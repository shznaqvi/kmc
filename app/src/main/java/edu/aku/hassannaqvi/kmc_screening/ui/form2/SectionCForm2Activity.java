package edu.aku.hassannaqvi.kmc_screening.ui.form2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import org.json.JSONException;
import org.json.JSONObject;

import edu.aku.hassannaqvi.kmc_screening.R;
import edu.aku.hassannaqvi.kmc_screening.core.DatabaseHelper;
import edu.aku.hassannaqvi.kmc_screening.core.MainApp;
import edu.aku.hassannaqvi.kmc_screening.databinding.ActivitySectionCForm2Binding;
import edu.aku.hassannaqvi.kmc_screening.ui.other.EndingActivity;
import edu.aku.hassannaqvi.kmc_screening.validation.ClearClass;
import edu.aku.hassannaqvi.kmc_screening.validation.ValidatorClass;

import static edu.aku.hassannaqvi.kmc_screening.core.MainApp.fc;

public class SectionCForm2Activity extends AppCompatActivity {

    ActivitySectionCForm2Binding bi;
    String deviceID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_c_form2);
        bi.setCallback(this);

        setContentUI();
        setListeners();
    }


    private void setContentUI() {
        this.setTitle(R.string.f2_hC);

        if (getIntent().getBooleanExtra("hfScreen", false))
            bi.fldGrpCVkf2c08.setVisibility(View.GONE);

    }

    public void BtnContinue() {
        if (!formValidation())
            return;

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

    private boolean UpdateDB() {

        DatabaseHelper db = new DatabaseHelper(this);
        long count = db.updateSC();
        return count == 1;
    }

    private void SaveDraft() throws JSONException {

        JSONObject sa1 = new JSONObject();

        sa1.put("kf2c01", bi.kf2c01.getText().toString());
        sa1.put("kf2c02", bi.kf2c02.getText().toString());
        sa1.put("kf2c03", bi.kf2c03.getText().toString());
        sa1.put("kf2c04", bi.kf2c04a.isChecked() ? "1" : bi.kf2c04b.isChecked() ? "2" : "0");
        sa1.put("kf2c05", bi.kf2c05a.isChecked() ? "1" : bi.kf2c05b.isChecked() ? "2" : bi.kf2c05c.isChecked() ? "3" : bi.kf2c05d.isChecked() ? "4" : bi.kf2c0596.isChecked() ? "96" : "0");
        sa1.put("kf2c0596x", bi.kf2c0596x.getText().toString());
        sa1.put("kf2c06", bi.kf2c06a.isChecked() ? "1" : bi.kf2c06b.isChecked() ? "2" : bi.kf2c06c.isChecked() ? "3" : bi.kf2c0698.isChecked() ? "98" : "0");
        sa1.put("kf2c07", bi.kf2c07a.isChecked() ? "1" : bi.kf2c07b.isChecked() ? "2" : "0");
        sa1.put("kf2c08", bi.kf2c08a.isChecked() ? "1" : bi.kf2c08b.isChecked() ? "2" : bi.kf2c0898.isChecked() ? "98" : "0");
        sa1.put("kf2c09", bi.kf2c09a.isChecked() ? "1" : bi.kf2c09b.isChecked() ? "2" : bi.kf2c09c.isChecked() ? "3" : bi.kf2c09d.isChecked() ? "4" : bi.kf2c0996.isChecked() ? "96" : "0");
        sa1.put("kf2c0996x", bi.kf2c0996x.getText().toString());
        sa1.put("kf2c10", bi.kf2c10a.isChecked() ? "1" : bi.kf2c10b.isChecked() ? "2" : bi.kf2c1098.isChecked() ? "98" : "0");
        sa1.put("kf2c11a", bi.kf2c11a.isChecked() ? "1" : "0");
        sa1.put("kf2c11b", bi.kf2c11b.isChecked() ? "2" : "0");
        sa1.put("kf2c11c", bi.kf2c11c.isChecked() ? "3" : "0");
        sa1.put("kf2c11d", bi.kf2c11d.isChecked() ? "4" : "0");
        sa1.put("kf2c11e", bi.kf2c11e.isChecked() ? "5" : "0");
        sa1.put("kf2c11f", bi.kf2c11f.isChecked() ? "6" : "0");
        sa1.put("kf2c1196", bi.kf2c1196.isChecked() ? "96" : "0");
        sa1.put("kf2c1198", bi.kf2c1198.isChecked() ? "98" : "0");
        sa1.put("kf2c1196x", bi.kf2c1196x.getText().toString());

        fc.setsC(String.valueOf(sa1));
    }

    private boolean formValidation() {
        return ValidatorClass.EmptyCheckingContainer(this, bi.fldGrpSecC01);
    }

    public void BtnEnd() {
        MainApp.endActivity(this, this);
    }


    private void setListeners() {

        bi.kf2c04.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == bi.kf2c04a.getId())
                    bi.kf2c05.clearCheck();
            }
        });


        bi.kf2c10.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i != bi.kf2c10b.getId()) {
                    ClearClass.ClearAllFields(bi.fldGrpCVkf2c11, null);
                }
            }
        });


        bi.kf2c10.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i != bi.kf2c1098.getId()) {
                    ClearClass.ClearAllFields(bi.fldGrpCVkf2c11, null);
                }
            }
        });

        bi.kf2c1198.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b)
                    ClearClass.ClearAllFields(bi.fldGrpLLkf2c11, false);
                else
                    ClearClass.ClearAllFields(bi.fldGrpLLkf2c11, true);
            }
        });

    }

    @Override
    public void onBackPressed() {
        Toast.makeText(this, "You can't go back", Toast.LENGTH_SHORT).show();
    }

}
