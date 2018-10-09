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

import edu.aku.hassannaqvi.kmc.R;
import edu.aku.hassannaqvi.kmc.core.DatabaseHelper;
import edu.aku.hassannaqvi.kmc.core.MainApp;
import edu.aku.hassannaqvi.kmc.databinding.ActivitySectionB3Binding;
import edu.aku.hassannaqvi.kmc.validation.validatorClass;


public class SectionB3Activity extends AppCompatActivity {

    private static final String TAG = SectionB3Activity.class.getName();
    ActivitySectionB3Binding bi;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_b3);
        bi.setCallback(this);


        bi.kb302.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (bi.kb302a.isChecked()) {
                    bi.fldGrpkb303.setVisibility(View.VISIBLE);
                } else {
                    bi.fldGrpkb303.setVisibility(View.GONE);
                    bi.kb303.clearCheck();
                    bi.kb30396x.setText(null);
                }
            }
        });

        bi.kb305.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (bi.kb305a.isChecked()) {
                    bi.fldGrpkb305.setVisibility(View.VISIBLE);
                } else {
                    bi.fldGrpkb305.setVisibility(View.GONE);
                    bi.kb306.clearCheck();
                    bi.kb306kg.setText(null);
                    bi.kb307rec.setText(null);

                    //bi.kb30777.setChecked(false);

                    bi.kb308.clearCheck();
                }
            }
        });


        bi.kb306.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (bi.kb306a.isChecked()) {
                    bi.kb306kg.setVisibility(View.VISIBLE);
                    bi.fldGrpkb306.setVisibility(View.GONE);
                    bi.kb307rec.setText(null);
                    //bi.kb30777.setChecked(false);

//                    bi.fldGrpkb307.setVisibility(View.GONE);
//                    bi.fldGrpkb308.setVisibility(View.VISIBLE);
                } else {
                    bi.kb306kg.setText(null);
                    bi.kb306kg.setVisibility(View.GONE);
//                    bi.kb309.clearCheck();
                    bi.fldGrpkb306.setVisibility(View.VISIBLE);
//                    bi.fldGrpkb307.setVisibility(View.VISIBLE);
//                    bi.fldGrpkb308.setVisibility(View.GONE);
                }
            }
        });


        /*bi.kb30777.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    bi.kb307rec.setText(null);
                    bi.kb307rec.setVisibility(View.GONE);
//                    bi.fldGrpkb307.setVisibility(View.VISIBLE);
                } else {
                    bi.kb308.clearCheck();
                    bi.kb307rec.setVisibility(View.VISIBLE);
//                    bi.fldGrpkb307.setVisibility(View.GONE);
                }
            }
        });*/

        bi.kb309.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (bi.kb309a.isChecked()) {
                    bi.fldGrpkb309.setVisibility(View.GONE);
                    bi.kb310.clearCheck();
                } else {
                    bi.fldGrpkb309.setVisibility(View.VISIBLE);
                }
            }
        });

        bi.kb311.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (bi.kb311a.isChecked()) {
                    bi.fldGrpkb312.setVisibility(View.GONE);
                    bi.kb312.clearCheck();
                    bi.kb31296x.setText(null);
                } else {
                    bi.fldGrpkb312.setVisibility(View.VISIBLE);
                }
            }
        });

        bi.kb314.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (bi.kb314b.isChecked()) {
                    bi.fldGrpkb314.setVisibility(View.VISIBLE);
                } else {
                    bi.kb315.clearCheck();
                    bi.fldGrpkb314.setVisibility(View.GONE);
                }
            }
        });





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

                startActivity(new Intent(this, SectionC4Activity.class));
                //startActivity(new Intent(this, MainActivity.class));

            } else {
                Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
            }
        }
    }


    private boolean formValidation() {

        if (!validatorClass.EmptyRadioButton(this, bi.kb301, bi.kb301a, getString(R.string.kb301))) {
            return false;
        }

        if (bi.kb30196.isChecked()) {
            if (!validatorClass.EmptyTextBox(this, bi.kb30196x, getString(R.string.other))) {
                return false;
            }
        }


        if (!validatorClass.EmptyRadioButton(this, bi.kb302, bi.kb302a, getString(R.string.kb302))) {
            return false;
        }


        if (bi.kb302a.isChecked()) {

            if (!validatorClass.EmptyRadioButton(this, bi.kb303, bi.kb303a, getString(R.string.kb303))) {
                return false;
            }

            if (bi.kb30396.isChecked()) {
                if (!validatorClass.EmptyTextBox(this, bi.kb30396x, getString(R.string.other))) {
                    return false;
                }
            }
        }

        if (!validatorClass.EmptyRadioButton(this, bi.kb304, bi.kb304a, getString(R.string.kb304))) {
            return false;
        }


        if (bi.kb30496.isChecked()) {
            if (!validatorClass.EmptyTextBox(this, bi.kb30496x, getString(R.string.other))) {
                return false;
            }
        }


        if (!validatorClass.EmptyRadioButton(this, bi.kb305, bi.kb305a, getString(R.string.kb305))) {
            return false;
        }

        if (bi.kb305a.isChecked()) {
            if (!validatorClass.EmptyRadioButton(this, bi.kb306, bi.kb306a, getString(R.string.kb306))) {
                return false;
            }


            if (bi.kb306a.isChecked()) {

                if (!validatorClass.EmptyTextBox(this, bi.kb306kg, getString(R.string.kb306))) {
                    return false;
                }

                if (!validatorClass.RangeTextBox(this, bi.kb306kg, 1.20, 7.00, getString(R.string.kb306), "Weight")) {
                    return false;
                }


            } else if (!bi.kb306a.isChecked()) {

                if (!validatorClass.EmptyTextBox(this, bi.kb307rec, getString(R.string.kb307))) {
                    return false;
                }


                if (!validatorClass.RangeTextBox(this, bi.kb307rec, 1.20, 7.00, getString(R.string.kb307rec), "Weight")) {
                    return false;
                }


                /*if (!bi.kb30777.isChecked()) {
                    if (!validatorClass.EmptyTextBox(this, bi.kb307rec, getString(R.string.kb307))) {
                        return false;
                    }
                }*/



/*
            if (bi.kb30777.isChecked()) {
                if (!validatorClass.EmptyRadioButton(this, bi.kb308, bi.kb308a, getString(R.string.kb308))) {
                    return false;
                }
            }*/

            }
            if (!validatorClass.EmptyRadioButton(this, bi.kb308, bi.kb308a, getString(R.string.kb308))) {
                return false;
            }
        }


        if (!validatorClass.EmptyRadioButton(this, bi.kb309, bi.kb309a, getString(R.string.kb309))) {
            return false;
        }
        if(!bi.kb309a.isChecked()){
            if (!validatorClass.EmptyRadioButton(this, bi.kb310, bi.kb310a, getString(R.string.kb310))) {
                return false;
            }
        }


        if (!validatorClass.EmptyRadioButton(this, bi.kb311, bi.kb311a, getString(R.string.kb311))) {
            return false;
        }


        if (!bi.kb311a.isChecked()) {

            if (!validatorClass.EmptyRadioButton(this, bi.kb312, bi.kb312a, getString(R.string.kb312))) {
                return false;
            }
            if (bi.kb31296.isChecked()) {
                if (!validatorClass.EmptyTextBox(this, bi.kb31296x, getString(R.string.other))) {
                    return false;
                }
            }

        }

        if (!validatorClass.EmptyRadioButton(this, bi.kb313, bi.kb313a, getString(R.string.kb313))) {
            return false;
        }


        if (!validatorClass.EmptyRadioButton(this, bi.kb314, bi.kb314a, getString(R.string.kb314))) {
            return false;
        }


        if (bi.kb314b.isChecked()) {
            if (!validatorClass.EmptyRadioButton(this, bi.kb315, bi.kb315a, getString(R.string.kb315))) {
                return false;
            }
        }


        if (!validatorClass.EmptyRadioButton(this, bi.kb316, bi.kb316a, getString(R.string.kb316))) {
            return false;
        }

        if (!validatorClass.EmptyRadioButton(this, bi.kb317, bi.kb317a, getString(R.string.kb317))) {
            return false;
        }


        return true;
    }


    private void SaveDraft() throws JSONException {

        JSONObject sC3 = new JSONObject();

        sC3.put("kb301", bi.kb301a.isChecked() ? "1"
                : bi.kb301b.isChecked() ? "2"
                : bi.kb301c.isChecked() ? "3"
                : bi.kb301d.isChecked() ? "4"
                : bi.kb301e.isChecked() ? "5"
                : bi.kb301f.isChecked() ? "6"
                : bi.kb301g.isChecked() ? "7"
                : bi.kb30198.isChecked() ? "98"
                : bi.kb30196.isChecked() ? "96"
                : "0");

        sC3.put("kb30196x", bi.kb30196x.getText().toString());


        sC3.put("kb302", bi.kb302a.isChecked() ? "1"
                : bi.kb302b.isChecked() ? "2" : bi.kb30298.isChecked() ? "98"
                : "0");

        sC3.put("kb303", bi.kb303a.isChecked() ? "1"
                : bi.kb303b.isChecked() ? "2"
                : bi.kb303c.isChecked() ? "3"
                : bi.kb303d.isChecked() ? "4"
                : bi.kb303e.isChecked() ? "5"
                : bi.kb303f.isChecked() ? "6"
                : bi.kb303g.isChecked() ? "7"
                : bi.kb303h.isChecked() ? "8"
                : bi.kb30396.isChecked() ? "96"
                : "0");

        sC3.put("kb30396x", bi.kb30396x.getText().toString());

        sC3.put("kb304", bi.kb304a.isChecked() ? "1"
                : bi.kb304b.isChecked() ? "2"
                : bi.kb304c.isChecked() ? "3"
                : bi.kb304d.isChecked() ? "4"
                : bi.kb304e.isChecked() ? "5"
                : bi.kb304f.isChecked() ? "6"
                : bi.kb304g.isChecked() ? "7"
                : bi.kb304h.isChecked() ? "8"
                : bi.kb30498.isChecked() ? "98"
                : bi.kb30496.isChecked() ? "96"
                : "0");

        sC3.put("kb30496x", bi.kb30496x.getText().toString());

        sC3.put("kb305", bi.kb305a.isChecked() ? "1"
                : bi.kb305b.isChecked() ? "2" : bi.kb30598.isChecked() ? "98"
                : "0");

        sC3.put("kb306", bi.kb306a.isChecked() ? "1"
                : bi.kb306b.isChecked() ? "2" : "0");

        sC3.put("kb306kg", bi.kb306kg.getText().toString());

        sC3.put("kb307", bi.kb307rec.getText().toString());

        sC3.put("kb308", bi.kb308a.isChecked() ? "1"
                : bi.kb308b.isChecked() ? "2"
                : bi.kb308c.isChecked() ? "3"
                : bi.kb308d.isChecked() ? "4"
                : bi.kb308e.isChecked() ? "5"
                : bi.kb30898.isChecked() ? "98"
                : "0");

       /* sC3.put("kb309", bi.kb308a.isChecked() ? "1"
                : bi.kb308b.isChecked() ? "2"
                : bi.kb30898.isChecked() ? "98"
                : "0");*/

        sC3.put("kb309", bi.kb309a.isChecked() ? "1"
                : bi.kb309b.isChecked() ? "2"
                : bi.kb30998.isChecked() ? "98"
                : "0");
        sC3.put("kb310", bi.kb310a.isChecked() ? "1"
                : bi.kb310b.isChecked() ? "2"
                : bi.kb310c.isChecked() ? "3"
                : bi.kb310d.isChecked() ? "4"
                : "0");


        sC3.put("kb311", bi.kb311a.isChecked() ? "1"
                : bi.kb311b.isChecked() ? "2"

                : bi.kb31198.isChecked() ? "98"
                : "0");

        sC3.put("kb312", bi.kb312a.isChecked() ? "1"
                : bi.kb312b.isChecked() ? "2"
                : bi.kb312c.isChecked() ? "3"
//                : bi.kb312d.isChecked() ? "4"
                : bi.kb31296.isChecked() ? "96"
                : bi.kb31298.isChecked() ? "98"
                : "0");

        sC3.put("kb31296x", bi.kb31296x.getText().toString());

        sC3.put("kb313", bi.kb313a.isChecked() ? "1"
                : bi.kb313b.isChecked() ? "2"
                : bi.kb31398.isChecked() ? "98"
                : "0");


        sC3.put("kb314", bi.kb314a.isChecked() ? "1"
                : bi.kb314b.isChecked() ? "2"
                : bi.kb31498.isChecked() ? "98"
                : "0");


        sC3.put("kb315", bi.kb315a.isChecked() ? "1"
                : bi.kb315b.isChecked() ? "2"
                : bi.kb31598.isChecked() ? "98"
                : "0");
        sC3.put("kb316", bi.kb316a.isChecked() ? "1"
                : bi.kb316b.isChecked() ? "2"
                : bi.kb316c.isChecked() ? "3"
                : bi.kb316d.isChecked() ? "4"
                : bi.kb31696.isChecked() ? "96"
                : "0");
        sC3.put("kb31696x", bi.kb31696x.getText().toString());


        sC3.put("kb317", bi.kb317a.isChecked() ? "1"
                : bi.kb317b.isChecked() ? "2"
                : bi.kb31798.isChecked() ? "98"
                : "0");



        MainApp.fc.setsC3(String.valueOf(sC3));
    }

    private boolean UpdateDB() {
        //Long rowId;
        DatabaseHelper db = new DatabaseHelper(this);

        int updcount = db.updateSC3();

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