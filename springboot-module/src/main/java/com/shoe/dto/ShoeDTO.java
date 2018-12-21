package com.shoe.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShoeDTO {
    private int idGiay;
	private GioiTinhDTO gioiTinh;
	private LoaiGiayDTO loaiGiay;
	private String tenGiay;
	private String maGiay;
	private int soLuongBan;
	private int giaBan;
	private String ghiChu;
	private String img1;
	private String img2;
	private String img3;
	private String img4;
}