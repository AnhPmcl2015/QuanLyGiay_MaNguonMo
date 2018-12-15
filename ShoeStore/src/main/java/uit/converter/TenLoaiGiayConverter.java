package uit.converter;

import org.springframework.stereotype.Component;

import uit.dto.TenLoaiGiayDto;
import uit.entity.LoaiGiay;

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
