package com.DAO;

import org.apache.log4j.Logger;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by Nikita on 28.02.2016.
 */
public class UserDAO {
    private static final Logger LOG = Logger.getLogger(UserDAO.class);

    private static final String USER_FIRSTNAME = "firstName";
    private static final String USER_LASTNAME = "lastName";
    private static final String USER_LOGIN = "login";
    private static final String USER_PASSWORD = "password";

    private static final String ADD_USER = "INSERT INTO logins (firstname, lastname, login, password) VALUES (?,?,?,?)";
    private static final String DELETE_USER = "DELETE FROM logins WHERE login=?";

    public void addUser(User user) throws SQLException{
        PreparedStatement statement = null;
        try {
            statement = ConnectionHolder.getConnection().prepareStatement(ADD_USER);
            statement.setString(1, user.getFirstName());
            statement.setString(2, user.getLastName());
            statement.setString(3, user.getLogin());
            statement.setString(4, user.getPassword());
        }
        catch (SQLException e) {
            LOG.error(e.getStackTrace());
        }
        finally {
            statement.close();
        }
    }

    public void deleteUser(String login) throws SQLException{
        PreparedStatement statement = null;
        try{
            statement = ConnectionHolder.getConnection().prepareStatement(DELETE_USER);
            statement.setString(1, login);
        }
        catch (SQLException e){
            LOG.error(e.getStackTrace());
        }
        finally {
            statement.close();
        }
    }

}
