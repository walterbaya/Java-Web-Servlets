
package com.educacionit.java.web.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@WebFilter (filterName = "/authenticationFilter",
            urlPatterns = "/*")
public class AuthenticationFilter implements Filter {


	private ServletContext context;


	private static final Logger logger = LoggerFactory.getLogger (RequestLoggingFilter.class);


	public AuthenticationFilter () {

		super ();
	}


	public void init (FilterConfig fConfig) {

	    this.context = fConfig.getServletContext();
		logger.debug ("AuthenticationFilter initialized");
	}
	
	public void doFilter (ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {


		HttpServletRequest  req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		
		String uri = req.getRequestURI ();
        logger.debug (String.format ("Requested Resource %s", uri));
		
		HttpSession session = req.getSession (false);
		
		if (session == null && !(uri.endsWith("html") || uri.endsWith ("login"))){

            logger.debug ("Unauthorized access request");
			res.sendRedirect("login.html");

		} else {

		    chain.doFilter (request, response);
		}
	}

	public void destroy () {}
}