package com.netas.interview.hibernate.view.stock;

import java.io.Serializable;

public class EditStockView implements Serializable {

    private int id;
    private String stockname;
    private String lastmodifiedby;

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

    public String getLastmodifiedby() {
        return lastmodifiedby;
    }

    public void setLastmodifiedby(String lastmodifiedby) {
        this.lastmodifiedby = lastmodifiedby;
    }


}
