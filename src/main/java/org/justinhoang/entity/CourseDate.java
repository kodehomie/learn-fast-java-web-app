package org.justinhoang.entity;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
public class CourseDate
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String meetingDates;

    @Override
    public boolean equals(final Object o)
    {
        if (this == o)
            return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o))
            return false;
        final CourseDate that = (CourseDate) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode()
    {
        return getClass().hashCode();
    }
}
