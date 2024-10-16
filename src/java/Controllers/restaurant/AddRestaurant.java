/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.restaurant;

import dal.RestaurantDao;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import model.Restaurant;

/**
 *
 * @author ASUS
 */
@MultipartConfig
public class AddRestaurant extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     *
     * //
     * <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
     * /**
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("addRestaurant.jsp").forward(request, response);
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
        String restaurantName = request.getParameter("restaurantName");
        String location = request.getParameter("location");
        String description = request.getParameter("description");
        String phoneNumber = request.getParameter("phoneNumber");
        String email = request.getParameter("email");
        String category = request.getParameter("category");
        boolean status = Boolean.parseBoolean(request.getParameter("status"));
        try {

            Part filePart = request.getPart("image");

            // Get the filename
            String fileName = getSubmittedFileName(filePart);

            // Define the directory where the file will be saved
            String uploadPath = getServletContext().getRealPath("") + File.separator + "img";
            File uploadDir = new File(uploadPath);

            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }

            // Save the file to the server
            try (InputStream input = filePart.getInputStream(); OutputStream output = new FileOutputStream(uploadPath + File.separator + fileName)) {
                int read;
                byte[] buffer = new byte[1024];
                while ((read = input.read(buffer)) != -1) {
                    output.write(buffer, 0, read);
                }
            }

            RestaurantDao resDb = new RestaurantDao();
            int maxId = resDb.getMaxId() + 1;

            Restaurant res = new Restaurant(maxId, restaurantName, location, description, phoneNumber, email, category, status, fileName);
            res.setRestaurantId(maxId);
            res.setRestaurantName(restaurantName);
            res.setLocation(location);
            res.setDescription(description);
            res.setPhoneNumber(phoneNumber);
            res.setEmail(email);
            res.setStatus(status);
            res.setImage(fileName);
            
            resDb.InsertRestaurant(res);

            response.sendRedirect(request.getContextPath() + "/restaurant/list");

        } catch (Exception e) {

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
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
