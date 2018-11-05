package edu.aku.hassannaqvi.kmc_validate_app.ui;

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

import edu.aku.hassannaqvi.kmc_validate_app.R;
import edu.aku.hassannaqvi.kmc_validate_app.core.DatabaseHelper;
import edu.aku.hassannaqvi.kmc_validate_app.core.MainApp;
import edu.aku.hassannaqvi.kmc_validate_app.databinding.ActivitySectionB2Binding;
import edu.aku.hassannaqvi.kmc_validate_app.validation.validatorClass;

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

        bi.kbb01.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (bi.kbb01a.isChecked()) {

                    bi.kbb02a.setChecked(false);
                    bi.kbb02b.setChecked(false);
                    bi.kbb02c.setChecked(false);
                    bi.kbb02d.setChecked(false);
                    bi.kbb02e.setChecked(false);
                    bi.kbb02f.setChecked(false);
                    bi.kbb0296.setChecked(false);

                    bi.kbb0296x.setText(null);
                    bi.fldGrpkbb01.setVisibility(View.GONE);
                    bi.fldGrpkbb03.setVisibility(View.VISIBLE);
                } else {
                    bi.fldGrpkbb01.setVisibility(View.VISIBLE);
                    bi.fldGrpkbb03.setVisibility(View.GONE);
                    bi.kbb03.setText(null);
                    bi.kbb0398.setChecked(false);
                    bi.kbb04.clearCheck();
                    bi.kbb05.clearCheck();
                    bi.kbb0596x.setText(null);

                    bi.kbb06.clearCheck();

                    /*bi.kbb06a.setChecked(false);
                    bi.kbb06b.setChecked(false);
                    bi.kbb06c.setChecked(false);
                    bi.kbb06d.setChecked(false);
                    bi.kbb06e.setChecked(false);
                    bi.kbb06f.setChecked(false);
                    bi.kbb06g.setChecked(false);
                    bi.kbb06h.setChecked(false);
                    bi.kbb0698.setChecked(false);
                    bi.kbb0696.setChecked(false);*/

                    bi.kbb0696x.setText(null);


                    bi.kbb07a.setChecked(false);
                    bi.kbb07b.setChecked(false);
                    bi.kbb07c.setChecked(false);
                    bi.kbb07d.setChecked(false);
                    bi.kbb07e.setChecked(false);
                    bi.kbb07f.setChecked(false);
                    bi.kbb07g.setChecked(false);
                    bi.kbb07h.setChecked(false);
                    bi.kbb07i.setChecked(false);
                    bi.kbb07j.setChecked(false);
                    bi.kbb0796.setChecked(false);


                    bi.kbb0796x.setText(null);
                    bi.kbb08.clearCheck();

                    bi.kbb09.clearCheck();
                    bi.kbb10m.setText(null);
                    bi.kbb10d.setText(null);
                    bi.kbb1098.setChecked(false);
                    bi.kbb11.clearCheck();
                    bi.kbb12.clearCheck();
                    bi.kbb13.clearCheck();
                    bi.kbb14.clearCheck();
                    bi.kbb15.clearCheck();
                    bi.kbb16.setText(null);
                    bi.kbb1698.setChecked(false);
                }
            }
        });

        bi.kbb0398.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    bi.kbb03.setText(null);
                    bi.kbb03.setVisibility(View.GONE);
                } else {
                    bi.kbb03.setVisibility(View.VISIBLE);
                }
            }
        });

        bi.kbb08.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (bi.kbb08a.isChecked()) {
                    bi.fldGrpkbb08.setVisibility(View.VISIBLE);
                } else {

                    bi.kbb09.clearCheck();

                    bi.kbb10m.setText(null);
                    bi.kbb10d.setText(null);
                    bi.kbb1098.setChecked(false);

                    bi.fldGrpkbb08.setVisibility(View.GONE);
                }
            }
        });


        bi.kbb11.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (bi.kbb11a.isChecked()) {
                    bi.fldGrpkbb11.setVisibility(View.VISIBLE);
                } else {
                    bi.kbb12.clearCheck();
                    bi.fldGrpkbb11.setVisibility(View.GONE);
                }
            }
        });

        bi.kbb13.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (bi.kbb13a.isChecked()) {
                    bi.fldGrpkbb13.setVisibility(View.VISIBLE);
                } else {
                    bi.kbb14.clearCheck();

                    bi.fldGrpkbb13.setVisibility(View.GONE);
                }
            }
        });
        bi.kbb15.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (bi.kbb15a.isChecked()) {
                    bi.fldGrpkbb15.setVisibility(View.VISIBLE);
                } else {
                    bi.kbb16.setText(null);
                    bi.kbb1698.setChecked(false);

                    bi.fldGrpkbb15.setVisibility(View.GONE);
                }
            }
        });

    }


    private void SaveDraft() throws JSONException {

        JSONObject sC2 = new JSONObject();

        sC2.put("kbb01", bi.kbb01a.isChecked() ? "1"
                : bi.kbb01b.isChecked() ? "2"
                : "0");


        sC2.put("kbb02a", bi.kbb02a.isChecked() ? "1" : "0");
        sC2.put("kbb02b", bi.kbb02b.isChecked() ? "2" : "0");
        sC2.put("kbb02c", bi.kbb02c.isChecked() ? "3" : "0");
        sC2.put("kbb02d", bi.kbb02d.isChecked() ? "4" : "0");
        sC2.put("kbb02e", bi.kbb02e.isChecked() ? "5" : "0");
        sC2.put("kbb02f", bi.kbb02f.isChecked() ? "6" : "0");
        sC2.put("kbb0296", bi.kbb0296.isChecked() ? "96" : "0");


        sC2.put("kbb0296x", bi.kbb0296x.getText().toString());

        sC2.put("kbb03", bi.kbb03.getText().toString());
        sC2.put("kbb0398", bi.kbb0398.isChecked() ? "98" : "0");


        sC2.put("kbb04", bi.kbb04a.isChecked() ? "1"
                : bi.kbb04b.isChecked() ? "2"
                : bi.kbb04c.isChecked() ? "3"
                : "0");


        sC2.put("kbb05", bi.kbb05a.isChecked() ? "1"
                : bi.kbb05b.isChecked() ? "2"
                : bi.kbb05c.isChecked() ? "3"
                : bi.kbb05d.isChecked() ? "4"
                : bi.kbb05e.isChecked() ? "5"
                : bi.kbb05f.isChecked() ? "6"
                : bi.kbb05g.isChecked() ? "7"
                : bi.kbb0596.isChecked() ? "96"
                : "0");

        sC2.put("kbb0596x", bi.kbb0596x.getText().toString());


        sC2.put("kbb06", bi.kbb06a.isChecked() ? "1"
                : bi.kbb06b.isChecked() ? "2"
                : bi.kbb06c.isChecked() ? "3"
                : bi.kbb06d.isChecked() ? "4"
                : bi.kbb06e.isChecked() ? "5"
                : bi.kbb06f.isChecked() ? "6"
                : bi.kbb06g.isChecked() ? "7"
                : bi.kbb06h.isChecked() ? "8"
                : bi.kbb0698.isChecked() ? "98"
                : bi.kbb0696.isChecked() ? "96"
                : "0");

        /*sC2.put("kbb06a", bi.kbb06a.isChecked() ? "1" : "0");
        sC2.put("kbb06b", bi.kbb06b.isChecked() ? "2" : "0");
        sC2.put("kbb06c", bi.kbb06c.isChecked() ? "3" : "0");
        sC2.put("kbb06d", bi.kbb06d.isChecked() ? "4" : "0");
        sC2.put("kbb06e", bi.kbb06e.isChecked() ? "5" : "0");
        sC2.put("kbb06f", bi.kbb06f.isChecked() ? "6" : "0");
        sC2.put("kbb06g", bi.kbb06g.isChecked() ? "7" : "0");
        sC2.put("kbb06h", bi.kbb06h.isChecked() ? "8" : "0");
        sC2.put("kbb0698", bi.kbb0698.isChecked() ? "98" : "0");
        sC2.put("kbb0696", bi.kbb0696.isChecked() ? "96" : "0");
        */

        sC2.put("kbb0696x", bi.kbb0696x.getText().toString());

        sC2.put("kbb07a", bi.kbb07a.isChecked() ? "1" : "0");
        sC2.put("kbb07b", bi.kbb07b.isChecked() ? "2" : "0");
        sC2.put("kbb07c", bi.kbb07c.isChecked() ? "3" : "0");
        sC2.put("kbb07d", bi.kbb07d.isChecked() ? "4" : "0");
        sC2.put("kbb07e", bi.kbb07e.isChecked() ? "5" : "0");
        sC2.put("kbb07f", bi.kbb07f.isChecked() ? "6" : "0");
        sC2.put("kbb07g", bi.kbb07g.isChecked() ? "7" : "0");
        sC2.put("kbb07h", bi.kbb07h.isChecked() ? "8" : "0");
        sC2.put("kbb07i", bi.kbb07i.isChecked() ? "9" : "0");
        sC2.put("kbb07j", bi.kbb07j.isChecked() ? "10" : "0");
        sC2.put("kbb0796", bi.kbb0796.isChecked() ? "96" : "0");


        sC2.put("kbb0796x", bi.kbb0796x.getText().toString());


        sC2.put("kbb08", bi.kbb08a.isChecked() ? "1"
                : bi.kbb08b.isChecked() ? "2"
                : "0");


        sC2.put("kbb09", bi.kbb09a.isChecked() ? "1"
                : bi.kbb09b.isChecked() ? "2"
                : bi.kbb09c.isChecked() ? "3"
                : bi.kbb09d.isChecked() ? "4"
                : bi.kbb09e.isChecked() ? "5"
                : bi.kbb09f.isChecked() ? "6"
                : "0");

       /* sC2.put("kbb10", bi.kbb10a.isChecked() ? "1"
                : bi.kbb10b.isChecked() ? "2"
                : bi.kbb1098.isChecked() ? "98"
                : "0");*/
        sC2.put("kbb10m", bi.kbb10m.getText().toString());
        sC2.put("kbb10d", bi.kbb10d.getText().toString());
        sC2.put("kbb1098", bi.kbb1098.isChecked()? "98": "0");


        sC2.put("kbb11", bi.kbb11a.isChecked() ? "1"
                : bi.kbb11b.isChecked() ? "2"
                : "0");


        sC2.put("kbb12", bi.kbb12a.isChecked() ? "1"
                : bi.kbb12b.isChecked() ? "2"
                : bi.kbb12c.isChecked() ? "3"
                : bi.kbb12d.isChecked() ? "4"
                : bi.kbb12e.isChecked() ? "5"
                : bi.kbb12f.isChecked() ? "6"
                : "0");


        sC2.put("kbb13", bi.kbb13a.isChecked() ? "1"
                : bi.kbb13b.isChecked() ? "2"
                : "0");

        sC2.put("kbb14", bi.kbb14a.isChecked() ? "1"
                : bi.kbb14b.isChecked() ? "2"
                : bi.kbb14c.isChecked() ? "3"
                : bi.kbb14d.isChecked() ? "4"
                : bi.kbb14e.isChecked() ? "5"
                : bi.kbb14f.isChecked() ? "6"
                : "0");

        sC2.put("kbb15", bi.kbb15a.isChecked() ? "1"
                : bi.kbb15b.isChecked() ? "2"
                : bi.kbb1598.isChecked() ? "98"
                : "0");

        sC2.put("kbb16", bi.kbb16.getText().toString());
        sC2.put("kbb1698", bi.kbb1698.isChecked() ? "98" : "0");


        MainApp.fc.setsb2(String.valueOf(sC2));
    }


    private boolean formValidation() {


        if (!validatorClass.EmptyRadioButton(this, bi.kbb01, bi.kbb01a, getString(R.string.kbb01))) {
            return false;
        }

        if (bi.kbb01b.isChecked()) {

            if (!validatorClass.EmptyCheckBox(this, bi.fldGrpkbb02, bi.kbb02a, getString(R.string.kbb02))) {
                return false;
            }
        }


        if (bi.kbb01b.isChecked()) {

            if (bi.kbb0296.isChecked()) {

                if (!validatorClass.EmptyTextBox(this, bi.kbb0296x, getString(R.string.other))) {
                    return false;
                }
            }
        }


        if (bi.kbb01a.isChecked()) {

            if (!bi.kbb0398.isChecked()) {
                if (!validatorClass.EmptyTextBox(this, bi.kbb03, getString(R.string.kbb03))) {
                    return false;
                }


                if (!validatorClass.RangeTextBox(this, bi.kbb03, 1, 15, getString(R.string.kbb03), "Times")) {
                    return false;
                }

            }


            if (!validatorClass.EmptyRadioButton(this, bi.kbb04, bi.kbb04a, getString(R.string.kbb04))) {
                return false;
            }


            if (!validatorClass.EmptyRadioButton(this, bi.kbb05, bi.kbb05a, getString(R.string.kbb05))) {
                return false;
            }


            if (bi.kbb0596.isChecked()) {

                if (!validatorClass.EmptyTextBox(this, bi.kbb0596x, getString(R.string.other))) {
                    return false;
                }
            }


            if (!validatorClass.EmptyRadioButton(this, bi.kbb06, bi.kbb06a, getString(R.string.kbb06))) {
                return false;
            }


            /*if (!bi.kbb06a.isChecked()
                    && !bi.kbb06b.isChecked()
                    && !bi.kbb06c.isChecked()
                    && !bi.kbb06d.isChecked()
                    && !bi.kbb06e.isChecked()
                    && !bi.kbb06f.isChecked()
                    && !bi.kbb06g.isChecked()
                    && !bi.kbb06h.isChecked()
                    && !bi.kbb0698.isChecked()
                    && !bi.kbb0696.isChecked()
                    ) {
                Toast.makeText(this, "ERROR(empty): " + getString(R.string.kbb06a), Toast.LENGTH_SHORT).show();
                bi.kbb06a.setError("This data is Required!");
                Log.i(TAG, "kbb06a: This data is Required!");
                return false;
            } else {
                bi.kbb06a.setError(null);
            }*/


            if (bi.kbb0696.isChecked()) {

                if (!validatorClass.EmptyTextBox(this, bi.kbb0696x, getString(R.string.other))) {
                    return false;
                }
            }


            /*if (!validatorClass.EmptyCheckBox(this, bi.fldGrpkbb06, bi.kbb07a, getString(R.string.kbb07))) {
                return false;
            }*/


            if (!bi.kbb07a.isChecked()
                    && !bi.kbb07b.isChecked()
                    && !bi.kbb07c.isChecked()
                    && !bi.kbb07d.isChecked()
                    && !bi.kbb07e.isChecked()
                    && !bi.kbb07f.isChecked()
                    && !bi.kbb07g.isChecked()
                    && !bi.kbb07h.isChecked()
                    && !bi.kbb07i.isChecked()
                    && !bi.kbb07j.isChecked()
                    && !bi.kbb0796.isChecked()
                    ) {
                Toast.makeText(this, "ERROR(empty): " + getString(R.string.kbb07a), Toast.LENGTH_SHORT).show();
                bi.kbb07a.setError("This data is Required!");
                Log.i(TAG, "kbb07a: This data is Required!");
                return false;
            } else {
                bi.kbb07a.setError(null);
            }


            if (bi.kbb0796.isChecked()) {

                if (!validatorClass.EmptyTextBox(this, bi.kbb0796x, getString(R.string.other))) {
                    return false;
                }
            }


            if (!validatorClass.EmptyRadioButton(this, bi.kbb08, bi.kbb08a, getString(R.string.kbb08))) {
                return false;
            }

            if (bi.kbb08a.isChecked()) {

                if (!validatorClass.EmptyRadioButton(this, bi.kbb09, bi.kbb09a, getString(R.string.kbb09))) {
                    return false;
                }

/*
                if (!bi.kbb09a.isChecked()
                        && !bi.kbb09b.isChecked()
                        && !bi.kbb09c.isChecked()
                        && !bi.kbb0996.isChecked()
                        ) {
                    Toast.makeText(this, "ERROR(empty): " + getString(R.string.kbb09a), Toast.LENGTH_SHORT).show();
                    bi.kbb09a.setError("This data is Required!");
                    Log.i(TAG, "kbb09a: This data is Required!");
                    return false;
                } else {
                    bi.kbb09a.setError(null);
                }*/


              /*  if (!validatorClass.EmptyRadioButton(this, bi.kbb10, bi.kbb10a, getString(R.string.kbb10))) {
                    return false;
                }*/
                if (!bi.kbb1098.isChecked()) {
                    if (!validatorClass.EmptyTextBox(this, bi.kbb10m, getString(R.string.kbb10a))) {
                        return false;
                    }
                    if (!validatorClass.RangeTextBox(this, bi.kbb10m, 0, 29, getString(R.string.kbb10a), "days")) {
                        return false;
                    }

                    if (!validatorClass.EmptyTextBox(this, bi.kbb10d, getString(R.string.kbb10b))) {
                        return false;
                    }
                    if (!validatorClass.RangeTextBox(this, bi.kbb10d, 0, 9, getString(R.string.kbb10b), " months")) {
                        return false;
                    }
                    if (bi.kbb10m.getText().toString().equals("0") && bi.kbb10d.getText().toString().equals("0")) {
                        Toast.makeText(this, "Days and months cannot be 0 at the same time! ", Toast.LENGTH_LONG).show();
                        bi.kbb10m.setError("Days and months cannot be 0 at the same time!");
                        bi.kbb10d.setError("Days and months cannot be 0 at the same time!");
                        bi.kbb10m.requestFocus();
                        return false;
                    } else {
                        bi.kbb10m.setError(null);
                        bi.kbb10d.setError(null);
                        bi.kbb10m.clearFocus();
                    }

                }


            }
            if (!validatorClass.EmptyRadioButton(this, bi.kbb11, bi.kbb11a, getString(R.string.kbb11))) {
                return false;
            }
            if (bi.kbb11a.isChecked()) {

                if (!validatorClass.EmptyRadioButton(this, bi.kbb12, bi.kbb12a, getString(R.string.kbb12))) {
                    return false;
                }
            }


            if (!validatorClass.EmptyRadioButton(this, bi.kbb13, bi.kbb13a, getString(R.string.kbb13))) {
                return false;
            }
            if (bi.kbb13a.isChecked()) {

                if (!validatorClass.EmptyRadioButton(this, bi.kbb14, bi.kbb14a, getString(R.string.kbb14))) {
                    return false;
                }
            }

            if (!validatorClass.EmptyRadioButton(this, bi.kbb15, bi.kbb15a, getString(R.string.kbb15))) {
                return false;
            }
            if (bi.kbb15a.isChecked()) {

                if (!bi.kbb1698.isChecked()) {
                    if (!validatorClass.EmptyTextBox(this, bi.kbb16, getString(R.string.kbb16))) {
                        return false;
                    }


                    return validatorClass.RangeTextBox(this, bi.kbb16, 1, 5, getString(R.string.kbb16), "Times");

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
            MainApp.endActivity(this, this);

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

        int updcount = db.updateSB2();

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