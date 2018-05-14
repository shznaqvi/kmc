package edu.aku.hassannaqvi.kmc.contracts;

import android.database.Cursor;
import android.provider.BaseColumns;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by hassan.naqvi on 11/30/2016.
 */

public class FormsContract {

    private final String projectName = "KMC";
    //private final String surveyType = "SN";
    private String _ID = "";
    private String _UID = "";
    private String formDate = ""; // Date
    private String user = ""; // Interviewer


    private String istatus = ""; // Interview Status
    private String istatus88x = ""; // Interview Status

    private String sInfo = "";    // Info Section
    private String sA1 = "";
    private String sB1 = "";
    private String sB2 = "";
    private String sA4 = ""; // sA4
    private String sA5 = ""; //
    private String sB4 = "";
    private String sD0 = "";
    private String sD1 = "";
    private String sD2 = "";
    private String sD3 = "";
    private String sE = "";
    private String count = "";


    private String gpsLat = "";
    private String gpsLng = "";
    private String gpsDT = "";
    private String gpsAcc = "";
    private String gpsElev = "";
    private String deviceID = "";
    private String devicetagID = "";
    private String synced = "";
    private String synced_date = "";
    private String appversion;

    public FormsContract() {
    }


    public FormsContract Sync(JSONObject jsonObject) throws JSONException {
        this._ID = jsonObject.getString(FormsTable._ID);
        this._UID = jsonObject.getString(FormsTable.COLUMN_UID);
        this.formDate = jsonObject.getString(FormsTable.COLUMN_FORMDATE);
        this.user = jsonObject.getString(FormsTable.COLUMN_USER);
        this.istatus = jsonObject.getString(FormsTable.COLUMN_ISTATUS);
        this.istatus88x = jsonObject.getString(FormsTable.COLUMN_ISTATUS);
        this.gpsElev = jsonObject.getString(FormsTable.COLUMN_GPSELEV);
        this.sInfo = jsonObject.getString(FormsTable.COLUMN_SINFO);
        this.sA1 = jsonObject.getString(FormsTable.COLUMN_SA1);
        this.sB1 = jsonObject.getString(FormsTable.COLUMN_SB1);
        this.sB2 = jsonObject.getString(FormsTable.COLUMN_SB2);

        this.sA4 = jsonObject.getString(FormsTable.COLUMN_SA4);
        this.sA5 = jsonObject.getString(FormsTable.COLUMN_SA5);
        this.sB4 = jsonObject.getString(FormsTable.COLUMN_SB4);
        this.sD0 = jsonObject.getString(FormsTable.COLUMN_SD0);
        this.sD1 = jsonObject.getString(FormsTable.COLUMN_SD1);
        this.sD2 = jsonObject.getString(FormsTable.COLUMN_SD2);
        this.sD3 = jsonObject.getString(FormsTable.COLUMN_SD3);

        this.sE = jsonObject.getString(FormsTable.COLUMN_SE);
        this.count = jsonObject.getString(FormsTable.COLUMN_COUNT);
        this.gpsLat = jsonObject.getString(FormsTable.COLUMN_GPSLAT);
        this.gpsLng = jsonObject.getString(FormsTable.COLUMN_GPSLNG);
        this.gpsDT = jsonObject.getString(FormsTable.COLUMN_GPSDATE);
        this.gpsAcc = jsonObject.getString(FormsTable.COLUMN_GPSACC);
        this.deviceID = jsonObject.getString(FormsTable.COLUMN_DEVICEID);
        this.devicetagID = jsonObject.getString(FormsTable.COLUMN_DEVICETAGID);
        this.synced = jsonObject.getString(FormsTable.COLUMN_SYNCED);
        this.synced_date = jsonObject.getString(FormsTable.COLUMN_SYNCED_DATE);
        this.appversion = jsonObject.getString(FormsTable.COLUMN_APP_VERSION);

        return this;

    }

