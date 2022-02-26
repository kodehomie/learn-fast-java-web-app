package org.justinhoang.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;


@Getter
@Setter
@NoArgsConstructor
@Proxy(lazy = false)
@ToString
@Entity(name = "User")
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    @NotEmpty(message = "Please enter first name")
    @Column(name = "first_name")
    private String firstName;

    @NotEmpty(message = "Please enter last name")
    @Column(name = "last_name")
    private String lastName;

    @NotEmpty(message = "Please enter email")
    @Column(name = "email")
    private String email;

    @NotEmpty(message = "Please enter username")
    @Column(name = "user_name")
    private String username;

    @NotEmpty(message = "Please enter password")
    @Column(name = "user_pass")
    private String password;


}
