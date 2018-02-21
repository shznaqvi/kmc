package edu.aku.hassannaqvi.kmc.contracts;

import android.database.Cursor;
import android.provider.BaseColumns;

import org.json.JSONException;
import org.json.JSONObject;

import edu.aku.hassannaqvi.kmc.R;

/**
 * Created by hassan.naqvi on 11/30/2016.
 */

public class FamilyMembersContract {

    private final String projectName = String.valueOf(R.string.app_name);
    private String _ID = "";
    private String _UID = "";
    private String _UUID = "";
    private String formDate = "";
    private String deviceId = "";
    private String devicetagID = "";
    private String user = "";
    private String app_ver = "";

    private String serialNo = "";
    private String name = "";
    private String dob = "";
    private String age = "";
    private String ageInYear = "";
    private String gender = "";
    private String motherId = "";
    private String sA2 = "";

    private String synced = "";
    private String syncedDate = "";

    public FamilyMembersContract() {
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

    public String getAgeInYear() {
        return ageInYear;
    }

    public void setAgeInYear(String ageInYear) {
        this.ageInYear = ageInYear;
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

    public String getMotherId() {
        return motherId;
    }

    public void setMotherId(String motherId) {
        this.motherId = motherId;
    }

    public String getsA2() {
        return sA2;
    }

    public void setsA2(String sA2) {
        this.sA2 = sA2;
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

    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
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

    public FamilyMembersContract Sync(JSONObject jsonObject) throws JSONException {

        this._ID = jsonObject.getString(familyMembers.COLUMN_ID);
        this._UID = jsonObject.getString(familyMembers.COLUMN_UID);
        this._UUID = jsonObject.getString(familyMembers.COLUMN_UUID);
        this.formDate = jsonObject.getString(familyMembers.COLUMN_FORMDATE);
        this.deviceId = jsonObject.getString(familyMembers.COLUMN_DEVICEID);
        this.user = jsonObject.getString(familyMembers.COLUMN_USER);
        this.app_ver = jsonObject.getString(familyMembers.COLUMN_APP_VERSION);
        this.sA2 = jsonObject.getString(familyMembers.COLUMN_SA2);
        this.synced = jsonObject.getString(familyMembers.COLUMN_SYNCED);
        this.syncedDate = jsonObject.getString(familyMembers.COLUMN_SYNCED_DATE);
        this.devicetagID = jsonObject.getString(familyMembers.COLUMN_DEVICETAGID);

        return this;

    }

    public FamilyMembersContract Hydrate(Cursor cursor) {

        this._ID = cursor.getString(cursor.getColumnIndex(familyMembers.COLUMN_ID));
        this._UID = cursor.getString(cursor.getColumnIndex(familyMembers.COLUMN_UID));
        this._UUID = cursor.getString(cursor.getColumnIndex(familyMembers.COLUMN_UUID));
        this.formDate = cursor.getString(cursor.getColumnIndex(familyMembers.COLUMN_FORMDATE));
        this.deviceId = cursor.getString(cursor.getColumnIndex(familyMembers.COLUMN_DEVICEID));
        this.user = cursor.getString(cursor.getColumnIndex(familyMembers.COLUMN_USER));
        this.app_ver = cursor.getString(cursor.getColumnIndex(familyMembers.COLUMN_APP_VERSION));
        this.sA2 = cursor.getString(cursor.getColumnIndex(familyMembers.COLUMN_SA2));
        this.devicetagID = cursor.getString(cursor.getColumnIndex(familyMembers.COLUMN_DEVICETAGID));

        return this;

    }


    public JSONObject toJSONObject() throws JSONException {

        JSONObject json = new JSONObject();

        json.put(familyMembers.COLUMN_ID, this._ID == null ? JSONObject.NULL : this._ID);
        json.put(familyMembers.COLUMN_UID, this._UID == null ? JSONObject.NULL : this._UID);
        json.put(familyMembers.COLUMN_UUID, this._UUID == null ? JSONObject.NULL : this._UUID);
        json.put(familyMembers.COLUMN_FORMDATE, this.formDate == null ? JSONObject.NULL : this.formDate);
        json.put(familyMembers.COLUMN_DEVICEID, this.deviceId == null ? JSONObject.NULL : this.deviceId);
        json.put(familyMembers.COLUMN_USER, this.user == null ? JSONObject.NULL : this.user);
        json.put(familyMembers.COLUMN_APP_VERSION, this.app_ver == null ? JSONObject.NULL : this.app_ver);
        if (!this.sA2.equals("")) {
            json.put(familyMembers.COLUMN_SA2, this.sA2.equals("") ? JSONObject.NULL : new JSONObject(this.sA2));
        }
        json.put(familyMembers.COLUMN_PROJECT_NAME, this.projectName == null ? JSONObject.NULL : this.projectName);
        json.put(familyMembers.COLUMN_DEVICETAGID, this.devicetagID == null ? JSONObject.NULL : this.devicetagID);


        return json;
    }

    public static abstract class familyMembers implements BaseColumns {

        public static final String TABLE_NAME = "familymembers";
        public static final String COLUMN_NAME_NULLABLE = "NULLHACK";

        public static final String COLUMN_PROJECT_NAME = "project_name";
        public static final String COLUMN_ID = "_id";
        public static final String COLUMN_UID = "uid";
        public static final String COLUMN_UUID = "uuid";
        public static final String COLUMN_FORMDATE = "formdate";
        public static final String COLUMN_DEVICEID = "deviceid";
        public static final String COLUMN_DEVICETAGID = "tagid";
        public static final String COLUMN_USER = "user";
        public static final String COLUMN_APP_VERSION = "app_ver";

        public static final String COLUMN_SA2 = "sA2";

        public static final String COLUMN_SYNCED = "synced";
        public static final String COLUMN_SYNCED_DATE = "sync_date";

        public static String _URL = "familymembers.php";
    }
}
