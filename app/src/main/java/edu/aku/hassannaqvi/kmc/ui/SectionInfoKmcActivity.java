package edu.aku.hassannaqvi.kmc.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import edu.aku.hassannaqvi.kmc.R;
import edu.aku.hassannaqvi.kmc.contracts.FormsContract;
import edu.aku.hassannaqvi.kmc.core.DatabaseHelper;
import edu.aku.hassannaqvi.kmc.core.MainApp;
import edu.aku.hassannaqvi.kmc.databinding.ActivitySectionInfoKmcBinding;
import edu.aku.hassannaqvi.kmc.validation.validatorClass;

public class SectionInfoKmcActivity extends Activity {

    ArrayList<String> lablesUCs;
    Map<String, String> ucsMap;


    private static final String TAG = SectionInfoKmcActivity.class.getName();
    String dtToday = new SimpleDateFormat("dd-MM-yy HH:mm").format(new Date().getTime());

    ActivitySectionInfoKmcBinding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_section_info_kmc);

        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_info_kmc);
        bi.setCallback(this);


        lablesUCs = new ArrayList<>();
        ucsMap = new HashMap<>();

        lablesUCs.add("Select UC..");
        lablesUCs.add("UC1");
        lablesUCs.add("UC2");


        bi.crauc.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, lablesUCs));

    }


    private boolean formValidation() {

        if (bi.crauc.getSelectedItemPosition() == 0) {
            Toast.makeText(this, "ERROR(Empty)" + getString(R.string.cruc), Toast.LENGTH_SHORT).show();
            ((TextView) bi.crauc.getSelectedView()).setText("This Data is Required");
            ((TextView) bi.crauc.getSelectedView()).setTextColor(Color.RED);
            bi.crauc.requestFocus();
            Log.i(TAG, "spTehsil: This Data is Required!");
            return false;
        } else {
            ((TextView) bi.crauc.getSelectedView()).setError(null);
        }


        if (!validatorClass.EmptyTextBox(this, bi.cravillage, getString(R.string.crvillage))) {
            return false;
        }


        if (!validatorClass.EmptyTextBox(this, bi.cra02, getString(R.string.cra02))) {
            return false;
        }


        if (!validatorClass.EmptyTextBox(this, bi.cra03, getString(R.string.cra03))) {
            return false;
        }


        if (!validatorClass.EmptyTextBox(this, bi.cra04, getString(R.string.cra04))) {
            return false;
        }


        if (!validatorClass.EmptyTextBox(this, bi.cra05, getString(R.string.cra05))) {
            return false;
        }


        return validatorClass.EmptyTextBox(this, bi.cra06, getString(R.string.cra06));
    }


    private void SaveDraft() throws JSONException {

        Toast.makeText(this, "Saving Draft for this Section", Toast.LENGTH_SHORT).show();
        SharedPreferences sharedPref = getSharedPreferences("tagName", MODE_PRIVATE);
        MainApp.fc = new FormsContract();

        MainApp.fc.setDevicetagID(sharedPref.getString("tagName", null));
        MainApp.fc.setFormDate(new SimpleDateFormat("dd-MM-yy HH:mm").format(new Date().getTime()));
        MainApp.fc.setUser(MainApp.userName);
        MainApp.fc.setDeviceID(Settings.Secure.getString(getApplicationContext().getContentResolver(),
                Settings.Secure.ANDROID_ID));
        MainApp.fc.setAppversion(MainApp.versionName + "." + MainApp.versionCode);

        JSONObject sInfo = new JSONObject();

        sInfo.put("uc_code", bi.crauc.getSelectedItem().toString());
        sInfo.put("cravillage", bi.cravillage.getText().toString());
        sInfo.put("cra02", bi.cra02.getText().toString());
        sInfo.put("cra03", bi.cra03.getText().toString());
        sInfo.put("cra04", bi.cra04.getText().toString());
        sInfo.put("cra05", bi.cra05.getText().toString());
        sInfo.put("cra06", bi.cra06.getText().toString());


        MainApp.fc.setsInfo(String.valueOf(sInfo));
    }


    public void BtnEnd() {
        Toast.makeText(this, "Processing End Section", Toast.LENGTH_SHORT).show();
        if (formValidation()) {
            try {
                SaveDraft();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (UpdateDB()) {
                Toast.makeText(this, "Starting Ending Section", Toast.LENGTH_SHORT).show();

                finish();

                startActivity(new Intent(this, EndingActivity.class));

            } else {
                Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void BtnContinue() {

        Toast.makeText(this, "Processing This Section", Toast.LENGTH_SHORT).show();
        if (formValidation()) {
            try {
                SaveDraft();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (UpdateDB()) {
                Toast.makeText(this, "Starting Ending Section", Toast.LENGTH_SHORT).show();

                finish();

                startActivity(new Intent(this, SectionA1Activity.class));

            } else {
                Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
            }
        }
    }


    private boolean UpdateDB() {

        DatabaseHelper db = new DatabaseHelper(this);

        long updcount = db.addForm(MainApp.fc);

        MainApp.fc.set_ID(String.valueOf(updcount));

        if (updcount != 0) {
            Toast.makeText(this, "Updating Database... Successful!", Toast.LENGTH_SHORT).show();

            MainApp.fc.setUID(
                    (MainApp.fc.getDeviceID() + MainApp.fc.get_ID()));
            db.updateFormID();
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
        }
        return true;
    }

}