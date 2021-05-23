
package com.educacionit.java.web.listener;


import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.educacionit.java.web.db.DBConnectionManager;


@WebListener
public class AppContextListener implements ServletContextListener {


    private static final Logger logger = LoggerFactory.getLogger (AppContextListener.class);


    public void contextInitialized (ServletContextEvent servletContextEvent) {

    	ServletContext ctx = servletContextEvent.getServletContext ();
    	
    	String url = ctx.getInitParameter ("DBURL");
    	String u   = ctx.getInitParameter ("DBUSER");
    	String p   = ctx.getInitParameter ("DBPWD");
    	

    	DBConnectionManager dbManager = new DBConnectionManager (url, u, p);
    	ctx.setAttribute ("DBManager", dbManager);
    	logger.debug ("Database connection initialized for Application.");
    }

    public void contextDestroyed (ServletContextEvent servletContextEvent) {

    	ServletContext ctx = servletContextEvent.getServletContext ();
    	DBConnectionManager dbManager = (DBConnectionManager) ctx.getAttribute ("DBManager");
    	dbManager.closeConnection ();

    	logger.debug ("Database connection closed for Application.");
    }
}