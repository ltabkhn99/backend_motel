package vn.oceantech.l3pre.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import vn.oceantech.l3pre.entity.District;

import java.util.List;

public interface DistrictRepo extends JpaRepository<District, Integer> {
    @Query(value = "SELECT * FROM district as d WHERE d.province_id=:provinceId", nativeQuery = true)
    List<District> getByProvinceId(Integer provinceId);
}
