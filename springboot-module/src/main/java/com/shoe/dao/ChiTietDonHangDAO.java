package com.shoe.dao;

import java.util.List;

import com.shoe.dto.ChiTietDonHangDTO;
import com.shoe.entities.ChiTietDonHang;


public interface ChiTietDonHangDAO {
	public List<ChiTietDonHangDTO> getChiTietDonHangsByIdDonHang(int idDonHang);
    public void add(ChiTietDonHang chiTietDonHang);
    public void update(ChiTietDonHang chiTietDonHang);
    
}
