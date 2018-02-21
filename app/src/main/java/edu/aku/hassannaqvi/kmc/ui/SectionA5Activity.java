package edu.aku.hassannaqvi.kmc.ui;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import edu.aku.hassannaqvi.kmc.R;
import edu.aku.hassannaqvi.kmc.core.DatabaseHelper;
import edu.aku.hassannaqvi.kmc.core.MainApp;
import edu.aku.hassannaqvi.kmc.databinding.ActivitySectionA5Binding;
import edu.aku.hassannaqvi.kmc.validation.validatorClass;

public class SectionA5Activity extends AppCompatActivity {

    ActivitySectionA5Binding binding;
    DatabaseHelper db;

    int recipientCounter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_section_a5);
        db = new DatabaseHelper(this);

//        Assigning data to UI binding
        binding.setCallback(this);

        binding.na501.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (!(checkedId == R.id.na501a)) {
                    binding.na502.clearCheck();
                    binding.na503a.setChecked(false);
                    binding.na503b.setChecked(false);
                    binding.na503c.setChecked(false);
                    binding.na503d.setChecked(false);
                    binding.na503e.setChecked(false);
                }
            }
        });

        binding.na503e.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    binding.na503a.setEnabled(false);
                    binding.na503b.setEnabled(false);
                    binding.na503c.setEnabled(false);
                    binding.na503d.setEnabled(false);

                    binding.na503a.setChecked(false);
                    binding.na503b.setChecked(false);
                    binding.na503c.setChecked(false);
                    binding.na503d.setChecked(false);

                } else {
                    binding.na503a.setEnabled(true);
                    binding.na503b.setEnabled(true);
                    binding.na503c.setEnabled(true);
                    binding.na503d.setEnabled(true);
                }
            }
        });

        binding.na504.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.na504b) {
                    binding.na505a.setChecked(false);
                    binding.na505b.setChecked(false);
                    binding.na505c.setChecked(false);
                    binding.na505d.setChecked(false);
                    binding.na505e.setChecked(false);
                }
            }
        });
        binding.na505e.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    binding.na505a.setEnabled(false);
                    binding.na505b.setEnabled(false);
                    binding.na505c.setEnabled(false);
                    binding.na505d.setEnabled(false);

                    binding.na505a.setChecked(false);
                    binding.na505b.setChecked(false);
                    binding.na505c.setChecked(false);
                    binding.na505d.setChecked(false);

                } else {
                    binding.na505a.setEnabled(true);
                    binding.na505b.setEnabled(true);
                    binding.na505c.setEnabled(true);
                    binding.na505d.setEnabled(true);
                }
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

                if (recipientCounter > 0) {
                    startActivity(new Intent(this, SectionA8AActivity.class).putExtra("recCounter", recipientCounter));
                } else {
                    startActivity(new Intent(this, SectionB1Activity.class));
                }


            } else {
                Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public boolean formValidation() {

        Toast.makeText(this, "Validating This Section ", Toast.LENGTH_SHORT).show();

//        na501
        if (!validatorClass.EmptyRadioButton(this, binding.na501, binding.na501d, getString(R.string.na501))) {
            return false;
        }

//        na502
        if (binding.na501a.isChecked()) {
            if (!validatorClass.EmptyRadioButton(this, binding.na502, binding.na502b, getString(R.string.na502b))) {
                return false;
            }
            // na503
            if (!validatorClass.EmptyCheckBox(this, binding.fldGrna503check, binding.na503e, String.valueOf(R.string.na503))) {
                return false;
            }
        }

//        na504
        if (!validatorClass.EmptyRadioButton(this, binding.na504, binding.na504b, getString(R.string.na504))) {
            return false;
        }

//        na505
        if (binding.na504a.isChecked()) {
            if (!validatorClass.EmptyCheckBox(this, binding.fldGrpna505check, binding.na505e, String.valueOf(R.string.na505))) {
                return false;
            }
        }
//        na50601
        if (!validatorClass.EmptyRadioButton(this, binding.na50601, binding.na50601b, getString(R.string.na50601))) {
            return false;
        }
//        na50602
        if (!validatorClass.EmptyRadioButton(this, binding.na50602, binding.na50602b, getString(R.string.na50602))) {
            return false;
        }
//        na50603
        if (!validatorClass.EmptyRadioButton(this, binding.na50603, binding.na50603b, getString(R.string.na50603))) {
            return false;
        }
//        na50604
        if (!validatorClass.EmptyRadioButton(this, binding.na50604, binding.na50604b, getString(R.string.na50604))) {
            return false;
        }
//        na50605
        if (!validatorClass.EmptyRadioButton(this, binding.na50605, binding.na50605b, getString(R.string.na50605))) {
            return false;
        }
//        na50696
        if (!validatorClass.EmptyRadioButton(this, binding.na50696, binding.na50696a, binding.na50696x, getString(R.string.na506) + " - " + getString(R.string.other))) {
            return false;
        }
//        na601
        if (!validatorClass.EmptyRadioButton(this, binding.na601, binding.na601a, getString(R.string.na601))) {
            return false;
        }
//        na601
        if (!validatorClass.EmptyRadioButton(this, binding.na601, binding.na60196, binding.na60196x, getString(R.string.na601) + " - " + getString(R.string.other))) {
            return false;
        }
//        na602
        if (!validatorClass.EmptyRadioButton(this, binding.na602, binding.na602c, getString(R.string.na602))) {
            return false;
        }
//        na603
        if (!validatorClass.EmptyRadioButton(this, binding.na603, binding.na603d, getString(R.string.na603))) {
            return false;
        }

//        na701
        if (!validatorClass.EmptyRadioButton(this, binding.na701, binding.na70199, getString(R.string.na701))) {
            return false;
        }
//        na702
        if (!validatorClass.EmptyRadioButton(this, binding.na702, binding.na70299, getString(R.string.na702))) {
            return false;
        }
//        na703
        if (!validatorClass.EmptyRadioButton(this, binding.na703, binding.na70399, getString(R.string.na703))) {
            return false;
        }
//        na704
        if (!validatorClass.EmptyRadioButton(this, binding.na704, binding.na70499, getString(R.string.na704))) {
            return false;
        }
//        na705
        if (!validatorClass.EmptyRadioButton(this, binding.na705, binding.na70599, getString(R.string.na705))) {
            return false;
        }
//        na706
        if (!validatorClass.EmptyRadioButton(this, binding.na706, binding.na70699, getString(R.string.na706))) {
            return false;
        }
//        na707
        if (!validatorClass.EmptyRadioButton(this, binding.na707, binding.na70799, getString(R.string.na707))) {
            return false;
        }
//        na708
        if (!validatorClass.EmptyRadioButton(this, binding.na708, binding.na70899, getString(R.string.na708))) {
            return false;
        }
//        na709
        if (!validatorClass.EmptyRadioButton(this, binding.na709, binding.na70999, getString(R.string.na709))) {
            return false;
        }
//        na801
        if (!validatorClass.EmptyRadioButton(this, binding.na801, binding.na801b, getString(R.string.na801))) {
            return false;
        }
//        na802
        if (!binding.na801a.isChecked()) {
            if (!validatorClass.EmptyTextBox(this, binding.na802, getString(R.string.na802))) {
                return false;
            }

            if (!validatorClass.RangeTextBox(this, binding.na802, 1, MainApp.membersCount.getCount(), getString(R.string.na802), "Recipient no")) {
                return false;
            }

        }

        return true;
    }

    public void BtnEnd() {
        MainApp.endActivity(this, this);

    }


    private void SaveDraft() throws JSONException {
        Toast.makeText(this, "Saving Draft for  This Section", Toast.LENGTH_SHORT).show();

        JSONObject sA5 = new JSONObject();

        sA5.put("nh401", binding.na501a.isChecked() ? "1"
                : binding.na501b.isChecked() ? "2"
                : binding.na501c.isChecked() ? "3"
                : binding.na501d.isChecked() ? "4"
                : "0");

        sA5.put("nh402", binding.na502a.isChecked() ? "1"
                : binding.na502b.isChecked() ? "2"
                : "0");

        sA5.put("nh403a", binding.na503a.isChecked() ? "1" : "0");
        sA5.put("nh403b", binding.na503b.isChecked() ? "2" : "0");
        sA5.put("nh403c", binding.na503c.isChecked() ? "3" : "0");
        sA5.put("nh403d", binding.na503d.isChecked() ? "4" : "0");
        sA5.put("nh403e", binding.na503e.isChecked() ? "5" : "0");

        sA5.put("nh404", binding.na504a.isChecked() ? "1"
                : binding.na504b.isChecked() ? "2"
                : "0");

        sA5.put("nh405a", binding.na505a.isChecked() ? "1" : "0");
        sA5.put("nh405b", binding.na505b.isChecked() ? "2" : "0");
        sA5.put("nh405c", binding.na505c.isChecked() ? "3" : "0");
        sA5.put("nh405d", binding.na505d.isChecked() ? "4" : "0");
        sA5.put("nh405e", binding.na505e.isChecked() ? "5" : "0");


        sA5.put("nh40601", binding.na50601a.isChecked() ? "1"
                : binding.na50601b.isChecked() ? "2"
                : "0");


        sA5.put("nh40602", binding.na50602a.isChecked() ? "1"
                : binding.na50602b.isChecked() ? "2"
                : "0");

        sA5.put("nh40603", binding.na50603a.isChecked() ? "1"
                : binding.na50603b.isChecked() ? "2"
                : "0");

        sA5.put("nh40604", binding.na50604a.isChecked() ? "1"
                : binding.na50604b.isChecked() ? "2"
                : "0");

        sA5.put("nh40605", binding.na50605a.isChecked() ? "1"
                : binding.na50605b.isChecked() ? "2"
                : "0");

        sA5.put("nh40696", binding.na50696a.isChecked() ? "1"
                : binding.na50696b.isChecked() ? "2"
                : "0");

        sA5.put("nh40696x", binding.na50696x.getText().toString());

        // Section A6


        sA5.put("nh501", binding.na601a.isChecked() ? "1"
                : binding.na601b.isChecked() ? "2"
                : binding.na601c.isChecked() ? "3"
                : binding.na601d.isChecked() ? "4"
                : binding.na60196.isChecked() ? "96"
                : "0");

        sA5.put("nh50196x", binding.na60196x.getText().toString());

        sA5.put("nh502", binding.na602a.isChecked() ? "1"
                : binding.na602b.isChecked() ? "2"
                : binding.na602c.isChecked() ? "3"
                : "0");

        sA5.put("nh503", binding.na603a.isChecked() ? "1"
                : binding.na603b.isChecked() ? "2"
                : binding.na603c.isChecked() ? "3"
                : binding.na603d.isChecked() ? "4"
                : "0");

        //Section A7

        sA5.put("nh601", binding.na701a.isChecked() ? "1"
                : binding.na701b.isChecked() ? "2"
                : binding.na70198.isChecked() ? "98"
                : binding.na70199.isChecked() ? "99"
                : "0");

        sA5.put("nh602", binding.na702a.isChecked() ? "1"
                : binding.na702b.isChecked() ? "2"
                : binding.na70298.isChecked() ? "98"
                : binding.na70299.isChecked() ? "99"
                : "0");

        sA5.put("nh603", binding.na703a.isChecked() ? "1"
                : binding.na703b.isChecked() ? "2"
                : binding.na70398.isChecked() ? "98"
                : binding.na70399.isChecked() ? "99"
                : "0");

        sA5.put("nh604", binding.na704a.isChecked() ? "1"
                : binding.na704b.isChecked() ? "2"
                : binding.na70498.isChecked() ? "98"
                : binding.na70499.isChecked() ? "99"
                : "0");

        sA5.put("nh605", binding.na705a.isChecked() ? "1"
                : binding.na705b.isChecked() ? "2"
                : binding.na70598.isChecked() ? "98"
                : binding.na70599.isChecked() ? "99"
                : "0");

        sA5.put("nh606", binding.na706a.isChecked() ? "1"
                : binding.na706b.isChecked() ? "2"
                : binding.na70698.isChecked() ? "98"
                : binding.na70699.isChecked() ? "99"
                : "0");

        sA5.put("nh607", binding.na707a.isChecked() ? "1"
                : binding.na707b.isChecked() ? "2"
                : binding.na70798.isChecked() ? "98"
                : binding.na70799.isChecked() ? "99"
                : "0");

        sA5.put("nh608", binding.na708a.isChecked() ? "1"
                : binding.na708b.isChecked() ? "2"
                : binding.na70898.isChecked() ? "98"
                : binding.na70899.isChecked() ? "99"
                : "0");

        sA5.put("nh609", binding.na709a.isChecked() ? "1"
                : binding.na709b.isChecked() ? "2"
                : binding.na70998.isChecked() ? "98"
                : binding.na70999.isChecked() ? "99"
                : "0");

        // Section A8

        sA5.put("nh701", binding.na801a.isChecked() ? "1"
                : binding.na801b.isChecked() ? "2"
                : "0");

        sA5.put("nh702", binding.na802.getText().toString());

        recipientCounter = Integer.valueOf(binding.na802.getText().toString());

        MainApp.fc.setsA5(String.valueOf(sA5));


        Toast.makeText(this, "Validation Successful! - Saving Draft...", Toast.LENGTH_SHORT).show();

    }

    private boolean UpdateDB() {

        //Long rowId;
        DatabaseHelper db = new DatabaseHelper(this);

        int updcount = db.updateSA5();

        if (updcount == 1) {
            Toast.makeText(this, "Updating Database... Successful!", Toast.LENGTH_SHORT).show();
            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }

    }


}
