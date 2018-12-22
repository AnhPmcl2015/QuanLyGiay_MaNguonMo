package com.shoe.entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(PhieuNhap.class)
public abstract class PhieuNhap_ {

	public static volatile SingularAttribute<PhieuNhap, Integer> tongSoLuong;
	public static volatile SetAttribute<PhieuNhap, ChiTietPhieuNhap> chiTietPhieuNhaps;
	public static volatile SingularAttribute<PhieuNhap, Integer> idPhieuNhap;
	public static volatile SingularAttribute<PhieuNhap, Date> ngayNhap;
	public static volatile SingularAttribute<PhieuNhap, HangSanXuat> hangSanXuat;

	public static final String TONG_SO_LUONG = "tongSoLuong";
	public static final String CHI_TIET_PHIEU_NHAPS = "chiTietPhieuNhaps";
	public static final String ID_PHIEU_NHAP = "idPhieuNhap";
	public static final String NGAY_NHAP = "ngayNhap";
	public static final String HANG_SAN_XUAT = "hangSanXuat";

}

