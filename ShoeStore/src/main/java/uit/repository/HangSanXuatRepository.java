package uit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import uit.entity.HangSanXuat;

@Repository
public interface HangSanXuatRepository extends JpaRepository<HangSanXuat, Integer> {
	
}
