package org.justinhoang.entity;

import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.FullTextField;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@RequiredArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "course")
public class Course
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @FullTextField(name = "field_suggest",
                   analyzer = "edge_ngram")
    @Column(name = "title")
    private String title;

    @FullTextField(name = "field_suggest",
                   analyzer = "edge_ngram")
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE,
                          CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "user_id")
    private User user;

    @FullTextField(name = "field_suggest",
                   analyzer = "edge_ngram")
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE,
                          CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "mentor_id")
    private Mentor mentor;

    @FullTextField(name = "field_suggest",
                   analyzer = "edge_ngram")
    @OneToMany(fetch = FetchType.LAZY,
               cascade = CascadeType.ALL)
    @JoinColumn(name = "course_id")
    @ToString.Exclude
    private List<Review> reviews;

    @FullTextField(name = "field_suggest",
                   analyzer = "edge_ngram")
    @ManyToMany(fetch = FetchType.LAZY,
                cascade = {CascadeType.PERSIST, CascadeType.MERGE,
                           CascadeType.DETACH, CascadeType.REFRESH})
    @JoinTable(name = "course_mentee",
               joinColumns = @JoinColumn(name = "course_id"),
               inverseJoinColumns = @JoinColumn(name = "mentee_id"))
    @ToString.Exclude
    private List<Mentee> mentees;

    @FullTextField(name = "field_suggest",
                   analyzer = "edge_ngram")
    @ManyToMany(fetch = FetchType.LAZY,
                cascade = {CascadeType.PERSIST, CascadeType.MERGE,
                           CascadeType.DETACH, CascadeType.REFRESH})
    @JoinTable(name = "course_user",
               joinColumns = @JoinColumn(name = "course_id"),
               inverseJoinColumns = @JoinColumn(name = "user_id"))
    @ToString.Exclude
    private List<User> users;

    @FullTextField(name = "field_suggest",
                   analyzer = "edge_ngram")
    @ManyToMany(fetch = FetchType.LAZY,
                cascade = {CascadeType.PERSIST, CascadeType.MERGE,
                           CascadeType.DETACH, CascadeType.REFRESH})
    @JoinTable(name = "course_user",
               joinColumns = @JoinColumn(name = "course_id"),
               inverseJoinColumns = @JoinColumn(name = "course_type_id"))
    @ToString.Exclude
    private List<Course>        courses;
    private List<CourseSection> courseSections;
    private List<CourseFormat>  courseFormats;
    private List<CourseMentor>  courseMentors;
    private List<CourseMeet>    courseMeets;
    private List<CourseDate>    courseDates;

    public Course(String title)
    {
        this.title = title;
    }

    public List<Course> getCourses()
    {
        return courses;
    }

    public void setCourses(List<Course> courses)
    {
        this.courses = courses;
    }

    public List<Review> getReviews()
    {
        return reviews;
    }

    public void setReviews(List<Review> reviews)
    {
        this.reviews = reviews;
    }

    public void addReview(Review review)
    {

        if (reviews == null)
        {
            reviews = new ArrayList<>();
        }

        reviews.add(review);
    }

    public void setUser(User user)
    {

        if (users == null)
        {
            users = new ArrayList<>();
        }

        users.add(user);
    }

    public List<User> getUsers()
    {
        return users;
    }

    public void setUsers(List<User> users)
    {
        this.users = users;
    }

    public void setCourseSection(CourseSection courseSection)
    {
        if (courseSection == null)
        {
            courseSections = new ArrayList<>();
        }

        courseSections.add(courseSection);
    }

    public List<CourseSection> getCourseSections()
    {
        return courseSections;
    }

    public void setCourseSections(List<CourseSection> courseSections)
    {
        this.courseSections = courseSections;
    }

    public void setCourseFormat(CourseFormat courseFormat)
    {

        if (courseFormats == null)
        {
            courseFormats = new ArrayList<>();
        }

        courseFormats.add(courseFormat);
    }

    public List<CourseFormat> getCourseFormats()
    {
        return courseFormats;
    }

    public void setCourseFormats(List<CourseFormat> courseFormats)
    {
        this.courseFormats = courseFormats;
    }

    @Override
    public boolean equals(final Object o)
    {
        if (this == o)
            return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o))
            return false;
        final Course course = (Course) o;
        return false;
    }

    @Override
    public int hashCode()
    {
        return getClass().hashCode();
    }
}




