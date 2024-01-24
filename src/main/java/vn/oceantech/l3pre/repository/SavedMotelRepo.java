package vn.oceantech.l3pre.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.oceantech.l3pre.entity.SavedMotel;

public interface SavedMotelRepo extends JpaRepository<SavedMotel, Integer> {
}
