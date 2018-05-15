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

import java.text.SimpleDateFormat;
import java.util.Date;

import edu.aku.hassannaqvi.kmc.R;
import edu.aku.hassannaqvi.kmc.core.DatabaseHelper;
import edu.aku.hassannaqvi.kmc.core.MainApp;
import edu.aku.hassannaqvi.kmc.databinding.ActivitySectionC4Binding;
import edu.aku.hassannaqvi.kmc.validation.validatorClass;

public class SectionC4Activity extends AppCompatActivity {

    private static final String TAG = SectionC4Activity.class.getName();
    String dtToday = new SimpleDateFormat("dd-MM-yy HH:mm").format(new Date().getTime());

    ActivitySectionC4Binding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_section_c4);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_c4);
        bi.setCallback(this);
        setupView();
    }

    private void setupView() {
        bi.kc402.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.kc402b) {
                    bi.fldGrpkc403.setVisibility(View.GONE);
                    bi.kc403.clearCheck();
                    bi.kc40396x.setText(null);
                    bi.kc404.clearCheck();
                    bi.kc405.clearCheck();
                    bi.kc406.clearCheck();
                    bi.kc40696x.setText(null);
                    bi.kc407.clearCheck();
                } else {
                    bi.fldGrpkc403.setVisibility(View.VISIBLE);
                }
            }
        });

        bi.kc404.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.kc404b) {
                    bi.fldGrpkc405.setVisibility(View.GONE);

                    bi.kc405.clearCheck();
                    bi.kc406.clearCheck();
                    bi.kc40696x.setText(null);

                } else {
                    bi.fldGrpkc405.setVisibility(View.VISIBLE);
                }
            }
        });


    }


    private void SaveDraft() throws JSONException {

        JSONObject sC4 = new JSONObject();

        sC4.put("kc401", bi.kc401a.isChecked() ? "1"
                : bi.kc401b.isChecked() ? "2"
                : bi.kc401c.isChecked() ? "3"
                : bi.kc401d.isChecked() ? "4"
                : bi.kc40196.isChecked() ? "96"
                : "0");

        sC4.put("kc40196", bi.kc40196x.getText().toString());

        sC4.put("kc402", bi.kc402a.isChecked() ? "1"
                : bi.kc402b.isChecked() ? "2"
                : "0");

        sC4.put("kc403", bi.kc403a.isChecked() ? "1"
                : bi.kc403b.isChecked() ? "2"
                : bi.kc403c.isChecked() ? "3"
                : bi.kc403d.isChecked() ? "4"
                : bi.kc403e.isChecked() ? "5"
                : bi.kc403f.isChecked() ? "6"
                : bi.kc403g.isChecked() ? "7"
                : bi.kc403h.isChecked() ? "8"
                : bi.kc403i.isChecked() ? "9"
                : bi.kc40399.isChecked() ? "99"
                : bi.kc40396.isChecked() ? "96"
                : "0");

        sC4.put("kc40396x", bi.kc40396x.getText().toString());


        sC4.put("kc404", bi.kc404a.isChecked() ? "1"
                : bi.kc404b.isChecked() ? "2"
                : bi.kc40498.isChecked() ? "98"
                : "0");


        sC4.put("kc405", bi.kc405a.isChecked() ? "1"
                : bi.kc405b.isChecked() ? "2"
                : bi.kc40598.isChecked() ? "98"
                : "0");

        sC4.put("kc406", bi.kc406a.isChecked() ? "1"
                : bi.kc406b.isChecked() ? "2"
                : bi.kc406c.isChecked() ? "3"
                : bi.kc406d.isChecked() ? "4"
                : bi.kc406e.isChecked() ? "5"
                : bi.kc406f.isChecked() ? "6"
                : bi.kc40698.isChecked() ? "98"
                : bi.kc40696.isChecked() ? "96"
                : "0");

        sC4.put("kc40696x", bi.kc40696x.getText().toString());


        sC4.put("kc407", bi.kc407a.isChecked() ? "1"
                : bi.kc407b.isChecked() ? "2"
                : bi.kc40798.isChecked() ? "98"
                : "0");


        MainApp.fc.setsC4(String.valueOf(sC4));
    }


    private boolean formValidation() {

        if (!validatorClass.EmptyRadioButton(this, bi.kc401, bi.kc401a, getString(R.string.kc401))) {
            return false;
        }


        if (bi.kc40196.isChecked()) {

            if (!validatorClass.EmptyTextBox(this, bi.kc40196x, getString(R.string.other))) {
                return false;
            }
        }


        if (!validatorClass.EmptyRadioButton(this, bi.kc402, bi.kc402a, getString(R.string.kc402))) {
            return false;
        }

        if (!validatorClass.EmptyRadioButton(this, bi.kc403, bi.kc403a, getString(R.string.kc403))) {
            return false;
        }


        if (bi.kc40396.isChecked()) {

            if (!validatorClass.EmptyTextBox(this, bi.kc40396x, getString(R.string.other))) {
                return false;
            }
        }


        if (!validatorClass.EmptyRadioButton(this, bi.kc404, bi.kc404a, getString(R.string.kc404))) {
            return false;
        }


        if (!validatorClass.EmptyRadioButton(this, bi.kc405, bi.kc405a, getString(R.string.kc405))) {
            return false;
        }


        if (!validatorClass.EmptyRadioButton(this, bi.kc406, bi.kc406a, getString(R.string.kc406))) {
            return false;
        }


        if (bi.kc40696.isChecked()) {

            if (!validatorClass.EmptyTextBox(this, bi.kc40696x, getString(R.string.other))) {
                return false;
            }
        }


        return validatorClass.EmptyRadioButton(this, bi.kc407, bi.kc407a, getString(R.string.kc407));
    }


    public void BtnEnd() {

        Toast.makeText(this, "Processing End Section", Toast.LENGTH_SHORT).show();
        if (formValidation()) {
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
        if (formValidation()) {
            try {
                SaveDraft();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (UpdateDB()) {
                Toast.makeText(this, "Starting Ending Section", Toast.LENGTH_SHORT).show();

                finish();

                startActivity(new Intent(this, SectionC5Activity.class));

            } else {
                Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
            }
        }
    }


    private boolean UpdateDB() {

        //Long rowId;
        DatabaseHelper db = new DatabaseHelper(this);

        int updcount = db.updateSC4();

        if (updcount == 1) {
            //Toast.makeText(this, "Updating Database... Successful!", Toast.LENGTH_SHORT).show();
            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }
    }

}
