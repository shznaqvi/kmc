package edu.aku.hassannaqvi.kmc.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;

import edu.aku.hassannaqvi.kmc.R;
import edu.aku.hassannaqvi.kmc.contracts.FormsContract;
import edu.aku.hassannaqvi.kmc.core.DatabaseHelper;
import edu.aku.hassannaqvi.kmc.core.MainApp;
import edu.aku.hassannaqvi.kmc.databinding.ActivitySectionA2Binding;
import edu.aku.hassannaqvi.kmc.databinding.ActivitySectionA3Binding;
import edu.aku.hassannaqvi.kmc.validation.validatorClass;

public class SectionA2Activity extends AppCompatActivity {
ActivitySectionA2Binding bi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this,R.layout.activity_section_a2);
        bi.setCallback(this);
    }


    public void BtnEnd() {
        if (formValidation()) {
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
        }
    }

    public void BtnContinue() {

        if (formValidation()) {
            try {
                SaveDraft();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (UpdateDB()) {
                Toast.makeText(this, "Starting Ending Section", Toast.LENGTH_SHORT).show();

                finish();

                startActivity(new Intent(this, SectionA3Activity.class));
                //startActivity(new Intent(this, MainActivity.class));

            } else {
                Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private boolean formValidation() {

        if (!validatorClass.EmptyRadioButton(this, bi.kab01, bi.kab01a, getString(R.string.kab01))) {
            return false;
        }
        if (bi.kab01a.isChecked()) {
            if (!validatorClass.EmptyTextBox(this, bi.kab02, getString(R.string.kab02))) {
                return false;
            }
        }
        if (!validatorClass.EmptyRadioButton(this, bi.kab03, bi.kab03a, getString(R.string.kab03))) {
            return false;
        }
        if (bi.kab03a.isChecked()) {

            if (!validatorClass.EmptyTextBox(this, bi.kab04, getString(R.string.kab04))) {
                return false;
            }
        }
        if (!validatorClass.EmptyRadioButton(this, bi.kab05, bi.kab05a, getString(R.string.kab05))) {
            return false;
        }
        if (bi.kab05a.isChecked()) {

            if (!validatorClass.EmptyTextBox(this, bi.kab06, getString(R.string.kab06))) {
                return false;
            }
        }
        if (!validatorClass.EmptyRadioButton(this, bi.kab07, bi.kab07a, getString(R.string.kab07))) {
            return false;
        }
        if (bi.kab07a.isChecked()) {

            if (!validatorClass.EmptyTextBox(this, bi.kab08, getString(R.string.kab08))) {
                return false;
            }
        }
        if (!validatorClass.EmptyRadioButton(this, bi.kab09, bi.kab09a, getString(R.string.kab09))) {
            return false;
        }
        if (bi.kab09a.isChecked()) {

            if (!validatorClass.EmptyTextBox(this, bi.kab10, getString(R.string.kab10))) {
                return false;
            }
        }
        if (!validatorClass.EmptyRadioButton(this, bi.kab11, bi.kab11a, getString(R.string.kab11))) {
            return false;
        }
        if (bi.kab11a.isChecked()) {

            if (!validatorClass.EmptyTextBox(this, bi.kab12, getString(R.string.kab12))) {
                return false;
            }
        }
        if (!validatorClass.EmptyRadioButton(this, bi.kab13, bi.kab13a, getString(R.string.kab13))) {
            return false;
        }
        if (bi.kab13a.isChecked()) {

            if (!validatorClass.EmptyTextBox(this, bi.kab14, getString(R.string.kab14))) {
                return false;
            }
        }


        return true;
    }


    private void SaveDraft() throws JSONException {

        JSONObject sInfo = new JSONObject();
        sInfo.put("kab01", bi.kab01a.isChecked() ? "1"
                : bi.kab01b.isChecked() ? "2"
                : "0");
        sInfo.put("kab02", bi.kab02.getText().toString());

        sInfo.put("kab03", bi.kab03a.isChecked() ? "1"
                : bi.kab03b.isChecked() ? "2"
                : "0");
        sInfo.put("kab04", bi.kab04.getText().toString());
        sInfo.put("kab05", bi.kab05a.isChecked() ? "1"
                : bi.kab05b.isChecked() ? "2"
                : "0");
        sInfo.put("kab06", bi.kab06.getText().toString());

        sInfo.put("kab07", bi.kab07a.isChecked() ? "1"
                : bi.kab07b.isChecked() ? "2"
                : "0");
        sInfo.put("kab08", bi.kab08.getText().toString());
        sInfo.put("kab09", bi.kab09a.isChecked() ? "1"
                : bi.kab09b.isChecked() ? "2"
                : "0");
        sInfo.put("kab10", bi.kab10.getText().toString());

        sInfo.put("kab11", bi.kab11a.isChecked() ? "1"
                : bi.kab11b.isChecked() ? "2"
                : "0");
        sInfo.put("kab12", bi.kab12.getText().toString());
        sInfo.put("kab13", bi.kab13a.isChecked() ? "1"
                : bi.kab13b.isChecked() ? "2"
                : "0");
        sInfo.put("kab014", bi.kab14.getText().toString());


        MainApp.fc.setsa2(String.valueOf(sInfo));

    }

    private boolean UpdateDB() {

        //Long rowId;
        DatabaseHelper db = new DatabaseHelper(this);

        int updcount = db.updateSA2();

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
