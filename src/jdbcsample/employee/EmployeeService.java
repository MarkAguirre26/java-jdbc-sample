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
import java.util.Map;
import jdbcsample.config.*;

/**
 *
 * @author AGUIRREMR
 */
public class EmployeeService {

    public static int Save(Employee e) throws SQLException {
        int status = 0;
        status = MySqlClass.ExecuteQuery("INSERT INTO `todo_employees` (`first_name`, `last_name`, `role`, `password`, `username`) VALUES (?,?,?,?,?)", new String[]{e.getFirstName(), e.getLastName(), "Admin", "pwd", "username"});
        return status;
    }

    public static int Update(Employee e) throws SQLException {
        int status = 0;
        status = MySqlClass.ExecuteQuery("update query here", new String[]{e.getId() + "", e.getFirstName(), e.getLastName()});
        return status;
    }

    public static int Delete(Employee e) throws SQLException {
        int status = 0;
        status = MySqlClass.ExecuteQuery("Delete query here", new String[]{e.getId() + ""});
        return status;
    }

    public static List<Employee> getRows() throws SQLException {

        String SQL = "SELECT a.id, a.first_name, a.last_name FROM todo_employees AS a";

        List<Employee> employeeList = new ArrayList<>();

        try {

            List<Map<String, Object>> list = MySqlClass.TableRows(SQL, null);
            for (Map<String, Object> item : list) {
                Employee e = new Employee();
                e.setId((int) item.get("id"));
                e.setFirstName(item.get("first_name").toString());
                e.setLastName(item.get("last_name").toString());
                employeeList.add(e);

//                System.out.println(item.get("id") + " " + item.get("first_name") + " " + item.get("last_name"));
            }

        } catch (SQLException e) {
            System.err.print(e);
        }
        return employeeList;
    }

}
