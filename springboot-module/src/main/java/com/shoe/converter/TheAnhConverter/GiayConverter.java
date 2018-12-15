package com.shoe.converter.TheAnhConverter;

import com.shoe.converter.BaseDtoConverter;
import com.shoe.dto.TheAnhDto.GiayDto;
import com.shoe.entities.Giay;
import org.springframework.stereotype.Component;

@Component
public class GiayConverter extends BaseDtoConverter<Giay, GiayDto> {

	@Override
	public void convertEntityToDto(Giay entity, GiayDto dto) {

		if(entity == null || dto == null)
			return;
		
		dto.setIdGiay(entity.getIdGiay()+"");
		dto.setTenGiay(entity.getTenGiay());
		dto.setGiaBan(entity.getGiaBan()+"");
		dto.setImg(entity.getImg1());
		dto.setLoaiGiay(entity.getLoaiGiay().getTenLoaiGiay());
	}

}
