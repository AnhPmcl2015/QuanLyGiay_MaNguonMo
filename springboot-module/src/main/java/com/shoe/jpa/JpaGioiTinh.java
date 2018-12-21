package com.shoe.jpa;

import com.shoe.entities.GioiTinh;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JpaGioiTinh extends JpaRepository<GioiTinh, Integer> {
    Optional<GioiTinh> findByIdGioiTinh(int id);
}
