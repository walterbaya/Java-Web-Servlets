
package com.educacionit.java.web.listener;


import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.annotation.WebListener;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@WebListener
public class AppContextAttributeListener implements ServletContextAttributeListener {


    private static final Logger logger = LoggerFactory.getLogger (AppContextAttributeListener.class);


    public AppContextAttributeListener () {

        super ();
    }


    public void attributeAdded (ServletContextAttributeEvent servletContextAttributeEvent) {

        logger.debug (String.format ("ServletContext attribute added %s, %s" , servletContextAttributeEvent.getName (), servletContextAttributeEvent.getValue ()));
    }

    public void attributeReplaced(ServletContextAttributeEvent servletContextAttributeEvent) {

        logger.debug (String.format ("ServletContext attribute replaced %s,%s", servletContextAttributeEvent.getName (), servletContextAttributeEvent.getValue ()));
    }

    public void attributeRemoved (ServletContextAttributeEvent servletContextAttributeEvent) {

        logger.debug (String.format ("ServletContext attribute removed %s,%s", servletContextAttributeEvent.getName (), servletContextAttributeEvent.getValue ()));
    }
}