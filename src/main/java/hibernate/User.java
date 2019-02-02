package hibernate;

public class User {

    private int id;
    private String login;
    private String email;
    private String profiles;
    private String createddate;
    private String lastmodifieddate;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProfiles() {
        return profiles;
    }

    public void setProfiles(String profiles) {
        this.profiles = profiles;
    }

    public String getCreateddate() {
        return createddate;
    }

    public void setCreateddate(String createddate) {
        this.createddate = createddate;
    }

    public String getLastmodifieddate() {
        return lastmodifieddate;
    }

    public void setLastmodifieddate(String lastmodifieddate) {
        this.lastmodifieddate = lastmodifieddate;
    }
}
