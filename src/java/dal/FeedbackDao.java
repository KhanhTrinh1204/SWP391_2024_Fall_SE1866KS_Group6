/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.util.ArrayList;
import java.util.List;
import model.Feedback;
import java.sql.*;

/**
 *
 * @author ASUS
 */
public class FeedbackDao extends DbContext<Feedback> implements IFeedbackDao {

    @Override
    public void insert(Feedback model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Feedback model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Feedback model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Feedback> list() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Feedback> searchFeedbacks(String email, String status, int page, int recordsPerPage) {

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
            PreparedStatement statement = connection.prepareStatement(query.toString());
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

            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Feedback account = new Feedback(
                        rs.getInt("FeedbackID"),
                        rs.getString("Email"),
                        rs.getString("Title"),
                        rs.getString("Date"),
                        rs.getString("Description"),
                        rs.getString("Response"),
                        rs.getBoolean("Status")
                );
                feedbackList.add(account);
            }
        } catch (SQLException ex) {

        }
        return feedbackList;
    }

    @Override
    public int getTotalRecords(String email, String status) {
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
            PreparedStatement statement = connection.prepareStatement(query.toString());

            int paramIndex = 1;

            // Set email parameter if provided
            if (email != null && !email.isEmpty()) {
                statement.setString(paramIndex++, "%" + email + "%");
            }

            // Set status parameter if provided
            if (status != null && !status.isEmpty()) {
                statement.setString(paramIndex++, status);
            }

            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                totalRecords = rs.getInt(1);
            }
        } catch (SQLException ex) {
        } finally {
        }
        return totalRecords;
    }

    @Override
    public boolean updateFeedback(String id, String response) {

        String query = "update Feedback set status = 1, Response= ? where FeedbackID =?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, response);
            ps.setString(2, id);
            ResultSet rs = ps.executeQuery();
            ps.executeUpdate();

        } catch (SQLException ex) {
        } finally {
        }
        return true;
    }

    public static void main(String[] args) {
        FeedbackDao dao = new FeedbackDao();
        List<Feedback> a = dao.searchFeedbacks("", "", 1, 1);
        System.err.println(a.get(0).getEmail());
    }

    @Override
    public boolean deleteFeedback(String id) {
        String query = "delete from Feedback where FeedbackID =?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            ps.executeUpdate();

        } catch (SQLException ex) {
        } finally {
        }
        return true;
    }

    @Override
    public Feedback getFeedbackByID(String id) {
        String query = "select * from account where FeedbackID =?";
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                return new Feedback(
                        rs.getInt("FeedbackID"),
                        rs.getString("Email"),
                        rs.getString("Title"),
                        rs.getString("Date"),
                        rs.getString("Description"),
                        rs.getString("Response"),
                        rs.getBoolean("Status")
                );
            }
        } catch (SQLException ex) {
        } finally {
        }
        return null;
    }

    @Override
    public boolean createFeedback(String email, String title, String description) {
        String query = "INSERT INTO Feedback \n"
                + "VALUES (?, ?, GETDATE(), ?, '', 'false');";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, email);
            ps.setString(2, title);
            ps.setString(3, description);
            ResultSet rs = ps.executeQuery();
            ps.executeUpdate();

        } catch (SQLException ex) {
        } finally {
        }
        return true;
    }
}
