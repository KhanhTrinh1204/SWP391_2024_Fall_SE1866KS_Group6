/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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

    public List<Restaurant> ListRestaurant(String search,int page, int recordsPerPage) {
        List<Restaurant> restaurants = new ArrayList<>();
          StringBuilder query = new StringBuilder("select RestaurantID, RestaurantName,Location, image  from Restaurant where 1=1");
       int start = (page - 1) * recordsPerPage;

        if (search != null && !search.trim().isEmpty()) {
             query.append(" AND RestaurantName LIKE ?");
          //  query += " and VehicleType like ?";
        }
               query.append(" ORDER BY RestaurantID desc OFFSET ? ROWS FETCH NEXT ? ROWS ONLY;");

        try {
              PreparedStatement statement = connection.prepareStatement(query.toString());
           
             int paramIndex = 1;
            // Set email parameter if provided
            if (search != null && !search.trim().isEmpty()) {
                statement.setString(paramIndex++, "%" + search + "%");
            }
            // Set pagination parameters
            statement.setInt(paramIndex++, start);
            statement.setInt(paramIndex, recordsPerPage);
            
            ResultSet rs = statement.executeQuery();
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
                + "           ([RestaurantName]\n"
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
                + "           ,?)";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);      // Set RestaurantID
            stm.setString(1, restaurant.getRestaurantName());      // Set RestaurantName
            stm.setString(2, restaurant.getLocation());            // Set Location
            stm.setString(3, restaurant.getDescription());         // Set Description
            stm.setString(4, restaurant.getPhoneNumber());         // Set PhoneNumber
            stm.setString(5, restaurant.getEmail());               // Set Email
            stm.setString(6, restaurant.getCategory());            // Set Category
            stm.setBoolean(7, restaurant.isStatus());
            stm.setString(8, restaurant.getImage());
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

     public int getTotalRecords(String search) {
        int totalRecords = 0;

        // Base query
            StringBuilder query = new StringBuilder("SELECT COUNT(*) FROM Restaurant");
        //String query = "SELECT COUNT(*) FROM Vehicle where VehicleType LIKE ?";
                    if (search != null && !search.trim().isEmpty()) {
             query.append(" Where RestaurantName LIKE ?");
          //  query += " and VehicleType like ?";
           }
        try {
          PreparedStatement stm = connection.prepareStatement(query.toString());
             if (search != null && !search.isEmpty()) {
                 
                stm.setString(1, "%" + search + "%");
            }
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                totalRecords = rs.getInt(1);
            }
        } catch (SQLException ex) {
        } finally {
        }
        return totalRecords;
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

  public void updateRestaurant(Restaurant restaurant) {
        String sql = "UPDATE Restaurant SET " +
                      "RestaurantName= ? ,"+
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
            
           ResultSet rs = ps.executeQuery();
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            
        }
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
