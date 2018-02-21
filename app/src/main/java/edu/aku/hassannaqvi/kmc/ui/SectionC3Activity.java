package edu.aku.hassannaqvi.kmc.ui;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioGroup;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;

import edu.aku.hassannaqvi.kmc.R;
import edu.aku.hassannaqvi.kmc.contracts.FamilyMembersContract;
import edu.aku.hassannaqvi.kmc.core.DatabaseHelper;
import edu.aku.hassannaqvi.kmc.core.MainApp;
import edu.aku.hassannaqvi.kmc.databinding.ActivitySectionC3Binding;
import edu.aku.hassannaqvi.kmc.validation.validatorClass;

public class SectionC3Activity extends AppCompatActivity {

    ActivitySectionC3Binding binding;
    FamilyMembersContract selectedChild;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_section_c3);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_section_c3);
        binding.setCallback(this);
        binding.nc3bcgdt.setManager(getSupportFragmentManager());
        binding.nc3opv0dt.setManager(getSupportFragmentManager());
        binding.nc3opv1dt.setManager(getSupportFragmentManager());
        binding.nc3p1dt.setManager(getSupportFragmentManager());
        binding.nc3pcv1dt.setManager(getSupportFragmentManager());
        binding.nc3opv2dt.setManager(getSupportFragmentManager());
        binding.nc3p2dt.setManager(getSupportFragmentManager());
        binding.nc3pcv2dt.setManager(getSupportFragmentManager());
        binding.nc3opv3dt.setManager(getSupportFragmentManager());
        binding.nc3p3dt.setManager(getSupportFragmentManager());
        binding.nc3pcv3dt.setManager(getSupportFragmentManager());
        binding.nc3ipvdt.setManager(getSupportFragmentManager());
        binding.nc3m1dt.setManager(getSupportFragmentManager());
        binding.nc3m2dt.setManager(getSupportFragmentManager());

