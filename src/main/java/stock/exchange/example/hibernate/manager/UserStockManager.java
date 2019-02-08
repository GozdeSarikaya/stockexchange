package stock.exchange.example.hibernate.manager;


import stock.exchange.example.hibernate.tables.UserStock;
import stock.exchange.example.rest.authentication.UserSessionView;
import stock.exchange.example.utility.EntityManagerUtility;

import javax.persistence.EntityManager;
import java.util.List;

import static stock.exchange.example.application.StockExchangeManager.initialUserPrice;
import static stock.exchange.example.application.StockExchangeManager.price;

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

    public UserStock buyStock(String loginname, String code, int amount)throws Exception {

        List<UserStock> userStock;
        UserStock userStock1;
            try {
                entityManager.getTransaction().begin();
                userStock = (List<UserStock>)entityManager.createQuery("Select e from UserStock e where e.code='"+code+"' and e.loginname='"+loginname+"'").getResultList();

                if(userStock.size()>0) {

                    if(userStock.get(0).getTotalprice()>price.get(code)*amount) {
                        userStock.get(0).setStockcount(userStock.get(0).getStockcount() + amount);
                        userStock.get(0).setTotalprice(userStock.get(0).getTotalprice() - price.get(code) * amount);
                        entityManager.merge(userStock.get(0));
                        entityManager.getTransaction().commit();
                        return userStock.get(0);
                    }
                    else
                        throw new Exception("Stock could not be sold out!");
                }
                else
                {
                    userStock1= new UserStock();
                    userStock1.setCode(code);
                    userStock1.setLoginname(loginname);
                    userStock1.setStockcount(amount);
                    userStock1.setTotalprice(initialUserPrice-price.get(code)*amount);
                    entityManager.merge(userStock1);
                    entityManager.getTransaction().commit();
                    return userStock1;
                }

            } catch (Exception e) {
                entityManager.getTransaction().rollback();
                throw new Exception("UserStock could not be bought!");
            }
    }

    public UserStock sellStock(String loginname,String code, int amount) throws Exception {
        List<UserStock> userStock;
        try {
            entityManager.getTransaction().begin();
            userStock = (List<UserStock>)entityManager.createQuery("Select e from UserStock e where e.code='"+code+"' and e.loginname='"+loginname+"'").getResultList();

            if(userStock.size()>0) {

                if(userStock.get(0).getStockcount()>amount) {
                    userStock.get(0).setStockcount(userStock.get(0).getStockcount() - amount);
                    userStock.get(0).setTotalprice(userStock.get(0).getTotalprice() + price.get(code) * amount);
                    entityManager.merge(userStock.get(0));
                    entityManager.getTransaction().commit();
                }
                else
                    throw new Exception("Stock could not be sold out!");
            }
            else
                throw new Exception("Stock could not be sold out!");
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw new Exception("Stock could not be sold out!");
        }

        return userStock.get(0);
    }
}
