/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller.auth;

import dal.HotelDAO;
import dal.RestaurantDao;
import dal.TourDao;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import model.Account;
import model.Hotel;
import model.Restaurant;
import model.Tour;

/**
 *
 * @author ASUS
 */
public class HomePage extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
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
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
             TourDao tourDb = new TourDao();
          String tourName = request.getParameter("search");
            HttpSession session = request.getSession();
        String a = (String) session.getAttribute("bookingSuccess");
        ArrayList<Tour> tour;
        
        String search = request.getParameter("search");
          String pageStr = request.getParameter("page");
        int RECORDS_PER_PAGE = 6;

        // Default to page 1 if not specified or invalid
        int page = 1;
        if (pageStr != null && !pageStr.isEmpty()) {
            try {
                page = Integer.parseInt(pageStr);
            } catch (NumberFormatException e) {
                page = 1;  // Default value
            }
        }
             
         tour  = tourDb.searchToursByName(search,page,RECORDS_PER_PAGE);
         
         
         RestaurantDao resDb = new RestaurantDao();
      
         List<Restaurant>  res  = resDb.ListRestaurant(search,page,RECORDS_PER_PAGE);
         
            HotelDAO h =new HotelDAO();//Use HotelDAO interface to call
            List<Hotel> list =h.getHotel(search,page,RECORDS_PER_PAGE);
        request.setAttribute("data", list);
        request.setAttribute("res", res);
        if(a!=null){
        session.setAttribute("bookingSuccess", "Booking completed successfully!");
        }
        // Đặt danh sách tour vào request để truyền sang JSP
        request.setAttribute("tour", tour);
        request.getRequestDispatcher("home.jsp").forward(request, response);
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
        processRequest(request, response);
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
