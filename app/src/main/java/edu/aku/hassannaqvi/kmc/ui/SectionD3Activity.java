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

import java.text.SimpleDateFormat;
import java.util.Date;

import edu.aku.hassannaqvi.kmc.R;
import edu.aku.hassannaqvi.kmc.core.DatabaseHelper;
import edu.aku.hassannaqvi.kmc.core.MainApp;
import edu.aku.hassannaqvi.kmc.databinding.ActivitySectionD3Binding;
import edu.aku.hassannaqvi.kmc.validation.validatorClass;

public class SectionD3Activity extends AppCompatActivity {

    private static final String TAG = SectionD3Activity.class.getName();
    String dtToday = new SimpleDateFormat("dd-MM-yy HH:mm").format(new Date().getTime());

    ActivitySectionD3Binding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_section_d3);

        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_d3);
        bi.setCallback(this);
        setupViews();
    }


    private void setupViews() {

        /*bi.kd30298.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {

                    bi.kd302a.setChecked(false);
                    bi.kd302b.setChecked(false);
                    bi.kd302c.setChecked(false);
                    bi.kd302d.setChecked(false);
                    bi.kd302e.setChecked(false);
                    bi.kd302f.setChecked(false);
                    bi.kd302g.setChecked(false);
                    bi.kd302h.setChecked(false);
                    bi.kd302i.setChecked(false);
                    bi.kd302j.setChecked(false);
                    bi.kd30296.setChecked(false);
                    bi.kd30298.setChecked(false);
                    bi.kd30296x.setText(null);

                    bi.kd303.clearCheck();
                    bi.kd30396x.setText(null);

                    bi.fldGrpkd301.setVisibility(View.GONE);
                } else {
                    bi.fldGrpkd301.setVisibility(View.VISIBLE);
                }
            }
        });*/


        bi.kd301.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (bi.kd301b.isChecked()) {

                    bi.kd302a.setChecked(false);
                    bi.kd302b.setChecked(false);
                    bi.kd302c.setChecked(false);
                    bi.kd302d.setChecked(false);
                    bi.kd302e.setChecked(false);
                    bi.kd302f.setChecked(false);
                    bi.kd302g.setChecked(false);
                    bi.kd302h.setChecked(false);
                    bi.kd302i.setChecked(false);
                    bi.kd302j.setChecked(false);
                    bi.kd30298.setChecked(false);
                    bi.kd30296.setChecked(false);
                    bi.kd30296x.setText(null);

                    bi.fldGrpkd301.setVisibility(View.GONE);
                } else {
                    bi.fldGrpkd301.setVisibility(View.VISIBLE);
                }
            }
        });


        bi.kd302g.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    bi.fldGrpkd303.setVisibility(View.VISIBLE);
                } else {
                    bi.fldGrpkd303.setVisibility(View.GONE);
                    bi.kd303.clearCheck();
                    bi.kd30396x.setText(null);
                }
            }
        });


        bi.kd30298.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    bi.kd302a.setChecked(false);
                    bi.kd302b.setChecked(false);
                    bi.kd302c.setChecked(false);
                    bi.kd302d.setChecked(false);
                    bi.kd302e.setChecked(false);
                    bi.kd302f.setChecked(false);
                    bi.kd302g.setChecked(false);
                    bi.kd302h.setChecked(false);
                    bi.kd302i.setChecked(false);
                    bi.kd302j.setChecked(false);
                    bi.kd30296.setChecked(false);
                    bi.kd302a.setEnabled(false);
                    bi.kd302b.setEnabled(false);
                    bi.kd302c.setEnabled(false);
                    bi.kd302d.setEnabled(false);
                    bi.kd302e.setEnabled(false);
                    bi.kd302f.setEnabled(false);
                    bi.kd302g.setEnabled(false);
                    bi.kd302h.setEnabled(false);
                    bi.kd302i.setEnabled(false);
                    bi.kd302j.setEnabled(false);
                    bi.kd30296.setEnabled(false);

                    bi.kd30296x.setText(null);
                    bi.kd30296x.setVisibility(View.GONE);
                } else {
                    bi.kd302a.setEnabled(true);
                    bi.kd302b.setEnabled(true);
                    bi.kd302c.setEnabled(true);
                    bi.kd302d.setEnabled(true);
                    bi.kd302e.setEnabled(true);
                    bi.kd302f.setEnabled(true);
                    bi.kd302g.setEnabled(true);
                    bi.kd302h.setEnabled(true);
                    bi.kd302i.setEnabled(true);
                    bi.kd302j.setEnabled(true);
                    bi.kd30296.setEnabled(true);
                }
            }
        });


        bi.kd302j.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (bi.kd302j.isChecked()) {
                    bi.kd302a.setChecked(false);
                    bi.kd302b.setChecked(false);
                    bi.kd302c.setChecked(false);
                    bi.kd302d.setChecked(false);
                    bi.kd302e.setChecked(false);
                    bi.kd302f.setChecked(false);
                    bi.kd302g.setChecked(false);
                    bi.kd302h.setChecked(false);
                    bi.kd302i.setChecked(false);
                    bi.kd30296.setChecked(false);
                    bi.kd302a.setEnabled(false);
                    bi.kd302b.setEnabled(false);
                    bi.kd302c.setEnabled(false);
                    bi.kd302d.setEnabled(false);
                    bi.kd302e.setEnabled(false);
                    bi.kd302f.setEnabled(false);
                    bi.kd302g.setEnabled(false);
                    bi.kd302h.setEnabled(false);
                    bi.kd302i.setEnabled(false);
                    bi.kd30296.setEnabled(false);
                    bi.kd30298.setEnabled(false);

                    bi.kd30296x.setText(null);
                    bi.kd30296x.setVisibility(View.GONE);
                } else {
                    bi.kd302a.setEnabled(true);
                    bi.kd302b.setEnabled(true);
                    bi.kd302c.setEnabled(true);
                    bi.kd302d.setEnabled(true);
                    bi.kd302e.setEnabled(true);
                    bi.kd302f.setEnabled(true);
                    bi.kd302g.setEnabled(true);
                    bi.kd302h.setEnabled(true);
                    bi.kd302i.setEnabled(true);
                    bi.kd30296.setEnabled(true);
                    bi.kd30298.setEnabled(true);
                }
            }
        });


        bi.kd304c.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    bi.fldGrpkd305.setVisibility(View.GONE);
                    bi.kd305.clearCheck();
                } else {
                    bi.fldGrpkd305.setVisibility(View.VISIBLE);
                }
            }
        });


    }


    private void SaveDraft() throws JSONException {

        JSONObject sD3 = new JSONObject();

        sD3.put("kd301", bi.kd301a.isChecked() ? "1"
                : bi.kd301b.isChecked() ? "2"
                : bi.kd30198.isChecked() ? "98"
                : "0");

        sD3.put("kd301wk", bi.kd301wk.getText().toString());
        sD3.put("kd301mon", bi.kd301mon.getText().toString());
        sD3.put("kd301yr", bi.kd301yr.getText().toString());


        sD3.put("kd302a", bi.kd302a.isChecked() ? "1" : "0");
        sD3.put("kd302b", bi.kd302b.isChecked() ? "2" : "0");
        sD3.put("kd302c", bi.kd302c.isChecked() ? "3" : "0");
        sD3.put("kd302d", bi.kd302d.isChecked() ? "4" : "0");
        sD3.put("kd302e", bi.kd302e.isChecked() ? "5" : "0");
        sD3.put("kd302f", bi.kd302f.isChecked() ? "6" : "0");
        sD3.put("kd302g", bi.kd302g.isChecked() ? "7" : "0");
        sD3.put("kd302h", bi.kd302h.isChecked() ? "8" : "0");
        sD3.put("kd302i", bi.kd302i.isChecked() ? "9" : "0");
        sD3.put("kd302j", bi.kd302j.isChecked() ? "10" : "0");
        sD3.put("kd30296", bi.kd30296.isChecked() ? "96" : "0");
        sD3.put("kd30298", bi.kd30298.isChecked() ? "98" : "0");

        sD3.put("kd30296x", bi.kd30296x.getText().toString());


        sD3.put("kd303", bi.kd303a.isChecked() ? "1"
                : bi.kd303b.isChecked() ? "2"
                : bi.kd303c.isChecked() ? "3"
                : bi.kd30396.isChecked() ? "96"
                : bi.kd30398.isChecked() ? "98"
                : "0");
        sD3.put("kd30396x", bi.kd30396x.getText().toString());


        sD3.put("kd304", bi.kd304a.isChecked() ? "1"
                : bi.kd304c.isChecked() ? "3"
                : bi.kd30498.isChecked() ? "98" : "0");

        sD3.put("kd304m", bi.kd304m.getText().toString());
        sD3.put("kd304y", bi.kd304y.getText().toString());


        sD3.put("kd305", bi.kd305a.isChecked() ? "1"
                : bi.kd305b.isChecked() ? "2"
                : bi.kd305c.isChecked() ? "3"
                : bi.kd305d.isChecked() ? "4"
                : bi.kd305e.isChecked() ? "5"
                : bi.kd305f.isChecked() ? "6"
                : bi.kd305g.isChecked() ? "7"
                : bi.kd30596.isChecked() ? "96"
                : bi.kd30598.isChecked() ? "98"
                : "0");
        sD3.put("kd30596x", bi.kd30596x.getText().toString());

        MainApp.fc.setsD3(String.valueOf(sD3));

    }


    private boolean formValidation() {


        if (!validatorClass.EmptyRadioButton(this, bi.kd301, bi.kd301a, getString(R.string.kd301))) {
            return false;
        }


        if (bi.kd301a.isChecked()) {

            if (!validatorClass.EmptyTextBox(this, bi.kd301wk, getString(R.string.weeks))) {
                return false;
            }


            if (!validatorClass.RangeTextBox(this, bi.kd301wk, 0, 3, getString(R.string.weeks), "Weeks")) {
                return false;
            }


            if (!validatorClass.EmptyTextBox(this, bi.kd301mon, getString(R.string.months))) {
                return false;
            }


            if (!validatorClass.RangeTextBox(this, bi.kd301mon, 0, 11, getString(R.string.months), "Months")) {
                return false;
            }


            if (!validatorClass.EmptyTextBox(this, bi.kd301yr, getString(R.string.years))) {
                return false;
            }


            if (!validatorClass.RangeTextBox(this, bi.kd301yr, 0, 2, getString(R.string.years), "Years")) {
                return false;
            }

        }


        if (!bi.kd301b.isChecked()) {

            if (!validatorClass.EmptyCheckBox(this, bi.kd302, bi.kd30296, bi.kd30296x, getString(R.string.kd302))) {
                return false;
            }

            if (bi.kd302g.isChecked()) {
                if (!validatorClass.EmptyRadioButton(this, bi.kd303, bi.kd30396, bi.kd30396x, getString(R.string.kd303))) {
                    return false;
                }
            }
        }

        if (!validatorClass.EmptyRadioButton(this, bi.kd304, bi.kd304a, getString(R.string.kd304))) {
            return false;
        }

        if (bi.kd304a.isChecked()) {

            if (!validatorClass.EmptyTextBox(this, bi.kd304m, getString(R.string.months))) {
                return false;
            }


            if (!validatorClass.RangeTextBox(this, bi.kd304m, 0, 11, getString(R.string.months), "Months")) {
                return false;
            }


            if (!validatorClass.EmptyTextBox(this, bi.kd304y, getString(R.string.years))) {
                return false;
            }


            if (!validatorClass.RangeTextBox(this, bi.kd304y, 0, 2, getString(R.string.years), "Years")) {
                return false;
            }

        }


        if (!bi.kd304c.isChecked()) {

            if (!validatorClass.EmptyRadioButton(this, bi.kd305, bi.kd30596, bi.kd30596x, getString(R.string.kd305))) {
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

                startActivity(new Intent(this, SectionEActivity.class));
                //startActivity(new Intent(this, MainActivity.class));

            } else {
                Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
            }
        }
    }


    private boolean UpdateDB() {

        //Long rowId;
        DatabaseHelper db = new DatabaseHelper(this);

        int updcount = db.updateSD3();

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