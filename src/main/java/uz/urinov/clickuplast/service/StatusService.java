package uz.urinov.clickuplast.service;

import org.springframework.http.ResponseEntity;
import uz.urinov.clickuplast.entity.User;
import uz.urinov.clickuplast.payload.StatusDTO;

public interface StatusService {

    ResponseEntity<?> getStatus();

    ResponseEntity<?> getStatus(Long statusId);

    ResponseEntity<?> addStatus(StatusDTO dto, User user);

    ResponseEntity<?> updateStatus(Long statusId, StatusDTO dto, User user);

    ResponseEntity<?> deleteStatus(Long statusId, User user);
}
