package edu.aku.hassannaqvi.kmc.ui;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
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
import edu.aku.hassannaqvi.kmc.databinding.ActivitySectionC3Binding;
import edu.aku.hassannaqvi.kmc.validation.validatorClass;


public class SectionC3Activity extends AppCompatActivity {

    private static final String TAG = SectionC3Activity.class.getName();
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

        bi.kc305.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (bi.kc305a.isChecked()) {
                    bi.fldGrpkc305.setVisibility(View.VISIBLE);
                } else {
                    bi.fldGrpkc305.setVisibility(View.GONE);
                    bi.kc306.clearCheck();
                    bi.kc306kg.setText(null);
                    bi.kc307rec.setText(null);

                    //bi.kc30777.setChecked(false);

                    bi.kc308.clearCheck();
                }
            }
        });


        bi.kc306.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (bi.kc306a.isChecked()) {
                    bi.kc306kg.setVisibility(View.VISIBLE);
                    bi.fldGrpkc306.setVisibility(View.GONE);
                    bi.kc307rec.setText(null);
                    //bi.kc30777.setChecked(false);

//                    bi.fldGrpkc307.setVisibility(View.GONE);
//                    bi.fldGrpkc308.setVisibility(View.VISIBLE);
                } else {
                    bi.kc306kg.setText(null);
                    bi.kc306kg.setVisibility(View.GONE);
//                    bi.kc309.clearCheck();
                    bi.fldGrpkc306.setVisibility(View.VISIBLE);
//                    bi.fldGrpkc307.setVisibility(View.VISIBLE);
//                    bi.fldGrpkc308.setVisibility(View.GONE);
                }
            }
        });


        /*bi.kc30777.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    bi.kc307rec.setText(null);
                    bi.kc307rec.setVisibility(View.GONE);
//                    bi.fldGrpkc307.setVisibility(View.VISIBLE);
                } else {
                    bi.kc308.clearCheck();
                    bi.kc307rec.setVisibility(View.VISIBLE);
//                    bi.fldGrpkc307.setVisibility(View.GONE);
                }
            }
        });*/


        bi.kc310.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (bi.kc310a.isChecked()) {
                    bi.fldGrpkc311.setVisibility(View.GONE);
                    bi.kc311.clearCheck();
                    bi.kc31196x.setText(null);
                } else {
                    bi.fldGrpkc311.setVisibility(View.VISIBLE);
                }
            }
        });

        bi.kc313.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (bi.kc313b.isChecked()) {
                    bi.fldGrpkc313.setVisibility(View.VISIBLE);
                } else {
                    bi.kc314.clearCheck();
                    bi.fldGrpkc313.setVisibility(View.GONE);
                }
            }
        });


        bi.kc315.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (!bi.kc315a.isChecked()) {
                    bi.fldGrpkc315.setVisibility(View.GONE);

                    bi.kc316a.setChecked(false);
                    bi.kc316b.setChecked(false);
                    bi.kc316c.setChecked(false);
                    bi.kc316d.setChecked(false);
                    bi.kc316e.setChecked(false);
                    bi.kc316f.setChecked(false);
                    bi.kc31696.setChecked(false);
                    bi.kc31698.setChecked(false);

                    bi.kc31696x.setText(null);
                } else {
                    bi.fldGrpkc315.setVisibility(View.VISIBLE);
                }
            }
        });
        bi.kc31698.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    bi.kc316a.setChecked(false);
                    bi.kc316b.setChecked(false);
                    bi.kc316c.setChecked(false);
                    bi.kc316d.setChecked(false);
                    bi.kc316e.setChecked(false);
                    bi.kc316f.setChecked(false);
                    bi.kc31696.setChecked(false);
                    bi.kc31696x.setText(null);
                    bi.kc316a.setEnabled(false);
                    bi.kc316b.setEnabled(false);
                    bi.kc316c.setEnabled(false);
                    bi.kc316d.setEnabled(false);
                    bi.kc316e.setEnabled(false);
                    bi.kc316f.setEnabled(false);
                    bi.kc31696.setEnabled(false);
                } else {
                    bi.kc316a.setEnabled(true);
                    bi.kc316b.setEnabled(true);
                    bi.kc316c.setEnabled(true);
                    bi.kc316d.setEnabled(true);
                    bi.kc316e.setEnabled(true);
                    bi.kc316f.setEnabled(true);
                    bi.kc31696.setEnabled(true);
                }
            }
        });


        bi.kc317.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (bi.kc317b.isChecked()) {
                    bi.kc317day.setText(null);
                    bi.kc317hr.setVisibility(View.VISIBLE);
                    bi.kc317day.setVisibility(View.GONE);
                } else if (bi.kc317c.isChecked()) {
                    bi.kc317hr.setText(null);
                    bi.kc317hr.setVisibility(View.GONE);
                    bi.kc317day.setVisibility(View.VISIBLE);
                } else {
                    bi.kc317hr.setText(null);
                    bi.kc317day.setText(null);
                    bi.kc317hr.setVisibility(View.GONE);
                    bi.kc317day.setVisibility(View.GONE);
                }
            }
        });


        bi.kc319.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (bi.kc319a.isChecked()) {
                    bi.kc320.clearCheck();
                    bi.fldGrpkc320.setVisibility(View.GONE);
                } else {
                    bi.fldGrpkc320.setVisibility(View.VISIBLE);
                }
            }
        });


        bi.kc321.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (bi.kc321e.isChecked()) {
                    bi.fldGrpkc321.setVisibility(View.VISIBLE);
                } else {
                    bi.kc322a.setChecked(false);
                    bi.kc322b.setChecked(false);
                    bi.kc322c.setChecked(false);
                    bi.kc322d.setChecked(false);
                    bi.kc322e.setChecked(false);
                    bi.kc32296.setChecked(false);
                    bi.kc32296x.setText(null);

                    bi.fldGrpkc321.setVisibility(View.GONE);
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

        if (!validatorClass.EmptyRadioButton(this, bi.kc301, bi.kc301a, getString(R.string.kc301))) {
            return false;
        }

        if (bi.kc30196.isChecked()) {
            if (!validatorClass.EmptyTextBox(this, bi.kc30196x, getString(R.string.other))) {
                return false;
            }
        }


        if (!validatorClass.EmptyRadioButton(this, bi.kc302, bi.kc302a, getString(R.string.kc302))) {
            return false;
        }


        if (bi.kc302a.isChecked()) {

            if (!validatorClass.EmptyRadioButton(this, bi.kc303, bi.kc303a, getString(R.string.kc303))) {
                return false;
            }

            if (bi.kc30396.isChecked()) {
                if (!validatorClass.EmptyTextBox(this, bi.kc30396x, getString(R.string.other))) {
                    return false;
                }
            }
        }

        if (!validatorClass.EmptyRadioButton(this, bi.kc304, bi.kc304a, getString(R.string.kc304))) {
            return false;
        }


        if (bi.kc30496.isChecked()) {
            if (!validatorClass.EmptyTextBox(this, bi.kc30496x, getString(R.string.other))) {
                return false;
            }
        }


        if (!validatorClass.EmptyRadioButton(this, bi.kc305, bi.kc305a, getString(R.string.kc305))) {
            return false;
        }

        if (bi.kc305a.isChecked()) {
            if (!validatorClass.EmptyRadioButton(this, bi.kc306, bi.kc306a, getString(R.string.kc306))) {
                return false;
            }


            if (bi.kc306a.isChecked()) {

                if (!validatorClass.EmptyTextBox(this, bi.kc306kg, getString(R.string.kc306))) {
                    return false;
                }

                if (!validatorClass.RangeTextBox(this, bi.kc306kg, 1.20, 7.00, getString(R.string.kc306), "Weight")) {
                    return false;
                }


            } else if (!bi.kc306a.isChecked()) {

                if (!validatorClass.EmptyTextBox(this, bi.kc307rec, getString(R.string.kc307))) {
                    return false;
                }

                /*if (!bi.kc30777.isChecked()) {
                    if (!validatorClass.EmptyTextBox(this, bi.kc307rec, getString(R.string.kc307))) {
                        return false;
                    }
                }*/



/*
            if (bi.kc30777.isChecked()) {
                if (!validatorClass.EmptyRadioButton(this, bi.kc308, bi.kc308a, getString(R.string.kc308))) {
                    return false;
                }
            }*/

            }
            if (!validatorClass.EmptyRadioButton(this, bi.kc308, bi.kc308a, getString(R.string.kc308))) {
                return false;
            }
        }


        if (!validatorClass.EmptyRadioButton(this, bi.kc309, bi.kc309a, getString(R.string.kc309))) {
            return false;
        }


        if (!validatorClass.EmptyRadioButton(this, bi.kc310, bi.kc310a, getString(R.string.kc310))) {
            return false;
        }


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

        if (!validatorClass.EmptyRadioButton(this, bi.kc312, bi.kc312a, getString(R.string.kc312))) {
            return false;
        }


        if (!validatorClass.EmptyRadioButton(this, bi.kc313, bi.kc313a, getString(R.string.kc313))) {
            return false;
        }


        if (bi.kc313b.isChecked()) {
            if (!validatorClass.EmptyRadioButton(this, bi.kc314, bi.kc314a, getString(R.string.kc314))) {
                return false;
            }
        }


        if (!validatorClass.EmptyRadioButton(this, bi.kc315, bi.kc315a, getString(R.string.kc315))) {
            return false;
        }


        if (bi.kc315a.isChecked()) {

            if (!validatorClass.EmptyCheckBox(this, bi.fldGrpkc315a, bi.kc316a, getString(R.string.kc316))) {
                return false;
            }


            if (bi.kc31696.isChecked()) {
                if (!validatorClass.EmptyTextBox(this, bi.kc31696x, getString(R.string.other))) {
                    return false;
                }
            }
        }


        if (!validatorClass.EmptyRadioButton(this, bi.kc317, bi.kc317a, getString(R.string.kc317))) {
            return false;
        }


        if (bi.kc317b.isChecked()) {
            if (!validatorClass.EmptyTextBox(this, bi.kc317hr, getString(R.string.hours))) {
                return false;
            }

            if (!validatorClass.RangeTextBox(this, bi.kc317hr, 1, 23, getString(R.string.hours), "Hours")) {
                return false;
            }

        } else if (bi.kc317c.isChecked()) {
            if (!validatorClass.EmptyTextBox(this, bi.kc317day, getString(R.string.days))) {
                return false;
            }

            if (!validatorClass.RangeTextBox(this, bi.kc317day, 1, 30, getString(R.string.days), "Days")) {
                return false;
            }
        }


        if (!validatorClass.EmptyRadioButton(this, bi.kc318, bi.kc318a, getString(R.string.kc318))) {
            return false;
        }


        if (bi.kc31896.isChecked()) {
            if (!validatorClass.EmptyTextBox(this, bi.kc31896x, getString(R.string.other))) {
                return false;
            }
        }


        if (!validatorClass.EmptyRadioButton(this, bi.kc319, bi.kc319a, getString(R.string.kc319))) {
            return false;
        }


        if (!bi.kc319a.isChecked()) {

            if (!validatorClass.EmptyRadioButton(this, bi.kc320, bi.kc320a, getString(R.string.kc320))) {
                return false;
            }

            if (bi.kc32096.isChecked()) {
                if (!validatorClass.EmptyTextBox(this, bi.kc32096x, getString(R.string.other))) {
                    return false;
                }
            }
        }


        if (!validatorClass.EmptyRadioButton(this, bi.kc321, bi.kc321a, getString(R.string.kc321))) {
            return false;
        }


        if (bi.kc32196.isChecked()) {
            if (!validatorClass.EmptyTextBox(this, bi.kc32196x, getString(R.string.other))) {
                return false;
            }
        }


        if (bi.kc321e.isChecked()) {

            if (!bi.kc322a.isChecked()
                    && !bi.kc322b.isChecked()
                    && !bi.kc322c.isChecked()
                    && !bi.kc322d.isChecked()
                    && !bi.kc322e.isChecked()
                    && !bi.kc32296.isChecked()
                    ) {
                Toast.makeText(this, "ERROR(empty): " + getString(R.string.kc322a), Toast.LENGTH_SHORT).show();
                bi.kc322a.setError("This data is Required!");
                Log.i(TAG, "kc322a: This data is Required!");
                return false;
            } else {
                bi.kc322a.setError(null);
            }


            if (bi.kc32296.isChecked()) {
                if (!validatorClass.EmptyTextBox(this, bi.kc32296x, getString(R.string.other))) {
                    return false;
                }
            }

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
                : bi.kc301f.isChecked() ? "6"
                : bi.kc301g.isChecked() ? "7"
                : bi.kc30198.isChecked() ? "98"
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
                : bi.kc306b.isChecked() ? "2" : "0");

        sC3.put("kc306kg", bi.kc306kg.getText().toString());

        sC3.put("kc307", bi.kc307rec.getText().toString());

        sC3.put("kc308", bi.kc308a.isChecked() ? "1"
                : bi.kc308b.isChecked() ? "2"
                : bi.kc308c.isChecked() ? "3"
                : bi.kc308d.isChecked() ? "4"
                : bi.kc308e.isChecked() ? "5"
                : bi.kc30898.isChecked() ? "98"
                : "0");

       /* sC3.put("kc309", bi.kc308a.isChecked() ? "1"
                : bi.kc308b.isChecked() ? "2"
                : bi.kc30898.isChecked() ? "98"
                : "0");*/

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
//                : bi.kc311d.isChecked() ? "4"
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


        sC3.put("kc316a", bi.kc316a.isChecked() ? "1" : "0");
        sC3.put("kc316b", bi.kc316b.isChecked() ? "2" : "0");
        sC3.put("kc316c", bi.kc316c.isChecked() ? "3" : "0");
        sC3.put("kc316d", bi.kc316d.isChecked() ? "4" : "0");
        sC3.put("kc316e", bi.kc316e.isChecked() ? "5" : "0");
        sC3.put("kc316f", bi.kc316f.isChecked() ? "6" : "0");
        sC3.put("kc31696", bi.kc31696.isChecked() ? "96" : "0");
        sC3.put("kc31698", bi.kc31698.isChecked() ? "98" : "0");


        sC3.put("kc31696x", bi.kc31696x.getText().toString());

        sC3.put("kc317", bi.kc317a.isChecked() ? "1"
                : bi.kc317b.isChecked() ? "2"
                : bi.kc317c.isChecked() ? "3"
                : bi.kc317d.isChecked() ? "4"
                : bi.kc31798.isChecked() ? "98"
                : "0");


        sC3.put("kc317hr", bi.kc317hr.getText().toString());
        sC3.put("kc317day", bi.kc317day.getText().toString());


        sC3.put("kc318a", bi.kc318a.isChecked() ? "1" : "0");
        sC3.put("kc318b", bi.kc318b.isChecked() ? "2" : "0");
        sC3.put("kc318c", bi.kc318c.isChecked() ? "3" : "0");
        sC3.put("kc318d", bi.kc318d.isChecked() ? "4" : "0");
        sC3.put("kc318e", bi.kc318e.isChecked() ? "5" : "0");
        sC3.put("kc31896", bi.kc31896.isChecked() ? "96" : "0");

        sC3.put("kc31896x", bi.kc31896x.getText().toString());


        sC3.put("kc319", bi.kc319a.isChecked() ? "1"
                : bi.kc319b.isChecked() ? "2"
                : bi.kc31998.isChecked() ? "98"
                : "0");


        sC3.put("kc320", bi.kc320a.isChecked() ? "1"
                : bi.kc320b.isChecked() ? "2"
                : bi.kc320c.isChecked() ? "3"
                : bi.kc320d.isChecked() ? "4"
                : bi.kc32096.isChecked() ? "96"
                : "0");

        sC3.put("kc32096x", bi.kc32096x.getText().toString());


        sC3.put("kc321a", bi.kc321a.isChecked() ? "1" : "0");
        sC3.put("kc321b", bi.kc321b.isChecked() ? "2" : "0");
        sC3.put("kc321c", bi.kc321c.isChecked() ? "3" : "0");
        sC3.put("kc321d", bi.kc321d.isChecked() ? "4" : "0");
        sC3.put("kc321e", bi.kc321e.isChecked() ? "5" : "0");
        sC3.put("kc32196", bi.kc32196.isChecked() ? "96" : "0");

        sC3.put("kc32196x", bi.kc32196x.getText().toString());


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