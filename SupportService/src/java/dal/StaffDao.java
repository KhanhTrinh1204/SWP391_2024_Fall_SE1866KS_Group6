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
import model.Role;

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

    public ArrayList<Staff> getStaff() {
        ArrayList<Staff> staff = new ArrayList<>();
        String sql = "select * from staff";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Staff s = new Staff();
                s.setStaffId(rs.getInt("staff_id"));
                s.setEmail(rs.getString("email"));
                s.setActive(rs.getBoolean("active"));
                s.setPassword(rs.getString("password"));

                Role role = new Role();
                role.setRoleId(rs.getInt("role_id"));
                s.setRole(role);

                staff.add(s);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StaffDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return staff;
    }

    public int getMaxStaffId() {
        String sql = "SELECT MAX(staff_id) FROM staff";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                return rs.getInt(1); // Lấy giá trị lớn nhất
            }
        } catch (SQLException ex) {
            Logger.getLogger(StaffDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0; // Trả về 0 nếu không tìm thấy staff nào
    }

    public void insertStaff(Staff staff) {
        String sql = "INSERT INTO [dbo].[staff] "
                + "           ([staff_id], [email], [active], [password], [role_id]) "
                + "     VALUES (?, ?, ?, ?, ?)";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, staff.getStaffId());
            stm.setString(2, staff.getEmail());
            stm.setBoolean(3, staff.isActive());
            stm.setString(4, staff.getPassword());
            stm.setInt(5, staff.getRole().getRoleId());

            ResultSet rs = stm.executeQuery();

        } catch (SQLException ex) {
            Logger.getLogger(StaffDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void deleteStaff(int id) {
        String sql = "DELETE FROM [dbo].[staff]\n"
                + "      WHERE staff_id = ?";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(StaffDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean updateStaff(Staff staff) {
        String sql = "UPDATE staff SET email = ?, password = ?, active = ?, role_id = ? WHERE staff_id = ?";
        try (PreparedStatement stm = connection.prepareStatement(sql)) {
            stm.setString(1, staff.getEmail());
            stm.setString(2, staff.getPassword());
            stm.setBoolean(3, staff.isActive());
            stm.setInt(4, staff.getRole().getRoleId());
            stm.setInt(5, staff.getStaffId());

            int rowsUpdated = stm.executeUpdate();
            return rowsUpdated > 0; // Trả về true nếu cập nhật thành công
        } catch (SQLException ex) {
            Logger.getLogger(StaffDao.class.getName()).log(Level.SEVERE, "Error while updating staff", ex);
        }
        return false;
    }

    public Staff getStaffById(int staffId) {
        String sql = "select * from staff where staff_id = ?";
        try (PreparedStatement stm = connection.prepareStatement(sql)) {
            stm.setInt(1, staffId);
            try (ResultSet rs = stm.executeQuery()) {
                if (rs.next()) {
                    Staff staff = new Staff();
                    staff.setStaffId(rs.getInt("staff_id"));
                    staff.setEmail(rs.getString("email"));
                    staff.setPassword(rs.getString("password"));
                    staff.setActive(rs.getBoolean("active"));

                    // Gán roleId cố định là 4
                    Role role = new Role();
                    role.setRoleId(rs.getInt("role_id"));
                    staff.setRole(role);

                    return staff;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(StaffDao.class.getName()).log(Level.SEVERE, "Error while getting staff by ID", ex);
        }
        return null;
    }
    /* public static void main(String[] args) {
        StaffDao stfd = new StaffDao();
        ArrayList<Staff> staff = stfd.getStaff();
        System.out.println(staff.get(0).getEmail());
    }*/
}
