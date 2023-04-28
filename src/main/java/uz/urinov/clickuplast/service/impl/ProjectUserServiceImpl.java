package uz.urinov.clickuplast.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.urinov.clickuplast.entity.Project;
import uz.urinov.clickuplast.entity.ProjectUser;
import uz.urinov.clickuplast.entity.User;
import uz.urinov.clickuplast.entity.enums.TaskPermission;
import uz.urinov.clickuplast.payload.ProjectUserDTO;
import uz.urinov.clickuplast.repository.ProjectRepository;
import uz.urinov.clickuplast.repository.ProjectUserRepository;
import uz.urinov.clickuplast.repository.UserRepository;
import uz.urinov.clickuplast.service.ProjectUserService;

import java.util.Arrays;
import java.util.Optional;
import java.util.UUID;

import static org.springframework.http.HttpStatus.*;
import static org.springframework.http.ResponseEntity.status;

@Service
public class ProjectUserServiceImpl implements ProjectUserService {

    private final ProjectUserRepository projectUserRepository;

    private final ProjectRepository projectRepository;

    private final UserRepository userRepository;

    @Autowired
    public ProjectUserServiceImpl(ProjectUserRepository projectUserRepository, ProjectRepository projectRepository, UserRepository userRepository) {
        this.projectUserRepository = projectUserRepository;
        this.projectRepository = projectRepository;
        this.userRepository = userRepository;
    }

    @Override
    public ResponseEntity<?> addProjectUser(ProjectUserDTO dto) {
        if (Arrays.stream(TaskPermission.values()).toList().contains(dto.getTaskPermission()))
            return status(BAD_REQUEST).body("Invalid task permission");
        Optional<Project> optionalProject = projectRepository.findById(dto.getProjectId());
        if (optionalProject.isEmpty()) return status(NOT_FOUND).body("Project not found");
        Optional<User> optionalUser = userRepository.findById(dto.getUserId());
        if (optionalUser.isEmpty()) return status(NOT_FOUND).body("User not found");
        ProjectUser projectUser = projectUserRepository.save(new ProjectUser(
                optionalProject.get(),
                optionalUser.get(),
                dto.getTaskPermission()
        ));
        return status(CREATED).body(projectUser);
    }

    @Override
    public ResponseEntity<?> editProjectUser(UUID projectUserId, UUID userId, User user) {
        Optional<ProjectUser> optionalProjectUser = projectUserRepository.findByProjectIdAndCreatedBy(projectUserId, user.getId());
        if (optionalProjectUser.isEmpty()) return status(NOT_FOUND).body("Project user not found");
        Optional<User> optionalUser = userRepository.findById(userId);
        if (optionalUser.isEmpty()) return status(NOT_FOUND).body("User not found");
        ProjectUser projectUser = optionalProjectUser.get();
        projectUser.setUser(optionalUser.get());
        projectUser = projectUserRepository.save(projectUser);
        return status(CREATED).body(projectUser);
    }

    @Override
    public ResponseEntity<?> deleteProjectUser(UUID projectUserId, UUID projectId, User user) {
        if (projectUserRepository.existsByProject_IdAndAndCreatedBy(projectId, user.getId()))
            return status(BAD_REQUEST).body("Project user not deleted");
        Optional<ProjectUser> optionalProjectUser = projectUserRepository.findById(projectUserId);
        if (optionalProjectUser.isEmpty()) return status(NOT_FOUND).body("Project user not found");
        projectUserRepository.delete(optionalProjectUser.get());
        return status(NO_CONTENT).body("Project user deleted");
    }
}
