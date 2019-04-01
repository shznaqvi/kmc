package edu.aku.hassannaqvi.kmc_screening.ui;

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
import edu.aku.hassannaqvi.kmc_screening.databinding.ActivitySectionCForm2Binding;
import edu.aku.hassannaqvi.kmc_screening.validation.ClearClass;
import edu.aku.hassannaqvi.kmc_screening.validation.ValidatorClass;

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

    public void BtnContinue() {
        if (!formValidation())
            return;

        SaveDraft();
        if (UpdateDB()) {


        } else {
            Toast.makeText(this, "Error in updating db!!", Toast.LENGTH_SHORT).show();
        }
    }

    private boolean UpdateDB() {

        DatabaseHelper db = new DatabaseHelper(this);
        long count = db.updateSA1();
        if (count != -1) return true;

        Toast.makeText(this, "Error in updating DB", Toast.LENGTH_SHORT).show();
        return false;
    }

    private void SaveDraft() {
        JSONObject sa1 = GeneratorClass.getContainerJSON(bi.fldGrpSecC02);
        SectionInfoKmcActivity.fc.setsA1(String.valueOf(sa1));
    }

    private boolean formValidation() {
        return ValidatorClass.EmptyCheckingContainer(this, bi.fldGrpSecC02);
    }

    public void BtnEnd() {
        startActivity(new Intent(this, EndingActivity.class));
    }


    private void setListeners() {


        bi.kf2c04.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i != bi.kf2c04a.getId()) {

                    ClearClass.ClearAllCardFields(bi.fldGrpCVkf2c05);

                } else {

                    ClearClass.ClearAllCardFields(bi.fldGrpCVkf2c05);


                }
            }
        });



        bi.kf2c10.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i != bi.kf2c10b.getId()) {

                    ClearClass.ClearAllCardFields(bi.fldGrpCVkf2c11);

                } else {

                    ClearClass.ClearAllCardFields(bi.fldGrpCVkf2c11);


                }
            }
        });


        bi.kf2c10.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i != bi.kf2c10c.getId()) {

                    ClearClass.ClearAllCardFields(bi.fldGrpCVkf2c11);

                } else {

                    ClearClass.ClearAllCardFields(bi.fldGrpCVkf2c11);


                }
            }
        });

    }


}
