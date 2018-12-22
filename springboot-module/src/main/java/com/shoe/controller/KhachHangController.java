package com.shoe.controller;

import com.shoe.ObjectToJson.ConvertToJson;
import com.shoe.dao.KhachHangDAO;
import com.shoe.dto.KhachHangDTO;
import com.shoe.form.KhachHangInfoForm;
import com.shoe.form.KhachHangPwdForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/khach-hang")
public class KhachHangController {

    @Autowired
    private KhachHangDAO dao;

    @PostMapping(value="/update-info")
    public ResponseEntity<String> saveThongTinKhachHang(@Valid @RequestBody KhachHangInfoForm form, Errors error){

        ResponseEntity<String> resp = null;
        if(error.hasErrors()){
            resp = new  ResponseEntity<String>("{\"status\":\"invalid\"}",HttpStatus.BAD_REQUEST);
        } else {

            KhachHangDTO dto = new KhachHangDTO();
            dto.setDiaChi(form.getDiaChi());
            dto.setSoDienThoai(Integer.parseInt(form.getSoDienThoai()));
            dto.setIdKhachHang(Integer.parseInt(form.getId()));
            dto.setTenKhachHang(form.getTenKhachHang());
            dao.saveKhachHang(dto);
            resp = new  ResponseEntity<String>("{\"status\":\"success\"}", HttpStatus.OK);
        }
        return resp;
    }

    @PostMapping(value="/update-password")
    public ResponseEntity<String> savePassword(@Valid @RequestBody KhachHangPwdForm form, Errors error){

        ResponseEntity<String> resp = null;
        if(error.hasErrors()){
            resp = new  ResponseEntity<String>("{\"status\":\"invalid\"}",HttpStatus.BAD_REQUEST);
        } else {
            if (dao.updatePassword(form)) {
                resp = new ResponseEntity<String>("{\"status\":\"success\"}", HttpStatus.OK);
            } else {
                resp = new ResponseEntity<String>("{\"status\":\"wrong\"}", HttpStatus.BAD_REQUEST);
            }
        }
        return resp;
    }

    @PostMapping(value="/get-user-by-id")
    public KhachHangInfoForm getKhachHangById(@RequestBody Long idUser){

        KhachHangInfoForm kh = new KhachHangInfoForm();
        KhachHangDTO dto = dao.getKhachHangByUser(idUser);
        kh.setDiaChi(dto.getDiaChi());
        kh.setSoDienThoai(dto.getSoDienThoai()+"");
        kh.setTenKhachHang(dto.getTenKhachHang());
        return kh;
    }
}
