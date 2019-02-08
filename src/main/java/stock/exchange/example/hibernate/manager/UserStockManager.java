package stock.exchange.example.hibernate.manager;


import stock.exchange.example.hibernate.tables.UserStock;
import stock.exchange.example.rest.authentication.UserSessionView;
import stock.exchange.example.utility.EntityManagerUtility;

import javax.persistence.EntityManager;

public class UserStockManager {

    public UserStockManager(UserSessionView userSessionView) {
        this.userSessionView = userSessionView;
    }

    private EntityManager entityManager = EntityManagerUtility.getEntityManager();
    private UserSessionView userSessionView;

    public UserStock editUserStockAmount(String loginname, String stockCode, int amout)throws Exception {

        UserStock userStock;
        try {
            entityManager.getTransaction().begin();
            userStock = (UserStock) entityManager.find(UserStock.class, loginname); //TODO
            userStock.setStockcount(amout);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw new Exception("UserStock could not be bought!");
        }

        return userStock;
    }

    public UserStock getUserStockAmount(String loginname, String code)throws Exception {

        UserStock userStock;
        try {
            entityManager.getTransaction().begin();
            userStock = (UserStock)entityManager.createQuery("Select e.stockcount from UserStock e where e.code='"+code+"'").getResultList().get(0);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw new Exception("UserStock could not be bought!");
        }

        return userStock;
    }

    public UserStock buyStock(String loginname, String stockCode, int amount)throws Exception {

            UserStock userStock = new UserStock();
            try {
                entityManager.getTransaction().begin();
                userStock.setStockcount(amount);
                userStock.setCode(stockCode);
                userStock.setLoginname(loginname);
                entityManager.merge(userStock);
                entityManager.getTransaction().commit();
            } catch (Exception e) {
                entityManager.getTransaction().rollback();
                throw new Exception("UserStock could not be bought!");
            }

        return userStock;
    }

    public UserStock sellStock(String loginname,String stockCode, int amount) throws Exception {
        UserStock userStock = new UserStock();
        try {
            entityManager.getTransaction().begin();
            userStock.setStockcount(amount);
            userStock.setCode(stockCode);
            userStock.setLoginname(loginname);
            entityManager.merge(userStock);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw new Exception("Stock could not be sold out!");
        }

        return userStock;
    }
}
