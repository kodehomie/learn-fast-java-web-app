package org.justinhoang.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Data
@Entity
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Role {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    private String role;

    @ManyToOne
    @JoinColumn(name="username", referencedColumnName = "username", nullable
            = false)
    private User user;
}
