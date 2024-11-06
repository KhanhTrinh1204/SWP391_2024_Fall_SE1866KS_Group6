/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package Controllers.tour;

import dal.RestaurantDao;
import dal.TourDao;
import dal.VehicleDao;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Hotel;
import model.Restaurant;
import model.Tour;
import model.TravelAgent;
import model.Vehicle;

/**
 *
 * @author ASUS
 */
public class AddTour extends HttpServlet {
   
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
            out.println("<title>Servlet AddTour</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AddTour at " + request.getContextPath () + "</h1>");
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
         RestaurantDao resDb = new RestaurantDao();
        VehicleDao vehicleDb = new VehicleDao();
        TourDao tourDb = new TourDao();
        // Lấy danh sách Agent, Vehicle, Restaurant
        List<TravelAgent> agents = tourDb.getAllAgents();
        List<Vehicle> vehicles = tourDb.getAllVehicles();
        List<Restaurant> restaurants = tourDb.getAllRestaurants();
        
         List<Hotel> hotels = tourDb.getAllHotels();
        // Đóng kết nối
        // Đưa danh sách vào request
        request.setAttribute("agents", agents);
        request.setAttribute("vehicles", vehicles);
        request.setAttribute("restaurants", restaurants);
        request.setAttribute("hotels", hotels);
        // Chuyển đến trang thêm tour
        request.getRequestDispatcher("addTour.jsp").forward(request, response);
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
            TourDao tourDb = new TourDao();
            // Lấy dữ liệu từ form
            String tourName = request.getParameter("tourName");
            String priceStr = request.getParameter("price");
            String description = request.getParameter("description");
            String startDateStr = request.getParameter("startDate");
            String endDateStr = request.getParameter("endDate");
            String agentIdStr = request.getParameter("agentId");
            String vehicleIdStr = request.getParameter("vehicleId");
            String restaurantIdStr = request.getParameter("restaurantId");
              String hotelIdStr = request.getParameter("hotelId");
               String fileName = request.getParameter("image");
             try {

            


            // Chuyển đổi các giá trị từ String sang kiểu dữ liệu tương ứng
            double price = Double.parseDouble(priceStr);
            int agentId = Integer.parseInt(agentIdStr);
            int vehicleId = Integer.parseInt(vehicleIdStr);
            int restaurantId = Integer.parseInt(restaurantIdStr);
             int hotelId = Integer.parseInt(hotelIdStr);
            // Định dạng ngày
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date startDate = null;
        try {
            startDate = dateFormat.parse(startDateStr);
        } catch (ParseException ex) {
            Logger.getLogger(AddTour.class.getName()).log(Level.SEVERE, null, ex);
        }
            Date endDate = null;
        try {
            endDate = dateFormat.parse(endDateStr);
        } catch (ParseException ex) {
            Logger.getLogger(AddTour.class.getName()).log(Level.SEVERE, null, ex);
        }
        int maxId = tourDb.getMaxId() + 1;
            // Tạo đối tượng Tour
            Tour tour = new Tour();
            tour.setTourId(maxId);
            tour.setTourName(tourName);
            tour.setPrice(price);
            tour.setDescription(description);
            tour.setStartDate(startDate);
            tour.setEndDate(endDate);
            tour.setImage(fileName);

            tourDb.insertTour(tour, agentId, vehicleId, restaurantId,hotelId);

           

            // Chuyển hướng người dùng đến trang danh sách tour hoặc trang thành công
            response.sendRedirect(request.getContextPath() + "/tour/list");
             } catch (Exception e){
                 
             }    
    }
        private String getSubmittedFileName(Part part) {
        String header = part.getHeader("content-disposition");
        String[] elements = header.split(";");
        for (String element : elements) {
            if (element.trim().startsWith("filename")) {
                return element.substring(element.indexOf('=') + 1).trim().replace("\"", "");
            }
        }
        return "";
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
