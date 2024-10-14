/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import java.util.Date;

/**
 *
 * @author Admin
 */
public class Account {

    private String accountId;
    private String userName;
    private String password;
    private String fullName;
    private String address;
    private String email;
    private String gender;
    private String DOB;
    private String roleID;
    private String phone;
    private String avatar;
    public String code;
    public String status;
    
    public Account(String userName, String code, String email, String password) {
        this.userName = userName;
        this.code = code;
        this.email = email;
        this.password = password;
    }

    public Account(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public Account(String userName,String code, String email ,String password, String fullName, String address, String gender, String phone) {
        this.userName = userName;
        this.password = password;
        this.fullName = fullName;
        this.address = address;
        this.email = email;
        this.gender = gender;
        this.phone = phone;
        this.code = code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Account(String accountId, String userName, String password, String fullName, String address, String email, String gender, String DOB, String roleID, String phone, String avatar, String status) {
        this.accountId = accountId;
        this.userName = userName;
        this.password = password;
        this.fullName = fullName;
        this.address = address;
        this.email = email;
        this.gender = gender;
        
        this.roleID = roleID;
        this.DOB = DOB;
        this.phone = phone;
        this.avatar = avatar;
        this.status = status;
    }
 
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Account(String accountId, String userName, String password, String fullName, String address, String email, String gender, String DOB, String roleID, String phone, String avatar) {
        this.accountId = accountId;
        this.userName = userName;
        this.password = password;
        this.fullName = fullName;
        this.address = address;
        this.email = email;
        this.gender = gender;
        this.DOB = DOB;
        this.roleID = roleID;
        this.phone = phone;
        this.avatar = avatar;
    }

    public Account() {
    }

    public Account(String userName, String password,String email) {
        this.userName = userName;
        this.password = password;
        this.email = email;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public String getRoleID() {
        return roleID;
    }

    public void setRoleID(String roleID) {
        this.roleID = roleID;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

}
