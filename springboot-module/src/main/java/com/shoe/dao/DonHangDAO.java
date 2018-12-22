package com.shoe.dao;

import com.shoe.dto.DonHangDTO;


public interface DonHangDAO {
	public DonHangDTO getDonHangById(int id);
    public void updateStatus(int id, int stt);
    public int save(DonHangDTO donHangDTO);
}
