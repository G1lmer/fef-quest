package com.kharazin.fef.movenko.quest.web.listner;


import com.kharazin.fef.movenko.quest.constant.ContextParams;
import com.kharazin.fef.movenko.quest.constant.Services;
import com.kharazin.fef.movenko.quest.database.connectionSource.DataSourceConnection;
import com.kharazin.fef.movenko.quest.database.factory.DAOFactory;
import com.kharazin.fef.movenko.quest.database.factory.DAOFactoryImpl;
import com.kharazin.fef.movenko.quest.database.service.registration.RegistrationService;
import com.kharazin.fef.movenko.quest.database.service.registration.RegistrationServiceImpl;
import com.kharazin.fef.movenko.quest.database.service.user.UserService;
import com.kharazin.fef.movenko.quest.database.service.user.UserServiceImpl;
import com.kharazin.fef.movenko.quest.database.transaction.TransactionManager;
import com.kharazin.fef.movenko.quest.database.transaction.TransactionManagerImpl;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.sql.DataSource;


public class ServletListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ServletContext servletContext = servletContextEvent.getServletContext();
        initServices(servletContext);
    }

    private void initServices(ServletContext servletContext) {
        DAOFactory daoFactory = new DAOFactoryImpl();
        String dataSourceName = servletContext.getInitParameter(ContextParams.DB_SOURCE);
        DataSource dataSource = getDataSource(dataSourceName);


        DataSourceConnection dataSourceConnectionSource = new DataSourceConnection(dataSource);
        TransactionManager transactionManager = new TransactionManagerImpl(dataSourceConnectionSource);
        UserService userService = new UserServiceImpl(transactionManager,daoFactory.getUserDao());
        servletContext.setAttribute(Services.USER_SERVICE, userService);
        RegistrationService registrationService = new RegistrationServiceImpl(
                transactionManager,daoFactory.getUserDao(),daoFactory.getGroupDao());
        servletContext.setAttribute(Services.REG_SERVICE, registrationService);

    }

    private DataSource getDataSource(String dataSourceName) {
        DataSource dataSource = null;
        try {
            Context initContext = new InitialContext();
            Context envContext = (Context) initContext.lookup("java:/comp/env");
            dataSource = (DataSource) envContext.lookup(dataSourceName);
        } catch (NamingException e) {
            e.printStackTrace();
        }
        return dataSource;
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }

}
