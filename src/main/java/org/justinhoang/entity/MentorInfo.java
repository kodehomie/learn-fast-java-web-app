package org.justinhoang.entity;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@RequiredArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "mentor_info")
public class MentorInfo
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "website")
    private String website;

    @Column(name = "interest")
    private String interest;

    @OneToOne(mappedBy = "mentorInfo", cascade = {CascadeType.DETACH,
                                                  CascadeType.MERGE,
                                                  CascadeType.PERSIST,
                                                  CascadeType.REFRESH})
    private Mentor mentor;

    public Mentor getMentor()
    {
        return mentor;
    }

    public void setMentor(Mentor mentor)
    {
        this.mentor = mentor;
    }

    public MentorInfo()
    {

    }

    public MentorInfo(String website, String interest)
    {
        this.website  = website;
        this.interest = interest;
    }

    @Override
    public boolean equals(final Object o)
    {
        if (this == o)
            return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o))
            return false;
        final MentorInfo that = (MentorInfo) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode()
    {
        return getClass().hashCode();
    }
}








