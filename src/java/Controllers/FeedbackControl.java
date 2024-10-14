/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controllers;

import Models.Feedback;
import dal.FeedbackDAO;
import dal.IFeedbackDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;

/**
 *
 * @author hoang
 */
@WebServlet(name = "ListFeedback", urlPatterns = {"/ListFeedback"})
public class FeedbackControl extends HttpServlet {

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
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AccountControl</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AccountControl at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String email = request.getParameter("email");
    String statusParam = request.getParameter("status");
    String pageStr = request.getParameter("page");
    int RECORDS_PER_PAGE = 5;

    // Default to page 1 if not specified or invalid
    int page = 1;
    if (pageStr != null && !pageStr.isEmpty()) {
        try {
            page = Integer.parseInt(pageStr);
        } catch (NumberFormatException e) {
            page = 1;  // Default value
        }
    }

    IFeedbackDAO feedbackDAO = new FeedbackDAO();
    List<Feedback> feedbacks = feedbackDAO.searchFeedbacks(email, statusParam, page, RECORDS_PER_PAGE);
    int totalRecords = feedbackDAO.getTotalRecords(email, statusParam);
    int totalPages = (int) Math.ceil((double) totalRecords / RECORDS_PER_PAGE);

    // Set attributes to pass to JSP
    request.setAttribute("feedbacks", feedbacks);
    request.setAttribute("totalPages", totalPages);
    request.setAttribute("currentPage", page);

    // Forward to the JSP page
    request.getRequestDispatcher("ListFeedback.jsp").forward(request, response);
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
