/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.util.ArrayList;
import model.Vehicle;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.TravelAgent;

/**
 *
 * @author ASUS
 */
public class VehicleDao extends DbContext<Vehicle> {

    @Override
    public void insert(Vehicle model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Vehicle model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Vehicle model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Vehicle> list() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public ArrayList<Vehicle> GetVehicleList() {
        ArrayList<Vehicle> vehicle = new ArrayList<>();
        String sql = "select VehicleID, VehicleType, VehicleName, LicensePlate, Image from Vehicle";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Vehicle v = new Vehicle();
                v.setVehicleId(rs.getInt("VehicleID"));
                v.setVehicleType(rs.getString("VehicleType"));
                v.setVehicleName(rs.getString("VehicleName"));
                v.setLicensePlate(rs.getString("LicensePlate"));
                v.setImage(rs.getString("Image"));
                vehicle.add(v);
            }
        } catch (SQLException ex) {
            Logger.getLogger(VehicleDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vehicle;
    }

    public int GetMaxVehicleId() {
        int maxVehicleId = 0;
        String sql = "SELECT MAX(VehicleID) AS MaxID FROM Vehicle";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                maxVehicleId = rs.getInt("MaxID");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return maxVehicleId;
    }

    public void InsertVehicle(Vehicle vehicle) {
        String sql = "INSERT INTO [dbo].[Vehicle]\n"
                + "           ([VehicleID]\n"
                + "           ,[VehicleType]\n"
                + "           ,[VehicleName]\n"
                + "           ,[LicensePlate]\n"
                + "           ,[Image]\n"
                + "           ,[Manufacture]\n"
                + "           ,[ModelYear]\n"
                + "           ,[Color]\n"
                + "           ,[EngineType]\n"
                + "           ,[Mileage]\n"
                + "           ,[SeatingCapacity]\n"
                + "           ,[RegistrationDate]\n"
                + "           ,[Description]\n"
                + "           ,[AgentID])\n"
                + "     VALUES\n"
                + "           (?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
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
            stm.setInt(1, vehicle.getVehicleId());
            stm.setString(2, vehicle.getVehicleType());
            stm.setString(3, vehicle.getVehicleName());
            stm.setString(4, vehicle.getLicensePlate());
            stm.setString(5, vehicle.getImage());
            stm.setString(6, vehicle.getManufacture());
            stm.setInt(7, vehicle.getModelYear());
            stm.setString(8, vehicle.getColor());
            stm.setString(9, vehicle.getEngineType());
            stm.setInt(10, vehicle.getMileAge());
            stm.setInt(11, vehicle.getSeatingCapacity());
            stm.setDate(12, new java.sql.Date(vehicle.getRegistrationDate().getTime()));
            stm.setString(13, vehicle.getDescription());
            stm.setInt(14, vehicle.getAgent().getAgentId());

            ResultSet rs = stm.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(VehicleDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Vehicle GetVehicleDetailById(int id) {
        String sql = "select * from Vehicle where VehicleID = ?";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                Vehicle vehicle = new Vehicle();
                vehicle.setVehicleId(rs.getInt("VehicleID"));
                vehicle.setVehicleType(rs.getString("VehicleType"));
                vehicle.setVehicleName(rs.getString("VehicleName"));
                vehicle.setLicensePlate(rs.getString("LicensePlate"));
                vehicle.setImage(rs.getString("Image"));
                return vehicle;
            }
        } catch (SQLException ex) {
            Logger.getLogger(VehicleDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Vehicle GetVehicleDetails(int id) {
        String sql = "SELECT v.VehicleID, v.VehicleType, v.VehicleName, v.LicensePlate, v.Image, "
                + "v.Manufacture, v.ModelYear, v.Color, v.EngineType, v.Mileage, "
                + "v.SeatingCapacity, v.RegistrationDate, v.Description, a.AgentID, a.AgentName "
                + "FROM Vehicle v "
                + "JOIN TravelAgent a ON v.AgentID = a.AgentID "
                + "WHERE v.VehicleID = ?";

        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();

            if (rs.next()) {
                Vehicle vehicle = new Vehicle();
                // Set basic vehicle details
                vehicle.setVehicleId(rs.getInt("VehicleID"));
                vehicle.setVehicleType(rs.getString("VehicleType"));
                vehicle.setVehicleName(rs.getString("VehicleName"));
                vehicle.setLicensePlate(rs.getString("LicensePlate"));
                vehicle.setImage(rs.getString("Image"));
                vehicle.setManufacture(rs.getString("Manufacture"));
                vehicle.setModelYear(rs.getInt("ModelYear"));
                vehicle.setColor(rs.getString("Color"));
                vehicle.setEngineType(rs.getString("EngineType"));
                vehicle.setMileAge(rs.getInt("Mileage"));
                vehicle.setSeatingCapacity(rs.getInt("SeatingCapacity"));
                vehicle.setRegistrationDate(rs.getDate("RegistrationDate"));
                vehicle.setDescription(rs.getString("Description"));

                // Set TravelAgent details
                TravelAgent agent = new TravelAgent();
                agent.setAgentId(rs.getInt("AgentID"));
                agent.setAgentName(rs.getString("AgentName"));
                vehicle.setAgent(agent);

                return vehicle;
            }
        } catch (SQLException ex) {
            Logger.getLogger(VehicleDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public boolean updateVehicle(Vehicle vehicle) {
        String sql = "UPDATE [dbo].[Vehicle] SET "
                + "[VehicleType] = ?, "
                + "[VehicleName] = ?, "
                + "[LicensePlate] = ?, "
                + "[Image] = ?, "
                + "[Manufacture] = ?, "
                + "[ModelYear] = ?, "
                + "[Color] = ?, "
                + "[EngineType] = ?, "
                + "[Mileage] = ?, "
                + "[SeatingCapacity] = ?, "
                + "[RegistrationDate] = ?, "
                + "[Description] = ?, "
                + "[AgentID] = ? "
                + "WHERE [VehicleID] = ?";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            // Thiết lập giá trị cho PreparedStatement
            ps.setString(1, vehicle.getVehicleType());
            ps.setString(2, vehicle.getVehicleName());
            ps.setString(3, vehicle.getLicensePlate());
            ps.setString(4, vehicle.getImage());
            ps.setString(5, vehicle.getManufacture());
            ps.setInt(6, vehicle.getModelYear());
            ps.setString(7, vehicle.getColor());
            ps.setString(8, vehicle.getEngineType());
            ps.setInt(9, vehicle.getMileAge());
            ps.setInt(10, vehicle.getSeatingCapacity());
            ps.setDate(11, new java.sql.Date(vehicle.getRegistrationDate().getTime())); // Convert java.util.Date to java.sql.Date
            ps.setString(12, vehicle.getDescription());
            ps.setInt(13, vehicle.getAgent().getAgentId());
            ps.setInt(14, vehicle.getVehicleId());

            // Thực hiện cập nhật
            int affectedRows = ps.executeUpdate();
            return affectedRows > 0; // Trả về true nếu có dòng nào được cập nhật
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false; // Trả về false nếu có lỗi
        }
    }

    public void DeleteVehicle(int id) {
        String sql = "DELETE FROM [dbo].[Vehicle]\n"
                + "      WHERE VehicleID = ?";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(StaffDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<Vehicle> SearchVehicle(String search) {
        ArrayList<Vehicle> vehicleList = new ArrayList<>();
        String sql = "select VehicleID, VehicleType, VehicleName, LicensePlate, Image from Vehicle\n"
                + "where 1=1";
        if (search != null && !search.trim().isEmpty()) {
            sql += " and VehicleType like ?";
        }
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            if (search != null && !search.trim().isEmpty()) {
                stm.setString(1, "%" + search + "%");
            }
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Vehicle vehicle = new Vehicle();
                vehicle.setVehicleId(rs.getInt("VehicleID"));
                vehicle.setVehicleType(rs.getString("VehicleType"));
                vehicle.setVehicleName(rs.getString("VehicleName"));
                vehicle.setLicensePlate(rs.getString("LicensePlate"));
                vehicle.setImage(rs.getString("Image"));
                vehicleList.add(vehicle);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vehicleList;
    }

}
