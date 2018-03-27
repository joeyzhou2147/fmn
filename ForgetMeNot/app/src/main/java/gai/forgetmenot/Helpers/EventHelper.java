package gai.forgetmenot.Helpers;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

import gai.forgetmenot.Models.Event;

/**
 * Created by Ajit on 3/5/2018.
 */

public class EventHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "ForgetMeNot.db";

    public static final String TABLE_NAME = "event";
    public static final String COLUMN_EVENT_ID = "event_id";
    public static final String COLUMN_USER_ID = "user_id";
    public static final String COLUMN_EVENT_NAME = "event_name";
    public static final String COLUMN_EVENT_MONTH= "event_month";
    public static final String COLUMN_EVENT_DATE = "event_date";
    public static final String COLUMN_EVENT_YEAR ="event_year";
    public static final String COLUMN_EVENT_STARTTIME = "event_starttime";
    public static final String COLUMN_EVENT_ENDTIME = "event_endtime";
    public static final String COLUMN_EVENT_LOCATIONSTREETNAME = "event_locationstreetname";
    public static final String COLUMN_EVENT_LOCATIONAPTNUMBER = "event_locationaptnumber";
    public static final String COLUMN_EVENT_LOCATIONCITY = "event_locationcity";
    public static final String COLUMN_EVENT_LOCATIONSTATE = "event_locationstate";
    public static final String COLUMN_EVENTLOCATIONCOUNTRY = "event_locationcountry";
    public static final String COLUMN_EVENTLOCATIONZIPCODE = "event_locationzipcode";


    public static final String createTable = "create table " + TABLE_NAME + " ( "
            + COLUMN_EVENT_ID + " VARCHAR, " + COLUMN_EVENT_NAME + " VARCHAR, "+COLUMN_EVENT_MONTH+ " INTEGER," +COLUMN_EVENT_DATE
            +" INTEGER, "+COLUMN_EVENT_YEAR+" INTEGER, "+COLUMN_EVENT_STARTTIME+" DATETIME," +COLUMN_EVENT_ENDTIME+" DATETIME,"
            +COLUMN_EVENT_LOCATIONSTREETNAME+" VARCHAR, "+COLUMN_EVENT_LOCATIONAPTNUMBER+" INTEGER, "+COLUMN_EVENT_LOCATIONCITY+" VARCHAR, "+COLUMN_EVENT_LOCATIONSTATE+" VARCHAR, "
            +COLUMN_EVENTLOCATIONCOUNTRY+" VARCHAR, "+COLUMN_EVENTLOCATIONZIPCODE+" INTEGER, "+COLUMN_USER_ID+" VARCHAR);";


    public EventHelper(Context context) {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db,int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public void addEvent(Event event) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_EVENT_ID,event.getEventID());
        values.put(COLUMN_EVENT_NAME,event.getEventName());
        values.put(COLUMN_EVENT_MONTH,event.getEventMonth());
        values.put(COLUMN_EVENT_DATE,event.getEventDate());
        values.put(COLUMN_EVENT_YEAR,event.getEventYear());
        values.put(COLUMN_EVENT_STARTTIME,event.getEventStartTime());
        values.put(COLUMN_EVENT_ENDTIME, event.getEventEndTime());
        values.put(COLUMN_EVENT_LOCATIONSTREETNAME,event.getEventLocationStreetName());
        values.put(COLUMN_EVENT_LOCATIONAPTNUMBER,event.getEventLocationAptNum());
        values.put(COLUMN_EVENT_LOCATIONCITY,event.getEventLocationCity());
        values.put(COLUMN_EVENT_LOCATIONSTATE,event.getEventLocationState());
        values.put(COLUMN_EVENTLOCATIONCOUNTRY,event.getEventLocationCountry());
        values.put(COLUMN_EVENTLOCATIONZIPCODE,event.getEventLocationZipCode());
        values.put(COLUMN_USER_ID,event.getUserID());

        db.insert(TABLE_NAME,null,values);
        db.close();
    }

    public Event createEvent(Cursor cursor) { //helper method to handle creation MedicalInfoModel object
        return new Event(cursor.getString(0),cursor.getString(1),cursor.getInt(2),cursor.getInt(3),
                cursor.getInt(4),cursor.getString(5),cursor.getString(6),
                cursor.getString(7),cursor.getInt(8),cursor.getString(9),cursor.getString(10),cursor.getString(11),cursor.getInt(12),cursor.getString(13));
    }
    public Event getEvent(String eventId, String userId) {
        SQLiteDatabase db = this.getWritableDatabase();


        String where = COLUMN_EVENT_ID +" = ? AND " +COLUMN_USER_ID+ " = ? ";
        String[] whereArgs = new String[] {eventId,userId};

        Cursor cursor = db.query(TABLE_NAME,null,where,whereArgs,null,null,null);

        if (cursor==null) {
            return null;
        }

        return createEvent(cursor);
    }

    public ArrayList<Event> getAllRecords(String userId) {
        SQLiteDatabase db = this.getReadableDatabase();

        String where = COLUMN_USER_ID  + " = ? " + userId;
        String[] whereArgs = new String[] {userId};
        Cursor cursor = db.query(TABLE_NAME, null,where,whereArgs,null, null, null);

        ArrayList<Event> events = new ArrayList<>();

        if (cursor.getCount() > 0) {
            for (int i = 0; i < cursor.getCount(); i++) {
                cursor.moveToNext();
                events.add(createEvent(cursor));
            }
        }
        cursor.close();
        db.close();

        return events;
    }
}
