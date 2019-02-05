package stock.exchange.example.hibernate.manager;


import stock.exchange.example.operation.Broker;
import stock.exchange.example.operation.BuyStock;
import stock.exchange.example.operation.Stock;
import stock.exchange.example.utility.EntityManagerUtility;

import javax.persistence.EntityManager;

public class UserStockManager {


    private EntityManager entityManager = EntityManagerUtility.getEntityManager();


    public Stock buyStock(String stockCode, String userid) {

        Stock stock = new Stock();

        BuyStock buyStockOrder = new BuyStock(stock);

        try {

            Broker broker = new Broker();
            broker.takeOrder(buyStockOrder);

            broker.placeOrders();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        }
        return stock;
    }

    public Stock sellStock(String stockCode, String userid) {
        Stock stock = new Stock();
        try {

        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        }
        return stock;
    }
}