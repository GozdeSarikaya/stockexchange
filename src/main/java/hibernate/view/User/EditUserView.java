package hibernate.view.User;

import java.sql.Timestamp;

public class EditUserView {

    private String loginname;
    private String password;


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

}
