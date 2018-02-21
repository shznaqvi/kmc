package edu.aku.hassannaqvi.kmc.ui;

import android.app.Activity;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import edu.aku.hassannaqvi.kmc.R;
import edu.aku.hassannaqvi.kmc.core.DatabaseHelper;
import edu.aku.hassannaqvi.kmc.core.MainApp;
import edu.aku.hassannaqvi.kmc.databinding.ActivitySectionB4Binding;
import edu.aku.hassannaqvi.kmc.validation.validatorClass;

public class SectionB4Activity extends Activity {

    ActivitySectionB4Binding binding;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_section_b4);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_section_b4);
        db = new DatabaseHelper(this);
        binding.setCallback(this);

        binding.nb40299.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    binding.nb402a.setChecked(false);
                    binding.nb402b.setChecked(false);
                    binding.nb402c.setChecked(false);
                    binding.nb402d.setChecked(false);
                    binding.nb402e.setChecked(false);
                    binding.nb40296.setChecked(false);

                    binding.nb402a.setEnabled(false);
                    binding.nb402b.setEnabled(false);
                    binding.nb402c.setEnabled(false);
                    binding.nb402d.setEnabled(false);
                    binding.nb402e.setEnabled(false);
                    binding.nb40296.setEnabled(false);
                } else {
                    binding.nb402a.setEnabled(true);
                    binding.nb402b.setEnabled(true);
                    binding.nb402c.setEnabled(true);
                    binding.nb402d.setEnabled(true);
                    binding.nb402e.setEnabled(true);
                    binding.nb40296.setEnabled(true);
                }
            }
        });
        binding.nb405.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.nb405b || checkedId == R.id.nb40598) {
                    binding.fldGrpnb406.setVisibility(View.GONE);
                    binding.nb406c.setText(null);
                    binding.nb406r.setText(null);
                    binding.nb40698.setChecked(false);
                } else {
                    binding.fldGrpnb406.setVisibility(View.VISIBLE);
                }
            }
        });
        binding.nb411.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.nb411b || checkedId == R.id.nb41198) {
                    binding.fldGrpnb412check.setVisibility(View.GONE);
                    binding.nb412a.setChecked(false);
                    binding.nb412b.setChecked(false);
                    binding.nb412c.setChecked(false);
                    binding.nb412d.setChecked(false);
                    binding.nb412e.setChecked(false);
                    binding.nb41296.setChecked(false);
                    binding.nb41298.setChecked(false);

                    binding.nb41296x.setText(null);

                } else {
                    binding.fldGrpnb412check.setVisibility(View.VISIBLE);
                }
            }
        });
        binding.nb41298.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    binding.nb412a.setEnabled(false);
                    binding.nb412b.setEnabled(false);
                    binding.nb412c.setEnabled(false);
                    binding.nb412d.setEnabled(false);
                    binding.nb412e.setEnabled(false);
                    binding.nb41296.setEnabled(false);

                    binding.nb412a.setChecked(false);
                    binding.nb412b.setChecked(false);
                    binding.nb412c.setChecked(false);
                    binding.nb412d.setChecked(false);
                    binding.nb412e.setChecked(false);
                    binding.nb41296.setChecked(false);

                    binding.nb41296x.setText(null);

                } else {
                    binding.nb412a.setEnabled(true);
                    binding.nb412b.setEnabled(true);
                    binding.nb412c.setEnabled(true);
                    binding.nb412d.setEnabled(true);
                    binding.nb412e.setEnabled(true);
                    binding.nb41296.setEnabled(true);
                }
            }
        });
    }

    public void BtnContinue() {

        Toast.makeText(this, "Processing This Section", Toast.LENGTH_SHORT).show();
        /*if (formValidation()) {
            try {
                SaveDraft();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (UpdateDB()) {
                Toast.makeText(this, "Starting Ending Section", Toast.LENGTH_SHORT).show();

                finish();

                startActivity(new Intent(this, ChildAssessmentActivity.class));

            } else {
                Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
            }
        }*/

        startActivity(new Intent(this, SectionB5Activity.class));
    }

    public void BtnEnd() {
        MainApp.endActivity(this, this);

    }


    public boolean formValidation() {

        Toast.makeText(this, "Validating This Section ", Toast.LENGTH_SHORT).show();

        if (!validatorClass.EmptyRadioButton(this, binding.nb401, binding.nb40196, binding.nb40196x, getString(R.string.nb401))) {
            return false;
        }

        // nb402
        if (!validatorClass.EmptyCheckBox(this, binding.fldGrpnb402check, binding.nb40296, binding.nb40296x, String.valueOf(R.string.nb402))) {
            return false;
        }
        // nb403
        if (!validatorClass.EmptyRadioButton(this, binding.nb403, binding.nb40396, binding.nb40396x, getString(R.string.nb403))) {
            return false;
        }
        // nb404
        if (!validatorClass.EmptyRadioButton(this, binding.nb404, binding.nb40498, getString(R.string.nb404))) {
            return false;
        }
        // nb405
        if (!validatorClass.EmptyRadioButton(this, binding.nb405, binding.nb40598, getString(R.string.nb405))) {
            return false;
        }

        if (!binding.nb405b.isChecked()) {
            // nb406

        }

        // nb407
        if (!validatorClass.EmptyRadioButton(this, binding.nb407, binding.nb40798, getString(R.string.nb407))) {
            return false;
        }
        // nb408
        if (!validatorClass.EmptyRadioButton(this, binding.nb408, binding.nb40898, getString(R.string.nb408))) {
            return false;
        }
        // nb409
        if (!validatorClass.EmptyRadioButton(this, binding.nb409, binding.nb40998, getString(R.string.nb409))) {
            return false;
        }
        // nb410
        if (!validatorClass.EmptyRadioButton(this, binding.nb410, binding.nb41098, getString(R.string.nb410))) {
            return false;
        }

        if (!binding.nb411a.isChecked()) {
            // nb412
            if (!validatorClass.EmptyCheckBox(this, binding.fldGrpnb412check, binding.nb41296, binding.nb41296x, String.valueOf(R.string.nb402))) {
                return false;
            }
        }

        return true;
    }


    private void SaveDraft() throws JSONException {
        Toast.makeText(this, "Saving Draft for  This Section", Toast.LENGTH_SHORT).show();

        JSONObject sB4 = new JSONObject();
        //       nb401
        sB4.put("nb401", binding.nb401a.isChecked() ? "1"
                : binding.nb401b.isChecked() ? "2"
                : binding.nb401c.isChecked() ? "3"
                : binding.nb401d.isChecked() ? "4"
                : binding.nb401e.isChecked() ? "5"
                : binding.nb40196.isChecked() ? "96"
                : binding.nb40199.isChecked() ? "99"
                : "0");
        sB4.put("nb40196x", binding.nb40196x.getText().toString());

//        nb402
        sB4.put("nb402a", binding.nb402a.isChecked() ? "1" : "0");
        sB4.put("nb402b", binding.nb402b.isChecked() ? "2" : "0");
        sB4.put("nb402c", binding.nb402c.isChecked() ? "3" : "0");
        sB4.put("nb402d", binding.nb402d.isChecked() ? "4" : "0");
        sB4.put("nb402e", binding.nb402e.isChecked() ? "5" : "0");
        sB4.put("nb40299", binding.nb40299.isChecked() ? "99" : "0");
        sB4.put("nb40296", binding.nb40296.isChecked() ? "96" : "0");
        sB4.put("nb40296x", binding.nb40296x.getText().toString());

//       nb403
        sB4.put("nb403", binding.nb403a.isChecked() ? "1"
                : binding.nb403b.isChecked() ? "2"
                : binding.nb403c.isChecked() ? "3"
                : binding.nb403d.isChecked() ? "4"
                : binding.nb403e.isChecked() ? "5"
                : binding.nb403f.isChecked() ? "6"
                : binding.nb403g.isChecked() ? "7"
                : binding.nb403h.isChecked() ? "8"
                : binding.nb403i.isChecked() ? "9"
                : binding.nb403j.isChecked() ? "10"
                : binding.nb403k.isChecked() ? "11"
                : binding.nb40396.isChecked() ? "96"
                : "0");
        sB4.put("nb40396x", binding.nb40396x.getText().toString());

//        nb404
        sB4.put("nb404", binding.nb404a.isChecked() ? "1"
                : binding.nb404b.isChecked() ? "2"
                : binding.nb404c.isChecked() ? "3"
                : binding.nb404d.isChecked() ? "4"
                : binding.nb404e.isChecked() ? "5"
                : binding.nb40498.isChecked() ? "98"
                : "0");
//        nb405
        sB4.put("nb405", binding.nb405a.isChecked() ? "1"
                : binding.nb405b.isChecked() ? "2"
                : binding.nb40598.isChecked() ? "98"
                : "0");
//        nb406
        sB4.put("nb406c", binding.nb406c.getText().toString());
        sB4.put("nb406r", binding.nb406r.getText().toString());

        sB4.put("nb40698", binding.nb40698.isChecked() ? "1" : "0");

//        nb407
        sB4.put("nb407", binding.nb407a.isChecked() ? "1"
                : binding.nb407b.isChecked() ? "2"
                : binding.nb40798.isChecked() ? "98"
                : "0");

//        nb408
        sB4.put("nb408", binding.nb408a.isChecked() ? "1"
                : binding.nb408b.isChecked() ? "2"
                : binding.nb40898.isChecked() ? "98"
                : "0");

//        nb409
        sB4.put("nb409", binding.nb409a.isChecked() ? "1"
                : binding.nb409b.isChecked() ? "2"
                : binding.nb40998.isChecked() ? "98"
                : "0");


//        nb410
        sB4.put("nb410h", binding.nb410h.getText().toString());
        sB4.put("nb410d", binding.nb410d.getText().toString());
        sB4.put("nb410", binding.nb410a.isChecked() ? "1"
                : binding.nb410b.isChecked() ? "2"
                : binding.nb41097.isChecked() ? "97"
                : binding.nb41098.isChecked() ? "98"
                : "0");

//        nb411
        sB4.put("nb411", binding.nb411a.isChecked() ? "1"
                : binding.nb411b.isChecked() ? "2"
                : binding.nb41198.isChecked() ? "98"
                : "0");

//      nb412
        sB4.put("nb412a", binding.nb412a.isChecked() ? "1" : "0");
        sB4.put("nb412b", binding.nb412b.isChecked() ? "2" : "0");
        sB4.put("nb412c", binding.nb412c.isChecked() ? "3" : "0");
        sB4.put("nb412d", binding.nb412d.isChecked() ? "4" : "0");
        sB4.put("nb412e", binding.nb412e.isChecked() ? "5" : "0");
        sB4.put("nb412e", binding.nb412e.isChecked() ? "6" : "0");
        sB4.put("nb4128", binding.nb41298.isChecked() ? "98" : "0");

        sB4.put("nb41296x", binding.nb41296x.getText().toString());

        MainApp.mc.setsB4(String.valueOf(sB4));


        Toast.makeText(this, "Validation Successful! - Saving Draft...", Toast.LENGTH_SHORT).show();

    }

    private boolean UpdateDB() {

        //Long rowId;
        DatabaseHelper db = new DatabaseHelper(this);

        int updcount = db.updateSB4();

        if (updcount == 1) {
            Toast.makeText(this, "Updating Database... Successful!", Toast.LENGTH_SHORT).show();
            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }
        //return true;

    }


}
