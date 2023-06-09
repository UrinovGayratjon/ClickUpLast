package uz.urinov.clickuplast.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import uz.urinov.clickuplast.entity.ProjectUser;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ProjectUserRepository extends JpaRepository<ProjectUser, UUID> {

    Optional<ProjectUser> findByProjectIdAndCreatedBy(UUID project_id, UUID createdBy);

    @Modifying
    @Query("select (count(p) > 0) from ProjectUser p where p.project.id = ?1 and p.createdBy = ?2")
    boolean existsByProject_IdAndAndCreatedBy(UUID projectId, UUID createdBy);
}