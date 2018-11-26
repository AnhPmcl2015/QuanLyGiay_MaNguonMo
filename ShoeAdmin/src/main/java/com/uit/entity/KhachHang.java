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
@Table(name = "khach_hang", catalog = "quanlygiay")
public class KhachHang {

	@Id
	@GeneratedValue
	@Column(name = "id", nullable = false, unique = true)
	private int id;

	@Column(name = "ma_khach_hang", nullable = false, unique = true)
	private String maKhachHang;

	@Column(name = "ten_khach_hang", nullable = false)
	private String tenKhachHang;

	@Column(name = "dia_chi", nullable = true)
	private String diaChi;

	@Column(name = "so_dien_thoai", nullable = false)
	private String soDienThoai;

	@Column(name = "tai_khoan", nullable = false)
	private String taiKhoan;

	@Column(name = "mat_khau", nullable = false, unique = true)
	private String matKhau;

	@OneToMany(fetch=FetchType.LAZY, mappedBy="khachHang", cascade=CascadeType.ALL)
	private Set<DonHang> listDonHang;

	public KhachHang() {
		super();
	}

	public KhachHang(String maKhachHang, String tenKhachHang, String diaChi, String soDienThoai, String taiKhoan,
			String matKhau, Set<DonHang> listDonHang) {
		super();
		this.maKhachHang = maKhachHang;
		this.tenKhachHang = tenKhachHang;
		this.diaChi = diaChi;
		this.soDienThoai = soDienThoai;
		this.taiKhoan = taiKhoan;
		this.matKhau = matKhau;
		this.listDonHang = listDonHang;
	}

	public Set<DonHang> getListDonHang() {
		return listDonHang;
	}

	public void setListDonHang(Set<DonHang> listDonHang) {
		this.listDonHang = listDonHang;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMaKhachHang() {
		return maKhachHang;
	}

	public void setMaKhachHang(String maKhachHang) {
		this.maKhachHang = maKhachHang;
	}

	public String getTenKhachHang() {
		return tenKhachHang;
	}

	public void setTenKhachHang(String tenKhachHang) {
		this.tenKhachHang = tenKhachHang;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	public String getTaiKhoan() {
		return taiKhoan;
	}

	public void setTaiKhoan(String taiKhoan) {
		this.taiKhoan = taiKhoan;
	}

	public String getMatKhau() {
		return matKhau;
	}

	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}

}
