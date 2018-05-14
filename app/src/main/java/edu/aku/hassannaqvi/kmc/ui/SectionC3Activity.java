package edu.aku.hassannaqvi.kmc.ui;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioGroup;

import edu.aku.hassannaqvi.kmc.R;
import edu.aku.hassannaqvi.kmc.databinding.ActivitySectionC3Binding;



public class SectionC3Activity extends AppCompatActivity {

    ActivitySectionC3Binding bi;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_section_c3);

        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_c3);
        bi.setCallback(this);


        bi.kc302.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (bi.kc302a.isChecked()) {
                    bi.fldGrpkc303.setVisibility(View.VISIBLE);
                } else {
                    bi.fldGrpkc303.setVisibility(View.GONE);
                    bi.kc303.clearCheck();
                    bi.kc30396x.setText(null);
                }
            }
        });


        bi.kc310.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                if (bi.kc310a.isChecked()) {
                    bi.fldGrpkc311.setVisibility(View.VISIBLE);

                } else {
                    bi.fldGrpkc311.setVisibility(View.GONE);
                    bi.kc311.clearCheck();
                    bi.kc31196x.setText(null);
                }
            }
        });

        bi.kc314.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (bi.kc314a.isChecked()) {
                    bi.fldGrpkc315.setVisibility(View.GONE);
                    bi.kc315.clearCheck();
                    bi.kc31596x.setText(null);
                } else {
                    bi.fldGrpkc315.setVisibility(View.VISIBLE);
                }
            }
        });










    }


    public void BtnEnd() {
/*
        Toast.makeText(this, "Processing End Section", Toast.LENGTH_SHORT).show();
        if (formValidation()) {
            try {
                SaveDraft();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (UpdateDB()) {
                Toast.makeText(this, "Starting Ending Section", Toast.LENGTH_SHORT).show();

                finish();

                startActivity(new Intent(this, EndingActivity.class));

            } else {
                Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
            }
        }*/
    }
    public void BtnContinue() {

/*        Toast.makeText(this, "Processing This Section", Toast.LENGTH_SHORT).show();
        if (formValidation()) {
            try {
                SaveDraft();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (UpdateDB()) {
                Toast.makeText(this, "Starting Ending Section", Toast.LENGTH_SHORT).show();

                finish();

//                startActivity(new Intent(this, SectionA2Activity.class));

            } else {
                Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
            }
        }*/
    }
}
