import java.sql.*;

import java.util.Random;

public class Main {
	
	final static int UPPER_BOUND = 1000000;
	static Random random = new Random();

	public static void main(String[] args) {	

		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			/**
			URL, username, and password left blank intentionally. 		
			*/
			Connection connect = DriverManager.getConnection();
			/**
			Testing method
			sendPackage(connect, 1111111111, "test214@email.com", "Fast", "34 S. ASU St. 85212", "1123 N 20th St 85112", "Box", 30, 26.8);
			*/
			
			

		}catch(Exception e) {
			e.printStackTrace();
		}
}
	
	/**
	 * SELECT ArrivalDate, ArrivalTime, ShippingSpeed
		FROM DELIVERY
		WHERE DELIVERY.PackageID = 2;
	 */
	
	public static void getPackageInfo(Connection connect, int packageId) {
		try {
			PreparedStatement statement=connect.prepareStatement("SELECT ArrivalDate, ArrivalTime, ShippingSpeed FROM DELIVERY WHERE DELIVERY.PackageID = ?;"); 
			statement.setInt(1,packageId);
			ResultSet purchases=statement.executeQuery();
			while(purchases.next()) { 
				System.out.printf("%s %s %s \n",purchases.getString("ArrivalDate"),purchases.getString("ArrivalTime"),purchases.getString("ShippingSpeed"));
			}
			if(statement != null) {
				statement.close();
			}
			if(purchases != null) {
				purchases.close();
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println();
	}
	/**
	SELECT CARRIES.VehicleID
	FROM VEHICLE, CARRIES, DELIVERY, RECEIVER
	WHERE VEHICLE.VehicleID = CARRIES.VehicleID
	      		AND DELIVERY.DeliveryID = CARRIES.DeliveryID
	      		AND RECEIVER.ToAddress =  DELIVERY.ToAddress;
	      		*/

	public static void getVehicle(Connection connect, int deliveryId, String toAddress) {
		try {
			PreparedStatement statement=connect.prepareStatement("SELECT CARRIES.VehicleID\n"
					+ "	FROM VEHICLE, CARRIES, DELIVERY, RECEIVER\n"
					+ "	WHERE VEHICLE.VehicleID = CARRIES.VehicleID\n"
					+ "	      		AND DELIVERY.DeliveryID = ?\n"
					+ "	      		AND RECEIVER.ToAddress =  ?;"); 
			statement.setInt(1,deliveryId);
			statement.setString(2, toAddress);
			ResultSet purchases=statement.executeQuery();
			while(purchases.next()) { 
				System.out.printf("%s \n",purchases.getString("CARRIES.VehicleID"));
			}
			if(statement != null) {
				statement.close();
			}
			if(purchases != null) {
				purchases.close();
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println();
		
	}
	/**
	SELECT RouteID 
	FROM AT
	WHERE AT.DeliveryID = 3;
	*/

	
	public static void getDeliveryRoute(Connection connect, int routeId) {
		try {
		PreparedStatement statement=connect.prepareStatement("SELECT RouteID FROM AT WHERE AT.DeliveryID = ?;"); 
		statement.setInt(1,routeId);
		ResultSet purchases=statement.executeQuery();
		while(purchases.next()) { 
			System.out.printf("%s \n",purchases.getString("RouteID"));
		}
		if(statement != null) {
			statement.close();
		}
		if(purchases != null) {
			purchases.close();
		}
	} catch(Exception e) {
		e.printStackTrace();
	}
		System.out.println();
	}
	

	/**
	 * Method for sending a new package
	 * 
	 * 
	 * @param connect
	 * @param phone
	 * @param email
	 * @param shippingSpeed
	 * @param toAddress
	 * @param fromAddress needs to be from existing sender in system
	 * @param packageType
	 * @param packageDimensions
	 * @param packageWeight
	 */
	
	public static void sendPackage(Connection connect, int phone, String email, String shippingSpeed, String toAddress, String fromAddress,
			String packageType, int packageDimensions, double packageWeight) {
		int newDelivery = -1;
		try {
			int delID = random.nextInt(UPPER_BOUND);
			
			
			
			PreparedStatement user=connect.prepareStatement("INSERT INTO USER(Phone, Email)" 
					+ "VALUES(?,?);");
			user.setInt(1, phone);
			user.setString(2, email);
			user.executeUpdate();
			
			
			PreparedStatement reciever=connect.prepareStatement("INSERT INTO RECEIVER(Phone, Email, ToAddress)" 
					+ "VALUES(?,?,?);");
			
			reciever.setInt(1, phone);
			reciever.setString(2, email);
			reciever.setString(3, toAddress);
			reciever.executeUpdate();
			
			PreparedStatement newPackage=connect.prepareStatement("INSERT INTO PACKAGE(Type, PackageID, Dimensions, Weight)" 
					+ "VALUES(?,?,?,?);");
			
			newPackage.setString(1, packageType);
			newPackage.setInt(2, delID);
			newPackage.setInt(3, packageDimensions);
			newPackage.setDouble(4, packageWeight);
			newPackage.executeUpdate();
			
			

			PreparedStatement shipment=connect.prepareStatement("INSERT INTO DELIVERY(ArrivalDate, ArrivalTime, DeliveryID, ShippingSpeed, ToAddress, FromAddress, PackageID)" 
					+ "VALUES(curdate(),curtime(),?,?,?,?,?);");
					
					/**
					"INSERT INTO DELIVERY(DeliveryAddress)" 
				+	"SELECT ToAddress" 
				+	"FROM RECEIVER"
				+	"WHERE ToAddress = ?"); 
				*/
			
			shipment.setInt(1, delID);
			shipment.setString(2, shippingSpeed);
			shipment.setString(3, toAddress);
			shipment.setString(4, fromAddress);
			shipment.setInt(5, delID);
			newDelivery = shipment.executeUpdate();
			
			if(newDelivery != -1) {
				System.out.println("Success! " + newDelivery);
			}
			else {
				System.out.println("Failure");
			}

			if(shipment != null) {
				shipment.close();
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}	
	
	
