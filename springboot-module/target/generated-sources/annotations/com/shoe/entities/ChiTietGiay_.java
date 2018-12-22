package com.shoe.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ChiTietGiay.class)
public abstract class ChiTietGiay_ {

	public static volatile SetAttribute<ChiTietGiay, ChiTietPhieuNhap> chiTietPhieuNhaps;
	public static volatile SingularAttribute<ChiTietGiay, Integer> idChiTietGiay;
	public static volatile SingularAttribute<ChiTietGiay, Integer> size;
	public static volatile SetAttribute<ChiTietGiay, ChiTietDonHang> chiTietDonHangs;
	public static volatile SingularAttribute<ChiTietGiay, Boolean> xoaFlag;
	public static volatile SingularAttribute<ChiTietGiay, Giay> giay;
	public static volatile SingularAttribute<ChiTietGiay, Integer> soLuong;

	public static final String CHI_TIET_PHIEU_NHAPS = "chiTietPhieuNhaps";
	public static final String ID_CHI_TIET_GIAY = "idChiTietGiay";
	public static final String SIZE = "size";
	public static final String CHI_TIET_DON_HANGS = "chiTietDonHangs";
	public static final String XOA_FLAG = "xoaFlag";
	public static final String GIAY = "giay";
	public static final String SO_LUONG = "soLuong";

}

