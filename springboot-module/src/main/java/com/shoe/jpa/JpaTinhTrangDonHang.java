package com.shoe.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shoe.entities.TinhTrangDonHang;

@Repository
public interface JpaTinhTrangDonHang extends JpaRepository<TinhTrangDonHang, Integer> {

}
