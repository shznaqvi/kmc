package edu.aku.hassannaqvi.kmc_screening.contracts;

import android.database.Cursor;
import android.provider.BaseColumns;

import org.json.JSONException;
import org.json.JSONObject;

public class VillagesContract {

    private String villageCode;
    private String villageName;
    private String districtCode;
    private String ucCode;


    public VillagesContract() {
    }

    public VillagesContract sync(JSONObject jsonObject) throws JSONException {
        this.villageCode = jsonObject.getString(SingleVillage.COLUMN_VILLAGE_CODE);
        this.villageName = jsonObject.getString(SingleVillage.COLUMN_VILLAGE_NAME);
        this.districtCode = jsonObject.getString(SingleVillage.COLUMN_DISTRICT_CODE);
        this.ucCode = jsonObject.getString(SingleVillage.COLUMN_UC_CODE);


        return this;
    }

    public VillagesContract hydrate(Cursor cursor) {
        this.villageCode = cursor.getString(cursor.getColumnIndex(SingleVillage.COLUMN_VILLAGE_CODE));
        this.villageName = cursor.getString(cursor.getColumnIndex(SingleVillage.COLUMN_VILLAGE_NAME));
        this.districtCode = cursor.getString(cursor.getColumnIndex(SingleVillage.COLUMN_DISTRICT_CODE));
        this.ucCode = cursor.getString(cursor.getColumnIndex(SingleVillage.COLUMN_UC_CODE));

        return this;
    }


    public String getUcCode() {
        return ucCode;
    }

    public String getVillageCode() {
        return villageCode;
    }

    public String getVillageName() {
        return villageName;
    }

    public String getDistrictCode() {
        return districtCode;
    }

    public static abstract class SingleVillage implements BaseColumns {

        public static final String TABLE_NAME = "villages";
        public static final String COLUMN_NAME_NULLABLE = "nullColumnHack";
        public static final String _ID = "_ID";
        public static final String COLUMN_VILLAGE_CODE = "village_code";
        public static final String COLUMN_VILLAGE_NAME = "village_name";
        public static final String COLUMN_DISTRICT_CODE = "taluka_code";
        public static final String COLUMN_UC_CODE = "uc_code";

        public static final String _URI = "villages.php";

    }
}