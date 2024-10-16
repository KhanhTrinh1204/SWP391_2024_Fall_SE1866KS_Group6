/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.util.ArrayList;
import model.Staff;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ASUS
 */
public class StaffDao extends DbContext<Staff> {

    @Override
    public void insert(Staff model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Staff model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Staff model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Staff> list() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public ArrayList<Staff> searchStaff(String search, String statusFilter) {
        ArrayList<Staff> staffList = new ArrayList<>();
        try {
            String sql = "SELECT StaffID, FullName, Email, PhoneNumber, Address, Status"
                    + " FROM Staff WHERE 1=1";
            if (search != null && !search.isEmpty()) {
                sql += " AND FullName LIKE ?";
            }
            if (statusFilter != null && !statusFilter.isEmpty()) {
                sql += " AND Status = ?";
            }
            PreparedStatement statement = connection.prepareStatement(sql);
            int paramIndex = 1;
            if (search != null && !search.isEmpty()) {
                statement.setString(paramIndex++, "%" + search + "%");
            }
            if (statusFilter != null && !statusFilter.isEmpty()) {
                statement.setBoolean(paramIndex++, Boolean.parseBoolean(statusFilter));
            }

            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                Staff staff = new Staff();
                staff.setStaffId(rs.getInt("StaffID"));
                staff.setFullName(rs.getString("FullName"));
                staff.setEmail(rs.getString("Email"));
                staff.setPhoneNumber(rs.getString("PhoneNumber"));
                staff.setAddress(rs.getString("Address"));
                staff.setStatus(rs.getBoolean("Status"));
                staffList.add(staff);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return staffList;
    }

    public ArrayList<Staff> searchStaffByName(String search) {
        ArrayList<Staff> staffList = new ArrayList<>();
        String sql = "SELECT StaffID, FullName, Email, PhoneNumber, Address, Status "
                + "FROM Staff "
                + "WHERE FullName LIKE ?";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, "%" + search + "%");

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Staff s = new Staff();
                s.setStaffId(rs.getInt("StaffID"));
                s.setFullName(rs.getString("FullName"));
                s.setEmail(rs.getString("Email"));
                s.setPhoneNumber(rs.getString("PhoneNumber"));
                s.setAddress(rs.getString("Address"));
                s.setStatus(rs.getBoolean("Status"));
                staffList.add(s);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return staffList;
    }

    public ArrayList<Staff> searchStaffByStatus(String statusFilter) {
        ArrayList<Staff> staffList = new ArrayList<>();
        String sql = "SELECT StaffID, FullName, Email, PhoneNumber, Address, Status"
                + " FROM Staff"
                + " WHERE Status = ?";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setBoolean(1, Boolean.parseBoolean(statusFilter));

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Staff s = new Staff();
                s.setStaffId(rs.getInt("StaffI"));
                s.setFullName(rs.getString("FullName"));
                s.setEmail(rs.getString("Email"));
                s.setPhoneNumber(rs.getString("PhoneNumber"));
                s.setAddress(rs.getString("Address"));
                s.setStatus(rs.getBoolean("Status"));
                staffList.add(s);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return staffList;
    }

    public ArrayList<Staff> searchStaffByNameAndStatus(String name, boolean status) {
        ArrayList<Staff> staffList = new ArrayList<>();
        String sql = "SELECT StaffID, FullName, Email, PhoneNumber, Address, Status"
                + " FROM Staff "
                + "WHERE FullName LIKE ? AND Status = ?";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, "%" + name + "%");
            ps.setBoolean(2, status);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Staff s = new Staff();
                s.setStaffId(rs.getInt("StaffID"));
                s.setFullName(rs.getString("FullName"));
                s.setEmail(rs.getString("Email"));
                s.setPhoneNumber(rs.getString("PhoneNumber"));
                s.setAddress(rs.getString("Address"));
                s.setStatus(rs.getBoolean("Status"));
                staffList.add(s);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return staffList;
    }

    public ArrayList<Staff> getStaffByStatus(boolean status) {
        ArrayList<Staff> staffList = new ArrayList<>();
        String sql = "SELECT StaffID, FullName, Email, PhoneNumber, Address, Status"
                + " FROM Staff"
                + " WHERE Status = ?";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setBoolean(1, status);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Staff s = new Staff();
                s.setStaffId(rs.getInt("StaffID"));
                s.setFullName(rs.getString("FullName"));
                s.setEmail(rs.getString("Email"));
                s.setPhoneNumber(rs.getString("PhoneNumber"));
                s.setAddress(rs.getString("Address"));
                s.setStatus(rs.getBoolean("Status"));
                staffList.add(s);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return staffList;
    }

