package com.uit;
// Generated Nov 27, 2018 12:36:27 AM by Hibernate Tools 5.1.10.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * GioiTinh generated by hbm2java
 */
@Entity
@Table(name = "gioi_tinh", catalog = "quanlygiay")
public class GioiTinh implements java.io.Serializable {

	private int idGioiTinh;
	private String tenGioiTinh;
	private Set<Giay> giays = new HashSet<Giay>(0);

	public GioiTinh() {
	}

	public GioiTinh(int idGioiTinh, String tenGioiTinh) {
		this.idGioiTinh = idGioiTinh;
		this.tenGioiTinh = tenGioiTinh;
	}

	public GioiTinh(int idGioiTinh, String tenGioiTinh, Set<Giay> giays) {
		this.idGioiTinh = idGioiTinh;
		this.tenGioiTinh = tenGioiTinh;
		this.giays = giays;
	}

	@Id

	@Column(name = "id_gioi_tinh", unique = true, nullable = false)
	public int getIdGioiTinh() {
		return this.idGioiTinh;
	}

	public void setIdGioiTinh(int idGioiTinh) {
		this.idGioiTinh = idGioiTinh;
	}

	@Column(name = "ten_gioi_tinh", nullable = false, length = 50)
	public String getTenGioiTinh() {
		return this.tenGioiTinh;
	}

	public void setTenGioiTinh(String tenGioiTinh) {
		this.tenGioiTinh = tenGioiTinh;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "gioiTinh")
	public Set<Giay> getGiays() {
		return this.giays;
	}

	public void setGiays(Set<Giay> giays) {
		this.giays = giays;
	}

}
