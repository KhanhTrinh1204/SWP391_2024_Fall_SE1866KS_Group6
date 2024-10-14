/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import Models.Feedback;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hoang
 */
public class FeedbackDAO extends BaseDAO implements IFeedbackDAO {

    @Override
    public List<Feedback> searchFeedbacks(String email, String status, int page, int recordsPerPage) {
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        List<Feedback> feedbackList = new ArrayList<>();
        int start = (page - 1) * recordsPerPage;
        // Base query
        StringBuilder query = new StringBuilder("SELECT * FROM Feedback WHERE 1=1");

        // Add email filter if provided
        if (email != null && !email.isEmpty()) {
            query.append(" AND Email LIKE ?");
        }

        // Add status filter if provided
        if (status != null && !status.isEmpty()) {
            query.append(" AND Status = ?");
        }

        // Add pagination
        query.append(" ORDER BY FeedbackID desc OFFSET ? ROWS FETCH NEXT ? ROWS ONLY;");

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

            rs = statement.executeQuery();
            while (rs.next()) {
                Feedback account = new Feedback(
                        rs.getString("FeedbackID"),
                        rs.getString("Email"),
                        rs.getString("Title"),
                        rs.getString("Date"),
                        rs.getString("Description"),
                        rs.getString("Response"),
                        rs.getString("Status")
                );
                feedbackList.add(account);
            }
        } catch (SQLException ex) {
            Logger.getLogger(FeedbackDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(conn, statement, rs);
        }
        return feedbackList;
    }

    @Override
    public int getTotalRecords(String email, String status) {
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        int totalRecords = 0;

        // Base query
        StringBuilder query = new StringBuilder("SELECT COUNT(*) FROM Feedback WHERE 1=1");

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

            rs = statement.executeQuery();
            if (rs.next()) {
                totalRecords = rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(FeedbackDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(conn, statement, rs);
        }
        return totalRecords;
    }
        

    @Override
    public boolean updateFeedback(String id, String response) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "update Feedback set status = 1, Response= ? where FeedbackID =?";
        try {
            conn = getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, response);
            ps.setString(2, id);
            rs = ps.executeQuery();
            ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(FeedbackDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(conn, ps, rs);
        }
        return true;
    }
    public static void main(String[] args) {
        FeedbackDAO dao = new FeedbackDAO();
        List<Feedback> a = dao.searchFeedbacks("", "", 1, 1);
        System.err.println(a.get(0).getEmail());
    }

    @Override
    public boolean deleteFeedback(String id) {
          Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "delete from Feedback where FeedbackID =?";
        try {
            conn = getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, id);
            rs = ps.executeQuery();
            ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(FeedbackDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(conn, ps, rs);
        }
        return true;
    }

    @Override
    public Feedback getFeedbackByID(String id) {
          Connection conn = null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        String query = "select * from account where FeedbackID =?";
        try {
            conn = getConnection();
            statement = conn.prepareStatement(query);
            statement.setString(1, id);
            rs = statement.executeQuery();
            while (rs.next()) {
                    return new Feedback(
                        rs.getString("FeedbackID"),
                        rs.getString("Email"),
                        rs.getString("Title"),
                        rs.getString("Date"),
                        rs.getString("Description"),
                        rs.getString("Response"),
                        rs.getString("Status")
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
    public boolean createFeedback(String email, String title, String description) {
         Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String query = "INSERT INTO Feedback \n" +
                        "VALUES (?, ?, GETDATE(), ?, '', 'false');";
        try {
            conn = getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, email);
              ps.setString(2, title);
                ps.setString(3, description);
            rs = ps.executeQuery();
            ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(FeedbackDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(conn, ps, rs);
        }
        return true;
    }
}
