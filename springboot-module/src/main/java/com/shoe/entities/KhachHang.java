package com.shoe.entities;
// Generated Nov 27, 2018 12:36:27 AM by Hibernate Tools 5.1.10.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * KhachHang generated by hbm2java
 */
@Entity
@Table(name = "khach_hang", catalog = "quanlygiay", uniqueConstraints = @UniqueConstraint(columnNames = "tai_khoan"))
public class KhachHang implements java.io.Serializable {

	private Integer idKhachHang;
	private String tenKhachHang;
	private String diaChi;
	private int soDienThoai;
	private String taiKhoan;
	private String matKhau;
	private Set<DonHang> donHangs = new HashSet<DonHang>(0);

	public KhachHang() {
	}

	public KhachHang(String tenKhachHang, String diaChi, int soDienThoai, String taiKhoan, String matKhau) {
		this.tenKhachHang = tenKhachHang;
		this.diaChi = diaChi;
		this.soDienThoai = soDienThoai;
		this.taiKhoan = taiKhoan;
		this.matKhau = matKhau;
	}

	public KhachHang(String tenKhachHang, String diaChi, int soDienThoai, String taiKhoan, String matKhau,
			Set<DonHang> donHangs) {
		this.tenKhachHang = tenKhachHang;
		this.diaChi = diaChi;
		this.soDienThoai = soDienThoai;
		this.taiKhoan = taiKhoan;
		this.matKhau = matKhau;
		this.donHangs = donHangs;
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

	@Column(name = "tai_khoan", unique = true, nullable = false, length = 100)
	public String getTaiKhoan() {
		return this.taiKhoan;
	}

	public void setTaiKhoan(String taiKhoan) {
		this.taiKhoan = taiKhoan;
	}

	@Column(name = "mat_khau", nullable = false, length = 65535)
	public String getMatKhau() {
		return this.matKhau;
	}

	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "khachHang")
	public Set<DonHang> getDonHangs() {
		return this.donHangs;
	}

	public void setDonHangs(Set<DonHang> donHangs) {
		this.donHangs = donHangs;
	}

}
