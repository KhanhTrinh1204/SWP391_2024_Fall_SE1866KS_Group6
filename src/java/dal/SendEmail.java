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
}