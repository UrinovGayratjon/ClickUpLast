package uz.urinov.clickuplast.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;
import uz.urinov.clickuplast.entity.enums.TaskPermission;
import uz.urinov.clickuplast.entity.template.AbsUUIDEntity;

import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class CategoryUser extends AbsUUIDEntity {

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @ToString.Exclude
    private Category category;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @ToString.Exclude
    private User user;

    @Enumerated(EnumType.STRING)
    private TaskPermission taskPermission;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        CategoryUser that = (CategoryUser) o;
        return getId() != null && Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
