package com.shoe.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(TinhTrangDonHang.class)
public abstract class TinhTrangDonHang_ {

	public static volatile SingularAttribute<TinhTrangDonHang, String> tenTinhTrang;
	public static volatile SingularAttribute<TinhTrangDonHang, Integer> idTinhTrang;
	public static volatile SetAttribute<TinhTrangDonHang, DonHang> donHangs;

	public static final String TEN_TINH_TRANG = "tenTinhTrang";
	public static final String ID_TINH_TRANG = "idTinhTrang";
	public static final String DON_HANGS = "donHangs";

}

