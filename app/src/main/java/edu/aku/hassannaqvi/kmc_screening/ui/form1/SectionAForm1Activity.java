package edu.aku.hassannaqvi.kmc_screening.ui.form1;

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
import edu.aku.hassannaqvi.kmc_screening.databinding.ActivitySectionAForm1Binding;
import edu.aku.hassannaqvi.kmc_screening.ui.other.EndingActivity;
import edu.aku.hassannaqvi.kmc_screening.validation.ClearClass;
import edu.aku.hassannaqvi.kmc_screening.validation.ValidatorClass;

import static edu.aku.hassannaqvi.kmc_screening.core.MainApp.fc;

public class SectionAForm1Activity extends AppCompatActivity {

    ActivitySectionAForm1Binding bi;
    String deviceID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_a_form1);
        bi.setCallback(this);

        setContentUI();
        setListeners();


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

        sa1.put("kf1b01a", bi.kf1b01a.getText().toString());
        sa1.put("kf1b02", bi.kf1b02a.isChecked() ? "1" : bi.kf1b02b.isChecked() ? "2" : "0");
        sa1.put("kf1b03", bi.kf1b03a.isChecked() ? "1" : bi.kf1b03b.isChecked() ? "2" : "0");

        sa1.put("kf1b04a01", bi.kf1b04a01a.isChecked() ? "1" : bi.kf1b04a01b.isChecked() ? "2" : "0");
        sa1.put("kf1b04a02", bi.kf1b04a02a.isChecked() ? "1" : bi.kf1b04a02b.isChecked() ? "2" : "0");
        sa1.put("kf1b04a03", bi.kf1b04a03a.isChecked() ? "1" : bi.kf1b04a03b.isChecked() ? "2" : "0");
        sa1.put("kf1b04a04", bi.kf1b04a04a.isChecked() ? "1" : bi.kf1b04a04b.isChecked() ? "2" : "0");
        sa1.put("kf1b04a05", bi.kf1b04a05a.isChecked() ? "1" : bi.kf1b04a05b.isChecked() ? "2" : "0");

        sa1.put("kf1b04b01", bi.kf1b04b01a.isChecked() ? "1" : bi.kf1b04b01b.isChecked() ? "2" : "0");
        sa1.put("kf1b04b02", bi.kf1b04b02a.isChecked() ? "1" : bi.kf1b04b02b.isChecked() ? "2" : "0");
        sa1.put("kf1b04b03", bi.kf1b04b03a.isChecked() ? "1" : bi.kf1b04b03b.isChecked() ? "2" : "0");
        sa1.put("kf1b04b04", bi.kf1b04b04a.isChecked() ? "1" : bi.kf1b04b04b.isChecked() ? "2" : "0");
        sa1.put("kf1b04b05", bi.kf1b04b05a.isChecked() ? "1" : bi.kf1b04b05b.isChecked() ? "2" : "0");
        sa1.put("kf1b04b06", bi.kf1b04b06a.isChecked() ? "1" : bi.kf1b04b06b.isChecked() ? "2" : "0");
        sa1.put("kf1b04b07", bi.kf1b04b07a.isChecked() ? "1" : bi.kf1b04b07b.isChecked() ? "2" : "0");
        sa1.put("kf1b04b08", bi.kf1b04b08a.isChecked() ? "1" : bi.kf1b04b08b.isChecked() ? "2" : "0");
        sa1.put("kf1b04b09", bi.kf1b04b09a.isChecked() ? "1" : bi.kf1b04b09b.isChecked() ? "2" : "0");

        sa1.put("kf1b04c01", bi.kf1b04c01a.isChecked() ? "1" : bi.kf1b04c01b.isChecked() ? "2" : "0");

        sa1.put("kf1b05a01", bi.kf1b05a01a.isChecked() ? "1" : bi.kf1b05a01b.isChecked() ? "2" : "0");
        sa1.put("kf1b05a02", bi.kf1b05a02a.isChecked() ? "1" : bi.kf1b05a02b.isChecked() ? "2" : "0");
        sa1.put("kf1b05a03", bi.kf1b05a03a.isChecked() ? "1" : bi.kf1b05a03b.isChecked() ? "2" : "0");
        sa1.put("kf1b05a04", bi.kf1b05a04a.isChecked() ? "1" : bi.kf1b05a04b.isChecked() ? "2" : "0");
        sa1.put("kf1b05a05", bi.kf1b05a05a.isChecked() ? "1" : bi.kf1b05a05b.isChecked() ? "2" : "0");
        sa1.put("kf1b05a0596", bi.kf1b05a0596.getText().toString());

        sa1.put("kf1b06", bi.kf1b06a.isChecked() ? "1" : bi.kf1b06b.isChecked() ? "2" : "0");

        sa1.put("kf1b07", bi.kf1b07a.isChecked() ? "1" : bi.kf1b07b.isChecked() ? "2" : "0");

        sa1.put("kf1b08", bi.kf1b08a.isChecked() ? "1" : bi.kf1b08b.isChecked() ? "2" : "0");

        sa1.put("kf1b09", bi.kf1b09a.isChecked() ? "1" : bi.kf1b09b.isChecked() ? "2" : "0");
        sa1.put("kf1b09x", bi.kf1b09x.getText().toString());

        sa1.put("kf1b10", bi.kf1b10a.isChecked() ? "1" : bi.kf1b10b.isChecked() ? "2" : "0");

        sa1.put("kf1b11a", bi.kf1b11a.getText().toString());

        fc.setsA(String.valueOf(sa1));
    }



    private boolean formValidation() {
        return ValidatorClass.EmptyCheckingContainer(this, bi.fldGrpSecB01);
    }

    public void BtnEnd() {
        startActivity(new Intent(this, EndingActivity.class));
    }

    private void setListeners() {

        bi.kf1b010.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i != bi.kf1b10a.getId()) {
                    ClearClass.ClearAllFields(bi.fldGrpCVkf1b11, null);
                }
            }
        });


        bi.kf1b010.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i != bi.kf1b04a01a.getId()) {
                    ClearClass.ClearAllFields(bi.fldGrpCVkkf1b05maj, null);
                }
            }
        });


        bi.kf1b04a01.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i != bi.kf1b04a02a.getId()) {
                    ClearClass.ClearAllFields(bi.fldGrpCVkkf1b05maj, null);
                }
            }
        });


        bi.kf1b04a02.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i != bi.kf1b04a03a.getId()) {
                    ClearClass.ClearAllFields(bi.fldGrpCVkkf1b05maj, null);
                }
            }
        });


        bi.kf1b04a03.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i != bi.kf1b04a04a.getId()) {
                    ClearClass.ClearAllFields(bi.fldGrpCVkkf1b05maj, null);
                }
            }
        });


        bi.kf1b04a04.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i != bi.kf1b04a05a.getId()) {
                    ClearClass.ClearAllFields(bi.fldGrpCVkkf1b05maj, null);
                }
            }
        });


        bi.kf1b04a05.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i != bi.kf1b04b01a.getId()) {
                    ClearClass.ClearAllFields(bi.fldGrpCVkkf1b05maj, null);
                }
            }
        });


        bi.kf1b04b01.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i != bi.kf1b04b01a.getId()) {
                    ClearClass.ClearAllFields(bi.fldGrpCVkkf1b05maj, null);
                }
            }
        });

        bi.kf1b04b01.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i != bi.kf1b04b02a.getId()) {
                    ClearClass.ClearAllFields(bi.fldGrpCVkkf1b05maj, null);
                }
            }
        });


        bi.kf1b04b02.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i != bi.kf1b04b03a.getId()) {
                    ClearClass.ClearAllFields(bi.fldGrpCVkkf1b05maj, null);
                }
            }
        });


        bi.kf1b04b03.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i != bi.kf1b04b04a.getId()) {
                    ClearClass.ClearAllFields(bi.fldGrpCVkkf1b05maj, null);
                }
            }
        });


        bi.kf1b04b04.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i != bi.kf1b04b05a.getId()) {
                    ClearClass.ClearAllFields(bi.fldGrpCVkkf1b05maj, null);
                }
            }
        });


        bi.kf1b04b05.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i != bi.kf1b04b05a.getId()) {
                    ClearClass.ClearAllFields(bi.fldGrpCVkkf1b05maj, null);
                }
            }
        });


        bi.kf1b04b06.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i != bi.kf1b04b06a.getId()) {
                    ClearClass.ClearAllFields(bi.fldGrpCVkkf1b05maj, null);
                }
            }
        });


        bi.kf1b04b07.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i != bi.kf1b04b07a.getId()) {
                    ClearClass.ClearAllFields(bi.fldGrpCVkkf1b05maj, null);
                }
            }
        });


        bi.kf1b04b06.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i != bi.kf1b04b07a.getId()) {
                    ClearClass.ClearAllFields(bi.fldGrpCVkkf1b05maj, null);
                }
            }
        });


        bi.kf1b04b07.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i != bi.kf1b04b09a.getId()) {
                    ClearClass.ClearAllFields(bi.fldGrpCVkkf1b05maj, null);
                }
            }
        });


        bi.kf1b04b09.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i != bi.kf1b04c01a.getId()) {
                    ClearClass.ClearAllFields(bi.fldGrpCVkkf1b05maj, null);
                }
            }
        });


        bi.kf1b04b06.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i != bi.kf1b04b06a.getId()) {
                    ClearClass.ClearAllFields(bi.fldGrpCVkf1b04b07, null);
                }
            }
        });


        bi.kf1b04b07.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i != bi.kf1b04b07a.getId()) {
                    ClearClass.ClearAllFields(bi.fldGrpCVkf1b04b08, null);
                    ClearClass.ClearAllFields(bi.fldGrpCVkf1b04b09, null);
                    ClearClass.ClearAllFields(bi.fldGrpCVkf1b010, null);
                    ClearClass.ClearAllFields(bi.fldGrpCVkf1b11, null);
                }
            }
        });
        bi.kf1b04b08.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i != bi.kf1b04b08a.getId()) {
                    ClearClass.ClearAllFields(bi.fldGrpCVkf1b04b09, null);
                    ClearClass.ClearAllFields(bi.fldGrpCVkf1b010, null);
                    ClearClass.ClearAllFields(bi.fldGrpCVkf1b11, null);
                }
            }
        });


        bi.kf1b010.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i != bi.kf1b10a.getId()) {
                    ClearClass.ClearAllFields(bi.fldGrpCVkf1b11, null);
                }
            }
        });


    }
}





