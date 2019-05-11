package edu.aku.hassannaqvi.kmc_screening.contracts;

import android.database.Cursor;
import android.provider.BaseColumns;

import org.json.JSONException;
import org.json.JSONObject;

public class EligibleContract {

    private String puid;
    private String village;
    private String hhno;
    private String formdate;
    private String m_name;
    private String m_serial;
    private String part_id;

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

    public String getHhno() {
        return hhno;
    }

    public void setHhno(String hhno) {
        this.hhno = hhno;
    }

    public String getFormdate() {
        return formdate;
    }

    public void setFormdate(String formdate) {
        this.formdate = formdate;
    }

    public String getM_serial() {
        return m_serial;
    }

    public void setM_serial(String m_serial) {
        this.m_serial = m_serial;
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

    public EligibleContract sync(JSONObject jsonObject) throws JSONException {

        this.puid = jsonObject.getString(EligibleEntry.COLUMN_PUID);
        this.village = jsonObject.getString(EligibleEntry.COLUMN_VILLAGE);
        this.hhno = jsonObject.getString(EligibleEntry.COLUMN_HHNO);
        this.formdate = jsonObject.getString(EligibleEntry.COLUMN_FORMDATE);
        this.m_name = jsonObject.getString(EligibleEntry.COLUMN_M_NAME);
        this.m_serial = jsonObject.getString(EligibleEntry.COLUMN_M_SERIAL);
        this.part_id = jsonObject.getString(EligibleEntry.COLUMN_PART_ID);

        return this;
    }

    public EligibleContract hydrate(Cursor cursor) {

        this.puid = cursor.getString(cursor.getColumnIndex(EligibleEntry.COLUMN_PUID));
        this.village = cursor.getString(cursor.getColumnIndex(EligibleEntry.COLUMN_VILLAGE));
        this.hhno = cursor.getString(cursor.getColumnIndex(EligibleEntry.COLUMN_HHNO));
        this.formdate = cursor.getString(cursor.getColumnIndex(EligibleEntry.COLUMN_FORMDATE));
        this.m_name = cursor.getString(cursor.getColumnIndex(EligibleEntry.COLUMN_M_NAME));
        this.m_serial = cursor.getString(cursor.getColumnIndex(EligibleEntry.COLUMN_M_SERIAL));
        this.part_id = cursor.getString(cursor.getColumnIndex(EligibleEntry.COLUMN_PART_ID));

        return this;
    }

    public JSONObject toJSONObject() throws JSONException {
        JSONObject json = new JSONObject();

        json.put(EligibleEntry.COLUMN_PUID, this.puid == null ? JSONObject.NULL : this.puid);
        json.put(EligibleEntry.COLUMN_VILLAGE, this.village == null ? JSONObject.NULL : this.village);
        json.put(EligibleEntry.COLUMN_HHNO, this.hhno == null ? JSONObject.NULL : this.hhno);
        json.put(EligibleEntry.COLUMN_FORMDATE, this.formdate == null ? JSONObject.NULL : this.formdate);
        json.put(EligibleEntry.COLUMN_M_NAME, this.m_name == null ? JSONObject.NULL : this.m_name);
        json.put(EligibleEntry.COLUMN_M_SERIAL, this.m_serial == null ? JSONObject.NULL : this.m_serial);
        json.put(EligibleEntry.COLUMN_PART_ID, this.part_id == null ? JSONObject.NULL : this.part_id);

        return json;
    }

    public static abstract class EligibleEntry implements BaseColumns {

        public static final String TABLE_NAME = "eligible_participants";
        public static final String MWRA_NULLABLE = "NULLHACK";
        public static final String COLUMN_PUID = "puid";
        public static final String COLUMN_VILLAGE = "village";
        public static final String COLUMN_HHNO = "hhno";
        public static final String COLUMN_FORMDATE = "formdate";
        public static final String COLUMN_M_NAME = "m_name";
        public static final String COLUMN_M_SERIAL = "m_serial";
        public static final String COLUMN_PART_ID = "part_id";

        public static String _URI = "eligible_participant.php";
    }
}