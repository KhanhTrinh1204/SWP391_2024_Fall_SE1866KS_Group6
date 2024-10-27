/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

/**
 *
 * @author Admin
 */
public class vehicle {
    int	vehicleId;
    String vehicleName;
    String imgURL;
    String startDate;
    String endDate;
    String description;
    int	travelAgentId;
    int	active;
    float price;

    public vehicle() {
    }

    public vehicle(int vehicleId, String vehicleName, String imgURL, String startDate, String endDate, String description, int travelAgentId, int active, float price) {
        this.vehicleId = vehicleId;
        this.vehicleName = vehicleName;
        this.imgURL = imgURL;
        this.startDate = startDate;
        this.endDate = endDate;
        this.description = description;
        this.travelAgentId = travelAgentId;
        this.active = active;
        this.price = price;
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

    public String getImgURL() {
        return imgURL;
    }

    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getTravelAgentId() {
        return travelAgentId;
    }

    public void setTravelAgentId(int travelAgentId) {
        this.travelAgentId = travelAgentId;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
    
    
}
