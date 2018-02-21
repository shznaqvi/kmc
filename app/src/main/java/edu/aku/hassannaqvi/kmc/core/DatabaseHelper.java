package edu.aku.hassannaqvi.kmc.core;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import edu.aku.hassannaqvi.kmc.contracts.ChildContract;
import edu.aku.hassannaqvi.kmc.contracts.ChildContract.ChildTable;
import edu.aku.hassannaqvi.kmc.contracts.EligibleMembersContract;
import edu.aku.hassannaqvi.kmc.contracts.EligibleMembersContract.eligibleMembers;
import edu.aku.hassannaqvi.kmc.contracts.EnumBlockContract;
import edu.aku.hassannaqvi.kmc.contracts.EnumBlockContract.EnumBlockTable;
import edu.aku.hassannaqvi.kmc.contracts.FamilyMembersContract;
import edu.aku.hassannaqvi.kmc.contracts.FamilyMembersContract.familyMembers;
import edu.aku.hassannaqvi.kmc.contracts.FormsContract;
import edu.aku.hassannaqvi.kmc.contracts.FormsContract.FormsTable;
import edu.aku.hassannaqvi.kmc.contracts.MWRAContract;
import edu.aku.hassannaqvi.kmc.contracts.MWRAContract.MWRATable;
import edu.aku.hassannaqvi.kmc.contracts.OutcomeContract;
import edu.aku.hassannaqvi.kmc.contracts.OutcomeContract.outcomeTable;
import edu.aku.hassannaqvi.kmc.contracts.RecipientsContract;
import edu.aku.hassannaqvi.kmc.contracts.RecipientsContract.RecipientsTable;
import edu.aku.hassannaqvi.kmc.contracts.SerialContract;
import edu.aku.hassannaqvi.kmc.contracts.SerialContract.singleSerial;
import edu.aku.hassannaqvi.kmc.contracts.UCsContract;
import edu.aku.hassannaqvi.kmc.contracts.UCsContract.UCsTable;
import edu.aku.hassannaqvi.kmc.contracts.UsersContract;
import edu.aku.hassannaqvi.kmc.contracts.UsersContract.UsersTable;

