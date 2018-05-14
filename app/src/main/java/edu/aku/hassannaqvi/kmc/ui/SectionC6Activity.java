package edu.aku.hassannaqvi.kmc.ui;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioGroup;

import edu.aku.hassannaqvi.kmc.R;
import edu.aku.hassannaqvi.kmc.databinding.ActivitySectionC6Binding;

public class SectionC6Activity extends AppCompatActivity {

    ActivitySectionC6Binding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_section_c6);

        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_c6);
        bi.setCallback(this);

        bi.kc601.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (bi.kc601a.isChecked()) {
                    bi.fldGrpkc602.setVisibility(View.VISIBLE);
                } else {
                    bi.fldGrpkc602.setVisibility(View.GONE);
                    bi.kc602.clearCheck();
                    bi.kc602day.setText(null);
                    bi.kc602week.setText(null);
                    bi.kc603.setText(null);
                    bi.kc60398.setChecked(false);
                    bi.kc604.clearCheck();
                    bi.kc605a.setChecked(false);
                    bi.kc605b.setChecked(false);
                    bi.kc605c.setChecked(false);
                    bi.kc605d.setChecked(false);
                    bi.kc605e.setChecked(false);
                    bi.kc605f.setChecked(false);
                    bi.kc605g.setChecked(false);
                    bi.kc605h.setChecked(false);
                    bi.kc605i.setChecked(false);
                    bi.kc605j.setChecked(false);
                    bi.kc605k.setChecked(false);
                    bi.kc605l.setChecked(false);
                    bi.kc60598.setChecked(false);
                    bi.kc60596.setChecked(false);
                    bi.kc60596x.setText(null);

                }
            }
        });


        bi.kc606.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (bi.kc606a.isChecked()) {
                    bi.fldGrpkc607.setVisibility(View.VISIBLE);
                } else {
                    bi.fldGrpkc607.setVisibility(View.GONE);
                    bi.kc607.clearCheck();
                    bi.kc607day.setText(null);
                    bi.kc607week.setText(null);
                    bi.kc608.setText(null);
                    bi.kc60898.setChecked(false);
                    bi.kc609.clearCheck();
                    bi.kc60996x.setText(null);
                    bi.kc610a.setChecked(false);
                    bi.kc610b.setChecked(false);
                    bi.kc610c.setChecked(false);
                    bi.kc610d.setChecked(false);
                    bi.kc610e.setChecked(false);
                    bi.kc610f.setChecked(false);
                    bi.kc610g.setChecked(false);
                    bi.kc61096.setChecked(false);
                    bi.kc61096x.setText(null);

                }
            }
        });

        bi.kc611.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (bi.kc611a.isChecked()) {
                    bi.fldGrpkc612.setVisibility(View.VISIBLE);
                } else {
                    bi.fldGrpkc612.setVisibility(View.GONE);
                    bi.kc612.clearCheck();
                    bi.kc61296x.setText(null);
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
