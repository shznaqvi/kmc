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
import edu.aku.hassannaqvi.kmc.databinding.ActivitySectionB3PncBinding;
import edu.aku.hassannaqvi.kmc.validation.validatorClass;

public class SectionB3_PNCActivity extends AppCompatActivity {

    ActivitySectionB3PncBinding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_section_b3_pnc);

        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_b3_pnc);
        bi.setCallback(this);


        bi.kbca01.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (bi.kbca01a.isChecked()) {
                    bi.fldGrpkbca02.setVisibility(View.VISIBLE);
                } else {
                    bi.fldGrpkbca02.setVisibility(View.GONE);
                    bi.kbca02.clearCheck();
                    bi.kbca02day.setText(null);
                    bi.kbca02week.setText(null);
                    bi.kbca03.clearCheck();
                    bi.kbca03times.setText(null);

                    bi.kbca04a.setChecked(false);
                    bi.kbca04b.setChecked(false);
                    bi.kbca04c.setChecked(false);
                    bi.kbca04d.setChecked(false);
                    bi.kbca04e.setChecked(false);
                    bi.kbca04f.setChecked(false);
                    bi.kbca04g.setChecked(false);
                    bi.kbca04h.setChecked(false);
                    bi.kbca04i.setChecked(false);
                    bi.kbca04j.setChecked(false);
                    bi.kbca04k.setChecked(false);
                    bi.kbca04l.setChecked(false);
                    bi.kbca04m.setChecked(false);
                    bi.kbca0498.setChecked(false);
                    bi.kbca0496.setChecked(false);
                    bi.kbca0496x.setText(null);

                }
            }
        });
        bi.kbca0498.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    bi.kbca04a.setChecked(false);
                    bi.kbca04b.setChecked(false);
                    bi.kbca04c.setChecked(false);
                    bi.kbca04d.setChecked(false);
                    bi.kbca04e.setChecked(false);
                    bi.kbca04f.setChecked(false);
                    bi.kbca04g.setChecked(false);
                    bi.kbca04h.setChecked(false);
                    bi.kbca04i.setChecked(false);
                    bi.kbca04j.setChecked(false);
                    bi.kbca04k.setChecked(false);
                    bi.kbca04l.setChecked(false);
                    bi.kbca04m.setChecked(false);
                    bi.kbca0496.setChecked(false);
                    bi.kbca04a.setEnabled(false);
                    bi.kbca04b.setEnabled(false);
                    bi.kbca04c.setEnabled(false);
                    bi.kbca04d.setEnabled(false);
                    bi.kbca04e.setEnabled(false);
                    bi.kbca04f.setEnabled(false);
                    bi.kbca04g.setEnabled(false);
                    bi.kbca04h.setEnabled(false);
                    bi.kbca04i.setEnabled(false);
                    bi.kbca04j.setEnabled(false);
                    bi.kbca04k.setEnabled(false);
                    bi.kbca04l.setEnabled(false);
                    bi.kbca04m.setEnabled(false);
                    bi.kbca0496.setEnabled(false);
                } else {
                    bi.kbca04a.setEnabled(true);
                    bi.kbca04b.setEnabled(true);
                    bi.kbca04c.setEnabled(true);
                    bi.kbca04d.setEnabled(true);
                    bi.kbca04e.setEnabled(true);
                    bi.kbca04f.setEnabled(true);
                    bi.kbca04g.setEnabled(true);
                    bi.kbca04h.setEnabled(true);
                    bi.kbca04i.setEnabled(true);
                    bi.kbca04j.setEnabled(true);
                    bi.kbca04k.setEnabled(true);
                    bi.kbca04l.setEnabled(true);
                    bi.kbca04m.setEnabled(true);
                    bi.kbca0496.setEnabled(true);
                }
            }
        });


        bi.kbcb01.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (bi.kbcb01a.isChecked()) {
                    bi.fldGrpkbcb02.setVisibility(View.VISIBLE);
                } else {
                    bi.fldGrpkbcb02.setVisibility(View.GONE);
                    bi.kbcb02.clearCheck();
                    bi.kbcb02day.setText(null);
                    bi.kbcb02week.setText(null);
                    bi.kbcb03times.setText(null);
                    bi.kbcb03.clearCheck();
                    bi.kbcb04.clearCheck();
                    bi.kbcb0496x.setText(null);
                    bi.kbcb05a.setChecked(false);
                    bi.kbcb05b.setChecked(false);
                    bi.kbcb05c.setChecked(false);
                    bi.kbcb05d.setChecked(false);
                    bi.kbcb05e.setChecked(false);
                    bi.kbcb05f.setChecked(false);
                    bi.kbcb05g.setChecked(false);
                    bi.kbcb05h.setChecked(false);
                    bi.kbcb0598.setChecked(false);
                    bi.kbcb0596.setChecked(false);
                    bi.kbcb0596x.setText(null);

                }
            }
        });
        bi.kbcb0598.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    bi.kbcb05a.setChecked(false);
                    bi.kbcb05b.setChecked(false);
                    bi.kbcb05c.setChecked(false);
                    bi.kbcb05d.setChecked(false);
                    bi.kbcb05e.setChecked(false);
                    bi.kbcb05f.setChecked(false);
                    bi.kbcb05g.setChecked(false);
                    bi.kbcb05h.setChecked(false);
                    bi.kbcb0596.setChecked(false);
                    bi.kbcb05a.setEnabled(false);
                    bi.kbcb05b.setEnabled(false);
                    bi.kbcb05c.setEnabled(false);
                    bi.kbcb05d.setEnabled(false);
                    bi.kbcb05e.setEnabled(false);
                    bi.kbcb05f.setEnabled(false);
                    bi.kbcb05g.setEnabled(false);
                    bi.kbcb05h.setEnabled(false);
                    bi.kbcb0596.setEnabled(false);
                } else {
                    bi.kbcb05a.setEnabled(true);
                    bi.kbcb05b.setEnabled(true);
                    bi.kbcb05c.setEnabled(true);
                    bi.kbcb05d.setEnabled(true);
                    bi.kbcb05e.setEnabled(true);
                    bi.kbcb05f.setEnabled(true);
                    bi.kbcb05g.setEnabled(true);
                    bi.kbcb05h.setEnabled(true);
                    bi.kbcb0596.setEnabled(true);
                }
            }
        });

        bi.kbcc01.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (bi.kbcc01a.isChecked()) {
                    bi.fldGrpkbcc02.setVisibility(View.VISIBLE);
                } else {
                    bi.fldGrpkbcc02.setVisibility(View.GONE);
                    bi.kbcc02a.setChecked(false);
                    bi.kbcc02b.setChecked(false);
                    bi.kbcc02c.setChecked(false);
                    bi.kbcc02d.setChecked(false);
                    bi.kbcc02e.setChecked(false);
                    bi.kbcc02f.setChecked(false);
                    bi.kbcc02g.setChecked(false);
                    bi.kbcc02h.setChecked(false);
                    bi.kbcc0296.setChecked(false);
                    bi.kbcc0298.setChecked(false);
                    bi.kbcc0296x.setText(null);
                }
            }
        });
        bi.kbcc0298.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    bi.kbcc02a.setChecked(false);
                    bi.kbcc02b.setChecked(false);
                    bi.kbcc02c.setChecked(false);
                    bi.kbcc02d.setChecked(false);
                    bi.kbcc02e.setChecked(false);
                    bi.kbcc02f.setChecked(false);
                    bi.kbcc02g.setChecked(false);
                    bi.kbcc02h.setChecked(false);
                    bi.kbcc0296.setChecked(false);
                    bi.kbcc02a.setEnabled(false);
                    bi.kbcc02a.setEnabled(false);
                    bi.kbcc02b.setEnabled(false);
                    bi.kbcc02c.setEnabled(false);
                    bi.kbcc02d.setEnabled(false);
                    bi.kbcc02e.setEnabled(false);
                    bi.kbcc02f.setEnabled(false);
                    bi.kbcc02g.setEnabled(false);
                    bi.kbcc02h.setEnabled(false);
                    bi.kbcc0296.setEnabled(false);

                } else {

                    bi.kbcc02a.setEnabled(true);
                    bi.kbcc02a.setEnabled(true);
                    bi.kbcc02b.setEnabled(true);
                    bi.kbcc02c.setEnabled(true);
                    bi.kbcc02d.setEnabled(true);
                    bi.kbcc02e.setEnabled(true);
                    bi.kbcc02f.setEnabled(true);
                    bi.kbcc02g.setEnabled(true);
                    bi.kbcc02h.setEnabled(true);
                    bi.kbcc0296.setEnabled(true);
                }
            }
        });


    }


    public boolean ValidateForm() {

        if (!validatorClass.EmptyRadioButton(this, bi.kbca01, bi.kbca01a, getString(R.string.kbca01))) {
            return false;
        }

        if (bi.kbca01a.isChecked()) {
            if (!validatorClass.EmptyRadioButton(this, bi.kbca02, bi.kbca02a, getString(R.string.kbca02))) {
                return false;
            }
            if (bi.kbca02a.isChecked()) {
                if (!validatorClass.EmptyTextBox(this, bi.kbca02day, getString(R.string.days))) {
                    return false;
                }
                if (!validatorClass.RangeTextBox(this, bi.kbca02day, 0, 6, getString(R.string.kbca02), " days")) {
                    return false;
                }
            }
            if (bi.kbca02b.isChecked()) {
                if (!validatorClass.EmptyTextBox(this, bi.kbca02week, getString(R.string.weeks))) {
                    return false;
                }
                if (!validatorClass.RangeTextBox(this, bi.kbca02week, 0, 7, getString(R.string.kbca02), " weeks")) {
                    return false;
                }
            }

            if (!validatorClass.EmptyRadioButton(this, bi.kbca03, bi.kbca03a, bi.kbca03times, getString(R.string.kbca03))) {
                return false;
            }
            if (bi.kbca03a.isChecked()) {
                if (!validatorClass.RangeTextBox(this, bi.kbca03times, 1, 10, getString(R.string.kbca03), " times")) {
                    return false;
                }
            }


            if (!validatorClass.EmptyCheckBox(this, bi.kbca04, bi.kbca0496, bi.kbca0496x, getString(R.string.kbca04))) {
                return false;
            }
            if (bi.kbca04d.isChecked()) {

                if (!validatorClass.EmptyTextBox(this, bi.kbca04dx, getString(R.string.kbca04))) {
                    return false;
                }

            }
        }

        if (!validatorClass.EmptyRadioButton(this, bi.kbcb01, bi.kbcb01a, getString(R.string.kbcb01))) {
            return false;
        }

        if (bi.kbcb01a.isChecked()) {
            if (!validatorClass.EmptyRadioButton(this, bi.kbcb02, bi.kbcb02a, getString(R.string.kbcb02))) {
                return false;
            }
            if (bi.kbcb02a.isChecked()) {
                if (!validatorClass.EmptyTextBox(this, bi.kbcb02day, getString(R.string.days))) {
                    return false;
                }
                if (!validatorClass.RangeTextBox(this, bi.kbcb02day, 0, 6, getString(R.string.kbcb02), " days")) {
                    return false;
                }
            }
            if (bi.kbcb02b.isChecked()) {
                if (!validatorClass.EmptyTextBox(this, bi.kbcb02week, getString(R.string.weeks))) {
                    return false;
                }
                if (!validatorClass.RangeTextBox(this, bi.kbcb02week, 0, 7, getString(R.string.kbcb02), " weeks")) {
                    return false;
                }
            }

            if (!validatorClass.EmptyRadioButton(this, bi.kbcb03, bi.kbcb03a, bi.kbcb03times, getString(R.string.kbcb03))) {
                return false;
            }
            if (bi.kbcb03a.isChecked()) {
                if (!validatorClass.RangeTextBox(this, bi.kbcb03times, 1, 5, getString(R.string.kbcb03), " times")) {
                    return false;
                }
            }


            if (!validatorClass.EmptyRadioButton(this, bi.kbcb04, bi.kbcb0496, bi.kbcb0496x, getString(R.string.kbcb04))) {
                return false;
            }

            if (!validatorClass.EmptyCheckBox(this, bi.kbcb05, bi.kbcb0596, bi.kbcb0596x, getString(R.string.kbcb05))) {
                return false;
            }

        }

        if (!validatorClass.EmptyRadioButton(this, bi.kbcc01, bi.kbcc01a, getString(R.string.kbcc01))) {
            return false;
        }

        if (bi.kbcc01a.isChecked()) {
            if (!validatorClass.EmptyCheckBox(this, bi.kbcc02, bi.kbcc0296, bi.kbcc0296x, getString(R.string.kbcc02))) {
                return false;
            }
        }
        return true;
    }


    private void SaveDraft() throws JSONException {
        Toast.makeText(this, "Saving Draft for  This Section", Toast.LENGTH_SHORT).show();

        JSONObject sn = new JSONObject();


        sn.put("kbca01", bi.kbca01a.isChecked() ? "1"
                : bi.kbca01b.isChecked() ? "2"
                : "0");
        sn.put("kbca02", bi.kbca02a.isChecked() ? "1"
                : bi.kbca02b.isChecked() ? "2"
                : bi.kbca0298.isChecked() ? "98"
                : "0");
        sn.put("kbca02day", bi.kbca02day.getText().toString());
        sn.put("kbca02week", bi.kbca02week.getText().toString());


        sn.put("kbca03", bi.kbca03a.isChecked() ? "1"
                : bi.kbca0398.isChecked() ? "98"
                : "0");
        sn.put("kbca03times", bi.kbca03times.getText().toString());


        sn.put("kbca04a", bi.kbca04a.isChecked() ? "1" : "0");
        sn.put("kbca04b", bi.kbca04b.isChecked() ? "2" : "0");
        sn.put("kbca04c", bi.kbca04c.isChecked() ? "3" : "0");
        sn.put("kbca04d", bi.kbca04d.isChecked() ? "4" : "0");
        sn.put("kbca04dx", bi.kbca04dx.getText().toString());
        sn.put("kbca04e", bi.kbca04e.isChecked() ? "5" : "0");
        sn.put("kbca04f", bi.kbca04f.isChecked() ? "6" : "0");
        sn.put("kbca04g", bi.kbca04g.isChecked() ? "7" : "0");
        sn.put("kbca04h", bi.kbca04h.isChecked() ? "8" : "0");
        sn.put("kbca04i", bi.kbca04i.isChecked() ? "9" : "0");
        sn.put("kbca04j", bi.kbca04j.isChecked() ? "10" : "0");
        sn.put("kbca04k", bi.kbca04k.isChecked() ? "11" : "0");
        sn.put("kbca04l", bi.kbca04l.isChecked() ? "12" : "0");
        sn.put("kbca04m", bi.kbca04m.isChecked() ? "13" : "0");
        sn.put("kbca0496", bi.kbca0496.isChecked() ? "96" : "0");
        sn.put("kbca0498", bi.kbca0498.isChecked() ? "98" : "0");
        sn.put("kbca0496x", bi.kbca0496x.getText().toString());

        sn.put("kbcb01", bi.kbcb01a.isChecked() ? "1"
                : bi.kbcb01b.isChecked() ? "2"
                : bi.kbcb0198.isChecked() ? "98"
                : "0");


        sn.put("kbcb02", bi.kbcb02a.isChecked() ? "1"
                : bi.kbcb02b.isChecked() ? "2"
                : bi.kbcb0298.isChecked() ? "98"
                : "0");
        sn.put("kbcb02day", bi.kbcb02day.getText().toString());
        sn.put("kbcb02week", bi.kbcb02week.getText().toString());


        sn.put("kbcb03", bi.kbcb03a.isChecked() ? "1"
                : bi.kbcb0398.isChecked() ? "98"
                : "0");
        sn.put("kbcb03times", bi.kbcb03times.getText().toString());


        sn.put("kbcb04", bi.kbcb04a.isChecked() ? "1"
                : bi.kbcb04b.isChecked() ? "2"
                : bi.kbcb04c.isChecked() ? "3"
                : bi.kbcb04d.isChecked() ? "4"
                : bi.kbcb04e.isChecked() ? "5"
                : bi.kbcb04f.isChecked() ? "6"
                : bi.kbcb04g.isChecked() ? "7"
                : bi.kbcb04h.isChecked() ? "8"
                : bi.kbcb0498.isChecked() ? "98"
                : bi.kbcb0496.isChecked() ? "96"
                : "0");

        sn.put("kbcb0496x", bi.kbcb0496x.getText().toString());

        sn.put("kbcb05a", bi.kbcb05a.isChecked() ? "1" : "0");
        sn.put("kbcb05b", bi.kbcb05b.isChecked() ? "2" : "0");
        sn.put("kbcb05c", bi.kbcb05c.isChecked() ? "3" : "0");
        sn.put("kbcb05d", bi.kbcb05d.isChecked() ? "4" : "0");
        sn.put("kbcb05e", bi.kbcb05e.isChecked() ? "5" : "0");
        sn.put("kbcb05f", bi.kbcb05f.isChecked() ? "6" : "0");
        sn.put("kbcb05g", bi.kbcb05g.isChecked() ? "7" : "0");
        sn.put("kbcb05h", bi.kbcb05h.isChecked() ? "8" : "0");
        sn.put("kbcb0598", bi.kbcb0598.isChecked() ? "98" : "0");
        sn.put("kbcb0596", bi.kbcb0596.isChecked() ? "96" : "0");
        sn.put("kbcb0596x", bi.kbcb0596x.getText().toString());

        sn.put("kbcc01", bi.kbcc01a.isChecked() ? "1"
                : bi.kbcc01b.isChecked() ? "2"
                : "0");

        sn.put("kbcc02a", bi.kbcc02a.isChecked() ? "1" : "0");
        sn.put("kbcc02b", bi.kbcc02b.isChecked() ? "2" : "0");
        sn.put("kbcc02c", bi.kbcc02c.isChecked() ? "3" : "0");
        sn.put("kbcc02d", bi.kbcc02d.isChecked() ? "4" : "0");
        sn.put("kbcc02e", bi.kbcc02e.isChecked() ? "5" : "0");
        sn.put("kbcc02f", bi.kbcc02f.isChecked() ? "6" : "0");
        sn.put("kbcc02g", bi.kbcc02g.isChecked() ? "7" : "0");
        sn.put("kbcc02h", bi.kbcc02h.isChecked() ? "8" : "0");
        sn.put("kbcc0298", bi.kbcc0298.isChecked() ? "98" : "0");
        sn.put("kbcc0296", bi.kbcc0296.isChecked() ? "96" : "0");
        sn.put("kbcc0296x", bi.kbcc0296x.getText().toString());

        MainApp.fc.setsb3_pnc(String.valueOf(sn));

        Toast.makeText(this, "Validation Successful! - Saving Draft...", Toast.LENGTH_SHORT).show();
    }

    private boolean UpdateDB() {
        DatabaseHelper db = new DatabaseHelper(this);

        int updcount = db.updateSB3_PNC();
        if (updcount == 1) {
            Toast.makeText(this, "Updating Database... Successful!", Toast.LENGTH_SHORT).show();
            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }

    }


    public void BtnEnd() {

        Toast.makeText(this, "Processing End Section", Toast.LENGTH_SHORT).show();
        //if (ValidateForm()) {
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

        if (ValidateForm()) {
            try {
                SaveDraft();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (UpdateDB()) {

                finish();

                startActivity(new Intent(this, SectionB4_2Activity.class));
                //                startActivity(new Intent(this, MainActivity.class));

            } else {
                Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void onBackPressed() {
        Toast.makeText(getApplicationContext(), "You Can't go back", Toast.LENGTH_LONG).show();
    }
}