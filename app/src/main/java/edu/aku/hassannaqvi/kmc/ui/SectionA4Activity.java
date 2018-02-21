package edu.aku.hassannaqvi.kmc.ui;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioGroup;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import edu.aku.hassannaqvi.kmc.R;
import edu.aku.hassannaqvi.kmc.core.DatabaseHelper;
import edu.aku.hassannaqvi.kmc.core.MainApp;
import edu.aku.hassannaqvi.kmc.databinding.ActivitySectionA4Binding;
import edu.aku.hassannaqvi.kmc.validation.validatorClass;

public class SectionA4Activity extends AppCompatActivity {

    ActivitySectionA4Binding binding;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_section_a4);
        db = new DatabaseHelper(this);

//        Assigning data to UI binding
        binding.setCallback(this);

//        Skip Pattern

//        na403
        binding.na403.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == R.id.na403b) {
                    binding.na404.clearCheck();
                    binding.na40496x.setText(null);
                }
            }
        });

//        na405
        binding.na405.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == R.id.na405i) {
                    binding.na406.clearCheck();
                    binding.na407.setText(null);
                }
            }
        });

//        na418
        binding.na418.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == R.id.na418b) {
                    binding.na419.clearCheck();
                }
            }
        });


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

                startActivity(new Intent(this, SectionA5Activity.class));

            } else {
                Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
            }
        }

        //startActivity(new Intent(this, SectionA5Activity.class));
    }

    public void BtnEnd() {
        MainApp.endActivity(this, this);

    }

    private boolean formValidation() {
        Toast.makeText(this, "Validating This Section ", Toast.LENGTH_SHORT).show();
        if (!validatorClass.EmptyRadioButton(this, binding.na401, binding.na40196, binding.na40196x, getString(R.string.na401))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, binding.na402, binding.na40296, binding.na40296x, getString(R.string.na402))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, binding.na403, binding.na403b, getString(R.string.na403))) {
            return false;
        }
        if (binding.na403a.isChecked()) {
            if (!validatorClass.EmptyRadioButton(this, binding.na404, binding.na40496, binding.na40496x, getString(R.string.na404))) {
                return false;
            }
        }

        if (!validatorClass.EmptyRadioButton(this, binding.na405, binding.na40596, binding.na40596x, getString(R.string.na405))) {
            return false;
        }

        if (!validatorClass.EmptyRadioButton(this, binding.na406, binding.na406b, getString(R.string.na406))) {
            return false;
        }

        if (binding.na406a.isChecked()) {
            if (!validatorClass.EmptyTextBox(this, binding.na407, getString(R.string.na407))) {
                return false;
            }
        }

        if (!validatorClass.EmptyRadioButton(this, binding.na408, binding.na40896, binding.na40896x, getString(R.string.na408))) {
            return false;
        }

        if (!validatorClass.EmptyRadioButton(this, binding.na40901, binding.na40901b, getString(R.string.na40901))) {
            return false;
        }

        if (!validatorClass.EmptyRadioButton(this, binding.na40902, binding.na40902b, getString(R.string.na40902))) {
            return false;
        }

        if (!validatorClass.EmptyRadioButton(this, binding.na40903, binding.na40903b, getString(R.string.na40903))) {
            return false;
        }

        if (!validatorClass.EmptyRadioButton(this, binding.na40904, binding.na40904b, getString(R.string.na40904))) {
            return false;
        }

        if (!validatorClass.EmptyRadioButton(this, binding.na40905, binding.na40905b, getString(R.string.na40905))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, binding.na40906, binding.na40906b, getString(R.string.na40906))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, binding.na40907, binding.na40907b, getString(R.string.na40907))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, binding.na40908, binding.na40908b, getString(R.string.na40908))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, binding.na40909, binding.na40909b, getString(R.string.na40909))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, binding.na40910, binding.na40910b, getString(R.string.na40910))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, binding.na40911, binding.na40911b, getString(R.string.na40911))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, binding.na40912, binding.na40912b, getString(R.string.na40912))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, binding.na40913, binding.na40913b, getString(R.string.na40913))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, binding.na40914, binding.na40914b, getString(R.string.na40914))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, binding.na40915, binding.na40915b, getString(R.string.na40915))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, binding.na40916, binding.na40916b, getString(R.string.na40916))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, binding.na40917, binding.na40917b, getString(R.string.na40917))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, binding.na40918, binding.na40918b, getString(R.string.na40918))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, binding.na40919, binding.na40919b, getString(R.string.na40919))) {
            return false;
        }

