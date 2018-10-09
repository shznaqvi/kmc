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
import edu.aku.hassannaqvi.kmc.databinding.ActivitySectionB1Binding;
import edu.aku.hassannaqvi.kmc.validation.validatorClass;


public class SectionB1Activity extends AppCompatActivity {

    ActivitySectionB1Binding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_b1);
        bi.setCallback(this);


        bi.kb106.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                if (bi.kb106a.isChecked()) {
                    bi.fldGrpkb107.setVisibility(View.GONE);
                    bi.kb107m.setText(null);
                    bi.kb107d.setText(null);
                } else {
                    bi.fldGrpkb107.setVisibility(View.VISIBLE);
                }
            }
        });
        bi.kb106twin.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                if (bi.kb106atwin.isChecked()) {
                    bi.fldGrpkb107twin.setVisibility(View.GONE);
                    bi.kb107mtwin.setText(null);
                    bi.kb107dtwin.setText(null);
                } else {
                    bi.fldGrpkb107twin.setVisibility(View.VISIBLE);
                }
            }
        });
    }


    public boolean ValidateForm() {

        if (!validatorClass.EmptyTextBox(this, bi.kb101, getString(R.string.kb101))) {
            return false;
        }
        if (!validatorClass.EmptyTextBox(this, bi.kb102, getString(R.string.kb102))) {
            return false;
        }
        if (!validatorClass.RangeTextBox(this, bi.kb102, 15, 49, getString(R.string.kb102)," years")) {
            return false;
        }
        if (!validatorClass.EmptyTextBox(this, bi.kb103, getString(R.string.kb103))) {
            return false;
        }
        if (!validatorClass.EmptyTextBox(this, bi.kb104, getString(R.string.kb104))) {
            return false;
        }

        if (!validatorClass.EmptyRadioButton(this, bi.kb105, bi.kb105a, getString(R.string.kb105))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, bi.kb106, bi.kb106a, getString(R.string.kb106))) {
            return false;
        }

        if (!bi.kb106a.isChecked()) {
            if (!validatorClass.EmptyTextBox(this, bi.kb107d, getString(R.string.kb107y))) {
                return false;
            }
            if (!validatorClass.RangeTextBox(this, bi.kb107d, 0, 29, getString(R.string.kb107y), "days")) {
                return false;
            }
            if (!validatorClass.EmptyTextBox(this, bi.kb107m, getString(R.string.kb107m))) {
                return false;
            }

            if (!validatorClass.RangeTextBox(this, bi.kb107m, 0, 11, getString(R.string.kb107m), " months")) {
                return false;
            }
            if (bi.kb107d.getText().toString().equals("0") && bi.kb107m.getText().toString().equals("0")) {
                Toast.makeText(this, "Days and months cannot be 0 at the same time! ", Toast.LENGTH_LONG).show();
                bi.kb107d.setError("Days and months cannot be 0 at the same time!");
                bi.kb107m.setError("Days and months cannot be 0 at the same time!");
                bi.kb107d.requestFocus();
                return false;
            } else {
                bi.kb107d.setError(null);
                bi.kb107m.setError(null);
                bi.kb107d.clearFocus();
            }
        }
/*
        if (bi.kb101e.isChecked()) {

            if (!validatorClass.EmptyRadioButton(this, bi.kb106twin, bi.kb106atwin, getString(R.string.kb106))) {
                return false;
            }

            if (!bi.kb106atwin.isChecked()) {
                if (!validatorClass.EmptyTextBox(this, bi.kb107dtwin, getString(R.string.kb107y))) {
                    return false;
                }
                if (!validatorClass.RangeTextBox(this, bi.kb107dtwin, 0, 29, getString(R.string.kb107y), "days")) {
                    return false;
                }
                if (!validatorClass.EmptyTextBox(this, bi.kb107mtwin, getString(R.string.kb107m))) {
                    return false;
                }
                if (!validatorClass.RangeTextBox(this, bi.kb107mtwin, 0, 11, getString(R.string.kb107m), " months")) {
                    return false;
                }
                if (bi.kb107dtwin.getText().toString().equals("0") && bi.kb107mtwin.getText().toString().equals("0")) {
                    Toast.makeText(this, "Days and months cannot be 0 at the same time! ", Toast.LENGTH_LONG).show();
                    bi.kb107dtwin.setError("Days and months cannot be 0 at the same time!");
                    bi.kb107mtwin.setError("Days and months cannot be 0 at the same time!");
                    bi.kb107dtwin.requestFocus();
                    return false;
                } else {
                    bi.kb107dtwin.setError(null);
                    bi.kb107mtwin.setError(null);
                    bi.kb107dtwin.clearFocus();
                }
            }

        }*/


        return true;
    }

    private void SaveDraft() throws JSONException {
        Toast.makeText(this, "Saving Draft for  This Section", Toast.LENGTH_SHORT).show();

        JSONObject sc1 = new JSONObject();


        sc1.put("kb101", bi.kb101.getText());
        sc1.put("kb102", bi.kb102.getText());
        sc1.put("kb103", bi.kb103.getText());
        sc1.put("kb104", bi.kb104.getText());


        sc1.put("kb105", bi.kb105a.isChecked() ? "1"
                : bi.kb105b.isChecked() ? "2"
                : bi.kb10598.isChecked() ? "98"
                : "0");
        sc1.put("kb106", bi.kb106a.isChecked() ? "1"
                : bi.kb106b.isChecked() ? "2"
                : "0");

        sc1.put("kb107d", bi.kb107d.getText().toString());
        sc1.put("kb107m", bi.kb107m.getText().toString());
        sc1.put("kb106twin", bi.kb106atwin.isChecked() ? "1"
                : bi.kb106btwin.isChecked() ? "2"
                : "0");

        sc1.put("kb107dtwin", bi.kb107dtwin.getText().toString());
        sc1.put("kb107mtwin", bi.kb107mtwin.getText().toString());

        MainApp.fc.setsC1(String.valueOf(sc1));

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
        if (ValidateForm()) {
            try {
                SaveDraft();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (UpdateDB()) {
                Toast.makeText(this, "Starting Ending Section", Toast.LENGTH_SHORT).show();

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