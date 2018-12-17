package com.shoe.dao;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.shoe.converter.DonHangConverter;
import com.shoe.dto.DonHangDTO;
import com.shoe.entities.DonHang;
import com.shoe.entities.TinhTrangDonHang;
import com.shoe.jpa.JpaDonHang;

@Repository
@Transactional
public class DonHangDAOImpl implements DonHangDAO {
	
//	@Autowired
//    private EntityManager entityManager;

	@Autowired
    private JpaDonHang jpaDonHang;
	
	@Autowired
    DonHangConverter donHangConverter;
	
	@Override
	public DonHangDTO getDonHangById(int id) {
		Optional<DonHang> donHangOptional = jpaDonHang.findById(id);
		DonHang donHang = new DonHang();
		if (donHangOptional.isPresent())
			donHang = donHangOptional.get();
		else 
			return null;
		DonHangDTO donHangDTO = new DonHangDTO();
		donHangConverter.convertEntityToDto(donHang, donHangDTO);
		return donHangDTO;
	}

	@Override
	public void add(DonHang donHang) {

	}

	@Override
	public void updateStatus(int id, int stt) {
		Optional<DonHang> donHangOptional = jpaDonHang.findById(id);
		if (donHangOptional.isPresent()) {
			TinhTrangDonHang tinhTrang = new TinhTrangDonHang();
			tinhTrang.setIdTinhTrang(stt);
			DonHang donhang= donHangOptional.get();
			donhang.setTinhTrangDonHang(tinhTrang);
		}
	}

}
