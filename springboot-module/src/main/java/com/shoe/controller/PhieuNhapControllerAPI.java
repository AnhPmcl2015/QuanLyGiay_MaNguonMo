package com.shoe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shoe.ObjectToJson.ConvertToJson;
import com.shoe.converter.ChiTietPhieuNhapConverter;
import com.shoe.converter.PhieuNhapConverter;
import com.shoe.dao.ChiTietGiayDAO;
import com.shoe.dao.HangSanXuatDAO;
import com.shoe.dao.PhieuNhapDAO;
import com.shoe.dto.ChiTietPhieuNhapDTO;
import com.shoe.dto.HangSanXuatDTO;
import com.shoe.dto.PhieuNhapDTO;
import com.shoe.form.PhieuNhapForm;

import javax.validation.Valid;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/phieu-nhap")
public class PhieuNhapControllerAPI {

	@Autowired
	PhieuNhapConverter converter;
	
	@Autowired
	ChiTietPhieuNhapConverter chiTietPhieuNhapEco;
	
    @Autowired
    PhieuNhapDAO phieuNhapDao;
    
    @Autowired
    private HangSanXuatDAO hangSanXuatDAO;
    
    @Autowired
    ChiTietGiayDAO chiTietGiayDAO;
    
	@PostMapping("/luu")
	public ResponseEntity<?> save(@Valid @RequestBody PhieuNhapForm phieuNhapform, Errors errors) {
       if (errors.hasErrors()) {
            String error = (errors.getAllErrors().stream().map(x -> x.getDefaultMessage()).collect(Collectors.joining(",")));
            return ResponseEntity.badRequest().body(error);
        }
        PhieuNhapDTO phieuNhapDto = new PhieuNhapDTO();
        converter.convertFormToDTO(phieuNhapform, phieuNhapDto);
        
        List<ChiTietPhieuNhapDTO> listCTPN = new ArrayList<ChiTietPhieuNhapDTO>();
        phieuNhapform.getRecieptDetails().forEach((form) -> {
        	ChiTietPhieuNhapDTO ctpn = new ChiTietPhieuNhapDTO();
        	chiTietPhieuNhapEco.convertFormToDTO(form, ctpn);
        	listCTPN.add(ctpn);
        });
        
        phieuNhapDao.add(phieuNhapDto, listCTPN);
        return ResponseEntity.ok(phieuNhapform);
    }

    @PostMapping("/get-hang-san-xuat")
    public ResponseEntity<String> getHangSanXuat(){
        List<HangSanXuatDTO> list = hangSanXuatDAO.getHangSanXuat();
        ResponseEntity<String> res = new ResponseEntity<>(ConvertToJson.ToJson(list), HttpStatus.OK);
        return res;
    }
    
//	@GetMapping(value = "/get-list-shoe-detail", produces = "application/json")
//	public ResponseEntity<?> getChiTietDonHang(@RequestParam("brandId") String id) {
//		List<ChiTietGiayDTO> chiTietGiay = new ArrayList<ChiTietGiayDTO>();
//		chiTietGiay = chiTietGiayDAO.getAllListNoneDel();
//
//		ResponseEntity<?> responseEntity = new ResponseEntity<Object>(chiTietGiay, HttpStatus.OK);
//		return responseEntity;
//	}
}