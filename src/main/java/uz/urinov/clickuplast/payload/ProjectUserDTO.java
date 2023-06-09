package uz.urinov.clickuplast.payload;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import uz.urinov.clickuplast.entity.enums.TaskPermission;

import java.util.UUID;

@Data
public class ProjectUserDTO {

    @NotNull
    private UUID projectId;

    @NotNull
    private UUID userId;

    @NotNull
    @Enumerated(EnumType.STRING)
    private TaskPermission taskPermission;
}
