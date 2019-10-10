package edu.aku.hassannaqvi.kmc_screening.contracts;

import android.database.Cursor;
import android.provider.BaseColumns;

import org.json.JSONException;
import org.json.JSONObject;

public class PWFollowUpContract {

    public String uid;
    public String village;
    public String round;
    public String fupdt;
    public String pwid;
    public String hname;
    public String wname;
    public String kapr07;
    public String kapr08;
    public String hhname;
    public String regdt;


    public PWFollowUpContract() {
    }

    public PWFollowUpContract sync(JSONObject jsonObject) throws JSONException {

        this.uid = jsonObject.getString(PWFUPEntry.MWRA_UID);
        this.village = jsonObject.getString(PWFUPEntry.MWRA_VILLAGE);
        this.round = jsonObject.getString(PWFUPEntry.MWRA_ROUND);
        this.fupdt = jsonObject.getString(PWFUPEntry.MWRA_FUPDT);
        this.pwid = jsonObject.getString(PWFUPEntry.MWRA_PWID);
        this.hname = jsonObject.getString(PWFUPEntry.MWRA_HNAME);
        this.wname = jsonObject.getString(PWFUPEntry.MWRA_WNAME);
        this.kapr07 = jsonObject.getString(PWFUPEntry.MWRA_KAPR07);
        this.kapr08 = jsonObject.getString(PWFUPEntry.MWRA_KAPR08);
        this.hhname = jsonObject.getString(PWFUPEntry.MWRA_HHNAME);
        this.regdt = jsonObject.getString(PWFUPEntry.MWRA_REGDT);

        return this;
    }

    public PWFollowUpContract hydrate(Cursor cursor) {

        this.uid = cursor.getString(cursor.getColumnIndex(PWFUPEntry.MWRA_UID));
        this.village = cursor.getString(cursor.getColumnIndex(PWFUPEntry.MWRA_VILLAGE));
        this.round = cursor.getString(cursor.getColumnIndex(PWFUPEntry.MWRA_ROUND));
        this.fupdt = cursor.getString(cursor.getColumnIndex(PWFUPEntry.MWRA_FUPDT));
        this.pwid = cursor.getString(cursor.getColumnIndex(PWFUPEntry.MWRA_PWID));
        this.hname = cursor.getString(cursor.getColumnIndex(PWFUPEntry.MWRA_HNAME));
        this.wname = cursor.getString(cursor.getColumnIndex(PWFUPEntry.MWRA_WNAME));
        this.kapr07 = cursor.getString(cursor.getColumnIndex(PWFUPEntry.MWRA_KAPR07));
        this.kapr08 = cursor.getString(cursor.getColumnIndex(PWFUPEntry.MWRA_KAPR08));
        this.hhname = cursor.getString(cursor.getColumnIndex(PWFUPEntry.MWRA_HHNAME));
        this.regdt = cursor.getString(cursor.getColumnIndex(PWFUPEntry.MWRA_REGDT));

        return this;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getVillage() {
        return village;
    }

    public void setVillage(String village) {
        this.village = village;
    }

    public String getRound() {
        return round;
    }

    public void setRound(String round) {
        this.round = round;
    }

    public String getFupdt() {
        return fupdt;
    }

    public void setFupdt(String fupdt) {
        this.fupdt = fupdt;
    }

    public String getPwid() {
        return pwid;
    }

    public void setPwid(String pwid) {
        this.pwid = pwid;
    }

    public String getHname() {
        return hname;
    }

    public void setHname(String hname) {
        this.hname = hname;
    }

    public String getWname() {
        return wname;
    }

    public void setWname(String wname) {
        this.wname = wname;
    }

    public String getKapr07() {
        return kapr07;
    }

    public void setKapr07(String kapr07) {
        this.kapr07 = kapr07;
    }

    public String getKapr08() {
        return kapr08;
    }

    public void setKapr08(String kapr08) {
        this.kapr08 = kapr08;
    }

    public String getHhname() {
        return hhname;
    }

    public void setHhname(String hhname) {
        this.hhname = hhname;
    }

    public String getRegdt() {
        return regdt;
    }

    public void setRegdt(String regdt) {
        this.regdt = regdt;
    }

    public JSONObject toJSONObject() throws JSONException {
        JSONObject json = new JSONObject();

        json.put(PWFUPEntry.MWRA_UID, this.uid == null ? JSONObject.NULL : this.uid);
        json.put(PWFUPEntry.MWRA_VILLAGE, this.village == null ? JSONObject.NULL : this.village);
        json.put(PWFUPEntry.MWRA_ROUND, this.round == null ? JSONObject.NULL : this.round);
        json.put(PWFUPEntry.MWRA_FUPDT, this.fupdt == null ? JSONObject.NULL : this.fupdt);
        json.put(PWFUPEntry.MWRA_PWID, this.pwid == null ? JSONObject.NULL : this.pwid);
        json.put(PWFUPEntry.MWRA_HNAME, this.hname == null ? JSONObject.NULL : this.hname);
        json.put(PWFUPEntry.MWRA_WNAME, this.wname == null ? JSONObject.NULL : this.wname);
        json.put(PWFUPEntry.MWRA_KAPR07, this.kapr07 == null ? JSONObject.NULL : this.kapr07);
        json.put(PWFUPEntry.MWRA_KAPR08, this.kapr08 == null ? JSONObject.NULL : this.kapr08);
        json.put(PWFUPEntry.MWRA_HHNAME, this.hhname == null ? JSONObject.NULL : this.hhname);
        json.put(PWFUPEntry.MWRA_REGDT, this.regdt == null ? JSONObject.NULL : this.regdt);

        return json;

    }

    public static abstract class PWFUPEntry implements BaseColumns {

        public static final String TABLE_NAME = "pwfollowup";
        public static final String MWRA_NULLABLE = "NULLHACK";
        public static final String MWRA_UID = "_uid";
        public static final String MWRA_VILLAGE = "village";
        public static final String MWRA_ROUND = "round";
        public static final String MWRA_FUPDT = "fupdt";
        public static final String MWRA_PWID = "pwid";
        public static final String MWRA_WNAME = "kapr03";
        public static final String MWRA_HNAME = "kapr06";
        public static final String MWRA_KAPR07 = "kapr07";
        public static final String MWRA_KAPR08 = "kapr08";
        public static final String MWRA_HHNAME = "kapr09";
        public static final String MWRA_REGDT = "regdt";

        public static String _URI = "followups_pwreg.php";
    }
}