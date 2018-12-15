package com.shoe.converter;

import com.shoe.dto.ChiTietGiayDTO;
import com.shoe.dto.ShoeDTO;
import com.shoe.entities.ChiTietGiay;
import com.shoe.form.ChiTietGiayForm;
import org.apache.commons.validator.GenericValidator;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ChiTietGiayConverter {
    public void convertDtoToEntity(ChiTietGiayDTO dto, ChiTietGiay entity) {
        if (dto == null || entity == null) {
            return;
        }
        ModelMapper map = new ModelMapper();
        map.map(dto, entity);
    }

    public void convertEntityToDto(ChiTietGiay entity, ChiTietGiayDTO dto) {
        if (dto == null || entity == null) {
            return;
        }
        ModelMapper map = new ModelMapper();
        map.map(entity, dto);
    }

    public void convertDtoToForm(ChiTietGiayDTO dto, ChiTietGiayForm form) {
        if (dto == null || form == null) {
            return;
        }

    }

    public void convertFormToDto(ChiTietGiayForm form, ChiTietGiayDTO dto) {
        if (dto == null || form == null) {
            return;
        }
        dto.setSize(Integer.parseInt(form.getSize()));
        if(GenericValidator.isInt(form.getIdChiTietGiay())) {
            dto.setIdChiTietGiay(Integer.parseInt(form.getIdChiTietGiay()));
        }
        dto.setSoLuong(Integer.parseInt(form.getSoluong()));
        ShoeDTO giay = new ShoeDTO();
        giay.setIdGiay(Integer.parseInt(form.getIdGiay()));
        dto.setGiay(giay);
    }
}
