package edu.aku.hassannaqvi.kmc_screening.ui.mortality;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.validatorcrawler.aliazaz.Clear;
import com.validatorcrawler.aliazaz.Validator;

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
import edu.aku.hassannaqvi.kmc_screening.databinding.ActivitySectionmraBinding;
import edu.aku.hassannaqvi.kmc_screening.ui.SectionInfoKmcActivity;
import edu.aku.hassannaqvi.kmc_screening.ui.other.EndingActivity;

import static edu.aku.hassannaqvi.kmc_screening.core.MainApp.fc;

public class SectionMRAActivity extends AppCompatActivity {

    private List<String> ucName;
    private List<String> villageNames;
    private List<String> talukaCodes, villageCodes;
    private Map<String, UCsContract> uc;
    private DatabaseHelper db;
    private PWScreenedContract mapWRA;
    private Map<String, EligibleContract> mapPartElig;
    private static final String TAG = SectionInfoKmcActivity.class.getName();
    ActivitySectionmraBinding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_sectionmra);
        bi.setCallback(this);
        db = new DatabaseHelper(this);
        populateSpinner(this);
    }

    private void setupFields(int visibility) {
        bi.fldGrpSecMR01.setVisibility(visibility);
        Clear.clearAllFields(bi.fldGrpSecMR01);
    }

    private void populateSpinner(Context context) {
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

        // attaching data adapter to spinner
        bi.crataluka.setAdapter(new ArrayAdapter<>(context, android.R.layout.simple_spinner_dropdown_item, talukaNames));

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

                if (uc.get(bi.crauc.getSelectedItem().toString()) == null) return;
                MainApp.armType = uc.get(bi.crauc.getSelectedItem().toString()).getStudy_arm();
                Collection<VillagesContract> pc = db.getAllPSUsByDistrict(talukaCodes.get(bi.crataluka.getSelectedItemPosition()), uc.get(bi.crauc.getSelectedItem().toString()).getUccode());
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
                bi.nmq104.setText(null);
                if (i == 0) return;
                bi.villageLabel.setText(String.format("Village Code: %s", villageCodes.get(bi.crvillage.getSelectedItemPosition())));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    public void nmq104OnTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        setupFields(View.GONE);
    }

    private void saveDraft() throws JSONException {
        SharedPreferences sharedPref = getSharedPreferences("tagName", MODE_PRIVATE);
        fc = new FormsContract();
        fc.setDevicetagID(sharedPref.getString("tagName", null));
        fc.setFormDate(new SimpleDateFormat("dd-MM-yy HH:mm").format(new Date().getTime()));
        fc.setUser(MainApp.userName);
        fc.setDeviceID(Settings.Secure.getString(getApplicationContext().getContentResolver(), Settings.Secure.ANDROID_ID));
        fc.setAppversion(MainApp.versionName + "." + MainApp.versionCode);
        fc.setTaluka(talukaCodes.get(bi.crataluka.getSelectedItemPosition()));
        fc.setUc(uc.get(bi.crauc.getSelectedItem().toString()).getUccode());
        fc.setVillage(villageCodes.get(bi.crvillage.getSelectedItemPosition()));
        fc.setFormType(MainApp.formType);
        fc.setSurveyType(MainApp.surveyType);
        fc.setPwid(bi.nmq104.getText().toString());

        JSONObject json = new JSONObject();
        json.put("nmq101", bi.nmq101a.isChecked() ? "1"
                : bi.nmq101b.isChecked() ? "2"
                : "-1");

        json.put("nmq105", bi.nmq105.getText().toString());

        json.put("nmq106", bi.nmq106.getText().toString());

        json.put("nmq107", bi.nmq107.getText().toString());

        json.put("nmq108", bi.nmq108a.isChecked() ? "1"
                : bi.nmq108b.isChecked() ? "2"
                : "-1");

        json.put("nmq109", bi.nmq109.getText().toString());

        json.put("nmq201", bi.nmq201a.isChecked() ? "1"
                : bi.nmq201b.isChecked() ? "2"
                : "-1");

        json.put("nmq202m", bi.nmq202m.getText().toString());

        json.put("nmq202d", bi.nmq202d.getText().toString());

        json.put("nmq203", bi.nmq203a.isChecked() ? "1"
                : bi.nmq203b.isChecked() ? "2"
                : "-1");

        json.put("nmq20401", bi.nmq20401.isChecked() ? "1" : "-1");

        json.put("nmq20402", bi.nmq20402.isChecked() ? "2" : "-1");

        json.put("nmq20403", bi.nmq20403.isChecked() ? "3" : "-1");

        json.put("nmq20404", bi.nmq20404.isChecked() ? "4" : "-1");

        json.put("nmq20405", bi.nmq20405.isChecked() ? "5" : "-1");

        json.put("nmq20406", bi.nmq20406.isChecked() ? "6" : "-1");

        json.put("nmq20407", bi.nmq20407.isChecked() ? "7" : "-1");

        json.put("nmq20408", bi.nmq20408.isChecked() ? "8" : "-1");

        json.put("nmq20409", bi.nmq20409.isChecked() ? "9" : "-1");

        json.put("nmq204010", bi.nmq204010.isChecked() ? "10" : "-1");

        json.put("nmq204011", bi.nmq204011.isChecked() ? "11" : "-1");

        json.put("nmq204098", bi.nmq204098.isChecked() ? "98" : "-1");

        json.put("nmq204096", bi.nmq204096.isChecked() ? "96" : "-1");

        json.put("nmq204096x", bi.nmq204096x.getText().toString());
        json.put("nmq205", bi.nmq20501.isChecked() ? "1"
                : bi.nmq20502.isChecked() ? "2"
                : bi.nmq20503.isChecked() ? "3"
                : bi.nmq20504.isChecked() ? "4"
                : bi.nmq20505.isChecked() ? "5"
                : bi.nmq20506.isChecked() ? "6"
                : bi.nmq20507.isChecked() ? "7"
                : bi.nmq205096.isChecked() ? "96"
                : "-1");

        json.put("nmq205096x", bi.nmq205096x.getText().toString());
        json.put("nmq206h", bi.nmq206h.getText().toString());

        json.put("nmq206d", bi.nmq206d.getText().toString());

        fc.setsA(String.valueOf(json));
    }

    public void BtnContinue(View v) {
        if (!formValidation()) return;
        try {
            saveDraft();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (UpdateDB()) {
            finish();
            startActivity(new Intent(this, EndingActivity.class));
        } else {
            Toast.makeText(this, "Sorry. You can't go further.\n Please contact IT Team (Failed to update DB)", Toast.LENGTH_SHORT).show();
        }
    }

    /*public void BtnSearchWoman() {

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

            bi.kf2a6.setAdapter(new ArrayAdapter<>(SectionMRAActivity.this, android.R.layout.simple_spinner_dropdown_item, partNam));
        }

        Toast.makeText(this, "Household number exists", Toast.LENGTH_LONG).show();
        setupFields(View.VISIBLE);

    }*/

    public void btnSearchWoman(View v) {
        setupFields(View.VISIBLE);
    }

    private boolean formValidation() {
        return Validator.emptyCheckingContainer(this, bi.GrpName);
    }

    private boolean UpdateDB() {
        long updcount = db.addForm(fc);
        fc.set_ID(String.valueOf(updcount));
        if (updcount > 0) {
            fc.setUID((fc.getDeviceID() + fc.get_ID()));
            db.updateFormID();
            return true;
        }
        return false;
    }


}