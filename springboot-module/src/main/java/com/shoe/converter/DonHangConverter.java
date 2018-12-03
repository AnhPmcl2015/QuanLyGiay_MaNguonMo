package com.shoe.converter;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.shoe.dto.DonHangDTO;
import com.shoe.dto.GiayDTO;
import com.shoe.entities.DonHang;
import com.shoe.form.GiayForm;

@Component
public class DonHangConverter {
	
    public void convertFormToDTO(GiayForm form, GiayDTO dto){
        
    }
    
    public void convertEntityToDto(DonHang entity, DonHangDTO dto){
    	ModelMapper modelMapper = new ModelMapper();
        modelMapper.map(entity, dto);
    }
    
    public void convertDtoToEntiy(DonHangDTO dto, DonHang entity){
    	ModelMapper modelMapper = new ModelMapper();
        modelMapper.map(dto, entity);
    }
}