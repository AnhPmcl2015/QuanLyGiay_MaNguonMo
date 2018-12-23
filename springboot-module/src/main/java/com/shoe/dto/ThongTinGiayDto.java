package com.shoe.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ThongTinGiayDto {
	private String idGiay;
	private String tenGiay;
	private String idHangSanXuat;
	private String tenHangSanXuat;
	private String idLoaiGiay;
	private String tenLoaiGiay;
	private String img1;
	private String img2;
	private String img3;
	private String img4;
	private List<ChiTietGiayDTO> listCTG;
	private String giaBan;
	private boolean xoaFlag;

}
