/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import Model.Account;
import java.util.*;
import java.lang.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountDAO {

    public static AccountDAO INSTANCE = new AccountDAO();
    private Connection connection;

    private AccountDAO() {
        if (INSTANCE == null) {
            connection = new DBContext().connect;
        } else {
            INSTANCE = this;
        }
    }

    public Account checkAccount(String username, String password) {
        try {
            String sql = "SELECT * FROM Account WHERE accountid=? AND password=? ";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Account acc = new Account();
                acc.setUsername(rs.getString(1));
                acc.setPassword(rs.getString(2));
                return acc;
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }
    
    public static void main(String[] args) {
        Account acc = INSTANCE.checkAccount("mre", "mra");
        System.out.println(acc.getUsername());
    }
}
