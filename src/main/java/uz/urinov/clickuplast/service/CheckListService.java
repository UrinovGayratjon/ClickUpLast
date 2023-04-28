package uz.urinov.clickuplast.service;

import org.springframework.http.ResponseEntity;
import uz.urinov.clickuplast.payload.CheckListDTO;
import uz.urinov.clickuplast.payload.CheckListItemDTO;

import java.util.UUID;

public interface CheckListService {

    ResponseEntity<?> getCheckLists(UUID taskId);

    ResponseEntity<?> getCheckList(UUID taskId, UUID checkListId);

    ResponseEntity<?> createCheckList(CheckListDTO dto);

    ResponseEntity<?> addAssignUser(UUID checkListId, UUID userId);

    ResponseEntity<?> deleteCheckList(UUID checkListId);

    ResponseEntity<?> updateCheckList(UUID checkListId, String name);

    ResponseEntity<?> addCheckListItem(UUID checkListId, CheckListItemDTO dto);

    ResponseEntity<?> removeCheckListItem(UUID checkListId, UUID checkListItemId);
}
