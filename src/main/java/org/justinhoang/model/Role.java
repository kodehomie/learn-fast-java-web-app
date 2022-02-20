package org.justinhoang.model;

import org.hibernate.Hibernate;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

/** The type Role. */

@MappedSuperclass
public class Role extends BaseModel {

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
