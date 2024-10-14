/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author hoang
 */
public class Feedback {

    private String FeedbackID;
    private String Email;
    private String Title;
    private String Date;
    private String Description;
    private String Response;
    private String Status;

    public Feedback(String FeedbackID, String Email, String Title, String Date, String Description, String Response, String Status) {
        this.FeedbackID = FeedbackID;
        this.Email = Email;
        this.Title = Title;
        this.Date = Date;
        this.Description = Description;
        this.Response = Response;
        this.Status = Status;
    }

    public Feedback(String Email, String Title, String Date, String Description, String Response, String Status) {
        this.Email = Email;
        this.Title = Title;
        this.Date = Date;
        this.Description = Description;
        this.Response = Response;
        this.Status = Status;
    }

    public String getFeedbackID() {
        return FeedbackID;
    }

    public void setFeedbackID(String FeedbackID) {
        this.FeedbackID = FeedbackID;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String Date) {
        this.Date = Date;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public String getResponse() {
        return Response;
    }

    public void setResponse(String Response) {
        this.Response = Response;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

}
