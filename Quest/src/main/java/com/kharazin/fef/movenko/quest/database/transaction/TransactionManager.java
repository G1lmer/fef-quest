package com.kharazin.fef.movenko.quest.database.transaction;


import com.kharazin.fef.movenko.quest.database.command.CommandSQL;

/**
 * Created by Serega on 20.05.2017.
 */
public interface TransactionManager {

    <T> T executeInTransaction(CommandSQL<T> command);

}
