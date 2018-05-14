package edu.aku.hassannaqvi.kmc.ui;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.RadioGroup;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;

import edu.aku.hassannaqvi.kmc.R;
import edu.aku.hassannaqvi.kmc.core.MainApp;
import edu.aku.hassannaqvi.kmc.databinding.ActivitySectionC2Binding;
import edu.aku.hassannaqvi.kmc.validation.validatorClass;

public class SectionC2Activity extends AppCompatActivity {

    private static final String TAG = SectionC2Activity.class.getName();
    String dtToday = new SimpleDateFormat("dd-MM-yy HH:mm").format(new Date().getTime());

    ActivitySectionC2Binding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_section_c2);

        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_c2);
        bi.setCallback(this);
        setupViews();
    }


    private void setupViews() {

        bi.kc201.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (bi.kc201a.isChecked()) {
                    bi.kc202.clearCheck();
                    bi.kc20296x.setText(null);
                    bi.fldGrpkc201.setVisibility(View.GONE);
                } else {
                    bi.fldGrpkc201.setVisibility(View.VISIBLE);
                }
            }
        });

        bi.kc208.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (bi.kc208a.isChecked()) {
                    bi.kc209.clearCheck();
                    bi.kc210.clearCheck();
                    bi.kc211.clearCheck();
                    bi.kc212.clearCheck();

                    bi.fldGrpkc208.setVisibility(View.GONE);

                } else {
                    bi.fldGrpkc208.setVisibility(View.VISIBLE);
                }
            }
        });


    }


    private void SaveDraft() throws JSONException {

        JSONObject sC2 = new JSONObject();

        sC2.put("kc201", bi.kc201a.isChecked() ? "1"
                : bi.kc201b.isChecked() ? "2"
                : bi.kc20198.isChecked() ? "98"
                : "0");


        sC2.put("kc202", bi.kc202a.isChecked() ? "1"
                : bi.kc202b.isChecked() ? "2"
                : bi.kc202c.isChecked() ? "3"
                : bi.kc202d.isChecked() ? "4"
                : bi.kc202e.isChecked() ? "5"
                : bi.kc202f.isChecked() ? "6"
                : bi.kc20296.isChecked() ? "96"
                : "0");

        sC2.put("kc20296", bi.kc20296x.getText().toString());
        sC2.put("kc203", bi.kc203.getText().toString());
        sC2.put("kc20398", bi.kc20398.isChecked() ? "1" : "0");


        sC2.put("kc204", bi.kc204a.isChecked() ? "1"
                : bi.kc204b.isChecked() ? "2"
                : bi.kc204c.isChecked() ? "3"
                : "0");


        sC2.put("kc205", bi.kc205a.isChecked() ? "1"
                : bi.kc205b.isChecked() ? "2"
                : bi.kc205c.isChecked() ? "3"
                : bi.kc205d.isChecked() ? "4"
                : bi.kc205e.isChecked() ? "5"
                : bi.kc20596.isChecked() ? "96"
                : "0");

        sC2.put("kc20596", bi.kc20596x.getText().toString());


        sC2.put("kc206", bi.kc206a.isChecked() ? "1"
                : bi.kc206b.isChecked() ? "2"
                : bi.kc206c.isChecked() ? "3"
                : bi.kc206d.isChecked() ? "4"
                : bi.kc206e.isChecked() ? "5"
                : bi.kc206f.isChecked() ? "6"
                : bi.kc206g.isChecked() ? "7"
                : bi.kc206h.isChecked() ? "8"
                : bi.kc20698.isChecked() ? "98"
                : bi.kc20696.isChecked() ? "96"
                : "0");

        sC2.put("kc20696", bi.kc20696x.getText().toString());


        sC2.put("kc207", bi.kc207a.isChecked() ? "1"
                : bi.kc207b.isChecked() ? "2"
                : bi.kc207c.isChecked() ? "3"
                : bi.kc207d.isChecked() ? "4"
                : bi.kc207e.isChecked() ? "5"
                : bi.kc207f.isChecked() ? "6"
                : bi.kc207g.isChecked() ? "7"
                : bi.kc207h.isChecked() ? "8"
                : bi.kc207i.isChecked() ? "9"
                : bi.kc20796.isChecked() ? "96"
                : "0");


        sC2.put("kc20796", bi.kc20796.getText().toString());


        sC2.put("kc208", bi.kc208a.isChecked() ? "1"
                : bi.kc208b.isChecked() ? "2"
                : bi.kc20898.isChecked() ? "98"
                : "0");


        sC2.put("kc209", bi.kc209a.isChecked() ? "1"
                : bi.kc209b.isChecked() ? "2"
                : bi.kc20996.isChecked() ? "96"
                : "0");


        sC2.put("kc20996x", bi.kc20996x.getText().toString());


        sC2.put("kc210", bi.kc210a.isChecked() ? "1"
                : bi.kc210b.isChecked() ? "2"
                : bi.kc210c.isChecked() ? "3"
                : bi.kc210d.isChecked() ? "4"
                : bi.kc210e.isChecked() ? "5"
                : bi.kc210f.isChecked() ? "6"
                : "0");


        sC2.put("kc211", bi.kc211a.isChecked() ? "1"
                : bi.kc211b.isChecked() ? "2"
                : bi.kc211c.isChecked() ? "3"
                : bi.kc211d.isChecked() ? "4"
                : bi.kc211e.isChecked() ? "5"
                : bi.kc211f.isChecked() ? "6"
                : "0");


        sC2.put("kc212", bi.kc212a.isChecked() ? "1"
                : bi.kc212b.isChecked() ? "2"
                : bi.kc212c.isChecked() ? "3"
                : bi.kc212d.isChecked() ? "4"
                : bi.kc212e.isChecked() ? "5"
                : bi.kc212f.isChecked() ? "6"
                : "0");


        sC2.put("kc213", bi.kc213a.isChecked() ? "1"
                : bi.kc213b.isChecked() ? "2"
                : bi.kc21398.isChecked() ? "98"
                : "0");


        sC2.put("kc214", bi.kc214.getText().toString());
        sC2.put("kc21498", bi.kc21498.isChecked() ? "1" : "0");


        MainApp.fc.setsC2(String.valueOf(sC2));
    }


    private boolean formValidation() {


        if (!validatorClass.EmptyRadioButton(this, bi.kc201, bi.kc201a, getString(R.string.kc201))) {
            return false;
        }


        if (!validatorClass.EmptyRadioButton(this, bi.kc202, bi.kc202a, getString(R.string.kc202))) {
            return false;
        }


        if (bi.kc20296.isChecked()) {

            if (!validatorClass.EmptyTextBox(this, bi.kc20296x, getString(R.string.other))) {
                return false;
            }
        }


        if (!bi.kc20398.isChecked()) {
            if (!validatorClass.EmptyTextBox(this, bi.kc203, getString(R.string.kc203))) {
                return false;
            }
        }


        if (!validatorClass.EmptyRadioButton(this, bi.kc204, bi.kc204a, getString(R.string.kc204))) {
            return false;
        }


        if (!validatorClass.EmptyRadioButton(this, bi.kc205, bi.kc205a, getString(R.string.kc205))) {
            return false;
        }


        if (bi.kc20596.isChecked()) {

            if (!validatorClass.EmptyTextBox(this, bi.kc20596x, getString(R.string.other))) {
                return false;
            }
        }


        if (!validatorClass.EmptyRadioButton(this, bi.kc206, bi.kc206a, getString(R.string.kc206))) {
            return false;
        }


        if (bi.kc20696.isChecked()) {

            if (!validatorClass.EmptyTextBox(this, bi.kc20696x, getString(R.string.other))) {
                return false;
            }
        }


        if (!validatorClass.EmptyRadioButton(this, bi.kc207, bi.kc207a, getString(R.string.kc207))) {
            return false;
        }


        if (bi.kc20796.isChecked()) {

            if (!validatorClass.EmptyTextBox(this, bi.kc20796x, getString(R.string.other))) {
                return false;
            }
        }


        if (!validatorClass.EmptyRadioButton(this, bi.kc208, bi.kc208a, getString(R.string.kc208))) {
            return false;
        }


        if (!validatorClass.EmptyRadioButton(this, bi.kc209, bi.kc209a, getString(R.string.kc209))) {
            return false;
        }


        if (bi.kc20996.isChecked()) {

            if (!validatorClass.EmptyTextBox(this, bi.kc20996x, getString(R.string.other))) {
                return false;
            }
        }


        if (!validatorClass.EmptyRadioButton(this, bi.kc210, bi.kc210a, getString(R.string.kc210))) {
            return false;
        }


        if (!validatorClass.EmptyRadioButton(this, bi.kc211, bi.kc211a, getString(R.string.kc211))) {
            return false;
        }

        if (!validatorClass.EmptyRadioButton(this, bi.kc212, bi.kc212a, getString(R.string.kc212))) {
            return false;
        }

        if (!validatorClass.EmptyRadioButton(this, bi.kc213, bi.kc213a, getString(R.string.kc213))) {
            return false;
        }


        if (!bi.kc21498.isChecked()) {

            if (!validatorClass.EmptyTextBox(this, bi.kc214, getString(R.string.kc214))) {
                return false;
            }
        }

        return true;
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
