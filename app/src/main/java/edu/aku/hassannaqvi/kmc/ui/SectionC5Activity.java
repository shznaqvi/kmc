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
                            bi.fldGrpkc502.setVisibility(View.VISIBLE);
                        } else {
                            bi.fldGrpkc502.setVisibility(View.GONE);
                            bi.kc502.setText(null);
                            bi.kc503.setText(null);
                            bi.kc504.setText(null);
                            bi.kc50498.setChecked(false);
                        }
                    }
                });
            }
        });
    }

    public void BtnEnd() {

        Toast.makeText(this, "Processing End Section", Toast.LENGTH_SHORT).show();
        if (formValidation()) {
            try {
                SaveDraft();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (UpdateDB()) {
                Toast.makeText(this, "Starting Ending Section", Toast.LENGTH_SHORT).show();

                finish();

                startActivity(new Intent(this, EndingActivity.class));

            } else {
                Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
            }
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

                startActivity(new Intent(this, SectionC6Activity.class));

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
            if (!validatorClass.EmptyTextBox(this, bi.kc502, getString(R.string.kc502))) {
                return false;
            }
            if (!validatorClass.EmptyTextBox(this, bi.kc503, getString(R.string.kc503))) {
                return false;
            }
            return validatorClass.EmptyTextBox(this, bi.kc504, getString(R.string.kc504));
        }


        return true;
    }

    private void SaveDraft() throws JSONException {

        JSONObject sC5 = new JSONObject();

        sC5.put("kc501", bi.kc501a.isChecked() ? "1"
                : bi.kc501b.isChecked() ? "2"
                : bi.kc50198.isChecked() ? "98"
                : "0");
        sC5.put("kc502", bi.kc502.getText().toString());
        sC5.put("kc503", bi.kc503.getText().toString());
        sC5.put("kc504", bi.kc504.getText().toString());
        sC5.put("kc504",
                bi.kc50498.isChecked() ? "98"
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
