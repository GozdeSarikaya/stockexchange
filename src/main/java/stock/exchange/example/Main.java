package stock.exchange.example;

import stock.exchange.example.application.StockExchangeManager;

public class Main {

    public static void main(String[] args) {

        StockExchangeManager stockExchangeManager;
        try {
            stockExchangeManager = new StockExchangeManager();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }




}
