package uz.urinov.clickuplast.payload;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import uz.urinov.clickuplast.entity.WorkspaceUser;
import uz.urinov.clickuplast.entity.enums.ActionType;

import java.sql.Timestamp;
import java.util.UUID;

@Data
public class MemberDTO {

    private UUID id;

    private String fullName;

    private String email;

    private String roleName;

    private Timestamp lastActivity;

    @NotNull(message = "Member ID cannot be null")
    private UUID userId;

    @NotNull(message = "Role ID cannot be null")
    private UUID roleId;

    @JsonIgnore
    @NotNull(message = "Action cannot be null")
    private ActionType actionType;

    public MemberDTO(WorkspaceUser wu) {
        this.id = wu.getId();
        this.fullName = wu.getUser().getFullName();
        this.email = wu.getUser().getEmail();
        this.roleName = wu.getWorkspaceRole().getName();
        this.lastActivity = wu.getUser().getLastActivity();
        this.userId = wu.getUser().getId();
        this.roleId = wu.getWorkspaceRole().getId();
    }
}
