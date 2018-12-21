package com.shoe.converter;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.shoe.dto.ChiTietDonHangDTO;
import com.shoe.dto.ShoeDTO;
import com.shoe.entities.ChiTietDonHang;
import com.shoe.form.GiayForm;

@Component
public class ChiTietDonHangConverter {
	
	@Autowired
	ChiTietGiayConverter chiTietGiayEco;
	
	
    public void convertFormToDTO(GiayForm form, ShoeDTO dto){
        
    }
    
    public void convertEntityToDto(ChiTietDonHang entity, ChiTietDonHangDTO dto){
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.map(entity, dto);
    }
    
    public void convertDtoToEntity(ChiTietDonHangDTO dto, ChiTietDonHang entity){
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.map(dto, entity);
    }
}