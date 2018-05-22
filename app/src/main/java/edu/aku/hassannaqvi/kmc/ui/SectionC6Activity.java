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
                    bi.kc60298.setChecked(false);
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
                    bi.kc605m.setChecked(false);
                    bi.kc60598.setChecked(false);
                    bi.kc60596.setChecked(false);
                    bi.kc60596x.setText(null);

                }
            }
        });
        bi.kc60598.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
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
                    bi.kc605m.setChecked(false);
                    bi.kc60596.setChecked(false);
                    bi.kc605a.setEnabled(false);
                    bi.kc605b.setEnabled(false);
                    bi.kc605c.setEnabled(false);
                    bi.kc605d.setEnabled(false);
                    bi.kc605e.setEnabled(false);
                    bi.kc605f.setEnabled(false);
                    bi.kc605g.setEnabled(false);
                    bi.kc605h.setEnabled(false);
                    bi.kc605i.setEnabled(false);
                    bi.kc605j.setEnabled(false);
                    bi.kc605k.setEnabled(false);
                    bi.kc605l.setEnabled(false);
                    bi.kc605m.setEnabled(false);
                    bi.kc60596.setEnabled(false);
                } else {
                    bi.kc605a.setEnabled(true);
                    bi.kc605b.setEnabled(true);
                    bi.kc605c.setEnabled(true);
                    bi.kc605d.setEnabled(true);
                    bi.kc605e.setEnabled(true);
                    bi.kc605f.setEnabled(true);
                    bi.kc605g.setEnabled(true);
                    bi.kc605h.setEnabled(true);
                    bi.kc605i.setEnabled(true);
                    bi.kc605j.setEnabled(true);
                    bi.kc605k.setEnabled(true);
                    bi.kc605l.setEnabled(true);
                    bi.kc605m.setEnabled(true);
                    bi.kc60596.setEnabled(true);
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
                    bi.kc60798.setChecked(false);
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
                    bi.kc61098.setChecked(false);
                    bi.kc61096.setChecked(false);
                    bi.kc61096x.setText(null);

                }
            }
        });
        bi.kc61098.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    bi.kc610a.setChecked(false);
                    bi.kc610b.setChecked(false);
                    bi.kc610c.setChecked(false);
                    bi.kc610d.setChecked(false);
                    bi.kc610e.setChecked(false);
                    bi.kc610f.setChecked(false);
                    bi.kc610g.setChecked(false);
                    bi.kc61096.setChecked(false);
                    bi.kc610a.setEnabled(false);
                    bi.kc610b.setEnabled(false);
                    bi.kc610c.setEnabled(false);
                    bi.kc610d.setEnabled(false);
                    bi.kc610e.setEnabled(false);
                    bi.kc610f.setEnabled(false);
                    bi.kc610g.setEnabled(false);
                    bi.kc61096.setEnabled(false);
                } else {
                    bi.kc610a.setEnabled(true);
                    bi.kc610b.setEnabled(true);
                    bi.kc610c.setEnabled(true);
                    bi.kc610d.setEnabled(true);
                    bi.kc610e.setEnabled(true);
                    bi.kc610f.setEnabled(true);
                    bi.kc610g.setEnabled(true);
                    bi.kc61096.setEnabled(true);
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
                    bi.kc612a.setChecked(false);
                    bi.kc612b.setChecked(false);
                    bi.kc612c.setChecked(false);
                    bi.kc612d.setChecked(false);
                    bi.kc612e.setChecked(false);
                    bi.kc612f.setChecked(false);
                    bi.kc612g.setChecked(false);
                    bi.kc612h.setChecked(false);
                    bi.kc61296.setChecked(false);
                    bi.kc61298.setChecked(false);
                    bi.kc61296x.setText(null);
                }
            }
        });
        bi.kc61298.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    bi.kc612a.setChecked(false);
                    bi.kc612b.setChecked(false);
                    bi.kc612c.setChecked(false);
                    bi.kc612d.setChecked(false);
                    bi.kc612e.setChecked(false);
                    bi.kc612f.setChecked(false);
                    bi.kc612g.setChecked(false);
                    bi.kc612h.setChecked(false);
                    bi.kc61296.setChecked(false);
                    bi.kc612a.setEnabled(false);
                    bi.kc612a.setEnabled(false);
                    bi.kc612b.setEnabled(false);
                    bi.kc612c.setEnabled(false);
                    bi.kc612d.setEnabled(false);
                    bi.kc612e.setEnabled(false);
                    bi.kc612f.setEnabled(false);
                    bi.kc612g.setEnabled(false);
                    bi.kc612h.setEnabled(false);
                    bi.kc61296.setEnabled(false);

                } else {

                    bi.kc612a.setEnabled(true);
                    bi.kc612a.setEnabled(true);
                    bi.kc612b.setEnabled(true);
                    bi.kc612c.setEnabled(true);
                    bi.kc612d.setEnabled(true);
                    bi.kc612e.setEnabled(true);
                    bi.kc612f.setEnabled(true);
                    bi.kc612g.setEnabled(true);
                    bi.kc612h.setEnabled(true);
                    bi.kc61296.setEnabled(true);
                }
            }
        });


    }


    public boolean ValidateForm() {

        if (!validatorClass.EmptyRadioButton(this, bi.kc601, bi.kc601a, getString(R.string.kc601))) {
            return false;
        }

        if (bi.kc601a.isChecked()) {
            if (!bi.kc60298.isChecked()) {
                if (!validatorClass.EmptyTextBox(this, bi.kc602day, getString(R.string.kc602))) {
                    return false;
                }

                if (!validatorClass.RangeTextBox(this, bi.kc602day, 0, 6, getString(R.string.kc602), " days")) {
                    return false;
                }


                if (!validatorClass.EmptyTextBox(this, bi.kc602week, getString(R.string.kc602))) {
                    return false;
                }

                if (!validatorClass.RangeTextBox(this, bi.kc602week, 0, 7, getString(R.string.kc602), " weeks")) {
                    return false;
                }
                if (bi.kc602day.getText().toString().equals("0") && bi.kc602week.getText().toString().equals("0")) {
                    Toast.makeText(this, "Days and weeks cannot be 0 at the same time! ", Toast.LENGTH_LONG).show();
                    bi.kc602day.setError("Days and weeks cannot be 0 at the same time!");
                    bi.kc602week.setError("Days and weeks cannot be 0 at the same time!");
                    bi.kc602day.requestFocus();
                    return false;
                } else {
                    bi.kc602day.setError(null);
                    bi.kc602week.setError(null);
                    bi.kc602day.clearFocus();
                }

            }

            if (!bi.kc60398.isChecked()) {
                if (!validatorClass.EmptyTextBox(this, bi.kc603, getString(R.string.kc603))) {
                    return false;
                }
                if (!validatorClass.RangeTextBox(this, bi.kc603, 1, 10, getString(R.string.kc603), " times")) {
                    return false;
                }
            }

            if (!validatorClass.EmptyRadioButton(this, bi.kc604, bi.kc60496, bi.kc60496x, getString(R.string.kc604))) {
                return false;
            }

            if (!validatorClass.EmptyCheckBox(this, bi.kc605, bi.kc60596, bi.kc60596x, getString(R.string.kc605))) {
                return false;
            }
            if (bi.kc605d.isChecked()) {

                if (!validatorClass.EmptyTextBox(this, bi.kc605dx, getString(R.string.kc605))) {
                    return false;
                }

            }
        }

        if (!validatorClass.EmptyRadioButton(this, bi.kc606, bi.kc606a, getString(R.string.kc606))) {
            return false;
        }

        if (bi.kc606a.isChecked()) {
            if (!bi.kc60798.isChecked()) {
                if (!validatorClass.EmptyTextBox(this, bi.kc607day, getString(R.string.kc607))) {
                    return false;
                }

                if (!validatorClass.RangeTextBox(this, bi.kc607day, 0, 6, getString(R.string.kc607), " days")) {
                    return false;
                }


                if (!validatorClass.EmptyTextBox(this, bi.kc607week, getString(R.string.kc607))) {
                    return false;
                }

                if (!validatorClass.RangeTextBox(this, bi.kc607week, 0, 7, getString(R.string.kc607), " weeks")) {
                    return false;
                }
                if (bi.kc607day.getText().toString().equals("0") && bi.kc607week.getText().toString().equals("0")) {
                    Toast.makeText(this, "Days and weeks cannot be 0 at the same time! ", Toast.LENGTH_LONG).show();
                    bi.kc607day.setError("Days and weeks cannot be 0 at the same time!");
                    bi.kc607week.setError("Days and weeks cannot be 0 at the same time!");
                    bi.kc607day.requestFocus();
                    return false;
                } else {
                    bi.kc607day.setError(null);
                    bi.kc607week.setError(null);
                    bi.kc607day.clearFocus();
                }
            }

            if (!bi.kc60898.isChecked()) {
                if (!validatorClass.EmptyTextBox(this, bi.kc608, getString(R.string.kc608))) {
                    return false;
                }
                if (!validatorClass.RangeTextBox(this, bi.kc608, 1, 10, getString(R.string.kc608), " times")) {
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
            if (!validatorClass.EmptyCheckBox(this, bi.kc612, bi.kc61296, bi.kc61296x, getString(R.string.kc612))) {
                return false;
            }
        }
        return true;
    }


    private void SaveDraft() throws JSONException {
        Toast.makeText(this, "Saving Draft for  This Section", Toast.LENGTH_SHORT).show();

        JSONObject sn = new JSONObject();


        sn.put("kc601", bi.kc601a.isChecked() ? "1"
                : bi.kc601b.isChecked() ? "2"
                : "0");


        sn.put("kc602day", bi.kc602day.getText().toString());
        sn.put("kc602week", bi.kc602week.getText().toString());
        sn.put("kc60298", bi.kc60298.isChecked() ? "98" : "0");

        sn.put("kc603", bi.kc60398.isChecked() ? "98" : bi.kc603.getText().toString());

        sn.put("kc604", bi.kc604a.isChecked() ? "1"
                : bi.kc604b.isChecked() ? "2"
                : bi.kc604c.isChecked() ? "3"
                : bi.kc604d.isChecked() ? "4"
                : bi.kc604e.isChecked() ? "5"
                : bi.kc604f.isChecked() ? "6"
                : bi.kc604g.isChecked() ? "7"
                : bi.kc604h.isChecked() ? "8"
                : bi.kc60496.isChecked() ? "96"
                : bi.kc60498.isChecked() ? "98"
                : "0");

        sn.put("kc60496x", bi.kc60496x.getText().toString());

        sn.put("kc605a", bi.kc605a.isChecked() ? "1" : "0");
        sn.put("kc605b", bi.kc605b.isChecked() ? "2" : "0");
        sn.put("kc605c", bi.kc605c.isChecked() ? "3" : "0");
        sn.put("kc605d", bi.kc605d.isChecked() ? "4" : "0");
        sn.put("kc605dx", bi.kc605dx.getText().toString());
        sn.put("kc605e", bi.kc605e.isChecked() ? "5" : "0");
        sn.put("kc605f", bi.kc605f.isChecked() ? "6" : "0");
        sn.put("kc605g", bi.kc605g.isChecked() ? "7" : "0");
        sn.put("kc605h", bi.kc605h.isChecked() ? "8" : "0");
        sn.put("kc605i", bi.kc605i.isChecked() ? "9" : "0");
        sn.put("kc605j", bi.kc605j.isChecked() ? "10" : "0");
        sn.put("kc605k", bi.kc605k.isChecked() ? "11" : "0");
        sn.put("kc605l", bi.kc605l.isChecked() ? "12" : "0");
        sn.put("kc605m", bi.kc605m.isChecked() ? "13" : "0");
        sn.put("kc60596", bi.kc60596.isChecked() ? "96" : "0");
        sn.put("kc60598", bi.kc60598.isChecked() ? "98" : "0");
        sn.put("kc60596x", bi.kc60596x.getText().toString());

        sn.put("kc701", bi.kc606a.isChecked() ? "1"
                : bi.kc606b.isChecked() ? "2"
                : bi.kc60698.isChecked() ? "98"
                : "0");


        sn.put("kc702day", bi.kc607day.getText().toString());
        sn.put("kc702week", bi.kc607week.getText().toString());
        sn.put("kc70298", bi.kc60798.isChecked() ? "98" : "0");

        sn.put("kc703", bi.kc60898.isChecked() ? "98" : bi.kc608.getText().toString());

        sn.put("kc704", bi.kc609a.isChecked() ? "1"
                : bi.kc609b.isChecked() ? "2"
                : bi.kc609c.isChecked() ? "3"
                : bi.kc609d.isChecked() ? "4"
                : bi.kc609e.isChecked() ? "5"
                : bi.kc609f.isChecked() ? "6"
                : bi.kc609g.isChecked() ? "7"
                : bi.kc609h.isChecked() ? "8"
                : bi.kc60998.isChecked() ? "98"
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
        sn.put("kc70598", bi.kc61098.isChecked() ? "98" : "0");
        sn.put("kc70596", bi.kc61096.isChecked() ? "96" : "0");
        sn.put("kc70596x", bi.kc61096x.getText().toString());

        sn.put("kc706", bi.kc611a.isChecked() ? "1"
                : bi.kc611b.isChecked() ? "2"
                : "0");

        sn.put("kc707a", bi.kc612a.isChecked() ? "1" : "0");
        sn.put("kc707b", bi.kc612b.isChecked() ? "2" : "0");
        sn.put("kc707c", bi.kc612c.isChecked() ? "3" : "0");
        sn.put("kc707d", bi.kc612d.isChecked() ? "4" : "0");
        sn.put("kc707e", bi.kc612e.isChecked() ? "5" : "0");
        sn.put("kc707f", bi.kc612f.isChecked() ? "6" : "0");
        sn.put("kc707g", bi.kc612g.isChecked() ? "7" : "0");
        sn.put("kc707h", bi.kc612h.isChecked() ? "8" : "0");
        sn.put("kc70798", bi.kc61298.isChecked() ? "98" : "0");
        sn.put("kc70796", bi.kc61296.isChecked() ? "96" : "0");
        sn.put("kc70796x", bi.kc61296x.getText().toString());

        //MainApp.fc.sets(String.valueOf(sn));

        Toast.makeText(this, "Validation Successful! - Saving Draft...", Toast.LENGTH_SHORT).show();
    }

    private boolean UpdateDB() {
        DatabaseHelper db = new DatabaseHelper(this);

        int updcount = db.updateSC6();
        if (updcount == 1) {
            Toast.makeText(this, "Updating Database... Successful!", Toast.LENGTH_SHORT).show();
            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }

    }


    public void BtnEnd() {

        Toast.makeText(this, "Processing End Section", Toast.LENGTH_SHORT).show();
        //if (ValidateForm()) {
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
        if (ValidateForm()) {
            try {
                SaveDraft();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (UpdateDB()) {
                Toast.makeText(this, "Starting Ending Section", Toast.LENGTH_SHORT).show();

                finish();

                startActivity(new Intent(this, SectionD1Activity.class));
                //                startActivity(new Intent(this, MainActivity.class));

            } else {
                Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
