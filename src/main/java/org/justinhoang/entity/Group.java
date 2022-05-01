package org.justinhoang.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "group")
@Data
public class Group
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long   id;
    @Column(name = "name")
    private String name;
    @Column(name = "interests")
    private String interests;
    @Column(name = "description")
    private String description;

    // many-to-one
    @ManyToOne
    @JoinColumn(name="username", referencedColumnName = "username",
                nullable = false)
    private User user;
}
