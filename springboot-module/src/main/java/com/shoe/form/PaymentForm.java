package com.shoe.form;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;

public class PaymentForm {
	@NotNull
	private int idKhachHang;

	@NotNull
	private int idTinhTrang;

	@NotNull
	private int tongTien;

	@NotNull
	private List<PaymentDetailForm> listChiTietDonHang = new ArrayList<PaymentDetailForm>();

	public int getIdKhachHang() {
		return idKhachHang;
	}

	public void setIdKhachHang(int idKhachHang) {
		this.idKhachHang = idKhachHang;
	}

	public int getIdTinhTrang() {
		return idTinhTrang;
	}

	public void setIdTinhTrang(int idTinhTrang) {
		this.idTinhTrang = idTinhTrang;
	}

	public int getTongTien() {
		return tongTien;
	}

	public void setTongTien(int tongTien) {
		this.tongTien = tongTien;
	}

	public List<PaymentDetailForm> getListChiTietDonHang() {
		return listChiTietDonHang;
	}

	public void setListChiTietDonHang(List<PaymentDetailForm> listChiTietDonHang) {
		this.listChiTietDonHang = listChiTietDonHang;
	}
	
}