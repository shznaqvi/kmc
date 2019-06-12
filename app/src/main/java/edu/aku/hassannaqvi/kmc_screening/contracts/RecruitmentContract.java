package edu.aku.hassannaqvi.kmc_screening.contracts;

import android.database.Cursor;
import android.provider.BaseColumns;

import org.json.JSONException;
import org.json.JSONObject;

public class RecruitmentContract extends EligibleContract {

    private String puid;
    private String village;
    private String formdate;
    private String m_name;
    private String m_id;
    private String screen_id;

    public RecruitmentContract() {
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

    public String getM_name() {
        return m_name;
    }

    public void setM_name(String m_name) {
        this.m_name = m_name;
    }

    public String getScreen_id() {
        return screen_id;
    }

    public void setScreen_id(String screen_id) {
        this.screen_id = screen_id;
    }

    public RecruitmentContract sync(JSONObject jsonObject) throws JSONException {

        this.puid = jsonObject.getString(RecruitmentEntry.COLUMN_PUID);
        this.village = jsonObject.getString(RecruitmentEntry.COLUMN_VILLAGE);
        this.formdate = jsonObject.getString(RecruitmentEntry.COLUMN_FORMDATE);
        this.m_name = jsonObject.getString(RecruitmentEntry.COLUMN_M_NAME);
        this.m_id = jsonObject.getString(RecruitmentEntry.COLUMN_M_ID);
        this.screen_id = jsonObject.getString(RecruitmentEntry.COLUMN_SCREEN_ID);

        return this;
    }

    public RecruitmentContract hydrate(Cursor cursor) {

        this.puid = cursor.getString(cursor.getColumnIndex(RecruitmentEntry.COLUMN_PUID));
        this.village = cursor.getString(cursor.getColumnIndex(RecruitmentEntry.COLUMN_VILLAGE));
        this.formdate = cursor.getString(cursor.getColumnIndex(RecruitmentEntry.COLUMN_FORMDATE));
        this.m_name = cursor.getString(cursor.getColumnIndex(RecruitmentEntry.COLUMN_M_NAME));
        this.m_id = cursor.getString(cursor.getColumnIndex(RecruitmentEntry.COLUMN_M_ID));
        this.screen_id = cursor.getString(cursor.getColumnIndex(RecruitmentEntry.COLUMN_SCREEN_ID));

        return this;
    }

    public JSONObject toJSONObject() throws JSONException {
        JSONObject json = new JSONObject();

        json.put(RecruitmentEntry.COLUMN_PUID, this.puid == null ? JSONObject.NULL : this.puid);
        json.put(RecruitmentEntry.COLUMN_VILLAGE, this.village == null ? JSONObject.NULL : this.village);
        json.put(RecruitmentEntry.COLUMN_FORMDATE, this.formdate == null ? JSONObject.NULL : this.formdate);
        json.put(RecruitmentEntry.COLUMN_M_NAME, this.m_name == null ? JSONObject.NULL : this.m_name);
        json.put(RecruitmentEntry.COLUMN_M_ID, this.m_id == null ? JSONObject.NULL : this.m_id);
        json.put(RecruitmentEntry.COLUMN_SCREEN_ID, this.screen_id == null ? JSONObject.NULL : this.screen_id);

        return json;
    }

    public static abstract class RecruitmentEntry implements BaseColumns {

        public static final String TABLE_NAME = "recruitment_part";
        public static final String COLUMN_PUID = "puid";
        public static final String COLUMN_VILLAGE = "village";
        public static final String COLUMN_FORMDATE = "formdate";
        public static final String COLUMN_M_NAME = "m_name";
        public static final String COLUMN_M_ID = "pwid";
        public static final String COLUMN_SCREEN_ID = "screen_id";

        public static String _URI = "recruitments.php";
    }

}