package edu.aku.hassannaqvi.kmc.ui;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;

import edu.aku.hassannaqvi.kmc.R;
import edu.aku.hassannaqvi.kmc.core.DatabaseHelper;
import edu.aku.hassannaqvi.kmc.databinding.ActivitySectionB2Binding;

public class SectionB2Activity extends AppCompatActivity {
    ActivitySectionB2Binding bi;
    DatabaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_b2);
        db = new DatabaseHelper(this);
        bi.setCallback(this);

        setupViews();
    }

    private void setupViews() {
        bi.kb206.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == R.id.kb206a){
                    bi.fldGrpkb207.setVisibility(View.GONE);
                    bi.kb207.clearCheck();
                    bi.kb20796x.setText(null);

                }else{
                    bi.fldGrpkb207.setVisibility(View.VISIBLE);

                }
            }
        });

        bi.kb213.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId != R.id.kb213b){
                    bi.fldGrpkb214.setVisibility(View.VISIBLE);

                }
                else{
                    bi.fldGrpkb214.setVisibility(View.GONE);
                    bi.kb214.clearCheck();
                    bi.kb21496x.setText(null);

                    bi.kb215.clearCheck();
                    bi.kb216.clearCheck();

                }
            }
        });

        bi.kb218.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId != R.id.kb218b){
                    bi.fldGrpkb219.setVisibility(View.VISIBLE);

                }
                else{
                    bi.fldGrpkb219.setVisibility(View.GONE);
                    bi.kb21998.setChecked(false);
                    bi.kb219.setText(null);

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