//        if (!validatorClass.EmptyTextBox(this, binding.deletea, getString(R.string.deletea))) {
//            return false;
//        }
//
//        if (!validatorClass.EmptyTextBox(this, binding.deleteb, getString(R.string.deleteb))) {
//            return false;
//        }
//
//        if (!validatorClass.EmptyTextBox(this, binding.deletec, getString(R.string.deletec))) {
//            return false;
//        }
//
//        if (!validatorClass.EmptyTextBox(this, binding.deleted, getString(R.string.deleted))) {
//            return false;
//        }
//
//        if (!validatorClass.EmptyTextBox(this, binding.deletee, getString(R.string.deletee))) {
//            return false;
//        }
//
//        if (!validatorClass.EmptyTextBox(this, binding.deletef, getString(R.string.deletef))) {
//            return false;
//        }
//
//        if (!validatorClass.EmptyTextBox(this, binding.deleteg, getString(R.string.deleteg))) {
//            return false;
//        }
//
//        if (!validatorClass.EmptyTextBox(this, binding.deleteh, getString(R.string.deleteh))) {
//            return false;
//        }
//
//        if (!validatorClass.EmptyTextBox(this, binding.deletei, getString(R.string.deletei))) {
//            return false;
//        }
//
//        if (!validatorClass.EmptyTextBox(this, binding.deletej, getString(R.string.deletej))) {
//            return false;
//        }
//
//        if (!validatorClass.EmptyTextBox(this, binding.deletek, getString(R.string.deletek))) {
//            return false;
//        }
//
//        if (!validatorClass.EmptyTextBox(this, binding.deletel, getString(R.string.deletel))) {
//            return false;
//        }
//
//        if (!validatorClass.EmptyTextBox(this, binding.deletem, getString(R.string.deletem))) {
//            return false;
//        }
//
//        if (!validatorClass.EmptyTextBox(this, binding.deleten, getString(R.string.deleten))) {
//            return false;
//        }
//
//        if (!validatorClass.EmptyTextBox(this, binding.deleteo, getString(R.string.deleteo))) {
//            return false;
//        }
//
//        if (!validatorClass.EmptyTextBox(this, binding.deletep, getString(R.string.deletep))) {
//            return false;
//        }

        if (!validatorClass.EmptyCheckBox(this, binding.fldGrpna0411check, binding.na41096, binding.na41096x, getString(R.string.na410))) {
            return false;
        }

        if (!validatorClass.EmptyRadioButton(this, binding.na411, binding.na41196, binding.na41196x, getString(R.string.na411))) {
            return false;
        }

        if (!validatorClass.EmptyRadioButton(this, binding.na412, binding.na41296, binding.na41296x, getString(R.string.na412))) {
            return false;
        }

        if (!validatorClass.EmptyRadioButton(this, binding.na413, binding.na41396, binding.na41396x, getString(R.string.na413))) {
            return false;
        }

        if (!validatorClass.EmptyRadioButton(this, binding.na414, binding.na41496, binding.na41496x, getString(R.string.na414))) {
            return false;
        }
        if (!validatorClass.EmptyRadioButton(this, binding.na415, binding.na41596, binding.na41596x, getString(R.string.na415))) {
            return false;
        }
        if (!validatorClass.RangeTextBox(this, binding.na416, 1, 15, getString(R.string.na416), "Room")) {
            return false;
        }
        if (!validatorClass.EmptyCheckBox(this, binding.fldGrpna0418check, binding.na417i, getString(R.string.na417))) {
            return false;
        }

        if (!validatorClass.EmptyRadioButton(this, binding.na418, binding.na418b, getString(R.string.na418))) {
            return false;
        }
        if (binding.na418a.isChecked()) {
            if (binding.na419a.isChecked()) {
                if (!validatorClass.EmptyRadioButton(this, binding.na419, binding.na419a, binding.na419acr, getString(R.string.na419))) {
                    return false;
                }
            } else if (binding.na419b.isChecked()) {
                if (!validatorClass.EmptyRadioButton(this, binding.na419, binding.na419a, binding.na419can, getString(R.string.na419))) {
                    return false;
                }
            } else if (binding.na41998.isChecked()) {
                if (!validatorClass.EmptyRadioButton(this, binding.na419, binding.na419a, getString(R.string.na419))) {
                    return false;
                }
            }
        }

        if (!validatorClass.EmptyRadioButton(this, binding.na420, binding.na420b, getString(R.string.na420))) {
            return false;
        }
        if (binding.na420a.isChecked()) {
            if (!validatorClass.RangeTextBox(this, binding.na421a, 0, 999, getString(R.string.na421a), "Animal")) {
                return false;
            }
            if (!validatorClass.RangeTextBox(this, binding.na421b, 0, 999, getString(R.string.na421b), "Animal")) {
                return false;
            }
            if (!validatorClass.RangeTextBox(this, binding.na421c, 0, 999, getString(R.string.na421c), "Animal")) {
                return false;
            }
            if (!validatorClass.RangeTextBox(this, binding.na421d, 0, 999, getString(R.string.na421d), "Animal")) {
                return false;
            }
            if (!validatorClass.RangeTextBox(this, binding.na421e, 0, 999, getString(R.string.na421e), "Animal")) {
                return false;
            }
            if (!validatorClass.RangeTextBox(this, binding.na421f, 0, 999, getString(R.string.na421f), "Animal")) {
                return false;
            }
            if (!validatorClass.RangeTextBox(this, binding.na421g, 0, 999, getString(R.string.na421g), "Animal")) {
                return false;
            }
        }
        return true;

    }

    private void SaveDraft() throws JSONException {
        Toast.makeText(this, "Saving Draft for  This Section", Toast.LENGTH_SHORT).show();

        JSONObject sA4 = new JSONObject();
        sA4.put("nh301", binding.na401a.isChecked() ? "1"
                : binding.na401b.isChecked() ? "2"
                : binding.na401c.isChecked() ? "3"
                : binding.na401d.isChecked() ? "4"
                : binding.na401e.isChecked() ? "5"
                : binding.na401f.isChecked() ? "6"
                : binding.na40196.isChecked() ? "96"
                : "0");
        sA4.put("nh30196x", binding.na40196x.getText().toString());


        sA4.put("nh302", binding.na402a.isChecked() ? "1"
                : binding.na402b.isChecked() ? "2"
                : binding.na402c.isChecked() ? "3"
                : binding.na402d.isChecked() ? "4"
                : binding.na402e.isChecked() ? "5"
                : binding.na402f.isChecked() ? "6"
                : binding.na402g.isChecked() ? "7"
                : binding.na402h.isChecked() ? "8"
                : binding.na402i.isChecked() ? "9"
                : binding.na402j.isChecked() ? "10"
                : binding.na402k.isChecked() ? "11"
                : binding.na402l.isChecked() ? "12"
                : binding.na402m.isChecked() ? "13"
                : binding.na402n.isChecked() ? "14"
                : binding.na402o.isChecked() ? "15"
                : binding.na40296.isChecked() ? "96"
                : "0");
        sA4.put("nh30296x", binding.na40296x.getText().toString());

        sA4.put("nh303", binding.na403a.isChecked() ? "1"
                : binding.na403b.isChecked() ? "2"
                : "0");

        sA4.put("nh304", binding.na404a.isChecked() ? "1"
                : binding.na404b.isChecked() ? "2"
                : binding.na404c.isChecked() ? "3"
                : binding.na404d.isChecked() ? "4"
                : binding.na404e.isChecked() ? "5"
                : binding.na404f.isChecked() ? "6"
                : binding.na40496.isChecked() ? "96"
                : "0");
        sA4.put("nh30496x", binding.na40496x.getText().toString());

        sA4.put("nh305", binding.na405a.isChecked() ? "1"
                : binding.na405b.isChecked() ? "2"
                : binding.na405c.isChecked() ? "3"
                : binding.na405d.isChecked() ? "4"
                : binding.na405e.isChecked() ? "5"
                : binding.na405f.isChecked() ? "6"
                : binding.na405g.isChecked() ? "7"
                : binding.na405h.isChecked() ? "8"
                : binding.na405i.isChecked() ? "9"
                : binding.na40596.isChecked() ? "96"
                : "0");
        sA4.put("nh30596x", binding.na40596x.getText().toString());

        sA4.put("nh306", binding.na406a.isChecked() ? "1"
                : binding.na406b.isChecked() ? "2"
                : "0");

        sA4.put("nh307", binding.na407.getText().toString());

        sA4.put("nh308", binding.na408a.isChecked() ? "1"
                : binding.na408b.isChecked() ? "2"
                : binding.na408c.isChecked() ? "3"
                : binding.na408d.isChecked() ? "4"
                : binding.na408e.isChecked() ? "5"
                : binding.na408f.isChecked() ? "6"
                : binding.na40896.isChecked() ? "96"
                : "0");
        sA4.put("nh30896x", binding.na40896x.getText().toString());

        sA4.put("nh30901", binding.na40901a.isChecked() ? "1"
                : binding.na40901b.isChecked() ? "2"
                : "0");

        sA4.put("nh30902", binding.na40902a.isChecked() ? "1"
                : binding.na40902b.isChecked() ? "2"
                : "0");

        sA4.put("nh30903", binding.na40903a.isChecked() ? "1"
                : binding.na40903b.isChecked() ? "2"
                : "0");

        sA4.put("nh30904", binding.na40904a.isChecked() ? "1"
                : binding.na40904b.isChecked() ? "2"
                : "0");

        sA4.put("nh30905", binding.na40905a.isChecked() ? "1"
                : binding.na40905b.isChecked() ? "2"
                : "0");
        sA4.put("nh30906", binding.na40906a.isChecked() ? "1"
                : binding.na40906b.isChecked() ? "2"
                : "0");
        sA4.put("nh30907", binding.na40907a.isChecked() ? "1"
                : binding.na40907b.isChecked() ? "2"
                : "0");
        sA4.put("nh30908", binding.na40908a.isChecked() ? "1"
                : binding.na40908b.isChecked() ? "2"
                : "0");
        sA4.put("nh30909", binding.na40909a.isChecked() ? "1"
                : binding.na40909b.isChecked() ? "2"
                : "0");
        sA4.put("nh30910", binding.na40910a.isChecked() ? "1"
                : binding.na40910b.isChecked() ? "2"
                : "0");
        sA4.put("nh30911", binding.na40911a.isChecked() ? "1"
                : binding.na40911b.isChecked() ? "2"
                : "0");
        sA4.put("nh30912", binding.na40912a.isChecked() ? "1"
                : binding.na40912b.isChecked() ? "2"
                : "0");
        sA4.put("nh30913", binding.na40913a.isChecked() ? "1"
                : binding.na40913b.isChecked() ? "2"
                : "0");
        sA4.put("nh30914", binding.na40914a.isChecked() ? "1"
                : binding.na40914b.isChecked() ? "2"
                : "0");
        sA4.put("nh30915", binding.na40915a.isChecked() ? "1"
                : binding.na40915b.isChecked() ? "2"
                : "0");
        sA4.put("nh30916", binding.na40916a.isChecked() ? "1"
                : binding.na40916b.isChecked() ? "2"
                : "0");
        sA4.put("nh30917", binding.na40917a.isChecked() ? "1"
                : binding.na40917b.isChecked() ? "2"
                : "0");
        sA4.put("nh30918", binding.na40918a.isChecked() ? "1"
                : binding.na40918b.isChecked() ? "2"
                : "0");
        sA4.put("nh30919", binding.na40919a.isChecked() ? "1"
                : binding.na40919b.isChecked() ? "2"
                : "0");

////        410
//
//        sA4.put("deletea", binding.deletea.getText().toString());
//        sA4.put("deleteb", binding.deleteb.getText().toString());
//        sA4.put("deletec", binding.deletec.getText().toString());
//        sA4.put("deleted", binding.deleted.getText().toString());
//        sA4.put("deletee", binding.deletee.getText().toString());
//        sA4.put("deletef", binding.deletef.getText().toString());
//        sA4.put("deleteg", binding.deleteg.getText().toString());
//        sA4.put("deleteh", binding.deleteh.getText().toString());
//        sA4.put("deletei", binding.deletei.getText().toString());
//        sA4.put("deletej", binding.deletej.getText().toString());
//        sA4.put("deletek", binding.deletek.getText().toString());
//        sA4.put("deletel", binding.deletel.getText().toString());
//        sA4.put("deletem", binding.deletem.getText().toString());
//        sA4.put("deleten", binding.deleten.getText().toString());
//        sA4.put("deleteo", binding.deleteo.getText().toString());
//        sA4.put("deletep", binding.deletep.getText().toString());

//        411
        sA4.put("nh310a", binding.na410a.isChecked() ? "1" : "0");
        sA4.put("nh310b", binding.na410b.isChecked() ? "2" : "0");
        sA4.put("nh310c", binding.na410c.isChecked() ? "3" : "0");
        sA4.put("nh310d", binding.na410d.isChecked() ? "4" : "0");
        sA4.put("nh310e", binding.na410e.isChecked() ? "5" : "0");
        sA4.put("nh310f", binding.na410f.isChecked() ? "6" : "0");
        sA4.put("nh31096", binding.na41096.isChecked() ? "96" : "0");

        sA4.put("nh31096x", binding.na41096x.getText().toString());

//        412
        sA4.put("nh311", binding.na411a.isChecked() ? "1"
                : binding.na411b.isChecked() ? "2"
                : binding.na411c.isChecked() ? "3"
                : binding.na411d.isChecked() ? "4"
                : binding.na411e.isChecked() ? "5"
                : binding.na411f.isChecked() ? "6"
                : binding.na411g.isChecked() ? "7"
                : binding.na411h.isChecked() ? "8"
                : binding.na411i.isChecked() ? "9"
                : binding.na411j.isChecked() ? "10"
                : binding.na41196.isChecked() ? "96"
                : "0");
        sA4.put("nh31196x", binding.na41196x.getText().toString());
//       413
        sA4.put("nh312", binding.na412a.isChecked() ? "1"
                : binding.na412b.isChecked() ? "2"
                : binding.na412c.isChecked() ? "3"
                : binding.na41196.isChecked() ? "96"
                : "0");
        sA4.put("nh31296x", binding.na41296x.getText().toString());

//        414
        sA4.put("nh313", binding.na413a.isChecked() ? "1"
                : binding.na413b.isChecked() ? "2"
                : binding.na413c.isChecked() ? "3"
                : binding.na413d.isChecked() ? "4"
                : binding.na413e.isChecked() ? "5"
                : binding.na413f.isChecked() ? "6"
                : binding.na413g.isChecked() ? "7"
                : binding.na413h.isChecked() ? "8"
                : binding.na413i.isChecked() ? "9"
                : binding.na413j.isChecked() ? "10"
                : binding.na413j.isChecked() ? "10"
                : binding.na41396.isChecked() ? "96"
                : "0");
        sA4.put("nh31396x", binding.na41396x.getText().toString());

//        415

        sA4.put("nh314", binding.na414a.isChecked() ? "1"
                : binding.na414b.isChecked() ? "2"
                : binding.na414c.isChecked() ? "3"
                : binding.na414d.isChecked() ? "4"
                : binding.na414e.isChecked() ? "5"
                : binding.na414f.isChecked() ? "6"
                : binding.na414g.isChecked() ? "7"
                : binding.na414h.isChecked() ? "8"
                : binding.na414i.isChecked() ? "9"
                : binding.na414j.isChecked() ? "10"
                : binding.na414k.isChecked() ? "11"
                : binding.na414l.isChecked() ? "12"
                : binding.na414m.isChecked() ? "13"
                : binding.na41496.isChecked() ? "96"
                : "0");
        sA4.put("nh31496x", binding.na41496x.getText().toString());

//          416
        sA4.put("nh315", binding.na415a.isChecked() ? "1"
                : binding.na415b.isChecked() ? "2"
                : binding.na415c.isChecked() ? "3"
                : binding.na415d.isChecked() ? "4"
                : binding.na415e.isChecked() ? "5"
                : binding.na415f.isChecked() ? "6"
                : binding.na415g.isChecked() ? "7"
                : binding.na415h.isChecked() ? "8"
                : binding.na415i.isChecked() ? "9"
                : binding.na415j.isChecked() ? "10"
                : binding.na415k.isChecked() ? "11"
                : binding.na41596.isChecked() ? "96"
                : "0");
        sA4.put("nh31596x", binding.na41596x.getText().toString());

//        417
        sA4.put("nh316", binding.na416.getText().toString());

//        418
        sA4.put("nh317a", binding.na417a.isChecked() ? "1" : "0");
        sA4.put("nh317b", binding.na417b.isChecked() ? "2" : "0");
        sA4.put("nh317c", binding.na417c.isChecked() ? "3" : "0");
        sA4.put("nh317d", binding.na417d.isChecked() ? "4" : "0");
        sA4.put("nh317e", binding.na417e.isChecked() ? "5" : "0");
        sA4.put("nh317f", binding.na417f.isChecked() ? "6" : "0");
        sA4.put("nh317g", binding.na417g.isChecked() ? "7" : "0");
        sA4.put("nh317h", binding.na417h.isChecked() ? "8" : "0");
        sA4.put("nh317i", binding.na417i.isChecked() ? "9" : "0");

//        419
        sA4.put("nh318", binding.na418a.isChecked() ? "1"
                : binding.na418b.isChecked() ? "2"
                : "0");

//        420
        sA4.put("nh319", binding.na419a.isChecked() ? "1"
                : binding.na419b.isChecked() ? "2"
                : binding.na41998.isChecked() ? "3"
                : "0");
        sA4.put("nh319acr", binding.na419acr.getText().toString());
        sA4.put("nh319can", binding.na419can.getText().toString());

//        421
        sA4.put("nh320", binding.na420a.isChecked() ? "1"
                : binding.na420b.isChecked() ? "2"
                : "0");
//        422
        sA4.put("nh321a", binding.na421a.getText().toString());
        sA4.put("nh321b", binding.na421b.getText().toString());
        sA4.put("nh321c", binding.na421c.getText().toString());
        sA4.put("nh321d", binding.na421d.getText().toString());
        sA4.put("nh321e", binding.na421e.getText().toString());
        sA4.put("nh321f", binding.na421f.getText().toString());
        sA4.put("nh321g", binding.na421g.getText().toString());


        MainApp.fc.setsA4(String.valueOf(sA4));


        Toast.makeText(this, "Validation Successful! - Saving Draft...", Toast.LENGTH_SHORT).show();

    }

    private boolean UpdateDB() {

        //Long rowId;
        DatabaseHelper db = new DatabaseHelper(this);

        int updcount = db.updateSA4();

        if (updcount == 1) {
            Toast.makeText(this, "Updating Database... Successful!", Toast.LENGTH_SHORT).show();
            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }
    }

}
