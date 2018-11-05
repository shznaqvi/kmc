package edu.aku.hassannaqvi.kmc_validate_app.ui;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import edu.aku.hassannaqvi.kmc_validate_app.R;
import edu.aku.hassannaqvi.kmc_validate_app.core.DatabaseHelper;
import edu.aku.hassannaqvi.kmc_validate_app.core.MainApp;
import edu.aku.hassannaqvi.kmc_validate_app.databinding.ActivitySectionB42Binding;
import edu.aku.hassannaqvi.kmc_validate_app.validation.ClearClass;
import edu.aku.hassannaqvi.kmc_validate_app.validation.validatorClass;

public class SectionB4_2Activity extends AppCompatActivity {
    ActivitySectionB42Binding bi;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_b4_2);
        bi.setCallback(this);
        setupView();

    }

    private void setupView() {
        bi.kbdb02.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId != R.id.kbdb02b) {
                    bi.fldGrpbdb02.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.kbdb03, false);
                } else {
                    bi.fldGrpbdb02.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.kbdb03, true);
                }
            }
        });


        bi.kbdb04.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId != R.id.kbdb04e) {
                    bi.fldGrpbdb05.setVisibility(View.GONE);
                    ClearClass.ClearAllFields(bi.fldGrpbdb05, false);
                } else {
                    bi.fldGrpbdb05.setVisibility(View.VISIBLE);
                    ClearClass.ClearAllFields(bi.fldGrpbdb05, true);
                }
            }
        });

    }

    public void BtnEnd() {
        Toast.makeText(this, "Processing End Section", Toast.LENGTH_SHORT).show();
        //if (formValidation()) {
        try {
            SaveDraft();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (UpdateDB()) {
            MainApp.endActivity(this, this);

        } else {
            Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
        }

        //}
    }

    private void SaveDraft() throws JSONException {


        JSONObject kbdb = new JSONObject();

        kbdb.put("kbdb01", bi.kbdb01a.isChecked() ? "1" :
                bi.kbdb01b.isChecked() ? "2" :
                        bi.kbdb01c.isChecked() ? "3" :
                                bi.kbdb01d.isChecked() ? "4" :
                                        bi.kbdb01e.isChecked() ? "5" :
                                                bi.kbdb0196.isChecked() ? "96" :
                                                        "0");
        kbdb.put("kbdb0196x", bi.kbdb0196x.getText().toString());

        kbdb.put("kbdb02",
                bi.kbdb02a.isChecked() ? "1" :
                        bi.kbdb02b.isChecked() ? "2" :
                                bi.kbdb0298.isChecked() ? "98"
                                        : "0");
        kbdb.put("kbdb03a", bi.kbdb03a.isChecked() ? "1" : "0");
        kbdb.put("kbdb03b", bi.kbdb03b.isChecked() ? "2" : "0");
        kbdb.put("kbdb03c", bi.kbdb03c.isChecked() ? "3" : "0");
        kbdb.put("kbdb03d", bi.kbdb03d.isChecked() ? "4" : "0");
        kbdb.put("kbdb0396", bi.kbdb0396.isChecked() ? "96" : "0");
        kbdb.put("kbdb0396x", bi.kbdb0396x.getText().toString());

        kbdb.put("kbdb04",
                bi.kbdb04a.isChecked() ? "1" :
                        bi.kbdb04b.isChecked() ? "2" :
                                bi.kbdb04c.isChecked() ? "3" :
                                        bi.kbdb04d.isChecked() ? "4" :
                                                bi.kbdb04e.isChecked() ? "5" :
                                                        bi.kbdb0496.isChecked() ? "96"
                                                                : "0");
        kbdb.put("kbdb0496x", bi.kbdb0496x.getText().toString());

        kbdb.put("kbdb05a", bi.kbdb05a.isChecked() ? "1" : "0");
        kbdb.put("kbdb05b", bi.kbdb05b.isChecked() ? "2" : "0");
        kbdb.put("kbdb05c", bi.kbdb05c.isChecked() ? "3" : "0");
        kbdb.put("kbdb05d", bi.kbdb05d.isChecked() ? "4" : "0");
        kbdb.put("kbdb05e", bi.kbdb05e.isChecked() ? "5" : "0");
        kbdb.put("kbdb0596", bi.kbdb0596.isChecked() ? "96" : "0");
        kbdb.put("kbdb0596x", bi.kbdb0596x.getText().toString());
        MainApp.fc.setsb4_2(String.valueOf(kbdb));

        Toast.makeText(this, "Validation Successful! - Saving Draft...", Toast.LENGTH_SHORT).show();
    }

    private boolean UpdateDB() {
        db = new DatabaseHelper(this);
        int updcount = db.updateSB4_2();

        if (updcount == 1) {
            Toast.makeText(this, "Updating Database... Successful!", Toast.LENGTH_SHORT).show();
            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
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
                startActivity(new Intent(this, SectionB4_3Activity.class));
                //startActivity(new Intent(this, MainActivity.class));

            } else {
                Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private boolean formValidation() {
        Toast.makeText(this, "Validating This Section ", Toast.LENGTH_SHORT).show();

        if (!validatorClass.EmptyRadioButton(this, bi.kbdb01, bi.kbdb0196, bi.kbdb0196x, getString(R.string.kbdb01))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, bi.kbdb02, bi.kbdb02a, getString(R.string.kbdb02))) {
            return false;
        }
        if (bi.kbdb02b.isChecked()) {
            if (!validatorClass.EmptyCheckBox(this, bi.kbdb03, bi.kbdb0396, bi.kbdb0396x, getString(R.string.kbdb03))) {
                return false;
            }
        }

        if (!validatorClass.EmptyRadioButton(this, bi.kbdb04, bi.kbdb0496, bi.kbdb0496x, getString(R.string.kbdb04))) {
            return false;
        }
        if (bi.kbdb04e.isChecked()) {

            if (!validatorClass.EmptyCheckBox(this, bi.kbdb05, bi.kbdb0596, bi.kbdb0596x, getString(R.string.kbdb05))) {
                return false;
            }
        }

        return true;
    }

    @Override
    public void onBackPressed() {
        Toast.makeText(getApplicationContext(), "You Can't go back", Toast.LENGTH_LONG).show();
    }
}
