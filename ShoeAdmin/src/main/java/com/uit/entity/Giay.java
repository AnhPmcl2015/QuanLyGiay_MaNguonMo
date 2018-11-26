package com.uit.entity;

import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "giay", catalog = "quanlygiay")
public class Giay {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private int id;

	@Column(name = "ma_giay", unique = true, nullable = false)
	private String maGiay;

	@Column(name = "ten_giay", unique = true, nullable = false)
	private String tenGiay;

	@Column(name = "so_luong_ban")
	private String soLuongBan;

	@Column(name = "gia_ban")
	private String giaBan;

	@Column(name = "ghi_chu", length = 250)
	private String ghiChu;

	@Column(name = "img", nullable = false)
	private String img;

	@Column(name = "xoa_flag", nullable = false)
	private boolean xoaFlag = false;

	@Column(name = "ngay_xoa")
	@Temporal(TemporalType.TIMESTAMP)
	private Date ngayXoa;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ma_loai_giay", nullable = false)
	private LoaiGiay loaiGiay;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_gioi_tinh", nullable = false)
	private GioiTinh gioiTinh;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "giay", cascade=CascadeType.ALL)
	private Set<ChiTietGiay> chiTietGiay;

	public Giay(String maGiay, String tenGiay, String soLuongBan, String giaBan, String ghiChu, String img,
			LoaiGiay loaiGiay, GioiTinh gioiTinh, Set<ChiTietGiay> chiTietGiay) {
		super();
		this.maGiay = maGiay;
		this.tenGiay = tenGiay;
		this.soLuongBan = soLuongBan;
		this.giaBan = giaBan;
		this.ghiChu = ghiChu;
		this.img = img;
		this.loaiGiay = loaiGiay;
		this.gioiTinh = gioiTinh;
		this.chiTietGiay = chiTietGiay;
	}

	public Giay(String maGiay, String giaBan, String ghiChu, Set<ChiTietGiay> chiTietGiay) {
		super();
		this.maGiay = maGiay;
		this.giaBan = giaBan;
		this.ghiChu = ghiChu;
		this.chiTietGiay = chiTietGiay;
	}

	public Set<ChiTietGiay> getChiTietGiay() {
		return chiTietGiay;
	}

	public void setChiTietGiay(Set<ChiTietGiay> chiTietGiay) {
		this.chiTietGiay = chiTietGiay;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMaGiay() {
		return maGiay;
	}

	public void setMaGiay(String maGiay) {
		this.maGiay = maGiay;
	}

	public String getTenGiay() {
		return tenGiay;
	}

	public void setTenGiay(String tenGiay) {
		this.tenGiay = tenGiay;
	}

	public String getSoLuongBan() {
		return soLuongBan;
	}

	public void setSoLuongBan(String soLuongBan) {
		this.soLuongBan = soLuongBan;
	}

	public String getGiaBan() {
		return giaBan;
	}

	public void setGiaBan(String giaBan) {
		this.giaBan = giaBan;
	}

	public String getGhiChu() {
		return ghiChu;
	}

	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public boolean isXoaFlag() {
		return xoaFlag;
	}

	public void setXoaFlag(boolean xoaFlag) {
		this.xoaFlag = xoaFlag;
	}

	public Date getNgayXoa() {
		return ngayXoa;
	}

	public void setNgayXoa(Date ngayXoa) {
		this.ngayXoa = ngayXoa;
	}

	public LoaiGiay getLoaiGiay() {
		return loaiGiay;
	}

	public void setLoaiGiay(LoaiGiay loaiGiay) {
		this.loaiGiay = loaiGiay;
	}

	public GioiTinh getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(GioiTinh gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

}
