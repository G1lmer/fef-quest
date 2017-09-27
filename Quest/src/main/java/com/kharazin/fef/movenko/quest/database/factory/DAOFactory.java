package com.kharazin.fef.movenko.quest.database.factory;


import com.kharazin.fef.movenko.quest.database.dao.group.GroupDao;
import com.kharazin.fef.movenko.quest.database.dao.user.UserDao;

public interface DAOFactory {

    UserDao getUserDao();

    GroupDao getGroupDao();

}
