package stock.exchange.example.hibernate.tables;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
