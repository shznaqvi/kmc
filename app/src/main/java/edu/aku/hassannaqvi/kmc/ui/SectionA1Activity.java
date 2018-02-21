package edu.aku.hassannaqvi.kmc.ui;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.View;
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
import edu.aku.hassannaqvi.kmc.databinding.ActivitySectionA1Binding;
import edu.aku.hassannaqvi.kmc.other.MembersCount;
import edu.aku.hassannaqvi.kmc.validation.validatorClass;

public class SectionA1Activity extends AppCompatActivity {

    private static final String TAG = SectionA1Activity.class.getName();
    ActivitySectionA1Binding binding;
    String dtToday = new SimpleDateFormat("dd-MM-yy HH:mm").format(new Date().getTime());
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_section_a1);
        db = new DatabaseHelper(this);
        binding.setCallback(this);

        SetupViewFunctionality();
    }

    public void SetupViewFunctionality() {

        //  Members Initialization
        MainApp.membersCount = new MembersCount();

        //  Setting members in map for Section A2
        Map<Integer, Map<Integer, Integer>> mem = new HashMap<>();
        Map<Integer, Integer> memType = new HashMap<>();
        memType.put(1, 0);
        memType.put(2, 0);

        mem.put(1, memType);
        mem.put(2, memType);
        mem.put(3, memType);

        MainApp.membersCount.setMembers(mem);
        MainApp.membersCount.setMwra(0);

        MainApp.members_f_m = new ArrayList<>();
        MainApp.all_members = new ArrayList<>();
        MainApp.childUnder2 = new ArrayList<>();
        MainApp.childUnder5 = new ArrayList<>();
        MainApp.childUnder5 = new ArrayList<>();
        MainApp.mwra = new ArrayList<>();
        MainApp.adolescents = new ArrayList<>();
        MainApp.serial_no = 0;

//        Checking IsHead
        MainApp.IsHead = false;

//        Listener

        binding.na102.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                binding.fldGrpna101.setVisibility(View.GONE);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

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

                startActivity(new Intent(this, SectionA2Activity.class));

            } else {
                Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
            }
        }
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

    public boolean formValidation() {

        Toast.makeText(this, "Validating This Section ", Toast.LENGTH_SHORT).show();

//        na102
        if (!validatorClass.EmptyTextBox(this, binding.na102, getString(R.string.na102))) {
            return false;
        }
/*

//        na101a
        if (!validatorClass.EmptySpinner(this, binding.na101a, "Province")) {
            return false;
        }
//        na101b
        if (!validatorClass.EmptySpinner(this, binding.na101b, "District")) {
            return false;
        }
//        na101c
        if (!validatorClass.EmptySpinner(this, binding.na101c, "Tehsil/Taluka")) {
            return false;
        }
//        na101d
        if (!validatorClass.EmptySpinner(this, binding.na101d, "City/Village")) {
            return false;
        }
*/

//        na103
        if (!validatorClass.EmptyTextBox(this, binding.na103, getString(R.string.na103))) {
            return false;
        }

        String[] str = binding.na103.getText().toString().split("-");
        if (str.length > 2 || binding.na103.getText().toString().charAt(3) != '-' || !str[0].matches("[0-9]+")) {
            binding.na103.setError("Wrong presentation!!");
            return false;
        }

//        na105
        if (!validatorClass.EmptyTextBox(this, binding.na105, getString(R.string.na105))) {
            return false;
        }
//        na107
        if (!validatorClass.EmptyTextBox(this, binding.na107, getString(R.string.na107))) {
            return false;
        }
//        na108
        if (!validatorClass.EmptyTextBox(this, binding.na108, getString(R.string.na108))) {
            return false;
        }

//        na213
        if (!validatorClass.EmptyTextBox(this, binding.na213, getString(R.string.na213))) {
            return false;
        }

//        na11101blood
        if (!validatorClass.EmptyRadioButton(this, binding.na11101blood, binding.na11101bloodb, getString(R.string.na11101blood))) {
            return false;
        }
//        na11102water
        if (!validatorClass.EmptyRadioButton(this, binding.na11102water, binding.na11102waterb, getString(R.string.na11102water))) {
            return false;
        }
//        na11201
        if (!validatorClass.EmptyRadioButton(this, binding.na11201, binding.na11201b, getString(R.string.na11201))) {
            return false;
        }
//        na11202
        if (!validatorClass.EmptyRadioButton(this, binding.na11202, binding.na11202b, getString(R.string.na11202))) {
            return false;
        }

        if (!(binding.na11101blooda.isChecked() && binding.na11202a.isChecked())) {
            binding.na11202a.setError("Wrong Selection");
            Toast.makeText(this, "Wrong Selection", Toast.LENGTH_SHORT).show();

            return false;
        }

//        na113
        if (binding.na11201b.isChecked()) {
            if (!validatorClass.EmptyCheckBox(this, binding.fldGrpna113, binding.na11396, binding.na11396x, String.valueOf(R.string.na113))) {
                return false;
            }
        }

        return true;
    }

    private void SaveDraft() throws JSONException {
        Toast.makeText(this, "Saving Draft for  This Section", Toast.LENGTH_SHORT).show();

        MainApp.fc = new FormsContract();

        MainApp.fc.setDevicetagID(MainApp.getTagName(this));
        MainApp.fc.setFormDate(dtToday);
        MainApp.fc.setUser(MainApp.userName);
        MainApp.fc.setDeviceID(Settings.Secure.getString(getApplicationContext().getContentResolver(),
                Settings.Secure.ANDROID_ID));
        MainApp.fc.setAppversion(MainApp.versionName + "." + MainApp.versionCode);

        setGPS(); // Set GPS

        JSONObject sA1 = new JSONObject();

        MainApp.fc.setsA1(String.valueOf(sA1));


    }

    public void setGPS() {
        SharedPreferences GPSPref = getSharedPreferences("GPSCoordinates", Context.MODE_PRIVATE);
        try {
            String lat = GPSPref.getString("Latitude", "0");
            String lang = GPSPref.getString("Longitude", "0");
            String acc = GPSPref.getString("Accuracy", "0");
            String elevation = GPSPref.getString("Elevation", "0");

            if (lat == "0" && lang == "0") {
                Toast.makeText(this, "Could not obtained GPS points", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "GPS set", Toast.LENGTH_SHORT).show();
            }

            String date = DateFormat.format("dd-MM-yyyy HH:mm", Long.parseLong(GPSPref.getString("Time", "0"))).toString();

            MainApp.fc.setGpsLat(lat);
            MainApp.fc.setGpsLng(lang);
            MainApp.fc.setGpsAcc(acc);
            MainApp.fc.setGpsDT(date); // Timestamp is converted to date above
            MainApp.fc.setGpsElev(elevation);

            Toast.makeText(this, "GPS set", Toast.LENGTH_SHORT).show();

        } catch (Exception e) {
            Log.e(TAG, "setGPS: " + e.getMessage());
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
            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }
    }

    public void BtnCheckHH() {

    }

    public void BtnCheckEnm() {

        if (validatorClass.EmptyTextBox(this, binding.na102, getString(R.string.na102))) {

            String selected = db.getEnumBlock(binding.na102.getText().toString());
            if (!selected.equals("")) {

                String[] selSplit = selected.split("\\|");

                binding.na101a.setText(selSplit[0]);
                binding.na101b.setText(selSplit[1].equals("") ? "----" : selSplit[1]);
                binding.na101c.setText(selSplit[2].equals("") ? "----" : selSplit[2]);
                binding.na101d.setText(selSplit[3]);

                binding.fldGrpna101.setVisibility(View.VISIBLE);

            } else {
                Toast.makeText(this, "Sorry not found any block", Toast.LENGTH_SHORT).show();
            }

        }
    }
}
