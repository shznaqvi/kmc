package edu.aku.hassannaqvi.kmc.ui;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import edu.aku.hassannaqvi.kmc.R;
import edu.aku.hassannaqvi.kmc.core.DatabaseHelper;
import edu.aku.hassannaqvi.kmc.core.MainApp;
import edu.aku.hassannaqvi.kmc.databinding.ActivitySectionA3Binding;
import edu.aku.hassannaqvi.kmc.validation.validatorClass;

public class SectionA3Activity extends AppCompatActivity {

    private static final String TAG = SectionA3Activity.class.getName();
    ActivitySectionA3Binding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_section_a3);

        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_a3);
        bi.setCallback(this);
        setupViews();
    }


    private void setupViews() {

        bi.kac11.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (bi.kac11b.isChecked()) {
                    bi.kac12.setText(null);
                    bi.kac13.clearCheck();

                    bi.fldGrpkac11.setVisibility(View.GONE);
                } else {
                    bi.fldGrpkac11.setVisibility(View.VISIBLE);
                }
            }
        });


        bi.kac14.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (bi.kac14b.isChecked()) {

                    bi.kac15a.setChecked(false);
                    bi.kac15b.setChecked(false);
                    bi.kac15c.setChecked(false);
                    bi.kac15d.setChecked(false);
                    bi.kac15e.setChecked(false);
                    bi.kac15f.setChecked(false);
                    bi.kac1596.setChecked(false);

                    bi.kac1596x.setText(null);

                    bi.fldGrpkac14.setVisibility(View.GONE);
                } else {
                    bi.fldGrpkac14.setVisibility(View.VISIBLE);
                }
            }
        });


        bi.kac17.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (bi.kac17b.isChecked()) {
                    bi.kac18.setText(null);
                    bi.fldGrpkac17.setVisibility(View.GONE);
                } else {
                    bi.fldGrpkac17.setVisibility(View.VISIBLE);
                }
            }
        });


        bi.kac22.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (bi.kac22b.isChecked()) {
                    bi.kac23a.setText(null);
                    bi.kac23k.setText(null);
                    bi.kac2398.setChecked(false);

                    bi.fldGrpkac22.setVisibility(View.GONE);
                } else {
                    bi.fldGrpkac22.setVisibility(View.VISIBLE);
                }
            }
        });


        bi.kac2398.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (bi.kac2398.isChecked()) {
                    bi.kac23a.setText(null);
                    bi.kac23k.setText(null);

                    bi.kac23a.setVisibility(View.GONE);
                    bi.kac23k.setVisibility(View.GONE);

                } else {
                    bi.kac23a.setVisibility(View.VISIBLE);
                    bi.kac23k.setVisibility(View.VISIBLE);
                }
            }
        });
        bi.kac2496x.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(!TextUtils.isEmpty(bi.kac2496x.getText().toString())){
                    bi.kac2496.setVisibility(View.VISIBLE);
                }else{
                    bi.kac2496.setVisibility(View.GONE);
                    bi.kac2496.setText(null);
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


    }


    private void SaveDraft() throws JSONException {


        JSONObject sA1 = new JSONObject();

        sA1.put("kac01", bi.kac01a.isChecked() ? "1"
                : bi.kac01b.isChecked() ? "2"
                : bi.kac01c.isChecked() ? "3"
                : bi.kac01d.isChecked() ? "4"
                : bi.kac01e.isChecked() ? "5"
                : bi.kac01f.isChecked() ? "6"
                : bi.kac0196.isChecked() ? "96"
                : "0");

        sA1.put("kac0196x", bi.kac0196x.getText().toString());


        sA1.put("kac02", bi.kac02a.isChecked() ? "1"
                : bi.kac02b.isChecked() ? "2"
                : bi.kac02c.isChecked() ? "3"
                : bi.kac02d.isChecked() ? "4"
                : bi.kac02e.isChecked() ? "5"
                : bi.kac02f.isChecked() ? "6"
                : bi.kac02g.isChecked() ? "7"
                : bi.kac02h.isChecked() ? "8"
                : bi.kac0296.isChecked() ? "96"
                : "0");

        sA1.put("kac0296x", bi.kac0296x.getText().toString());


        sA1.put("kac03", bi.kac03a.isChecked() ? "1"
                : bi.kac03b.isChecked() ? "2"
                : bi.kac03c.isChecked() ? "3"
                : bi.kac03d.isChecked() ? "4"
                : bi.kac03e.isChecked() ? "5"
                : bi.kac03f.isChecked() ? "6"
                : bi.kac03g.isChecked() ? "7"
                : bi.kac03h.isChecked() ? "8"
                : bi.kac03i.isChecked() ? "9"
                : bi.kac03j.isChecked() ? "10"
                : bi.kac03k.isChecked() ? "11"
                : bi.kac0396.isChecked() ? "96"
                : "0");

        sA1.put("kac0396x", bi.kac0396x.getText().toString());


        sA1.put("kac04", bi.kac04a.isChecked() ? "1"
                : bi.kac04b.isChecked() ? "2"
                : bi.kac04c.isChecked() ? "3"
                : bi.kac04d.isChecked() ? "4"
                : bi.kac04e.isChecked() ? "5"
                : bi.kac04f.isChecked() ? "6"
                : bi.kac04g.isChecked() ? "7"
                : bi.kac04h.isChecked() ? "8"
                : bi.kac04i.isChecked() ? "9"
                : bi.kac0496.isChecked() ? "96"
                : "0");


        sA1.put("kac0496x", bi.kac0496x.getText().toString());


        sA1.put("kac05", bi.kac05a.isChecked() ? "1"
                : bi.kac05b.isChecked() ? "2"
                : bi.kac05c.isChecked() ? "3"
                : "0");


        sA1.put("kac06", bi.kac06.getText().toString());


        sA1.put("kac07", bi.kac07a.isChecked() ? "1"
                : bi.kac07b.isChecked() ? "2"
                : "0");


        sA1.put("kac08", bi.kac08a.isChecked() ? "1"
                : bi.kac08b.isChecked() ? "2"
                : bi.kac08c.isChecked() ? "3"
                : bi.kac08d.isChecked() ? "4"
                : bi.kac08e.isChecked() ? "5"
                : bi.kac08f.isChecked() ? "6"
                : bi.kac08g.isChecked() ? "7"
                : bi.kac08h.isChecked() ? "8"
                : bi.kac08i.isChecked() ? "9"
                : bi.kac08j.isChecked() ? "10"
                : bi.kac08k.isChecked() ? "11"
                : bi.kac0896.isChecked() ? "96"
                : "0");


        sA1.put("kac0896x", bi.kac0896x.getText().toString());


        sA1.put("kac09", bi.kac09a.isChecked() ? "1"
                : bi.kac09b.isChecked() ? "2"
                : bi.kac09c.isChecked() ? "3"
                : bi.kac09d.isChecked() ? "4"
                : bi.kac09e.isChecked() ? "5"
                : bi.kac09f.isChecked() ? "6"
                : bi.kac09g.isChecked() ? "7"
                : bi.kac09h.isChecked() ? "8"
                : bi.kac09i.isChecked() ? "9"
                : bi.kac09j.isChecked() ? "10"
                : bi.kac09k.isChecked() ? "11"
                : bi.kac09l.isChecked() ? "12"
                : bi.kac09m.isChecked() ? "13"
                : bi.kac09n.isChecked() ? "14"
                : bi.kac09o.isChecked() ? "15"
                : bi.kac0996.isChecked() ? "96"
                : "0");


        sA1.put("kac0996x", bi.kac0996x.getText().toString());


        sA1.put("kac10", bi.kac10a.isChecked() ? "1"
                : bi.kac10b.isChecked() ? "2"
                : bi.kac10c.isChecked() ? "3"
                : bi.kac10d.isChecked() ? "4"
                : bi.kac10e.isChecked() ? "5"
                : bi.kac10f.isChecked() ? "6"
                : bi.kac10g.isChecked() ? "7"
                : bi.kac10h.isChecked() ? "8"
                : bi.kac10i.isChecked() ? "9"
                : bi.kac10j.isChecked() ? "10"
                : bi.kac10k.isChecked() ? "11"
                : bi.kac10l.isChecked() ? "12"
                : bi.kac10m.isChecked() ? "13"
                : bi.kac10n.isChecked() ? "14"
                : bi.kac10o.isChecked() ? "15"
                : bi.kac1096.isChecked() ? "96"
                : "0");

        sA1.put("kac1096x", bi.kac1096x.getText().toString());


        sA1.put("kac11", bi.kac11a.isChecked() ? "1"
                : bi.kac11b.isChecked() ? "2"
                : "0");

        sA1.put("kac12", bi.kac12.getText().toString());


        sA1.put("kac13", bi.kac13a.isChecked() ? "1"
                : bi.kac13b.isChecked() ? "2"
                : bi.kac13c.isChecked() ? "3"
                : bi.kac13d.isChecked() ? "4"
                : "0");


        sA1.put("kac14", bi.kac14a.isChecked() ? "1"
                : bi.kac14b.isChecked() ? "2"
                : "0");


        sA1.put("kac15a", bi.kac15a.isChecked() ? "1" : "0");
        sA1.put("kac15b", bi.kac15b.isChecked() ? "2" : "0");
        sA1.put("kac15c", bi.kac15c.isChecked() ? "3" : "0");
        sA1.put("kac15d", bi.kac15d.isChecked() ? "4" : "0");
        sA1.put("kac15e", bi.kac15e.isChecked() ? "5" : "0");
        sA1.put("kac15f", bi.kac15f.isChecked() ? "6" : "0");
        sA1.put("kac1596", bi.kac1596.isChecked() ? "96" : "0");


        sA1.put("kac1596x", bi.kac1596x.getText().toString());


        sA1.put("kac16", bi.kac16a.isChecked() ? "1"
                : bi.kac16b.isChecked() ? "2"
                : bi.kac16c.isChecked() ? "3"
                : bi.kac16d.isChecked() ? "4"
                : bi.kac16e.isChecked() ? "5"
                : bi.kac16f.isChecked() ? "6"
                : bi.kac16g.isChecked() ? "7"
                : bi.kac16h.isChecked() ? "8"
                : bi.kac16i.isChecked() ? "9"
                : bi.kac16j.isChecked() ? "10"
                : bi.kac16k.isChecked() ? "11"
                : bi.kac1696.isChecked() ? "96"
                : "0");

        sA1.put("kac1696x", bi.kac1696x.getText().toString());

        sA1.put("kac17", bi.kac17a.isChecked() ? "1"
                : bi.kac17b.isChecked() ? "2"
                : "0");

        sA1.put("kac18", bi.kac18.getText().toString());


        sA1.put("kac19", bi.kac19a.isChecked() ? "1"
                : bi.kac19b.isChecked() ? "2"
                : "0");


        sA1.put("kac20", bi.kac20a.isChecked() ? "1"
                : bi.kac20b.isChecked() ? "2"
                : "0");

        sA1.put("kac21", bi.kac21a.isChecked() ? "1"
                : bi.kac21b.isChecked() ? "2"
                : "0");

        sA1.put("kac22", bi.kac22a.isChecked() ? "1"
                : bi.kac22b.isChecked() ? "2"
                : "0");


        sA1.put("kac23acr", bi.kac23a.getText().toString());
        sA1.put("kac23kan", bi.kac23k.getText().toString());
        sA1.put("kac2398", bi.kac2398.isChecked() ? "98" : "0");

        sA1.put("kac2401", bi.kac2401.getText().toString());
        sA1.put("kac2402", bi.kac2402.getText().toString());
        sA1.put("kac2403", bi.kac2403.getText().toString());
        sA1.put("kac2404", bi.kac2404.getText().toString());
        sA1.put("kac2405", bi.kac2405.getText().toString());
        sA1.put("kac2406", bi.kac2406.getText().toString());
        sA1.put("kac2407", bi.kac2407.getText().toString());
        sA1.put("kac2408", bi.kac2408.getText().toString());
        sA1.put("kac2409", bi.kac2409.getText().toString());
        sA1.put("kac2410", bi.kac2410.getText().toString());
        sA1.put("kac2411", bi.kac2411.getText().toString());
        sA1.put("kac2412", bi.kac2412.getText().toString());
        sA1.put("kac2413", bi.kac2413.getText().toString());
        sA1.put("kac2414", bi.kac2414.getText().toString());
        sA1.put("kac2415", bi.kac2415.getText().toString());
        sA1.put("kac2416", bi.kac2416.getText().toString());
        sA1.put("kac2417", bi.kac2417.getText().toString());
        sA1.put("kac2418", bi.kac2418.getText().toString());
        sA1.put("kac2419", bi.kac2419.getText().toString());
        sA1.put("kac2420", bi.kac2420.getText().toString());
        sA1.put("kac2496x", bi.kac2496x.getText().toString());
        sA1.put("kac2496", bi.kac2496.getText().toString());


        MainApp.fc.setsa3(String.valueOf(sA1));
    }


    private boolean formValidation() {

        if (!validatorClass.EmptyRadioButton(this, bi.kac01, bi.kac01a, getString(R.string.kac01))) {
            return false;
        }


        if (bi.kac0196.isChecked()) {

            if (!validatorClass.EmptyTextBox(this, bi.kac0196x, getString(R.string.other))) {
                return false;
            }
        }


        if (!validatorClass.EmptyRadioButton(this, bi.kac02, bi.kac02a, getString(R.string.kac02))) {
            return false;
        }


        if (bi.kac0296.isChecked()) {

            if (!validatorClass.EmptyTextBox(this, bi.kac0296x, getString(R.string.other))) {
                return false;
            }
        }


        if (!validatorClass.EmptyRadioButton(this, bi.kac03, bi.kac03a, getString(R.string.kac03sub))) {
            return false;
        }


        if (bi.kac0396.isChecked()) {

            if (!validatorClass.EmptyTextBox(this, bi.kac0396x, getString(R.string.other))) {
                return false;
            }
        }


        if (!validatorClass.EmptyRadioButton(this, bi.kac04, bi.kac04a, getString(R.string.kac04sub))) {
            return false;
        }


        if (bi.kac0496.isChecked()) {

            if (!validatorClass.EmptyTextBox(this, bi.kac0496x, getString(R.string.other))) {
                return false;
            }
        }


        if (!validatorClass.EmptyRadioButton(this, bi.kac05, bi.kac05a, getString(R.string.kac05))) {
            return false;
        }


        if (!validatorClass.EmptyTextBox(this, bi.kac06, getString(R.string.kac06))) {
            return false;
        }


        if (!validatorClass.RangeTextBox(this, bi.kac06, 1, 15, getString(R.string.kac06), "Rooms")) {
            return false;
        }


        if (!validatorClass.EmptyRadioButton(this, bi.kac07, bi.kac07a, getString(R.string.kac07))) {
            return false;
        }


        if (!validatorClass.EmptyRadioButton(this, bi.kac08, bi.kac08a, getString(R.string.kac08))) {
            return false;
        }


        if (bi.kac0896.isChecked()) {

            if (!validatorClass.EmptyTextBox(this, bi.kac0896x, getString(R.string.other))) {
                return false;
            }
        }


        if (!validatorClass.EmptyRadioButton(this, bi.kac09, bi.kac0996, bi.kac0996x, getString(R.string.kac09))) {
            return false;
        }


        if (!validatorClass.EmptyRadioButton(this, bi.kac10, bi.kac10a, getString(R.string.kac10))) {
            return false;
        }


        if (bi.kac1096.isChecked()) {

            if (!validatorClass.EmptyTextBox(this, bi.kac1096x, getString(R.string.other))) {
                return false;
            }
        }


        if (!validatorClass.EmptyRadioButton(this, bi.kac11, bi.kac11a, getString(R.string.kac11))) {
            return false;
        }


        if (bi.kac11a.isChecked()) {

            if (!validatorClass.EmptyTextBox(this, bi.kac12, getString(R.string.kac12))) {
                return false;
            }

            if (!validatorClass.RangeTextBox(this, bi.kac12, 2, 90, getString(R.string.kac12), " minutes")) {
                return false;
            }


            if (Integer.valueOf(bi.kac12.getText().toString()) <= 0) {
                Toast.makeText(this, "Must be greater than 0 ", Toast.LENGTH_SHORT).show();
                bi.kac12.requestFocus();
                return false;
            }


            if (!validatorClass.EmptyRadioButton(this, bi.kac13, bi.kac13a, getString(R.string.kac13))) {
                return false;
            }
        }


        if (!validatorClass.EmptyRadioButton(this, bi.kac14, bi.kac14a, getString(R.string.kac14))) {
            return false;
        }


        if (bi.kac14a.isChecked()) {

            if (!validatorClass.EmptyCheckBox(this, bi.fldGrpkac15, bi.kac15a, getString(R.string.kac15))) {
                return false;
            }


            if (bi.kac1596.isChecked()) {

                if (!validatorClass.EmptyTextBox(this, bi.kac1596x, getString(R.string.other))) {
                    return false;
                }
            }

        }


        if (!validatorClass.EmptyRadioButton(this, bi.kac16, bi.kac16a, getString(R.string.kac16))) {
            return false;
        }


        if (bi.kac1696.isChecked()) {

            if (!validatorClass.EmptyTextBox(this, bi.kac1696x, getString(R.string.other))) {
                return false;
            }
        }


        if (!validatorClass.EmptyRadioButton(this, bi.kac17, bi.kac17a, getString(R.string.kac17))) {
            return false;
        }


        if (bi.kac17a.isChecked()) {

            if (!validatorClass.EmptyTextBox(this, bi.kac18, getString(R.string.kac18))) {
                return false;
            }

            if (!validatorClass.RangeTextBox(this, bi.kac18, 1, 15, getString(R.string.kac18), "Toilet")) {
                return false;
            }
        }


        if (!validatorClass.EmptyRadioButton(this, bi.kac19, bi.kac19a, getString(R.string.kac19))) {
            return false;
        }


        if (!validatorClass.EmptyRadioButton(this, bi.kac20, bi.kac20a, getString(R.string.kac20))) {
            return false;
        }


        if (!validatorClass.EmptyRadioButton(this, bi.kac21, bi.kac21a, getString(R.string.kac21))) {
            return false;
        }


        if (!validatorClass.EmptyRadioButton(this, bi.kac22, bi.kac22a, getString(R.string.kac22))) {
            return false;
        }


        if (bi.kac22a.isChecked()) {

            if (!bi.kac2398.isChecked()) {

                if (!validatorClass.EmptyTextBox(this, bi.kac23a, getString(R.string.kac23acr))) {
                    return false;
                }


                if (!validatorClass.EmptyTextBox(this, bi.kac23k, getString(R.string.kac23can))) {
                    return false;
                }
            }
        }


        if (!validatorClass.EmptyTextBox(this, bi.kac2401, getString(R.string.kac2401))) {
            return false;
        }


        if (!validatorClass.RangeTextBox(this, bi.kac2401, 0, 99, getString(R.string.kac2401), "Quantity")) {
            return false;
        }


        if (!validatorClass.EmptyTextBox(this, bi.kac2402, getString(R.string.kac2402))) {
            return false;
        }


        if (!validatorClass.RangeTextBox(this, bi.kac2402, 0, 99, getString(R.string.kac2402), "Quantity")) {
            return false;
        }


        if (!validatorClass.EmptyTextBox(this, bi.kac2403, getString(R.string.kac2403))) {
            return false;
        }


        if (!validatorClass.RangeTextBox(this, bi.kac2403, 0, 10, getString(R.string.kac2403), "Quantity")) {
            return false;
        }


        if (!validatorClass.EmptyTextBox(this, bi.kac2404, getString(R.string.kac2404))) {
            return false;
        }


        if (!validatorClass.RangeTextBox(this, bi.kac2404, 0, 10, getString(R.string.kac2404), "Quantity")) {
            return false;
        }


        if (!validatorClass.EmptyTextBox(this, bi.kac2405, getString(R.string.kac2405))) {
            return false;
        }


        if (!validatorClass.RangeTextBox(this, bi.kac2405, 0, 10, getString(R.string.kac2405), "Quantity")) {
            return false;
        }


        if (!validatorClass.EmptyTextBox(this, bi.kac2406, getString(R.string.kac2406))) {
            return false;
        }


        if (!validatorClass.RangeTextBox(this, bi.kac2406, 0, 10, getString(R.string.kac2406), "Quantity")) {
            return false;
        }


        if (!validatorClass.EmptyTextBox(this, bi.kac2407, getString(R.string.kac2407))) {
            return false;
        }


        if (!validatorClass.RangeTextBox(this, bi.kac2407, 0, 10, getString(R.string.kac2407), "Quantity")) {
            return false;
        }


        if (!validatorClass.EmptyTextBox(this, bi.kac2408, getString(R.string.kac2408))) {
            return false;
        }


        if (!validatorClass.RangeTextBox(this, bi.kac2408, 0, 10, getString(R.string.kac2408), "Quantity")) {
            return false;
        }


        if (!validatorClass.EmptyTextBox(this, bi.kac2409, getString(R.string.kac2409))) {
            return false;
        }


        if (!validatorClass.RangeTextBox(this, bi.kac2409, 0, 10, getString(R.string.kac2409), "Quantity")) {
            return false;
        }


        if (!validatorClass.EmptyTextBox(this, bi.kac2410, getString(R.string.kac2410))) {
            return false;
        }


        if (!validatorClass.RangeTextBox(this, bi.kac2410, 0, 10, getString(R.string.kac2410), "Quantity")) {
            return false;
        }


        if (!validatorClass.EmptyTextBox(this, bi.kac2411, getString(R.string.kac2411))) {
            return false;
        }


        if (!validatorClass.RangeTextBox(this, bi.kac2411, 0, 10, getString(R.string.kac2411), "Quantity")) {
            return false;
        }


        if (!validatorClass.EmptyTextBox(this, bi.kac2412, getString(R.string.kac2412))) {
            return false;
        }


        if (!validatorClass.RangeTextBox(this, bi.kac2412, 0, 10, getString(R.string.kac2412), "Quantity")) {
            return false;
        }


        if (!validatorClass.EmptyTextBox(this, bi.kac2413, getString(R.string.kac2413))) {
            return false;
        }


        if (!validatorClass.RangeTextBox(this, bi.kac2413, 0, 10, getString(R.string.kac2413), "Quantity")) {
            return false;
        }


        if (!validatorClass.EmptyTextBox(this, bi.kac2414, getString(R.string.kac2414))) {
            return false;
        }


        if (!validatorClass.RangeTextBox(this, bi.kac2414, 0, 10, getString(R.string.kac2414), "Quantity")) {
            return false;
        }


        if (!validatorClass.EmptyTextBox(this, bi.kac2415, getString(R.string.kac2415))) {
            return false;
        }


        if (!validatorClass.RangeTextBox(this, bi.kac2415, 0, 10, getString(R.string.kac2415), "Quantity")) {
            return false;
        }


        if (!validatorClass.EmptyTextBox(this, bi.kac2416, getString(R.string.kac2415))) {
            return false;
        }


        if (!validatorClass.RangeTextBox(this, bi.kac2416, 0, 10, getString(R.string.kac2416), "Quantity")) {
            return false;
        }


        if (!validatorClass.EmptyTextBox(this, bi.kac2417, getString(R.string.kac2417))) {
            return false;
        }


        if (!validatorClass.RangeTextBox(this, bi.kac2417, 0, 10, getString(R.string.kac2417), "Quantity")) {
            return false;
        }


        if (!validatorClass.EmptyTextBox(this, bi.kac2418, getString(R.string.kac2418))) {
            return false;
        }


        if (!validatorClass.RangeTextBox(this, bi.kac2418, 0, 10, getString(R.string.kac2418), "Quantity")) {
            return false;
        }


        if (!validatorClass.EmptyTextBox(this, bi.kac2419, getString(R.string.kac2419))) {
            return false;
        }


        if (!validatorClass.RangeTextBox(this, bi.kac2419, 0, 10, getString(R.string.kac2419), "Quantity")) {
            return false;
        }


        if (!validatorClass.EmptyTextBox(this, bi.kac2420, getString(R.string.kac2420))) {
            return false;
        }


        if (!validatorClass.RangeTextBox(this, bi.kac2420, 0, 10, getString(R.string.kac2420), "Quantity")) {
            return false;
        }

/*
        if (!validatorClass.EmptyTextBox(this, bi.kac2496x, getString(R.string.other))) {
            return false;
        }*/
        if (!TextUtils.isEmpty(bi.kac2496x.toString())) {
            if (!validatorClass.EmptyTextBox(this, bi.kac2496, getString(R.string.other))) {
                return false;
            }
            if (!validatorClass.RangeTextBox(this, bi.kac2496 , 1, 20, getString(R.string.other), " number")) {
                return false;
            }
        }


        return true;

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

            startActivity(new Intent(this, EndingActivity.class).putExtra("complete", false));

        } else {
            Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
        }
        //}
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

                startActivity(new Intent(this, SectionB1Activity.class));
                //startActivity(new Intent(this, MainActivity.class));

            } else {
                Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
            }
        }
    }


    private boolean UpdateDB() {

        //Long rowId;
        DatabaseHelper db = new DatabaseHelper(this);

        int updcount = db.updateSA3();

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