/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbcsample;

import com.mysql.jdbc.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import jdbcsample.config.MySqlClass;
import jdbcsample.employee.Employee;

/**
 *
 * @author AGUIRREMR
 */
import jdbcsample.employee.frmMain;

public class app {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {

       

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmMain().setVisible(true);
            }
        });
    }

}
