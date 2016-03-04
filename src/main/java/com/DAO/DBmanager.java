package com.DAO;

import com.mysql.jdbc.Connection;
import org.apache.log4j.Logger;

import java.sql.DriverManager;
import java.sql.SQLException;


/**
 * Created by Nikita on 27.02.2016.
 */
public class DBmanager {
    private static final Logger LOG = Logger.getLogger(DBmanager.class);
    private static final String DB_DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/filestorage";
    private static final String USER = "root";
    private static final String PASS = "norton12";

    private DBmanager(){
        super();
    }

    public static Connection getConnection(){
        Connection connection = null;
        try{
            Class.forName(DB_DRIVER);
        } catch (ClassNotFoundException e) {
            LOG.info("Driver not found");
        }
        try {
            connection = (Connection) DriverManager.getConnection(URL,USER,PASS);
        }
        catch (SQLException e){
            LOG.info("Connection does`t create");
        }
        return connection;
    }

}
