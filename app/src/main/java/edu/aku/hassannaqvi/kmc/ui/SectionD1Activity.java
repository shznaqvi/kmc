package edu.aku.hassannaqvi.kmc.ui;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;

import edu.aku.hassannaqvi.kmc.R;
import edu.aku.hassannaqvi.kmc.databinding.ActivitySectionB1Binding;
import edu.aku.hassannaqvi.kmc.databinding.ActivitySectionD1Binding;

public class SectionD1Activity extends AppCompatActivity {
ActivitySectionD1Binding bi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_section_d1);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_d1);
        bi.setCallback(this);
        setupView();
    }

    private void setupView() {
        bi.kd102.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == R.id.kd102b){
                    bi.fldGrpkd103.setVisibility(View.GONE);
                    bi.kd103.clearCheck();
                    bi.kd10396x.setText(null);
                    bi.kd104.clearCheck();
                    bi.kd105.clearCheck();
                    bi.kd106.clearCheck();
                    bi.kd10696x.setText(null);
                    bi.kd107.clearCheck();
                }else{
                    bi.fldGrpkd103.setVisibility(View.VISIBLE);
                }
            }
        });

        bi.kd104.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == R.id.kd104b){
                    bi.fldGrpkd105.setVisibility(View.GONE);

                    bi.kd105.clearCheck();
                    bi.kd106.clearCheck();
                    bi.kd10696x.setText(null);

                }else{
                    bi.fldGrpkd105.setVisibility(View.VISIBLE);
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
