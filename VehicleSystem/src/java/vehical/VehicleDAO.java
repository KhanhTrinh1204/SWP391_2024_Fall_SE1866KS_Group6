/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vehical;

import dal.DbContext;
import dal.HotelDAO;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Vehicle;

/**
 *
 * @author Legion
 */
public class VehicleDAO extends DbContext<Vehicle> {

    @Override
    public void insert(Vehicle model) {
        String sql = "INSERT INTO vehicle (vehicle_name, img_URL, start_date, end_date, description, travel_agent_id, active, price) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (
                PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, model.getVehicleName());
            pstmt.setString(2, model.getImgUrl());
            pstmt.setDate(3, new java.sql.Date(model.getStartDate().getTime()));
            pstmt.setDate(4, new java.sql.Date(model.getStartDate().getTime()));
            pstmt.setString(5, model.getDescription());
            pstmt.setInt(6, model.getTravelAgentId());
            pstmt.setBoolean(7, model.isActive());
            pstmt.setDouble(8, model.getPrice());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Vehicle model) {
        String sql = "UPDATE vehicle SET vehicle_name=?, img_URL=?, start_date=?, end_date=?, description=?, travel_agent_id=?, active=?, price=? WHERE vehicle_id=?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, model.getVehicleName());
            pstmt.setString(2, model.getImgUrl());
            pstmt.setDate(3, new java.sql.Date(model.getStartDate().getTime()));
            pstmt.setDate(4, new java.sql.Date(model.getStartDate().getTime()));
            pstmt.setString(5, model.getDescription());
            pstmt.setInt(6, model.getTravelAgentId());
            pstmt.setBoolean(7, model.isActive());
            pstmt.setDouble(8, model.getPrice());
            pstmt.setInt(9, model.getVehicleId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Vehicle model) {
        String sql = "DELETE FROM vehicle WHERE vehicle_id=?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, model.getVehicleId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<Vehicle> list() {
        ArrayList<Vehicle> vehicles = new ArrayList<>();
        String query = "SELECT TOP 1000 vehicle_id, vehicle_name, img_URL, start_date, end_date, description, travel_agent_id, active, price FROM TravelSystem.dbo.vehicle";

        try (PreparedStatement stmt = connection.prepareStatement(query); ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Vehicle vehicle = new Vehicle();
                vehicle.setVehicleId(rs.getInt("vehicle_id"));
                vehicle.setVehicleName(rs.getString("vehicle_name"));
                vehicle.setImgUrl(rs.getString("img_URL"));
                vehicle.setStartDate(rs.getDate("start_date"));
                vehicle.setEndDate(rs.getDate("end_date"));
                vehicle.setDescription(rs.getString("description"));
                vehicle.setTravelAgentId(rs.getInt("travel_agent_id"));
                vehicle.setActive(rs.getBoolean("active"));
                vehicle.setPrice(rs.getDouble("price"));

                vehicles.add(vehicle);
            }
        } catch (SQLException ex) {
            Logger.getLogger(HotelDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return vehicles;
    }

}
