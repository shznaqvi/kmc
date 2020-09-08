package edu.aku.hassannaqvi.kmc_screening.contracts;

import android.database.Cursor;
import android.provider.BaseColumns;

import org.json.JSONException;
import org.json.JSONObject;

public class MortalityContract {

    private String _UID;
    private String village;
    private String pwid;
    private String screendate;
    private String pw_name;
    private String child;
    private String childname;
    private String sex;

    public MortalityContract() {
    }

    public MortalityContract sync(JSONObject jsonObject) throws JSONException {
        this._UID = jsonObject.getString(SingleMortality.COLUMN__UID);
        this.village = jsonObject.getString(SingleMortality.COLUMN_VILLAGE);
        this.pwid = jsonObject.getString(SingleMortality.COLUMN_PWID);
        this.screendate = jsonObject.getString(SingleMortality.COLUMN_SCREENDATE);
        this.pw_name = jsonObject.getString(SingleMortality.COLUMN_PW_NAME);
        this.child = jsonObject.getString(SingleMortality.COLUMN_CHILD);
        this.childname = jsonObject.getString(SingleMortality.COLUMN_CHILDNAME);
        this.sex = jsonObject.getString(SingleMortality.COLUMN_SEX);

        return this;
    }

    public MortalityContract hydrate(Cursor cursor) {
        this._UID = cursor.getString(cursor.getColumnIndex(SingleMortality.COLUMN__UID));
        this.village = cursor.getString(cursor.getColumnIndex(SingleMortality.COLUMN_VILLAGE));
        this.pwid = cursor.getString(cursor.getColumnIndex(SingleMortality.COLUMN_PWID));
        this.screendate = cursor.getString(cursor.getColumnIndex(SingleMortality.COLUMN_SCREENDATE));
        this.pw_name = cursor.getString(cursor.getColumnIndex(SingleMortality.COLUMN_PW_NAME));
        this.child = cursor.getString(cursor.getColumnIndex(SingleMortality.COLUMN_CHILD));
        this.childname = cursor.getString(cursor.getColumnIndex(SingleMortality.COLUMN_CHILDNAME));
        this.sex = cursor.getString(cursor.getColumnIndex(SingleMortality.COLUMN_SEX));

        return this;
    }


    public String getUID() {
        return _UID;
    }

    public void setUID(String _UID) {
        this._UID = _UID;
    }

    public String getvillage() {
        return village;
    }

    public void setvillage(String village) {
        this.village = village;
    }

    public String getpwid() {
        return pwid;
    }

    public void setpwid(String pwid) {
        this.pwid = pwid;
    }

    public String getscreendate() {
        return screendate;
    }

    public void setscreendate(String screendate) {
        this.screendate = screendate;
    }

    public String getpw_name() {
        return pw_name;
    }

    public void setpw_name(String pw_name) {
        this.pw_name = pw_name;
    }

    public String getchild() {
        return child;
    }

    public void setchild(String child) {
        this.child = child;
    }

    public String getchildname() {
        return childname;
    }

    public void setchildname(String childname) {
        this.childname = childname;
    }

    public String getsex() {
        return sex;
    }

    public void setsex(String sex) {
        this.sex = sex;
    }

    public static abstract class SingleMortality implements BaseColumns {

        public static final String TABLE_NAME = "mortality";
        public static final String COLUMN_NAME_NULLABLE = "nullColumnHack";
        public static final String COLUMN__UID = "_uid";
        public static final String COLUMN_VILLAGE = "village";
        public static final String COLUMN_PWID = "pwid";
        public static final String COLUMN_SCREENDATE = "screendate";
        public static final String COLUMN_PW_NAME = "pw_name";
        public static final String COLUMN_CHILD = "child";
        public static final String COLUMN_CHILDNAME = "childname";
        public static final String COLUMN_SEX = "sex";

        public static final String _URI = "mortality_list.php";

    }
}