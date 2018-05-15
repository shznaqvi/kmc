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

        bi.kd301.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (bi.kd301d.isChecked()) {

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
                    bi.kd304.clearCheck();

                    bi.fldGrpkd301.setVisibility(View.GONE);
                } else {
                    bi.fldGrpkd301.setVisibility(View.VISIBLE);
                }
            }
        });


    }


    private void SaveDraft() throws JSONException {

        JSONObject sD3 = new JSONObject();

        sD3.put("kd301", bi.kd301a.isChecked() ? "1"
                : bi.kd301b.isChecked() ? "2"
                : bi.kd301c.isChecked() ? "3"
                : bi.kd301d.isChecked() ? "4"
                : bi.kd30198.isChecked() ? "98"
                : "0");


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


        sD3.put("kd304m", bi.kd304m.getText().toString());
        sD3.put("kd304y", bi.kd304y.getText().toString());
        sD3.put("kd304d", bi.kd304d.isChecked() ? "1" : "0");
        sD3.put("kd30498", bi.kd30498.isChecked() ? "98" : "0");


        MainApp.fc.setsD3(String.valueOf(sD3));

    }


    private boolean formValidation() {


        if (!validatorClass.EmptyRadioButton(this, bi.kd301, bi.kd301a, getString(R.string.kd301))) {
            return false;
        }


        if (!validatorClass.EmptyCheckBox(this, bi.kd302, bi.kd302a, getString(R.string.kd302))) {
            return false;
        }


        if (bi.kd30296.isChecked()) {

            if (!validatorClass.EmptyTextBox(this, bi.kd30296x, getString(R.string.other))) {
                return false;
            }
        }


        if (!validatorClass.EmptyRadioButton(this, bi.kd303, bi.kd303a, getString(R.string.kd303))) {
            return false;
        }


        if (!validatorClass.EmptyRadioButton(this, bi.kd304, bi.kd304a, getString(R.string.kd304))) {
            return false;
        }

        if (bi.kd304a.isChecked()) {

            if (!validatorClass.EmptyTextBox(this, bi.kd304m, getString(R.string.kd304))) {
                return false;
            }

        }


        if (!validatorClass.EmptyRadioButton(this, bi.kd305, bi.kd305a, getString(R.string.kd305))) {
            return false;
        }


        if (bi.kd30596.isChecked()) {

            return validatorClass.EmptyTextBox(this, bi.kd30596x, getString(R.string.other));
        }

        return true;
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

}