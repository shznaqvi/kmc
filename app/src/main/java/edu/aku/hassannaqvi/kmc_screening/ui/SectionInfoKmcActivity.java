package edu.aku.hassannaqvi.kmc_screening.ui;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
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
import edu.aku.hassannaqvi.kmc_screening.contracts.RegisteredPWContract;
import edu.aku.hassannaqvi.kmc_screening.contracts.TalukasContract;
import edu.aku.hassannaqvi.kmc_screening.contracts.UCsContract;
import edu.aku.hassannaqvi.kmc_screening.contracts.VillagesContract;
import edu.aku.hassannaqvi.kmc_screening.core.DatabaseHelper;
import edu.aku.hassannaqvi.kmc_screening.core.MainApp;
import edu.aku.hassannaqvi.kmc_screening.databinding.ActivitySectionInfoKmcBinding;
import edu.aku.hassannaqvi.kmc_screening.other.DateUtils;
import edu.aku.hassannaqvi.kmc_screening.ui.form1.SectionAForm1Activity;
import edu.aku.hassannaqvi.kmc_screening.ui.form2.SectionBForm2Activity;
import edu.aku.hassannaqvi.kmc_screening.ui.form3.SectionBForm3Activity;
import edu.aku.hassannaqvi.kmc_screening.ui.other.EndingActivity;
import edu.aku.hassannaqvi.kmc_screening.validation.ClearClass;
import edu.aku.hassannaqvi.kmc_screening.validation.ValidatorClass;

import static edu.aku.hassannaqvi.kmc_screening.core.MainApp.fc;


public class SectionInfoKmcActivity extends AppCompatActivity {

