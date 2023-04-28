package uz.urinov.clickuplast.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.urinov.clickuplast.entity.TaskTag;

@Repository
public interface TaskTagRepository extends JpaRepository<TaskTag, Long> {
}