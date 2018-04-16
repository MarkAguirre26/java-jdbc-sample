/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbcsample.employee;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import jdbcsample.config.AppAction;
import jdbcsample.config.*;

/**
 *
 * @author AGUIRREMR
 */
public class EmployeeService {

    public static int Save(Employee e) throws SQLException {
        int status = 0;
        status = MySqlClass.ExecuteQuery("Insert Query Here", new String[]{e.getFirstName(), e.getLastName()});
        return status;
    }

    public static int Update(Employee e) throws SQLException {
        int status = 0;
        status = MySqlClass.ExecuteQuery("update query here", new String[]{e.getId() + "", e.getFirstName(), e.getLastName()});
        return status;
    }
    
     public static int Delete(Employee e) throws SQLException {
        int status = 0;
        status = MySqlClass.ExecuteQuery("Delete query here", new String[]{e.getId()+""});
        return status;
    }
          
    public static List<Employee> getEmployees() throws SQLException {
        List<Employee> list = new ArrayList<>();
        ResultSet rs = null;
        rs = MySqlClass.Table("query here", new String[]{""});
        while (rs.next()) {
            Employee e = new Employee();
            e.setFirstName(rs.getString(1).toString());
            e.setLastName(rs.getString(2).toString());
            list.add(e);
        }
        if (rs != null) {
            rs.close();
        }
        return list;
    }

}
