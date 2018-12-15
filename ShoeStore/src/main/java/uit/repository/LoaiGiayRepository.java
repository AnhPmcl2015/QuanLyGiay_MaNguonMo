package uit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import uit.entity.HangSanXuat;
import uit.entity.LoaiGiay;

@Repository
public interface LoaiGiayRepository extends JpaRepository<LoaiGiay, Integer> {
	List<LoaiGiay> findByHangSanXuat(HangSanXuat hangSanXuat);
}
