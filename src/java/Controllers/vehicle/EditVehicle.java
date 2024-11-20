/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.vehicle;

import dal.VehicleDao;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import static java.lang.String.valueOf;
import java.util.Date;
import model.TravelAgent;
import model.Vehicle;

/**
 *
 * @author ASUS
 */
public class EditVehicle extends HttpServlet {

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
            out.println("<title>Servlet EditVehicle</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet EditVehicle at " + request.getContextPath() + "</h1>");
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
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String vehicleIdStr = request.getParameter("id");
            try {
                int vehicleId = Integer.parseInt(vehicleIdStr);
                // Sử dụng VehicleDao để lấy chi tiết phương tiện
                VehicleDao vehicleDao = new VehicleDao();
                Vehicle vehicle = vehicleDao.GetVehicleDetails(vehicleId);
                if (vehicle != null) {
                    // Gửi dữ liệu vehicle tới trang JSP để hiển thị
                    request.setAttribute("vehicle", vehicle);
                    request.getRequestDispatcher("editVehicle.jsp").forward(request, response);
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
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Lấy thông tin từ request
        int vehicleId = Integer.parseInt(request.getParameter("vehicleId"));
        String vehicleType = request.getParameter("vehicleType");
        String vehicleName = request.getParameter("vehicleName");
        String licensePlate = request.getParameter("licensePlate");
        String image = request.getParameter("image");
        String manufacture = request.getParameter("manufacture");
        int modelYear = Integer.parseInt(request.getParameter("modelYear"));
        String color = request.getParameter("color");
        String engineType = request.getParameter("engineType");
        int mileage = Integer.parseInt(request.getParameter("mileage"));
        int seatingCapacity = Integer.parseInt(request.getParameter("seatingCapacity"));
        java.util.Date registrationDate = java.sql.Date.valueOf(request.getParameter("registrationDate"));
        String description = request.getParameter("description");
        int agentId = Integer.parseInt(request.getParameter("agentId"));

        // Tạo đối tượng Vehicle
        TravelAgent agent = new TravelAgent();
        agent.setAgentId(1);
        Vehicle vehicle = new Vehicle(vehicleId, vehicleType, vehicleName, licensePlate, image,
                manufacture, modelYear, color, engineType, mileage,
                seatingCapacity, registrationDate, description, agent);
        VehicleDao vehicleDb = new VehicleDao();

        boolean updated = vehicleDb.updateVehicle(vehicle);

        if (updated) {
            request.setAttribute("message", "Vehicle updated successfully!");
        } else {
            request.setAttribute("error", "Failed to update vehicle.");
        }

        // Forward đến trang kết quả hoặc hiển thị thông báo
        response.sendRedirect(request.getContextPath() + "/vehicle/list");
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
