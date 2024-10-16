///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
// */
//package controller.staff;
//
//import com.microsoft.sqlserver.jdbc.SQLServerException;
//import controller.admin.UpdateTourServerlet;
//import dal.StaffDao;
//import java.io.IOException;
//import java.io.PrintWriter;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import jakarta.servlet.http.HttpSession;
//import java.sql.SQLException;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import model.Account;
//import model.Staff;
//import model.TravelAgent;
//
///**
// *
// * @author ASUS
// */
//public class EditStaff extends HttpServlet {
//
//    /**
//     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
//     * methods.
//     *
//     * @param request servlet request
//     * @param response servlet response
//     * @throws ServletException if a servlet-specific error occurs
//     * @throws IOException if an I/O error occurs
//     */
//    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
//    /**
//     * Handles the HTTP <code>GET</code> method.
//     *
//     * @param request servlet request
//     * @param response servlet response
//     * @throws ServletException if a servlet-specific error occurs
//     * @throws IOException if an I/O error occurs
//     */
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        String staffIdParam = request.getParameter("id");
//
//        try {
//            if (staffIdParam != null) {
//                int staffId = Integer.parseInt(staffIdParam);
//                StaffDao staffDao = new StaffDao();
//                Staff staff = staffDao.GetStaffById(staffId); 
//
//                if (staff != null) {
//                    request.setAttribute("staff", staff); 
//                    request.getRequestDispatcher("editStaff.jsp").forward(request, response);
//                } else {
//                    response.getWriter().write("Staff not found.");
//                }
//            } else {
//                response.getWriter().write("Invalid staff ID.");
//            }
//        } catch (NumberFormatException e) {
//            response.getWriter().write("Invalid staff ID format.");
//        }
//    }
//
//    /**
//     * Handles the HTTP <code>POST</code> method.
//     *
//     * @param request servlet request
//     * @param response servlet response
//     * @throws ServletException if a servlet-specific error occurs
//     * @throws IOException if an I/O error occurs
//     */
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        try {
//            Staff staff = new Staff();
//            StaffDao staffDb = new StaffDao();
//
//            staff.setStaffId(Integer.parseInt(request.getParameter("staffId")));
//            staff.setFullName(request.getParameter("fullName"));
//            staff.setEmail(request.getParameter("email"));
//            staff.setPhoneNumber(request.getParameter("phoneNumber"));
//            staff.setAddress(request.getParameter("address"));
//            staff.setStatus(Boolean.parseBoolean(request.getParameter("status")));
//            
//            TravelAgent agent = new TravelAgent();
//            agent.setAgentId(1);
//            staff.setAgent(agent);
//    
//
//            boolean success = staffDb.UpdateStaff(staff);
//            if (success) {               
//                response.sendRedirect(request.getContextPath() + "/staff/list");
//            } else {
//                request.setAttribute("errorMessage", "Update failed. Please try again.");
//                request.setAttribute("staff", staff); 
//                request.getRequestDispatcher("editStaff.jsp").forward(request, response);
//            }
//        } catch (NumberFormatException e) {         
//            request.setAttribute("errorMessage", "Invalid input. Please check your data.");
//            request.getRequestDispatcher("editStaff.jsp").forward(request, response);
//        }
//
//    }
//
//    /**
//     * Returns a short description of the servlet.
//     *
//     * @return a String containing servlet description
//     */
//    @Override
//    public String getServletInfo() {
//        return "Short description";
//    }// </editor-fold>
//
//}
