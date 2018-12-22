package com.shoe.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/khach-hang")
public class KhachHangController {

    @PostMapping(value="/update-info")
    public ResponseEntity<String> saveThongTinKhachHang(){


    }
}
