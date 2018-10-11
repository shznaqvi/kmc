package edu.aku.hassannaqvi.kmc.ui;

import android.app.Activity;
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
import edu.aku.hassannaqvi.kmc.databinding.ActivitySectionB45Binding;
import edu.aku.hassannaqvi.kmc.validation.validatorClass;

public class SectionB4_5Activity extends AppCompatActivity {

    private static final String TAG = SectionB4_5Activity.class.getName();
    String dtToday = new SimpleDateFormat("dd-MM-yy HH:mm").format(new Date().getTime());

    ActivitySectionB45Binding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_section_b4_5);

        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_b4_5);
        bi.setCallback(this);
        setupViews();
    }


    private void setupViews() {

        /*bi.kbde0298.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {

                    bi.kbde02a.setChecked(false);
                    bi.kbde02b.setChecked(false);
                    bi.kbde02c.setChecked(false);
                    bi.kbde02d.setChecked(false);
                    bi.kbde02e.setChecked(false);
                    bi.kbde02f.setChecked(false);
                    bi.kbde02g.setChecked(false);
                    bi.kbde02h.setChecked(false);
                    bi.kbde02i.setChecked(false);
                    bi.kbde02j.setChecked(false);
                    bi.kbde0296.setChecked(false);
                    bi.kbde0298.setChecked(false);
                    bi.kbde0296x.setText(null);

                    bi.kbde03.clearCheck();
                    bi.kbde0396x.setText(null);

                    bi.fldGrpkbde01.setVisibility(View.GONE);
                } else {
                    bi.fldGrpkbde01.setVisibility(View.VISIBLE);
                }
            }
        });*/


        bi.kbde01.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (bi.kbde01b.isChecked()) {

                    bi.kbde02a.setChecked(false);
                    bi.kbde02b.setChecked(false);
                    bi.kbde02c.setChecked(false);
                    bi.kbde02d.setChecked(false);
                    bi.kbde02e.setChecked(false);
                    bi.kbde02f.setChecked(false);
                    bi.kbde02g.setChecked(false);
                    bi.kbde02h.setChecked(false);
                    bi.kbde02i.setChecked(false);
                    bi.kbde02j.setChecked(false);
                    bi.kbde0298.setChecked(false);
                    bi.kbde0296.setChecked(false);
                    bi.kbde0296x.setText(null);

                    bi.fldGrpkbde01.setVisibility(View.GONE);
                } else {
                    bi.fldGrpkbde01.setVisibility(View.VISIBLE);
                }
            }
        });


        bi.kbde02g.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    bi.fldGrpkbde03.setVisibility(View.VISIBLE);
                } else {
                    bi.fldGrpkbde03.setVisibility(View.GONE);
                    bi.kbde03.clearCheck();
                    bi.kbde0396x.setText(null);
                }
            }
        });


        bi.kbde0298.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    bi.kbde02a.setChecked(false);
                    bi.kbde02b.setChecked(false);
                    bi.kbde02c.setChecked(false);
                    bi.kbde02d.setChecked(false);
                    bi.kbde02e.setChecked(false);
                    bi.kbde02f.setChecked(false);
                    bi.kbde02g.setChecked(false);
                    bi.kbde02h.setChecked(false);
                    bi.kbde02i.setChecked(false);
                    bi.kbde02j.setChecked(false);
                    bi.kbde0296.setChecked(false);
                    bi.kbde02a.setEnabled(false);
                    bi.kbde02b.setEnabled(false);
                    bi.kbde02c.setEnabled(false);
                    bi.kbde02d.setEnabled(false);
                    bi.kbde02e.setEnabled(false);
                    bi.kbde02f.setEnabled(false);
                    bi.kbde02g.setEnabled(false);
                    bi.kbde02h.setEnabled(false);
                    bi.kbde02i.setEnabled(false);
                    bi.kbde02j.setEnabled(false);
                    bi.kbde0296.setEnabled(false);

                    bi.kbde0296x.setText(null);
                    bi.kbde0296x.setVisibility(View.GONE);
                } else {
                    bi.kbde02a.setEnabled(true);
                    bi.kbde02b.setEnabled(true);
                    bi.kbde02c.setEnabled(true);
                    bi.kbde02d.setEnabled(true);
                    bi.kbde02e.setEnabled(true);
                    bi.kbde02f.setEnabled(true);
                    bi.kbde02g.setEnabled(true);
                    bi.kbde02h.setEnabled(true);
                    bi.kbde02i.setEnabled(true);
                    bi.kbde02j.setEnabled(true);
                    bi.kbde0296.setEnabled(true);
                }
            }
        });


        bi.kbde02j.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (bi.kbde02j.isChecked()) {
                    bi.kbde02a.setChecked(false);
                    bi.kbde02b.setChecked(false);
                    bi.kbde02c.setChecked(false);
                    bi.kbde02d.setChecked(false);
                    bi.kbde02e.setChecked(false);
                    bi.kbde02f.setChecked(false);
                    bi.kbde02g.setChecked(false);
                    bi.kbde02h.setChecked(false);
                    bi.kbde02i.setChecked(false);
                    bi.kbde0296.setChecked(false);
                    bi.kbde02a.setEnabled(false);
                    bi.kbde02b.setEnabled(false);
                    bi.kbde02c.setEnabled(false);
                    bi.kbde02d.setEnabled(false);
                    bi.kbde02e.setEnabled(false);
                    bi.kbde02f.setEnabled(false);
                    bi.kbde02g.setEnabled(false);
                    bi.kbde02h.setEnabled(false);
                    bi.kbde02i.setEnabled(false);
                    bi.kbde0296.setEnabled(false);
                    bi.kbde0298.setEnabled(false);

                    bi.kbde0296x.setText(null);
                    bi.kbde0296x.setVisibility(View.GONE);
                } else {
                    bi.kbde02a.setEnabled(true);
                    bi.kbde02b.setEnabled(true);
                    bi.kbde02c.setEnabled(true);
                    bi.kbde02d.setEnabled(true);
                    bi.kbde02e.setEnabled(true);
                    bi.kbde02f.setEnabled(true);
                    bi.kbde02g.setEnabled(true);
                    bi.kbde02h.setEnabled(true);
                    bi.kbde02i.setEnabled(true);
                    bi.kbde0296.setEnabled(true);
                    bi.kbde0298.setEnabled(true);
                }
            }
        });


        bi.kbde04c.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    bi.fldGrpkbde05.setVisibility(View.GONE);
                    bi.kbde05.clearCheck();
                } else {
                    bi.fldGrpkbde05.setVisibility(View.VISIBLE);
                }
            }
        });


    }


    private void SaveDraft() throws JSONException {

        JSONObject sD3 = new JSONObject();

        sD3.put("kbde01", bi.kbde01a.isChecked() ? "1"
                : bi.kbde01b.isChecked() ? "2"
                : bi.kbde0198.isChecked() ? "98"
                : "0");

        sD3.put("kbde01wk", bi.kbde01wk.getText().toString());
        sD3.put("kbde01mon", bi.kbde01mon.getText().toString());
        sD3.put("kbde01yr", bi.kbde01yr.getText().toString());


        sD3.put("kbde02a", bi.kbde02a.isChecked() ? "1" : "0");
        sD3.put("kbde02b", bi.kbde02b.isChecked() ? "2" : "0");
        sD3.put("kbde02c", bi.kbde02c.isChecked() ? "3" : "0");
        sD3.put("kbde02d", bi.kbde02d.isChecked() ? "4" : "0");
        sD3.put("kbde02e", bi.kbde02e.isChecked() ? "5" : "0");
        sD3.put("kbde02f", bi.kbde02f.isChecked() ? "6" : "0");
        sD3.put("kbde02g", bi.kbde02g.isChecked() ? "7" : "0");
        sD3.put("kbde02h", bi.kbde02h.isChecked() ? "8" : "0");
        sD3.put("kbde02i", bi.kbde02i.isChecked() ? "9" : "0");
        sD3.put("kbde02j", bi.kbde02j.isChecked() ? "10" : "0");
        sD3.put("kbde0296", bi.kbde0296.isChecked() ? "96" : "0");
        sD3.put("kbde0298", bi.kbde0298.isChecked() ? "98" : "0");

        sD3.put("kbde0296x", bi.kbde0296x.getText().toString());


        sD3.put("kbde03", bi.kbde03a.isChecked() ? "1"
                : bi.kbde03b.isChecked() ? "2"
                : bi.kbde03c.isChecked() ? "3"
                : bi.kbde0396.isChecked() ? "96"
                : bi.kbde0398.isChecked() ? "98"
                : "0");
        sD3.put("kbde0396x", bi.kbde0396x.getText().toString());


        sD3.put("kbde04", bi.kbde04a.isChecked() ? "1"
                : bi.kbde04c.isChecked() ? "3"
                : bi.kbde0498.isChecked() ? "98" : "0");

        sD3.put("kbde04m", bi.kbde04m.getText().toString());
        sD3.put("kbde04y", bi.kbde04y.getText().toString());


        sD3.put("kbde05", bi.kbde05a.isChecked() ? "1"
                : bi.kbde05b.isChecked() ? "2"
                : bi.kbde05c.isChecked() ? "3"
                : bi.kbde05d.isChecked() ? "4"
                : bi.kbde05e.isChecked() ? "5"
                : bi.kbde05f.isChecked() ? "6"
                : bi.kbde05g.isChecked() ? "7"
                : bi.kbde0596.isChecked() ? "96"
                : bi.kbde0598.isChecked() ? "98"
                : "0");
        sD3.put("kbde0596x", bi.kbde0596x.getText().toString());

        MainApp.fc.setsb4_5(String.valueOf(sD3));

    }


    private boolean formValidation() {


        if (!validatorClass.EmptyRadioButton(this, bi.kbde01, bi.kbde01a, getString(R.string.kbde01))) {
            return false;
        }


        if (bi.kbde01a.isChecked()) {

            if (!validatorClass.EmptyTextBox(this, bi.kbde01wk, getString(R.string.weeks))) {
                return false;
            }


            if (!validatorClass.RangeTextBox(this, bi.kbde01wk, 0, 3, getString(R.string.weeks), "Weeks")) {
                return false;
            }


            if (!validatorClass.EmptyTextBox(this, bi.kbde01mon, getString(R.string.months))) {
                return false;
            }


            if (!validatorClass.RangeTextBox(this, bi.kbde01mon, 0, 11, getString(R.string.months), "Months")) {
                return false;
            }


            if (!validatorClass.EmptyTextBox(this, bi.kbde01yr, getString(R.string.years))) {
                return false;
            }


            if (!validatorClass.RangeTextBox(this, bi.kbde01yr, 0, 2, getString(R.string.years), "Years")) {
                return false;
            }

        }


        if (!bi.kbde01b.isChecked()) {

            if (!validatorClass.EmptyCheckBox(this, bi.kbde02, bi.kbde0296, bi.kbde0296x, getString(R.string.kbde02))) {
                return false;
            }

            if (bi.kbde02g.isChecked()) {
                if (!validatorClass.EmptyRadioButton(this, bi.kbde03, bi.kbde0396, bi.kbde0396x, getString(R.string.kbde03))) {
                    return false;
                }
            }
        }

        if (!validatorClass.EmptyRadioButton(this, bi.kbde04, bi.kbde04a, getString(R.string.kbde04))) {
            return false;
        }

        if (bi.kbde04a.isChecked()) {

            if (!validatorClass.EmptyTextBox(this, bi.kbde04m, getString(R.string.months))) {
                return false;
            }


            if (!validatorClass.RangeTextBox(this, bi.kbde04m, 0, 11, getString(R.string.months), "Months")) {
                return false;
            }


            if (!validatorClass.EmptyTextBox(this, bi.kbde04y, getString(R.string.years))) {
                return false;
            }


            if (!validatorClass.RangeTextBox(this, bi.kbde04y, 0, 2, getString(R.string.years), "Years")) {
                return false;
            }

        }


        if (!bi.kbde04c.isChecked()) {

            if (!validatorClass.EmptyRadioButton(this, bi.kbde05, bi.kbde0596, bi.kbde0596x, getString(R.string.kbde05))) {
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

                startActivity(new Intent(this, SectionB4Activity.class));
                //startActivity(new Intent(this, MainActivity.class));

            } else {
                Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
            }
        }
    }


    private boolean UpdateDB() {

        //Long rowId;
        DatabaseHelper db = new DatabaseHelper(this);

        int updcount = db.updateSB4_5();

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