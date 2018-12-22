package com.shoe.converter;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.shoe.dto.ChiTietDonHangDTO;
import com.shoe.dto.ChiTietGiayDTO;
import com.shoe.entities.ChiTietDonHang;
import com.shoe.form.PaymentDetailForm;

@Component
public class ChiTietDonHangConverter {
	
	@Autowired
	ChiTietGiayConverter chiTietGiayEco;
	
	
    public void convertFormToDTO(PaymentDetailForm form, ChiTietDonHangDTO dto){
    	ChiTietGiayDTO chiTietGiayDTO = new ChiTietGiayDTO();
    	chiTietGiayDTO.setIdChiTietGiay(form.getIdChiTietGiay());
    	
    	dto.setChiTietGiay(chiTietGiayDTO);
    	dto.setSoLuong(form.getSoLuong());
    	dto.setThanhTien(form.getThanhTien());
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