package com.uit;
// Generated Nov 27, 2018 12:36:27 AM by Hibernate Tools 5.1.10.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * ChiTietPhieuNhap generated by hbm2java
 */
@Entity
@Table(name = "chi_tiet_phieu_nhap", catalog = "quanlygiay")
public class ChiTietPhieuNhap implements java.io.Serializable {

	private Integer idChiTietPhieuNhap;
	private ChiTietGiay chiTietGiay;
	private PhieuNhap phieuNhap;
	private int soLuong;
	private Integer giaVon;

	public ChiTietPhieuNhap() {
	}

	public ChiTietPhieuNhap(ChiTietGiay chiTietGiay, PhieuNhap phieuNhap, int soLuong) {
		this.chiTietGiay = chiTietGiay;
		this.phieuNhap = phieuNhap;
		this.soLuong = soLuong;
	}

	public ChiTietPhieuNhap(ChiTietGiay chiTietGiay, PhieuNhap phieuNhap, int soLuong, Integer giaVon) {
		this.chiTietGiay = chiTietGiay;
		this.phieuNhap = phieuNhap;
		this.soLuong = soLuong;
		this.giaVon = giaVon;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id_chi_tiet_phieu_nhap", unique = true, nullable = false)
	public Integer getIdChiTietPhieuNhap() {
		return this.idChiTietPhieuNhap;
	}

	public void setIdChiTietPhieuNhap(Integer idChiTietPhieuNhap) {
		this.idChiTietPhieuNhap = idChiTietPhieuNhap;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_chi_tiet_giay", nullable = false)
	public ChiTietGiay getChiTietGiay() {
		return this.chiTietGiay;
	}

	public void setChiTietGiay(ChiTietGiay chiTietGiay) {
		this.chiTietGiay = chiTietGiay;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_phieu_nhap", nullable = false)
	public PhieuNhap getPhieuNhap() {
		return this.phieuNhap;
	}

	public void setPhieuNhap(PhieuNhap phieuNhap) {
		this.phieuNhap = phieuNhap;
	}

	@Column(name = "so_luong", nullable = false)
	public int getSoLuong() {
		return this.soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	@Column(name = "gia_von")
	public Integer getGiaVon() {
		return this.giaVon;
	}

	public void setGiaVon(Integer giaVon) {
		this.giaVon = giaVon;
	}

}
