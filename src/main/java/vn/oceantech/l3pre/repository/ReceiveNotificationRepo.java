package vn.oceantech.l3pre.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import vn.oceantech.l3pre.entity.ReceiveNotification;

import java.util.List;

public interface ReceiveNotificationRepo extends JpaRepository<ReceiveNotification, Integer> {
    @Query("SELECT r FROM ReceiveNotification r")
    List<ReceiveNotification> getAll();
}
