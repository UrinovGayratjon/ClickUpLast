package uz.urinov.clickuplast.payload.resp;

import lombok.Data;
import uz.urinov.clickuplast.entity.User;
import uz.urinov.clickuplast.entity.Workspace;

@Data
public class WorkspaceResponse {

    private String name;
    private String color;
    private String initialLetter;
    private User owner;

    public WorkspaceResponse(Workspace workspace) {
        this.name = workspace.getName();
        this.owner = workspace.getOwner();
        this.color = workspace.getColor();
        this.initialLetter = workspace.getInitialLetter();
    }
}
