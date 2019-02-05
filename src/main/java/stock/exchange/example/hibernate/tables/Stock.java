package stock.exchange.example.hibernate.tables;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String code;
    private String stockname;
    private String lastmodifiedby;
    private Timestamp createddate;
    private Timestamp lastmodifieddate;

    //@Column(name="code", unique = true)
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }

    //@Column(name="stockname")
    public String getStockname() {
        return stockname;
    }
    public void setStockname(String stockname) {
        this.stockname = stockname;
    }

    //@Column(name="createddate")
    public Timestamp getCreateddate() {
        return createddate;
    }
    public void setCreateddate(Timestamp createddate) {
        this.createddate = createddate;
    }

    //@Column(name="lastmodifieddate")
    public Timestamp getLastmodifieddate() {
        return lastmodifieddate;
    }
    public void setLastmodifieddate(Timestamp lastmodifieddate) {
        this.lastmodifieddate = lastmodifieddate;
    }

    //@Column(name="lastmodifiedby")
    public String getLastmodifiedby() {
        return lastmodifiedby;
    }
    public void setLastmodifiedby(String lastmodifiedby) {
        this.lastmodifiedby = lastmodifiedby;
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", stockname='" + stockname + '\'' +
                ", lastmodifiedby=" + lastmodifiedby +
                ", createddate=" + createddate +
                ", lastmodifieddate=" + lastmodifieddate +
                '}';
    }
}
