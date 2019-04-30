package edu.aku.hassannaqvi.kmc_screening.ui.form1;

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
        long count = db.updateSA();
        if (count != -1) return true;

        Toast.makeText(this, "Error in updating DB", Toast.LENGTH_SHORT).show();
        return false;
    }

    private void SaveDraft() {
        JSONObject sa1 = GeneratorClass.getContainerJSON(bi.fldGrpSecB01, true);
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


                    ClearClass.ClearAllCardFields(bi.fldGrpCVkf1b11);


                } else {


                    ClearClass.ClearAllCardFields(bi.fldGrpCVkf1b11);

                }
            }
        });


        bi.kf1b010.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i != bi.kf1b04a01a.getId()) {

                    ClearClass.ClearAllCardFields(bi.fldGrpCVkkf1b05maj);

                } else {

                    ClearClass.ClearAllCardFields(bi.fldGrpCVkkf1b05maj);


                }
            }
        });


        bi.kf1b04a01.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i != bi.kf1b04a02a.getId()) {

                    ClearClass.ClearAllCardFields(bi.fldGrpCVkkf1b05maj);

                } else {

                    ClearClass.ClearAllCardFields(bi.fldGrpCVkkf1b05maj);


                }
            }
        });


        bi.kf1b04a02.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i != bi.kf1b04a03a.getId()) {

                    ClearClass.ClearAllCardFields(bi.fldGrpCVkkf1b05maj);

                } else {

                    ClearClass.ClearAllCardFields(bi.fldGrpCVkkf1b05maj);


                }
            }
        });


        bi.kf1b04a03.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i != bi.kf1b04a04a.getId()) {

                    ClearClass.ClearAllCardFields(bi.fldGrpCVkkf1b05maj);

                } else {

                    ClearClass.ClearAllCardFields(bi.fldGrpCVkkf1b05maj);


                }
            }
        })
        ;

        bi.kf1b04a04.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i != bi.kf1b04a05a.getId()) {

                    ClearClass.ClearAllCardFields(bi.fldGrpCVkkf1b05maj);

                } else {

                    ClearClass.ClearAllCardFields(bi.fldGrpCVkkf1b05maj);


                }
            }
        });


        bi.kf1b04a05.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i != bi.kf1b04b01a.getId()) {

                    ClearClass.ClearAllCardFields(bi.fldGrpCVkkf1b05maj);

                } else {

                    ClearClass.ClearAllCardFields(bi.fldGrpCVkkf1b05maj);


                }
            }
        });


        bi.kf1b04b01.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i != bi.kf1b04b01a.getId()) {

                    ClearClass.ClearAllCardFields(bi.fldGrpCVkkf1b05maj);

                } else {

                    ClearClass.ClearAllCardFields(bi.fldGrpCVkkf1b05maj);


                }
            }
        });

        bi.kf1b04b01.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i != bi.kf1b04b02a.getId()) {

                    ClearClass.ClearAllCardFields(bi.fldGrpCVkkf1b05maj);

                } else {

                    ClearClass.ClearAllCardFields(bi.fldGrpCVkkf1b05maj);


                }
            }
        });


        bi.kf1b04b02.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i != bi.kf1b04b03a.getId()) {

                    ClearClass.ClearAllCardFields(bi.fldGrpCVkkf1b05maj);

                } else {

                    ClearClass.ClearAllCardFields(bi.fldGrpCVkkf1b05maj);


                }
            }
        });


        bi.kf1b04b03.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i != bi.kf1b04b04a.getId()) {

                    ClearClass.ClearAllCardFields(bi.fldGrpCVkkf1b05maj);

                } else {

                    ClearClass.ClearAllCardFields(bi.fldGrpCVkkf1b05maj);


                }
            }
        });


        bi.kf1b04b04.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i != bi.kf1b04b05a.getId()) {

                    ClearClass.ClearAllCardFields(bi.fldGrpCVkkf1b05maj);

                } else {

                    ClearClass.ClearAllCardFields(bi.fldGrpCVkkf1b05maj);


                }
            }
        });


        bi.kf1b04b05.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i != bi.kf1b04b05a.getId()) {

                    ClearClass.ClearAllCardFields(bi.fldGrpCVkkf1b05maj);

                } else {

                    ClearClass.ClearAllCardFields(bi.fldGrpCVkkf1b05maj);


                }
            }
        });


        bi.kf1ab04b06.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i != bi.kf1ab04b06a.getId()) {

                    ClearClass.ClearAllCardFields(bi.fldGrpCVkkf1b05maj);

                } else {

                    ClearClass.ClearAllCardFields(bi.fldGrpCVkkf1b05maj);


                }
            }
        });


        bi.kf1b04b07.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i != bi.kf1b04b07a.getId()) {

                    ClearClass.ClearAllCardFields(bi.fldGrpCVkkf1b05maj);

                } else {

                    ClearClass.ClearAllCardFields(bi.fldGrpCVkkf1b05maj);


                }
            }
        });


        bi.kf1ab04b06.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i != bi.kf1b04b07a.getId()) {

                    ClearClass.ClearAllCardFields(bi.fldGrpCVkkf1b05maj);

                } else {

                    ClearClass.ClearAllCardFields(bi.fldGrpCVkkf1b05maj);


                }
            }
        });


        bi.kf1b04b07.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i != bi.kf1b04b09a.getId()) {

                    ClearClass.ClearAllCardFields(bi.fldGrpCVkkf1b05maj);

                } else {

                    ClearClass.ClearAllCardFields(bi.fldGrpCVkkf1b05maj);


                }
            }
        });


        bi.kf1b04b09.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i != bi.kf1b04c01a.getId()) {

                    ClearClass.ClearAllCardFields(bi.fldGrpCVkkf1b05maj);

                } else {

                    ClearClass.ClearAllCardFields(bi.fldGrpCVkkf1b05maj);


                }
            }
        });


        bi.kf1ab04b06.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i != bi.kf1ab04b06a.getId()) {

                    ClearClass.ClearAllCardFields(bi.fldGrpCVkf1b04b07);

                } else {

                    ClearClass.ClearAllCardFields(bi.fldGrpCVkf1b04b07);


                }
            }
        });


        bi.kf1b04b07.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i != bi.kf1b04b07a.getId()) {

                    ClearClass.ClearAllCardFields(bi.fldGrpCVkf1b04b08);
                    ClearClass.ClearAllCardFields(bi.fldGrpCVkf1b04b09);
                    ClearClass.ClearAllCardFields(bi.fldGrpCVkf1b010);
                    ClearClass.ClearAllCardFields(bi.fldGrpCVkf1b11);

                } else {

                    ClearClass.ClearAllCardFields(bi.fldGrpCVkf1b04b08);
                    ClearClass.ClearAllCardFields(bi.fldGrpCVkf1b04b09);
                    ClearClass.ClearAllCardFields(bi.fldGrpCVkf1b010);
                    ClearClass.ClearAllCardFields(bi.fldGrpCVkf1b11);


                }
            }
        });
        bi.kf1b04b08.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i != bi.kf1b04b08a.getId()) {


                    ClearClass.ClearAllCardFields(bi.fldGrpCVkf1b04b09);

                    ClearClass.ClearAllCardFields(bi.fldGrpCVkf1b010);
                    ClearClass.ClearAllCardFields(bi.fldGrpCVkf1b11);


                } else {


                    ClearClass.ClearAllCardFields(bi.fldGrpCVkf1b04b09);

                    ClearClass.ClearAllCardFields(bi.fldGrpCVkf1b010);
                    ClearClass.ClearAllCardFields(bi.fldGrpCVkf1b11);


                }
            }
        });


        bi.kf1b010.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i != bi.kf1b10a.getId()) {


                    ClearClass.ClearAllCardFields(bi.fldGrpCVkf1b11);


                } else {


                    ClearClass.ClearAllCardFields(bi.fldGrpCVkf1b11);

                }
            }
        });


    }
}





