package vn.oceantech.l3pre.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import vn.oceantech.l3pre.entity.SubDistrict;

import java.util.List;

public interface SubDistrictRepo extends JpaRepository<SubDistrict, Integer> {
    @Query(value = "SELECT * FROM sub_district as std WHERE std.district_id=:districtId", nativeQuery = true)
    List<SubDistrict> getByDistrictId(Integer districtId);
}
