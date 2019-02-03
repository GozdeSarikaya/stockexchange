package com.netas.interview.hibernate.tables;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Entity
public class Profile  {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String profilename;

    public String getProfilename() {
        return profilename;
    }
    public void setProfilename(String profilename) {
        this.profilename = profilename;
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", profilename='" + profilename + '\'' +
                '}';
    }
}
