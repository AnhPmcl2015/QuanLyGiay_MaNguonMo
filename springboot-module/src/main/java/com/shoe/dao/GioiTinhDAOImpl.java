package com.shoe.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import com.shoe.jpa.JpaGioiTinh;
import com.shoe.dto.GioiTinhDTO;
import com.shoe.entities.GioiTinh;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class GioiTinhDAOImpl implements GioiTinhDAO{

    @Autowired
    private JpaGioiTinh jpa;

    @Autowired
    private EntityManager em;

    @Override
	public List<GioiTinhDTO> getList(){

        List<GioiTinh> listGender = jpa.findAll();
        List<GioiTinhDTO> listGenderDto = new ArrayList<>();
        listGender.forEach(i->{
            GioiTinhDTO dto = new GioiTinhDTO(i.getIdGioiTinh(),i.getTenGioiTinh());
            listGenderDto.add(dto);
        });
        return listGenderDto;
    }
}
