package org.justinhoang.model;

import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.util.HashSet;
import java.util.Set;
import java.util.StringJoiner;

/** The type User. */
@MappedSuperclass
public class User extends BaseModel {

//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
//    @GenericGenerator(name = "native", strategy = "native")
//    private int id;

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
   * @param firstName the first name
   * @param lastName the last name
   * @param email the email
   * @param username the username
   * @param password the password
   */
  public User(String firstName, String lastName, String email, String username, String password) {
//        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.username = username;
        this.password = password;

        roles = new HashSet<Role>();
    }


  /**
   * Gets first name.
   *
   * @return the first name
   */
  public String getFirstName() {
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
   * Gets last name.
   *
   * @return the last name
   */
  public String getLastName() {
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
   * Gets email.
   *
   * @return the email
   */
  public String getEmail() {
        return email;
    }

  /**
   * Sets email.
   *
   * @param email the email
   */
  public void setEmail(String email) {
        this.email = email;
    }

  /**
   * Gets username.
   *
   * @return the username
   */
  public String getUsername() {
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
   * Gets password.
   *
   * @return the password
   */
  public String getPassword() {
        return password;
    }

  /**
   * Sets password.
   *
   * @param password the password
   */
  public void setPassword(String password) {
        this.password = password;
    }

  /**
   * Gets roles.
   *
   * @return the roles
   */
  public Set<Role> getRoles() {
        return roles;
    }

    //    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private final Set<Role> roles;

  /**
   * Add role.
   *
   * @param role the role
   */
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

    @Override
    public String toString() {
        return new StringJoiner(", ", User.class.getSimpleName() + "[", "]")
                .add("firstName='" + firstName + "'")
                .add("lastName='" + lastName + "'")
                .add("email='" + email + "'")
                .add("username='" + username + "'")
                .add("password='" + password + "'")
                .add("roles=" + roles)
                .toString();
    }
}
