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
public class UserAttributes
{
    private String key;
    private String value;

}