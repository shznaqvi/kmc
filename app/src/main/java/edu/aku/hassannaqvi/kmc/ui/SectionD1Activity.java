package edu.aku.hassannaqvi.kmc.ui;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;

import edu.aku.hassannaqvi.kmc.R;
import edu.aku.hassannaqvi.kmc.core.DatabaseHelper;
import edu.aku.hassannaqvi.kmc.core.MainApp;
import edu.aku.hassannaqvi.kmc.databinding.ActivitySectionD1Binding;
import edu.aku.hassannaqvi.kmc.validation.validatorClass;

public class SectionD1Activity extends AppCompatActivity {
    ActivitySectionD1Binding bi;
    Context context;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_d1);
        bi.setCallback(this);
        setupView();

        context = this;

    }

    private void setupView() {
        bi.kd103.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.kd103a) {
                    bi.fldGrpkd104.setVisibility(View.GONE);
                    bi.kd104a.setChecked(false);
                    bi.kd104b.setChecked(false);
                    bi.kd104c.setChecked(false);
                    bi.kd104d.setChecked(false);
                    bi.kd104e.setChecked(false);
                    bi.kd104f.setChecked(false);
                    bi.kd104g.setChecked(false);
                    bi.kd104h.setChecked(false);
                    bi.kd10496x.setText(null);
                } else {
                    bi.fldGrpkd104.setVisibility(View.VISIBLE);
                }
            }
        });

    }


    public void BtnEnd() {
/*
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
        }*/
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

                //startActivity(new Intent(this, SectionD2Activity.class));
                startActivity(new Intent(this, MainActivity.class));

            } else {
                Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private boolean formValidation() {
        Toast.makeText(context, "Validating This Section ", Toast.LENGTH_SHORT).show();

        if (!validatorClass.EmptyTextBox(context, bi.kd001d, getString(R.string.days))) {
            return false;
        }
        if (!validatorClass.EmptyTextBox(context, bi.kd001m, getString(R.string.months))) {
            return false;
        }
        if (bi.kd001d.getText().equals("0") && bi.kd001m.getText().equals("0")) {
            bi.kd001d.requestFocus();
            bi.kd001d.setError("Days and month cannot be 0 at a time");
            bi.kd001m.setError("Days and month cannot be 0 at a time");
            return false;
        } else {
            bi.kd001d.setError(null);
            bi.kd001m.setError(null);
            Toast.makeText(context, "ERROR:Days and month cannot be 0 at a time ", Toast.LENGTH_SHORT).show();
        }


        if (!validatorClass.RangeTextBox(context, bi.kd001d, 0, 29, getString(R.string.days), "days")) {
            return false;
        }
        if (!validatorClass.RangeTextBox(context, bi.kd001m, 0, 11, getString(R.string.months), "months")) {
            return false;
        }

        if (!validatorClass.EmptyRadioButton(context, bi.kd101, bi.kd101a, getString(R.string.kd101))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(context, bi.kd102, bi.kd102a, getString(R.string.kd102))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(context, bi.kd103, bi.kd10396, bi.kd10396x, getString(R.string.kd103))) {
            return false;
        }
        if (!bi.kd103a.isChecked()) {
            if (!validatorClass.EmptyCheckBox(context, bi.kd104, bi.kd10496, bi.kd10496x, getString(R.string.kd104))) {
                return false;
            }
        }

        return true;
    }

    private void SaveDraft() throws JSONException {
        Toast.makeText(this, "Saving Draft for  This Section", Toast.LENGTH_SHORT).show();


        JSONObject sd1 = new JSONObject();
        sd1.put("kd001d", bi.kd001d.getText().toString());
        sd1.put("kd001m", bi.kd001m.getText().toString());
        sd1.put("kd101", bi.kd101a.isChecked() ? "1" : bi.kd101b.isChecked() ? "2" : "0");
        sd1.put("kd102",
                bi.kd102a.isChecked() ? "1" :
                        bi.kd102b.isChecked() ? "2" :
                                bi.kd10298.isChecked() ? "98" :
                                        "0");
        sd1.put("kd102ax", bi.kd102ax.getText().toString());

        sd1.put("kd102",
                bi.kd102a.isChecked() ? "1" :
                        bi.kd102b.isChecked() ? "2" :
                                bi.kd10298.isChecked() ? "98" :
                                        "0");
        sd1.put("kd103",
                bi.kd103a.isChecked() ? "1" :
                        bi.kd103b.isChecked() ? "2" :
                                bi.kd103c.isChecked() ? "3" :
                                        bi.kd103d.isChecked() ? "4" :
                                                bi.kd10396.isChecked() ? "96" :
                                                        "0");
        sd1.put("kd10396x", bi.kd10396x.getText().toString());
        sd1.put("kd104a", bi.kd104a.isChecked() ? "1" : "0");
        sd1.put("kd104b", bi.kd104b.isChecked() ? "2" : "0");
        sd1.put("kd104c", bi.kd104c.isChecked() ? "3" : "0");
        sd1.put("kd104d", bi.kd104d.isChecked() ? "4" : "0");
        sd1.put("kd104e", bi.kd104e.isChecked() ? "5" : "0");
        sd1.put("kd104f", bi.kd104f.isChecked() ? "6" : "0");
        sd1.put("kd104g", bi.kd104g.isChecked() ? "7" : "0");
        sd1.put("kd104h", bi.kd104h.isChecked() ? "8" : "0");
        sd1.put("kd10496", bi.kd10496.isChecked() ? "96" : "0");
        sd1.put("kd10496x", bi.kd10496x.getText().toString());

        MainApp.fc.setsD1(String.valueOf(sd1));

        Toast.makeText(this, "Validation Successful! - Saving Draft...", Toast.LENGTH_SHORT).show();
    }

    private boolean UpdateDB() {
       /* db = new DatabaseHelper(context);
        int updcount = db.updateSD1();

        if (updcount == 1) {
            Toast.makeText(this, "Updating Database... Successful!", Toast.LENGTH_SHORT).show();
            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }*/

        return true;
    }

}
