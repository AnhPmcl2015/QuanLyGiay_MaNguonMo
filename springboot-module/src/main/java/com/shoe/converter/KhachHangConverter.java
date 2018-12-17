package com.shoe.converter;

import org.springframework.stereotype.Component;

import com.shoe.dto.KhachHangDTO;
import com.shoe.entities.KhachHang;

@Component
public class KhachHangConverter {
	
    public void convertEntityToDto(KhachHang entity, KhachHangDTO dto){
    	dto.setIdKhachHang(entity.getIdKhachHang());
    	dto.setTenKhachHang(entity.getTenKhachHang());
    	dto.setDiaChi(entity.getDiaChi());
    	dto.setSoDienThoai(entity.getSoDienThoai());
    }
    
    public void convertDtoToEntity(KhachHangDTO dto, KhachHang entity){
    	entity.setIdKhachHang(dto.getIdKhachHang());
    	entity.setTenKhachHang(dto.getTenKhachHang());
    	entity.setDiaChi(dto.getDiaChi());
    	entity.setSoDienThoai(dto.getSoDienThoai());
    }
}