package edu.aku.hassannaqvi.kmc.ui;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.opengl.Visibility;
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

                    bi.kc202a.setChecked(false);
                    bi.kc202b.setChecked(false);
                    bi.kc202c.setChecked(false);
                    bi.kc202d.setChecked(false);
                    bi.kc202e.setChecked(false);
                    bi.kc202f.setChecked(false);
                    bi.kc20296.setChecked(false);

                    bi.kc20296x.setText(null);
                    bi.fldGrpkc201.setVisibility(View.GONE);
                    bi.fldGrpkc203.setVisibility(View.VISIBLE);
                } else {
                    bi.fldGrpkc201.setVisibility(View.VISIBLE);
                    bi.fldGrpkc203.setVisibility(View.GONE);
                    bi.kc203.setText(null);
                    bi.kc20398.setChecked(false);
                    bi.kc204.clearCheck();
                    bi.kc205.clearCheck();
                    bi.kc20596x.setText(null);
                    bi.kc206.clearCheck();
                    bi.kc20696x.setText(null);


                    bi.kc207a.setChecked(false);
                    bi.kc207b.setChecked(false);
                    bi.kc207c.setChecked(false);
                    bi.kc207d.setChecked(false);
                    bi.kc207e.setChecked(false);
                    bi.kc207f.setChecked(false);
                    bi.kc207g.setChecked(false);
                    bi.kc207h.setChecked(false);
                    bi.kc207i.setChecked(false);
                    bi.kc20796.setChecked(false);


                    bi.kc20796x.setText(null);
                    bi.kc208.clearCheck();

                    bi.kc209a.setChecked(false);
                    bi.kc209b.setChecked(false);
                    bi.kc209c.setChecked(false);
                    bi.kc20996.setChecked(false);


                    bi.kc20996x.setText(null);
                    bi.kc210.clearCheck();
                    bi.kc211.clearCheck();
                    bi.kc212.clearCheck();
                    bi.kc213.clearCheck();
                    bi.kc214.setText(null);
                    bi.kc21498.setChecked(false);
                }
            }
        });

        bi.kc20398.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    bi.kc203.setText(null);
                    bi.kc203.setVisibility(View.GONE);
                } else {
                    bi.kc203.setVisibility(View.VISIBLE);
                }
            }
        });

        bi.kc208.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (bi.kc208a.isChecked()) {
                    bi.fldGrpkc208.setVisibility(View.VISIBLE);
                } else {

                    bi.kc209a.setChecked(false);
                    bi.kc209b.setChecked(false);
                    bi.kc209c.setChecked(false);
                    bi.kc20996.setChecked(false);

                    bi.kc210.clearCheck();
                    bi.kc211.clearCheck();
                    bi.kc212.clearCheck();

                    bi.fldGrpkc208.setVisibility(View.GONE);
                }
            }
        });


        bi.kc213.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (bi.kc213a.isChecked()) {
                    bi.fldGrpkc213.setVisibility(View.VISIBLE);
                } else {
                    bi.kc214.setText(null);
                    bi.kc21498.setChecked(false);
                    bi.fldGrpkc213.setVisibility(View.GONE);
                }
            }
        });

    }


    private void SaveDraft() throws JSONException {

        JSONObject sC2 = new JSONObject();

        sC2.put("kc201", bi.kc201a.isChecked() ? "1"
                : bi.kc201b.isChecked() ? "2"
                : "0");


        sC2.put("kc202a", bi.kc202a.isChecked() ? "1" : "0");
        sC2.put("kc202b", bi.kc202b.isChecked() ? "2" : "0");
        sC2.put("kc202c", bi.kc202c.isChecked() ? "3" : "0");
        sC2.put("kc202d", bi.kc202d.isChecked() ? "4" : "0");
        sC2.put("kc202e", bi.kc202e.isChecked() ? "5" : "0");
        sC2.put("kc202f", bi.kc202f.isChecked() ? "6" : "0");
        sC2.put("kc20296", bi.kc20296.isChecked() ? "96" : "0");


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


        sC2.put("kc207a", bi.kc207a.isChecked() ? "1" : "0");
        sC2.put("kc207b", bi.kc207b.isChecked() ? "2" : "0");
        sC2.put("kc207c", bi.kc207c.isChecked() ? "3" : "0");
        sC2.put("kc207d", bi.kc207d.isChecked() ? "4" : "0");
        sC2.put("kc207e", bi.kc207e.isChecked() ? "5" : "0");
        sC2.put("kc207f", bi.kc207f.isChecked() ? "6" : "0");
        sC2.put("kc207g", bi.kc207g.isChecked() ? "7" : "0");
        sC2.put("kc207h", bi.kc207h.isChecked() ? "8" : "0");
        sC2.put("kc207i", bi.kc207i.isChecked() ? "9" : "0");
        sC2.put("kc20796", bi.kc20796.isChecked() ? "96" : "0");


        sC2.put("kc20796", bi.kc20796.getText().toString());


        sC2.put("kc208", bi.kc208a.isChecked() ? "1"
                : bi.kc208b.isChecked() ? "2"
                : bi.kc20898.isChecked() ? "98"
                : "0");


        sC2.put("kc209a", bi.kc209a.isChecked() ? "1" : "0");
        sC2.put("kc209b", bi.kc209b.isChecked() ? "2" : "0");
        sC2.put("kc209c", bi.kc209c.isChecked() ? "3" : "0");
        sC2.put("kc20996", bi.kc20996.isChecked() ? "96" : "0");


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

        if (bi.kc201b.isChecked()) {

            if (!validatorClass.EmptyCheckBox(this, bi.fldGrpkc202, bi.kc202a, getString(R.string.kc202))) {
                return false;
            }
        }


        if (bi.kc201b.isChecked()) {

            if (bi.kc20296.isChecked()) {

                if (!validatorClass.EmptyTextBox(this, bi.kc20296x, getString(R.string.other))) {
                    return false;
                }
            }
        }


        if (bi.kc201a.isChecked()) {

            if (!bi.kc20398.isChecked()) {
                if (!validatorClass.EmptyTextBox(this, bi.kc203, getString(R.string.kc203))) {
                    return false;
                }


                if (!validatorClass.RangeTextBox(this, bi.kc203, 1, 15, getString(R.string.kc203), "Times")) {
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


            /*if (!validatorClass.EmptyCheckBox(this, bi.fldGrpkc206, bi.kc207a, getString(R.string.kc207))) {
                return false;
            }*/


            if (!bi.kc207a.isChecked()
                    && !bi.kc207b.isChecked()
                    && !bi.kc207c.isChecked()
                    && !bi.kc207d.isChecked()
                    && !bi.kc207e.isChecked()
                    && !bi.kc207f.isChecked()
                    && !bi.kc207g.isChecked()
                    && !bi.kc207h.isChecked()
                    && !bi.kc207i.isChecked()
                    && !bi.kc20796.isChecked()
                    ) {
                Toast.makeText(this, "ERROR(empty): " + getString(R.string.kc207a), Toast.LENGTH_SHORT).show();
                bi.kc207a.setError("This data is Required!");
                Log.i(TAG, "kc207a: This data is Required!");
                return false;
            } else {
                bi.kc207a.setError(null);
            }


            if (bi.kc20796.isChecked()) {

                if (!validatorClass.EmptyTextBox(this, bi.kc20796x, getString(R.string.other))) {
                    return false;
                }
            }


            if (!validatorClass.EmptyRadioButton(this, bi.kc208, bi.kc208a, getString(R.string.kc208))) {
                return false;
            }

            if (bi.kc208a.isChecked()) {

                /*if (!validatorClass.EmptyCheckBox(this, bi.fldGrpkc209, bi.kc209a, getString(R.string.kc209))) {
                    return false;
                }*/


                if (!bi.kc209a.isChecked()
                        && !bi.kc209b.isChecked()
                        && !bi.kc209c.isChecked()
                        && !bi.kc20996.isChecked()
                        ) {
                    Toast.makeText(this, "ERROR(empty): " + getString(R.string.kc209a), Toast.LENGTH_SHORT).show();
                    bi.kc209a.setError("This data is Required!");
                    Log.i(TAG, "kc209a: This data is Required!");
                    return false;
                } else {
                    bi.kc209a.setError(null);
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

            }

            if (!validatorClass.EmptyRadioButton(this, bi.kc213, bi.kc213a, getString(R.string.kc213))) {
                return false;
            }
            if (bi.kc213a.isChecked()) {
                if (!bi.kc21498.isChecked()) {
                    if (!validatorClass.EmptyTextBox(this, bi.kc214, getString(R.string.kc214))) {
                        return false;
                    }


                    if (!validatorClass.RangeTextBox(this, bi.kc214, 1, 15, getString(R.string.kc214), "Times")) {
                        return false;
                    }

                }
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

                startActivity(new Intent(this, SectionC3Activity.class));
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
}