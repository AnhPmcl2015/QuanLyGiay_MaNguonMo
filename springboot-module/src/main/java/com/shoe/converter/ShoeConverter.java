package com.shoe.converter;

import org.apache.commons.validator.GenericValidator;
import org.modelmapper.ModelMapper;

import com.shoe.dto.ShoeDTO;
import com.shoe.dto.GioiTinhDTO;
import com.shoe.dto.LoaiGiayDTO;
import com.shoe.entities.Giay;
import com.shoe.form.GiayForm;
import org.springframework.stereotype.Component;

@Component
public class ShoeConverter {
    public void convertFormToDTO(GiayForm form, ShoeDTO dto) {
        if (form == null || dto == null) {
            return;
        }
        if(GenericValidator.isInt(form.getId())){
            dto.setIdGiay(Integer.parseInt(form.getId()));
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
        dto.setGiaBan(Integer.parseInt(form.getGiaBan()));
    }

    public void convertDTOtoForm(ShoeDTO dto, GiayForm form){
        form.setGhiChu(dto.getGhiChu());
        form.setId(dto.getIdGiay()+"");
        form.setMaGiay(dto.getMaGiay());
        form.setTenGiay(dto.getTenGiay());
        form.setId_gioi_tinh(dto.getGioiTinh().getIdGioiTinh()+"");
        form.setId_loai_giay(dto.getLoaiGiay().getIdLoaiGiay()+"");
        form.setGiaBan(dto.getGiaBan()+"");
    }
    public void convertDtoToEntity(ShoeDTO dto, Giay entity) {
        if (dto == null || entity == null) {
            return;
        }
        ModelMapper map = new ModelMapper();
        map.map(dto, entity);
    }

    public void convertEntityToDto(Giay entity, ShoeDTO dto) {
        if (dto == null || entity == null) {
            return;
        }
        ModelMapper map = new ModelMapper();
        map.map(entity, dto);
    }
}