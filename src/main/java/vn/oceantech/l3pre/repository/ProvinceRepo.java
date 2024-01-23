package vn.oceantech.l3pre.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import vn.oceantech.l3pre.entity.Province;

import java.util.List;

public interface ProvinceRepo extends JpaRepository<Province, Integer> {
    @Query("SELECT p FROM Province p")
    List<Province> getAll();
}
