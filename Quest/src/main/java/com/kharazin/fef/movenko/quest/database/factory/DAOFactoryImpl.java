package com.kharazin.fef.movenko.quest.database.factory;


import com.kharazin.fef.movenko.quest.database.dao.group.GroupDao;
import com.kharazin.fef.movenko.quest.database.dao.group.GroupDaoImpl;
import com.kharazin.fef.movenko.quest.database.dao.user.UserDao;
import com.kharazin.fef.movenko.quest.database.dao.user.UserDaoImpl;

/**
 * Created by Serega on 03.08.2017.
 */
public class DAOFactoryImpl implements DAOFactory {

    @Override
    public UserDao getUserDao() {
        return new UserDaoImpl();
    }

    @Override
    public GroupDao getGroupDao() {
        return new GroupDaoImpl();
    }

}
