package com.netas.interview.hibernate.manager;

import com.netas.interview.hibernate.tables.Stock;
import com.netas.interview.hibernate.view.stock.EditStockView;
import com.netas.interview.hibernate.view.stock.SaveStockView;
import com.netas.interview.utility.EntityManagerUtility;

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


    public void deleteStock(int stockid) {
        try {
            entityManager.getTransaction().begin();
            Stock stock = (Stock) entityManager.find(Stock.class, stockid);
            entityManager.remove(stock);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        }

    }

    public Stock getStock(int stockid) {
        Stock stock = new Stock();
        try {
            entityManager.getTransaction().begin();
            stock = (Stock) entityManager.find(Stock.class, stockid);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
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
