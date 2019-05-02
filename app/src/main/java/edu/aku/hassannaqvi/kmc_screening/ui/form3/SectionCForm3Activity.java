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
import edu.aku.hassannaqvi.kmc_screening.databinding.ActivitySectionCForm3Binding;

import static edu.aku.hassannaqvi.kmc_screening.core.MainApp.fc;

public class SectionCForm3Activity extends AppCompatActivity {

    ActivitySectionCForm3Binding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_c_form3);
        bi.setCallback(this);


        setupViews();
    }

    private void setupViews() {


    }

    public void BtnEnd() {

        MainApp.endActivity(this, this);

    }


    private void SaveDraft() throws JSONException {

        JSONObject sa1 = new JSONObject();

        sa1.put("kf3c01", bi.kf3c01a.isChecked() ? "1" : bi.kf3c01b.isChecked() ? "2" : "0");

        sa1.put("kf3c02a", bi.kf3c02a.getText().toString());

        sa1.put("kf3c03a", bi.kf3c03a.getText().toString());

        sa1.put("kf3c04", bi.kf3c04a.isChecked() ? "1" : bi.kf3c04b.isChecked() ? "2" : "0");
        sa1.put("kf3c04c", bi.kf3c04c.getText().toString());

        sa1.put("kf3c05a", bi.kf3c05a.getText().toString());

        sa1.put("kf3c06", bi.kf3c06a.isChecked() ? "1" : bi.kf3c06b.isChecked() ? "2" : bi.kf3c06c.isChecked() ? "3" : bi.kf3c06d.isChecked() ? "4" : bi.kf3c06e.isChecked() ? "5" : "0");
        sa1.put("kf3c06f", bi.kf3c06f.getText().toString());

        sa1.put("kf3c07", bi.kf3c07a.isChecked() ? "1" : bi.kf3c07b.isChecked() ? "2" : "0");

        sa1.put("kf3c08a", bi.kf3c08a.isChecked() ? "1" : "0");
        sa1.put("kf3c08b", bi.kf3c08b.isChecked() ? "2" : "0");
        sa1.put("kf3c08c", bi.kf3c08c.isChecked() ? "3" : "0");
        sa1.put("kf3c08d", bi.kf3c08d.isChecked() ? "4" : "0");
        sa1.put("kf3c08e", bi.kf3c08e.getText().toString());

        sa1.put("kf3c09", bi.kf3c09a.isChecked() ? "1" : bi.kf3c09b.isChecked() ? "2" : "0");
        sa1.put("kf3c09c", bi.kf3c09c.getText().toString());

        sa1.put("kf3c10", bi.kf3c10a.isChecked() ? "1" : bi.kf3c10b.isChecked() ? "2" : "0");

        sa1.put("kf3c11a", bi.kf3c11a.getText().toString());

        sa1.put("kf3c12a", bi.kf3c12a.getText().toString());

        sa1.put("kf3c13a", bi.kf3c13a.getText().toString());

        sa1.put("kf3c14", bi.kf3c14.getText().toString());

        sa1.put("kf3c15", bi.kf3c15a.isChecked() ? "1" : bi.kf3c15b.isChecked() ? "2" : bi.kf3c1598.isChecked() ? "98" : "0");

        sa1.put("kf3c16a", bi.kf3c16a.isChecked() ? "1" : "0");
        sa1.put("kf3c16b", bi.kf3c16b.isChecked() ? "2" : "0");
        sa1.put("kf3c16c", bi.kf3c16c.isChecked() ? "3" : "0");
        sa1.put("kf3c16d", bi.kf3c16d.isChecked() ? "4" : "0");
        sa1.put("kf3c16e", bi.kf3c16e.isChecked() ? "5" : "0");
        sa1.put("kf3c16f", bi.kf3c16f.isChecked() ? "6" : "0");
        sa1.put("kf3c16g", bi.kf3c16g.isChecked() ? "7" : "0");
        sa1.put("kf3c16h", bi.kf3c16h.isChecked() ? "8" : "0");
        sa1.put("kf3c16i", bi.kf3c16i.isChecked() ? "9" : "0");
        sa1.put("kf3c16j", bi.kf3c16j.isChecked() ? "10" : "0");
        sa1.put("kf3c16x", bi.kf3c16x.getText().toString());

        sa1.put("kf3c17", bi.kf3c17a.isChecked() ? "1" : bi.kf3c17b.isChecked() ? "2" : "0");

        sa1.put("kf3c18a", bi.kf3c18a.isChecked() ? "1" : "0");
        sa1.put("kf3c18b", bi.kf3c18b.isChecked() ? "2" : "0");
        sa1.put("kf3c18c", bi.kf3c18c.isChecked() ? "3" : "0");
        sa1.put("kf3c18d", bi.kf3c18d.isChecked() ? "4" : "0");
        sa1.put("kf3c18e", bi.kf3c18e.isChecked() ? "5" : "0");
        sa1.put("kf3c18f", bi.kf3c18f.isChecked() ? "6" : "0");
        sa1.put("kf3c18x", bi.kf3c18x.getText().toString());

        sa1.put("kf3c19", bi.kf3c19a.isChecked() ? "1" : bi.kf3c19b.isChecked() ? "2" : bi.kf3c1998.isChecked() ? "98" : "0");

        sa1.put("kf3c20", bi.kf3c20a.isChecked() ? "1" : bi.kf3c20b.isChecked() ? "2" : bi.kf3c2098.isChecked() ? "98" : "0");

        sa1.put("kf3c21", bi.kf3c21a.isChecked() ? "1" : bi.kf3c21b.isChecked() ? "2" : bi.kf3c21c.isChecked() ? "3" : bi.kf3c21d.isChecked() ? "4" : "0");
        
        fc.setsC(String.valueOf(sa1));

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
                startActivity(new Intent(this, SectionDForm3Activity.class));

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

        int updcount = db.updateSC();

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
