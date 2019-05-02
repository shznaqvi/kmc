package edu.aku.hassannaqvi.kmc_screening.ui.form2;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioGroup;
import android.widget.Toast;

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

        SaveDraft();
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

    private void SaveDraft() {
        JSONObject sa1 = GeneratorClass.getContainerJSON(bi.fldGrpSecB02, true);
        fc.setsA(String.valueOf(sa1));
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
