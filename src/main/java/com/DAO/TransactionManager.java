package com.DAO;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by Nikita on 01.03.2016.
 */
public class TransactionManager {

    private static final Logger LOG = Logger.getLogger(TransactionManager.class);

    public Object doInTransaction(Transaction transaction){
        Connection connection = ConnectionHolder.getConnection();
        Object result = null;
        try{
            connection.setAutoCommit(false);
            result = transaction.action();
            connection.commit();
        } catch (SQLException e) {
            LOG.info("Can`t create transaction" + e);
            try {
                connection.rollback();
            } catch (SQLException e1) {
                LOG.error(e1);
            }
        }
        return result;
    }
}
