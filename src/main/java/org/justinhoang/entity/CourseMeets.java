package org.justinhoang.entity;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
public class CourseMeets
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String meetingDays;

}
