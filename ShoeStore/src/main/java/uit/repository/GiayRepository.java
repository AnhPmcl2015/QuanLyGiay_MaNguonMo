package uit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import uit.entity.Giay;

@Repository
public interface GiayRepository extends JpaRepository<Giay, Integer>{
	
	@Query(value="select * from Giay limit 8", nativeQuery=true)
	List<Giay> findTop8();
	
	@Query(value="select * from Giay order by so_luong_ban DESC limit 8", nativeQuery=true)
	List<Giay> findTopSeller();
	
	@Query(value="SELECT * from Giay giay where giay.id_loai_giay in (\r\n" + 
			"	select loaigiay.id_loai_giay from loai_giay loaigiay\r\n" + 
			"    where loaigiay.id_hang_san_xuat = :id_hang_san_xuat\r\n" + 
			") order by giay.so_luong_ban desc limit 8;", nativeQuery=true)
	List<Giay> findGiayBaseOnIdHangSanXuat(@Param("id_hang_san_xuat") String idHangSanXuat);
}
