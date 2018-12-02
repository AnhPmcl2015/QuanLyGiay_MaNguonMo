package uit.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import uit.entity.GioiTinh;

@Repository
public interface GioiTinhRepository extends JpaRepository<GioiTinh, Integer>{
	Optional<GioiTinh> findByIdGioiTinh(int id);
}
