package com.shoe.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(LoaiGiay.class)
public abstract class LoaiGiay_ {

	public static volatile SetAttribute<LoaiGiay, Giay> giays;
	public static volatile SingularAttribute<LoaiGiay, Integer> idLoaiGiay;
	public static volatile SingularAttribute<LoaiGiay, Boolean> xoaFlag;
	public static volatile SingularAttribute<LoaiGiay, String> tenLoaiGiay;
	public static volatile SingularAttribute<LoaiGiay, HangSanXuat> hangSanXuat;

	public static final String GIAYS = "giays";
	public static final String ID_LOAI_GIAY = "idLoaiGiay";
	public static final String XOA_FLAG = "xoaFlag";
	public static final String TEN_LOAI_GIAY = "tenLoaiGiay";
	public static final String HANG_SAN_XUAT = "hangSanXuat";

}

