package org.justinhoang.entity;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.Hibernate;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/** The type User. */
@Entity(name = "User")
@Table(name = "user") // case sensitive!
@ToString
@NoArgsConstructor
public class User implements Serializable {

    // Every Entity must have a unique identifier which is annotated @Id
    // Notice there is no @Column here as the column and instance variable name are the same
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

  /**
   * Instantiates a new User.
   *
   * @param id the id
   * @param firstName the first name
   * @param lastName the last name
   * @param email the email
   * @param username the username
   * @param password the password
   */
  public User(
      int id, String firstName, String lastName, String email, String username, String password) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.username = username;
        this.password = password;

    }

  /**
   * Id int.
   *
   * @return the int
   */
  public int getId() {
        return id;
    }

  /**
   * Sets id.
   *
   * @param id the id
   * @return the id
   */
  public User setId(int id) {
        this.id = id;
        return this;
    }

  /**
   * First name string.
   *
   * @return the string
   */
  public String firstName() {
        return firstName;
    }

  /**
   * Sets first name.
   *
   * @param firstName the first name
   */
  public void setFirstName(String firstName) {
        this.firstName = firstName;
  }

  /**
   * Last name string.
   *
   * @return the string
   */
  public String lastName() {
        return lastName;
    }

  /**
   * Sets last name.
   *
   * @param lastName the last name
   */
  public void setLastName(String lastName) {
        this.lastName = lastName;
  }

  /**
   * Email string.
   *
   * @return the string
   */
  public String email() {
        return email;
    }

  /**
   * Sets email.
   *
   * @param email the email
   * @return the email
   */
  public User setEmail(String email) {
        this.email = email;
        return this;
    }

  /**
   * Username string.
   *
   * @return the string
   */
  public String username() {
        return username;
    }

  /**
   * Sets username.
   *
   * @param username the username
   */
  public void setUsername(String username) {
        this.username = username;
  }

  /**
   * Password string.
   *
   * @return the string
   */
  public String password() {
        return password;
    }

  /**
   * Sets password.
   *
   * @param password the password
   * @return the password
   */
  public User setPassword(String password) {
        this.password = password;
        return this;
    }



    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private final Set<Role> roles = new HashSet<Role>();

    public void addRole(Role role) {
        roles.add(role);

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o))
            return false;
        User user = (User) o;
        return false;
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}