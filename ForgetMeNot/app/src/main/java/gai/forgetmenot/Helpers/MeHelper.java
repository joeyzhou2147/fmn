package gai.forgetmenot.Helpers;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MeHelper extends SQLiteOpenHelper {
    // Initializing database variables
    private static final String DATABASE_NAME = "Me.db";
    private static final String TABLE_NAME = "me_table";
    private static final String ID = "ID";
    private static final String NAME = "NAME";
    private static final String DOB = "DOB";
    private static final String HOME = "HOME";

    // Create a database object
    MeHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT, DOB TEXT, HOME TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    boolean insertData(String id, String name, String dob, String home) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(ID, id);
        contentValues.put(NAME, name);
        contentValues.put(DOB, dob);
        contentValues.put(HOME, home);
        long res = db.insert(TABLE_NAME, null, contentValues);
        db.close();
        if (res != 0) return true;
        return false;
    }

    Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.rawQuery("select * from " + TABLE_NAME, null);
    }

    boolean updateData(String id, String name, String dob, String home) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(NAME, name);
        contentValues.put(DOB, dob);
        contentValues.put(HOME, home);
        int res = db.update(TABLE_NAME, contentValues, ID + " = ?",
                new String[]{String.valueOf(id)});
        db.close();
        if (res != 0) return true;
        return false;
    }

    void deleteData(String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME, "ID = ?", new String[]{id});
        db.close();
    }
}



