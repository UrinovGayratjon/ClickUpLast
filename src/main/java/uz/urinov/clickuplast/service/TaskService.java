package uz.urinov.clickuplast.service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;
import uz.urinov.clickuplast.payload.TaskDTO;

import java.util.UUID;

public interface TaskService {

    ResponseEntity<?> getTask(UUID taskId);

    ResponseEntity<?> getAllTasks(UUID categoryId);

    ResponseEntity<?> addTask(TaskDTO dto);

    ResponseEntity<?> updateTask(UUID taskId, TaskDTO dto);

    ResponseEntity<?> removeTask(UUID taskId);

    ResponseEntity<?> previewTaskAttach(UUID taskId, UUID attachmentId);

    ResponseEntity<?> uploadTaskAttachment(UUID taskId, MultipartFile file);

    ResponseEntity<?> removeTaskAttachment(UUID taskId, UUID attachmentId);

    ResponseEntity<?> addTaskTag(UUID taskId, Long tagId);
}
