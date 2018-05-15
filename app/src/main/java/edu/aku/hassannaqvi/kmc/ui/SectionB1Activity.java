package edu.aku.hassannaqvi.kmc.ui;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import edu.aku.hassannaqvi.kmc.R;
import edu.aku.hassannaqvi.kmc.core.DatabaseHelper;
import edu.aku.hassannaqvi.kmc.core.MainApp;
import edu.aku.hassannaqvi.kmc.databinding.ActivitySectionB1Binding;
import edu.aku.hassannaqvi.kmc.validation.validatorClass;

public class SectionB1Activity extends AppCompatActivity {

    ActivitySectionB1Binding bi;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_b1);
        bi.setCallback(this);

        setupView();
    }

    private void setupView() {

        /*bi.kb101.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
  *//*              if(Integer.valueOf(bi.kb102.getText().toString()) == 0){
                    bi.fldGrpkb101.setVisibility(View.GONE);
//                    clearing edit texts
                    bi.kb202w.setText("0");
                    bi.kb202m.setText("0");
                    bi.kb203.clearCheck();
                    bi.kb204.setText(null);
                    bi.kb205.setText(null);
                }
                else{
                    bi.fldGrpkb101.setVisibility(View.VISIBLE);
                }
*//*
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });*/


        bi.kb201.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (bi.kb201b.isChecked()) {

                    bi.kb202w.setText(null);
                    bi.kb202m.setText(null);
                    bi.kb203.clearCheck();
                    bi.kb204.setText(null);
                    bi.kb205.setText(null);

                    bi.fldGrpkb201.setVisibility(View.GONE);
                } else if (bi.kb20198.isChecked()) {

                    bi.kb202w.setText(null);
                    bi.kb202m.setText(null);


                    bi.fldGrpkb202.setVisibility(View.GONE);
                    bi.fldGrpkb201.setVisibility(View.VISIBLE);

                } else {
                    bi.fldGrpkb201.setVisibility(View.VISIBLE);
                    bi.fldGrpkb202.setVisibility(View.VISIBLE);
                }
            }
        });


    }


    private void SaveDraft() throws JSONException {

        JSONObject sB1 = new JSONObject();

        sB1.put("kb101", bi.kb101.getText().toString());


        sB1.put("kb201", bi.kb201a.isChecked() ? "1"
                : bi.kb201b.isChecked() ? "2"
                : bi.kb20198.isChecked() ? "98"
                : "0");

        sB1.put("kb202w", bi.kb202w.getText().toString());
        sB1.put("kb202m", bi.kb202m.getText().toString());

        sB1.put("kb203", bi.kb203a.isChecked() ? "1"
                : bi.kb203b.isChecked() ? "2"
                : "0");

        sB1.put("kb204", bi.kb204.getText().toString());
        sB1.put("kb205", bi.kb205.getText().toString());


        MainApp.fc.setsB1(String.valueOf(sB1));

    }


    private boolean formValidation() {

        if (!validatorClass.EmptyTextBox(this, bi.kb101, getString(R.string.kb101))) {
            return false;
        }


        if (!validatorClass.EmptyRadioButton(this, bi.kb201, bi.kb201a, getString(R.string.kb201))) {
            return false;
        }


        if (!bi.kb201b.isChecked()) {

            if (!bi.kb20198.isChecked()) {

                if (!validatorClass.EmptyTextBox(this, bi.kb202w, getString(R.string.weeks))) {
                    return false;
                }

                if (!validatorClass.EmptyTextBox(this, bi.kb202m, getString(R.string.months))) {
                    return false;
                }
            }


            if (!validatorClass.EmptyRadioButton(this, bi.kb203, bi.kb203a, getString(R.string.kb203))) {
                return false;
            }


            if (!validatorClass.EmptyTextBox(this, bi.kb204, getString(R.string.kb204))) {
                return false;
            }


            if (!validatorClass.EmptyTextBox(this, bi.kb205, getString(R.string.kb205))) {
                return false;
            }
        }

        return true;
    }


    public void BtnEnd() {

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
        }
    }

    public void BtnContinue() {

        Toast.makeText(this, "Processing This Section", Toast.LENGTH_SHORT).show();
        if (formValidation()) {
            try {
                SaveDraft();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (UpdateDB()) {
                Toast.makeText(this, "Starting Ending Section", Toast.LENGTH_SHORT).show();

                finish();

                //startActivity(new Intent(this, SectionB2Activity.class));
                startActivity(new Intent(this, MainActivity.class));

            } else {
                Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
            }
        }
    }


    private boolean UpdateDB() {

       /* //Long rowId;
        DatabaseHelper db = new DatabaseHelper(this);

        int updcount = db.updateSB1();

        if (updcount == 1) {
            //Toast.makeText(this, "Updating Database... Successful!", Toast.LENGTH_SHORT).show();
            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }*/

        return true;
    }

}