/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.util.List;
import model.Feedback;

/**
 *
 * @author ASUS
 */
public interface IFeedbackDao {

    public List<Feedback> searchFeedbacks(String email, String status, int page, int recordsPerPage);

    public int getTotalRecords(String email, String status);

    public boolean updateFeedback(String id, String response);

    public boolean deleteFeedback(String id);

    public Feedback getFeedbackByID(String id);

    public boolean createFeedback(String email, String title, String description);
}
