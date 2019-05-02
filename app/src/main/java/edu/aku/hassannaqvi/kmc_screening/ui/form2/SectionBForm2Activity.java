package edu.aku.hassannaqvi.kmc_screening.ui.form2;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioGroup;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import edu.aku.hassannaqvi.kmc_screening.JSON.GeneratorClass;
import edu.aku.hassannaqvi.kmc_screening.R;
import edu.aku.hassannaqvi.kmc_screening.core.DatabaseHelper;
import edu.aku.hassannaqvi.kmc_screening.core.MainApp;
import edu.aku.hassannaqvi.kmc_screening.databinding.ActivitySectionBForm2Binding;
import edu.aku.hassannaqvi.kmc_screening.validation.ClearClass;
import edu.aku.hassannaqvi.kmc_screening.validation.ValidatorClass;

import static edu.aku.hassannaqvi.kmc_screening.core.MainApp.fc;

public class SectionBForm2Activity extends AppCompatActivity {

    ActivitySectionBForm2Binding bi;
    String deviceID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_b_form2);
        bi.setCallback(this);

        setContentUI();
    }


    private void setContentUI() {
        this.setTitle(R.string.f1_secb);
        deviceID = Settings.Secure.getString(this.getContentResolver(), Settings.Secure.ANDROID_ID);

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
            startActivity(new Intent(this, SectionCForm2Activity.class));

        } else {
            Toast.makeText(this, "Error in updating db!!", Toast.LENGTH_SHORT).show();
        }
    }

    private boolean UpdateDB() {

        DatabaseHelper db = new DatabaseHelper(this);
        long count = db.updateSA();
        if (count != -1) return true;

        Toast.makeText(this, "Error in updating DB", Toast.LENGTH_SHORT).show();
        return false;
    }

    private void SaveDraft() throws JSONException {
        
        JSONObject sa1 = new JSONObject();

        sa1.put("kf2b01a", bi.kf2b01a.getText().toString());

        sa1.put("kf2b02a", bi.kf2b02a.getText().toString());

        sa1.put("kf2b03a", bi.kf2b03a.getText().toString());

        sa1.put("kf2b04a", bi.kf2b04a.getText().toString());

        sa1.put("kf2b05", bi.kf2b05a.isChecked() ? "1" : bi.kf2b05b.isChecked() ? "2" : "0");

        sa1.put("kf2b06", bi.kf2b06a.isChecked() ? "1" : bi.kf2b06b.isChecked() ? "2" : bi.kf2b06c.isChecked() ? "3" : bi.kf2b0696.isChecked() ? "96" : "0");

        sa1.put("kf2b07", bi.kf2b07a.isChecked() ? "1" : bi.kf2b07b.isChecked() ? "2" : "0");

        sa1.put("kf2b08a", bi.kf2b08a.getText().toString());

        sa1.put("kf2b09", bi.kf2b09a.isChecked() ? "1" : bi.kf2b09b.isChecked() ? "2" : "0");

        sa1.put("kf2b10", bi.kf2b10a.isChecked() ? "1" : bi.kf2b10b.isChecked() ? "2" : "0");
        sa1.put("kf2b10c", bi.kf2b10c.getText().toString());

        sa1.put("kf2b10d", bi.kf2b10d.getText().toString());

        sa1.put("kf2b11a", bi.kf2b11a.getText().toString());

        sa1.put("kf2b12a", bi.kf2b12a.getText().toString());

        sa1.put("kf2b13a", bi.kf2b13a.getText().toString());

        sa1.put("kf2b14", bi.kf2b14a.isChecked() ? "1" : bi.kf2b14b.isChecked() ? "2" : "0");

        sa1.put("kf2b15", bi.kf2b15a.isChecked() ? "1" : bi.kf2b15b.isChecked() ? "2" : "0");

        sa1.put("kf2b16a", bi.kf2b16a.isChecked() ? "1" : "0");
        sa1.put("kf2b16b", bi.kf2b16b.isChecked() ? "2" : "0");
        sa1.put("kf2b16c", bi.kf2b16c.isChecked() ? "3" : "0");
        sa1.put("kf2b16d", bi.kf2b16d.isChecked() ? "4" : "0");
        sa1.put("kf2b16e", bi.kf2b16e.isChecked() ? "5" : "0");
        sa1.put("kf2b16f", bi.kf2b16f.isChecked() ? "6" : "0");
        sa1.put("kf2b16g", bi.kf2b16g.isChecked() ? "7" : "0");
        sa1.put("kf2b16h", bi.kf2b16h.isChecked() ? "8" : "0");
        sa1.put("kf2b16x", bi.kf2b16x.getText().toString());

        fc.setsB(String.valueOf(sa1));
    }

    

    private boolean formValidation() {
        return ValidatorClass.EmptyCheckingContainer(this, bi.fldGrpSecB02);
    }

    public void BtnEnd() {
        MainApp.endActivity(this, this);
    }


    private void setListeners() {


        bi.kf2b07.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i != bi.kf2b07a.getId()) {
                    ClearClass.ClearAllFields(bi.fldGrpCVkf2b08, null);
                }
            }
        });


        bi.kf2b14.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i != bi.kf2b14b.getId()) {
                    ClearClass.ClearAllFields(bi.fldGrpCVkf2b15, null);
                    ClearClass.ClearAllFields(bi.fldGrpCVkf2b16, null);
                }
            }
        });

        bi.kf2b15.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i != bi.kf2b15b.getId()) {
                    ClearClass.ClearAllFields(bi.fldGrpCVkf2b16, null);
                }
            }
        });
    }
}
