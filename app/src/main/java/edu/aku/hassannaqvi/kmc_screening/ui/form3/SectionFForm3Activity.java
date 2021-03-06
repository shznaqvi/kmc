package edu.aku.hassannaqvi.kmc_screening.ui.form3;

import android.content.Intent;
import android.os.Bundle;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import org.json.JSONException;
import org.json.JSONObject;

import edu.aku.hassannaqvi.kmc_screening.R;
import edu.aku.hassannaqvi.kmc_screening.core.DatabaseHelper;
import edu.aku.hassannaqvi.kmc_screening.core.MainApp;
import edu.aku.hassannaqvi.kmc_screening.databinding.ActivitySectionFForm3Binding;
import edu.aku.hassannaqvi.kmc_screening.ui.other.EndingActivity;
import edu.aku.hassannaqvi.kmc_screening.validation.ClearClass;
import edu.aku.hassannaqvi.kmc_screening.validation.ValidatorClass;

import static edu.aku.hassannaqvi.kmc_screening.core.MainApp.fc;

public class SectionFForm3Activity extends AppCompatActivity {

    ActivitySectionFForm3Binding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_f_form3);
        bi.setCallback(this);

        this.setTitle(R.string.f3_hF);
        setupListener();

        /*if (followupNo == 8) {
            bi.fldGrpSecF02.setVisibility(View.VISIBLE);
        } else {
            ClearClass.ClearAllFields(bi.fldGrpSecF02, null);
            bi.fldGrpSecF02.setVisibility(View.GONE);
        }*/

    }

    private void setupListener() {

        bi.kf3f03.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == bi.kf3f03b.getId())
                    ClearClass.ClearAllFields(bi.fldGrpLLkf3f04, null);
            }
        });

        bi.kf3f0597.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                bi.kf3f05a.setChecked(false);
                bi.kf3f05a.setEnabled(false);
                bi.kf3f05b.setChecked(false);
                bi.kf3f05b.setEnabled(false);
                bi.kf3f05c.setChecked(false);
                bi.kf3f05c.setEnabled(false);
                bi.kf3f0596.setChecked(false);
                bi.kf3f0596.setEnabled(false);
            } else {
                bi.kf3f05a.setEnabled(true);
                bi.kf3f05b.setEnabled(true);
                bi.kf3f05c.setEnabled(true);
                bi.kf3f0596.setEnabled(true);
            }
        });

    }

    public void BtnEnd() {
        MainApp.endActivity(this, this);
    }

    private void SaveDraft() throws JSONException {

        JSONObject sa1 = new JSONObject();

        sa1.put("kf3f01a", bi.kf3f01a.isChecked() ? "1" : "0");
        sa1.put("kf3f01b", bi.kf3f01b.isChecked() ? "2" : "0");
        sa1.put("kf3f01c", bi.kf3f01c.isChecked() ? "3" : "0");

        sa1.put("kf3f02a", bi.kf3f02a.isChecked() ? "1" : "0");
        sa1.put("kf3f02b", bi.kf3f02b.isChecked() ? "2" : "0");
        sa1.put("kf3f02c", bi.kf3f02c.isChecked() ? "3" : "0");
        sa1.put("kf3f02d", bi.kf3f02d.isChecked() ? "4" : "0");
        sa1.put("kf3f02e", bi.kf3f02e.isChecked() ? "5" : "0");
        sa1.put("kf3f0296", bi.kf3f0296.isChecked() ? "96" : "0");
        sa1.put("kf3f0296x", bi.kf3f0296x.getText().toString());

        sa1.put("kf3f03", bi.kf3f03a.isChecked() ? "1"
                : bi.kf3f03b.isChecked() ? "2"
                : "0");

        sa1.put("kf3f04a", bi.kf3f04a.isChecked() ? "1" : "0");
        sa1.put("kf3f04b", bi.kf3f04b.isChecked() ? "2" : "0");
        sa1.put("kf3f04c", bi.kf3f04c.isChecked() ? "3" : "0");
        sa1.put("kf3f04d", bi.kf3f04d.isChecked() ? "4" : "0");
        sa1.put("kf3f0496", bi.kf3f0496.isChecked() ? "96" : "0");
        sa1.put("kf3f0496x", bi.kf3f0496x.getText().toString());

        sa1.put("kf3f05a", bi.kf3f05a.isChecked() ? "1" : "0");
        sa1.put("kf3f05b", bi.kf3f05b.isChecked() ? "2" : "0");
        sa1.put("kf3f05c", bi.kf3f05c.isChecked() ? "3" : "0");
        sa1.put("kf3f0597", bi.kf3f0597.isChecked() ? "97" : "0");
        sa1.put("kf3f0596", bi.kf3f0596.isChecked() ? "96" : "0");
        sa1.put("kf3f0596x", bi.kf3f0596x.getText().toString());

        sa1.put("kf3f06", bi.kf3f06a.isChecked() ? "1"
                : bi.kf3f06b.isChecked() ? "2"
                : "0");

        fc.setsF(String.valueOf(sa1));

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
                startActivity(new Intent(this, EndingActivity.class).putExtra("complete", true));

            } else {
                Toast.makeText(this, "Sorry. You can't go further.\n Please contact IT Team (Failed to update DB)", Toast.LENGTH_SHORT).show();
            }
        }

    }

    private boolean formValidation() {
        return ValidatorClass.EmptyCheckingContainer(this, bi.fldGrpSecF02);
    }

    private boolean UpdateDB() {
        DatabaseHelper db = new DatabaseHelper(this);
        int updcount = db.updateSF();
        return updcount == 1;
    }


    @Override
    public void onBackPressed() {
        Toast.makeText(getApplicationContext(), "You Can't go back", Toast.LENGTH_LONG).show();
    }
}
