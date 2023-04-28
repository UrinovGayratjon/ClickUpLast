package uz.urinov.clickuplast.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.urinov.clickuplast.entity.WorkspacePermission;
import uz.urinov.clickuplast.entity.enums.WorkspacePermissionName;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface WorkspacePermissionRepository extends JpaRepository<WorkspacePermission, Long> {

    Optional<WorkspacePermission> findByWorkspaceRole_IdAndPermissionType(UUID workspaceRole_id, WorkspacePermissionName permissionType);
}
