package edu.aku.hassannaqvi.kmc.ui;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.aku.hassannaqvi.kmc.R;
import edu.aku.hassannaqvi.kmc.contracts.ChildContract;
import edu.aku.hassannaqvi.kmc.contracts.FamilyMembersContract;
import edu.aku.hassannaqvi.kmc.core.DatabaseHelper;
import edu.aku.hassannaqvi.kmc.core.MainApp;
import edu.aku.hassannaqvi.kmc.databinding.ActivitySectionC1Binding;
import edu.aku.hassannaqvi.kmc.validation.validatorClass;

public class SectionC1Activity extends AppCompatActivity {

    public static int counter = 1;
    public static int counterPerMom = 0;
    public static String selectedChildName = "";
    static List<String> childU5;
    static Map<String, FamilyMembersContract> childMap;
    ActivitySectionC1Binding binding;
    DatabaseHelper db;

    String dtToday = new SimpleDateFormat("dd-MM-yy HH:mm").format(new Date().getTime());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_section_c1);
        db = new DatabaseHelper(this);

//        Assigning data to UI binding
        binding.setCallback(this);

//        Setup views
        if (getIntent().getBooleanExtra("flag", false)) {
            childU5.remove(getIntent().getExtras().getInt("name"));
            counter++;
        } else {
            childU5 = new ArrayList<>();
            childMap = new HashMap<>();

            childU5.add("....");

            for (FamilyMembersContract fmc : MainApp.childUnder5) {
                if (fmc.getMotherId().equals(MainApp.mc.getB1SerialNo())) {
                    childMap.put(fmc.getName(), fmc);
                    childU5.add(fmc.getName());
                    counterPerMom++;
                }
            }
        }

        // setup head
        binding.txtCounter.setText("Count " + counter + " out of " + counterPerMom);

        // setup spinner
        binding.nc101.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, childU5));
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

                if (Integer.valueOf(childMap.get(binding.nc101.getSelectedItem().toString()).getAgeInYear()) > 2) {
                    startActivity(new Intent(this, SectionC2Activity.class).putExtra("selectedChild", (Serializable) childMap.get(binding.nc101.getSelectedItem().toString())));
                } else {
                    startActivity(new Intent(this, SectionC3Activity.class).putExtra("selectedChild", (Serializable) childMap.get(binding.nc101.getSelectedItem().toString())));
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

//        nc101
        if (!validatorClass.EmptySpinner(this, binding.nc101, getString(R.string.nc101))) {
            return false;
        }
//        nc103
        if (!validatorClass.EmptyRadioButton(this, binding.nc103, binding.nc10398, getString(R.string.nc103))) {
            return false;
        }
//        nc104
        return validatorClass.EmptyRadioButton(this, binding.nc104, binding.nc10498, getString(R.string.nc104));
    }

    private void SaveDraft() throws JSONException {
        Toast.makeText(this, "Saving Draft for  This Section", Toast.LENGTH_SHORT).show();

        selectedChildName = binding.nc101.getSelectedItem().toString();

        MainApp.cc = new ChildContract();

        MainApp.cc.setDevicetagID(MainApp.getTagName(this));
        MainApp.cc.setFormDate(dtToday);
        MainApp.cc.setUser(MainApp.userName);
        MainApp.cc.setDeviceID(Settings.Secure.getString(getApplicationContext().getContentResolver(),
                Settings.Secure.ANDROID_ID));
        MainApp.cc.setAppversion(MainApp.versionName + "." + MainApp.versionCode);
        MainApp.cc.setUUID(MainApp.mc.get_UID());

        JSONObject sC1 = new JSONObject();

//       nc101
        sC1.put("nc101", binding.nc101.getSelectedItem().toString());
//        nc103
        sC1.put("nc103", binding.nc103a.isChecked() ? "1"
                : binding.nc103b.isChecked() ? "2"
                : binding.nc103c.isChecked() ? "3"
                : binding.nc10398.isChecked() ? "98"
                : "0");

//        nc104
        sC1.put("nc104", binding.nc104a.isChecked() ? "1"
                : binding.nc104b.isChecked() ? "2"
                : binding.nc10498.isChecked() ? "98"
                : "0");

        MainApp.cc.setsC1(String.valueOf(sC1));

        Toast.makeText(this, "Validation Successful! - Saving Draft...", Toast.LENGTH_SHORT).show();
    }

    private boolean UpdateDB() {

        //Long rowId;
        DatabaseHelper db = new DatabaseHelper(this);

        Long updcount = db.addChildForm(MainApp.cc);
        MainApp.cc.set_ID(String.valueOf(updcount));

        if (updcount != 0) {
            Toast.makeText(this, "Updating Database... Successful!", Toast.LENGTH_SHORT).show();

            MainApp.cc.setUID(
                    (MainApp.cc.getDeviceID() + MainApp.cc.get_ID()));
            db.updateFormChildID();

            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }

    }

}
