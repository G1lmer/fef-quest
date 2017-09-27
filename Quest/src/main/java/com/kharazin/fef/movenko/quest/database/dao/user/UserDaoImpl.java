package com.kharazin.fef.movenko.quest.database.dao.user;

import com.kharazin.fef.movenko.quest.constant.EntityFields;
import com.kharazin.fef.movenko.quest.entity.Group;
import com.kharazin.fef.movenko.quest.entity.User;
import com.kharazin.fef.movenko.quest.exception.OperationDaoException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {

    private static final String ADD_USER = "INSERT INTO users (" +
            "password, email, name, surname, father_name, is_captain, group_id) VALUES (?, ?, ?, ?, ?, ?, ?)";

    private static final String SELECT_USER_BY_LOGIN = "SELECT * FROM users " +
            "INNER JOIN groups ON users.group_id = groups.id WHERE groups.team_login = ?";

    @Override
    public User findByLogin(String login, Connection connection) {
        String sql = SELECT_USER_BY_LOGIN;
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, login);
            List<User> users = executeQuery(preparedStatement);
            return users.isEmpty() ? null : users.get(0);
        } catch (SQLException e) {
            throw new OperationDaoException("Can't handle sql ['" + sql + "']", e);
        }
    }

    @Override
    public boolean saveUser(User user, Connection connection) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(ADD_USER, Statement.RETURN_GENERATED_KEYS)) {
            beforeInsert(user, preparedStatement);
            if (preparedStatement.executeUpdate() > 0) {
                ResultSet resultSet = preparedStatement.getGeneratedKeys();
                if (resultSet.next()) {
                    user.setId(resultSet.getInt(1));
                }
                return true;
            }
            return false;
        } catch (SQLException e) {
            throw new OperationDaoException("Can't handle sql ['" + ADD_USER + "']", e);
        }
    }

    @Override
    public boolean exists(User user, Connection connection) {
        return false;
    }

    private void beforeInsert(User user, PreparedStatement preparedStatement) throws SQLException {
        int k = 1;
        preparedStatement.setString(k++, user.getPassword());
        preparedStatement.setString(k++, user.getEmail());
        preparedStatement.setString(k++, user.getName());
        preparedStatement.setString(k++, user.getSurname());
        preparedStatement.setString(k++, user.getFatherName());
        preparedStatement.setString(k++, Boolean.toString(user.isCaptain()));
        preparedStatement.setLong(k, user.getGroup().getId());
    }

    private User extractUser(ResultSet resultSet) throws SQLException {
        User user = new User();
        user.setId(resultSet.getInt(EntityFields.User.USERS_ID));
        user.setPassword(resultSet.getString(EntityFields.User.PASSWORD));
        user.setEmail(resultSet.getString(EntityFields.User.EMAIL));
        user.setName(resultSet.getString(EntityFields.User.NAME));
        user.setSurname(resultSet.getString(EntityFields.User.SURNAME));
        user.setFatherName(resultSet.getString(EntityFields.User.FATHER_NAME));
        user.setCaptain(Boolean.parseBoolean(resultSet.getString(EntityFields.User.IS_CAPTAIN)));
        Group group = extractGroup(resultSet);
        user.setGroup(group);
        return user;
    }

    private Group extractGroup(ResultSet resultSet) throws SQLException{
        Group group = new Group();
        group.setId(resultSet.getLong(EntityFields.Group.GROUPS_ID));
        group.setName(resultSet.getString(EntityFields.Group.NAME));
        group.setTeamLogin(resultSet.getString(EntityFields.Group.TEAM_LOGIN));
        group.setSchoolName(resultSet.getString(EntityFields.Group.SCHOOL_NAME));
        group.setMembersQuantity(resultSet.getInt(EntityFields.Group.MEMBERS));
        return group;
    }

    private List<User> executeQuery(PreparedStatement preparedStatement) throws SQLException {
        try (ResultSet resultSet = preparedStatement.executeQuery()) {
            List<User> results = new ArrayList<>();
            while (resultSet.next()) {
                User record = extractUser(resultSet);
                results.add(record);
            }
            return results;
        }
    }
}
