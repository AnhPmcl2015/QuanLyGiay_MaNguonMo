package com.shoe.test;
// Generated Dec 3, 2018 6:37:20 PM by Hibernate Tools 5.3.6.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * DonHang generated by hbm2java
 */
public class DonHang implements java.io.Serializable {

	private Integer idDonHang;
	private KhachHang khachHang;
	private TinhTrangDonHang tinhTrangDonHang;
	private Date ngayDat;
	private Date ngayGiao;
	private int tongTien;
	private Set chiTietDonHangs = new HashSet(0);

	public DonHang() {
	}

	public DonHang(KhachHang khachHang, TinhTrangDonHang tinhTrangDonHang, Date ngayDat, Date ngayGiao, int tongTien) {
		this.khachHang = khachHang;
		this.tinhTrangDonHang = tinhTrangDonHang;
		this.ngayDat = ngayDat;
		this.ngayGiao = ngayGiao;
		this.tongTien = tongTien;
	}

	public DonHang(KhachHang khachHang, TinhTrangDonHang tinhTrangDonHang, Date ngayDat, Date ngayGiao, int tongTien,
			Set chiTietDonHangs) {
		this.khachHang = khachHang;
		this.tinhTrangDonHang = tinhTrangDonHang;
		this.ngayDat = ngayDat;
		this.ngayGiao = ngayGiao;
		this.tongTien = tongTien;
		this.chiTietDonHangs = chiTietDonHangs;
	}

	public Integer getIdDonHang() {
		return this.idDonHang;
	}

	public void setIdDonHang(Integer idDonHang) {
		this.idDonHang = idDonHang;
	}

	public KhachHang getKhachHang() {
		return this.khachHang;
	}

	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}

	public TinhTrangDonHang getTinhTrangDonHang() {
		return this.tinhTrangDonHang;
	}

	public void setTinhTrangDonHang(TinhTrangDonHang tinhTrangDonHang) {
		this.tinhTrangDonHang = tinhTrangDonHang;
	}

	public Date getNgayDat() {
		return this.ngayDat;
	}

	public void setNgayDat(Date ngayDat) {
		this.ngayDat = ngayDat;
	}

	public Date getNgayGiao() {
		return this.ngayGiao;
	}

	public void setNgayGiao(Date ngayGiao) {
		this.ngayGiao = ngayGiao;
	}

	public int getTongTien() {
		return this.tongTien;
	}

	public void setTongTien(int tongTien) {
		this.tongTien = tongTien;
	}

	public Set getChiTietDonHangs() {
		return this.chiTietDonHangs;
	}

	public void setChiTietDonHangs(Set chiTietDonHangs) {
		this.chiTietDonHangs = chiTietDonHangs;
	}

}
