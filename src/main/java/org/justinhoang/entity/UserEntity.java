package org.justinhoang.entity;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "user",
       schema = "learnfasttest")
public class UserEntity
{
    private long      id;
    private Date      birthdate;
    private String    firstName;
    private String    lastName;
    private String    email;
    private String    phone;
    private String    username;
    private String    password;
    private Timestamp createTime;
    private Timestamp updateTime;

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
    @Column(name = "birthdate",
            nullable = false)
    public Date getBirthdate()
    {
        return birthdate;
    }

    public void setBirthdate(final Date birthdate)
    {
        this.birthdate = birthdate;
    }

    @Basic
    @Column(name = "first_name",
            nullable = false,
            length = 75)
    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(final String firstName)
    {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "last_name",
            nullable = false,
            length = 70)
    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(final String lastName)
    {
        this.lastName = lastName;
    }

    @Basic
    @Column(name = "email",
            nullable = false,
            length = 75)
    public String getEmail()
    {
        return email;
    }

    public void setEmail(final String email)
    {
        this.email = email;
    }

    @Basic
    @Column(name = "phone",
            nullable = false,
            length = 25)
    public String getPhone()
    {
        return phone;
    }

    public void setPhone(final String phone)
    {
        this.phone = phone;
    }

    @Basic
    @Column(name = "username",
            nullable = false,
            length = 70)
    public String getUsername()
    {
        return username;
    }

    public void setUsername(final String username)
    {
        this.username = username;
    }

    @Basic
    @Column(name = "password",
            nullable = false,
            length = 255)
    public String getPassword()
    {
        return password;
    }

    public void setPassword(final String password)
    {
        this.password = password;
    }

    @Basic
    @Column(name = "create_time",
            nullable = false)
    public Timestamp getCreateTime()
    {
        return createTime;
    }

    public void setCreateTime(final Timestamp createTime)
    {
        this.createTime = createTime;
    }

    @Basic
    @Column(name = "update_time",
            nullable = false)
    public Timestamp getUpdateTime()
    {
        return updateTime;
    }

    public void setUpdateTime(final Timestamp updateTime)
    {
        this.updateTime = updateTime;
    }

    @Override
    public boolean equals(final Object o)
    {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        final UserEntity that = (UserEntity) o;
        return id == that.id && Objects.equals(birthdate, that.birthdate) &&
               Objects.equals(firstName, that.firstName) &&
               Objects.equals(lastName, that.lastName) &&
               Objects.equals(email, that.email) &&
               Objects.equals(phone, that.phone) &&
               Objects.equals(username, that.username) &&
               Objects.equals(password, that.password) &&
               Objects.equals(createTime, that.createTime) &&
               Objects.equals(updateTime, that.updateTime);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(id, birthdate, firstName, lastName, email, phone,
                            username, password, createTime, updateTime);
    }
}
