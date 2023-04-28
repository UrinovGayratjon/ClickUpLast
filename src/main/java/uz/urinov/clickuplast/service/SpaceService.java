package uz.urinov.clickuplast.service;

import org.springframework.http.ResponseEntity;
import uz.urinov.clickuplast.entity.User;
import uz.urinov.clickuplast.payload.SpaceDTO;

import java.util.UUID;

public interface SpaceService {

    ResponseEntity<?> getAllSpaces(Long workspaceId, User user);

    ResponseEntity<?> getSpace(UUID spaceId);

    ResponseEntity<?> createSpace(Long workspaceId, SpaceDTO dto, User user);

    ResponseEntity<?> deleteSpace(Long workspaceId, UUID spaceId, User user);

    ResponseEntity<?> editSpace(Long workspaceId, UUID spaceId, SpaceDTO dto, User user);
}
