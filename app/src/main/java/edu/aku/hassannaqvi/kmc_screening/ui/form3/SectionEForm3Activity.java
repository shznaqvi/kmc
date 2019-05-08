package edu.aku.hassannaqvi.kmc_screening.ui.form3;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import edu.aku.hassannaqvi.kmc_screening.R;
import edu.aku.hassannaqvi.kmc_screening.core.DatabaseHelper;
import edu.aku.hassannaqvi.kmc_screening.core.MainApp;
import edu.aku.hassannaqvi.kmc_screening.databinding.ActivitySectionEForm3Binding;

import static edu.aku.hassannaqvi.kmc_screening.core.MainApp.fc;

public class SectionEForm3Activity extends AppCompatActivity {

    ActivitySectionEForm3Binding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_e_form3);
        bi.setCallback(this);
    }

    public void BtnEnd() {
        MainApp.endActivity(this, this);
    }


    private void SaveDraft() throws JSONException {

        JSONObject sa1 = new JSONObject();

        sa1.put("kf3e01a", bi.kf3e01a.getText().toString());

        sa1.put("kf3e02", bi.kf3e02a.isChecked() ? "1" : bi.kf3e02b.isChecked() ? "2" : "0");

        sa1.put("kf3e03", bi.kf3e03a.isChecked() ? "1" : bi.kf3e03b.isChecked() ? "2" : bi.kf3e03c.isChecked() ? "3" : "0");

        sa1.put("kf3e07", bi.kf3e07a.isChecked() ? "1" : bi.kf3e07b.isChecked() ? "2" : "0");

        sa1.put("kf3e05a", bi.kf3e05a.getText().toString());

        sa1.put("kf3e06a", bi.kf3e06a.getText().toString());

        sa1.put("kf3e07", bi.kf3e07a.isChecked() ? "1" : bi.kf3e07b.isChecked() ? "2" : "0");

        sa1.put("kf3e08", bi.kf3e08a.isChecked() ? "1" : bi.kf3e08b.isChecked() ? "2" : "0");

        sa1.put("kf3e09", bi.kf3e09a.isChecked() ? "1" : bi.kf3e09b.isChecked() ? "2" : "0");

        sa1.put("kf3e10", bi.kf3e10a.isChecked() ? "1" : bi.kf3e10b.isChecked() ? "2" : "0");

        sa1.put("kf3e11", bi.kf3e11a.isChecked() ? "1" : bi.kf3e11b.isChecked() ? "2" : "0");

        sa1.put("kf3e12", bi.kf3e12a.isChecked() ? "1" : bi.kf3e12b.isChecked() ? "2" : "0");

        sa1.put("kf3e13", bi.kf3e13a.isChecked() ? "1" : bi.kf3e13b.isChecked() ? "2" : "0");

        sa1.put("kf3e14", bi.kf3e14a.isChecked() ? "1" : bi.kf3e14b.isChecked() ? "2" : "0");

        sa1.put("kf3e15", bi.kf3e15a.isChecked() ? "1" : bi.kf3e15b.isChecked() ? "2" : "0");

        sa1.put("kf3e16", bi.kf3e16a.isChecked() ? "1" : bi.kf3e16b.isChecked() ? "2" : "0");

        sa1.put("kf3e17", bi.kf3e17a.isChecked() ? "1" : bi.kf3e17b.isChecked() ? "2" : "0");

        sa1.put("kf3e18", bi.kf3e18a.isChecked() ? "1" : bi.kf3e18b.isChecked() ? "2" : "0");

        sa1.put("kf3e19", bi.kf3e19a.isChecked() ? "1" : bi.kf3e19b.isChecked() ? "2" : "0");

        sa1.put("kf3e20", bi.kf3e20a.isChecked() ? "1" : bi.kf3e20b.isChecked() ? "2" : "0");

        sa1.put("kf3e21", bi.kf3e21a.isChecked() ? "1" : bi.kf3e21b.isChecked() ? "2" : "0");

        fc.setsE(String.valueOf(sa1));

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
                startActivity(new Intent(this, SectionFForm3Activity.class));

            } else {
                Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
            }
        }

    }

    private boolean formValidation() {

        return true;
    }

    private boolean UpdateDB() {

        DatabaseHelper db = new DatabaseHelper(this);

        int updcount = db.updateSE();

        if (updcount > 0) {
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