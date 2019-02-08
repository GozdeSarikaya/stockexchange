package stock.exchange.example.application;

import stock.exchange.example.http.server.application.HttpServerManager;

import java.util.HashMap;
import java.util.Map;

public class StockExchangeManager {

    //region Constructor

    public StockExchangeManager() {
        initialize();
    }


    //endregion

    //region Private Members
    private StockExchangeContext stockExchangeContext;
    private HttpServerManager httpServerManager;
    public static Map<String, Double> price;
    public static double initialUserPrice = 10000;

    //endregion


    //region Public Methods

    public void initialize() {

        stockExchangeContext = new StockExchangeContext(new StockExchangeConfiguration());
        httpServerManager = new HttpServerManager();
        price = new HashMap<>();

        try {
            httpServerManager.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public StockExchangeContext getStockExchangeContext() {
        return stockExchangeContext;
    }


    //endregion
}
