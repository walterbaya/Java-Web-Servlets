
package com.educacionit.java.web.listener;


import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestEvent;
import javax.servlet.annotation.WebListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@WebListener
public class ServletRequestListener implements javax.servlet.ServletRequestListener {


    private static final Logger logger = LoggerFactory.getLogger (ServletRequestListener.class);


    public ServletRequestListener () {

        super ();
    }

    public void requestDestroyed (ServletRequestEvent servletRequestEvent) {

    	ServletRequest servletRequest = servletRequestEvent.getServletRequest ();
    	logger.debug (String.format ("ServletRequest destroyed. Remote IP %s", servletRequest.getRemoteAddr ()));
    }

    public void requestInitialized (ServletRequestEvent servletRequestEvent) {

        ServletRequest servletRequest = servletRequestEvent.getServletRequest ();
        logger.debug (String.format ("ServletRequest initialized. Remote IP %s", servletRequest.getRemoteAddr ()));
    }
}