package edu.aku.hassannaqvi.kmc_screening.core;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import org.json.JSONArray;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import edu.aku.hassannaqvi.kmc_screening.contracts.EligibleContract;
import edu.aku.hassannaqvi.kmc_screening.contracts.EligibleContract.EligibleEntry;
import edu.aku.hassannaqvi.kmc_screening.contracts.FormsContract;
import edu.aku.hassannaqvi.kmc_screening.contracts.FormsContract.FormsTable;
import edu.aku.hassannaqvi.kmc_screening.contracts.MortalityContract;
import edu.aku.hassannaqvi.kmc_screening.contracts.MortalityContract.SingleMortality;
import edu.aku.hassannaqvi.kmc_screening.contracts.PWFollowUpContract;
import edu.aku.hassannaqvi.kmc_screening.contracts.PWFollowUpContract.PWFUPEntry;
import edu.aku.hassannaqvi.kmc_screening.contracts.PWScreenedContract;
import edu.aku.hassannaqvi.kmc_screening.contracts.PWScreenedContract.PWFScrennedEntry;
import edu.aku.hassannaqvi.kmc_screening.contracts.RecruitmentContract;
import edu.aku.hassannaqvi.kmc_screening.contracts.RecruitmentContract.RecruitmentEntry;
import edu.aku.hassannaqvi.kmc_screening.contracts.RegisteredPWContract;
import edu.aku.hassannaqvi.kmc_screening.contracts.RegisteredPWContract.RegisteredPW;
import edu.aku.hassannaqvi.kmc_screening.contracts.TalukasContract;
import edu.aku.hassannaqvi.kmc_screening.contracts.TalukasContract.SingleTaluka;
import edu.aku.hassannaqvi.kmc_screening.contracts.UCsContract;
import edu.aku.hassannaqvi.kmc_screening.contracts.UCsContract.UCsTable;
import edu.aku.hassannaqvi.kmc_screening.contracts.UsersContract;
import edu.aku.hassannaqvi.kmc_screening.contracts.UsersContract.UsersTable;
import edu.aku.hassannaqvi.kmc_screening.contracts.VillagesContract;
import edu.aku.hassannaqvi.kmc_screening.contracts.VillagesContract.SingleVillage;

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
    public static final String DATABASE_NAME = "kmc_screening.db";
    public static final String DB_NAME = DATABASE_NAME.replace(".", "_copy.");
    public static final String PROJECT_NAME = "KMC-SCREENING";
    private static final int DATABASE_VERSION = 9;
    private static final String SQL_CREATE_FORMS = "CREATE TABLE "
            + FormsTable.TABLE_NAME + "("
            + FormsTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            FormsTable.COLUMN_PROJECTNAME + " TEXT," +
            FormsTable.COLUMN_DEVICEID + " TEXT," +
            FormsTable.COLUMN_DEVICETAGID + " TEXT," +
            FormsTable.COLUMN_APPVERSION + " TEXT," +
            FormsTable.COLUMN_FORMTYPE + " TEXT," +
            FormsTable.COLUMN_SURVEYTYPE + " TEXT," +
            FormsTable.COLUMN_FORMDATE + " TEXT," +
            FormsTable.COLUMN__UID + " TEXT," +
            FormsTable.COLUMN_USER + " TEXT," +
            FormsTable.COLUMN_GPSLAT + " TEXT," +
            FormsTable.COLUMN_GPSLNG + " TEXT," +
            FormsTable.COLUMN_GPSDT + " TEXT," +
            FormsTable.COLUMN_GPSACC + " TEXT," +
            FormsTable.COLUMN_GPSALTITUDE + " TEXT," +
            FormsTable.COLUMN_PWID + " TEXT," +
            FormsTable.COLUMN_SCREENID + " TEXT," +
            FormsTable.COLUMN_TALUKA + " TEXT," +
            FormsTable.COLUMN_UC + " TEXT," +
            FormsTable.COLUMN_VILLAGE + " TEXT," +
            FormsTable.COLUMN_SINFO + " TEXT," +
            FormsTable.COLUMN_SA + " TEXT," +
            FormsTable.COLUMN_SB + " TEXT," +
            FormsTable.COLUMN_SC + " TEXT," +
            FormsTable.COLUMN_SD + " TEXT," +
            FormsTable.COLUMN_SE + " TEXT," +
            FormsTable.COLUMN_SF + " TEXT," +
            FormsTable.COLUMN_SG + " TEXT," +
            FormsTable.COLUMN_ENDINGDATETIME + " TEXT," +
            FormsTable.COLUMN_ISTATUS + " TEXT," +
            FormsTable.COLUMN_ISTATUS88X + " TEXT," +
            FormsTable.COLUMN_SYNCED + " TEXT," +
            FormsTable.COLUMN_SYNCED_DATE + " TEXT"
            + " );";

    private static final String SQL_ALTER_FORMS = "ALTER TABLE " +
            FormsTable.TABLE_NAME + " ADD COLUMN " +
            FormsTable.COLUMN_SCREENID + " TEXT;";

    private static final String SQL_ALTER_FORMS_02 = "ALTER TABLE " +
            FormsTable.TABLE_NAME + " ADD COLUMN " +
            FormsTable.COLUMN_SG + " TEXT;";

    private static final String SQL_CREATE_MWRAFOLLOWUPS = "CREATE TABLE " +
            PWFUPEntry.TABLE_NAME + "(" +
            PWFUPEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            PWFUPEntry.MWRA_UID + " TEXT," +
            PWFUPEntry.MWRA_VILLAGE + " TEXT," +
            PWFUPEntry.MWRA_REGDT + " TEXT," +
            PWFUPEntry.MWRA_ROUND + " TEXT," +
            PWFUPEntry.MWRA_FUPDT + " TEXT," +
            PWFUPEntry.MWRA_PWID + " TEXT," +
            PWFUPEntry.MWRA_WNAME + " TEXT," +
            PWFUPEntry.MWRA_HNAME + " TEXT," +
            PWFUPEntry.MWRA_KAPR07 + " TEXT," +
            PWFUPEntry.MWRA_KAPR08 + " TEXT," +
            PWFUPEntry.MWRA_HHNAME + " TEXT"
            + " );";

    private static final String SQL_CREATE_MWRA_SCREENED = "CREATE TABLE " +
            PWFScrennedEntry.TABLE_NAME + "(" +
            PWFScrennedEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            PWFScrennedEntry.COLUMN_PUID + " TEXT," +
            PWFScrennedEntry.COLUMN_VILLAGE + " TEXT," +
            PWFScrennedEntry.COLUMN_PWID + " TEXT," +
            PWFScrennedEntry.COLUMN_FORMDATE + " TEXT," +
            PWFScrennedEntry.COLUMN_PW_NAME + " TEXT," +
            PWFScrennedEntry.COLUMN_H_NAME + " TEXT," +
            PWFScrennedEntry.COLUMN_PW_CAST + " TEXT," +
            PWFScrennedEntry.COLUMN_HH_NAME + " TEXT);";

    private static final String SQL_CREATE_RECRUITMENT = "CREATE TABLE " +
            RecruitmentEntry.TABLE_NAME + "(" +
            RecruitmentEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            RecruitmentEntry.COLUMN_PUID + " TEXT," +
            RecruitmentEntry.COLUMN_VILLAGE + " TEXT," +
            RecruitmentEntry.COLUMN_FORMDATE + " TEXT," +
            RecruitmentEntry.COLUMN_M_NAME + " TEXT," +
            RecruitmentEntry.COLUMN_M_ID + " TEXT," +
            RecruitmentEntry.COLUMN_SCREEN_ID + " TEXT" +
            ");";

    private static final String SQL_CREATE_ELIGIBILES = "CREATE TABLE " +
            EligibleEntry.TABLE_NAME + "(" +
            EligibleEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            EligibleEntry.COLUMN_PUID + " TEXT," +
            EligibleEntry.COLUMN_VILLAGE + " TEXT," +
            EligibleEntry.COLUMN_FORMDATE + " TEXT," +
            EligibleEntry.COLUMN_M_NAME + " TEXT," +
            EligibleEntry.COLUMN_M_ID + " TEXT," +
            EligibleEntry.COLUMN_PART_ID + " TEXT," +
            EligibleEntry.COLUMN_SCREEN_ID + " TEXT" +
            ");";

    private static final String SQL_ALTER_ELIGIBILES = "ALTER TABLE " +
            EligibleEntry.TABLE_NAME + " ADD COLUMN " +
            EligibleEntry.COLUMN_SCREEN_ID + " TEXT;";
    private static final String SQL_DELETE_TALUKA = "DROP TABLE IF EXISTS " + SingleTaluka.TABLE_NAME;

    private static final String SQL_ALTER_PW_REGISTERED = "ALTER TABLE " +
            RegisteredPW.TABLE_NAME + " ADD COLUMN " +
            RegisteredPW.COLUMN_FORMTYPE + " TEXT;";
    private static final String SQL_ALTER_UCS = "ALTER TABLE " +
            UCsTable.TABLE_NAME + " ADD COLUMN " +
            UCsTable.COLUMN_STUDY_ARM + " TEXT;";

    final String SQL_CREATE_UC = "CREATE TABLE " + UCsTable.TABLE_NAME + " (" +
            UCsTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            UCsTable.COLUMN_UCCODE + " TEXT, " +
            UCsTable.COLUMN_UCS_NAME + " TEXT, " +
            UCsTable.COLUMN_TALUKA_CODE + " TEXT, " +
            UCsTable.COLUMN_STUDY_ARM + " TEXT " +
            ");";

    final String SQL_CREATE_REGISTERED_PW_TABLE = "CREATE TABLE " + RegisteredPW.TABLE_NAME + " (" +
            RegisteredPW._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            RegisteredPW.COLUMN_FORMTYPE + " TEXT, " +
            RegisteredPW.COLUMN_VILLAGE_CODE + " TEXT, " +
            RegisteredPW.COLUMN_PWIDS + " TEXT " +
            ");";
    private static final String SQL_DELETE_VILLAGE = "DROP TABLE IF EXISTS " + SingleVillage.TABLE_NAME;
    final String SQL_CREATE_DISTRICT_TABLE = "CREATE TABLE " + SingleTaluka.TABLE_NAME + " (" +
            SingleTaluka._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            SingleTaluka.COLUMN_DISTRICT_CODE + " TEXT, " +
            SingleTaluka.COLUMN_DISTRICT_NAME + " TEXT " +
            ");";

    private static final String SQL_DELETE_USERS = "DROP TABLE IF EXISTS " + UsersContract.UsersTable.TABLE_NAME;
    private static final String SQL_DELETE_FORMS = "DROP TABLE IF EXISTS " + FormsTable.TABLE_NAME;
    final String SQL_CREATE_PSU_TABLE = "CREATE TABLE " + SingleVillage.TABLE_NAME + " (" +
            SingleVillage._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            SingleVillage.COLUMN_VILLAGE_CODE + " TEXT, " +
            SingleVillage.COLUMN_VILLAGE_NAME + " TEXT, " +
            SingleVillage.COLUMN_DISTRICT_CODE + " TEXT, " +
            SingleVillage.COLUMN_UC_CODE + " TEXT " +
            ");";
    private static final String SQL_DELETE_UCS = "DROP TABLE IF EXISTS " + UCsTable.TABLE_NAME;
    final String SQL_CREATE_MRA_TABLE = "CREATE TABLE " + SingleMortality.TABLE_NAME + " (" +
            SingleMortality._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            SingleMortality.COLUMN__UID + " TEXT, " +
            SingleMortality.COLUMN_VILLAGE + " TEXT, " +
            SingleMortality.COLUMN_PWID + " TEXT, " +
            SingleMortality.COLUMN_SCREENDATE + " TEXT, " +
            SingleMortality.COLUMN_PW_NAME + " TEXT, " +
            SingleMortality.COLUMN_CHILD + " TEXT, " +
            SingleMortality.COLUMN_CHILDNAME + " TEXT, " +
            SingleMortality.COLUMN_SEX + " TEXT " +
            ");";
    private static final String SQL_DELETE_MWRA = "DROP TABLE IF EXISTS " + PWFUPEntry.TABLE_NAME;
    private static final String SQL_DELETE_MWRASCREENED = "DROP TABLE IF EXISTS " + PWFScrennedEntry.TABLE_NAME;
    private static final String SQL_DELETE_ELIGIBILE = "DROP TABLE IF EXISTS " + EligibleEntry.TABLE_NAME;

    private final String TAG = "DatabaseHelper";
    public String spDateT = new SimpleDateFormat("dd-MM-yy").format(new Date().getTime());

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(SQL_CREATE_USERS);
        db.execSQL(SQL_CREATE_FORMS);
        db.execSQL(SQL_CREATE_DISTRICT_TABLE);
        db.execSQL(SQL_CREATE_UC);
        db.execSQL(SQL_CREATE_PSU_TABLE);
        db.execSQL(SQL_CREATE_MRA_TABLE);
        db.execSQL(SQL_CREATE_MWRAFOLLOWUPS);
        db.execSQL(SQL_CREATE_MWRA_SCREENED);
        db.execSQL(SQL_CREATE_ELIGIBILES);
        db.execSQL(SQL_CREATE_RECRUITMENT);
        db.execSQL(SQL_CREATE_REGISTERED_PW_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        /*db.execSQL(SQL_DELETE_USERS);
        db.execSQL(SQL_DELETE_FORMS);
        db.execSQL(SQL_DELETE_TALUKA);
        db.execSQL(SQL_DELETE_UCS);
        db.execSQL(SQL_DELETE_VILLAGE);
        db.execSQL(SQL_DELETE_MWRA);
        db.execSQL(SQL_DELETE_MWRASCREENED);*/

        switch (i) {
            case 1:
                db.execSQL(SQL_CREATE_ELIGIBILES);
            case 2:
                db.execSQL(SQL_ALTER_ELIGIBILES);
            case 3:
                db.execSQL(SQL_ALTER_FORMS);
            case 4:
                db.execSQL(SQL_ALTER_UCS);
                db.execSQL(SQL_CREATE_RECRUITMENT);
            case 5:
                db.execSQL(SQL_CREATE_REGISTERED_PW_TABLE);
            case 6:
            case 7:
                db.execSQL(SQL_ALTER_FORMS_02);
            case 8:
                db.execSQL(SQL_CREATE_MRA_TABLE);
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
                values.put(UCsTable.COLUMN_STUDY_ARM, Vc.getStudy_arm());

                db.insert(UCsTable.TABLE_NAME, null, values);
            }
        } catch (Exception e) {
        } finally {
            db.close();
        }
    }

    public Collection<TalukasContract> getAllDistricts() {

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = {
                SingleTaluka._ID,
                SingleTaluka.COLUMN_DISTRICT_CODE,
                SingleTaluka.COLUMN_DISTRICT_NAME
        };

        String whereClause = null;
        String[] whereArgs = null;
        String groupBy = null;
        String having = null;

        String orderBy =
                SingleTaluka.COLUMN_DISTRICT_NAME + " ASC";

        Collection<TalukasContract> allDC = new ArrayList<TalukasContract>();
        try {
            c = db.query(
                    SingleTaluka.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                TalukasContract dc = new TalukasContract();
                allDC.add(dc.hydrate(c));
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
                UCsTable.COLUMN_TALUKA_CODE,
                UCsTable.COLUMN_STUDY_ARM,
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

    public Collection<VillagesContract> getAllPSUsByDistrict(String district_code, String uc_code) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = {
                SingleVillage._ID,
                SingleVillage.COLUMN_VILLAGE_CODE,
                SingleVillage.COLUMN_VILLAGE_NAME,
                SingleVillage.COLUMN_DISTRICT_CODE,
                SingleVillage.COLUMN_UC_CODE
        };

        String whereClause = SingleVillage.COLUMN_DISTRICT_CODE + " =? AND " + SingleVillage.COLUMN_UC_CODE + " =?";

        String[] whereArgs = {district_code, uc_code};
        String groupBy = null;
        String having = null;

        String orderBy =
                SingleVillage.COLUMN_VILLAGE_NAME + " ASC";

        Collection<VillagesContract> allPC = new ArrayList<VillagesContract>();
        try {
            c = db.query(
                    SingleVillage.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                VillagesContract pc = new VillagesContract();
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

    public List<MortalityContract> getMortalityByVillage(String village_code, String pwid) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = {
                SingleMortality.COLUMN__UID,
                SingleMortality.COLUMN_VILLAGE,
                SingleMortality.COLUMN_PWID,
                SingleMortality.COLUMN_SCREENDATE,
                SingleMortality.COLUMN_PW_NAME,
                SingleMortality.COLUMN_CHILD,
                SingleMortality.COLUMN_CHILDNAME,
                SingleMortality.COLUMN_SEX
        };

        String whereClause = SingleMortality.COLUMN_VILLAGE + " =? AND " + SingleMortality.COLUMN_PWID + " =?";

        String[] whereArgs = {village_code, pwid};
        String groupBy = null;
        String having = null;

        String orderBy = SingleMortality.COLUMN_VILLAGE + " ASC";

        List<MortalityContract> allPC = new ArrayList<>();
        try {
            c = db.query(
                    SingleMortality.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                allPC.add(new MortalityContract().hydrate(c));
            }
        } finally {
            if (c != null) {
                c.close();
            }
            if (db != null) {
                db.close();
            }
        }
        return allPC.size() == 0 ? null : allPC;
    }

    public Collection<PWFollowUpContract> getPW(String villageCode, String hhno) {

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = {
                PWFUPEntry.MWRA_UID,
                PWFUPEntry.MWRA_VILLAGE,
                PWFUPEntry.MWRA_ROUND,
                PWFUPEntry.MWRA_FUPDT,
                PWFUPEntry.MWRA_PWID,
                PWFUPEntry.MWRA_HNAME,
                PWFUPEntry.MWRA_WNAME,
                PWFUPEntry.MWRA_KAPR07,
                PWFUPEntry.MWRA_KAPR08,
                PWFUPEntry.MWRA_REGDT,
                PWFUPEntry.MWRA_HHNAME
        };

        String whereClause = PWFUPEntry.MWRA_VILLAGE + " =? AND " + PWFUPEntry.MWRA_PWID + " =?";
        String[] whereArgs = {villageCode, hhno};
        String groupBy = null;
        String having = null;

        String orderBy = PWFUPEntry.MWRA_PWID + " ASC";

        Collection<PWFollowUpContract> allEB = new ArrayList<>();

        try {
            c = db.query(
                    PWFUPEntry.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                PWFollowUpContract mwra = new PWFollowUpContract();
                allEB.add(mwra.hydrate(c));
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

    public RegisteredPWContract checkPWExist(String formType, String villageCode, String pwid) {

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = {
                RegisteredPW.COLUMN_PWIDS,
                RegisteredPW.COLUMN_VILLAGE_CODE,
                RegisteredPW.COLUMN_FORMTYPE,
        };

        String whereClause = RegisteredPW.COLUMN_FORMTYPE + "=? AND " + RegisteredPW.COLUMN_VILLAGE_CODE + " =? AND " + RegisteredPW.COLUMN_PWIDS + " LIKE ?";
        String[] whereArgs = {formType, villageCode, "%" + pwid + ",%"};
        String groupBy = null;
        String having = null;

        String orderBy = RegisteredPW._ID + " ASC";

        RegisteredPWContract allEB = null;
        try {
            c = db.query(
                    RegisteredPW.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                allEB = new RegisteredPWContract().hydrate(c);
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

    public FormsContract checkPWExistDB(String villageCode, String hhno) {

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = {
                FormsTable.COLUMN__ID,
                FormsTable.COLUMN_PWID,
                FormsTable.COLUMN_VILLAGE,
                FormsTable.COLUMN_SINFO
        };

        String whereClause = FormsTable.COLUMN_VILLAGE + " =? AND " + FormsTable.COLUMN_PWID + " =?";
        String[] whereArgs = {villageCode, hhno};
        String groupBy = null;
        String having = null;

        String orderBy = FormsTable.COLUMN__ID + " ASC";

        FormsContract allEB = null;
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
                allEB = new FormsContract().Hydrate(c, 1);
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

    public FormsContract checkPWExistDB(String villageCode, String hhno, String round) {

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = {
                FormsTable.COLUMN__ID,
                FormsTable.COLUMN_PWID,
                FormsTable.COLUMN_VILLAGE,
                FormsTable.COLUMN_SINFO
        };

        String whereClause = FormsTable.COLUMN_VILLAGE + " =? AND " + FormsTable.COLUMN_PWID + " =?";
        String[] whereArgs = {villageCode, hhno};
        String groupBy = null;
        String having = null;

        String orderBy = FormsTable.COLUMN__ID + " ASC";

        FormsContract allEB = null;
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
                FormsContract formItem = new FormsContract().Hydrate(c, 1);
                if (FormsContract.checkingEligibility(formItem.getsInfo(), round)) {
                    allEB = formItem;
                    break;
                }
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

    public PWScreenedContract getPWScreened(String villageCode, String hhno) {

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = {
                PWFScrennedEntry.COLUMN_PUID,
                PWFScrennedEntry.COLUMN_VILLAGE,
                PWFScrennedEntry.COLUMN_PWID,
                PWFScrennedEntry.COLUMN_FORMDATE,
                PWFScrennedEntry.COLUMN_PW_NAME,
                PWFScrennedEntry.COLUMN_H_NAME,
                PWFScrennedEntry.COLUMN_PW_CAST,
                PWFScrennedEntry.COLUMN_HH_NAME,
        };

        String whereClause = PWFScrennedEntry.COLUMN_VILLAGE + " =? AND " + PWFScrennedEntry.COLUMN_PWID + " =?";
        String[] whereArgs = {villageCode, hhno};
        String groupBy = null;
        String having = null;

        String orderBy = PWFScrennedEntry.COLUMN_PWID + " ASC";

        PWScreenedContract allEB = null;

        try {
            c = db.query(
                    PWFScrennedEntry.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                allEB = new PWScreenedContract().hydrate(c);
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

    public PWScreenedContract getPWScreened(String sType, String villageCode, String pwid) {

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = {
                FormsTable.COLUMN__UID,
                FormsTable.COLUMN_VILLAGE,
                FormsTable.COLUMN_FORMDATE,
                FormsTable.COLUMN_PWID,
                FormsTable.COLUMN_SINFO
        };

        String whereClause = FormsTable.COLUMN_VILLAGE + " =? AND " + FormsTable.COLUMN_PWID + " =? AND " + FormsTable.COLUMN_SURVEYTYPE + "=? AND " + FormsTable.COLUMN_ISTATUS + "=?";
        String[] whereArgs = {villageCode, pwid, sType, "1"};
        String groupBy = null;
        String having = null;

        String orderBy = FormsTable.COLUMN_PWID + " ASC";

        PWScreenedContract allEB = null;

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
                allEB = new PWScreenedContract().hydrateForm(c);
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

    public Collection<EligibleContract> getEligibileParticipant(String villageCode, String hhno) {

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = {
                EligibleEntry.COLUMN_PUID,
                EligibleEntry.COLUMN_VILLAGE,
                EligibleEntry.COLUMN_M_NAME,
                EligibleEntry.COLUMN_FORMDATE,
                EligibleEntry.COLUMN_M_ID,
                EligibleEntry.COLUMN_PART_ID,
                EligibleEntry.COLUMN_SCREEN_ID,
        };

        String whereClause = EligibleEntry.COLUMN_VILLAGE + " =? AND " + EligibleEntry.COLUMN_M_ID + " =?";
        String[] whereArgs = {villageCode, hhno};
        String groupBy = null;
        String having = null;

        String orderBy = EligibleEntry.COLUMN_M_ID + " ASC";

        Collection<EligibleContract> allEB = new ArrayList<>();

        try {
            c = db.query(
                    EligibleEntry.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                allEB.add(new EligibleContract().hydrate(c));
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

    public Collection<?> getRecruitmentParticipant(String villageCode, String hhno) {

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = {
                RecruitmentEntry.COLUMN_PUID,
                RecruitmentEntry.COLUMN_VILLAGE,
                RecruitmentEntry.COLUMN_M_NAME,
                RecruitmentEntry.COLUMN_FORMDATE,
                RecruitmentEntry.COLUMN_M_ID,
                RecruitmentEntry.COLUMN_SCREEN_ID,
        };

        String whereClause = RecruitmentEntry.COLUMN_VILLAGE + " =? AND " + RecruitmentEntry.COLUMN_M_ID + " =?";
        String[] whereArgs = {villageCode, hhno};
        String groupBy = null;
        String having = null;

        String orderBy = RecruitmentEntry.COLUMN_M_ID + " ASC";

        Collection<RecruitmentContract> allEB = new ArrayList<>();

        try {
            c = db.query(
                    RecruitmentEntry.TABLE_NAME,  // The table to query
                    columns,                   // The columns to return
                    whereClause,               // The columns for the WHERE clause
                    whereArgs,                 // The values for the WHERE clause
                    groupBy,                   // don't group the rows
                    having,                    // don't filter by row groups
                    orderBy                    // The sort order
            );
            while (c.moveToNext()) {
                allEB.add(new RecruitmentContract().hydrate(c));
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

    public Collection<EligibleContract> getEligibleParticipantFromPDADB(String villageCode, String hhno, String fType) {

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = {
                FormsTable.COLUMN__UID,
                FormsTable.COLUMN_VILLAGE,
                FormsTable.COLUMN_FORMDATE,
                FormsTable.COLUMN_PWID,
                FormsTable.COLUMN_SINFO,
                FormsTable.COLUMN_SA,
                FormsTable.COLUMN_FORMTYPE,
        };

        String whereClause = FormsTable.COLUMN_FORMTYPE + " =? AND " + FormsTable.COLUMN_VILLAGE + " =? AND " + FormsTable.COLUMN_PWID + " =? AND " + FormsTable.COLUMN_ISTATUS + " =?";
        String[] whereArgs = {fType, villageCode, hhno, "1"};
        String groupBy = null;
        String having = null;

        String orderBy = FormsTable.COLUMN_PWID + " ASC";

        Collection<EligibleContract> allEB = new ArrayList<>();

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
                if (fType.equals("kf1"))
                    if (!EligibleContract.checkingEligibility(c)) continue;
                allEB.add(new EligibleContract().hydrate2(c, fType.equals("kf1")));
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
         //   Log.d(TAG, "syncUser(e): " + e);
        } finally {
            db.close();
        }
    }

    public void syncTalukas(JSONArray talukalist) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(SingleTaluka.TABLE_NAME, null, null);
        try {
            JSONArray jsonArray = talukalist;
            for (int i = 0; i < jsonArray.length(); i++) {

                JSONObject jsonObjectUser = jsonArray.getJSONObject(i);

                TalukasContract user = new TalukasContract();
                user.sync(jsonObjectUser);
                ContentValues values = new ContentValues();

                values.put(SingleTaluka.COLUMN_DISTRICT_CODE, user.getDistrictCode());
                values.put(SingleTaluka.COLUMN_DISTRICT_NAME, user.getDistrictName());
                db.insert(SingleTaluka.TABLE_NAME, null, values);
            }

        } catch (Exception e) {
            //  Log.d(TAG, "syncTalukas(e): " + e);
        } finally {
            db.close();
        }
    }

    public void deleteRegisteredPW() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(RegisteredPW.TABLE_NAME, null, null);
    }

    public void syncRegisteredPW(String formType, JSONArray registeredPWlist) {
        SQLiteDatabase db = this.getWritableDatabase();
//        db.delete(RegisteredPW.TABLE_NAME, null, null);
        try {
            JSONArray jsonArray = registeredPWlist;
            for (int i = 0; i < jsonArray.length(); i++) {

                JSONObject jsonObjectUser = jsonArray.getJSONObject(i);

                RegisteredPWContract user = new RegisteredPWContract();
                user.sync(jsonObjectUser);
                ContentValues values = new ContentValues();

                values.put(RegisteredPW.COLUMN_VILLAGE_CODE, user.getVillageCode());
                values.put(RegisteredPW.COLUMN_PWIDS, user.getPwids());
                values.put(RegisteredPW.COLUMN_FORMTYPE, formType);
                db.insert(RegisteredPW.TABLE_NAME, null, values);
            }

        } catch (Exception e) {
            //    Log.d(TAG, "syncRegisteredPW(e): " + e);
        } finally {
            db.close();
        }
    }

    public void syncPWS(JSONArray pcList) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(PWFUPEntry.TABLE_NAME, null, null);

        try {
            JSONArray jsonArray = pcList;

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObjectPSU = jsonArray.getJSONObject(i);

                PWFollowUpContract vc = new PWFollowUpContract();
                vc.sync(jsonObjectPSU);
                //        Log.i(TAG, "PWs: " + jsonObjectPSU.toString());

                ContentValues values = new ContentValues();

                values.put(PWFUPEntry.MWRA_UID, vc.getUid());
                values.put(PWFUPEntry.MWRA_VILLAGE, vc.getVillage());
                values.put(PWFUPEntry.MWRA_REGDT, vc.getRegdt());
                values.put(PWFUPEntry.MWRA_ROUND, vc.getRound());
                values.put(PWFUPEntry.MWRA_FUPDT, vc.getFupdt());
                values.put(PWFUPEntry.MWRA_PWID, vc.getPwid());
                values.put(PWFUPEntry.MWRA_HNAME, vc.getHname());
                values.put(PWFUPEntry.MWRA_WNAME, vc.getWname());
                values.put(PWFUPEntry.MWRA_KAPR07, vc.getKapr07());
                values.put(PWFUPEntry.MWRA_KAPR08, vc.getKapr08());
                values.put(PWFUPEntry.MWRA_HHNAME, vc.getHhname());

                db.insert(PWFUPEntry.TABLE_NAME, null, values);
            }
            db.close();

        } catch (Exception e) {
            //    Log.d(TAG, "syncPWS: " + e.getMessage());
        }
    }

    public void syncPWSScreened(JSONArray pcList) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(PWFScrennedEntry.TABLE_NAME, null, null);

        try {
            JSONArray jsonArray = pcList;

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObjectPSU = jsonArray.getJSONObject(i);

                PWScreenedContract spw = new PWScreenedContract();
                spw.sync(jsonObjectPSU);
                //           Log.i(TAG, "PWScreened: " + jsonObjectPSU.toString());

                ContentValues values = new ContentValues();

                values.put(PWFScrennedEntry.COLUMN_PUID, spw.getPuid());
                values.put(PWFScrennedEntry.COLUMN_VILLAGE, spw.getVillage());
                values.put(PWFScrennedEntry.COLUMN_PWID, spw.getPwid());
                values.put(PWFScrennedEntry.COLUMN_FORMDATE, spw.getFormdate());
                values.put(PWFScrennedEntry.COLUMN_PW_NAME, spw.getPw_name());
                values.put(PWFScrennedEntry.COLUMN_H_NAME, spw.getH_name());
                values.put(PWFScrennedEntry.COLUMN_PW_CAST, spw.getCast());
                values.put(PWFScrennedEntry.COLUMN_HH_NAME, spw.getHh_name());

                db.insert(PWFScrennedEntry.TABLE_NAME, null, values);
            }
            db.close();

        } catch (Exception e) {
            //     Log.d(TAG, "syncPWScreened: " + e.getMessage());
        }
    }

    public void syncEligibiles(JSONArray eliList) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(EligibleEntry.TABLE_NAME, null, null);

        try {
            JSONArray jsonArray = eliList;

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObjectPSU = jsonArray.getJSONObject(i);

                EligibleContract epw = new EligibleContract();
                epw.sync(jsonObjectPSU);
                //         Log.i(TAG, "Eligibiles: " + jsonObjectPSU.toString());

                ContentValues values = new ContentValues();

                values.put(EligibleEntry.COLUMN_PUID, epw.getPuid());
                values.put(EligibleEntry.COLUMN_VILLAGE, epw.getVillage());
                values.put(EligibleEntry.COLUMN_FORMDATE, epw.getFormdate());
                values.put(EligibleEntry.COLUMN_M_NAME, epw.getM_name());
                values.put(EligibleEntry.COLUMN_M_ID, epw.getM_id());
                values.put(EligibleEntry.COLUMN_PART_ID, epw.getPart_id());
                values.put(EligibleEntry.COLUMN_SCREEN_ID, epw.getScreen_id());

                db.insert(EligibleEntry.TABLE_NAME, null, values);
            }
            db.close();

        } catch (Exception e) {
            //      Log.d(TAG, "syncEligibiles: " + e.getMessage());
        }
    }

    public void syncRecruitments(JSONArray eliList) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(RecruitmentEntry.TABLE_NAME, null, null);

        try {
            JSONArray jsonArray = eliList;

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObjectPSU = jsonArray.getJSONObject(i);

                RecruitmentContract epw = new RecruitmentContract();
                epw.sync(jsonObjectPSU);
                //          Log.i(TAG, "Rrecruitment" + jsonObjectPSU.toString());

                ContentValues values = new ContentValues();

                values.put(RecruitmentEntry.COLUMN_PUID, epw.getPuid());
                values.put(RecruitmentEntry.COLUMN_VILLAGE, epw.getVillage());
                values.put(RecruitmentEntry.COLUMN_FORMDATE, epw.getFormdate());
                values.put(RecruitmentEntry.COLUMN_M_NAME, epw.getM_name());
                values.put(RecruitmentEntry.COLUMN_M_ID, epw.getM_id());
                values.put(RecruitmentEntry.COLUMN_SCREEN_ID, epw.getScreen_id());

                db.insert(RecruitmentEntry.TABLE_NAME, null, values);
            }
            db.close();

        } catch (Exception e) {
            //        Log.d(TAG, "syncRrecruitment" + e.getMessage());
        }
    }

    public void syncVillages(JSONArray pcList) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(SingleVillage.TABLE_NAME, null, null);

        try {
            JSONArray jsonArray = pcList;

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObjectPSU = jsonArray.getJSONObject(i);

                VillagesContract vc = new VillagesContract();
                vc.sync(jsonObjectPSU);
                //        Log.i(TAG, "syncVillages: " + jsonObjectPSU.toString());

                ContentValues values = new ContentValues();

                values.put(SingleVillage.COLUMN_UC_CODE, vc.getUcCode());
                values.put(SingleVillage.COLUMN_VILLAGE_CODE, vc.getVillageCode());
                values.put(SingleVillage.COLUMN_VILLAGE_NAME, vc.getVillageName());
                values.put(SingleVillage.COLUMN_DISTRICT_CODE, vc.getDistrictCode());

                db.insert(SingleVillage.TABLE_NAME, null, values);
            }
            db.close();

        } catch (Exception e) {

        }
    }

    public void syncMortality(JSONArray pcList) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(SingleMortality.TABLE_NAME, null, null);

        try {

            for (int i = 0; i < pcList.length(); i++) {
                JSONObject jsonObjectPSU = pcList.getJSONObject(i);

                MortalityContract vc = new MortalityContract();
                vc.sync(jsonObjectPSU);
                //       Log.i(TAG, "syncMortality: " + jsonObjectPSU.toString());

                ContentValues values = new ContentValues();

                values.put(SingleMortality.COLUMN__UID, vc.getUID());
                values.put(SingleMortality.COLUMN_VILLAGE, vc.getvillage());
                values.put(SingleMortality.COLUMN_PWID, vc.getpwid());
                values.put(SingleMortality.COLUMN_SCREENDATE, vc.getscreendate());
                values.put(SingleMortality.COLUMN_PW_NAME, vc.getpw_name());
                values.put(SingleMortality.COLUMN_CHILD, vc.getchild());
                values.put(SingleMortality.COLUMN_CHILDNAME, vc.getchildname());
                values.put(SingleMortality.COLUMN_SEX, vc.getsex());

                db.insert(SingleMortality.TABLE_NAME, null, values);
            }
            db.close();

        } catch (Exception e) {

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

    public Long addForm(FormsContract fc) {

        // Gets the data repository in write mode
        SQLiteDatabase db = this.getWritableDatabase();

// Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(FormsTable.COLUMN_PROJECTNAME, fc.getProjectName());
        values.put(FormsTable.COLUMN_SURVEYTYPE, fc.getSurveyType());
        values.put(FormsTable.COLUMN__UID, fc.getUID());
        values.put(FormsTable.COLUMN_FORMDATE, fc.getFormDate());
        values.put(FormsTable.COLUMN_USER, fc.getUser());
        values.put(FormsTable.COLUMN_ISTATUS, fc.getIstatus());
        values.put(FormsTable.COLUMN_ISTATUS88X, fc.getIstatus88x());
        values.put(FormsTable.COLUMN_SINFO, fc.getsInfo());
        values.put(FormsTable.COLUMN_SA, fc.getsA());
        values.put(FormsTable.COLUMN_SB, fc.getsB());
        values.put(FormsTable.COLUMN_FORMTYPE, fc.getFormType());
        values.put(FormsTable.COLUMN_SC, fc.getsC());
        values.put(FormsTable.COLUMN_SD, fc.getsD());
        values.put(FormsTable.COLUMN_SE, fc.getsE());
        values.put(FormsTable.COLUMN_SF, fc.getsF());
        values.put(FormsTable.COLUMN_SG, fc.getsG());
        values.put(FormsTable.COLUMN_ENDINGDATETIME, fc.getEndingdatetime());
        values.put(FormsTable.COLUMN_GPSLAT, fc.getGpsLat());
        values.put(FormsTable.COLUMN_GPSLNG, fc.getGpsLng());
        values.put(FormsTable.COLUMN_GPSDT, fc.getGpsDT());
        values.put(FormsTable.COLUMN_GPSACC, fc.getGpsAcc());
        values.put(FormsTable.COLUMN_GPSALTITUDE, fc.getGpsAltitude());
        values.put(FormsTable.COLUMN_DEVICEID, fc.getDeviceID());
        values.put(FormsTable.COLUMN_DEVICETAGID, fc.getDevicetagID());
        values.put(FormsTable.COLUMN_SYNCED, fc.getSynced());
        values.put(FormsTable.COLUMN_SYNCED_DATE, fc.getSynced_date());
        values.put(FormsTable.COLUMN_APPVERSION, fc.getAppversion());
        values.put(FormsTable.COLUMN_PWID, fc.getPwid());
        values.put(FormsTable.COLUMN_SCREENID, fc.getScreenid());
        values.put(FormsTable.COLUMN_UC, fc.getUc());
        values.put(FormsTable.COLUMN_TALUKA, fc.getTaluka());
        values.put(FormsTable.COLUMN_VILLAGE, fc.getVillage());


        // Insert the new row, returning the primary key value of the new row
        long newRowId;
        newRowId = db.insert(
                FormsTable.TABLE_NAME,
                FormsTable.COLUMN_NAME_NULLABLE,
                values);
        return newRowId;
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

    public int updateFormID() {
        SQLiteDatabase db = this.getReadableDatabase();

// New value for one column
        ContentValues values = new ContentValues();
        values.put(FormsTable.COLUMN__UID, MainApp.fc.getUID());

// Which row to update, based on the ID
        String selection = FormsTable.COLUMN__ID + " = ?";
        String[] selectionArgs = {String.valueOf(MainApp.fc.get_ID())};

        int count = db.update(FormsTable.TABLE_NAME,
                values,
                selection,
                selectionArgs);
        return count;
    }

    public FormsContract getFormExistance(String villageCode, String formType, String pwid, String screenid, String followUpNo) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = {
                FormsTable._ID,
                FormsTable.COLUMN_PROJECTNAME,
                FormsTable.COLUMN_SURVEYTYPE,
                FormsTable.COLUMN__UID,
                FormsTable.COLUMN_FORMDATE,
                FormsTable.COLUMN_USER,
                FormsTable.COLUMN_SCREENID,
                FormsTable.COLUMN_ISTATUS,
                FormsTable.COLUMN_ISTATUS88X,
                FormsTable.COLUMN_SINFO,
                FormsTable.COLUMN_SA,
                FormsTable.COLUMN_SB,
                FormsTable.COLUMN_FORMTYPE,
                FormsTable.COLUMN_SC,
                FormsTable.COLUMN_SD,
                FormsTable.COLUMN_SE,
                FormsTable.COLUMN_SF,
                FormsTable.COLUMN_SG,
                FormsTable.COLUMN_ENDINGDATETIME,
                FormsTable.COLUMN_GPSLAT,
                FormsTable.COLUMN_GPSLNG,
                FormsTable.COLUMN_GPSDT,
                FormsTable.COLUMN_GPSACC,
                FormsTable.COLUMN_GPSALTITUDE,
                FormsTable.COLUMN_DEVICEID,
                FormsTable.COLUMN_DEVICETAGID,
                FormsTable.COLUMN_SYNCED,
                FormsTable.COLUMN_SYNCED_DATE,
                FormsTable.COLUMN_APPVERSION,
                FormsTable.COLUMN_PWID,
                FormsTable.COLUMN_UC,
                FormsTable.COLUMN_VILLAGE,
                FormsTable.COLUMN_TALUKA,

        };
        String whereClause = FormsTable.COLUMN_VILLAGE + " =? AND " + FormsTable.COLUMN_FORMTYPE + " =? AND " + FormsTable.COLUMN_PWID + " =? AND " + FormsTable.COLUMN_SCREENID + " =? AND " + FormsTable.COLUMN_ISTATUS + " =?";
        String[] whereArgs = {villageCode, formType, pwid, screenid, "1"};
        String groupBy = null;
        String having = null;

        String orderBy = FormsTable.COLUMN__ID + " ASC";

        FormsContract allFC = null;
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
                allFC = new FormsContract().Hydrate(c, 0);

                if (formType.equals("kf3")) {
                    if (FormsContract.checkingEligibility(allFC.getsInfo(), allFC.getsB(), followUpNo)) {
                        break;
                    } else
                        allFC = null;
                }

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

    public Collection<FormsContract> getUnsyncedForms(String formType) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = {
                FormsTable._ID,
                FormsTable.COLUMN_PROJECTNAME,
                FormsTable.COLUMN_SURVEYTYPE,
                FormsTable.COLUMN__UID,
                FormsTable.COLUMN_FORMDATE,
                FormsTable.COLUMN_USER,
                FormsTable.COLUMN_SCREENID,
                FormsTable.COLUMN_ISTATUS,
                FormsTable.COLUMN_ISTATUS88X,
                FormsTable.COLUMN_SINFO,
                FormsTable.COLUMN_SA,
                FormsTable.COLUMN_SB,
                FormsTable.COLUMN_FORMTYPE,
                FormsTable.COLUMN_SC,
                FormsTable.COLUMN_SD,
                FormsTable.COLUMN_SE,
                FormsTable.COLUMN_SF,
                FormsTable.COLUMN_SG,
                FormsTable.COLUMN_ENDINGDATETIME,
                FormsTable.COLUMN_GPSLAT,
                FormsTable.COLUMN_GPSLNG,
                FormsTable.COLUMN_GPSDT,
                FormsTable.COLUMN_GPSACC,
                FormsTable.COLUMN_GPSALTITUDE,
                FormsTable.COLUMN_DEVICEID,
                FormsTable.COLUMN_DEVICETAGID,
                FormsTable.COLUMN_SYNCED,
                FormsTable.COLUMN_SYNCED_DATE,
                FormsTable.COLUMN_APPVERSION,
                FormsTable.COLUMN_PWID,
                FormsTable.COLUMN_UC,
                FormsTable.COLUMN_VILLAGE,
                FormsTable.COLUMN_TALUKA,

        };
        String whereClause =
                FormsTable.COLUMN_FORMTYPE +
                        " =? AND (" +
                        FormsTable.COLUMN_SYNCED +
                        " is null OR " +
                        FormsTable.COLUMN_SYNCED + " = '') ";
        String[] whereArgs = {formType};
        String groupBy = null;
        String having = null;

        String orderBy =
                FormsTable.COLUMN__ID + " ASC";

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
                allFC.add(fc.Hydrate(c, 0));
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

    public Collection<FormsContract> getUnsyncedForms0(String formType, String surveyType) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = null;
        String[] columns = {
                FormsTable._ID,
                FormsTable.COLUMN_PROJECTNAME,
                FormsTable.COLUMN_SURVEYTYPE,
                FormsTable.COLUMN__UID,
                FormsTable.COLUMN_FORMDATE,
                FormsTable.COLUMN_USER,
                FormsTable.COLUMN_SCREENID,
                FormsTable.COLUMN_ISTATUS,
                FormsTable.COLUMN_ISTATUS88X,
                FormsTable.COLUMN_SINFO,
                FormsTable.COLUMN_SA,
                FormsTable.COLUMN_SB,
                FormsTable.COLUMN_FORMTYPE,
                FormsTable.COLUMN_SC,
                FormsTable.COLUMN_SD,
                FormsTable.COLUMN_SE,
                FormsTable.COLUMN_SF,
                FormsTable.COLUMN_SG,
                FormsTable.COLUMN_ENDINGDATETIME,
                FormsTable.COLUMN_GPSLAT,
                FormsTable.COLUMN_GPSLNG,
                FormsTable.COLUMN_GPSDT,
                FormsTable.COLUMN_GPSACC,
                FormsTable.COLUMN_GPSALTITUDE,
                FormsTable.COLUMN_DEVICEID,
                FormsTable.COLUMN_DEVICETAGID,
                FormsTable.COLUMN_SYNCED,
                FormsTable.COLUMN_SYNCED_DATE,
                FormsTable.COLUMN_APPVERSION,
                FormsTable.COLUMN_PWID,
                FormsTable.COLUMN_UC,
                FormsTable.COLUMN_VILLAGE,
                FormsTable.COLUMN_TALUKA,

        };
        String whereClause =
                FormsTable.COLUMN_FORMTYPE +
                        " =? AND " +
                        FormsTable.COLUMN_SURVEYTYPE +
                        " =? AND (" +
                        FormsTable.COLUMN_SYNCED +
                        " is null OR " +
                        FormsTable.COLUMN_SYNCED + " = '') ";
        String[] whereArgs = {formType, surveyType};
        String groupBy = null;
        String having = null;

        String orderBy =
                FormsTable.COLUMN__ID + " ASC";

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
                allFC.add(fc.Hydrate(c, 0));
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
            //          Log.d("printing exception", sqlEx.getMessage());
            //if any exceptions are triggered save the error message to cursor an return the arraylist
            Cursor2.addRow(new Object[]{"" + sqlEx.getMessage()});
            alc.set(1, Cursor2);
            return alc;
        } catch (Exception ex) {

            //      Log.d("printing exception", ex.getMessage());

            //if any exceptions are triggered save the error message to cursor an return the arraylist
            Cursor2.addRow(new Object[]{"" + ex.getMessage()});
            alc.set(1, Cursor2);
            return alc;
        }
    }

    public int updateSA() {
        SQLiteDatabase db = this.getReadableDatabase();

// New value for one column
        ContentValues values = new ContentValues();
        values.put(FormsTable.COLUMN_SA, MainApp.fc.getsA());

// Which row to update, based on the ID
        String selection = FormsTable._ID + " = ?";
        String[] selectionArgs = {String.valueOf(MainApp.fc.get_ID())};

        int count = db.update(FormsTable.TABLE_NAME,
                values,
                selection,
                selectionArgs);
        return count;
    }

    public int updateSB() {
        SQLiteDatabase db = this.getReadableDatabase();

// New value for one column
        ContentValues values = new ContentValues();
        values.put(FormsTable.COLUMN_SB, MainApp.fc.getsB());

// Which row to update, based on the ID
        String selection = FormsTable._ID + " = ?";
        String[] selectionArgs = {String.valueOf(MainApp.fc.get_ID())};

        int count = db.update(FormsTable.TABLE_NAME,
                values,
                selection,
                selectionArgs);
        return count;
    }

    public int updateSC() {
        SQLiteDatabase db = this.getReadableDatabase();

// New value for one column
        ContentValues values = new ContentValues();
        values.put(FormsTable.COLUMN_SC, MainApp.fc.getsC());

// Which row to update, based on the ID
        String selection = FormsTable._ID + " = ?";
        String[] selectionArgs = {String.valueOf(MainApp.fc.get_ID())};

        int count = db.update(FormsTable.TABLE_NAME,
                values,
                selection,
                selectionArgs);
        return count;
    }

    public int updateSD() {
        SQLiteDatabase db = this.getReadableDatabase();

// New value for one column
        ContentValues values = new ContentValues();
        values.put(FormsTable.COLUMN_SD, MainApp.fc.getsD());

// Which row to update, based on the ID
        String selection = FormsTable._ID + " = ?";
        String[] selectionArgs = {String.valueOf(MainApp.fc.get_ID())};

        int count = db.update(FormsTable.TABLE_NAME,
                values,
                selection,
                selectionArgs);
        return count;
    }

    public int updateSE() {
        SQLiteDatabase db = this.getReadableDatabase();

// New value for one column
        ContentValues values = new ContentValues();
        values.put(FormsTable.COLUMN_SE, MainApp.fc.getsE());

// Which row to update, based on the ID
        String selection = FormsTable._ID + " = ?";
        String[] selectionArgs = {String.valueOf(MainApp.fc.get_ID())};

        int count = db.update(FormsTable.TABLE_NAME,
                values,
                selection,
                selectionArgs);
        return count;
    }

    public int updateSF() {
        SQLiteDatabase db = this.getReadableDatabase();

// New value for one column
        ContentValues values = new ContentValues();
        values.put(FormsTable.COLUMN_SF, MainApp.fc.getsF());

// Which row to update, based on the ID
        String selection = FormsTable._ID + " = ?";
        String[] selectionArgs = {String.valueOf(MainApp.fc.get_ID())};

        int count = db.update(FormsTable.TABLE_NAME,
                values,
                selection,
                selectionArgs);
        return count;
    }

    public int updateSG() {
        SQLiteDatabase db = this.getReadableDatabase();

// New value for one column
        ContentValues values = new ContentValues();
        values.put(FormsTable.COLUMN_SG, MainApp.fc.getsG());

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
        values.put(FormsTable.COLUMN_ISTATUS88X, MainApp.fc.getIstatus88x());
        values.put(FormsTable.COLUMN_ENDINGDATETIME, MainApp.fc.getEndingdatetime());

// Which row to update, based on the ID
        String selection = FormsTable._ID + " =? ";
        String[] selectionArgs = {String.valueOf(MainApp.fc.get_ID())};

        int count = db.update(FormsTable.TABLE_NAME,
                values,
                selection,
                selectionArgs);
        return count;
    }
}