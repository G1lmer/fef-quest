package com.kharazin.fef.movenko.quest.database.service.user;

import com.kharazin.fef.movenko.quest.database.dao.user.UserDao;
import com.kharazin.fef.movenko.quest.database.service.user.UserService;
import com.kharazin.fef.movenko.quest.database.transaction.TransactionManager;
import com.kharazin.fef.movenko.quest.entity.User;


public class UserServiceImpl implements UserService {

    private TransactionManager transactionManager;

    private UserDao userDao;

    public UserServiceImpl(TransactionManager transactionManager, UserDao userDao) {
        this.transactionManager = transactionManager;
        this.userDao = userDao;
    }

    @Override
    public User findByLogin(String login) {
        return transactionManager.executeInTransaction(connection -> userDao.findByLogin(login,connection));
    }

    @Override
    public boolean exists(User user) {
        return transactionManager.executeInTransaction(connection -> userDao.exists(user,connection));
    }
}
