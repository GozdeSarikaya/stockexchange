package stock.exchange.example.application;

import stock.exchange.example.http.server.application.HttpServerManager;

public class StockExchangeManager {

    //region Constructor

    public StockExchangeManager() {
        initialize();
    }


    //endregion

    //region Private Members
    private StockExchangeContext stockExchangeContext;
    private HttpServerManager httpServerManager;

    //endregion


    //region Public Methods

    public void initialize() {

        stockExchangeContext = new StockExchangeContext(new StockExchangeConfiguration());
        httpServerManager = new HttpServerManager();
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
