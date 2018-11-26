package com.uit.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "chi_tiet_giay", catalog = "quanlygiay")
public class ChiTietGiay {
	@Id
	@GeneratedValue
	@Column(name = "id", nullable = false, unique = true)
	private int id;

	@Column(name = "ma_chi_tiet_giay", nullable = false, unique = true)
	private String maChiTietGiay;

	@Column(name = "size", nullable = false)
	private String size;

	@Column(name = "so_luong", nullable = false)
	private int soLuong = 0;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ma_giay", nullable = false)
	private Giay giay;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "chiTietGiay", cascade=CascadeType.ALL)
	private Set<ChiTietPhieuNhap> listChiTietPhieuNhap;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "chiTietGiay", cascade=CascadeType.ALL)
	private Set<ChiTietDonHang> listChiTietDonHang;

	public ChiTietGiay() {
		super();
	}

	public ChiTietGiay(String maChiTietGiay, String size, int soLuong, Giay giay,
			Set<ChiTietPhieuNhap> listChiTietPhieuNhap, Set<ChiTietDonHang> listChiTietDonHang) {
		super();
		this.maChiTietGiay = maChiTietGiay;
		this.size = size;
		this.soLuong = soLuong;
		this.giay = giay;
		this.listChiTietPhieuNhap = listChiTietPhieuNhap;
		this.listChiTietDonHang = listChiTietDonHang;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMaChiTietGiay() {
		return maChiTietGiay;
	}

	public void setMaChiTietGiay(String maChiTietGiay) {
		this.maChiTietGiay = maChiTietGiay;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public Giay getGiay() {
		return giay;
	}

	public void setGiay(Giay giay) {
		this.giay = giay;
	}

	public Set<ChiTietPhieuNhap> getListChiTietPhieuNhap() {
		return listChiTietPhieuNhap;
	}

	public void setListChiTietPhieuNhap(Set<ChiTietPhieuNhap> listChiTietPhieuNhap) {
		this.listChiTietPhieuNhap = listChiTietPhieuNhap;
	}

	public Set<ChiTietDonHang> getListChiTietDonHang() {
		return listChiTietDonHang;
	}

	public void setListChiTietDonHang(Set<ChiTietDonHang> listChiTietDonHang) {
		this.listChiTietDonHang = listChiTietDonHang;
	}

}
