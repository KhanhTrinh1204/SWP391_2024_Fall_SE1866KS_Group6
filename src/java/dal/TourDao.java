/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Tour;

/**
 *
 * @author ASUS
 */
public class TourDao extends DbContext<Tour> {

    @Override
    public void insert(Tour model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Tour model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Tour model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Tour> list() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
   public ArrayList<Tour> GetListTour() {
    ArrayList<Tour> tours = new ArrayList<>();
    String sql = "SELECT TourID, TourName, Price FROM Tour";
    
    try {
        PreparedStatement stm = connection.prepareStatement(sql);
        ResultSet rs = stm.executeQuery();
        
        while (rs.next()) {
            Tour tour = new Tour();
            tour.setTourId(rs.getInt("TourID"));
            tour.setTourName(rs.getString("TourName"));
            tour.setPrice(rs.getFloat("Price"));  // Assuming Price is of type float
            
            // Thêm đối tượng tour vào danh sách
            tours.add(tour);
        }
        
    } catch (SQLException ex) {
        Logger.getLogger(TourDao.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    return tours;
}

}
