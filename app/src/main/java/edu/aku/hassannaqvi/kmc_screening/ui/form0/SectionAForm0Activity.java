package edu.aku.hassannaqvi.kmc_screening.ui.form0;

import android.content.Context;
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
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import edu.aku.hassannaqvi.kmc_screening.R;
import edu.aku.hassannaqvi.kmc_screening.contracts.FormsContract;
import edu.aku.hassannaqvi.kmc_screening.contracts.PWFollowUpContract;
import edu.aku.hassannaqvi.kmc_screening.contracts.TalukasContract;
import edu.aku.hassannaqvi.kmc_screening.contracts.UCsContract;
import edu.aku.hassannaqvi.kmc_screening.contracts.VillagesContract;
import edu.aku.hassannaqvi.kmc_screening.core.DatabaseHelper;
import edu.aku.hassannaqvi.kmc_screening.core.MainApp;
import edu.aku.hassannaqvi.kmc_screening.databinding.ActivitySectionAForm0Binding;
import edu.aku.hassannaqvi.kmc_screening.other.DateUtils;
import edu.aku.hassannaqvi.kmc_screening.ui.other.EndingActivity;
import edu.aku.hassannaqvi.kmc_screening.validation.ClearClass;
import edu.aku.hassannaqvi.kmc_screening.validation.ValidatorClass;

import static edu.aku.hassannaqvi.kmc_screening.core.MainApp.fc;


public class SectionAForm0Activity extends AppCompatActivity {

