package com.shoe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.shoe.dao.GioiTinhDAO;
import com.shoe.dao.LoaiGiayDAO;
import com.shoe.dto.GioiTinhDTO;
import com.shoe.dto.LoaiGiayDTO;
import com.shoe.entities.GioiTinh;
import com.shoe.entities.LoaiGiay;
import java.util.stream.Collectors;
import java.util.List;

@RestController
public class ShoeControllerAPI {

    @Autowired
    LoaiGiayDAO loaigiayDAO;

    @GetMapping("/get-list-loaigiay")
    public List<LoaiGiayDTO> getListLoaiGiay() {
        List<LoaiGiay> listLoaiGiay = loaigiayDAO.getList();
        List<LoaiGiayDTO> listGiayDTO = listLoaiGiay.stream()
                .map(s -> new LoaiGiayDTO(s.getIdLoaiGiay(), s.getHangSanXuat(), s.getMaLoaiGiay(), s.getTenLoaiGiay()))
                .collect(Collectors.toList());
        return listGiayDTO;
    }

    @Autowired
    GioiTinhDAO gioitinhDAO;

    @GetMapping("/get-list-gioitinh")
    public List<GioiTinhDTO> getListGioiTinh() {
        List<GioiTinh> listGioiTinh = gioitinhDAO.getList();
        List<GioiTinhDTO> listGioiTinhDTO = listGioiTinh.stream()
                .map(s -> new GioiTinhDTO(s.getIdGioiTinh(), s.getTenGioiTinh())).collect(Collectors.toList());
        return listGioiTinhDTO;
    }
}