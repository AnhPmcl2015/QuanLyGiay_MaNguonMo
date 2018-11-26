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
@Table(name="chi_tiet_phieu_nhap", catalog="quanlygiay")
public class ChiTietPhieuNhap {
	@Id
	@GeneratedValue
	@Column(name="id", nullable=false, unique=true)
	private int id;
	
	@Column(name="ma_chi_tiet_phieu_nhap", nullable=false, unique=true)
	private String maChiTietPhieuNhap;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "ma_phieu_nhap", nullable = false)
	private PhieuNhap phieuNhap;
	
	@Column(name="so_luong", nullable=false)
	private int SoLuong;
	
	@Column(name="gia_von", nullable=false)
	private long giaVon;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ma_chi_tiet_giay", nullable = false)
	private ChiTietGiay chiTietGiay;

	public ChiTietPhieuNhap() {
		super();
	}

	public ChiTietPhieuNhap(String maChiTietPhieuNhap, PhieuNhap phieuNhap, int soLuong, int giaVon,
			ChiTietGiay chiTietGiay) {
		super();
		this.maChiTietPhieuNhap = maChiTietPhieuNhap;
		this.phieuNhap = phieuNhap;
		SoLuong = soLuong;
		this.giaVon = giaVon;
		this.chiTietGiay = chiTietGiay;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMaChiTietPhieuNhap() {
		return maChiTietPhieuNhap;
	}

	public void setMaChiTietPhieuNhap(String maChiTietPhieuNhap) {
		this.maChiTietPhieuNhap = maChiTietPhieuNhap;
	}

	public PhieuNhap getPhieuNhap() {
		return phieuNhap;
	}

	public void setPhieuNhap(PhieuNhap phieuNhap) {
		this.phieuNhap = phieuNhap;
	}

	public int getSoLuong() {
		return SoLuong;
	}

	public void setSoLuong(int soLuong) {
		SoLuong = soLuong;
	}

	public long getGiaVon() {
		return giaVon;
	}

	public void setGiaVon(long giaVon) {
		this.giaVon = giaVon;
	}

	public ChiTietGiay getChiTietGiay() {
		return chiTietGiay;
	}

	public void setChiTietGiay(ChiTietGiay chiTietGiay) {
		this.chiTietGiay = chiTietGiay;
	}

}
