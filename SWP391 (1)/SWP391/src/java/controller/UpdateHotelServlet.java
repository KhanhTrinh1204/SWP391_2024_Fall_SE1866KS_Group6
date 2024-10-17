/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Hotel;
import dal.HotelDAO;

/**
 *
 * @author ACER
 */
public class UpdateHotelServlet extends HttpServlet {
   
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
            out.println("<title>Servlet UpdateHotelServlet</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UpdateHotelServlet at " + request.getContextPath () + "</h1>");
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
       int hotelId = Integer.parseInt(request.getParameter("id")); 
         HotelDAO hotelDb = new HotelDAO();
        Hotel hotel = hotelDb.getHotelById(hotelId); 

        if (hotel != null) {
            request.setAttribute("hotel", hotel);
            request.getRequestDispatcher("updateHotel.jsp").forward(request, response);
            
        } else {
            
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
        Hotel hotel = new Hotel();
        HotelDAO hotelDb = new HotelDAO();
        hotel.setHotelId(Integer.parseInt(request.getParameter("hotelId")));
        hotel.setHotelName(request.getParameter("hotelName"));
        hotel.setImgUrl(request.getParameter("imgUrl"));
        hotel.setStartDate(java.sql.Date.valueOf(request.getParameter("startDate")));
        hotel.setEndDate(java.sql.Date.valueOf(request.getParameter("endDate")));
        hotel.setDescription(request.getParameter("description"));
        hotel.setPrice(Double.parseDouble(request.getParameter("price")));
        hotelDb.updateHotel(hotel);
        response.sendRedirect("update?id=" + hotel.getHotelId());
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
