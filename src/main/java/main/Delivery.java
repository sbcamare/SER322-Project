package main;

import util.Database;

import java.sql.*;

public class Delivery {

    private final int deliveryId;

    /*
     * Constructor
     * Use this constructor when creating an object for a delivery
     */
    public Delivery(int diD) {
        this.deliveryId = diD;
    }

    public String getDeliveryId() {
        return getDeliveryInfo("DeliveryID");
    }

    public String getArrivalDate() {
        return getDeliveryInfo("ArrivalDate");
    }

    public String getArrivalTime() {
        return getDeliveryInfo("ArrivalTime");
    }

    public String getShippingSpeed() {
        return getDeliveryInfo("ShippingSpeed");
    }

    public String getToAddress() {
        return getDeliveryInfo("ToAddress");
    }

    public String getFromAddress() {
        return getDeliveryInfo("FromAddress");
    }

    // Used for getting delivery information
    private String getDeliveryInfo(String data) {
        ResultSet resultSet = null;
        PreparedStatement statement = null;
        Connection connection = null;

        try {
            connection = Database.getConnection(); // CONNECTING TO DATABASE

            // PREPARING STATEMENT
            statement = connection.prepareStatement("SELECT "+ data +" FROM parcel.DELIVERY WHERE DeliveryID = ?;");

            statement.setInt(1, this.deliveryId); // ADDING

            resultSet = statement.executeQuery(); // EXECUTE QUERY

            String resultFound = "";
            if(resultSet.next()) {
                resultFound = resultSet.getString(1);
            }

            return resultFound;
        }
        catch (SQLException se) {
            System.out.println("SQL EXCEPTION - DATA NOT FOUND");
            se.printStackTrace();
            return null;

        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
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
