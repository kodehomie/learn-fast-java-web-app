package org.justinhoang.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "course")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long   id;
    @Column(name = "title")
    private String title;
    @Column(name = "section")
    private String section;
    @Column(name = "format")
    private String format;
    @Column(name = "mentor")
    private String mentor;
    @Column(name = "section_status")
    private String sectionStatus;
    @Column(name = "meets")
    private String meets;
    @Column(name = "dates")
    private String dates;
    @Column(name = "description")
    private String description;

    // many-to-one
    @ManyToOne
    @JoinColumn(name="username", referencedColumnName = "username",
                nullable = false)
    private User user;

}
