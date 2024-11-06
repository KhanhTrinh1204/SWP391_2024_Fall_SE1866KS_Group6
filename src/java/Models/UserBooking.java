/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import java.util.Date;

/**
 *
 * @author hoang
 */
public class UserBooking {
    private String id;
    private String TourID;
    private String AccountID;
    private String status;
    private String timebooking;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTourID() {
        return TourID;
    }

    public void setTourID(String TourID) {
        this.TourID = TourID;
    }

    public String getAccountID() {
        return AccountID;
    }

    public void setAccountID(String AccountID) {
        this.AccountID = AccountID;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public UserBooking() {
    }

    public String getTimebooking() {
        return timebooking;
    }

    public void setTimebooking(String timebooking) {
        this.timebooking = timebooking;
    }

    public UserBooking(String id, String TourID, String AccountID, String status, String timebooking) {
        this.id = id;
        this.TourID = TourID;
        this.AccountID = AccountID;
        this.status = status;
        this.timebooking = timebooking;
    }

   

   

    
    
    
}
