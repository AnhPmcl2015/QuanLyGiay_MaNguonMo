package com.shoe.form;

import javax.validation.constraints.NotNull;

public class PaymentDetailForm {
    @NotNull
    private int idChiTietGiay;

    @NotNull
    private int soLuong;
    
    @NotNull
    private int thanhTien;

	public int getIdChiTietGiay() {
		return idChiTietGiay;
	}

	public void setIdChiTietGiay(int idChiTietGiay) {
		this.idChiTietGiay = idChiTietGiay;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public int getThanhTien() {
		return thanhTien;
	}

	public void setThanhTien(int thanhTien) {
		this.thanhTien = thanhTien;
	}
    
}