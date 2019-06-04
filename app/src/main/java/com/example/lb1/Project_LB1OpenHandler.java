package com.example.lb1;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;

public class Project_LB1OpenHandler extends SQLiteOpenHelper {

    private static final String TAG = Project_LB1OpenHandler.class
            .getSimpleName();

    // Name und Version der Datenbank
    private static final String DATABASE_NAME = "Project_LB1.db";
    private static final int DATABASE_VERSION = 1;

    // Name und Attribute der Tabelle "user"
    private static final String _ID = "_id";
    private static final String TABLE_NAME_USER = "user";
    private static final String FIRSTNAME = "firstname";
    private static final String LASTNAME = "lastname";
    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";
    private static final String COMMENT = "comment";
    private static final String EMAIL = "email";

    // Konstanten für die Stimmungen
    static final int MOOD_FINE = 1;
    static final int MOOD_OK = 2;
    static final int MOOD_BAD = 3;

    // Tabelle "mood" anlegen
    private static final String TABLE_MOOD_CREATE = "CREATE TABLE "
            + TABLE_NAME_USER + " (" + _ID  + " INTEGER PRIMARY KEY AUTOINCREMENT, " + FIRSTNAME + " TEXT, " + LASTNAME + " TEXT, " + USERNAME + " TEXT, " + PASSWORD + " TEXT, " + COMMENT + " TEXT, " + EMAIL + " TEXT );";

    // Tabelle "USER" löschen
    private static final String TABLE_MOOD_DROP =
            "DROP TABLE IF EXISTS " + TABLE_NAME_USER;

    Project_LB1OpenHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_MOOD_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion,
                          int newVersion) {
        Log.w(TAG, "Upgrade der Datenbank von Version "
                + oldVersion + " zu "
                + newVersion + "; alle Daten werden gelöscht");
        db.execSQL(TABLE_MOOD_DROP);
        onCreate(db);
    }

    void insert(String firstname, String lastname, String username, String password, String comment, String email) {
        long rowId = -1;
        try {
// Datenbank öffnen
            SQLiteDatabase db = getWritableDatabase();
            Log.d(TAG, "Pfad: " + db.getPath());
// die zu speichernden Werte
            ContentValues values = new ContentValues();
            values.put(LASTNAME, firstname);
            values.put(FIRSTNAME, lastname);
            values.put(USERNAME, username);
            values.put(PASSWORD, password);
            values.put(COMMENT, comment);
            values.put(EMAIL, email);

// in die Tabelle "user" einfügen
            rowId = db.insert(TABLE_NAME_USER, null, values);
        } catch (SQLiteException e) {
            Log.e(TAG, "insert()", e);
        } finally {
            Log.d(TAG, "insert(): rowId=" + rowId);
        }
    }
}

