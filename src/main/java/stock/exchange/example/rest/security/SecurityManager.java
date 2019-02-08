package stock.exchange.example.rest.security;

import stock.exchange.example.hibernate.manager.StockManager;
import stock.exchange.example.hibernate.manager.UserManager;
import stock.exchange.example.hibernate.manager.UserStockManager;
import stock.exchange.example.hibernate.tables.Stock;

import java.util.List;
import java.util.Random;

import static stock.exchange.example.application.StockExchangeManager.price;

public class SecurityManager {

    //region Constructor

    public SecurityManager() throws Exception {
        initialize();
    }
    //endregion

    //region Private Members
    private SecurityContext securityContext;
    private UserStockManager userStockManager;
    private UserManager userManager;
    private StockManager stockManager;
    private Random rnd = new Random();
    private double min = 1;
    private double max = 1000;

    //endregion

    //region Public Members
    public SecurityContext getSecurityContext() {
        return securityContext;
    }

    public StockManager getStockManager() throws Exception {
        if (stockManager == null)
            initializeStockManager();
        return stockManager;
    }

    public UserStockManager getUserStockManager()throws Exception {
        if (userStockManager == null)
            initializeUserStockManager();
        return userStockManager;
    }


    public UserManager getUserManager() {
        if (userManager == null)
            initializeUserManager();
        return userManager;
    }


    //endregion

    //region Private Methods

    private void initialize() throws Exception{
        this.securityContext = new SecurityContext();
        generateRandomStockPrice();
    }

    private void initializeUserStockManager() throws Exception{
        userStockManager = new UserStockManager(securityContext.getUserSessionView());
    }

    private void initializeUserManager() {
        userManager = new UserManager(securityContext.getUserSessionView());
    }

    private void initializeStockManager() throws Exception {
        stockManager = new StockManager(securityContext.getUserSessionView());
    }

    private void generateRandomStockPrice() throws Exception{

        List<Stock> stocks = getStockManager().getStockList();

        if (price.size() == 0 && stocks.size() > 0) {
            for (Stock stock : stocks) {
                double randomValue = min + (max - min) * rnd.nextDouble();
                price.put(stock.getCode(), randomValue);
            }
        }
    }


    //endregion


}
