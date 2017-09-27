package com.kharazin.fef.movenko.quest.database.connectionSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class DataSourceConnection implements ConnectionSource {

    private DataSource dataSource;

    public DataSourceConnection(DataSource ds) {
        dataSource = ds;
    }

    @Override
    public Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

}
