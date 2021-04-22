import java.sql.*;

public class Main {
	

	public static void main(String[] args) {	
		
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/PARCEL","root","Blake1010");
			getPackageInfo(connect, 2);
			getVehicle(connect, 1, "5666 E 11th St 85301");
			getDeliveryRoute(connect, 1);
			sendPackage(connect, toAddress)

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
	INSERT INTO DELIVERY(DeliveryAddress)
	SELECT ToAddress
	FROM RECEIVER
	WHERE ToAddress = '2222 W 11th St 85221';
	*/
	
	public static void sendPackage(Connection connect, String toAddress) {
		try {
			PreparedStatement statement=connect.prepareStatement("INSERT INTO DELIVERY(DeliveryAddress)" 
				+	"SELECT ToAddress" 
				+	"FROM RECEIVER"
				+	"WHERE ToAddress = ?"); 
			statement.setString(1,toAddress);
			int newAddress = statement.executeUpdate();
			System.out.println("Row effected: " + newAddress);

			if(statement != null) {
				statement.close();
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println();
		
	}

}	
	
	