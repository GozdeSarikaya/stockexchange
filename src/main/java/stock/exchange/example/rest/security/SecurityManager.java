package stock.exchange.example.rest.security;

import stock.exchange.example.hibernate.manager.StockManager;
import stock.exchange.example.hibernate.manager.UserManager;
import stock.exchange.example.hibernate.manager.UserStockManager;

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

    //endregion

    //region Public Members
    public SecurityContext getSecurityContext() {
        return securityContext;
    }

    public StockManager getStockManager() {
        if (stockManager == null)
            initializeStockManager();
        return stockManager;
    }

    public UserStockManager getUserStockManager() {
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

    private void initialize() throws Exception {
        this.securityContext = new SecurityContext();
    }

    private void initializeUserStockManager() {
        userStockManager = new UserStockManager(securityContext.getUserSessionView());
    }

    private void initializeUserManager() {
        userManager = new UserManager(securityContext.getUserSessionView());
    }

    private void initializeStockManager() {
        stockManager = new StockManager(securityContext.getUserSessionView());
    }



    //endregion



}
