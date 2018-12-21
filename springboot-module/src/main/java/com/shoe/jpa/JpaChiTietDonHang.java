package com.shoe.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shoe.entities.ChiTietDonHang;

@Repository
public interface JpaChiTietDonHang extends JpaRepository<ChiTietDonHang, Integer> {

}
