package org.justinhoang.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

/**
 * The type Contact.
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@Proxy(lazy = false)
@Entity(name = "Contact")
@Table(name = "contact")
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    @NotEmpty(message = "Please enter first name")
    @Column(name = "firstname")
    private String firstname;

    @NotEmpty(message = "Please enter last name")
    @Column(name = "lastname")
    private String lastname;

    @NotEmpty(message = "Please enter email")
    @Column(name = "email")
    private String email;

    @Column(name = "user_name")
    private String username;

    @NotEmpty(message = "Please enter subject")
    @Column(name = "subject")
    private String subject;

    @NotEmpty(message = "Please enter message")
    @Column(name = "message")
    private String message;

    @ManyToOne
    private User user;


    /**
     * Instantiates a new Contact.
     *
     * @param firstname the firstname
     * @param lastname  the lastname
     * @param email     the email
     * @param subject   the subject
     * @param message   the message
     * @param username  the username
     * @param user      the user
     */
    public Contact(String firstname, String lastname, String email, String subject, String message, String username, User user) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.subject = subject;
        this.message = message;
        this.username = username;
        this.user = user;

    }


    /**
     * Instantiates a new Contact.
     *
     * @param firstname the firstname
     * @param lastname  the lastname
     * @param email     the email
     * @param subject   the subject
     * @param message   the message
     */
    public Contact(String firstname, String lastname, String email, String subject, String message) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.subject = subject;
        this.message = message;

    }
}