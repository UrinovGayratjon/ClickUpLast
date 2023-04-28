package uz.urinov.clickuplast.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.urinov.clickuplast.aop.CurrentUser;
import uz.urinov.clickuplast.entity.User;
import uz.urinov.clickuplast.payload.StatusDTO;
import uz.urinov.clickuplast.service.StatusService;
import uz.urinov.clickuplast.service.impl.StatusServiceImpl;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/api/status")
@SecurityRequirement(name = "bearerAuth")
@Tag(name = "Status Controller")
public class StatusController implements StatusService {

    private final StatusServiceImpl service;

    @Autowired
    public StatusController(StatusServiceImpl service) {
        this.service = service;
    }

    @Override
    public ResponseEntity<?> getStatus() {
        return service.getStatus();
    }

    @GetMapping(value = "/{statusId}")
    @Override
    public ResponseEntity<?> getStatus(@PathVariable Long statusId) {
        return service.getStatus(statusId);
    }

    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    @Override
    public ResponseEntity<?> addStatus(@RequestBody @Valid StatusDTO dto, @CurrentUser User user) {
        return service.addStatus(dto, user);
    }

    @PutMapping(value = "/{statusId}", consumes = APPLICATION_JSON_VALUE)
    @Override
    public ResponseEntity<?> updateStatus(@PathVariable Long statusId, @RequestBody @Valid StatusDTO dto, @CurrentUser User user) {
        return service.updateStatus(statusId, dto, user);
    }

    @DeleteMapping(value = "/{statusId}")
    @Override
    public ResponseEntity<?> deleteStatus(@PathVariable Long statusId, @CurrentUser User user) {
        return service.deleteStatus(statusId, user);
    }
}
