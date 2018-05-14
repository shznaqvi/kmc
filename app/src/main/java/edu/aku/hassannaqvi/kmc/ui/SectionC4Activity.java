package edu.aku.hassannaqvi.kmc.ui;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioGroup;

import edu.aku.hassannaqvi.kmc.R;
import edu.aku.hassannaqvi.kmc.databinding.ActivitySectionC4Binding;

public class SectionC4Activity extends AppCompatActivity {
    ActivitySectionC4Binding bi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_section_c4);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_c4);
        bi.setCallback(this);
        setupView();
    }

    private void setupView() {
        bi.kc402.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.kc402b) {
                    bi.fldGrpkc403.setVisibility(View.GONE);
                    bi.kc403.clearCheck();
                    bi.kc40396x.setText(null);
                    bi.kc404.clearCheck();
                    bi.kc405.clearCheck();
                    bi.kc406.clearCheck();
                    bi.kc40696x.setText(null);
                    bi.kc407.clearCheck();
                } else {
                    bi.fldGrpkc403.setVisibility(View.VISIBLE);
                }
            }
        });

        bi.kc404.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.kc404b) {
                    bi.fldGrpkc405.setVisibility(View.GONE);

                    bi.kc405.clearCheck();
                    bi.kc406.clearCheck();
                    bi.kc40696x.setText(null);

                } else {
                    bi.fldGrpkc405.setVisibility(View.VISIBLE);
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
