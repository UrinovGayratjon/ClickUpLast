package uz.urinov.clickuplast.service;

import org.springframework.http.ResponseEntity;
import uz.urinov.clickuplast.entity.User;
import uz.urinov.clickuplast.payload.CommentDTO;

import java.util.UUID;

public interface CommentService {

    ResponseEntity<?> getAllTaskComments(UUID taskId);

    ResponseEntity<?> getComment(UUID commentId);

    ResponseEntity<?> addComment(CommentDTO commentDTO);

    ResponseEntity<?> editComment(UUID commentId, CommentDTO commentDTO);

    ResponseEntity<?> deleteComment(UUID commentId, User user);
}
