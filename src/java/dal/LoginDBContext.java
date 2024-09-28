/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import Models.Account;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author hoang
 */
public class LoginDBContext extends DBContext<Account> {

    PreparedStatement ps = null;
    ResultSet rs = null;

    public Account login(String user, String pass) {
        String query = "select * from account where Username = ?  and Password = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, user);
            ps.setString(2, pass);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Account(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getString(10),
                        rs.getString(11)
                );
            }
        } catch (Exception e) {
        }
        return null;

    }
    
     public Account loginwithEmail(String email, String pass) {
        String query = "select * from account where Email = ?  and Password = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, email);
            ps.setString(2, pass);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Account(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getString(10),
                        rs.getString(11)
                );
            }
        } catch (Exception e) {
        }
        return null;

    }

     
    public Account checkAccount(String user) {
        String query = "select * from account where Username =?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, user);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Account(
                        rs.getString(2),
                        rs.getString(3));
            }
        } catch (Exception e) {
        }
        return null;

    }


    public Account getEmail(String email) {
        String query = "select * from account where Email =?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, email);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Account(
                        rs.getString(2),
                        rs.getString(3));
            }
        } catch (Exception e) {
        }
        return null;

    }

    public void updatePassword(String email, String password) {
        String query = "update Account set password = ?  where Email =?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, password);
            ps.setString(2, email);
            rs = ps.executeQuery();
            ps.executeUpdate();

        } catch (Exception e) {
        }

    }

    @Override
    public ArrayList<Account> list() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Account get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void insert(Account model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Account model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Account model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void signup(String user, String pass, String email, String fullname, String address, String gender, String phone) {
        //String query = "insert into Account values(?,?,?, ?,?,?,?,'1',?,'',true)";
        String query = "insert into Account(Username, Email, Password , Fullname,Address,Gender, Phone,DOB,RoleID) values(?, ?, ?,?,?, ?, ?,'',1)";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, user);
            ps.setString(2, pass);
            ps.setString(3, email);
            ps.setString(4, fullname);
            ps.setString(5, address);
            ps.setString(6, gender);
            ps.setString(7, phone);
            rs = ps.executeQuery();

            ps.executeUpdate();

        } catch (Exception e) {
        }
    }

    public static void main(String[] args) {
        LoginDBContext lg = new LoginDBContext();
        Account a = lg.getEmail("hoangngoclong2001@gmail.com");
        System.out.print(a.getUserName());
    }
     public void updateProfile(String userName, String fullName, String Address, String gender , String dob, String phone, String avatar, String email) {
        String query = "update Account set Username = ? , Fullname = ? , Address = ?, Gender =?, DOB = ? ,Phone = ?, Avatar= ? where Email = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, userName);
            ps.setString(2, fullName);
             ps.setString(3, Address);
              ps.setString(4, gender);
               ps.setString(5, dob);
                ps.setString(6, phone);
                 ps.setString(7, avatar);
                                ps.setString(8, email);
            rs = ps.executeQuery();
            ps.executeUpdate();

        } catch (Exception e) {
        }

    }
}
