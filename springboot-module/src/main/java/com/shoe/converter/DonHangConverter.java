package com.shoe.converter;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.shoe.dto.DonHangDTO;
import com.shoe.dto.ShoeDTO;
import com.shoe.dto.KhachHangDTO;
import com.shoe.dto.TinhTrangDonHangDTO;
import com.shoe.entities.DonHang;
import com.shoe.form.GiayForm;

@Component
public class DonHangConverter {
	@Autowired
	KhachHangConverter khachHangEco;
	
	@Autowired
	TinhTrangDonHangConverter tinhTrangDonHangConverter;
	
    public void convertFormToDTO(GiayForm form, ShoeDTO dto){
        
    }
    
    public void convertEntityToDto(DonHang entity, DonHangDTO dto){
    	KhachHangDTO khachHangDTO = new KhachHangDTO();
    	khachHangEco.convertEntityToDto(entity.getKhachHang(), khachHangDTO);
    	TinhTrangDonHangDTO tinhTrangDonHangDTO = new TinhTrangDonHangDTO();
    	tinhTrangDonHangConverter.convertEntityToDto(entity.getTinhTrangDonHang(), tinhTrangDonHangDTO);
    	
    	dto.setIdDonHang(entity.getIdDonHang());
    	dto.setKhachHang(khachHangDTO);
    	dto.setNgayDat(entity.getNgayDat());
    	dto.setNgayGiao(entity.getNgayGiao());
    	dto.setTinhTrangDonHang(tinhTrangDonHangDTO);
    	dto.setTongTien(entity.getTongTien());
    }
    
    public void convertDtoToEntiy(DonHangDTO dto, DonHang entity){
    	ModelMapper modelMapper = new ModelMapper();
        modelMapper.map(dto, entity);
    }
}