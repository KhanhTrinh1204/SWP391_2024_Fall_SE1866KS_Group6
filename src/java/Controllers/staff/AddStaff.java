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
import jakarta.servlet.http.HttpSession;
import model.Staff;
import model.TravelAgent;

/**
 *
 * @author ASUS
 */
public class AddStaff extends HttpServlet {
   
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
            out.println("<title>Servlet AddStaff</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AddStaff at " + request.getContextPath () + "</h1>");
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
        request.getRequestDispatcher("addStaff.jsp").forward(request, response);
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
          String fullname = request.getParameter("fullname");
        String email = request.getParameter("email");
        String phoneNumber = request.getParameter("phoneNumber");
        String address = request.getParameter("address");
        String statusRaw = request.getParameter("status");

        StaffDao staffDb = new StaffDao();
        boolean isEmailExist = staffDb.checkEmailExist(email);
        boolean isPhoneNumberExist = staffDb.checkPhoneNumberExist(phoneNumber);

        if (isEmailExist) {
            request.setAttribute("errorMessage", "Email has already existed.");
            request.getRequestDispatcher("addStaff.jsp").forward(request, response);
        } else if (isPhoneNumberExist) {
            request.setAttribute("errorMessage", "Phone number has already existed.");
            request.getRequestDispatcher("addStaff.jsp").forward(request, response);
        } else {
            int maxStaffId = staffDb.getMaxStaffId() + 1;
            boolean status = Boolean.parseBoolean(statusRaw);

            Staff staff = new Staff();
            staff.setStaffId(maxStaffId);
            staff.setFullName(fullname);
            staff.setEmail(email);
            staff.setPhoneNumber(phoneNumber);
            staff.setAddress(address);
            staff.setStatus(status);
            
            TravelAgent agent = new TravelAgent();
            agent.setAgentId(1);
            staff.setAgent(agent);

       

            HttpSession session = request.getSession();
            session.setAttribute("successMessage", "Staff added successfully!");

            staffDb.InsertStaff(staff);

            response.sendRedirect(request.getContextPath() + "/staff/list");
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
