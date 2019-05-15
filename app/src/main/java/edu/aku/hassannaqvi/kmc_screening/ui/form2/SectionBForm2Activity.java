package edu.aku.hassannaqvi.kmc_screening.ui.form2;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.RadioGroup;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import edu.aku.hassannaqvi.kmc_screening.R;
import edu.aku.hassannaqvi.kmc_screening.core.DatabaseHelper;
import edu.aku.hassannaqvi.kmc_screening.core.MainApp;
import edu.aku.hassannaqvi.kmc_screening.databinding.ActivitySectionBForm2Binding;
import edu.aku.hassannaqvi.kmc_screening.other.DateUtils;
import edu.aku.hassannaqvi.kmc_screening.validation.ClearClass;
import edu.aku.hassannaqvi.kmc_screening.validation.ValidatorClass;

import static edu.aku.hassannaqvi.kmc_screening.core.MainApp.fc;

public class SectionBForm2Activity extends AppCompatActivity {

    ActivitySectionBForm2Binding bi;
    String deviceID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_b_form2);
        bi.setCallback(this);

        setContentUI();
        setListeners();
    }

    private void setContentUI() {
        this.setTitle(R.string.f2_hB);
        bi.kf2b03.setMinDate(DateUtils.getUpdatedDate("dd-MM-yy HH:mm", -7));
    }

    public void BtnContinue() {
        if (!formValidation())
            return;

        try {
            SaveDraft();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (UpdateDB()) {
            finish();
            startActivity(new Intent(this, SectionCForm2Activity.class));
        } else {
            Toast.makeText(this, "Error in updating db!!", Toast.LENGTH_SHORT).show();
        }
    }

    private boolean UpdateDB() {

        DatabaseHelper db = new DatabaseHelper(this);
        long count = db.updateSA();
        if (count != -1) return true;

        Toast.makeText(this, "Error in updating DB", Toast.LENGTH_SHORT).show();
        return false;
    }

    private void SaveDraft() throws JSONException {

        JSONObject sa1 = new JSONObject();

        sa1.put("kf2b01", bi.kf2b01.getText().toString());
        sa1.put("kf2b02", bi.kf2b02.getText().toString());
        sa1.put("kf2b03", bi.kf2b03.getText().toString());
        sa1.put("kf2b04", bi.kf2b04.getText().toString());
        sa1.put("kf2b05", bi.kf2b05a.isChecked() ? "1" : bi.kf2b05b.isChecked() ? "2" : "0");
        sa1.put("kf2b06", bi.kf2b06a.isChecked() ? "1" : bi.kf2b06b.isChecked() ? "2" : bi.kf2b06c.isChecked() ? "3" : bi.kf2b0696.isChecked() ? "96" : "0");
        sa1.put("kf2b0696x", bi.kf2b0696x.getText().toString());
        sa1.put("kf2b07", bi.kf2b07a.isChecked() ? "1" : bi.kf2b07b.isChecked() ? "2" : "0");
        sa1.put("kf2b08", bi.kf2b08.getText().toString());
        sa1.put("kf2b09", bi.kf2b09a.isChecked() ? "1" : bi.kf2b09b.isChecked() ? "2" : "0");
        sa1.put("kf2b10", bi.kf2b10a.isChecked() ? "1" : bi.kf2b10b.isChecked() ? "2" : "0");
        sa1.put("kf2b10d", bi.kf2b10d.getText().toString());
        sa1.put("kf2b10m", bi.kf2b10m.getText().toString());
        sa1.put("kf2b11", bi.kf2b11.getText().toString());
        sa1.put("kf2b12", bi.kf2b12.getText().toString());
        sa1.put("kf2b13", bi.kf2b13.getText().toString());
        sa1.put("kf2b14", bi.kf2b14a.isChecked() ? "1" : bi.kf2b14b.isChecked() ? "2" : "0");
        sa1.put("kf2b15", bi.kf2b15a.isChecked() ? "1" : bi.kf2b15b.isChecked() ? "2" : "0");
        sa1.put("kf2b16a", bi.kf2b16a.isChecked() ? "1" : "0");
        sa1.put("kf2b16b", bi.kf2b16b.isChecked() ? "2" : "0");
        sa1.put("kf2b16c", bi.kf2b16c.isChecked() ? "3" : "0");
        sa1.put("kf2b16d", bi.kf2b16d.isChecked() ? "4" : "0");
        sa1.put("kf2b16e", bi.kf2b16e.isChecked() ? "5" : "0");
        sa1.put("kf2b16f", bi.kf2b16f.isChecked() ? "6" : "0");
        sa1.put("kf2b16g", bi.kf2b16g.isChecked() ? "7" : "0");
        sa1.put("kf2b16h", bi.kf2b16h.isChecked() ? "8" : "0");
        sa1.put("kf2b1696", bi.kf2b1696.isChecked() ? "9" : "0");
        sa1.put("kf2b1696x", bi.kf2b1696x.getText().toString());

        fc.setsB(String.valueOf(sa1));
    }


    private boolean formValidation() {
        return ValidatorClass.EmptyCheckingContainer(this, bi.fldGrpSecB02);
    }

    public void BtnEnd() {
        MainApp.endActivity(this, this);
    }


    private void setListeners() {

        bi.kf2b12.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (bi.kf2b12.getText().toString().isEmpty())
                    bi.kf2b13.setMax(9);
                else
                    bi.kf2b13.setMax(Float.valueOf(bi.kf2b12.getText().toString()));
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        bi.kf2b14.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == bi.kf2b14b.getId())
                    ClearClass.ClearAllFields(bi.fldGrpF2SecB01, null);
            }
        });

        bi.kf2b15.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == bi.kf2b15b.getId())
                    ClearClass.ClearAllFields(bi.fldGrpCVkf2b16, null);
            }
        });

        bi.kf2b10.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == bi.kf2b10a.getId()) {
                    bi.kf2b10d.setMax(1);
                    bi.kf2b10m.setMax(1);
                } else {
                    bi.kf2b10d.setMax(0);
                    bi.kf2b10m.setMax(0);
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        Toast.makeText(this, "You can't go back", Toast.LENGTH_SHORT).show();
    }
}
