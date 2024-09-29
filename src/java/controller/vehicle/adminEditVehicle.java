/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller.vehicle;

import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import dal.vehicleDAO;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import model.vehicle;

/**
 *
 * @author Admin
 */
public class adminEditVehicle extends HttpServlet {
   
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
            out.println("<title>Servlet adminEditVehicle</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet adminEditVehicle at " + request.getContextPath () + "</h1>");
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
        String id=request.getParameter("Id");
        vehicle Vehicle=new vehicle();
        Vehicle.setVehicleId(Integer.parseInt(id));
        vehicleDAO dao=new vehicleDAO();
        request.setAttribute("vehicleD", dao.findVehicle(Vehicle));               
        RequestDispatcher dispatcher = request.getRequestDispatcher("edit.jsp");
        dispatcher.forward(request, response);
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
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        String id = request.getParameter("id");
        String p = request.getParameter("price");
        try {
            vehicleDAO dao = new vehicleDAO();
            dao.edit(new vehicle(Integer.parseInt(id),
                                request.getParameter("name"),
                                request.getParameter("picture"),
                                dateFormat.format(request.getParameter("start")),
                                dateFormat.format(request.getParameter("end")),
                                request.getParameter("description"),
                                1,
                                1,
                                Float.parseFloat(p)));
            response.sendRedirect("list");
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        }
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
