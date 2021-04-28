import util.Database;

import java.sql.*;

public class Package {

    private final int packageId;

    /*
    * Constructor
    * Use this constructor when creating an object for a package
     */
    public Package(int packageId) {
        this.packageId = packageId;
    }

    public String getPackageId() {
        return getPackage("PackageID");
    }

    public void setType(String type) { // TODO: test
        updatePackage("Type", type);

    }
    public String getType() { // TODO: test
        return getPackage("Type");
    }

    public void setWeight(String weight) { // TODO: finish
        updatePackage("Weight", weight);
    }
    public String getWeight() {
        return getPackage("Weight");
    }


    public String getDimensions() { // TODO: finish
        return getPackage("Dimensions");
    }
    public void setDimensions(String dimensions) {
        updatePackage("Weight", dimensions);
    }




    // Used for getting package information
    private String getPackage(String data) {
        ResultSet resultSet = null;
        PreparedStatement statement = null;
        Connection connection = null;

        try {
            connection = Database.getConnection(); // CONNECTING TO DATABASE

            // PREPARING STATEMENT
            statement = connection.prepareStatement("SELECT "+data+" FROM package WHERE PackageID = ?;");

            statement.setInt(1, this.packageId); // ADDING

            resultSet = statement.executeQuery(); // EXECUTE QUERY

            return resultSet.getString(1);

        }
        catch (SQLException se) {
            System.out.println("SQL EXCEPTION - DATA NOT FOUND");
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


    // Used for updating user data in database
    private void updatePackage(String type, String data) {
        ResultSet resultSet = null;
        PreparedStatement statement = null;
        Connection connection = null;

        try {
            connection = Database.getConnection(); // CONNECTING TO DATABASE

            // PREPARING STATEMENT
            statement = connection.prepareStatement("UPDATE package SET "+type+" = '"+data+"' WHERE PackageID = '"+this.packageId+"';");

            statement.execute(); // EXECUTE QUERY

            System.out.println("ALERT - User "+type+" info updated!");

        }
        catch (SQLException se) {
            System.out.println("SQL EXCEPTION - DATA NOT FOUND");
            se.printStackTrace();

        }
        catch (Exception e) {
            e.printStackTrace();
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


    public void insertPackage(int packageId) {



    }

}
