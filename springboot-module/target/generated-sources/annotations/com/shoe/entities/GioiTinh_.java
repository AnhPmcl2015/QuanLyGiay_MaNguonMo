package com.shoe.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(GioiTinh.class)
public abstract class GioiTinh_ {

	public static volatile SingularAttribute<GioiTinh, Integer> idGioiTinh;
	public static volatile SingularAttribute<GioiTinh, String> tenGioiTinh;
	public static volatile SetAttribute<GioiTinh, Giay> giays;

	public static final String ID_GIOI_TINH = "idGioiTinh";
	public static final String TEN_GIOI_TINH = "tenGioiTinh";
	public static final String GIAYS = "giays";

}

