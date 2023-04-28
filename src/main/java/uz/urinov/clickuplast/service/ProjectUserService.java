package uz.urinov.clickuplast.service;

import org.springframework.http.ResponseEntity;
import uz.urinov.clickuplast.entity.User;
import uz.urinov.clickuplast.payload.ProjectUserDTO;

import java.util.UUID;

public interface ProjectUserService {

    ResponseEntity<?> addProjectUser(ProjectUserDTO dto);

    ResponseEntity<?> editProjectUser(UUID projectUserId, UUID userId, User user);

    ResponseEntity<?> deleteProjectUser(UUID projectUserId, UUID projectId, User user);
}
