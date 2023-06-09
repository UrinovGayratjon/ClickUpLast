package uz.urinov.clickuplast.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import uz.urinov.clickuplast.entity.AttachmentContent;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface AttachmentContentRepository extends JpaRepository<AttachmentContent, Long> {

    Optional<AttachmentContent> findByAttachment_Id(UUID attachment_id);

    boolean existsByAttachment_Id(UUID attachment_id);

    @Transactional
    @Modifying
    void deleteByAttachmentId(UUID attachment_id);
}
