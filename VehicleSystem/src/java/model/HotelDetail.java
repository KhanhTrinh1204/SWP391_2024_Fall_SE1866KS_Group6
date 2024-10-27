
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ASUS
 */
public class HotelDetail {
    private int hotelDetailId;
    private Hotel hotel;
    private Tour tour;

  

    public int getHotelDetailId() {
        return hotelDetailId;
    }

    public void setHotelDetailId(int hotelDetailId) {
        this.hotelDetailId = hotelDetailId;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public Tour getTour() {
        return tour;
    }

    public void setTour(Tour tour) {
        this.tour = tour;
    }
    
}
