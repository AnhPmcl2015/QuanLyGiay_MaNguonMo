package com.shoe.jpa;

import com.shoe.entities.HangSanXuat;
import com.shoe.entities.LoaiGiay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JpaLoaiGiay extends JpaRepository<LoaiGiay, Integer> {
    List<LoaiGiay> findByHangSanXuat(HangSanXuat hangSanXuat);
}
