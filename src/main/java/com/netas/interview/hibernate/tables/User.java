package com.netas.interview.hibernate.tables;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name = "User")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String profilename;
    private String loginname;
    private String password;
    private String email;
    private Timestamp createddate;
    private Timestamp lastmodifieddate;

    @Column(name="email")
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name="profilename")
    public String getProfilename() {
        return profilename;
    }
    public void setProfilename(String profilename) {
        this.profilename = profilename;
    }

    @Column(name="loginname")
    public String getLoginname() {
        return loginname;
    }
    public void setLoginname(String loginname) {
        this.loginname = loginname;
    }

    @Column(name="password")
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name="createddate")
    public Timestamp getCreateddate() {
        return createddate;
    }
    public void setCreateddate(Timestamp createddate) {
        this.createddate = createddate;
    }

    @Column(name="lastmodifieddate")
    public Timestamp getLastmodifieddate() {
        return lastmodifieddate;
    }
    public void setLastmodifieddate(Timestamp lastmodifieddate) {
        this.lastmodifieddate = lastmodifieddate;
    }
}
