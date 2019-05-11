package edu.aku.hassannaqvi.kmc_screening.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.os.Bundle;
import android.provider.Settings;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.aku.hassannaqvi.kmc_screening.R;
import edu.aku.hassannaqvi.kmc_screening.contracts.EligibleContract;
import edu.aku.hassannaqvi.kmc_screening.contracts.FormsContract;
import edu.aku.hassannaqvi.kmc_screening.contracts.PWScreenedContract;
import edu.aku.hassannaqvi.kmc_screening.contracts.TalukasContract;
import edu.aku.hassannaqvi.kmc_screening.contracts.UCsContract;
import edu.aku.hassannaqvi.kmc_screening.contracts.VillagesContract;
import edu.aku.hassannaqvi.kmc_screening.core.DatabaseHelper;
import edu.aku.hassannaqvi.kmc_screening.core.MainApp;
import edu.aku.hassannaqvi.kmc_screening.databinding.ActivitySectionInfoKmcBinding;
import edu.aku.hassannaqvi.kmc_screening.ui.form1.SectionAForm1Activity;
import edu.aku.hassannaqvi.kmc_screening.ui.form2.SectionBForm2Activity;
import edu.aku.hassannaqvi.kmc_screening.ui.other.EndingActivity;
import edu.aku.hassannaqvi.kmc_screening.validation.ClearClass;
import edu.aku.hassannaqvi.kmc_screening.validation.ValidatorClass;

import static edu.aku.hassannaqvi.kmc_screening.core.MainApp.fc;


public class SectionInfoKmcActivity extends Activity {

