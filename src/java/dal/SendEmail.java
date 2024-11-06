/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.util.Random;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import jakarta.servlet.http.HttpSession;
import static java.lang.Math.abs;
import model.Account;
import model.Hotel;
import model.Restaurant;
import model.Tour;
import model.Vehicle;
/**
 *
 * @author hoang
 */
public class SendEmail {

    public String getRandom() {
        int length = 6;
        Random rand = new Random();
        StringBuilder captchaStringBuilder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int baseCharNumber = abs(rand.nextInt()) % 62;
            int charNumber = 0;
            if (baseCharNumber < 26) {
                charNumber = 65 + baseCharNumber;
            } else if (baseCharNumber < 52) {
                charNumber = 97 + (baseCharNumber - 26);
            } else {
                charNumber = 48 + (baseCharNumber - 52);
            }
            captchaStringBuilder.append((char) charNumber);
        }

        return captchaStringBuilder.toString();

    }
    public boolean sendEmailResponse(String email, String response) {
        boolean test = false;
         String fromEmail = "tu08092001@gmail.com";
        String password = "dyya qksa lako ohnw";

        try {
              Properties pr = new Properties();
            pr.setProperty("mail.smtp.host", "smtp.gmail.com");
            pr.setProperty("mail.smtp.port", "587");
            pr.setProperty("mail.smtp.auth", "true");
            pr.setProperty("mail.smtp.starttls.enable", "true");
            pr.put("mail.smtp.socketFactory.port", "587");
            pr.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
            pr.put("mail.smtp.ssl.checkserveridentity", true);
            //get session to authenticate the host email address and password
            Session session = Session.getInstance(pr, new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(fromEmail, password);
                }
            });
            Message mess = new MimeMessage(session);
            mess.setFrom(new InternetAddress(fromEmail));
            mess.setRecipient(Message.RecipientType.TO, new InternetAddress(email));

            mess.setText("Mail response: "+ response);
            Transport.send(mess);
            test = true;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return test;

    }

    public boolean sendEmail(Account user) {
        boolean test = false;
         String fromEmail = "tu08092001@gmail.com";
        String password = "dyya qksa lako ohnw";

        String toEmail = user.getEmail();
        try {
              Properties pr = new Properties();
            pr.setProperty("mail.smtp.host", "smtp.gmail.com");
            pr.setProperty("mail.smtp.port", "587");
            pr.setProperty("mail.smtp.auth", "true");
            pr.setProperty("mail.smtp.starttls.enable", "true");
            pr.put("mail.smtp.socketFactory.port", "587");
            pr.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
            pr.put("mail.smtp.ssl.checkserveridentity", true);
            //get session to authenticate the host email address and password
            Session session = Session.getInstance(pr, new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(fromEmail, password);
                }
            });
            Message mess = new MimeMessage(session);
            mess.setFrom(new InternetAddress(fromEmail));
            mess.setRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));

            mess.setSubject("User Email Verification");
            mess.setText("Register succesfuly:   "+ user.getCode());
            Transport.send(mess);
            test = true;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return test;

    }
    public boolean sendDetailedEmail(String username, String code, String email, String fullname, 
                                     String address, String phoneNumber, String role) {
        boolean test = false;
        String fromEmail = "tu08092001@gmail.com";
        String password = "dyya qksa lako ohnw";

        try {
            Properties pr = new Properties();
            pr.setProperty("mail.smtp.host", "smtp.gmail.com");
            pr.setProperty("mail.smtp.port", "587");
            pr.setProperty("mail.smtp.auth", "true");
            pr.setProperty("mail.smtp.starttls.enable", "true");

            // Get session with email authentication
            Session session = Session.getInstance(pr, new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(fromEmail, password);
                }
            });

            // Create a new email message
            Message mess = new MimeMessage(session);
            mess.setFrom(new InternetAddress(fromEmail));
            mess.setRecipient(Message.RecipientType.TO, new InternetAddress(email));

            // Email subject
            mess.setSubject("Account Registration Successful");

            // Email body (formatted with HTML)
            String emailContent = "<html><body>"
                + "<h2>Account Registration Details</h2>"
                + "<p>Dear " + fullname + ",</p>"
                + "<p>Your registration was successful! Below are your account details:</p>"
                + "<table border='1' cellpadding='10'>"
                + "<tr><th>Username</th><td>" + username + "</td></tr>"
                + "<tr><th>Verification Code</th><td>" + code + "</td></tr>"
                + "<tr><th>Email</th><td>" + email + "</td></tr>"
                + "<tr><th>Full Name</th><td>" + fullname + "</td></tr>"
                + "<tr><th>Address</th><td>" + address + "</td></tr>"
                + "<tr><th>Phone Number</th><td>" + phoneNumber + "</td></tr>"
                + "<tr><th>Role</th><td>" + role + "</td></tr>"
                + "</table>"
                + "<br><p>Thank you for registering with us!</p>"
                + "</body></html>";

            mess.setContent(emailContent, "text/html");

            // Send the email
            Transport.send(mess);
            test = true;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return test;
    }
    public boolean sendTourEmail(String toEmail, Tour tour) {
    boolean test = false;
    String fromEmail = "tu08092001@gmail.com";
    String password = "dyya qksa lako ohnw";

    try {
        Properties pr = new Properties();
        pr.setProperty("mail.smtp.host", "smtp.gmail.com");
        pr.setProperty("mail.smtp.port", "587");
        pr.setProperty("mail.smtp.auth", "true");
        pr.setProperty("mail.smtp.starttls.enable", "true");
        pr.put("mail.smtp.socketFactory.port", "587");
        pr.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        pr.put("mail.smtp.ssl.checkserveridentity", true);

        Session session = Session.getInstance(pr, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromEmail, password);
            }
        });

        Message mess = new MimeMessage(session);
        mess.setFrom(new InternetAddress(fromEmail));
        mess.setRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
        mess.setSubject("Tour Details: " + tour.getTourName());

        // Constructing the email body
        StringBuilder emailContent = new StringBuilder();
        emailContent.append("Dear Customer,\n\n");
        emailContent.append("Here are the details for your tour:\n\n");
        emailContent.append("Tour Name: ").append(tour.getTourName()).append("\n");
        emailContent.append("Price: $").append(tour.getPrice()).append("\n");
        emailContent.append("Start Date: ").append(tour.getStartDate()).append("\n");
        emailContent.append("End Date: ").append(tour.getEndDate()).append("\n");
        emailContent.append("Description: ").append(tour.getDescription()).append("\n\n");

        // Agent Information
        emailContent.append("Organized by: ").append(tour.getAgent().getAgentName()).append("\n\n");

        // Vehicle Information
        emailContent.append("Vehicles Included:\n");
        for (Vehicle vehicle : tour.getVechicle()) {
            emailContent.append("- Name: ").append(vehicle.getVehicleName())
                         .append(", Color: ").append(vehicle.getColor())
                         .append(", Engine Type: ").append(vehicle.getEngineType())
                         .append(", Seating Capacity: ").append(vehicle.getSeatingCapacity())
                         .append("\n");
        }
        emailContent.append("\n");

        // Restaurant Information
        emailContent.append("Restaurants:\n");
        for (Restaurant restaurant : tour.getRestaurant()) {
            emailContent.append("- Name: ").append(restaurant.getRestaurantName())
                         .append(", Category: ").append(restaurant.getCategory())
                         .append(", Location: ").append(restaurant.getLocation())
                         .append(", Contact: ").append(restaurant.getPhoneNumber())
                         .append("\n");
        }
        emailContent.append("\n");

        // Hotel Information
        emailContent.append("Hotels:\n");
        for (Hotel hotel : tour.getHotel()) {
            emailContent.append("- Name: ").append(hotel.getHotelName())
                         .append(", Price per Night: $").append(hotel.getPrice())
                         .append(", Description: ").append(hotel.getDescription())
                         .append("\n");
        }
        emailContent.append("\n");

        // Tour Image
        emailContent.append("Tour Image: ").append(tour.getImage()).append("\n\n");

        emailContent.append("Thank you for choosing us!\nBest Regards,\nYour Travel Agency");

        mess.setText(emailContent.toString());
        Transport.send(mess);
        test = true;

    } catch (Exception e) {
        e.printStackTrace();
    }

    return test;
}

}