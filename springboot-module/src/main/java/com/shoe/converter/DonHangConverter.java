package com.shoe.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.shoe.dto.ChiTietDonHangDTO;
import com.shoe.dto.DonHangDTO;
import com.shoe.dto.KhachHangDTO;
import com.shoe.dto.TinhTrangDonHangDTO;
import com.shoe.entities.ChiTietDonHang;
import com.shoe.entities.DonHang;
import com.shoe.entities.KhachHang;
import com.shoe.entities.TinhTrangDonHang;
import com.shoe.form.PaymentForm;

@Component
public class DonHangConverter {
	@Autowired
	KhachHangConverter khachHangEco;

	@Autowired
	ChiTietDonHangConverter chiTietDonHangConverter;

	@Autowired
	TinhTrangDonHangConverter tinhTrangDonHangConverter;

	public void convertFormToDTO(PaymentForm form, DonHangDTO dto) {
		TinhTrangDonHangDTO tinhTrangDonHangDTO = new TinhTrangDonHangDTO();
		KhachHangDTO khachHangDTO = new KhachHangDTO();
		List<ChiTietDonHangDTO> listChiTietDonHangDTO = new ArrayList<ChiTietDonHangDTO>();

		tinhTrangDonHangDTO.setIdTinhTrang(form.getIdTinhTrang());
		khachHangDTO.setIdKhachHang(form.getIdKhachHang());
		form.getListChiTietDonHang().forEach(item -> {
			ChiTietDonHangDTO chiTietDonHangDTO = new ChiTietDonHangDTO();
			chiTietDonHangConverter.convertFormToDTO(item, chiTietDonHangDTO);

			listChiTietDonHangDTO.add(chiTietDonHangDTO);
		});

		dto.setTinhTrangDonHang(tinhTrangDonHangDTO);
		dto.setTongTien(form.getTongTien());
		dto.setKhachHang(khachHangDTO);
		dto.setListChiTietDonHangDTO(listChiTietDonHangDTO);
	}

	public void convertEntityToDto(DonHang entity, DonHangDTO dto) {
		KhachHangDTO khachHangDTO = new KhachHangDTO();
		khachHangEco.convertEntityToDto(entity.getKhachHang(), khachHangDTO);
		TinhTrangDonHangDTO tinhTrangDonHangDTO = new TinhTrangDonHangDTO();
		tinhTrangDonHangConverter.convertEntityToDto(entity.getTinhTrangDonHang(), tinhTrangDonHangDTO);

		dto.setIdDonHang(entity.getIdDonHang());
		dto.setKhachHang(khachHangDTO);
		dto.setNgayDat(entity.getNgayDat());
		dto.setNgayGiao(entity.getNgayGiao());
		dto.setTinhTrangDonHang(tinhTrangDonHangDTO);
		dto.setTongTien(entity.getTongTien());
	}

	public void convertDtoToEntiy(DonHangDTO dto, DonHang entity) {
		TinhTrangDonHang tinhtrang = new TinhTrangDonHang();
		tinhtrang.setIdTinhTrang(dto.getTinhTrangDonHang().getIdTinhTrang());
		
		KhachHang khachHang = new KhachHang();
		khachHang.setIdKhachHang(dto.getKhachHang().getIdKhachHang());
		
		List<ChiTietDonHang> chiTietDonHangs = new ArrayList<ChiTietDonHang>();
		dto.getListChiTietDonHangDTO().forEach(ctdh -> {
			ChiTietDonHang _ctdh = new ChiTietDonHang();
			chiTietDonHangConverter.convertDtoToEntity(ctdh, _ctdh);
			chiTietDonHangs.add(_ctdh);
		});

		// entity.setIdDonHang(dto.getIdDonHang());
		entity.setKhachHang(khachHang);
		entity.setNgayDat(dto.getNgayDat());
		entity.setNgayGiao(dto.getNgayGiao());
		entity.setTinhTrangDonHang(tinhtrang);
		entity.setTongTien(dto.getTongTien());
		entity.setChiTietDonHangs(chiTietDonHangs);
	}
}