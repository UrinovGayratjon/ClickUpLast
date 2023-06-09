package uz.urinov.clickuplast.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.urinov.clickuplast.payload.TagDTO;
import uz.urinov.clickuplast.service.TagService;
import uz.urinov.clickuplast.service.impl.TagServiceImpl;

@RestController
@RequestMapping("/api/tag")
@Tag(name = "Tag Controller")
@SecurityRequirement(name = "bearerAuth")
public class TagController implements TagService {

    private final TagServiceImpl service;

    @Autowired
    public TagController(TagServiceImpl service) {
        this.service = service;
    }

    @GetMapping(value = "/{tagId}")
    @Override
    public ResponseEntity<?> getTag(@PathVariable Long tagId) {
        return service.getTag(tagId);
    }

    @GetMapping(value = "/{workspaceId}")
    @Override
    public ResponseEntity<?> getAllWorkspaceTags(@PathVariable Long workspaceId) {
        return service.getAllWorkspaceTags(workspaceId);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @Override
    public ResponseEntity<?> addTag(@RequestBody @Valid TagDTO dto) {
        return service.addTag(dto);
    }

    @PutMapping(value = "/{tagId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @Override
    public ResponseEntity<?> editTag(@PathVariable Long tagId, @RequestBody @Valid TagDTO dto) {
        return service.editTag(tagId, dto);
    }

    @DeleteMapping(value = "/{tagId}")
    @Override
    public ResponseEntity<?> deleteTag(@PathVariable Long tagId) {
        return service.deleteTag(tagId);
    }
}
