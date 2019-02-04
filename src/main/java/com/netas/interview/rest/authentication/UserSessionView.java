package com.netas.interview.rest.authentication;

public class UserSessionView implements java.io.Serializable
{
    private String loginname;
    private String userType="Admin";

    public UserSessionView() {
    }

    public String getLoginname() {
        return loginname;
    }

    public void setLoginname(String loginname) {
        this.loginname = loginname;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }
}

