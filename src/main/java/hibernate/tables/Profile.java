package hibernate.tables;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="Profile")
public class Profile implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private int id;

    @Column(name="profilename", nullable = false)
    private String profilename;

    public String getProfilename() {
        return profilename;
    }

    public void setProfilename(String profilename) {
        this.profilename = profilename;
    }
}
