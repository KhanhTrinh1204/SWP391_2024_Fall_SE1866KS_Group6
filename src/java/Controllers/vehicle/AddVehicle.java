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
import java.text.SimpleDateFormat;
import java.util.Date;
import model.TravelAgent;
import model.Vehicle;

/**
 *
 * @author ASUS
 */
public class AddVehicle extends HttpServlet {

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
        request.getRequestDispatcher("addVehicle.jsp").forward(request, response);
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
        VehicleDao vehicleDb = new VehicleDao();

        String vehicleType = request.getParameter("vehicleType");
        String vehicleName = request.getParameter("vehicleName");
        String licensePlate = request.getParameter("licensePlate");
        String image = request.getParameter("image");
        String manufacture = request.getParameter("manufacture");
        int modelYear = Integer.parseInt(request.getParameter("modelYear"));
        String color = request.getParameter("color");
        int mileage = Integer.parseInt(request.getParameter("mileage"));
        int seatingCapacity = Integer.parseInt(request.getParameter("seatingCapacity"));
        java.util.Date registrationDate = java.sql.Date.valueOf(request.getParameter("registrationDate"));
        String description = request.getParameter("description");

        int maxId = vehicleDb.GetMaxVehicleId() + 1;
        
        TravelAgent agent = new TravelAgent();
        Vehicle vehicle = new Vehicle(maxId, vehicleType, vehicleName, licensePlate, image,
                manufacture, modelYear, color, vehicleType, mileage, seatingCapacity, 
                registrationDate, description, agent);
        vehicle.setVehicleId(maxId); // Tạo ID mới
        vehicle.setVehicleType(vehicleType);
        vehicle.setVehicleName(vehicleName);
        vehicle.setLicensePlate(licensePlate);
        vehicle.setImage(image);
        vehicle.setManufacture(manufacture);
        vehicle.setModelYear(modelYear);
        vehicle.setColor(color);
        vehicle.setMileAge(mileage);
        vehicle.setSeatingCapacity(seatingCapacity);
        vehicle.setRegistrationDate(registrationDate);
        vehicle.setDescription(description);
        agent.setAgentId(1);
        vehicle.setAgent(agent);
        // Thêm xe vào cơ sở dữ liệu
        vehicleDb.InsertVehicle(vehicle);

        // Chuyển hướng đến trang danh sách xe hoặc trang khác sau khi thêm thành công
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
