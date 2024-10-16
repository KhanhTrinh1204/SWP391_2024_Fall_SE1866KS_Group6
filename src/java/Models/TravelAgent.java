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
public class TravelAgent {
    private int agentId;
    private String agentName;
    private String location;
    private String phoneNumber;
    private String email;
    private Staff staff;
    private Account account;
    private Vehicle vehicle;

    public TravelAgent() {
    }

    public TravelAgent(int agentId, String agentName, String location, String phoneNumber, String email, Staff staff, Account account, Vehicle vehicle) {
        this.agentId = agentId;
        this.agentName = agentName;
        this.location = location;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.staff = staff;
        this.account = account;
        this.vehicle = vehicle;
    }

    public int getAgentId() {
        return agentId;
    }

    public void setAgentId(int agentId) {
        this.agentId = agentId;
    }

    public String getAgentName() {
        return agentName;
    }

    public void setAgentName(String agentName) {
        this.agentName = agentName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
    
   
}
