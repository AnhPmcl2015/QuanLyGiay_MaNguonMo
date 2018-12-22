package com.shoe.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DonHangDTO {
	private int idDonHang;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private Date ngayDat;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	private Date ngayGiao;
	private int tongTien;
	private KhachHangDTO khachHang;
	private TinhTrangDonHangDTO tinhTrangDonHang;
	private List<ChiTietDonHangDTO> listChiTietDonHangDTO = new ArrayList<ChiTietDonHangDTO>();
}