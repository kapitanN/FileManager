package com.DAO;

import org.apache.log4j.Logger;

import javax.jws.soap.SOAPBinding;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Nikita on 28.02.2016.
 */
public class UserDAO {
    private static final Logger LOG = Logger.getLogger(UserDAO.class);

    private static final String USER_ID = "id";
    private static final String USER_FIRSTNAME = "firstname";
    private static final String USER_LASTNAME = "lastname";
    private static final String USER_LOGIN = "login";
    private static final String USER_PASSWORD = "password";

    private static final String ADD_USER = "INSERT INTO logins (firstname, lastname, login, password) VALUES (?,?,?,?)";
    private static final String DELETE_USER = "DELETE FROM logins WHERE login=?";
    private static final String GET_USER_BY_LOGIN = "SELECT * FROM logins WHERE logins.login = ?";
    private static final String GET_PATH = "SELECT foldername FROM filepath WHERE filepath.id_user = ?";

    public User getUserByLogin(String login) throws SQLException {
        PreparedStatement statement = null;
        User user = null;
        ResultSet resultSet = null;
        try {
            statement = ConnectionHolder.getConnection().prepareStatement(GET_USER_BY_LOGIN);
            statement.setString(1, login);
            resultSet = statement.executeQuery();
            if (resultSet.next()){
                user = extractUser(resultSet);
            }
        } catch (SQLException e) {
            LOG.error(e);
        }finally {
            statement.close();
            resultSet.close();
        }
        return user;
    }
    public String getPath(int id) throws SQLException{
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String path = null;
        try{
            statement = ConnectionHolder.getConnection().prepareStatement(GET_PATH);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            if (resultSet.next()){
                path = resultSet.getString("foldername");
            }
        }
        catch (SQLException e){
            LOG.error(e);
        }finally {
            statement.close();
        }
        return path;
    }

    public void addUser(User user) throws SQLException{
        PreparedStatement statement = null;
        try {
            statement = ConnectionHolder.getConnection().prepareStatement(ADD_USER);
            statement.setString(1, user.getFirstName());
            statement.setString(2, user.getLastName());
            statement.setString(3, user.getLogin());
            statement.setString(4, user.getPassword());
            statement.execute();
        }
        catch (SQLException e) {
            LOG.error(e);
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
            LOG.error(e);
        }
        finally {
            statement.close();
        }
    }

    private User extractUser(ResultSet rs) throws SQLException {
        User user = new User();
        user.setIdUser(rs.getInt(USER_ID));
        user.setFirstName(rs.getString(USER_FIRSTNAME));
        user.setLastName(rs.getString(USER_LASTNAME));
        user.setLogin(rs.getString(USER_LOGIN));
        user.setPassword(rs.getString(USER_PASSWORD));
        return user;
    }

}
