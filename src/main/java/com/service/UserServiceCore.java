package com.service;

import com.DAO.Transaction;
import com.DAO.User;
import com.DAO.UserDAO;
import org.apache.log4j.Logger;

import java.sql.SQLException;

/**
 * Created by Nikita on 01.03.2016.
 */
public class UserServiceCore extends Service implements UserService {
    private static final Logger LOG = Logger.getLogger(UserServiceCore.class);

    UserDAO userDAO;

    public UserServiceCore(){
        super();
        userDAO = new UserDAO();
    }


    @Override
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

    @Override
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

    @Override
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

    @Override
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

    @Override
    public void deleteUser(final String login) {
        transactionManager.doInTransaction(new Transaction() {
            @Override
            public Object action() {
                try {
                    userDAO.deleteUser(login);
                } catch (SQLException e) {
                    LOG.error(e);
                }
                return null;
            }
        });
    }
}
