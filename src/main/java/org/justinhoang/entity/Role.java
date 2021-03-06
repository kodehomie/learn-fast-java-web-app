package org.justinhoang.entity;

import lombok.*;

import javax.persistence.*;

/**
 * The type Role.
 */
@Entity
@Table(name = "role")
@Data
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    // many-to-one
    @ManyToOne
    @JoinColumn(name="username", referencedColumnName = "username",
                nullable = false)
    private User user;
}
