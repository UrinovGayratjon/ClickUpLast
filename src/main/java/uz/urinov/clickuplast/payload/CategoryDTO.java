package uz.urinov.clickuplast.payload;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import uz.urinov.clickuplast.entity.enums.AccessType;

import java.util.UUID;

@Data
public class CategoryDTO {

    @NotNull(message = "Name must not be null")
    private String name;

    @NotNull(message = "color must not be null")
    private String color;

    private boolean archived;

    @NotNull(message = "accessType must not be null")
    private AccessType accessType;

    @NotNull(message = "Project ID must not be null")
    private UUID projectId;
}
