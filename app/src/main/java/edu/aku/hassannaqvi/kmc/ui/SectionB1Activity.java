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
        //setContentView(R.layout.activity_section_b1);

        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_b1);
        bi.setCallback(this);

        bi.kb101.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (bi.kb101a.isChecked() || bi.kb101b.isChecked() || bi.kb101c.isChecked() || bi.kb101f.isChecked()) {
                    bi.fldGrpkb102.setVisibility(View.GONE);
                    bi.kb102.clearCheck();
                    bi.kb103d.setText(null);
                    bi.kb103m.setText(null);
                    bi.fldGrpkb102twin.setVisibility(View.GONE);
                    bi.kb102twin.clearCheck();
                    bi.kb103dtwin.setText(null);
                    bi.kb103mtwin.setText(null);
                } else if (bi.kb101e.isChecked()) {
                    bi.fldGrpkb102.setVisibility(View.VISIBLE);
                    bi.fldGrpkb102twin.setVisibility(View.VISIBLE);
                } else {
                    bi.fldGrpkb102twin.setVisibility(View.GONE);
                    bi.kb102twin.clearCheck();
                    bi.kb103dtwin.setText(null);
                    bi.kb103mtwin.setText(null);
                    bi.fldGrpkb102.setVisibility(View.VISIBLE);
                }
            }
        });


        bi.kb102.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                if (bi.kb102a.isChecked()) {
                    bi.fldGrpkb103.setVisibility(View.GONE);
                    bi.kb103m.setText(null);
                    bi.kb103d.setText(null);
                } else {
                    bi.fldGrpkb103.setVisibility(View.VISIBLE);
                }
            }
        });
        bi.kb102twin.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                if (bi.kb102atwin.isChecked()) {
                    bi.fldGrpkb103twin.setVisibility(View.GONE);
                    bi.kb103mtwin.setText(null);
                    bi.kb103dtwin.setText(null);
                } else {
                    bi.fldGrpkb103twin.setVisibility(View.VISIBLE);
                }
            }
        });
    }


    public boolean ValidateForm() {

        if (!validatorClass.EmptyRadioButton(this, bi.kb101, bi.kb101a, getString(R.string.kb101))) {
            return false;
        }

        if (bi.kb101d.isChecked() || bi.kb101e.isChecked() || bi.kb101g.isChecked()) {
            if (!validatorClass.EmptyRadioButton(this, bi.kb102, bi.kb102a, getString(R.string.kb102))) {
                return false;
            }

            if (!bi.kb102a.isChecked()) {
                if (!validatorClass.EmptyTextBox(this, bi.kb103d, getString(R.string.kb103y))) {
                    return false;
                }
                if (!validatorClass.RangeTextBox(this, bi.kb103d, 0, 29, getString(R.string.kb103y), "days")) {
                    return false;
                }
                if (!validatorClass.EmptyTextBox(this, bi.kb103m, getString(R.string.kb103m))) {
                    return false;
                }

                if (!validatorClass.RangeTextBox(this, bi.kb103m, 0, 11, getString(R.string.kb103m), " months")) {
                    return false;
                }
                if (bi.kb103d.getText().toString().equals("0") && bi.kb103m.getText().toString().equals("0")) {
                    Toast.makeText(this, "Days and months cannot be 0 at the same time! ", Toast.LENGTH_LONG).show();
                    bi.kb103d.setError("Days and months cannot be 0 at the same time!");
                    bi.kb103m.setError("Days and months cannot be 0 at the same time!");
                    bi.kb103d.requestFocus();
                    return false;
                } else {
                    bi.kb103d.setError(null);
                    bi.kb103m.setError(null);
                    bi.kb103d.clearFocus();
                }
            }

            if (bi.kb101e.isChecked()) {

                if (!validatorClass.EmptyRadioButton(this, bi.kb102twin, bi.kb102atwin, getString(R.string.kb102))) {
                    return false;
                }

                if (!bi.kb102atwin.isChecked()) {
                    if (!validatorClass.EmptyTextBox(this, bi.kb103dtwin, getString(R.string.kb103y))) {
                        return false;
                    }
                    if (!validatorClass.RangeTextBox(this, bi.kb103dtwin, 0, 29, getString(R.string.kb103y), "days")) {
                        return false;
                    }
                    if (!validatorClass.EmptyTextBox(this, bi.kb103mtwin, getString(R.string.kb103m))) {
                        return false;
                    }
                    if (!validatorClass.RangeTextBox(this, bi.kb103mtwin, 0, 11, getString(R.string.kb103m), " months")) {
                        return false;
                    }
                    if (bi.kb103dtwin.getText().toString().equals("0") && bi.kb103mtwin.getText().toString().equals("0")) {
                        Toast.makeText(this, "Days and months cannot be 0 at the same time! ", Toast.LENGTH_LONG).show();
                        bi.kb103dtwin.setError("Days and months cannot be 0 at the same time!");
                        bi.kb103mtwin.setError("Days and months cannot be 0 at the same time!");
                        bi.kb103dtwin.requestFocus();
                        return false;
                    } else {
                        bi.kb103dtwin.setError(null);
                        bi.kb103mtwin.setError(null);
                        bi.kb103dtwin.clearFocus();
                    }
                }

            }
        }

        return true;
    }

    private void SaveDraft() throws JSONException {
        Toast.makeText(this, "Saving Draft for  This Section", Toast.LENGTH_SHORT).show();

        JSONObject sc1 = new JSONObject();


        sc1.put("kb101", bi.kb101a.isChecked() ? "1"
                : bi.kb101b.isChecked() ? "2"
                : bi.kb101c.isChecked() ? "3"
                : bi.kb101d.isChecked() ? "4"
                : bi.kb101e.isChecked() ? "5"
                : bi.kb101f.isChecked() ? "6"
                : bi.kb101g.isChecked() ? "7"
                : "0");


        sc1.put("kb102", bi.kb102a.isChecked() ? "1"
                : bi.kb102b.isChecked() ? "2"
                : "0");

        sc1.put("kb103d", bi.kb103d.getText().toString());
        sc1.put("kb103m", bi.kb103m.getText().toString());
        sc1.put("kb102twin", bi.kb102atwin.isChecked() ? "1"
                : bi.kb102btwin.isChecked() ? "2"
                : "0");

        sc1.put("kb103dtwin", bi.kb103dtwin.getText().toString());
        sc1.put("kb103mtwin", bi.kb103mtwin.getText().toString());

        MainApp.fc.setsC1(String.valueOf(sc1));

        Toast.makeText(this, "Validation Successful! - Saving Draft...", Toast.LENGTH_SHORT).show();
    }

    private boolean UpdateDB() {
        DatabaseHelper db = new DatabaseHelper(this);

        int updcount = db.updateSC1();
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

                startActivity(new Intent(this, SectionC2Activity.class));
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