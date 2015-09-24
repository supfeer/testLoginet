package ru.loginet.test.ojects.tools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by supfe_000 on 23.09.2015.
 */
public class SqlTool {


    public static void deleteRequests(String[] requestNames) {
        final String DB_URL = "jdbc:sqlserver://test:1433;databaseName=LoginetFull;";
        final String USER = "AdminLoginet";
        final String PASS = "AdminLoginet2";

        Connection conn = null;
        Statement stmt = null;
        try {
            //STEP 2: Register JDBC driver
            DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
            //STEP 3: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            //STEP 4: Execute a query
            System.out.println("Creating statement...");

            //ResultSet rs = null;


            for (String requestName : requestNames) {
                stmt = conn.createStatement();
                //rs = null;
                String sql = "UPDATE dbo.ShippingRequest\n" +
                        "SET DeleteDate = SYSDATETIME ()\n" +
                        "WHERE Name LIKE N'" + requestName + "';";
                int i = stmt.executeUpdate(sql);
                stmt.close();
            }

            //STEP 5: Extract data from result set
            /*while(rs.next()){
                //Retrieve by column name

                String name = rs.getString("Name");
                String comment = rs.getString("Comment");

                //Display values
                System.out.print(", First: " + name);
                System.out.println(", Last: " + comment);
            }*/
            //STEP 6: Clean-up environment
            //rs.close();

            conn.close();
        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2) {
            }// nothing we can do
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }//end finally try
        }//end try
        System.out.println("Goodbye!");
    }

    public static void deleteRequest(String requestName) {
        final String DB_URL = "jdbc:sqlserver://test:1433;databaseName=LoginetFull;";
        final String USER = "AdminLoginet";
        final String PASS = "AdminLoginet2";

        Connection conn = null;
        Statement stmt = null;
        try {
            //STEP 2: Register JDBC driver
            DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
            //STEP 3: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            //STEP 4: Execute a query
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql;
            sql = "UPDATE dbo.ShippingRequest\n" +
                    "set DeleteDate = SYSDATETIME ()\n" +  //
                    "WHERE name LIKE N'" + requestName + "';";
            //ResultSet rs =
            stmt.executeUpdate(sql);

            //STEP 5: Extract data from result set
            /*while(rs.next()){
                //Retrieve by column name

                String name = rs.getString("Name");
                String comment = rs.getString("Comment");

                //Display values
                System.out.print(", First: " + name);
                System.out.println(", Last: " + comment);
            }*/
            //STEP 6: Clean-up environment
            //rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2) {
            }// nothing we can do
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }//end finally try
        }//end try
        System.out.println("Goodbye!");
    }
}
