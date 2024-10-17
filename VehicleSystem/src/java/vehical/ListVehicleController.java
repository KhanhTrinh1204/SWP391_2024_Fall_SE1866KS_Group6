/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package vehical;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import model.Vehicle;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 *
 * @author Legion
 */
@WebServlet(name = "ListVehicleController", urlPatterns = {"/list-vehicle"})
public class ListVehicleController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        VehicleDAO vehicleDAO = new VehicleDAO();
        ArrayList<Vehicle> vehicles = vehicleDAO.list();
        request.setAttribute("vehicles", vehicles);
        request.getRequestDispatcher("/list-vehicle.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("add".equalsIgnoreCase(action)) {
            addVehicle(request, response);
        } else if ("edit".equalsIgnoreCase(action)) {
            updateVehicle(request, response);
        } else if ("delete".equalsIgnoreCase(action)) {
            deleteVehicle(request, response);
        } else {
            response.sendRedirect("error.jsp"); // Redirect in case of an invalid action
        }

    }

    // Method to parse date from String to java.sql.Date
    private Date parseDate(String dateString) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            java.util.Date utilDate = dateFormat.parse(dateString);
            return new Date(utilDate.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    private void deleteVehicle(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int vehicleId = Integer.parseInt(request.getParameter("vehicleId"));
        Vehicle vehicle = new Vehicle();
        vehicle.setVehicleId(vehicleId);
        new VehicleDAO().delete(vehicle);
        response.sendRedirect("list-vehicle"); // Redirect back to vehicle list after deletion
    }

    // Handling Add Vehicle
    private void addVehicle(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        // Fetch form parameters
        String vehicleName = request.getParameter("vehicleName");
        String imgUrl = request.getParameter("imgUrl");
        String startDateStr = request.getParameter("startDate");
        String endDateStr = request.getParameter("endDate");
        String description = request.getParameter("description");
        int travelAgentId = Integer.parseInt(request.getParameter("travelAgentId"));
        boolean active = request.getParameter("active") != null;
        double price = Double.parseDouble(request.getParameter("price"));

        // Parse date strings to java.sql.Date
        Date startDate = parseDate(startDateStr);
        Date endDate = (endDateStr != null && !endDateStr.isEmpty()) ? parseDate(endDateStr) : null;

        // Create a new Vehicle object
        Vehicle vehicle = new Vehicle(vehicleName, imgUrl, startDate, endDate, description, travelAgentId, active, price);

        // Add vehicle using DAO
        new VehicleDAO().insert(vehicle);

        // Redirect to vehicle list page
        response.sendRedirect("list-vehicle");
    }

    // Handling Update Vehicle
    private void updateVehicle(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        // Fetch form parameters
        int vehicleId = Integer.parseInt(request.getParameter("vehicleId"));
        String vehicleName = request.getParameter("vehicleName");
        String imgUrl = request.getParameter("imgUrl");
        String startDateStr = request.getParameter("startDate");
        String endDateStr = request.getParameter("endDate");
        String description = request.getParameter("description");
        int travelAgentId = Integer.parseInt(request.getParameter("travelAgentId"));
        boolean active = request.getParameter("active") != null;
        double price = Double.parseDouble(request.getParameter("price"));

        // Parse date strings to java.sql.Date
        Date startDate = parseDate(startDateStr);
        Date endDate = (endDateStr != null && !endDateStr.isEmpty()) ? parseDate(endDateStr) : null;

        // Create an updated Vehicle object
        Vehicle vehicle = new Vehicle(vehicleId, vehicleName, imgUrl, startDate, endDate, description, travelAgentId, active, price);

        // Update vehicle using DAO
        new VehicleDAO().update(vehicle);

        // Redirect to vehicle list page
        response.sendRedirect("list-vehicle");
    }

}
