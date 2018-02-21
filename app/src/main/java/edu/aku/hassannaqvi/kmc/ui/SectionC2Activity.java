package edu.aku.hassannaqvi.kmc.ui;

import android.app.Activity;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import edu.aku.hassannaqvi.kmc.R;
import edu.aku.hassannaqvi.kmc.contracts.FamilyMembersContract;
import edu.aku.hassannaqvi.kmc.core.DatabaseHelper;
import edu.aku.hassannaqvi.kmc.core.MainApp;
import edu.aku.hassannaqvi.kmc.databinding.ActivitySectionC2Binding;
import edu.aku.hassannaqvi.kmc.validation.validatorClass;

public class SectionC2Activity extends Activity {

    ActivitySectionC2Binding bi;
    FamilyMembersContract selectedChild;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_section_c2);

        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_c2);
        bi.setCallback(this);

        setupViews();
    }

    public void setupViews() {
        bi.nc204.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (bi.nc204a.isChecked()) {
                    bi.fldGrpnc205.setVisibility(View.VISIBLE);
                } else {
                    bi.fldGrpnc205.setVisibility(View.GONE);
                    bi.nc205.clearCheck();
                    bi.nc206.clearCheck();
                    bi.nc207.clearCheck();
                    bi.nc208.clearCheck();
                    bi.nc209.clearCheck();
                    bi.nc210.clearCheck();
                    bi.nc21096x.setText(null);
                    bi.nc211.clearCheck();
                }
            }
        });

        bi.nc205.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (bi.nc205a.isChecked()) {
                    bi.fldGrpnc206.setVisibility(View.VISIBLE);
                } else {
                    bi.fldGrpnc206.setVisibility(View.GONE);
                    bi.nc206.clearCheck();
                    bi.nc207.clearCheck();
                }
            }
        });

        bi.nc206.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (bi.nc206a.isChecked()) {
                    bi.fldGrpnc207.setVisibility(View.GONE);
                    bi.nc207.clearCheck();
                } else {
                    bi.fldGrpnc207.setVisibility(View.VISIBLE);
                }
            }
        });

        bi.nc209.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (bi.nc209b.isChecked()) {
                    bi.fldGrpnc210.setVisibility(View.VISIBLE);
                } else {
                    bi.fldGrpnc210.setVisibility(View.GONE);
                    bi.nc210.clearCheck();
                    bi.nc21096x.setText(null);
                }
            }
        });

        bi.nc211.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (bi.nc211a.isChecked()) {
                    bi.fldGrpnc212.setVisibility(View.VISIBLE);
                } else {
                    bi.fldGrpnc212.setVisibility(View.GONE);
                    bi.nc212a.setChecked(false);
                    bi.nc212b.setChecked(false);
                    bi.nc212c.setChecked(false);
                    bi.nc212d.setChecked(false);
                    bi.nc212e.setChecked(false);
                    bi.nc212f.setChecked(false);
                    bi.nc212g.setChecked(false);
                    bi.nc212h.setChecked(false);
                    bi.nc212i.setChecked(false);
                    bi.nc212j.setChecked(false);
                    bi.nc21299.setChecked(false);
                    bi.nc21296.setChecked(false);
                    bi.nc21296x.setText(null);
                }
            }
        });

        bi.nc21299.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {

                    bi.nc212a.setEnabled(false);
                    bi.nc212b.setEnabled(false);
                    bi.nc212c.setEnabled(false);
                    bi.nc212d.setEnabled(false);
                    bi.nc212e.setEnabled(false);
                    bi.nc212f.setEnabled(false);
                    bi.nc212g.setEnabled(false);
                    bi.nc212h.setEnabled(false);
                    bi.nc212i.setEnabled(false);
                    bi.nc212j.setEnabled(false);
                    bi.nc21296.setEnabled(false);
                    bi.nc212a.setChecked(false);
                    bi.nc212b.setChecked(false);
                    bi.nc212c.setChecked(false);
                    bi.nc212d.setChecked(false);
                    bi.nc212e.setChecked(false);
                    bi.nc212f.setChecked(false);
                    bi.nc212g.setChecked(false);
                    bi.nc212h.setChecked(false);
                    bi.nc212i.setChecked(false);
                    bi.nc212j.setChecked(false);
                    bi.nc21296.setChecked(false);
                    bi.nc21296x.setText(null);
                } else {
                    bi.nc212a.setEnabled(true);
                    bi.nc212b.setEnabled(true);
                    bi.nc212c.setEnabled(true);
                    bi.nc212d.setEnabled(true);
                    bi.nc212e.setEnabled(true);
                    bi.nc212f.setEnabled(true);
                    bi.nc212g.setEnabled(false);
                    bi.nc212h.setEnabled(false);
                    bi.nc212i.setEnabled(false);
                    bi.nc212j.setEnabled(false);
                    bi.nc21296.setEnabled(false);
                }
            }
        });

        bi.nc215b.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (bi.nc215ba.isChecked()) {
                    bi.fldGrpnc215b1.setVisibility(View.VISIBLE);
                } else {
                    bi.fldGrpnc215b1.setVisibility(View.GONE);
                    bi.nc215b1.setText(null);
                    bi.nc215b198.setChecked(false);
                }
            }
        });

        bi.nc215c.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (bi.nc215ca.isChecked()) {
                    bi.fldGrpnc215c1.setVisibility(View.VISIBLE);
                } else {
                    bi.fldGrpnc215c1.setVisibility(View.GONE);
                    bi.nc215c1.setText(null);
                    bi.nc215c198.setChecked(false);
                }
            }
        });

        bi.nc215f.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (bi.nc215fa.isChecked()) {
                    bi.fldGrpnc215f1.setVisibility(View.VISIBLE);
                } else {
                    bi.fldGrpnc215f1.setVisibility(View.GONE);
                    bi.nc215f1.setText(null);
                    bi.nc215f198.setChecked(false);
                }
            }
        });

        bi.nc216a.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (bi.nc216aa.isChecked()) {
                    bi.fldGrpnc216a1.setVisibility(View.VISIBLE);
                } else {
                    bi.fldGrpnc216a1.setVisibility(View.GONE);
                    bi.nc216a1.setText(null);
                    bi.nc216a198.setChecked(false);
                }
            }
        });

        bi.nc218.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (bi.nc218a.isChecked()) {
                    bi.fldGrpnc219.setVisibility(View.VISIBLE);
                } else {
                    bi.fldGrpnc219.setVisibility(View.GONE);
                    bi.nc219.clearCheck();
                    bi.nc220.clearCheck();
                    bi.nc22096x.setText(null);
                }
            }
        });

        //Get Intent
        selectedChild = (FamilyMembersContract) getIntent().getSerializableExtra("selectedChild");


    }

    public void BtnContinue() {

        Toast.makeText(this, "Processing This Section", Toast.LENGTH_SHORT).show();
        if (ValidateForm()) {
            try {
                SaveDraft();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (UpdateDB()) {
                Toast.makeText(this, "Starting Ending Section", Toast.LENGTH_SHORT).show();

                finish();

                startActivity(new Intent(this, SectionC3Activity.class));

            } else {
                Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void BtnEnd() {

        MainApp.endActivityMother(this, this, false);

    }

    private boolean ValidateForm() {

        Toast.makeText(this, "Validating This Section ", Toast.LENGTH_SHORT).show();

        if (!validatorClass.EmptyRadioButton(this, bi.nc204, bi.nc204a, getString(R.string.nc204))) {
            return false;
        }

        if (bi.nc204a.isChecked()) {
            if (!validatorClass.EmptyRadioButton(this, bi.nc205, bi.nc205a, getString(R.string.nc205))) {
                return false;
            }

            if (bi.nc205a.isChecked()) {
                if (!validatorClass.EmptyRadioButton(this, bi.nc206, bi.nc206a, getString(R.string.nc206))) {
                    return false;
                }

                if (bi.nc206a.isChecked()) {
                    if (!validatorClass.EmptyRadioButton(this, bi.nc207, bi.nc207a, getString(R.string.nc207))) {
                        return false;
                    }
                }
            }

            if (!validatorClass.EmptyRadioButton(this, bi.nc208, bi.nc208a, getString(R.string.nc208))) {
                return false;
            }

            if (!validatorClass.EmptyRadioButton(this, bi.nc209, bi.nc209a, getString(R.string.nc209))) {
                return false;
            }

            if (bi.nc209a.isChecked() || bi.nc20998.isChecked()) {
                if (!validatorClass.EmptyRadioButton(this, bi.nc210, bi.nc210a, getString(R.string.nc210))) {
                    return false;
                }
            }

            if (!validatorClass.EmptyRadioButton(this, bi.nc211, bi.nc211a, getString(R.string.nc211))) {
                return false;
            }

        }

        if (!bi.nc204a.isChecked() || bi.nc211a.isChecked()) {

            if (!bi.nc21299.isChecked()) {
                if (!validatorClass.EmptyCheckBox(this, bi.fldGrpnc212check, bi.nc212a, getString(R.string.nc212))) {
                    return false;
                }

                if (!validatorClass.EmptyCheckBox(this, bi.fldGrpnc212check, bi.nc21296, bi.nc21296x, getString(R.string.nb212) + " - " + getString(R.string.other))) {
                    return false;
                }
            }
        }

        if (!validatorClass.EmptyRadioButton(this, bi.nc213, bi.nc213a, getString(R.string.nc213))) {
            return false;
        }

        if (!validatorClass.EmptyRadioButton(this, bi.nc214, bi.nc214a, getString(R.string.nc214))) {
            return false;
        }

        if (!validatorClass.EmptyRadioButton(this, bi.nc215a, bi.nc215aa, getString(R.string.nc215a))) {
            return false;
        }

        if (!validatorClass.EmptyRadioButton(this, bi.nc215b, bi.nc215ba, getString(R.string.nc215b))) {
            return false;
        }

        /*if (!validatorClass.EmptyRadioButton(this, bi.nc215b, bi.nc215ba, bi.nc215b1, getString(R.string.nc215b1))) {
            return false;
        }*/

        if (bi.nc215ba.isChecked() && !bi.nc215b198.isChecked()) {

            if (!validatorClass.EmptyTextBox(this, bi.nc215b1, getString(R.string.nb215))) {
                return false;
            }
            if (!validatorClass.RangeTextBox(this, bi.nc215b1, 1, 7, getString(R.string.nb215), " times")) {
                return false;
            }
        }


        if (!validatorClass.EmptyRadioButton(this, bi.nc215c, bi.nc215ca, getString(R.string.nc215c))) {
            return false;
        }

        if (bi.nc215ca.isChecked() && !bi.nc215c198.isChecked()) {

            if (!validatorClass.EmptyTextBox(this, bi.nc215c1, getString(R.string.nb215))) {
                return false;
            }

            if (!validatorClass.RangeTextBox(this, bi.nc215c1, 1, 7, getString(R.string.nc215), " times")) {
                return false;
            }
        }

        if (!validatorClass.EmptyRadioButton(this, bi.nc215d, bi.nc215da, getString(R.string.nc215d))) {
            return false;
        }

        if (!validatorClass.EmptyRadioButton(this, bi.nc215e, bi.nc215ea, getString(R.string.nc215e))) {
            return false;
        }


        if (!validatorClass.EmptyRadioButton(this, bi.nc215f, bi.nc215fa, getString(R.string.nc215f))) {
            return false;
        }

        if (bi.nc215fa.isChecked() && !bi.nc215f198.isChecked()) {

            if (!validatorClass.EmptyTextBox(this, bi.nc215f1, getString(R.string.nb215))) {
                return false;
            }

            if (!validatorClass.RangeTextBox(this, bi.nc215f1, 1, 7, getString(R.string.nc215), " times")) {
                return false;
            }
        }


        if (!validatorClass.EmptyRadioButton(this, bi.nc215g, bi.nc215ga, getString(R.string.nc215g))) {
            return false;
        }

        if (!validatorClass.EmptyRadioButton(this, bi.nc215h, bi.nc215ha, getString(R.string.nc215h))) {
            return false;
        }

        if (!validatorClass.EmptyRadioButton(this, bi.nc215i, bi.nc215ia, getString(R.string.nc215i))) {
            return false;
        }

        if (!validatorClass.EmptyRadioButton(this, bi.nc215i, bi.nc215ia, bi.nc215i96x, getString(R.string.nc215i) + " - " + getString(R.string.other))) {
            return false;
        }

        if (!validatorClass.EmptyRadioButton(this, bi.nc216a, bi.nc216aa, getString(R.string.nc216a))) {
            return false;
        }


        if (bi.nc216aa.isChecked() && !bi.nc216a198.isChecked()) {

            if (!validatorClass.EmptyTextBox(this, bi.nc216a1, getString(R.string.nc216a1))) {
                return false;
            }

            if (!validatorClass.RangeTextBox(this, bi.nc216a1, 1, 7, getString(R.string.nc216a1), " times")) {
                return false;
            }
        }

        if (!validatorClass.EmptyRadioButton(this, bi.nc216b, bi.nc216ba, getString(R.string.nc216b))) {
            return false;
        }

        if (!validatorClass.EmptyRadioButton(this, bi.nc216c, bi.nc216ca, getString(R.string.nc216c))) {
            return false;
        }

        if (!validatorClass.EmptyRadioButton(this, bi.nc216d, bi.nc216da, getString(R.string.nc216d))) {
            return false;
        }

        if (!validatorClass.EmptyRadioButton(this, bi.nc216e, bi.nc216ea, getString(R.string.nc216e))) {
            return false;
        }

        if (!validatorClass.EmptyRadioButton(this, bi.nc216f, bi.nc216fa, getString(R.string.nc216f))) {
            return false;
        }

        if (!validatorClass.EmptyRadioButton(this, bi.nc216g, bi.nc216ga, getString(R.string.nc216g))) {
            return false;
        }

        if (!validatorClass.EmptyRadioButton(this, bi.nc216h, bi.nc216ha, getString(R.string.nc216h))) {
            return false;
        }

        if (!validatorClass.EmptyRadioButton(this, bi.nc216i, bi.nc216ia, getString(R.string.nc216i))) {
            return false;
        }

        if (!validatorClass.EmptyRadioButton(this, bi.nc216j, bi.nc216ja, getString(R.string.nc216j))) {
            return false;
        }

        if (!validatorClass.EmptyRadioButton(this, bi.nc216k, bi.nc216ka, getString(R.string.nc216k))) {
            return false;
        }

        if (!validatorClass.EmptyRadioButton(this, bi.nc216l, bi.nc216la, getString(R.string.nc216l))) {
            return false;
        }

        if (!validatorClass.EmptyRadioButton(this, bi.nc216m, bi.nc216ma, getString(R.string.nc216m))) {
            return false;
        }

        if (!validatorClass.EmptyRadioButton(this, bi.nc216n, bi.nc216na, getString(R.string.nc216n))) {
            return false;
        }

        if (!validatorClass.EmptyRadioButton(this, bi.nc216x, bi.nc216xa, bi.nc216x1, getString(R.string.nc216x))) {
            return false;
        }

        if (bi.nc216aa.isChecked()) {
            if (!bi.nc216a1.getText().toString().isEmpty() && !bi.nc217.getText().toString().isEmpty()) {
                if (Integer.valueOf(bi.nc216a1.getText().toString()) != Integer.valueOf(bi.nc217.getText().toString())) {
                    Toast.makeText(this, "Both values should be same.. Check again ", Toast.LENGTH_SHORT).show();
                    bi.nc217.setError("Number of times recored for Yogurt in A1 is " + bi.nc216a1.getText().toString() + "Check again plz");    // Set Error on last radio button
                    bi.nc217.requestFocus();
                    Log.i(SectionC2Activity.class.getSimpleName(), "nc217: Both values should be same");

                } else {
                    bi.nc217.setError(null);
                }
            }
        } else if (bi.nc216ab.isChecked()) {
            if (!bi.nc217.getText().toString().isEmpty()) {
                if (Integer.valueOf(bi.nc217.getText().toString()) > 0) {
                    Toast.makeText(this, "Value should be zero", Toast.LENGTH_SHORT).show();
                    bi.nc217.setError("Number of times recored for Yogurt in Q16 A1 is 0 Check again plz");    // Set Error on last radio button
                    bi.nc217.requestFocus();
                    Log.i(SectionC2Activity.class.getSimpleName(), "nc217: Both values should be same");

                } else {
                    bi.nc217.setError(null);
                }
            }
        } else if (bi.nc216a98.isChecked() && !bi.nc21798.isChecked()) {
            Toast.makeText(this, "Check Again", Toast.LENGTH_SHORT).show();
            bi.nc21798.setError("Check Again.. Dont know is recored for yougurt in Q16 A");    // Set Error on last radio button
            bi.nc21798.requestFocus();
            Log.i(SectionC2Activity.class.getSimpleName(), "nc217:Check Again");

        } else {
            bi.nc21798.setError(null);
        }

        if (!validatorClass.EmptyRadioButton(this, bi.nc218, bi.nc218a, getString(R.string.nc218))) {
            return false;
        }

        if (bi.nc218a.isChecked()) {
            if (!validatorClass.EmptyRadioButton(this, bi.nc219, bi.nc219a, getString(R.string.nc219))) {
                return false;
            }

            if (!validatorClass.EmptyRadioButton(this, bi.nc220, bi.nc220a, bi.nc22096x, getString(R.string.nc220))) {
                return false;
            }
        }

        if (!validatorClass.EmptyRadioButton(this, bi.nc221, bi.nc221a, getString(R.string.nc221))) {
            return false;
        }

        if (bi.nc221a.isChecked()) {
            if (!validatorClass.EmptyTextBox(this, bi.nc222, getString(R.string.nc222))) {
                return false;
            }
        }

        if (!validatorClass.EmptyRadioButton(this, bi.nc223, bi.nc223a, getString(R.string.nc223))) {
            return false;
        }

        if (bi.nc223a.isChecked()) {
            if (!validatorClass.EmptyTextBox(this, bi.nc224, getString(R.string.nc224))) {
                return false;
            }
        }

        if (!validatorClass.EmptyRadioButton(this, bi.nc225, bi.nc225a, getString(R.string.nc225))) {
            return false;
        }

        if (bi.nc225a.isChecked()) {
            if (!validatorClass.EmptyTextBox(this, bi.nc226, getString(R.string.nc226))) {
                return false;
            }
        }


        return true;
    }


    private void SaveDraft() throws JSONException {
        Toast.makeText(this, "Saving Draft for  This Section", Toast.LENGTH_SHORT).show();

        JSONObject sC2 = new JSONObject();

//        nc201
        sC2.put("nc201", selectedChild.getName());
//        nc202
        sC2.put("nc202Serial", selectedChild.getSerialNo());
//        nc203
        if (selectedChild.getDob().equals("")) {
            sC2.put("nc203", selectedChild.getAge());
        } else {
            sC2.put("nc203", selectedChild.getDob());
        }

//        nc204
        sC2.put("nc204", bi.nc204a.isChecked() ? "1"
                : bi.nc204b.isChecked() ? "2"
                : bi.nc20498.isChecked() ? "98"
                : "0");

//      nc205
        sC2.put("nc205", bi.nc205a.isChecked() ? "1"
                : bi.nc205b.isChecked() ? "2"
                : bi.nc20598.isChecked() ? "98"
                : "0");

//      nc206
        sC2.put("nc206", bi.nc206a.isChecked() ? "1"
                : bi.nc206b.isChecked() ? "2"
                : bi.nc20698.isChecked() ? "98"
                : "0");


//      nc207
        sC2.put("nc207", bi.nc207a.isChecked() ? "1"
                : bi.nc207b.isChecked() ? "2"
                : bi.nc20798.isChecked() ? "98"
                : "0");

//      nc208
        sC2.put("nc208", bi.nc208a.isChecked() ? "1"
                : bi.nc208b.isChecked() ? "2"
                : bi.nc208c.isChecked() ? "3"
                : bi.nc208d.isChecked() ? "4"
                : bi.nc208e.isChecked() ? "5"
                : "0");

//      nc209
        sC2.put("nc209", bi.nc209a.isChecked() ? "1"
                : bi.nc209b.isChecked() ? "2"
                : bi.nc20998.isChecked() ? "98"
                : "0");

//      nc210
        sC2.put("nc210", bi.nc210a.isChecked() ? "1"
                : bi.nc210b.isChecked() ? "2"
                : bi.nc210c.isChecked() ? "3"
                : bi.nc21096.isChecked() ? "96"
                : "0");

//      nc211
        sC2.put("nc211", bi.nc211a.isChecked() ? "1"
                : bi.nc211b.isChecked() ? "2"
                : "0");

//      nc212
        sC2.put("nc212a", bi.nc212a.isChecked() ? "1" : "0");
        sC2.put("nc212b", bi.nc212b.isChecked() ? "2" : "0");
        sC2.put("nc212c", bi.nc212c.isChecked() ? "3" : "0");
        sC2.put("nc212d", bi.nc212d.isChecked() ? "4" : "0");
        sC2.put("nc212e", bi.nc212e.isChecked() ? "5" : "0");
        sC2.put("nc212f", bi.nc212f.isChecked() ? "6" : "0");
        sC2.put("nc212g", bi.nc212g.isChecked() ? "7" : "0");
        sC2.put("nc212h", bi.nc212h.isChecked() ? "8" : "0");
        sC2.put("nc212i", bi.nc212i.isChecked() ? "9" : "0");
        sC2.put("nc212j", bi.nc212j.isChecked() ? "10" : "0");
        sC2.put("nc21296", bi.nc21296.isChecked() ? "96" : "0");
        sC2.put("nc21299", bi.nc21299.isChecked() ? "99" : "0");


        sC2.put("nc21296x", bi.nc21296x.getText().toString());


//      nc213
        sC2.put("nc213", bi.nc213a.isChecked() ? "1"
                : bi.nc213b.isChecked() ? "2"
                : bi.nc21398.isChecked() ? "98"
                : "0");


//      nc214
        sC2.put("nc214", bi.nc214a.isChecked() ? "1"
                : bi.nc214b.isChecked() ? "2"
                : bi.nc21498.isChecked() ? "98"
                : "0");

//      nc215a
        sC2.put("nc215a", bi.nc215aa.isChecked() ? "1"
                : bi.nc215ab.isChecked() ? "2"
                : bi.nc215a98.isChecked() ? "98"
                : "0");

//      nc215b
        sC2.put("nc215b", bi.nc215ba.isChecked() ? "1"
                : bi.nc215bb.isChecked() ? "2"
                : bi.nc215b98.isChecked() ? "98"
                : "0");
//        nc215b1
        sC2.put("nc215b1", bi.nc215b1.getText().toString());

//        nc215b198

        sC2.put("nc215b198", bi.nc215b198.isChecked() ? "1" : "0");

//      nc215c
        sC2.put("nc215c", bi.nc215ca.isChecked() ? "1"
                : bi.nc215cb.isChecked() ? "2"
                : bi.nc215c98.isChecked() ? "98"
                : "0");

//        nc215c1
        sC2.put("nc215c1", bi.nc215c1.getText().toString());

//        nc215c198
        sC2.put("nc215c198", bi.nc215c198.isChecked() ? "1" : "0");


//      nc215d
        sC2.put("nc215d", bi.nc215da.isChecked() ? "1"
                : bi.nc215db.isChecked() ? "2"
                : bi.nc215d98.isChecked() ? "98"
                : "0");

//      nc215e
        sC2.put("nc215e", bi.nc215ea.isChecked() ? "1"
                : bi.nc215eb.isChecked() ? "2"
                : bi.nc215e98.isChecked() ? "98"
                : "0");

        //      nc215f
        sC2.put("nc215f", bi.nc215fa.isChecked() ? "1"
                : bi.nc215fb.isChecked() ? "2"
                : bi.nc215f98.isChecked() ? "98"
                : "0");
//        nc215f1
        sC2.put("nc215f1", bi.nc215f1.getText().toString());

//        nc215f198

        sC2.put("nc215f198", bi.nc215f198.isChecked() ? "1" : "0");


//      nc215g
        sC2.put("nc215g", bi.nc215ga.isChecked() ? "1"
                : bi.nc215gb.isChecked() ? "2"
                : bi.nc215g98.isChecked() ? "98"
                : "0");

//      nc215h
        sC2.put("nc215h", bi.nc215ha.isChecked() ? "1"
                : bi.nc215hb.isChecked() ? "2"
                : bi.nc215h98.isChecked() ? "98"
                : "0");

        //      nc215i
        sC2.put("nc215i", bi.nc215ia.isChecked() ? "1"
                : bi.nc215ib.isChecked() ? "2"
                : bi.nc215i98.isChecked() ? "98"
                : "0");

        sC2.put("nc215i96x", bi.nc215i96x.getText().toString());


//        nc216a
        sC2.put("nc216a", bi.nc216aa.isChecked() ? "1"
                : bi.nc216ab.isChecked() ? "2"
                : bi.nc216a98.isChecked() ? "98"
                : "0");
//        nc216a1
        sC2.put("nc216a1", bi.nc216a1.getText().toString());

//        nc216a198

        sC2.put("nc216a198", bi.nc216a198.isChecked() ? "1" : "0");


//        nc216b
        sC2.put("nc216b", bi.nc216ba.isChecked() ? "1"
                : bi.nc216bb.isChecked() ? "2"
                : bi.nc216b98.isChecked() ? "98"
                : "0");

//        nc216c
        sC2.put("nc216c", bi.nc216ca.isChecked() ? "1"
                : bi.nc216cb.isChecked() ? "2"
                : bi.nc216c98.isChecked() ? "98"
                : "0");

//        nc216d
        sC2.put("nc216d", bi.nc216da.isChecked() ? "1"
                : bi.nc216db.isChecked() ? "2"
                : bi.nc216d98.isChecked() ? "98"
                : "0");

//        nc216e
        sC2.put("nc216e", bi.nc216ea.isChecked() ? "1"
                : bi.nc216eb.isChecked() ? "2"
                : bi.nc216e98.isChecked() ? "98"
                : "0");

//        nc216f
        sC2.put("nc216f", bi.nc216fa.isChecked() ? "1"
                : bi.nc216fb.isChecked() ? "2"
                : bi.nc216f98.isChecked() ? "98"
                : "0");

//        nc216g
        sC2.put("nc216g", bi.nc216ga.isChecked() ? "1"
                : bi.nc216gb.isChecked() ? "2"
                : bi.nc216g98.isChecked() ? "98"
                : "0");

//        nc216h
        sC2.put("nc216h", bi.nc216ha.isChecked() ? "1"
                : bi.nc216hb.isChecked() ? "2"
                : bi.nc216h98.isChecked() ? "98"
                : "0");

//        nc216g
        sC2.put("nc216g", bi.nc216ga.isChecked() ? "1"
                : bi.nc216gb.isChecked() ? "2"
                : bi.nc216g98.isChecked() ? "98"
                : "0");

//        nc216h
        sC2.put("nc216h", bi.nc216ha.isChecked() ? "1"
                : bi.nc216hb.isChecked() ? "2"
                : bi.nc216h98.isChecked() ? "98"
                : "0");

//        nc216i
        sC2.put("nc216i", bi.nc216ia.isChecked() ? "1"
                : bi.nc216ib.isChecked() ? "2"
                : bi.nc216i98.isChecked() ? "98"
                : "0");

//        nc216j
        sC2.put("nc216j", bi.nc216ja.isChecked() ? "1"
                : bi.nc216jb.isChecked() ? "2"
                : bi.nc216j98.isChecked() ? "98"
                : "0");

//        nc216k
        sC2.put("nc216k", bi.nc216ka.isChecked() ? "1"
                : bi.nc216kb.isChecked() ? "2"
                : bi.nc216k98.isChecked() ? "98"
                : "0");

//        nc216l
        sC2.put("nc216l", bi.nc216la.isChecked() ? "1"
                : bi.nc216lb.isChecked() ? "2"
                : bi.nc216l98.isChecked() ? "98"
                : "0");

//        nc216m
        sC2.put("nc216m", bi.nc216ma.isChecked() ? "1"
                : bi.nc216mb.isChecked() ? "2"
                : bi.nc216m98.isChecked() ? "98"
                : "0");

//        nc216n
        sC2.put("nc216n", bi.nc216na.isChecked() ? "1"
                : bi.nc216nb.isChecked() ? "2"
                : bi.nc216n98.isChecked() ? "98"
                : "0");

//        nc216x
        sC2.put("nc216x", bi.nc216xa.isChecked() ? "1"
                : bi.nc216xb.isChecked() ? "2"
                : bi.nc216x98.isChecked() ? "98"
                : "0");
//        nc216x1
        sC2.put("nc216x1", bi.nc216x1.getText().toString());


//      nc217
        sC2.put("nc217", bi.nc217.getText().toString());
        sC2.put("nc21798", bi.nc21798.isChecked() ? "1" : "0");

//      nc218
        sC2.put("nc218", bi.nc218a.isChecked() ? "1"
                : bi.nc218b.isChecked() ? "2"
                : bi.nc21898.isChecked() ? "98"
                : "0");
//      nc219
        sC2.put("nc219", bi.nc219a.isChecked() ? "1"
                : bi.nc219b.isChecked() ? "2"
                : bi.nc219c.isChecked() ? "3"
                : bi.nc21996.isChecked() ? "96"
                : "0");
        sC2.put("nc21996x", bi.nc21996x.getText().toString());


//      nc220
        sC2.put("nc220", bi.nc220a.isChecked() ? "1"
                : bi.nc220b.isChecked() ? "2"
                : bi.nc220c.isChecked() ? "3"
                : bi.nc22096.isChecked() ? "96"
                : "0");
        sC2.put("nc22096x", bi.nc22096x.getText().toString());


//      nc221
        sC2.put("nc221", bi.nc221a.isChecked() ? "1"
                : bi.nc221b.isChecked() ? "2"
                : bi.nc22198.isChecked() ? "98"
                : "0");

//    nc222

        sC2.put("nc222", bi.nc222.getText().toString());

//      nc223
        sC2.put("nc223", bi.nc223a.isChecked() ? "1"
                : bi.nc223b.isChecked() ? "2"
                : bi.nc22398.isChecked() ? "98"
                : "0");

//    nc224

        sC2.put("nc224", bi.nc224.getText().toString());

//      nc225
        sC2.put("nc225", bi.nc225a.isChecked() ? "1"
                : bi.nc225b.isChecked() ? "2"
                : "0");


//    nc226

        sC2.put("nc226", bi.nc226.getText().toString());

        MainApp.cc.setsC2(String.valueOf(sC2));


        Toast.makeText(this, "Validation Successful! - Saving Draft...", Toast.LENGTH_SHORT).show();
    }

    private boolean UpdateDB() {

        //Long rowId;
        DatabaseHelper db = new DatabaseHelper(this);

        int updcount = db.updateSC2();

        if (updcount == 1) {
            Toast.makeText(this, "Updating Database... Successful!", Toast.LENGTH_SHORT).show();
            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }

    }

}
