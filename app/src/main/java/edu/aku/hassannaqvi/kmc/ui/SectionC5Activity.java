package edu.aku.hassannaqvi.kmc.ui;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import edu.aku.hassannaqvi.kmc.R;
import edu.aku.hassannaqvi.kmc.core.DatabaseHelper;
import edu.aku.hassannaqvi.kmc.core.MainApp;
import edu.aku.hassannaqvi.kmc.databinding.ActivitySectionC5Binding;
import edu.aku.hassannaqvi.kmc.validation.validatorClass;

public class SectionC5Activity extends AppCompatActivity {
    ActivitySectionC5Binding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_section_c5);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_c5);
        bi.setCallback(this);
        setupview();
    }

    private void setupview() {
        bi.kc501.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                bi.kc501.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup group, int checkedId) {
                        if (checkedId == R.id.kc501a) {
                            bi.fldGrpkc503.setVisibility(View.VISIBLE);
                        } else {
                            bi.fldGrpkc503.setVisibility(View.GONE);
                            bi.kc502.clearCheck();
                            bi.kc503.setText(null);
                            bi.kc504.setText(null);
                            bi.kc505.setText(null);
                            bi.kc50598.setChecked(false);
                        }
                    }
                });
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
            Toast.makeText(this, "Starting Ending Section", Toast.LENGTH_SHORT).show();

            finish();

            startActivity(new Intent(this, EndingActivity.class).putExtra("complete", false));

        } else {
            Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
        }
        //}
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

                startActivity(new Intent(this, SectionC6Activity.class));
                //startActivity(new Intent(this, MainActivity.class));

            } else {
                Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private boolean formValidation() {

        if (!validatorClass.EmptyRadioButton(this, bi.kc501, bi.kc501a, getString(R.string.kc501))) {
            return false;
        }
        if (bi.kc501a.isChecked()) {
            if (!validatorClass.EmptyRadioButton(this, bi.kc502, bi.kc50296, bi.kc50296x, getString(R.string.kc502))) {
                return false;
            }
            if (!validatorClass.EmptyTextBox(this, bi.kc503, getString(R.string.kc503))) {
                return false;
            }
            if (!validatorClass.EmptyTextBox(this, bi.kc504, getString(R.string.kc504))) {
                return false;
            }
            if (!validatorClass.RangeTextBox(this, bi.kc504, 1, 4, getString(R.string.kc504), "per day")) {
                return false;
            }
            if (!bi.kc50598.isChecked()) {
                if (!validatorClass.EmptyTextBox(this, bi.kc505, getString(R.string.kc505))) {
                    return false;
                }
                if (!validatorClass.RangeTextBox(this, bi.kc505, 1, 45, getString(R.string.kc505), "days")) {
                    return false;
                }
            }

        }


        return true;
    }

    private void SaveDraft() throws JSONException {

        JSONObject sC5 = new JSONObject();

        sC5.put("kc501", bi.kc501a.isChecked() ? "1"
                : bi.kc501b.isChecked() ? "2"
                : bi.kc50198.isChecked() ? "98"
                : "0");
        sC5.put("kc502", bi.kc502a.isChecked() ? "1"
                : bi.kc502b.isChecked() ? "2"
                : bi.kc502c.isChecked() ? "3"
                : bi.kc50296.isChecked() ? "96"
                : "0");
        sC5.put("kc50296x", bi.kc50296x.getText().toString());
        sC5.put("kc503", bi.kc503.getText().toString());
        sC5.put("kc504", bi.kc504.getText().toString());
        sC5.put("kc505", bi.kc505.getText().toString());
        sC5.put("kc505", bi.kc50598.isChecked() ? "98"
                : "0");

        MainApp.fc.setsC5(String.valueOf(sC5));
    }

    private boolean UpdateDB() {

        //Long rowId;
        DatabaseHelper db = new DatabaseHelper(this);

        int updcount = db.updateSC5();

        if (updcount == 1) {
            //Toast.makeText(this, "Updating Database... Successful!", Toast.LENGTH_SHORT).show();
            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }

    }
}