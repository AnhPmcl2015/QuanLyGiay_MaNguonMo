package com.shoe.dao;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.shoe.converter.KhachHangConverter;
import com.shoe.dto.KhachHangDTO;
import com.shoe.entities.KhachHang;
import com.shoe.jpa.JpaKhachHang;

@Repository
@Transactional
public class KhachHangDAOImpl implements KhachHangDAO {

	@Autowired
	private JpaKhachHang jpaKhachHang;

	@Autowired
	KhachHangConverter khachHangEco;

	@Override
	public KhachHangDTO getKhachHangByUser(Long idUser) {
		KhachHang khachHang = new KhachHang();
		KhachHangDTO khachHangdto = new KhachHangDTO();
		khachHang = jpaKhachHang.findByUserUserId(idUser);
		khachHangEco.convertEntityToDto(khachHang, khachHangdto);
		return khachHangdto;
	}

}