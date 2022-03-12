package org.justinhoang.entity;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
public class CourseDate
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String meetingDates;

}
