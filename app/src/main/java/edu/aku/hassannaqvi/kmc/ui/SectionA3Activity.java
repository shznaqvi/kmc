package edu.aku.hassannaqvi.kmc.ui;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.aku.hassannaqvi.kmc.R;
import edu.aku.hassannaqvi.kmc.contracts.EligibleMembersContract;
import edu.aku.hassannaqvi.kmc.contracts.FamilyMembersContract;
import edu.aku.hassannaqvi.kmc.core.DatabaseHelper;
import edu.aku.hassannaqvi.kmc.core.MainApp;
import edu.aku.hassannaqvi.kmc.databinding.ActivitySectionA3Binding;
import edu.aku.hassannaqvi.kmc.validation.validatorClass;

public class SectionA3Activity extends AppCompatActivity {

    static List<String> members;
    static Map<String, SelectedMem> membersMap;
    static int counter = 1;
    ActivitySectionA3Binding binding;
    DatabaseHelper db;
    int slc_type;

    FamilyMembersContract slcMem;
    String dtToday = new SimpleDateFormat("dd-MM-yy HH:mm").format(new Date().getTime());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_section_a3);
        db = new DatabaseHelper(this);

//        Assigning data to UI binding
        binding.setCallback(this);

        setupViews();

        Log.d("Mem", String.valueOf(MainApp.members_f_m));
        Log.d("Mem", String.valueOf(MainApp.childUnder2));
        Log.d("Mem", String.valueOf(MainApp.childUnder5));
        Log.d("Mem", String.valueOf(MainApp.mwra));
    }

    public void setupViews() {

//        Setup spinner

        //  Getting Extra
        if (getIntent().getBooleanExtra("flag", false)) {
            counter++;
        } else {
            members = new ArrayList<>();
            membersMap = new HashMap<>();

            members.add("....");

            familyMembersSetting(MainApp.mwra, 1);  // 1 for Mwra
            familyMembersSetting(MainApp.childUnder5, 2);  // 2 for Under 5
            familyMembersSetting(MainApp.adolescents, 3);  // 3 for Adolescents
        }

        slcMem = new FamilyMembersContract();
        binding.na301.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, members));

