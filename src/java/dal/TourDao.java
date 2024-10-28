/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Restaurant;
import model.Tour;
import model.TravelAgent;
import model.Vehicle;

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
        String sql = "SELECT TourID, TourName, Price, Image FROM Tour";

        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                Tour tour = new Tour();
                tour.setTourId(rs.getInt("TourID"));
                tour.setTourName(rs.getString("TourName"));
                tour.setPrice(rs.getFloat("Price"));  // Assuming Price is of type float
                tour.setImage(rs.getString("Image"));
                // Thêm đối tượng tour vào danh sách
                tours.add(tour);
            }

        } catch (SQLException ex) {
            Logger.getLogger(TourDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return tours;
    }

    public Tour ViewTourDetail(int id) {
        String sql = "select t.TourID, t.TourName, t.Price, t.Description, t.StartDate, t.EndDate, ta.AgentName, v.VehicleName, r.RestaurantName, t.Image from Tour t\n"
                + "join TravelAgent ta on ta.AgentID = t.AgentID\n"
                + "join Vehicle v on v.VehicleID = t.VehicleID\n"
                + "join Restaurant r on r.RestaurantID = t.RestaurantID\n"
                + "where t.TourID = ?";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                Tour tour = new Tour();
                tour.setTourId(rs.getInt("TourID"));
                tour.setTourName(rs.getString("TourName"));
                tour.setPrice(rs.getDouble("Price"));
                tour.setDescription(rs.getString("Description"));
                tour.setStartDate(rs.getDate("StartDate"));
                tour.setEndDate(rs.getDate("EndDate"));
                tour.setImage(rs.getString("Image"));

                // Gán thông tin của TravelAgent
                TravelAgent agent = new TravelAgent();
                agent.setAgentName(rs.getString("AgentName"));
                tour.setAgent(agent);

                // Gán thông tin của Vehicle
                ArrayList<Vehicle> vehicles = new ArrayList<>();
                Vehicle vehicle = new Vehicle();
                vehicle.setVehicleName(rs.getString("VehicleName"));
                vehicles.add(vehicle);
                tour.setVechicle(vehicles);

                // Gán thông tin của Restaurant
                ArrayList<Restaurant> restaurants = new ArrayList<>();
                Restaurant restaurant = new Restaurant();
                restaurant.setRestaurantName(rs.getString("RestaurantName"));
                restaurants.add(restaurant);
                tour.setRestaurant(restaurants);
                return tour;
            }
        } catch (SQLException ex) {
            Logger.getLogger(TourDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    // Phương thức để chèn tour vào cơ sở dữ liệu

    public void insertTour(Tour tour, int agentId, int vehicleId, int restaurantId) {
        String sql = "INSERT INTO [dbo].[Tour] "
                + "([TourID], [TourName], [Price], [Description], [StartDate], [EndDate], "
                + "[AgentID], [VehicleID], [RestaurantID], [Image]) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement stm = connection.prepareStatement(sql)) {
            stm.setInt(1, tour.getTourId());
            stm.setString(2, tour.getTourName());
            stm.setDouble(3, tour.getPrice());
            stm.setString(4, tour.getDescription());
            stm.setDate(5, new java.sql.Date(tour.getStartDate().getTime()));
            stm.setDate(6, new java.sql.Date(tour.getEndDate().getTime()));
            stm.setInt(7, agentId);
            stm.setInt(8, vehicleId);
            stm.setInt(9, restaurantId);
            stm.setString(10, tour.getImage());

            // Thực thi câu lệnh INSERT
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(TourDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Phương thức để lấy danh sách Agent
    public List<TravelAgent> getAllAgents() {
        List<TravelAgent> agents = new ArrayList<>();
        String sql = "SELECT AgentID, AgentName FROM TravelAgent";
        try (PreparedStatement stm = connection.prepareStatement(sql); ResultSet rs = stm.executeQuery()) {
            while (rs.next()) {
                TravelAgent agent = new TravelAgent();
                agent.setAgentId(rs.getInt("AgentId"));
                agent.setAgentName(rs.getString("AgentName"));
                agents.add(agent);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TourDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return agents;
    }

    // Phương thức để lấy danh sách Vehicle
    public List<Vehicle> getAllVehicles() {
        List<Vehicle> vehicles = new ArrayList<>();
        String sql = "SELECT VehicleID, VehicleName FROM Vehicle";
        try (PreparedStatement stm = connection.prepareStatement(sql); ResultSet rs = stm.executeQuery()) {
            while (rs.next()) {
                Vehicle vehicle = new Vehicle();
                vehicle.setVehicleId(rs.getInt("VehicleID"));
                vehicle.setVehicleName(rs.getString("VehicleName"));
                vehicles.add(vehicle);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TourDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vehicles;
    }

    // Phương thức để lấy danh sách Restaurant
    public List<Restaurant> getAllRestaurants() {
        List<Restaurant> restaurants = new ArrayList<>();
        String sql = "SELECT RestaurantID, RestaurantName FROM Restaurant";
        try (PreparedStatement stm = connection.prepareStatement(sql); ResultSet rs = stm.executeQuery()) {
            while (rs.next()) {
                Restaurant restaurant = new Restaurant();
                restaurant.setRestaurantId(rs.getInt("RestaurantID"));
                restaurant.setRestaurantName(rs.getString("RestaurantName"));
                restaurants.add(restaurant);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TourDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return restaurants;
    }

    public boolean editTour(Tour tour) {
        String sql = "UPDATE Tour SET TourName = ?, Price = ?, Description = ?, StartDate = ?, EndDate = ?, "
                + "Image = ? WHERE TourID = ?";

        try {
            PreparedStatement stm = connection.prepareStatement(sql);

            // Gán các thông tin của tour vào PreparedStatement
            stm.setString(1, tour.getTourName());
            stm.setDouble(2, tour.getPrice());
            stm.setString(3, tour.getDescription());
            stm.setDate(4, new java.sql.Date(tour.getStartDate().getTime())); // Chuyển đổi từ java.util.Date sang java.sql.Date
            stm.setDate(5, new java.sql.Date(tour.getEndDate().getTime()));
            stm.setString(6, tour.getImage());
            stm.setInt(7, tour.getTourId()); // TourID để xác định bản ghi cần cập nhật

            // Thực thi câu lệnh UPDATE cho tour
            int rowsAffected = stm.executeUpdate();

            // Nếu có sự thay đổi trong danh sách phương tiện
            if (tour.getVechicle() != null && !tour.getVechicle().isEmpty()) {
                for (Vehicle vehicle : tour.getVechicle()) {
                    updateVehicleName(vehicle.getVehicleId(), vehicle.getVehicleName()); // Cập nhật tên phương tiện
                }
            }

            // Nếu có sự thay đổi trong danh sách nhà hàng
            if (tour.getRestaurant() != null && !tour.getRestaurant().isEmpty()) {
                for (Restaurant restaurant : tour.getRestaurant()) {
                    updateRestaurantName(restaurant.getRestaurantId(), restaurant.getRestaurantName()); // Cập nhật tên nhà hàng
                }
            }

            return rowsAffected > 0; // Trả về true nếu cập nhật tour thành công
        } catch (SQLException ex) {
            Logger.getLogger(TourDao.class.getName()).log(Level.SEVERE, null, ex);
            return false; // Trả về false nếu có lỗi xảy ra
        }
    }

// Phương thức cập nhật tên phương tiện
    public boolean updateVehicleName(int vehicleId, String newName) {
        String sql = "UPDATE Vehicle SET VehicleName = ? WHERE VehicleID = ?"; // Giả sử cột tên trong bảng Vehicle là VehicleName

        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, newName); // Gán tên mới
            stm.setInt(2, vehicleId);   // Gán ID phương tiện

            int rowsAffected = stm.executeUpdate(); // Thực thi câu lệnh UPDATE
            return rowsAffected > 0; // Trả về true nếu cập nhật thành công
        } catch (SQLException ex) {
            Logger.getLogger(TourDao.class.getName()).log(Level.SEVERE, null, ex);
            return false; // Trả về false nếu có lỗi xảy ra
        }
    }

// Phương thức cập nhật tên nhà hàng
    public boolean updateRestaurantName(int restaurantId, String newName) {
        String sql = "UPDATE Restaurant SET RestaurantName = ? WHERE RestaurantID = ?"; // Giả sử cột tên trong bảng Restaurant là RestaurantName

        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, newName); // Gán tên mới
            stm.setInt(2, restaurantId);   // Gán ID nhà hàng

            int rowsAffected = stm.executeUpdate(); // Thực thi câu lệnh UPDATE
            return rowsAffected > 0; // Trả về true nếu cập nhật thành công
        } catch (SQLException ex) {
            Logger.getLogger(TourDao.class.getName()).log(Level.SEVERE, null, ex);
            return false; // Trả về false nếu có lỗi xảy ra
        }
    }

    public boolean deleteTour(int tourId) {
        String sql = "DELETE FROM Tour WHERE TourID = ?";

        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, tourId); // Gán TourID mà bạn muốn xóa

            // Thực thi câu lệnh DELETE
            int rowsAffected = stm.executeUpdate();
            return rowsAffected > 0; // Trả về true nếu xóa thành công
        } catch (SQLException ex) {
            Logger.getLogger(TourDao.class.getName()).log(Level.SEVERE, null, ex);
            return false; // Trả về false nếu có lỗi xảy ra
        }
    }

    public int getTotalTour() {
        String sql = "select count(*) from tour";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TourDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public ArrayList<Tour> getToursByPage(int page, int pageSize) {
        ArrayList<Tour> list = new ArrayList<>();
        String query = "SELECT * FROM Tour LIMIT ?, ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, (page - 1) * pageSize);
            ps.setInt(2, pageSize);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Tour tour = new Tour();
                // Set thuộc tính cho đối tượng tour từ kết quả truy vấn
                tour.setTourId(rs.getInt("TourId"));
                tour.setTourName(rs.getString("TourName"));
                tour.setPrice(rs.getDouble("Price"));
                list.add(tour);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public int getMaxId() {
        int maxId = 0;
        try {
            String sql = "SELECT MAX(TourId) AS maxId FROM Tour";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                maxId = rs.getInt("maxId");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return maxId;
    }

    public ArrayList<Tour> searchToursByName(String tourName) {
        ArrayList<Tour> tours = new ArrayList<>();
        String sql = "SELECT TourID, TourName, Price, Image FROM Tour WHERE name LIKE ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, "%" + tourName + "%"); // Sử dụng ký tự đại diện % để tìm kiếm gần đúng

            try (ResultSet rs = statement.executeQuery()) {
                while (rs.next()) {
                    Tour tour = new Tour();
                    tour.setTourId(rs.getInt("TourId"));
                    tour.setTourName(rs.getString("TourName"));
                    tour.setPrice(rs.getDouble("Price"));
                    tour.setImage(rs.getString("Image"));
                    // Thiết lập các thuộc tính khác của tour nếu có
                    tours.add(tour);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return tours;
    }

}
