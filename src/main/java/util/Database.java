package util;

import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

	public static String user;
	public static String pass;
	public static String connection;
	public static String driver;


	public static void setDatabase(String connection, String user, String pass, String driver) {

		Database.connection = connection;
		Database.user = user;
		Database.pass = pass;
		Database.driver = driver;



	}

	public static Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName(Database.driver); // LOADING DRIVER
			connection = DriverManager.getConnection(Database.connection, Database.user, Database.pass); // CONNECTING TO DATABASE
			connection.setAutoCommit(false);

		}
		catch (SQLException se) {
			System.out.println("SQL ERROR - UNABLE TO CONNECT");
			se.printStackTrace();
		}
		catch (ClassNotFoundException e) {
			System.out.println("DRIVER ERROR - DRIVER NOT FOUND");
			e.printStackTrace();
		}
		return connection;
	}

}
