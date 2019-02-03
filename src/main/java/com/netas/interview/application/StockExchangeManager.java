package com.netas.interview.application;

import com.netas.interview.http.server.HttpServer;

public class StockExchangeManager {

    //region Constructor

    public StockExchangeManager() {
        initialize();
    }


    //endregion

    //region Private Members
    private StockExchangeContext stockExchangeContext;
    private HttpServer httpServer;

    //endregion




    //region Public Methods

    public void initialize() {

        stockExchangeContext = new StockExchangeContext(new StockExchangeConfiguration());
        httpServer = new HttpServer();
        try {
            httpServer.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public StockExchangeContext getStockExchangeContext() {
        return stockExchangeContext;
    }


    //endregion
}
