package com.shoe.controller;

import com.shoe.dao.GiayDAO;
import com.shoe.dto.GiayDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParser;
import org.springframework.boot.json.JsonParserFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.shoe.dao.GioiTinhDAO;
import com.shoe.dao.LoaiGiayDAO;
import com.shoe.dto.GioiTinhDTO;
import com.shoe.dto.LoaiGiayDTO;
import com.shoe.entities.GioiTinh;
import com.shoe.entities.LoaiGiay;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.List;

@RestController
public class ShoeControllerAPI {

    @Autowired
    LoaiGiayDAO loaigiayDAO;

    @Autowired
    GioiTinhDAO gioiTinhDAO;

    @GetMapping("/get-list-loaigiay")
    public List<LoaiGiayDTO> getListLoaiGiay() {

        return loaigiayDAO.getList();
    }

    @Autowired
    GioiTinhDAO gioitinhDAO;

    @GetMapping("/get-list-gioitinh")
    public List<GioiTinhDTO> getListGioiTinh() {

        return gioiTinhDAO.getList();
    }

    @Autowired
    GiayDAO giayDao;

    @PostMapping("/delete-giay")
    public ResponseEntity<String> deleteGiay(@RequestBody Map<String, Object> giay) {
        ResponseEntity<String> response = null;
        GiayDTO dto = new GiayDTO();
        try {
            dto.setIdGiay(Integer.parseInt(giay.get("id") + ""));
            if (giayDao.deleteShoe(dto)) {
                response = new ResponseEntity<>("{\"status\":\"success\"}", HttpStatus.OK);
            } else {
                response = new ResponseEntity<>("{\"status\":\"faild\"}", HttpStatus.BAD_REQUEST);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            response = new ResponseEntity<>("{\"status\":\"error format\"}", HttpStatus.BAD_REQUEST);
        }
        return response;
    }


}