/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package Controllers.tour;

import dal.TourDao;
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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
public class UpdateTour extends HttpServlet {
   
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
            TourDao tourDao = new TourDao();
            Tour tour = tourDao.ViewTourDetail(tourId);

            // Lấy danh sách Agent, Restaurant và Vehicle để hiển thị
            List<TravelAgent> agents = tourDao.getAllAgents();
            List<Restaurant> restaurants = tourDao.getAllRestaurants();
            List<Vehicle> vehicles = tourDao.getAllVehicles();
             List<Hotel> hotels = tourDao.getAllHotels();
            request.setAttribute("tour", tour);
            request.setAttribute("agents", agents);
            request.setAttribute("restaurants", restaurants);
            request.setAttribute("vehicles", vehicles);
            request.setAttribute("hotels", hotels);
            request.getRequestDispatcher("updateTour.jsp").forward(request, response);
        } catch (NumberFormatException e) {
            Logger.getLogger(UpdateTour.class.getName()).log(Level.SEVERE, "Invalid tour ID", e);
            response.sendRedirect(request.getContextPath() + "/tour/list");
        } catch (Exception e) {
            Logger.getLogger(UpdateTour.class.getName()).log(Level.SEVERE, "Error loading tour details", e);
            response.sendRedirect(request.getContextPath() + "/error.jsp");
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
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

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
            Date startDate = null;
            Date endDate = null;
            try {
                startDate = dateFormat.parse(startDateStr);
                endDate = dateFormat.parse(endDateStr);
            } catch (ParseException e) {
                request.setAttribute("error", "Invalid date format");
                Logger.getLogger(UpdateTour.class.getName()).log(Level.SEVERE, "Date parse error", e);
                doGet(request, response);  // Hiển thị lại form nếu có lỗi
                return;
            }

            // Lấy file ảnh nếu có
   

            // Tạo đối tượng Tour
            Tour tour = new Tour();
            tour.setTourName(tourName);
            tour.setPrice(price);
            tour.setDescription(description);
            tour.setStartDate(startDate);
            tour.setEndDate(endDate);
            tour.setImage(fileName);

            // Cập nhật thông tin agent, vehicle và restaurant
            TravelAgent agent = new TravelAgent();
            agent.setAgentId(agentId);
            tour.setAgent(agent);

            Vehicle vehicle = new Vehicle();
            vehicle.setVehicleId(vehicleId);
            tour.setVechicle(new ArrayList<>(List.of(vehicle)));

            Restaurant restaurant = new Restaurant();
            restaurant.setRestaurantId(restaurantId);
            tour.setRestaurant(new ArrayList<>(List.of(restaurant)));

            Hotel hotel = new Hotel();
            hotel.setHotelId(hotelId);
            tour.setHotel(new ArrayList<>(List.of(hotel)));
            // Cập nhật thông tin Tour
            TourDao tourDao = new TourDao();
            boolean success = tourDao.editTour(tour, agentId,vehicleId,restaurantId,hotelId);

            if (success) {
                response.sendRedirect(request.getContextPath() + "/tour/list");
            } else {
                request.setAttribute("error", "Update failed");
                Logger.getLogger(UpdateTour.class.getName()).log(Level.SEVERE, "Tour update failed");
                doGet(request, response);  // Hiển thị lại form nếu có lỗi
            }
        } catch (NumberFormatException e) {
            request.setAttribute("error", "Invalid input data");
            Logger.getLogger(UpdateTour.class.getName()).log(Level.SEVERE, "Input parsing error", e);
            doGet(request, response);  // Hiển thị lại form nếu có lỗi
        } catch (Exception e) {
            request.setAttribute("error", "An unexpected error occurred");
            Logger.getLogger(UpdateTour.class.getName()).log(Level.SEVERE, "Unexpected error", e);
            doGet(request, response);  // Hiển thị lại form nếu có lỗi
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
