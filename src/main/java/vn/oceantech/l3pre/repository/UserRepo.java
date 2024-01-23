package vn.oceantech.l3pre.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import vn.oceantech.l3pre.entity.User;

import java.util.List;

public interface UserRepo extends JpaRepository<User, Integer> {
    @Query("SELECT u FROM User as u WHERE u.username = :userName")
    User getByUsername(String userName);

    @Query("SELECT u FROM User as u")
    List<User> getAll();
}
