package com.shoe.entities;
// Generated Nov 27, 2018 12:36:27 AM by Hibernate Tools 5.1.10.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * PhieuNhap generated by hbm2java
 */
@Entity
@Table(name = "phieu_nhap", catalog = "quanlygiay")
public class PhieuNhap implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4092998800675008325L;
	private Integer idPhieuNhap;
	private HangSanXuat hangSanXuat;
	private Date ngayNhap;
	private int tongSoLuong;
	private Set<ChiTietPhieuNhap> chiTietPhieuNhaps = new HashSet<ChiTietPhieuNhap>(0);

	public PhieuNhap() {
	}

	public PhieuNhap(HangSanXuat hangSanXuat, Date ngayNhap, int tongSoLuong) {
		this.hangSanXuat = hangSanXuat;
		this.ngayNhap = ngayNhap;
		this.tongSoLuong = tongSoLuong;
	}

	public PhieuNhap(HangSanXuat hangSanXuat, Date ngayNhap, int tongSoLuong, Set<ChiTietPhieuNhap> chiTietPhieuNhaps) {
		this.hangSanXuat = hangSanXuat;
		this.ngayNhap = ngayNhap;
		this.tongSoLuong = tongSoLuong;
		this.chiTietPhieuNhaps = chiTietPhieuNhaps;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id_phieu_nhap", unique = true, nullable = false)
	public Integer getIdPhieuNhap() {
		return this.idPhieuNhap;
	}

	public void setIdPhieuNhap(Integer idPhieuNhap) {
		this.idPhieuNhap = idPhieuNhap;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_hang_san_xuat", nullable = false)
	public HangSanXuat getHangSanXuat() {
		return this.hangSanXuat;
	}

	public void setHangSanXuat(HangSanXuat hangSanXuat) {
		this.hangSanXuat = hangSanXuat;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "ngay_nhap", nullable = false, length = 19)
	public Date getNgayNhap() {
		return this.ngayNhap;
	}

	public void setNgayNhap(Date ngayNhap) {
		this.ngayNhap = ngayNhap;
	}

	@Column(name = "tong_so_luong", nullable = false)
	public int getTongSoLuong() {
		return this.tongSoLuong;
	}

	public void setTongSoLuong(int tongSoLuong) {
		this.tongSoLuong = tongSoLuong;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "phieuNhap")
	public Set<ChiTietPhieuNhap> getChiTietPhieuNhaps() {
		return this.chiTietPhieuNhaps;
	}

	public void setChiTietPhieuNhaps(Set<ChiTietPhieuNhap> chiTietPhieuNhaps) {
		this.chiTietPhieuNhaps = chiTietPhieuNhaps;
	}

}
