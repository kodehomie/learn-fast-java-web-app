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
@Table(name = "course")
public class Course
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "title")
    private String title;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE,
                          CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE,
                          CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "mentor_id")
    private Mentor mentor;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "course_id")
    private List<Review> reviews;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST,
                                                   CascadeType.MERGE,
                                                   CascadeType.DETACH,
                                                   CascadeType.REFRESH})
    @JoinTable(name = "course_mentee", joinColumns = @JoinColumn(name =
            "course_id"), inverseJoinColumns = @JoinColumn(name = "mentee_id"))
    private List<Mentee> mentees;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST,
                                                   CascadeType.MERGE,
                                                   CascadeType.DETACH,
                                                   CascadeType.REFRESH})
    @JoinTable(name = "course_user", joinColumns = @JoinColumn(name =
            "course_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<User> users;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST,
                                                   CascadeType.MERGE,
                                                   CascadeType.DETACH,
                                                   CascadeType.REFRESH})
    @JoinTable(name = "course_user", joinColumns = @JoinColumn(name =
            "course_id"), inverseJoinColumns = @JoinColumn(name =
            "course_type_id"))
    private List<CourseFormat> courseFormats;

    public Course()
    {

    }

    public Course(String title)
    {
        this.title = title;
    }

    public List<Review> getReviews()
    {
        return reviews;
    }

    public void setReviews(List<Review> reviews)
    {
        this.reviews = reviews;
    }

    // add a convenience method

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

    public void setCourseFormats(CourseFormat courseFormat)
    {

        if (courseFormats == null)
        {
            courseFormats = new ArrayList<>();
        }

        courseFormats.add(courseFormat);
    }

}



