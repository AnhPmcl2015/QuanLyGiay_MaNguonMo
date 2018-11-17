package com.shoe.dao;

import com.shoe.dto.ChiTietGiayDTO;
import com.shoe.entities.ChiTietGiay;

import java.util.List;

public interface ChiTietGiayDAO {
    public List<ChiTietGiayDTO> getAllListNoneDel();
    public void addDetailShoe(ChiTietGiayDTO giay);
    public void updateDetailShoe(ChiTietGiayDTO giay);
    public void deleteDetailShoe(ChiTietGiayDTO giay);
}
