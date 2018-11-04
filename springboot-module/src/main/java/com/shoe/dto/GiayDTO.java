package com.shoe.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GiayDTO{
    private int idGiay;
	private GioiTinhDTO gioiTinh;
	private LoaiGiayDTO loaiGiay;
	private String maGiay;
	private String tenGiay;
	private int soLuongBan;
	private long giaBan;
	private String ghiChu;
	private String img1;
	private String img2;
	private String img3;
	private String img4;
}