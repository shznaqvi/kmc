package edu.aku.hassannaqvi.kmc_validate_app.contracts;

import android.database.Cursor;
import android.net.Uri;
import android.provider.BaseColumns;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by hassan.naqvi on 11/30/2016.
 */

public class FormsContract {

    private String projectName = "KMC_Validation_app";
    private String surveyType = "BL";
    private String _ID = "";
    private String _UID = "";
    private String formDate = ""; // Date
    private String user = ""; // Interviewer
    private String istatus = ""; // Interview Status
    private String istatus88x = ""; // Interview Status
    private String sa1 = "";
    private String sa2 = "";
    private String sa3 = "";
    private String sb1 = "";
    private String sb2 = "";
    private String sb3 = "";
    private String sb3_pnc = "";
    private String sb4 = "";
    private String sb4_2 = "";
    private String sb4_3 = "";
    private String sb4_4 = "";
    private String sb4_5 = "";
    private String sc = "";
    private String endingdatetime = "";
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

    public static final String CONTENT_AUTHORITY = "edu.aku.hassannaqvi.kmc.provider";
    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);

    public static final String PATH_FORMS = "forms";

    public static final Uri URI_TABLE = Uri.parse(BASE_CONTENT_URI.toString() + "/" + PATH_FORMS);

    public static final String[] TOP_LEVEL_PATHS = {PATH_FORMS};

    public FormsContract() {
    }


    public FormsContract Sync(JSONObject jsonObject) throws JSONException {
        this.projectName = jsonObject.getString(FormsTable.COLUMN_PROJECTNAME);
        this.surveyType = jsonObject.getString(FormsTable.COLUMN_SURVEYTYPE);
        this._ID = jsonObject.getString(FormsTable.COLUMN__ID);
        this._UID = jsonObject.getString(FormsTable.COLUMN__UID);
        this.formDate = jsonObject.getString(FormsTable.COLUMN_FORMDATE);
        this.user = jsonObject.getString(FormsTable.COLUMN_USER);
        this.istatus = jsonObject.getString(FormsTable.COLUMN_ISTATUS);
        this.istatus88x = jsonObject.getString(FormsTable.COLUMN_ISTATUS88X);
        this.sa1= jsonObject.getString(FormsTable.COLUMN_SA1);
        this.sa2= jsonObject.getString(FormsTable.COLUMN_SA2);
        this.sa3= jsonObject.getString(FormsTable.COLUMN_SA3);
        this.sb1= jsonObject.getString(FormsTable.COLUMN_SB1);
        this.sb2= jsonObject.getString(FormsTable.COLUMN_SB2);
        this.sb3= jsonObject.getString(FormsTable.COLUMN_SB3);
        this.sb3_pnc= jsonObject.getString(FormsTable.COLUMN_SB3_PNC);
        this.sb4= jsonObject.getString(FormsTable.COLUMN_SB4);
        this.sb4_2= jsonObject.getString(FormsTable.COLUMN_SB4_2);
        this.sb4_3= jsonObject.getString(FormsTable.COLUMN_SB4_3);
        this.sb4_4= jsonObject.getString(FormsTable.COLUMN_SB4_4);
        this.sb4_5= jsonObject.getString(FormsTable.COLUMN_SB4_5);
        this.sc= jsonObject.getString(FormsTable.COLUMN_SC);

        this.endingdatetime = jsonObject.getString(FormsTable.COLUMN_ENDINGDATETIME);
        this.gpsLat = jsonObject.getString(FormsTable.COLUMN_GPSLAT);
        this.gpsLng = jsonObject.getString(FormsTable.COLUMN_GPSLNG);
        this.gpsDT = jsonObject.getString(FormsTable.COLUMN_GPSDT);
        this.gpsAcc = jsonObject.getString(FormsTable.COLUMN_GPSACC);
        this.gpsElev = jsonObject.getString(FormsTable.COLUMN_GPSELEV);
        this.deviceID = jsonObject.getString(FormsTable.COLUMN_DEVICEID);
        this.devicetagID = jsonObject.getString(FormsTable.COLUMN_DEVICETAGID);
        this.synced = jsonObject.getString(FormsTable.COLUMN_SYNCED);
        this.synced_date = jsonObject.getString(FormsTable.COLUMN_SYNCED_DATE);
        this.appversion = jsonObject.getString(FormsTable.COLUMN_APPVERSION);


        return this;

    }

    public FormsContract Hydrate(Cursor cursor) {
        this.projectName = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_PROJECTNAME));
        this.surveyType = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_SURVEYTYPE));
        this._ID = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN__ID));
        this._UID = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN__UID));
        this.formDate = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_FORMDATE));
        this.user = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_USER));
        this.istatus = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_ISTATUS));
        this.istatus88x = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_ISTATUS88X));
        this.sa1 = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_SA1));
        this.sa2 = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_SA2));
        this.sa3 = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_SA3));
        this.sb1 = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_SB1));
        this.sb2 = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_SB2));
        this.sb3 = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_SB3));
        this.sb3_pnc = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_SB3_PNC));
        this.sb4 = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_SB4));
        this.sb4_2 = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_SB4_2));
        this.sb4_3 = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_SB4_3));
        this.sb4_4 = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_SB4_4));
        this.sb4_5 = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_SB4_5));
        this.sc = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_SC));

        this.endingdatetime = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_ENDINGDATETIME));
        this.gpsLat = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_GPSLAT));
        this.gpsLng = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_GPSLNG));
        this.gpsDT = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_GPSDT));
        this.gpsAcc = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_GPSACC));
        this.gpsElev = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_GPSELEV));
        this.deviceID = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_DEVICEID));
        this.devicetagID = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_DEVICETAGID));
        this.synced = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_SYNCED));
        this.synced_date = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_SYNCED_DATE));
        this.appversion = cursor.getString(cursor.getColumnIndex(FormsTable.COLUMN_APPVERSION));


        return this;

    }


    public JSONObject toJSONObject() throws JSONException {

        JSONObject json = new JSONObject();

        json.put(FormsTable.COLUMN_PROJECTNAME, this.projectName == null ? JSONObject.NULL : this.projectName);
        json.put(FormsTable.COLUMN_SURVEYTYPE, this.surveyType == null ? JSONObject.NULL : this.surveyType);
        json.put(FormsTable.COLUMN__ID, this._ID == null ? JSONObject.NULL : this._ID);
        json.put(FormsTable.COLUMN__UID, this._UID == null ? JSONObject.NULL : this._UID);
        json.put(FormsTable.COLUMN_FORMDATE, this.formDate == null ? JSONObject.NULL : this.formDate);
        json.put(FormsTable.COLUMN_USER, this.user == null ? JSONObject.NULL : this.user);
        json.put(FormsTable.COLUMN_ISTATUS, this.istatus == null ? JSONObject.NULL : this.istatus);
        json.put(FormsTable.COLUMN_ISTATUS88X, this.istatus88x == null ? JSONObject.NULL : this.istatus88x);
        json.put(FormsTable.COLUMN_ENDINGDATETIME, this.endingdatetime == null ? JSONObject.NULL : this.endingdatetime);


   /*     json.put(FormsTable.COLUMN_SA1, this.sa1 == null ? JSONObject.NULL : this.sa1);
        json.put(FormsTable.COLUMN_SA2, this.sa2 == null ? JSONObject.NULL : this.sa2);
        json.put(FormsTable.COLUMN_SA3, this.sa3 == null ? JSONObject.NULL : this.sa3);
        json.put(FormsTable.COLUMN_SB1, this.sb1 == null ? JSONObject.NULL : this.sb1);
        json.put(FormsTable.COLUMN_SB2, this.sb2 == null ? JSONObject.NULL : this.sb2);
        json.put(FormsTable.COLUMN_SB3, this.sb3 == null ? JSONObject.NULL : this.sb3);
        json.put(FormsTable.COLUMN_SB3_PNC, this.sb3_pnc == null ? JSONObject.NULL : this.sb3_pnc);
        json.put(FormsTable.COLUMN_SB4, this.sb4 == null ? JSONObject.NULL : this.sb4);
        json.put(FormsTable.COLUMN_SB4_2, this.sb4_2 == null ? JSONObject.NULL : this.sb4_2);
        json.put(FormsTable.COLUMN_SB4_3, this.sb4_3 == null ? JSONObject.NULL : this.sb4_3);
        json.put(FormsTable.COLUMN_SB4_4, this.sb4_4 == null ? JSONObject.NULL : this.sb4_4);
        json.put(FormsTable.COLUMN_SB4_5, this.sb4_5 == null ? JSONObject.NULL : this.sb4_5);
        json.put(FormsTable.COLUMN_SC, this.sc == null ? JSONObject.NULL : this.sc);*/

        if (!this.sa1.equals("")) {
            json.put(FormsTable.COLUMN_SA1, this.sa1.equals("") ? JSONObject.NULL : new JSONObject(this.sa1));
        }
        if (!this.sa2.equals("")) {
            json.put(FormsTable.COLUMN_SA2, this.sa2.equals("") ? JSONObject.NULL : new JSONObject(this.sa2));
        }
        if (!this.sa3.equals("")) {
            json.put(FormsTable.COLUMN_SA3, this.sa3.equals("") ? JSONObject.NULL : new JSONObject(this.sa3));
        }
        if (!this.sb1.equals("")) {
            json.put(FormsTable.COLUMN_SB1, this.sb1.equals("") ? JSONObject.NULL : new JSONObject(this.sb1));
        }
        if (!this.sb2.equals("")) {
            json.put(FormsTable.COLUMN_SB2, this.sb2.equals("") ? JSONObject.NULL : new JSONObject(this.sb2));
        }
        if (!this.sb3.equals("")) {
            json.put(FormsTable.COLUMN_SB3, this.sb3.equals("") ? JSONObject.NULL : new JSONObject(this.sb3));
        }
        if (!this.sb3_pnc.equals("")) {
            json.put(FormsTable.COLUMN_SB3_PNC, this.sb3_pnc.equals("") ? JSONObject.NULL : new JSONObject(this.sb3_pnc));
        }
        if (!this.sb4.equals("")) {
            json.put(FormsTable.COLUMN_SB4, this.sb4.equals("") ? JSONObject.NULL : new JSONObject(this.sb4));
        }
        if (!this.sb4_2.equals("")) {
            json.put(FormsTable.COLUMN_SB4_2, this.sb4_2.equals("") ? JSONObject.NULL : new JSONObject(this.sb4_2));
        }

        if (!this.sb4_3.equals("")) {
            json.put(FormsTable.COLUMN_SB4_3, this.sb4_3.equals("") ? JSONObject.NULL : new JSONObject(this.sb4_3));
        }

        if (!this.sb4_4.equals("")) {
            json.put(FormsTable.COLUMN_SB4_4, this.sb4_4.equals("") ? JSONObject.NULL : new JSONObject(this.sb4_4));
        }

        if (!this.sb4_5.equals("")) {
            json.put(FormsTable.COLUMN_SB4_5, this.sb4_5.equals("") ? JSONObject.NULL : new JSONObject(this.sb4_5));
        }
        if (!this.sc.equals("")) {
            json.put(FormsTable.COLUMN_SC, this.sc.equals("") ? JSONObject.NULL : new JSONObject(this.sc));
        }

        json.put(FormsTable.COLUMN_GPSLAT, this.gpsLat == null ? JSONObject.NULL : this.gpsLat);
        json.put(FormsTable.COLUMN_GPSLNG, this.gpsLng == null ? JSONObject.NULL : this.gpsLng);
        json.put(FormsTable.COLUMN_GPSDT, this.gpsDT == null ? JSONObject.NULL : this.gpsDT);
        json.put(FormsTable.COLUMN_GPSACC, this.gpsAcc == null ? JSONObject.NULL : this.gpsAcc);
        json.put(FormsTable.COLUMN_GPSELEV, this.gpsElev == null ? JSONObject.NULL : this.gpsElev);
        json.put(FormsTable.COLUMN_DEVICEID, this.deviceID == null ? JSONObject.NULL : this.deviceID);
        json.put(FormsTable.COLUMN_DEVICETAGID, this.devicetagID == null ? JSONObject.NULL : this.devicetagID);
        json.put(FormsTable.COLUMN_SYNCED, this.synced == null ? JSONObject.NULL : this.synced);
        json.put(FormsTable.COLUMN_SYNCED_DATE, this.synced_date == null ? JSONObject.NULL : this.synced_date);
        json.put(FormsTable.COLUMN_APPVERSION, this.appversion == null ? JSONObject.NULL : this.appversion);

        return json;
    }

    public String getEndingdatetime() {
        return endingdatetime;
    }

    public void setEndingdatetime(String endingdatetime) {
        this.endingdatetime = endingdatetime;
    }


    public String getProjectName() {
        return projectName;
    }

    public String getSurveyType() {
        return surveyType;
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

    public String getsa1() {
        return sa1;
    }

    public void setsa1(String sa1) {
        this.sa1 = sa1;
    }

    public String getsa2() {
        return sa2;
    }

    public void setsa2(String sa2) {
        this.sa2 = sa2;
    }

    public String getsa3() {
        return sa3;
    }

    public void setsa3(String sa3) {
        this.sa3 = sa3;
    }

    public String getsb1() {
        return sb1;
    }

    public void setsb1(String sb1) {
        this.sb1 = sb1;
    }

    public String getsb2() {
        return sb2;
    }

    public void setsb2(String sb2) {
        this.sb2 = sb2;
    }

    public String getsb3() {
        return sb3;
    }

    public void setsb3(String sb3) {
        this.sb3 = sb3;
    }

    public String getsb3_pnc() {
        return sb3_pnc;
    }

    public void setsb3_pnc(String sb3_pnc) {
        this.sb3_pnc = sb3_pnc;
    }

    public String getsb4() {
        return sb4;
    }

    public void setsb4(String sb4) {
        this.sb4 = sb4;
    }

    public String getsb4_2() {
        return sb4_2;
    }

    public void setsb4_2(String sb4_2) {
        this.sb4_2 = sb4_2;
    }

    public String getsb4_3() {
        return sb4_3;
    }

    public void setsb4_3(String sb4_3) {
        this.sb4_3 = sb4_3;
    }

    public String getsb4_4() {
        return sb4_4;
    }

    public void setsb4_4(String sb4_4) {
        this.sb4_4 = sb4_4;
    }

    public String getsb4_5() {
        return sb4_5;
    }

    public void setsb4_5(String sb4_5) {
        this.sb4_5 = sb4_5;
    }

    public String getsc() {
        return sc;
    }

    public void setsc(String sc) {
        this.sc = sc;
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


    public String getGpsElev() {
        return gpsElev;
    }

    public void setGpsElev(String gpsElev) {
        this.gpsElev = gpsElev;
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
        public static final String COLUMN_PROJECTNAME = "projectname";
        public static final String COLUMN_SURVEYTYPE = "surveytype";
        public static final String COLUMN__ID = "_id";
        public static final String COLUMN__UID = "_uid";
        public static final String COLUMN_FORMDATE = "formdate";
        public static final String COLUMN_USER = "user";
        public static final String COLUMN_ISTATUS = "istatus";
        public static final String COLUMN_ISTATUS88X = "istatus88x";
        public static final String COLUMN_SA1 = "sa1";
        public static final String COLUMN_SA2 = "sa2";
        public static final String COLUMN_SA3 = "sa3";
        public static final String COLUMN_SB1 = "sb1";
        public static final String COLUMN_SB2 = "sb2";
        public static final String COLUMN_SB3 = "sb3";
        public static final String COLUMN_SB3_PNC = "sb3_pnc";
        public static final String COLUMN_SB4 = "sb4";
        public static final String COLUMN_SB4_2 = "sb4_2";
        public static final String COLUMN_SB4_3 = "sb4_3";
        public static final String COLUMN_SB4_4 = "sb4_4";
        public static final String COLUMN_SB4_5 = "sb4_5";
        public static final String COLUMN_SC = "sc";
        public static final String COLUMN_ENDINGDATETIME = "endingdatetime";
        public static final String COLUMN_GPSLAT = "gpslat";
        public static final String COLUMN_GPSLNG = "gpslng";
        public static final String COLUMN_GPSDT = "gpsdt";
        public static final String COLUMN_GPSACC = "gpsacc";
        public static final String COLUMN_GPSELEV = "gpselev";
        public static final String COLUMN_DEVICEID = "deviceid";
        public static final String COLUMN_DEVICETAGID = "devicetagid";
        public static final String COLUMN_SYNCED = "synced";
        public static final String COLUMN_SYNCED_DATE = "synced_date";
        public static final String COLUMN_APPVERSION = "appversion";

        public static String _URL = "forms.php";

        public static final Uri CONTENT_URI = BASE_CONTENT_URI.buildUpon().appendEncodedPath(PATH_FORMS).build();

        // Accessing content directory and item
        public static final String CONTENT_TYPE = "vnd.android.cursor.dir/vnd." + CONTENT_AUTHORITY + ".forms";
        public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/vnd." + CONTENT_AUTHORITY + ".forms";

        public static Uri buildFormsUri(String id) {
            return CONTENT_URI.buildUpon().appendEncodedPath(id).build();
        }

        public static String getFormsID(Uri uri) {
            return uri.getPathSegments().get(1);
        }
    }
}