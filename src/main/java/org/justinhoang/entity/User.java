package org.justinhoang.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.FullTextField;
import org.justinhoang.util.TimestampAttributeConverter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * The type User.
 */
@Data
@Entity
@Getter
@Setter
@ToString
public class User implements Serializable
{

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long   id;
    @FullTextField
    @Column(name = "birthdate")
    private Date   birthdate;
    @FullTextField
    @Column(name = "first_name")
    private String firstName;
    @FullTextField
    @Column(name = "last_name")
    private String lastName;
    @FullTextField
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @FullTextField
    @Column(name = "email")
    private String email;
    @FullTextField
    @Column(name = "phone")
    private String phone;
//    @Column(name = "create_time")
    //    private Date   createTime;
    //    @Column(name = "update_time")
    //    private Date   updateTime;



    @CreationTimestamp
    @Convert(converter = TimestampAttributeConverter.class)
    @EqualsAndHashCode.Exclude
    @Column(name = "create_date")
    private LocalDateTime createDate;

    @UpdateTimestamp
    @Convert(converter = TimestampAttributeConverter.class)
    @EqualsAndHashCode.Exclude
    @Column(name = "update_date")
    private LocalDateTime updateDate;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Role> roles = new HashSet<Role>();

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Course> courses = new HashSet<Course>();

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Review> reviews = new HashSet<Review>();;


}


