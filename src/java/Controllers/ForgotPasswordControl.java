/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controllers;

import Models.Account;
import dal.ILoginDAO;
import dal.LoginDAO;
import dal.LoginDBContext;
import dal.SendEmail;
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
@WebServlet(name = "ForgotPasswordControl", urlPatterns = {"/ForgotPasswordControl"})
public class ForgotPasswordControl extends HttpServlet {

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
        String email = request.getParameter("email");
        ILoginDAO dao = new LoginDAO();
        Account acc = dao.getEmail(email);
        if (acc == null) {
            String errorMessage = "Email not exist.";
            request.setAttribute("errorMessage", errorMessage);
            request.getRequestDispatcher("EnterEmail.jsp").forward(request, response);
        }
        SendEmail sm = new SendEmail();
        String code = sm.getRandom();
        long otpTimestamp = System.currentTimeMillis();

        Account acb = new Account(acc.getUserName(), code, email, acc.getPassword());
        boolean test = sm.sendEmail(acb);
        if (test) {
            HttpSession session = request.getSession();
            session.setAttribute("authcode", acb);
            session.setAttribute("otpTimestamp", otpTimestamp);
            response.sendRedirect("ForgotPassword.jsp");
        } else {
            response.sendRedirect("EnterEmail.jsp");
        }

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
