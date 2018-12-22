package com.shoe.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(HangSanXuat.class)
public abstract class HangSanXuat_ {

	public static volatile SingularAttribute<HangSanXuat, String> tenHangSanXuat;
	public static volatile SingularAttribute<HangSanXuat, Boolean> xoaFlag;
	public static volatile SetAttribute<HangSanXuat, LoaiGiay> loaiGiays;
	public static volatile SetAttribute<HangSanXuat, PhieuNhap> phieuNhaps;
	public static volatile SingularAttribute<HangSanXuat, Integer> idHangSanXuat;

	public static final String TEN_HANG_SAN_XUAT = "tenHangSanXuat";
	public static final String XOA_FLAG = "xoaFlag";
	public static final String LOAI_GIAYS = "loaiGiays";
	public static final String PHIEU_NHAPS = "phieuNhaps";
	public static final String ID_HANG_SAN_XUAT = "idHangSanXuat";

}

