/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controllers;

import Models.Account;
import dal.ILoginDAO;
import dal.LoginDAO;
import dal.LoginDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author hoang
 */
@WebServlet(name = "ConfirmPassWord", urlPatterns = {"/ConfirmPassWord"})
public class ConfirmPassWord extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            HttpSession session = request.getSession();
            String password = request.getParameter("confirm");
            String repassword = request.getParameter("reconfirm");
            Account user = (Account) session.getAttribute("authcode");
            String code = request.getParameter("authcode");
            long otpTimestamp = (long) session.getAttribute("otpTimestamp");

            // Time limit for OTP validity (30 seconds)
            long timeLimitMillis = 30000;
            if (!code.equals(user.code) || (System.currentTimeMillis() - otpTimestamp) > timeLimitMillis) {
                session.setAttribute("authcode", user);
                String errorMessage = "Invalid or expired OTP.";
                request.setAttribute("errorMessage", errorMessage);
                request.getRequestDispatcher("ForgotPassword.jsp").forward(request, response);
            } else if (!password.equals(repassword)) {
                session.setAttribute("authcode", user);
                String errorMessage = "Passwords do not match. Please try again.";
                request.setAttribute("errorMessage", errorMessage);
                request.getRequestDispatcher("ForgotPassword.jsp").forward(request, response);
            } else if (code.equals(user.getCode()) && password.equals(repassword) && (System.currentTimeMillis() - otpTimestamp) <= timeLimitMillis) {
                ILoginDAO dao = new LoginDAO();
                dao.updatePassword(user.getEmail(), password);
                response.sendRedirect("Login.jsp");

            } else {
                session.setAttribute("authcode", user);
                String errorMessage = "Error all information.";
                request.setAttribute("errorMessage", errorMessage);
                request.getRequestDispatcher("ForgotPassword.jsp").forward(request, response);
            }
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
