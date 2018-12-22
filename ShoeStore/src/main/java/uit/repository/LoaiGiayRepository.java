package uit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


import uit.entity.HangSanXuat;
import uit.entity.LoaiGiay;

@Repository
public interface LoaiGiayRepository extends JpaRepository<LoaiGiay, Integer> {
	List<LoaiGiay> findByHangSanXuat(HangSanXuat hangSanXuat);
}
