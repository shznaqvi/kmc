package edu.aku.hassannaqvi.kmc.ui;

import android.app.Activity;
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

import edu.aku.hassannaqvi.kmc.R;
import edu.aku.hassannaqvi.kmc.core.DatabaseHelper;
import edu.aku.hassannaqvi.kmc.core.MainApp;
import edu.aku.hassannaqvi.kmc.databinding.ActivitySectionD2Binding;
import edu.aku.hassannaqvi.kmc.validation.validatorClass;

public class SectionD2Activity extends AppCompatActivity {
    ActivitySectionD2Binding bi;
    Context context;
    DatabaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_d2);
        bi.setCallback(this);

        context = SectionD2Activity.this;
        setupView();
    }

    private void setupView() {
        bi.kd203.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.kd203b) {
                    bi.fldGrpkd204.setVisibility(View.GONE);
                    bi.kd204.clearCheck();
                    bi.kd20496x.setText(null);
                }
                else{
                    bi.fldGrpkd204.setVisibility(View.VISIBLE);
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

                //startActivity(new Intent(this, SectionD3Activity.class));
                startActivity(new Intent(this, MainActivity.class));

            } else {
                Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
            }
        }
    }
    private boolean formValidation(){
        Toast.makeText(context, "Validating This Section ", Toast.LENGTH_SHORT).show();

        if (!validatorClass.EmptyTextBox(context, bi.kd201d, getString(R.string.days))) {
            return false;
        }
        if (!validatorClass.EmptyTextBox(context, bi.kd201m, getString(R.string.months))) {
            return false;
        }
        if (!validatorClass.RangeTextBox(context, bi.kd201d,1, 29, getString(R.string.days), "days")) {
            return false;
        }
        if (!validatorClass.RangeTextBox(context, bi.kd201m,1, 11, getString(R.string.months), "months")) {
            return false;
        }

        if (!validatorClass.EmptyCheckBox(context, bi.kd202, bi.kd20296,bi.kd20296x, getString(R.string.other))){
            return false;
        }
        if (!validatorClass.EmptyRadioButton(context, bi.kd203, bi.kd203a, getString(R.string.kd203))) {
            return false;
        }
        if(!bi.kd203b.isChecked()){
            if (!validatorClass.EmptyRadioButton(context, bi.kd204, bi.kd20496,bi.kd20496x, getString(R.string.kd204))) {
                return false;
            }
        }
        return true;
    }
    private void SaveDraft() throws JSONException {
        Toast.makeText(this, "Saving Draft for  This Section", Toast.LENGTH_SHORT).show();

        JSONObject sd2 = new JSONObject();
        sd2.put("kd201",
                bi.kd201a.isChecked() ? "1" :
                        bi.kd201b.isChecked() ? "2" :
                        bi.kd20199.isChecked() ? "99" :
                        bi.kd20177.isChecked() ? "77" :
                                bi.kd20198.isChecked() ? "98" :
                                        "0");
        sd2.put("kd201d", bi.kd201d.getText().toString());
        sd2.put("kd201m", bi.kd201m.getText().toString());

        sd2.put("kd202a", bi.kd202a.isChecked() ? "1" : "0");
        sd2.put("kd202b", bi.kd202b.isChecked() ? "2" : "0");
        sd2.put("kd202c", bi.kd202c.isChecked() ? "3" : "0");
        sd2.put("kd202d", bi.kd202d.isChecked() ? "4" : "0");
        sd2.put("kd202e", bi.kd202e.isChecked() ? "5" : "0");
        sd2.put("kd20296", bi.kd20296.isChecked() ? "96" : "0");
        sd2.put("kd20296x", bi.kd20296x.getText().toString());


        sd2.put("kd203",
                bi.kd203a.isChecked() ? "1" :
                        bi.kd203b.isChecked() ? "2" :
                                        "0");
        sd2.put("kd204",
                bi.kd204a.isChecked() ? "1" :
                        bi.kd204b.isChecked() ? "2" :
                        bi.kd204c.isChecked() ? "3" :
                        bi.kd204d.isChecked() ? "4" :
                        bi.kd204e.isChecked() ? "5" :
                        bi.kd204f.isChecked() ? "6" :
                        bi.kd204g.isChecked() ? "7" :
                        bi.kd20496.isChecked() ? "96" :
                                        "0");
        sd2.put("kd20496x", bi.kd20496x.getText().toString());

        MainApp.fc.setsD2(String.valueOf(sd2));

        Toast.makeText(this, "Validation Successful! - Saving Draft...", Toast.LENGTH_SHORT).show();
    }

    private boolean UpdateDB() {
        /*db = new DatabaseHelper(context);
        int updcount = db.updateSD2();

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
