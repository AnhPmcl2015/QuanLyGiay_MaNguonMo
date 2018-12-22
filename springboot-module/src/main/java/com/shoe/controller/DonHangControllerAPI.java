package com.shoe.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.shoe.converter.ChiTietDonHangConverter;
import com.shoe.converter.DonHangConverter;
import com.shoe.converter.TinhTrangDonHangConverter;
import com.shoe.dao.ChiTietDonHangDAO;
import com.shoe.dao.DonHangDAO;
import com.shoe.dao.TinhTrangDonHangDAO;
import com.shoe.dto.ChiTietDonHangDTO;
import com.shoe.dto.DonHangDTO;
import com.shoe.dto.TinhTrangDonHangDTO;
import com.shoe.entities.TinhTrangDonHang;
import com.shoe.payload.SeverResponse;

@RestController
@RequestMapping("/api/invoice")
public class DonHangControllerAPI {

	@Autowired
	DonHangDAO donhangDao;

	@Autowired
	ChiTietDonHangDAO chiTietDonHangDao;

	@Autowired
	TinhTrangDonHangDAO tinhTrangDonHangDao;
	
	@Autowired
	ChiTietDonHangConverter chiTietDonHangEco;

	@Autowired
	TinhTrangDonHangConverter tinhTrangDonHangEco;
	
	@Autowired
	DonHangConverter donHangConverter;


	@GetMapping(value = "/get-order", produces = "application/json")
	public ResponseEntity<?> getChiTietDonHang(@RequestParam("id") int id) {
		ResponseEntity<?> responseEntity;
		DonHangDTO donHang = new DonHangDTO();
		donHang = donhangDao.getDonHangById(id);
		if (donHang == null) {
			responseEntity = new ResponseEntity<Object>(donHang, HttpStatus.BAD_REQUEST);
		}
		responseEntity = new ResponseEntity<Object>(donHang, HttpStatus.OK);
		return responseEntity;
	}

	@PostMapping(value = "/get-order-detail", produces = "application/json")
	// @PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> getDonHang(@RequestParam("id") int idDonHang) {
		List<ChiTietDonHangDTO> listChiTietDoHang = new ArrayList<>();
		listChiTietDoHang = chiTietDonHangDao.getChiTietDonHangsByIdDonHang(idDonHang);
		ResponseEntity<?> responseEntity = new ResponseEntity<Object>(listChiTietDoHang, HttpStatus.OK);
		return responseEntity;
	}
	
    @PostMapping("/get-status")
    public ResponseEntity<?> getStatus(){
        List<TinhTrangDonHang> tinhTrangDonHangs = tinhTrangDonHangDao.getListStatus();
        
        List<TinhTrangDonHangDTO> list = new ArrayList<TinhTrangDonHangDTO>();
        tinhTrangDonHangs.forEach(entity ->{
        	TinhTrangDonHangDTO dto = new TinhTrangDonHangDTO();
        	tinhTrangDonHangEco.convertEntityToDto(entity, dto);
        	list.add(dto);
        });
        
        ResponseEntity<?> res = new ResponseEntity<>(list, HttpStatus.OK);
        return res;
    }
    
	@PostMapping("/update-status")
	public ResponseEntity<?> save(@RequestParam("id") int id, @RequestParam("stt") int stt) {
		donhangDao.updateStatus(id, stt);
		
        return ResponseEntity.ok(new SeverResponse(true, "update success !"));
    }
}