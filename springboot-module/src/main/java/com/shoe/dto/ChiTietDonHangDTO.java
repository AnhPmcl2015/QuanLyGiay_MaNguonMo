package com.shoe.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChiTietDonHangDTO {
	private int idChiTietDonHang;
	private ChiTietGiayDTO chiTietGiay;
	private DonHangDTO donHang;
	private int soLuong;
	private int thanhTien;

}