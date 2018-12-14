package com.shoe.controller;

import com.shoe.ObjectToJson.ConvertToJson;
import com.shoe.converter.ChiTietGiayConverter;
import com.shoe.dao.ChiTietGiayDAO;
import com.shoe.dto.ChiTietGiayDTO;
import com.shoe.form.ChiTietGiayForm;
import org.apache.commons.validator.GenericValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/admin/api/detail-shoe")
public class ChiTietGiayController {
    @Autowired
    private ChiTietGiayDAO chiTietGiayDAO;

    @Autowired
    private ChiTietGiayConverter converter;

    @PostMapping("/get-chitietgiay-by-id")
    public ResponseEntity<String> getChiTietGiayById(@RequestBody String idChiTietGiay) {
        ResponseEntity<String> resp = null;
        if (GenericValidator.isInt(idChiTietGiay)) {
            List<ChiTietGiayDTO> list = chiTietGiayDAO.getAllListNoneDelByIdGiay(Integer.parseInt(idChiTietGiay));
            List<ChiTietGiayForm> listForm = new ArrayList<>();
            list.forEach(i->{
                ChiTietGiayForm form = new ChiTietGiayForm();
                form.setIdChiTietGiay(i.getIdChiTietGiay()+"");
                form.setIdGiay(i.getGiay().getIdGiay()+"");
                form.setSize(i.getSize()+"");
                form.setSoluong(i.getSoLuong()+"");
                listForm.add(form);
            });
            resp = new ResponseEntity<>(ConvertToJson.ToJson(listForm),HttpStatus.OK);
        } else {
            resp = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return resp;
    }

    @PostMapping(value = "/save-chitietgiay", consumes = "application/json")
    public ResponseEntity<String> saveChiTietGiay(@Valid @RequestBody ChiTietGiayForm form, Errors error) {
        ResponseEntity<String> resp = null;

        if (error.hasErrors()) {

            resp = new ResponseEntity<>("{\"status\":\"fail\"}",HttpStatus.BAD_REQUEST);
        } else {
            ChiTietGiayDTO dto = new ChiTietGiayDTO();
            converter.convertFormToDto(form, dto);
            System.out.println(dto);
            chiTietGiayDAO.saveDetailShoe(dto);
            resp = new ResponseEntity<>("{\"status\":\"success\"}",HttpStatus.OK);
        }

        return resp;
    }

    @PostMapping(value = "/delete-chitietgiay", consumes = "application/json")
    public ResponseEntity<String> deleteChiTietGiay(@RequestBody String idChiTietGiay) {
        ResponseEntity<String> resp = null;
        System.out.println(idChiTietGiay);
        if(GenericValidator.isInt(idChiTietGiay)){
            int id = Integer.parseInt(idChiTietGiay);
            ChiTietGiayDTO dto = new ChiTietGiayDTO();
            dto.setIdChiTietGiay(id);
            chiTietGiayDAO.deleteDetailShoe(dto);
            resp = new ResponseEntity<>("{\"status\":\"success\"}",HttpStatus.OK);
        } else {
            resp = new ResponseEntity<>("{\"status\":\"fail\"}",HttpStatus.BAD_REQUEST);
        }

        return resp;
    }
}
