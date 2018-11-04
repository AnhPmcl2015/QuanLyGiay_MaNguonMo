package com.shoe.converter;

import com.shoe.dto.GiayDTO;
import com.shoe.dto.GioiTinhDTO;
import com.shoe.dto.LoaiGiayDTO;
import com.shoe.entities.Giay;
import com.shoe.form.GiayForm;

import org.modelmapper.ModelMapper;

public class GiayConverter {
    public static void convertFormToDTO(GiayForm form, GiayDTO dto){
        dto.setMaGiay(form.getMaGiay());
        dto.setTenGiay(form.getTenGiay());
        dto.setGhiChu(form.getGhiChu());
        LoaiGiayDTO loaigiay = new LoaiGiayDTO();
        loaigiay.setIdLoaiGiay(Integer.parseInt(form.getId_loai_giay()));
        dto.setLoaiGiay(loaigiay);
        GioiTinhDTO gioitinh = new GioiTinhDTO();
        gioitinh.setIdGioiTinh(Integer.parseInt(form.getId_gioi_tinh()));
        dto.setGioiTinh(gioitinh);
        dto.setGiaBan(Long.parseLong(form.getGiaBan()));
        dto.setImg1(form.getImg1());
        dto.setImg2(form.getImg2());
        dto.setImg3(form.getImg3());
        dto.setImg4(form.getImg4());
    }
    public static void convertDtoToEntity(GiayDTO dto, Giay entity){
        ModelMapper map = new ModelMapper();
        map.map(dto, entity);
    }
}