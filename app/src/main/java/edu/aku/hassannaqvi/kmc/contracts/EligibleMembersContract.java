package edu.aku.hassannaqvi.kmc.contracts;

import android.database.Cursor;
import android.provider.BaseColumns;

import org.json.JSONException;
import org.json.JSONObject;

import edu.aku.hassannaqvi.kmc.R;

/**
 * Created by hassan.naqvi on 11/30/2016.
 */

public class EligibleMembersContract {

    private final String projectName = String.valueOf(R.string.app_name);
    private String _ID = "";
    private String _UID = "";
    private String _UUID = "";
    private String formDate = "";
    private String deviceId = "";
    private String devicetagID = "";
    private String user = "";
    private String app_ver = "";

    private String a3SerialNo = "";
    private String name = "";
    private String dob = "";
    private String age = "";
    private String gender = "";
    private String sA3 = "";

    private String synced = "";
    private String syncedDate = "";

    public EligibleMembersContract() {
    }

    public EligibleMembersContract(EligibleMembersContract ec) {
        this.a3SerialNo = ec.getA3SerialNo();
        this.name = ec.getName();
        this.dob = ec.getDob();
        this.age = ec.getAge();
        this.gender = ec.getGender();


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

    public String get_UID() {
        return _UID;
    }

    public void set_UID(String _UID) {
        this._UID = _UID;
    }

    public String get_UUID() {
        return _UUID;
    }

    public void set_UUID(String _UUID) {
        this._UUID = _UUID;
    }

    public String getFormDate() {
        return formDate;
    }

    public void setFormDate(String formDate) {
        this.formDate = formDate;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getApp_ver() {
        return app_ver;
    }

    public void setApp_ver(String app_ver) {
        this.app_ver = app_ver;
    }

    public String getsA3() {
        return sA3;
    }

    public void setsA3(String sA3) {
        this.sA3 = sA3;
    }

    public String getSynced() {
        return synced;
    }

    public void setSynced(String synced) {
        this.synced = synced;
    }

    public String getSyncedDate() {
        return syncedDate;
    }

    public void setSyncedDate(String syncedDate) {
        this.syncedDate = syncedDate;
    }

    public String getA3SerialNo() {
        return a3SerialNo;
    }

    public void setA3SerialNo(String a3SerialNo) {
        this.a3SerialNo = a3SerialNo;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getDevicetagID() {
        return devicetagID;
    }

    public void setDevicetagID(String devicetagID) {
        this.devicetagID = devicetagID;
    }

    public EligibleMembersContract Sync(JSONObject jsonObject) throws JSONException {

        this._ID = jsonObject.getString(eligibleMembers.COLUMN__ID);
        this._UID = jsonObject.getString(eligibleMembers.COLUMN_UID);
        this._UUID = jsonObject.getString(eligibleMembers.COLUMN_UUID);
        this.formDate = jsonObject.getString(eligibleMembers.COLUMN_FORMDATE);
        this.deviceId = jsonObject.getString(eligibleMembers.COLUMN_DEVICEID);
        this.devicetagID = jsonObject.getString(eligibleMembers.COLUMN_DEVICETAGID);
        this.user = jsonObject.getString(eligibleMembers.COLUMN_USER);
        this.app_ver = jsonObject.getString(eligibleMembers.COLUMN_APPVERSION);
        this.a3SerialNo = jsonObject.getString(eligibleMembers.COLUMN_A3SERIALNO);
        this.name = jsonObject.getString(eligibleMembers.COLUMN_NAME);
        this.dob = jsonObject.getString(eligibleMembers.COLUMN_DOB);
        this.age = jsonObject.getString(eligibleMembers.COLUMN_AGE);
        this.gender = jsonObject.getString(eligibleMembers.COLUMN_GENDER);
        this.sA3 = jsonObject.getString(eligibleMembers.COLUMN_SA3);
        this.synced = jsonObject.getString(eligibleMembers.COLUMN_SYNCED);
        this.syncedDate = jsonObject.getString(eligibleMembers.COLUMN_SYNCEDDATE);

        return this;

    }

    public EligibleMembersContract Hydrate(Cursor cursor) {

        this._ID = cursor.getString(cursor.getColumnIndex(eligibleMembers.COLUMN__ID));
        this._UID = cursor.getString(cursor.getColumnIndex(eligibleMembers.COLUMN_UID));
        this._UUID = cursor.getString(cursor.getColumnIndex(eligibleMembers.COLUMN_UUID));
        this.formDate = cursor.getString(cursor.getColumnIndex(eligibleMembers.COLUMN_FORMDATE));
        this.deviceId = cursor.getString(cursor.getColumnIndex(eligibleMembers.COLUMN_DEVICEID));
        this.devicetagID = cursor.getString(cursor.getColumnIndex(eligibleMembers.COLUMN_DEVICETAGID));
        this.user = cursor.getString(cursor.getColumnIndex(eligibleMembers.COLUMN_USER));
        this.app_ver = cursor.getString(cursor.getColumnIndex(eligibleMembers.COLUMN_APPVERSION));
        this.a3SerialNo = cursor.getString(cursor.getColumnIndex(eligibleMembers.COLUMN_A3SERIALNO));
        this.name = cursor.getString(cursor.getColumnIndex(eligibleMembers.COLUMN_NAME));
        this.dob = cursor.getString(cursor.getColumnIndex(eligibleMembers.COLUMN_DOB));
        this.age = cursor.getString(cursor.getColumnIndex(eligibleMembers.COLUMN_AGE));
        this.gender = cursor.getString(cursor.getColumnIndex(eligibleMembers.COLUMN_GENDER));
        this.sA3 = cursor.getString(cursor.getColumnIndex(eligibleMembers.COLUMN_SA3));
        this.synced = cursor.getString(cursor.getColumnIndex(eligibleMembers.COLUMN_SYNCED));
        this.syncedDate = cursor.getString(cursor.getColumnIndex(eligibleMembers.COLUMN_SYNCEDDATE));


        return this;

    }


    public JSONObject toJSONObject() throws JSONException {

        JSONObject json = new JSONObject();

        json.put(eligibleMembers.COLUMN_PROJECTNAME, this.projectName == null ? JSONObject.NULL : this.projectName);
        json.put(eligibleMembers.COLUMN__ID, this._ID == null ? JSONObject.NULL : this._ID);
        json.put(eligibleMembers.COLUMN_UID, this._UID == null ? JSONObject.NULL : this._UID);
        json.put(eligibleMembers.COLUMN_UUID, this._UUID == null ? JSONObject.NULL : this._UUID);
        json.put(eligibleMembers.COLUMN_FORMDATE, this.formDate == null ? JSONObject.NULL : this.formDate);
        json.put(eligibleMembers.COLUMN_DEVICEID, this.deviceId == null ? JSONObject.NULL : this.deviceId);
        json.put(eligibleMembers.COLUMN_DEVICETAGID, this.devicetagID == null ? JSONObject.NULL : this.devicetagID);
        json.put(eligibleMembers.COLUMN_USER, this.user == null ? JSONObject.NULL : this.user);
        json.put(eligibleMembers.COLUMN_APPVERSION, this.app_ver == null ? JSONObject.NULL : this.app_ver);

        if (!this.sA3.equals("")) {
            json.put(eligibleMembers.COLUMN_SA3, this.sA3.equals("") ? JSONObject.NULL : new JSONObject(this.sA3));
        }
        json.put(eligibleMembers.COLUMN_NAME, this.name == null ? JSONObject.NULL : this.name);
        json.put(eligibleMembers.COLUMN_DOB, this.dob == null ? JSONObject.NULL : this.dob);
        json.put(eligibleMembers.COLUMN_AGE, this.age == null ? JSONObject.NULL : this.age);
        json.put(eligibleMembers.COLUMN_GENDER, this.gender == null ? JSONObject.NULL : this.gender);
        json.put(eligibleMembers.COLUMN_SA3, this.sA3 == null ? JSONObject.NULL : this.sA3);
        json.put(eligibleMembers.COLUMN_SYNCED, this.synced == null ? JSONObject.NULL : this.synced);
        json.put(eligibleMembers.COLUMN_SYNCEDDATE, this.syncedDate == null ? JSONObject.NULL : this.syncedDate);


        return json;
    }

    public static abstract class eligibleMembers implements BaseColumns {

        public static final String TABLE_NAME = "eligibles";
        public static final String COLUMN_NAME_NULLABLE = "NULLHACK";

        public static final String COLUMN_PROJECTNAME = "projectname";
        public static final String COLUMN__ID = "_id ";
        public static final String COLUMN_UID = "uid ";
        public static final String COLUMN_UUID = "uuid";
        public static final String COLUMN_FORMDATE = "formdate";
        public static final String COLUMN_DEVICEID = "deviceid ";
        public static final String COLUMN_DEVICETAGID = "devicetagid ";
        public static final String COLUMN_USER = "user";
        public static final String COLUMN_APPVERSION = "appversion";
        public static final String COLUMN_A3SERIALNO = "a3serialno";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_DOB = "dob";
        public static final String COLUMN_AGE = "age";
        public static final String COLUMN_GENDER = "gender";
        public static final String COLUMN_SA3 = "sa3";
        public static final String COLUMN_SYNCED = "synced";
        public static final String COLUMN_SYNCEDDATE = "synceddate";


        public static String _URL = "familymembers.php";
    }
}
