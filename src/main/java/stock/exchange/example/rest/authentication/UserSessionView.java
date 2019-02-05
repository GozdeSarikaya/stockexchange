package stock.exchange.example.rest.authentication;

public class UserSessionView implements java.io.Serializable
{
    private String loginname;
    private String userType;

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