//        Skip Patterns
        binding.nc312.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == R.id.nc312b) {
                    binding.nc313.clearCheck();
                }
            }
        });

        binding.nc304.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == R.id.nc304d) {
                    binding.nc3bcg.clearCheck();
                    binding.nc3opv0.clearCheck();
                    binding.nc3opv1.clearCheck();
                    binding.nc3p1.clearCheck();
                    binding.nc3pcv1.clearCheck();
                    binding.nc3opv2.clearCheck();
                    binding.nc3p2.clearCheck();
                    binding.nc3pcv2.clearCheck();
                    binding.nc3opv3.clearCheck();
                    binding.nc3p3.clearCheck();
                    binding.nc3pcv3.clearCheck();
                    binding.nc3ipv.clearCheck();
                    binding.nc3m1.clearCheck();
                    binding.nc3m2.clearCheck();
                }
            }
        });

        //Get Intent
        selectedChild = (FamilyMembersContract) getIntent().getSerializableExtra("selectedChild");

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

                startActivity(new Intent(this, SectionC4Activity.class)
                        .putExtra("selectedChild", (Serializable) selectedChild));

            } else {
                Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
            }
        }

    }

    public void BtnEnd() {

        MainApp.endActivityMother(this, this, false);

    }

    private boolean formValidation() {
        Toast.makeText(this, "Validating This Section ", Toast.LENGTH_SHORT).show();

//       nc303
        if (!validatorClass.EmptyRadioButton(this, binding.nc303, binding.nc303b, getString(R.string.nc303))) {
            return false;
        }

//        nc304
        if (!validatorClass.EmptyRadioButton(this, binding.nc304, binding.nc304d, getString(R.string.nc304))) {
            return false;
        }

//        nc3bcg
        if (!validatorClass.EmptyRadioButton(this, binding.nc3bcg, binding.nc3bcgb, binding.nc3bcgdt, getString(R.string.nc3bcg))) {
            return false;
        }
//        nc3opv0
        if (!validatorClass.EmptyRadioButton(this, binding.nc3opv0, binding.nc3opv0b, binding.nc3opv0dt, getString(R.string.nc3opv0))) {
            return false;
        }


//        nc3opv1
        if (!validatorClass.EmptyRadioButton(this, binding.nc3opv1, binding.nc3opv1b, binding.nc3opv1dt, getString(R.string.nc3opv1))) {
            return false;
        }
//        nc3p1
        if (!validatorClass.EmptyRadioButton(this, binding.nc3p1, binding.nc3p1b, binding.nc3p1dt, getString(R.string.nc3p1))) {
            return false;
        }
//        nc3pcv1
        if (!validatorClass.EmptyRadioButton(this, binding.nc3pcv1, binding.nc3pcv1b, binding.nc3pcv1dt, getString(R.string.nc3pcv1))) {
            return false;
        }


//        nc3opv2
        if (!validatorClass.EmptyRadioButton(this, binding.nc3opv2, binding.nc3opv2b, binding.nc3opv2dt, getString(R.string.nc3opv2))) {
            return false;
        }
//        nc3p2
        if (!validatorClass.EmptyRadioButton(this, binding.nc3p2, binding.nc3p2b, binding.nc3p2dt, getString(R.string.nc3p2))) {
            return false;
        }
//        nc3pcv2
        if (!validatorClass.EmptyRadioButton(this, binding.nc3pcv2, binding.nc3pcv2b, binding.nc3pcv2dt, getString(R.string.nc3pcv2))) {
            return false;
        }


//        nc3opv3
        if (!validatorClass.EmptyRadioButton(this, binding.nc3opv3, binding.nc3opv3b, binding.nc3opv3dt, getString(R.string.nc3opv3))) {
            return false;
        }
//        nc3p3
        if (!validatorClass.EmptyRadioButton(this, binding.nc3p3, binding.nc3p3b, binding.nc3p3dt, getString(R.string.nc3p3))) {
            return false;
        }
//        nc3pcv3
        if (!validatorClass.EmptyRadioButton(this, binding.nc3pcv3, binding.nc3pcv3b, binding.nc3pcv3dt, getString(R.string.nc3pcv3))) {
            return false;
        }
//        nc3ipv3
        if (!validatorClass.EmptyRadioButton(this, binding.nc3ipv, binding.nc3ipvb, binding.nc3ipvdt, getString(R.string.nc3ipv))) {
            return false;
        }

//        nc3m1dt
        if (!validatorClass.EmptyRadioButton(this, binding.nc3m1, binding.nc3m1b, binding.nc3m1dt, getString(R.string.nc3m1))) {
            return false;
        }

//        nc3m2dt
        if (!validatorClass.EmptyRadioButton(this, binding.nc3m2, binding.nc3m2b, binding.nc3m2dt, getString(R.string.nc3m2))) {
            return false;
        }


//        nc306
        if (!validatorClass.EmptyRadioButton(this, binding.nc306, binding.nc306b, getString(R.string.nc306))) {
            return false;
        }

//        nc307
        if (!validatorClass.EmptyRadioButton(this, binding.nc307, binding.nc307b, getString(R.string.nc307))) {
            return false;
        }
//        nc308
        if (!validatorClass.EmptyRadioButton(this, binding.nc308, binding.nc308b, getString(R.string.nc308))) {
            return false;
        }

//        nc309
        if (!validatorClass.EmptyTextBox(this, binding.nc309, getString(R.string.nc309))) {
            return false;
        }

//        nc310
        if (!validatorClass.EmptyRadioButton(this, binding.nc310, binding.nc310b, getString(R.string.nc310))) {
            return false;
        }

//        nc311
        if (!validatorClass.EmptyTextBox(this, binding.nc311, getString(R.string.nc311))) {
            return false;
        }

//        nc312
        if (!validatorClass.EmptyRadioButton(this, binding.nc312, binding.nc312b, getString(R.string.nc312))) {
            return false;
        }
//        nc313
        if (!validatorClass.EmptyRadioButton(this, binding.nc313, binding.nc31398, getString(R.string.nc313))) {
            return false;
        }
//        nc314
        if (!validatorClass.EmptyRadioButton(this, binding.nc314, binding.nc31498, getString(R.string.nc314))) {
            return false;
        }

//        nc315
        if (!validatorClass.EmptyTextBox(this, binding.nc315, getString(R.string.nc315))) {
            return false;
        }

//        nc316
        if (!validatorClass.EmptyRadioButton(this, binding.nc316, binding.nc31698, getString(R.string.nc316))) {
            return false;
        }

//        nc317
        return validatorClass.EmptyTextBox(this, binding.nc317, getString(R.string.nc317));
    }

    private void SaveDraft() throws JSONException {
        Toast.makeText(this, "Saving Draft for  This Section", Toast.LENGTH_SHORT).show();

        JSONObject sC3 = new JSONObject();

//        nc301
        sC3.put("nc301", selectedChild.getName());
//        nc302
        sC3.put("nc302Serial", selectedChild.getSerialNo());

//        nc303
        sC3.put("nc303", binding.nc303a.isChecked() ? "1"
                : binding.nc303b.isChecked() ? "2"
                : "0");

//        nc304
        sC3.put("nc304", binding.nc304a.isChecked() ? "1"
                : binding.nc304b.isChecked() ? "2"
                : binding.nc304c.isChecked() ? "3"
                : binding.nc304d.isChecked() ? "4"
                : "0");
//at birth
//          nc3bcg
        sC3.put("nc3bcg", binding.nc3bcga.isChecked() ? "1"
                : binding.nc3bcgb.isChecked() ? "2"
                : "0");
        sC3.put("nc3bcgdt", binding.nc3bcgdt.getText().toString());

//          nc3opv0
        sC3.put("nc3opv0", binding.nc3opv0a.isChecked() ? "1"
                : binding.nc3opv0b.isChecked() ? "2"
                : "0");
        sC3.put("nc3opv0dt", binding.nc3opv0dt.getText().toString());

//       at age of 6

//          nc3opv1
        sC3.put("nc3opv1", binding.nc3opv1a.isChecked() ? "1"
                : binding.nc3opv1b.isChecked() ? "2"
                : "0");
        sC3.put("nc3opv1dt", binding.nc3opv1dt.getText().toString());

//          nc3p1
        sC3.put("nc3p1", binding.nc3p1a.isChecked() ? "1"
                : binding.nc3p1b.isChecked() ? "2"
                : "0");
        sC3.put("nc3p1dt", binding.nc3p1dt.getText().toString());

//          nc3pcv1
        sC3.put("nc3pcv1", binding.nc3pcv1a.isChecked() ? "1"
                : binding.nc3pcv1b.isChecked() ? "2"
                : "0");
        sC3.put("nc3pcv1dt", binding.nc3pcv1dt.getText().toString());

//       at age of 10 weeks

//          nc3opv2
        sC3.put("nc3opv2", binding.nc3opv2a.isChecked() ? "1"
                : binding.nc3opv2b.isChecked() ? "2"
                : "0");
        sC3.put("nc3opv2dt", binding.nc3opv2dt.getText().toString());

//          nc3p2
        sC3.put("nc3p2", binding.nc3p2a.isChecked() ? "1"
                : binding.nc3p2b.isChecked() ? "2"
                : "0");
        sC3.put("nc3p2dt", binding.nc3p2dt.getText().toString());

//          nc3pcv2
        sC3.put("nc3pcv2", binding.nc3pcv2a.isChecked() ? "1"
                : binding.nc3pcv2b.isChecked() ? "2"
                : "0");
        sC3.put("nc3pcv2dt", binding.nc3pcv2dt.getText().toString());


//       at age of 14 weeks

//          nc3opv3
        sC3.put("nc3opv3", binding.nc3opv3a.isChecked() ? "1"
                : binding.nc3opv3b.isChecked() ? "2"
                : "0");
        sC3.put("nc3opv3dt", binding.nc3opv3dt.getText().toString());

//          nc3p3
        sC3.put("nc3p3", binding.nc3p3a.isChecked() ? "1"
                : binding.nc3p3b.isChecked() ? "2"
                : "0");
        sC3.put("nc3p3dt", binding.nc3p3dt.getText().toString());

//          nc3pcv3
        sC3.put("nc3pcv3", binding.nc3pcv3a.isChecked() ? "1"
                : binding.nc3pcv3b.isChecked() ? "2"
                : "0");
        sC3.put("nc3pcv3dt", binding.nc3pcv3dt.getText().toString());

//          nc3ipv
        sC3.put("nc3ipv", binding.nc3ipva.isChecked() ? "1"
                : binding.nc3ipvb.isChecked() ? "2"
                : "0");
        sC3.put("nc3ipvdt", binding.nc3ipvdt.getText().toString());

//at the age of 9 months
//          nc3m1
        sC3.put("nc3m1", binding.nc3m1a.isChecked() ? "1"
                : binding.nc3m1b.isChecked() ? "2"
                : "0");
        sC3.put("nc3m1dt", binding.nc3m1dt.getText().toString());

//at age of 15 months
//          nc3m2
        sC3.put("nc3m2", binding.nc3m2a.isChecked() ? "1"
                : binding.nc3m2b.isChecked() ? "2"
                : "0");
        sC3.put("nc3m2dt", binding.nc3m2dt.getText().toString());


//        nc306
        sC3.put("nc306", binding.nc306a.isChecked() ? "1"
                : binding.nc306b.isChecked() ? "2"
                : "0");

//        nc307
        sC3.put("nc307", binding.nc307a.isChecked() ? "1"
                : binding.nc307b.isChecked() ? "2"
                : binding.nc307c.isChecked() ? "3"
                : "0");

//        nc308
        sC3.put("nc308", binding.nc308a.isChecked() ? "1"
                : binding.nc308b.isChecked() ? "2"
                : binding.nc308c.isChecked() ? "3"
                : "0");

//        nc309
        sC3.put("nc309", binding.nc309.getText().toString());

//        nc310
        sC3.put("nc310", binding.nc310a.isChecked() ? "1"
                : binding.nc310b.isChecked() ? "2"
                : binding.nc310c.isChecked() ? "3"
                : "0");

//        nc311
        sC3.put("nc311", binding.nc311.getText().toString());

//        nc312
        sC3.put("nc312", binding.nc312a.isChecked() ? "1"
                : binding.nc312b.isChecked() ? "2"
                : binding.nc312c.isChecked() ? "3"
                : "0");
//        nc313
        sC3.put("nc313", binding.nc313a.isChecked() ? "1"
                : binding.nc313b.isChecked() ? "2"
                : binding.nc31398.isChecked() ? "98"
                : "0");


//        nc314
        sC3.put("nc314", binding.nc314a.isChecked() ? "1"
                : binding.nc314b.isChecked() ? "2"
                : binding.nc31498.isChecked() ? "98"
                : "0");

//        nc315
        sC3.put("nc315", binding.nc315.getText().toString());

//        nc316
        sC3.put("nc316", binding.nc316a.isChecked() ? "1"
                : binding.nc316b.isChecked() ? "2"
                : binding.nc31698.isChecked() ? "98"
                : "0");

//        nc317
        sC3.put("nc317", binding.nc317.getText().toString());

        MainApp.cc.setsC3(String.valueOf(sC3));


        Toast.makeText(this, "Validation Successful! - Saving Draft...", Toast.LENGTH_SHORT).show();
    }

    private boolean UpdateDB() {

        //Long rowId;
        DatabaseHelper db = new DatabaseHelper(this);

        int updcount = db.updateSC3();

        if (updcount == 1) {
            Toast.makeText(this, "Updating Database... Successful!", Toast.LENGTH_SHORT).show();
            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }

    }


}

