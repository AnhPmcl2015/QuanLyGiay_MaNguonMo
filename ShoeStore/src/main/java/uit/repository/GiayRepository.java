package uit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import uit.entity.Giay;

@Repository
public interface GiayRepository extends JpaRepository<Giay, Integer>{

}
