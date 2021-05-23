
package com.educacionit.java.web.filters;


import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@WebFilter (filterName = "/loggingFilter",
            urlPatterns = "/*",
            dispatcherTypes = {DispatcherType.REQUEST})
public class RequestLoggingFilter implements Filter {


    private ServletContext context;


    private static final Logger logger = LoggerFactory.getLogger (RequestLoggingFilter.class);


	public RequestLoggingFilter () {

	    super ();
    }

	
	public void init(FilterConfig fConfig) {

		this.context = fConfig.getServletContext ();
        logger.debug ("RequestLoggingFilter initialized");
	}

	public void doFilter (ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

	    HttpServletRequest     req = (HttpServletRequest) request;
		Enumeration<String> params = req.getParameterNames ();

		while (params.hasMoreElements ()) {

		    String name = params.nextElement();
			String value = request.getParameter(name);
            logger.debug (req.getRemoteAddr () + " => Request Params => [" + name + ":" + value + "]");
		}
		
		Cookie[] cookies = req.getCookies ();

		if (cookies != null) {

		    for (Cookie cookie : cookies) {

                logger.debug (req.getRemoteAddr () + " => Cookie => ["+cookie.getName () + ":" + cookie.getValue () + "]");
			}
		}
		chain.doFilter (request, response);
	}

	public void destroy () {}
}