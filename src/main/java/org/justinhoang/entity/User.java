package org.justinhoang.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class User implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",
            nullable = false)
    private Long   id;
    private String username;
    private String password;
    //    private List<UserAttributes> userAttributes;
    private String birthdate;
    private String email;
    private String phoneNumber;
    private String givenName;
    private String familyName;
    private String gender;

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }
    //    public List <UserAttributes > getUserAttributes() {
    //        return userAttributes;
    //    }
    //    public void setUserAttributes(List <UserAttributes > userAttributes) {
    //        this.userAttributes = userAttributes;
    //    }

    public String getBirthdate()
    {
        return birthdate;
    }

    public String getEmail()
    {
        return email;
    }

    public String getPhoneNumber()
    {
        return phoneNumber;
    }

    public String getGivenName()
    {
        return givenName;
    }

    public String getFamilyName()
    {
        return familyName;
    }

    public String getGender()
    {
        return gender;
    }

    public void setBirthdate(final String birthdate)
    {
        this.birthdate = birthdate;
    }

    public void setEmail(final String email)
    {
        this.email = email;
    }

    public void setPhoneNumber(final String phoneNumber)
    {
        this.phoneNumber = phoneNumber;
    }

    public void setGivenName(final String givenName)
    {
        this.givenName = givenName;
    }

    public void setFamilyName(final String familyName)
    {
        this.familyName = familyName;
    }

    public void setGender(final String gender)
    {
        this.gender = gender;
    }

//    @Override
//    public String toString()
//    {
//        return "User{" + "id=" + id + ", username='" + username + '\'' +
//               ", password='" + password + '\'' + ", userAttributes=" +
//               userAttributes + ", birthdate='" + birthdate + '\'' +
//               ", email='" + email + '\'' + ", phoneNumber='" + phoneNumber +
//               '\'' + ", givenName='" + givenName + '\'' + ", familyName='" +
//               familyName + '\'' + ", gender='" + gender + '\'' + '}';
//    }
}