    public FormsContract Hydrate(Cursor cursor) {
        this._ID = cursor.getString(cursor.getColumnIndex(FormsTable._ID));
        this._UID = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_UID));
        this.formDate = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_FORMDATE));
        this.user = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_USER));
        this.istatus = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_ISTATUS));
        this.istatus88x = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_ISTATUS));
        this.gpsElev = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_GPSELEV));

        this.sInfo = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_SINFO));
        this.sA1 = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_SA1));

        this.sB1 = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_SB1));
        this.sB2 = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_SB2));


        this.sA4 = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_SA4));
        this.sA5 = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_SA5));
        this.sB4 = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_SB4));
        this.sD0 = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_SD0));
        this.sD1 = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_SD1));
        this.sD2 = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_SD2));
        this.sD3 = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_SD3));

        this.sE = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_SE));
        this.count = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_COUNT));
        this.gpsLat = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_GPSLAT));
        this.gpsLng = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_GPSLNG));
        this.gpsDT = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_GPSDATE));
        this.gpsAcc = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_GPSACC));
        this.deviceID = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_DEVICEID));
        this.devicetagID = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_DEVICETAGID));
        this.synced = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_SYNCED));
        this.synced_date = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_SYNCED_DATE));
        this.appversion = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_APP_VERSION));

        // TODO:

        return this;

    }


    public JSONObject toJSONObject() throws JSONException {

        JSONObject json = new JSONObject();

        json.put(FormsTable._ID, this._ID == null ? JSONObject.NULL : this._ID);
        json.put(FormsTable.COLUMN_UID, this._UID == null ? JSONObject.NULL : this._UID);
        json.put(FormsTable.COLUMN_FORMDATE, this.formDate == null ? JSONObject.NULL : this.formDate);
        json.put(FormsTable.COLUMN_USER, this.user == null ? JSONObject.NULL : this.user);
        json.put(FormsTable.COLUMN_ISTATUS, this.istatus == null ? JSONObject.NULL : this.istatus);
        json.put(FormsTable.COLUMN_ISTATUS88x, this.istatus88x == null ? JSONObject.NULL : this.istatus88x);
        json.put(FormsTable.COLUMN_GPSELEV, this.gpsElev == null ? JSONObject.NULL : this.gpsElev);


        if (!this.sInfo.equals("")) {
            json.put(FormsTable.COLUMN_SINFO, this.sInfo.equals("") ? JSONObject.NULL : new JSONObject(this.sInfo));
        }


        if (!this.sA1.equals("")) {

            json.put(FormsTable.COLUMN_SA1, this.sA1.equals("") ? JSONObject.NULL : new JSONObject(this.sA1));
        }


        if (!this.sB1.equals("")) {

            json.put(FormsTable.COLUMN_SB1, this.sB1.equals("") ? JSONObject.NULL : new JSONObject(this.sB1));
        }


        if (!this.sB2.equals("")) {

            json.put(FormsTable.COLUMN_SB2, this.sB2.equals("") ? JSONObject.NULL : new JSONObject(this.sB2));
        }


        if (!this.count.equals("")) {

            json.put(FormsTable.COLUMN_COUNT, this.count.equals("") ? JSONObject.NULL : new JSONObject(this.count));
        }


        /*if (!this.sA4.equals("")) {

            json.put(FormsTable.COLUMN_SA3, this.sA4.equals("") ? JSONObject.NULL : new JSONObject(this.sA4));
        }
        if (!this.sA5.equals("")) {

            json.put(FormsTable.COLUMN_SA5, this.sA5.equals("") ? JSONObject.NULL : new JSONObject(this.sA5));
        }
        if (!this.sB4.equals("")) {

            json.put(FormsTable.COLUMN_SB4, this.sB4.equals("") ? JSONObject.NULL : new JSONObject(this.sB4));
        }*/
        if (!this.sD0.equals("")) {
            json.put(FormsTable.COLUMN_SD0, this.sD0 == null ? JSONObject.NULL : new JSONObject(this.sD0));
        }
        if (!this.sD1.equals("")) {

            json.put(FormsTable.COLUMN_SD1, this.sD1 == null ? JSONObject.NULL : new JSONObject(this.sD1));
        }
        if (!this.sD2.equals("")) {

            json.put(FormsTable.COLUMN_SD2, this.sD2 == null ? JSONObject.NULL : new JSONObject(this.sD2));
        }
        if (!this.sD3.equals("")) {

            json.put(FormsTable.COLUMN_SD3, this.sD3 == null ? JSONObject.NULL : new JSONObject(this.sD3));
        }

        if (!this.sE.equals("")) {

            json.put(FormsTable.COLUMN_SE, this.sE.equals("") ? JSONObject.NULL : new JSONObject(this.sE));
        }


        json.put(FormsTable.COLUMN_GPSLAT, this.gpsLat == null ? JSONObject.NULL : this.gpsLat);
        json.put(FormsTable.COLUMN_GPSLNG, this.gpsLng == null ? JSONObject.NULL : this.gpsLng);
        json.put(FormsTable.COLUMN_GPSDATE, this.gpsDT == null ? JSONObject.NULL : this.gpsDT);
        json.put(FormsTable.COLUMN_GPSACC, this.gpsAcc == null ? JSONObject.NULL : this.gpsAcc);
        json.put(FormsTable.COLUMN_DEVICEID, this.deviceID == null ? JSONObject.NULL : this.deviceID);
        json.put(FormsTable.COLUMN_DEVICETAGID, this.devicetagID == null ? JSONObject.NULL : this.devicetagID);
        json.put(FormsTable.COLUMN_SYNCED, this.synced == null ? JSONObject.NULL : this.synced);
        json.put(FormsTable.COLUMN_SYNCED_DATE, this.synced_date == null ? JSONObject.NULL : this.synced_date);
        json.put(FormsTable.COLUMN_APP_VERSION, this.appversion == null ? JSONObject.NULL : this.appversion);


        return json;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getProjectName() {
        return projectName;
    }

    public String get_ID() {
        return _ID;
    }

    public void set_ID(String _ID) {
        this._ID = _ID;
    }

    public String getUID() {
        return _UID;
    }

    public void setUID(String _UID) {
        this._UID = _UID;
    }

    public String getFormDate() {
        return formDate;
    }

    public void setFormDate(String formDate) {
        this.formDate = formDate;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getIstatus() {
        return istatus;
    }

    public void setIstatus(String istatus) {
        this.istatus = istatus;
    }


    public String getIstatus88x() {
        return istatus88x;
    }

    public void setIstatus88x(String istatus88x) {
        this.istatus88x = istatus88x;
    }


    public String getsInfo() {
        return sInfo;
    }

    public void setsInfo(String sInfo) {
        this.sInfo = sInfo;
    }


    public String getsA1() {
        return sA1;
    }

    public void setsA1(String sA1) {
        this.sA1 = sA1;
    }


    public String getsB2() {
        return sB2;
    }

    public void setsB2(String sB2) {
        this.sB2 = sB2;
    }


    public String getsB1() {
        return sB1;
    }

    public void setsB1(String sB1) {
        this.sB1 = sB1;
    }


    public String getGpsElev() {
        return gpsElev;
    }

    public void setGpsElev(String gpsElev) {
        this.gpsElev = gpsElev;
    }

    public String getsB4() {
        return sB4;
    }

    public void setsB4(String sB4) {
        this.sB4 = sB4;
    }

    public String getsD0() {
        return sD0;
    }

    public void setsD0(String sD0) {
        this.sD0 = sD0;
    }

    public String getsD1() {
        return sD1;
    }

    public void setsD1(String sD1) {
        this.sD1 = sD1;
    }

    public String getsD2() {
        return sD2;
    }

    public void setsD2(String sD2) {
        this.sD2 = sD2;
    }

    public String getsD3() {
        return sD3;
    }

    public void setsD3(String sD3) {
        this.sD3 = sD3;
    }

    public String getsE() {
        return sE;
    }

    public void setsE(String sE) {
        this.sE = sE;
    }


    public String getsA4() {
        return sA4;
    }

    public void setsA4(String sA4) {
        this.sA4 = sA4;
    }

    public String getsA5() {

        return sA5;
    }

    public void setsA5(String sA5) {
        this.sA5 = sA5;
    }

    public String getGpsLat() {
        return gpsLat;
    }

    public void setGpsLat(String gpsLat) {
        this.gpsLat = gpsLat;
    }

    public String getGpsLng() {
        return gpsLng;
    }

    public void setGpsLng(String gpsLng) {
        this.gpsLng = gpsLng;
    }

    public String getGpsDT() {
        return gpsDT;
    }

    public void setGpsDT(String gpsDT) {
        this.gpsDT = gpsDT;
    }

    public String getGpsAcc() {
        return gpsAcc;
    }

    public void setGpsAcc(String gpsAcc) {
        this.gpsAcc = gpsAcc;
    }

    public String getDeviceID() {
        return deviceID;
    }

    public void setDeviceID(String deviceID) {
        this.deviceID = deviceID;
    }

    public String getDevicetagID() {
        return devicetagID;
    }

    public void setDevicetagID(String devicetagID) {
        this.devicetagID = devicetagID;
    }

    public String getSynced() {
        return synced;
    }

    public void setSynced(String synced) {
        this.synced = synced;
    }

    public String getSynced_date() {
        return synced_date;
    }

    public void setSynced_date(String synced_date) {
        this.synced_date = synced_date;
    }

    public String getAppversion() {
        return appversion;
    }

    public void setAppversion(String appversion) {
        this.appversion = appversion;
    }

    public static abstract class FormsTable implements BaseColumns {

        public static final String TABLE_NAME = "forms";
        public static final String COLUMN_NAME_NULLABLE = "NULLHACK";
        public static final String COLUMN_PROJECT_NAME = "projectname";
        public static final String _ID = "_id";
        public static final String COLUMN_UID = "_uid";
        public static final String COLUMN_FORMDATE = "formdate";
        public static final String COLUMN_USER = "user";
        public static final String COLUMN_ISTATUS = "istatus";
        public static final String COLUMN_ISTATUS88x = "istatus88x";

        public static final String COLUMN_SINFO = "sinfo";
        public static final String COLUMN_SA1 = "sa1";
        public static final String COLUMN_SB1 = "sb1";
        public static final String COLUMN_SB2 = "sb2";
        public static final String COLUMN_SA4 = "sa4";
        public static final String COLUMN_SA5 = "sa5";
        public static final String COLUMN_SB4 = "sb4";
        public static final String COLUMN_SD0 = "sd0";
        public static final String COLUMN_SD1 = "sd1";
        public static final String COLUMN_SD2 = "sd2 ";
        public static final String COLUMN_SD3 = "sd3";

        public static final String COLUMN_SE = "se";
        public static final String COLUMN_COUNT = "count";

        public static final String COLUMN_GPSLAT = "gpslat";
        public static final String COLUMN_GPSLNG = "gpslng";
        public static final String COLUMN_GPSDATE = "gpsdate";
        public static final String COLUMN_GPSACC = "gpsacc";
        public static final String COLUMN_GPSELEV = "gpselev";
        public static final String COLUMN_DEVICEID = "deviceid";
        public static final String COLUMN_DEVICETAGID = "tagid";
        public static final String COLUMN_SYNCED = "synced";
        public static final String COLUMN_SYNCED_DATE = "synced_date";
        public static final String COLUMN_APP_VERSION = "appversion";

        public static String _URL = "forms.php";
    }
}