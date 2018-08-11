package gai.forgetmenot.Helpers;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

import gai.forgetmenot.Models.Contact;
import gai.forgetmenot.Models.Prescription;

public class ContactHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "Forget.db";
    private static final int DATABASE_VERSION = 1;

    public static final String TABLE_NAME = "contact";
    public static final String COLUMN_CONTACT_ID= "contact_id";
    public static final String COLUMN_CONTACT_NAME= "contact_name";
    public static final String COLUMN_CONTACT_RELATION= "contact_relation";
    public static final String COLUMN_USER_ID= "user_id";
    public static final String COLUMN_CONTACT_BIRTHMONTH= "contact_birthmonth";
    public static final String COLUMN_CONTACT_BIRTHDAY = "contact_birthday";
    public static final String COLUMN_CONTACT_BIRTHYEAR = "contact_birthyear";
    public static final String COLUMN_ADDITIONALINFO = "contact_additionalinfo";
    public static final String COLUMN_CONTACT_PHONE="contact_phone";
    public static final String COLUMN_STREETNAME="contact_streetname";
    public static final String COLUMN_APTNUMBER= "contact_aptnumber";
    public static final String COLUMN_CONTACT_CITY="contact_city";
    public static final String COLUMN_CONTACT_STATE= "contact_state";
    public static final String COLUMN_CONTACT_ZIP= "contact_zipcode";

    public static final String createTable = "create table " + TABLE_NAME + " ( "
            + COLUMN_CONTACT_ID + " VARCHAR, " + COLUMN_CONTACT_NAME + " VARCHAR, "+COLUMN_CONTACT_RELATION+ " VARCHAR," +COLUMN_USER_ID
            +" INTEGER, "+COLUMN_CONTACT_BIRTHMONTH+" INTEGER, "+COLUMN_CONTACT_BIRTHDAY+" INTEGER," +COLUMN_CONTACT_BIRTHYEAR+" INTEGER,"
            +COLUMN_ADDITIONALINFO+" VARCHAR, "+COLUMN_CONTACT_PHONE+" INTEGER, "+COLUMN_STREETNAME+" VARCHAR, "+COLUMN_APTNUMBER+" INTEGER, "
            +COLUMN_CONTACT_CITY+" VARCHAR, "+COLUMN_CONTACT_STATE+" VARCHAR, "+COLUMN_CONTACT_ZIP+" INTEGER);";

    public ContactHelper(Context context) {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public Contact createContact(Cursor cursor) {
        return new Contact(cursor.getString(0),cursor.getString(1),cursor.getString(2),cursor.getString(3),cursor.getInt(4),cursor.getInt(5),cursor.getInt(6),
                cursor.getString(7),cursor.getInt(8),cursor.getInt(9),cursor.getInt(10),cursor.getString(11),cursor.getString(12),
                cursor.getInt(13));
    }

    public void addContact(Contact contact) {
        SQLiteDatabase db =  this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_CONTACT_ID,contact.getContact_id());
        values.put(COLUMN_CONTACT_NAME,contact.getContact_name());
        values.put(COLUMN_CONTACT_RELATION,contact.getContact_relation());
        values.put(COLUMN_USER_ID,contact.getUser_id());
        values.put(COLUMN_CONTACT_BIRTHMONTH,contact.getContact_birthmonth());
        values.put(COLUMN_CONTACT_BIRTHDAY,contact.getContact_birthday());
        values.put(COLUMN_CONTACT_BIRTHYEAR,contact.getContact_birthyear());
        values.put(COLUMN_ADDITIONALINFO,contact.getContact_additionalinfo());
        values.put(COLUMN_CONTACT_PHONE,contact.getContact_phone());
        values.put(COLUMN_STREETNAME,contact.getContact_streetname());
        values.put(COLUMN_APTNUMBER,contact.getContact_aptnumber());
        values.put(COLUMN_CONTACT_CITY,contact.getContact_city());
        values.put(COLUMN_CONTACT_STATE,contact.getContact_state());
        values.put(COLUMN_CONTACT_ZIP,contact.getContact_zipcode());
        db.insert(TABLE_NAME,null,values);
    }

    public ArrayList<Contact> getAllRecords(String relation) {
        SQLiteDatabase db= this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_NAME, null, COLUMN_CONTACT_RELATION+"=?",new String[] {relation}, null, null, null);

        ArrayList<Contact> contacts= new ArrayList<>();
        Contact contact;

        if (cursor.getCount() > 0) {
            for (int i = 0; i < cursor.getCount(); i++) {
                cursor.moveToNext();
                contact= createContact(cursor);
                contacts.add(contact);
            }
        }
        cursor.close();
        db.close();

        return contacts;
    }

}
