package com.uit.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="chi_tiet_don_hang", catalog="quanlygiay")
public class ChiTietDonHang {
	
	@Id
	@GeneratedValue
	@Column(name="id", nullable=false, unique=true)
	private int id;
	
	@Column(name="ma_chi_tiet_don_hang", unique=true, nullable=false)
	private String maChiTietDonHang;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "ma_chi_tiet_giay", nullable = false)
	private ChiTietGiay chiTietGiay;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "ma_don_hang", nullable = false)
	private DonHang donHang;
	
	@Column(name="so_luong", nullable=false)
	private int soLuong = 0;
	
	@Column(name="thanh_tien", nullable=false)
	private long thanhTien = 0l;

	public ChiTietDonHang() {
		super();
	}

	public ChiTietDonHang(String maChiTietDonHang, ChiTietGiay chiTietGiay, DonHang donHang, int soLuong,
			long thanhTien) {
		super();
		this.maChiTietDonHang = maChiTietDonHang;
		this.chiTietGiay = chiTietGiay;
		this.donHang = donHang;
		this.soLuong = soLuong;
		this.thanhTien = thanhTien;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMaChiTietDonHang() {
		return maChiTietDonHang;
	}

	public void setMaChiTietDonHang(String maChiTietDonHang) {
		this.maChiTietDonHang = maChiTietDonHang;
	}

	public ChiTietGiay getChiTietGiay() {
		return chiTietGiay;
	}

	public void setChiTietGiay(ChiTietGiay chiTietGiay) {
		this.chiTietGiay = chiTietGiay;
	}

	public DonHang getDonHang() {
		return donHang;
	}

	public void setDonHang(DonHang donHang) {
		this.donHang = donHang;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public long getThanhTien() {
		return thanhTien;
	}

	public void setThanhTien(long thanhTien) {
		this.thanhTien = thanhTien;
	}

}
