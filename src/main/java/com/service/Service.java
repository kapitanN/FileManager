package com.service;

import com.DAO.Transaction;
import com.DAO.TransactionManager;
import com.DAO.User;
import com.DAO.UserDAO;
import com.storage.Storage;
import org.apache.log4j.Logger;

import java.io.File;
import java.sql.SQLException;

/**
 * Created by Nikita on 01.03.2016.
 */
public class Service {
    private static final Logger LOG = Logger.getLogger(Service.class);

    TransactionManager transactionManager;
    UserDAO userDAO;

    public Service(){
        super();
        userDAO = new UserDAO();
        this.transactionManager = new TransactionManager();
    }
    public Service(TransactionManager transactionManager){
        this.transactionManager = transactionManager;
    }


    public void setPath(final String login, final String folderName){
        transactionManager.doInTransaction(new Transaction() {
            @Override
            public Object action() {
                int id = getUserByLogin(login).getIdUser();
                try {
                    userDAO.setPath(id, folderName);
                } catch (SQLException e) {
                    LOG.error(e);
                }
                return null;
            }
        });
    }

    public User getUserByLogin(final String login){
        return (User)transactionManager.doInTransaction(new Transaction() {
            @Override
            public Object action() {
                User result = null;
                try {
                    result = userDAO.getUserByLogin(login);
                } catch (SQLException e) {
                    LOG.error(e);
                }

                return result;
            }
        });
    }

    public String getPath(final int id){
        return (String) transactionManager.doInTransaction(new Transaction() {
            @Override
            public Object action() {
                String result = null;
                try {
                    result = userDAO.getPath(id);
                } catch (SQLException e) {
                    LOG.error(e);
                }
                return result;
            }
        });
    }

    public User addUsers(final User user) {
        return (User)transactionManager.doInTransaction(new Transaction() {
            @Override
            public Object action() {
                try {
                    userDAO.addUser(user);
                    LOG.info("User added");
                } catch (SQLException e) {
                    LOG.error("User no added" + e);
                }
                return null;
            }
        });
    }

    public void deleteUser(final String login, final File file) {
        transactionManager.doInTransaction(new Transaction() {
            @Override
            public Object action() {
                Storage storage = new Storage();
                try {
                    storage.deleteFiles(file);
                    int id = userDAO.getUserByLogin(login).getIdUser();
                    userDAO.deleteFiles(id);
                    userDAO.deleteUser(login);

                } catch (SQLException e) {
                    LOG.error(e);
                }
                return null;
            }
        });
    }
}
