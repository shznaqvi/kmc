package edu.aku.hassannaqvi.kmc_screening.contracts;

import android.database.Cursor;
import android.provider.BaseColumns;

import org.json.JSONException;
import org.json.JSONObject;

public class RegisteredPWContract {

    private static String TAG = "";

    private String villageCode;
    private String pwids;

    public RegisteredPWContract() {
    }

    public RegisteredPWContract sync(JSONObject jsonObject) throws JSONException {

        this.villageCode = jsonObject.getString(RegisteredPW.COLUMN_VILLAGE_CODE);
        this.pwids = jsonObject.getString(RegisteredPW.COLUMN_PWIDS);

        return this;
    }

    public RegisteredPWContract hydrate(Cursor cursor) {
        this.villageCode = cursor.getString(cursor.getColumnIndex(RegisteredPW.COLUMN_VILLAGE_CODE));
        this.pwids = cursor.getString(cursor.getColumnIndex(RegisteredPW.COLUMN_PWIDS));

        return this;
    }

    public String getVillageCode() {
        return villageCode;
    }

    public void setVillageCode(String villageCode) {
        this.villageCode = villageCode;
    }

    public String getPwids() {
        return pwids;
    }

    public void setPwids(String pwids) {
        this.pwids = pwids;
    }

    public static abstract class RegisteredPW implements BaseColumns {

        public static final String TABLE_NAME = "registeredpw";
        public static final String COLUMN_NAME_NULLABLE = "nullColumnHack";
        public static final String COLUMN_VILLAGE_CODE = "village";
        public static final String COLUMN_PWIDS = "pwids";

        public static final String _URI = "registered.php";
    }

}