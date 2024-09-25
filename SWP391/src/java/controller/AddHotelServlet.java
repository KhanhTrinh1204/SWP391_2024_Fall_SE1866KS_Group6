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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import model.CategoryTour;
import model.Hotel;
import model.TravelAgent;
import dal.HotelDAO;
/**
 *
 * @author ACER
 */
public class AddHotelServlet extends HttpServlet {
   
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
            out.println("<title>Servlet AddHotelServlet</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AddHotelServlet at " + request.getContextPath () + "</h1>");
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
        
        request.getRequestDispatcher("addHotel.jsp").forward(request, response);

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
        String hotelName = request.getParameter("hotelName");
        String imgUrl = request.getParameter("imgUrl");
        String description = request.getParameter("description");
        String startDateStr = request.getParameter("startDate");
        String endDateStr = request.getParameter("endDate");
        String travelAgentIdStr = request.getParameter("travelAgentId");
        String categoryIdStr = request.getParameter("categoryId");
        String activeStr = request.getParameter("active");
        String priceStr = request.getParameter("price");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date startDate = null;
        Date endDate = null;
         try {
            startDate = sdf.parse(startDateStr);
            endDate = sdf.parse(endDateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        TravelAgent travelAgent = new TravelAgent();
        travelAgent.setTravelAgentId(Integer.parseInt(travelAgentIdStr)); // Giả sử TravelAgent có trường agentId

        CategoryTour categoryTour = new CategoryTour();
        categoryTour.setCategoryId(Integer.parseInt(categoryIdStr)); // Giả sử CategoryTour có trường categoryId

        boolean active = Boolean.parseBoolean(activeStr);
        double price = Double.parseDouble(priceStr);
        
        Hotel hotel =new Hotel();
        hotel.setHotelName(hotelName);
        hotel.setImgUrl(imgUrl);
        hotel.setDescription(description);
        hotel.setStartDate(startDate);
        hotel.setEndDate(endDate);
        hotel.setTravelAgent(travelAgent);
        hotel.setActive(active);
        hotel.setPrice(price);
        HotelDao hotelDao = new HotelDao();
        hotelDao.addHotel(hotel);
         response.sendRedirect(request.getContextPath() + "/list");
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private static class HotelDao {

        public HotelDao() {
        }

        private void addHotel(Hotel hotel) {
           
        }
    }

}
