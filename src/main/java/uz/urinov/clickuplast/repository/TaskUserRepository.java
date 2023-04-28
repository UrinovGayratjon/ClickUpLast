package uz.urinov.clickuplast.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.urinov.clickuplast.entity.TaskUser;

import java.util.UUID;

@Repository
public interface TaskUserRepository extends JpaRepository<TaskUser, UUID> {

    boolean existsByTask_IdAndUser_Id(UUID task_id, UUID user_id);
}