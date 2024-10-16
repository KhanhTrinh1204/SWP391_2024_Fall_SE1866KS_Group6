/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Restaurant;

/**
 *
 * @author ASUS
 */
public class RestaurantDao extends DbContext<Restaurant> {

    @Override
    public void insert(Restaurant model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Restaurant model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Restaurant model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Restaurant> list() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public ArrayList<Restaurant> ListRestaurant() {
        ArrayList<Restaurant> restaurants = new ArrayList<>();
        String sql = "select RestaurantID, RestaurantName,Location, image "
                + "from Restaurant";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Restaurant res = new Restaurant();
                res.setRestaurantId(rs.getInt("RestaurantID"));
                res.setRestaurantName(rs.getString("RestaurantName"));
                res.setLocation(rs.getString("Location"));
                res.setImage(rs.getString("image"));
                restaurants.add(res);
            }
        } catch (SQLException ex) {
            Logger.getLogger(RestaurantDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return restaurants;
    }

    public void InsertRestaurant(Restaurant restaurant) {
        String sql = "INSERT INTO [dbo].[Restaurant]\n"
                + "           ([RestaurantID]\n"
                + "           ,[RestaurantName]\n"
                + "           ,[Location]\n"
                + "           ,[Description]\n"
                + "           ,[PhoneNumber]\n"
                + "           ,[Email]\n"
                + "           ,[Category]\n"
                + "           ,[Status]\n"
                + "           ,[image])\n"
                + "     VALUES\n"
                + "           (?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?)";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, restaurant.getRestaurantId());          // Set RestaurantID
            stm.setString(2, restaurant.getRestaurantName());      // Set RestaurantName
            stm.setString(3, restaurant.getLocation());            // Set Location
            stm.setString(4, restaurant.getDescription());         // Set Description
            stm.setString(5, restaurant.getPhoneNumber());         // Set PhoneNumber
            stm.setString(6, restaurant.getEmail());               // Set Email
            stm.setString(7, restaurant.getCategory());            // Set Category
            stm.setBoolean(8, restaurant.isStatus());
            stm.setString(9, restaurant.getImage());
            ResultSet rs = stm.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(RestaurantDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Restaurant GetRestaurantById(int id) {
        String sql = "select * from Restaurant where RestaurantID = ?";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                Restaurant restaurant = new Restaurant();
                restaurant.setRestaurantId(rs.getInt("RestaurantID"));
                restaurant.setRestaurantName(rs.getString("RestaurantName"));
                restaurant.setLocation(rs.getString("Location"));
                restaurant.setDescription(rs.getString("Description"));
                restaurant.setPhoneNumber(rs.getString("PhoneNumber"));
                restaurant.setEmail(rs.getString("Email"));
                restaurant.setCategory(rs.getString("Category"));
                restaurant.setStatus(rs.getBoolean("Status"));
                restaurant.setImage(rs.getString("image"));

                return restaurant;
            }
        } catch (SQLException ex) {
            Logger.getLogger(RestaurantDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public int getMaxId() {
        int maxId = 0;
        try {
            String sql = "select max(RestaurantID) as MaxId from Restaurant";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                maxId = rs.getInt("MaxId");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return maxId;
    }

  public boolean updateRestaurant(Restaurant restaurant) {
        String sql = "UPDATE Restaurant SET " +
                     "Location = ?, " +
                     "Description = ?, " +
                     "PhoneNumber = ?, " +
                     "Email = ?, " +
                     "Category = ?, " +
                     "Status = ?, " +
                     "Image = ? " +
                     "WHERE RestaurantID = ?";
        
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            // Thiết lập giá trị cho các tham số trong câu lệnh SQL
            ps.setString(1, restaurant.getRestaurantName());
            ps.setString(2, restaurant.getLocation());
            ps.setString(3, restaurant.getDescription());
            ps.setString(4, restaurant.getPhoneNumber());
            ps.setString(5, restaurant.getEmail());
            ps.setString(6, restaurant.getCategory());
            ps.setBoolean(7, restaurant.isStatus());
            ps.setString(8, restaurant.getImage());
            ps.setInt(9, restaurant.getRestaurantId());
            
            // Thực thi câu lệnh UPDATE
             int update = ps.executeUpdate();
           return update > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            
        }
    return false;
}



    public void DeleteRestaurant(int id) {
        String sql = "DELETE FROM [dbo].[Restaurant]\n"
                + "      WHERE RestaurantID = ?";

        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(StaffDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
