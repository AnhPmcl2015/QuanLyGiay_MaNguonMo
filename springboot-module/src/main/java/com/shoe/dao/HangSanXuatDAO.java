package com.shoe.dao;

import com.shoe.dto.HangSanXuatDTO;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface HangSanXuatDAO {

    public List<HangSanXuatDTO> getHangSanXuat();
}
