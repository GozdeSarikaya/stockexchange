package hibernate.tables;


import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name="Stock")
public class Stock implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    private Profile profile;

    @Column(name="code", unique = true)
    private String code;

    @Column(name="stockname")
    private String stockname;

    @Column(name="lastmodifiedby")
    private int lastmodifiedby;

    @Column(name="createddate")
    private Timestamp createddate;

    @Column(name="lastmodifieddate")
    private Timestamp lastmodifieddate;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStockname() {
        return stockname;
    }

    public void setStockname(String stockname) {
        this.stockname = stockname;
    }

    public int getLastmodifiedby() {
        return lastmodifiedby;
    }

    public void setLastmodifiedby(int lastmodifiedby) {
        this.lastmodifiedby = lastmodifiedby;
    }

    public Timestamp getCreateddate() {
        return createddate;
    }

    public void setCreateddate(Timestamp createddate) {
        this.createddate = createddate;
    }

    public Timestamp getLastmodifieddate() {
        return lastmodifieddate;
    }

    public void setLastmodifieddate(Timestamp lastmodifieddate) {
        this.lastmodifieddate = lastmodifieddate;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }
}