//        Spinner setting
        binding.na301.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                if (i != 0) {

                    SelectedMem mem = membersMap.get(binding.na301.getSelectedItem().toString());
                    slc_type = mem.getType();
                    slcMem = mem.getFmc();

                    switch (slc_type) {
                        case 1:
                            binding.fldGrpbcgScar.setVisibility(View.GONE);
                            binding.fldGrpgoiter.setVisibility(View.VISIBLE);
                            binding.fldGrpca.setVisibility(View.VISIBLE);
                            binding.fldGrpode.setVisibility(View.VISIBLE);
                            break;
                        case 2:
                            binding.fldGrpbcgScar.setVisibility(View.VISIBLE);
                            binding.fldGrpgoiter.setVisibility(View.GONE);
                            binding.fldGrpca.setVisibility(View.GONE);
                            binding.fldGrpode.setVisibility(View.GONE);
                            break;
                        case 3:
                            binding.fldGrpbcgScar.setVisibility(View.GONE);
                            binding.fldGrpgoiter.setVisibility(View.VISIBLE);
                            binding.fldGrpca.setVisibility(View.VISIBLE);
                            binding.fldGrpode.setVisibility(View.GONE);
                            break;
                    }

                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        // setup head
        binding.txtCounter.setText("Count " + counter + " out of " + MainApp.membersCount.getEligibleCount());

    }

    public void familyMembersSetting(List<FamilyMembersContract> family, int type) {

        for (FamilyMembersContract fmc : family) {
            membersMap.put(fmc.getName() + "_" + fmc.getSerialNo(), new SelectedMem(type, fmc));
            members.add(fmc.getName() + "_" + fmc.getSerialNo());
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

                if (counter == MainApp.membersCount.getEligibleCount()) {

                    counter = 1;

                    startActivity(new Intent(this, SectionA4Activity.class));
                } else {

                    members.remove(binding.na301.getSelectedItem().toString());

                    startActivity(new Intent(this, SectionA3Activity.class)
                            .putExtra("flag", true));
                }

            } else {
                Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void BtnEnd() {
        MainApp.endActivity(this, this);
    }

    private boolean formValidation() {

        Toast.makeText(this, "Validating This Section ", Toast.LENGTH_SHORT).show();

        if (!validatorClass.EmptySpinner(this, binding.na301, getString(R.string.na3w))) {
            return false;
        }

        if (!validatorClass.EmptyTextBox(this, binding.na3w, getString(R.string.na3w))) {
            return false;
        }

        if (!validatorClass.EmptyTextBox(this, binding.na3h, getString(R.string.na3h))) {
            return false;
        }

        if (!validatorClass.EmptyTextBox(this, binding.na3muac, getString(R.string.na3muac))) {
            return false;
        }

        if (slc_type == 2) {
            if (!validatorClass.EmptyRadioButton(this, binding.na3bcgscar, binding.na3bcgscara, getString(R.string.na3bcgscar))) {
                return false;
            }
        }

        if (slc_type == 1) {

            if (slc_type == 3) {
                if (!validatorClass.EmptyRadioButton(this, binding.na3g, binding.na3ga, getString(R.string.na3g))) {
                    return false;
                }

                if (!validatorClass.EmptyRadioButton(this, binding.na3ca, binding.na3caa, getString(R.string.na3ca))) {
                    return false;
                }
            }

            if (!validatorClass.EmptyRadioButton(this, binding.na3o, binding.na3oa, getString(R.string.na3o))) {
                return false;
            }

        }
        return true;
    }

    private void SaveDraft() throws JSONException {
        Toast.makeText(this, "Saving Draft for  This Section", Toast.LENGTH_SHORT).show();

        MainApp.emc = new EligibleMembersContract();

        MainApp.emc.setDevicetagID(MainApp.getTagName(this));
        MainApp.emc.setFormDate(dtToday);
        MainApp.emc.setUser(MainApp.userName);
        MainApp.emc.setDeviceId(Settings.Secure.getString(getApplicationContext().getContentResolver(),
                Settings.Secure.ANDROID_ID));
        MainApp.emc.setApp_ver(MainApp.versionName + "." + MainApp.versionCode);
        MainApp.emc.set_UUID(slcMem.get_UID());

        JSONObject sA3 = new JSONObject();

        sA3.put("na301", slcMem.getName());
        sA3.put("na301Serial", slcMem.getSerialNo());

        sA3.put("na3Serial", String.valueOf(counter));

        sA3.put("na3w", binding.na3w.getText().toString());

        sA3.put("na3h", binding.na3h.getText().toString());

        sA3.put("na3muac", binding.na3muac.getText().toString());

        sA3.put("na3bcgscar", binding.na3bcgscara.isChecked() ? "1"
                : binding.na3bcgscarb.isChecked() ? "2" : "0");

        sA3.put("na3g", binding.na3ga.isChecked() ? "1"
                : binding.na3gb.isChecked() ? "2" : "0");

        sA3.put("na3g", binding.na3caa.isChecked() ? "1"
                : binding.na3cab.isChecked() ? "2" : "0");

        sA3.put("na3o", binding.na3oa.isChecked() ? "1"
                : binding.na3ob.isChecked() ? "2" : "0");


        MainApp.emc.setsA3(String.valueOf(sA3));


        Toast.makeText(this, "Validation Successful! - Saving Draft...", Toast.LENGTH_SHORT).show();

    }

    private boolean UpdateDB() {

        //Long rowId;
        DatabaseHelper db = new DatabaseHelper(this);

        Long updcount = db.addEligibleMember(MainApp.emc);
        MainApp.emc.set_ID(String.valueOf(updcount));

        if (updcount != 0) {
            Toast.makeText(this, "Updating Database... Successful!", Toast.LENGTH_SHORT).show();

            MainApp.emc.set_UID(
                    (MainApp.emc.getDeviceId() + MainApp.emc.get_ID()));
            db.updateFormChildID();

            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }
    }

    public class SelectedMem {
        int type;
        FamilyMembersContract fmc;

        public SelectedMem(int type, FamilyMembersContract fmc) {
            this.type = type;
            this.fmc = fmc;
        }

        public int getType() {
            return type;
        }

        public FamilyMembersContract getFmc() {
            return fmc;
        }
    }

}
