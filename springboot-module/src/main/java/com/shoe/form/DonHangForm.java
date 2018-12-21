package com.shoe.form;

import java.util.Date;
import java.util.List;
import com.shoe.entities.ChiTietDonHang;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DonHangForm {
	private int idDonHang;
	private Date ngayDat;
	private Date ngayGiao;
	private int idTinhTrang;
	private String tongTien;
	private String taiKhoan;
	private List<ChiTietDonHang> chiTietDonHangs;
}