    public boolean checkEmailExist(String email) {
        String sql = "SELECT StaffID, FullName, Email, PhoneNumber, Address, Status"
                + " FROM Staff "
                + "WHERE Email = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            return rs.next(); // Trả về true nếu tìm thấy kết quả
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Phương thức kiểm tra số điện thoại có tồn tại hay không
    public boolean checkPhoneNumberExist(String phoneNumber) {
        String sql = "SELECT StaffID, FullName, Email, PhoneNumber, Address, Status"
                + " FROM Staff"
                + " WHERE PhoneNumber = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, phoneNumber);
            ResultSet rs = ps.executeQuery();
            return rs.next(); // Trả về true nếu tìm thấy kết quả
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public int getMaxStaffId() {
        int maxStaffId = 0;
        try {
            String sql = "SELECT MAX(staffId) AS maxStaffId FROM staff";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                maxStaffId = rs.getInt("maxStaffId");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return maxStaffId;
    }

    public ArrayList<Staff> GetStaffList() {
        ArrayList<Staff> staff = new ArrayList<>();
        String sql = "select StaffID, FullName, Email, PhoneNumber, Address, Status from Staff";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Staff s = new Staff();
                s.setStaffId(rs.getInt("StaffID"));
                s.setFullName(rs.getString("FullName"));
                s.setEmail(rs.getString("Email"));
                s.setPhoneNumber(rs.getString("PhoneNumber"));
                s.setAddress(rs.getString("Address"));
                s.setStatus(rs.getBoolean("Status"));
                staff.add(s);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StaffDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return staff;
    }

    public void InsertStaff(Staff staff) {
        String sql = "INSERT INTO [dbo].[Staff]\n"
                + "           ([StaffID]\n"
                + "           ,[FullName]\n"
                + "           ,[Email]\n"
                + "           ,[PhoneNumber]\n"
                + "           ,[Address]\n"
                + "           ,[Status]\n"
                + "           ,[AgentID])\n"
                + "     VALUES\n"
                + "           (?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?)";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, staff.getStaffId());
            stm.setString(2, staff.getFullName());
            stm.setString(3, staff.getEmail());
            stm.setString(4, staff.getPhoneNumber());
            stm.setString(5, staff.getAddress());
            stm.setBoolean(6, staff.isStatus());
            stm.setInt(7, staff.getAgent().getAgentId());
            ResultSet rs = stm.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(StaffDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void DeleteStaff(int id) {
        String sql = "DELETE FROM [dbo].[Staff]\n"
                + "      WHERE StaffID = ?";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(StaffDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Staff GetStaffById(int staffId) {
        String sql = "select StaffID, FullName, Email, PhoneNumber, Address, Status from Staff\n"
                + "where AgentID = ?";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, staffId);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                Staff staff = new Staff();
                staff.setStaffId(rs.getInt("StaffID"));
                staff.setFullName(rs.getString("FullName"));
                staff.setEmail(rs.getString("Email"));
                staff.setPhoneNumber(rs.getString("PhoneNumber"));
                staff.setAddress(rs.getString("Address"));
                staff.setStatus(rs.getBoolean("Status"));
                return staff;
            }
        } catch (SQLException ex) {
            Logger.getLogger(StaffDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public boolean UpdateStaff(Staff staff) {
        String sql = "UPDATE Staff SET FullName = ?, Email = ?, PhoneNumber = ?, Address = ?, Status = ? WHERE StaffID = ?";

        try (PreparedStatement stm = connection.prepareStatement(sql)) {

            stm.setString(1, staff.getFullName());
            stm.setString(2, staff.getEmail());
            stm.setString(3, staff.getPhoneNumber());
            stm.setString(4, staff.getAddress());
            stm.setBoolean(5, staff.isStatus());
            stm.setInt(6, staff.getStaffId());

            int rowsUpdated = stm.executeUpdate();
            if (rowsUpdated > 0) {
                Logger.getLogger(StaffDao.class.getName()).log(Level.INFO, "Successfully updated staff with ID: {0}", staff.getStaffId());
                return true;
            } else {
                Logger.getLogger(StaffDao.class.getName()).log(Level.INFO, "No staff found with ID: {0} to update", staff.getStaffId());
            }
        } catch (SQLException ex) {
            Logger.getLogger(StaffDao.class.getName()).log(Level.SEVERE, "Error while updating staff with ID: " + staff.getStaffId(), ex);
        }
        return false;
    }
}
