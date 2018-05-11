package edu.aku.hassannaqvi.kmc.ui;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import edu.aku.hassannaqvi.kmc.R;
import edu.aku.hassannaqvi.kmc.databinding.ActivitySectionA1Binding;

public class SectionA1Activity extends AppCompatActivity {


    ActivitySectionA1Binding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_section_a1);

        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_a1);

        bi.setCallback(this);
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
