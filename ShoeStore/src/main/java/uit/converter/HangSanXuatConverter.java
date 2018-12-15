package uit.converter;

import org.springframework.stereotype.Component;

import uit.dto.HangSanXuatDto;
import uit.entity.HangSanXuat;

@Component
public class HangSanXuatConverter extends BaseDtoConverter<HangSanXuat, HangSanXuatDto>{

	@Override
	public void convertEntityToDto(HangSanXuat entity, HangSanXuatDto dto) {
		if(entity == null || dto == null) {
			return;
		}
		
		dto.setId(entity.getIdHangSanXuat() + "");
		dto.setTenHangSanXuat(entity.getTenHangSanXuat());
	}

}
