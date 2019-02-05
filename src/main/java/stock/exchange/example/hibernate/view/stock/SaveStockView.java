package stock.exchange.example.hibernate.view.stock;

import java.io.Serializable;

public class SaveStockView  implements Serializable {

    private String code;
    private String stockname;
    private String lastmodifiedby;

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

    public String getLastmodifiedby() {
        return lastmodifiedby;
    }

    public void setLastmodifiedby(String lastmodifiedby) {
        this.lastmodifiedby = lastmodifiedby;
    }
}
