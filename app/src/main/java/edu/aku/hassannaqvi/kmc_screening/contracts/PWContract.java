package edu.aku.hassannaqvi.kmc_screening.contracts;

import android.database.Cursor;
import android.provider.BaseColumns;

import org.json.JSONException;
import org.json.JSONObject;

public class PWContract {

    public String uid;
    public String village;
    public String round;
    public String fupdt;
    public String hhno;
    public String wserial;
    public String hname;
    public String wname;
    public String kapr07;
    public String kapr08;
    public String hhname;


    public PWContract() {
    }

    public PWContract sync(JSONObject jsonObject) throws JSONException {

        this.uid = jsonObject.getString(PWEntry.MWRA_UID);
        this.village = jsonObject.getString(PWEntry.MWRA_VILLAGE);
        this.round = jsonObject.getString(PWEntry.MWRA_ROUND);
        this.fupdt = jsonObject.getString(PWEntry.MWRA_FUPDT);
        this.hhno = jsonObject.getString(PWEntry.MWRA_HHNO);
        this.hname = jsonObject.getString(PWEntry.MWRA_HNAME);
        this.wname = jsonObject.getString(PWEntry.MWRA_WNAME);
        this.kapr07 = jsonObject.getString(PWEntry.MWRA_KAPR07);
        this.kapr08 = jsonObject.getString(PWEntry.MWRA_KAPR08);
        this.hhname = jsonObject.getString(PWEntry.MWRA_HHNAME);
        this.wserial = jsonObject.getString(PWEntry.MWRA_WSERIAL);

        return this;
    }

    public PWContract hydrate(Cursor cursor) {

        this.uid = cursor.getString(cursor.getColumnIndex(PWEntry.MWRA_UID));
        this.village = cursor.getString(cursor.getColumnIndex(PWEntry.MWRA_VILLAGE));
        this.round = cursor.getString(cursor.getColumnIndex(PWEntry.MWRA_ROUND));
        this.fupdt = cursor.getString(cursor.getColumnIndex(PWEntry.MWRA_FUPDT));
        this.hhno = cursor.getString(cursor.getColumnIndex(PWEntry.MWRA_HHNO));
        this.hname = cursor.getString(cursor.getColumnIndex(PWEntry.MWRA_HNAME));
        this.wname = cursor.getString(cursor.getColumnIndex(PWEntry.MWRA_WNAME));
        this.kapr07 = cursor.getString(cursor.getColumnIndex(PWEntry.MWRA_KAPR07));
        this.kapr08 = cursor.getString(cursor.getColumnIndex(PWEntry.MWRA_KAPR08));
        this.hhname = cursor.getString(cursor.getColumnIndex(PWEntry.MWRA_HHNAME));
        this.wserial = cursor.getString(cursor.getColumnIndex(PWEntry.MWRA_WSERIAL));

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

    public String getHhno() {
        return hhno;
    }

    public void setHhno(String hhno) {
        this.hhno = hhno;
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

    public String getWserial() {
        return wserial;
    }

    public void setWserial(String wserial) {
        this.wserial = wserial;
    }

    public JSONObject toJSONObject() throws JSONException {
        JSONObject json = new JSONObject();

        json.put(PWEntry.MWRA_UID, this.uid == null ? JSONObject.NULL : this.uid);
        json.put(PWEntry.MWRA_VILLAGE, this.village == null ? JSONObject.NULL : this.village);
        json.put(PWEntry.MWRA_ROUND, this.round == null ? JSONObject.NULL : this.round);
        json.put(PWEntry.MWRA_FUPDT, this.fupdt == null ? JSONObject.NULL : this.fupdt);
        json.put(PWEntry.MWRA_HHNO, this.hhno == null ? JSONObject.NULL : this.hhno);
        json.put(PWEntry.MWRA_HNAME, this.hname == null ? JSONObject.NULL : this.hname);
        json.put(PWEntry.MWRA_WNAME, this.wname == null ? JSONObject.NULL : this.wname);
        json.put(PWEntry.MWRA_KAPR07, this.kapr07 == null ? JSONObject.NULL : this.kapr07);
        json.put(PWEntry.MWRA_KAPR08, this.kapr08 == null ? JSONObject.NULL : this.kapr08);
        json.put(PWEntry.MWRA_HHNAME, this.hhname == null ? JSONObject.NULL : this.hhname);
        json.put(PWEntry.MWRA_WSERIAL, this.wserial == null ? JSONObject.NULL : this.wserial);

        return json;

    }

    public static abstract class PWEntry implements BaseColumns {

        public static final String TABLE_NAME = "pws";
        public static final String MWRA_NULLABLE = "NULLHACK";
        public static final String MWRA_UID = "_uid";
        public static final String MWRA_VILLAGE = "village";
        public static final String MWRA_ROUND = "round";
        public static final String MWRA_FUPDT = "fupdt";
        public static final String MWRA_HHNO = "hhno";
        public static final String MWRA_WSERIAL = "kapr02";
        public static final String MWRA_WNAME = "kapr03";
        public static final String MWRA_HNAME = "kapr06";
        public static final String MWRA_KAPR07 = "kapr07";
        public static final String MWRA_KAPR08 = "kapr08";
        public static final String MWRA_HHNAME = "kapr09";

        public static String _URI = "followups_pwreg.php";
    }
}