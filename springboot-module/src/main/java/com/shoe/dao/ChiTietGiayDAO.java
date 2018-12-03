package com.shoe.dao;

import java.util.List;

import com.shoe.dto.ChiTietGiayDTO;

public interface ChiTietGiayDAO {
    public List<ChiTietGiayDTO> getAllListNoneDel();
    public void addDetailShoe(ChiTietGiayDTO giay);
    public void updateDetailShoe(ChiTietGiayDTO giay);
    public void deleteDetailShoe(ChiTietGiayDTO giay);
}
