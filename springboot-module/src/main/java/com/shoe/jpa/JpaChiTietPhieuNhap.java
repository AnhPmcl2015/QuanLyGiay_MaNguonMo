package com.shoe.jpa;

import com.shoe.entities.ChiTietPhieuNhap;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaChiTietPhieuNhap extends JpaRepository<ChiTietPhieuNhap, Integer> {

}
