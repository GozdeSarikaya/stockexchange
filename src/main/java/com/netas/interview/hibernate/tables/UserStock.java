package com.netas.interview.hibernate.tables;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UserStock {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private int userid;
    private int stockid;


    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", userid=" + userid +
                ", stockid=" + stockid +
                '}';
    }
}
