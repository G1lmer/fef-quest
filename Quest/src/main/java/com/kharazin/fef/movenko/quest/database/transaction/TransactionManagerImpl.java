package com.kharazin.fef.movenko.quest.database.transaction;


import com.kharazin.fef.movenko.quest.database.command.CommandSQL;
import com.kharazin.fef.movenko.quest.database.connectionSource.ConnectionSource;
import com.kharazin.fef.movenko.quest.exception.OperationDaoException;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by Serega on 20.05.2017.
 */
public class TransactionManagerImpl implements TransactionManager {

    private ConnectionSource connectionSource;

    public TransactionManagerImpl(ConnectionSource connectionSource) {
        this.connectionSource = connectionSource;
    }

    public <T> T executeInTransaction(CommandSQL<T> command) {
        Connection con = null;
        T res = null;
        try {
            con = connectionSource.getConnection();
            res = command.execute(con);
            commit(con);
        } catch (SQLException e) {
            if (con != null) {
                rollback(con);
            }
            throw new OperationDaoException("Something wrong",e);
        } finally {
            if (con != null) {
                close(con);
            }
        }
        return res;
    }


    private void close(Connection con) {
        try {
            con.close();
        } catch (SQLException e) {
            throw new OperationDaoException("Something wrong",e);
        }
    }


    private void commit(Connection con) {
        try {
            con.commit();
        } catch (SQLException e) {
            throw new OperationDaoException("Something wrong",e);
        }
    }

    private void rollback(Connection con) {
        try {
            con.rollback();
        } catch (SQLException e) {
            throw new OperationDaoException("Something wrong",e);
        }
    }
}
