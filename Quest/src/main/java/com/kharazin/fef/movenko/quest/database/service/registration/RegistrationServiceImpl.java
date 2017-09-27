package com.kharazin.fef.movenko.quest.database.service.registration;


import com.kharazin.fef.movenko.quest.database.dao.group.GroupDao;
import com.kharazin.fef.movenko.quest.database.dao.user.UserDao;
import com.kharazin.fef.movenko.quest.database.transaction.TransactionManager;
import com.kharazin.fef.movenko.quest.entity.Group;
import com.kharazin.fef.movenko.quest.entity.User;

import java.util.List;

public class RegistrationServiceImpl implements RegistrationService {

    private TransactionManager transactionManager;

    private UserDao userDao;

    private GroupDao groupDao;

    public RegistrationServiceImpl(TransactionManager transactionManager, UserDao userDao, GroupDao groupDao) {
        this.transactionManager = transactionManager;
        this.userDao = userDao;
        this.groupDao = groupDao;
    }

    @Override
    public boolean registerTeam(Group group, List<User> users) {
        Group registeredGroup = transactionManager.executeInTransaction(
                connection -> groupDao.saveGroup(group,connection));
        for(User user : users){
            user.setGroup(registeredGroup);
            transactionManager.executeInTransaction(connection -> userDao.saveUser(user,connection));
        }
        return true;
    }
}
