package com.shoe.dao;

import com.shoe.dto.HangSanXuatSelectDTO;
import com.shoe.dto.LoaiGiaySelectDTO;
import com.shoe.jpa.JpaHangSanXuat;
import com.shoe.converter.HangSanXuatConverter;
import com.shoe.dto.HangSanXuatDTO;
import org.modelmapper.ModelMapper;
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
        jpa.findAll().forEach(i -> {
            if(!i.getXoaFlag()) {
                HangSanXuatDTO hsx = new HangSanXuatDTO();
                converter.convertEntityToDto(i, hsx);
                list.add(hsx);
            }
        });
        return list;
    }

    public List<HangSanXuatSelectDTO> getAllList() {
        List<HangSanXuatSelectDTO> list = new ArrayList<>();

        jpa.findAll().forEach(i -> {
            if(!i.getXoaFlag()) {
                HangSanXuatSelectDTO dto = new HangSanXuatSelectDTO();
                List<LoaiGiaySelectDTO> loaigiayList = new ArrayList<>();
                dto.setTenHangSanXuat(i.getTenHangSanXuat());
                i.getLoaiGiays().forEach(j -> {
                    j.setHangSanXuat(i);
                    LoaiGiaySelectDTO loaiGiayDto = new LoaiGiaySelectDTO();
                    loaiGiayDto.setIdLoaiGiay(j.getIdLoaiGiay());
                    loaiGiayDto.setTenLoaiGiay(j.getTenLoaiGiay());
                    loaigiayList.add(loaiGiayDto);
                });
                dto.setLoaiGiays(loaigiayList);
                list.add(dto);
            }
        });
        return list;
    }
}
