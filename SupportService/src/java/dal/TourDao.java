/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.CategoryTour;
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

    public ArrayList<Tour> getTour() {
        ArrayList<Tour> listTour = new ArrayList<>();
        String sql = "select tour_id, tour_name from tour";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Tour tour = new Tour();
                tour.setTourId(rs.getInt("tour_id"));
                tour.setTourName(rs.getString("tour_name"));
                listTour.add(tour);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TourDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listTour;
    }

    public void addTour(Tour tour) {
        String sqlTour = "INSERT INTO tour (tour_name, img_url, description, start_date, end_date, travel_agent_id, category_id, active, price)"
                + " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement stm = connection.prepareStatement(sqlTour);
            stm.setString(1, tour.getTourName());
            stm.setString(2, tour.getImgUrl());
            stm.setString(3, tour.getDescription());
            stm.setDate(4, new java.sql.Date(tour.getStartDate().getTime()));
            stm.setDate(5, new java.sql.Date(tour.getEndDate().getTime()));
            stm.setInt(6, tour.getTravelAgent().getTravelAgentId());
            stm.setInt(7, tour.getCategoryTour().getCategoryId());
            stm.setBoolean(8, tour.isActive());
            stm.setDouble(9, tour.getPrice());
            ResultSet rs = stm.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteTour(int id) {
        String sql = "DELETE FROM [dbo].[tour]\n"
                + "      WHERE tour_id = ?";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(TourDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public Tour getTourById(int tourId) throws SQLException {
        String sql = "SELECT t.tour_id, t.tour_name, t.img_url, t.description, t.start_date, t.end_date, t.active, t.price, "
                + "v.vehicle_name, r.restaurant_name, ct.category_name "
                + "FROM tour t "
                + "JOIN vehicle_detail vd ON t.tour_id = vd.tour_id "
                + "JOIN vehicle v ON vd.vehicle_id = v.vehicle_id "
                + "JOIN restaurant_detail rd ON t.tour_id = rd.tour_id "
                + "JOIN restaurant r ON rd.restaurant_id = r.restaurant_id "
                + "JOIN category_tour ct ON t.category_id = ct.category_id "
                + "WHERE t.tour_id = ?";

        PreparedStatement ps = null;
        ResultSet rs = null;
        Tour tour = null;

        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, tourId);
            rs = ps.executeQuery();

            if (rs.next()) {
                tour = new Tour();
                tour.setTourId(rs.getInt("tour_id"));
                tour.setTourName(rs.getString("tour_name"));
                tour.setImgUrl(rs.getString("img_url"));
                tour.setDescription(rs.getString("description"));
                tour.setStartDate(rs.getDate("start_date"));
                tour.setEndDate(rs.getDate("end_date"));
                tour.setActive(rs.getBoolean("active"));
                tour.setPrice(rs.getDouble("price"));

                CategoryTour categoryTour = new CategoryTour();
                categoryTour.setCategoryName(rs.getString("category_name"));
                tour.setCategoryTour(categoryTour);

                Vehicle vehicle = new Vehicle();
                vehicle.setVehicleName(rs.getString("vehicle_name"));
                tour.setVehicle(vehicle);

                Restaurant restaurant = new Restaurant();
                restaurant.setRestaurantName(rs.getString("restaurant_name"));
                tour.setRestaurant(restaurant);
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
        }
        return tour;
    }

    public boolean updateTour(Tour tour) {
        String sql = "UPDATE tour SET tour_name = ?, img_URL = ?, start_date = ?, end_date = ?, description = ? WHERE tour_id = ?";

        try (PreparedStatement stm = connection.prepareStatement(sql)) {
            stm.setString(1, tour.getTourName());
            stm.setString(2, tour.getImgUrl());
            stm.setDate(3, new java.sql.Date(tour.getStartDate().getTime()));
            stm.setDate(4, new java.sql.Date(tour.getEndDate().getTime()));
            stm.setString(5, tour.getDescription());
            stm.setInt(6, tour.getTourId());

            int rowsUpdated = stm.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException ex) {
            Logger.getLogger(TourDao.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

  /*  public static void main(String[] args) {
        TourDao dao = new TourDao();
        ArrayList<Tour> t = dao.getTour();
        System.out.println(t.get(0).getTourName());
    }*/
}
