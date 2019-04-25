package edu.aku.hassannaqvi.kmc_screening.contracts;

import android.database.Cursor;
import android.provider.BaseColumns;

import org.json.JSONException;
import org.json.JSONObject;

public class DistrictsContract {

    private static String TAG = "";

    private String districtCode;
    private String districtName;

    public DistrictsContract() {
    }

    public DistrictsContract sync(JSONObject jsonObject) throws JSONException {

        this.districtCode = jsonObject.getString(singleDistrict.COLUMN_DISTRICT_CODE);
        this.districtName = jsonObject.getString(singleDistrict.COLUMN_DISTRICT_NAME);

        return this;
    }

    public DistrictsContract hydrate(Cursor cursor) {
        this.districtCode = cursor.getString(cursor.getColumnIndex(singleDistrict.COLUMN_DISTRICT_CODE));
        this.districtName = cursor.getString(cursor.getColumnIndex(singleDistrict.COLUMN_DISTRICT_NAME));

        return this;
    }

    public String getDistrictCode() {
        return districtCode;
    }

    public void setDistrictCode(String districtCode) {
        this.districtCode = districtCode;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public static abstract class singleDistrict implements BaseColumns {

        public static final String TABLE_NAME = "Districts";
        public static final String COLUMN_NAME_NULLABLE = "nullColumnHack";
        public static final String _ID = "_ID";
        public static final String COLUMN_DISTRICT_CODE = "taluka_code";
        public static final String COLUMN_DISTRICT_NAME = "taluka_name";

        public static final String _URI = "talukas.php";
    }

}