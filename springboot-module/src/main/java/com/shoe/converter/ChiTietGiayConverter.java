package com.shoe.converter;

import com.shoe.dto.ChiTietGiayDTO;
import com.shoe.entities.ChiTietGiay;
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
}
