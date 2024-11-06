/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controllers.auth;

import dal.ILoginDAO;
import dal.LoginDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author hoang
 */
public class UpdateProfileCustomer extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         // Set request encoding to handle form data correctly (e.g., for non-ASCII characters)
        request.setCharacterEncoding("UTF-8");

        // Get the form parameters
        String username = request.getParameter("username").trim();
        String fullName = request.getParameter("fullname").trim();
        String address = request.getParameter("address").trim();
        String email = request.getParameter("email").trim();
        String gender = request.getParameter("gender").trim();
        String dob = request.getParameter("dob").trim();
        String phone = request.getParameter("phone").trim();
        String avatarUrl = request.getParameter("avatarUrl").trim();

        // Basic validation logic (you can expand this)
        if (username == null || fullName == null || email == null || phone == null || dob == null || avatarUrl == null) {
            // If validation fails, redirect back to the form with an error message
            request.setAttribute("error", "All fields are required.");

            return;
        }

        ILoginDAO dao = new LoginDAO();
       boolean isUpdated = dao.updateProfile(username, fullName, address, gender, dob, phone, avatarUrl, email);
        if (isUpdated) {
    // Set success message in request attribute
    request.setAttribute("successMessage", "Profile updated successfully!");
    // Redirect to the profile page (or the update form)
        response.sendRedirect("view/home");
} else {
    // If update fails, pass an error message
    request.setAttribute("error", "Profile update failed. Please try again.");
          request.getRequestDispatcher("ViewProfile.jsp").forward(request, response);
}
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
