package com.shoe.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(KhachHang.class)
public abstract class KhachHang_ {

	public static volatile SingularAttribute<KhachHang, String> diaChi;
	public static volatile SingularAttribute<KhachHang, Integer> soDienThoai;
	public static volatile SingularAttribute<KhachHang, String> tenKhachHang;
	public static volatile SingularAttribute<KhachHang, Integer> idKhachHang;
	public static volatile SingularAttribute<KhachHang, User> user;

	public static final String DIA_CHI = "diaChi";
	public static final String SO_DIEN_THOAI = "soDienThoai";
	public static final String TEN_KHACH_HANG = "tenKhachHang";
	public static final String ID_KHACH_HANG = "idKhachHang";
	public static final String USER = "user";

}

