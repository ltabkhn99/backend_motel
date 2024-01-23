package vn.oceantech.l3pre.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import vn.oceantech.l3pre.entity.MotelRoom;

import java.util.List;

public interface MotelRoomRepo extends JpaRepository<MotelRoom, Integer> {
    @Query("SELECT m FROM MotelRoom m")
    List<MotelRoom> getAll();
}
