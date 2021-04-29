package main;

import main.Delivery;

import util.Database;
import util.App;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import java.util.Random;

public class Main {

    final static int UPPER_BOUND = 1000000;
    static Random random = new Random();


    public static void main(String[] args) {
        ResultSet rs = null;
        if (args.length != 4) {
            System.out.println("If using gradle use:");
            System.out.println("gradle run -Pconnection=\"CONNECTIONNAME\" -Puser=\"USERNAME\" -Ppass=\"PASSWORD\" -Pdriver=\"DRIVER\"");
            System.out.println("Else args must be: ");
            System.out.println("\"CONNECTIONNAME\" \"USERNAME\" \"PASSWORD\" \"DRIVER\"");
            System.exit(0);
        }
        System.out.println("CONNECTION: " + args[0]);
        System.out.println("USER: " + args[1]);
        System.out.println("PASS: " + args[2]);
        System.out.println("DRIVER: " + args[3]);

        Database.setDatabase(args[0], args[1], args[2], args[3]);

        App.show();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            /**
             URL, username, and password left blank intentionally.
             */
            Connection connect = DriverManager.getConnection(args[0], args[1], args[2]);
            connect.setAutoCommit(false);
            /**
             Testing method
             sendPackage(connect, 1111111111, "test214@email.com", "Fast", "34 S. ASU St. 85212", "1123 N 20th St 85112", "Box", 30, 26.8);
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

            /*
             * LUIS PACKAGE CLASS TEST
             */
            System.out.println("TESTING DELIVERY CLASS");
            Delivery delTest = new Delivery(1);
            System.out.println(delTest.getDeliveryId());
            System.out.println(delTest.getArrivalDate());
            System.out.println(delTest.getArrivalTime());
            System.out.println(delTest.getShippingSpeed());
            System.out.println(delTest.getToAddress());
            System.out.println(delTest.getFromAddress());
            System.out.println(delTest.getPackageID());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * SELECT ArrivalDate, ArrivalTime, ShippingSpeed
     * FROM DELIVERY
     * WHERE DELIVERY.PackageID = 2;
     */

    public static void getPackageInfo(Connection connect, int packageId) {
        try {
            PreparedStatement statement = connect.prepareStatement("SELECT ArrivalDate, ArrivalTime, ShippingSpeed FROM DELIVERY WHERE DELIVERY.PackageID = ?;");
            statement.setInt(1, packageId);
            ResultSet purchases = statement.executeQuery();
            while (purchases.next()) {
                System.out.printf("%s %s %s \n", purchases.getString("ArrivalDate"), purchases.getString("ArrivalTime"), purchases.getString("ShippingSpeed"));
            }
            if (statement != null) {
                statement.close();
            }
            if (purchases != null) {
                purchases.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println();
    }

    /**
     * SELECT CARRIES.VehicleID
     * FROM VEHICLE, CARRIES, DELIVERY, RECEIVER
     * WHERE VEHICLE.VehicleID = CARRIES.VehicleID
     * AND DELIVERY.DeliveryID = CARRIES.DeliveryID
     * AND RECEIVER.ToAddress =  DELIVERY.ToAddress;
     */

    public static void getVehicle(Connection connect, int deliveryId, String toAddress) {
        try {
            PreparedStatement statement = connect.prepareStatement("SELECT CARRIES.VehicleID\n"
                    + "	FROM VEHICLE, CARRIES, DELIVERY, RECEIVER\n"
                    + "	WHERE VEHICLE.VehicleID = CARRIES.VehicleID\n"
                    + "	      		AND DELIVERY.DeliveryID = ?\n"
                    + "	      		AND RECEIVER.ToAddress =  ?;");
            statement.setInt(1, deliveryId);
            statement.setString(2, toAddress);
            ResultSet purchases = statement.executeQuery();
            while (purchases.next()) {
                System.out.printf("%s \n", purchases.getString("CARRIES.VehicleID"));
            }
            if (statement != null) {
                statement.close();
            }
            if (purchases != null) {
                purchases.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println();

    }

    /**
     * SELECT RouteID
     * FROM AT
     * WHERE AT.DeliveryID = 3;
     */


    public static void getDeliveryRoute(Connection connect, int routeId) {
        try {
            PreparedStatement statement = connect.prepareStatement("SELECT RouteID FROM AT WHERE AT.DeliveryID = ?;");
            statement.setInt(1, routeId);
            ResultSet purchases = statement.executeQuery();
            while (purchases.next()) {
                System.out.printf("%s \n", purchases.getString("RouteID"));
            }
            if (statement != null) {
                statement.close();
            }
            if (purchases != null) {
                purchases.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println();
    }


    /**
     * Method for sending a new package
     * <p>
     * Check to see if reciever exists in system
     * if not create new user and add them as reciever
     * if reciever exists
     * create new package
     * add package to new delivery
     * <p>
     * print shipping label to .txt file
     *
     * @param conne
     * @param senderPhone
     * @param receiverPhone
     * @param shippingSpeed
     * @param toAddress
     * @param fromAddress       needs to be from existing sender in system
     * @param packageType
     * @param packageDimensions
     * @param packageWeight
     */

    public static void sendPackage(Connection conne, String senderPhone, String receiverPhone, String senderEmail, String receiverEmail, String shippingSpeed, String toAddress, String fromAddress,
                                   String packageType, String packageDimensions, double packageWeight, String firstName, String lastName) {
        int newDelivery = -1;

        try {

        	Connection connect = Database.getConnection();

            int delID = random.nextInt(UPPER_BOUND);

            PreparedStatement userSearch = connect.prepareStatement("SELECT * FROM USER WHERE USER.Email = ?;");
            userSearch.setString(1, receiverEmail);
            ResultSet userResult = userSearch.executeQuery();

            if (userResult.next() == false) {
                PreparedStatement user = connect.prepareStatement("INSERT INTO USER(Phone, Email, First, Last)"
                        + "VALUES(?,?,?,?);");
                user.setString(1, receiverPhone);
                user.setString(2, receiverEmail);
                user.setString(3, firstName);
                user.setString(4, lastName);
                user.executeUpdate();
                connect.commit();



                if (user != null) {
                    user.close();
                }

                System.out.println("New user added");
            }


            PreparedStatement receiverSearch = connect.prepareStatement("SELECT * FROM RECEIVER WHERE RECEIVER.ToAddress = ?;");
            receiverSearch.setString(1, toAddress);
            ResultSet receiverResult = receiverSearch.executeQuery();

            /**
             * check to see if receiver has receiver a package before. If not
             * add them to the system.
             */
            if (receiverResult.next() == false) {


                PreparedStatement receiver = connect.prepareStatement("INSERT INTO RECEIVER(Phone, Email, ToAddress)"
                        + "VALUES(?,?,?);");

                receiver.setString(1, receiverPhone);
                receiver.setString(2, receiverEmail);
                receiver.setString(3, toAddress);
                receiver.executeUpdate();
                connect.commit();


                if (receiver != null) {
                    receiver.close();
                }


                System.out.println("New  receiver added and package added");
            }

            PreparedStatement searchSender = connect.prepareStatement("SELECT * FROM SENDER WHERE SENDER.FromAddress = ?;");
            searchSender.setString(1, fromAddress);
            ResultSet senderResult = searchSender.executeQuery();

            /**
             * Check to see if sender has shipped package before
             */
            if (senderResult.next() == false) {
                PreparedStatement sender = connect.prepareStatement("INSERT INTO SENDER(Phone, Email, FromAddress)"
                        + "VALUES(?,?,?);");

                sender.setString(1, senderPhone);
                sender.setString(2, senderEmail);
                sender.setString(3, fromAddress);
                sender.executeUpdate();
                connect.commit();

                if (sender != null) {
                    sender.close();
                }


            }

            PreparedStatement newPackage = connect.prepareStatement("INSERT INTO PACKAGE(Type, PackageID, Dimensions, Weight)"
                    + "VALUES(?,?,?,?);");

            newPackage.setString(1, packageType);
            newPackage.setInt(2, delID);
            newPackage.setString(3, packageDimensions);
            newPackage.setDouble(4, packageWeight);
            newPackage.executeUpdate();
            connect.commit();


            PreparedStatement shipment = connect.prepareStatement("INSERT INTO DELIVERY(ArrivalDate, ArrivalTime, DeliveryID, ShippingSpeed, ToAddress, FromAddress, PackageID)"
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
            connect.commit();

            if (shipment != null) {
                shipment.close();
            }

            if (newPackage != null) {
                newPackage.close();
            }


            try {
                File myObj = new File("ShippingLabel.txt");
                if (myObj.createNewFile()) {
                    System.out.println("File created: " + myObj.getName());
                } else {
                    System.out.println("File already exists.");
                }
            } catch (Exception e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }

            FileWriter fileWriter = new FileWriter("ShippingLabel.txt");
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.println(firstName + " " + lastName);
            printWriter.println(toAddress);
            printWriter.println("---------------------------");
            printWriter.println("||| | || ||||||||| | ||| ||");
            printWriter.println("||| | || ||||||||| | ||| ||");
            printWriter.println("||| | || ||||||||| | ||| ||");
            printWriter.println("||| | || ||||||||| | ||| ||");
            printWriter.println("||| | || ||||||||| | ||| ||");
            printWriter.println("||| | || ||||||||| | ||| ||");
            printWriter.println("||| | || ||||||||| | ||| ||");
            printWriter.println("---------------------------");
            printWriter.close();

            if (newDelivery != -1) {
                System.out.println("Success! " + newDelivery);
            } else {
                System.out.println("Failure");
            }

        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }

    }


    /**
     * SELECT StartTime, EndTime, ArrivalTime FROM DELIVERY_ROUTE, DELIVERY WHERE
     * ArrivalTime = current_time() between StartTime and EndTime
     *
     * @throws SQLException
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
                if (connect != null) {
                    connect.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }

}	
	
	
