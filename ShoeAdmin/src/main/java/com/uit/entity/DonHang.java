package com.uit.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="don_hang", catalog="quanlygiay")
public class DonHang {
	
	@Id
	@GeneratedValue
	@Column(name="id", nullable=false, unique=true)
	private int id;
	
	@Column(name="ma_don_hang", nullable=false, unique=true)
	private String maDonHang;
	
	@Column(name="ngay_dat", nullable=false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date ngayDat;
	
	@Column(name="ngay_giao", nullable=false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date ngayGiao;
	
	@Column(name="tong_tien", nullable=false)
	private long tongTien = 0l;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="donHang", cascade=CascadeType.ALL)
	private Set<ChiTietDonHang> listChiTietDonHang;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "id_tinh_trang_don_hang", nullable = false)
	private TinhTrangDonHang tinhTrangDonHang;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "ma_khach_hang", nullable = false)
	private KhachHang khachHang;

	public DonHang() {
		super();
	}

	public DonHang(String maDonHang, Date ngayDat, Date ngayGiao, long tongTien, Set<ChiTietDonHang> listChiTietDonHang,
			TinhTrangDonHang tinhTrangDonHang, KhachHang khachHang) {
		super();
		this.maDonHang = maDonHang;
		this.ngayDat = ngayDat;
		this.ngayGiao = ngayGiao;
		this.tongTien = tongTien;
		this.listChiTietDonHang = listChiTietDonHang;
		this.tinhTrangDonHang = tinhTrangDonHang;
		this.khachHang = khachHang;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMaDonHang() {
		return maDonHang;
	}

	public void setMaDonHang(String maDonHang) {
		this.maDonHang = maDonHang;
	}

	public Date getNgayDat() {
		return ngayDat;
	}

	public void setNgayDat(Date ngayDat) {
		this.ngayDat = ngayDat;
	}

	public Date getNgayGiao() {
		return ngayGiao;
	}

	public void setNgayGiao(Date ngayGiao) {
		this.ngayGiao = ngayGiao;
	}

	public long getTongTien() {
		return tongTien;
	}

	public void setTongTien(long tongTien) {
		this.tongTien = tongTien;
	}

	public Set<ChiTietDonHang> getListChiTietDonHang() {
		return listChiTietDonHang;
	}

	public void setListChiTietDonHang(Set<ChiTietDonHang> listChiTietDonHang) {
		this.listChiTietDonHang = listChiTietDonHang;
	}

	public TinhTrangDonHang getTinhTrangDonHang() {
		return tinhTrangDonHang;
	}

	public void setTinhTrangDonHang(TinhTrangDonHang tinhTrangDonHang) {
		this.tinhTrangDonHang = tinhTrangDonHang;
	}

	public KhachHang getKhachHang() {
		return khachHang;
	}

	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}

}
