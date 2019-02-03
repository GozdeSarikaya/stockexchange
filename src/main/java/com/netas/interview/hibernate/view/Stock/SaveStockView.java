package com.netas.interview.hibernate.view.Stock;

import java.sql.Timestamp;

public class SaveStockView {

    private String code;
    private String stockname;
    private int lastmodifiedby;
    private Timestamp createddate;
    private Timestamp lastmodifieddate;


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getStockname() {
        return stockname;
    }

    public void setStockname(String stockname) {
        this.stockname = stockname;
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

    public int getLastmodifiedby() {
        return lastmodifiedby;
    }

    public void setLastmodifiedby(int lastmodifiedby) {
        this.lastmodifiedby = lastmodifiedby;
    }
}
