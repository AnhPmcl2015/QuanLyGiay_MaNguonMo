package com.shoe.controller;

import com.shoe.converter.GiayConverter;
import com.shoe.dao.ChiTietGiayDAO;
import com.shoe.dto.ChiTietGiayDTO;
import com.shoe.payload.SeverResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/client/public/payment")
public class PaymentController {

	@Autowired
	private ChiTietGiayDAO chiTietGiayDAO;

	@Autowired
	private GiayConverter giayConverter;

	@GetMapping(value = "/get-shoe", produces = "application/json")
	public ResponseEntity<?> getChiTietDonHang(@RequestParam("id") int id) {
		ResponseEntity<?> responseEntity;
		
		List<ChiTietGiayDTO> ctgDTO = new ArrayList<ChiTietGiayDTO>();
		ctgDTO = chiTietGiayDAO.getAllListNoneDelByIdGiay(id);
		if (ctgDTO == null) {
			responseEntity = new ResponseEntity<Object>(new SeverResponse(false, "load shoe detail failed"), HttpStatus.BAD_REQUEST);
		}
		responseEntity = new ResponseEntity<Object>(ctgDTO.get(0), HttpStatus.OK);
		return responseEntity;
	}
	
}
