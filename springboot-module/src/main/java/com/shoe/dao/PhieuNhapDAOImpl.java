package com.shoe.dao;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;
import com.shoe.dto.PhieuNhapDTO;

@Repository
@Transactional
public class PhieuNhapDAOImpl implements PhieuNhapDAO {

//	@Autowired
//	private PhieuNhapConverter eco;
	
	@Override
	public void add(PhieuNhapDTO phieuNhapDto) {
		
		//jpaPhieuNhap.save(phieuNhapDto);
	}

}
