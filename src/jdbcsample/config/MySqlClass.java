/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbcsample.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author AGUIRREMR
 */
public class MySqlClass {

    private static final String DB_DRIVER = "com.mysql.jdbc.Driver";
    public static String HOST = "";
    public static String DATABASE = "";
    private static final String DB_CONNECTION = "jdbc:mysql://" + HOST + ":3306/" + DATABASE;
    public static String DB_USER = "root";
    public static String DB_PASSWORD = "";

    private static java.sql.Connection getDBConnection() {

        java.sql.Connection dbConnection = null;

        try {
            Class.forName(DB_DRIVER);
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        try {
            dbConnection = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
            return dbConnection;

        } catch (SQLException e) {

            System.out.println(e.getMessage());

        }

        return dbConnection;

    }

    public static ResultSet Table(String selectSQL, String[] placeHolderValue) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = getDBConnection();
            stmt = conn.prepareStatement(selectSQL);
            stmt.setString(1,placeHolderValue[0].toString()); //set the placeholder value         
            rs = stmt.executeQuery();  // execute  SQL stetement

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }
            if (rs != null) {
                rs.close();
            }
        }
        return rs;
    }

    public static int ExecuteQuery(String qry, String[] value) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int status = 0;
        try {
            conn = getDBConnection();
            stmt = conn.prepareStatement(qry);
            stmt.setInt(1, 1001); //set the placeholder value         
            status = stmt.executeUpdate();  // execute  SQL stetement

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return status;
    }

//      public static void ResultSet(String selectSQL) throws SQLException {
//        Connection conn = null;
//        PreparedStatement stmt = null;
//
//        try {
//            conn = getDBConnection();
//            stmt = conn.prepareStatement(selectSQL);
//            stmt.setInt(1, 1001); //set the placeholder value         
//            ResultSet rs = stmt.executeQuery();  // execute select SQL stetement
//
//            while (rs.next()) {
//                String userid = rs.getString("USER_ID");
//                String username = rs.getString("USERNAME");
//                System.out.println("userid : " + userid);
//                System.out.println("username : " + username);
//            }
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        } finally {
//            if (stmt != null) {
//                stmt.close();
//            }
//            if (conn != null) {
//                conn.close();
//            }
//        }
//
//    }
}
