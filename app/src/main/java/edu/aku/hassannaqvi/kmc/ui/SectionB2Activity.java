package edu.aku.hassannaqvi.kmc.ui;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
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
import edu.aku.hassannaqvi.kmc.databinding.ActivitySectionB2Binding;
import edu.aku.hassannaqvi.kmc.validation.validatorClass;

public class SectionB2Activity extends AppCompatActivity {

    private static final String TAG = SectionB2Activity.class.getName();
    String dtToday = new SimpleDateFormat("dd-MM-yy HH:mm").format(new Date().getTime());

    ActivitySectionB2Binding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_b2);
        bi.setCallback(this);
        setupViews();
    }


    private void setupViews() {

        bi.kb201.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (bi.kb201a.isChecked()) {

                    bi.kb202a.setChecked(false);
                    bi.kb202b.setChecked(false);
                    bi.kb202c.setChecked(false);
                    bi.kb202d.setChecked(false);
                    bi.kb202e.setChecked(false);
                    bi.kb202f.setChecked(false);
                    bi.kb20296.setChecked(false);

                    bi.kb20296x.setText(null);
                    bi.fldGrpkb201.setVisibility(View.GONE);
                    bi.fldGrpkb203.setVisibility(View.VISIBLE);
                } else {
                    bi.fldGrpkb201.setVisibility(View.VISIBLE);
                    bi.fldGrpkb203.setVisibility(View.GONE);
                    bi.kb203.setText(null);
                    bi.kb20398.setChecked(false);
                    bi.kb204.clearCheck();
                    bi.kb205.clearCheck();
                    bi.kb20596x.setText(null);

                    bi.kb206.clearCheck();

                    /*bi.kb206a.setChecked(false);
                    bi.kb206b.setChecked(false);
                    bi.kb206c.setChecked(false);
                    bi.kb206d.setChecked(false);
                    bi.kb206e.setChecked(false);
                    bi.kb206f.setChecked(false);
                    bi.kb206g.setChecked(false);
                    bi.kb206h.setChecked(false);
                    bi.kb20698.setChecked(false);
                    bi.kb20696.setChecked(false);*/

                    bi.kb20696x.setText(null);


                    bi.kb207a.setChecked(false);
                    bi.kb207b.setChecked(false);
                    bi.kb207c.setChecked(false);
                    bi.kb207d.setChecked(false);
                    bi.kb207e.setChecked(false);
                    bi.kb207f.setChecked(false);
                    bi.kb207g.setChecked(false);
                    bi.kb207h.setChecked(false);
                    bi.kb207i.setChecked(false);
                    bi.kb207j.setChecked(false);
                    bi.kb20796.setChecked(false);


                    bi.kb20796x.setText(null);
                    bi.kb208.clearCheck();

                    bi.kb209.clearCheck();
                    bi.kb210.clearCheck();
                    bi.kb211.clearCheck();
                    bi.kb212.clearCheck();
                    bi.kb213.clearCheck();
                    bi.kb214.clearCheck();
                    bi.kb215.clearCheck();
                    bi.kb216.setText(null);
                    bi.kb21698.setChecked(false);
                }
            }
        });

        bi.kb20398.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    bi.kb203.setText(null);
                    bi.kb203.setVisibility(View.GONE);
                } else {
                    bi.kb203.setVisibility(View.VISIBLE);
                }
            }
        });

        bi.kb208.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (bi.kb208a.isChecked()) {
                    bi.fldGrpkb208.setVisibility(View.VISIBLE);
                } else {

                    bi.kb209.clearCheck();

                    bi.kb210.clearCheck();

                    bi.fldGrpkb208.setVisibility(View.GONE);
                }
            }
        });


        bi.kb211.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (bi.kb211a.isChecked()) {
                    bi.fldGrpkb211.setVisibility(View.VISIBLE);
                } else {
                    bi.kb212.clearCheck();
                    bi.fldGrpkb211.setVisibility(View.GONE);
                }
            }
        });

        bi.kb213.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (bi.kb213a.isChecked()) {
                    bi.fldGrpkb213.setVisibility(View.VISIBLE);
                } else {
                    bi.kb214.clearCheck();

                    bi.fldGrpkb213.setVisibility(View.GONE);
                }
            }
        });
        bi.kb215.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (bi.kb215a.isChecked()) {
                    bi.fldGrpkb215.setVisibility(View.VISIBLE);
                } else {
                    bi.kb216.setText(null);
                    bi.kb21698.setChecked(false);

                    bi.fldGrpkb215.setVisibility(View.GONE);
                }
            }
        });

    }


    private void SaveDraft() throws JSONException {

        JSONObject sC2 = new JSONObject();

        sC2.put("kb201", bi.kb201a.isChecked() ? "1"
                : bi.kb201b.isChecked() ? "2"
                : "0");


        sC2.put("kb202a", bi.kb202a.isChecked() ? "1" : "0");
        sC2.put("kb202b", bi.kb202b.isChecked() ? "2" : "0");
        sC2.put("kb202c", bi.kb202c.isChecked() ? "3" : "0");
        sC2.put("kb202d", bi.kb202d.isChecked() ? "4" : "0");
        sC2.put("kb202e", bi.kb202e.isChecked() ? "5" : "0");
        sC2.put("kb202f", bi.kb202f.isChecked() ? "6" : "0");
        sC2.put("kb20296", bi.kb20296.isChecked() ? "96" : "0");


        sC2.put("kb20296x", bi.kb20296x.getText().toString());

        sC2.put("kb203", bi.kb203.getText().toString());
        sC2.put("kb20398", bi.kb20398.isChecked() ? "1" : "0");


        sC2.put("kb204", bi.kb204a.isChecked() ? "1"
                : bi.kb204b.isChecked() ? "2"
                : bi.kb204c.isChecked() ? "3"
                : "0");


        sC2.put("kb205", bi.kb205a.isChecked() ? "1"
                : bi.kb205b.isChecked() ? "2"
                : bi.kb205c.isChecked() ? "3"
                : bi.kb205d.isChecked() ? "4"
                : bi.kb205e.isChecked() ? "5"
                : bi.kb205f.isChecked() ? "6"
                : bi.kb205g.isChecked() ? "7"
                : bi.kb20596.isChecked() ? "96"
                : "0");

        sC2.put("kb20596x", bi.kb20596x.getText().toString());


        sC2.put("kb206", bi.kb206a.isChecked() ? "1"
                : bi.kb206b.isChecked() ? "2"
                : bi.kb206c.isChecked() ? "3"
                : bi.kb206d.isChecked() ? "4"
                : bi.kb206e.isChecked() ? "5"
                : bi.kb206f.isChecked() ? "6"
                : bi.kb206g.isChecked() ? "7"
                : bi.kb206h.isChecked() ? "8"
                : bi.kb20698.isChecked() ? "98"
                : bi.kb20696.isChecked() ? "96"
                : "0");

        /*sC2.put("kb206a", bi.kb206a.isChecked() ? "1" : "0");
        sC2.put("kb206b", bi.kb206b.isChecked() ? "2" : "0");
        sC2.put("kb206c", bi.kb206c.isChecked() ? "3" : "0");
        sC2.put("kb206d", bi.kb206d.isChecked() ? "4" : "0");
        sC2.put("kb206e", bi.kb206e.isChecked() ? "5" : "0");
        sC2.put("kb206f", bi.kb206f.isChecked() ? "6" : "0");
        sC2.put("kb206g", bi.kb206g.isChecked() ? "7" : "0");
        sC2.put("kb206h", bi.kb206h.isChecked() ? "8" : "0");
        sC2.put("kb20698", bi.kb20698.isChecked() ? "98" : "0");
        sC2.put("kb20696", bi.kb20696.isChecked() ? "96" : "0");
        */

        sC2.put("kb20696x", bi.kb20696x.getText().toString());

        sC2.put("kb207a", bi.kb207a.isChecked() ? "1" : "0");
        sC2.put("kb207b", bi.kb207b.isChecked() ? "2" : "0");
        sC2.put("kb207c", bi.kb207c.isChecked() ? "3" : "0");
        sC2.put("kb207d", bi.kb207d.isChecked() ? "4" : "0");
        sC2.put("kb207e", bi.kb207e.isChecked() ? "5" : "0");
        sC2.put("kb207f", bi.kb207f.isChecked() ? "6" : "0");
        sC2.put("kb207g", bi.kb207g.isChecked() ? "7" : "0");
        sC2.put("kb207h", bi.kb207h.isChecked() ? "8" : "0");
        sC2.put("kb207i", bi.kb207i.isChecked() ? "9" : "0");
        sC2.put("kb207j", bi.kb207j.isChecked() ? "10" : "0");
        sC2.put("kb20796", bi.kb20796.isChecked() ? "96" : "0");


        sC2.put("kb20796x", bi.kb20796x.getText().toString());


        sC2.put("kb208", bi.kb208a.isChecked() ? "1"
                : bi.kb208b.isChecked() ? "2"
                : "0");


        sC2.put("kb209", bi.kb209a.isChecked() ? "1"
                : bi.kb209b.isChecked() ? "2"
                : bi.kb209c.isChecked() ? "3"
                : bi.kb209d.isChecked() ? "4"
                : bi.kb209e.isChecked() ? "5"
                : bi.kb209f.isChecked() ? "6"
                : "0");

        sC2.put("kb210", bi.kb210a.isChecked() ? "1"
                : bi.kb210b.isChecked() ? "2"
                : bi.kb21098.isChecked() ? "98"
                : "0");


        sC2.put("kb211", bi.kb211a.isChecked() ? "1"
                : bi.kb211b.isChecked() ? "2"
                : "0");


        sC2.put("kb212", bi.kb212a.isChecked() ? "1"
                : bi.kb212b.isChecked() ? "2"
                : bi.kb212c.isChecked() ? "3"
                : bi.kb212d.isChecked() ? "4"
                : bi.kb212e.isChecked() ? "5"
                : bi.kb212f.isChecked() ? "6"
                : "0");


        sC2.put("kb213", bi.kb213a.isChecked() ? "1"
                : bi.kb213b.isChecked() ? "2"
                : "0");

        sC2.put("kb214", bi.kb214a.isChecked() ? "1"
                : bi.kb214b.isChecked() ? "2"
                : bi.kb214c.isChecked() ? "3"
                : bi.kb214d.isChecked() ? "4"
                : bi.kb214e.isChecked() ? "5"
                : bi.kb214f.isChecked() ? "6"
                : "0");

        sC2.put("kb215", bi.kb215a.isChecked() ? "1"
                : bi.kb215b.isChecked() ? "2"
                : bi.kb21598.isChecked() ? "98"
                : "0");

        sC2.put("kb216", bi.kb216.getText().toString());
        sC2.put("kb21698", bi.kb21698.isChecked() ? "1" : "0");


        MainApp.fc.setsC2(String.valueOf(sC2));
    }


    private boolean formValidation() {


        if (!validatorClass.EmptyRadioButton(this, bi.kb201, bi.kb201a, getString(R.string.kb201))) {
            return false;
        }

        if (bi.kb201b.isChecked()) {

            if (!validatorClass.EmptyCheckBox(this, bi.fldGrpkb202, bi.kb202a, getString(R.string.kb202))) {
                return false;
            }
        }


        if (bi.kb201b.isChecked()) {

            if (bi.kb20296.isChecked()) {

                if (!validatorClass.EmptyTextBox(this, bi.kb20296x, getString(R.string.other))) {
                    return false;
                }
            }
        }


        if (bi.kb201a.isChecked()) {

            if (!bi.kb20398.isChecked()) {
                if (!validatorClass.EmptyTextBox(this, bi.kb203, getString(R.string.kb203))) {
                    return false;
                }


                if (!validatorClass.RangeTextBox(this, bi.kb203, 1, 15, getString(R.string.kb203), "Times")) {
                    return false;
                }

            }


            if (!validatorClass.EmptyRadioButton(this, bi.kb204, bi.kb204a, getString(R.string.kb204))) {
                return false;
            }


            if (!validatorClass.EmptyRadioButton(this, bi.kb205, bi.kb205a, getString(R.string.kb205))) {
                return false;
            }


            if (bi.kb20596.isChecked()) {

                if (!validatorClass.EmptyTextBox(this, bi.kb20596x, getString(R.string.other))) {
                    return false;
                }
            }


            if (!validatorClass.EmptyRadioButton(this, bi.kb206, bi.kb206a, getString(R.string.kb206))) {
                return false;
            }


            /*if (!bi.kb206a.isChecked()
                    && !bi.kb206b.isChecked()
                    && !bi.kb206c.isChecked()
                    && !bi.kb206d.isChecked()
                    && !bi.kb206e.isChecked()
                    && !bi.kb206f.isChecked()
                    && !bi.kb206g.isChecked()
                    && !bi.kb206h.isChecked()
                    && !bi.kb20698.isChecked()
                    && !bi.kb20696.isChecked()
                    ) {
                Toast.makeText(this, "ERROR(empty): " + getString(R.string.kb206a), Toast.LENGTH_SHORT).show();
                bi.kb206a.setError("This data is Required!");
                Log.i(TAG, "kb206a: This data is Required!");
                return false;
            } else {
                bi.kb206a.setError(null);
            }*/


            if (bi.kb20696.isChecked()) {

                if (!validatorClass.EmptyTextBox(this, bi.kb20696x, getString(R.string.other))) {
                    return false;
                }
            }


            /*if (!validatorClass.EmptyCheckBox(this, bi.fldGrpkb206, bi.kb207a, getString(R.string.kb207))) {
                return false;
            }*/


            if (!bi.kb207a.isChecked()
                    && !bi.kb207b.isChecked()
                    && !bi.kb207c.isChecked()
                    && !bi.kb207d.isChecked()
                    && !bi.kb207e.isChecked()
                    && !bi.kb207f.isChecked()
                    && !bi.kb207g.isChecked()
                    && !bi.kb207h.isChecked()
                    && !bi.kb207i.isChecked()
                    && !bi.kb207j.isChecked()
                    && !bi.kb20796.isChecked()
                    ) {
                Toast.makeText(this, "ERROR(empty): " + getString(R.string.kb207a), Toast.LENGTH_SHORT).show();
                bi.kb207a.setError("This data is Required!");
                Log.i(TAG, "kb207a: This data is Required!");
                return false;
            } else {
                bi.kb207a.setError(null);
            }


            if (bi.kb20796.isChecked()) {

                if (!validatorClass.EmptyTextBox(this, bi.kb20796x, getString(R.string.other))) {
                    return false;
                }
            }


            if (!validatorClass.EmptyRadioButton(this, bi.kb208, bi.kb208a, getString(R.string.kb208))) {
                return false;
            }

            if (bi.kb208a.isChecked()) {

                if (!validatorClass.EmptyRadioButton(this, bi.kb209, bi.kb209a, getString(R.string.kb209))) {
                    return false;
                }

/*
                if (!bi.kb209a.isChecked()
                        && !bi.kb209b.isChecked()
                        && !bi.kb209c.isChecked()
                        && !bi.kb20996.isChecked()
                        ) {
                    Toast.makeText(this, "ERROR(empty): " + getString(R.string.kb209a), Toast.LENGTH_SHORT).show();
                    bi.kb209a.setError("This data is Required!");
                    Log.i(TAG, "kb209a: This data is Required!");
                    return false;
                } else {
                    bi.kb209a.setError(null);
                }*/


                if (!validatorClass.EmptyRadioButton(this, bi.kb210, bi.kb210a, getString(R.string.kb210))) {
                    return false;
                }


            }
            if (!validatorClass.EmptyRadioButton(this, bi.kb211, bi.kb211a, getString(R.string.kb211))) {
                return false;
            }
            if (bi.kb211a.isChecked()) {

                if (!validatorClass.EmptyRadioButton(this, bi.kb212, bi.kb212a, getString(R.string.kb212))) {
                    return false;
                }
            }


            if (!validatorClass.EmptyRadioButton(this, bi.kb213, bi.kb213a, getString(R.string.kb213))) {
                return false;
            }
            if (bi.kb213a.isChecked()) {

                if (!validatorClass.EmptyRadioButton(this, bi.kb214, bi.kb214a, getString(R.string.kb214))) {
                    return false;
                }
            }

            if (!validatorClass.EmptyRadioButton(this, bi.kb215, bi.kb215a, getString(R.string.kb215))) {
                return false;
            }
            if (bi.kb215a.isChecked()) {

                if (!bi.kb21698.isChecked()) {
                    if (!validatorClass.EmptyTextBox(this, bi.kb216, getString(R.string.kb216))) {
                        return false;
                    }


                    if (!validatorClass.RangeTextBox(this, bi.kb216, 1, 5, getString(R.string.kb216), "Times")) {
                        return false;
                    }

                }

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

                startActivity(new Intent(this, SectionB3Activity.class));
                //startActivity(new Intent(this, MainActivity.class));

            } else {
                Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
            }
        }
    }


    private boolean UpdateDB() {
        //Long rowId;
        DatabaseHelper db = new DatabaseHelper(this);

        int updcount = db.updateSC2();

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