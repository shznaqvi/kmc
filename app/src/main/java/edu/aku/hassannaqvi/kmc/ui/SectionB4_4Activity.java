package edu.aku.hassannaqvi.kmc.ui;

import android.content.Context;
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
import edu.aku.hassannaqvi.kmc.databinding.ActivitySectionB44Binding;
import edu.aku.hassannaqvi.kmc.validation.validatorClass;

public class SectionB4_4Activity extends AppCompatActivity {

    ActivitySectionB44Binding bi;
    Context context;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_b4_4);
        bi.setCallback(this);

        context = SectionB4_4Activity.this;
        setupView();
    }

    private void setupView() {

        bi.kbdd01.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (bi.kbdd01a.isChecked()) {
                    bi.kbdd01d.setVisibility(View.VISIBLE);
                    bi.kbdd01m.setVisibility(View.VISIBLE);
                } else {
                    bi.kbdd01d.setText(null);
                    bi.kbdd01m.setText(null);

                    bi.kbdd01d.setVisibility(View.GONE);
                    bi.kbdd01m.setVisibility(View.GONE);
                }
            }
        });

        bi.kbdd03.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.kbdd03b) {
                    bi.fldGrpkbdd04.setVisibility(View.GONE);

                    bi.kbdd04a.setChecked(false);
                    bi.kbdd04b.setChecked(false);
                    bi.kbdd04c.setChecked(false);
                    bi.kbdd04d.setChecked(false);
                    bi.kbdd04e.setChecked(false);
                    bi.kbdd04f.setChecked(false);
                    bi.kbdd04g.setChecked(false);
                    bi.kbdd0496.setChecked(false);

                    //bi.kbdd04.clearCheck();
                    bi.kbdd0496x.setText(null);
                } else {
                    bi.fldGrpkbdd04.setVisibility(View.VISIBLE);
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
            MainApp.endActivity(this, this);

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

                startActivity(new Intent(this, SectionB4_5Activity.class));
                //startActivity(new Intent(this, MainActivity.class));

            } else {
                Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private boolean formValidation() {
        Toast.makeText(context, "Validating This Section ", Toast.LENGTH_SHORT).show();

        if (!validatorClass.EmptyRadioButton(context, bi.kbdd01, bi.kbdd01a, getString(R.string.kbdd01))) {
            return false;
        }

        if (bi.kbdd01a.isChecked()) {

            if (!validatorClass.EmptyTextBox(context, bi.kbdd01d, getString(R.string.kbdd01a))) {
                return false;
            }


            if (!validatorClass.RangeTextBox(context, bi.kbdd01d, 0, 29, getString(R.string.days), "days")) {
                return false;
            }

            if (!validatorClass.EmptyTextBox(context, bi.kbdd01m, getString(R.string.kbdd01b))) {
                return false;
            }

            if (!validatorClass.RangeTextBox(context, bi.kbdd01m, 0, 12, getString(R.string.months), "months")) {
                return false;
            }

            if (bi.kbdd01d.getText().toString().equals("0") && bi.kbdd01m.getText().toString().equals("0")) {
                Toast.makeText(this, "Days and months cannot be 0 at the same time! ", Toast.LENGTH_LONG).show();
                bi.kbdd01d.setError("Days and months cannot be 0 at the same time!");
                bi.kbdd01m.setError("Days and months cannot be 0 at the same time!");
                bi.kbdd01d.requestFocus();
                return false;
            } else {
                bi.kbdd01d.setError(null);
                bi.kbdd01m.setError(null);
                bi.kbdd01d.clearFocus();
            }

        }


        if (!validatorClass.EmptyCheckBox(context, bi.kbdd02, bi.kbdd0296, bi.kbdd0296x, getString(R.string.other))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(context, bi.kbdd03, bi.kbdd03a, getString(R.string.kbdd03))) {
            return false;
        }
        if (!bi.kbdd03b.isChecked()) {
            return validatorClass.EmptyCheckBox(context, bi.kbdd04, bi.kbdd0496, bi.kbdd0496x, getString(R.string.kbdd04));
        }
        return true;
    }

    private void SaveDraft() throws JSONException {
        Toast.makeText(this, "Saving Draft for  This Section", Toast.LENGTH_SHORT).show();

        JSONObject sd2 = new JSONObject();
        sd2.put("kbdd01",
                bi.kbdd01a.isChecked() ? "1" :
                        bi.kbdd0197.isChecked() ? "97" :
                                bi.kbdd0177.isChecked() ? "4" :
                                        bi.kbdd0198.isChecked() ? "98" :
                                                "0");

        sd2.put("kbdd01d", bi.kbdd01d.getText().toString());
        sd2.put("kbdd01m", bi.kbdd01m.getText().toString());

        sd2.put("kbdd02a", bi.kbdd02a.isChecked() ? "1" : "0");
        sd2.put("kbdd02b", bi.kbdd02b.isChecked() ? "2" : "0");
        sd2.put("kbdd02c", bi.kbdd02c.isChecked() ? "3" : "0");
        sd2.put("kbdd02d", bi.kbdd02d.isChecked() ? "4" : "0");
        sd2.put("kbdd02e", bi.kbdd02e.isChecked() ? "5" : "0");
        sd2.put("kbdd0296", bi.kbdd0296.isChecked() ? "96" : "0");
        sd2.put("kbdd0296x", bi.kbdd0296x.getText().toString());


        sd2.put("kbdd03",
                bi.kbdd03a.isChecked() ? "1" :
                        bi.kbdd03b.isChecked() ? "2" :
                                "0");
        /*sd2.put("kbdd04",
                bi.kbdd04a.isChecked() ? "1" :
                        bi.kbdd04b.isChecked() ? "2" :
                                bi.kbdd04c.isChecked() ? "3" :
                                        bi.kbdd04d.isChecked() ? "4" :
                                                bi.kbdd04e.isChecked() ? "5" :
                                                        bi.kbdd04f.isChecked() ? "6" :
                                                                bi.kbdd04g.isChecked() ? "7" :
                                                                        bi.kbdd0496.isChecked() ? "96" :
                                                                                "0");*/


        sd2.put("kbdd04a", bi.kbdd04a.isChecked() ? "1" : "0");
        sd2.put("kbdd04b", bi.kbdd04b.isChecked() ? "2" : "0");
        sd2.put("kbdd04c", bi.kbdd04c.isChecked() ? "3" : "0");
        sd2.put("kbdd04d", bi.kbdd04d.isChecked() ? "4" : "0");
        sd2.put("kbdd04e", bi.kbdd04e.isChecked() ? "5" : "0");
        sd2.put("kbdd04f", bi.kbdd04f.isChecked() ? "6" : "0");
        sd2.put("kbdd04g", bi.kbdd04g.isChecked() ? "7" : "0");
        sd2.put("kbdd0496", bi.kbdd0496.isChecked() ? "96" : "0");

        sd2.put("kbdd0496x", bi.kbdd0496x.getText().toString());

        MainApp.fc.setsb4_4(String.valueOf(sd2));

        Toast.makeText(this, "Validation Successful! - Saving Draft...", Toast.LENGTH_SHORT).show();
    }

    private boolean UpdateDB() {
        db = new DatabaseHelper(context);
        int updcount = db.updateSB4_4();

        if (updcount == 1) {
            Toast.makeText(this, "Updating Database... Successful!", Toast.LENGTH_SHORT).show();
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