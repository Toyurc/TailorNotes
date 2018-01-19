package dao;

import pojo.CustomerObject;

import java.io.FileInputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;


public class CustomerDAO {

    private Connection mConnection;

    /**
     * @throws Exception
     */
    public CustomerDAO() throws Exception {

        Properties properties = new Properties();

        // get db properties
        properties.load(new FileInputStream("/Users/toyosi.adebayo-ige/IdeaProjects/TailorApp/src/tailor.properties"));

        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String dburl = properties.getProperty("dburl");

        // connect to database
        mConnection = DriverManager.getConnection(dburl, user, password);
        System.err.println("DB connection successful to: " + dburl);
    }

    /**
     * @param customerId id to recognise the customer
     * @throws SQLException
     */
    public void deleteCustomer(int customerId) throws SQLException {
        PreparedStatement myStmt = null;

        try {
            // prepare statement
            myStmt = mConnection.prepareStatement("delete from customers where id=?");

            // set param
            myStmt.setInt(1, customerId);

            // execute SQL
            myStmt.executeUpdate();
        } finally {
            close(myStmt);
        }
    }

    /**
     * @param thecustomer
     * @throws SQLException
     */
    public void updateCustomer(CustomerObject thecustomer) throws SQLException {
        PreparedStatement myStmt = null;

        try {
            // prepare statement
            myStmt = mConnection.prepareStatement(
                    "update customers"
                    + " set lastName =?,"
                    + " firstName=?,address = ?,type = ?,"
                    + "date = ?,"
                    + "description = ?,"
                    + "waist = ?,"
                    + "hip = ?,"
                    + "shoulder = ?,"
                    + "bust = ?,"
                    + "skirtLength = ?,"
                    + "gownLength = ?,"
                    + "shoulderToWaist = ?,"
                    + "acrossBack = ?,"
                    + "blouse = ?,"
                    + "underBust = ? ,"
                    + "bp = ?,"
                    + "np = ?"
                    + " where id=?");

            // set params
            myStmt.setInt(1, thecustomer.getId());
            myStmt.setString(2, thecustomer.getFirstName());
            myStmt.setString(3, thecustomer.getLastName());
            myStmt.setString(4, thecustomer.getAddress());
            myStmt.setString(5, thecustomer.getType());
            myStmt.setDate(6, (java.sql.Date) thecustomer.getDate());
            myStmt.setString(7, thecustomer.getDescription());
            myStmt.setFloat(8, thecustomer.getWaist());
            myStmt.setFloat(9, thecustomer.getHip());
            myStmt.setFloat(10, thecustomer.getShoulder());
            myStmt.setFloat(11, thecustomer.getBust());
            myStmt.setFloat(12, thecustomer.getBlouse());
            myStmt.setFloat(13, thecustomer.getSkirtLength());
            myStmt.setFloat(14, thecustomer.getGownLength());
            myStmt.setFloat(15, thecustomer.getAcrossBack());
            myStmt.setFloat(16, thecustomer.getUnderBust());
            myStmt.setFloat(17, thecustomer.getShoulderToWaist());
            myStmt.setFloat(18, thecustomer.getbp());
            myStmt.setFloat(19, thecustomer.getnp());

            // execute SQL
            myStmt.executeUpdate();
        } finally {
            close(myStmt);
        }
    }

