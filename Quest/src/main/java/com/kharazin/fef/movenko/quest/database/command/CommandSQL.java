package com.kharazin.fef.movenko.quest.database.command;

import java.sql.Connection;
import java.sql.SQLException;

public interface CommandSQL<T> {

    T execute(Connection connection) throws SQLException;

}
