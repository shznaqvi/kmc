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
import edu.aku.hassannaqvi.kmc.databinding.ActivitySectionB5Binding;
import edu.aku.hassannaqvi.kmc.validation.validatorClass;

public class SectionB5Activity extends AppCompatActivity {

    ActivitySectionB5Binding binding;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_section_b5);
        db = new DatabaseHelper(this);

//        Assigning data to UI binding
        binding.setCallback(this);

//        Skip patterns

        binding.nb501.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == R.id.nb501b) {
                    binding.nb502a.setChecked(false);
                    binding.nb502b.setChecked(false);
                    binding.nb502c.setChecked(false);
                    binding.nb502d.setChecked(false);
                    binding.nb502e.setChecked(false);
                    binding.nb502f.setChecked(false);
                    binding.nb502g.setChecked(false);
                    binding.nb50296.setChecked(false);

                    binding.nb503.clearCheck();
                    binding.nb504.setText(null);

                    binding.nb505a.setChecked(false);
                    binding.nb505b.setChecked(false);
                    binding.nb505c.setChecked(false);
                    binding.nb505d.setChecked(false);
                    binding.nb505e.setChecked(false);
                    binding.nb505f.setChecked(false);
                    binding.nb505g.setChecked(false);
                    binding.nb505h.setChecked(false);
                    binding.nb50596.setChecked(false);

                }
            }
        });

        binding.nb506.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == R.id.nb506b) {
                    binding.nb507a.setChecked(false);
                    binding.nb507b.setChecked(false);
                    binding.nb507c.setChecked(false);
                    binding.nb507d.setChecked(false);
                    binding.nb507e.setChecked(false);
                    binding.nb507f.setChecked(false);
                    binding.nb507g.setChecked(false);
                    binding.nb50796.setChecked(false);

                    binding.nb508.clearCheck();
                    binding.nb509.setText(null);

                    binding.nb510a.setChecked(false);
                    binding.nb510b.setChecked(false);
                    binding.nb510c.setChecked(false);
                    binding.nb510d.setChecked(false);
                    binding.nb510e.setChecked(false);
                    binding.nb51096.setChecked(false);
                }
            }
        });


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

                startActivity(new Intent(this, SectionB6Activity.class));

            } else {
                Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
            }
        }

        //startActivity(new Intent(this, SectionB6Activity.class));
    }

    public void BtnEnd() {
        MainApp.endActivity(this, this);
    }


    private boolean ValidateForm() {

        Toast.makeText(this, "Validating This Section ", Toast.LENGTH_SHORT).show();

        if (!validatorClass.EmptyRadioButton(this, binding.nb501, binding.nb501a, getString(R.string.nb501))) {
            return false;
        }

        if (binding.nb501a.isChecked()) {
            if (!validatorClass.EmptyCheckBox(this, binding.fldGrpnb502check, binding.nb502a, getString(R.string.nb502))) {
                return false;
            }

            if (!validatorClass.EmptyCheckBox(this, binding.fldGrpnb502check, binding.nb50296, binding.nb50296x, getString(R.string.nb502) + " - " + getString(R.string.other))) {
                return false;
            }

            if (!validatorClass.EmptyRadioButton(this, binding.nb503, binding.nb503a, getString(R.string.nb503))) {
                return false;
            }

            if (binding.nb503a.isChecked()) {

                if (!validatorClass.EmptyTextBox(this, binding.nb503hr, getString(R.string.nb503a))) {
                    return false;
                }

                if (!validatorClass.RangeTextBox(this, binding.nb503hr, 1, 23, getString(R.string.nb503a), " hours")) {
                    return false;
                }


            }


            if (binding.nb503b.isChecked()) {

                if (!validatorClass.EmptyTextBox(this, binding.nb503d, getString(R.string.nb503b))) {
                    return false;
                }

                if (!validatorClass.RangeTextBox(this, binding.nb503d, 1, 29, getString(R.string.nb503b), " days")) {
                    return false;
                }

            }

            if (binding.nb503c.isChecked()) {

                if (!validatorClass.EmptyTextBox(this, binding.nb503w, getString(R.string.nb503c))) {
                    return false;
                }

                if (!validatorClass.RangeTextBox(this, binding.nb503w, 1, 29, getString(R.string.nb503c), " weeks")) {
                    return false;
                }

            }


            if (!validatorClass.EmptyTextBox(this, binding.nb504, getString(R.string.nb504))) {
                return false;
            }

            if (!validatorClass.RangeTextBox(this, binding.nb504, 1, 12, getString(R.string.nb504), " times")) {
                return false;
            }

            if (!validatorClass.EmptyCheckBox(this, binding.fldGrpnb505check, binding.nb505a, getString(R.string.nb505))) {
                return false;
            }

            if (!validatorClass.EmptyCheckBox(this, binding.fldGrpnb505check, binding.nb50596, binding.nb50596x, getString(R.string.nb505) + " - " + getString(R.string.other))) {
                return false;
            }

        }


        if (!validatorClass.EmptyRadioButton(this, binding.nb506, binding.nb506a, getString(R.string.nb506))) {
            return false;
        }


        if (binding.nb506a.isChecked()) {

            if (!validatorClass.EmptyCheckBox(this, binding.fldGrpnb507check, binding.nb507a, getString(R.string.nb507))) {
                return false;
            }

            if (!validatorClass.EmptyCheckBox(this, binding.fldGrpnb507check, binding.nb50796, binding.nb50796x, getString(R.string.nb505) + " - " + getString(R.string.other))) {
                return false;
            }

            if (!validatorClass.EmptyRadioButton(this, binding.nb508, binding.nb508a, getString(R.string.nb508))) {
                return false;
            }

            if (binding.nb508a.isChecked()) {

                if (!validatorClass.EmptyTextBox(this, binding.nb508hr, getString(R.string.nb508a))) {
                    return false;
                }

                if (!validatorClass.RangeTextBox(this, binding.nb508hr, 1, 23, getString(R.string.nb508a), " hours")) {
                    return false;
                }


            }


            if (binding.nb508b.isChecked()) {

                if (!validatorClass.EmptyTextBox(this, binding.nb508d, getString(R.string.nb508b))) {
                    return false;
                }

                if (!validatorClass.RangeTextBox(this, binding.nb508d, 1, 29, getString(R.string.nb508b), " days")) {
                    return false;
                }

            }

            if (binding.nb508c.isChecked()) {

                if (!validatorClass.EmptyTextBox(this, binding.nb508w, getString(R.string.nb508c))) {
                    return false;
                }

                if (!validatorClass.RangeTextBox(this, binding.nb508w, 1, 29, getString(R.string.nb508c), " weeks")) {
                    return false;
                }

            }


            if (!validatorClass.EmptyTextBox(this, binding.nb509, getString(R.string.nb509))) {
                return false;
            }

            if (!validatorClass.RangeTextBox(this, binding.nb509, 1, 12, getString(R.string.nb509), " times")) {
                return false;
            }

            if (!validatorClass.EmptyCheckBox(this, binding.fldGrpnb510check, binding.nb510a, getString(R.string.nb510))) {
                return false;
            }

            if (!validatorClass.EmptyCheckBox(this, binding.fldGrpnb510check, binding.nb51096, binding.nb51096x, getString(R.string.nb510) + " - " + getString(R.string.other))) {
                return false;
            }


        }

        return true;
    }

    private void SaveDraft() throws JSONException {
        Toast.makeText(this, "Saving Draft for  This Section", Toast.LENGTH_SHORT).show();

        JSONObject sB5 = new JSONObject();
        //       nb501
//        nb501
        sB5.put("nb501", binding.nb501a.isChecked() ? "1"
                : binding.nb501b.isChecked() ? "2"
                : "0");
//      nb502
        sB5.put("nb502a", binding.nb502a.isChecked() ? "1" : "0");
        sB5.put("nb502b", binding.nb502b.isChecked() ? "2" : "0");
        sB5.put("nb502c", binding.nb502c.isChecked() ? "3" : "0");
        sB5.put("nb502d", binding.nb502d.isChecked() ? "4" : "0");
        sB5.put("nb502e", binding.nb502e.isChecked() ? "5" : "0");
        sB5.put("nb502f", binding.nb502f.isChecked() ? "6" : "0");
        sB5.put("nb502g", binding.nb502g.isChecked() ? "7" : "0");
        sB5.put("nb50296", binding.nb50296.isChecked() ? "96" : "0");
        sB5.put("nb50296x", binding.nb50296x.getText().toString());

//      nb503
        sB5.put("nb503", binding.nb503a.isChecked() ? "1"
                : binding.nb503b.isChecked() ? "2"
                : binding.nb503c.isChecked() ? "3"
                : binding.nb50398.isChecked() ? "98"
                : "0");
        sB5.put("nb503hr", binding.nb503hr.getText().toString());
        sB5.put("nb503d", binding.nb503d.getText().toString());
        sB5.put("nb503w", binding.nb503w.getText().toString());

//        nb504
        sB5.put("nb504", binding.nb504.getText().toString());

//        nb505
        sB5.put("nb505a", binding.nb505a.isChecked() ? "1" : "0");
        sB5.put("nb505b", binding.nb505b.isChecked() ? "2" : "0");
        sB5.put("nb505c", binding.nb505c.isChecked() ? "3" : "0");
        sB5.put("nb505d", binding.nb505d.isChecked() ? "4" : "0");
        sB5.put("nb505e", binding.nb505e.isChecked() ? "5" : "0");
        sB5.put("nb505f", binding.nb505f.isChecked() ? "6" : "0");
        sB5.put("nb505g", binding.nb505g.isChecked() ? "7" : "0");
        sB5.put("nb505h", binding.nb505h.isChecked() ? "8" : "0");
        sB5.put("nb50596", binding.nb50596.isChecked() ? "96" : "0");
        sB5.put("nb50596x", binding.nb50596x.getText().toString());

//        nb506
        sB5.put("nb506", binding.nb506a.isChecked() ? "1"
                : binding.nb506b.isChecked() ? "2"
                : "0");
//        nb507
        sB5.put("nb507a", binding.nb507a.isChecked() ? "1" : "0");
        sB5.put("nb507b", binding.nb507b.isChecked() ? "2" : "0");
        sB5.put("nb507c", binding.nb507c.isChecked() ? "3" : "0");
        sB5.put("nb507d", binding.nb507d.isChecked() ? "4" : "0");
        sB5.put("nb507e", binding.nb507e.isChecked() ? "5" : "0");
        sB5.put("nb507f", binding.nb507f.isChecked() ? "6" : "0");
        sB5.put("nb507g", binding.nb507g.isChecked() ? "7" : "0");
        sB5.put("nb50796", binding.nb50796.isChecked() ? "96" : "0");
        sB5.put("nb50796x", binding.nb50796x.getText().toString());


//        nb508
        sB5.put("nb508", binding.nb508a.isChecked() ? "1"
                : binding.nb508b.isChecked() ? "2"
                : binding.nb508c.isChecked() ? "3"
                : binding.nb50898.isChecked() ? "98"
                : "0");
        sB5.put("nb508hr", binding.nb508hr.getText().toString());
        sB5.put("nb508d", binding.nb508d.getText().toString());
        sB5.put("nb508w", binding.nb508w.getText().toString());

//        nb509
        sB5.put("nb509", binding.nb509.getText().toString());

//        nb510
        sB5.put("nb510a", binding.nb510a.isChecked() ? "1" : "0");
        sB5.put("nb510b", binding.nb510b.isChecked() ? "2" : "0");
        sB5.put("nb510c", binding.nb510c.isChecked() ? "3" : "0");
        sB5.put("nb510d", binding.nb510d.isChecked() ? "4" : "0");
        sB5.put("nb510e", binding.nb510e.isChecked() ? "5" : "0");
        sB5.put("nb51096", binding.nb51096.isChecked() ? "96" : "0");
        sB5.put("nb51096x", binding.nb51096x.getText().toString());


        MainApp.mc.setsB5(String.valueOf(sB5));


        Toast.makeText(this, "Validation Successful! - Saving Draft...", Toast.LENGTH_SHORT).show();
    }

    private boolean UpdateDB() {

        //Long rowId;
        DatabaseHelper db = new DatabaseHelper(this);

        int updcount = db.updateSA5();

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
