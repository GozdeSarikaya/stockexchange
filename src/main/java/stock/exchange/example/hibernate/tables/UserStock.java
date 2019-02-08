package stock.exchange.example.hibernate.tables;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UserStock {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String loginname;
    private String code;
    private int stockcount;
    private double totalprice;

    public String getLoginname() {
        return loginname;
    }

    public void setLoginname(String loginname) {
        this.loginname = loginname;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getStockcount() {
        return stockcount;
    }

    public void setStockcount(int stockcount) {
        this.stockcount = stockcount;
    }


    public double getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(double totalprice) {
        this.totalprice = totalprice;
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", loginname='" + loginname + '\'' +
                ", code='" + code + '\'' +
                ", stockcount=" + stockcount +
                ", totalprice=" + totalprice +
                '}';
    }
}
