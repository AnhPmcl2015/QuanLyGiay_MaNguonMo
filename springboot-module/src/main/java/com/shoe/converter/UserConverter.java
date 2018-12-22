package com.shoe.converter;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.shoe.dto.UserDTO;
import com.shoe.entities.User;

@Component
public class UserConverter {

	public void convertEntityToDto(User entity, UserDTO dto) {
		if (dto == null || entity == null) {
			return;
		}
		ModelMapper map = new ModelMapper();
		map.map(entity, dto);
	}

	public void convertDtoToEntity(UserDTO dto, User entity) {
		if (dto == null || entity == null) {
			return;
		}
		ModelMapper map = new ModelMapper();
		map.map(dto, entity);
	}
}