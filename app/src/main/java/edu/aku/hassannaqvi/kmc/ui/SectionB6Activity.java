package edu.aku.hassannaqvi.kmc.ui;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import edu.aku.hassannaqvi.kmc.R;
import edu.aku.hassannaqvi.kmc.core.DatabaseHelper;
import edu.aku.hassannaqvi.kmc.core.MainApp;
import edu.aku.hassannaqvi.kmc.databinding.ActivitySectionB6Binding;
import edu.aku.hassannaqvi.kmc.validation.validatorClass;

public class SectionB6Activity extends AppCompatActivity {

    ActivitySectionB6Binding bi;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_section_b6);

        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_b6);
        db = new DatabaseHelper(this);
        bi.setCallback(this);
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

                startActivity(new Intent(this, SectionC1Activity.class));

            } else {
                Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
            }
        }

        //startActivity(new Intent(this, SectionC1Activity.class));

    }

    public void BtnEnd() {

        MainApp.endActivity(this, this);

    }

    private boolean ValidateForm() {

        Toast.makeText(this, "Validating This Section ", Toast.LENGTH_SHORT).show();

        if (!validatorClass.EmptyRadioButton(this, bi.nb60101, bi.nb60101a, getString(R.string.nb601a))) {
            return false;
        }

        if (!validatorClass.EmptyRadioButton(this, bi.nb60102, bi.nb60102a, getString(R.string.nb601b))) {
            return false;
        }

        if (!validatorClass.EmptyRadioButton(this, bi.nb60103, bi.nb60103a, getString(R.string.nb601c))) {
            return false;
        }

        if (!validatorClass.EmptyRadioButton(this, bi.nb60104, bi.nb60104a, getString(R.string.nb601d))) {
            return false;
        }

        if (!validatorClass.EmptyRadioButton(this, bi.nb60105, bi.nb60105a, getString(R.string.nb601e))) {
            return false;
        }

        if (!validatorClass.EmptyRadioButton(this, bi.nb60106, bi.nb60106a, getString(R.string.nb601f))) {
            return false;
        }

        if (!validatorClass.EmptyRadioButton(this, bi.nb60107, bi.nb60107a, getString(R.string.nb601g))) {
            return false;
        }

        if (!validatorClass.EmptyRadioButton(this, bi.nb60108, bi.nb60108a, getString(R.string.nb601h))) {
            return false;
        }

        if (!validatorClass.EmptyRadioButton(this, bi.nb60108, bi.nb60108a, bi.nb60108x, getString(R.string.nb601h) + " - " + getString(R.string.other))) {
            return false;
        }

        if (!validatorClass.EmptyRadioButton(this, bi.nb60109, bi.nb60109a, getString(R.string.nb601i))) {
            return false;
        }

        if (!validatorClass.EmptyRadioButton(this, bi.nb60109, bi.nb60109a, bi.nb60109x, getString(R.string.nb601j) + " - " + getString(R.string.other))) {
            return false;
        }

        if (!validatorClass.EmptyRadioButton(this, bi.nb60196, bi.nb60196a, getString(R.string.nb601j))) {
            return false;
        }

        return validatorClass.EmptyRadioButton(this, bi.nb60196, bi.nb60196a, bi.nb60196x, getString(R.string.nb601j) + " - " + getString(R.string.other));
    }

    private void SaveDraft() throws JSONException {
        Toast.makeText(this, "Saving Draft for  This Section", Toast.LENGTH_SHORT).show();

        JSONObject sB6 = new JSONObject();
        //       nb601
//        60101
        sB6.put("nb60101", bi.nb60101a.isChecked() ? "1"
                : bi.nb60101b.isChecked() ? "2"
                : "0");
//        60102
        sB6.put("nb60102", bi.nb60102a.isChecked() ? "1"
                : bi.nb60102b.isChecked() ? "2"
                : "0");
//        60103
        sB6.put("nb60103", bi.nb60103a.isChecked() ? "1"
                : bi.nb60103b.isChecked() ? "2"
                : "0");
//        60104
        sB6.put("nb60104", bi.nb60104a.isChecked() ? "1"
                : bi.nb60104b.isChecked() ? "2"
                : "0");
//        60105
        sB6.put("nb60105", bi.nb60105a.isChecked() ? "1"
                : bi.nb60105b.isChecked() ? "2"
                : "0");
//        60106
        sB6.put("nb60106", bi.nb60106a.isChecked() ? "1"
                : bi.nb60106b.isChecked() ? "2"
                : "0");
//        60107
        sB6.put("nb60107", bi.nb60107a.isChecked() ? "1"
                : bi.nb60107b.isChecked() ? "2"
                : "0");
//        60108
        sB6.put("nb60108", bi.nb60108a.isChecked() ? "1"
                : bi.nb60108b.isChecked() ? "2"
                : "0");
//        60109
        sB6.put("nb60109", bi.nb60109a.isChecked() ? "1"
                : bi.nb60109b.isChecked() ? "2"
                : "0");

//        60196
        sB6.put("nb60196", bi.nb60196a.isChecked() ? "1"
                : bi.nb60196b.isChecked() ? "2"
                : "0");


        sB6.put("nc101", bi.nb60108x.getText().toString());
        sB6.put("nc101", bi.nb60109x.getText().toString());
        sB6.put("nc101", bi.nb60196x.getText().toString());

        MainApp.mc.setsB6(String.valueOf(sB6));


        Toast.makeText(this, "Validation Successful! - Saving Draft...", Toast.LENGTH_SHORT).show();
    }

    private boolean UpdateDB() {

        //Long rowId;
        DatabaseHelper db = new DatabaseHelper(this);

        int updcount = db.updateSB6();

        if (updcount == 1) {
            Toast.makeText(this, "Updating Database... Successful!", Toast.LENGTH_SHORT).show();
            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }

        //return true;

    }

}
