package uz.urinov.clickuplast.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.urinov.clickuplast.entity.Tag;

import java.util.List;

@Repository
public interface TagRepository extends JpaRepository<Tag, Long> {

    List<Tag> findAllByWorkspace_Id(Long workspace_id);

    boolean existsByWorkspace_IdAndName(Long workspace_id, String name);

    boolean existsByWorkspace_IdAndNameAndIdNot(Long workspace_id, String name, Long id);
}