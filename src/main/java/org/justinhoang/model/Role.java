package org.justinhoang.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * The type Role.
 */
@Data
@Entity
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "role")
    private String role;

    @ManyToOne
    @JoinColumn(name = "user_username", referencedColumnName = "username", nullable = false)
    private User user;

    @Column(name = "user_id")
    private int userId;

    @Column(name = "user_username")
    private String username;

    @Column(name = "create_date")
    private LocalDate createDate;

    @Column(name = "update_date")
    private LocalDate updateDate;


}
