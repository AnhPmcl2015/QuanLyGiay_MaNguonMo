package com.shoe.dao;

import com.shoe.converter.HangSanXuatConverter;
import com.shoe.dto.HangSanXuatDTO;
import com.shoe.entities.GioiTinh;
import com.shoe.entities.HangSanXuat;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class HangSanXuatDAOImpl implements HangSanXuatDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private HangSanXuatConverter converter;

    public List<HangSanXuatDTO> getHangSanXuat() {

        Session session = sessionFactory.getCurrentSession();
        Criteria crit = session.createCriteria(HangSanXuat.class);
        List<HangSanXuatDTO> list_hang_san_xuat = new ArrayList<>();
        List<HangSanXuat> list = (List<HangSanXuat>) crit.list();
        list.forEach(i -> {
            HangSanXuatDTO dto = new HangSanXuatDTO();
            converter.convertEntityToDto(i, dto);
            list_hang_san_xuat.add(dto);
        });
        return list_hang_san_xuat;
    }
}
