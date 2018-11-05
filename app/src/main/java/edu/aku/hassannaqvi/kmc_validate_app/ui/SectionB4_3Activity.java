package edu.aku.hassannaqvi.kmc_validate_app.ui;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import edu.aku.hassannaqvi.kmc_validate_app.R;
import edu.aku.hassannaqvi.kmc_validate_app.core.DatabaseHelper;
import edu.aku.hassannaqvi.kmc_validate_app.core.MainApp;
import edu.aku.hassannaqvi.kmc_validate_app.databinding.ActivitySectionB43Binding;
import edu.aku.hassannaqvi.kmc_validate_app.validation.validatorClass;

public class SectionB4_3Activity extends AppCompatActivity {
    ActivitySectionB43Binding bi;
    Context context;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_b4_3);
        bi.setCallback(this);
        setupView();

        context = this;

    }

    private void setupView() {
        bi.kbdc02.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.kbdc02a) {
                    bi.fldGrpkbdc04.setVisibility(View.GONE);
                    bi.kbdc03.clearCheck();
                    bi.kbdc04a.setChecked(false);
                    bi.kbdc04b.setChecked(false);
                    bi.kbdc04c.setChecked(false);
                    bi.kbdc04d.setChecked(false);
                    bi.kbdc04e.setChecked(false);
                    bi.kbdc04f.setChecked(false);
                    bi.kbdc04g.setChecked(false);
                    bi.kbdc04h.setChecked(false);
                    bi.kbdc0496x.setText(null);
                    bi.kbdc0396x.setText(null);
                } else {
                    bi.fldGrpkbdc04.setVisibility(View.VISIBLE);
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

    public void BtnContinue() {
        if (formValidation()) {
            try {
                SaveDraft();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (UpdateDB()) {

                finish();

                startActivity(new Intent(this, SectionB4_4Activity.class));
                //startActivity(new Intent(this, MainActivity.class));

            } else {
                Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private boolean formValidation() {
        Toast.makeText(context, "Validating This Section ", Toast.LENGTH_SHORT).show();

        if (!validatorClass.EmptyRadioButton(context, bi.kbdc01, bi.kbdc01a, getString(R.string.kbdc01))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(context, bi.kbdc02, bi.kbdc02a, getString(R.string.kbdc02))) {
            return false;
        }

        if (!bi.kbdc02a.isChecked()) {

        if (!validatorClass.EmptyRadioButton(context, bi.kbdc03, bi.kbdc0396, bi.kbdc0396x, getString(R.string.kbdc03))) {
            return false;
        }

            return validatorClass.EmptyCheckBox(context, bi.kbdc04, bi.kbdc0496, bi.kbdc0496x, getString(R.string.kbdc04));
        }

        return true;
    }

    private void SaveDraft() throws JSONException {
        Toast.makeText(this, "Saving Draft for  This Section", Toast.LENGTH_SHORT).show();


        JSONObject sd1 = new JSONObject();

        sd1.put("kbdc01", bi.kbdc01a.isChecked() ? "1" : bi.kbdc01b.isChecked() ? "2" : "0");

        sd1.put("kbdc02",
                bi.kbdc02a.isChecked() ? "1" :
                        bi.kbdc02b.isChecked() ? "2" : "0");
        sd1.put("kbdc03",
                bi.kbdc03a.isChecked() ? "1" :
                        bi.kbdc03b.isChecked() ? "2" :
                                bi.kbdc03c.isChecked() ? "3" :
                                                bi.kbdc0396.isChecked() ? "96" :
                                                        "0");
        sd1.put("kbdc0396x", bi.kbdc0396x.getText().toString());
        sd1.put("kbdc04a", bi.kbdc04a.isChecked() ? "1" : "0");
        sd1.put("kbdc04b", bi.kbdc04b.isChecked() ? "2" : "0");
        sd1.put("kbdc04c", bi.kbdc04c.isChecked() ? "3" : "0");
        sd1.put("kbdc04d", bi.kbdc04d.isChecked() ? "4" : "0");
        sd1.put("kbdc04e", bi.kbdc04e.isChecked() ? "5" : "0");
        sd1.put("kbdc04f", bi.kbdc04f.isChecked() ? "6" : "0");
        sd1.put("kbdc04g", bi.kbdc04g.isChecked() ? "7" : "0");
        sd1.put("kbdc04h", bi.kbdc04h.isChecked() ? "8" : "0");
        sd1.put("kbdc04i", bi.kbdc04i.isChecked() ? "9" : "0");
        sd1.put("kbdc04j", bi.kbdc04j.isChecked() ? "10" : "0");
        sd1.put("kbdc04k", bi.kbdc04k.isChecked() ? "11" : "0");
        sd1.put("kbdc0496", bi.kbdc0496.isChecked() ? "96" : "0");
        sd1.put("kbdc0496x", bi.kbdc0496x.getText().toString());

        MainApp.fc.setsb4_3(String.valueOf(sd1));

        Toast.makeText(this, "Validation Successful! - Saving Draft...", Toast.LENGTH_SHORT).show();
    }

    private boolean UpdateDB() {
        db = new DatabaseHelper(context);
        int updcount = db.updateSB4_3();

        if (updcount == 1) {
            Toast.makeText(this, "Updating Database... Successful!", Toast.LENGTH_SHORT).show();
            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }
    }

    @Override
    public void onBackPressed() {
        Toast.makeText(getApplicationContext(), "You Can't go back", Toast.LENGTH_LONG).show();
    }
}