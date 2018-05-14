package edu.aku.hassannaqvi.kmc.ui;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import edu.aku.hassannaqvi.kmc.R;
import edu.aku.hassannaqvi.kmc.core.DatabaseHelper;
import edu.aku.hassannaqvi.kmc.databinding.ActivitySectionC6Binding;
import edu.aku.hassannaqvi.kmc.validation.validatorClass;

public class SectionC6Activity extends AppCompatActivity {

    ActivitySectionC6Binding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_section_c6);

        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_c6);
        bi.setCallback(this);

        bi.kc601.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (bi.kc601a.isChecked()) {
                    bi.fldGrpkc602.setVisibility(View.VISIBLE);
                } else {
                    bi.fldGrpkc602.setVisibility(View.GONE);
                    bi.kc602.clearCheck();
                    bi.kc602day.setText(null);
                    bi.kc602week.setText(null);
                    bi.kc603.setText(null);
                    bi.kc60398.setChecked(false);
                    bi.kc604.clearCheck();
                    bi.kc605a.setChecked(false);
                    bi.kc605b.setChecked(false);
                    bi.kc605c.setChecked(false);
                    bi.kc605d.setChecked(false);
                    bi.kc605e.setChecked(false);
                    bi.kc605f.setChecked(false);
                    bi.kc605g.setChecked(false);
                    bi.kc605h.setChecked(false);
                    bi.kc605i.setChecked(false);
                    bi.kc605j.setChecked(false);
                    bi.kc605k.setChecked(false);
                    bi.kc605l.setChecked(false);
                    bi.kc60598.setChecked(false);
                    bi.kc60596.setChecked(false);
                    bi.kc60596x.setText(null);

                }
            }
        });


        bi.kc606.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (bi.kc606a.isChecked()) {
                    bi.fldGrpkc607.setVisibility(View.VISIBLE);
                } else {
                    bi.fldGrpkc607.setVisibility(View.GONE);
                    bi.kc607.clearCheck();
                    bi.kc607day.setText(null);
                    bi.kc607week.setText(null);
                    bi.kc608.setText(null);
                    bi.kc60898.setChecked(false);
                    bi.kc609.clearCheck();
                    bi.kc60996x.setText(null);
                    bi.kc610a.setChecked(false);
                    bi.kc610b.setChecked(false);
                    bi.kc610c.setChecked(false);
                    bi.kc610d.setChecked(false);
                    bi.kc610e.setChecked(false);
                    bi.kc610f.setChecked(false);
                    bi.kc610g.setChecked(false);
                    bi.kc61096.setChecked(false);
                    bi.kc61096x.setText(null);

                }
            }
        });

        bi.kc611.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (bi.kc611a.isChecked()) {
                    bi.fldGrpkc612.setVisibility(View.VISIBLE);
                } else {
                    bi.fldGrpkc612.setVisibility(View.GONE);
                    bi.kc612.clearCheck();
                    bi.kc61296x.setText(null);
                }
            }
        });


    }


    public boolean ValidateForm() {

        if (!validatorClass.EmptyRadioButton(this, bi.kc601, bi.kc601a, getString(R.string.kc601))) {
            return false;
        }

        if (bi.kc601a.isChecked()) {
            if (!validatorClass.EmptyRadioButton(this, bi.kc602, bi.kc602a, getString(R.string.kc602))) {
                return false;
            }

            if (bi.kc602a.isChecked()) {
                if (!validatorClass.EmptyTextBox(this, bi.kc602day, getString(R.string.kc602))) {
                    return false;
                }

                if (!validatorClass.RangeTextBox(this, bi.kc602day, 1, 30, getString(R.string.kc602), " days")) {
                    return false;
                }
            }

            if (bi.kc602b.isChecked()) {

                if (!validatorClass.EmptyTextBox(this, bi.kc602week, getString(R.string.kc602))) {
                    return false;
                }
            }

            if (!bi.kc60398.isChecked()) {
                if (!validatorClass.EmptyTextBox(this, bi.kc603, getString(R.string.kc603))) {
                    return false;
                }
            }

            if (!validatorClass.EmptyRadioButton(this, bi.kc604, bi.kc60496, bi.kc60496x, getString(R.string.kc604))) {
                return false;
            }

            if (!validatorClass.EmptyCheckBox(this, bi.kc605, bi.kc60596, bi.kc60596x, getString(R.string.kc605))) {
                return false;
            }

        }


        if (!validatorClass.EmptyRadioButton(this, bi.kc606, bi.kc606a, getString(R.string.kc606))) {
            return false;
        }

        if (bi.kc606a.isChecked()) {
            if (!validatorClass.EmptyRadioButton(this, bi.kc607, bi.kc607a, getString(R.string.kc607))) {
                return false;
            }

            if (bi.kc607a.isChecked()) {
                if (!validatorClass.EmptyTextBox(this, bi.kc607day, getString(R.string.kc607))) {
                    return false;
                }

                if (!validatorClass.RangeTextBox(this, bi.kc607day, 1, 30, getString(R.string.kc607), " days")) {
                    return false;
                }
            }

            if (bi.kc607b.isChecked()) {

                if (!validatorClass.EmptyTextBox(this, bi.kc607week, getString(R.string.kc607))) {
                    return false;
                }
            }

            if (!bi.kc60898.isChecked()) {
                if (!validatorClass.EmptyTextBox(this, bi.kc608, getString(R.string.kc608))) {
                    return false;
                }
            }

            if (!validatorClass.EmptyRadioButton(this, bi.kc609, bi.kc60996, bi.kc60996x, getString(R.string.kc609))) {
                return false;
            }

            if (!validatorClass.EmptyCheckBox(this, bi.kc610, bi.kc61096, bi.kc61096x, getString(R.string.kc610))) {
                return false;
            }

        }

        if (!validatorClass.EmptyRadioButton(this, bi.kc611, bi.kc611a, getString(R.string.kc611))) {
            return false;
        }

        if (bi.kc611a.isChecked()) {
            return validatorClass.EmptyRadioButton(this, bi.kc612, bi.kc61296, bi.kc61296x, getString(R.string.kc612));

        }


        return true;
    }


    private void SaveDraft() throws JSONException {
        Toast.makeText(this, "Saving Draft for  This Section", Toast.LENGTH_SHORT).show();

        JSONObject sn = new JSONObject();


        sn.put("kc601", bi.kc601a.isChecked() ? "1"
                : bi.kc601b.isChecked() ? "2"
                : bi.kc60198.isChecked() ? "98"
                : "0");

        sn.put("kc602", bi.kc602a.isChecked() ? "1"
                : bi.kc602b.isChecked() ? "2"
                : bi.kc60298.isChecked() ? "98"
                : "0");

        sn.put("kc602day", bi.kc602day.getText().toString());
        sn.put("kc602week", bi.kc602week.getText().toString());

        sn.put("kc603", bi.kc60398.isChecked() ? "98" : bi.kc603.getText().toString());

        sn.put("kc604", bi.kc604a.isChecked() ? "1"
                : bi.kc604b.isChecked() ? "2"
                : bi.kc604c.isChecked() ? "3"
                : bi.kc604d.isChecked() ? "4"
                : bi.kc604e.isChecked() ? "5"
                : bi.kc604f.isChecked() ? "6"
                : bi.kc604g.isChecked() ? "7"
                : bi.kc604h.isChecked() ? "8"
                : bi.kc604i.isChecked() ? "9"
                : bi.kc60496.isChecked() ? "96"
                : bi.kc60498.isChecked() ? "98"
                : "0");

        sn.put("kc60496x", bi.kc60496x.getText().toString());

        sn.put("kc605a", bi.kc605a.isChecked() ? "1" : "0");
        sn.put("kc605b", bi.kc605b.isChecked() ? "2" : "0");
        sn.put("kc605c", bi.kc605c.isChecked() ? "3" : "0");
        sn.put("kc605d", bi.kc605d.isChecked() ? "4" : "0");
        sn.put("kc605e", bi.kc605e.isChecked() ? "5" : "0");
        sn.put("kc605f", bi.kc605f.isChecked() ? "6" : "0");
        sn.put("kc605g", bi.kc605g.isChecked() ? "7" : "0");
        sn.put("kc605h", bi.kc605h.isChecked() ? "8" : "0");
        sn.put("kc605i", bi.kc605i.isChecked() ? "9" : "0");
        sn.put("kc605j", bi.kc605j.isChecked() ? "10" : "0");
        sn.put("kc605k", bi.kc605k.isChecked() ? "11" : "0");
        sn.put("kc605l", bi.kc605l.isChecked() ? "12" : "0");
        sn.put("kc60596", bi.kc60596.isChecked() ? "96" : "0");
        sn.put("kc60598", bi.kc60598.isChecked() ? "98" : "0");
        sn.put("kc60596x", bi.kc60596x.getText().toString());

        sn.put("kc701", bi.kc606a.isChecked() ? "1"
                : bi.kc606b.isChecked() ? "2"
                : bi.kc60698.isChecked() ? "98"
                : "0");

        sn.put("kc702", bi.kc607a.isChecked() ? "1"
                : bi.kc607b.isChecked() ? "2"
                : bi.kc60798.isChecked() ? "98"
                : "0");

        sn.put("kc702day", bi.kc607day.getText().toString());
        sn.put("kc702week", bi.kc607week.getText().toString());

        sn.put("kc703", bi.kc60898.isChecked() ? "98" : bi.kc608.getText().toString());

        sn.put("kc704", bi.kc609a.isChecked() ? "1"
                : bi.kc609b.isChecked() ? "2"
                : bi.kc609c.isChecked() ? "3"
                : bi.kc609d.isChecked() ? "4"
                : bi.kc609e.isChecked() ? "5"
                : bi.kc609f.isChecked() ? "6"
                : bi.kc609g.isChecked() ? "7"
                : bi.kc609h.isChecked() ? "8"
                : bi.kc60996.isChecked() ? "96"
                : "0");

        sn.put("kc70496x", bi.kc60996x.getText().toString());

        sn.put("kc705a", bi.kc610a.isChecked() ? "1" : "0");
        sn.put("kc705b", bi.kc610b.isChecked() ? "2" : "0");
        sn.put("kc705c", bi.kc610c.isChecked() ? "3" : "0");
        sn.put("kc705d", bi.kc610d.isChecked() ? "4" : "0");
        sn.put("kc705e", bi.kc610e.isChecked() ? "5" : "0");
        sn.put("kc705f", bi.kc610f.isChecked() ? "6" : "0");
        sn.put("kc705g", bi.kc610g.isChecked() ? "7" : "0");
        sn.put("kc70596", bi.kc61096.isChecked() ? "96" : "0");
        sn.put("kc70596x", bi.kc61096x.getText().toString());

        sn.put("kc706", bi.kc611a.isChecked() ? "1"
                : bi.kc611b.isChecked() ? "2"
                : "0");

        sn.put("kc707", bi.kc612a.isChecked() ? "1"
                : bi.kc612b.isChecked() ? "2"
                : bi.kc612c.isChecked() ? "3"
                : bi.kc612d.isChecked() ? "4"
                : bi.kc612e.isChecked() ? "5"
                : bi.kc612f.isChecked() ? "6"
                : bi.kc612g.isChecked() ? "7"
                : bi.kc612h.isChecked() ? "8"
                : bi.kc61296.isChecked() ? "96"
                : "0");

        //MainApp.fc.sets(String.valueOf(sn));

        Toast.makeText(this, "Validation Successful! - Saving Draft...", Toast.LENGTH_SHORT).show();
    }

    private boolean UpdateDB() {
        DatabaseHelper db = new DatabaseHelper(this);

        int updcount = db.updateBirthsDeaths();
        if (updcount == 1) {
            Toast.makeText(this, "Updating Database... Successful!", Toast.LENGTH_SHORT).show();
            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
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
