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
    }


    private void setContentUI() {
        this.setTitle(R.string.f1_secb);
        deviceID = Settings.Secure.getString(this.getContentResolver(), Settings.Secure.ANDROID_ID);

    }

    public void BtnContinue() throws JSONException {
        if (!formValidation())
            return;

        SaveDraft();
        if (UpdateDB()) {
            startActivity(new Intent(this, EndingActivity.class).putExtra("complete", true));

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

        sa1.put("kf2c01a", bi.kf2c01a.getText().toString());

        sa1.put("kf2c02a", bi.kf2c02a.getText().toString());

        sa1.put("kf2c03a", bi.kf2c03a.getText().toString());

        sa1.put("kf2c04", bi.kf2c04a.isChecked() ? "1" : bi.kf2c04b.isChecked() ? "2" : "0");

        sa1.put("kf2c05", bi.kf2c05a.isChecked() ? "1" : bi.kf2c05b.isChecked() ? "2" : bi.kf2c05c.isChecked() ? "3" : bi.kf2c05d.isChecked() ? "4" : "0");
        sa1.put("kf2c05x", bi.kf2c05x.getText().toString());

        sa1.put("kf2c06", bi.kf2c06a.isChecked() ? "1" : bi.kf2c06b.isChecked() ? "2" : bi.kf2c06c.isChecked() ? "3" : "0");

        sa1.put("kf2c07", bi.kf2c07a.isChecked() ? "1" : bi.kf2c07b.isChecked() ? "2" : "0");

        sa1.put("kf2c08", bi.kf2c08a.isChecked() ? "1" : bi.kf2c08b.isChecked() ? "2" : bi.kf2c0898.isChecked() ? "98" : "0");

        sa1.put("kf2c09", bi.kf2c09a.isChecked() ? "1" : bi.kf2c09b.isChecked() ? "2" : bi.kf2c09c.isChecked() ? "3" : bi.kf2c09d.isChecked() ? "4" : "0");
        sa1.put("kf2c09x", bi.kf2c09x.getText().toString());

        sa1.put("kf2c10", bi.kf2c10a.isChecked() ? "1" : bi.kf2c10b.isChecked() ? "2" : bi.kf2c1098.isChecked() ? "98" : "0");

        sa1.put("kf2c11a", bi.kf2c11a.isChecked() ? "1" : "0");
        sa1.put("kf2c11b", bi.kf2c11b.isChecked() ? "2" : "0");
        sa1.put("kf2c11c", bi.kf2c11c.isChecked() ? "3" : "0");
        sa1.put("kf2c11d", bi.kf2c11d.isChecked() ? "4" : "0");
        sa1.put("kf2c11e", bi.kf2c11e.isChecked() ? "5" : "0");
        sa1.put("kf2c11f", bi.kf2c11f.isChecked() ? "6" : "0");

        fc.setsC(String.valueOf(sa1));
    }

    private boolean formValidation() {
        return ValidatorClass.EmptyCheckingContainer(this, bi.fldGrpSecC01);
    }

    public void BtnEnd() {
        startActivity(new Intent(this, EndingActivity.class));
    }


    private void setListeners() {


        bi.kf2c04.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i != bi.kf2c04a.getId()) {
                    ClearClass.ClearAllFields(bi.fldGrpCVkf2c05, null);
                }
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

    }


}
