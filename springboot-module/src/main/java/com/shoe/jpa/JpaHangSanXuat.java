package com.shoe.jpa;

import com.shoe.entities.LoaiGiay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shoe.entities.HangSanXuat;

import java.util.List;

@Repository
public interface JpaHangSanXuat extends JpaRepository<HangSanXuat, Integer> {

}
