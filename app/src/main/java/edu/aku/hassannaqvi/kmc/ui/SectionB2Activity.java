package edu.aku.hassannaqvi.kmc.ui;

import android.app.Activity;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import edu.aku.hassannaqvi.kmc.R;
import edu.aku.hassannaqvi.kmc.core.DatabaseHelper;
import edu.aku.hassannaqvi.kmc.core.MainApp;
import edu.aku.hassannaqvi.kmc.databinding.ActivitySectionB2Binding;
import edu.aku.hassannaqvi.kmc.validation.validatorClass;

public class SectionB2Activity extends Activity {

    ActivitySectionB2Binding bi;
    DatabaseHelper db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_section_b2);

        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_b2);
        db = new DatabaseHelper(this);
        bi.setCallback(this);

        setupViews();
    }

    public void setupViews() {
        bi.nb201.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (bi.nb201a.isChecked()) {
                    bi.fldGrpnb202.setVisibility(View.VISIBLE);
                } else {
                    bi.fldGrpnb202.setVisibility(View.GONE);
                    bi.nb202a.setChecked(false);
                    bi.nb202b.setChecked(false);
                    bi.nb202c.setChecked(false);
                    bi.nb202d.setChecked(false);
                    bi.nb202e.setChecked(false);
                    bi.nb202f.setChecked(false);
                    bi.nb202g.setChecked(false);
                    bi.nb202h.setChecked(false);
                    bi.nb20296.setChecked(false);
                    bi.nb20296x.setText(null);
                    bi.nb203m.setText(null);
                    bi.nb203w.setText(null);
                    bi.nb20398.setChecked(false);
                    bi.nb204.setText(null);
                    bi.nb20498.setChecked(false);
                    bi.nb205a.setChecked(false);
                    bi.nb205b.setChecked(false);
                    bi.nb205c.setChecked(false);
                    bi.nb205d.setChecked(false);
                    bi.nb205e.setChecked(false);
                    bi.nb205f.setChecked(false);
                    bi.nb205g.setChecked(false);
                    bi.nb205h.setChecked(false);
                    bi.nb20596.setChecked(false);
                    bi.nb20596x.setText(null);
                }
            }
        });

        bi.nb207.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (bi.nb207a.isChecked()) {
                    bi.fldGrpnb208.setVisibility(View.VISIBLE);
                } else {
                    bi.fldGrpnb208.setVisibility(View.GONE);
                    bi.nb208.setText(null);
                    bi.nb20898.setChecked(false);
                }
            }
        });

        bi.nb209.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (bi.nb209a.isChecked()) {
                    bi.fldGrpnb210.setVisibility(View.VISIBLE);
                } else {
                    bi.fldGrpnb210.setVisibility(View.GONE);
//                    bi.nb21001.clearCheck();
//                    bi.nb21002.clearCheck();
//                    bi.nb21003.clearCheck();
//                    bi.nb21098.clearCheck();
//                    bi.nb21099.clearCheck();
                    bi.nb211.clearCheck();
                    bi.nb212m.setText(null);
                    bi.nb212d.setText(null);
                }
            }
        });

