package com.uit.entity;

import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="phieu_nhap", catalog="quanlygiay")
public class PhieuNhap {
	@Id
	@GeneratedValue
	@Column(name="id", nullable=false, unique=true)
	private int id;
	
	@Column(name="ma_phieu_nhap", nullable=false, unique=true)
	private String maPhieuNhap;
	
	@Column(name="ngay_nhap", nullable=false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date ngayNhap;
	
	@Column(name="tong_so_luong", nullable=false)
	private int tongSoLuong;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ma_hang_san_xuat", nullable = false)
	private HangSanXuat hangSanXuat;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="phieuNhap", cascade=CascadeType.ALL)
	private Set<ChiTietPhieuNhap> listChiTietPhieuNhap;

	public PhieuNhap() {
		super();
	}

	public PhieuNhap(String maPhieuNhap, Date ngayNhap, int tongSoLuong, HangSanXuat hangSanXuat,
			Set<ChiTietPhieuNhap> listChiTietPhieuNhap) {
		super();
		this.maPhieuNhap = maPhieuNhap;
		this.ngayNhap = ngayNhap;
		this.tongSoLuong = tongSoLuong;
		this.hangSanXuat = hangSanXuat;
		this.listChiTietPhieuNhap = listChiTietPhieuNhap;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMaPhieuNhap() {
		return maPhieuNhap;
	}

	public void setMaPhieuNhap(String maPhieuNhap) {
		this.maPhieuNhap = maPhieuNhap;
	}

	public Date getNgayNhap() {
		return ngayNhap;
	}

	public void setNgayNhap(Date ngayNhap) {
		this.ngayNhap = ngayNhap;
	}

	public int getTongSoLuong() {
		return tongSoLuong;
	}

	public void setTongSoLuong(int tongSoLuong) {
		this.tongSoLuong = tongSoLuong;
	}

	public HangSanXuat getHangSanXuat() {
		return hangSanXuat;
	}

	public void setHangSanXuat(HangSanXuat hangSanXuat) {
		this.hangSanXuat = hangSanXuat;
	}

	public Set<ChiTietPhieuNhap> getListChiTietPhieuNhap() {
		return listChiTietPhieuNhap;
	}

	public void setListChiTietPhieuNhap(Set<ChiTietPhieuNhap> listChiTietPhieuNhap) {
		this.listChiTietPhieuNhap = listChiTietPhieuNhap;
	}

}
