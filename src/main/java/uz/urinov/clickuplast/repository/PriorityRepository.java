package uz.urinov.clickuplast.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.urinov.clickuplast.entity.Priority;

@Repository
public interface PriorityRepository extends JpaRepository<Priority, Long> {

    boolean existsByName(String name);
}