package hibernate.view.Stock;

import java.sql.Timestamp;

public class EditStockView {

    private String stockname;
    private int lastmodifiedby;

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


}
