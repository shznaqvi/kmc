package edu.aku.hassannaqvi.kmc_screening.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.os.Bundle;
import android.provider.Settings;
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
import java.util.List;
import java.util.Map;

import edu.aku.hassannaqvi.kmc_screening.R;
import edu.aku.hassannaqvi.kmc_screening.contracts.FormsContract;
import edu.aku.hassannaqvi.kmc_screening.contracts.PWContract;
import edu.aku.hassannaqvi.kmc_screening.contracts.TalukasContract;
import edu.aku.hassannaqvi.kmc_screening.contracts.UCsContract;
import edu.aku.hassannaqvi.kmc_screening.contracts.VillagesContract;
import edu.aku.hassannaqvi.kmc_screening.core.DatabaseHelper;
import edu.aku.hassannaqvi.kmc_screening.core.MainApp;
import edu.aku.hassannaqvi.kmc_screening.databinding.ActivitySectionInfoKmcBinding;
import edu.aku.hassannaqvi.kmc_screening.ui.form1.SectionAForm1Activity;
import edu.aku.hassannaqvi.kmc_screening.ui.form2.SectionBForm2Activity;
import edu.aku.hassannaqvi.kmc_screening.ui.form3.SectionAForm3Activity;
import edu.aku.hassannaqvi.kmc_screening.ui.other.EndingActivity;
import edu.aku.hassannaqvi.kmc_screening.validation.ValidatorClass;

import static edu.aku.hassannaqvi.kmc_screening.core.MainApp.fc;


public class SectionInfoKmcActivity extends Activity {

    public List<String> ucName, talukaNames, villageNames, wName;
    public List<String> ucCode, talukaCodes, villageCodes, wSno;
    DatabaseHelper db;
    Map<String, PWContract> mapWRA;

    private static final String TAG = SectionInfoKmcActivity.class.getName();
    String dtToday = new SimpleDateFormat("dd-MM-yy HH:mm").format(new Date().getTime());

    ActivitySectionInfoKmcBinding bi;
    int length = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_section_info_kmc);

        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_info_kmc);
        bi.setCallback(this);

        db = new DatabaseHelper(getApplicationContext());


        /*if (MainApp.userName.equals("test1234")) {
            populateSpinner_testuser(this);
        } else {
            populateSpinner(this);
        }*/

//        if(MainApp.formType.equals("f1")){
//            bi.form01.setVisibility(View.VISIBLE);
//            bi.form02.setVisibility(View.VISIBLE);
//            bi.form0203.setVisibility(View.VISIBLE);
//            bi.form03.setVisibility(View.VISIBLE);
//        }else if(MainApp.formType.equals("f2")){
//
//        }


        populateSpinner(this);

