
package com.educacionit.java.web.db;


import java.sql.Connection;


public class DBConnectionManager {


	private String dbURL;
	private String user;
	private String password;
	private Connection con;


	public DBConnectionManager (String url, String u, String p) {

	    super ();
		this.dbURL = url;
		this.user  = u;
		this.password = p;
	}

	
	public Connection getConnection () {

		return this.con;
	}
	
	public void closeConnection () {
	}
}