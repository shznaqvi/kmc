package edu.aku.hassannaqvi.kmc_screening.ui.mortality;


import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
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
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

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
import edu.aku.hassannaqvi.kmc_screening.ui.SectionInfoKmcActivity;
import edu.aku.hassannaqvi.kmc_screening.ui.mortality.Section1Activity;
import edu.aku.hassannaqvi.kmc_screening.ui.other.EndingActivity;
import edu.aku.hassannaqvi.kmc_screening.validation.ClearClass;
import edu.aku.hassannaqvi.kmc_screening.validation.ValidatorClass;

import static edu.aku.hassannaqvi.kmc_screening.core.MainApp.fc;

import android.os.Bundle;

public class Section1Activity extends AppCompatActivity {



    private List<String> ucName;
    private List<String> villageNames;
    private List<String> talukaCodes, villageCodes;
    private Map<String, UCsContract> uc;
    private DatabaseHelper db;
    private PWScreenedContract mapWRA;
    private Map<String, EligibleContract> mapPartElig;
    private static final String TAG = SectionInfoKmcActivity.class.getName();
    ActivitySectionInfoKmcBinding bi;
    public static int followupNo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_section1);
    }






    public void populateSpinner(final Context context) {
        // Spinner Drop down elements
        List<String> talukaNames = new ArrayList<>();
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
            List<String> partNam = new ArrayList<>();
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

            bi.kf2a6.setAdapter(new ArrayAdapter<>(Section1Activity.this, android.R.layout.simple_spinner_dropdown_item, partNam));
        }

        Toast.makeText(this, "Household number exists", Toast.LENGTH_LONG).show();
        setupFields(View.VISIBLE);

    }
    private void setupFields(int status) {
        bi.fldGrpcra02.setVisibility(status);
        bi.fldGrpbtn.setVisibility(status);

        switch (MainApp.formType) {
            case "kf1":
                bi.form01.setVisibility(status);
                ClearClass.ClearAllFields(bi.form01, null);
                bi.kf1a6.setMinDate(DateUtils.getDaysBack("dd/MM/yyyy", -29));
                break;
            case "kf2":
                bi.form02.setVisibility(status);
                bi.form0203.setVisibility(status);
                ClearClass.ClearAllFields(bi.form02, null);
                ClearClass.ClearAllFields(bi.form0203, null);
                break;
            case "kf3":
                bi.form0203.setVisibility(status);
                bi.form03.setVisibility(status);
                ClearClass.ClearAllFields(bi.form0203, null);
                ClearClass.ClearAllFields(bi.form03, null);
                break;
        }
        bi.kfa1.clearCheck();
    }
}