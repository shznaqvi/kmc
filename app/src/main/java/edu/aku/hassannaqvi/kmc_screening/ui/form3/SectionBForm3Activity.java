package edu.aku.hassannaqvi.kmc_screening.ui.form3;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import edu.aku.hassannaqvi.kmc_screening.R;
import edu.aku.hassannaqvi.kmc_screening.core.DatabaseHelper;
import edu.aku.hassannaqvi.kmc_screening.core.MainApp;
import edu.aku.hassannaqvi.kmc_screening.databinding.ActivitySectionBForm3Binding;
import edu.aku.hassannaqvi.kmc_screening.validation.ValidatorClass;

import static edu.aku.hassannaqvi.kmc_screening.core.MainApp.fc;

public class SectionBForm3Activity extends AppCompatActivity {

    ActivitySectionBForm3Binding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_b_form3);
        bi.setCallback(this);

        setupViews();

    }

    private void setupViews() {

        bi.kf3b03.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                if (checkedId != bi.kf3b03c.getId()) {
                    bi.fldGrpCVkf3b04.setVisibility(View.GONE);
                    bi.fldGrpCVkf3b05.setVisibility(View.GONE);
                    bi.fldGrpCVkf3b06.setVisibility(View.GONE);
                } else {
                    bi.fldGrpCVkf3b04.setVisibility(View.VISIBLE);
                    bi.fldGrpCVkf3b05.setVisibility(View.VISIBLE);
                    bi.fldGrpCVkf3b06.setVisibility(View.VISIBLE);
                }

            }

        });

    }


    private void SaveDraft() throws JSONException {

        JSONObject sa1 = new JSONObject();

        sa1.put("kf3b01", bi.kf3b01a.isChecked() ? "1"
                : bi.kf3b01b.isChecked() ? "2"
                : bi.kf3b01c.isChecked() ? "3"
                : bi.kf3b01d.isChecked() ? "4"
                : bi.kf3b01e.isChecked() ? "5"
                : bi.kf3b01f.isChecked() ? "6"
                : bi.kf3b01g.isChecked() ? "7"
                : bi.kf3b01h.isChecked() ? "8"
                : "0");

        sa1.put("kf3b02", bi.kf3b02a.isChecked() ? "1"
                : bi.kf3b02b.isChecked() ? "2"
                : bi.kf3b02c.isChecked() ? "3"
                : "0");

        sa1.put("kf3b03", bi.kf3b03a.isChecked() ? "1"
                : bi.kf3b03b.isChecked() ? "2"
                : bi.kf3b03c.isChecked() ? "3"
                : "0");

        sa1.put("kf3b04a", bi.kf3b04a.isChecked() ? "1" : "0");
        sa1.put("kf3b04b", bi.kf3b04b.isChecked() ? "2" : "0");
        sa1.put("kf3b04c", bi.kf3b04c.isChecked() ? "3" : "0");
        sa1.put("kf3b04d", bi.kf3b04d.isChecked() ? "4" : "0");
        sa1.put("kf3b04e", bi.kf3b04e.isChecked() ? "5" : "0");
        sa1.put("kf3b04f", bi.kf3b04f.isChecked() ? "6" : "0");
        sa1.put("kf3b04g", bi.kf3b04g.isChecked() ? "7" : "0");
        sa1.put("kf3b04h", bi.kf3b04h.isChecked() ? "8" : "0");
        sa1.put("kf3b04i", bi.kf3b04i.isChecked() ? "9" : "0");

        sa1.put("kf3b05", bi.kf3b05a.isChecked() ? "1"
                : bi.kf3b05b.isChecked() ? "2"
                : bi.kf3b05c.isChecked() ? "3"
                : bi.kf3b05d.isChecked() ? "4"
                : bi.kf3b05e.isChecked() ? "5"
                : "0");

        sa1.put("kf3b06", bi.kf3b06a.isChecked() ? "1"
                : bi.kf3b06b.isChecked() ? "2"
                : "0");

        fc.setsB(String.valueOf(sa1));

    }

    public void BtnEnd() {
        MainApp.endActivity(this, this);
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
                startActivity(new Intent(this, SectionCForm3Activity.class));

            } else {
                Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
            }
        }


    }

    private boolean formValidation() {
        return ValidatorClass.EmptyCheckingContainer(this, bi.fldGrpSecB02);
    }

    private boolean UpdateDB() {

        DatabaseHelper db = new DatabaseHelper(this);

        int updcount = db.updateSB();

        if (updcount > 0) {
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
