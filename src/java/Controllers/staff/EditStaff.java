/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package Controllers.staff;

import dal.StaffDao;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Staff;
import model.TravelAgent;

/**
 *
 * @author ASUS
 */
public class EditStaff extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet EditStaff</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet EditStaff at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    } 

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
                int staffId = Integer.parseInt(staffIdParam);
                StaffDao staffDao = new StaffDao();
                Staff staff = staffDao.GetStaffById(staffId); 

                if (staff != null) {
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
            Staff staff = new Staff();
            StaffDao staffDb = new StaffDao();

            staff.setStaffId(Integer.parseInt(request.getParameter("staffId")));
            staff.setFullName(request.getParameter("fullName"));
            staff.setEmail(request.getParameter("email"));
            staff.setPhoneNumber(request.getParameter("phoneNumber"));
            staff.setAddress(request.getParameter("address"));
            staff.setStatus(Boolean.parseBoolean(request.getParameter("status")));
            
            TravelAgent agent = new TravelAgent();
            agent.setAgentId(1);
            staff.setAgent(agent);
    

            boolean success = staffDb.UpdateStaff(staff);
            if (success) {               
                response.sendRedirect(request.getContextPath() + "/staff/list");
            } else {
                request.setAttribute("errorMessage", "Update failed. Please try again.");
                request.setAttribute("staff", staff); 
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
