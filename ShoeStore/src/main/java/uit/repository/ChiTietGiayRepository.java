package uit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import uit.entity.ChiTietGiay;

@Repository
public interface ChiTietGiayRepository extends JpaRepository<ChiTietGiay, Integer>{

}
