package com.DAO;

import java.sql.Connection;

/**
 * Created by Nikita on 29.02.2016.
 */
public class ConnectionHolder {
    public static ThreadLocal<Connection> connectionThreadLocal = new ThreadLocal<>();

    public final static Connection getConnection(){
        return connectionThreadLocal.get();
    }

    public final static void setConnectionThreadLocal(Connection connection){
        ConnectionHolder.connectionThreadLocal.set(connection);
    }
}
