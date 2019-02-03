package com.netas.interview.hibernate.manager;

import com.netas.interview.hibernate.tables.Stock;
import com.netas.interview.hibernate.view.Stock.EditStockView;
import com.netas.interview.hibernate.view.Stock.SaveStockView;

import javax.persistence.EntityManager;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class StockManager {

    private EntityManager entityManager = null;//EntityManager.getEntityManager();


    public Stock saveStock(SaveStockView stockView) {
        Stock stock = new Stock();
        SaveStockView stockViews = new SaveStockView();
        try {
            entityManager.getTransaction().begin();
            stockViews.setCode(stockView.getCode());
            stockViews.setStockname(stockView.getStockname());
            stockViews.setLastmodifiedby(stockView.getLastmodifiedby());
            stockViews.setCreateddate(new Timestamp(System.currentTimeMillis()));
            stockViews.setLastmodifieddate(new Timestamp(System.currentTimeMillis()));
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
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        }
        return stock;
    }

    public void editStock(EditStockView editStockView) {
        try {
            entityManager.getTransaction().begin();
            Stock stock = (Stock) entityManager.find(Stock.class, editStockView.getStockname());
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
            String sql = "select '*' from Stock";
            stocks = entityManager.createQuery(sql).getResultList();

            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        }
        return stocks;
    }


    public Stock buyStock() {
        Stock stock = new Stock();
        try {

        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        }
        return stock;
    }

    public Stock sellStock() {
        Stock stock = new Stock();
        try {

        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        }
        return stock;
    }
}
