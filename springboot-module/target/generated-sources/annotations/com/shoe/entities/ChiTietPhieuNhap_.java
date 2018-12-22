package com.shoe.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ChiTietPhieuNhap.class)
public abstract class ChiTietPhieuNhap_ {

	public static volatile SingularAttribute<ChiTietPhieuNhap, Integer> idChiTietPhieuNhap;
	public static volatile SingularAttribute<ChiTietPhieuNhap, PhieuNhap> phieuNhap;
	public static volatile SingularAttribute<ChiTietPhieuNhap, ChiTietGiay> chiTietGiay;
	public static volatile SingularAttribute<ChiTietPhieuNhap, Integer> giaVon;
	public static volatile SingularAttribute<ChiTietPhieuNhap, Integer> soLuong;

	public static final String ID_CHI_TIET_PHIEU_NHAP = "idChiTietPhieuNhap";
	public static final String PHIEU_NHAP = "phieuNhap";
	public static final String CHI_TIET_GIAY = "chiTietGiay";
	public static final String GIA_VON = "giaVon";
	public static final String SO_LUONG = "soLuong";

}

