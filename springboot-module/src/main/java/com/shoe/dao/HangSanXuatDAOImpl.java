package com.shoe.dao;

import com.shoe.com.shoe.jpa.JpaHangSanXuat;
import com.shoe.converter.HangSanXuatConverter;
import com.shoe.dto.HangSanXuatDTO;
import com.shoe.entities.GioiTinh;
import com.shoe.entities.HangSanXuat;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class HangSanXuatDAOImpl implements HangSanXuatDAO {

    @Autowired
    private HangSanXuatConverter converter;

    @Autowired
    private EntityManager em;

    @Autowired
    private JpaHangSanXuat jpa;

    public List<HangSanXuatDTO> getHangSanXuat() {

        List<HangSanXuatDTO> list = new ArrayList<>();
        jpa.findAll().forEach(i->{
            HangSanXuatDTO hsx = new HangSanXuatDTO();
            converter.convertEntityToDto(i,hsx);
            list.add(hsx);
        });
        return list;
    }
}
