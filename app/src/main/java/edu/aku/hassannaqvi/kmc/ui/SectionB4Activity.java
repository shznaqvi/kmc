package edu.aku.hassannaqvi.kmc.ui;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;

import edu.aku.hassannaqvi.kmc.R;
import edu.aku.hassannaqvi.kmc.core.DatabaseHelper;
import edu.aku.hassannaqvi.kmc.core.MainApp;
import edu.aku.hassannaqvi.kmc.databinding.ActivitySectionB4Binding;
import edu.aku.hassannaqvi.kmc.validation.validatorClass;

public class SectionB4Activity extends AppCompatActivity {

    private static final String TAG = SectionB4Activity.class.getName();
    String dtToday = new SimpleDateFormat("dd-MM-yy HH:mm").format(new Date().getTime());

    ActivitySectionB4Binding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_section_b4);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_b4);
        bi.setCallback(this);
        setupView();
    }

    private void setupView() {
        bi.kbda02b.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.kbda02b02) {
                    bi.fldGrpkbda03.setVisibility(View.GONE);

                    bi.kbda05.clearCheck();
                    bi.kbda03.setText(null);
                    bi.kbda04.setText(null);
                    bi.kbda06.clearCheck();
                } else {
                    bi.fldGrpkbda03.setVisibility(View.VISIBLE);
                }
            }
        });


    }


    private void SaveDraft() throws JSONException {

        JSONObject sC4 = new JSONObject();

        sC4.put("kbda01a", bi.kbda01a.isChecked() ? "1" : "0");
        sC4.put("kbda01b", bi.kbda01b.isChecked() ? "2" : "0");
        sC4.put("kbda01c", bi.kbda01c.isChecked() ? "3" : "0");
        sC4.put("kbda0196", bi.kbda0196.isChecked() ? "96" : "0");

        sC4.put("kbda0196x", bi.kbda0196x.getText().toString());

        sC4.put("kbda02a", bi.kbda02a01.isChecked() ? "1"
                : bi.kbda02a02.isChecked() ? "2"
                : "0");
        sC4.put("kbda02b", bi.kbda02b01.isChecked() ? "1"
                : bi.kbda02b02.isChecked() ? "2"
                : "0");

        sC4.put("kbda03", bi.kbda03.getText().toString());
        sC4.put("kbda04", bi.kbda04.getText().toString());

        sC4.put("kbda05", bi.kbda05a.isChecked() ? "1"
                : bi.kbda05b.isChecked() ? "2"
                : bi.kbda0598.isChecked() ? "98"
                : "0");

        sC4.put("kbda06", bi.kbda06a.isChecked() ? "1"
                : bi.kbda06b.isChecked() ? "2"
                : bi.kbda0698.isChecked() ? "98"
                : "0");


        MainApp.fc.setsb4(String.valueOf(sC4));
    }


    private boolean formValidation() {

        if (!validatorClass.EmptyCheckBox(this, bi.kbda01, bi.kbda0196, bi.kbda0196x, getString(R.string.kbda01))) {
            return false;
        }

        if (!validatorClass.EmptyRadioButton(this, bi.kbda02a, bi.kbda02a01, getString(R.string.kbda02sub1))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, bi.kbda02b, bi.kbda02b01, getString(R.string.kbda02sub2))) {
            return false;
        }
        if (!bi.kbda02b02.isChecked()) {

            if (!validatorClass.EmptyTextBox(this, bi.kbda03, getString(R.string.kbda03))) {
                return false;
            }
            if (!validatorClass.RangeTextBox(this, bi.kbda03, 1, 9, getString(R.string.kbda03), " days")) {
                return false;
            }


            if (!bi.kbda03.getText().toString().isEmpty()) {

                if (Integer.valueOf(bi.kbda03.getText().toString()) <= 0) {
                    Toast.makeText(this, "Must be greater than 0", Toast.LENGTH_SHORT).show();
                    bi.kbda03.requestFocus();
                    return false;
                }

            }

            if (!validatorClass.EmptyTextBox(this, bi.kbda04, getString(R.string.kbda04))) {
                return false;
            }

            if (!validatorClass.RangeTextBox(this, bi.kbda04, 1, 9, getString(R.string.kbda04), " days")) {
                return false;
            }

            if (!bi.kbda04.getText().toString().isEmpty()) {

                if (Integer.valueOf(bi.kbda04.getText().toString()) <= 0) {
                    Toast.makeText(this, "Must be greater than 0", Toast.LENGTH_SHORT).show();
                    bi.kbda04.requestFocus();
                    return false;
                }

            }
         


            if (!validatorClass.EmptyRadioButton(this, bi.kbda05, bi.kbda05a, getString(R.string.kbda05))) {
                return false;
            }


            if (!validatorClass.EmptyRadioButton(this, bi.kbda06, bi.kbda06a, getString(R.string.kbda06))) {
                return false;
            }

        }

        return true;
    }


    public void BtnEnd() {

        Toast.makeText(this, "Processing End Section", Toast.LENGTH_SHORT).show();
        //if (formValidation()) {
        try {
            SaveDraft();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (UpdateDB()) {
            Toast.makeText(this, "Starting Ending Section", Toast.LENGTH_SHORT).show();

            finish();

            startActivity(new Intent(this, EndingActivity.class).putExtra("complete", false));

        } else {
            Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
        }
        //}
    }

    public void BtnContinue() {

        if (formValidation()) {
            try {
                SaveDraft();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (UpdateDB()) {

                finish();

                startActivity(new Intent(this, SectionCActivity.class));
                //startActivity(new Intent(this, MainActivity.class));

            } else {
                Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
            }
        }
    }


    private boolean UpdateDB() {

        //Long rowId;
        DatabaseHelper db = new DatabaseHelper(this);

        int updcount = db.updateSB4();

        if (updcount == 1) {
            //Toast.makeText(this, "Updating Database... Successful!", Toast.LENGTH_SHORT).show();
            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }
    }

    @Override
    public void onBackPressed() {
        Toast.makeText(getApplicationContext(), "You Can't go back", Toast.LENGTH_LONG).show();
    }
}