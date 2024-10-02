/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ASUS
 */
public class RestarantDetail {
    private String restaurantDetailId;
    private Restaurant restaurant;
    private Tour tour;

    

    public String getRestaurantDetailId() {
        return restaurantDetailId;
    }

    public void setRestaurantDetailId(String restaurantDetailId) {
        this.restaurantDetailId = restaurantDetailId;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public Tour getTour() {
        return tour;
    }

    public void setTour(Tour tour) {
        this.tour = tour;
    }
    
}
