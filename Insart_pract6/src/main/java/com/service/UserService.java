package com.service;

import com.DAO.User;

/**
 * Created by Nikita on 01.03.2016.
 */
public interface UserService {
    User addUsers(User user);
    void deleteUser(String login);
}
