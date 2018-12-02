package uit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import uit.entity.LoaiGiay;

@Repository
public interface LoaiGiayRepository extends JpaRepository<LoaiGiay, Integer> {

}
