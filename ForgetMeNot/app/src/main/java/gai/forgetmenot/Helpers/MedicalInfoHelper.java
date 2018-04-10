package gai.forgetmenot.Helpers;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

import gai.forgetmenot.Models.MedicalInfoModel;

public class MedicalInfoHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Forget.db";

    public static final String TABLE_NAME = "medical";
    public static final String COLUMN_MEDICAL_ID = "medical_id";
    public static final String COLUMN_USER_ID = "user_id";
    public static final String COLUMN_DOC_NAME = "doc_name";
    public static final String COLUMN_DOC_STREETNAME = "doc_streetname";
    public static final String COLUMN_DOC_STREET_APT_NUM="doc_streetaptnumber";
    public static final String COLUMN_DOC_ADDRESS_CITY = "doc_addresscity";
    public static final String COLUMN_DOC_ADDRESS_STATE= "doc_addressstate";
    public static final String COLUMN_DOC_STREET_ZIP= "doc_streetzipcode";
    public static final String COLUMN_DOC_PHONE_NUMBER = "doc_phonenumber";

    public static final String createTable = "create table " + TABLE_NAME + " ( "
            + COLUMN_MEDICAL_ID + " VARCHAR, " + COLUMN_USER_ID + " VARCHAR, "+COLUMN_DOC_NAME+ " VARCHAR," +COLUMN_DOC_STREETNAME
            +" VARCHAR, "+COLUMN_DOC_STREET_APT_NUM+" INTEGER, "+COLUMN_DOC_ADDRESS_CITY+" VARCHAR," +COLUMN_DOC_ADDRESS_STATE+" VARCHAR,"
            +COLUMN_DOC_STREET_ZIP+" INTEGER, "+COLUMN_DOC_PHONE_NUMBER +" INTEGER);";

    private SQLiteDatabase database;

    public MedicalInfoHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
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

    public MedicalInfoModel createMedicalObject(Cursor cursor) { //helper method to handle creation MedicalInfoModel object
        return new MedicalInfoModel(cursor.getString(0),cursor.getString(1),cursor.getString(2),cursor.getString(3),
                cursor.getInt(4),cursor.getString(5),cursor.getString(6),
                cursor.getInt(7),cursor.getInt(8));
    }

    public void addMedicalRecord(MedicalInfoModel medicalModel) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_MEDICAL_ID,medicalModel.getMedicalId());
        values.put(COLUMN_USER_ID,medicalModel.getUserId());
        values.put(COLUMN_DOC_NAME,medicalModel.getDoctorName());
        values.put(COLUMN_DOC_STREETNAME,medicalModel.getDoctorStreet());
        values.put(COLUMN_DOC_STREET_APT_NUM,medicalModel.getStreetAptNum());
        values.put(COLUMN_DOC_ADDRESS_CITY, medicalModel.getDoctorAddressCity());
        values.put(COLUMN_DOC_ADDRESS_STATE, medicalModel.getDoctorState());
        values.put(COLUMN_DOC_STREET_ZIP,medicalModel.getDoctorZip());
        values.put(COLUMN_DOC_PHONE_NUMBER,medicalModel.getDoctorPhone());

        db.insert(TABLE_NAME,null,values);
    }

    public void updateMedicalRecord(MedicalInfoModel medicalModel) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_MEDICAL_ID,medicalModel.getMedicalId());
        values.put(COLUMN_USER_ID,medicalModel.getUserId());
        values.put(COLUMN_DOC_NAME,medicalModel.getDoctorName());
        values.put(COLUMN_DOC_STREETNAME,medicalModel.getDoctorStreet());
        values.put(COLUMN_DOC_STREET_APT_NUM,medicalModel.getStreetAptNum());
        values.put(COLUMN_DOC_ADDRESS_CITY, medicalModel.getDoctorAddressCity());
        values.put(COLUMN_DOC_ADDRESS_STATE, medicalModel.getDoctorState());
        values.put(COLUMN_DOC_STREET_ZIP,medicalModel.getDoctorZip());
        values.put(COLUMN_DOC_PHONE_NUMBER,medicalModel.getDoctorPhone());

        db.update(TABLE_NAME, values, COLUMN_USER_ID+"=?",new String[] {medicalModel.getUserId()});
    }
    public MedicalInfoModel getRecord(String userID) {
        SQLiteDatabase db = this.getReadableDatabase();
        Log.d("USER ID:",userID);
        Cursor cursor = db.query(TABLE_NAME,null,COLUMN_USER_ID+"=?",new String[] {userID},null,null,null
        );

        if (cursor==null) {
            return null;
        }
        cursor.moveToFirst();
        return createMedicalObject(cursor);
    }

    public ArrayList<MedicalInfoModel> getAllRecords(String userId) {
        database = this.getReadableDatabase();
        Cursor cursor = database.query(TABLE_NAME, null, COLUMN_USER_ID + " = ?", new String[] {userId}, null, null, null);

        ArrayList<MedicalInfoModel> medicalRecords = new ArrayList<>();
        MedicalInfoModel medicalInfoModel;

        if (cursor.getCount() > 0) {
            for (int i = 0; i < cursor.getCount(); i++) {
                cursor.moveToNext();
                medicalInfoModel = createMedicalObject(cursor);
                medicalRecords.add(medicalInfoModel);
            }
        }
        cursor.close();
        database.close();

        return medicalRecords;
    }

    public void deleteAllRecords() {
        database = this.getReadableDatabase();
        database.delete(TABLE_NAME, null, null);
        database.close();
    }

    public void deleteRecord(MedicalInfoModel medicalInfoModel) {
        database = this.getReadableDatabase();
        database.delete(TABLE_NAME, COLUMN_USER_ID + " = ?", new String[]{medicalInfoModel.getUserId() });
        database.close();
    }
}
