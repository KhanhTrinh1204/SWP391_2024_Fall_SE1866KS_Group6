/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package Controllers.staff;

import dal.ILoginDAO;
import dal.LoginDAO;
import dal.SendEmail;
import dal.StaffDao;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Account;
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
        String username = request.getParameter("username").trim();
        String fullname = request.getParameter("fullname").trim();
        String email = request.getParameter("email").trim();
        String phoneNumber = request.getParameter("phoneNumber").trim();
        String address = request.getParameter("address").trim();
        String role = request.getParameter("role").trim();
         ILoginDAO dao = new LoginDAO();
        Account checkusername = dao.checkAccount(username);
          Account chekcemail = dao.getEmail(email);
        if (checkusername != null || chekcemail != null) {
            String alertMessage = "Create failed, Email and username exist!";
            request.setAttribute("alertMessage", alertMessage);
           response.sendRedirect(request.getContextPath() + "/staff/add");
        } else
        {
              SendEmail sm = new SendEmail();
              String code = sm.getRandom();
              dao.createAccount(username, code, email, fullname, address,  phoneNumber,role);
              sm.sendDetailedEmail(username, code, email, fullname, address, phoneNumber, role);
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
