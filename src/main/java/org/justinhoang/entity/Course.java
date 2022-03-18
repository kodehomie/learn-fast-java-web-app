package org.justinhoang.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "course",
       schema = "learnfasttest")
public class Course
{
    private long   id;
    private String title;
    private String section;
    private String format;
    private String mentor;
    private String sectionStatus;
    private String meets;
    private String dates;
    private String description;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id",
            nullable = false)
    public long getId()
    {
        return id;
    }

    public void setId(final long id)
    {
        this.id = id;
    }

    @Basic
    @Column(name = "title",
            nullable = false,
            length = 50)
    public String getTitle()
    {
        return title;
    }

    public void setTitle(final String title)
    {
        this.title = title;
    }

    @Basic
    @Column(name = "section",
            nullable = false,
            length = 50)
    public String getSection()
    {
        return section;
    }

    public void setSection(final String section)
    {
        this.section = section;
    }

    @Basic
    @Column(name = "format",
            nullable = false,
            length = 50)
    public String getFormat()
    {
        return format;
    }

    public void setFormat(final String format)
    {
        this.format = format;
    }

    @Basic
    @Column(name = "mentor",
            nullable = false,
            length = 70)
    public String getMentor()
    {
        return mentor;
    }

    public void setMentor(final String mentor)
    {
        this.mentor = mentor;
    }

    @Basic
    @Column(name = "section_status",
            nullable = false,
            length = 50)
    public String getSectionStatus()
    {
        return sectionStatus;
    }

    public void setSectionStatus(final String sectionStatus)
    {
        this.sectionStatus = sectionStatus;
    }

    @Basic
    @Column(name = "meets",
            nullable = false,
            length = 50)
    public String getMeets()
    {
        return meets;
    }

    public void setMeets(final String meets)
    {
        this.meets = meets;
    }

    @Basic
    @Column(name = "dates",
            nullable = false,
            length = 50)
    public String getDates()
    {
        return dates;
    }

    public void setDates(final String dates)
    {
        this.dates = dates;
    }

    @Basic
    @Column(name = "description",
            nullable = false,
            length = 255)
    public String getDescription()
    {
        return description;
    }

    public void setDescription(final String description)
    {
        this.description = description;
    }

    @Override
    public boolean equals(final Object o)
    {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        final Course that = (Course) o;
        return id == that.id && Objects.equals(title, that.title) &&
               Objects.equals(section, that.section) &&
               Objects.equals(format, that.format) &&
               Objects.equals(mentor, that.mentor) &&
               Objects.equals(sectionStatus, that.sectionStatus) &&
               Objects.equals(meets, that.meets) &&
               Objects.equals(dates, that.dates) &&
               Objects.equals(description, that.description);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(id, title, section, format, mentor, sectionStatus,
                            meets, dates, description);
    }
}
