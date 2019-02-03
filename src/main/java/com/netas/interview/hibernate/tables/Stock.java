package com.netas.interview.hibernate.tables;


import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name="Stock")
public class Stock implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String code;
    private String stockname;
    private int lastmodifiedby;
    private Timestamp createddate;
    private Timestamp lastmodifieddate;

    @Column(name="code", unique = true)
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }

    @Column(name="stockname")
    public String getStockname() {
        return stockname;
    }
    public void setStockname(String stockname) {
        this.stockname = stockname;
    }

    @Column(name="createddate")
    public Timestamp getCreateddate() {
        return createddate;
    }
    public void setCreateddate(Timestamp createddate) {
        this.createddate = createddate;
    }

    @Column(name="lastmodifieddate")
    public Timestamp getLastmodifieddate() {
        return lastmodifieddate;
    }
    public void setLastmodifieddate(Timestamp lastmodifieddate) {
        this.lastmodifieddate = lastmodifieddate;
    }

    @Column(name="lastmodifiedby")
    public int getLastmodifiedby() {
        return lastmodifiedby;
    }
    public void setLastmodifiedby(int lastmodifiedby) {
        this.lastmodifiedby = lastmodifiedby;
    }
}
