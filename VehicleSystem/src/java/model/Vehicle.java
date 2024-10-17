/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

/**
 *
 * @author ASUS
 */
public class Vehicle {

    private int vehicleId;
    private String vehicleName;
    private String imgUrl;
    private Date startDate;
    private Date endDate;
    private String description;
    private TravelAgent travelAgent;
    private boolean active;
    private double price;
    private int travelAgentId;

    public Vehicle() {
    }

    // Constructor for adding a vehicle
    public Vehicle(String vehicleName, String imgUrl, Date startDate, Date endDate, String description, int travelAgentId, boolean active, double price) {
        this.vehicleName = vehicleName;
        this.imgUrl = imgUrl;
        this.startDate = startDate;
        this.endDate = endDate;
        this.description = description;
        this.travelAgentId = travelAgentId;
        this.active = active;
        this.price = price;
    }

    // Constructor for updating a vehicle
    public Vehicle(int vehicleId, String vehicleName, String imgUrl, Date startDate, Date endDate, String description, int travelAgentId, boolean active, double price) {
        this.vehicleId = vehicleId;
        this.vehicleName = vehicleName;
        this.imgUrl = imgUrl;
        this.startDate = startDate;
        this.endDate = endDate;
        this.description = description;
        this.travelAgentId = travelAgentId;
        this.active = active;
        this.price = price;
    }
    
    public int getTravelAgentId() {
        return travelAgentId;
    }

    public void setTravelAgentId(int travelAgentId) {
        this.travelAgentId = travelAgentId;
    }

    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getVehicleName() {
        return vehicleName;
    }

    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TravelAgent getTravelAgent() {
        return travelAgent;
    }

    public void setTravelAgent(TravelAgent travelAgent) {
        this.travelAgent = travelAgent;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

}
