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
@Table(name="tinh_trang_don_hang", catalog="quanlygiay")
public class TinhTrangDonHang {

	@Id
	@GeneratedValue
	@Column(name="id_tinh_trang_don_hang", unique=true, nullable=false)
	private int id;
	
	@Column(name="ten_tinh_trang_don_hang", unique=true, nullable=false)
	private String tenTinhTrangDonHang;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="tinhTrangDonHang", cascade=CascadeType.ALL)
	private Set<DonHang> listDonHang;

	public TinhTrangDonHang() {
		super();
	}

	public TinhTrangDonHang(String tenTinhTrangDonHang, Set<DonHang> listDonHang) {
		super();
		this.tenTinhTrangDonHang = tenTinhTrangDonHang;
		this.listDonHang = listDonHang;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTenTinhTrangDonHang() {
		return tenTinhTrangDonHang;
	}

	public void setTenTinhTrangDonHang(String tenTinhTrangDonHang) {
		this.tenTinhTrangDonHang = tenTinhTrangDonHang;
	}

	public Set<DonHang> getListDonHang() {
		return listDonHang;
	}

	public void setListDonHang(Set<DonHang> listDonHang) {
		this.listDonHang = listDonHang;
	}

}
