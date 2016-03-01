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
    public User addUsers(final User user) {
        return (User)transactionManager.doInTransaction(new Transaction() {
            @Override
            public Object action() {
                try {
                    userDAO.addUser(user);
                    LOG.info("User added");
                } catch (SQLException e) {
                    LOG.error("User no added");
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
