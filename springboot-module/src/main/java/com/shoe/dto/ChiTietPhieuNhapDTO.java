package com.shoe.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChiTietPhieuNhapDTO {
	private int idChiTietPhieuNhap;
	private PhieuNhapDTO phieuNhap;
	private ChiTietGiayDTO chiTietGiay;
	private int soLuong;
	private String giaVon;
	private int thanhTien;
}