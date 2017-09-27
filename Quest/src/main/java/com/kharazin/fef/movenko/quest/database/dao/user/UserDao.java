package com.kharazin.fef.movenko.quest.database.dao.user;


import com.kharazin.fef.movenko.quest.entity.User;

import java.sql.Connection;


public interface UserDao{

    User findByLogin(String login, Connection connection);

    boolean saveUser(User user, Connection connection);

    boolean exists(User user, Connection connection);
}
