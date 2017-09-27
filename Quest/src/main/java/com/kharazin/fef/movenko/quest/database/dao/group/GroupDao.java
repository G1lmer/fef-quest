package com.kharazin.fef.movenko.quest.database.dao.group;


import com.kharazin.fef.movenko.quest.entity.Group;

import java.sql.Connection;

public interface GroupDao {

    Group saveGroup(Group group, Connection connection);

    Group findGroupById(long id, Connection connection);

    Group findGroupByName(String name, Connection connection);

}