//
//        bi.cra04.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//                clearFields();
//                bi.fldGrpcra04.setVisibility(View.GONE);
//                bi.btnNext.setVisibility(View.GONE);
//                bi.btnEnd.setVisibility(View.GONE);
//            }
//
//            @Override
//            public void afterTextChanged(Editable editable) {
//
//            }
//        });
//
//
//        bi.cra07.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(RadioGroup group, int checkedId) {
//                if (bi.cra07a.isChecked()) {
//                    bi.btnNext.setVisibility(View.VISIBLE);
//                } else {
//                    bi.btnNext.setVisibility(View.GONE);
//                }
//            }
//        });


        //setUp();

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

        JSONObject sInfo = new JSONObject();
        sInfo.put("kf1a1", bi.kf1a0.getText().toString());
        if (MainApp.formType.equals("kf1")) {

            sInfo.put("kf1a2", bi.kf1a1.getText().toString());
            sInfo.put("kf1a3", bi.kf1a2.getText().toString());
            sInfo.put("kf1a4", bi.kf1a3.getText().toString());
            sInfo.put("kf1a5", bi.kf1a4.getText().toString());
            sInfo.put("kf1a6", bi.kf1a5.getText().toString());
        }

        if (MainApp.formType.equals("kf2")) {
            sInfo.put("kf2a1", bi.kf2a6.getText().toString());
            sInfo.put("kf2a2", bi.kf2a7.getText().toString());
            sInfo.put("kf2a3", bi.kf2a8.getText().toString());
            sInfo.put("kf2a4", bi.kf2a1.getText().toString());
            sInfo.put("kf2a5", bi.kf2a2.getText().toString());
            sInfo.put("kf2a6", bi.kf2a3.getText().toString());
            sInfo.put("kf2a7", bi.kf2a4.getText().toString());
            sInfo.put("kf2a8", bi.kf2a5.getText().toString());

        }
        if (MainApp.formType.equals("kf3")) {
            sInfo.put("kf3a1", bi.kf2a6.getText().toString());
            sInfo.put("kf3a2", bi.kf2a7.getText().toString());
            sInfo.put("kf3a3", bi.kf2a8.getText().toString());
            sInfo.put("kf3a4", bi.kf3a3.getText().toString());
            sInfo.put("kf3a5", bi.kf3a4.getText().toString());

        }

        fc.setsInfo(String.valueOf(sInfo));

        setGPS();
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

                startActivity(new Intent(this, EndingActivity.class).putExtra("complete", true));

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
                startActivity(new Intent(this, MainApp.formType.equals("kf1") ? SectionAForm1Activity.class
                        : MainApp.formType.equals("kf2") ? SectionBForm2Activity.class
                        : MainApp.formType.equals("kf3") ? SectionAForm3Activity.class : null));
                //startActivity(new Intent(this, MainActivity.class));

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


        return true;
    }

    public void BtnSearchWoman() {

        if (ValidateSpinners()) {

            bi.mainLayout.setVisibility(View.VISIBLE);
            if (MainApp.formType.equals("kf1")) {
                bi.form01.setVisibility(View.VISIBLE);
            } else if (MainApp.formType.equals("kf2")) {
                bi.form02.setVisibility(View.VISIBLE);
                bi.form0203.setVisibility(View.VISIBLE);
            } else if (MainApp.formType.equals("kf3")) {
                bi.form0203.setVisibility(View.VISIBLE);
                bi.form03.setVisibility(View.VISIBLE);
            }
//            if (!TextUtils.isEmpty(bi.kapr02a.getText().toString())) {
//                db = new DatabaseHelper(this);
//
//
//                // Spinner Drop down elements
//                wName = new ArrayList<>();
//                wSno = new ArrayList<>();
//
//                wName.add("....");
//                wSno.add("....");
//
//                mapWRA = new HashMap<>();
//
//                Collection<PWContract> dc = db.getPW(bi.kapr02a.getText().toString(), MainApp.villageCode);
//                Log.d(TAG, "onCreate: " + dc.size());
//                for (PWContract d : dc) {
//                    wName.add(d.getWname() + "_" + d.getSno());
//                    wSno.add(d.getSno());
//                    mapWRA.put(d.getWname() + "_" + d.getSno(), d);
//                }
//
//                if (dc.size() <= 0) {
//                    bi.fldGrpcra02.setVisibility(View.GONE);
//                    Toast.makeText(this, "Household does not exist ", Toast.LENGTH_LONG).show();
//                } else {
//                    Toast.makeText(this, "Household number exists", Toast.LENGTH_LONG).show();
//                    bi.fldGrpcra02.setVisibility(View.VISIBLE);
//                }
//            } else {
//                Toast.makeText(this, "Household number required", Toast.LENGTH_LONG).show();
//                bi.kapr02a.requestFocus();
//            }
        }

    }

    private void setUp() {

//        bi.cra04.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//
//                bi.cra04.setInputType(InputType.TYPE_CLASS_NUMBER);
//                length = charSequence.toString().length();
//            }
//
//            @Override
//            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//
//                clearFields();
//
//
//                if (!bi.cra04.getText().toString().isEmpty() && bi.cra04.getText().toString().length() == 4) {
//                    if (bi.cra04.getText().toString().substring(0, 3).matches("[0-9]+")) {
//                        if (length < 5) {
//                            bi.cra04.setText(bi.cra04.getText().toString() + "-");
//                            bi.cra04.setSelection(bi.cra04.getText().length());
//                            //binding.nh108.setInputType(InputType.TYPE_TEXT_FLAG_CAP_CHARACTERS);
//                        }
//                    }
//                }
//            }
//
//            @Override
//            public void afterTextChanged(Editable editable) {
//
//            }
//        });

    }


    public void clearFields() {
//        bi.fldGrpcra04.setVisibility(View.GONE);
//
//        bi.cravillage.setText(null);
//        //bi.cra03.setText(null);
//        //bi.cra05.setText(null);
//        bi.cra06.setText(null);
//        bi.cra07.clearCheck();
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


    @Override
    public void onBackPressed() {
        Toast.makeText(getApplicationContext(), "You Can't go back", Toast.LENGTH_LONG).show();
    }

}