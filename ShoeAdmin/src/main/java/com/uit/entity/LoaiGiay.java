package com.uit.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="loai_giay", catalog="quanlygiay")
public class LoaiGiay {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id", nullable=false, unique=true)
	private int id;
	
	@Column(name="ma_loai_giay", nullable=false, unique=true)
	private String maLoaiGiay;
	
	@Column(name="ten_loai_giay", nullable=false)
	private String tenLoaiGiay;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "loaiGiay", cascade=CascadeType.ALL)
	private Set<Giay> listGiay;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ma_hang_san_xuat", nullable = false)
	private HangSanXuat hangSanXuat;
	
	@Column(name="xoa_flag", nullable=false)
	private boolean xoaFlag = false;

	public LoaiGiay() {
		super();
	}

	public LoaiGiay(String maLoaiGiay, String tenLoaiGiay, Set<Giay> listGiay, HangSanXuat hangSanXuat,
			boolean xoaFlag) {
		super();
		this.maLoaiGiay = maLoaiGiay;
		this.tenLoaiGiay = tenLoaiGiay;
		this.listGiay = listGiay;
		this.hangSanXuat = hangSanXuat;
		this.xoaFlag = xoaFlag;
	}

	public boolean isXoaFlag() {
		return xoaFlag;
	}

	public void setXoaFlag(boolean xoaFlag) {
		this.xoaFlag = xoaFlag;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMaLoaiGiay() {
		return maLoaiGiay;
	}

	public void setMaLoaiGiay(String maLoaiGiay) {
		this.maLoaiGiay = maLoaiGiay;
	}

	public String getTenLoaiGiay() {
		return tenLoaiGiay;
	}

	public void setTenLoaiGiay(String tenLoaiGiay) {
		this.tenLoaiGiay = tenLoaiGiay;
	}

	public Set<Giay> getListGiay() {
		return listGiay;
	}

	public void setListGiay(Set<Giay> listGiay) {
		this.listGiay = listGiay;
	}

	public HangSanXuat getHangSanXuat() {
		return hangSanXuat;
	}

	public void setHangSanXuat(HangSanXuat hangSanXuat) {
		this.hangSanXuat = hangSanXuat;
	}

}