//        bi.nb21098.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(RadioGroup group, int checkedId) {
//                if (bi.nb21098a.isChecked()) {
//                    bi.nb21001.setEnabled(false);
//                    bi.nb21001.clearCheck();
//                    bi.nb21002.setEnabled(false);
//                    bi.nb21002.clearCheck();
//                    bi.nb21003.setEnabled(false);
//                    bi.nb21003.clearCheck();
//                    bi.nb21099.setEnabled(false);
//                    bi.nb21099.clearCheck();
//                } else {
//                    bi.nb21001.setEnabled(true);
//                    bi.nb21002.setEnabled(true);
//                    bi.nb21003.setEnabled(true);
//                    bi.nb21099.setEnabled(true);
//
//                }
//            }
//        });
//
//        bi.nb21099.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(RadioGroup group, int checkedId) {
//                if (bi.nb21099a.isChecked()) {
//                    bi.nb21001.setEnabled(false);
//                    bi.nb21001.clearCheck();
//                    bi.nb21002.setEnabled(false);
//                    bi.nb21002.clearCheck();
//                    bi.nb21003.setEnabled(false);
//                    bi.nb21003.clearCheck();
//                    bi.nb21098.setEnabled(false);
//                    bi.nb21098.clearCheck();
//                } else {
//                    bi.nb21001.setEnabled(true);
//                    bi.nb21002.setEnabled(true);
//                    bi.nb21003.setEnabled(true);
//                    bi.nb21098.setEnabled(true);
//
//                }
//            }
//        });

        bi.nb213.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (bi.nb213a.isChecked()) {
                    bi.fldGrpnb214.setVisibility(View.VISIBLE);
                } else {
                    bi.fldGrpnb214.setVisibility(View.GONE);
                    bi.nb214.clearCheck();
                    bi.nb215m.setText(null);
                    bi.nb215d.setText(null);
                }
            }
        });

        bi.nb216.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (bi.nb216a.isChecked()) {
                    bi.fldGrpnb217.setVisibility(View.VISIBLE);
                } else {
                    bi.fldGrpnb217.setVisibility(View.GONE);
                    bi.nb217.clearCheck();
                    bi.nb218d.setText(null);
                    bi.nb218m.setText(null);
                }
            }
        });


    }

    public void BtnContinue() {

        Toast.makeText(this, "Processing This Section", Toast.LENGTH_SHORT).show();
        /*if (ValidateForm()) {
            try {
                SaveDraft();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (UpdateDB()) {
                Toast.makeText(this, "Starting Ending Section", Toast.LENGTH_SHORT).show();

                finish();

                startActivity(new Intent(this, ChildAssessmentActivity.class));

            } else {
                Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
            }
        }*/

        startActivity(new Intent(this, SectionB3Activity.class));
    }

    public void BtnEnd() {
        MainApp.endActivity(this, this);

    }

    private boolean ValidateForm() {

        Toast.makeText(this, "Validating This Section ", Toast.LENGTH_SHORT).show();

        if (!validatorClass.EmptyRadioButton(this, bi.nb201, bi.nb201a, getString(R.string.nb201))) {
            return false;
        }

        if (bi.nb201a.isChecked()) {
            if (!validatorClass.EmptyCheckBox(this, bi.fldGrpnb202check, bi.nb202a, getString(R.string.nb202))) {
                return false;
            }

            if (!validatorClass.EmptyCheckBox(this, bi.fldGrpnb202check, bi.nb20296, bi.nb20296x, getString(R.string.nb202) + " - " + getString(R.string.other))) {
                return false;
            }

            if (!bi.nb20398.isChecked()) {
                if (!validatorClass.EmptyTextBox(this, bi.nb203w, getString(R.string.nb203) + " - " + getString(R.string.week))) {
                    return false;
                }

                if (!validatorClass.EmptyTextBox(this, bi.nb203m, getString(R.string.nb203) + " - " + getString(R.string.months))) {
                    return false;
                }

                if (bi.nb203w.getText().toString().equals("0") && bi.nb203m.getText().toString().equals("0")) {
                    Toast.makeText(this, "ERROR(invalid): " + "All can not be zero" + getString(R.string.nb203), Toast.LENGTH_LONG).show();
                    bi.nb203w.setError("All can not be zero");
                    bi.nb203w.setError("All can not be zero");
                    Log.i(SectionB2Activity.class.getSimpleName(), "nb203" + ": This data is Required!");
                } else {
                    bi.nb203w.setError(null);
                    bi.nb203m.setError(null);

                }

            }

            if (!bi.nb20498.isChecked()) {
                if (!validatorClass.EmptyTextBox(this, bi.nb204, getString(R.string.nb204) + " - " + getString(R.string.times))) {
                    return false;
                }
            }

            if (!validatorClass.EmptyCheckBox(this, bi.fldGrpnb205check, bi.nb205a, getString(R.string.nb205))) {
                return false;
            }

            if (!validatorClass.EmptyCheckBox(this, bi.fldGrpnb205check, bi.nb20596, bi.nb20596x, getString(R.string.nb205) + " - " + getString(R.string.other))) {
                return false;
            }

        }


        if (!validatorClass.EmptyRadioButton(this, bi.nb206, bi.nb206a, getString(R.string.nb206))) {
            return false;
        }

        if (!validatorClass.EmptyRadioButton(this, bi.nb207, bi.nb207a, getString(R.string.nb207))) {
            return false;
        }

        if (bi.nb207a.isChecked()) {
            if (!bi.nb20898.isChecked()) {
                if (!validatorClass.EmptyTextBox(this, bi.nb208, getString(R.string.nb208) + " - " + getString(R.string.times))) {
                    return false;
                }
            }
        }

        if (!validatorClass.EmptyRadioButton(this, bi.nb209, bi.nb209a, getString(R.string.nb209))) {
            return false;
        }

        if (bi.nb209a.isChecked()) {

//            if (!bi.nb21098a.isChecked() || !bi.nb21099a.isChecked()) {
//                if (!validatorClass.EmptyRadioButton(this, bi.nb21001, bi.nb21001a, getString(R.string.nb21001))) {
//                    return false;
//                }
//
//                if (!validatorClass.EmptyRadioButton(this, bi.nb21002, bi.nb21002a, getString(R.string.nb21002))) {
//                    return false;
//                }
//
//                if (!validatorClass.EmptyRadioButton(this, bi.nb21003, bi.nb21003a, getString(R.string.nb21003))) {
//                    return false;
//                }
//            }

            if (!validatorClass.EmptyRadioButton(this, bi.nw310, bi.nw310a, getString(R.string.nw310))) {
                return false;
            }
            if (!validatorClass.EmptyRadioButton(this, bi.nw310, bi.nw310a, bi.nw31096x, getString(R.string.nw310))) {
                return false;
            }
            if (!validatorClass.EmptyRadioButton(this, bi.nw315, bi.nw315a, getString(R.string.nw315))) {
                return false;
            }
            if (!validatorClass.EmptyRadioButton(this, bi.nw315, bi.nw315a, bi.nw31596x, getString(R.string.nw315))) {
                return false;
            }
            if (!validatorClass.EmptyRadioButton(this, bi.nw320, bi.nw320a, getString(R.string.nw320))) {
                return false;
            }
            if (!validatorClass.EmptyRadioButton(this, bi.nw320, bi.nw320a, bi.nw32096x, getString(R.string.nw320))) {
                return false;
            }


            if (!validatorClass.EmptyRadioButton(this, bi.nb211, bi.nb211a, getString(R.string.nb211))) {
                return false;
            }

            if (!validatorClass.EmptyTextBox(this, bi.nb212m, getString(R.string.nb212) + " - " + getString(R.string.month))) {
                return false;
            }

            if (!validatorClass.EmptyTextBox(this, bi.nb212d, getString(R.string.nb212) + " - " + getString(R.string.day))) {
                return false;
            }

            if (!validatorClass.RangeTextBox(this, bi.nb212m, 0, 11, getString(R.string.nb212), " months")) {
                return false;
            }

            if (!validatorClass.RangeTextBox(this, bi.nb212d, 0, 29, getString(R.string.nb212), " days")) {
                return false;
            }

            if (bi.nb212m.getText().toString().equals("0") && bi.nb212d.getText().toString().equals("0")) {
                Toast.makeText(this, "ERROR(invalid): " + "All can not be zero" + getString(R.string.nb212), Toast.LENGTH_LONG).show();
                bi.nb212m.setError("All can not be zero");
                bi.nb212d.setError("All can not be zero");
                Log.i(SectionB2Activity.class.getSimpleName(), "nb212" + ": This data is Required!");
            } else {
                bi.nb212m.setError(null);
                bi.nb212d.setError(null);

            }

        }


        if (!validatorClass.EmptyRadioButton(this, bi.nb213, bi.nb213a, getString(R.string.nb213))) {
            return false;
        }

        if (bi.nb213a.isChecked()) {


            if (!validatorClass.EmptyRadioButton(this, bi.nb214, bi.nb214a, getString(R.string.nb214))) {
                return false;
            }

            if (!validatorClass.EmptyTextBox(this, bi.nb215m, getString(R.string.nb215) + " - " + getString(R.string.month))) {
                return false;
            }

            if (!validatorClass.EmptyTextBox(this, bi.nb215d, getString(R.string.nb215) + " - " + getString(R.string.day))) {
                return false;
            }

            if (!validatorClass.RangeTextBox(this, bi.nb215m, 0, 11, getString(R.string.nb215), " months")) {
                return false;
            }

            if (!validatorClass.RangeTextBox(this, bi.nb215d, 0, 29, getString(R.string.nb215), " days")) {
                return false;
            }

            if (bi.nb215m.getText().toString().equals("0") && bi.nb215d.getText().toString().equals("0")) {
                Toast.makeText(this, "ERROR(invalid): " + "All can not be zero" + getString(R.string.nb215), Toast.LENGTH_LONG).show();
                bi.nb215m.setError("All can not be zero");
                bi.nb215d.setError("All can not be zero");
                Log.i(SectionB2Activity.class.getSimpleName(), "nb215" + ": This data is Required!");
            } else {
                bi.nb215m.setError(null);
                bi.nb215d.setError(null);

            }

        }


        if (!validatorClass.EmptyRadioButton(this, bi.nb216, bi.nb216a, getString(R.string.nb216))) {
            return false;
        }

        if (bi.nb216a.isChecked()) {


            if (!validatorClass.EmptyRadioButton(this, bi.nb217, bi.nb217a, getString(R.string.nb217))) {
                return false;
            }

            if (!validatorClass.EmptyTextBox(this, bi.nb218m, getString(R.string.nb218) + " - " + getString(R.string.month))) {
                return false;
            }

            if (!validatorClass.EmptyTextBox(this, bi.nb218d, getString(R.string.nb218) + " - " + getString(R.string.day))) {
                return false;
            }

            if (!validatorClass.RangeTextBox(this, bi.nb218m, 0, 11, getString(R.string.nb218), " months")) {
                return false;
            }

            if (!validatorClass.RangeTextBox(this, bi.nb218d, 0, 29, getString(R.string.nb218), " days")) {
                return false;
            }

            if (bi.nb218m.getText().toString().equals("0") && bi.nb218d.getText().toString().equals("0")) {
                Toast.makeText(this, "ERROR(invalid): " + "All can not be zero" + getString(R.string.nb218), Toast.LENGTH_LONG).show();
                bi.nb218m.setError("All can not be zero");
                bi.nb218d.setError("All can not be zero");
                Log.i(SectionB2Activity.class.getSimpleName(), "nb218" + ": This data is Required!");
            } else {
                bi.nb218m.setError(null);
                bi.nb218d.setError(null);

            }

        }

        if (!validatorClass.EmptyRadioButton(this, bi.nb219, bi.nb219a, getString(R.string.nb219))) {
            return false;
        }

        return validatorClass.EmptyRadioButton(this, bi.nb220, bi.nb220a, getString(R.string.nb220));
    }


    private void SaveDraft() throws JSONException {
        Toast.makeText(this, "Saving Draft for  This Section", Toast.LENGTH_SHORT).show();
//       nb201
        JSONObject sB2 = new JSONObject();
        sB2.put("nw301", bi.nb201a.isChecked() ? "1"
                : bi.nb201b.isChecked() ? "2"
                : "0");

//       nb202
        sB2.put("nw302a", bi.nb202a.isChecked() ? "1" : "0");
        sB2.put("nw302b", bi.nb202b.isChecked() ? "2" : "0");
        sB2.put("nw302c", bi.nb202c.isChecked() ? "3" : "0");
        sB2.put("nw302d", bi.nb202d.isChecked() ? "4" : "0");
        sB2.put("nw302e", bi.nb202e.isChecked() ? "5" : "0");
        sB2.put("nw302f", bi.nb202f.isChecked() ? "6" : "0");
        sB2.put("nw302g", bi.nb202g.isChecked() ? "7" : "0");
        sB2.put("nw302h", bi.nb202h.isChecked() ? "8" : "0");
        sB2.put("nw30296", bi.nb20296.isChecked() ? "96" : "0");
        sB2.put("nw30296x", bi.nb20296x.getText().toString());


//        nb203
        sB2.put("nw303", bi.nb203w.getText().toString());
        sB2.put("nw303", bi.nb203w.getText().toString());
        sB2.put("nw30398", bi.nb20398.isChecked() ? "98" : "0");


        //        nw204
        sB2.put("nw304", bi.nb204.getText().toString());
        sB2.put("nw30498", bi.nb20498.isChecked() ? "98" : "0");

//      nb205
        sB2.put("nw305a", bi.nb205a.isChecked() ? "1" : "0");
        sB2.put("nw305b", bi.nb205b.isChecked() ? "2" : "0");
        sB2.put("nw305c", bi.nb205c.isChecked() ? "3" : "0");
        sB2.put("nw305d", bi.nb205d.isChecked() ? "4" : "0");
        sB2.put("nw305e", bi.nb205e.isChecked() ? "5" : "0");
        sB2.put("nw305f", bi.nb205f.isChecked() ? "6" : "0");
        sB2.put("nw305g", bi.nb205g.isChecked() ? "7" : "0");
        sB2.put("nw305h", bi.nb205h.isChecked() ? "8" : "0");
        sB2.put("nw30596", bi.nb20596.isChecked() ? "96" : "0");
        sB2.put("nw30596x", bi.nb20596x.getText().toString());

//        nb206
        sB2.put("nw306", bi.nb206a.isChecked() ? "1"
                : bi.nb206b.isChecked() ? "2"
                : bi.nb206c.isChecked() ? "3"
                : bi.nb20698.isChecked() ? "98"
                : "0");
//        nb207
        sB2.put("nw307", bi.nb207a.isChecked() ? "1"
                : bi.nb207b.isChecked() ? "2"
                : bi.nb20798.isChecked() ? "98"
                : "0");
//        nb208

        sB2.put("nw308", bi.nb208.getText().toString());
        sB2.put("nw30898", bi.nb20898.isChecked() ? "98" : "0");

//        nb209
        sB2.put("nw309", bi.nb209a.isChecked() ? "1"
                : bi.nb209b.isChecked() ? "2"
                : "0");

//          nw310
        sB2.put("nw310", bi.nw310a.isChecked() ? "1"
                : bi.nw310b.isChecked() ? "2"
                : bi.nw310c.isChecked() ? "3"
                : bi.nw310d.isChecked() ? "4"
                : bi.nw310e.isChecked() ? "5"
                : bi.nw310f.isChecked() ? "6"
                : bi.nw310g.isChecked() ? "7"
                : bi.nw310h.isChecked() ? "8"
                : bi.nw31096.isChecked() ? "96"
                : "0");
        sB2.put("nw31096x", bi.nw31096x.getText().toString());
//        nw311
        sB2.put("nw311", bi.nw311a.isChecked() ? "1"
                : bi.nw311b.isChecked() ? "2"
                : bi.nw311c.isChecked() ? "3"
                : bi.nw311d.isChecked() ? "4"
                : bi.nw311e.isChecked() ? "5"
                : bi.nw311f.isChecked() ? "6"
                : bi.nw311g.isChecked() ? "7"
                : bi.nw311h.isChecked() ? "8"
                : bi.nw311i.isChecked() ? "9"
                : bi.nw311j.isChecked() ? "10"
                : bi.nw311k.isChecked() ? "11"
                : bi.nw311l.isChecked() ? "12"
                : bi.nw311m.isChecked() ? "13"
                : bi.nw311961.isChecked() ? "961"
                : bi.nw311962.isChecked() ? "962"
                : bi.nw311963.isChecked() ? "963"
                : "0");
        sB2.put("nw311961x", bi.nw311961x.getText().toString());
        sB2.put("nw311962x", bi.nw311962x.getText().toString());
        sB2.put("nw311963x", bi.nw311963x.getText().toString());

//         nw312
        sB2.put("nw312", bi.nb211a.isChecked() ? "1"
                : bi.nb211b.isChecked() ? "2"
                : bi.nb211c.isChecked() ? "3"
                : bi.nb211d.isChecked() ? "4"
                : bi.nb211e.isChecked() ? "5"
                : "0");

//        nw313
        sB2.put("nw313m", bi.nb212m.getText().toString());
        sB2.put("nw313d", bi.nb212d.getText().toString());

        //        nw314
        sB2.put("nw314", bi.nb213a.isChecked() ? "1"
                : bi.nb213b.isChecked() ? "2"
                : "0");

//        nw315

        sB2.put("nw315", bi.nw315a.isChecked() ? "1"
                : bi.nw315b.isChecked() ? "2"
                : bi.nw315c.isChecked() ? "3"
                : bi.nw315d.isChecked() ? "4"
                : bi.nw315e.isChecked() ? "5"
                : bi.nw315f.isChecked() ? "6"
                : bi.nw315g.isChecked() ? "7"
                : bi.nw315h.isChecked() ? "8"
                : bi.nw31596.isChecked() ? "96"
                : "0");
        sB2.put("nw31596x", bi.nw31596x.getText().toString());

//        nw316
        sB2.put("nw316", bi.nw316a.isChecked() ? "1"
                : bi.nw316b.isChecked() ? "2"
                : bi.nw316c.isChecked() ? "3"
                : bi.nw316d.isChecked() ? "4"
                : bi.nw316e.isChecked() ? "5"
                : bi.nw316f.isChecked() ? "6"
                : bi.nw316g.isChecked() ? "7"
                : bi.nw316h.isChecked() ? "8"
                : bi.nw316i.isChecked() ? "9"
                : bi.nw316j.isChecked() ? "10"
                : bi.nw316k.isChecked() ? "11"
                : bi.nw316l.isChecked() ? "12"
                : bi.nw316m.isChecked() ? "13"
                : bi.nw316961.isChecked() ? "961"
                : bi.nw316962.isChecked() ? "962"
                : bi.nw316963.isChecked() ? "963"
                : "0");
        sB2.put("nw316961x", bi.nw316961x.getText().toString());
        sB2.put("nw316962x", bi.nw316962x.getText().toString());
        sB2.put("nw316963x", bi.nw316963x.getText().toString());


//        nw317
        sB2.put("nw317", bi.nb214a.isChecked() ? "1"
                : bi.nb214b.isChecked() ? "2"
                : bi.nb214b.isChecked() ? "3"
                : bi.nb214b.isChecked() ? "4"
                : bi.nb214b.isChecked() ? "5"
                : "0");

//        nw318
        sB2.put("nw318m", bi.nb215m.getText().toString());
        sB2.put("nw318d", bi.nb215d.getText().toString());

//        nw319
        sB2.put("nw319", bi.nb216a.isChecked() ? "1"
                : bi.nb216b.isChecked() ? "2"
                : "0");


//        nw320

        sB2.put("nw320", bi.nw320a.isChecked() ? "1"
                : bi.nw320b.isChecked() ? "2"
                : bi.nw320c.isChecked() ? "3"
                : bi.nw320d.isChecked() ? "4"
                : bi.nw320e.isChecked() ? "5"
                : bi.nw320f.isChecked() ? "6"
                : bi.nw320g.isChecked() ? "7"
                : bi.nw320h.isChecked() ? "8"
                : bi.nw32096.isChecked() ? "96"
                : "0");
        sB2.put("nwnw32096x", bi.nw32096x.getText().toString());

//        nw321
        sB2.put("nw321", bi.nw321a.isChecked() ? "1"
                : bi.nw321b.isChecked() ? "2"
                : bi.nw321c.isChecked() ? "3"
                : bi.nw321d.isChecked() ? "4"
                : bi.nw321e.isChecked() ? "5"
                : bi.nw321f.isChecked() ? "6"
                : bi.nw321g.isChecked() ? "7"
                : bi.nw321h.isChecked() ? "8"
                : bi.nw321i.isChecked() ? "9"
                : bi.nw321j.isChecked() ? "10"
                : bi.nw321k.isChecked() ? "11"
                : bi.nw321l.isChecked() ? "12"
                : bi.nw321m.isChecked() ? "13"
                : bi.nw321961.isChecked() ? "961"
                : bi.nw321962.isChecked() ? "962"
                : bi.nw321963.isChecked() ? "963"
                : "0");
        sB2.put("nw321961x", bi.nw321961x.getText().toString());
        sB2.put("nw321962x", bi.nw321962x.getText().toString());
        sB2.put("nw321963x", bi.nw321963x.getText().toString());


//        nw322
        sB2.put("nw322", bi.nb217a.isChecked() ? "1"
                : bi.nb217b.isChecked() ? "2"
                : bi.nb217c.isChecked() ? "3"
                : bi.nb217d.isChecked() ? "4"
                : bi.nb217e.isChecked() ? "5"
                : "0");

//        nw323
        sB2.put("nw323m", bi.nb218m.getText().toString());
        sB2.put("nw323d", bi.nb218d.getText().toString());

//        nw324
        sB2.put("nw324", bi.nb219a.isChecked() ? "1"
                : bi.nb219b.isChecked() ? "2"
                : "0");
//        nw325
        sB2.put("nw325", bi.nb220a.isChecked() ? "1"
                : bi.nb220b.isChecked() ? "2"
                : bi.nb22098.isChecked() ? "98"
                : "0");

        MainApp.mc.setsB2(String.valueOf(sB2));


        Toast.makeText(this, "Validation Successful! - Saving Draft...", Toast.LENGTH_SHORT).show();

    }

    private boolean UpdateDB() {

        //Long rowId;
        DatabaseHelper db = new DatabaseHelper(this);

        int updcount = db.updateSB2();

        if (updcount == 1) {
            Toast.makeText(this, "Updating Database... Successful!", Toast.LENGTH_SHORT).show();
            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }

        //return true;

    }

}
