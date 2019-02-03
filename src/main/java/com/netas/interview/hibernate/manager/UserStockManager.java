package com.netas.interview.hibernate.manager;

import com.netas.interview.hibernate.tables.Stock;
import com.netas.interview.utility.EntityManagerUtility;

import javax.persistence.EntityManager;

public class UserStockManager {


    private EntityManager entityManager = EntityManagerUtility.getEntityManager();


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
