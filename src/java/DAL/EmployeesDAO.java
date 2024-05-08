/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import Model.Employees;
import java.util.*;
import java.lang.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeesDAO {

    public static EmployeesDAO INSTANCE = new EmployeesDAO();
    private Connection connection;
    private String status = "OK";

    private EmployeesDAO() {
        if (INSTANCE == null) {
            connection = new DBContext().connect;
        } else {
            INSTANCE = this;
        }
    }

    public List<Employees> getEmployees() {
        List<Employees> listE = new ArrayList<>();
        try {
            String sql = "SELECT * FROM Employee";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Employees e = new Employees();
                e.setId(rs.getInt(1));
                e.setName(rs.getString(2));
                e.setGender(rs.getBoolean(3));
                e.setDob(rs.getDate(4));
                e.setCreatedBy(rs.getString(5));
                listE.add(e);
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return listE;
    }
    
    public static void main(String[] args) {
        List<Employees> listE = INSTANCE.getEmployees();
        for (Employees employees : listE) {
            System.out.println(employees.getId());
        }
    }
}
