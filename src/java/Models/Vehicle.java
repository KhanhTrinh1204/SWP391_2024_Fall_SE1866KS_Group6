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
   private String vehicleType;
   private String vehicleName;
   private String licensePlate;
   private String image;
   private String manufacture;
   private int modelYear;
   private String color;
   private String engineType;
   private int mileAge;
   private int seatingCapacity;
   private Date registrationDate;
   private String description;
   private TravelAgent agent;

    public Vehicle() {
    }

    public Vehicle(int vehicleId, String vehicleType, String vehicleName, String licensePlate, String image, String manufacture, int modelYear, String color, String engineType, int mileAge, int seatingCapacity, Date registrationDate, String description, TravelAgent agent) {
        this.vehicleId = vehicleId;
        this.vehicleType = vehicleType;
        this.vehicleName = vehicleName;
        this.licensePlate = licensePlate;
        this.image = image;
        this.manufacture = manufacture;
        this.modelYear = modelYear;
        this.color = color;
        this.engineType = engineType;
        this.mileAge = mileAge;
        this.seatingCapacity = seatingCapacity;
        this.registrationDate = registrationDate;
        this.description = description;
        this.agent = agent;
    }

    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getVehicleName() {
        return vehicleName;
    }

    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getManufacture() {
        return manufacture;
    }

    public void setManufacture(String manufacture) {
        this.manufacture = manufacture;
    }

    public int getModelYear() {
        return modelYear;
    }

    public void setModelYear(int modelYear) {
        this.modelYear = modelYear;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getEngineType() {
        return engineType;
    }

    public void setEngineType(String engineType) {
        this.engineType = engineType;
    }

    public int getMileAge() {
        return mileAge;
    }

    public void setMileAge(int mileAge) {
        this.mileAge = mileAge;
    }

    public int getSeatingCapacity() {
        return seatingCapacity;
    }

    public void setSeatingCapacity(int seatingCapacity) {
        this.seatingCapacity = seatingCapacity;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TravelAgent getAgent() {
        return agent;
    }

    public void setAgent(TravelAgent agent) {
        this.agent = agent;
    }
   

}
