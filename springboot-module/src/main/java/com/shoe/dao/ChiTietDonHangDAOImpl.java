package com.shoe.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.shoe.converter.ChiTietDonHangConverter;
import com.shoe.converter.DonHangConverter;
import com.shoe.dto.ChiTietDonHangDTO;
import com.shoe.entities.ChiTietDonHang;
import com.shoe.entities.DonHang;
import com.shoe.jpa.JpaDonHang;

@Repository
@Transactional
public class ChiTietDonHangDAOImpl implements ChiTietDonHangDAO {
	
//	@Autowired
//    private EntityManager entityManager;
	
	@Autowired
    private JpaDonHang jpaDonHang;
    
	@Autowired
    ChiTietDonHangConverter chiTietDonHangEco;
	
	@Autowired
    DonHangConverter donHangEco;
	
	@Override
	public List<ChiTietDonHangDTO> getChiTietDonHangsByIdDonHang(int idDonHang) {
		Optional<DonHang> donHangOptional = jpaDonHang.findById(idDonHang);
		DonHang donHang = new DonHang();
		
		if (donHangOptional.isPresent())
			donHang = donHangOptional.get();
		else 
			return null;
		
		List<ChiTietDonHang> listChiTietDonHang = new ArrayList<>();
		List<ChiTietDonHangDTO> listChiTietDonHangDTO = new ArrayList<>();
		
		// listChiTietDonHang = donHang.getChiTietDonHangs();
		
		listChiTietDonHang.forEach(ctdh ->{
        	ChiTietDonHangDTO chiTietDonHangDTO = new ChiTietDonHangDTO();
        	chiTietDonHangEco.convertEntityToDto(ctdh, chiTietDonHangDTO);
        	listChiTietDonHangDTO.add(chiTietDonHangDTO);
		});
		
		return listChiTietDonHangDTO;
	}
	

	@Override
	public void add(ChiTietDonHang chiTietDonHang) {
		
	}

	@Override
	public void update(ChiTietDonHang chiTietDonHang) {
		
	}

}
