package edu.aku.hassannaqvi.kmc_validate_app.ui;

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

import java.text.SimpleDateFormat;
import java.util.Date;

import edu.aku.hassannaqvi.kmc_validate_app.R;
import edu.aku.hassannaqvi.kmc_validate_app.core.DatabaseHelper;
import edu.aku.hassannaqvi.kmc_validate_app.core.MainApp;
import edu.aku.hassannaqvi.kmc_validate_app.databinding.ActivitySectionCBinding;
import edu.aku.hassannaqvi.kmc_validate_app.validation.validatorClass;

public class SectionCActivity extends AppCompatActivity {

    private static final String TAG = SectionCActivity.class.getName();
    String dtToday = new SimpleDateFormat("dd-MM-yy HH:mm").format(new Date().getTime());

    ActivitySectionCBinding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //setContentView(R.layout.activity_section_c);

        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_c);
        bi.setCallback(this);
        setupViews();
    }


    private void setupViews() {

        bi.kc0196.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (bi.kc0196.isChecked()) {
                    bi.kc0196x.setVisibility(View.VISIBLE);
                } else {
                    bi.kc0196x.setText(null);
                    bi.kc0196x.setVisibility(View.GONE);
                }
            }
        });

        bi.kc04g.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    bi.kc04a.setChecked(false);
                    bi.kc04b.setChecked(false);
                    bi.kc04c.setChecked(false);
                    bi.kc04d.setChecked(false);
                    bi.kc04e.setChecked(false);
                    bi.kc04f.setChecked(false);
                    bi.kc04a.setEnabled(false);
                    bi.kc04b.setEnabled(false);
                    bi.kc04c.setEnabled(false);
                    bi.kc04d.setEnabled(false);
                    bi.kc04e.setEnabled(false);
                    bi.kc04f.setEnabled(false);
                } else {
                    bi.kc04a.setEnabled(true);
                    bi.kc04b.setEnabled(true);
                    bi.kc04c.setEnabled(true);
                    bi.kc04d.setEnabled(true);
                    bi.kc04e.setEnabled(true);
                    bi.kc04f.setEnabled(true);
                }
            }
        });

        bi.kc06.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (bi.kc06b.isChecked()) {

                    bi.kc07a.setChecked(false);
                    bi.kc07b.setChecked(false);
                    bi.kc07c.setChecked(false);
                    bi.kc0796.setChecked(false);
                    bi.kc0796x.setText(null);

                    bi.kc08.clearCheck();
                    bi.kc0896x.setText(null);

                    bi.fldGrpkc06.setVisibility(View.GONE);
                } else {
                    bi.fldGrpkc06.setVisibility(View.VISIBLE);
                }
            }
        });


        bi.kc09j.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    bi.kc09a.setChecked(false);
                    bi.kc09b.setChecked(false);
                    bi.kc09c.setChecked(false);
                    bi.kc09d.setChecked(false);
                    bi.kc09e.setChecked(false);
                    bi.kc09f.setChecked(false);
                    bi.kc09g.setChecked(false);
                    bi.kc09h.setChecked(false);
                    bi.kc09i.setChecked(false);
                    bi.kc0996.setChecked(false);

                    bi.kc09a.setEnabled(false);
                    bi.kc09b.setEnabled(false);
                    bi.kc09c.setEnabled(false);
                    bi.kc09d.setEnabled(false);
                    bi.kc09e.setEnabled(false);
                    bi.kc09f.setEnabled(false);
                    bi.kc09g.setEnabled(false);
                    bi.kc09h.setEnabled(false);
                    bi.kc09i.setEnabled(false);
                    bi.kc0996.setEnabled(false);

                    bi.kc0996x.setText(null);
                } else {

                    bi.kc09a.setEnabled(true);
                    bi.kc09b.setEnabled(true);
                    bi.kc09c.setEnabled(true);
                    bi.kc09d.setEnabled(true);
                    bi.kc09e.setEnabled(true);
                    bi.kc09f.setEnabled(true);
                    bi.kc09g.setEnabled(true);
                    bi.kc09h.setEnabled(true);
                    bi.kc09i.setEnabled(true);
                    bi.kc0996.setEnabled(true);
                }
            }
        });


        bi.kc12a.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    bi.kc12b.setChecked(false);
                    bi.kc12c.setChecked(false);
                    bi.kc12d.setChecked(false);
                    bi.kc12e.setChecked(false);
                    bi.kc12f.setChecked(false);
                    bi.kc12g.setChecked(false);
                    bi.kc12h.setChecked(false);
                    bi.kc12i.setChecked(false);
                    bi.kc12j.setChecked(false);
                    bi.kc12k.setChecked(false);
                    bi.kc1296.setChecked(false);

                    bi.kc12b.setEnabled(false);
                    bi.kc12c.setEnabled(false);
                    bi.kc12d.setEnabled(false);
                    bi.kc12e.setEnabled(false);
                    bi.kc12f.setEnabled(false);
                    bi.kc12g.setEnabled(false);
                    bi.kc12h.setEnabled(false);
                    bi.kc12i.setEnabled(false);
                    bi.kc12j.setEnabled(false);
                    bi.kc12k.setEnabled(false);
                    bi.kc1296.setEnabled(false);

                    bi.kc1296x.setText(null);
                } else {

                    bi.kc12b.setEnabled(true);
                    bi.kc12c.setEnabled(true);
                    bi.kc12d.setEnabled(true);
                    bi.kc12e.setEnabled(true);
                    bi.kc12f.setEnabled(true);
                    bi.kc12g.setEnabled(true);
                    bi.kc12h.setEnabled(true);
                    bi.kc12i.setEnabled(true);
                    bi.kc12j.setEnabled(true);
                    bi.kc12k.setEnabled(true);
                    bi.kc1296.setEnabled(true);
                }
            }
        });


        bi.kc15e.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    bi.kc15a.setChecked(false);
                    bi.kc15b.setChecked(false);
                    bi.kc15c.setChecked(false);
                    bi.kc15d.setChecked(false);
                    bi.kc1596.setChecked(false);

                    bi.kc15a.setEnabled(false);
                    bi.kc15b.setEnabled(false);
                    bi.kc15c.setEnabled(false);
                    bi.kc15d.setEnabled(false);
                    bi.kc1596.setEnabled(false);

                } else {
                    bi.kc15a.setEnabled(true);
                    bi.kc15b.setEnabled(true);
                    bi.kc15c.setEnabled(true);
                    bi.kc15d.setEnabled(true);
                    bi.kc1596.setEnabled(true);

                }
            }
        });


        bi.kc18g.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    bi.kc18a.setChecked(false);
                    bi.kc18b.setChecked(false);
                    bi.kc18c.setChecked(false);
                    bi.kc18d.setChecked(false);
                    bi.kc18e.setChecked(false);
                    bi.kc18f.setChecked(false);
                    bi.kc1896.setChecked(false);

                    bi.kc18a.setEnabled(false);
                    bi.kc18b.setEnabled(false);
                    bi.kc18c.setEnabled(false);
                    bi.kc18d.setEnabled(false);
                    bi.kc18e.setEnabled(false);
                    bi.kc18f.setEnabled(false);
                    bi.kc1896.setEnabled(false);

                    bi.kc1896x.setText(null);
                } else {
                    bi.kc18a.setEnabled(true);
                    bi.kc18b.setEnabled(true);
                    bi.kc18c.setEnabled(true);
                    bi.kc18d.setEnabled(true);
                    bi.kc18e.setEnabled(true);
                    bi.kc18f.setEnabled(true);
                    bi.kc1896.setEnabled(true);
                }
            }
        });


        bi.kc0796.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (bi.kc0796.isChecked()) {
                    bi.kc0796x.setVisibility(View.VISIBLE);
                } else {
                    bi.kc0796x.setText(null);
                    bi.kc0796x.setVisibility(View.GONE);
                }
            }
        });


        bi.kc0896.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (bi.kc0896.isChecked()) {
                    bi.kc0896x.setVisibility(View.VISIBLE);
                } else {
                    bi.kc0896x.setText(null);
                    bi.kc0896x.setVisibility(View.GONE);
                }
            }
        });


        bi.kc0996.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (bi.kc0996.isChecked()) {
                    bi.kc0996x.setVisibility(View.VISIBLE);
                } else {
                    bi.kc0996x.setText(null);
                    bi.kc0996x.setVisibility(View.GONE);
                }
            }
        });


        bi.kc10.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (bi.kc10b.isChecked()) {

                    bi.kc11a.setChecked(false);
                    bi.kc11b.setChecked(false);
                    bi.kc11c.setChecked(false);
                    bi.kc1196.setChecked(false);
                    bi.kc1196x.setText(null);

                    bi.fldGrpkc10.setVisibility(View.GONE);
                } else {
                    bi.fldGrpkc10.setVisibility(View.VISIBLE);
                }
            }
        });


        bi.kc1196.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (bi.kc1196.isChecked()) {
                    bi.kc1196x.setVisibility(View.VISIBLE);
                } else {
                    bi.kc1196x.setText(null);
                    bi.kc1196x.setVisibility(View.GONE);
                }
            }
        });


        bi.kc1296.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (bi.kc1296.isChecked()) {
                    bi.kc1296x.setVisibility(View.VISIBLE);
                } else {
                    bi.kc1296x.setText(null);
                    bi.kc1296x.setVisibility(View.GONE);
                }
            }
        });


        bi.kc13.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (bi.kc13b.isChecked()) {

                    bi.kc14a.setChecked(false);
                    bi.kc14b.setChecked(false);
                    bi.kc14c.setChecked(false);
                    bi.kc14d.setChecked(false);
                    bi.kc14e.setChecked(false);
                    bi.kc14f.setChecked(false);
                    bi.kc1496.setChecked(false);
                    bi.kc1496x.setText(null);

                    bi.fldGrpkc13.setVisibility(View.GONE);
                } else {
                    bi.fldGrpkc13.setVisibility(View.VISIBLE);
                }
            }
        });


        bi.kc1496.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (bi.kc1496.isChecked()) {
                    bi.kc1496x.setVisibility(View.VISIBLE);
                } else {
                    bi.kc1496x.setText(null);
                    bi.kc1496x.setVisibility(View.GONE);
                }
            }
        });


        bi.kc1596.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (bi.kc1596.isChecked()) {
                    bi.kc1596x.setVisibility(View.VISIBLE);
                } else {
                    bi.kc1596x.setText(null);
                    bi.kc1596x.setVisibility(View.GONE);
                }
            }
        });


        bi.kc1896.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (bi.kc1896.isChecked()) {
                    bi.kc1896x.setVisibility(View.VISIBLE);
                } else {
                    bi.kc1896x.setText(null);
                    bi.kc1896x.setVisibility(View.GONE);
                }
            }
        });


        bi.kc19.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                if (bi.kc19b.isChecked() || bi.kc1999.isChecked()) {

                    bi.kc20a.setChecked(false);
                    bi.kc20b.setChecked(false);
                    bi.kc20c.setChecked(false);
                    bi.kc20d.setChecked(false);
                    bi.kc20e.setChecked(false);
                    bi.kc2096.setChecked(false);

                    bi.kc2096x.setText(null);
                    bi.kc2096x.setVisibility(View.GONE);

                    bi.fldGrpkc19.setVisibility(View.GONE);
                } else {
                    bi.fldGrpkc19.setVisibility(View.VISIBLE);
                }
            }
        });


       /* bi.kc21b.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    bi.kc22.clearCheck();
                    bi.fldGrpkc21.setVisibility(View.GONE);
                } else {
                    bi.fldGrpkc21.setVisibility(View.VISIBLE);
                }
            }
        });
*/

        bi.kc2196.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (bi.kc2196.isChecked()) {
                    bi.kc2196x.setVisibility(View.VISIBLE);
                } else {
                    bi.kc2196x.setText(null);
                    bi.kc2196x.setVisibility(View.GONE);
                }
            }
        });


        bi.kc2396.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (bi.kc2396.isChecked()) {
                    bi.kc2396x.setVisibility(View.VISIBLE);
                } else {
                    bi.kc2396x.setText(null);
                    bi.kc2396x.setVisibility(View.GONE);
                }
            }
        });
    }


    private boolean formValidation() {


        if (!validatorClass.EmptyRadioButton(this, bi.kc01, bi.kc01a, getString(R.string.kc01))) {
            return false;
        }


        if (bi.kc0196.isChecked()) {

            if (!validatorClass.EmptyTextBox(this, bi.kc0196x, getString(R.string.other))) {
                return false;
            }
        }


        if (!validatorClass.EmptyRadioButton(this, bi.kc02, bi.kc02a, getString(R.string.kc02))) {
            return false;
        }


        if (!validatorClass.EmptyTextBox(this, bi.kc03, getString(R.string.kc03))) {
            return false;
        }


        if (!validatorClass.RangeTextBox(this, bi.kc03, 0, 18, getString(R.string.kc03hr), "Hours ")) {
            return false;
        }


        if (!validatorClass.EmptyCheckBox(this, bi.kc04, bi.kc04a, getString(R.string.kc04))) {
            return false;
        }


        if (!validatorClass.EmptyTextBox(this, bi.kc05hr, getString(R.string.kc05))) {
            return false;
        }


        if (!validatorClass.RangeTextBox(this, bi.kc05hr, 0, 10, getString(R.string.kc03hr), "Hours ")) {
            return false;
        }


        if (!validatorClass.EmptyRadioButton(this, bi.kc06, bi.kc06a, getString(R.string.kc06))) {
            return false;
        }


        if (bi.kc06a.isChecked()) {

            if (!validatorClass.EmptyCheckBox(this, bi.kc07, bi.kc07a, getString(R.string.kc07))) {
                return false;
            }


            if (bi.kc0796.isChecked()) {

                if (!validatorClass.EmptyTextBox(this, bi.kc0796x, getString(R.string.other))) {
                    return false;
                }
            }


            if (!validatorClass.EmptyRadioButton(this, bi.kc08, bi.kc08a, getString(R.string.kc08))) {
                return false;
            }


            if (bi.kc0896.isChecked()) {

                if (!validatorClass.EmptyTextBox(this, bi.kc0896x, getString(R.string.other))) {
                    return false;
                }
            }
        }


        if (!validatorClass.EmptyCheckBox(this, bi.kc09, bi.kc09a, getString(R.string.kc09))) {
            return false;
        }


        if (bi.kc0996.isChecked()) {

            if (!validatorClass.EmptyTextBox(this, bi.kc0996x, getString(R.string.other))) {
                return false;
            }
        }


        if (!validatorClass.EmptyRadioButton(this, bi.kc10, bi.kc10a, getString(R.string.kc10))) {
            return false;
        }


        if (bi.kc10a.isChecked()) {

            if (!validatorClass.EmptyCheckBox(this, bi.kc11, bi.kc11a, getString(R.string.kc11))) {
                return false;
            }


            if (bi.kc1196.isChecked()) {

                if (!validatorClass.EmptyTextBox(this, bi.kc1196x, getString(R.string.other))) {
                    return false;
                }
            }
        }


        if (!validatorClass.EmptyCheckBox(this, bi.kc12, bi.kc12a, getString(R.string.kc12))) {
            return false;
        }


        if (bi.kc1296.isChecked()) {

            if (!validatorClass.EmptyTextBox(this, bi.kc1296x, getString(R.string.other))) {
                return false;
            }
        }


        if (!validatorClass.EmptyRadioButton(this, bi.kc13, bi.kc13a, getString(R.string.kc13))) {
            return false;
        }


        if (bi.kc13a.isChecked()) {

            if (!validatorClass.EmptyCheckBox(this, bi.kc14, bi.kc14a, getString(R.string.kc14))) {
                return false;
            }


            if (bi.kc1496.isChecked()) {

                if (!validatorClass.EmptyTextBox(this, bi.kc1496x, getString(R.string.other))) {
                    return false;
                }
            }
        }


        if (!validatorClass.EmptyCheckBox(this, bi.kc15, bi.kc15a, getString(R.string.kc15))) {
            return false;
        }


        if (bi.kc1596.isChecked()) {

            if (!validatorClass.EmptyTextBox(this, bi.kc1596x, getString(R.string.other))) {
                return false;
            }
        }


        if (!validatorClass.EmptyRadioButton(this, bi.kc16, bi.kc16a, getString(R.string.kc16))) {
            return false;
        }


        if (!validatorClass.EmptyRadioButton(this, bi.kc17, bi.kc17a, getString(R.string.kc17))) {
            return false;
        }


        if (!validatorClass.EmptyCheckBox(this, bi.kc18, bi.kc18a, getString(R.string.kc18))) {
            return false;
        }


        if (bi.kc1896.isChecked()) {

            if (!validatorClass.EmptyTextBox(this, bi.kc1896x, getString(R.string.other))) {
                return false;
            }
        }


        if (!validatorClass.EmptyRadioButton(this, bi.kc19, bi.kc19a, getString(R.string.kc19))) {
            return false;
        }


        if (bi.kc19a.isChecked() || bi.kc19c.isChecked()) {

            if (!validatorClass.EmptyCheckBox(this, bi.kc20, bi.kc20a, getString(R.string.kc20))) {
                return false;
            }


            if (bi.kc2096.isChecked()) {

                if (!validatorClass.EmptyTextBox(this, bi.kc2096x, getString(R.string.other))) {
                    return false;
                }
            }
        }


        if (!validatorClass.EmptyCheckBox(this, bi.kc21, bi.kc21a, getString(R.string.kc21))) {
            return false;
        }


        if (bi.kc2196.isChecked()) {

            if (!validatorClass.EmptyTextBox(this, bi.kc2196x, getString(R.string.other))) {
                return false;
            }
        }


        if (!validatorClass.EmptyRadioButton(this, bi.kc22, bi.kc22a, getString(R.string.kc22))) {
            return false;
        }


        if (!validatorClass.EmptyCheckBox(this, bi.kc23, bi.kc23a, getString(R.string.kc23))) {
            return false;
        }


        if (bi.kc2396.isChecked()) {

            if (!validatorClass.EmptyTextBox(this, bi.kc2396x, getString(R.string.other))) {
                return false;
            }
        }


        return validatorClass.EmptyRadioButton(this, bi.kc24, bi.kc24a, getString(R.string.kc24));
    }


    private void SaveDraft() throws JSONException {

        JSONObject sE = new JSONObject();

        sE.put("kc01", bi.kc01a.isChecked() ? "1"
                : bi.kc01b.isChecked() ? "2"
                : bi.kc01c.isChecked() ? "3"
                : bi.kc01d.isChecked() ? "4"
                : bi.kc01e.isChecked() ? "5"
                : bi.kc01f.isChecked() ? "6"
                : bi.kc01g.isChecked() ? "7"
                : bi.kc01h.isChecked() ? "8"
                : bi.kc0196.isChecked() ? "96"
                : "0");

        sE.put("kc0196x", bi.kc0196x.getText().toString());


        sE.put("kc02", bi.kc02a.isChecked() ? "1"
                : bi.kc02b.isChecked() ? "2"
                : "0");

        sE.put("kc03hr", bi.kc03.getText().toString());

        sE.put("kc04a", bi.kc04a.isChecked() ? "1" : "0");
        sE.put("kc04b", bi.kc04b.isChecked() ? "2" : "0");
        sE.put("kc04c", bi.kc04c.isChecked() ? "3" : "0");
        sE.put("kc04d", bi.kc04d.isChecked() ? "4" : "0");
        sE.put("kc04e", bi.kc04e.isChecked() ? "5" : "0");
        sE.put("kc04f", bi.kc04f.isChecked() ? "6" : "0");
        sE.put("kc04g", bi.kc04g.isChecked() ? "7" : "0");


        sE.put("kc05hr", bi.kc05hr.getText().toString());


        sE.put("kc06", bi.kc06a.isChecked() ? "1"
                : bi.kc06b.isChecked() ? "2"
                : "0");


        sE.put("kc07a", bi.kc07a.isChecked() ? "1" : "0");
        sE.put("kc07b", bi.kc07b.isChecked() ? "2" : "0");
        sE.put("kc07c", bi.kc07c.isChecked() ? "3" : "0");
        sE.put("kc0796", bi.kc0796.isChecked() ? "96" : "0");

        sE.put("kc0796x", bi.kc0796x.getText().toString());


        sE.put("kc08", bi.kc08a.isChecked() ? "1"
                : bi.kc08b.isChecked() ? "2"
                : bi.kc08c.isChecked() ? "3"
                : bi.kc0896.isChecked() ? "96"
                : "0");

        sE.put("kc0896x", bi.kc0896x.getText().toString());


        sE.put("kc09a", bi.kc09a.isChecked() ? "1" : "0");
        sE.put("kc09b", bi.kc09b.isChecked() ? "2" : "0");
        sE.put("kc09c", bi.kc09c.isChecked() ? "3" : "0");
        sE.put("kc09d", bi.kc09d.isChecked() ? "4" : "0");
        sE.put("kc09e", bi.kc09e.isChecked() ? "5" : "0");
        sE.put("kc09f", bi.kc09f.isChecked() ? "6" : "0");
        sE.put("kc09g", bi.kc09g.isChecked() ? "7" : "0");
        sE.put("kc09h", bi.kc09h.isChecked() ? "8" : "0");
        sE.put("kc09i", bi.kc09i.isChecked() ? "9" : "0");
        sE.put("kc09j", bi.kc09j.isChecked() ? "10" : "0");
        sE.put("kc0996", bi.kc0996.isChecked() ? "96" : "0");

        sE.put("kc0996x", bi.kc0996x.getText().toString());

        sE.put("kc10", bi.kc10a.isChecked() ? "1"
                : bi.kc10b.isChecked() ? "2"
                : "0");


        sE.put("kc11a", bi.kc11a.isChecked() ? "1" : "0");
        sE.put("kc11b", bi.kc11b.isChecked() ? "2" : "0");
        sE.put("kc11c", bi.kc11c.isChecked() ? "3" : "0");
        sE.put("kc1196", bi.kc1196.isChecked() ? "96" : "0");


        sE.put("kc1196x", bi.kc1196x.getText().toString());


        sE.put("kc12a", bi.kc12a.isChecked() ? "1" : "0");
        sE.put("kc12b", bi.kc12b.isChecked() ? "2" : "0");
        sE.put("kc12c", bi.kc12c.isChecked() ? "3" : "0");
        sE.put("kc12d", bi.kc12d.isChecked() ? "4" : "0");
        sE.put("kc12e", bi.kc12e.isChecked() ? "5" : "0");
        sE.put("kc12f", bi.kc12f.isChecked() ? "6" : "0");
        sE.put("kc12g", bi.kc12g.isChecked() ? "7" : "0");
        sE.put("kc12h", bi.kc12h.isChecked() ? "8" : "0");
        sE.put("kc12i", bi.kc12i.isChecked() ? "9" : "0");
        sE.put("kc12j", bi.kc12j.isChecked() ? "10" : "0");
        sE.put("kc12k", bi.kc12k.isChecked() ? "11" : "0");
        sE.put("kc1296", bi.kc1296.isChecked() ? "96" : "0");

        sE.put("kc1296x", bi.kc1296x.getText().toString());


        sE.put("kc13", bi.kc13a.isChecked() ? "1"
                : bi.kc13b.isChecked() ? "2"
                : "0");


        sE.put("kc14a", bi.kc14a.isChecked() ? "1" : "0");
        sE.put("kc14b", bi.kc14b.isChecked() ? "2" : "0");
        sE.put("kc14c", bi.kc14c.isChecked() ? "3" : "0");
        sE.put("kc14d", bi.kc14d.isChecked() ? "4" : "0");
        sE.put("kc14e", bi.kc14e.isChecked() ? "5" : "0");
        sE.put("kc14f", bi.kc14f.isChecked() ? "6" : "0");
        sE.put("kc1496", bi.kc1496.isChecked() ? "96" : "0");

        sE.put("kc1496x", bi.kc1496x.getText().toString());


        sE.put("kc15a", bi.kc15a.isChecked() ? "1" : "0");
        sE.put("kc15b", bi.kc15b.isChecked() ? "2" : "0");
        sE.put("kc15c", bi.kc15c.isChecked() ? "3" : "0");
        sE.put("kc15d", bi.kc15d.isChecked() ? "4" : "0");
        sE.put("kc15e", bi.kc15e.isChecked() ? "5" : "0");
        sE.put("kc1596", bi.kc1596.isChecked() ? "96" : "0");

        sE.put("kc1596x", bi.kc1596x.getText().toString());


        sE.put("kc16", bi.kc16a.isChecked() ? "1"
                : bi.kc16b.isChecked() ? "2"
                : bi.kc16c.isChecked() ? "3"
                : bi.kc16d.isChecked() ? "4"
                : bi.kc1699.isChecked() ? "99"
                : "0");


        sE.put("kc17", bi.kc17a.isChecked() ? "1"
                : bi.kc17b.isChecked() ? "2"
                : bi.kc17c.isChecked() ? "3"
                : bi.kc17d.isChecked() ? "4"
                : bi.kc1799.isChecked() ? "99"
                : "0");


        sE.put("kc18a", bi.kc18a.isChecked() ? "1" : "0");
        sE.put("kc18b", bi.kc18b.isChecked() ? "2" : "0");
        sE.put("kc18c", bi.kc18c.isChecked() ? "3" : "0");
        sE.put("kc18d", bi.kc18d.isChecked() ? "4" : "0");
        sE.put("kc18e", bi.kc18e.isChecked() ? "5" : "0");
        sE.put("kc18f", bi.kc18f.isChecked() ? "6" : "0");
        sE.put("kc18g", bi.kc18g.isChecked() ? "7" : "0");
        sE.put("kc1896", bi.kc1896.isChecked() ? "96" : "0");


        sE.put("kc1896x", bi.kc1896x.getText().toString());


        sE.put("kc19", bi.kc19a.isChecked() ? "1"
                : bi.kc19b.isChecked() ? "2"
                : bi.kc19c.isChecked() ? "3"
                : bi.kc1999.isChecked() ? "99"
                : "0");


        sE.put("kc20a", bi.kc20a.isChecked() ? "1" : "0");
        sE.put("kc20b", bi.kc20b.isChecked() ? "2" : "0");
        sE.put("kc20c", bi.kc20c.isChecked() ? "3" : "0");
        sE.put("kc20d", bi.kc20d.isChecked() ? "4" : "0");
        sE.put("kc20e", bi.kc20e.isChecked() ? "5" : "0");
        sE.put("kc2096", bi.kc2096.isChecked() ? "96" : "0");


        sE.put("kc2096x", bi.kc2096x.getText().toString());


        sE.put("kc21a", bi.kc21a.isChecked() ? "1" : "0");
        sE.put("kc21b", bi.kc21b.isChecked() ? "2" : "0");
        sE.put("kc21c", bi.kc21c.isChecked() ? "3" : "0");
        sE.put("kc21d", bi.kc21d.isChecked() ? "4" : "0");
        sE.put("kc21e", bi.kc21e.isChecked() ? "5" : "0");
        sE.put("kc2196", bi.kc2196.isChecked() ? "96" : "0");

        sE.put("kc2196x", bi.kc2196x.getText().toString());


        sE.put("kc22", bi.kc22a.isChecked() ? "1"
                : bi.kc22b.isChecked() ? "2"
                : bi.kc22c.isChecked() ? "3"
                : bi.kc22d.isChecked() ? "4"
                : bi.kc2298.isChecked() ? "98"
                : "0");

        sE.put("kc23a", bi.kc23a.isChecked() ? "1" : "0");
        sE.put("kc23b", bi.kc23b.isChecked() ? "2" : "0");
        sE.put("kc23c", bi.kc23c.isChecked() ? "3" : "0");
        sE.put("kc23d", bi.kc23d.isChecked() ? "4" : "0");
        sE.put("kc23e", bi.kc23e.isChecked() ? "5" : "0");
        sE.put("kc23f", bi.kc23f.isChecked() ? "6" : "0");
        sE.put("kc23g", bi.kc23g.isChecked() ? "7" : "0");
        sE.put("kc2396", bi.kc2396.isChecked() ? "96" : "0");


        sE.put("kc2396x", bi.kc2396x.getText().toString());


        sE.put("kc24", bi.kc24a.isChecked() ? "1"
                : bi.kc24b.isChecked() ? "2"
                : bi.kc24c.isChecked() ? "3"
                : bi.kc24d.isChecked() ? "4"
                : bi.kc2498.isChecked() ? "98"
                : "0");


        MainApp.fc.setsc(String.valueOf(sE));

    }


    public void BtnEnd() {

        //if (formValidation()) {
        try {
            SaveDraft();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (UpdateDB()) {
            MainApp.endActivity(this, this);
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

                startActivity(new Intent(this, EndingActivity.class).putExtra("complete", true));
                //startActivity(new Intent(this, MainActivity.class));

            } else {
                Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
            }
        }
    }


    private boolean UpdateDB() {

        //Long rowId;
        DatabaseHelper db = new DatabaseHelper(this);

        int updcount = db.updateSC();

        if (updcount == 1) {
            Toast.makeText(this, "Updating Database... Successful!", Toast.LENGTH_SHORT).show();
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