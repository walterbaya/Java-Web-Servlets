
package com.educacionit.java.web.listener;


import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@WebListener
public class SessionListener implements HttpSessionListener {


    private static final Logger logger = LoggerFactory.getLogger (SessionListener.class);


    public SessionListener() {

        super ();
    }


    public void sessionCreated(HttpSessionEvent sessionEvent) {

        logger.debug (String.format ("Session ID %s Created", sessionEvent.getSession ().getId ()));
    }

    public void sessionDestroyed(HttpSessionEvent sessionEvent) {

        logger.debug (String.format ("Session ID %s Destroyed", sessionEvent.getSession().getId ()));
    }
}