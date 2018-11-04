package com.shoe.entities;
// Generated Oct 28, 2018 6:49:43 PM by Hibernate Tools 5.1.10.Final

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * ChiTietGiay generated by hbm2java
 */
@Entity
@Table(name = "chi_tiet_giay", catalog = "quanlygiay")
public class ChiTietGiay implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8956801492963305768L;
	private int idChiTietGiay;
	private Giay giay;
	private int size;
	private int soLuong;
	private Date deleteYmd;

	public ChiTietGiay() {
	}

	public ChiTietGiay(int idChiTietGiay, Giay giay, int size, int soLuong) {
		this.idChiTietGiay = idChiTietGiay;
		this.giay = giay;
		this.size = size;
		this.soLuong = soLuong;
	}

	public ChiTietGiay(int idChiTietGiay, Giay giay, int size, int soLuong, Date deleteYmd) {
		this.idChiTietGiay = idChiTietGiay;
		this.giay = giay;
		this.size = size;
		this.soLuong = soLuong;
		this.deleteYmd = deleteYmd;
	}

	@Id
	@Column(name = "id_chi_tiet_giay", unique = true, nullable = false)
	public int getIdChiTietGiay() {
		return this.idChiTietGiay;
	}

	public void setIdChiTietGiay(int idChiTietGiay) {
		this.idChiTietGiay = idChiTietGiay;
	}

	@ManyToOne
	@JoinColumn(name = "id_giay", nullable = false)
	public Giay getGiay() {
		return this.giay;
	}

	public void setGiay(Giay giay) {
		this.giay = giay;
	}

	@Column(name = "size", nullable = false)
	public int getSize() {
		return this.size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	@Column(name = "so_luong", nullable = false)
	public int getSoLuong() {
		return this.soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "delete_ymd", length = 26)
	public Date getDeleteYmd() {
		return this.deleteYmd;
	}

	public void setDeleteYmd(Date deleteYmd) {
		this.deleteYmd = deleteYmd;
	}

}
