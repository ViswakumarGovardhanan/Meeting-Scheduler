package org.java.VaadinMeetingBook.samples.BookMeeting;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class MeetingFields implements Serializable {


    
    
    ///
    
    @NotNull
    @Size(min = 2, message = "Product name must have at least two characters")
   private String date;
    
    @NotNull
    @Size(min = 2, message = "Product name must have at least two characters")
   private String meetingRoom;
    
    @NotNull
    @Size(min = 2, message = "Product name must have at least two characters")
   private String meetingVenue;
    
    
    @NotNull
    @Size(min = 2, message = "Product name must have at least two characters")
   private String startTime;
    
    @NotNull
    @Size(min = 2, message = "Product name must have at least two characters")
   private String endTime;
    
    
    @NotNull
    @Size(min = 2, message = "Product name must have at least two characters")
   private String meetingPurpose;
    
    
    @NotNull
    @Size(min = 2, message = "Product name must have at least two characters")
   private String userName;
    
    
    
    
   public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    
    
    public String getMeetingVenue() {
        return meetingVenue;
    }

    public void setMeetingVenue(String meetingVenue) {
        this.meetingVenue = meetingVenue;
    }
    
    
    
    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }
    
    
    public String getMeetingRoom() {
        return meetingRoom;
    }

    public void setMeetingRoom(String meetingRoom) {
        this.meetingRoom = meetingRoom;
    }
    
    
    
    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
    
    public String getMeetingPurpose() {
        return meetingPurpose;
    }

    public void setMeetingPurpose(String meetingPurpose) {
        this.meetingPurpose = meetingPurpose;
    }
    
    public String getuserName() {
        return userName;
    }

    public void getuserName(String userName) {
        this.userName = userName;
    }
  
    
    
    
    
    
    
    
    
    
    
    

   

     
   

}
