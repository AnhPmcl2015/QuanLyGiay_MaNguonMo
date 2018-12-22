package com.shoe.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shoe.entities.KhachHang;

@Repository
public interface JpaKhachHang extends JpaRepository<KhachHang, Integer> {
	public KhachHang findByUserUserId(Long userId);
}
