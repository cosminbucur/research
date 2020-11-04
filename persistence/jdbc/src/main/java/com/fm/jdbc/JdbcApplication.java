package com.fm.jdbc;

import com.fm.jdbc.util.PropertiesLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;

public class JdbcApplication {

    // TODO: add slf4j + log4j support
    private static final Logger logger = LoggerFactory.getLogger(JdbcApplication.class);

    public static void main(String[] args) throws SQLException {
        PropertiesLoader propertiesLoader = new PropertiesLoader();
        propertiesLoader.loadProperties();

        Connection myConn = null;
        Statement myStmt = null;
        ResultSet myRs = null;

        try {
            myConn = DriverManager.getConnection(propertiesLoader.url, propertiesLoader.username, propertiesLoader.password);
            System.out.println("Database connection successful!\n");
            myStmt = myConn.createStatement();
            myRs = myStmt.executeQuery("select * from bookapp.book");
            while (myRs.next()) {
                System.out.println(myRs.getString("author") + ", " + myRs.getString("title") +", "
                        + myRs.getDate("publish_date"));
            }
        }
        catch (Exception exc) {
            exc.printStackTrace();
        }
        finally {
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
    }
}
