package org.justinhoang.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;

/**
 * The type User role.
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@Proxy(lazy = false)
@Entity(name = "UserRole")
@Table(name = "user_roles")
public class UserRole { // @OneToMany

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    @Column(name = "role_name")
    private String roleName;

    @Column(name = "user_name")
    private String username;

    @ManyToOne
    private User user;

    /**
     * Instantiates a new User role.
     *
     * @param id the id
     */
    public UserRole(int id) {
        this.id = id;
    }

    /**
     * Instantiates a new User role.
     *
     * @param roleName the role name
     * @param username the username
     * @param user     the user
     */
    public UserRole(String roleName, String username, User user) {
        this.roleName = roleName;
        this.username = username;
        this.user = user;
    }
}
