/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import Models.Account;

/**
 *
 * @author hoang
 */
public interface ILoginDAO {
    public Account login(String user, String pass);
      public Account loginwithEmail(String email, String pass);
      public Account checkAccount(String user);
       public Account getEmail(String email);
       
       public void updatePassword(String email, String password);
        public void signup(String user, String pass, String email, String fullname, String address, String gender, String phone);
         public void updateProfile(String userName, String fullName, String Address, String gender , String dob, String phone, String avatar, String email);
         
             public Account viewProfile(String email);
         
}
