package org.justinhoang.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * The type User.
 */
@Data
@Entity
@Getter
@Setter
@ToString
public class User
{

    @Id
    @Column(name = "id")
    private Long   id;
    @Column(name = "birthdate")
    private Date   birthdate;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "email")
    private String email;
    @Column(name = "phone")
    private String phone;
    @Column(name = "create_time")
    private Date   createTime;
    @Column(name = "update_time")
    private Date   updateTime;

    private List<UserAttributes>   userAttributes;
    private List<CustomAttributes> customAttributes;

}


