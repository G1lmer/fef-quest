package com.kharazin.fef.movenko.quest.database.connectionSource;

import java.sql.Connection;
import java.sql.SQLException;

public interface ConnectionSource {

    Connection getConnection() throws SQLException;

}
