package com.shoe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Map;

import com.shoe.converter.GiayConverter;
import com.shoe.dao.GiayDAO;
import com.shoe.dto.GiayDTO;
import com.shoe.entities.Giay;
import com.shoe.form.GiayForm;

@RestController
public class ShoeController {

	@Autowired
	GiayDAO giayDAO;

	@GetMapping("/giay")
	public ModelAndView gotoGiay(Map<String, Object> model) {
		return new ModelAndView("giay");
	}

	@PostMapping(value = "/giay", consumes = "application/json")
	public ResponseEntity<String> getDataGiay(@RequestBody GiayForm model) {
		ResponseEntity resp = null;
		GiayDTO dto = new GiayDTO();
		GiayConverter.convertFormToDTO(model, dto);
		Giay entity = new Giay();
		GiayConverter.convertDtoToEntity(dto, entity);
		giayDAO.addShoe(entity);
		resp = new ResponseEntity<>("1", HttpStatus.OK);
		return resp;
	}

	@GetMapping("/dsgiay")
	public ModelAndView gotoDsGiay(Map<String, Object> model) {
		return new ModelAndView("danhsachgiay");
	}

	@GetMapping("/searchgiay")
	public ModelAndView gotoTraCuuGiay(Map<String, Object> model) {
		return new ModelAndView("tracuugiay");
	}
}