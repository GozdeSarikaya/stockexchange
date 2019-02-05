package stock.exchange.example.hibernate.manager;

import stock.exchange.example.hibernate.tables.Stock;
import stock.exchange.example.hibernate.view.stock.EditStockView;
import stock.exchange.example.hibernate.view.stock.SaveStockView;
import stock.exchange.example.utility.EntityManagerUtility;

import javax.persistence.EntityManager;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class StockManager {

    private EntityManager entityManager = EntityManagerUtility.getEntityManager();


    public Stock saveStock(SaveStockView stockView) {
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
        }
        return stock;
    }


    public void deleteStock(String code) {
        try {
            entityManager.getTransaction().begin();
            List<Stock> stock = (List<Stock>)entityManager.createQuery("Select e from Stock e where e.code='"+code+"'").getResultList();
            entityManager.remove(stock);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        }

    }

    public Stock getStock(String code) {
        Stock stock;
        try {
            entityManager.getTransaction().begin();
            stock = (Stock)entityManager.createQuery("Select e from Stock e where e.code='"+code+"'").getResultList().get(0);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            return null;
        }
        return stock;
    }

    public void editStock(EditStockView editStockView) {
        try {
            entityManager.getTransaction().begin();
            Stock stock = (Stock) entityManager.find(Stock.class, editStockView.getId());
            stock.setLastmodifiedby(editStockView.getLastmodifiedby());
            stock.setStockname(editStockView.getStockname());
            stock.setLastmodifieddate(new Timestamp(System.currentTimeMillis()));
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        }
    }


    public List<Stock> getStockList() {
        List<Stock> stocks = new ArrayList<>();
        try {
            entityManager.getTransaction().begin();
            stocks = entityManager.createQuery("Select e from Stock e").getResultList();
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        }
        return stocks;
    }



}
