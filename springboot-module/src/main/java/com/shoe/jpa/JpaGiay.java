package com.shoe.jpa;

import com.shoe.entities.Giay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JpaGiay extends JpaRepository<Giay, Integer> {

}
