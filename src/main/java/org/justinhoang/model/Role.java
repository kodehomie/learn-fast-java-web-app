package org.justinhoang.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.time.LocalDate;

/** The type Role. */

@MappedSuperclass
//@Entity(name = "Role")
@Table(name = "role")
@Getter
@Setter
@ToString
@NoArgsConstructor
@Proxy(lazy=false)
public class Role extends BaseModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    @Column(name = "user_id")
    private int userId;

    @Column(name = "user_username")
    private String username;

    @Column(name = "role")
    private String role;

    @Column(name = "create_date")
    private LocalDate createDate;

    @Column(name = "update_date")
    private LocalDate updateDate;



}
