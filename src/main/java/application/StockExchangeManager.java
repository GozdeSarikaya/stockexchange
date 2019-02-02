package application;

public class StockExchangeManager {

    //region Constructor

    public StockExchangeManager() {
        initialize();
    }


    //endregion

    //region Private Members
    private StockExchangeContext stockExchangeContext;

    //endregion




    //region Public Methods

    public void initialize() {
        stockExchangeContext = new StockExchangeContext(new StockExchangeConfiguration());
    }

    public StockExchangeContext getStockExchangeContext() {
        return stockExchangeContext;
    }


    //endregion
}
