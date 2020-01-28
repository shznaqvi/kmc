package edu.aku.hassannaqvi.kmc_screening.ui.form1;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import edu.aku.hassannaqvi.kmc_screening.R;
import edu.aku.hassannaqvi.kmc_screening.core.DatabaseHelper;
import edu.aku.hassannaqvi.kmc_screening.core.MainApp;
import edu.aku.hassannaqvi.kmc_screening.databinding.ActivitySectionAForm1Binding;
import edu.aku.hassannaqvi.kmc_screening.ui.other.EndingActivity;
import edu.aku.hassannaqvi.kmc_screening.validation.ClearClass;
import edu.aku.hassannaqvi.kmc_screening.validation.ValidatorClass;

import static edu.aku.hassannaqvi.kmc_screening.core.MainApp.fc;

public class SectionAForm1Activity extends AppCompatActivity {

    ActivitySectionAForm1Binding bi;
    List<RadioButton> rdbEligibilityCheckIDs;
    List<RadioButton> q04rdbCheckID;
    List<RadioButton> q04rdaCheckID;
    boolean question04Flag;
    boolean flag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_a_form1);
        bi.setCallback(this);

        setContentUI();
        setListeners();

    }

    private void setContentUI() {
        this.setTitle(R.string.f1_secb);

        rdbEligibilityCheckIDs = new ArrayList<>(Arrays.asList(
                bi.kf1b0501b, bi.kf1b0502b, bi.kf1b0503b, bi.kf1b0504b, bi.kf1b0596b, bi.kf1b06b, bi.kf1b0602a));

        q04rdbCheckID = new ArrayList<>(Arrays.asList(bi.kf1b0401b, bi.kf1b0402b, bi.kf1b0403b, bi.kf1b0404b, bi.kf1b0405b, bi.kf1b0406b,
                bi.kf1b0407b, bi.kf1b0408b, bi.kf1b0409b, bi.kf1b0410b, bi.kf1b0411b, bi.kf1b0412b, bi.kf1b0413b, bi.kf1b0414b, bi.kf1b0415b));

        q04rdaCheckID = new ArrayList<>(Arrays.asList(bi.kf1b0401a, bi.kf1b0402a, bi.kf1b0403a, bi.kf1b0404a, bi.kf1b0405a, bi.kf1b0406a,
                bi.kf1b0407a, bi.kf1b0408a, bi.kf1b0409a, bi.kf1b0410a, bi.kf1b0411a, bi.kf1b0412a, bi.kf1b0413a, bi.kf1b0414a, bi.kf1b0415a));
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
            startActivity(new Intent(this, EndingActivity.class).putExtra("complete", true));
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

        sa1.put("kf1b01", bi.kf1b01.getText().toString());
        sa1.put("kf1b02", bi.kf1b02a.isChecked() ? "1" : bi.kf1b02b.isChecked() ? "2" : "0");
        sa1.put("kf1b03", bi.kf1b03a.isChecked() ? "1" : bi.kf1b03b.isChecked() ? "2" : "0");
        sa1.put("kf1b0401", bi.kf1b0401a.isChecked() ? "1" : bi.kf1b0401b.isChecked() ? "2" : "0");
        sa1.put("kf1b0402", bi.kf1b0402a.isChecked() ? "1" : bi.kf1b0402b.isChecked() ? "2" : "0");
        sa1.put("kf1b0403", bi.kf1b0403a.isChecked() ? "1" : bi.kf1b0403b.isChecked() ? "2" : "0");
        sa1.put("kf1b0404", bi.kf1b0404a.isChecked() ? "1" : bi.kf1b0404b.isChecked() ? "2" : "0");
        sa1.put("kf1b0405", bi.kf1b0405a.isChecked() ? "1" : bi.kf1b0405b.isChecked() ? "2" : "0");
        sa1.put("kf1b0406", bi.kf1b0406a.isChecked() ? "1" : bi.kf1b0406b.isChecked() ? "2" : "0");
        sa1.put("kf1b0407", bi.kf1b0407a.isChecked() ? "1" : bi.kf1b0407b.isChecked() ? "2" : "0");
        sa1.put("kf1b0408", bi.kf1b0408a.isChecked() ? "1" : bi.kf1b0408b.isChecked() ? "2" : "0");
        sa1.put("kf1b0409", bi.kf1b0409a.isChecked() ? "1" : bi.kf1b0409b.isChecked() ? "2" : "0");
        sa1.put("kf1b0410", bi.kf1b0410a.isChecked() ? "1" : bi.kf1b0410b.isChecked() ? "2" : "0");
        sa1.put("kf1b0411", bi.kf1b0411a.isChecked() ? "1" : bi.kf1b0411b.isChecked() ? "2" : "0");
        sa1.put("kf1b0412", bi.kf1b0412a.isChecked() ? "1" : bi.kf1b0412b.isChecked() ? "2" : "0");
        sa1.put("kf1b0413", bi.kf1b0413a.isChecked() ? "1" : bi.kf1b0413b.isChecked() ? "2" : "0");
        sa1.put("kf1b0414", bi.kf1b0414a.isChecked() ? "1" : bi.kf1b0414b.isChecked() ? "2" : "0");
        sa1.put("kf1b0415", bi.kf1b0415a.isChecked() ? "1" : bi.kf1b0415b.isChecked() ? "2" : "0");
        sa1.put("kf1b0501", bi.kf1b0501a.isChecked() ? "1" : bi.kf1b0501b.isChecked() ? "2" : "0");
        sa1.put("kf1b0502", bi.kf1b0502a.isChecked() ? "1" : bi.kf1b0502b.isChecked() ? "2" : "0");
        sa1.put("kf1b0503", bi.kf1b0503a.isChecked() ? "1" : bi.kf1b0503b.isChecked() ? "2" : "0");
        sa1.put("kf1b0504", bi.kf1b0504a.isChecked() ? "1" : bi.kf1b0504b.isChecked() ? "2" : "0");
        sa1.put("kf1b0596", bi.kf1b0596a.isChecked() ? "1" : bi.kf1b0596b.isChecked() ? "2" : "0");
        sa1.put("kf1b0596x", bi.kf1b0596x.getText().toString());
        sa1.put("kf1b06", bi.kf1b06a.isChecked() ? "1" : bi.kf1b06b.isChecked() ? "2" : "0");
        sa1.put("kf1b0602", bi.kf1b0602a.isChecked() ? "1" : bi.kf1b0602b.isChecked() ? "2" : "0");
        sa1.put("kf1b07", bi.kf1b07a.isChecked() ? "1" : bi.kf1b07b.isChecked() ? "2" : "0");
        sa1.put("kf1b08", bi.kf1b08a.isChecked() ? "1" : bi.kf1b08b.isChecked() ? "2" : "0");
        sa1.put("kf1b09", bi.kf1b09a.isChecked() ? "1" : bi.kf1b09b.isChecked() ? "2" : bi.kf1b0996.isChecked() ? "96" : "0");
        sa1.put("kf1b0996x", bi.kf1b0996x.getText().toString());
        sa1.put("kf1b10", bi.kf1b10a.isChecked() ? "1" : bi.kf1b10b.isChecked() ? "2" : "0");
        sa1.put("kf1b11", bi.kf1b11.getText().toString());

        fc.setsA(String.valueOf(sa1));
    }

    private boolean formValidation() {
        return ValidatorClass.EmptyCheckingContainer(this, bi.fldGrpSecB01);
    }

    public void BtnEnd() {
        MainApp.endActivity(this, this);
    }

    private void setListeners() {

        bi.kf1b10.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i != bi.kf1b10a.getId()) {
                    ClearClass.ClearAllFields(bi.fldGrpCVkf1b11, null);
                }
            }
        });

        bi.kf1b08.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == bi.kf1b08a.getId())
                    bi.kf1b09.clearCheck();
                else
                    bi.kf1b10.clearCheck();
            }
        });

        bi.kf1b07.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == bi.kf1b07b.getId())
                    ClearClass.ClearAllFields(bi.fldGrpF1Sec07, null);
            }
        });


        bi.kf1b10.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == bi.kf1b10a.getId())
                    bi.kf1b11.setText(getIntent().getStringExtra("pwid"));
                else
                    bi.kf1b11.setText(null);
            }
        });

    }

    public void weightChanged(CharSequence s, int start, int before, int count) {
        if (bi.kf1b01.getText().toString().isEmpty()) return;

        if (Integer.valueOf(bi.kf1b01.getText().toString()) > 1200 && Integer.valueOf(bi.kf1b01.getText().toString()) <= 2200)
            bi.kf1b02a.setChecked(true);
        else
            bi.kf1b02b.setChecked(true);
    }

    public void onRadioClickChanged(RadioGroup radioGroup, int id) {
        if (radioGroup.getCheckedRadioButtonId() == bi.kf1b02b.getId())
            ClearClass.ClearAllFields(bi.fldGrpF1Sec01, null);
        if (radioGroup.getCheckedRadioButtonId() == bi.kf1b03b.getId())
            ClearClass.ClearAllFields(bi.fldGrpF1Sec01, null);
    }

    public void onRadioEligibilityChecked(RadioGroup radioGroup, int id) {
        flag = true;
        for (RadioButton rdbID : rdbEligibilityCheckIDs) {
            if (!rdbID.isChecked()) {
                flag = false;
                break;
            }
        }

        bi.kf1b07.check(flag && question04Flag ? bi.kf1b07a.getId() : bi.kf1b07b.getId());
    }

    public void onRadioQuestion04CheckID(RadioGroup radioGroup, int id) {
        question04Flag = true;
        int count = 0;
        for (RadioButton rdbID : q04rdbCheckID) {
            if (!rdbID.isChecked()) {
                /*count++;
                if (count < 3 || count > 3) {
                    question04Flag = true;
                    break;
                }*/
                question04Flag = false;
                break;
            }

        }

        for (RadioButton rdbID : q04rdaCheckID) {

            if (rdbID.isChecked())
                count++;

        }

        question04Flag = count <= 1;


        bi.kf1b07.check(flag && question04Flag ? bi.kf1b07a.getId() : bi.kf1b07b.getId());


    }

    @Override
    public void onBackPressed() {
        Toast.makeText(this, "You can't go back", Toast.LENGTH_SHORT).show();
    }

}





