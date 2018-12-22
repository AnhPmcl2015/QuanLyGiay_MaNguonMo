package com.shoe.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ChiTietDonHang.class)
public abstract class ChiTietDonHang_ {

	public static volatile SingularAttribute<ChiTietDonHang, ChiTietGiay> chiTietGiay;
	public static volatile SingularAttribute<ChiTietDonHang, Integer> idChiTietDonHang;
	public static volatile SingularAttribute<ChiTietDonHang, Integer> thanhTien;
	public static volatile SingularAttribute<ChiTietDonHang, DonHang> donHang;
	public static volatile SingularAttribute<ChiTietDonHang, Integer> soLuong;

	public static final String CHI_TIET_GIAY = "chiTietGiay";
	public static final String ID_CHI_TIET_DON_HANG = "idChiTietDonHang";
	public static final String THANH_TIEN = "thanhTien";
	public static final String DON_HANG = "donHang";
	public static final String SO_LUONG = "soLuong";

}

