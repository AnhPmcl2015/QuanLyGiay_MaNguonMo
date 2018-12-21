package com.shoe.dao;

import java.util.List;

import com.shoe.dto.ChiTietPhieuNhapDTO;
import com.shoe.dto.PhieuNhapDTO;

public interface PhieuNhapDAO {
	public void add(PhieuNhapDTO phieuNhapDTO, List<ChiTietPhieuNhapDTO> list);
}
