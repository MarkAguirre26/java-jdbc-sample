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
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static javafx.scene.input.KeyCode.T;
import sun.security.rsa.RSACore;

/**
 *
 * @author AGUIRREMR
 */
public class MySqlClass {

    private static final String DB_DRIVER = "com.mysql.jdbc.Driver";
    public static String HOST = "localhost";
    public static String DATABASE = "dev-todo";
    private static final String DB_CONNECTION = "jdbc:mysql://" + HOST + ":3306/" + DATABASE + "?AutoReconnecttrue&useSSL=false";
    public static String DB_USER = "root";
    public static String DB_PASSWORD = "";

    public static Connection getConnection() throws SQLException {
        String USERNAME = "root";
        String PASSWORD = "";
        String CONN = "jdbc:mysql://localhost:3306/dev-todo?AutoReconnecttrue&useSSL=false";
        return DriverManager.getConnection(CONN, USERNAME, PASSWORD);

    }


    public static List<Map<String, Object>> TableRows(String selectSQL, String[] value) throws SQLException {

        ResultSet rs = null;
        List<Map<String, Object>> resultList = null;
        try (
                Connection conn = getConnection();
                PreparedStatement stmt = conn.prepareStatement(selectSQL);) {
            if(value != null){
                for(int i = 0;i < value.length; i++){
                    stmt.setString((i+1), value[i]);
                }
            }
            rs = stmt.executeQuery(); // execute  SQL stetement

            resultList = new ArrayList<Map<String, Object>>();
            Map<String, Object> row = null;

            ResultSetMetaData metaData = rs.getMetaData();
            Integer columnCount = metaData.getColumnCount();

            while (rs.next()) {
                row = new HashMap<String, Object>();
                for (int i = 1; i <= columnCount; i++) {
                    row.put(metaData.getColumnName(i), rs.getObject(i));
                }
                resultList.add(row);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            if (rs != null) {
                rs.close();
            }
        }

        return resultList;
    }

    public static int ExecuteQuery(String qry, String[] value) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int status = 0;
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(qry);
            if (value != null) {
                for (int i = 0; i < value.length; i++) {
                    stmt.setString((i + 1), String.valueOf(value[i]));
                }
            }
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
