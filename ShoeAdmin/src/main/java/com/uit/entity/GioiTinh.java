package com.uit.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "gioi_tinh", catalog = "quanlygiay")
public class GioiTinh {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_gioi_tinh", nullable = false, unique = true)
	private int id;

	@Column(name = "ten_gioi_tinh", unique = true, nullable = false)
	private String tenGioiTinh;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "gioiTinh", cascade=CascadeType.ALL)
	private Set<Giay> listGiay;

	public GioiTinh() {
		super();
	}

	public GioiTinh(String tenGioiTinh, Set<Giay> listGiay) {
		super();
		this.tenGioiTinh = tenGioiTinh;
		this.listGiay = listGiay;
	}

	public Set<Giay> getListGiay() {
		return listGiay;
	}

	public void setListGiay(Set<Giay> listGiay) {
		this.listGiay = listGiay;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTenGioiTinh() {
		return tenGioiTinh;
	}

	public void setTenGioiTinh(String tenGioiTinh) {
		this.tenGioiTinh = tenGioiTinh;
	}

}
