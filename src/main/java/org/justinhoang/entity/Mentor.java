package org.justinhoang.entity;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@RequiredArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "mentor")
public class Mentor
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

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
    @ToString.Exclude
    private List<Course> courses;

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

    @Override
    public boolean equals(final Object o)
    {
        if (this == o)
            return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o))
            return false;
        final Mentor mentor = (Mentor) o;
        return id != null && Objects.equals(id, mentor.id);
    }

    @Override
    public int hashCode()
    {
        return getClass().hashCode();
    }
}











