package edu.aku.hassannaqvi.kmc_screening.ui;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import edu.aku.hassannaqvi.kmc_screening.R;
import edu.aku.hassannaqvi.kmc_screening.databinding.ActivitySectionAForm3Binding;

public class SectionA_form3 extends AppCompatActivity {


    ActivitySectionAForm3Binding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_a_form3);
        bi.setCallback(this);

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
