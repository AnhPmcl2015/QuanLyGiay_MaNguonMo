package com.shoe.dto;

import com.shoe.entities.PhieuNhap;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChiTietPhieuNhapDTO {
	private int idChiTietPhieuNhap;
	private PhieuNhap phieuNhap;
	private ShoeDTO giayDTO;
	private int soLuong;
	private String giaVon;

}