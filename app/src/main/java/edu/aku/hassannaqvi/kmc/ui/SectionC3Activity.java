package edu.aku.hassannaqvi.kmc.ui;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import edu.aku.hassannaqvi.kmc.R;
import edu.aku.hassannaqvi.kmc.core.DatabaseHelper;
import edu.aku.hassannaqvi.kmc.core.MainApp;
import edu.aku.hassannaqvi.kmc.databinding.ActivitySectionC3Binding;
import edu.aku.hassannaqvi.kmc.validation.validatorClass;


public class SectionC3Activity extends AppCompatActivity {

    ActivitySectionC3Binding bi;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_section_c3);

        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_c3);
        bi.setCallback(this);


        bi.kc302.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (bi.kc302a.isChecked()) {
                    bi.fldGrpkc303.setVisibility(View.VISIBLE);
                } else {
                    bi.fldGrpkc303.setVisibility(View.GONE);
                    bi.kc303.clearCheck();
                    bi.kc30396x.setText(null);
                }
            }
        });


        bi.kc310.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                if (bi.kc310a.isChecked()) {
                    bi.fldGrpkc311.setVisibility(View.VISIBLE);

                } else {
                    bi.fldGrpkc311.setVisibility(View.GONE);
                    bi.kc311.clearCheck();
                    bi.kc31196x.setText(null);
                }
            }
        });

        bi.kc314.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (bi.kc314a.isChecked()) {
                    bi.fldGrpkc315.setVisibility(View.GONE);
                    bi.kc315.clearCheck();
                    bi.kc31596x.setText(null);
                } else {
                    bi.fldGrpkc315.setVisibility(View.VISIBLE);
                }
            }
        });










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

                startActivity(new Intent(this, SectionC4Activity.class));

            } else {
                Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
            }
        }
    }


    private boolean formValidation() {

        if (!validatorClass.EmptyRadioButton(this, bi.kc301, bi.kc301a, getString(R.string.kc301))) {
            return false;
        }

        if (!validatorClass.EmptyRadioButton(this, bi.kc302, bi.kc302a, getString(R.string.kc302))) {
            return false;
        }
        if (bi.kc302a.isChecked()) {

            if (!validatorClass.EmptyRadioButton(this, bi.kc303, bi.kc303a, getString(R.string.kc303))) {
                return false;
            }
        }
        if (!validatorClass.EmptyRadioButton(this, bi.kc304, bi.kc304a, getString(R.string.kc304))) {
            return false;
        }


        if (!validatorClass.EmptyRadioButton(this, bi.kc305, bi.kc305a, getString(R.string.kc305))) {
            return false;
        }

        if (bi.kc305a.isChecked()) {
            if (!validatorClass.EmptyRadioButton(this, bi.kc306, bi.kc306a, getString(R.string.kc306))) {
                return false;
            }
        }

        if (!bi.kc306a.isChecked()) {

            if (!validatorClass.EmptyRadioButton(this, bi.kc307, bi.kc307a, getString(R.string.kc307))) {
                return false;
            }

            if (!validatorClass.EmptyTextBox(this, bi.kc308, getString(R.string.kc308))) {
                return false;
            }
        }

        if (!validatorClass.EmptyRadioButton(this, bi.kc309, bi.kc309a, getString(R.string.kc309))) {
            return false;
        }


        if (!validatorClass.EmptyRadioButton(this, bi.kc310, bi.kc310a, getString(R.string.kc310))) {
            return false;
        }


   /*     if (bi.kc31096.isChecked()) {

            if (!validatorClass.EmptyTextBox(this, bi.kc31096x, getString(R.string.other))) {
                return false;
            }
        }*/
        if (!bi.kc310a.isChecked()) {

            if (!validatorClass.EmptyRadioButton(this, bi.kc311, bi.kc311a, getString(R.string.kc311))) {
                return false;
            }


            if (bi.kc31196.isChecked()) {

                if (!validatorClass.EmptyTextBox(this, bi.kc31196x, getString(R.string.other))) {
                    return false;
                }
            }

        }
        if (!validatorClass.EmptyCheckBox(this, bi.kc312, bi.kc312a, getString(R.string.kc312))) {
            return false;
        }


        /*if (bi.kc31296.isChecked()) {

            if (!validatorClass.EmptyTextBox(this, bi.kc31296x, getString(R.string.other))) {
                return false;
            }
        }*/


        if (!validatorClass.EmptyRadioButton(this, bi.kc313, bi.kc313a, getString(R.string.kc313))) {
            return false;
        }


        if (bi.kc313b.isChecked()) {

            if (!validatorClass.EmptyRadioButton(this, bi.kc314, bi.kc314a, getString(R.string.kc314))) {
                return false;
            }

        }
            /*if (bi.kc31496.isChecked()) {

                if (!validatorClass.EmptyTextBox(this, bi.kc31496x, getString(R.string.other))) {
                    return false;
                }
            }*/


        if (!validatorClass.EmptyRadioButton(this, bi.kc315, bi.kc315a, getString(R.string.kc315))) {
            return false;
        }

        if (bi.kc315a.isChecked()) {

            return validatorClass.EmptyRadioButton(this, bi.kc316, bi.kc316a, getString(R.string.kc316));
        }

        return true;
    }


    private void SaveDraft() throws JSONException {

        JSONObject sC3 = new JSONObject();

        sC3.put("kc301", bi.kc301a.isChecked() ? "1"
                : bi.kc301b.isChecked() ? "2"
                : bi.kc301c.isChecked() ? "3"
                : bi.kc301d.isChecked() ? "4"
                : bi.kc301e.isChecked() ? "5"
                //: bi.kc301f.isChecked() ? "6"
                : bi.kc30196.isChecked() ? "96"
                : "0");
        sC3.put("kc30196x", bi.kc30196x.getText().toString());


        sC3.put("kc302", bi.kc302a.isChecked() ? "1"
                : bi.kc302b.isChecked() ? "2" : bi.kc30298.isChecked() ? "98"
                : "0");

        sC3.put("kc303", bi.kc303a.isChecked() ? "1"
                : bi.kc303b.isChecked() ? "2"
                : bi.kc303c.isChecked() ? "3"
                : bi.kc303d.isChecked() ? "4"
                : bi.kc303e.isChecked() ? "5"
                : bi.kc303f.isChecked() ? "6"
                : bi.kc303g.isChecked() ? "7"
                : bi.kc303h.isChecked() ? "8"
                : bi.kc30396.isChecked() ? "96"
                : "0");
        sC3.put("kc30396x", bi.kc30396x.getText().toString());

        sC3.put("kc304", bi.kc304a.isChecked() ? "1"
                : bi.kc304b.isChecked() ? "2"
                : bi.kc304c.isChecked() ? "3"
                : bi.kc304d.isChecked() ? "4"
                : bi.kc304e.isChecked() ? "5"
                : bi.kc304f.isChecked() ? "6"
                : bi.kc304g.isChecked() ? "7"
                : bi.kc304h.isChecked() ? "8"
                : bi.kc30498.isChecked() ? "98"
                : bi.kc30496.isChecked() ? "96"
                : "0");
        sC3.put("kc30496x", bi.kc30496x.getText().toString());

        sC3.put("kc305", bi.kc305a.isChecked() ? "1"
                : bi.kc305b.isChecked() ? "2" : bi.kc30598.isChecked() ? "98"
                : "0");

        sC3.put("kc306", bi.kc306a.isChecked() ? "1"
                : bi.kc306b.isChecked() ? "2" : bi.kc30698.isChecked() ? "98"
                : "0");

        sC3.put("kc306kg", bi.kc306kg.getText().toString());

        sC3.put("kc307", bi.kc307a.isChecked() ? "1"
                : bi.kc307b.isChecked() ? "2" : bi.kc30798.isChecked() ? "98"
                : "0");

        sC3.put("kc307", bi.kc307a.isChecked() ? "1"
                : bi.kc307b.isChecked() ? "2"
                : bi.kc307c.isChecked() ? "3"
                : bi.kc307d.isChecked() ? "4"
                : bi.kc307e.isChecked() ? "5"
                : bi.kc30798.isChecked() ? "98"
                : "0");

        sC3.put("kc308", bi.kc308a.isChecked() ? "1"
                : bi.kc308b.isChecked() ? "2"
                : bi.kc30898.isChecked() ? "98"
                : "0");

        sC3.put("kc309", bi.kc309a.isChecked() ? "1"
                : bi.kc309b.isChecked() ? "2"
                : bi.kc30998.isChecked() ? "98"
                : "0");


        sC3.put("kc310", bi.kc310a.isChecked() ? "1"
                : bi.kc310b.isChecked() ? "2"

                : bi.kc31098.isChecked() ? "98"
                : "0");

        sC3.put("kc311", bi.kc311a.isChecked() ? "1"
                : bi.kc311b.isChecked() ? "2"
                : bi.kc311c.isChecked() ? "3"
                : bi.kc311d.isChecked() ? "4"
                : bi.kc31196.isChecked() ? "96"
                : bi.kc31198.isChecked() ? "98"
                : "0");

        sC3.put("kc31196x", bi.kc31196x.getText().toString());

        sC3.put("kc312", bi.kc312a.isChecked() ? "1"
                : bi.kc312b.isChecked() ? "2"
                : bi.kc31298.isChecked() ? "98"
                : "0");


        sC3.put("kc313", bi.kc313a.isChecked() ? "1"
                : bi.kc313b.isChecked() ? "2"
                : bi.kc31398.isChecked() ? "98"
                : "0");


        sC3.put("kc314", bi.kc314a.isChecked() ? "1"
                : bi.kc314b.isChecked() ? "2"
                : bi.kc31498.isChecked() ? "98"
                : "0");

        sC3.put("kc315", bi.kc315a.isChecked() ? "1"
                : bi.kc315b.isChecked() ? "2"
                : bi.kc315c.isChecked() ? "3"
                : bi.kc315d.isChecked() ? "4"
                : bi.kc315e.isChecked() ? "5"
                : bi.kc31596.isChecked() ? "96"
                : bi.kc31598.isChecked() ? "98"
                : "0");

        sC3.put("kc31596x", bi.kc31596x.getText().toString());

        sC3.put("kc316", bi.kc316a.isChecked() ? "1"
                : bi.kc316b.isChecked() ? "2"
                : bi.kc316c.isChecked() ? "3"
                : bi.kc31697.isChecked() ? "97"
                : bi.kc31698.isChecked() ? "98"

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
}
