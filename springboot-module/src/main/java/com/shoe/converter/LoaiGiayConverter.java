package com.shoe.converter;

import com.shoe.dto.LoaiGiayDTO;
import com.shoe.entities.LoaiGiay;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class LoaiGiayConverter {
    public void convertDtoToEntity(LoaiGiayDTO dto, LoaiGiay entity) {
        if (dto == null || entity == null) {
            return;
        }
        ModelMapper map = new ModelMapper();
        map.map(dto, entity);
    }

    public void convertEntityToDto(LoaiGiay entity, LoaiGiayDTO dto) {
        if (dto == null || entity == null) {
            return;
        }
        ModelMapper map = new ModelMapper();
        map.map(entity, dto);
    }
}
