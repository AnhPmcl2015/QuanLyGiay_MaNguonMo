package com.shoe.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GiayDto {
	private String idGiay;
	private String tenGiay;
	private String giaBan;
	private String img;
	private String loaiGiay;
	private String gioiTinh;
}
