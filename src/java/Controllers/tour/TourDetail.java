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
import model.Tour;

/**
 *
 * @author ASUS
 */
public class TourDetail extends HttpServlet {
   
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
        String tourIdStr = request.getParameter("id");
            try {
                int tourId = Integer.parseInt(tourIdStr);
                // Sử dụng VehicleDao để lấy chi tiết phương tiện
                TourDao tourDb = new TourDao();
                Tour tour = tourDb.ViewTourDetail(tourId);
                if (tour != null) {
                    // Gửi dữ liệu vehicle tới trang JSP để hiển thị
                    request.setAttribute("tour", tour);
                    request.getRequestDispatcher("tourDetail.jsp").forward(request, response);
                } else {
                    // Nếu không tìm thấy phương tiện, hiển thị trang lỗi
                    request.setAttribute("error", "Vehicle not found");
                    request.getRequestDispatcher("error.jsp").forward(request, response);
                }
            } catch (NumberFormatException e) {
                // Nếu VehicleID không hợp lệ, hiển thị trang lỗi
                request.setAttribute("error", "Invalid Vehicle ID");
                request.getRequestDispatcher("error.jsp").forward(request, response);
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
