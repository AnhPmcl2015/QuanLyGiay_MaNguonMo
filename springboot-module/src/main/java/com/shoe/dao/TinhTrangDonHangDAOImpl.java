package com.shoe.dao;

import java.util.List;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.shoe.converter.DonHangConverter;
import com.shoe.entities.TinhTrangDonHang;
import com.shoe.jpa.JpaTinhTrangDonHang;

@Repository
@Transactional
public class TinhTrangDonHangDAOImpl implements TinhTrangDonHangDAO {

	@Autowired
	private JpaTinhTrangDonHang jpaTinhTrangDonHang;

	@Autowired
	DonHangConverter donHangConverter;

	@Override
	public List<TinhTrangDonHang> getListStatus() {
		return jpaTinhTrangDonHang.findAll();
	}
}
