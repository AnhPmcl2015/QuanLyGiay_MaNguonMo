package com.shoe.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.shoe.dto.HangSanXuatDTO;
import com.shoe.dto.PhieuNhapDTO;
import com.shoe.entities.HangSanXuat;
import com.shoe.entities.PhieuNhap;
import com.shoe.form.PhieuNhapForm;

@Component
public class PhieuNhapConverter {
	@Autowired
	HangSanXuatConverter hsxEco;
	
	public void convertFormToDTO(PhieuNhapForm form, PhieuNhapDTO dto){
    	Date date = null;
		try {
			date = new SimpleDateFormat("dd-MM-yyyy").parse(form.getDateOfReciept());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		
		HangSanXuatDTO hsxDTO = new HangSanXuatDTO();
		hsxDTO.setIdHangSanXuat(form.getBrandId());

    	dto.setNgayNhap(date);
    	dto.setTongSoLuong(form.getAmount());
    	dto.setHangSanXuat(hsxDTO);
    }
    
    public void convertEntityToDto(PhieuNhap entity, PhieuNhapDTO dto){
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.map(entity, dto);

    }
    
    public void convertDtoToEntity(PhieuNhapDTO dto, PhieuNhap entity){
//        ModelMapper modelMapper = new ModelMapper();
//        modelMapper.map(dto, entity);
    	HangSanXuat hangSanXuat = new HangSanXuat();
    	hsxEco.convertDtoToEntity(dto.getHangSanXuat(), hangSanXuat);
    	
    	// entity.setIdPhieuNhap(dto.getIdPhieuNhap());
    	entity.setHangSanXuat(hangSanXuat);
    	entity.setNgayNhap(dto.getNgayNhap());
    	entity.setTongSoLuong(dto.getTongSoLuong());
    }
}