package edu.aku.hassannaqvi.kmc.ui;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioGroup;

import edu.aku.hassannaqvi.kmc.R;
import edu.aku.hassannaqvi.kmc.databinding.ActivitySectionD1Binding;

public class SectionD1Activity extends AppCompatActivity {
    ActivitySectionD1Binding bi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_d1);
        bi.setCallback(this);

        setupView();

    }

    private void setupView() {
        bi.kd101.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.kd101b) {
                    bi.fldGrpkd102.setVisibility(View.GONE);
                    bi.kd102.clearCheck();
                    bi.kd10296x.setText(null);

                }else{
                    bi.fldGrpkd102.setVisibility(View.VISIBLE);
                }
            }
        });
        bi.kd103.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.kd103a) {
                    bi.fldGrpkd104.setVisibility(View.GONE);
                    bi.kd104.clearCheck();
                    bi.kd10496x.setText(null);
                }else{
                    bi.fldGrpkd104.setVisibility(View.VISIBLE);
                }
            }
        });
        bi.kd105.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.kd105e) {
                    bi.fldGrpkd106.setVisibility(View.VISIBLE);

                }else{
                    bi.fldGrpkd106.setVisibility(View.GONE);
                    bi.kd106.clearCheck();
                    bi.kd10696x.setText(null);
                }
            }
        });
        bi.kd109.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.kd109a) {
                    bi.fldGrpkd110.setVisibility(View.GONE);
                    bi.kd110a.setChecked(false);
                    bi.kd110b.setChecked(false);
                    bi.kd110c.setChecked(false);
                    bi.kd110d.setChecked(false);
                    bi.kd110e.setChecked(false);
                    bi.kd110f.setChecked(false);
                    bi.kd110g.setChecked(false);
                    bi.kd110h.setChecked(false);
                    bi.kd11096x.setText(null);
                }
                else{
                    bi.fldGrpkd110.setVisibility(View.VISIBLE);
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
