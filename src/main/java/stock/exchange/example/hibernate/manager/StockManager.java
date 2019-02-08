package stock.exchange.example.hibernate.manager;

import stock.exchange.example.hibernate.tables.Stock;
import stock.exchange.example.hibernate.view.stock.EditStockView;
import stock.exchange.example.hibernate.view.stock.SaveStockView;
import stock.exchange.example.rest.authentication.UserSessionView;
import stock.exchange.example.utility.EntityManagerUtility;

import javax.persistence.EntityManager;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class StockManager {

    public StockManager(UserSessionView userSessionView) {
        this.userSessionView = userSessionView;
    }

    private EntityManager entityManager = EntityManagerUtility.getEntityManager();
    private UserSessionView userSessionView;


    public Stock saveStock(SaveStockView stockView) throws Exception {
        Stock stock = new Stock();

        try {
            entityManager.getTransaction().begin();
            stock.setCode(stockView.getCode());
            stock.setStockname(stockView.getStockname());
            stock.setLastmodifiedby(stockView.getLastmodifiedby());
            stock.setCreateddate(new Timestamp(System.currentTimeMillis()));
            stock.setLastmodifieddate(new Timestamp(System.currentTimeMillis()));
            stock = entityManager.merge(stock);
            entityManager.getTransaction().commit();

        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw new Exception("Stock could not be saved!");

        }
        return stock;
    }


    public void deleteStock(String code) throws Exception {
        try {
            entityManager.getTransaction().begin();
            List<Stock> stock = (List<Stock>)entityManager.createQuery("Select e from Stock e where e.code='"+code+"'").getResultList();
            entityManager.remove(stock);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw new Exception("Stock " + code + "could not be deleted!");

        }

    }

    public Stock getStock(String code) throws Exception {
        Stock stock;
        try {
            entityManager.getTransaction().begin();
            stock = (Stock)entityManager.createQuery("Select e from Stock e where e.code='"+code+"'").getResultList().get(0);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw new Exception("Stock "+code+" could not be get!");
        }
        return stock;
    }

    public void editStock(EditStockView editStockView) throws Exception {
        try {
            entityManager.getTransaction().begin();
            Stock stock = (Stock) entityManager.find(Stock.class, editStockView.getId());
            stock.setLastmodifiedby(editStockView.getLastmodifiedby());
            stock.setStockname(editStockView.getStockname());
            stock.setLastmodifieddate(new Timestamp(System.currentTimeMillis()));
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw new Exception("Stock could not be edited!");

        }
    }


    public List<Stock> getStockList() throws Exception{
        List<Stock> stocks = new ArrayList<>();
        try {
            entityManager.getTransaction().begin();
            stocks = entityManager.createQuery("Select e from Stock e").getResultList();
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw new Exception("Stock list could not be get!");

        }
        return stocks;
    }



}
