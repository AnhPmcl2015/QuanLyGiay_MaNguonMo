package com.shoe.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class KhachHangDTO{
	private int idKhachHang;
	private String tenKhachHang;
	private String diaChi;
	private int soDienThoai;
}