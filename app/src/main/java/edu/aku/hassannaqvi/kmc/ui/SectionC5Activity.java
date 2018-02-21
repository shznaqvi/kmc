package edu.aku.hassannaqvi.kmc.ui;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import edu.aku.hassannaqvi.kmc.R;
import edu.aku.hassannaqvi.kmc.contracts.FamilyMembersContract;
import edu.aku.hassannaqvi.kmc.core.DatabaseHelper;
import edu.aku.hassannaqvi.kmc.core.MainApp;
import edu.aku.hassannaqvi.kmc.databinding.ActivitySectionC5Binding;
import edu.aku.hassannaqvi.kmc.validation.validatorClass;

public class SectionC5Activity extends AppCompatActivity {

    ActivitySectionC5Binding bi;
    FamilyMembersContract selectedChild;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_section_c5);

        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_c5);
        bi.setCallback(this);

        //Get Intent
        selectedChild = (FamilyMembersContract) getIntent().getSerializableExtra("selectedChild");
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

                MainApp.endActivityMother(this, this, true);

            } else {
                Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
            }
        }

    }

    public void BtnEnd() {
        MainApp.endActivityMother(this, this, false);
    }

    private boolean formValidation() {
        Toast.makeText(this, "Validating This Section ", Toast.LENGTH_SHORT).show();

        if (!validatorClass.EmptyRadioButton(this, bi.nc503, bi.nc503a, getString(R.string.nc503))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, bi.nc504, bi.nc504a, getString(R.string.nc504))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, bi.nc505, bi.nc505a, getString(R.string.nc505))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, bi.nc506, bi.nc506a, getString(R.string.nc506))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, bi.nc507, bi.nc507a, getString(R.string.nc507))) {
            return false;
        }
        return validatorClass.EmptyRadioButton(this, bi.nc508, bi.nc508a, getString(R.string.nc508));

    }

    private void SaveDraft() throws JSONException {
        Toast.makeText(this, "Saving Draft for  This Section", Toast.LENGTH_SHORT).show();

        JSONObject sC5 = new JSONObject();

//        nc301
        sC5.put("nc501", selectedChild.getName());
//        nc302
        sC5.put("nc502Serial", selectedChild.getSerialNo());

//        nc503
        sC5.put("nc503", bi.nc503a.isChecked() ? "1"
                : bi.nc503b.isChecked() ? "2"
                : bi.nc503c.isChecked() ? "3"
                : bi.nc503d.isChecked() ? "4"
                : "0");
//        nc504
        sC5.put("nc504", bi.nc504a.isChecked() ? "1"
                : bi.nc504b.isChecked() ? "2"
                : bi.nc504c.isChecked() ? "3"
                : bi.nc504d.isChecked() ? "4"
                : "0");
//        nc505
        sC5.put("nc505", bi.nc505a.isChecked() ? "1"
                : bi.nc505b.isChecked() ? "2"
                : bi.nc505c.isChecked() ? "3"
                : bi.nc505d.isChecked() ? "4"
                : "0");
//        nc506
        sC5.put("nc506", bi.nc506a.isChecked() ? "1"
                : bi.nc506b.isChecked() ? "2"
                : bi.nc506c.isChecked() ? "3"
                : bi.nc506d.isChecked() ? "4"
                : "0");
//        nc507
        sC5.put("nc507", bi.nc507a.isChecked() ? "1"
                : bi.nc507b.isChecked() ? "2"
                : bi.nc507c.isChecked() ? "3"
                : bi.nc507d.isChecked() ? "4"
                : "0");
//        nc508
        sC5.put("nc508", bi.nc508a.isChecked() ? "1"
                : bi.nc508b.isChecked() ? "2"
                : bi.nc508c.isChecked() ? "3"
                : bi.nc508d.isChecked() ? "4"
                : "0");

        MainApp.cc.setsC5(String.valueOf(sC5));

        Toast.makeText(this, "Validation Successful! - Saving Draft...", Toast.LENGTH_SHORT).show();
    }

    private boolean UpdateDB() {

        //Long rowId;
        DatabaseHelper db = new DatabaseHelper(this);

        int updcount = db.updateSC5();

        if (updcount == 1) {
            Toast.makeText(this, "Updating Database... Successful!", Toast.LENGTH_SHORT).show();
            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }

    }


}
