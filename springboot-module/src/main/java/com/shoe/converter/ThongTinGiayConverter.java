package com.shoe.converter;

import com.shoe.dto.ChiTietGiayDTO;
import com.shoe.dto.ThongTinGiayDto;
import com.shoe.entities.ChiTietGiay;
import com.shoe.entities.Giay;
import com.shoe.entities.LoaiGiay;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

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
		dto.setXoaFlag(entity.getXoaFlag());
		List<ChiTietGiayDTO> listCTG = new ArrayList<>();
		for (ChiTietGiay ct : entity.getChiTietGiays()) {
			ChiTietGiayDTO ctg = new ChiTietGiayDTO();
			ctg.setIdChiTietGiay(ct.getIdChiTietGiay());
			ctg.setSoLuong(ct.getSoLuong());
			ctg.setSize(ct.getSize());
			listCTG.add(ctg);
		}
		dto.setListCTG(listCTG);
	}

}
