package com.shoe.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Giay.class)
public abstract class Giay_ {

	public static volatile SingularAttribute<Giay, String> img4;
	public static volatile SingularAttribute<Giay, String> img3;
	public static volatile SingularAttribute<Giay, String> ghiChu;
	public static volatile SingularAttribute<Giay, LoaiGiay> loaiGiay;
	public static volatile SingularAttribute<Giay, Integer> giaBan;
	public static volatile SingularAttribute<Giay, Integer> soLuongBan;
	public static volatile SingularAttribute<Giay, GioiTinh> gioiTinh;
	public static volatile SingularAttribute<Giay, String> tenGiay;
	public static volatile SingularAttribute<Giay, String> maGiay;
	public static volatile SingularAttribute<Giay, Boolean> xoaFlag;
	public static volatile SingularAttribute<Giay, Integer> idGiay;
	public static volatile SetAttribute<Giay, ChiTietGiay> chiTietGiays;
	public static volatile SingularAttribute<Giay, String> img2;
	public static volatile SingularAttribute<Giay, String> img1;

	public static final String IMG4 = "img4";
	public static final String IMG3 = "img3";
	public static final String GHI_CHU = "ghiChu";
	public static final String LOAI_GIAY = "loaiGiay";
	public static final String GIA_BAN = "giaBan";
	public static final String SO_LUONG_BAN = "soLuongBan";
	public static final String GIOI_TINH = "gioiTinh";
	public static final String TEN_GIAY = "tenGiay";
	public static final String MA_GIAY = "maGiay";
	public static final String XOA_FLAG = "xoaFlag";
	public static final String ID_GIAY = "idGiay";
	public static final String CHI_TIET_GIAYS = "chiTietGiays";
	public static final String IMG2 = "img2";
	public static final String IMG1 = "img1";

}

