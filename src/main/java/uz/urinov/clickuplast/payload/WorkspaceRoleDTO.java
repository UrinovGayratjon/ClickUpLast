package uz.urinov.clickuplast.payload;

import lombok.Data;
import uz.urinov.clickuplast.entity.enums.ActionType;
import uz.urinov.clickuplast.entity.enums.WorkspacePermissionName;
import uz.urinov.clickuplast.entity.enums.WorkspaceRoleName;

import java.util.UUID;

@Data
public class WorkspaceRoleDTO {

    private UUID id;

    private String name;

    private WorkspaceRoleName roleName;

    private WorkspacePermissionName permissionName;

    private ActionType actionType;
}
