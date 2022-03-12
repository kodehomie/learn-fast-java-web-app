package org.justinhoang.entity;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
public class CourseDescription
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String courseDescription;

}
