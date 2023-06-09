package uz.urinov.clickuplast.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.urinov.clickuplast.entity.Status;

import java.util.UUID;

public interface StatusRepository extends JpaRepository<Status, Long> {

    boolean existsByNameAndCategory_Id(String name, UUID category_id);

    boolean existsByNameAndCategory_IdAndIdNot(String name, UUID category_id, Long id);

    boolean existsByIdAndCreatedBy(Long id, UUID createdBy);
}