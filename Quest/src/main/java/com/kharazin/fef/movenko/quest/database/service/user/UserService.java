package com.kharazin.fef.movenko.quest.database.service.user;

import com.kharazin.fef.movenko.quest.entity.User;

public interface UserService {

    User findByLogin(String login);

    boolean exists(User user);
}
