package uit.converter;

import org.springframework.stereotype.Component;

import uit.dto.GiayDto;
import uit.entity.Giay;

@Component
public class GiayConverter extends BaseDtoConverter<Giay, GiayDto>{

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
