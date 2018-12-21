package com.shoe.converter;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.shoe.dto.TinhTrangDonHangDTO;
import com.shoe.entities.TinhTrangDonHang;

@Component
public class TinhTrangDonHangConverter {
	
    public void convertEntityToDto(TinhTrangDonHang entity, TinhTrangDonHangDTO dto){
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.map(entity, dto);
    }
    
    public void convertDtoToEntity(TinhTrangDonHangDTO dto, TinhTrangDonHang entity){
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.map(dto, entity);
    }
}