package com.kharazin.fef.movenko.quest.database.dao.group;


import com.kharazin.fef.movenko.quest.entity.Group;
import com.kharazin.fef.movenko.quest.exception.OperationDaoException;

import java.sql.*;

public class GroupDaoImpl implements GroupDao {

    private static final String ADD_GROUP = "INSERT INTO groups (" +
            "team_name, team_login, school_name, members) VALUES (?, ?, ?, ?)";

    @Override
    public Group saveGroup(Group group, Connection connection) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(ADD_GROUP, Statement.RETURN_GENERATED_KEYS)) {
            beforeInsert(group, preparedStatement);
            if (preparedStatement.executeUpdate() > 0) {
                ResultSet resultSet = preparedStatement.getGeneratedKeys();
                if (resultSet.next()) {
                    group.setId(resultSet.getInt(1));
                }
            }
            return group;
        } catch (SQLException e) {
            throw new OperationDaoException("Can't handle sql ['" + ADD_GROUP + "']", e);
        }
    }

    private void beforeInsert(Group group, PreparedStatement preparedStatement) throws SQLException {
        int k = 1;
        preparedStatement.setString(k++, group.getName());
        preparedStatement.setString(k++, group.getTeamLogin());
        preparedStatement.setString(k++, group.getSchoolName());
        preparedStatement.setInt(k, group.getMembersQuantity());
    }

    @Override
    public Group findGroupById(long id, Connection connection) {
        return null;
    }

    @Override
    public Group findGroupByName(String name, Connection connection) {
        return null;
    }

}
