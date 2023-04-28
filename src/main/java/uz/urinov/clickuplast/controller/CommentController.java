package uz.urinov.clickuplast.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.urinov.clickuplast.aop.CurrentUser;
import uz.urinov.clickuplast.entity.User;
import uz.urinov.clickuplast.payload.CommentDTO;
import uz.urinov.clickuplast.service.CommentService;
import uz.urinov.clickuplast.service.impl.CommentServiceImpl;

import java.util.UUID;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/api/comment")
@SecurityRequirement(name = "bearerAuth")
@Tag(name = "Comment Controller")
public class CommentController implements CommentService {

    private final CommentServiceImpl service;

    @Autowired
    public CommentController(CommentServiceImpl service) {
        this.service = service;
    }

    @DeleteMapping("/{taskId}")
    @Override
    public ResponseEntity<?> getAllTaskComments(@PathVariable UUID taskId) {
        return service.getAllTaskComments(taskId);
    }

    @GetMapping("/{commentId}")
    @Override
    public ResponseEntity<?> getComment(@PathVariable UUID commentId) {
        return service.getComment(commentId);
    }

    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    @Override
    public ResponseEntity<?> addComment(@RequestBody @Valid CommentDTO commentDTO) {
        return service.addComment(commentDTO);
    }

    @PutMapping(value = "/{commentId}", consumes = APPLICATION_JSON_VALUE)
    @Override
    public ResponseEntity<?> editComment(@PathVariable UUID commentId, @RequestBody @Valid CommentDTO commentDTO) {
        return service.editComment(commentId, commentDTO);
    }

    @DeleteMapping("/{commentId}")
    @Override
    public ResponseEntity<?> deleteComment(@PathVariable UUID commentId, @CurrentUser User user) {
        return service.deleteComment(commentId, user);
    }
}
