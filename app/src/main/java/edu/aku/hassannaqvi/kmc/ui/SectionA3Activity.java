package edu.aku.hassannaqvi.kmc.ui;

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

        bi.ka311.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (bi.ka311b.isChecked()) {
                    bi.ka312.setText(null);
                    bi.ka313.clearCheck();

                    bi.fldGrpka311.setVisibility(View.GONE);
                } else {
                    bi.fldGrpka311.setVisibility(View.VISIBLE);
                }
            }
        });


        bi.ka314.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (bi.ka314b.isChecked()) {

                    bi.ka315a.setChecked(false);
                    bi.ka315b.setChecked(false);
                    bi.ka315c.setChecked(false);
                    bi.ka315d.setChecked(false);
                    bi.ka315e.setChecked(false);
                    bi.ka315f.setChecked(false);
                    bi.ka31596.setChecked(false);

                    bi.ka31596x.setText(null);

                    bi.fldGrpka314.setVisibility(View.GONE);
                } else {
                    bi.fldGrpka314.setVisibility(View.VISIBLE);
                }
            }
        });


        bi.ka317.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (bi.ka317b.isChecked()) {
                    bi.ka318.setText(null);
                    bi.fldGrpka317.setVisibility(View.GONE);
                } else {
                    bi.fldGrpka317.setVisibility(View.VISIBLE);
                }
            }
        });


        bi.ka322.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (bi.ka322b.isChecked()) {
                    bi.ka323a.setText(null);
                    bi.ka323k.setText(null);
                    bi.ka32398.setChecked(false);

                    bi.fldGrpka322.setVisibility(View.GONE);
                } else {
                    bi.fldGrpka322.setVisibility(View.VISIBLE);
                }
            }
        });


        bi.ka32398.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (bi.ka32398.isChecked()) {
                    bi.ka323a.setText(null);
                    bi.ka323k.setText(null);

                    bi.ka323a.setVisibility(View.GONE);
                    bi.ka323k.setVisibility(View.GONE);

                } else {
                    bi.ka323a.setVisibility(View.VISIBLE);
                    bi.ka323k.setVisibility(View.VISIBLE);
                }
            }
        });


    }


    private void SaveDraft() throws JSONException {


        JSONObject sA1 = new JSONObject();

        sA1.put("ka301", bi.ka301a.isChecked() ? "1"
                : bi.ka301b.isChecked() ? "2"
                : bi.ka301c.isChecked() ? "3"
                : bi.ka301d.isChecked() ? "4"
                : bi.ka301e.isChecked() ? "5"
                : bi.ka301f.isChecked() ? "6"
                : bi.ka30196.isChecked() ? "96"
                : "0");

        sA1.put("ka30196x", bi.ka30196x.getText().toString());


        sA1.put("ka302", bi.ka302a.isChecked() ? "1"
                : bi.ka302b.isChecked() ? "2"
                : bi.ka302c.isChecked() ? "3"
                : bi.ka302d.isChecked() ? "4"
                : bi.ka302e.isChecked() ? "5"
                : bi.ka302f.isChecked() ? "6"
                : bi.ka302g.isChecked() ? "7"
                : bi.ka302h.isChecked() ? "8"
                : bi.ka30296.isChecked() ? "96"
                : "0");

        sA1.put("ka30296x", bi.ka30296x.getText().toString());


        sA1.put("ka303", bi.ka303a.isChecked() ? "1"
                : bi.ka303b.isChecked() ? "2"
                : bi.ka303c.isChecked() ? "3"
                : bi.ka303d.isChecked() ? "4"
                : bi.ka303e.isChecked() ? "5"
                : bi.ka303f.isChecked() ? "6"
                : bi.ka303g.isChecked() ? "7"
                : bi.ka303h.isChecked() ? "8"
                : bi.ka303i.isChecked() ? "9"
                : bi.ka303j.isChecked() ? "10"
                : bi.ka303k.isChecked() ? "11"
                : bi.ka30396.isChecked() ? "96"
                : "0");

        sA1.put("ka30396x", bi.ka30396x.getText().toString());


        sA1.put("ka304", bi.ka304a.isChecked() ? "1"
                : bi.ka304b.isChecked() ? "2"
                : bi.ka304c.isChecked() ? "3"
                : bi.ka304d.isChecked() ? "4"
                : bi.ka304e.isChecked() ? "5"
                : bi.ka304f.isChecked() ? "6"
                : bi.ka304g.isChecked() ? "7"
                : bi.ka304h.isChecked() ? "8"
                : bi.ka304i.isChecked() ? "9"
                : bi.ka30496.isChecked() ? "96"
                : "0");


        sA1.put("ka30496x", bi.ka30496x.getText().toString());


        sA1.put("ka305", bi.ka305a.isChecked() ? "1"
                : bi.ka305b.isChecked() ? "2"
                : bi.ka305c.isChecked() ? "3"
                : "0");


        sA1.put("ka306", bi.ka306.getText().toString());


        sA1.put("ka307", bi.ka307a.isChecked() ? "1"
                : bi.ka307b.isChecked() ? "2"
                : "0");


        sA1.put("ka308", bi.ka308a.isChecked() ? "1"
                : bi.ka308b.isChecked() ? "2"
                : bi.ka308c.isChecked() ? "3"
                : bi.ka308d.isChecked() ? "4"
                : bi.ka308e.isChecked() ? "5"
                : bi.ka308f.isChecked() ? "6"
                : bi.ka308g.isChecked() ? "7"
                : bi.ka308h.isChecked() ? "8"
                : bi.ka308i.isChecked() ? "9"
                : bi.ka308j.isChecked() ? "10"
                : bi.ka308k.isChecked() ? "11"
                : bi.ka30896.isChecked() ? "96"
                : "0");


        sA1.put("ka30896x", bi.ka30896x.getText().toString());


        sA1.put("ka309", bi.ka309a.isChecked() ? "1"
                : bi.ka309b.isChecked() ? "2"
                : bi.ka309c.isChecked() ? "3"
                : bi.ka309d.isChecked() ? "4"
                : bi.ka309e.isChecked() ? "5"
                : bi.ka309f.isChecked() ? "6"
                : bi.ka309g.isChecked() ? "7"
                : bi.ka309h.isChecked() ? "8"
                : bi.ka309i.isChecked() ? "9"
                : bi.ka309j.isChecked() ? "10"
                : bi.ka309k.isChecked() ? "11"
                : bi.ka309l.isChecked() ? "12"
                : bi.ka309m.isChecked() ? "13"
                : bi.ka309n.isChecked() ? "14"
                : bi.ka309o.isChecked() ? "15"
                : bi.ka30996.isChecked() ? "96"
                : "0");


        sA1.put("ka30996x", bi.ka30996x.getText().toString());


        sA1.put("ka310", bi.ka310a.isChecked() ? "1"
                : bi.ka310b.isChecked() ? "2"
                : bi.ka310c.isChecked() ? "3"
                : bi.ka310d.isChecked() ? "4"
                : bi.ka310e.isChecked() ? "5"
                : bi.ka310f.isChecked() ? "6"
                : bi.ka310g.isChecked() ? "7"
                : bi.ka310h.isChecked() ? "8"
                : bi.ka310i.isChecked() ? "9"
                : bi.ka310j.isChecked() ? "10"
                : bi.ka310k.isChecked() ? "11"
                : bi.ka310l.isChecked() ? "12"
                : bi.ka310m.isChecked() ? "13"
                : bi.ka310n.isChecked() ? "14"
                : bi.ka310o.isChecked() ? "15"
                : bi.ka31096.isChecked() ? "96"
                : "0");

        sA1.put("ka31096x", bi.ka31096x.getText().toString());


        sA1.put("ka311", bi.ka311a.isChecked() ? "1"
                : bi.ka311b.isChecked() ? "2"
                : "0");

        sA1.put("ka312", bi.ka312.getText().toString());


        sA1.put("ka313", bi.ka313a.isChecked() ? "1"
                : bi.ka313b.isChecked() ? "2"
                : bi.ka313c.isChecked() ? "3"
                : bi.ka313d.isChecked() ? "4"
                : "0");


        sA1.put("ka314", bi.ka314a.isChecked() ? "1"
                : bi.ka314b.isChecked() ? "2"
                : "0");


        sA1.put("ka315a", bi.ka315a.isChecked() ? "1" : "0");
        sA1.put("ka315b", bi.ka315b.isChecked() ? "2" : "0");
        sA1.put("ka315c", bi.ka315c.isChecked() ? "3" : "0");
        sA1.put("ka315d", bi.ka315d.isChecked() ? "4" : "0");
        sA1.put("ka315e", bi.ka315e.isChecked() ? "5" : "0");
        sA1.put("ka315f", bi.ka315f.isChecked() ? "6" : "0");
        sA1.put("ka31596", bi.ka31596.isChecked() ? "96" : "0");


        sA1.put("ka31596x", bi.ka31596x.getText().toString());


        sA1.put("ka316", bi.ka316a.isChecked() ? "1"
                : bi.ka316b.isChecked() ? "2"
                : bi.ka316c.isChecked() ? "3"
                : bi.ka316d.isChecked() ? "4"
                : bi.ka316e.isChecked() ? "5"
                : bi.ka316f.isChecked() ? "6"
                : bi.ka316g.isChecked() ? "7"
                : bi.ka316h.isChecked() ? "8"
                : bi.ka316i.isChecked() ? "9"
                : bi.ka316j.isChecked() ? "10"
                : bi.ka316k.isChecked() ? "11"
                : bi.ka31696.isChecked() ? "96"
                : "0");

        sA1.put("ka31696x", bi.ka31696x.getText().toString());

        sA1.put("ka317", bi.ka317a.isChecked() ? "1"
                : bi.ka317b.isChecked() ? "2"
                : "0");

        sA1.put("ka318", bi.ka318.getText().toString());


        sA1.put("ka319", bi.ka319a.isChecked() ? "1"
                : bi.ka319b.isChecked() ? "2"
                : "0");


        sA1.put("ka320", bi.ka320a.isChecked() ? "1"
                : bi.ka320b.isChecked() ? "2"
                : "0");

        sA1.put("ka321", bi.ka321a.isChecked() ? "1"
                : bi.ka321b.isChecked() ? "2"
                : "0");

        sA1.put("ka322", bi.ka322a.isChecked() ? "1"
                : bi.ka322b.isChecked() ? "2"
                : "0");


        sA1.put("ka323a", bi.ka323a.getText().toString());
        sA1.put("ka323k", bi.ka323k.getText().toString());
        sA1.put("ka32398", bi.ka32398.isChecked() ? "98" : "0");

        sA1.put("ka32401", bi.ka32401.getText().toString());
        sA1.put("ka32402", bi.ka32402.getText().toString());
        sA1.put("ka32403", bi.ka32403.getText().toString());
        sA1.put("ka32404", bi.ka32404.getText().toString());
        sA1.put("ka32405", bi.ka32405.getText().toString());
        sA1.put("ka32406", bi.ka32406.getText().toString());
        sA1.put("ka32407", bi.ka32407.getText().toString());
        sA1.put("ka32408", bi.ka32408.getText().toString());
        sA1.put("ka32409", bi.ka32409.getText().toString());
        sA1.put("ka32410", bi.ka32410.getText().toString());
        sA1.put("ka32411", bi.ka32411.getText().toString());
        sA1.put("ka32412", bi.ka32412.getText().toString());
        sA1.put("ka32413", bi.ka32413.getText().toString());
        sA1.put("ka32414", bi.ka32414.getText().toString());
        sA1.put("ka32415", bi.ka32415.getText().toString());
        sA1.put("ka32416", bi.ka32416.getText().toString());
        sA1.put("ka32417", bi.ka32417.getText().toString());
        sA1.put("ka32418", bi.ka32418.getText().toString());
        sA1.put("ka32419", bi.ka32419.getText().toString());
        sA1.put("ka32420", bi.ka32420.getText().toString());
        sA1.put("ka32496", bi.ka32496.getText().toString());


        MainApp.fc.setsA1(String.valueOf(sA1));
    }


    private boolean formValidation() {

        if (!validatorClass.EmptyRadioButton(this, bi.ka301, bi.ka301a, getString(R.string.ka301))) {
            return false;
        }


        if (bi.ka30196.isChecked()) {

            if (!validatorClass.EmptyTextBox(this, bi.ka30196x, getString(R.string.other))) {
                return false;
            }
        }


        if (!validatorClass.EmptyRadioButton(this, bi.ka302, bi.ka302a, getString(R.string.ka302))) {
            return false;
        }


        if (bi.ka30296.isChecked()) {

            if (!validatorClass.EmptyTextBox(this, bi.ka30296x, getString(R.string.other))) {
                return false;
            }
        }


        if (!validatorClass.EmptyRadioButton(this, bi.ka303, bi.ka303a, getString(R.string.ka303sub))) {
            return false;
        }


        if (bi.ka30396.isChecked()) {

            if (!validatorClass.EmptyTextBox(this, bi.ka30396x, getString(R.string.other))) {
                return false;
            }
        }


        if (!validatorClass.EmptyRadioButton(this, bi.ka304, bi.ka304a, getString(R.string.ka304sub))) {
            return false;
        }


        if (bi.ka30496.isChecked()) {

            if (!validatorClass.EmptyTextBox(this, bi.ka30496x, getString(R.string.other))) {
                return false;
            }
        }


        if (!validatorClass.EmptyRadioButton(this, bi.ka305, bi.ka305a, getString(R.string.ka305))) {
            return false;
        }


        if (!validatorClass.EmptyTextBox(this, bi.ka306, getString(R.string.ka306))) {
            return false;
        }


        if (!validatorClass.RangeTextBox(this, bi.ka306, 1, 15, getString(R.string.ka306), "Rooms")) {
            return false;
        }


        if (!validatorClass.EmptyRadioButton(this, bi.ka307, bi.ka307a, getString(R.string.ka307))) {
            return false;
        }


        if (!validatorClass.EmptyRadioButton(this, bi.ka308, bi.ka308a, getString(R.string.ka308))) {
            return false;
        }


        if (bi.ka30896.isChecked()) {

            if (!validatorClass.EmptyTextBox(this, bi.ka30896x, getString(R.string.other))) {
                return false;
            }
        }


        if (!validatorClass.EmptyRadioButton(this, bi.ka309, bi.ka309a, getString(R.string.ka309))) {
            return false;
        }


        if (!validatorClass.EmptyRadioButton(this, bi.ka310, bi.ka310a, getString(R.string.ka310))) {
            return false;
        }


        if (bi.ka31096.isChecked()) {

            if (!validatorClass.EmptyTextBox(this, bi.ka31096x, getString(R.string.other))) {
                return false;
            }
        }


        if (!validatorClass.EmptyRadioButton(this, bi.ka311, bi.ka311a, getString(R.string.ka311))) {
            return false;
        }


        if (bi.ka311a.isChecked()) {

            if (!validatorClass.EmptyTextBox(this, bi.ka312, getString(R.string.ka312))) {
                return false;
            }


            if (Integer.valueOf(bi.ka312.getText().toString()) <= 0) {
                Toast.makeText(this, "Must be greater than 0 ", Toast.LENGTH_SHORT).show();
                bi.ka312.requestFocus();
                return false;
            }


            if (!validatorClass.EmptyRadioButton(this, bi.ka313, bi.ka313a, getString(R.string.ka313))) {
                return false;
            }
        }


        if (!validatorClass.EmptyRadioButton(this, bi.ka314, bi.ka314a, getString(R.string.ka314))) {
            return false;
        }


        if (bi.ka314a.isChecked()) {

            if (!validatorClass.EmptyCheckBox(this, bi.fldGrpka315, bi.ka315a, getString(R.string.ka315))) {
                return false;
            }


            if (bi.ka31596.isChecked()) {

                if (!validatorClass.EmptyTextBox(this, bi.ka31596x, getString(R.string.other))) {
                    return false;
                }
            }

        }


        if (!validatorClass.EmptyRadioButton(this, bi.ka316, bi.ka316a, getString(R.string.ka316))) {
            return false;
        }


        if (bi.ka31696.isChecked()) {

            if (!validatorClass.EmptyTextBox(this, bi.ka31696x, getString(R.string.other))) {
                return false;
            }
        }


        if (!validatorClass.EmptyRadioButton(this, bi.ka317, bi.ka317a, getString(R.string.ka317))) {
            return false;
        }


        if (bi.ka317a.isChecked()) {

            if (!validatorClass.EmptyTextBox(this, bi.ka318, getString(R.string.ka318))) {
                return false;
            }

            if (!validatorClass.RangeTextBox(this, bi.ka318, 1, 15, getString(R.string.ka318), "Toilet")) {
                return false;
            }
        }


        if (!validatorClass.EmptyRadioButton(this, bi.ka319, bi.ka319a, getString(R.string.ka319))) {
            return false;
        }


        if (!validatorClass.EmptyRadioButton(this, bi.ka320, bi.ka320a, getString(R.string.ka320))) {
            return false;
        }


        if (!validatorClass.EmptyRadioButton(this, bi.ka321, bi.ka321a, getString(R.string.ka321))) {
            return false;
        }


        if (!validatorClass.EmptyRadioButton(this, bi.ka322, bi.ka322a, getString(R.string.ka322))) {
            return false;
        }


        if (bi.ka322a.isChecked()) {

            if (!bi.ka32398.isChecked()) {

                if (!validatorClass.EmptyTextBox(this, bi.ka323a, getString(R.string.ka323acr))) {
                    return false;
                }


                if (!validatorClass.EmptyTextBox(this, bi.ka323k, getString(R.string.ka323can))) {
                    return false;
                }
            }
        }


        if (!validatorClass.EmptyTextBox(this, bi.ka32401, getString(R.string.ka32401))) {
            return false;
        }


        if (!validatorClass.RangeTextBox(this, bi.ka32401, 0, 99, getString(R.string.ka32401), "Quantity")) {
            return false;
        }


        if (!validatorClass.EmptyTextBox(this, bi.ka32402, getString(R.string.ka32402))) {
            return false;
        }


        if (!validatorClass.RangeTextBox(this, bi.ka32402, 0, 99, getString(R.string.ka32402), "Quantity")) {
            return false;
        }


        if (!validatorClass.EmptyTextBox(this, bi.ka32403, getString(R.string.ka32403))) {
            return false;
        }


        if (!validatorClass.RangeTextBox(this, bi.ka32403, 0, 10, getString(R.string.ka32403), "Quantity")) {
            return false;
        }


        if (!validatorClass.EmptyTextBox(this, bi.ka32404, getString(R.string.ka32404))) {
            return false;
        }


        if (!validatorClass.RangeTextBox(this, bi.ka32404, 0, 10, getString(R.string.ka32404), "Quantity")) {
            return false;
        }


        if (!validatorClass.EmptyTextBox(this, bi.ka32405, getString(R.string.ka32405))) {
            return false;
        }


        if (!validatorClass.RangeTextBox(this, bi.ka32405, 0, 10, getString(R.string.ka32405), "Quantity")) {
            return false;
        }


        if (!validatorClass.EmptyTextBox(this, bi.ka32406, getString(R.string.ka32406))) {
            return false;
        }


        if (!validatorClass.RangeTextBox(this, bi.ka32406, 0, 10, getString(R.string.ka32406), "Quantity")) {
            return false;
        }


        if (!validatorClass.EmptyTextBox(this, bi.ka32407, getString(R.string.ka32407))) {
            return false;
        }


        if (!validatorClass.RangeTextBox(this, bi.ka32407, 0, 10, getString(R.string.ka32407), "Quantity")) {
            return false;
        }


        if (!validatorClass.EmptyTextBox(this, bi.ka32408, getString(R.string.ka32408))) {
            return false;
        }


        if (!validatorClass.RangeTextBox(this, bi.ka32408, 0, 10, getString(R.string.ka32408), "Quantity")) {
            return false;
        }


        if (!validatorClass.EmptyTextBox(this, bi.ka32409, getString(R.string.ka32409))) {
            return false;
        }


        if (!validatorClass.RangeTextBox(this, bi.ka32409, 0, 10, getString(R.string.ka32409), "Quantity")) {
            return false;
        }


        if (!validatorClass.EmptyTextBox(this, bi.ka32410, getString(R.string.ka32410))) {
            return false;
        }


        if (!validatorClass.RangeTextBox(this, bi.ka32410, 0, 10, getString(R.string.ka32410), "Quantity")) {
            return false;
        }


        if (!validatorClass.EmptyTextBox(this, bi.ka32411, getString(R.string.ka32411))) {
            return false;
        }


        if (!validatorClass.RangeTextBox(this, bi.ka32411, 0, 10, getString(R.string.ka32411), "Quantity")) {
            return false;
        }


        if (!validatorClass.EmptyTextBox(this, bi.ka32412, getString(R.string.ka32412))) {
            return false;
        }


        if (!validatorClass.RangeTextBox(this, bi.ka32412, 0, 10, getString(R.string.ka32412), "Quantity")) {
            return false;
        }


        if (!validatorClass.EmptyTextBox(this, bi.ka32413, getString(R.string.ka32413))) {
            return false;
        }


        if (!validatorClass.RangeTextBox(this, bi.ka32413, 0, 10, getString(R.string.ka32413), "Quantity")) {
            return false;
        }


        if (!validatorClass.EmptyTextBox(this, bi.ka32414, getString(R.string.ka32414))) {
            return false;
        }


        if (!validatorClass.RangeTextBox(this, bi.ka32414, 0, 10, getString(R.string.ka32414), "Quantity")) {
            return false;
        }


        if (!validatorClass.EmptyTextBox(this, bi.ka32415, getString(R.string.ka32415))) {
            return false;
        }


        if (!validatorClass.RangeTextBox(this, bi.ka32415, 0, 10, getString(R.string.ka32415), "Quantity")) {
            return false;
        }


        if (!validatorClass.EmptyTextBox(this, bi.ka32416, getString(R.string.ka32415))) {
            return false;
        }


        if (!validatorClass.RangeTextBox(this, bi.ka32416, 0, 10, getString(R.string.ka32416), "Quantity")) {
            return false;
        }


        if (!validatorClass.EmptyTextBox(this, bi.ka32417, getString(R.string.ka32417))) {
            return false;
        }


        if (!validatorClass.RangeTextBox(this, bi.ka32417, 0, 10, getString(R.string.ka32417), "Quantity")) {
            return false;
        }


        if (!validatorClass.EmptyTextBox(this, bi.ka32418, getString(R.string.ka32418))) {
            return false;
        }


        if (!validatorClass.RangeTextBox(this, bi.ka32418, 0, 10, getString(R.string.ka32418), "Quantity")) {
            return false;
        }


        if (!validatorClass.EmptyTextBox(this, bi.ka32419, getString(R.string.ka32419))) {
            return false;
        }


        if (!validatorClass.RangeTextBox(this, bi.ka32419, 0, 10, getString(R.string.ka32419), "Quantity")) {
            return false;
        }


        if (!validatorClass.EmptyTextBox(this, bi.ka32420, getString(R.string.ka32420))) {
            return false;
        }


        if (!validatorClass.RangeTextBox(this, bi.ka32420, 0, 10, getString(R.string.ka32420), "Quantity")) {
            return false;
        }


        if (!validatorClass.EmptyTextBox(this, bi.ka32496, getString(R.string.other))) {
            return false;
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

                startActivity(new Intent(this, SectionB2Activity.class));
                //startActivity(new Intent(this, MainActivity.class));

            } else {
                Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
            }
        }
    }


    private boolean UpdateDB() {

        //Long rowId;
        DatabaseHelper db = new DatabaseHelper(this);

        int updcount = db.updateSA1();

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