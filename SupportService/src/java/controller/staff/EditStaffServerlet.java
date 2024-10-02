/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller.staff;

import dal.StaffDao;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.lang.System.Logger;
import model.Role;
import model.Staff;

/**
 *
 * @author ASUS
 */
public class EditStaffServerlet extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
   

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String staffIdParam = request.getParameter("id");

        try {
            if (staffIdParam != null) {
                int staffId = Integer.parseInt(staffIdParam); // Có thể gây NumberFormatException
                StaffDao staffDao = new StaffDao();
                Staff staff = staffDao.getStaffById(staffId);

                if (staff != null) {
                    // Đưa thông tin nhân viên vào request để chuyển đến JSP
                    request.setAttribute("staff", staff);
                    request.getRequestDispatcher("editStaff.jsp").forward(request, response);
                } else {
                    response.getWriter().write("Staff not found.");
                }
            } else {
                response.getWriter().write("Invalid staff ID.");
            }
        } catch (NumberFormatException e) {
            response.getWriter().write("Invalid staff ID format.");
        }
    }

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
       try {
            int staffId = Integer.parseInt(request.getParameter("staffId"));
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            boolean active = request.getParameter("active") != null;
            

            Staff staff = new Staff();
            staff.setStaffId(staffId);
            staff.setEmail(email);
            staff.setPassword(password);
            staff.setActive(active);

            Role role = new Role();
            role.setRoleId(4); 
            staff.setRole(role);

            StaffDao staffDao = new StaffDao();
            boolean success = staffDao.updateStaff(staff);

            if (success) {
                response.sendRedirect(request.getContextPath() + "/staff/list");
            } else {
                request.setAttribute("errorMessage", "Update failed. Please try again.");
                request.getRequestDispatcher("editStaff.jsp").forward(request, response);
            }
        } catch (NumberFormatException e) {
            request.setAttribute("errorMessage", "Invalid input. Please check your data.");
            request.getRequestDispatcher("editStaff.jsp").forward(request, response);
        }
    }
    

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}

