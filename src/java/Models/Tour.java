/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author ASUS
 */
public class Tour {
    private int tourId;
    private String tourName;
    private double price;
    private Date startDate;
    private Date endDate;
    private Account acount;
    private TravelAgent agent;
    private ArrayList<Vehicle> vechicle;
    private ArrayList<Restaurant> restaurant;
    private String image;

    public Tour() {
    }

    public Tour(int tourId, String tourName, double price, Date startDate, Date endDate, Account acount, TravelAgent agent, ArrayList<Vehicle> vechicle, ArrayList<Restaurant> restaurant, String image) {
        this.tourId = tourId;
        this.tourName = tourName;
        this.price = price;
        this.startDate = startDate;
        this.endDate = endDate;
        this.acount = acount;
        this.agent = agent;
        this.vechicle = vechicle;
        this.restaurant = restaurant;
        this.image = image;
    }

    public int getTourId() {
        return tourId;
    }

    public void setTourId(int tourId) {
        this.tourId = tourId;
    }

    public String getTourName() {
        return tourName;
    }

    public void setTourName(String tourName) {
        this.tourName = tourName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
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

    public Account getAcount() {
        return acount;
    }

    public void setAcount(Account acount) {
        this.acount = acount;
    }

    public TravelAgent getAgent() {
        return agent;
    }

    public void setAgent(TravelAgent agent) {
        this.agent = agent;
    }

    public ArrayList<Vehicle> getVechicle() {
        return vechicle;
    }

    public void setVechicle(ArrayList<Vehicle> vechicle) {
        this.vechicle = vechicle;
    }

    public ArrayList<Restaurant> getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(ArrayList<Restaurant> restaurant) {
        this.restaurant = restaurant;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    
       
}
