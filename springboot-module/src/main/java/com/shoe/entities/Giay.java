package com.shoe.entities;
// Generated Nov 27, 2018 12:36:27 AM by Hibernate Tools 5.1.10.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * Giay generated by hbm2java
 */
@Entity
@Table(name = "giay", catalog = "quanlygiay", uniqueConstraints = @UniqueConstraint(columnNames = "ten_giay"))
public class Giay implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8141491010636065677L;
	private Integer idGiay;
	private GioiTinh gioiTinh;
	private LoaiGiay loaiGiay;
	private String maGiay;
	private String tenGiay;
	private int giaBan;
	private String ghiChu;
	private String img1;
	private String img2;
	private String img3;
	private String img4;
	private int soLuongBan;
	private Boolean xoaFlag;
	private Set<ChiTietGiay> chiTietGiays = new HashSet<ChiTietGiay>(0);

	public Giay() {
	}

	public Giay(Integer idGiay, GioiTinh gioiTinh, LoaiGiay loaiGiay, String tenGiay, int giaBan, int soLuongBan) {
		this.idGiay = idGiay;
		this.gioiTinh = gioiTinh;
		this.loaiGiay = loaiGiay;
		this.tenGiay = tenGiay;
		this.giaBan = giaBan;
		this.soLuongBan = soLuongBan;
	}

	public Giay(Integer idGiay, GioiTinh gioiTinh, LoaiGiay loaiGiay, String tenGiay, int giaBan, String ghiChu,
			String img1, String img2, String img3, String img4, int soLuongBan, Boolean xoaFlag,
			Set<ChiTietGiay> chiTietGiays) {
		this.idGiay = idGiay;
		this.gioiTinh = gioiTinh;
		this.loaiGiay = loaiGiay;
		this.tenGiay = tenGiay;
		this.giaBan = giaBan;
		this.ghiChu = ghiChu;
		this.img1 = img1;
		this.img2 = img2;
		this.img3 = img3;
		this.img4 = img4;
		this.soLuongBan = soLuongBan;
		this.xoaFlag = xoaFlag;
		this.chiTietGiays = chiTietGiays;
	}

	@Id

	@Column(name = "id_giay", unique = true, nullable = false, length = 50)
	public Integer getIdGiay() {
		return this.idGiay;
	}

	public void setIdGiay(Integer idGiay) {
		this.idGiay = idGiay;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_gioi_tinh", nullable = false)
	public GioiTinh getGioiTinh() {
		return this.gioiTinh;
	}

	public void setGioiTinh(GioiTinh gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_loai_giay", nullable = false)
	public LoaiGiay getLoaiGiay() {
		return this.loaiGiay;
	}

	public void setLoaiGiay(LoaiGiay loaiGiay) {
		this.loaiGiay = loaiGiay;
	}

	@Column(name = "ten_giay", nullable = false, length = 100)
	public String getTenGiay() {
		return this.tenGiay;
	}

	public void setTenGiay(String tenGiay) {
		this.tenGiay = tenGiay;
	}

	@Column(name = "gia_ban", nullable = false)
	public int getGiaBan() {
		return this.giaBan;
	}

	public void setGiaBan(int giaBan) {
		this.giaBan = giaBan;
	}

	@Column(name = "ghi_chu", length = 65535)
	public String getGhiChu() {
		return this.ghiChu;
	}

	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}

	@Column(name = "img1", length = 65535)
	public String getImg1() {
		return this.img1;
	}

	public void setImg1(String img1) {
		this.img1 = img1;
	}

	@Column(name = "img2", length = 65535)
	public String getImg2() {
		return this.img2;
	}

	public void setImg2(String img2) {
		this.img2 = img2;
	}

	@Column(name = "img3", length = 65535)
	public String getImg3() {
		return this.img3;
	}

	public void setImg3(String img3) {
		this.img3 = img3;
	}

	@Column(name = "img4", length = 65535)
	public String getImg4() {
		return this.img4;
	}

	public void setImg4(String img4) {
		this.img4 = img4;
	}

	@Column(name = "so_luong_ban", nullable = false)
	public int getSoLuongBan() {
		return this.soLuongBan;
	}

	public void setSoLuongBan(int soLuongBan) {
		this.soLuongBan = soLuongBan;
	}

	@Column(name = "xoa_flag")
	public Boolean getXoaFlag() {
		return this.xoaFlag;
	}

	public void setXoaFlag(Boolean xoaFlag) {
		this.xoaFlag = xoaFlag;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "giay")
	public Set<ChiTietGiay> getChiTietGiays() {
		return this.chiTietGiays;
	}

	public void setChiTietGiays(Set<ChiTietGiay> chiTietGiays) {
		this.chiTietGiays = chiTietGiays;
	}

	@Column(name = "ma_giay", unique = true, nullable = false, length = 255)
	public String getMaGiay() {
		return maGiay;
	}

	public void setMaGiay(String maGiay) {
		this.maGiay = maGiay;
	}
}
