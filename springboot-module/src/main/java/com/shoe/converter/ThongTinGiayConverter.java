package com.shoe.converter;

import com.shoe.dto.ThongTinGiayDto;
import com.shoe.entities.ChiTietGiay;
import com.shoe.entities.Giay;
import com.shoe.entities.LoaiGiay;
import org.springframework.stereotype.Component;

@Component
public class ThongTinGiayConverter extends BaseDtoConverter<Giay, ThongTinGiayDto> {

	private static int size38 = 0;

	@Override
	public void convertEntityToDto(Giay entity, ThongTinGiayDto dto) {

		if (entity == null || dto == null)
			return;

		dto.setIdGiay(entity.getIdGiay() + "");
		dto.setTenGiay(entity.getTenGiay());

		LoaiGiay loaiGiay = entity.getLoaiGiay();
		dto.setIdLoaiGiay(loaiGiay.getIdLoaiGiay() + "");
		dto.setTenLoaiGiay(loaiGiay.getTenLoaiGiay());

		dto.setIdHangSanXuat(loaiGiay.getHangSanXuat().getIdHangSanXuat() + "");
		dto.setTenHangSanXuat(loaiGiay.getHangSanXuat().getTenHangSanXuat());

		dto.setImg1(entity.getImg1());
		dto.setImg2(entity.getImg2());
		dto.setImg3(entity.getImg3());
		dto.setImg4(entity.getImg4());

		dto.setGiaBan(entity.getGiaBan() + "");

		for (ChiTietGiay ct : entity.getChiTietGiays()) {
			switch (ct.getSize()) {
			case 38:
				dto.setSize38(ct.getSoLuong() + "");
				break;
			case 39:
				dto.setSize39(ct.getSoLuong() + "");
				break;
			case 40:
				dto.setSize40(ct.getSoLuong() + "");
				break;
			case 41:
				dto.setSize41(ct.getSoLuong() + "");
				break;
			case 42:
				dto.setSize42(ct.getSoLuong() + "");
				break;
			case 43:
				dto.setSize43(ct.getSoLuong() + "");
				break;
				
			default:
				break;
			}
		}
	}

}