    private List<String> ucName, talukaNames, villageNames, wName, partNam;
    private List<String> ucCode, talukaCodes, villageCodes, wSno;
    private DatabaseHelper db;
    private Map<String, PWScreenedContract> mapWRA;
    private Map<String, EligibleContract> mapPartElig;
    private static final String TAG = SectionInfoKmcActivity.class.getName();
    ActivitySectionInfoKmcBinding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_info_kmc);
        bi.setCallback(this);
        db = new DatabaseHelper(getApplicationContext());

        settingListeners();
        populateSpinner(this);

    }

    private void settingListeners() {
        bi.kapr02a.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                setupFields(View.GONE);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        bi.kf1a2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0) return;
                bi.kf1a3.setText(mapWRA.get(bi.kf1a2.getSelectedItem()).getPw_serial());
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        bi.kf2a6.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0) return;
                bi.kf2a7.setText(mapPartElig.get(bi.kf2a6.getSelectedItem()).getM_name());
                bi.kf2a8.setText(mapPartElig.get(bi.kf2a6.getSelectedItem()).getM_serial());
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    public void populateSpinner(final Context context) {
        // Spinner Drop down elements
        talukaNames = new ArrayList<>();
        talukaCodes = new ArrayList<>();

        talukaNames.add("....");
        talukaCodes.add("....");

        Collection<TalukasContract> dc = db.getAllDistricts();
        Log.d(TAG, "onCreate: " + dc.size());
        for (TalukasContract d : dc) {
            talukaNames.add(d.getDistrictName());
            talukaCodes.add(d.getDistrictCode());
        }

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(context,
                android.R.layout.simple_spinner_dropdown_item, talukaNames);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        bi.crataluka.setAdapter(dataAdapter);

        bi.crataluka.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if (position == 0) return;

                ucCode = new ArrayList<>();
                ucName = new ArrayList<>();
                ucCode.add("....");
                ucName.add("....");

                Collection<UCsContract> pc = db.getAllUCsByTalukas(talukaCodes.get(position));
                for (UCsContract p : pc) {
                    ucCode.add(p.getUccode());
                    ucName.add(p.getUcsName());
                }
                ArrayAdapter<String> psuAdapter = new ArrayAdapter<>(context,
                        android.R.layout.simple_spinner_dropdown_item, ucName);

                psuAdapter
                        .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                bi.crauc.setAdapter(psuAdapter);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        bi.crauc.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if (position == 0) return;

                villageCodes = new ArrayList<>();
                villageNames = new ArrayList<>();

                villageCodes.add("....");
                villageNames.add("....");

                Collection<VillagesContract> pc = db.getAllPSUsByDistrict(talukaCodes.get(bi.crataluka.getSelectedItemPosition()), ucCode.get(position));
                for (VillagesContract p : pc) {
                    villageCodes.add(p.getVillageCode());
                    villageNames.add(p.getVillageName().split("\\|")[2]);
                }

                bi.crvillage.setAdapter(new ArrayAdapter<>(context, android.R.layout.simple_spinner_dropdown_item, villageNames));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    private boolean formValidation() {
        return ValidatorClass.EmptyCheckingContainer(this, bi.infoMainLayout);
    }

    private void SaveDraft() throws JSONException {

        SharedPreferences sharedPref = getSharedPreferences("tagName", MODE_PRIVATE);
        fc = new FormsContract();

        fc.setDevicetagID(sharedPref.getString("tagName", null));
        fc.setFormDate(new SimpleDateFormat("dd-MM-yy HH:mm").format(new Date().getTime()));
        fc.setUser(MainApp.userName);
        fc.setDeviceID(Settings.Secure.getString(getApplicationContext().getContentResolver(), Settings.Secure.ANDROID_ID));
        fc.setAppversion(MainApp.versionName + "." + MainApp.versionCode);
        fc.setTaluka(talukaCodes.get(bi.crataluka.getSelectedItemPosition()));
        fc.setUc(ucCode.get(bi.crauc.getSelectedItemPosition()));
        fc.setVillage(villageCodes.get(bi.crvillage.getSelectedItemPosition()));
        fc.setFormType(MainApp.formType);
        fc.setSurveyType(MainApp.surveyType);
        fc.setHhno(bi.kapr02a.getText().toString());

        JSONObject sInfo = new JSONObject();
        String fType = MainApp.formType;

        //
        sInfo.put(fType + "a1", bi.kfa1a.isChecked() ? "1" : bi.kfa1b.isChecked() ? "2" : "0");
        if (fType.equals("kf1")) {
            sInfo.put("kf1a2", bi.kf1a2.getSelectedItem());
            sInfo.put("kf1a3", bi.kf1a3.getText().toString());
            sInfo.put("kf1a4", bi.kf1a4.getText().toString());

            sInfo.put("pw_puid", mapWRA.get(bi.kf1a2.getSelectedItem()).getPuid());
            sInfo.put("pw_formdate", mapWRA.get(bi.kf1a2.getSelectedItem()).getFormdate());
            sInfo.put("pw_h_name", mapWRA.get(bi.kf1a2.getSelectedItem()).getH_name());
            sInfo.put("pw_cast", mapWRA.get(bi.kf1a2.getSelectedItem()).getCast());
            sInfo.put("pw_hh_name", mapWRA.get(bi.kf1a2.getSelectedItem()).getHh_name());

        } else if (fType.equals("kf2")) {
            sInfo.put("kf2a5", bi.kf2a1.getText().toString());
            sInfo.put("kf2a6", bi.kf2a2.getText().toString());
            sInfo.put("kf2a7", bi.kf2a3.getText().toString());
            sInfo.put("kf2a8", bi.kf2a4.getText().toString());
        } else if (fType.equals("kf3")) {
            sInfo.put("kf3a5", bi.kf3a3.getText().toString());
            sInfo.put("kf3a6", bi.kf3a4.getText().toString());
        }

        if (fType.equals("kf2") || fType.equals("kf3")) {
            sInfo.put(fType + "a2", bi.kf2a6.getSelectedItem().toString());
            sInfo.put(fType + "a3", bi.kf2a7.getText().toString());
            sInfo.put(fType + "a4", bi.kf2a8.getText().toString());

            sInfo.put("part_puid", mapPartElig.get(bi.kf2a6.getSelectedItem()).getPuid());
            sInfo.put("part_formdate", mapPartElig.get(bi.kf2a6.getSelectedItem()).getFormdate());
        }

        fc.setsInfo(String.valueOf(sInfo));

        setGPS();
    }

    public void BtnEnd() {
        if (formValidation()) {
            try {
                SaveDraft();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (UpdateDB()) {
                finish();
                startActivity(new Intent(this, EndingActivity.class).putExtra("complete", false));
            } else {
                Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void BtnContinue() {

        if (formValidation()) {
            try {
                SaveDraft();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (UpdateDB()) {
                finish();
                startActivity(new Intent(this, MainApp.formType.equals("kf1") ? SectionAForm1Activity.class
                        : MainApp.formType.equals("kf2") ? SectionBForm2Activity.class
                        : MainApp.formType.equals("kf3") ? SectionBForm2Activity.class : null));
            } else {
                Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private boolean ValidateSpinners() {
        if (bi.crataluka.getSelectedItemPosition() == 0) {
            Toast.makeText(this, "ERROR(Empty)" + getString(R.string.crataluka), Toast.LENGTH_SHORT).show();
            ((TextView) bi.crataluka.getSelectedView()).setText("This Data is Required");
            ((TextView) bi.crataluka.getSelectedView()).setTextColor(Color.RED);
            bi.crataluka.requestFocus();
            Log.i(TAG, "crataluka: This Data is Required!");
            return false;
        } else {
            ((TextView) bi.crataluka.getSelectedView()).setError(null);
        }


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


        if (bi.crvillage.getSelectedItemPosition() == 0) {
            Toast.makeText(this, "ERROR(Empty)" + getString(R.string.crvillage), Toast.LENGTH_SHORT).show();
            ((TextView) bi.crvillage.getSelectedView()).setText("This Data is Required");
            ((TextView) bi.crvillage.getSelectedView()).setTextColor(Color.RED);
            bi.crvillage.requestFocus();
            Log.i(TAG, "crvillage: This Data is Required!");
            return false;
        } else {
            ((TextView) bi.crvillage.getSelectedView()).setError(null);
        }


        return ValidatorClass.EmptyTextBox(this, bi.kapr02a, getString(R.string.kapr02));
    }

    public void BtnSearchWoman() {

        if (!ValidateSpinners()) return;

        if (MainApp.formType.equals("kf1")) {
            mapWRA = new HashMap<>();
            wName = new ArrayList<>();
            wName.add("....");

            Collection<PWScreenedContract> dc = db.getPWScreened(villageCodes.get(bi.crvillage.getSelectedItemPosition()), bi.kapr02a.getText().toString());
            Log.d(TAG, "onCreate: " + dc.size());
            for (PWScreenedContract d : dc) {
                wName.add(d.getPw_name());
                mapWRA.put(d.getPw_name(), d);
            }

            if (mapWRA.size() == 0) {
                setupFields(View.GONE);
                Toast.makeText(this, "Household does not exist ", Toast.LENGTH_LONG).show();
                return;
            }

            bi.kf1a2.setAdapter(new ArrayAdapter<>(SectionInfoKmcActivity.this, android.R.layout.simple_spinner_dropdown_item, wName));

        } else {
            mapPartElig = new HashMap<>();
            partNam = new ArrayList<>();
            partNam.add("....");

            Collection<EligibleContract> dc = db.getEligibileParticipant(villageCodes.get(bi.crvillage.getSelectedItemPosition()), bi.kapr02a.getText().toString());
            Log.d(TAG, "onCreate: " + dc.size());
            for (EligibleContract d : dc) {
                partNam.add(d.getPart_id());
                mapPartElig.put(d.getPart_id(), d);
            }

            if (mapPartElig.size() == 0) {
                setupFields(View.GONE);
                Toast.makeText(this, "Household does not exist ", Toast.LENGTH_LONG).show();
                return;
            }

            bi.kf2a6.setAdapter(new ArrayAdapter<>(SectionInfoKmcActivity.this, android.R.layout.simple_spinner_dropdown_item, partNam));

        }

        Toast.makeText(this, "Household number exists", Toast.LENGTH_LONG).show();
        setupFields(View.VISIBLE);

    }

    private boolean UpdateDB() {

        DatabaseHelper db = new DatabaseHelper(this);

        long updcount = db.addForm(fc);

        fc.set_ID(String.valueOf(updcount));

        if (updcount > 0) {
            Toast.makeText(this, "Updating Database... Successful!", Toast.LENGTH_SHORT).show();

            fc.setUID(
                    (fc.getDeviceID() + fc.get_ID()));
            db.updateFormID();
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
        }

        return true;
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

            fc.setGpsLat(lat);
            fc.setGpsLng(lang);
            fc.setGpsAcc(acc);
            fc.setGpsDT(date); // Timestamp is converted to date above
            fc.setGpsAltitude(elevation);

            Toast.makeText(this, "GPS set", Toast.LENGTH_SHORT).show();

        } catch (Exception e) {
            Log.e(TAG, "setGPS: " + e.getMessage());
        }

    }

    private void setupFields(int status) {
        bi.fldGrpcra02.setVisibility(status);
        bi.fldGrpbtn.setVisibility(status);

        if (MainApp.formType.equals("kf1")) {
            bi.form01.setVisibility(status);
            ClearClass.ClearAllFields(bi.form01, null);
        } else if (MainApp.formType.equals("kf2")) {
            bi.form02.setVisibility(status);
            bi.form0203.setVisibility(status);
            ClearClass.ClearAllFields(bi.form02, null);
            ClearClass.ClearAllFields(bi.form0203, null);
        } else if (MainApp.formType.equals("kf3")) {
            bi.form0203.setVisibility(status);
            bi.form03.setVisibility(status);
            ClearClass.ClearAllFields(bi.form0203, null);
            ClearClass.ClearAllFields(bi.form03, null);
        }
        bi.kfa1.clearCheck();
    }

}