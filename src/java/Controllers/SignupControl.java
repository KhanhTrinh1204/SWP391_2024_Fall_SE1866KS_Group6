/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 *
 * @author hoang
 */
@WebServlet(name = "SignupControl", urlPatterns = {"/signup"})
public class SignupControl extends HttpServlet {

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
        String user = request.getParameter("newuser").trim();
        String email = request.getParameter("email").trim();
        String newpass = request.getParameter("newpass");
        String rewpass = request.getParameter("repass");
        String fullname = request.getParameter("fullname").trim();
        String gender = request.getParameter("gender").trim();
        String phone = request.getParameter("phone").trim();
        String address = request.getParameter("address").trim();
        ILoginDAO dao = new LoginDAO();
        Account checkusername = dao.checkAccount(user);
        long otpTimestamp = System.currentTimeMillis();
        Account chekcemail = dao.getEmail(email);
        if (checkusername != null || chekcemail != null) {
            String alertMessage = "Sign up failed, Email and password exist!";
            request.setAttribute("alertMessage", alertMessage);
            request.getRequestDispatcher("Login.jsp").forward(request, response);
        } else if (!newpass.equals(rewpass)) {
            String alertMessage = "Re-password failed!";
            request.setAttribute("alertMessage", alertMessage);
            request.getRequestDispatcher("Login.jsp").forward(request, response);
        } else if (user == null || email == null || newpass == null || fullname == null || rewpass == null || gender == null || phone == null || address == null) {
            String alertMessage = " Please fill all information!";
            request.setAttribute("alertMessage", alertMessage);
            request.getRequestDispatcher("Login.jsp").forward(request, response);
        } else {
            SendEmail sm = new SendEmail();
            String code = sm.getRandom();
            Account a = new Account(user, code, email, newpass, fullname, address, gender, phone);
            boolean test = sm.sendEmail(a);

            if (test) {
                HttpSession session = request.getSession();
                session.setAttribute("otpTimestamp", otpTimestamp);
                session.setAttribute("authcode", a);
                response.sendRedirect("verify.jsp");
            } else {
                response.sendRedirect("Login.jsp");
            }
        }
//       String gender=request.getParameter("gender");
//       String dob=request.getParameter("dob");
//       String phone=request.getParameter("phone");
//       else{
//            LoginDBContext dao = new LoginDBContext();
//           Account a=dao.checkAccount(user);
//           if(a==null){
//               dao.signup(user, pass,email);
//               response.sendRedirect("Login.jsp");
//           }
//           else{
//               response.sendRedirect("Login.jsp");
//           }
//       }
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
