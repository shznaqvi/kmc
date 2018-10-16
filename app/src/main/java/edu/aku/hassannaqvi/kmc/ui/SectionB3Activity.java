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


        bi.kbc02.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (bi.kbc02a.isChecked()) {
                    bi.fldGrpkbc03.setVisibility(View.VISIBLE);
                } else {
                    bi.fldGrpkbc03.setVisibility(View.GONE);
                    bi.kbc03.clearCheck();
                    bi.kbc0396x.setText(null);
                }
            }
        });

        bi.kbc05.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (bi.kbc05a.isChecked()) {
                    bi.fldGrpkbc05.setVisibility(View.VISIBLE);
                } else {
                    bi.fldGrpkbc05.setVisibility(View.GONE);
                    bi.kbc06.clearCheck();
                    bi.kbc06kg.setText(null);
                    bi.kbc07rec.setText(null);

                    //bi.kbc0777.setChecked(false);

                    bi.kbc08.clearCheck();
                }
            }
        });


        bi.kbc06.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (bi.kbc06a.isChecked()) {
                    bi.kbc06kg.setVisibility(View.VISIBLE);
                    bi.fldGrpkbc06.setVisibility(View.GONE);
                    bi.kbc07rec.setText(null);
                    bi.kbc08.clearCheck();
                    //bi.kbc0777.setChecked(false);

//                    bi.fldGrpkbc07.setVisibility(View.GONE);
//                    bi.fldGrpkbc08.setVisibility(View.VISIBLE);
                } else {
                    bi.kbc06kg.setText(null);
                    bi.kbc06kg.setVisibility(View.GONE);
//                    bi.kbc09.clearCheck();
                    bi.fldGrpkbc06.setVisibility(View.VISIBLE);
//                    bi.fldGrpkbc07.setVisibility(View.VISIBLE);
//                    bi.fldGrpkbc08.setVisibility(View.GONE);
                }
            }
        });


        /*bi.kbc0777.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    bi.kbc07rec.setText(null);
                    bi.kbc07rec.setVisibility(View.GONE);
//                    bi.fldGrpkbc07.setVisibility(View.VISIBLE);
                } else {
                    bi.kbc08.clearCheck();
                    bi.kbc07rec.setVisibility(View.VISIBLE);
//                    bi.fldGrpkbc07.setVisibility(View.GONE);
                }
            }
        });*/

        bi.kbc09.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (bi.kbc09a.isChecked()) {
                    bi.fldGrpkbc09.setVisibility(View.GONE);
                    bi.kbc10.clearCheck();
                } else {
                    bi.fldGrpkbc09.setVisibility(View.VISIBLE);
                }
            }
        });

        bi.kbc11.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (bi.kbc11a.isChecked()) {
                    bi.fldGrpkbc12.setVisibility(View.GONE);
                    bi.kbc12.clearCheck();
                    bi.kbc1296x.setText(null);
                } else {
                    bi.fldGrpkbc12.setVisibility(View.VISIBLE);
                }
            }
        });

        bi.kbc14.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (bi.kbc14a.isChecked()) {
                    bi.fldGrpkbc14.setVisibility(View.VISIBLE);
                } else {
                    bi.kbc15.clearCheck();
                    bi.fldGrpkbc14.setVisibility(View.GONE);
                }
            }
        });
        bi.kbc17.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.kbc17a) {
                    bi.fldGrpkbc17.setVisibility(View.VISIBLE);
                } else {
                    bi.fldGrpkbc17.setVisibility(View.GONE);
                    bi.kbc18a.setChecked(false);
                    bi.kbc18b.setChecked(false);
                    bi.kbc18c.setChecked(false);
                    bi.kbc18d.setChecked(false);
                    bi.kbc18e.setChecked(false);
                    bi.kbc18f.setChecked(false);
                    bi.kbc1896.setChecked(false);
                    bi.kbc1898.setChecked(false);
                    bi.kbc1896x.setText(null);

                }
            }
        });
        bi.kbc1898.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    bi.kbc18a.setChecked(false);
                    bi.kbc18b.setChecked(false);
                    bi.kbc18c.setChecked(false);
                    bi.kbc18d.setChecked(false);
                    bi.kbc18e.setChecked(false);
                    bi.kbc18f.setChecked(false);
                    bi.kbc1896.setChecked(false);

                    bi.kbc1896x.setText(null);

                    bi.kbc18a.setEnabled(false);
                    bi.kbc18b.setEnabled(false);
                    bi.kbc18c.setEnabled(false);
                    bi.kbc18d.setEnabled(false);
                    bi.kbc18e.setEnabled(false);
                    bi.kbc18f.setEnabled(false);
                    bi.kbc1896.setEnabled(false);

                } else {

                    bi.kbc18a.setEnabled(true);
                    bi.kbc18b.setEnabled(true);
                    bi.kbc18c.setEnabled(true);
                    bi.kbc18d.setEnabled(true);
                    bi.kbc18e.setEnabled(true);
                    bi.kbc18f.setEnabled(true);
                    bi.kbc1896.setEnabled(true);
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

        if (formValidation()) {
            try {
                SaveDraft();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (UpdateDB()) {

                finish();

                startActivity(new Intent(this, SectionB3_PNCActivity.class));
                //startActivity(new Intent(this, MainActivity.class));

            } else {
                Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
            }
        }
    }


    private boolean formValidation() {

        if (!validatorClass.EmptyRadioButton(this, bi.kbc01, bi.kbc01a, getString(R.string.kbc01))) {
            return false;
        }

        if (bi.kbc0196.isChecked()) {
            if (!validatorClass.EmptyTextBox(this, bi.kbc0196x, getString(R.string.other))) {
                return false;
            }
        }


        if (!validatorClass.EmptyRadioButton(this, bi.kbc02, bi.kbc02a, getString(R.string.kbc02))) {
            return false;
        }


        if (bi.kbc02a.isChecked()) {

            if (!validatorClass.EmptyRadioButton(this, bi.kbc03, bi.kbc03a, getString(R.string.kbc03))) {
                return false;
            }

            if (bi.kbc0396.isChecked()) {
                if (!validatorClass.EmptyTextBox(this, bi.kbc0396x, getString(R.string.other))) {
                    return false;
                }
            }
        }

        if (!validatorClass.EmptyRadioButton(this, bi.kbc04, bi.kbc04a, getString(R.string.kbc04))) {
            return false;
        }


        if (bi.kbc0496.isChecked()) {
            if (!validatorClass.EmptyTextBox(this, bi.kbc0496x, getString(R.string.other))) {
                return false;
            }
        }


        if (!validatorClass.EmptyRadioButton(this, bi.kbc05, bi.kbc05a, getString(R.string.kbc05))) {
            return false;
        }

        if (bi.kbc05a.isChecked()) {
            if (!validatorClass.EmptyRadioButton(this, bi.kbc06, bi.kbc06a, getString(R.string.kbc06))) {
                return false;
            }


            if (bi.kbc06a.isChecked()) {

                if (!validatorClass.EmptyTextBox(this, bi.kbc06kg, getString(R.string.kbc06))) {
                    return false;
                }

                if (!validatorClass.RangeTextBox(this, bi.kbc06kg, 1.20, 7.00, getString(R.string.kbc06), "Weight")) {
                    return false;
                }


            } else if (!bi.kbc06a.isChecked()) {

                if (!validatorClass.EmptyTextBox(this, bi.kbc07rec, getString(R.string.kbc07))) {
                    return false;
                }


                if (!validatorClass.RangeTextBox(this, bi.kbc07rec, 1.20, 7.00, getString(R.string.kbc07rec), "Weight")) {
                    return false;
                }


                /*if (!bi.kbc0777.isChecked()) {
                    if (!validatorClass.EmptyTextBox(this, bi.kbc07rec, getString(R.string.kbc07))) {
                        return false;
                    }
                }*/



/*
            if (bi.kbc0777.isChecked()) {
                if (!validatorClass.EmptyRadioButton(this, bi.kbc08, bi.kbc08a, getString(R.string.kbc08))) {
                    return false;
                }
            }*/
                if (!validatorClass.EmptyRadioButton(this, bi.kbc08, bi.kbc08a, getString(R.string.kbc08))) {
                    return false;
                }
            }

        }


        if (!validatorClass.EmptyRadioButton(this, bi.kbc09, bi.kbc09a, getString(R.string.kbc09))) {
            return false;
        }
        if (!bi.kbc09a.isChecked()) {
            if (!validatorClass.EmptyRadioButton(this, bi.kbc10, bi.kbc10a, getString(R.string.kbc10))) {
                return false;
            }
        }


        if (!validatorClass.EmptyRadioButton(this, bi.kbc11, bi.kbc11a, getString(R.string.kbc11))) {
            return false;
        }


        if (!bi.kbc11a.isChecked()) {

            if (!validatorClass.EmptyRadioButton(this, bi.kbc12, bi.kbc12a, getString(R.string.kbc12))) {
                return false;
            }
            if (bi.kbc1296.isChecked()) {
                if (!validatorClass.EmptyTextBox(this, bi.kbc1296x, getString(R.string.other))) {
                    return false;
                }
            }

        }

        if (!validatorClass.EmptyRadioButton(this, bi.kbc13, bi.kbc13a, getString(R.string.kbc13))) {
            return false;
        }


        if (!validatorClass.EmptyRadioButton(this, bi.kbc14, bi.kbc14a, getString(R.string.kbc14))) {
            return false;
        }


        if (bi.kbc14a.isChecked()) {
            if (!validatorClass.EmptyRadioButton(this, bi.kbc15, bi.kbc15a, getString(R.string.kbc15))) {
                return false;
            }
        }


        if (!validatorClass.EmptyRadioButton(this, bi.kbc16, bi.kbc1696, bi.kbc1696x, getString(R.string.kbc16))) {
            return false;
        }

        if (!validatorClass.EmptyRadioButton(this, bi.kbc17, bi.kbc17a, getString(R.string.kbc17))) {
            return false;
        }
        if (bi.kbc17a.isChecked()) {

            if (!validatorClass.EmptyCheckBox(this, bi.fldGrpkbc17a, bi.kbc1896, bi.kbc1896x, getString(R.string.kbc18))) {
                return false;
            }
        }

        if (!validatorClass.EmptyRadioButton(this, bi.kbc19, bi.kbc19a, getString(R.string.kbc19))) {
            return false;
        }
        if (bi.kbc19b.isChecked()) {
            if (!validatorClass.EmptyTextBox(this, bi.kbc19hr, getString(R.string.hours))) {
                return false;
            }
        } else if (bi.kbc19c.isChecked()) {
            if (!validatorClass.EmptyTextBox(this, bi.kbc19day, getString(R.string.days))) {
                return false;
            }
        }


        return true;
    }


    private void SaveDraft() throws JSONException {

        JSONObject sC3 = new JSONObject();

        sC3.put("kbc01", bi.kbc01a.isChecked() ? "1"
                : bi.kbc01b.isChecked() ? "2"
                : bi.kbc01c.isChecked() ? "3"
                : bi.kbc01d.isChecked() ? "4"
                : bi.kbc01e.isChecked() ? "5"
                : bi.kbc01f.isChecked() ? "6"
                : bi.kbc01g.isChecked() ? "7"
                : bi.kbc0198.isChecked() ? "98"
                : bi.kbc0196.isChecked() ? "96"
                : "0");

        sC3.put("kbc0196x", bi.kbc0196x.getText().toString());


        sC3.put("kbc02", bi.kbc02a.isChecked() ? "1"
                : bi.kbc02b.isChecked() ? "2" : bi.kbc0298.isChecked() ? "98"
                : "0");

        sC3.put("kbc03", bi.kbc03a.isChecked() ? "1"
                : bi.kbc03b.isChecked() ? "2"
                : bi.kbc03c.isChecked() ? "3"
                : bi.kbc03d.isChecked() ? "4"
                : bi.kbc03e.isChecked() ? "5"
                : bi.kbc03f.isChecked() ? "6"
                : bi.kbc03g.isChecked() ? "7"
                : bi.kbc03h.isChecked() ? "8"
                : bi.kbc03i.isChecked() ? "9"
                : bi.kbc0396.isChecked() ? "96"
                : "0");

        sC3.put("kbc0396x", bi.kbc0396x.getText().toString());

        sC3.put("kbc04", bi.kbc04a.isChecked() ? "1"
                : bi.kbc04b.isChecked() ? "2"
                : bi.kbc04c.isChecked() ? "3"
                : bi.kbc04d.isChecked() ? "4"
                : bi.kbc04e.isChecked() ? "5"
                : bi.kbc04f.isChecked() ? "6"
                : bi.kbc04g.isChecked() ? "7"
                : bi.kbc04h.isChecked() ? "8"
                : bi.kbc0498.isChecked() ? "98"
                : bi.kbc0496.isChecked() ? "96"
                : "0");

        sC3.put("kbc0496x", bi.kbc0496x.getText().toString());

        sC3.put("kbc05", bi.kbc05a.isChecked() ? "1"
                : bi.kbc05b.isChecked() ? "2" : bi.kbc0598.isChecked() ? "98"
                : "0");

        sC3.put("kbc06", bi.kbc06a.isChecked() ? "1"
                : bi.kbc06b.isChecked() ? "2" : "0");

        sC3.put("kbc06kg", bi.kbc06kg.getText().toString());

        sC3.put("kbc07", bi.kbc07rec.getText().toString());

        sC3.put("kbc08", bi.kbc08a.isChecked() ? "1"
                : bi.kbc08b.isChecked() ? "2"
                : bi.kbc08c.isChecked() ? "3"
                : bi.kbc08d.isChecked() ? "4"
                : bi.kbc08e.isChecked() ? "5"
                : bi.kbc0898.isChecked() ? "98"
                : "0");

       /* sC3.put("kbc09", bi.kbc08a.isChecked() ? "1"
                : bi.kbc08b.isChecked() ? "2"
                : bi.kbc0898.isChecked() ? "98"
                : "0");*/

        sC3.put("kbc09", bi.kbc09a.isChecked() ? "1"
                : bi.kbc09b.isChecked() ? "2"
                : bi.kbc0998.isChecked() ? "98"
                : "0");
        sC3.put("kbc10", bi.kbc10a.isChecked() ? "1"
                : bi.kbc10b.isChecked() ? "2"
                : bi.kbc10c.isChecked() ? "3"
                : bi.kbc10d.isChecked() ? "4"
                : "0");


        sC3.put("kbc11", bi.kbc11a.isChecked() ? "1"
                : bi.kbc11b.isChecked() ? "2"

                : bi.kbc1198.isChecked() ? "98"
                : "0");

        sC3.put("kbc12", bi.kbc12a.isChecked() ? "1"
                : bi.kbc12b.isChecked() ? "2"
                : bi.kbc12c.isChecked() ? "3"
                : bi.kbc1296.isChecked() ? "96"
                : bi.kbc1298.isChecked() ? "98"
                : "0");

        sC3.put("kbc1296x", bi.kbc1296x.getText().toString());

        sC3.put("kbc13", bi.kbc13a.isChecked() ? "1"
                : bi.kbc13b.isChecked() ? "2"
                : bi.kbc1398.isChecked() ? "98"
                : "0");


        sC3.put("kbc14", bi.kbc14a.isChecked() ? "1"
                : bi.kbc14b.isChecked() ? "2"
                : bi.kbc1498.isChecked() ? "98"
                : "0");


        sC3.put("kbc15", bi.kbc15a.isChecked() ? "1"
                : bi.kbc15b.isChecked() ? "2"
                : bi.kbc1598.isChecked() ? "98"
                : "0");
        sC3.put("kbc16", bi.kbc16a.isChecked() ? "1"
                : bi.kbc16b.isChecked() ? "2"
                : bi.kbc16c.isChecked() ? "3"
                : bi.kbc16d.isChecked() ? "4"
                : bi.kbc1696.isChecked() ? "96"
                : "0");
        sC3.put("kbc1696x", bi.kbc1696x.getText().toString());


        sC3.put("kbc17", bi.kbc17a.isChecked() ? "1"
                : bi.kbc17b.isChecked() ? "2"
                : bi.kbc1798.isChecked() ? "98"
                : "0");

        sC3.put("kbc18a", bi.kbc18a.isChecked() ? "1" : "0");
        sC3.put("kbc18b", bi.kbc18b.isChecked() ? "2" : "0");
        sC3.put("kbc18c", bi.kbc18c.isChecked() ? "3" : "0");
        sC3.put("kbc18d", bi.kbc18d.isChecked() ? "4" : "0");
        sC3.put("kbc18e", bi.kbc18e.isChecked() ? "5" : "0");
        sC3.put("kbc18f", bi.kbc18f.isChecked() ? "6" : "0");
        sC3.put("kbc1896", bi.kbc18f.isChecked() ? "96" : "0");
        sC3.put("kbc1898", bi.kbc18f.isChecked() ? "98" : "0");

        sC3.put("kbc1896x", bi.kbc1896x.getText().toString());

        sC3.put("kbc19", bi.kbc19a.isChecked() ? "1"
                : bi.kbc19b.isChecked() ? "2"
                : bi.kbc19c.isChecked() ? "3"
                : bi.kbc19d.isChecked() ? "4"
                : bi.kbc1998.isChecked() ? "98"
                : "0");
        sC3.put("kbc19hr", bi.kbc19hr.getText().toString());
        sC3.put("kbc19day", bi.kbc19day.getText().toString());


        MainApp.fc.setsb3(String.valueOf(sC3));
    }

    private boolean UpdateDB() {
        //Long rowId;
        DatabaseHelper db = new DatabaseHelper(this);

        int updcount = db.updateSB3();

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