    /**
     * @param thecustomer
     * @throws Exception
     */
    public void addCustomer(CustomerObject thecustomer) throws SQLException {
        PreparedStatement myStmt = null;

        try {
            // prepare statement
            myStmt = mConnection.prepareStatement("insert into customers"
                    + " (id, lastName, firstName,address,type,date,"
                    + "description,waist,hip,shoulder,bust,skirtLength,gownLength,"
                    + "shoulderToWaist,"
                    + "acrossBack,blouse,underBust,bp,np)"
                    + " values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

            // set params
            myStmt.setInt(1, thecustomer.getId());
            myStmt.setString(2, thecustomer.getFirstName());
            myStmt.setString(3, thecustomer.getLastName());
            myStmt.setString(4, thecustomer.getAddress());
            myStmt.setString(5, thecustomer.getType());
            myStmt.setDate(6, (java.sql.Date) thecustomer.getDate());
            myStmt.setString(7, thecustomer.getDescription());
            myStmt.setFloat(8, thecustomer.getWaist());
            myStmt.setFloat(9, thecustomer.getHip());
            myStmt.setFloat(10, thecustomer.getShoulder());
            myStmt.setFloat(11, thecustomer.getBust());
            myStmt.setFloat(12, thecustomer.getBlouse());
            myStmt.setFloat(13, thecustomer.getSkirtLength());
            myStmt.setFloat(14, thecustomer.getGownLength());
            myStmt.setFloat(15, thecustomer.getAcrossBack());
            myStmt.setFloat(16, thecustomer.getUnderBust());
            myStmt.setFloat(17, thecustomer.getShoulderToWaist());
            myStmt.setFloat(18, thecustomer.getbp());
            myStmt.setFloat(19, thecustomer.getnp());

            // execute SQL
            myStmt.executeUpdate();
        } finally {
            close(myStmt);
        }
    }

    /**
     * @return
     * @throws Exception
     */
    public List<CustomerObject> getAllCustomers() throws SQLException {
        List<CustomerObject> list = new ArrayList<>();

        Statement myStmt = null;
        ResultSet myRs = null;

        try {
            myStmt = mConnection.createStatement();
            myRs = myStmt.executeQuery("select * from customers order by lastName");

            while (myRs.next()) {
                CustomerObject someCustomerObject = convertRowToCustomer(myRs);
                list.add(someCustomerObject);
            }

            return list;
        } finally {
            close(myStmt, myRs);
        }
    }

    /**
     * @param lastName
     * @return
     * @throws Exception
     */
    public List<CustomerObject> searchCustomer(String lastName) throws SQLException {
        List<CustomerObject> list = new ArrayList<>();

        PreparedStatement myStmt = null;
        ResultSet myRs = null;

        try {
            lastName += "%";
            myStmt = mConnection.prepareStatement("select * from customers where lastName like ?  order by lastName");

            myStmt.setString(1, lastName);

            myRs = myStmt.executeQuery();

            while (myRs.next()) {
                CustomerObject someCustomerObject = convertRowToCustomer(myRs);
                list.add(someCustomerObject);
            }

            return list;
        } finally {
            close(myStmt, myRs);
        }
    }

    /**
     * @param myConn
     * @param myStmt
     * @param myRs
     * @throws SQLException
     */
    private static void close(Connection myConn, Statement myStmt, ResultSet myRs)
            throws SQLException {

        if (myRs != null) {
            myRs.close();
        }

        if (myStmt != null) {
            myStmt.close();
        }

        if (myConn != null) {
            myConn.close();
        }
    }

    /**
     * @param myStmt
     * @param myRs
     * @throws SQLException
     */
    private void close(Statement myStmt, ResultSet myRs) throws SQLException {
        close(null, myStmt, myRs);
    }

    /**
     * @param myStmt
     * @throws SQLException
     */
    private void close(Statement myStmt) throws SQLException {
        close(null, myStmt, null);
    }

    /**
     * @param mResultSet
     * @return
     * @throws SQLException
     */
    private CustomerObject convertRowToCustomer(ResultSet mResultSet) throws SQLException {

        int id = mResultSet.getInt("id");
        String lastName = mResultSet.getString("lastName");
        String firstName = mResultSet.getString("firstName");
        String address = mResultSet.getString("address");
        String type = mResultSet.getString("type");
        Date collectionDay = mResultSet.getDate("date");
        String description = mResultSet.getString("description");
        float waist = mResultSet.getFloat("waist");
        float hip = mResultSet.getFloat("hip");
        float shoulder = mResultSet.getFloat("shoulder");
        float bust = mResultSet.getFloat("bust");
        float skirtLength = mResultSet.getFloat("skirtLength");
        float gownLength = mResultSet.getFloat("gownLength");
        float shoulderToWaist = mResultSet.getFloat("shoulderToWaist");
        float acrossBack = mResultSet.getFloat("acrossBack");
        float blouse = mResultSet.getFloat("blouse");
        float underBust = mResultSet.getFloat("underBust");
        float bp = mResultSet.getFloat("bp");
        float np = mResultSet.getFloat("np");

        CustomerObject mCustomerObject;
        mCustomerObject = new CustomerObject(
                id,
                lastName,
                firstName,
                address,
                type,
                collectionDay,
                description,
                waist,
                hip,
                shoulder,
                bust,
                skirtLength,
                gownLength,
                shoulderToWaist,
                acrossBack,
                blouse,
                underBust,
                bp,
                np
        );
        return mCustomerObject;
    }
}


