/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import Models.UserBooking;
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
    private String description;
    private TravelAgent agent;
    private ArrayList<Vehicle> vechicle;
    private ArrayList<Restaurant> restaurant;
     private ArrayList<Hotel> hotel;
    private String image;
    private ArrayList<UserBooking> userBooking;
    private ArrayList<Account> account;
    public Tour() {
    }

    public ArrayList<Account> getAccount() {
        return account;
    }

    public void setAccount(ArrayList<Account> account) {
        this.account = account;
    }

    public Tour(int tourId, String tourName, double price, Date startDate, Date endDate, String description, TravelAgent agent, ArrayList<Vehicle> vechicle, ArrayList<Restaurant> restaurant, ArrayList<Hotel> hotel, String image, ArrayList<UserBooking> userBooking, ArrayList<Account> account) {
        this.tourId = tourId;
        this.tourName = tourName;
        this.price = price;
        this.startDate = startDate;
        this.endDate = endDate;
        this.description = description;
        this.agent = agent;
        this.vechicle = vechicle;
        this.restaurant = restaurant;
        this.hotel = hotel;
        this.image = image;
        this.userBooking = userBooking;
        this.account = account;
    }

    

    public ArrayList<UserBooking> getUserBooking() {
        return userBooking;
    }

    public void setUserBooking(ArrayList<UserBooking> userBooking) {
        this.userBooking = userBooking;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public ArrayList<Hotel> getHotel() {
        return hotel;
    }

    public void setHotel(ArrayList<Hotel> hotel) {
        this.hotel = hotel;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    
       
}
