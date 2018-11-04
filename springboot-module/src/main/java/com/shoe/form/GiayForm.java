package com.shoe.form;

import com.shoe.entities.GioiTinh;
import com.shoe.entities.LoaiGiay;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GiayForm{

	private String maGiay;
    private String tenGiay;
	private String id_gioi_tinh;
	private String id_loai_giay;	
	private String ghiChu;
	private String giaBan;
	private String img1;
	private String img2;
	private String img3;
	private String img4;
}