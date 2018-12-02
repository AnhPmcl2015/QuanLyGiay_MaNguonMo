package com.shoe.dao;

import java.sql.SQLException;
import java.util.List;

import com.shoe.dto.GiayDTO;
import com.shoe.entities.Giay;

public interface GiayDAO {

    public void saveShoe(GiayDTO giay);

    public List<GiayDTO> getAllListNoneDel();

    public boolean deleteShoe(GiayDTO giay);

    public GiayDTO getGiayById(Integer id);
}
