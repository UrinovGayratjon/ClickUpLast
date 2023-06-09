package uz.urinov.clickuplast.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import uz.urinov.clickuplast.entity.enums.WorkspacePermissionName;
import uz.urinov.clickuplast.entity.template.AbsLongEntity;

@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@Entity
public class WorkspacePermission extends AbsLongEntity {

    @ManyToOne(optional = false)
    private WorkspaceRole workspaceRole;    // o'rinbosar

    @Enumerated(EnumType.STRING)
    private WorkspacePermissionName permissionType; // add member, remove member
}
