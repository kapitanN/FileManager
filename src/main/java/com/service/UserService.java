package com.service;

import com.DAO.User;

import java.io.File;

/**
 * Created by Nikita on 01.03.2016.
 */
public interface UserService {
    User addUsers(User user);
    void deleteUser(String login, File file);
    User getUserByLogin(String login);
    String getPath(int id);
    void setPath(String login, String folderName);
}
