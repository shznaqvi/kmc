package edu.aku.hassannaqvi.kmc_screening.ui.form3;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import edu.aku.hassannaqvi.kmc_screening.R;
import edu.aku.hassannaqvi.kmc_screening.core.DatabaseHelper;
import edu.aku.hassannaqvi.kmc_screening.core.MainApp;
import edu.aku.hassannaqvi.kmc_screening.databinding.ActivitySectionCForm3Binding;
import edu.aku.hassannaqvi.kmc_screening.ui.other.EndingActivity;
import edu.aku.hassannaqvi.kmc_screening.validation.ClearClass;
import edu.aku.hassannaqvi.kmc_screening.validation.ValidatorClass;

import static edu.aku.hassannaqvi.kmc_screening.core.MainApp.fc;

public class SectionCForm3Activity extends AppCompatActivity {

    ActivitySectionCForm3Binding bi;
    Boolean day1Flag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_c_form3);
        bi.setCallback(this);

        this.setTitle(R.string.f3_hC);
        setupViews();
    }

    private void setupViews() {

        day1Flag = getIntent().getBooleanExtra("day1", false);
        if (day1Flag) {
            bi.fldGrpCVkf3c05.setVisibility(View.GONE);
            bi.fldGrpCVkf3c13.setVisibility(View.GONE);
        } else
            //bi.fldGrpSecC02d.setVisibility(View.GONE);

        bi.kf3c01.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == bi.kf3c01a.getId())
                    bi.kf3c04.clearCheck();
            }
        });

        bi.kf3c07.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == bi.kf3c07b.getId())
                    ClearClass.ClearAllFields(bi.fldGrpSecC02b, null);
            }
        });

        bi.kf3c17.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == bi.kf3c17a.getId())
                    ClearClass.ClearAllFields(bi.fldGrpCVkf3c18, null);
            }
        });

        bi.kf3c1698.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b)
                    ClearClass.ClearAllFields(bi.fldGrpLLkf3c16, false);
                else
                    ClearClass.ClearAllFields(bi.fldGrpLLkf3c16, true);
            }
        });
    }

    public void BtnEnd() {
        MainApp.endActivity(this, this);
    }

    private void SaveDraft() throws JSONException {

        JSONObject sa1 = new JSONObject();

        sa1.put("kf3c01", bi.kf3c01a.isChecked() ? "1" : bi.kf3c01b.isChecked() ? "2" : "0");

        sa1.put("kf3c02", bi.kf3c02.getText().toString());

        sa1.put("kf3c03h", bi.kf3c03h.getText().toString());
        sa1.put("kf3c03m", bi.kf3c03m.getText().toString());

        sa1.put("kf3c04", bi.kf3c04a.isChecked() ? "1" : bi.kf3c04b.isChecked() ? "2" : bi.kf3c0496.isChecked() ? "96" : "0");
        sa1.put("kf3c0496x", bi.kf3c0496x.getText().toString());

        sa1.put("kf3c05", bi.kf3c05.getText().toString());

        sa1.put("kf3c06", bi.kf3c06a.isChecked() ? "1" : bi.kf3c06b.isChecked() ? "2" : bi.kf3c06c.isChecked() ? "3" : bi.kf3c06d.isChecked() ? "4" : bi.kf3c06e.isChecked() ? "5" : bi.kf3c0697.isChecked() ? "97" : bi.kf3c0696.isChecked() ? "96" : "0");
        sa1.put("kf3c0696x", bi.kf3c0696x.getText().toString());

        sa1.put("kf3c07", bi.kf3c07a.isChecked() ? "1" : bi.kf3c07b.isChecked() ? "2" : "0");

        sa1.put("kf3c08a", bi.kf3c08a.isChecked() ? "1" : "0");
        sa1.put("kf3c08b", bi.kf3c08b.isChecked() ? "2" : "0");
        sa1.put("kf3c08c", bi.kf3c08c.isChecked() ? "3" : "0");
        sa1.put("kf3c08d", bi.kf3c08d.isChecked() ? "4" : "0");
        sa1.put("kf3c08e", bi.kf3c08e.isChecked() ? "5" : "0");
        sa1.put("kf3c0896", bi.kf3c0896.isChecked() ? "96" : "0");
        sa1.put("kf3c0896x", bi.kf3c0896x.getText().toString());

        sa1.put("kf3c09", bi.kf3c09a.isChecked() ? "1" : bi.kf3c09b.isChecked() ? "2" : bi.kf3c0996.isChecked() ? "96" : "0");
        sa1.put("kf3c0996x", bi.kf3c0996x.getText().toString());

        sa1.put("kf3c10", bi.kf3c10a.isChecked() ? "1" : bi.kf3c10b.isChecked() ? "2" : "0");

        sa1.put("kf3c11", bi.kf3c11.getText().toString());
        sa1.put("kf3c12h", bi.kf3c12h.getText().toString());
        sa1.put("kf3c12m", bi.kf3c12m.getText().toString());
        sa1.put("kf3c13", bi.kf3c13.getText().toString());
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
        sa1.put("kf3c1698", bi.kf3c1698.isChecked() ? "98" : "0");
        sa1.put("kf3c1696", bi.kf3c1696.isChecked() ? "96" : "0");
        sa1.put("kf3c1696x", bi.kf3c1696x.getText().toString());

        sa1.put("kf3c17", bi.kf3c17a.isChecked() ? "1" : bi.kf3c17b.isChecked() ? "2" : "0");

        sa1.put("kf3c18a", bi.kf3c18a.isChecked() ? "1" : "0");
        sa1.put("kf3c18b", bi.kf3c18b.isChecked() ? "2" : "0");
        sa1.put("kf3c18c", bi.kf3c18c.isChecked() ? "3" : "0");
        sa1.put("kf3c18d", bi.kf3c18d.isChecked() ? "4" : "0");
        sa1.put("kf3c18e", bi.kf3c18e.isChecked() ? "5" : "0");
        sa1.put("kf3c18f", bi.kf3c18f.isChecked() ? "6" : "0");
        sa1.put("kf3c1896", bi.kf3c1896.isChecked() ? "96" : "0");
        sa1.put("kf3c1896x", bi.kf3c1896x.getText().toString());

        //sa1.put("kf3c19", bi.kf3c19a.isChecked() ? "1" : bi.kf3c19b.isChecked() ? "2" : bi.kf3c1998.isChecked() ? "98" : "0");

        //sa1.put("kf3c20", bi.kf3c20a.isChecked() ? "1" : bi.kf3c20b.isChecked() ? "2" : bi.kf3c2098.isChecked() ? "98" : "0");

        //sa1.put("kf3c21", bi.kf3c21a.isChecked() ? "1" : bi.kf3c21b.isChecked() ? "2" : bi.kf3c21c.isChecked() ? "3" : bi.kf3c21d.isChecked() ? "4" : bi.kf3c2198.isChecked() ? "98" : "0");
        //sa1.put("kf3c21bh", bi.kf3c21bh.getText().toString());
        //sa1.put("kf3c21cd", bi.kf3c21cd.getText().toString());

        fc.setsC(String.valueOf(sa1));

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
                startActivity(new Intent(this, bi.kf3c17a.isChecked() ? EndingActivity.class : SectionDForm3Activity.class)
                        .putExtra("complete", true).putExtra("day1", day1Flag));

            } else {
                Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
            }
        }


    }

    private boolean formValidation() {
        if (!ValidatorClass.EmptyCheckingContainer(this, bi.fldGrpSecC02))
            return false;


        if (bi.kf3c01a.isChecked()) {
            if (Integer.valueOf(bi.kf3c03h.getText().toString()) == 0 && Integer.valueOf(bi.kf3c03m.getText().toString()) == 0) {
                bi.kf3c03h.setError("Both values can't be zero!!");
                bi.kf3c03h.setFocusable(true);
                Toast.makeText(this, getString(R.string.kf3c03a) + ": Both values can't be zero!!", Toast.LENGTH_SHORT).show();
                return false;
            }
        }

        if (bi.kf3c10a.isChecked()) {
            if (Integer.valueOf(bi.kf3c12h.getText().toString()) == 0 && Integer.valueOf(bi.kf3c12m.getText().toString()) == 0) {
                bi.kf3c12h.setError("Both values can't be zero!!");
                bi.kf3c12h.setFocusable(true);
                Toast.makeText(this, getString(R.string.kf3c12a) + ": Both values can't be zero!!", Toast.LENGTH_SHORT).show();
                return false;
            }
        }

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
