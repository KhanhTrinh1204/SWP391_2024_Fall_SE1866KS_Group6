/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller.admin;

import dal.TourDao;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Tour;

/**
 *
 * @author ASUS
 */
public class UpdateTourServerlet extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
   
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
        try {
            int tourId = Integer.parseInt(request.getParameter("id"));
            TourDao tourDb = new TourDao();
            Tour tour = tourDb.getTourById(tourId);
            
            if (tour != null) {
                request.setAttribute("tour", tour);
                request.getRequestDispatcher("updateTour.jsp").forward(request, response);
                
            } else {
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(UpdateTourServerlet.class.getName()).log(Level.SEVERE, null, ex);
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
         Tour tour = new Tour();
         TourDao tourDb = new TourDao();
        tour.setTourId(Integer.parseInt(request.getParameter("tourId")));
        tour.setTourName(request.getParameter("tourName"));
        tour.setImgUrl(request.getParameter("imgUrl"));
        tour.setStartDate(java.sql.Date.valueOf(request.getParameter("startDate")));
        tour.setEndDate(java.sql.Date.valueOf(request.getParameter("endDate")));
        tour.setDescription(request.getParameter("description"));
        tour.setPrice(Double.parseDouble(request.getParameter("price")));
        tourDb.updateTour(tour);
        response.sendRedirect("detail?id=" + tour.getTourId());
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
