package edu.aku.hassannaqvi.kmc_screening.contracts;

import android.database.Cursor;
import android.provider.BaseColumns;

import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

public class EligibleContract {

    private String puid;
    private String village;
    private String formdate;
    private String m_name;
    private String m_id;
    private String part_id;
    private String screen_id;

    public EligibleContract() {
    }

    public String getPuid() {
        return puid;
    }

    public void setPuid(String puid) {
        this.puid = puid;
    }

    public String getVillage() {
        return village;
    }

    public void setVillage(String village) {
        this.village = village;
    }

    public String getFormdate() {
        return formdate;
    }

    public void setFormdate(String formdate) {
        this.formdate = formdate;
    }

    public String getM_id() {
        return m_id;
    }

    public void setM_id(String m_id) {
        this.m_id = m_id;
    }

    public String getPart_id() {
        return part_id;
    }

    public void setPart_id(String part_id) {
        this.part_id = part_id;
    }

    public String getM_name() {
        return m_name;
    }

    public void setM_name(String m_name) {
        this.m_name = m_name;
    }

    public static boolean checkingEligibility(Cursor cursor) {
        SimpleEligibleSA forms = new Gson().fromJson(cursor.getString(cursor.getColumnIndex(FormsContract.FormsTable.COLUMN_SA)), SimpleEligibleSA.class);
        return !forms.getKf1b11().equals("");
    }

    public String getScreen_id() {
        return screen_id;
    }

    public void setScreen_id(String screen_id) {
        this.screen_id = screen_id;
    }

    public EligibleContract sync(JSONObject jsonObject) throws JSONException {

        this.puid = jsonObject.getString(EligibleEntry.COLUMN_PUID);
        this.village = jsonObject.getString(EligibleEntry.COLUMN_VILLAGE);
        this.formdate = jsonObject.getString(EligibleEntry.COLUMN_FORMDATE);
        this.m_name = jsonObject.getString(EligibleEntry.COLUMN_M_NAME);
        this.m_id = jsonObject.getString(EligibleEntry.COLUMN_M_ID);
        this.part_id = jsonObject.getString(EligibleEntry.COLUMN_PART_ID);
        this.screen_id = jsonObject.getString(EligibleEntry.COLUMN_SCREEN_ID);

        return this;
    }

    public EligibleContract hydrate(Cursor cursor) {

        this.puid = cursor.getString(cursor.getColumnIndex(EligibleEntry.COLUMN_PUID));
        this.village = cursor.getString(cursor.getColumnIndex(EligibleEntry.COLUMN_VILLAGE));
        this.formdate = cursor.getString(cursor.getColumnIndex(EligibleEntry.COLUMN_FORMDATE));
        this.m_name = cursor.getString(cursor.getColumnIndex(EligibleEntry.COLUMN_M_NAME));
        this.m_id = cursor.getString(cursor.getColumnIndex(EligibleEntry.COLUMN_M_ID));
        this.part_id = cursor.getString(cursor.getColumnIndex(EligibleEntry.COLUMN_PART_ID));
        this.screen_id = cursor.getString(cursor.getColumnIndex(EligibleEntry.COLUMN_SCREEN_ID));

        return this;
    }

    public EligibleContract hydrate2(Cursor cursor, boolean flag) {

        this.puid = cursor.getString(cursor.getColumnIndex(FormsContract.FormsTable.COLUMN__UID));
        this.village = cursor.getString(cursor.getColumnIndex(FormsContract.FormsTable.COLUMN_VILLAGE));
        this.formdate = cursor.getString(cursor.getColumnIndex(FormsContract.FormsTable.COLUMN_FORMDATE));
        this.m_id = cursor.getString(cursor.getColumnIndex(FormsContract.FormsTable.COLUMN_PWID));

        if (flag) {
            SimpleEligibleSA formsSA = new Gson().fromJson(cursor.getString(cursor.getColumnIndex(FormsContract.FormsTable.COLUMN_SA)), SimpleEligibleSA.class);
            SimpleEligibleSINFO formsSINFO = new Gson().fromJson(cursor.getString(cursor.getColumnIndex(FormsContract.FormsTable.COLUMN_SINFO)), SimpleEligibleSINFO.class);
            this.m_name = formsSINFO.getKf1a02();
            this.screen_id = formsSINFO.getKf1a03();
            this.part_id = formsSA.getKf1b11();
        } else {
            SimpleEligibleSINFO_F2 formsSINFO = new Gson().fromJson(cursor.getString(cursor.getColumnIndex(FormsContract.FormsTable.COLUMN_SINFO)), SimpleEligibleSINFO_F2.class);
            this.m_name = formsSINFO.getKf2a03();
            this.screen_id = formsSINFO.getKf2a02();
        }

        return this;
    }

    public JSONObject toJSONObject() throws JSONException {
        JSONObject json = new JSONObject();

        json.put(EligibleEntry.COLUMN_PUID, this.puid == null ? JSONObject.NULL : this.puid);
        json.put(EligibleEntry.COLUMN_VILLAGE, this.village == null ? JSONObject.NULL : this.village);
        json.put(EligibleEntry.COLUMN_FORMDATE, this.formdate == null ? JSONObject.NULL : this.formdate);
        json.put(EligibleEntry.COLUMN_M_NAME, this.m_name == null ? JSONObject.NULL : this.m_name);
        json.put(EligibleEntry.COLUMN_M_ID, this.m_id == null ? JSONObject.NULL : this.m_id);
        json.put(EligibleEntry.COLUMN_PART_ID, this.part_id == null ? JSONObject.NULL : this.part_id);
        json.put(EligibleEntry.COLUMN_SCREEN_ID, this.screen_id == null ? JSONObject.NULL : this.screen_id);

        return json;
    }

    public static abstract class EligibleEntry implements BaseColumns {

        public static final String TABLE_NAME = "eligible_participants";
        public static final String MWRA_NULLABLE = "NULLHACK";
        public static final String COLUMN_PUID = "puid";
        public static final String COLUMN_VILLAGE = "village";
        public static final String COLUMN_FORMDATE = "formdate";
        public static final String COLUMN_M_NAME = "m_name";
        public static final String COLUMN_M_ID = "pwid";
        public static final String COLUMN_PART_ID = "part_id";
        public static final String COLUMN_SCREEN_ID = "screen_id";

        public static String _URI = "eligible_participant.php";
    }

    private class SimpleEligibleSINFO {

        String kf1a02, kf1a03;

        public String getKf1a03() {
            return kf1a03;
        }

        public String getKf1a02() {
            return kf1a02;
        }
    }

    private class SimpleEligibleSINFO_F2 {

        String kf2a03, kf2a02;

        public String getKf2a03() {
            return kf2a03;
        }

        public String getKf2a02() {
            return kf2a02;
        }
    }

    private class SimpleEligibleSA {

        String kf1b11;

        public String getKf1b11() {
            return kf1b11;
        }
    }
}