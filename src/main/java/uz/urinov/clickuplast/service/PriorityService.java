package uz.urinov.clickuplast.service;

import org.springframework.http.ResponseEntity;
import uz.urinov.clickuplast.payload.PriorityDTO;

public interface PriorityService {

    ResponseEntity<?> getPriorities();

    ResponseEntity<?> getPriority(Long priorityId);

    ResponseEntity<?> addPriority(PriorityDTO priorityDTO);

    ResponseEntity<?> updatePriority(Long priorityId, PriorityDTO priorityDTO);
}
