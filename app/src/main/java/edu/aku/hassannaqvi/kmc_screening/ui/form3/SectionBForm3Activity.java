package edu.aku.hassannaqvi.kmc_screening.ui.form3;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import edu.aku.hassannaqvi.kmc_screening.R;
import edu.aku.hassannaqvi.kmc_screening.core.DatabaseHelper;
import edu.aku.hassannaqvi.kmc_screening.core.MainApp;
import edu.aku.hassannaqvi.kmc_screening.databinding.ActivitySectionBForm3Binding;
import edu.aku.hassannaqvi.kmc_screening.ui.other.EndingActivity;
import edu.aku.hassannaqvi.kmc_screening.validation.ClearClass;
import edu.aku.hassannaqvi.kmc_screening.validation.ValidatorClass;

import static edu.aku.hassannaqvi.kmc_screening.core.MainApp.fc;

public class SectionBForm3Activity extends AppCompatActivity {

    ActivitySectionBForm3Binding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_b_form3);
        bi.setCallback(this);

        this.setTitle(R.string.f3_hB);

        setupViews();

    }

    private void setupViews() {

        bi.kf3b02.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i != bi.kf3b02a.getId()) {
                    ClearClass.ClearAllFields(bi.fldGrpSecB03, null);
                }
            }
        });

        bi.kf3b0498.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b){
                    ClearClass.ClearAllFields(bi.fldGrpLLkf3b04, false);
                    bi.fldGrpLLkf3b04.setTag("-1");
                } else {
                    ClearClass.ClearAllFields(bi.fldGrpLLkf3b04, true);
                    bi.fldGrpLLkf3b04.setTag("0");
                }
            }
        });

        bi.kf3b03.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i != bi.kf3b03c.getId())
                    ClearClass.ClearAllFields(bi.fldGrpSecB04, null);
            }
        });

    }

    private void SaveDraft() throws JSONException {

        JSONObject sa1 = new JSONObject();

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
        sa1.put("kf3b0498", bi.kf3b0498.isChecked() ? "98" : "0");
        sa1.put("kf3b04i", bi.kf3b0496.isChecked() ? "96" : "0");
        sa1.put("kf3b0496x", bi.kf3b0496x.getText().toString());

        sa1.put("kf3b05", bi.kf3b05a.isChecked() ? "1"
                : bi.kf3b05b.isChecked() ? "2"
                : bi.kf3b05c.isChecked() ? "3"
                : bi.kf3b05d.isChecked() ? "4"
                : bi.kf3b0596.isChecked() ? "96"
                : "0");
        sa1.put("kf3b0596x", bi.kf3b0596x.getText().toString());

        sa1.put("kf3b06h", bi.kf3b06h.getText().toString());
        sa1.put("kf3b06d", bi.kf3b06d.getText().toString());

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
                startActivity(new Intent(this, !bi.kf3b02a.isChecked() || !bi.kf3b03a.isChecked() ? EndingActivity.class : SectionCForm3Activity.class)
                        .putExtra("complete", true).putExtra("day1", getIntent().getBooleanExtra("dayFlag", false)));

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
