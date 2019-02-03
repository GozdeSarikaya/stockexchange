package com.netas.interview.hibernate.tables;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String profilename;
    private String loginname;
    private String password;
    private String email;
    private Timestamp createddate;
    private Timestamp lastmodifieddate;

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getProfilename() {
        return profilename;
    }
    public void setProfilename(String profilename) {
        this.profilename = profilename;
    }

    public String getLoginname() {
        return loginname;
    }
    public void setLoginname(String loginname) {
        this.loginname = loginname;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public Timestamp getCreateddate() {
        return createddate;
    }
    public void setCreateddate(Timestamp createddate) {
        this.createddate = createddate;
    }

    // @Column(name="lastmodifieddate")
    public Timestamp getLastmodifieddate() {
        return lastmodifieddate;
    }
    public void setLastmodifieddate(Timestamp lastmodifieddate) {
        this.lastmodifieddate = lastmodifieddate;
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", profilename='" + profilename + '\'' +
                ", loginname='" + loginname + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", createddate=" + createddate +
                ", lastmodifieddate=" + lastmodifieddate +
                '}';
    }
}
