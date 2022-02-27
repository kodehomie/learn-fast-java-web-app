package org.justinhoang.entity;

import lombok.*;
import org.hibernate.annotations.Proxy;
import org.springframework.beans.MutablePropertyValues;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;


/**
 * The type User.
 */
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


    /**
     * The User roles.
     */
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    public Set<UserRole> userRoles = new HashSet<>();

    /**
     * The Contacts.
     */
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    public Set<Contact> contacts = new HashSet<>();

    /**
     * The Orders.
     */
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    public Set<Order> orders = new HashSet<>();

    /**
     * Instantiates a new User.
     *
     * @param firstName the first name
     * @param lastName  the last name
     * @param email     the email
     * @param username  the username
     * @param password  the password
     */
    public User(String firstName, String lastName, String email, String username, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.username = username;
        this.password = password;
    }

    /**
     * Instantiates a new User.
     *
     * @param username the username
     * @param password the password
     */
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    /**
     * Instantiates a new User.
     *
     * @param firstName the first name
     * @param lastName  the last name
     * @param username  the username
     * @param email     the email
     */
    public User(String firstName, String lastName, String username, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.email = email;

    }

    /**
     * Add user roles.
     *
     * @param userRole the user role
     */
    public void addUserRoles(UserRole userRole) {
        userRoles.add(userRole);
        userRole.setUser(this);
    }

    /**
     * Remove user roles.
     *
     * @param userRole the user role
     */
    public void removeUserRoles(UserRole userRole) {
        userRoles.remove(userRole);
        userRole.setUser(null);
    }


}
