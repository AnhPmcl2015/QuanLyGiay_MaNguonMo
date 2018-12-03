package com.shoe.entities;
// Generated Dec 3, 2018 9:08:44 PM by Hibernate Tools 4.3.5.Final

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
 * KhachHang generated by hbm2java
 */
@Entity
@Table(name = "khach_hang", catalog = "quanlygiay")
public class KhachHang implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8871953299256852332L;
	private Integer idKhachHang;
	private User user;
	private String tenKhachHang;
	private String diaChi;
	private int soDienThoai;

	public KhachHang() {
	}

	public KhachHang(String tenKhachHang, String diaChi, int soDienThoai) {
		this.tenKhachHang = tenKhachHang;
		this.diaChi = diaChi;
		this.soDienThoai = soDienThoai;
	}

	public KhachHang(User user, String tenKhachHang, String diaChi, int soDienThoai) {
		this.user = user;
		this.tenKhachHang = tenKhachHang;
		this.diaChi = diaChi;
		this.soDienThoai = soDienThoai;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id_khach_hang", unique = true, nullable = false)
	public Integer getIdKhachHang() {
		return this.idKhachHang;
	}

	public void setIdKhachHang(Integer idKhachHang) {
		this.idKhachHang = idKhachHang;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Column(name = "ten_khach_hang", nullable = false, length = 100)
	public String getTenKhachHang() {
		return this.tenKhachHang;
	}

	public void setTenKhachHang(String tenKhachHang) {
		this.tenKhachHang = tenKhachHang;
	}

	@Column(name = "dia_chi", nullable = false, length = 65535)
	public String getDiaChi() {
		return this.diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	@Column(name = "so_dien_thoai", nullable = false)
	public int getSoDienThoai() {
		return this.soDienThoai;
	}

	public void setSoDienThoai(int soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

}