    private List<String> ucName, talukaNames, villageNames, partNam;
    private List<String> talukaCodes, villageCodes;
    private Map<String, UCsContract> uc;
    private DatabaseHelper db;
    private PWScreenedContract mapWRA;
    private Map<String, EligibleContract> mapPartElig;
    private static final String TAG = SectionInfoKmcActivity.class.getName();
    ActivitySectionInfoKmcBinding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_info_kmc);
        bi.setCallback(this);
        db = new DatabaseHelper(getApplicationContext());

        settingComponent();
        settingListeners();
        populateSpinner(this);

    }

    private void settingComponent() {
        this.setTitle(MainApp.formType.equals("kf1") ? getString(R.string.f1_hA) : getString(R.string.f2_3_hA));

        switch (MainApp.formType) {
            case "kf1":
                break;
            case "kf2":
                break;
            case "kf3":
                bi.fldGrpkfal.setVisibility(View.GONE);
                break;
        }

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
        bi.kf2a6.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0) return;
                bi.kf2a7.setText(mapPartElig.get(bi.kf2a6.getSelectedItem()).getM_name());
                bi.kf2a8.setText(mapPartElig.get(bi.kf2a6.getSelectedItem()).getM_id());
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        bi.kf2a4.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (bi.kf2a4.getText().toString().isEmpty()) return;
                if (Integer.valueOf(bi.kf2a4.getText().toString()) < 2) return;

                bi.kf2a5.setMaxvalue(Float.valueOf(bi.kf2a4.getText().toString()) - 1);
            }

            @Override
            public void afterTextChanged(Editable editable) {

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

                setupFields(View.GONE);

                if (position == 0) return;

                uc = new HashMap<>();
                ucName = new ArrayList<>();
                ucName.add("....");

                Collection<UCsContract> pc = db.getAllUCsByTalukas(talukaCodes.get(position));
                for (UCsContract p : pc) {
                    ucName.add(p.getUcsName());
                    uc.put(p.getUcsName(), p);
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

                setupFields(View.GONE);

                if (position == 0) return;

                villageCodes = new ArrayList<>();
                villageNames = new ArrayList<>();

                villageCodes.add("....");
                villageNames.add("....");

                MainApp.armType = uc.get(bi.crauc.getSelectedItem()).getStudy_arm();

                Collection<VillagesContract> pc = db.getAllPSUsByDistrict(talukaCodes.get(bi.crataluka.getSelectedItemPosition()), uc.get(bi.crauc.getSelectedItem()).getUccode());
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

        bi.crvillage.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                setupFields(View.GONE);
                bi.kapr02a.setText(null);

                if (i == 0) return;
                bi.villageLabel.setText("Village Code: " + villageCodes.get(bi.crvillage.getSelectedItemPosition()));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    private boolean formValidation() {
        if (!ValidatorClass.EmptyCheckingContainer(this, bi.infoMainLayout))
            return false;

        String type = "", pwid = "", followupNo = "";
        switch (MainApp.formType) {
            case "kf1":
                type = MainApp.FORMTYPE1;
                pwid = bi.kapr02a.getText().toString() + "-" + bi.kf1a3.getText().toString();
                break;
            case "kf2":
                type = MainApp.FORMTYPE2;
                pwid = bi.kapr02a.getText().toString() + "-" + bi.kf2a6.getSelectedItem().toString();
                break;
            case "kf3":
                type = MainApp.FORMTYPE3;
                pwid = bi.kapr02a.getText().toString() + "-" + bi.kf2a6.getSelectedItem().toString();
                break;
        }

        followupNo = bi.kf3b01a.isChecked() ? "1"
                : bi.kf3b01b.isChecked() ? "2"
                : bi.kf3b01c.isChecked() ? "3"
                : bi.kf3b01d.isChecked() ? "4"
                : bi.kf3b01e.isChecked() ? "5"
                : bi.kf3b01f.isChecked() ? "6"
                : bi.kf3b01g.isChecked() ? "7"
                : bi.kf3b01h.isChecked() ? "8"
                : bi.kf3b01i.isChecked() ? "9"
                : bi.kf3b01j.isChecked() ? "10"
                : bi.kf3b01k.isChecked() ? "11"
                : bi.kf3b01l.isChecked() ? "12"
                : "";

        RegisteredPWContract dc = db.checkPWExist(type, villageCodes.get(bi.crvillage.getSelectedItemPosition()) + (MainApp.formType.equals("kf3") ? "-" + followupNo : ""), pwid);
        if (dc == null) {

            if (!checkFormExist(villageCodes.get(bi.crvillage.getSelectedItemPosition()),
                    MainApp.formType,
                    bi.kapr02a.getText().toString(),
                    MainApp.formType.equals("kf1") ? bi.kf1a3.getText().toString() : bi.kf2a6.getSelectedItem().toString(),
                    followupNo
            )) {
                Toast.makeText(this, "Form is already exist!!", Toast.LENGTH_SHORT).show();
                return false;
            }

        } else {
            Toast.makeText(this, "Form is already exist!!", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;

    }

    private boolean checkFormExist(String villageCode, String formType, String pwid, String screendid, String followUpNo) {
        FormsContract dc = db.getFormExistance(villageCode, formType, pwid, screendid, followUpNo);
        return dc == null;
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
        fc.setUc(uc.get(bi.crauc.getSelectedItem()).getUccode());
        fc.setVillage(villageCodes.get(bi.crvillage.getSelectedItemPosition()));
        fc.setFormType(MainApp.formType);
        fc.setSurveyType(MainApp.surveyType);
        fc.setPwid(bi.kapr02a.getText().toString());

        JSONObject sInfo = new JSONObject();
        String fType = MainApp.formType;

        sInfo.put(fType + "a01", bi.kfa1a.isChecked() ? "1" : bi.kfa1b.isChecked() ? "2" : "0");
        if (fType.equals("kf1")) {
            sInfo.put("kf1a02", bi.kf1a2.getText().toString());

            sInfo.put("kf1a03", bi.kf1a3.getText().toString());
            fc.setScreenid(bi.kf1a3.getText().toString());

            sInfo.put("kf1a04", bi.kf1a4.getText().toString());
            sInfo.put("kf1a05", bi.kf1a5a.isChecked() ? "1" : bi.kf1a5b.isChecked() ? "2" : "0");

            sInfo.put("kf1a06", bi.kf1a6.getText().toString());
            sInfo.put("kf1a07", bi.kf1a7.getText().toString());
            sInfo.put("kf1a08", bi.kf1a8a.isChecked() ? "1"
                    : bi.kf1a8b.isChecked() ? "2"
                    : bi.kf1a8c.isChecked() ? "3"
                    : bi.kf1a896.isChecked() ? "96"
                    : "0");
            sInfo.put("kf1a8cx", bi.kf1a8cx.getText().toString());
            sInfo.put("kf1a896x", bi.kf1a896x.getText().toString());

            sInfo.put("pw_puid", mapWRA.getPuid());
            sInfo.put("pw_formdate", mapWRA.getFormdate());
            sInfo.put("pw_h_name", mapWRA.getH_name());
            sInfo.put("pw_cast", mapWRA.getCast());
            sInfo.put("pw_hh_name", mapWRA.getHh_name());

        } else if (fType.equals("kf2")) {
            sInfo.put("kf2a05", bi.kf2a1.getText().toString());
            sInfo.put("kf2a06", bi.kf2a2.getText().toString());
            sInfo.put("kf2a07", bi.kf2a3.getText().toString());
            sInfo.put("kf2a08", bi.kf2a4.getText().toString());
            sInfo.put("kf2a09", bi.kf2a5.getText().toString());
        } else if (fType.equals("kf3")) {
            /*sInfo.put("kf3a05", bi.kf3a3.getText().toString());
            sInfo.put("kf3a06", bi.kf3a4.getText().toString());*/
            sInfo.put("kf3b01", bi.kf3b01a.isChecked() ? "1"
                    : bi.kf3b01b.isChecked() ? "2"
                    : bi.kf3b01c.isChecked() ? "3"
                    : bi.kf3b01d.isChecked() ? "4"
                    : bi.kf3b01e.isChecked() ? "5"
                    : bi.kf3b01f.isChecked() ? "6"
                    : bi.kf3b01g.isChecked() ? "7"
                    : bi.kf3b01h.isChecked() ? "8"
                    : bi.kf3b01i.isChecked() ? "9"
                    : bi.kf3b01j.isChecked() ? "10"
                    : bi.kf3b01k.isChecked() ? "11"
                    : bi.kf3b01l.isChecked() ? "12"
                    : "0");
        }

        if (fType.equals("kf2") || fType.equals("kf3")) {

            sInfo.put(fType + "a02", bi.kf2a6.getSelectedItem().toString());
            fc.setScreenid(bi.kf2a6.getSelectedItem().toString());

            sInfo.put(fType + "a03", bi.kf2a7.getText().toString());
            sInfo.put(fType + "a04", bi.kf2a8.getText().toString());

            sInfo.put("part_puid", mapPartElig.get(bi.kf2a6.getSelectedItem()).getPuid());
            sInfo.put("part_formdate", mapPartElig.get(bi.kf2a6.getSelectedItem()).getFormdate());
        }

        fc.setsInfo(String.valueOf(sInfo));

        setGPS();
    }

    public void BtnEnd() {

        if (formValidation()) {
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                    SectionInfoKmcActivity.this);
            alertDialogBuilder
                    .setMessage("Do you want to Exit??")
                    .setCancelable(false)
                    .setPositiveButton("Yes",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog,
                                                    int id) {

                                    try {
                                        SaveDraft();
                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    }
                                    if (UpdateDB()) {
                                        finish();
                                        startActivity(new Intent(SectionInfoKmcActivity.this, EndingActivity.class).putExtra("complete", false));
                                    } else {
                                        Toast.makeText(SectionInfoKmcActivity.this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
                                    }
                                }


                            });
            alertDialogBuilder.setNegativeButton("No",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.cancel();
                        }
                    });
            AlertDialog alert = alertDialogBuilder.create();
            alert.show();
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
                        : MainApp.formType.equals("kf3") ? SectionBForm3Activity.class : null)
                        .putExtra("pwid", bi.kapr02a.getText().toString())
                        .putExtra("hfScreen", bi.kfa1a.isChecked())
                        .putExtra("dayFlag", bi.kf3b01a.isChecked()));
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


        return ValidatorClass.EmptyTextBox(this, bi.kapr02a, getString(R.string.kapr01));
    }

    public void BtnSearchWoman() {

        if (!ValidateSpinners()) return;

        if (MainApp.formType.equals("kf1")) {

            mapWRA = db.getPWScreened(villageCodes.get(bi.crvillage.getSelectedItemPosition()), bi.kapr02a.getText().toString());

            if (mapWRA == null)
                mapWRA = db.getPWScreened("kf0a", villageCodes.get(bi.crvillage.getSelectedItemPosition()), bi.kapr02a.getText().toString());

            if (mapWRA == null) {
                setupFields(View.GONE);
                Toast.makeText(this, "Household does not exist ", Toast.LENGTH_LONG).show();
                return;
            }

            bi.kf1a2.setText(mapWRA.getPw_name());

        } else {
            mapPartElig = new HashMap<>();
            partNam = new ArrayList<>();
            partNam.add("....");

            Collection<EligibleContract> dc;

            String fType = MainApp.formType;
            if (fType.equals("kf2"))
                dc = db.getEligibileParticipant(villageCodes.get(bi.crvillage.getSelectedItemPosition()), bi.kapr02a.getText().toString());
            else
                dc = (Collection<EligibleContract>) db.getRecruitmentParticipant(villageCodes.get(bi.crvillage.getSelectedItemPosition()), bi.kapr02a.getText().toString());

            for (Object d : dc) {
                partNam.add(((EligibleContract) d).getScreen_id());
                mapPartElig.put(((EligibleContract) d).getScreen_id(), ((EligibleContract) d));
            }

            if (mapPartElig.size() == 0) {
                dc = db.getEligibleParticipantFromPDADB(villageCodes.get(bi.crvillage.getSelectedItemPosition()), bi.kapr02a.getText().toString(), fType.equals("kf2") ? "kf1" : "kf2");
                for (Object d : dc) {
                    partNam.add(((EligibleContract) d).getScreen_id());
                    mapPartElig.put(((EligibleContract) d).getScreen_id(), ((EligibleContract) d));
                }

                if (mapPartElig.size() == 0) {
                    setupFields(View.GONE);
                    Toast.makeText(this, "Household does not exist ", Toast.LENGTH_LONG).show();
                    return;
                }
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
            bi.kf1a6.setMinDate(DateUtils.getDaysBack("dd/MM/yyyy", -2));
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