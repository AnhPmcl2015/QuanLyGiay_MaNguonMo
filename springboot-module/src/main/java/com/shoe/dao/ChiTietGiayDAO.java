package com.shoe.dao;

import java.util.List;

import com.shoe.dto.ChiTietGiayDTO;

public interface ChiTietGiayDAO {
    public List<ChiTietGiayDTO> getAllListNoneDelByIdGiay(Integer id);
    public void saveDetailShoe(ChiTietGiayDTO giay);
    public void updateDetailShoe(ChiTietGiayDTO giay);
    public void deleteDetailShoe(ChiTietGiayDTO giay);


}
