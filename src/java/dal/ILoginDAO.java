/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.util.List;
import model.Account;



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
         public boolean updateProfile(String userName, String fullName, String Address, String gender , String dob, String phone, String avatar, String email);
          public void createAccount(String user, String pass, String email, String fullname, String address, String phone, String roleID);
             public Account viewProfile(String email);
             public int getTotalRecordsAccount(String email, String status);
              public List<Account> getTotalListAccount(String email, String status,int page, int recordsPerPage);
           public void updateUser( String fullName, String Address,  String phone,String role,String status ,String email );

}
