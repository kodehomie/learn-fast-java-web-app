package org.justinhoang.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/** The type User. */
@Entity(name = "User")
@Table(name = "user") // case sensitive!
public class User {

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

  /** Instantiates a new User. */
  public User() {}

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
  public int id() {
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
   * @return the first name
   */
  public User setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
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
   * @return the last name
   */
  public User setLastName(String lastName) {
        this.lastName = lastName;
        return this;
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
   * @return the username
   */
  public User setUsername(String username) {
        this.username = username;
        return this;
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

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("User{");
        sb.append("id=").append(id);
        sb.append(", firstName='").append(firstName).append('\'');
        sb.append(", lastName='").append(lastName).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append(", username='").append(username).append('\'');
        sb.append(", password='").append(password).append('\'');
        sb.append('}');
        return sb.toString();
    }
}