    private static final String TAG = SectionAForm0Activity.class.getName();
    public PWFollowUpContract mapWRA;
    public int ucPos, talukaPos, villagePos;
    private List<String> ucName, talukaNames, villageNames;
    DatabaseHelper db;
    ActivitySectionAForm0Binding bi;
    private static List<String> ucCode, talukaCodes, villageCodes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_a_form0);
        bi.setCallback(this);
        db = new DatabaseHelper(getApplicationContext());

        settingComponents();
        settingListeners();
        populateSpinner(this);

        ucPos = 0;
        talukaPos = 0;
        villagePos = 0;

    }

    private void settingComponents() {
        if (MainApp.surveyType.equals("kf0b")) {
            bi.checkBtnLayout.setVisibility(View.VISIBLE);
            this.setTitle(getString(R.string.pw_sur));
        } else {
            bi.hhLayout.setVisibility(View.VISIBLE);
            bi.hhLayout2.setVisibility(View.VISIBLE);
            bi.recruitmentLayout.setVisibility(View.VISIBLE);
            bi.fldGrpcra04.setVisibility(View.VISIBLE);
            bi.kapr12a.setEnabled(false);
            bi.kapr12a.setChecked(true);
            bi.kapr12b.setEnabled(false);
            bi.kapr12c.setEnabled(false);
            bi.kapr12d.setEnabled(false);
            bi.kapr12e.setEnabled(false);
            bi.kapr12f.setEnabled(false);
            bi.kapr12g.setEnabled(false);
            this.setTitle(getString(R.string.pw_reg));
        }

        //setting date
        bi.kapr05.setMaxDate(DateUtils.getUpdatedDateByMonths("dd/MM/yyyy", 9));
    }

    private void settingListeners() {
        bi.kapr02a.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                clearFields(View.GONE);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        bi.kapr12.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i != bi.kapr12b.getId()) {
                    bi.kapr13.clearCheck();
                    bi.kapr14.setText(null);
                }
            }
        });
    }

    private void populateSpinner(final Context context) {
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
        bi.crataluka.setSelection(talukaPos);

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
                bi.crauc.setSelection(ucPos);

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
                bi.crvillage.setSelection(villagePos);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    private boolean formValidation() {
        if (!ValidatorClass.EmptyCheckingContainer(this, bi.form0Layout))
            return false;

        if (MainApp.surveyType.equals("kf0a")) {
            if (checkingWomenExist()) {
                Toast.makeText(this, "PWID already exist!!", Toast.LENGTH_SHORT).show();
                return false;
            }
        }

        return true;
    }

    private void SaveDraft() throws JSONException {
        SharedPreferences sharedPref = getSharedPreferences("tagName", MODE_PRIVATE);
        //Initializing contract
        fc = new FormsContract();
        fc.setDevicetagID(sharedPref.getString("tagName", null));
        fc.setFormDate(new SimpleDateFormat("dd-MM-yy HH:mm").format(new Date().getTime()));
        fc.setUser(MainApp.userName);
        fc.setDeviceID(Settings.Secure.getString(getApplicationContext().getContentResolver(), Settings.Secure.ANDROID_ID));
        fc.setAppversion(MainApp.versionName + "." + MainApp.versionCode);
        fc.setTaluka(talukaCodes.get(bi.crataluka.getSelectedItemPosition()));
        fc.setUc(ucCode.get(bi.crauc.getSelectedItemPosition()));
        fc.setVillage(villageCodes.get(bi.crvillage.getSelectedItemPosition()));
        fc.setSurveyType(MainApp.surveyType);
        fc.setFormType(MainApp.formType);

        JSONObject sInfo = new JSONObject();

        sInfo.put("kapr03", bi.kapr03.getText().toString());
        sInfo.put("kapr12", bi.kapr12a.isChecked() ? "1"
                : bi.kapr12b.isChecked() ? "2"
                : bi.kapr12c.isChecked() ? "3"
                : bi.kapr12d.isChecked() ? "4"
                : bi.kapr12e.isChecked() ? "5"
                : bi.kapr12f.isChecked() ? "6"
                : bi.kapr12g.isChecked() ? "7"
                : "0");

        if (MainApp.surveyType.equals("kf0a")) {
            fc.setPwid(bi.kapr02b.getText().toString());
            sInfo.put("kapr04", bi.kapr04.getText().toString());
            sInfo.put("kapr05", bi.kapr05.getText().toString());
            sInfo.put("kapr06", bi.kapr06.getText().toString());
            sInfo.put("kapr07", bi.kapr07.getText().toString());
            sInfo.put("kapr08", bi.kapr08.getText().toString());
            sInfo.put("kapr09", bi.kapr09.getText().toString());
            sInfo.put("kapr10", bi.kapr10.getText().toString());
            sInfo.put("kapr11", bi.kapr11.getText().toString());

        } else {
            fc.setPwid(bi.kapr02a.getText().toString());

            sInfo.put("kapr13", bi.kapr13a.isChecked() ? "1"
                    : bi.kapr13b.isChecked() ? "2"
                    : bi.kapr13c.isChecked() ? "3"
                    : bi.kapr13d.isChecked() ? "4"
                    : bi.kapr13e.isChecked() ? "5"
                    : bi.kapr13f.isChecked() ? "6"
                    : bi.kapr13g.isChecked() ? "7"
                    : "0");
            sInfo.put("kapr14", bi.kapr14.getText().toString());

            sInfo.put("pw_luid", mapWRA.getUid());
            sInfo.put("pw_round", mapWRA.getRound());
            sInfo.put("pw_fupdt", mapWRA.getFupdt());
            sInfo.put("pw_kapr06", mapWRA.getHname());
            sInfo.put("pw_kapr07", mapWRA.getKapr07());
            sInfo.put("pw_kapr08", mapWRA.getKapr08());
            sInfo.put("pw_kapr09", mapWRA.getHhname());
            sInfo.put("pw_regdt", mapWRA.getRegdt());

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
                startActivity(new Intent(this, EndingActivity.class).putExtra("complete", true));
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

        mapWRA = null;
        Collection<PWFollowUpContract> dc = db.getPW(villageCodes.get(bi.crvillage.getSelectedItemPosition()), bi.kapr02a.getText().toString());
        Log.d(TAG, "onCreate: " + dc.size());
        for (PWFollowUpContract d : dc) {
            Long days = DateUtils.getDaysBWDates(new Date(), DateUtils.stringToDate(d.getFupdt()));
            if (days > -7 && days < 7) {
                mapWRA = d;
                break;
            }
        }

        if (mapWRA == null) {
            clearFields(View.GONE);
            Toast.makeText(this, "Household does not exist ", Toast.LENGTH_LONG).show();
            return;
        }

        bi.kapr03.setText(mapWRA.getWname());
        try {
            bi.kapr14.setMinDate(new SimpleDateFormat("dd/MM/yyyy").format(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(mapWRA.getRegdt())));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Toast.makeText(this, "Household number exists", Toast.LENGTH_LONG).show();
        clearFields(View.VISIBLE);

        bi.kapr03.setEnabled(false);

    }

    private boolean checkingWomenExist() {
        PWFollowUpContract dc = db.checkPWExist(villageCodes.get(bi.crvillage.getSelectedItemPosition()), bi.kapr02b.getText().toString());
        return dc == null;
    }

    private void clearFields(int status) {
        bi.fldGrpcra04.setVisibility(status);
        bi.hhLayout2.setVisibility(status);
        bi.fldGrpbtn.setVisibility(status);
        bi.btnEnd.setVisibility(status);
        ClearClass.ClearAllFields(bi.fldGrpcra04, null);
    }

    private boolean UpdateDB() {

        DatabaseHelper db = new DatabaseHelper(this);

        long updcount = db.addForm(fc);

        fc.set_ID(String.valueOf(updcount));

        if (updcount > 0) {
            fc.setUID(
                    (fc.getDeviceID() + fc.get_ID()));
            db.updateFormID();
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
        }

        return true;
    }

    private void setGPS() {
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

        } catch (Exception e) {
            Log.e(TAG, "setGPS: " + e.getMessage());
        }

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

}