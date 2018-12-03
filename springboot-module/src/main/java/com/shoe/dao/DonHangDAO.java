package com.shoe.dao;

import com.shoe.dto.DonHangDTO;
import com.shoe.entities.DonHang;


public interface DonHangDAO {
	public DonHangDTO getDonHangById(int id);
    public void add(DonHang donHang);
    public void update(DonHang donHang);
}
