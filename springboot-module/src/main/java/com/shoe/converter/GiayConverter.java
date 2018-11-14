package com.shoe.converter;

import org.modelmapper.ModelMapper;

import com.shoe.dto.GiayDTO;
import com.shoe.dto.GioiTinhDTO;
import com.shoe.dto.LoaiGiayDTO;
import com.shoe.entities.Giay;
import com.shoe.form.GiayForm;
import org.springframework.stereotype.Component;

@Component
public class GiayConverter {
    public void convertFormToDTO(GiayForm form, GiayDTO dto) {
        if (form == null || dto == null) {
            return;
        }
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

    public void convertDtoToEntity(GiayDTO dto, Giay entity) {
        if (dto == null || entity == null) {
            return;
        }
        ModelMapper map = new ModelMapper();
        map.map(dto, entity);
    }

    public void convertEntityToDto(Giay entity, GiayDTO dto) {
        if (dto == null || entity == null) {
            return;
        }
        ModelMapper map = new ModelMapper();
        map.map(entity, dto);
    }
}