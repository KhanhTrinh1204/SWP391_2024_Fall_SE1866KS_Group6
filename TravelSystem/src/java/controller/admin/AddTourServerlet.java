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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.CategoryTour;
import model.Tour;
import model.TravelAgent;

/**
 *
 * @author ASUS
 */
public class AddTourServerlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
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
        request.getRequestDispatcher("addTour.jsp").forward(request, response);

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
        String tourName = request.getParameter("tourName");
        String imgUrl = request.getParameter("imgUrl");
        String description = request.getParameter("description");
        String startDateStr = request.getParameter("startDate");
        String endDateStr = request.getParameter("endDate");
        String travelAgentIdStr = request.getParameter("travelAgentId");
        String categoryIdStr = request.getParameter("categoryId");
        String activeStr = request.getParameter("active");
        String priceStr = request.getParameter("price");

        // Chuyển đổi dữ liệu
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

        // Tạo đối tượng Tour
        Tour tour = new Tour();
        tour.setTourName(tourName);
        tour.setImgUrl(imgUrl);
        tour.setDescription(description);
        tour.setStartDate(startDate);
        tour.setEndDate(endDate);
        tour.setTravelAgent(travelAgent);
        tour.setCategoryTour(categoryTour);
        tour.setActive(active);
        tour.setPrice(price);

        // Gọi TourDao để thêm tour vào DB
        TourDao tourDao = new TourDao();
        tourDao.addTour(tour);

        // Redirect về trang danh sách tour
        response.sendRedirect(request.getContextPath() + "/list");
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
