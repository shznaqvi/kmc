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

import edu.aku.hassannaqvi.kmc.R;
import edu.aku.hassannaqvi.kmc.core.DatabaseHelper;
import edu.aku.hassannaqvi.kmc.core.MainApp;
import edu.aku.hassannaqvi.kmc.databinding.ActivitySectionB1Binding;
import edu.aku.hassannaqvi.kmc.other.DateTimeUtils;
import edu.aku.hassannaqvi.kmc.validation.validatorClass;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;


public class SectionB1Activity extends AppCompatActivity {

    ActivitySectionB1Binding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_b1);
        bi.setCallback(this);
        bi.kba09.setManager(getSupportFragmentManager());
        bi.kba09.setMaxDate(new SimpleDateFormat("dd/MM/yyyy").format(System.currentTimeMillis()));
        bi.kba09.setMinDate(DateTimeUtils.getYearsBack("dd/MM/yyyy", -1));


        bi.kba06.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                if (bi.kba06a.isChecked()) {
                    bi.fldGrpkba07.setVisibility(GONE);
                    bi.kba07m.setText(null);
                    bi.kba07d.setText(null);
                } else {
                    bi.fldGrpkba07.setVisibility(View.VISIBLE);
                }
            }
        });
        bi.kba08.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.kba08a || checkedId == R.id.kba08b || checkedId == R.id.kba08c || checkedId == R.id.kba08f) {
                    bi.fldGrpkba08.setVisibility(GONE);
                    bi.kba09.setText(null);
                    bi.kba06.clearCheck();
                    bi.kba07m.setText(null);
                    bi.kba07d.setText(null);

                } else {
                    bi.fldGrpkba08.setVisibility(VISIBLE);

                }
                if (checkedId == R.id.kba08e) {
                    bi.kba06.clearCheck();
                    bi.kba06a.setVisibility(GONE);
                    bi.kba06b.setVisibility(GONE);
                    bi.kba06c.setVisibility(VISIBLE);
                    bi.kba06d.setVisibility(VISIBLE);
                    bi.kba06e.setVisibility(VISIBLE);
                } else {
                    bi.kba06a.setVisibility(VISIBLE);
                    bi.kba06b.setVisibility(VISIBLE);
                    bi.kba06c.setVisibility(GONE);
                    bi.kba06d.setVisibility(GONE);
                    bi.kba06e.setVisibility(GONE);
                }
            }
        });
       /* bi.kba06twin.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                if (bi.kba06atwin.isChecked()) {
                    bi.fldGrpkba07twin.setVisibility(View.GONE);
                    bi.kba07mtwin.setText(null);
                    bi.kba07dtwin.setText(null);
                } else {
                    bi.fldGrpkba07twin.setVisibility(View.VISIBLE);
                }
            }
        });*/
    }


    public boolean ValidateForm() {

        if (!validatorClass.EmptyTextBox(this, bi.kba01, getString(R.string.kba01))) {
            return false;
        }
        if (!validatorClass.EmptyTextBox(this, bi.kba02, getString(R.string.kba02))) {
            return false;
        }
        if (!validatorClass.RangeTextBox(this, bi.kba02, 15, 49, getString(R.string.kba02), " years")) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, bi.kba05, bi.kba05a, getString(R.string.kba05))) {
            return false;
        }
        if (!validatorClass.EmptyTextBox(this, bi.kba03, getString(R.string.kba03))) {
            return false;
        }
        if (!validatorClass.RangeTextBox(this, bi.kba03, 1, 15, getString(R.string.kba03), " Number")) {
            return false;
        }
        if (!validatorClass.EmptyTextBox(this, bi.kba04, getString(R.string.kba04))) {
            return false;
        }

        if (!validatorClass.RangeTextBox(this, bi.kba04, 1, 15, getString(R.string.kba04), " Number")) {
            return false;
        }
        if (Integer.valueOf(bi.kba03.getText().toString()) >= Integer.valueOf(bi.kba04.getText().toString())) {

        } else {
            bi.kba03.setError("Total no of Pregnancies must be equal to or greater than Total no of Deliveries");
            bi.kba04.setError("Total no of Pregnancies must be equal to or greater than Total no of Deliveries");
            Toast.makeText(this, "Total no of Pregnancies must be equal to or greater than Total no of Deliveries", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (!validatorClass.EmptyRadioButton(this, bi.kba08, bi.kba08a, getString(R.string.kba08))) {
            return false;
        }
        if(bi.kba08a.isChecked() || bi.kba08b.isChecked() || bi.kba08c.isChecked() || bi.kba08f.isChecked()){

        }else {

        if (!validatorClass.EmptyTextBox(this, bi.kba09, getString(R.string.kba09))) {
            return false;
        }


        if (!validatorClass.EmptyRadioButton(this, bi.kba06, bi.kba06a, getString(R.string.kba06))) {
            return false;
        }

        if (!bi.kba06a.isChecked()) {
            if (!validatorClass.EmptyTextBox(this, bi.kba07d, getString(R.string.kba07y))) {
                return false;
            }
            if (!validatorClass.RangeTextBox(this, bi.kba07d, 0, 29, getString(R.string.kba07y), "days")) {
                return false;
            }
            if (!validatorClass.EmptyTextBox(this, bi.kba07m, getString(R.string.kba07m))) {
                return false;
            }

            if (!validatorClass.RangeTextBox(this, bi.kba07m, 0, 11, getString(R.string.kba07m), " months")) {
                return false;
            }
            if (bi.kba07d.getText().toString().equals("0") && bi.kba07m.getText().toString().equals("0")) {
                Toast.makeText(this, "Days and months cannot be 0 at the same time! ", Toast.LENGTH_LONG).show();
                bi.kba07d.setError("Days and months cannot be 0 at the same time!");
                bi.kba07m.setError("Days and months cannot be 0 at the same time!");
                bi.kba07d.requestFocus();
                return false;
            } else {
                bi.kba07d.setError(null);
                bi.kba07m.setError(null);
                bi.kba07d.clearFocus();
            }
        }
        }



        return true;
    }

    private void SaveDraft() throws JSONException {
        Toast.makeText(this, "Saving Draft for  This Section", Toast.LENGTH_SHORT).show();

        JSONObject sc1 = new JSONObject();


        sc1.put("resName", MainApp.resName);// Adding respondant name as Selected MWRA as amjad bhai said it is decided in the meeting
        sc1.put("kba01", bi.kba01.getText().toString());// Adding respondant name as Selected MWRA as amjad bhai said it is decided in the meeting
        sc1.put("kba02", bi.kba02.getText().toString());
        sc1.put("kba03", bi.kba05a.isChecked() ? "1"
                : bi.kba05b.isChecked() ? "2"
                : bi.kba0598.isChecked() ? "98"
                : "0");
        sc1.put("kba04", bi.kba03.getText().toString());
        sc1.put("kba05", bi.kba04.getText().toString());


        sc1.put("kba06", bi.kba08a.isChecked() ? "1"
                : bi.kba08b.isChecked() ? "2"
                : bi.kba08c.isChecked() ? "3"
                : bi.kba08d.isChecked() ? "4"
                : bi.kba08e.isChecked() ? "5"
                : bi.kba08f.isChecked() ? "6"
                : "0");
        sc1.put("kba07", bi.kba09.getText().toString());

        sc1.put("kba08", bi.kba06a.isChecked() ? "1"
                : bi.kba06b.isChecked() ? "2"
                : bi.kba06c.isChecked() ? "3"
                : bi.kba06d.isChecked() ? "4"
                : bi.kba06e.isChecked() ? "5"
                : "0");

        sc1.put("kba09d", bi.kba07d.getText().toString());
        sc1.put("kba09m", bi.kba07m.getText().toString());
     /*   sc1.put("kba06twin", bi.kba06atwin.isChecked() ? "1"
                : bi.kba06btwin.isChecked() ? "2"
                : "0");

        sc1.put("kba07dtwin", bi.kba07dtwin.getText().toString());
        sc1.put("kba07mtwin", bi.kba07mtwin.getText().toString());*/

        MainApp.fc.setsb1(String.valueOf(sc1));

        Toast.makeText(this, "Validation Successful! - Saving Draft...", Toast.LENGTH_SHORT).show();
    }

    private boolean UpdateDB() {
        DatabaseHelper db = new DatabaseHelper(this);

        int updcount = db.updateSB1();
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
            MainApp.endActivity(this, this);

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

                startActivity(new Intent(this, SectionB2Activity.class));
                //startActivity(new Intent(this, MainActivity.class));

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