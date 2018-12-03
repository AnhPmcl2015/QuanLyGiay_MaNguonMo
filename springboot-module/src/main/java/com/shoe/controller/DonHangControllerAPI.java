package com.shoe.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.shoe.converter.ChiTietDonHangConverter;
import com.shoe.converter.DonHangConverter;
import com.shoe.dao.ChiTietDonHangDAO;
import com.shoe.dao.DonHangDAO;
import com.shoe.dto.ChiTietDonHangDTO;
import com.shoe.dto.DonHangDTO;

@RestController
@RequestMapping("/api/invoice")
public class DonHangControllerAPI {

	@Autowired
	DonHangDAO donhangDao;

	@Autowired
	ChiTietDonHangDAO chiTietDonHangDao;

	@Autowired
	ChiTietDonHangConverter chiTietDonHangEco;

	@Autowired
	DonHangConverter donHangConverter;

	@GetMapping("/don-hang")
	public ModelAndView gotoHoaDon(Map<String, Object> model) {
		return new ModelAndView("donhang");
	}

	@CrossOrigin
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

	@CrossOrigin
	@PreAuthorize("hasRole('PM')")
	@GetMapping(value = "/get-order-detail", produces = "application/json")
	public ResponseEntity<?> getDonHang(@RequestParam("id") int idDonHang) {
		List<ChiTietDonHangDTO> listChiTietDoHang = new ArrayList<>();
		listChiTietDoHang = chiTietDonHangDao.getChiTietDonHangsByIdDonHang(idDonHang);
		ResponseEntity<?> responseEntity = new ResponseEntity<Object>(listChiTietDoHang, HttpStatus.OK);
		return responseEntity;
	}

}