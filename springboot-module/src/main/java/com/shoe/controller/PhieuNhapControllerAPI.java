package com.shoe.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.shoe.dao.PhieuNhapDAO;
import com.shoe.entities.PhieuNhap;
import com.shoe.form.PhieuNhapForm;

import javax.validation.Valid;

import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class PhieuNhapControllerAPI {

    @Autowired
    PhieuNhapDAO phieuNhapDao;
    
	@GetMapping("/phieu-nhap")
	public ModelAndView gotoNhapKho(Map<String, Object> model) {
		return new ModelAndView("phieunhap");
	}
	
	@PostMapping("/them-phieu-nhap")
	public ResponseEntity<?> getSearchResultViaAjax(@Valid @RequestBody PhieuNhapForm phieuNhapform, Errors errors) {

        //If error, just return a 400 bad request, along with the error message
        if (errors.hasErrors()) {
            String error = (errors.getAllErrors().stream().map(x -> x.getDefaultMessage()).collect(Collectors.joining(",")));
            return ResponseEntity.badRequest().body(error);
        }
        
        String result;
        
        PhieuNhap phieuNhap = new PhieuNhap();
        BeanUtils.copyProperties(phieuNhapform, phieuNhap);
        
        // phieuNhapDao.add(phieuNhap);
        
        result = "success";        

        return ResponseEntity.ok(result);

    }
}