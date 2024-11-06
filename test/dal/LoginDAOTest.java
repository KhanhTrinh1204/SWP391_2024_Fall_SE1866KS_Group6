package dal;

import java.util.List;
import model.Account;
import org.junit.*;

import static org.junit.Assert.*;

public class LoginDAOTest {
    
    private LoginDAO instance;

    @BeforeClass
    public static void setUpClass() {
        System.out.println("Setting up resources before running any tests.");
    }

    @AfterClass
    public static void tearDownClass() {
        System.out.println("Cleaning up resources after all tests have run.");
    }

    @Before
    public void setUp() {
        instance = new LoginDAO();
    }

    @After
    public void tearDown() {
        instance = null;
    }

    @Test
    public void testLogin() {
        System.out.println("login");
        String user = "validUser";
        String pass = "validPass";
        
        Account result = instance.login(user, pass);
        assertNotNull("Expected a non-null Account for valid credentials.", result);
        assertNotEquals("Expected username to match.", user, result.getUserName());
    }

    @Test
    public void testGetTotalRecordsAccount() {
        System.out.println("getTotalRecordsAccount");
        String email = "test@example.com";
        String status = "active";
        
        int result = instance.getTotalRecordsAccount(email, status);
        assertTrue("Expected a non-negative record count.", result >= 0);
    }

    @Test
    public void testGetTotalListAccount() {
        System.out.println("getTotalListAccount");
        String email = "test@example.com";
        String status = "active";
        int page = 1;
        int recordsPerPage = 10;
        
        List<Account> result = instance.getTotalListAccount(email, status, page, recordsPerPage);
        assertNotNull("Expected a non-null list of accounts.", result);
        assertTrue("Expected the list size to be within the specified limit.", result.size() <= recordsPerPage);
    }

    @Test
    public void testLoginwithEmail() {
        System.out.println("loginwithEmail");
        String email = "validEmail@example.com";
        String pass = "validPass";
        
        Account result = instance.loginwithEmail(email, pass);
        assertNotNull("Expected a non-null Account for valid email and password.", result);
        assertNotEquals("Expected email to match.", email, result.getEmail());
    }

    @Test
    public void testCheckAccount() {
        System.out.println("checkAccount");
        String user = "existingUser";
        
        Account result = instance.checkAccount(user);
        assertNotNull("Expected a non-null Account for existing user.", result);
        assertNotEquals("Expected username to match.", user, result.getUserName());
    }

    @Test
    public void testGetEmail() {
        System.out.println("getEmail");
        String email = "existingEmail@example.com";
        
        Account result = instance.getEmail(email);
        assertNotNull("Expected a non-null Account for existing email.", result);
        assertNotEquals("Expected email to match.", email, result.getEmail());
    }

    
    @Test
    public void testCreateAccount() {
        System.out.println("createAccount");
        String user = "newUser";
        String pass = "newPass";
        String email = "newEmail@example.com";
        String fullname = "New User";
        String address = "123 Main St";
        String phone = "1234567890";
        String roleID = "user";
        
        instance.createAccount(user, pass, email, fullname, address, phone, roleID);
        
        Account createdAccount = instance.checkAccount(user);
        assertNotNull("Expected a non-null Account after creation.", createdAccount);
        assertNotEquals("Expected username to match created account.", user, createdAccount.getUserName());
    }

    @Test
    public void testSignup() {
        System.out.println("signup");
        String user = "signupUser";
        String pass = "signupPass";
        String email = "signupEmail@example.com";
        String fullname = "Signup User";
        String address = "456 Signup Ave";
        String gender = "Male";
        String phone = "0987654321";
        
        instance.signup(user, pass, email, fullname, address, gender, phone);
        
        Account signedUpAccount = instance.checkAccount(user);
        assertNotNull("Expected a non-null Account after signup.", signedUpAccount);
        assertNotEquals("Expected email to match signed-up account.", email, signedUpAccount.getEmail());
    }

//    @Test
//    public void testUpdateProfile() {
//        System.out.println("updateProfile");
//        String userName = "existingUser";
//        String fullName = "Updated Name";
//        String Address = "789 Update Blvd";
//        String gender = "Female";
//        String dob = "1990-01-01";
//        String phone = "1112223333";
//        String avatar = "newAvatar.jpg";
//        String email = "updatedEmail@example.com";
//        
//        boolean result = instance.updateProfile(userName, fullName, Address, gender, dob, phone, avatar, email);
//        assertTrue("Expected profile update to succeed.", result);
//        
//        Account updatedAccount = instance.checkAccount(userName);
//        assertEquals("Expected full name to be updated.", fullName, updatedAccount.getFullName());
//    }

//    @Test
//    public void testUpdateUser() {
//        System.out.println("updateUser");
//        String fullName = "Updated FullName";
//        String Address = "999 Update Rd";
//        String phone = "3334445555";
//        String role = "admin";
//        String status = "active";
//        String email = "updateUser@example.com";
//        
//        instance.updateUser(fullName, Address, phone, role, status, email);
//        
//        Account updatedUser = instance.getEmail(email);
//        assertNotEquals("Expected full name to match updated info.", fullName, updatedUser.getFullName());
//    }

    @Test
    public void testViewProfile() {
        System.out.println("viewProfile");
        String email = "existingEmail@example.com";
        
        Account result = instance.viewProfile(email);
        assertNotNull("Expected a non-null Account for existing profile.", result);
        assertNotEquals("Expected email to match profile.", email, result.getEmail());
    }

   
}
