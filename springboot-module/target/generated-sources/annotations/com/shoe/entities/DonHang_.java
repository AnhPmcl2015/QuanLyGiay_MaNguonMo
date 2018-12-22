package com.shoe.entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(DonHang.class)
public abstract class DonHang_ {

	public static volatile SingularAttribute<DonHang, Integer> idDonHang;
	public static volatile SetAttribute<DonHang, ChiTietDonHang> chiTietDonHangs;
	public static volatile SingularAttribute<DonHang, Date> ngayGiao;
	public static volatile SingularAttribute<DonHang, Integer> tongTien;
	public static volatile SingularAttribute<DonHang, KhachHang> khachHang;
	public static volatile SingularAttribute<DonHang, Date> ngayDat;
	public static volatile SingularAttribute<DonHang, TinhTrangDonHang> tinhTrangDonHang;

	public static final String ID_DON_HANG = "idDonHang";
	public static final String CHI_TIET_DON_HANGS = "chiTietDonHangs";
	public static final String NGAY_GIAO = "ngayGiao";
	public static final String TONG_TIEN = "tongTien";
	public static final String KHACH_HANG = "khachHang";
	public static final String NGAY_DAT = "ngayDat";
	public static final String TINH_TRANG_DON_HANG = "tinhTrangDonHang";

}

