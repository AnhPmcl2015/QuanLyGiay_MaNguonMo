package com.shoe.controller;

import com.shoe.converter.DonHangConverter;
import com.shoe.dao.ChiTietGiayDAO;
import com.shoe.dao.DonHangDAO;
import com.shoe.dto.ChiTietGiayDTO;
import com.shoe.dto.DonHangDTO;
import com.shoe.form.PaymentForm;
import com.shoe.payload.SeverResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

import javax.validation.Valid;

@RestController
@RequestMapping("api/client/public/payment")
public class PaymentController {

	@Autowired
	private ChiTietGiayDAO chiTietGiayDAO;

	@Autowired
	private DonHangDAO donHangDAO;
	
	@Autowired
	private DonHangConverter donHangConverter;

	@GetMapping(value = "/get-shoe", produces = "application/json")
	public ResponseEntity<?> getChiTietGiay(@RequestParam("id") int id) {
		ResponseEntity<?> responseEntity;
		
		ChiTietGiayDTO ctgDTO = chiTietGiayDAO.getGiayByIdChiTietGiay(id);
		if (ctgDTO == null) {
			responseEntity = new ResponseEntity<Object>(new SeverResponse(false, "load shoe detail failed"), HttpStatus.BAD_REQUEST);
		}
		responseEntity = new ResponseEntity<Object>(ctgDTO, HttpStatus.OK);
		return responseEntity;
	}
	
	@PostMapping("/pay")
	public ResponseEntity<?> pay(@Valid @RequestBody PaymentForm paymentForm, Errors errors) {
       if (errors.hasErrors()) {
            String error = (errors.getAllErrors().stream().map(x -> x.getDefaultMessage()).collect(Collectors.joining(",")));
            return ResponseEntity.badRequest().body(error);
        }
        DonHangDTO donHangDTO = new DonHangDTO();
        donHangConverter.convertFormToDTO(paymentForm, donHangDTO);
        int idDonHang = donHangDAO.save(donHangDTO);
        return ResponseEntity.ok(idDonHang);
    }
}
