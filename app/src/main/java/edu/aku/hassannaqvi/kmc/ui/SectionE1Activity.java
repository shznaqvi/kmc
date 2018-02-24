package edu.aku.hassannaqvi.kmc.ui;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;

import edu.aku.hassannaqvi.kmc.R;
import edu.aku.hassannaqvi.kmc.databinding.ActivitySectionE1Binding;

public class SectionE1Activity extends AppCompatActivity {
ActivitySectionE1Binding bi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_e1);
        bi.setCallback(this);

        setupView();

    }

    private void setupView() {
        bi.ke101.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == R.id.ke101b){
                    bi.fldGrpke102.setVisibility(View.GONE);
                    bi.ke102.clearCheck();
                    bi.ke10296x.setText(null);

                }else{
                    bi.fldGrpke102.setVisibility(View.VISIBLE);
                }
            }
        });
        bi.ke103.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == R.id.ke103a){
                    bi.fldGrpke104.setVisibility(View.GONE);
                    bi.ke104.clearCheck();
                    bi.ke10496x.setText(null);
                }else{
                    bi.fldGrpke104.setVisibility(View.VISIBLE);
                }
            }
        });
        bi.ke105.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == R.id.ke105e){
                    bi.fldGrpke106.setVisibility(View.VISIBLE);

                }else{
                    bi.fldGrpke106.setVisibility(View.GONE);
                    bi.ke106.clearCheck();
                    bi.ke10696x.setText(null);
                }
            }
        });
        bi.ke109.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == R.id.ke109a){
                    bi.fldGrpke110.setVisibility(View.GONE);
                    bi.ke110a.setChecked(false);
                    bi.ke110b.setChecked(false);
                    bi.ke110c.setChecked(false);
                    bi.ke110d.setChecked(false);
                    bi.ke110e.setChecked(false);
                    bi.ke110f.setChecked(false);
                    bi.ke110g.setChecked(false);
                    bi.ke110h.setChecked(false);
                    bi.ke11096x.setText(null);
                }
                else{
                    bi.fldGrpke110.setVisibility(View.VISIBLE);
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
