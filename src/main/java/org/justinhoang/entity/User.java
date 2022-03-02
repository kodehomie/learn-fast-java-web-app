package org.justinhoang.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

/**
 * The type User.
 */
@Data
@Entity
@Getter
@Setter
@ToString
public class User {

    @Id
    private Long id;

    private String firstName;

    private String lastName;

    private String username;

    private String password;

    private String email;

    private String phone;

    private Date createTime;

    private Date updateTime;

    private Date birthdate;

    private String role;


}


