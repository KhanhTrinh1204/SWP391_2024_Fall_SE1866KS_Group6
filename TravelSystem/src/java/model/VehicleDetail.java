/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ASUS
 */
public class VehicleDetail {
    private int vehicleDetailId;
    private Vehicle vehicle;
    private Tour tour;

  
    public int getVehicleDetailId() {
        return vehicleDetailId;
    }

    public void setVehicleDetailId(int vehicleDetailId) {
        this.vehicleDetailId = vehicleDetailId;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Tour getTour() {
        return tour;
    }

    public void setTour(Tour tour) {
        this.tour = tour;
    }
    
}
