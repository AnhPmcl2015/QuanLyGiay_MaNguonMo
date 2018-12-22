package com.shoe.converter;

import com.shoe.dto.TenLoaiGiayDto;
import com.shoe.entities.LoaiGiay;
import org.springframework.stereotype.Component;

@Component
public class TenLoaiGiayConverter extends BaseDtoConverter<LoaiGiay, TenLoaiGiayDto>{

	@Override
	public void convertEntityToDto(LoaiGiay entity, TenLoaiGiayDto dto) {
		if(entity == null || dto == null) {
			return;
		}
		
		dto.setId(entity.getIdLoaiGiay()+"");
		dto.setTenLoaiGiay(entity.getTenLoaiGiay()+"");
	}
	
}
