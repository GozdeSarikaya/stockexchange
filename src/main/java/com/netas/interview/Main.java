package com.netas.interview;

import com.netas.interview.application.StockExchangeManager;

public class Main {

    public static void main(String[] args) {

        StockExchangeManager stockExchangeManager;
        try {
            stockExchangeManager = new StockExchangeManager();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }




}
