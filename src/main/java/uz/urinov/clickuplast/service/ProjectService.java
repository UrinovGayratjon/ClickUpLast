package uz.urinov.clickuplast.service;

import org.springframework.http.ResponseEntity;
import uz.urinov.clickuplast.entity.User;
import uz.urinov.clickuplast.payload.ProjectDTO;

import java.util.UUID;

public interface ProjectService {

    ResponseEntity<?> getAllProjects(UUID spaceId);

    ResponseEntity<?> getOneProject(UUID spaceId, UUID projectId);

    ResponseEntity<?> addProject(ProjectDTO dto, User user);

    ResponseEntity<?> editProject(UUID projectId, ProjectDTO dto, User user);

    ResponseEntity<?> deleteProject(UUID projectId, User user);
}
