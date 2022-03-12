package org.justinhoang.entity;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
public class CourseFormat
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

}
