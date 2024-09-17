/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controllers;

import Models.Account;
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
@WebServlet(name = "VerifyChangePass", urlPatterns = {"/VerifyChangePass"})
public class VerifyChangePass extends HttpServlet {

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
            
            /* TODO output your page here. You may use following sample code. */
            HttpSession session = request.getSession();
              long otpTimestamp = (long) session.getAttribute("otpTimestamp");

        // Time limit for OTP validity (30 seconds)
              long timeLimitMillis = 30000;
            Account user = (Account) session.getAttribute("authcode");
            String code = request.getParameter("authcode");
            if (code.equals(user.getCode()) && (System.currentTimeMillis() - otpTimestamp) <= timeLimitMillis) {
                LoginDBContext dao = new LoginDBContext();
                dao.updatePassword(user.getEmail(), user.getPassword());
//                    String alertMessage = "Create account successful!";
//                  request.setAttribute("alertMessage1", alertMessage);
//                    request.getRequestDispatcher("Login.jsp").forward(request, response);
                out.print("Change pass successful");
            } else {
                session.setAttribute("authcode", user);
                String errorMessage = "Invalid or expired OTP.";
                request.setAttribute("errorMessage", errorMessage);
                request.getRequestDispatcher("verifychangepass.jsp").forward(request, response);
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
