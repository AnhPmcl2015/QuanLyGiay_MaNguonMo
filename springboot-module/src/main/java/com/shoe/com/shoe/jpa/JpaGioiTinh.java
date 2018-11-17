package com.shoe.com.shoe.jpa;

import com.shoe.entities.GioiTinh;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaGioiTinh extends JpaRepository<GioiTinh, Integer> {
}
