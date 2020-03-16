package edu.aku.hassannaqvi.kmc_screening.ui.form3;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import edu.aku.hassannaqvi.kmc_screening.R;
import edu.aku.hassannaqvi.kmc_screening.core.DatabaseHelper;
import edu.aku.hassannaqvi.kmc_screening.core.MainApp;
import edu.aku.hassannaqvi.kmc_screening.databinding.ActivitySectionEForm3Binding;
import edu.aku.hassannaqvi.kmc_screening.validation.ClearClass;
import edu.aku.hassannaqvi.kmc_screening.validation.ValidatorClass;

import static edu.aku.hassannaqvi.kmc_screening.core.MainApp.fc;
import static edu.aku.hassannaqvi.kmc_screening.ui.SectionInfoKmcActivity.followupNo;

public class SectionEForm3Activity extends AppCompatActivity {

    ActivitySectionEForm3Binding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_e_form3);
        bi.setCallback(this);

        this.setTitle(R.string.f3_hE);
        setupListeners();

        if (followupNo == 6 || followupNo == 8) {
            bi.fldGrpSecE02e.setVisibility(View.VISIBLE);
        } else {
            ClearClass.ClearAllFields(bi.fldGrpSecE02e, null);
            bi.fldGrpSecE02e.setVisibility(View.GONE);
        }

        if (followupNo == 10 || followupNo == 11 || followupNo == 12) {
            bi.fldGrpSecE02d.setVisibility(View.GONE);
            ClearClass.ClearAllFields(bi.fldGrpSecE02d, null);
        } else {
            bi.fldGrpSecE02d.setVisibility(View.VISIBLE);
        }

    }

    private void setupListeners() {

       /* if (followupNo == 6 || followupNo == 8 || followupNo == 9 || followupNo == 10 || followupNo == 12) {
            bi.fldGrpSecE02.setVisibility(View.VISIBLE);
        }*/

        bi.kf3e02.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == bi.kf3e02b.getId())
                    bi.kf3e03.clearCheck();
            }
        });

        bi.kf3e13.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == bi.kf3e13a.getId())
                    ClearClass.ClearAllFields(bi.fldGrpSecE02b, null);
            }
        });

        bi.kf3e19.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == bi.kf3e19a.getId())
                    ClearClass.ClearAllFields(bi.fldGrpSecE02c, null);
            }
        });

        bi.kf3e20.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == bi.kf3e20a.getId())
                    bi.kf3e21.clearCheck();
            }
        });

        bi.kf3e12f.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b)
                    ClearClass.ClearAllFields(bi.fldGrpLLkf3e12, false);
                else
                    ClearClass.ClearAllFields(bi.fldGrpLLkf3e12, true);
            }
        });

        bi.kf3e04a.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                float no = bi.kf3e04a.getText().toString().isEmpty() ? 0f : Float.valueOf(bi.kf3e04a.getText().toString());

                if (no >= 38 || no <= 35.5) {
                    bi.kf3e04b.setVisibility(View.VISIBLE);
                    return;
                }

                bi.kf3e04b.setVisibility(View.GONE);
                bi.kf3e04b.setText(null);

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        bi.kf3e05.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                int no = bi.kf3e05.getText().toString().isEmpty() ? 0 : Integer.valueOf(bi.kf3e05.getText().toString());

                if (no >= 60) {
                    bi.fldGrpCVkf3e06.setVisibility(View.VISIBLE);
                    return;
                }

                bi.fldGrpCVkf3e06.setVisibility(View.GONE);
                bi.kf3e06.setText(null);

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

    }

    public void BtnEnd() {
        MainApp.endActivity(this, this);
    }

    private void SaveDraft() throws JSONException {

        JSONObject sa1 = new JSONObject();

        sa1.put("kf3e01", bi.kf3e01.getText().toString());

        sa1.put("kf3e22", bi.kf3e22.getText().toString());

        sa1.put("kf3e02", bi.kf3e02a.isChecked() ? "1" : bi.kf3e02b.isChecked() ? "2" : "0");

        sa1.put("kf3e03", bi.kf3e03a.isChecked() ? "1" : bi.kf3e03b.isChecked() ? "2" : bi.kf3e03c.isChecked() ? "3" : "0");

        sa1.put("kf3e04a", bi.kf3e04a.getText().toString());
        sa1.put("kf3e04b", bi.kf3e04b.getText().toString());

        sa1.put("kf3e05", bi.kf3e05.getText().toString());

        sa1.put("kf3e06", bi.kf3e06.getText().toString());

        sa1.put("kf3e07", bi.kf3e07a.isChecked() ? "1" : bi.kf3e07b.isChecked() ? "2" : "0");

        sa1.put("kf3e08", bi.kf3e08a.isChecked() ? "1" : bi.kf3e08b.isChecked() ? "2" : "0");

        sa1.put("kf3e09", bi.kf3e09a.isChecked() ? "1" : bi.kf3e09b.isChecked() ? "2" : "0");

        sa1.put("kf3e10", bi.kf3e10a.isChecked() ? "1" : bi.kf3e10b.isChecked() ? "2" : "0");

        sa1.put("kf3e11", bi.kf3e11a.isChecked() ? "1" : bi.kf3e11b.isChecked() ? "2" : "0");

        sa1.put("kf3e12a", bi.kf3e12a.isChecked() ? "1" : "0");
        sa1.put("kf3e12b", bi.kf3e12b.isChecked() ? "2" : "0");
        sa1.put("kf3e12c", bi.kf3e12c.isChecked() ? "3" : "0");
        sa1.put("kf3e12d", bi.kf3e12d.isChecked() ? "4" : "0");
        sa1.put("kf3e12e", bi.kf3e12e.isChecked() ? "5" : "0");
        sa1.put("kf3e12f", bi.kf3e12f.isChecked() ? "6" : "0");

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

        if (formValidation()) {
            try {
                SaveDraft();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (UpdateDB()) {
                finish();
                //startActivity(new Intent(this, MainApp.armType.equals("1") ? SectionFForm3Activity.class : EndingActivity.class).putExtra("complete", true));
                startActivity(new Intent(this, SectionFForm3Activity.class));

            } else {
                Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
            }
        }

    }

    private boolean formValidation() {
        return ValidatorClass.EmptyCheckingContainer(this, bi.fldGrpSecE02);
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
