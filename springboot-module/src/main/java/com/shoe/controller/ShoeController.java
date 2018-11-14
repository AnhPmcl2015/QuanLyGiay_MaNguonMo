package com.shoe.controller;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.shoe.dao.ChiTietGiayDAO;
import com.shoe.dao.HangSanXuatDAO;
import com.shoe.dto.ChiTietGiayDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import com.shoe.converter.GiayConverter;
import com.shoe.dao.GiayDAO;
import com.shoe.dto.GiayDTO;
import com.shoe.entities.Giay;
import com.shoe.form.GiayForm;

@RestController
public class ShoeController {

    @Autowired
    GiayDAO giayDAO;

    @Autowired
    private GiayConverter converter;

    @Autowired
    private HangSanXuatDAO hangSanXuatDAO;

    @GetMapping("/giay")
    public ModelAndView gotoGiay(Map<String, Object> model) {
        return new ModelAndView("giay");
    }

    @PostMapping(value = "/giay", consumes = "application/json")
    public ResponseEntity<String> getDataGiay(@Valid @RequestBody GiayForm model, Errors error) {
        ResponseEntity resp = null;
        if (error.hasErrors()) {
            resp = new ResponseEntity<>("{\"status\":\"invalid\"}", HttpStatus.BAD_REQUEST);
        } else if (giayDAO.FindByAtribute("maGiay", model.getMaGiay())) {
            resp = new ResponseEntity<>("{\"status\":\"unique\"}", HttpStatus.BAD_REQUEST);
        } else {
            GiayDTO dto = new GiayDTO();
            converter.convertFormToDTO(model, dto);
            giayDAO.addShoe(dto);
            resp = new ResponseEntity<>("{\"status\":\"success\"}", HttpStatus.OK);
        }
        return resp;
    }

    @Autowired
    GiayDAO giayDao;

    @GetMapping("/dsgiay")
    public ModelAndView gotoDsGiay(Map<String, Object> model) {
        List<GiayDTO> list = giayDao.getAllListNoneDel();
        model.put("list_giay", list);
        model.put("list_hsx", hangSanXuatDAO.getHangSanXuat());

        return new ModelAndView("danhsachgiay");
    }

    @Autowired
    private ChiTietGiayDAO chiTietGiayDAO;

    @GetMapping("/searchgiay")
    public ModelAndView gotoTraCuuGiay(Map<String, Object> model) {

        List<ChiTietGiayDTO> chiTietGiayDTOS = chiTietGiayDAO.getAllListNoneDel();
        chiTietGiayDTOS.forEach(i->{
            System.out.println(i.getGiay().getIdGiay());
        });
        return new ModelAndView("tracuugiay");
    }
}