/**
 * Created by hassan.naqvi on 11/30/2016.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String SQL_CREATE_USERS = "CREATE TABLE " + UsersContract.UsersTable.TABLE_NAME + "("
            + UsersTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + UsersTable.ROW_USERNAME + " TEXT,"
            + UsersTable.ROW_PASSWORD + " TEXT,"
            + UsersTable.FULL_NAME + " TEXT"
            + " );";
    public static final String DATABASE_NAME = "kmc.db";
    public static final String DB_NAME = DATABASE_NAME.replace(".", "_copy.");
    public static final String PROJECT_NAME = "NNS-2018";
    private static final int DATABASE_VERSION = 1;
    private static final String SQL_CREATE_FORMS = "CREATE TABLE "
            + FormsTable.TABLE_NAME + "("
            + FormsTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + FormsTable.COLUMN_PROJECT_NAME + " TEXT,"
            + FormsTable.COLUMN_UID + " TEXT," +
            FormsTable.COLUMN_FORMDATE + " TEXT," +
            FormsTable.COLUMN_USER + " TEXT," +
            FormsTable.COLUMN_GPSELEV + " TEXT," +
            FormsTable.COLUMN_SA1 + " TEXT," +
            FormsTable.COLUMN_SA4 + " TEXT," +
            FormsTable.COLUMN_SA5 + " TEXT," +
            FormsTable.COLUMN_SB4 + " TEXT," +
            FormsTable.COLUMN_ISTATUS + " TEXT," +
            FormsTable.COLUMN_ISTATUS88x + " TEXT," +
            FormsTable.COLUMN_GPSLAT + " TEXT," +
            FormsTable.COLUMN_GPSLNG + " TEXT," +
            FormsTable.COLUMN_GPSDATE + " TEXT," +
            FormsTable.COLUMN_GPSACC + " TEXT," +
            FormsTable.COLUMN_DEVICEID + " TEXT," +
            FormsTable.COLUMN_DEVICETAGID + " TEXT," +
            FormsTable.COLUMN_APP_VERSION + " TEXT," +
            FormsTable.COLUMN_SYNCED + " TEXT," +
            FormsTable.COLUMN_SYNCED_DATE + " TEXT"
            + " );";

    private static final String SQL_CREATE_FAMILY_MEMEBERS = "CREATE TABLE "
            + familyMembers.TABLE_NAME + "("
            + familyMembers.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + familyMembers.COLUMN_PROJECT_NAME + " TEXT,"
            + familyMembers.COLUMN_UID + " TEXT," +
            familyMembers.COLUMN_UUID + " TEXT," +
            familyMembers.COLUMN_FORMDATE + " TEXT," +
            familyMembers.COLUMN_USER + " TEXT," +
            familyMembers.COLUMN_SA2 + " TEXT," +
            familyMembers.COLUMN_DEVICEID + " TEXT," +
            familyMembers.COLUMN_DEVICETAGID + " TEXT," +
            familyMembers.COLUMN_APP_VERSION + " TEXT," +
            familyMembers.COLUMN_SYNCED + " TEXT," +
            familyMembers.COLUMN_SYNCED_DATE + " TEXT"
            + " );";

    private static final String SQL_CREATE_CHILD_FORMS = "CREATE TABLE "
            + ChildTable.TABLE_NAME + "("
            + ChildTable.COLUMN__ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + ChildTable.COLUMN_PROJECTNAME + " TEXT," +
            ChildTable.COLUMN__UID + " TEXT," +
            ChildTable.COLUMN_FORMDATE + " TEXT," +
            ChildTable.COLUMN_USER + " TEXT," +
            ChildTable.COLUMN_C1SERIALNO + " TEXT," +
            ChildTable.COLUMN_SC1 + " TEXT," +
            ChildTable.COLUMN_SC2 + " TEXT," +
            ChildTable.COLUMN_SC3 + " TEXT," +
            ChildTable.COLUMN_SC4 + " TEXT," +
            ChildTable.COLUMN_SC5 + " TEXT," +
            ChildTable.COLUMN_DEVICEID + " TEXT," +
            ChildTable.COLUMN_DEVICETAGID + " TEXT," +
            ChildTable.COLUMN_SYNCED + " TEXT," +
            ChildTable.COLUMN_SYNCED_DATE + " TEXT," +
            ChildTable.COLUMN_APPVERSION + " TEXT "

            + " );";

    private static final String SQL_DELETE_USERS =
            "DROP TABLE IF EXISTS " + UsersContract.UsersTable.TABLE_NAME;
    private static final String SQL_DELETE_FORMS =
            "DROP TABLE IF EXISTS " + FormsTable.TABLE_NAME;

    private static final String SQL_DELETE_CHILD_FORMS =
            "DROP TABLE IF EXISTS " + ChildContract.ChildTable.TABLE_NAME;
    private static final String SQL_DELETE_SINGLE = "DROP TABLE IF EXISTS " + singleSerial.TABLE_NAME;
    private static final String SQL_DELETE_TALUKAS = "DROP TABLE IF EXISTS " + EnumBlockTable.TABLE_NAME;
    private static final String SQL_DELETE_UCS = "DROP TABLE IF EXISTS " + UCsTable.TABLE_NAME;
    private static final String SQL_DELETE_ELIGIBLE_MEMBERS = "DROP TABLE IF EXISTS " + eligibleMembers.TABLE_NAME;
    private static final String SQL_DELETE_MWRAS = "DROP TABLE IF EXISTS " + MWRATable.TABLE_NAME;
    private static final String SQL_DELETE_OUTCOME = "DROP TABLE IF EXISTS " + outcomeTable.TABLE_NAME;
    private static final String SQL_DELETE_FAMILYMEMBERS = "DROP TABLE IF EXISTS " + familyMembers.TABLE_NAME;
    private static final String SQL_DELETE_RECIENPTS = "DROP TABLE IF EXISTS " + RecipientsTable.TABLE_NAME;
    final String SQL_CREATE_SERIAL = "CREATE TABLE " + singleSerial.TABLE_NAME + " (" +
            singleSerial._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            singleSerial.COLUMN_DEVICE_ID + " TEXT, " +
            singleSerial.COLUMN_DATE + " TEXT, " +
            singleSerial.COLUMN_SERIAL_NO + " TEXT, " +
            singleSerial.COLUMN_SYNCED + " TEXT, " +
            singleSerial.COLUMN_SYNCED_DATE + " TEXT " +
            ");";
    final String SQL_CREATE_TALUKA = "CREATE TABLE " + EnumBlockTable.TABLE_NAME + " (" +
            EnumBlockTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            EnumBlockTable.COLUMN_EB_CODE + " TEXT, " +
            EnumBlockTable.COLUMN_GEO_AREA + " TEXT " +
            ");";
    final String SQL_CREATE_UC = "CREATE TABLE " + UCsTable.TABLE_NAME + " (" +
            UCsTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            UCsTable.COLUMN_UCCODE + " TEXT, " +
            UCsTable.COLUMN_UCS_NAME + " TEXT, " +
            UCsTable.COLUMN_TALUKA_CODE + " TEXT " +
            ");";

    final String SQL_CREATE_ELIGIBLE_MEMBERS = "CREATE TABLE " + eligibleMembers.TABLE_NAME + " (" +
            eligibleMembers.COLUMN__ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            eligibleMembers.COLUMN_UID + " TEXT," +
            eligibleMembers.COLUMN_UUID + " TEXT," +
            eligibleMembers.COLUMN_FORMDATE + " TEXT," +
            eligibleMembers.COLUMN_DEVICEID + " TEXT," +
            eligibleMembers.COLUMN_DEVICETAGID + " TEXT," +
            eligibleMembers.COLUMN_USER + " TEXT," +
            eligibleMembers.COLUMN_APPVERSION + " TEXT," +
            eligibleMembers.COLUMN_A3SERIALNO + " TEXT," +
            eligibleMembers.COLUMN_NAME + " TEXT," +
            eligibleMembers.COLUMN_DOB + " TEXT," +
            eligibleMembers.COLUMN_AGE + " TEXT," +
            eligibleMembers.COLUMN_GENDER + " TEXT," +
            eligibleMembers.COLUMN_SA3 + " TEXT," +
            eligibleMembers.COLUMN_SYNCED + " TEXT," +
            eligibleMembers.COLUMN_SYNCEDDATE + " TEXT" +

            ");";


    final String SQL_CREATE_MWRAS = "CREATE TABLE " + MWRATable.TABLE_NAME + " (" +
            MWRATable.COLUMN__ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            MWRATable.COLUMN_UID + " TEXT," +
            MWRATable.COLUMN_UUID + " TEXT," +
            MWRATable.COLUMN_FORMDATE + " TEXT," +
            MWRATable.COLUMN_DEVICEID + " TEXT," +
            MWRATable.COLUMN_DEVICETAGID + " TEXT," +
            MWRATable.COLUMN_USER + " TEXT," +
            MWRATable.COLUMN_APP_VER + " TEXT," +
            MWRATable.COLUMN_B1SERIALNO + " TEXT," +
            MWRATable.COLUMN_SB1 + " TEXT," +
            MWRATable.COLUMN_SB2 + " TEXT," +
            MWRATable.COLUMN_SB4 + " TEXT," +
            MWRATable.COLUMN_SB5 + " TEXT," +
            MWRATable.COLUMN_SB6 + " TEXT," +
            MWRATable.COLUMN_SYNCED + " TEXT," +
            MWRATable.COLUMN_SYNCEDDATE + " TEXT " +

            ");";


    final String SQL_CREATE_OUTCOME = "CREATE TABLE " + outcomeTable.TABLE_NAME + " (" +
            outcomeTable.COLUMN__ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            outcomeTable.COLUMN_UID + " TEXT," +
            outcomeTable.COLUMN_UUID + " TEXT," +
            outcomeTable.COLUMN_FORMDATE + " TEXT," +
            outcomeTable.COLUMN_DEVICEID + " TEXT," +
            outcomeTable.COLUMN_DEVICETAGID + " TEXT," +
            outcomeTable.COLUMN_USER + " TEXT," +
            outcomeTable.COLUMN_APP_VER + " TEXT," +
            outcomeTable.COLUMN_B1APregSNO + " TEXT," +
            outcomeTable.COLUMN_SB1A + " TEXT," +
            outcomeTable.COLUMN_SYNCED + " TEXT," +
            outcomeTable.COLUMN_SYNCEDDATE + " TEXT " +

            ");";

    final String SQL_CREATE_RECIPIENTS = "CREATE TABLE " + RecipientsTable.TABLE_NAME + " (" +
            RecipientsTable.COLUMN__ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            RecipientsTable.COLUMN_UID + " TEXT," +
            RecipientsTable.COLUMN_UUID + " TEXT," +
            RecipientsTable.COLUMN_FORMDATE + " TEXT," +
            RecipientsTable.COLUMN_DEVICEID + " TEXT," +
            RecipientsTable.COLUMN_DEVICETAGID + " TEXT," +
            RecipientsTable.COLUMN_USER + " TEXT," +
            RecipientsTable.COLUMN_APP_VER + " TEXT," +
            RecipientsTable.COLUMN_A8ASNO + " TEXT," +
            RecipientsTable.COLUMN_SA8A + " TEXT," +
            outcomeTable.COLUMN_SYNCED + " TEXT," +
            outcomeTable.COLUMN_SYNCEDDATE + " TEXT " +

            ");";


    private final String TAG = "DatabaseHelper";


    public String spDateT = new SimpleDateFormat("dd-MM-yy").format(new Date().getTime());


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(SQL_CREATE_USERS);
        db.execSQL(SQL_CREATE_FORMS);
        db.execSQL(SQL_CREATE_CHILD_FORMS);
        db.execSQL(SQL_CREATE_SERIAL);
        db.execSQL(SQL_CREATE_TALUKA);
        db.execSQL(SQL_CREATE_UC);
        db.execSQL(SQL_CREATE_ELIGIBLE_MEMBERS);
        db.execSQL(SQL_CREATE_MWRAS);
        db.execSQL(SQL_CREATE_OUTCOME);
        db.execSQL(SQL_CREATE_FAMILY_MEMEBERS);
        db.execSQL(SQL_CREATE_RECIPIENTS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL(SQL_DELETE_USERS);
        db.execSQL(SQL_DELETE_FORMS);
        db.execSQL(SQL_DELETE_CHILD_FORMS);
        db.execSQL(SQL_DELETE_SINGLE);
        db.execSQL(SQL_DELETE_TALUKAS);
        db.execSQL(SQL_DELETE_UCS);
        db.execSQL(SQL_DELETE_ELIGIBLE_MEMBERS);
        db.execSQL(SQL_DELETE_MWRAS);
        db.execSQL(SQL_DELETE_OUTCOME);
        db.execSQL(SQL_DELETE_FAMILYMEMBERS);
        db.execSQL(SQL_DELETE_RECIENPTS);


    }

    public void syncEnumBlocks(JSONArray Enumlist) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(EnumBlockTable.TABLE_NAME, null, null);
        try {
            JSONArray jsonArray = Enumlist;
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObjectCC = jsonArray.getJSONObject(i);

                EnumBlockContract Vc = new EnumBlockContract();
                Vc.Sync(jsonObjectCC);

                ContentValues values = new ContentValues();

                values.put(EnumBlockTable.COLUMN_EB_CODE, Vc.getEbcode());
                values.put(EnumBlockTable.COLUMN_GEO_AREA, Vc.getTalukaName());

                db.insert(EnumBlockTable.TABLE_NAME, null, values);
            }
        } catch (Exception e) {
        } finally {
            db.close();
        }
    }

    public void syncUCs(JSONArray UCslist) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(UCsTable.TABLE_NAME, null, null);
        try {
            JSONArray jsonArray = UCslist;
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObjectCC = jsonArray.getJSONObject(i);

                UCsContract Vc = new UCsContract();
                Vc.Sync(jsonObjectCC);

                ContentValues values = new ContentValues();

                values.put(UCsTable.COLUMN_UCCODE, Vc.getUccode());
                values.put(UCsTable.COLUMN_UCS_NAME, Vc.getUcsName());
                values.put(UCsTable.COLUMN_TALUKA_CODE, Vc.getTaluka_code());

                db.insert(UCsTable.TABLE_NAME, null, values);
            }
        } catch (Exception e) {
        } finally {
            db.close();
        }
    }

    public String getEnumBlock(String enumBlock) {

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = {
                EnumBlockTable._ID,
                EnumBlockTable.COLUMN_EB_CODE,
                EnumBlockTable.COLUMN_GEO_AREA
        };

        String whereClause = EnumBlockTable.COLUMN_EB_CODE + " =?";
        String[] whereArgs = new String[]{enumBlock};
        String groupBy = null;
        String having = null;

        String orderBy =
                EnumBlockTable._ID + " ASC";

//        Collection<EnumBlockContract> allEB = new ArrayList<>();
        String allEB = "";
        try {
            c = db.query(
                    EnumBlockTable.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
//                EnumBlockContract eb = new EnumBlockContract();
//                allEB.add(eb.HydrateTalukas(c));
                allEB = c.getString(c.getColumnIndex(EnumBlockTable.COLUMN_GEO_AREA));
            }
        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }
        return allEB;
    }

    public SerialContract getSerialWRTDate(String date) {

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = {
                singleSerial._ID,
                singleSerial.COLUMN_DEVICE_ID,
                singleSerial.COLUMN_DATE,
                singleSerial.COLUMN_SERIAL_NO,
        };

        String whereClause = singleSerial.COLUMN_DATE + " =?";
        String[] whereArgs = new String[]{date};
        String groupBy = null;
        String having = null;

        String orderBy =
                singleSerial._ID + " ASC";

        SerialContract allDC = new SerialContract();
        try {
            c = db.query(
                    singleSerial.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                allDC.hydrate(c);
            }
        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }
        return allDC;
    }

    public Collection<UCsContract> getAllUCsByTalukas(String taluka_code) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = {
                UCsTable._ID,
                UCsTable.COLUMN_UCCODE,
                UCsTable.COLUMN_UCS_NAME,
                UCsTable.COLUMN_TALUKA_CODE
        };

        String whereClause = UCsTable.COLUMN_TALUKA_CODE + " = ?";
        String[] whereArgs = {taluka_code};
        String groupBy = null;
        String having = null;

        String orderBy =
                UCsTable.COLUMN_UCS_NAME + " ASC";

        Collection<UCsContract> allPC = new ArrayList<>();
        try {
            c = db.query(
                    UCsTable.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                UCsContract pc = new UCsContract();
                allPC.add(pc.hydrate(c));
            }
        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }
        return allPC;
    }

    public void syncUser(JSONArray userlist) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(UsersTable.TABLE_NAME, null, null);
        try {
            JSONArray jsonArray = userlist;
            for (int i = 0; i < jsonArray.length(); i++) {

                JSONObject jsonObjectUser = jsonArray.getJSONObject(i);

                UsersContract user = new UsersContract();
                user.Sync(jsonObjectUser);
                ContentValues values = new ContentValues();

                values.put(UsersContract.UsersTable.ROW_USERNAME, user.getUserName());
                values.put(UsersTable.ROW_PASSWORD, user.getPassword());
                values.put(UsersTable.FULL_NAME, user.getFULL_NAME());
                db.insert(UsersTable.TABLE_NAME, null, values);
            }


        } catch (Exception e) {
            Log.d(TAG, "syncUser(e): " + e);
        } finally {
            db.close();
        }
    }

    public boolean Login(String username, String password) throws SQLException {

        SQLiteDatabase db = this.getReadableDatabase();

// New value for one column
        String[] columns = {
                UsersTable._ID
        };

// Which row to update, based on the ID
        String selection = UsersContract.UsersTable.ROW_USERNAME + " = ?" + " AND " + UsersContract.UsersTable.ROW_PASSWORD + " = ?";
        String[] selectionArgs = {username, password};
        Cursor cursor = db.query(UsersContract.UsersTable.TABLE_NAME, //Table to query
                columns,                    //columns to return
                selection,                  //columns for the WHERE clause
                selectionArgs,              //The values for the WHERE clause
                null,                       //group the rows
                null,                       //filter by row groups
                null);                      //The sort order

        int cursorCount = cursor.getCount();

        cursor.close();
        db.close();
        return cursorCount > 0;
    }

    public List<FormsContract> getFormsByDSS(String dssID) {
        List<FormsContract> formList = new ArrayList<>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + FormsTable.TABLE_NAME;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (c.moveToFirst()) {
            do {
                FormsContract fc = new FormsContract();
                formList.add(fc.Hydrate(c));
            } while (c.moveToNext());
        }

        // return contact list
        return formList;
    }

    public Long addForm(FormsContract fc) {

        // Gets the data repository in write mode
        SQLiteDatabase db = this.getWritableDatabase();

// Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(FormsTable.COLUMN_PROJECT_NAME, fc.getProjectName());
        values.put(FormsTable.COLUMN_UID, fc.getUID());
        values.put(FormsTable.COLUMN_FORMDATE, fc.getFormDate());
        values.put(FormsTable.COLUMN_USER, fc.getUser());
        values.put(FormsTable.COLUMN_GPSELEV, fc.getGpsElev());
        values.put(FormsTable.COLUMN_ISTATUS, fc.getIstatus());
        values.put(FormsTable.COLUMN_ISTATUS88x, fc.getIstatus88x());
        values.put(FormsTable.COLUMN_SA1, fc.getsA1());
        values.put(FormsTable.COLUMN_SA4, fc.getsA4());
        values.put(FormsTable.COLUMN_SA5, fc.getsA5());
        values.put(FormsTable.COLUMN_SB4, fc.getsB4());
        values.put(FormsTable.COLUMN_GPSLAT, fc.getGpsLat());
        values.put(FormsTable.COLUMN_GPSLNG, fc.getGpsLng());
        values.put(FormsTable.COLUMN_GPSDATE, fc.getGpsDT());
        values.put(FormsTable.COLUMN_GPSACC, fc.getGpsAcc());
        values.put(FormsTable.COLUMN_DEVICETAGID, fc.getDevicetagID());
        values.put(FormsTable.COLUMN_DEVICEID, fc.getDeviceID());
        values.put(FormsTable.COLUMN_SYNCED, fc.getSynced());
        values.put(FormsTable.COLUMN_SYNCED_DATE, fc.getSynced_date());
        values.put(FormsTable.COLUMN_APP_VERSION, fc.getAppversion());


        // Insert the new row, returning the primary key value of the new row
        long newRowId;
        newRowId = db.insert(
                FormsTable.TABLE_NAME,
                FormsTable.COLUMN_NAME_NULLABLE,
                values);
        return newRowId;
    }

    public Long addFamilyMembers(FamilyMembersContract fmc) {

        // Gets the data repository in write mode
        SQLiteDatabase db = this.getWritableDatabase();

// Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(familyMembers.COLUMN_PROJECT_NAME, fmc.getProjectName());
        values.put(familyMembers.COLUMN_UID, fmc.get_UID());
        values.put(familyMembers.COLUMN_UUID, fmc.get_UUID());
        values.put(familyMembers.COLUMN_FORMDATE, fmc.getFormDate());
        values.put(familyMembers.COLUMN_USER, fmc.getUser());
        values.put(familyMembers.COLUMN_SA2, fmc.getsA2());
        values.put(familyMembers.COLUMN_DEVICETAGID, fmc.getDevicetagID());
        values.put(familyMembers.COLUMN_DEVICEID, fmc.getDeviceId());
        values.put(familyMembers.COLUMN_SYNCED, fmc.getSynced());
        values.put(familyMembers.COLUMN_SYNCED_DATE, fmc.getSyncedDate());
        values.put(familyMembers.COLUMN_APP_VERSION, fmc.getApp_ver());


        // Insert the new row, returning the primary key value of the new row
        long newRowId;
        newRowId = db.insert(
                familyMembers.TABLE_NAME,
                familyMembers.COLUMN_NAME_NULLABLE,
                values);
        return newRowId;
    }


    public Long addRecipient(RecipientsContract rc) {

        // Gets the data repository in write mode
        SQLiteDatabase db = this.getWritableDatabase();

// Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(RecipientsTable.COLUMN_PROJECTNAME, rc.getProjectName());
        values.put(RecipientsTable.COLUMN_UID, rc.get_UID());
        values.put(RecipientsTable.COLUMN_UUID, rc.get_UUID());
        values.put(RecipientsTable.COLUMN_FORMDATE, rc.getFormDate());
        values.put(RecipientsTable.COLUMN_USER, rc.getUser());
        values.put(RecipientsTable.COLUMN_A8ASNO, rc.getA8aSNo());
        values.put(RecipientsTable.COLUMN_SA8A, rc.getsA8A());
        values.put(RecipientsTable.COLUMN_DEVICETAGID, rc.getDevicetagID());
        values.put(RecipientsTable.COLUMN_DEVICEID, rc.getDeviceId());
        values.put(RecipientsTable.COLUMN_SYNCED, rc.getSynced());
        values.put(RecipientsTable.COLUMN_SYNCEDDATE, rc.getSyncedDate());
        values.put(RecipientsTable.COLUMN_APP_VER, rc.getApp_ver());


        // Insert the new row, returning the primary key value of the new row
        long newRowId;
        newRowId = db.insert(
                familyMembers.TABLE_NAME,
                familyMembers.COLUMN_NAME_NULLABLE,
                values);
        return newRowId;
    }

    public Long addChildForm(ChildContract cc) {

        // Gets the data repository in write mode
        SQLiteDatabase db = this.getWritableDatabase();

// Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(ChildTable.COLUMN_PROJECTNAME, cc.getProjectName());
        //values.put(ChildTable.COLUMN__ID, cc.get_ID());
        values.put(ChildTable.COLUMN__UID, cc.getUID());
        values.put(ChildTable.COLUMN_FORMDATE, cc.getFormDate());
        values.put(ChildTable.COLUMN_USER, cc.getUser());
        values.put(ChildTable.COLUMN_C1SERIALNO, cc.getC1SerialNo());
        values.put(ChildTable.COLUMN_SC1, cc.getsC1());
        values.put(ChildTable.COLUMN_SC2, cc.getsC2());
        values.put(ChildTable.COLUMN_SC3, cc.getsC3());
        values.put(ChildTable.COLUMN_SC4, cc.getsC4());
        values.put(ChildTable.COLUMN_SC5, cc.getsC5());
        values.put(ChildTable.COLUMN_DEVICEID, cc.getDeviceID());
        values.put(ChildTable.COLUMN_DEVICETAGID, cc.getDevicetagID());
        values.put(ChildTable.COLUMN_SYNCED, cc.getSynced());
        values.put(ChildTable.COLUMN_SYNCED_DATE, cc.getSynced_date());
        values.put(ChildTable.COLUMN_APPVERSION, cc.getAppversion());


        // Insert the new row, returning the primary key value of the new row
        long newRowId;
        newRowId = db.insert(
                ChildTable.TABLE_NAME,
                ChildTable.COLUMN_NAME_NULLABLE,
                values);
        return newRowId;
    }


    public Long addEligibleMember(EligibleMembersContract ec) {

        // Gets the data repository in write mode
        SQLiteDatabase db = this.getWritableDatabase();

// Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(eligibleMembers.COLUMN_PROJECTNAME, ec.getProjectName());
        //values.put(eligibleMembers.COLUMN__ID, ec.get_ID());
        values.put(eligibleMembers.COLUMN_UID, ec.get_UID());
        values.put(eligibleMembers.COLUMN_UUID, ec.get_UUID());
        values.put(eligibleMembers.COLUMN_FORMDATE, ec.getFormDate());
        values.put(eligibleMembers.COLUMN_DEVICEID, ec.getDeviceId());
        values.put(eligibleMembers.COLUMN_DEVICETAGID, ec.getDevicetagID());
        values.put(eligibleMembers.COLUMN_USER, ec.getUser());
        values.put(eligibleMembers.COLUMN_APPVERSION, ec.getApp_ver());
        values.put(eligibleMembers.COLUMN_A3SERIALNO, ec.getA3SerialNo());
        values.put(eligibleMembers.COLUMN_NAME, ec.getName());
        values.put(eligibleMembers.COLUMN_DOB, ec.getDob());
        values.put(eligibleMembers.COLUMN_AGE, ec.getAge());
        values.put(eligibleMembers.COLUMN_GENDER, ec.getGender());
        values.put(eligibleMembers.COLUMN_SA3, ec.getsA3());
        values.put(eligibleMembers.COLUMN_SYNCED, ec.getSynced());
        values.put(eligibleMembers.COLUMN_SYNCEDDATE, ec.getSyncedDate());


        // Insert the new row, returning the primary key value of the new row
        long newRowId;
        newRowId = db.insert(
                eligibleMembers.TABLE_NAME,
                eligibleMembers.COLUMN_NAME_NULLABLE,
                values);
        return newRowId;
    }


    public Long addMWRA(MWRAContract mc) {

        // Gets the data repository in write mode
        SQLiteDatabase db = this.getWritableDatabase();

// Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(MWRATable.COLUMN_PROJECTNAME, mc.getProjectName());
        //values.put(MWRATable.COLUMN__ID, mc.get_ID());
        values.put(MWRATable.COLUMN_UID, mc.get_UID());
        values.put(MWRATable.COLUMN_UUID, mc.get_UUID());
        values.put(MWRATable.COLUMN_FORMDATE, mc.getFormDate());
        values.put(MWRATable.COLUMN_DEVICEID, mc.getDeviceId());
        values.put(MWRATable.COLUMN_DEVICETAGID, mc.getDevicetagID());
        values.put(MWRATable.COLUMN_USER, mc.getUser());
        values.put(MWRATable.COLUMN_APP_VER, mc.getApp_ver());
        values.put(MWRATable.COLUMN_B1SERIALNO, mc.getB1SerialNo());
        values.put(MWRATable.COLUMN_SB1, mc.getsB1());
        values.put(MWRATable.COLUMN_SB2, mc.getsB2());
        values.put(MWRATable.COLUMN_SB4, mc.getsB4());
        values.put(MWRATable.COLUMN_SB5, mc.getsB5());
        values.put(MWRATable.COLUMN_SB6, mc.getsB6());
        values.put(MWRATable.COLUMN_SYNCED, mc.getSynced());
        values.put(MWRATable.COLUMN_SYNCEDDATE, mc.getSyncedDate());


        // Insert the new row, returning the primary key value of the new row
        long newRowId;
        newRowId = db.insert(
                MWRATable.TABLE_NAME,
                MWRATable.COLUMN_NAME_NULLABLE,
                values);
        return newRowId;
    }

    public Long addOutcome(OutcomeContract oc) {

        // Gets the data repository in write mode
        SQLiteDatabase db = this.getWritableDatabase();

// Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(outcomeTable.COLUMN_PROJECTNAME, oc.getProjectName());
        //values.put(outcomeTable.COLUMN__ID, oc.get_ID());
        values.put(outcomeTable.COLUMN_UID, oc.get_UID());
        values.put(outcomeTable.COLUMN_UUID, oc.get_UUID());
        values.put(outcomeTable.COLUMN_FORMDATE, oc.getFormDate());
        values.put(outcomeTable.COLUMN_DEVICEID, oc.getDeviceId());
        values.put(outcomeTable.COLUMN_DEVICETAGID, oc.getDevicetagID());
        values.put(outcomeTable.COLUMN_USER, oc.getUser());
        values.put(outcomeTable.COLUMN_APP_VER, oc.getApp_ver());
        values.put(outcomeTable.COLUMN_B1APregSNO, oc.getB1aPregSNo());
        values.put(outcomeTable.COLUMN_SB1A, oc.getsB1A());

        values.put(outcomeTable.COLUMN_SYNCED, oc.getSynced());
        values.put(outcomeTable.COLUMN_SYNCEDDATE, oc.getSyncedDate());


        // Insert the new row, returning the primary key value of the new row
        long newRowId;
        newRowId = db.insert(
                outcomeTable.TABLE_NAME,
                outcomeTable.COLUMN_NAME_NULLABLE,
                values);
        return newRowId;
    }


    public Long addSerialForm(SerialContract sc) {

        // Gets the data repository in write mode
        SQLiteDatabase db = this.getWritableDatabase();

// Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(singleSerial.COLUMN_DEVICE_ID, sc.getDeviceid());
        values.put(singleSerial.COLUMN_DATE, sc.getdt());
        values.put(singleSerial.COLUMN_SERIAL_NO, sc.getSerialno());

        // Insert the new row, returning the primary key value of the new row
        long newRowId;
        newRowId = db.insert(
                singleSerial.TABLE_NAME,
                singleSerial.COLUMN_NAME_NULLABLE,
                values);
        return newRowId;
    }

    public int updateSerialWRTDate(String date, String serial) {

        // Gets the data repository in write mode
        SQLiteDatabase db = this.getWritableDatabase();

// Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(singleSerial.COLUMN_SERIAL_NO, serial);

        // Which row to update, based on the title
        String where = singleSerial.COLUMN_DATE + " = ?";
        String[] whereArgs = {date};

        int count = db.update(
                singleSerial.TABLE_NAME,
                values,
                where,
                whereArgs);

        return count;
    }


    public void updateSyncedForms(String id) {
        SQLiteDatabase db = this.getReadableDatabase();

// New value for one column
        ContentValues values = new ContentValues();
        values.put(FormsTable.COLUMN_SYNCED, true);
        values.put(FormsTable.COLUMN_SYNCED_DATE, new Date().toString());

// Which row to update, based on the title
        String where = FormsTable._ID + " = ?";
        String[] whereArgs = {id};

        int count = db.update(
                FormsTable.TABLE_NAME,
                values,
                where,
                whereArgs);
    }


    public void updateSyncedChildForm(String id) {
        SQLiteDatabase db = this.getReadableDatabase();

// New value for one column
        ContentValues values = new ContentValues();
        values.put(ChildTable.COLUMN_SYNCED, true);
        values.put(ChildTable.COLUMN_SYNCED_DATE, new Date().toString());

// Which row to update, based on the title
        String where = ChildTable._ID + " = ?";
        String[] whereArgs = {id};

        int count = db.update(
                ChildTable.TABLE_NAME,
                values,
                where,
                whereArgs);
    }


    public void updateSyncedSerial(String id) {
        SQLiteDatabase db = this.getReadableDatabase();

// New value for one column
        ContentValues values = new ContentValues();
        values.put(singleSerial.COLUMN_SYNCED, true);
        values.put(singleSerial.COLUMN_SYNCED_DATE, new Date().toString());

// Which row to update, based on the title
        String where = singleSerial._ID + " = ?";
        String[] whereArgs = {id};

        int count = db.update(
                singleSerial.TABLE_NAME,
                values,
                where,
                whereArgs);
    }


    public int updateFormID() {
        SQLiteDatabase db = this.getReadableDatabase();

// New value for one column
        ContentValues values = new ContentValues();
        values.put(FormsTable.COLUMN_UID, MainApp.fc.getUID());

// Which row to update, based on the ID
        String selection = FormsTable._ID + " = ?";
        String[] selectionArgs = {String.valueOf(MainApp.fc.get_ID())};

        int count = db.update(FormsTable.TABLE_NAME,
                values,
                selection,
                selectionArgs);
        return count;
    }

    public int updateFamilyMemberID() {
        SQLiteDatabase db = this.getReadableDatabase();

// New value for one column
        ContentValues values = new ContentValues();
        values.put(familyMembers.COLUMN_UID, MainApp.fmc.get_UID());

// Which row to update, based on the ID
        String selection = familyMembers._ID + " = ?";
        String[] selectionArgs = {String.valueOf(MainApp.fmc.get_ID())};

        int count = db.update(familyMembers.TABLE_NAME,
                values,
                selection,
                selectionArgs);
        return count;
    }

    public int updateMWRAID() {
        SQLiteDatabase db = this.getReadableDatabase();

// New value for one column
        ContentValues values = new ContentValues();
        values.put(MWRATable.COLUMN_UID, MainApp.mc.get_UID());

// Which row to update, based on the ID
        String selection = MWRATable.COLUMN__ID + " = ?";
        String[] selectionArgs = {String.valueOf(MainApp.mc.get_ID())};

        int count = db.update(MWRATable.TABLE_NAME,
                values,
                selection,
                selectionArgs);
        return count;
    }

    public int updateOutcomeID() {
        SQLiteDatabase db = this.getReadableDatabase();

// New value for one column
        ContentValues values = new ContentValues();
        values.put(outcomeTable.COLUMN_UID, MainApp.oc.get_UID());

// Which row to update, based on the ID
        String selection = outcomeTable.COLUMN__ID + " = ?";
        String[] selectionArgs = {String.valueOf(MainApp.oc.get_ID())};

        int count = db.update(outcomeTable.TABLE_NAME,
                values,
                selection,
                selectionArgs);
        return count;
    }

    public int updateRecepientID() {
        SQLiteDatabase db = this.getReadableDatabase();

// New value for one column
        ContentValues values = new ContentValues();
        values.put(RecipientsTable.COLUMN_UID, MainApp.rc.get_UID());

// Which row to update, based on the ID
        String selection = RecipientsTable.COLUMN__ID + " = ?";
        String[] selectionArgs = {String.valueOf(MainApp.rc.get_ID())};

        int count = db.update(ChildTable.TABLE_NAME,
                values,
                selection,
                selectionArgs);
        return count;
    }

    public int updateFormChildID() {
        SQLiteDatabase db = this.getReadableDatabase();

// New value for one column
        ContentValues values = new ContentValues();
        values.put(ChildTable.COLUMN__UID, MainApp.cc.getUID());

// Which row to update, based on the ID
        String selection = ChildTable.COLUMN__ID + " = ?";
        String[] selectionArgs = {String.valueOf(MainApp.cc.get_ID())};

        int count = db.update(ChildTable.TABLE_NAME,
                values,
                selection,
                selectionArgs);
        return count;
    }


    public int updateEligibleMemberID() {
        SQLiteDatabase db = this.getReadableDatabase();

// New value for one column
        ContentValues values = new ContentValues();
        values.put(eligibleMembers.COLUMN_UID, MainApp.ec.get_UUID());

// Which row to update, based on the ID
        String selection = eligibleMembers.COLUMN__ID + " = ?";
        String[] selectionArgs = {String.valueOf(MainApp.ec.get_ID())};

        int count = db.update(eligibleMembers.TABLE_NAME,
                values,
                selection,
                selectionArgs);
        return count;
    }

    public Collection<FormsContract> getUnsyncedForms() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = {
                FormsTable._ID,
                FormsTable.COLUMN_UID,
                FormsTable.COLUMN_FORMDATE,
                FormsTable.COLUMN_USER,
                FormsTable.COLUMN_ISTATUS,
                //FormsTable.COLUMN_GPSELEV,
                FormsTable.COLUMN_SA1,
                FormsTable.COLUMN_SA4,
                FormsTable.COLUMN_SA5,
                FormsTable.COLUMN_SB4,
                FormsTable.COLUMN_GPSLAT,
                FormsTable.COLUMN_GPSLNG,
                FormsTable.COLUMN_GPSDATE,
                FormsTable.COLUMN_GPSACC,
                FormsTable.COLUMN_DEVICETAGID,
                FormsTable.COLUMN_DEVICEID,
                FormsTable.COLUMN_SYNCED,
                FormsTable.COLUMN_SYNCED_DATE,
                FormsTable.COLUMN_APP_VERSION
        };
        String whereClause = FormsTable.COLUMN_SYNCED + " is null OR " + FormsTable.COLUMN_SYNCED + " = '' ";
        String[] whereArgs = null;
        String groupBy = null;
        String having = null;

        String orderBy =
                FormsTable._ID + " ASC";

        Collection<FormsContract> allFC = new ArrayList<FormsContract>();
        try {
            c = db.query(
                    FormsTable.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                FormsContract fc = new FormsContract();
                allFC.add(fc.Hydrate(c));
            }
        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }
        return allFC;
    }


    public Collection<ChildContract> getUnsyncedChildForms() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = {
                ChildTable.COLUMN__ID,
                ChildTable.COLUMN__UID,
                ChildTable.COLUMN_FORMDATE,
                ChildTable.COLUMN_USER,
                ChildTable.COLUMN_C1SERIALNO,
                ChildTable.COLUMN_SC1,
                ChildTable.COLUMN_SC2,
                ChildTable.COLUMN_SC3,
                ChildTable.COLUMN_SC4,
                ChildTable.COLUMN_SC5,
                ChildTable.COLUMN_DEVICEID,
                ChildTable.COLUMN_DEVICETAGID,
                ChildTable.COLUMN_SYNCED,
                ChildTable.COLUMN_SYNCED_DATE,
                ChildTable.COLUMN_APPVERSION,

        };
        String whereClause = ChildContract.ChildTable.COLUMN_SYNCED + " is null OR " + ChildTable.COLUMN_SYNCED + " = '' ";
        String[] whereArgs = null;
        String groupBy = null;
        String having = null;

        String orderBy =
                ChildContract.ChildTable._ID + " ASC";

        Collection<ChildContract> allFC = new ArrayList<ChildContract>();
        try {
            c = db.query(
                    ChildTable.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                ChildContract fc = new ChildContract();
                allFC.add(fc.Hydrate(c));
            }
        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }
        return allFC;
    }


    public Collection<EligibleMembersContract> getUnsyncedEligbleMembers() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = {
                eligibleMembers.COLUMN__ID,
                eligibleMembers.COLUMN_UID,
                eligibleMembers.COLUMN_UUID,
                eligibleMembers.COLUMN_FORMDATE,
                eligibleMembers.COLUMN_DEVICEID,
                eligibleMembers.COLUMN_DEVICETAGID,
                eligibleMembers.COLUMN_USER,
                eligibleMembers.COLUMN_APPVERSION,
                eligibleMembers.COLUMN_A3SERIALNO,
                eligibleMembers.COLUMN_NAME,
                eligibleMembers.COLUMN_DOB,
                eligibleMembers.COLUMN_AGE,
                eligibleMembers.COLUMN_GENDER,
                eligibleMembers.COLUMN_SA3,
                eligibleMembers.COLUMN_SYNCED,
                eligibleMembers.COLUMN_SYNCEDDATE,

        };
        String whereClause = eligibleMembers.COLUMN_SYNCED + " is null OR " + eligibleMembers.COLUMN_SYNCED + " = '' ";
        String[] whereArgs = null;
        String groupBy = null;
        String having = null;

        String orderBy =
                eligibleMembers._ID + " ASC";

        Collection<EligibleMembersContract> allFC = new ArrayList<EligibleMembersContract>();
        try {
            c = db.query(
                    eligibleMembers.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                EligibleMembersContract fc = new EligibleMembersContract();
                allFC.add(fc.Hydrate(c));
            }
        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }
        return allFC;
    }


    public Collection<MWRAContract> getUnsyncedMWRA() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = {
                MWRATable.COLUMN__ID,
                MWRATable.COLUMN_UID,
                MWRATable.COLUMN_UUID,
                MWRATable.COLUMN_FORMDATE,
                MWRATable.COLUMN_DEVICEID,
                MWRATable.COLUMN_DEVICETAGID,
                MWRATable.COLUMN_USER,
                MWRATable.COLUMN_APP_VER,
                MWRATable.COLUMN_B1SERIALNO,
                MWRATable.COLUMN_SB1,
                MWRATable.COLUMN_SB2,
                MWRATable.COLUMN_SB4,
                MWRATable.COLUMN_SB5,
                MWRATable.COLUMN_SB6,

                MWRATable.COLUMN_SYNCED,
                MWRATable.COLUMN_SYNCEDDATE,

        };
        String whereClause = MWRATable.COLUMN_SYNCED + " is null OR " + MWRATable.COLUMN_SYNCED + " = '' ";
        String[] whereArgs = null;
        String groupBy = null;
        String having = null;

        String orderBy =
                MWRATable._ID + " ASC";

        Collection<MWRAContract> allFC = new ArrayList<MWRAContract>();
        try {
            c = db.query(
                    MWRATable.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                MWRAContract fc = new MWRAContract();
                allFC.add(fc.Hydrate(c));
            }
        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }
        return allFC;
    }


    public Collection<RecipientsContract> getUnsyncedRecipients() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = {
                RecipientsTable.COLUMN__ID,
                RecipientsTable.COLUMN_UID,
                RecipientsTable.COLUMN_UUID,
                RecipientsTable.COLUMN_FORMDATE,
                RecipientsTable.COLUMN_DEVICEID,
                RecipientsTable.COLUMN_DEVICETAGID,
                RecipientsTable.COLUMN_USER,
                RecipientsTable.COLUMN_APP_VER,
                RecipientsTable.COLUMN_A8ASNO,
                RecipientsTable.COLUMN_SA8A,

                RecipientsTable.COLUMN_SYNCED,
                RecipientsTable.COLUMN_SYNCEDDATE,

        };
        String whereClause = RecipientsTable.COLUMN_SYNCED + " is null OR " + RecipientsTable.COLUMN_SYNCED + " = '' ";
        String[] whereArgs = null;
        String groupBy = null;
        String having = null;

        String orderBy =
                RecipientsTable._ID + " ASC";

        Collection<RecipientsContract> allFC = new ArrayList<RecipientsContract>();
        try {
            c = db.query(
                    RecipientsTable.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                RecipientsContract fc = new RecipientsContract();
                allFC.add(fc.Hydrate(c));
            }
        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }
        return allFC;
    }


    public Collection<OutcomeContract> getUnsyncedOutcome() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = {
                outcomeTable.COLUMN__ID,
                outcomeTable.COLUMN_UID,
                outcomeTable.COLUMN_UUID,
                outcomeTable.COLUMN_FORMDATE,
                outcomeTable.COLUMN_DEVICEID,
                outcomeTable.COLUMN_DEVICETAGID,
                outcomeTable.COLUMN_USER,
                outcomeTable.COLUMN_APP_VER,
                outcomeTable.COLUMN_B1APregSNO,
                outcomeTable.COLUMN_SB1A,

                outcomeTable.COLUMN_SYNCED,
                outcomeTable.COLUMN_SYNCEDDATE,

        };
        String whereClause = outcomeTable.COLUMN_SYNCED + " is null OR " + outcomeTable.COLUMN_SYNCED + " = '' ";
        String[] whereArgs = null;
        String groupBy = null;
        String having = null;

        String orderBy =
                MWRATable._ID + " ASC";

        Collection<OutcomeContract> allFC = new ArrayList<OutcomeContract>();
        try {
            c = db.query(
                    outcomeTable.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                OutcomeContract fc = new OutcomeContract();
                allFC.add(fc.Hydrate(c));
            }
        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }
        return allFC;
    }


    public Collection<SerialContract> getUnsyncedSerials() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = {
                singleSerial._ID,
                singleSerial.COLUMN_DEVICE_ID,
                singleSerial.COLUMN_DATE,
                singleSerial.COLUMN_SERIAL_NO,
                singleSerial.COLUMN_SYNCED,
                singleSerial.COLUMN_SYNCED_DATE
        };

        String whereClause = null;
        String[] whereArgs = null;
        String groupBy = null;
        String having = null;

        String orderBy =
                singleSerial._ID + " ASC";

        Collection<SerialContract> allFC = new ArrayList<SerialContract>();
        try {
            c = db.query(
                    singleSerial.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                SerialContract fc = new SerialContract();
                allFC.add(fc.hydrate(c));
            }
        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }
        return allFC;
    }


    public Collection<FormsContract> getTodayForms() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = {
                FormsTable._ID,
                //ChildTable.COLUMN_DSSID,
                FormsTable.COLUMN_FORMDATE,
                FormsTable.COLUMN_ISTATUS,
                FormsTable.COLUMN_SYNCED,

        };
        String whereClause = FormsTable.COLUMN_FORMDATE + " Like ? ";
        String[] whereArgs = new String[]{"%" + spDateT.substring(0, 8).trim() + "%"};
        String groupBy = null;
        String having = null;

        String orderBy =
                FormsTable._ID + " ASC";

        Collection<FormsContract> allFC = new ArrayList<>();
        try {
            c = db.query(
                    FormsTable.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                FormsContract fc = new FormsContract();
                fc.set_ID(c.getString(c.getColumnIndex(FormsTable._ID)));
                fc.setFormDate(c.getString(c.getColumnIndex(FormsTable.COLUMN_FORMDATE)));
                fc.setIstatus(c.getString(c.getColumnIndex(FormsTable.COLUMN_ISTATUS)));
                fc.setSynced(c.getString(c.getColumnIndex(FormsTable.COLUMN_SYNCED)));
                allFC.add(fc);
            }
        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }
        return allFC;
    }

    // ANDROID DATABASE MANAGER
    public ArrayList<Cursor> getData(String Query) {
        //get writable database
        SQLiteDatabase sqlDB = this.getWritableDatabase();
        String[] columns = new String[]{"message"};
        //an array list of cursor to save two cursors one has results from the query
        //other cursor stores error message if any errors are triggered
        ArrayList<Cursor> alc = new ArrayList<Cursor>(2);
        MatrixCursor Cursor2 = new MatrixCursor(columns);
        alc.add(null);
        alc.add(null);

        try {
            String maxQuery = Query;
            //execute the query results will be save in Cursor c
            Cursor c = sqlDB.rawQuery(maxQuery, null);

            //add value to cursor2
            Cursor2.addRow(new Object[]{"Success"});

            alc.set(1, Cursor2);
            if (null != c && c.getCount() > 0) {

                alc.set(0, c);
                c.moveToFirst();

                return alc;
            }
            return alc;
        } catch (SQLException sqlEx) {
            Log.d("printing exception", sqlEx.getMessage());
            //if any exceptions are triggered save the error message to cursor an return the arraylist
            Cursor2.addRow(new Object[]{"" + sqlEx.getMessage()});
            alc.set(1, Cursor2);
            return alc;
        } catch (Exception ex) {

            Log.d("printing exception", ex.getMessage());

            //if any exceptions are triggered save the error message to cursor an return the arraylist
            Cursor2.addRow(new Object[]{"" + ex.getMessage()});
            alc.set(1, Cursor2);
            return alc;
        }
    }

    // mwra - uPDATE
    public int updateSB2() {
        SQLiteDatabase db = this.getReadableDatabase();

// New value for one column
        ContentValues values = new ContentValues();
        values.put(MWRATable.COLUMN_SB2, MainApp.mc.getsB2());

// Which row to update, based on the ID
        String selection = MWRATable._ID + " = ?";
        String[] selectionArgs = {String.valueOf(MainApp.mc.get_ID())};

        int count = db.update(MWRATable.TABLE_NAME,
                values,
                selection,
                selectionArgs);
        return count;
    }


    public int updateSB4() {
        SQLiteDatabase db = this.getReadableDatabase();

// New value for one column
        ContentValues values = new ContentValues();
        values.put(MWRATable.COLUMN_SB4, MainApp.mc.getsB4());

// Which row to update, based on the ID
        String selection = MWRATable._ID + " = ?";
        String[] selectionArgs = {String.valueOf(MainApp.mc.get_ID())};

        int count = db.update(MWRATable.TABLE_NAME,
                values,
                selection,
                selectionArgs);
        return count;
    }

    public int updateSB5() {
        SQLiteDatabase db = this.getReadableDatabase();

// New value for one column
        ContentValues values = new ContentValues();
        values.put(MWRATable.COLUMN_SB5, MainApp.mc.getsB5());

// Which row to update, based on the ID
        String selection = MWRATable._ID + " = ?";
        String[] selectionArgs = {String.valueOf(MainApp.mc.get_ID())};

        int count = db.update(MWRATable.TABLE_NAME,
                values,
                selection,
                selectionArgs);
        return count;
    }

    public int updateSB6() {
        SQLiteDatabase db = this.getReadableDatabase();

// New value for one column
        ContentValues values = new ContentValues();
        values.put(MWRATable.COLUMN_SB6, MainApp.mc.getsB6());

// Which row to update, based on the ID
        String selection = MWRATable._ID + " = ?";
        String[] selectionArgs = {String.valueOf(MainApp.mc.get_ID())};

        int count = db.update(MWRATable.TABLE_NAME,
                values,
                selection,
                selectionArgs);
        return count;
    }


    public int updateSA1() {
        SQLiteDatabase db = this.getReadableDatabase();

// New value for one column
        ContentValues values = new ContentValues();
        values.put(FormsTable.COLUMN_SA1, MainApp.fc.getsA1());

// Which row to update, based on the ID
        String selection = FormsTable._ID + " = ?";
        String[] selectionArgs = {String.valueOf(MainApp.fc.get_ID())};

        int count = db.update(FormsTable.TABLE_NAME,
                values,
                selection,
                selectionArgs);
        return count;
    }


    public int updateSA4() {
        SQLiteDatabase db = this.getReadableDatabase();

// New value for one column
        ContentValues values = new ContentValues();
        values.put(FormsTable.COLUMN_SA4, MainApp.fc.getsA4());

// Which row to update, based on the ID
        String selection = FormsTable._ID + " = ?";
        String[] selectionArgs = {String.valueOf(MainApp.fc.get_ID())};

        int count = db.update(FormsTable.TABLE_NAME,
                values,
                selection,
                selectionArgs);
        return count;
    }

    public int updateSA5() {
        SQLiteDatabase db = this.getReadableDatabase();

// New value for one column
        ContentValues values = new ContentValues();
        values.put(FormsTable.COLUMN_SA5, MainApp.fc.getsA5());

// Which row to update, based on the ID
        String selection = FormsTable._ID + " = ?";
        String[] selectionArgs = {String.valueOf(MainApp.fc.get_ID())};

        int count = db.update(FormsTable.TABLE_NAME,
                values,
                selection,
                selectionArgs);
        return count;
    }

    public int updateSC1() {
        SQLiteDatabase db = this.getReadableDatabase();

// New value for one column
        ContentValues values = new ContentValues();
        values.put(ChildTable.COLUMN_SC1, MainApp.cc.getsC1());

// Which row to update, based on the ID
        String selection = ChildTable._ID + " = ?";
        String[] selectionArgs = {String.valueOf(MainApp.cc.get_ID())};

        int count = db.update(ChildTable.TABLE_NAME,
                values,
                selection,
                selectionArgs);
        return count;
    }

    public int updateSC2() {
        SQLiteDatabase db = this.getReadableDatabase();

// New value for one column
        ContentValues values = new ContentValues();
        values.put(ChildTable.COLUMN_SC2, MainApp.cc.getsC2());

// Which row to update, based on the ID
        String selection = ChildTable._ID + " = ?";
        String[] selectionArgs = {String.valueOf(MainApp.cc.get_ID())};

        int count = db.update(ChildTable.TABLE_NAME,
                values,
                selection,
                selectionArgs);
        return count;
    }

    public int updateSC3() {
        SQLiteDatabase db = this.getReadableDatabase();

// New value for one column
        ContentValues values = new ContentValues();
        values.put(ChildTable.COLUMN_SC3, MainApp.cc.getsC3());

// Which row to update, based on the ID
        String selection = ChildTable._ID + " = ?";
        String[] selectionArgs = {String.valueOf(MainApp.cc.get_ID())};

        int count = db.update(ChildTable.TABLE_NAME,
                values,
                selection,
                selectionArgs);
        return count;
    }

    public int updateSC4() {
        SQLiteDatabase db = this.getReadableDatabase();

// New value for one column
        ContentValues values = new ContentValues();
        values.put(ChildTable.COLUMN_SC4, MainApp.cc.getsC4());

// Which row to update, based on the ID
        String selection = ChildTable._ID + " = ?";
        String[] selectionArgs = {String.valueOf(MainApp.cc.get_ID())};

        int count = db.update(ChildTable.TABLE_NAME,
                values,
                selection,
                selectionArgs);
        return count;
    }


    public int updateSC5() {
        SQLiteDatabase db = this.getReadableDatabase();

// New value for one column
        ContentValues values = new ContentValues();
        values.put(ChildTable.COLUMN_SC5, MainApp.cc.getsC5());

// Which row to update, based on the ID
        String selection = ChildTable._ID + " = ?";
        String[] selectionArgs = {String.valueOf(MainApp.cc.get_ID())};

        int count = db.update(ChildTable.TABLE_NAME,
                values,
                selection,
                selectionArgs);
        return count;
    }

    /*public int updateSB4() {
        SQLiteDatabase db = this.getReadableDatabase();

// New value for one column
        ContentValues values = new ContentValues();
        values.put(FormsTable.COLUMN_SB4, MainApp.fc.getsB4());

// Which row to update, based on the ID
        String selection = FormsTable._ID + " = ?";
        String[] selectionArgs = {String.valueOf(MainApp.fc.get_ID())};

        int count = db.update(FormsTable.TABLE_NAME,
                values,
                selection,
                selectionArgs);
        return count;
    }

*/
    public int updateCount() {
        SQLiteDatabase db = this.getReadableDatabase();

// New value for one column
        ContentValues values = new ContentValues();
        values.put(FormsTable.COLUMN_SA4, MainApp.fc.getsA4());

// Which row to update, based on the ID
        String selection = FormsTable._ID + " = ?";
        String[] selectionArgs = {String.valueOf(MainApp.fc.get_ID())};

        int count = db.update(FormsTable.TABLE_NAME,
                values,
                selection,
                selectionArgs);
        return count;
    }


    public int updateEnding() {
        SQLiteDatabase db = this.getReadableDatabase();

// New value for one column
        ContentValues values = new ContentValues();
        values.put(FormsTable.COLUMN_ISTATUS, MainApp.fc.getIstatus());
        values.put(FormsTable.COLUMN_ISTATUS88x, MainApp.fc.getIstatus88x());

// Which row to update, based on the ID
        String selection = FormsTable._ID + " =? ";
        String[] selectionArgs = {String.valueOf(MainApp.fc.get_ID())};

        int count = db.update(FormsTable.TABLE_NAME,
                values,
                selection,
                selectionArgs);
        return count;
    }

/*    public int updateMotherEnding() {
        SQLiteDatabase db = this.getReadableDatabase();

// New value for one column
        ContentValues values = new ContentValues();
        values.put(MWRATable.COLUMN_ISTATUS, MainApp.mc.getIstatus());
        values.put(MWRATable.COLUMN_ISTATUS88x, MainApp.mc.getIstatus88x());

// Which row to update, based on the ID
        String selection = MWRATable._ID + " =? ";
        String[] selectionArgs = {String.valueOf(MainApp.mc.get_ID())};

        int count = db.update(MWRATable.TABLE_NAME,
                values,
                selection,
                selectionArgs);
        return count;
    }*/

}