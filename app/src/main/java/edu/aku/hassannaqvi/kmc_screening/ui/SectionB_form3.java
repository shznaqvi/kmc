package edu.aku.hassannaqvi.kmc_screening.ui;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.Toast;

import edu.aku.hassannaqvi.kmc_screening.R;
import edu.aku.hassannaqvi.kmc_screening.databinding.ActivitySectionBForm3Binding;

public class SectionB_form3 extends AppCompatActivity {

    ActivitySectionBForm3Binding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_b_form3);
        bi.setCallback(this);

        setupViews();

    }

    private void setupViews() {

        bi.kf3b03.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                if (checkedId != bi.kf3b03c.getId()) {
                    bi.fldGrpCVkf3b04.setVisibility(View.GONE);
                    bi.fldGrpCVkf3b05.setVisibility(View.GONE);
                    bi.fldGrpCVkf3b06.setVisibility(View.GONE);
                } else {
                    bi.fldGrpCVkf3b04.setVisibility(View.VISIBLE);
                    bi.fldGrpCVkf3b05.setVisibility(View.VISIBLE);
                    bi.fldGrpCVkf3b06.setVisibility(View.VISIBLE);
                }


            }

        });

    }


    private void SaveDraft() {

    }

    public void BtnEnd() {


    }

    public void BtnContinue() {


    }

    private boolean UpdateDB() {

        return true;
    }


    @Override
    public void onBackPressed() {
        Toast.makeText(getApplicationContext(), "You Can't go back", Toast.LENGTH_LONG).show();
    }

}
