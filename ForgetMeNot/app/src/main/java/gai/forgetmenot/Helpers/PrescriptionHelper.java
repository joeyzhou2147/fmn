package gai.forgetmenot.Helpers;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import gai.forgetmenot.Models.Prescription;
import java.util.ArrayList;

import gai.forgetmenot.Models.MedicalInfoModel;
/**
 * Created by Ajit on 3/4/2018.
 */

public class PrescriptionHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Forget.db";

    public static final String TABLE_NAME = "prescription";
    public static final String COLUMN_PRESCRIPTION_ID= "prescription_id";
    public static final String COLUMN_MEDICAL_ID = "medical_id";
    public static final String COLUMN_PRESCRIPTION_WHEN = "prescription_when";
    public static final String COLUMN_PRESCRIPTION_CONSISTENCY = "prescription_consistency";
    public static final String COLUMN_PRESCRIPTION_AMOUNT = "prescription_amount";
    public static final String COLUMN_PRESCRIPTION_SIDEEFFECTS = "prescription_sideeffects";


    public static final String createTable = "create table " + TABLE_NAME + " ( "
            + COLUMN_PRESCRIPTION_ID + " VARCHAR, " + COLUMN_MEDICAL_ID+ " VARCHAR, "+COLUMN_PRESCRIPTION_WHEN+ " VARCHAR, "
            + COLUMN_PRESCRIPTION_CONSISTENCY+" VARCHAR, "+COLUMN_PRESCRIPTION_AMOUNT+" VARCHAR, "+COLUMN_PRESCRIPTION_SIDEEFFECTS+" VARCHAR);";

    public PrescriptionHelper(Context context) {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) { db.execSQL(createTable);}

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public Prescription createPrescription(Cursor cursor) {
        return new Prescription(cursor.getString(0),cursor.getString(1),cursor.getString(2)
                ,cursor.getString(3),cursor.getString(4),cursor.getString(5));
    }

    public void addPrescription(Prescription prescription) {
        SQLiteDatabase db =  this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_PRESCRIPTION_ID,prescription.getPrescriptionID());
        values.put(COLUMN_MEDICAL_ID,prescription.getMedicalID());
        values.put(COLUMN_PRESCRIPTION_WHEN,prescription.getPrescriptionWhen());
        values.put(COLUMN_PRESCRIPTION_CONSISTENCY,prescription.getPrescriptionConsistency());
        values.put(COLUMN_PRESCRIPTION_AMOUNT,prescription.getPrescriptionAmount());
        values.put(COLUMN_PRESCRIPTION_SIDEEFFECTS,prescription.getPrescriptionSideEffects());
        db.insert(TABLE_NAME,null,values);
    }

    public Prescription getPrescription(String prescriptionID) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_NAME,null,COLUMN_PRESCRIPTION_ID+"=?",new String[] {prescriptionID},null,null,null
        );

        if (cursor==null) {
            return null;
        }

        return createPrescription(cursor);
    }

    public ArrayList<Prescription> getAllRecords(String medicalID) {
        SQLiteDatabase db= this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_NAME, null, COLUMN_MEDICAL_ID+"=?",new String[] {medicalID}, null, null, null);

        ArrayList<Prescription> prescriptions= new ArrayList<>();
        Prescription prescription;

        if (cursor.getCount() > 0) {
            for (int i = 0; i < cursor.getCount(); i++) {
                cursor.moveToNext();
                prescription= createPrescription(cursor);
                prescriptions.add(prescription);
            }
        }
        cursor.close();
        db.close();

        return prescriptions;
    }

    public void deleteAllRecords() {
        SQLiteDatabase db = this.getReadableDatabase();
        db.delete(TABLE_NAME, null, null);
        db.close();
    }

    public void deleteRecord(Prescription prescription) {
        SQLiteDatabase db = this.getReadableDatabase();
        db.delete(TABLE_NAME, COLUMN_PRESCRIPTION_ID + " = ?", new String[]{prescription.getPrescriptionID()});
        db.close();
    }

}
