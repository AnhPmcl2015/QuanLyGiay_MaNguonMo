package uit.converter;

import org.springframework.stereotype.Component;

import uit.dto.TenGiayDto;
import uit.entity.Giay;

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
