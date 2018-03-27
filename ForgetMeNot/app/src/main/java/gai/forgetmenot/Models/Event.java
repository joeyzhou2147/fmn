package gai.forgetmenot.Models;

/**
 * Created by Ajit on 3/5/2018.
 */

public class Event {
    private String eventID, eventName, eventStartTime, eventEndTime, eventLocationStreetName, eventLocationCity, eventLocationState, eventLocationCountry, userID;
    private int eventMonth,eventDate,eventYear,eventLocationAptNum, eventLocationZipCode;

    public Event(String eventID,String eventName, int eventMonth, int eventDate, int eventYear, String eventStartTime, String eventEndTime
            ,String eventLocationStreetName,int eventLocationAptNum,String eventLocationCity,String eventLocationState,String eventLocationCountry,
                 int eventLocationZipCode,String userID) {
        this.eventID = eventID;
        this.eventName = eventName;
        this.eventMonth = eventMonth;
        this.eventDate = eventDate;
        this.eventYear = eventYear;
        this.eventStartTime = eventStartTime;
        this.eventEndTime = eventEndTime;
        this.eventLocationStreetName = eventLocationStreetName;
        this.eventLocationAptNum = eventLocationAptNum;
        this.eventLocationCity = eventLocationCity;
        this.eventLocationState = eventLocationState;
        this.eventLocationCountry = eventLocationCountry;
        this.eventLocationZipCode = eventLocationZipCode;
        this.userID = userID;

    }

    public String getEventID() {return eventID;}
    public String getEventName() {return eventName;}
    public String getEventStartTime() {return eventStartTime;}
    public String getEventEndTime() {return eventEndTime;}
    public String getEventLocationStreetName() {return eventLocationStreetName;}
    public String getEventLocationCity() {return eventLocationCity;}
    public String getEventLocationState() {return eventLocationState;}
    public String getEventLocationCountry() {return eventLocationCountry;}
    public String getUserID() {return userID;}

    public int getEventMonth() {return eventMonth;}
    public int getEventDate() {return eventDate;}
    public int getEventYear() {return eventYear;}
    public int getEventLocationAptNum() {return eventLocationAptNum;}
    public int getEventLocationZipCode() {return eventLocationZipCode;}


}
