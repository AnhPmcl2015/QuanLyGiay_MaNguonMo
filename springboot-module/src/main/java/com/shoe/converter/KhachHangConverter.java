package com.shoe.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.shoe.dto.KhachHangDTO;
import com.shoe.dto.UserDTO;
import com.shoe.entities.KhachHang;
import com.shoe.entities.User;

@Component
public class KhachHangConverter {

	@Autowired
	UserConverter userEco;

	public void convertEntityToDto(KhachHang entity, KhachHangDTO dto) {
		UserDTO userDTO = new UserDTO();
		userEco.convertEntityToDto(entity.getUser(), userDTO);

		dto.setIdKhachHang(entity.getIdKhachHang());
		dto.setTenKhachHang(entity.getTenKhachHang());
		dto.setDiaChi(entity.getDiaChi());
		dto.setSoDienThoai(entity.getSoDienThoai());
		dto.setUser(userDTO);
	}

	public void convertDtoToEntity(KhachHangDTO dto, KhachHang entity) {
		User user = new User();
		userEco.convertDtoToEntity(dto.getUser(), user);
		
		entity.setIdKhachHang(dto.getIdKhachHang());
		entity.setTenKhachHang(dto.getTenKhachHang());
		entity.setDiaChi(dto.getDiaChi());
		entity.setSoDienThoai(dto.getSoDienThoai());
		entity.setUser(user);
	}
}