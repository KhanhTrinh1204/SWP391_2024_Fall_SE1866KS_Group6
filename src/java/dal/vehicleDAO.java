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
import model.vehicle;

/**
 *
 * @author Admin
 */
public class vehicleDAO extends DBContext<Object> {

    public List<vehicle> getList() {
        List<vehicle> list = new ArrayList<>();
        String sql = "select * from vehicle";
        try {
            PreparedStatement pre = connection.prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                int vehicleId = rs.getInt("vehicle_id");
                String vehicleName = rs.getString("vehicle_name");
                String imgURL = rs.getString("img_URL");
                String startDate = rs.getString("start_date");
                String endDate = rs.getString("end_date");
                String description = rs.getString("description");
                int travelAgentId = rs.getInt("travel_agent_id");
                int active = rs.getInt("active");
                float price = rs.getFloat("price");
                list.add(new vehicle(vehicleId, vehicleName, imgURL, startDate, endDate, description, travelAgentId, active, price));
            }
        } catch (SQLException e) {

        }
        return list;
    }

    public void add(vehicle Vehicle) {
        String sql = "INSERT INTO vehicle (vehicle_id,vehicle_name,img_URL,start_date,end_date,description,travel_agent_id,active,price) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, Vehicle.getVehicleId());
            statement.setString(2, Vehicle.getVehicleName());
            statement.setString(3, Vehicle.getImgURL());
            statement.setString(4, Vehicle.getStartDate());
            statement.setString(5, Vehicle.getEndDate());
            statement.setString(6, Vehicle.getDescription());
            statement.setInt(7, Vehicle.getTravelAgentId());
            statement.setInt(8, Vehicle.getActive());
            statement.setFloat(9, Vehicle.getPrice());
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public vehicle findVehicle(vehicle Vehicle) {
        String sql = "select * from vehicle WHERE vehicle_id = ? ";
        try {
            PreparedStatement pre = connection.prepareCall(sql);
            pre.setInt(1, Vehicle.getVehicleId());
            ResultSet rs = pre.executeQuery();
            if (rs.next()) {
                return new vehicle(
                    rs.getInt("vehicle_id"),
                    rs.getString("vehicle_name"),
                    rs.getString("img_URL"),
                    rs.getString("start_date"),
                    rs.getString("end_date"),
                    rs.getString("description"),
                    rs.getInt("travel_agent_id"),
                    rs.getInt("active"),
                    rs.getFloat("price")
                );
            }
        } catch (SQLException e) {
        }
        return null;
    }

    // Chỉnh sửa thông tin sinh viên
    public void edit(vehicle Vehicle) {
        String sql = "UPDATE vehicle  SET vehicle_name = ?, img_URL = ?, start_date = ?,  end_date = ?, description = ?,travel_agent_id = ?, active = ?, price = ? WHERE vehicle_id = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(9, Vehicle.getVehicleId());
            statement.setString(1, Vehicle.getVehicleName());
            statement.setString(2, Vehicle.getImgURL());
            statement.setString(3, Vehicle.getStartDate());
            statement.setString(4, Vehicle.getEndDate());
            statement.setString(5, Vehicle.getDescription());
            statement.setInt(6, Vehicle.getTravelAgentId());
            statement.setInt(7, Vehicle.getActive());
            statement.setFloat(8, Vehicle.getPrice());
            statement.executeUpdate();
        } catch (SQLException e) {
        }

    }

    // Xóa một sinh viên
    public void deleteStudent(vehicle Vehicle) {
        String sql = "DELETE FROM vehicle WHERE vehicle_id = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, Vehicle.getVehicleId());
            statement.executeUpdate();
        } catch (SQLException e) {
        }

    }
    
    

    @Override
    public ArrayList<Object> list() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Object get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void insert(Object model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Object model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Object model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
