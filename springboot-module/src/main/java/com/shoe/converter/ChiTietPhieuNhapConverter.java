package com.shoe.converter;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.shoe.dto.ChiTietGiayDTO;
import com.shoe.dto.ChiTietPhieuNhapDTO;
import com.shoe.entities.ChiTietPhieuNhap;
import com.shoe.form.ChiTietPhieuNhapForm;

@Component
public class ChiTietPhieuNhapConverter {
	
	public void convertFormToDTO(ChiTietPhieuNhapForm form, ChiTietPhieuNhapDTO dto){
    	ChiTietGiayDTO ctg= new ChiTietGiayDTO();
    	ctg.setIdChiTietGiay(form.getKey());
    	
    	dto.setChiTietGiay(ctg);
    	dto.setSoLuong(form.getAmount());
    	dto.setGiaVon(form.getPrice());
    	dto.setThanhTien(form.getTotal());
    }
    
    public void convertEntityToDto(ChiTietPhieuNhap entity, ChiTietPhieuNhapDTO dto){
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.map(entity, dto);
    }
    
    public void convertDtoToEntity(ChiTietPhieuNhapDTO dto, ChiTietPhieuNhap entity){
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.map(dto, entity);
    }
}