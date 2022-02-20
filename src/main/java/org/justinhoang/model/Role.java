package org.justinhoang.model;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;

/** The type Role. */
@Getter
@Setter
@RequiredArgsConstructor
@Entity
@ToString

public class Role {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    private String role;

    @ManyToOne
    @JoinColumn(name="username", referencedColumnName = "username", nullable
            = false)
    private User user;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o))
            return false;
        Role role = (Role) o;
        return false;
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
