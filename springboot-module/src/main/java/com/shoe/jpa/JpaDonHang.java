package com.shoe.jpa;

import com.shoe.entities.DonHang;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaDonHang extends JpaRepository<DonHang, Integer> {

}
