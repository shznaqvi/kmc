package edu.aku.hassannaqvi.kmc_screening.contracts;

import android.database.Cursor;
import android.provider.BaseColumns;

import org.json.JSONException;
import org.json.JSONObject;

public class PWScreenedContract {

    private String puid;
    private String village;
    private String hhno;
    private String formdate;
    private String pw_serial;
    private String pw_name;
    private String h_name;
    private String cast;
    private String hh_name;

    public PWScreenedContract() {
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

    public String getPw_name() {
        return pw_name;
    }

    public void setPw_name(String pw_name) {
        this.pw_name = pw_name;
    }

    public String getH_name() {
        return h_name;
    }

    public void setH_name(String h_name) {
        this.h_name = h_name;
    }

    public String getCast() {
        return cast;
    }

    public void setCast(String cast) {
        this.cast = cast;
    }

    public String getHh_name() {
        return hh_name;
    }

    public void setHh_name(String hh_name) {
        this.hh_name = hh_name;
    }

    public String getPw_serial() {
        return pw_serial;
    }

    public void setPw_serial(String pw_serial) {
        this.pw_serial = pw_serial;
    }

    public PWScreenedContract sync(JSONObject jsonObject) throws JSONException {
        this.puid = jsonObject.getString(PWFScrennedEntry.COLUMN_PUID);
        this.village = jsonObject.getString(PWFScrennedEntry.COLUMN_VILLAGE);
        this.hhno = jsonObject.getString(PWFScrennedEntry.COLUMN_HHNO);
        this.formdate = jsonObject.getString(PWFScrennedEntry.COLUMN_FORMDATE);
        this.pw_name = jsonObject.getString(PWFScrennedEntry.COLUMN_PW_NAME);
        this.h_name = jsonObject.getString(PWFScrennedEntry.COLUMN_H_NAME);
        this.cast = jsonObject.getString(PWFScrennedEntry.COLUMN_PW_CAST);
        this.hh_name = jsonObject.getString(PWFScrennedEntry.COLUMN_HH_NAME);
        this.pw_serial = jsonObject.getString(PWFScrennedEntry.COLUMN_PW_SERIAL);


        return this;
    }

    public PWScreenedContract hydrate(Cursor cursor) {
        this.puid = cursor.getString(cursor.getColumnIndex(PWFScrennedEntry.COLUMN_PUID));
        this.village = cursor.getString(cursor.getColumnIndex(PWFScrennedEntry.COLUMN_VILLAGE));
        this.hhno = cursor.getString(cursor.getColumnIndex(PWFScrennedEntry.COLUMN_HHNO));
        this.formdate = cursor.getString(cursor.getColumnIndex(PWFScrennedEntry.COLUMN_FORMDATE));
        this.pw_serial = cursor.getString(cursor.getColumnIndex(PWFScrennedEntry.COLUMN_PW_SERIAL));
        this.pw_name = cursor.getString(cursor.getColumnIndex(PWFScrennedEntry.COLUMN_PW_NAME));
        this.h_name = cursor.getString(cursor.getColumnIndex(PWFScrennedEntry.COLUMN_H_NAME));
        this.cast = cursor.getString(cursor.getColumnIndex(PWFScrennedEntry.COLUMN_PW_CAST));
        this.hh_name = cursor.getString(cursor.getColumnIndex(PWFScrennedEntry.COLUMN_HH_NAME));

        return this;
    }

    public JSONObject toJSONObject() throws JSONException {
        JSONObject json = new JSONObject();
        json.put(PWFScrennedEntry.COLUMN_PUID, this.puid == null ? JSONObject.NULL : this.puid);
        json.put(PWFScrennedEntry.COLUMN_VILLAGE, this.village == null ? JSONObject.NULL : this.village);
        json.put(PWFScrennedEntry.COLUMN_HHNO, this.hhno == null ? JSONObject.NULL : this.hhno);
        json.put(PWFScrennedEntry.COLUMN_FORMDATE, this.formdate == null ? JSONObject.NULL : this.formdate);
        json.put(PWFScrennedEntry.COLUMN_PW_SERIAL, this.pw_serial == null ? JSONObject.NULL : this.pw_serial);
        json.put(PWFScrennedEntry.COLUMN_PW_NAME, this.pw_name == null ? JSONObject.NULL : this.pw_name);
        json.put(PWFScrennedEntry.COLUMN_H_NAME, this.h_name == null ? JSONObject.NULL : this.h_name);
        json.put(PWFScrennedEntry.COLUMN_PW_CAST, this.cast == null ? JSONObject.NULL : this.cast);
        json.put(PWFScrennedEntry.COLUMN_HH_NAME, this.hh_name == null ? JSONObject.NULL : this.hh_name);

        return json;
    }

    public static abstract class PWFScrennedEntry implements BaseColumns {

        public static final String TABLE_NAME = "pwscreened";
        public static final String MWRA_NULLABLE = "NULLHACK";
        public static final String COLUMN_PUID = "puid";
        public static final String COLUMN_VILLAGE = "village";
        public static final String COLUMN_HHNO = "hhno";
        public static final String COLUMN_FORMDATE = "formdate";
        public static final String COLUMN_PW_SERIAL = "pw_serial";
        public static final String COLUMN_PW_NAME = "pw_name";
        public static final String COLUMN_H_NAME = "h_name";
        public static final String COLUMN_PW_CAST = "pw_cast";
        public static final String COLUMN_HH_NAME = "hh_name";

        public static String _URI = "getpw.php";
    }
}