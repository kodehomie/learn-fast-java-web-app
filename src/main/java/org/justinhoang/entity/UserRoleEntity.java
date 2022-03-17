package org.justinhoang.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "user_role",
       schema = "learnfasttest",
       catalog = "")
public class UserRoleEntity
{
    private long   id;
    private String roleName;
    private long   userUsername;
    private long   userId;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id",
            nullable = false)
    public long getId()
    {
        return id;
    }

    public void setId(final long id)
    {
        this.id = id;
    }

    @Basic
    @Column(name = "role_name",
            nullable = false,
            length = 70)
    public String getRoleName()
    {
        return roleName;
    }

    public void setRoleName(final String roleName)
    {
        this.roleName = roleName;
    }

    @Basic
    @Column(name = "user_username",
            nullable = false)
    public long getUserUsername()
    {
        return userUsername;
    }

    public void setUserUsername(final long userUsername)
    {
        this.userUsername = userUsername;
    }

    @Basic
    @Column(name = "user_id",
            nullable = false)
    public long getUserId()
    {
        return userId;
    }

    public void setUserId(final long userId)
    {
        this.userId = userId;
    }

    @Override
    public boolean equals(final Object o)
    {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        final UserRoleEntity that = (UserRoleEntity) o;
        return id == that.id && userUsername == that.userUsername &&
               userId == that.userId && Objects.equals(roleName, that.roleName);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(id, roleName, userUsername, userId);
    }
}
