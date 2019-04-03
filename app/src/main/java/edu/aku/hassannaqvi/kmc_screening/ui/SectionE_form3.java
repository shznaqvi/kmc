package edu.aku.hassannaqvi.kmc_screening.ui;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import edu.aku.hassannaqvi.kmc_screening.R;
import edu.aku.hassannaqvi.kmc_screening.databinding.ActivitySectionEForm3Binding;

public class SectionE_form3 extends AppCompatActivity {

    ActivitySectionEForm3Binding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_e_form3);
        bi.setCallback(this);
    }

    public void BtnEnd() {


    }


    private void SaveDraft() {

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
