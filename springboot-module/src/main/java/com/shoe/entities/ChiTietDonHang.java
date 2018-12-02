package com.shoe.entities;
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
 * ChiTietDonHang generated by hbm2java
 */
@Entity
@Table(name = "chi_tiet_don_hang", catalog = "quanlygiay")
public class ChiTietDonHang implements java.io.Serializable {

	private Integer idChiTietDonHang;
	private ChiTietGiay chiTietGiay;
	private DonHang donHang;
	private int soLuong;
	private int thanhTien;

	public ChiTietDonHang() {
	}

	public ChiTietDonHang(ChiTietGiay chiTietGiay, DonHang donHang, int soLuong, int thanhTien) {
		this.chiTietGiay = chiTietGiay;
		this.donHang = donHang;
		this.soLuong = soLuong;
		this.thanhTien = thanhTien;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id_chi_tiet_don_hang", unique = true, nullable = false)
	public Integer getIdChiTietDonHang() {
		return this.idChiTietDonHang;
	}

	public void setIdChiTietDonHang(Integer idChiTietDonHang) {
		this.idChiTietDonHang = idChiTietDonHang;
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
	@JoinColumn(name = "id_don_hang", nullable = false)
	public DonHang getDonHang() {
		return this.donHang;
	}

	public void setDonHang(DonHang donHang) {
		this.donHang = donHang;
	}

	@Column(name = "so_luong", nullable = false)
	public int getSoLuong() {
		return this.soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	@Column(name = "thanh_tien", nullable = false)
	public int getThanhTien() {
		return this.thanhTien;
	}

	public void setThanhTien(int thanhTien) {
		this.thanhTien = thanhTien;
	}

}
