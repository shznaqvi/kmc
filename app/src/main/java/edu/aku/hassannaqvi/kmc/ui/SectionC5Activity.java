package edu.aku.hassannaqvi.kmc.ui;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioGroup;

import edu.aku.hassannaqvi.kmc.R;
import edu.aku.hassannaqvi.kmc.databinding.ActivitySectionD2Binding;

public class SectionC5Activity extends AppCompatActivity {
    ActivitySectionD2Binding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_section_c5);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_c5);
        bi.setCallback(this);
        setupview();
    }

    private void setupview() {
        bi.kc501.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                bi.kc501.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup group, int checkedId) {
                        if (checkedId == R.id.kc501a) {
                            bi.fldGrpkc502.setVisibility(View.VISIBLE);
                        } else {
                            bi.fldGrpkc502.setVisibility(View.GONE);
                            bi.kc502.setText(null);
                            bi.kc503.setText(null);
                            bi.kc504.setText(null);
                            bi.kc50498.setChecked(false);
                        }
                    }
                });
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
