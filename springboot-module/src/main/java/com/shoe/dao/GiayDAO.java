package com.shoe.dao;

import java.sql.SQLException;
import java.util.List;

import com.shoe.entities.Giay;


public interface GiayDAO {
    public List<Giay> getList();
    public int addShoe(Giay giay);
}
