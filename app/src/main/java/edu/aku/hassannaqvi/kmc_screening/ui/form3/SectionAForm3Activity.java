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
import edu.aku.hassannaqvi.kmc_screening.databinding.ActivitySectionAForm3Binding;
import edu.aku.hassannaqvi.kmc_screening.ui.other.EndingActivity;

import static edu.aku.hassannaqvi.kmc_screening.core.MainApp.fc;

public class SectionAForm3Activity extends AppCompatActivity {


    ActivitySectionAForm3Binding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_a_form3);
        bi.setCallback(this);

    }

    private void SaveDraft() throws JSONException {

        JSONObject sa1 = new JSONObject();

        sa1.put("kf3a01", bi.kf3a01a.isChecked() ? "1" : bi.kf3a01b.isChecked() ? "2" : "0");

        sa1.put("kf3a02", bi.kf3a02a.isChecked() ? "1" : bi.kf3a02b.isChecked() ? "2" : "0");
        
        sa1.put("kf3a03x", bi.kf3a03x.getText().toString());

        sa1.put("kf3a04x", bi.kf3a04x.getText().toString());

        sa1.put("kf3a05x", bi.kf3a05x.getText().toString());

        sa1.put("kf3a06x", bi.kf3a06x.getText().toString());

        sa1.put("kf3a07x", bi.kf3a07x.getText().toString());

        fc.setsA(String.valueOf(sa1));
        
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
            Toast.makeText(this, "Starting Ending Section", Toast.LENGTH_SHORT).show();

            finish();

            startActivity(new Intent(this, EndingActivity.class).putExtra("complete", true));

        } else {
            Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
        }
        //}


    }

    private boolean formValidation() {
        return true;
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
                startActivity(new Intent(this, SectionBForm3Activity.class));

            } else {
                Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
            }
        }

    }

    private boolean UpdateDB() {

        DatabaseHelper db = new DatabaseHelper(this);

        int updcount = db.updateSA();

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
