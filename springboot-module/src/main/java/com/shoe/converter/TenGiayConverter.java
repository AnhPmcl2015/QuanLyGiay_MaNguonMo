package com.shoe.converter;

import com.shoe.dto.TenGiayDto;
import com.shoe.entities.Giay;
import org.springframework.stereotype.Component;

@Component
public class TenGiayConverter extends BaseDtoConverter<Giay, TenGiayDto> {

	@Override
	public void convertEntityToDto(Giay entity, TenGiayDto dto) {
		
		if (entity == null || dto == null) {
			
			return;
		}
		
		dto.setId(entity.getIdGiay()+"");
		dto.setTenGiay(entity.getTenGiay());
	}

}
