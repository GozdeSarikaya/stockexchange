package stock.exchange.example.application;

public class StockExchangeContext {

    //region Constructor

    public StockExchangeContext(StockExchangeConfiguration stockExchangeConfiguration) {
        initialize(stockExchangeConfiguration);
    }


    //endregion

    //region Private Members

    private StockExchangeConfiguration stockExchangeConfiguration;

    //endregion


    //region Public Methods

    public void initialize(StockExchangeConfiguration stockExchangeConfiguration) {
        this.stockExchangeConfiguration = stockExchangeConfiguration;
    }

    public StockExchangeConfiguration getStockExchangeConfiguration() {
        return stockExchangeConfiguration;
    }

    public void setStockExchangeConfiguration(StockExchangeConfiguration stockExchangeConfiguration) {
        this.stockExchangeConfiguration = stockExchangeConfiguration;
    }

    //endregion
}
