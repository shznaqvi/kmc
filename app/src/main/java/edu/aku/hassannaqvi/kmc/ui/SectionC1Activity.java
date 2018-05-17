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
import edu.aku.hassannaqvi.kmc.databinding.ActivitySectionC1Binding;
import edu.aku.hassannaqvi.kmc.validation.validatorClass;


public class SectionC1Activity extends AppCompatActivity {

    ActivitySectionC1Binding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_section_c1);

        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_c1);
        bi.setCallback(this);

        bi.kc101.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (bi.kc101a.isChecked() || bi.kc101b.isChecked() || bi.kc101c.isChecked() || bi.kc101f.isChecked()) {
                    bi.fldGrpkc102.setVisibility(View.GONE);
                    bi.kc102.clearCheck();
                    bi.kc103d.setText(null);
                    bi.kc103m.setText(null);
                    bi.fldGrpkc102twin.setVisibility(View.GONE);
                    bi.kc102twin.clearCheck();
                    bi.kc103dtwin.setText(null);
                    bi.kc103mtwin.setText(null);
                } else if (bi.kc101e.isChecked()) {
                    bi.fldGrpkc102.setVisibility(View.VISIBLE);
                    bi.fldGrpkc102twin.setVisibility(View.VISIBLE);
                } else {
                    bi.fldGrpkc102twin.setVisibility(View.GONE);
                    bi.kc102twin.clearCheck();
                    bi.kc103dtwin.setText(null);
                    bi.kc103mtwin.setText(null);
                    bi.fldGrpkc102.setVisibility(View.VISIBLE);
                }
            }
        });


        bi.kc102.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                if (bi.kc102a.isChecked()) {
                    bi.fldGrpkc103.setVisibility(View.GONE);
                    bi.kc103m.setText(null);
                    bi.kc103d.setText(null);
                } else {
                    bi.fldGrpkc103.setVisibility(View.VISIBLE);
                }
            }
        });
        bi.kc102twin.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                if (bi.kc102atwin.isChecked()) {
                    bi.fldGrpkc103twin.setVisibility(View.GONE);
                    bi.kc103mtwin.setText(null);
                    bi.kc103dtwin.setText(null);
                } else {
                    bi.fldGrpkc103twin.setVisibility(View.VISIBLE);
                }
            }
        });
    }


    public boolean ValidateForm() {

        if (!validatorClass.EmptyRadioButton(this, bi.kc101, bi.kc101a, getString(R.string.kc101))) {
            return false;
        }

        if (bi.kc101d.isChecked() || bi.kc101e.isChecked() || bi.kc101g.isChecked()) {
            if (!validatorClass.EmptyRadioButton(this, bi.kc102, bi.kc102a, getString(R.string.kc102))) {
                return false;
            }

            if (!bi.kc102a.isChecked()) {
                if (!validatorClass.EmptyTextBox(this, bi.kc103d, getString(R.string.kc103y))) {
                    return false;
                }
                if (!validatorClass.RangeTextBox(this,bi.kc103d,0,29,getString(R.string.kc103y),"days")) {
                    return false;
                }
                if (!validatorClass.EmptyTextBox(this, bi.kc103m, getString(R.string.kc103m))) {
                    return false;
                }

                if (!validatorClass.RangeTextBox(this,bi.kc103m,0,11,getString(R.string.kc103m)," months")) {
                    return false;
                }
                if (bi.kc103d.getText().toString().equals("0") && bi.kc103m.getText().toString().equals("0")) {
                    Toast.makeText(this, "Days and months cannot be 0 at the same time! ", Toast.LENGTH_LONG).show();
                    bi.kc103d.setError("Days and months cannot be 0 at the same time!");
                    bi.kc103m.setError("Days and months cannot be 0 at the same time!");
                    bi.kc103d.requestFocus();
                    return false;
                } else {
                    bi.kc103d.setError(null);
                    bi.kc103m.setError(null);
                    bi.kc103d.clearFocus();
                }
            }
            if (bi.kc101e.isChecked()) {

                if (!validatorClass.EmptyRadioButton(this, bi.kc102twin, bi.kc102atwin, getString(R.string.kc102))) {
                    return false;
                }

                if (!bi.kc102atwin.isChecked()) {
                    if (!validatorClass.EmptyTextBox(this, bi.kc103dtwin, getString(R.string.kc103y))) {
                        return false;
                    }
                    if (!validatorClass.RangeTextBox(this,bi.kc103dtwin,0,29,getString(R.string.kc103y),"days")) {
                        return false;
                    }
                    if (!validatorClass.EmptyTextBox(this, bi.kc103mtwin, getString(R.string.kc103m))) {
                        return false;
                    }
                    if (!validatorClass.RangeTextBox(this,bi.kc103mtwin,0,11,getString(R.string.kc103m)," months")) {
                        return false;
                    }
                    if (bi.kc103dtwin.getText().toString().equals("0") && bi.kc103mtwin.getText().toString().equals("0")) {
                        Toast.makeText(this, "Days and months cannot be 0 at the same time! ", Toast.LENGTH_LONG).show();
                        bi.kc103dtwin.setError("Days and months cannot be 0 at the same time!");
                        bi.kc103mtwin.setError("Days and months cannot be 0 at the same time!");
                        bi.kc103dtwin.requestFocus();
                        return false;
                    } else {
                        bi.kc103dtwin.setError(null);
                        bi.kc103mtwin.setError(null);
                        bi.kc103dtwin.clearFocus();
                    }
                }

            }
        }

        return true;
    }

    private void SaveDraft() throws JSONException {
        Toast.makeText(this, "Saving Draft for  This Section", Toast.LENGTH_SHORT).show();

        JSONObject sn = new JSONObject();


        sn.put("kc101", bi.kc101a.isChecked() ? "1"
                : bi.kc101b.isChecked() ? "2"
                : bi.kc101c.isChecked() ? "3"
                : bi.kc101d.isChecked() ? "4"
                : bi.kc101e.isChecked() ? "5"
                : bi.kc101f.isChecked() ? "6"
                : bi.kc101g.isChecked() ? "7"
                : "0");


        sn.put("kc102", bi.kc102a.isChecked() ? "1"
                : bi.kc102b.isChecked() ? "2"
                : "0");

        sn.put("kc103d", bi.kc103d.getText().toString());
        sn.put("kc103m", bi.kc103m.getText().toString());
        sn.put("kc102twin", bi.kc102atwin.isChecked() ? "1"
                : bi.kc102btwin.isChecked() ? "2"
                : "0");

        sn.put("kc103dtwin", bi.kc103dtwin.getText().toString());
        sn.put("kc103mtwin", bi.kc103mtwin.getText().toString());

        //MainApp.fc.sets(String.valueOf(sn));

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
        if (ValidateForm()) {
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
}
