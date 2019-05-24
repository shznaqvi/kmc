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
import edu.aku.hassannaqvi.kmc_screening.databinding.ActivitySectionDForm3Binding;
import edu.aku.hassannaqvi.kmc_screening.validation.ClearClass;
import edu.aku.hassannaqvi.kmc_screening.validation.ValidatorClass;

import static edu.aku.hassannaqvi.kmc_screening.core.MainApp.fc;

public class SectionDForm3Activity extends AppCompatActivity {

    ActivitySectionDForm3Binding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_d_form3);
        bi.setCallback(this);

        this.setTitle(R.string.f3_hD);
        setupListeners();

    }

    private void setupListeners() {

        Boolean day1Flag = getIntent().getBooleanExtra("day1", false);
        if (!day1Flag) {
            bi.fldGrpSecD02a.setVisibility(View.GONE);

        }

        bi.kf3d01.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i != bi.kf3d01e.getId())
                    bi.kf3d02.clearCheck();
            }
        });

        bi.kf3d04.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == bi.kf3d04a.getId())
                    bi.kf3d05.clearCheck();
            }
        });

        bi.kf3d06.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == bi.kf3d06a.getId())
                    bi.kf3d07.clearCheck();
            }
        });

        bi.kf3d08.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == bi.kf3d08a.getId())
                    ClearClass.ClearAllFields(bi.fldGrpSecD02b, null);
            }
        });

        bi.kf3d15.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == bi.kf3d15b.getId())
                    ClearClass.ClearAllFields(bi.fldGrpSecD02c, null);
            }
        });

        bi.kf3d1797.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b)
                    ClearClass.ClearAllFields(bi.fldGrpLLkf3d17, false);
                else
                    ClearClass.ClearAllFields(bi.fldGrpLLkf3d17, true);
            }
        });

        bi.kf3d1698.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b)
                    ClearClass.ClearAllFields(bi.fldGrpSecD02d, false);
                else
                    ClearClass.ClearAllFields(bi.fldGrpSecD02d, true);
            }
        });

    }

    public void BtnEnd() {
        MainApp.endActivity(this, this);
    }

    private void SaveDraft() throws JSONException {

        JSONObject sa1 = new JSONObject();
        sa1.put("kf3d01", bi.kf3d01a.isChecked() ? "1"
                : bi.kf3d01b.isChecked() ? "2"
                : bi.kf3d01c.isChecked() ? "3"
                : bi.kf3d01d.isChecked() ? "4"
                : bi.kf3d01e.isChecked() ? "5"
                : bi.kf3d0196.isChecked() ? "96"
                : "0");
        sa1.put("kf3d0196x", bi.kf3d0196x.getText().toString());

        sa1.put("kf3d02", bi.kf3d02a.isChecked() ? "1"
                : bi.kf3d02b.isChecked() ? "2"
                : bi.kf3d02c.isChecked() ? "3"
                : bi.kf3d02d.isChecked() ? "4"
                : bi.kf3d02e.isChecked() ? "5"
                : bi.kf3d02f.isChecked() ? "6"
                : bi.kf3d02g.isChecked() ? "7"
                : bi.kf3d02h.isChecked() ? "8"
                : bi.kf3d02i.isChecked() ? "9"
                : bi.kf3d02j.isChecked() ? "10"
                : bi.kf3d0296.isChecked() ? "96"
                : "0");
        sa1.put("kf3d0296x", bi.kf3d0296x.getText().toString());

        sa1.put("kf3d03", bi.kf3d03a.isChecked() ? "1"
                : bi.kf3d03b.isChecked() ? "2"
                : bi.kf3d03c.isChecked() ? "3"
                : bi.kf3d03d.isChecked() ? "4"
                : bi.kf3d03e.isChecked() ? "5"
                : bi.kf3d0396.isChecked() ? "96"
                : "0");
        sa1.put("kf3d0396x", bi.kf3d0396x.getText().toString());

        sa1.put("kf3d04", bi.kf3d04a.isChecked() ? "1" : bi.kf3d04b.isChecked() ? "2" : bi.kf3d0498.isChecked() ? "98" : "0");

        sa1.put("kf3d05", bi.kf3d05a.isChecked() ? "1"
                : bi.kf3d05b.isChecked() ? "2"
                : bi.kf3d05c.isChecked() ? "3"
                : bi.kf3d05d.isChecked() ? "4"
                : bi.kf3d05e.isChecked() ? "5"
                : bi.kf3d05f.isChecked() ? "6"
                : bi.kf3d05g.isChecked() ? "7"
                : bi.kf3d05h.isChecked() ? "8"
                : bi.kf3d05i.isChecked() ? "9"
                : bi.kf3d05j.isChecked() ? "10"
                : bi.kf3d05k.isChecked() ? "11"
                : bi.kf3d05l.isChecked() ? "12"
                : bi.kf3d05m.isChecked() ? "13"
                : bi.kf3d05n.isChecked() ? "14"
                : bi.kf3d0596.isChecked() ? "96"
                : "0");
        sa1.put("kf3d0596x", bi.kf3d0596x.getText().toString());

        sa1.put("kf3d06", bi.kf3d06a.isChecked() ? "1" : bi.kf3d06b.isChecked() ? "2" : "0");

        sa1.put("kf3d07", bi.kf3d07a.isChecked() ? "1"
                : bi.kf3d07b.isChecked() ? "2"
                : bi.kf3d07c.isChecked() ? "3"
                : bi.kf3d07d.isChecked() ? "4"
                : bi.kf3d07e.isChecked() ? "5"
                : bi.kf3d07f.isChecked() ? "6"
                : bi.kf3d07g.isChecked() ? "7"
                : bi.kf3d07h.isChecked() ? "8"
                : bi.kf3d07i.isChecked() ? "9"
                : bi.kf3d07j.isChecked() ? "10"
                : bi.kf3d0796.isChecked() ? "96"
                : "0");
        sa1.put("kf3d0796x", bi.kf3d0796x.getText().toString());

        sa1.put("kf3d08", bi.kf3d08a.isChecked() ? "1" : bi.kf3d08b.isChecked() ? "2" : "0");

        sa1.put("kf3d09", bi.kf3d09a.isChecked() ? "1" : bi.kf3d09b.isChecked() ? "2" : "0");

        sa1.put("kf3d10", bi.kf3d10a.isChecked() ? "1"
                : bi.kf3d10b.isChecked() ? "2"
                : bi.kf3d10c.isChecked() ? "3"
                : "0");
        sa1.put("kf3d1096x", bi.kf3d1096x.getText().toString());

        sa1.put("kf3d11", bi.kf3d11.getText().toString());

        sa1.put("kf3d12", bi.kf3d12a.isChecked() ? "1" : bi.kf3d12b.isChecked() ? "2" : "0");

        sa1.put("kf3d13", bi.kf3d13.getText().toString());

        sa1.put("kf3d14", bi.kf3d14.getText().toString());

        sa1.put("kf3d15", bi.kf3d15a.isChecked() ? "1" : bi.kf3d15b.isChecked() ? "2" : "0");

        sa1.put("kf3d16h", bi.kf3d16h.getText().toString());
        sa1.put("kf3d16d", bi.kf3d16d.getText().toString());
        sa1.put("kf3d16w", bi.kf3d16w.getText().toString());

        sa1.put("kf3d17a", bi.kf3d17a.isChecked() ? "1" : "0");
        sa1.put("kf3d17b", bi.kf3d17b.isChecked() ? "2" : "0");
        sa1.put("kf3d17c", bi.kf3d17c.isChecked() ? "3" : "0");
        sa1.put("kf3d17d", bi.kf3d17d.isChecked() ? "4" : "0");
        sa1.put("kf3d17e", bi.kf3d17e.isChecked() ? "5" : "0");
        sa1.put("kf3d17f", bi.kf3d17f.isChecked() ? "6" : "0");
        sa1.put("kf3d17g", bi.kf3d17g.isChecked() ? "7" : "0");
        sa1.put("kf3d17h", bi.kf3d17h.isChecked() ? "8" : "0");
        sa1.put("kf3d17i", bi.kf3d17i.isChecked() ? "9" : "0");
        sa1.put("kf3d17j", bi.kf3d17j.isChecked() ? "10" : "0");
        sa1.put("kf3d1797", bi.kf3d1797.isChecked() ? "97" : "0");
        sa1.put("kf3d1796", bi.kf3d1796.isChecked() ? "96" : "0");
        sa1.put("kf3d1796x", bi.kf3d1796x.getText().toString());

        sa1.put("kf3d18", bi.kf3d18.getText().toString());

        fc.setsD(String.valueOf(sa1));

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
                startActivity(new Intent(this, SectionEForm3Activity.class));

            } else {
                Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
            }
        }


    }

    private boolean formValidation() {
        if (!ValidatorClass.EmptyCheckingContainer(this, bi.fldGrpSecD02))
            return false;


        if (bi.kf3d15a.isChecked()) {
            if (Integer.valueOf(bi.kf3d16h.getText().toString()) == 0 && Integer.valueOf(bi.kf3d16d.getText().toString()) == 00 && Integer.valueOf(bi.kf3d16w.getText().toString()) == 0) {
                bi.kf3d16w.setError("All values can't be zero!!");
                bi.kf3d16w.setFocusable(true);
                Toast.makeText(this, getString(R.string.kf3d16) + ": All values can't be zero!!", Toast.LENGTH_SHORT).show();
                return false;
            }
        }

        return true;
    }

    private boolean UpdateDB() {

        DatabaseHelper db = new DatabaseHelper(this);

        int updcount = db.updateSD();

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
