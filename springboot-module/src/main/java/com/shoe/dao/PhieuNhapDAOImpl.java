package com.shoe.dao;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.shoe.converter.ChiTietPhieuNhapConverter;
import com.shoe.converter.PhieuNhapConverter;
import com.shoe.dto.ChiTietPhieuNhapDTO;
import com.shoe.dto.PhieuNhapDTO;
import com.shoe.entities.ChiTietGiay;
import com.shoe.entities.ChiTietPhieuNhap;
import com.shoe.entities.PhieuNhap;
import com.shoe.jpa.JpaChiTietGiay;
import com.shoe.jpa.JpaChiTietPhieuNhap;
import com.shoe.jpa.JpaPhieuNhap;

@Repository
@Transactional
public class PhieuNhapDAOImpl implements PhieuNhapDAO {

	@Autowired
	private PhieuNhapConverter PhieuNhapEco;
	
	@Autowired
	private ChiTietPhieuNhapConverter ChiTietPhieuNhapEco;
	
	@Autowired
	private JpaChiTietGiay jpaChiTietGiay;
	
	@Autowired
	private JpaPhieuNhap jpaPhieuNhap;

	@Autowired
	private JpaChiTietPhieuNhap jpaChiTietPhieuNhap;
	
	@Override
	public void add(PhieuNhapDTO phieuNhapDTO, List<ChiTietPhieuNhapDTO> listCtpn) {
		// TODO Auto-generated method stub
		PhieuNhap phieuNhap = new PhieuNhap();
		PhieuNhapEco.convertDtoToEntity(phieuNhapDTO, phieuNhap);
		jpaPhieuNhap.save(phieuNhap);
		listCtpn.forEach(ctpnDTO ->{
			ChiTietPhieuNhap CTPN = new ChiTietPhieuNhap();
			ChiTietPhieuNhapEco.convertDtoToEntity(ctpnDTO, CTPN);
			CTPN.setPhieuNhap(phieuNhap);
			jpaChiTietPhieuNhap.save(CTPN);
			updateShoe(CTPN);
		});
	}
	
	private void updateShoe(ChiTietPhieuNhap ctpn) {
		Optional<ChiTietGiay> optional = jpaChiTietGiay.findById(ctpn.getChiTietGiay().getIdChiTietGiay());
		if (optional.isPresent()) {
			ChiTietGiay ctg = new ChiTietGiay();
			ctg = optional.get();
			int oldAmount = ctg.getSoLuong();
			ctg.setSoLuong(oldAmount + ctpn.getSoLuong());
			jpaChiTietGiay.save(ctg);
		}
	}

}
