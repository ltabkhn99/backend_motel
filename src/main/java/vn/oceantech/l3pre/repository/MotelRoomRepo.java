package vn.oceantech.l3pre.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import vn.oceantech.l3pre.entity.MotelRoom;

import java.util.List;

public interface MotelRoomRepo extends JpaRepository<MotelRoom, Integer> {
    @Query("SELECT m FROM MotelRoom m")
    List<MotelRoom> getAll();

    @Query(value = "SELECT * FROM motel_room as m WHERE m.name LIKE CONCAT('%',:name,'%')", nativeQuery = true)
    List<MotelRoom> searchByName(String name);

    @Query(value = "SELECT * FROM motel_room as m " +
            " WHERE (:proId is null or m.province_id = :proId)" +
            " AND (:dtId is null or m.district_id = :dtId) " +
            " AND (:subId is null or m.sub_district_id = :subId) ", nativeQuery = true)
    List<MotelRoom> searchByLocation(Integer proId, Integer dtId, Integer subId);
}
