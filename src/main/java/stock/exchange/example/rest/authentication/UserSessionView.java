package stock.exchange.example.rest.authentication;

public class UserSessionView implements java.io.Serializable
{
    private String loginname;
    private String profilename;

    public UserSessionView() {
    }

    public String getLoginname() {
        return loginname;
    }

    public void setLoginname(String loginname) {
        this.loginname = loginname;
    }

    public String getProfilename() {
        return profilename;
    }

    public void setProfilename(String profilename) {
        this.profilename = profilename;
    }
}

