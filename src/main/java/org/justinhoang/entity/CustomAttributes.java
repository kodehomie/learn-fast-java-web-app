package org.justinhoang.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;

@Data
@Entity
@Getter
@Setter
@ToString
public class CustomAttributes
{
    private String key;
    private String value;
}
