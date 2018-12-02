package com.shoe.controller;

import com.shoe.ObjectToJson.ConvertToJson;
import com.shoe.dao.GioiTinhDAO;
import com.shoe.dao.HangSanXuatDAO;
import com.shoe.dto.GioiTinhDTO;
import com.shoe.dto.HangSanXuatSelectDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin/api/data")
public class DataGiayController {
    @Autowired
    GioiTinhDAO gioiTinhDAO;

    @PostMapping("/get-gender")
    public ResponseEntity<String> getGioiTinh(){
        List<GioiTinhDTO> list = gioiTinhDAO.getList();
        ResponseEntity res = new ResponseEntity<>(ConvertToJson.ToJson(list), HttpStatus.OK);
        return res;
    }

    @Autowired
    private HangSanXuatDAO hangSanXuatDAO;

    @PostMapping("/get-hang-san-xuat")
    public ResponseEntity<String> getHangSanXuat(){
        List<HangSanXuatSelectDTO> list = hangSanXuatDAO.getAllList();
        ResponseEntity res = new ResponseEntity<>(ConvertToJson.ToJson(list), HttpStatus.OK);
        return res;
    }
}
