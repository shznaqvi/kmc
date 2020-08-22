package edu.aku.hassannaqvi.kmc_screening.ui.form3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import org.json.JSONException;
import org.json.JSONObject;

import edu.aku.hassannaqvi.kmc_screening.R;
import edu.aku.hassannaqvi.kmc_screening.core.DatabaseHelper;
import edu.aku.hassannaqvi.kmc_screening.core.MainApp;
import edu.aku.hassannaqvi.kmc_screening.databinding.ActivitySectionGForm3Binding;
import edu.aku.hassannaqvi.kmc_screening.validation.ClearClass;
import edu.aku.hassannaqvi.kmc_screening.validation.ValidatorClass;

import static edu.aku.hassannaqvi.kmc_screening.core.MainApp.fc;
import static edu.aku.hassannaqvi.kmc_screening.ui.SectionInfoKmcActivity.followupNo;

public class SectionGForm3Activity extends AppCompatActivity {

    ActivitySectionGForm3Binding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_g_form3);
        bi.setCallback(this);
        this.setTitle(R.string.kf3gh0);
        setupListeners();

    }

    private void setupListeners() {

        Boolean day1Flag = getIntent().getBooleanExtra("day1", false);
        if (!day1Flag) {
            bi.fldGrpSecG01.setVisibility(View.GONE);

            if (followupNo == 11 || followupNo == 12) {
                bi.fldGrpSecG01.setVisibility(View.VISIBLE);
            }

        }

        bi.kf3g08.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i != bi.kf3g08a.getId())
                    ClearClass.ClearAllFields(bi.fldGrpCVkf3g09, null);
            }
        });

        bi.kf3g10.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i != bi.kf3g10a.getId())
                    ClearClass.ClearAllFields(bi.fldGrpSecG02, null);
            }
        });

    }

    public void BtnEnd() {
        MainApp.endActivity(this, this);
    }

    private void SaveDraft() throws JSONException {

        JSONObject sa1 = new JSONObject();

        sa1.put("kf3g01", bi.kf3g01a.isChecked() ? "1"
                : bi.kf3g01b.isChecked() ? "2"
                : bi.kf3g0198.isChecked() ? "98"
                : "0");

        sa1.put("kf3g02", bi.kf3g02a.isChecked() ? "1"
                : bi.kf3g02b.isChecked() ? "2"
                : bi.kf3g0298.isChecked() ? "98"
                : "0");

        sa1.put("kf3g03", bi.kf3g03a.isChecked() ? "1"
                : bi.kf3g03b.isChecked() ? "2"
                : bi.kf3g0398.isChecked() ? "98"
                : "0");

        sa1.put("kf3g06a", bi.kf3g061a.isChecked() ? "1"
                : bi.kf3g061b.isChecked() ? "2"
                : bi.kf3g06198.isChecked() ? "98"
                : "0");

        sa1.put("kf3g06b", bi.kf3g062a.isChecked() ? "1"
                : bi.kf3g062b.isChecked() ? "2"
                : bi.kf3g06298.isChecked() ? "98"
                : "0");
        sa1.put("kf3g062x", bi.kf3g062x.getText().toString());

        sa1.put("kf3g06c", bi.kf3g063a.isChecked() ? "1"
                : bi.kf3g063b.isChecked() ? "2"
                : bi.kf3g06398.isChecked() ? "98"
                : "0");
        sa1.put("kf3g063x", bi.kf3g063x.getText().toString());

        sa1.put("kf3g06d", bi.kf3g064a.isChecked() ? "1"
                : bi.kf3g064b.isChecked() ? "2"
                : bi.kf3g06498.isChecked() ? "98"
                : "0");

        sa1.put("kf3g06e", bi.kf3g065a.isChecked() ? "1"
                : bi.kf3g065b.isChecked() ? "2"
                : bi.kf3g06598.isChecked() ? "98"
                : "0");

        sa1.put("kf3g06f", bi.kf3g066a.isChecked() ? "1"
                : bi.kf3g066b.isChecked() ? "2"
                : bi.kf3g06698.isChecked() ? "98"
                : "0");
        sa1.put("kf3g066x", bi.kf3g066x.getText().toString());

        sa1.put("kf3g06g", bi.kf3g067a.isChecked() ? "1"
                : bi.kf3g067b.isChecked() ? "2"
                : bi.kf3g06798.isChecked() ? "98"
                : "0");

        sa1.put("kf3g06h", bi.kf3g068a.isChecked() ? "1"
                : bi.kf3g068b.isChecked() ? "2"
                : bi.kf3g06898.isChecked() ? "98"
                : "0");

        sa1.put("kf3g06i", bi.kf3g069a.isChecked() ? "1"
                : bi.kf3g069b.isChecked() ? "2"
                : bi.kf3g06998.isChecked() ? "98"
                : "0");

        sa1.put("kf3g07a", bi.kf3g071a.isChecked() ? "1"
                : bi.kf3g071b.isChecked() ? "2"
                : bi.kf3g07198.isChecked() ? "98"
                : "0");

        sa1.put("kf3g07b", bi.kf3g072a.isChecked() ? "1"
                : bi.kf3g072b.isChecked() ? "2"
                : bi.kf3g07298.isChecked() ? "98"
                : "0");

        sa1.put("kf3g07c", bi.kf3g073a.isChecked() ? "1"
                : bi.kf3g073b.isChecked() ? "2"
                : bi.kf3g07398.isChecked() ? "98"
                : "0");

        sa1.put("kf3g07d", bi.kf3g074a.isChecked() ? "1"
                : bi.kf3g074b.isChecked() ? "2"
                : bi.kf3g07498.isChecked() ? "98"
                : "0");

        sa1.put("kf3g07e", bi.kf3g075a.isChecked() ? "1"
                : bi.kf3g075b.isChecked() ? "2"
                : bi.kf3g07598.isChecked() ? "98"
                : "0");

        sa1.put("kf3g07f", bi.kf3g076a.isChecked() ? "1"
                : bi.kf3g076b.isChecked() ? "2"
                : bi.kf3g07698.isChecked() ? "98"
                : "0");

        sa1.put("kf3g07g", bi.kf3g077a.isChecked() ? "1"
                : bi.kf3g077b.isChecked() ? "2"
                : bi.kf3g07798.isChecked() ? "98"
                : "0");

        sa1.put("kf3g07h", bi.kf3g078a.isChecked() ? "1"
                : bi.kf3g078b.isChecked() ? "2"
                : bi.kf3g07898.isChecked() ? "98"
                : "0");

        sa1.put("kf3g07i", bi.kf3g079a.isChecked() ? "1"
                : bi.kf3g079b.isChecked() ? "2"
                : bi.kf3g07998.isChecked() ? "98"
                : "0");

        sa1.put("kf3g07j", bi.kf3g0710a.isChecked() ? "1"
                : bi.kf3g0710b.isChecked() ? "2"
                : bi.kf3g071098.isChecked() ? "98"
                : "0");

        sa1.put("kf3g07k", bi.kf3g0711a.isChecked() ? "1"
                : bi.kf3g0711b.isChecked() ? "2"
                : bi.kf3g071198.isChecked() ? "98"
                : "0");

        sa1.put("kf3g07l", bi.kf3g0712a.isChecked() ? "1"
                : bi.kf3g0712b.isChecked() ? "2"
                : bi.kf3g071298.isChecked() ? "98"
                : "0");

        sa1.put("kf3g07m", bi.kf3g0713a.isChecked() ? "1"
                : bi.kf3g0713b.isChecked() ? "2"
                : bi.kf3g071398.isChecked() ? "98"
                : "0");

        sa1.put("kf3g07n", bi.kf3g0714a.isChecked() ? "1"
                : bi.kf3g0714b.isChecked() ? "2"
                : bi.kf3g071498.isChecked() ? "98"
                : "0");

        sa1.put("kf3g07o", bi.kf3g0715a.isChecked() ? "1"
                : bi.kf3g0715b.isChecked() ? "2"
                : bi.kf3g071598.isChecked() ? "98"
                : "0");

        sa1.put("kf3g07p", bi.kf3g0716a.isChecked() ? "1"
                : bi.kf3g0716b.isChecked() ? "2"
                : bi.kf3g071698.isChecked() ? "98"
                : "0");

        sa1.put("kf3g07q", bi.kf3g0717a.isChecked() ? "1"
                : bi.kf3g0717b.isChecked() ? "2"
                : bi.kf3g071798.isChecked() ? "98"
                : "0");

        sa1.put("kf3g08", bi.kf3g08a.isChecked() ? "1"
                : bi.kf3g08b.isChecked() ? "2"
                : bi.kf3g0898.isChecked() ? "98"
                : "0");

        sa1.put("kf3g09", bi.kf3g09.getText().toString());
        sa1.put("kf3g09a", bi.kf3g09a.isChecked() ? "1" : "0");

        sa1.put("kf3g10", bi.kf3g10a.isChecked() ? "1"
                : bi.kf3g10b.isChecked() ? "2"
                : bi.kf3g1098.isChecked() ? "98"
                : "0");

        sa1.put("kf3g11", bi.kf3g11a.isChecked() ? "1"
                : bi.kf3g11b.isChecked() ? "2"
                : bi.kf3g11c.isChecked() ? "3"
                : bi.kf3g1196.isChecked() ? "96"
                : "0");
        sa1.put("kf3g1196x", bi.kf3g1196x.getText().toString());

        sa1.put("kf3g12", bi.kf3g12a.isChecked() ? "1"
                : bi.kf3g12b.isChecked() ? "2"
                : bi.kf3g12c.isChecked() ? "3"
                : bi.kf3g1296.isChecked() ? "96"
                : "0");
        sa1.put("kf3g1296x", bi.kf3g1296x.getText().toString());

        sa1.put("kf3g13", bi.kf3g13a.isChecked() ? "1"
                : bi.kf3g13b.isChecked() ? "2"
                : bi.kf3g1398.isChecked() ? "98"
                : "0");

        fc.setsG(String.valueOf(sa1));

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
                Toast.makeText(this, "Sorry. You can't go further.\n Please contact IT Team (Failed to update DB)", Toast.LENGTH_SHORT).show();
            }
        }


    }

    private boolean formValidation() {
        return ValidatorClass.EmptyCheckingContainer(this, bi.fldGrpSecG01);


        /*if (bi.kf3d15a.isChecked() && !bi.kf3d1698.isChecked()) {
            if (Integer.valueOf(bi.kf3d16h.getText().toString()) == 0 && Integer.valueOf(bi.kf3d16d.getText().toString()) == 00 && Integer.valueOf(bi.kf3d16w.getText().toString()) == 0) {
                bi.kf3d16w.setError("All values can't be zero!!");
                bi.kf3d16w.setFocusable(true);
                Toast.makeText(this, getString(R.string.kf3d16) + ": All values can't be zero!!", Toast.LENGTH_SHORT).show();
                return false;
            }
        }*/
    }

    private boolean UpdateDB() {
        DatabaseHelper db = new DatabaseHelper(this);
        int updcount = db.updateSG();
        return updcount == 1;
    }

    @Override
    public void onBackPressed() {
        Toast.makeText(getApplicationContext(), "You Can't go back", Toast.LENGTH_LONG).show();
    }
}
