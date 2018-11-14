package com.shoe.converter;

import com.shoe.dto.GiayDTO;
import com.shoe.dto.HangSanXuatDTO;
import com.shoe.entities.Giay;
import com.shoe.entities.HangSanXuat;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class HangSanXuatConverter {

    public void convertDtoToEntity(HangSanXuatDTO dto, HangSanXuat entity) {
        if (dto == null || entity == null) {
            return;
        }
        ModelMapper map = new ModelMapper();
        map.map(dto, entity);
    }

    public void convertEntityToDto(HangSanXuat entity, HangSanXuatDTO dto) {
        if (dto == null || entity == null) {
            return;
        }
        ModelMapper map = new ModelMapper();
        map.map(entity, dto);
    }
}
