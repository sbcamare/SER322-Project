//import javax.swing.*;
//import java.sql.*;
//
//public class DeliveryList {
//
//    private DefaultListModel<Delivery> listModel = null;
//    JList<Delivery> deliveryJList = null;
//
//    public DeliveryList() {
//        listModel = new DefaultListModel<>();
//        createListModel();
//        deliveryJList = new JList<>(getListModel());
//    }
//
//    public JList<Delivery> getList() {
//        return deliveryJList;
//    }
//
//    private DefaultListModel<Delivery> getListModel() {
//        return listModel;
//    }
//
//
//    // Selects all all users from users table inside the database
//    private void createListModel() {
//        ResultSet resultSet = null;
//        PreparedStatement statement = null;
//        Connection connection = null;
//
//        try {
//            Class.forName("org.sqlite.JDBC"); // LOADING DRIVER
//            connection = DriverManager.getConnection("jdbc:sqlite:KASE.db"); // CONNECTING TO DATABASE
//
//            // PREPARING STATEMENT
//            statement = connection.prepareStatement("select DeliveryID from delivery;");
//
//            resultSet = statement.executeQuery(); // EXECUTE QUERY
//
//            while (resultSet.next()) {
//                listModel.addElement(new Delivery(resultSet.getInt(1)));
//            }
//
//        }
//        catch (SQLException se) {
//            System.out.println("SQL EXCEPTION - DATA NOT FOUND");
//
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        finally {  // CLOSING RESOURCES
//            try {
//                if (resultSet != null) {
//                    resultSet.close();
//                }
//                if (statement != null) {
//                    statement.close();
//                }
//                if (connection != null) {
//                    connection.close();
//                }
//            }
//            catch (SQLException se) {
//                se.printStackTrace();
//            }
//        }
//    }
//
//}
