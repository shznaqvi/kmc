package edu.aku.hassannaqvi.kmc_validate_app.ui;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Calendar;

import edu.aku.hassannaqvi.kmc_validate_app.R;
import edu.aku.hassannaqvi.kmc_validate_app.databinding.ActivityTestDateBinding;

public class TestDate extends AppCompatActivity {

    ActivityTestDateBinding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_test_date);

        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_b4_4);
        bi.setCallback(this);

        Calendar c = Calendar.getInstance();
        bi.dob.setManager(getSupportFragmentManager());
        bi.dob.setMaxDate("");

        bi.dov.setManager(getSupportFragmentManager());
        bi.dov.setMaxDate("");
    }

    public void BtnEnd() {

    }
}