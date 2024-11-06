/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Account;

public class LoginDAO extends BaseDAO implements ILoginDAO {
    @Override
    public Account login(String user, String pass) {
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        String query = "select * from account where Username = ?  and Password = ? and Status = true";
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
    public int getTotalRecordsAccount(String email, String status) {
        int totalRecords = 0;
          Connection conn = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        // Base query
        StringBuilder query = new StringBuilder("SELECT COUNT(*) FROM Account WHERE 1=1");

        // Add email filter if provided
        if (email != null && !email.isEmpty()) {
            query.append(" AND Email LIKE ?");
        }

        // Add status filter if provided
        if (status != null && !status.isEmpty()) {
            query.append(" AND Status = ?");
        }

        try {
             conn = getConnection();
            statement = conn.prepareStatement(query.toString());

            int paramIndex = 1;

            // Set email parameter if provided
            if (email != null && !email.isEmpty()) {
                statement.setString(paramIndex++, "%" + email + "%");
            }

            // Set status parameter if provided
            if (status != null && !status.isEmpty()) {
                statement.setString(paramIndex++, status);
            }

           rs=  statement.executeQuery();
            if (rs.next()) {
                totalRecords = rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoginDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(conn, statement, rs);
        }
        return totalRecords;
    }
    
    
     @Override
    public List<Account> getTotalListAccount(String email, String status,int page, int recordsPerPage) {
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
         List<Account> accountLists = new ArrayList<>();
        int start = (page - 1) * recordsPerPage;
        // Base query
        StringBuilder query = new StringBuilder("SELECT * FROM Account WHERE 1=1");
        // Add email filter if provided
        if (email != null && !email.isEmpty()) {
            query.append(" AND Email LIKE ?");
        }
        // Add status filter if provided
        if (status != null && !status.isEmpty()) {
            query.append(" AND Status = ?");
        }
        // Add pagination
        query.append(" ORDER BY AccountID desc OFFSET ? ROWS FETCH NEXT ? ROWS ONLY;");
        try {
            conn = getConnection();
            statement = conn.prepareStatement(query.toString());
            int paramIndex = 1;
            // Set email parameter if provided
            if (email != null && !email.isEmpty()) {
                statement.setString(paramIndex++, "%" + email + "%");
            }
            // Set status parameter if provided
            if (status != null && !status.isEmpty()) {
                statement.setString(paramIndex++, status);
            }
            // Set pagination parameters
            statement.setInt(paramIndex++, start);
            statement.setInt(paramIndex, recordsPerPage);

              rs=  statement.executeQuery();
            while (rs.next()) {
                Account account = new Account(
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
                        rs.getString(11),
                        rs.getString(12)
                );
                accountLists.add(account);
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoginDAO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } finally {
         
        }
        return accountLists;
    }
    @Override
    public Account loginwithEmail(String email, String pass) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "select * from account where Email = ?  and Password = ? and Status = 'true'";
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
                        rs.getString(11),
                            rs.getString(12)
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
     public void createAccount(String user, String pass, String email, String fullname, String address, String phone, String roleID){
          Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "insert into Account(Username,Password,  Email  , Fullname,Address,Gender, Phone,DOB,RoleID,Status) values(?, ?, ?,?,?, '', ?,'',?,'True')";
        try {
            conn = getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, user);
            ps.setString(2, pass);
            ps.setString(3, email);
            ps.setString(4, fullname);
            ps.setString(5, address);
            ps.setString(6, phone);
            ps.setString(7, roleID);
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
        String query = "insert into Account(Username, Password,Email  , Fullname,Address,Gender, Phone,DOB,RoleID,Status) values(?, ?, ?,?,?, ?, ?,'',1, 'true')";
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
    public boolean updateProfile(String userName, String fullName, String Address, String gender, String dob, String phone, String avatar, String email) {
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
        return true;
    }

    
    
      @Override
    public void updateUser( String fullName, String Address,  String phone,String role,String status ,String email ) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "update Account set Fullname = ? , Address = ?,Phone = ?, RoleID= ?,Status= ?  where Email = ?";
        try {
            conn = getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, fullName);
            ps.setString(2, Address);
            ps.setString(3, phone);
            ps.setString(4, role);
               ps.setString(5, status);
                ps.setString(6, email);
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
                        rs.getString(11),
                        rs.getString(12)
                );
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoginDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(conn, ps, rs);
        }
        return null;

    }
   
public static void main(String[] args) {
        LoginDAO dao = new LoginDAO();
        // Retrieve a tour with a specific ID, e.g., 2
        Account a = dao.loginwithEmail("hoangngoclong2001@gmail.com","1234");

        // Check if the tour is not null before trying to print its details
        
            System.out.println(a.getStatus());
        
    
}
}