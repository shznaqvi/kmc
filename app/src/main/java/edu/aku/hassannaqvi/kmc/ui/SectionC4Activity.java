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

import java.text.SimpleDateFormat;
import java.util.Date;

import edu.aku.hassannaqvi.kmc.R;
import edu.aku.hassannaqvi.kmc.core.DatabaseHelper;
import edu.aku.hassannaqvi.kmc.core.MainApp;
import edu.aku.hassannaqvi.kmc.databinding.ActivitySectionC4Binding;
import edu.aku.hassannaqvi.kmc.validation.validatorClass;

public class SectionC4Activity extends AppCompatActivity {

    private static final String TAG = SectionC4Activity.class.getName();
    String dtToday = new SimpleDateFormat("dd-MM-yy HH:mm").format(new Date().getTime());

    ActivitySectionC4Binding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_section_c4);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_c4);
        bi.setCallback(this);
        setupView();
    }

    private void setupView() {
        bi.kc402.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.kc402b) {
                    bi.fldGrpkc403.setVisibility(View.GONE);
                    bi.kc403a.setChecked(false);
                    bi.kc403b.setChecked(false);
                    bi.kc403c.setChecked(false);
                    bi.kc403d.setChecked(false);
                    bi.kc403e.setChecked(false);
                    bi.kc403f.setChecked(false);
                    bi.kc403g.setChecked(false);
                    bi.kc403h.setChecked(false);
                    bi.kc403i.setChecked(false);
                    bi.kc40399.setChecked(false);
                    bi.kc40396.setChecked(false);
                    bi.kc40396x.setText(null);
                    bi.kc404.clearCheck();
                    bi.kc406.clearCheck();
                    bi.kc405.setText(null);
                    bi.kc407a.setChecked(false);
                    bi.kc407b.setChecked(false);
                    bi.kc407c.setChecked(false);
                    bi.kc407d.setChecked(false);
                    bi.kc407e.setChecked(false);
                    bi.kc407f.setChecked(false);
                    bi.kc40798.setChecked(false);
                    bi.kc40796.setChecked(false);
                    bi.kc40796x.setText(null);
                    bi.kc408.clearCheck();
                } else {
                    bi.fldGrpkc403.setVisibility(View.VISIBLE);
                }
            }
        });
        bi.kc40399.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    bi.kc403a.setChecked(false);
                    bi.kc403b.setChecked(false);
                    bi.kc403c.setChecked(false);
                    bi.kc403d.setChecked(false);
                    bi.kc403e.setChecked(false);
                    bi.kc403f.setChecked(false);
                    bi.kc403g.setChecked(false);
                    bi.kc403h.setChecked(false);
                    bi.kc403i.setChecked(false);
                    bi.kc40396.setChecked(false);

                    bi.kc403a.setEnabled(false);
                    bi.kc403b.setEnabled(false);
                    bi.kc403c.setEnabled(false);
                    bi.kc403d.setEnabled(false);
                    bi.kc403e.setEnabled(false);
                    bi.kc403f.setEnabled(false);
                    bi.kc403g.setEnabled(false);
                    bi.kc403h.setEnabled(false);
                    bi.kc403i.setEnabled(false);
                    bi.kc40396.setEnabled(false);
                } else {
                    bi.kc403a.setEnabled(true);
                    bi.kc403b.setEnabled(true);
                    bi.kc403c.setEnabled(true);
                    bi.kc403d.setEnabled(true);
                    bi.kc403e.setEnabled(true);
                    bi.kc403f.setEnabled(true);
                    bi.kc403g.setEnabled(true);
                    bi.kc403h.setEnabled(true);
                    bi.kc403i.setEnabled(true);
                    bi.kc40396.setEnabled(true);
                }
            }
        });

        bi.kc404.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.kc404b) {
                    bi.fldGrpkc406.setVisibility(View.GONE);
                    bi.kc405.setText(null);
                    bi.kc406.clearCheck();
                    bi.kc407a.setChecked(false);
                    bi.kc407b.setChecked(false);
                    bi.kc407c.setChecked(false);
                    bi.kc407d.setChecked(false);
                    bi.kc407e.setChecked(false);
                    bi.kc407f.setChecked(false);
                    bi.kc40798.setChecked(false);
                    bi.kc40796.setChecked(false);
                    bi.kc40796x.setText(null);
                    bi.kc408.clearCheck();
                } else {
                    bi.fldGrpkc406.setVisibility(View.VISIBLE);
                }
            }
        });
        bi.kc40798.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    bi.kc407a.setChecked(false);
                    bi.kc407b.setChecked(false);
                    bi.kc407c.setChecked(false);
                    bi.kc407d.setChecked(false);
                    bi.kc407e.setChecked(false);
                    bi.kc407f.setChecked(false);
                    bi.kc40796.setChecked(false);
                    bi.kc407a.setEnabled(false);
                    bi.kc407b.setEnabled(false);
                    bi.kc407c.setEnabled(false);
                    bi.kc407d.setEnabled(false);
                    bi.kc407e.setEnabled(false);
                    bi.kc407f.setEnabled(false);
                    bi.kc40796.setEnabled(false);
                } else {
                    bi.kc407a.setEnabled(true);
                    bi.kc407b.setEnabled(true);
                    bi.kc407c.setEnabled(true);
                    bi.kc407d.setEnabled(true);
                    bi.kc407e.setEnabled(true);
                    bi.kc407f.setEnabled(true);
                    bi.kc40796.setEnabled(true);
                }
            }
        });


    }


    private void SaveDraft() throws JSONException {

        JSONObject sC4 = new JSONObject();

        sC4.put("kc401a", bi.kc401a.isChecked() ? "1" : "0");
        sC4.put("kc401b", bi.kc401a.isChecked() ? "2" : "0");
        sC4.put("kc401c", bi.kc401a.isChecked() ? "3" : "0");
        sC4.put("kc401d", bi.kc401a.isChecked() ? "4" : "0");
        sC4.put("kc401e", bi.kc401a.isChecked() ? "5" : "0");
        sC4.put("kc40196", bi.kc40196.isChecked() ? "96" : "0");

        sC4.put("kc40196", bi.kc40196x.getText().toString());

        sC4.put("kc402", bi.kc402a.isChecked() ? "1"
                : bi.kc402b.isChecked() ? "2"
                : "0");

        sC4.put("kc403a", bi.kc403a.isChecked() ? "1" : "0");
        sC4.put("kc403b", bi.kc403b.isChecked() ? "2" : "0");
        sC4.put("kc403c", bi.kc403c.isChecked() ? "3" : "0");
        sC4.put("kc403d", bi.kc403d.isChecked() ? "4" : "0");
        sC4.put("kc403e", bi.kc403e.isChecked() ? "5" : "0");
        sC4.put("kc403f", bi.kc403f.isChecked() ? "6" : "0");
        sC4.put("kc403g", bi.kc403g.isChecked() ? "7" : "0");
        sC4.put("kc403h", bi.kc403h.isChecked() ? "8" : "0");
        sC4.put("kc403i", bi.kc403i.isChecked() ? "9" : "0");
        sC4.put("kc40399", bi.kc40399.isChecked() ? "99" : "0");
        sC4.put("kc40396", bi.kc40396.isChecked() ? "96" : "0");
        sC4.put("kc40396x", bi.kc40396x.getText().toString());


        sC4.put("kc404", bi.kc404a.isChecked() ? "1"
                : bi.kc404b.isChecked() ? "2"
                : "0");
        sC4.put("kc405", bi.kc405.getText().toString());

        sC4.put("kc406", bi.kc406a.isChecked() ? "1"
                : bi.kc406b.isChecked() ? "2"
                : bi.kc40698.isChecked() ? "98"
                : "0");

        sC4.put("kc407a", bi.kc407a.isChecked() ? "1" : "0");
        sC4.put("kc407b", bi.kc407b.isChecked() ? "2" : "0");
        sC4.put("kc407c", bi.kc407c.isChecked() ? "3" : "0");
        sC4.put("kc407d", bi.kc407d.isChecked() ? "4" : "0");
        sC4.put("kc407e", bi.kc407e.isChecked() ? "5" : "0");
        sC4.put("kc407f", bi.kc407f.isChecked() ? "6" : "0");
        sC4.put("kc40798", bi.kc40798.isChecked() ? "98" : "0");
        sC4.put("kc40796", bi.kc40796.isChecked() ? "96" : "0");


        sC4.put("kc40796x", bi.kc40796x.getText().toString());


        sC4.put("kc408", bi.kc408a.isChecked() ? "1"
                : bi.kc408b.isChecked() ? "2"
                : bi.kc40898.isChecked() ? "98"
                : "0");


        MainApp.fc.setsC4(String.valueOf(sC4));
    }


    private boolean formValidation() {

        if (!validatorClass.EmptyCheckBox(this, bi.kc401, bi.kc40196, bi.kc40196x, getString(R.string.kc401))) {
            return false;
        }

        if (!validatorClass.EmptyRadioButton(this, bi.kc402, bi.kc402a, getString(R.string.kc402))) {
            return false;
        }
        if (bi.kc402a.isChecked()) {

            if (!validatorClass.EmptyCheckBox(this, bi.kc403, bi.kc40396, bi.kc40396x, getString(R.string.kc403))) {
                return false;
            }


            if (!validatorClass.EmptyRadioButton(this, bi.kc404, bi.kc404a, getString(R.string.kc404))) {
                return false;
            }
            if (bi.kc404a.isChecked()) {

                if (!validatorClass.EmptyTextBox(this, bi.kc405, getString(R.string.kc405))) {
                    return false;
                }


                if (!validatorClass.EmptyRadioButton(this, bi.kc406, bi.kc406a, getString(R.string.kc406))) {
                    return false;
                }


                if (!validatorClass.EmptyCheckBox(this, bi.kc407, bi.kc407a, getString(R.string.kc407))) {
                    return false;
                }


                if (bi.kc40796.isChecked()) {

                    if (!validatorClass.EmptyTextBox(this, bi.kc40796x, getString(R.string.other))) {
                        return false;
                    }
                }
                if (!validatorClass.EmptyRadioButton(this, bi.kc408, bi.kc408a, getString(R.string.kc408))) {
                    return false;
                }
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

                startActivity(new Intent(this, SectionC5Activity.class));
                //startActivity(new Intent(this, MainActivity.class));

            } else {
                Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
            }
        }
    }


    private boolean UpdateDB() {

        //Long rowId;
        DatabaseHelper db = new DatabaseHelper(this);

        int updcount = db.updateSC4();

        if (updcount == 1) {
            //Toast.makeText(this, "Updating Database... Successful!", Toast.LENGTH_SHORT).show();
            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }

    }

}
