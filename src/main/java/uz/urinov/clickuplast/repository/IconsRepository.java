package uz.urinov.clickuplast.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.urinov.clickuplast.entity.Icons;

import java.util.UUID;

@Repository
public interface IconsRepository extends JpaRepository<Icons, UUID> {
}