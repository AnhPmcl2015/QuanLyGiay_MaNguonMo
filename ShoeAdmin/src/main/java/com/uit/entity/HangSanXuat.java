package com.uit.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="hang_san_xuat", catalog="quanlygiay")
public class HangSanXuat {
	
	@Id
	@GeneratedValue
	@Column(name="id", nullable=false, unique=true)
	private int id;
	
	@Column(name="ma_hang_san_xuat", nullable=false, unique=true)
	private String maHangSanXuat;
	
	@Column(name="ten_hang_san_xuat", nullable=false, unique=true)
	private String tenHangSanXuat;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="hangSanXuat", cascade=CascadeType.ALL)
	private Set<LoaiGiay> listLoaiGiay;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="hangSanXuat", cascade=CascadeType.ALL)
	private Set<PhieuNhap> listPhieuNhap;
	
	@Column(name="xoa_flag", nullable=false)
	private boolean xoaFlag=false;

	public HangSanXuat() {
		super();
	}

	public HangSanXuat(String maHangSanXuat, String tenHangSanXuat) {
		super();
		this.maHangSanXuat = maHangSanXuat;
		this.tenHangSanXuat = tenHangSanXuat;
	}

	public HangSanXuat(String maHangSanXuat, String tenHangSanXuat, Set<LoaiGiay> listLoaiGiay,
			Set<PhieuNhap> listPhieuNhap, boolean xoaFlag) {
		super();
		this.maHangSanXuat = maHangSanXuat;
		this.tenHangSanXuat = tenHangSanXuat;
		this.listLoaiGiay = listLoaiGiay;
		this.listPhieuNhap = listPhieuNhap;
		this.xoaFlag = xoaFlag;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMaHangSanXuat() {
		return maHangSanXuat;
	}

	public void setMaHangSanXuat(String maHangSanXuat) {
		this.maHangSanXuat = maHangSanXuat;
	}

	public String getTenHangSanXuat() {
		return tenHangSanXuat;
	}

	public void setTenHangSanXuat(String tenHangSanXuat) {
		this.tenHangSanXuat = tenHangSanXuat;
	}

	public Set<LoaiGiay> getListLoaiGiay() {
		return listLoaiGiay;
	}

	public void setListLoaiGiay(Set<LoaiGiay> listLoaiGiay) {
		this.listLoaiGiay = listLoaiGiay;
	}

	public Set<PhieuNhap> getListPhieuNhap() {
		return listPhieuNhap;
	}

	public void setListPhieuNhap(Set<PhieuNhap> listPhieuNhap) {
		this.listPhieuNhap = listPhieuNhap;
	}

	public boolean isXoaFlag() {
		return xoaFlag;
	}

	public void setXoaFlag(boolean xoaFlag) {
		this.xoaFlag = xoaFlag;
	}

}
