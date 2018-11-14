package com.shoe.entities;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * LoaiGiay generated by hbm2java
 */
@Entity
@Table(name = "loai_giay", catalog = "quanlygiay")
public class LoaiGiay implements java.io.Serializable {

    private static final long serialVersionUID = -3999940744724630064L;
    private Integer idLoaiGiay;
    private HangSanXuat hangSanXuat;
    private String maLoaiGiay;
    private String tenLoaiGiay;
    private Set<Giay> giays = new HashSet<Giay>(0);
    
    public LoaiGiay() {
    }

    public LoaiGiay(HangSanXuat hangSanXuat, String tenLoaiGiay) {
        this.hangSanXuat = hangSanXuat;
        this.tenLoaiGiay = tenLoaiGiay;
    }

    public LoaiGiay(HangSanXuat hangSanXuat, String maLoaiGiay, String tenLoaiGiay, Set<Giay> giays) {
        this.hangSanXuat = hangSanXuat;
        this.maLoaiGiay = maLoaiGiay;
        this.tenLoaiGiay = tenLoaiGiay;
        this.giays = giays;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id_loai_giay", unique = true, nullable = false)
    public Integer getIdLoaiGiay() {
        return this.idLoaiGiay;
    }

    public void setIdLoaiGiay(Integer idLoaiGiay) {
        this.idLoaiGiay = idLoaiGiay;
    }

    @ManyToOne
    @JoinColumn(name = "id_hang_san_xuat", nullable = false)
    public HangSanXuat getHangSanXuat() {
        return this.hangSanXuat;
    }

    public void setHangSanXuat(HangSanXuat hangSanXuat) {
        this.hangSanXuat = hangSanXuat;
    }

    @Column(name = "ma_loai_giay", length = 50)
    public String getMaLoaiGiay() {
        return this.maLoaiGiay;
    }

    public void setMaLoaiGiay(String maLoaiGiay) {
        this.maLoaiGiay = maLoaiGiay;
    }

    @Column(name = "ten_loai_giay", nullable = false, length = 50)
    public String getTenLoaiGiay() {
        return this.tenLoaiGiay;
    }

    public void setTenLoaiGiay(String tenLoaiGiay) {
        this.tenLoaiGiay = tenLoaiGiay;
    }

    @OneToMany(mappedBy = "loaiGiay")
    public Set<Giay> getGiays() {
        return this.giays;
    }

    public void setGiays(Set<Giay> giays) {
        this.giays = giays;
    }

}
