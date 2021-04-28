package util;

import java.sql.*;

import ui.LoginDialog;
import ui.ProgramFrame;
import ui.SignupDialog;

import javax.swing.*;

public class App {

	public static String userEmail;
	public static String firstName;
	public static String lastName;
	public static String userPhone;

	public static void show() {
		JDialog loginDialog = new LoginDialog();
		loginDialog.setLocationRelativeTo(null);
		loginDialog.setVisible(true);

		if (LoginDialog.getNewUser()) {
			JDialog signupDialog = new SignupDialog();
			signupDialog.setLocationRelativeTo(null);
			signupDialog.setVisible(true);
		}

		JFrame programFrame = new ProgramFrame();
		programFrame.setLocationRelativeTo(null);
		programFrame.setVisible(true);


	}


	public static boolean userLogin(String email, String password) {
		ResultSet resultSet = null;
		PreparedStatement statement = null;
		Connection connection = null;

		try {
			connection = Database.getConnection();

			// PREPARING STATEMENT
			statement = connection.prepareStatement("SELECT Email, Password, First , Last, Phone FROM USER WHERE USER.Email = ?;");

			// ADDING USERNAME TO QUERY
			statement.setString(1, email);

			// EXECUTE QUERY
			resultSet = statement.executeQuery();

			resultSet.next();

			// VALIDATING GIVEN CREDENTIALS
			if (resultSet.getString("Email").equals(email) && resultSet.getString("Password").equals(password) ) {

				userEmail = resultSet.getString(1);
				firstName = resultSet.getString(3);
				lastName = resultSet.getString(4);
				userPhone = resultSet.getString(5);

				return true;
			}
			else {
				System.out.println("ALERT - CREDENTIALS INVALID");
				return false;
			}

		}
		catch (SQLException se) {
			System.out.println("SQL EXCEPTION - USER NOT FOUND");
			//se.printStackTrace();
			return false;
		}
		catch (Exception e) {
			System.out.println("EXCEPTION - AN ERROR OCCURRED ");
			e.printStackTrace();
			return false;
		}

		finally {  // CLOSING RESOURCES
			try {
				if (resultSet != null) {
					resultSet.close();
				}
				if (statement != null) {
					statement.close();
				}
				if (connection != null) {
					connection.close();
				}
			}
			catch (SQLException se) {
				se.printStackTrace();
			}
		}
	}


	public static boolean userSignup(String email, String password, String first, String last, String phone) {

		ResultSet resultSet = null;
		PreparedStatement statement = null;
		Connection connection = null;

		try {
			connection = Database.getConnection();

			// PREPARING STATEMENT
			PreparedStatement prep = connection.prepareStatement("INSERT INTO USER values (?, ?, ?, ?, ?);");

			prep.setString(1, email);
			prep.setString(2, password);
			prep.setString(3, first);
			prep.setString(4, last);
			prep.setString(5, phone);
			prep.addBatch();

			connection.setAutoCommit(false);
			prep.executeBatch();
			connection.setAutoCommit(true);

			System.out.println("ALERT - USER CREATED");
			
			userLogin(email, password);
			
			return true;

		}
		catch (SQLException se) {
			System.out.println("SQL EXCEPTION - DUPLICATE USER");
			return false;
		}
		catch (Exception e) {
			System.out.println("EXCEPTION - AN ERROR OCCURRED ");
			e.printStackTrace();
			return false;
		}


		finally {  // CLOSING RESOURCES
			try {
				if (resultSet != null) {
					resultSet.close();
				}
				if (statement != null) {
					statement.close();
				}
				if (connection != null) {
					connection.close();
				}
			}
			catch (SQLException se) {
				se.printStackTrace();
			}
		}

	}

}
