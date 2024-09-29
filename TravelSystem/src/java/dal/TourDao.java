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
import model.Tour;
import model.TravelAgent;

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
        String sql = "INSERT INTO tour (tour_name, img_url, description, start_date, end_date, travel_agent_id, category_id, active, price)"
                + " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, tour.getTourName());
            stm.setString(2, tour.getImgUrl());
            stm.setString(3, tour.getDescription());
            stm.setDate(4, new java.sql.Date(tour.getStartDate().getTime()));
            stm.setDate(5, new java.sql.Date(tour.getEndDate().getTime()));
            stm.setInt(6, tour.getTravelAgent().getTravelAgentId()); // Assuming TravelAgent has an ID field
            stm.setInt(7, tour.getCategoryTour().getCategoryId()); // Assuming CategoryTour has an ID field
            stm.setBoolean(8, tour.isActive());
            stm.setDouble(9, tour.getPrice());
            stm.executeUpdate();
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

    public Tour getTourById(int tourId) {
        String sql = "SELECT tour_id, tour_name, img_URL, start_date, end_date, description, price"
                + " FROM tour WHERE tour_id = ?";

        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, tourId);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                Tour tour = new Tour();
                tour.setTourId(rs.getInt("tour_id"));
                tour.setTourName(rs.getString("tour_name"));
                tour.setImgUrl(rs.getString("img_URL"));
                tour.setStartDate(rs.getDate("start_date"));
                tour.setEndDate(rs.getDate("end_date"));
                tour.setDescription(rs.getString("description"));
                tour.setPrice(rs.getDouble("price"));

                return tour;
            }
        } catch (SQLException ex) {
            Logger.getLogger(TourDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
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
}
//  public static void main(String[] args) {
///  TourDao dao = new TourDao();
//  ArrayList<Tour> t = dao.getTour();
// System.out.println(t.get(0).getTourName());
// }

