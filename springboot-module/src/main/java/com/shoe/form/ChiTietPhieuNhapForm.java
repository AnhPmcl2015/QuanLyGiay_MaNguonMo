package com.shoe.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChiTietPhieuNhapForm {
	private int idChiTietGiay;
	private int soLuong;
	private String giaVon;
}