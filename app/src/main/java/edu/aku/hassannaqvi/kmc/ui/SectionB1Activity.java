package edu.aku.hassannaqvi.kmc.ui;

import android.app.Activity;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.os.Bundle;
import android.provider.Settings;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import edu.aku.hassannaqvi.kmc.R;
import edu.aku.hassannaqvi.kmc.contracts.FamilyMembersContract;
import edu.aku.hassannaqvi.kmc.contracts.MWRAContract;
import edu.aku.hassannaqvi.kmc.core.DatabaseHelper;
import edu.aku.hassannaqvi.kmc.core.MainApp;
import edu.aku.hassannaqvi.kmc.databinding.ActivitySectionB1Binding;
import edu.aku.hassannaqvi.kmc.validation.validatorClass;

import static android.view.View.GONE;

public class SectionB1Activity extends Activity {

    static ArrayList<String> respName;
    static ArrayList<String> respSerial;
    ActivitySectionB1Binding bi;
    DatabaseHelper db;
    ArrayList<String> lstMwra;
    int position = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_section_b1);

        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_b1);
        db = new DatabaseHelper(this);
        lstMwra = new ArrayList<>();

        MainApp.mwraMap.put("....", "");
        lstMwra.add("....");
        respName = new ArrayList<>();
        respSerial = new ArrayList<>();
        respName.add("....");
        //respSerial.

        //Assigning data to UI binding
        bi.setCallback(this);

        setupViews();
    }

    public void setupViews() {

        bi.nb104.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if (bi.nb104.getText().toString().equals("0")) {
                    bi.fldGrpnb105.setVisibility(GONE);
                    bi.nb105.clearCheck();
                    bi.nb106.setText(null);
                } else {
                    bi.fldGrpnb105.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        for (FamilyMembersContract fmc : MainApp.members_f_m) {

            respName.add(fmc.getName());
            respSerial.add(fmc.getSerialNo());
        }


        for (byte i = 0; i < MainApp.mwra.size(); i++) {
            MainApp.mwraMap.put(MainApp.mwra.get(i).getName(), MainApp.mwra.get(i).getSerialNo());
            lstMwra.add(MainApp.mwra.get(i).getName());
        }


        bi.nb101.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, lstMwra));
        bi.resp.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, respName));

        bi.nb101.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int i, long id) {
                position = i;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        bi.resp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int i, long id) {
                position = i;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        bi.nb105.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.nb105b) {
                    bi.fldGrpnb106.setVisibility(GONE);
                    bi.nw206.clearCheck();
                    bi.nw20701.clearCheck();
                    bi.nw20702.clearCheck();
                    bi.nw20703.clearCheck();
                    bi.nw20798.setChecked(false);
                    bi.nw20799.setChecked(false);
                } else {
                    bi.fldGrpnb106.setVisibility(View.VISIBLE);
                }

            }
        });
        bi.nw20798.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    bi.nw206.clearCheck();
                    bi.nw20701.clearCheck();
                    bi.nw20702.clearCheck();
                    bi.nw20703.clearCheck();
                    bi.nw20701.setEnabled(false);
                    bi.nw20702.setEnabled(false);
                    bi.nw20703.setEnabled(false);
                    bi.nw20799.setChecked(false);
                    bi.nw20799.setEnabled(false);
                } else {
                    bi.nw20701.setEnabled(true);
                    bi.nw20702.setEnabled(true);
                    bi.nw20703.setEnabled(true);
                    bi.nw20799.setEnabled(true);
                }
            }
        });
        bi.nw20799.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    bi.nw20798.setChecked(false);
                    bi.nw20701.clearCheck();
                    bi.nw20702.clearCheck();
                    bi.nw20703.clearCheck();
                }
            }
        });


    }

    public void BtnContinue() {

        Toast.makeText(this, "Processing This Section", Toast.LENGTH_SHORT).show();
        if (ValidateForm()) {
            try {
                SaveDraft();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (UpdateDB()) {
                Toast.makeText(this, "Starting Ending Section", Toast.LENGTH_SHORT).show();

                finish();

                if (MainApp.totalPregnancy > 0) {

                    startActivity(new Intent(this, SectionB1AActivity.class));
                } else if (MainApp.totalPregnancy == 1 && bi.nb105a.isChecked()) {
                    startActivity(new Intent(this, SectionB2Activity.class));
                } else if (MainApp.totalPregnancy == 0) {
                    startActivity(new Intent(this, SectionB6Activity.class));
                }

            } else {
                Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
            }
        }

        //startActivity(new Intent(this, SectionB1AActivity.class));
    }

    public void BtnEnd() {
        MainApp.endActivity(this, this);

    }

    private boolean ValidateForm() {

        Toast.makeText(this, "Validating This Section ", Toast.LENGTH_SHORT).show();


        if (!validatorClass.EmptySpinner(this, bi.resp, getString(R.string.na107))) {
            return false;
        }

        if (!validatorClass.EmptySpinner(this, bi.nb101, getString(R.string.nb101))) {
            return false;
        }

        if (!bi.nb101.getSelectedItem().toString().equals(bi.resp.getSelectedItem().toString())) {
            Toast.makeText(this, "ERROR(invalid): " + "Respondent should be same as Selected Woman" + getString(R.string.nb101), Toast.LENGTH_LONG).show();

            ((TextView) bi.nb101.getSelectedView()).setText("Respondent should be same as Selected Woman");
            ((TextView) bi.nb101.getSelectedView()).setTextColor(Color.RED);

            ((TextView) bi.resp.getSelectedView()).setText("Respondent should be same as Selected Woman");
            ((TextView) bi.resp.getSelectedView()).setTextColor(Color.RED);

            Log.i(SectionB2Activity.class.getSimpleName(), "nb203" + ": This data is Required!");
            return false;
        } else {
            ((TextView) bi.resp.getSelectedView()).setError(null);
            ((TextView) bi.nb101.getSelectedView()).setError(null);
        }

        if (!validatorClass.EmptyTextBox(this, bi.nb103, getString(R.string.nb103))) {
            return false;
        }

        if (!validatorClass.RangeTextBox(this, bi.nb103, 15, 49, getString(R.string.na8a03m), " years")) {
            return false;
        }

        if (!validatorClass.EmptyTextBox(this, bi.nb104, getString(R.string.nb104))) {
            return false;
        }

        if (Integer.valueOf(bi.nb104.getText().toString()) < 0) {
            if (!validatorClass.EmptyRadioButton(this, bi.nb105, bi.nb105a, getString(R.string.nb105))) {
                return false;
            }

            if (!validatorClass.EmptyTextBox(this, bi.nb106, getString(R.string.nb106))) {
                return false;
            }

        }


        return true;
    }

    private void SaveDraft() throws JSONException {
        Toast.makeText(this, "Saving Draft for  This Section", Toast.LENGTH_SHORT).show();

        MainApp.mc = new MWRAContract();

        MainApp.mc.setDevicetagID(MainApp.getTagName(this));
        MainApp.mc.setFormDate(new SimpleDateFormat("dd-MM-yyyy HH:mm").format(System.currentTimeMillis()));
        MainApp.mc.setUser(MainApp.userName);
        MainApp.mc.setDeviceId(Settings.Secure.getString(getApplicationContext().getContentResolver(),
                Settings.Secure.ANDROID_ID));
        MainApp.mc.setApp_ver(MainApp.versionName + "." + MainApp.versionCode);
        MainApp.mc.setB1SerialNo(MainApp.mwraMap.get(bi.nb101.getSelectedItem().toString()));
        MainApp.mc.set_UUID(MainApp.fc.getUID());

        JSONObject sB1 = new JSONObject();

        sB1.put("nb101", bi.nb101.getSelectedItem().toString());
        sB1.put("nb1serialno", MainApp.mwraMap.get(bi.nb101.getSelectedItem().toString()));
        sB1.put("nb104", bi.nb104.getText().toString());


        sB1.put("nb105", bi.nb105a.isChecked() ? "1"
                : bi.nb105b.isChecked() ? "2" : "0");

        sB1.put("nb106", bi.nb106.getText().toString());

        if (bi.nb105a.isChecked()) {
            MainApp.totalPregnancy = Integer.valueOf(bi.nb104.getText().toString()) - 1;
        } else {
            MainApp.totalPregnancy = Integer.valueOf(bi.nb104.getText().toString());
        }


        MainApp.mc.setsB1(String.valueOf(sB1));


        Toast.makeText(this, "Validation Successful! - Saving Draft...", Toast.LENGTH_SHORT).show();

    }

    private boolean UpdateDB() {

        //Long rowId;
        DatabaseHelper db = new DatabaseHelper(this);

        Long updcount = db.addMWRA(MainApp.mc);
        MainApp.mc.set_ID(String.valueOf(updcount));

        if (updcount != 0) {
            Toast.makeText(this, "Updating Database... Successful!", Toast.LENGTH_SHORT).show();

            MainApp.mc.set_UID(
                    (MainApp.mc.getDeviceId() + MainApp.mc.get_ID()));
            db.updateMWRAID();

            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }

        //return true;

    }


}
