package com.service;

import com.DAO.TransactionManager;

/**
 * Created by Nikita on 01.03.2016.
 */
public class Service {
    TransactionManager transactionManager;

    public Service(){
        super();
        this.transactionManager = new TransactionManager();
    }

    public Service(TransactionManager transactionManager){
        this.transactionManager = transactionManager;
    }
}
