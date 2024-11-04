/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;
import java.util.List;
import model.Hotel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 *
 * @author ACER
 */
public class HotelDAO extends DbContext<Hotel>{

   
    public ArrayList<Hotel> getHotel(String search,int page, int recordsPerPage) {
        ArrayList<Hotel> listHotel = new ArrayList<>();
        String sql = "select * from hotel";
        
           StringBuilder query = new StringBuilder("select * from hotel where 1=1");
       int start = (page - 1) * recordsPerPage;

        if (search != null && !search.trim().isEmpty()) {
             query.append(" AND hotel_name LIKE ?");
        }
               query.append(" ORDER BY hotel_id desc OFFSET ? ROWS FETCH NEXT ? ROWS ONLY;");

               
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
                Hotel hotel = new Hotel();
                hotel.setHotelId(rs.getInt("hotel_id"));
                hotel.setImgUrl(rs.getString("img_URL"));
                hotel.setPrice(rs.getString("price"));
                hotel.setHotelName(rs.getString("hotel_name"));
                hotel.setDescription(rs.getString("description"));
                listHotel.add(hotel);
            }
        } catch (SQLException ex) {
            Logger.getLogger(HotelDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listHotel;
    }
    
    public int getTotalRecords(String search) {
        int totalRecords = 0;

        // Base query
            StringBuilder query = new StringBuilder("SELECT COUNT(*) FROM hotel");
        //String query = "SELECT COUNT(*) FROM Vehicle where VehicleType LIKE ?";
                    if (search != null && !search.trim().isEmpty()) {
             query.append(" Where hotel_name LIKE ?");
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
     public void addHotel(Hotel hotel) {
        String sql = "INSERT INTO hotel (hotel_name, img_url, description, start_date, end_date, active, price)"
                + " VALUES (?, ?, ?, ?, ?, 1, ?)";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, hotel.getHotelName());
            stm.setString(2, hotel.getImgUrl());
            stm.setString(3, hotel.getDescription());
            stm.setDate(4, new java.sql.Date(hotel.getStartDate().getTime()));
            stm.setDate(5, new java.sql.Date(hotel.getEndDate().getTime()));   
           stm.setString(6, hotel.getPrice());
            
            stm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
     public void deleteHotel(int id) {
        String sql = "DELETE FROM [dbo].[hotel]\n"
                + "      WHERE hotel_id = ?";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(HotelDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
     public Hotel getHotelById(int hotelId) {
        String sql = "SELECT hotel_id, hotel_name, img_URL, start_date, end_date, description, price"
                + " FROM hotel WHERE hotel_id = ?";

        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, hotelId);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                Hotel hotel = new Hotel();
                hotel.setHotelId(rs.getInt("hotel_id"));
                hotel.setHotelName(rs.getString("hotel_name"));
                hotel.setImgUrl(rs.getString("img_URL"));
                hotel.setStartDate(rs.getDate("start_date"));
                hotel.setEndDate(rs.getDate("end_date"));
                hotel.setDescription(rs.getString("description"));
                hotel.setPrice(rs.getString("price"));

                return hotel;
            }
        } catch (SQLException ex) {
            Logger.getLogger(HotelDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
     public boolean updateHotel(Hotel hotel) {
        String sql = "UPDATE hotel SET hotel_name = ?, img_URL = ?, start_date = ?, end_date = ?, description = ?, price = ? WHERE hotel_id = ?";

        try (PreparedStatement stm = connection.prepareStatement(sql)) {
            stm.setString(1, hotel.getHotelName());
            stm.setString(2, hotel.getImgUrl());
            stm.setDate(3, new java.sql.Date(hotel.getStartDate().getTime()));
            stm.setDate(4, new java.sql.Date(hotel.getEndDate().getTime()));
            stm.setString(5, hotel.getDescription());
            stm.setString(6, hotel.getPrice());
            stm.setInt(7, hotel.getHotelId());

            int rowsUpdated = stm.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException ex) {
            Logger.getLogger(HotelDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
     
    @Override
    public void insert(Hotel model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Hotel model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Hotel model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Hotel> list() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    

    
    //public static void main(String[] args){
      //  HotelDAO h =new HotelDAO();
        //List<Hotel> list =h.getHotel();
        //System.out.println(list.get(0).getAll());
    //}

}
