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
 * HangSanXuat generated by hbm2java
 */
@Entity
@Table(name = "hang_san_xuat", catalog = "quanlygiay")
public class HangSanXuat implements java.io.Serializable {

	private String idHangSanXuat;
	private String tenHangSanXuat;
	private Boolean xoaFlag;
	private Set<LoaiGiay> loaiGiays = new HashSet<LoaiGiay>(0);
	private Set<PhieuNhap> phieuNhaps = new HashSet<PhieuNhap>(0);

	public HangSanXuat() {
	}

	public HangSanXuat(String idHangSanXuat) {
		this.idHangSanXuat = idHangSanXuat;
	}

	public HangSanXuat(String idHangSanXuat, String tenHangSanXuat, Boolean xoaFlag, Set<LoaiGiay> loaiGiays,
			Set<PhieuNhap> phieuNhaps) {
		this.idHangSanXuat = idHangSanXuat;
		this.tenHangSanXuat = tenHangSanXuat;
		this.xoaFlag = xoaFlag;
		this.loaiGiays = loaiGiays;
		this.phieuNhaps = phieuNhaps;
	}

	@Id

	@Column(name = "id_hang_san_xuat", unique = true, nullable = false, length = 50)
	public String getIdHangSanXuat() {
		return this.idHangSanXuat;
	}

	public void setIdHangSanXuat(String idHangSanXuat) {
		this.idHangSanXuat = idHangSanXuat;
	}

	@Column(name = "ten_hang_san_xuat", length = 100)
	public String getTenHangSanXuat() {
		return this.tenHangSanXuat;
	}

	public void setTenHangSanXuat(String tenHangSanXuat) {
		this.tenHangSanXuat = tenHangSanXuat;
	}

	@Column(name = "xoa_flag")
	public Boolean getXoaFlag() {
		return this.xoaFlag;
	}

	public void setXoaFlag(Boolean xoaFlag) {
		this.xoaFlag = xoaFlag;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "hangSanXuat")
	public Set<LoaiGiay> getLoaiGiays() {
		return this.loaiGiays;
	}

	public void setLoaiGiays(Set<LoaiGiay> loaiGiays) {
		this.loaiGiays = loaiGiays;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "hangSanXuat")
	public Set<PhieuNhap> getPhieuNhaps() {
		return this.phieuNhaps;
	}

	public void setPhieuNhaps(Set<PhieuNhap> phieuNhaps) {
		this.phieuNhaps = phieuNhaps;
	}

}
