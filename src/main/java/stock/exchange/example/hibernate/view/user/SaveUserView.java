package stock.exchange.example.hibernate.view.user;


import java.io.Serializable;


public class SaveUserView implements Serializable {


    private String profilename;
    private String loginname;
    private String email;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
