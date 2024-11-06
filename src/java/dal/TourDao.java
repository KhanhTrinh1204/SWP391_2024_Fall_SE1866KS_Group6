/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import Models.UserBooking;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Account;
import model.Hotel;
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
        String sql = "SELECT TourID,Description ,TourName, Price, Image FROM Tour";

        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                Tour tour = new Tour();
                tour.setTourId(rs.getInt("TourID"));
                 tour.setDescription(rs.getString("Description"));
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
    
       public String GetEmailAccount(int id) {
        String sql = "select c.Email from UserBooking t, Account c where c.AccountID = t.AccountID and t.id= ?";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                String a = rs.getString("Email");
                 return a;
            }
        } catch (SQLException ex) {
            Logger.getLogger(TourDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    

    public Tour ViewTourDetail(int id) {
        String sql = "select t.TourID, t.TourName, t.Price, t.Description, t.StartDate, t.EndDate, ta.AgentName, v.VehicleName, r.RestaurantName, t.Image ,h.hotel_id, h.hotel_name from Tour t\n" +
"                join TravelAgent ta on ta.AgentID = t.AgentID\n" +
"               join Vehicle v on v.VehicleID = t.VehicleID\n" +
"               join Restaurant r on r.RestaurantID = t.RestaurantID\n" +
"			   join hotel h on h.hotel_id = t.hotelID\n" +
"                where t.TourID = ?";
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
                ArrayList<Hotel> hotels = new ArrayList<>();
                Hotel hotel = new Hotel();
                hotel.setHotelName(rs.getString("hotel_name"));
                hotels.add(hotel);
                tour.setHotel(hotels);
                
                
                // Gán thông tin của 
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
    
    
     public Tour ViewTourDetailValue(int id) {
        String sql = "select t.TourID, t.TourName, t.Price, t.Description, t.StartDate, t.EndDate, ta.AgentName,\n" +
"v.VehicleName, v.Color,v.Description as[VehicleDescription], v.EngineType, v.Image as [VehicleImage], v.Manufacture, v.Mileage,v.ModelYear,v.SeatingCapacity,v.VehicleType,\n" +
"r.RestaurantName, r.Category,r.Description as [RestaurantDescription],r.Email,r.image as[RestaurantImage],r.Location,r.PhoneNumber,\n" +
"t.Image \n" +
",h.hotel_id, h.hotel_name ,h.img_URL as [HotelImage],h.description as[HotelDescription], h.price\n" +
"from Tour t\n" +
"                join TravelAgent ta on ta.AgentID = t.AgentID\n" +
"               join Vehicle v on v.VehicleID = t.VehicleID\n" +
"               join Restaurant r on r.RestaurantID = t.RestaurantID\n" +
"			   join hotel h on h.hotel_id = t.hotelID\n" +
"                where t.TourID = ?";
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
                vehicle.setColor(rs.getString("Color"));
                vehicle.setDescription(rs.getString("VehicleDescription"));
                
                vehicle.setEngineType(rs.getString("EngineType"));
                vehicle.setImage(rs.getString("VehicleImage"));
                vehicle.setManufacture(rs.getString("Manufacture"));
                
                vehicle.setModelYear(Integer.parseInt(rs.getString("ModelYear")) );
                vehicle.setSeatingCapacity(Integer.parseInt(rs.getString("SeatingCapacity")));
                
                 vehicle.setVehicleType(rs.getString("VehicleType"));

                vehicle.setMileAge(Integer.parseInt(rs.getString("Mileage")));
                
                vehicles.add(vehicle);
                tour.setVechicle(vehicles);

                // Gán thông tin của Restaurant
                ArrayList<Hotel> hotels = new ArrayList<>();
                Hotel hotel = new Hotel();
                hotel.setHotelName(rs.getString("hotel_name"));
                hotel.setImgUrl(rs.getString("HotelImage"));
                hotel.setDescription(rs.getString("HotelDescription"));
                hotel.setPrice(rs.getString("price"));
               
                hotels.add(hotel);
                tour.setHotel(hotels);
                
                
                // Gán thông tin của 
                ArrayList<Restaurant> restaurants = new ArrayList<>();
                Restaurant restaurant = new Restaurant();
                restaurant.setRestaurantName(rs.getString("RestaurantName"));
                restaurant.setCategory(rs.getString("Category"));
                restaurant.setDescription(rs.getString("RestaurantDescription"));
                restaurant.setEmail(rs.getString("Email"));
                restaurant.setImage(rs.getString("RestaurantImage"));
                restaurant.setLocation(rs.getString("Location"));
                restaurant.setPhoneNumber(rs.getString("PhoneNumber"));
                restaurants.add(restaurant);
                tour.setRestaurant(restaurants);
                
                return tour;
            }
        } catch (SQLException ex) {
            Logger.getLogger(TourDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public ArrayList<Tour> ViewBookingTourDetail(int id) {
         ArrayList<Tour> tours = new ArrayList<>();
         SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String sql = "select u.id,u.status,u.TimeBooking ,t.TourID, t.TourName, t.Price, t.Description, t.StartDate, t.EndDate, ta.AgentName, v.VehicleName, r.RestaurantName,r.image,r.Description , t.Image, h.[hotel_name], h.img_URL, h.price from Tour t \n" +
"				\n" +
"                 join TravelAgent ta on ta.AgentID = t.AgentID\n" +
"                 join Vehicle v on v.VehicleID = t.VehicleID\n" +
"                 join Restaurant r on r.RestaurantID = t.RestaurantID\n" +
"				 join hotel h on h.hotel_id = t.hotelID\n" +
"				 join UserBooking u on u.TourID = t.TourID\n" +
"				 join Account a on a.AccountID = u.AccountID\n" +
"                 where a.AccountID = ?";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                
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
                
                 ArrayList<UserBooking> userBookings = new ArrayList<>();
                UserBooking userBooking = new UserBooking();
                userBooking.setId(rs.getString("id"));
                 userBooking.setStatus(rs.getString("status"));
                 userBooking.setTimebooking(rs.getString("TimeBooking"));
                userBookings.add(userBooking);
                tour.setUserBooking(userBookings);
                 tours.add(tour);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TourDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tours;
    }
    
      public ArrayList<Tour> ViewListBookingTour(String search, String status, int page, int recordsPerPage) {
         ArrayList<Tour> tours = new ArrayList<>();
          int start = (page - 1) * recordsPerPage;
         SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
      StringBuilder query = new StringBuilder("select u.id,u.status,u.TimeBooking, a.Fullname,a.AccountID,a.Email ,t.TourID, t.TourName, t.Price, t.Description, t.StartDate, t.EndDate, ta.AgentName, v.VehicleName, r.RestaurantName,r.image,r.Description , t.Image, h.[hotel_name], h.img_URL, h.price from Tour t \n" +
"				\n" +
"                 join TravelAgent ta on ta.AgentID = t.AgentID\n" +
"                 join Vehicle v on v.VehicleID = t.VehicleID\n" +
"                 join Restaurant r on r.RestaurantID = t.RestaurantID\n" +
"				 join hotel h on h.hotel_id = t.hotelID\n" +
"				 join UserBooking u on u.TourID = t.TourID\n" +
"				 join Account a on a.AccountID = u.AccountID\n" +
"                 where 1=1 ");
      
         if (search != null && !search.trim().isEmpty()) {
             query.append(" AND a.Fullname LIKE ?");

        }
          if (status != null && !status.trim().isEmpty()) {
             query.append(" AND u.status LIKE ?");
        }
               query.append(" ORDER BY u.id desc OFFSET ? ROWS FETCH NEXT ? ROWS ONLY;");
        try {
           PreparedStatement statement = connection.prepareStatement(query.toString());
           
             int paramIndex = 1;
            // Set email parameter if provided
            if (search != null && !search.trim().isEmpty()) {
                statement.setString(paramIndex++, "%" + search + "%");
            }
              if (status != null && !status.trim().isEmpty()) {
               statement.setString(paramIndex++, "%" + status + "%");
        }
            // Set pagination parameters
            statement.setInt(paramIndex++, start);
            statement.setInt(paramIndex, recordsPerPage);
            
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                
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
                
                 ArrayList<UserBooking> userBookings = new ArrayList<>();
                UserBooking userBooking = new UserBooking();
                userBooking.setId(rs.getString("id"));
                 userBooking.setStatus(rs.getString("status"));
                 userBooking.setTimebooking(rs.getString("TimeBooking"));
                userBookings.add(userBooking);             
                tour.setUserBooking(userBookings);
                
                   ArrayList<Account> accounts = new ArrayList<>();
                Account account = new Account();
                account.setAccountId(rs.getString("AccountID"));
                account.setFullName(rs.getString("Fullname"));
              account.setEmail(rs.getString("Email"));
                accounts.add(account);
                tour.setAccount(accounts);
                 tours.add(tour);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TourDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tours;
    }
    
      
      public boolean updateConfirmTour(String id) {

        String query = "update UserBooking set status = 2 where id = ?";
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
      
      
      
    // Phương thức để chèn tour vào cơ sở dữ liệu
    
    public boolean updateCancleTour(String id) {

        String query = "update UserBooking set status = 3 where id = ?";
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
 public int getTotalBookingRecords(String search, String status) {
        int totalRecords = 0;

        // Base query
            StringBuilder query = new StringBuilder("SELECT COUNT(t.id) \n" +
"FROM UserBooking t\n" +
"JOIN Account a ON a.AccountID = t.AccountID\n where 1= 1" +
"");

                    if (search != null && !search.trim().isEmpty()) {
             query.append(" AND a.Fullname LIKE ?");
           }
                    if (status != null && !status.trim().isEmpty()) {
             query.append(" AND t.status LIKE ?");
        }
        try {
           int paramIndex = 1;
          PreparedStatement stm = connection.prepareStatement(query.toString());
             if (search != null && !search.trim().isEmpty()) {
                stm.setString(paramIndex++, "%" + search + "%");
            }
              if (status != null && !status.trim().isEmpty()) {
               stm.setString(paramIndex++, "%" + status + "%");
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
    public void insertTour(Tour tour, int agentId, int vehicleId, int restaurantId, int hotelID) {
        String sql = "INSERT INTO [dbo].[Tour] "
                + "([TourID], [TourName], [Price], [Description], [StartDate], [EndDate], "
                + "[AgentID], [VehicleID], [RestaurantID], [Image], [hotelID]) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?)";

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
            stm.setInt(11, hotelID);
            // Thực thi câu lệnh INSERT
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(TourDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        public void insertBookingTour(int TourID, int AccountID) {
        String sql = "insert into [dbo].[UserBooking](TourID, AccountID, Status,TimeBooking) VALUES(?,?,1,GETDATE())";

        try (PreparedStatement stm = connection.prepareStatement(sql)) {
            stm.setInt(1, TourID);
            stm.setInt(2, AccountID);

            // Thực thi câu lệnh INSERT
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(TourDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
        public void updateDeleteBookingTour(int id) {
        String sql = "Update [dbo].[UserBooking] set Status =3 where id =?";

        try (PreparedStatement stm = connection.prepareStatement(sql)) {
            stm.setInt(1, id);

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

     public List<Hotel> getAllHotels() {
        List<Hotel> hotels = new ArrayList<>();
        String sql = "SELECT hotel_id, hotel_name FROM hotel";
        try (PreparedStatement stm = connection.prepareStatement(sql); ResultSet rs = stm.executeQuery()) {
            while (rs.next()) {
                Hotel hotel = new Hotel();
                hotel.setHotelId(rs.getInt("hotel_id"));
                hotel.setHotelName(rs.getString("hotel_name"));
                hotels.add(hotel);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TourDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return hotels;
    }

    public boolean editTour(Tour tour,int agentId,int vehicleId,int restaurantId,int hotelId) {
        String sql = "UPDATE Tour SET TourName = ?, Price = ?, Description = ?, StartDate = ?, EndDate = ?, "
                + "Image = ?, AgentID= ? , VehicleID =?, RestaurantID= ?, hotelID=?  WHERE TourID = ?";

        try {
            PreparedStatement stm = connection.prepareStatement(sql);

            // Gán các thông tin của tour vào PreparedStatement
            stm.setString(1, tour.getTourName());
            stm.setDouble(2, tour.getPrice());
            stm.setString(3, tour.getDescription());
            stm.setDate(4, new java.sql.Date(tour.getStartDate().getTime())); // Chuyển đổi từ java.util.Date sang java.sql.Date
            stm.setDate(5, new java.sql.Date(tour.getEndDate().getTime()));
            stm.setString(6, tour.getImage());
            stm.setInt(7, agentId);
            stm.setInt(8, vehicleId);
            stm.setInt(9,restaurantId);
            stm.setInt(10, hotelId);
            stm.setInt(11, tour.getTourId()); // TourID để xác định bản ghi cần cập nhật

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

    public ArrayList<Tour> searchToursByName(String search,int page, int recordsPerPage) {
        ArrayList<Tour> tours = new ArrayList<>();
      //  String sql = "SELECT TourID, TourName, Price, Image FROM Tour WHERE 1 = 1";

        StringBuilder query = new StringBuilder("SELECT TourID, TourName, Price, Image FROM Tour WHERE 1 = 1");
       int start = (page - 1) * recordsPerPage;

        if (search != null && !search.trim().isEmpty()) {
             query.append(" AND TourName LIKE ?");
          //  query += " and VehicleType like ?";
        }
               query.append(" ORDER BY TourID desc OFFSET ? ROWS FETCH NEXT ? ROWS ONLY;");
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
                    Tour tour = new Tour();
                    tour.setTourId(rs.getInt("TourID"));
                    tour.setTourName(rs.getString("TourName"));
                    tour.setPrice(rs.getDouble("Price"));
                    tour.setImage(rs.getString("Image"));
                    // Thiết lập các thuộc tính khác của tour nếu có
                    tours.add(tour);
                }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return tours;
    }
     public int getTotalRecords(String search) {
        int totalRecords = 0;

        // Base query
            StringBuilder query = new StringBuilder("SELECT COUNT(*) FROM Tour");
        //String query = "SELECT COUNT(*) FROM Vehicle where VehicleType LIKE ?";
                    if (search != null && !search.trim().isEmpty()) {
             query.append(" Where TourName LIKE ?");
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
  
     
       public Tour ViewBookingTourDetailValue(int id) {
        String sql = "select t.TourID, t.TourName, t.Price, t.Description, t.StartDate, t.EndDate, ta.AgentName,\n" +
"v.VehicleName, v.Color,v.Description as[VehicleDescription], v.EngineType, v.Image as [VehicleImage], v.Manufacture, v.Mileage,v.ModelYear,v.SeatingCapacity,v.VehicleType, +\n" +
"r.RestaurantName, r.Category,r.Description as [RestaurantDescription],r.Email,r.image as[RestaurantImage],r.Location,r.PhoneNumber,\n" +
"t.Image\n" +
",h.hotel_id, h.hotel_name ,h.img_URL as [HotelImage],h.description as[HotelDescription], h.price\n" +
"from Tour t\n" +
"                join TravelAgent ta on ta.AgentID = t.AgentID\n" +
"               join Vehicle v on v.VehicleID = t.VehicleID\n" +
"              join Restaurant r on r.RestaurantID = t.RestaurantID\n" +
"			   join hotel h on h.hotel_id = t.hotelID\n" +
"               join UserBooking u on u.TourID=t.TourID where u.id= ?";
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
                vehicle.setColor(rs.getString("Color"));
                vehicle.setDescription(rs.getString("VehicleDescription"));
                
                vehicle.setEngineType(rs.getString("EngineType"));
                vehicle.setImage(rs.getString("VehicleImage"));
                vehicle.setManufacture(rs.getString("Manufacture"));
                
                vehicle.setModelYear(Integer.parseInt(rs.getString("ModelYear")) );
                vehicle.setSeatingCapacity(Integer.parseInt(rs.getString("SeatingCapacity")));
                
                 vehicle.setVehicleType(rs.getString("VehicleType"));

                vehicle.setMileAge(Integer.parseInt(rs.getString("Mileage")));
                
                vehicles.add(vehicle);
                tour.setVechicle(vehicles);

                // Gán thông tin của Restaurant
                ArrayList<Hotel> hotels = new ArrayList<>();
                Hotel hotel = new Hotel();
                hotel.setHotelName(rs.getString("hotel_name"));
                hotel.setImgUrl(rs.getString("HotelImage"));
                hotel.setDescription(rs.getString("HotelDescription"));
                hotel.setPrice(rs.getString("price"));
               
                hotels.add(hotel);
                tour.setHotel(hotels);
                
                
                // Gán thông tin của 
                ArrayList<Restaurant> restaurants = new ArrayList<>();
                Restaurant restaurant = new Restaurant();
                restaurant.setRestaurantName(rs.getString("RestaurantName"));
                restaurant.setCategory(rs.getString("Category"));
                restaurant.setDescription(rs.getString("RestaurantDescription"));
                restaurant.setEmail(rs.getString("Email"));
                restaurant.setImage(rs.getString("RestaurantImage"));
                restaurant.setLocation(rs.getString("Location"));
                restaurant.setPhoneNumber(rs.getString("PhoneNumber"));
                restaurants.add(restaurant);
                tour.setRestaurant(restaurants);
                
                return tour;
            }
        } catch (SQLException ex) {
            Logger.getLogger(TourDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public static void main(String[] args) {
        TourDao dao = new TourDao();
        // Retrieve a tour with a specific ID, e.g., 2
        String a = dao.GetEmailAccount(14);

        // Check if the tour is not null before trying to print its details
        
            System.out.println(a);
        
    
}

}
