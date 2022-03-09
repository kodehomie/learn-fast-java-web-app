package org.justinhoang.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Data
@Getter
@Setter
@ToString
@Table(name = "mentor_info")
public class MentorInfo
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

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

}








