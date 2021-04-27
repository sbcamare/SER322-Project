import java.sql.*;

public class Main {

	public static void main(String[] args) {
	    ResultSet rs = null;
		System.out.println("CONNECTION: "+args[0]);
		System.out.println("USER: "+args[1]);
		System.out.println("PASS: "+args[2]);
		System.out.println("DRIVER: "+args[3]);
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			/**
			URL, username, and password left blank intentionally. 		
			*/
			Connection connect = DriverManager.getConnection(args[0], args[1], args[2]);
            connect.setAutoCommit(false);
			/**
			Testing methods
			*/
			getPackageInfo(connect, 2);
			getVehicle(connect, 1, "5666 E 11th St 85301");
			getDeliveryRoute(connect, 1);
			/**
			Needs a toAddress to be tested
			*/
			//sendPackage(connect, toAddress);
			
			// Route start and end times
            routeTimes(rs, connect, 2);
            //list all packages
            System.out.println("Track all packages:");
            trackAllPackages(connect);
            System.out.println("\n\nTrack a package");
            trackAPackage(connect, 3);
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
	
	
	/**
     * SELECT StartTime, EndTime, ArrivalTime FROM DELIVERY_ROUTE, DELIVERY WHERE
     * ArrivalTime = current_time() between StartTime and EndTime
     * 
     * @throws SQLException
     * 
     */
    public static void routeTimes(ResultSet resultSet, Connection connect, int routes) throws SQLException {
        try {
            PreparedStatement statement = connect.prepareStatement("SELECT StartTime, EndTime, ArrivalTime "
                    + "FROM DELIVERY_ROUTE, DELIVERY "
                    + "WHERE DELIVERY.ArrivalTime = ? between DELIVERY_ROUTE.StartTime AND DELIVERY_ROUTE.EndTime");

            statement.setInt(1, routes);
            resultSet = statement.executeQuery();

            System.out.println("-------------------------------------");
            System.out.println("|      Package Delivery Times       |");
            System.out.println("-------------------------------------");
            System.out.println("|   Earliest    |      Latest       |");
            System.out.println("-------------------------------------");
            while (resultSet.next()) {
                System.out.println("|   " + resultSet.getTime(1) + "    |    " + resultSet.getTime(routes) + "       |");

            }
            System.out.println("-------------------------------------");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                //if (connect != null) {
                  //  connect.close();
                //}
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }
    
    public static void trackAllPackages(Connection connect) throws SQLException {
        try {
            PreparedStatement statement=connect.prepareStatement("SELECT CARRIES.VehicleID, ArrivalDate, ArrivalTime, ShippingSpeed, RouteID, PackageID "
                            + "FROM VEHICLE, CARRIES, DELIVERY, RECEIVER, AT "
                            + "WHERE VEHICLE.VehicleID = CARRIES.VehicleID "
                            + "AND DELIVERY.DeliveryID = CARRIES.DeliveryID "
                            + "AND RECEIVER.ToAddress =  DELIVERY.ToAddress "
                            + "AND AT.DeliveryID =  DELIVERY.DeliveryID ");
            ResultSet purchases=statement.executeQuery();
            while(purchases.next()) { 
                System.out.printf("Package: %s Arriving: %s At: %s On Route: %s\n",purchases.getInt("PackageID"),purchases.getString("ArrivalDate"),purchases.getString("ArrivalTime"), purchases.getInt("AT.RouteID"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } 
    }
    
    public static void trackAPackage(Connection connect, int packageId) throws SQLException {
        try {
            PreparedStatement statement=connect.prepareStatement( "SELECT CARRIES.VehicleID, ArrivalDate, ArrivalTime, ShippingSpeed, RouteID, PackageID "
                            + "FROM VEHICLE, CARRIES, DELIVERY, RECEIVER, AT "
                            + "WHERE VEHICLE.VehicleID = CARRIES.VehicleID "
                            + "AND DELIVERY.DeliveryID = CARRIES.DeliveryID "
                            + "AND RECEIVER.ToAddress =  DELIVERY.ToAddress "
                            + "AND AT.DeliveryID = ? "
                            + "AND AT.RouteID = DELIVERY.DeliveryID");
            statement.setInt(1,packageId);
            ResultSet purchases=statement.executeQuery();
            while(purchases.next()) { 
                System.out.printf("Package: %s Arriving: %s At: %s On Route: %s\n",purchases.getInt("PackageID"),purchases.getString("ArrivalDate"),purchases.getString("ArrivalTime"), purchases.getInt("RouteID"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
        

}	
	
	
