package com.javamaster.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ConnectionPool {
	
	
	private ConnectionPool(){
		//private constructor
	}
	
	/**
	 * Connection instance
	 */
	private Connection connection = getConnection();

	private static ConnectionPool instance = null;
	
	public static ConnectionPool getInstance(){
		if (instance==null)
			instance = new ConnectionPool();
		return instance;
	}
	
	/**
	 * Getting connection from connection pool.
	 *
	 * @see ConnectionPool
	 * @throws SQLException
	 */
	Connection getConnection() {

				try {
					Class.forName("org.postgresql.Driver").newInstance();
				} catch (InstantiationException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IllegalAccessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		
		String username = "ozqhsksvnybqas";
		String password = "71b10f4ff80127ca903c6da6a61a4e91e94e6da08caaa5c2bf9811d62ff8eebc";
		String dbUrl = "jdbc:postgresql://" + "ec2-54-156-8-21.compute-1.amazonaws.com"
				+ "/d8a04hsfn90n7p?sslmode=require";
		try {
			return DriverManager.getConnection(dbUrl, username, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return connection;
	}
}
