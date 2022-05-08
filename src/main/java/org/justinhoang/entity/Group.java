package org.justinhoang.entity;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "group")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Group
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long   id;
    @Column(name = "name")
    private String name;
    @Column(name = "interests")
    private String interests;
    @Column(name = "description")
    private String description;

    @Override
    public boolean equals(final Object o)
    {
        if (this == o)
            return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o))
            return false;
        final Group group = (Group) o;
        return id != null && Objects.equals(id, group.id);
    }

    @Override
    public int hashCode()
    {
        return getClass().hashCode();
    }
}
