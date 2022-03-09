package org.justinhoang.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Getter
@Setter
@ToString
@Table(name = "mentor")
public class Mentor
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "mentor_info_id")
    private MentorInfo mentorInfo;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "mentor", cascade = {
            CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH,
            CascadeType.REFRESH})
    private List<Course> courses;

    public Mentor()
    {

    }

    public Mentor(String firstName, String lastName, String email)
    {
        this.firstName = firstName;
        this.lastName  = lastName;
        this.email     = email;
    }

    public List<Course> getCourses()
    {
        return courses;
    }

    public void setCourses(List<Course> courses)
    {
        this.courses = courses;
    }

    // methods for bi-directional relationship

    public void add(Course tempCourse)
    {

        if (courses == null)
        {
            courses = new ArrayList<>();
        }

        courses.add(tempCourse);

        tempCourse.setMentor(this);
    }

}











