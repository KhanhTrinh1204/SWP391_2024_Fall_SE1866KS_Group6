/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import Models.Account;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoginDAO extends BaseDAO implements ILoginDAO {

    @Override
    public Account login(String user, String pass) {
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        String query = "select * from account where Username = ?  and Password = ?";
        try {
            conn = getConnection();
            statement = conn.prepareStatement(query);
            statement.setString(1, user);
            statement.setString(2, pass);
            rs = statement.executeQuery();
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
        } catch (SQLException ex) {
            Logger.getLogger(LoginDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(conn, statement, rs);
        }
        return null;
    }

    @Override
    public Account loginwithEmail(String email, String pass) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "select * from account where Email = ?  and Password = ?";
        try {
            conn = getConnection();
            ps = conn.prepareStatement(query);
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
        } catch (SQLException ex) {
            Logger.getLogger(LoginDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(conn, ps, rs);
        }
        return null;

    }

    @Override
    public Account checkAccount(String user) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "select * from account where Username =?";
        try {
            conn = getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, user);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Account(
                        rs.getString(2),
                        rs.getString(3));
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoginDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(conn, ps, rs);
        }
        return null;
    }

    @Override
    public Account getEmail(String email) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "select * from account where Email =?";
        try {
            conn = getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, email);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Account(
                        rs.getString(2),
                        rs.getString(3));
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoginDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(conn, ps, rs);
        }
        return null;
    }

    @Override
    public void updatePassword(String email, String password) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "update Account set password = ?  where Email =?";
        try {
            conn = getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, password);
            ps.setString(2, email);
            rs = ps.executeQuery();
            ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(LoginDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(conn, ps, rs);
        }
    }

    @Override
    public void signup(String user, String pass, String email, String fullname, String address, String gender, String phone) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "insert into Account(Username, Email, Password , Fullname,Address,Gender, Phone,DOB,RoleID) values(?, ?, ?,?,?, ?, ?,'',1)";
        try {
            conn = getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, user);
            ps.setString(2, pass);
            ps.setString(3, email);
            ps.setString(4, fullname);
            ps.setString(5, address);
            ps.setString(6, gender);
            ps.setString(7, phone);
            rs = ps.executeQuery();

            ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(LoginDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(conn, ps, rs);
        }
    }

    @Override
    public void updateProfile(String userName, String fullName, String Address, String gender, String dob, String phone, String avatar, String email) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "update Account set Username = ? , Fullname = ? , Address = ?, Gender =?, DOB = ? ,Phone = ?, Avatar= ? where Email = ?";
        try {
            conn = getConnection();
            ps = conn.prepareStatement(query);
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

        } catch (SQLException ex) {
            Logger.getLogger(LoginDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(conn, ps, rs);
        }
    }

    @Override
    public Account viewProfile(String email) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "select * from account where Email = ?";
        try {
            conn = getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, email);
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
        } catch (SQLException ex) {
            Logger.getLogger(LoginDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(conn, ps, rs);
        }
        return null;

    }

}
