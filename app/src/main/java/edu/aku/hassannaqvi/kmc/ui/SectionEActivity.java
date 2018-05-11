package edu.aku.hassannaqvi.kmc.ui;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.os.Bundle;

import org.json.JSONException;
import org.json.JSONObject;

import edu.aku.hassannaqvi.kmc.R;
import edu.aku.hassannaqvi.kmc.core.MainApp;
import edu.aku.hassannaqvi.kmc.validation.validatorClass;

public class SectionEActivity extends Activity {

    ActivitySectionEBinding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //setContentView(R.layout.activity_section_e);

        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_e);

        bi.setCallback(this);
    }


    private boolean ValidateForm() {


        if (!validatorClass.EmptyRadioButton(this, bi.ke401, bi.ke401a, getString(R.string.ke401))) {
            return false;
        }


        if (!validatorClass.EmptyTextBox(this, bi.ke40196x, getString(R.string.other))) {
            return false;
        }


        if (!validatorClass.EmptyRadioButton(this, bi.ke402, bi.ke402a, getString(R.string.ke402))) {
            return false;
        }


        if (!validatorClass.EmptyTextBox(this, bi.ke403, getString(R.string.ke403))) {
            return false;
        }


        if (!validatorClass.EmptyCheckBox(this, bi.ke404, bi.ke404a, getString(R.string.ke404))) {
            return false;
        }


        if (!validatorClass.EmptyTextBox(this, bi.ke405, getString(R.string.ke405))) {
            return false;
        }


        if (!validatorClass.EmptyRadioButton(this, bi.ke406, bi.ke406a, getString(R.string.ke406))) {
            return false;
        }


        if (!validatorClass.EmptyCheckBox(this, bi.ke407, bi.ke407a, getString(R.string.ke407))) {
            return false;
        }


        if (!validatorClass.EmptyTextBox(this, bi.ke40796x, getString(R.string.other))) {
            return false;
        }


        if (!validatorClass.EmptyRadioButton(this, bi.ke408, bi.ke408a, getString(R.string.ke408))) {
            return false;
        }


        if (!validatorClass.EmptyTextBox(this, bi.ke40896x, getString(R.string.other))) {
            return false;
        }


        if (!validatorClass.EmptyCheckBox(this, bi.ke409, bi.ke409a, getString(R.string.ke409))) {
            return false;
        }

        if (!validatorClass.EmptyTextBox(this, bi.ke40996x, getString(R.string.other))) {
            return false;
        }


        if (!validatorClass.EmptyRadioButton(this, bi.ke410, bi.ke410a, getString(R.string.ke410))) {
            return false;
        }

        if (!validatorClass.EmptyCheckBox(this, bi.ke411, bi.ke411a, getString(R.string.ke411))) {
            return false;
        }


        if (!validatorClass.EmptyTextBox(this, bi.ke41196x, getString(R.string.other))) {
            return false;
        }


        if (!validatorClass.EmptyCheckBox(this, bi.ke412, bi.ke412a, getString(R.string.ke412))) {
            return false;
        }


        if (!validatorClass.EmptyTextBox(this, bi.ke41296x, getString(R.string.other))) {
            return false;
        }


        if (!validatorClass.EmptyRadioButton(this, bi.ke413, bi.ke413a, getString(R.string.ke413))) {
            return false;
        }


        if (!validatorClass.EmptyCheckBox(this, bi.ke414, bi.ke414a, getString(R.string.ke414))) {
            return false;
        }

        if (!validatorClass.EmptyTextBox(this, bi.ke41496x, getString(R.string.other))) {
            return false;
        }


        if (!validatorClass.EmptyCheckBox(this, bi.ke415, bi.ke415a, getString(R.string.ke415))) {
            return false;
        }


        if (!validatorClass.EmptyTextBox(this, bi.ke41596x, getString(R.string.other))) {
            return false;
        }


        if (!validatorClass.EmptyRadioButton(this, bi.ke416, bi.ke416a, getString(R.string.ke416))) {
            return false;
        }


        if (!validatorClass.EmptyRadioButton(this, bi.ke417, bi.ke417a, getString(R.string.ke417))) {
            return false;
        }


        if (!validatorClass.EmptyRadioButton(this, bi.ke418, bi.ke418a, getString(R.string.ke418))) {
            return false;
        }


        if (!validatorClass.EmptyTextBox(this, bi.ke41896x, getString(R.string.other))) {
            return false;
        }


        if (!validatorClass.EmptyRadioButton(this, bi.ke419, bi.ke419a, getString(R.string.ke419))) {
            return false;
        }


        if (!validatorClass.EmptyCheckBox(this, bi.ke420, bi.ke420a, getString(R.string.ke420))) {
            return false;
        }


        if (!validatorClass.EmptyTextBox(this, bi.ke42096x, getString(R.string.other))) {
            return false;
        }


        if (!validatorClass.EmptyRadioButton(this, bi.ke421, bi.ke421a, getString(R.string.ke421))) {
            return false;
        }


        if (!validatorClass.EmptyTextBox(this, bi.ke42196x, getString(R.string.other))) {
            return false;
        }


        if (!validatorClass.EmptyRadioButton(this, bi.ke422, bi.ke422a, getString(R.string.ke422))) {
            return false;
        }


        if (!validatorClass.EmptyCheckBox(this, bi.ke423, bi.ke423a, getString(R.string.ke423))) {
            return false;
        }


        if (!validatorClass.EmptyTextBox(this, bi.ke42396x, getString(R.string.other))) {
            return false;
        }


        if (!validatorClass.EmptyRadioButton(this, bi.ke424, bi.ke424a, getString(R.string.ke424))) {
            return false;
        }


        return true;
    }


    private void SaveDraft() throws JSONException {

        JSONObject sE = new JSONObject();

        sE.put("ke401", bi.ke401a.isChecked() ? "1"
                : bi.ke401b.isChecked() ? "2"
                : bi.ke401c.isChecked() ? "3"
                : bi.ke401d.isChecked() ? "4"
                : bi.ke401e.isChecked() ? "5"
                : bi.ke401f.isChecked() ? "6"
                : bi.ke401g.isChecked() ? "7"
                : bi.ke401h.isChecked() ? "8"
                : bi.ke40196.isChecked() ? "96"
                : "0");

        sE.put("ke40196", binding.ke40196x.getText().toString());


        sE.put("ke402", bi.ke402a.isChecked() ? "1"
                : bi.ke402b.isChecked() ? "2"
                : bi.ke402c.isChecked() ? "3"
                : "0");

        sE.put("ke403", bi.ke403.getText().toString());

        sE.put("ke404a", bi.ke404a.isChecked() ? "1" : "0");
        sE.put("ke404b", bi.ke404b.isChecked() ? "2" : "0");
        sE.put("ke404c", bi.ke404c.isChecked() ? "3" : "0");
        sE.put("ke404d", bi.ke404d.isChecked() ? "4" : "0");
        sE.put("ke404e", bi.ke404e.isChecked() ? "5" : "0");
        sE.put("ke404f", bi.ke404f.isChecked() ? "6" : "0");
        sE.put("ke404g", bi.ke404g.isChecked() ? "7" : "0");


        sE.put("ke405", bi.ke405.getText().toString());


        sE.put("ke406", bi.ke406a.isChecked() ? "1"
                : bi.ke406b.isChecked() ? "2"
                : "0");


        sE.put("ke407a", bi.ke407a.isChecked() ? "1" : "0");
        sE.put("ke407b", bi.ke407b.isChecked() ? "2" : "0");
        sE.put("ke407c", bi.ke407c.isChecked() ? "3" : "0");
        sE.put("ke407d", bi.ke407d.isChecked() ? "4" : "0");
        sE.put("ke407e", bi.ke407e.isChecked() ? "5" : "0");
        sE.put("ke407f", bi.ke407f.isChecked() ? "6" : "0");
        sE.put("ke407g", bi.ke407g.isChecked() ? "7" : "0");

        sE.put("ke40796x", bi.ke40796x.getText().toString());


        sE.put("ke408", bi.ke408a.isChecked() ? "1"
                : bi.ke408b.isChecked() ? "2"
                : bi.ke408c.isChecked() ? "3"
                : bi.ke40896.isChecked() ? "96"
                : "0");


        sE.put("ke409a", bi.ke409a.isChecked() ? "1" : "0");
        sE.put("ke409b", bi.ke409b.isChecked() ? "2" : "0");
        sE.put("ke409c", bi.ke409c.isChecked() ? "3" : "0");
        sE.put("ke409d", bi.ke409d.isChecked() ? "4" : "0");
        sE.put("ke409e", bi.ke409e.isChecked() ? "5" : "0");
        sE.put("ke409f", bi.ke409f.isChecked() ? "6" : "0");
        sE.put("ke409g", bi.ke409g.isChecked() ? "7" : "0");
        sE.put("ke409h", bi.ke409h.isChecked() ? "8" : "0");
        sE.put("ke409i", bi.ke409i.isChecked() ? "9" : "0");
        sE.put("ke409j", bi.ke409j.isChecked() ? "10" : "0");
        sE.put("ke40996", bi.ke40996.isChecked() ? "96" : "0");

        sE.put("ke40996x", bi.ke40996x.getText().toString());

        sE.put("ke410", bi.ke410a.isChecked() ? "1"
                : bi.ke410b.isChecked() ? "2"
                : "0");


        sE.put("ke411a", bi.ke411a.isChecked() ? "1" : "0");
        sE.put("ke411b", bi.ke411b.isChecked() ? "2" : "0");
        sE.put("ke411c", bi.ke411c.isChecked() ? "3" : "0");
        sE.put("ke41196", bi.ke41196.isChecked() ? "96" : "0");


        sE.put("ke41196x", bi.ke41196x.getText().toString());


        sE.put("ke412a", bi.ke412a.isChecked() ? "1" : "0");
        sE.put("ke412b", bi.ke412b.isChecked() ? "2" : "0");
        sE.put("ke412c", bi.ke412c.isChecked() ? "3" : "0");
        sE.put("ke412d", bi.ke412d.isChecked() ? "4" : "0");
        sE.put("ke412e", bi.ke412e.isChecked() ? "5" : "0");
        sE.put("ke412f", bi.ke412f.isChecked() ? "6" : "0");
        sE.put("ke412g", bi.ke412g.isChecked() ? "7" : "0");
        sE.put("ke412h", bi.ke412h.isChecked() ? "8" : "0");
        sE.put("ke412i", bi.ke412i.isChecked() ? "9" : "0");
        sE.put("ke412j", bi.ke412j.isChecked() ? "10" : "0");
        sE.put("ke412k", bi.ke412k.isChecked() ? "11" : "0");
        sE.put("ke41296", bi.ke41296.isChecked() ? "96" : "0");

        sE.put("ke41296x", bi.ke41296x.getText().toString());


        sE.put("ke413", bi.ke413a.isChecked() ? "1"
                : bi.ke413b.isChecked() ? "2"
                : "0");


        sE.put("ke414a", bi.ke414a.isChecked() ? "1" : "0");
        sE.put("ke414b", bi.ke414b.isChecked() ? "2" : "0");
        sE.put("ke414c", bi.ke414c.isChecked() ? "3" : "0");
        sE.put("ke414d", bi.ke414d.isChecked() ? "4" : "0");
        sE.put("ke414e", bi.ke414e.isChecked() ? "5" : "0");
        sE.put("ke414f", bi.ke414f.isChecked() ? "6" : "0");
        sE.put("ke41496", bi.ke41496.isChecked() ? "96" : "0");

        sE.put("ke41496x", bi.ke41496x.getText().toString());


        sE.put("ke415a", bi.ke415a.isChecked() ? "1" : "0");
        sE.put("ke415b", bi.ke415b.isChecked() ? "2" : "0");
        sE.put("ke415c", bi.ke415c.isChecked() ? "3" : "0");
        sE.put("ke415d", bi.ke415d.isChecked() ? "4" : "0");
        sE.put("ke415e", bi.ke415e.isChecked() ? "5" : "0");
        sE.put("ke41596", bi.ke41596.isChecked() ? "96" : "0");

        sE.put("ke41596x", bi.ke41596x.getText().toString());


        sE.put("ke416", bi.ke416a.isChecked() ? "1"
                : bi.ke416b.isChecked() ? "2"
                : bi.ke416c.isChecked() ? "3"
                : bi.ke416d.isChecked() ? "4"
                : bi.ke41699.isChecked() ? "99"
                : "0");


        sE.put("ke417", bi.ke417a.isChecked() ? "1"
                : bi.ke417b.isChecked() ? "2"
                : bi.ke417c.isChecked() ? "3"
                : bi.ke417d.isChecked() ? "4"
                : bi.ke41799.isChecked() ? "99"
                : "0");


        sE.put("ke418a", bi.ke418a.isChecked() ? "1" : "0");
        sE.put("ke418b", bi.ke418b.isChecked() ? "2" : "0");
        sE.put("ke418c", bi.ke418c.isChecked() ? "3" : "0");
        sE.put("ke418d", bi.ke418d.isChecked() ? "4" : "0");
        sE.put("ke418e", bi.ke418e.isChecked() ? "5" : "0");
        sE.put("ke418f", bi.ke418f.isChecked() ? "6" : "0");
        sE.put("ke418g", bi.ke418g.isChecked() ? "7" : "0");
        sE.put("ke41896", bi.ke41896.isChecked() ? "96" : "0");


        sE.put("ke41896x", bi.ke41896x.getText().toString());


        sE.put("ke419", bi.ke419a.isChecked() ? "1"
                : bi.ke419b.isChecked() ? "2"
                : bi.ke419c.isChecked() ? "3"
                : bi.ke41999.isChecked() ? "99"
                : "0");


        sE.put("ke420a", bi.ke420a.isChecked() ? "1" : "0");
        sE.put("ke420b", bi.ke420b.isChecked() ? "2" : "0");
        sE.put("ke420c", bi.ke420c.isChecked() ? "3" : "0");
        sE.put("ke420d", bi.ke420d.isChecked() ? "4" : "0");
        sE.put("ke420e", bi.ke420e.isChecked() ? "5" : "0");
        sE.put("ke420f", bi.ke420f.isChecked() ? "6" : "0");
        sE.put("ke420g", bi.ke420g.isChecked() ? "7" : "0");
        sE.put("ke42096", bi.ke42096.isChecked() ? "96" : "0");


        sE.put("ke42096x", bi.ke42096x.getText().toString());


        sE.put("ke421", bi.ke421a.isChecked() ? "1"
                : bi.ke421b.isChecked() ? "2"
                : bi.ke421c.isChecked() ? "3"
                : bi.ke42196.isChecked() ? "96"
                : "0");

        sE.put("ke42196x", bi.ke42196x.getText().toString());


        sE.put("ke422", bi.ke422a.isChecked() ? "1"
                : bi.ke422b.isChecked() ? "2"
                : bi.ke422c.isChecked() ? "3"
                : bi.ke422d.isChecked() ? "4"
                : bi.ke42296.isChecked() ? "96"
                : "0");

        sE.put("ke423a", bi.ke423a.isChecked() ? "1" : "0");
        sE.put("ke423b", bi.ke423b.isChecked() ? "2" : "0");
        sE.put("ke423c", bi.ke423c.isChecked() ? "3" : "0");
        sE.put("ke423d", bi.ke423d.isChecked() ? "4" : "0");
        sE.put("ke423e", bi.ke423e.isChecked() ? "6" : "0");
        sE.put("ke423f", bi.ke423f.isChecked() ? "7" : "0");
        sE.put("ke423g", bi.ke423g.isChecked() ? "8" : "0");
        sE.put("ke42396", bi.ke42396.isChecked() ? "96" : "0");


        sE.put("ke42396x", bi.ke42396x.getText().toString());


        sE.put("ke424", bi.ke424a.isChecked() ? "1"
                : bi.ke424b.isChecked() ? "2"
                : bi.ke424c.isChecked() ? "3"
                : bi.ke424d.isChecked() ? "4"
                : bi.ke42499.isChecked() ? "99"
                : "0");


        MainApp.fc.setsB4(String.valueOf(sE));

    }


    public void BtnEnd() {
/*
        Toast.makeText(this, "Processing End Section", Toast.LENGTH_SHORT).show();
        if (formValidation()) {
            try {
                SaveDraft();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (UpdateDB()) {
                Toast.makeText(this, "Starting Ending Section", Toast.LENGTH_SHORT).show();

                finish();

                startActivity(new Intent(this, EndingActivity.class));

            } else {
                Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
            }
        }*/
    }

    public void BtnContinue() {

/*        Toast.makeText(this, "Processing This Section", Toast.LENGTH_SHORT).show();
        if (formValidation()) {
            try {
                SaveDraft();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (UpdateDB()) {
                Toast.makeText(this, "Starting Ending Section", Toast.LENGTH_SHORT).show();

                finish();

//                startActivity(new Intent(this, SectionA2Activity.class));

            } else {
                Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
            }
        }*/
    }


}