package uz.urinov.clickuplast.service;

import org.springframework.http.ResponseEntity;
import uz.urinov.clickuplast.entity.User;
import uz.urinov.clickuplast.payload.CategoryDTO;

public interface CategoryService {

    ResponseEntity<?> getCategory(Long categoryId);

    ResponseEntity<?> addCategory(CategoryDTO dto, User user);

    ResponseEntity<?> editCategory(Long categoryId, CategoryDTO dto, User user);

    ResponseEntity<?> deleteCategory(Long categoryId, User user);
}
