package edu.aku.hassannaqvi.kmc.ui;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;

import edu.aku.hassannaqvi.kmc.R;
import edu.aku.hassannaqvi.kmc.contracts.OutcomeContract;
import edu.aku.hassannaqvi.kmc.core.DatabaseHelper;
import edu.aku.hassannaqvi.kmc.core.MainApp;
import edu.aku.hassannaqvi.kmc.databinding.ActivitySectionB1ABinding;
import edu.aku.hassannaqvi.kmc.validation.validatorClass;

public class SectionB1AActivity extends AppCompatActivity {

    ActivitySectionB1ABinding bi;
    DatabaseHelper db;

    int childSerial = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_section_b1_a);

        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_b1_a);
        db = new DatabaseHelper(this);
        bi.setCallback(this);
        setupViews();

        if (MainApp.flag) {
            Boolean type = getIntent().getExtras().getBoolean("type");
            String date = getIntent().getExtras().getString("date");

            if (type) {
                bi.nb1a01.setText(date);
                bi.nb1a02d.setChecked(true);
                bi.nb1a01.setEnabled(false);
                bi.nb1a02.setEnabled(false);
            } else {
                bi.nb1a01.setText(null);
                bi.nb1a02d.setChecked(false);
                bi.nb1a01.setEnabled(true);
                bi.nb1a02.setEnabled(true);
            }
        }

    }

    public void setupViews() {

        bi.nb1a01.setManager(getSupportFragmentManager());

        bi.nb1a04.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (bi.nb1a04a.isChecked()) {
                    bi.fldGrpnb1a05.setVisibility(View.VISIBLE);
                    bi.fldGrpnb1a06.setVisibility(View.GONE);
                    bi.nb1a06d.setText(null);
                    bi.nb1a06m.setText(null);
                    bi.nb1a06y.setText(null);

                } else {
                    bi.fldGrpnb1a05.setVisibility(View.GONE);
                    bi.fldGrpnb1a06.setVisibility(View.VISIBLE);
                    bi.nb1a05d.setText(null);
                    bi.nb1a05m.setText(null);
                    bi.nb1a05y.setText(null);
                }
            }
        });

        bi.nb1a02.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (bi.nb1a02a.isChecked() || bi.nb1a02b.isChecked() || bi.nb1a02c.isChecked()) {
                    bi.fldGrpnb1a03.setVisibility(View.GONE);
                    bi.nb1a04.clearCheck();
                    bi.nb1a05d.setText(null);
                    bi.nb1a05m.setText(null);
                    bi.nb1a05y.setText(null);
                    bi.nb1a06d.setText(null);
                    bi.nb1a06m.setText(null);
                    bi.nb1a06y.setText(null);

                } else {
                    bi.fldGrpnb1a03.setVisibility(View.VISIBLE);
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

                if (MainApp.outcome != 4) {
                    MainApp.count++;
                    if (MainApp.totalPregnancy >= MainApp.count) {
                        startActivity(new Intent(this, SectionB1Activity.class).putExtra("type", false));
                    } else {
                        startActivity(new Intent(this, SectionB2Activity.class));
                    }
                } else {

                    MainApp.outcome = 0;
                    MainApp.flag = true;
                    childSerial++;
                    Intent i = new Intent(this, SectionB1AActivity.class);
                    i.putExtra("date", bi.nb1a01.getText().toString());
                    i.putExtra("type", true);
                    startActivity(i);

                    //startActivity(new Intent(this, SectionB1Activity.class).putExtra(""));
                }


            } else {
                Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
            }
        }

        //startActivity(new Intent(this, SectionB2Activity.class));
    }

    public void BtnEnd() {
        MainApp.endActivity(this, this);

    }

    private boolean ValidateForm() {

        Toast.makeText(this, "Validating This Section ", Toast.LENGTH_SHORT).show();

        if (!validatorClass.EmptyTextBox(this, bi.nb1a01, getString(R.string.nb1a01))) {
            return false;
        }

        if (!validatorClass.EmptyRadioButton(this, bi.nb1a02, bi.nb1a02a, getString(R.string.nb1a02))) {
            return false;
        }

        if (bi.nb1a02c.isChecked() || bi.nb1a02f.isChecked()) {
            if (!validatorClass.EmptyRadioButton(this, bi.nb1a04, bi.nb1a04a, getString(R.string.nb1a04))) {
                return false;
            }

            if (bi.nb1a04a.isChecked()) {
                if (!validatorClass.EmptyTextBox(this, bi.nb1a05y, getString(R.string.nb1a05) + " - " + getString(R.string.year))) {
                    return false;
                }

                if (!validatorClass.EmptyTextBox(this, bi.nb1a05m, getString(R.string.nb1a05) + " - " + getString(R.string.month))) {
                    return false;
                }

                if (!validatorClass.EmptyTextBox(this, bi.nb1a05d, getString(R.string.nb1a05) + " - " + getString(R.string.day))) {
                    return false;
                }

                if (!validatorClass.RangeTextBox(this, bi.nb1a05m, 0, 11, getString(R.string.nb1a05), " months")) {
                    return false;
                }


                if (!validatorClass.RangeTextBox(this, bi.nb1a05d, 0, 29, getString(R.string.nb1a05), " days")) {
                    return false;
                }

                if (bi.nb1a05y.getText().toString().equals("0") && bi.nb1a05m.getText().toString().equals("0") && bi.nb1a05d.getText().toString().equals("0")) {
                    Toast.makeText(this, "ERROR(invalid): " + "All can not be zero" + getString(R.string.nb1a05), Toast.LENGTH_LONG).show();
                    bi.nb1a05y.setError("All can not be zero");
                    bi.nb1a05m.setError("All can not be zero");
                    bi.nb1a05d.setError("All can not be zero");
                    Log.i(SectionA2Activity.class.getSimpleName(), "nb1a05" + ": This data is Required!");
                } else {
                    bi.nb1a05y.setError(null);
                    bi.nb1a05m.setError(null);
                    bi.nb1a05d.setError(null);
                }
            } else if (bi.nb1a04b.isChecked()) {
                if (!validatorClass.EmptyTextBox(this, bi.nb1a06y, getString(R.string.nb1a06) + " - " + getString(R.string.year))) {
                    return false;
                }

                if (!validatorClass.EmptyTextBox(this, bi.nb1a06m, getString(R.string.nb1a06) + " - " + getString(R.string.month))) {
                    return false;
                }

                if (!validatorClass.EmptyTextBox(this, bi.nb1a06d, getString(R.string.nb1a06) + " - " + getString(R.string.day))) {
                    return false;
                }

                if (!validatorClass.RangeTextBox(this, bi.nb1a06m, 0, 11, getString(R.string.nb1a06), " months")) {
                    return false;
                }


                if (!validatorClass.RangeTextBox(this, bi.nb1a06d, 0, 29, getString(R.string.nb1a06), " days")) {
                    return false;
                }

                if (bi.nb1a06y.getText().toString().equals("0") && bi.nb1a06m.getText().toString().equals("0") && bi.nb1a06d.getText().toString().equals("0")) {
                    Toast.makeText(this, "ERROR(invalid): " + "All can not be zero" + getString(R.string.nb1a06), Toast.LENGTH_LONG).show();
                    bi.nb1a06y.setError("All can not be zero");
                    bi.nb1a06m.setError("All can not be zero");
                    bi.nb1a06d.setError("All can not be zero");
                    Log.i(SectionA2Activity.class.getSimpleName(), "nb1a06" + ": This data is Required!");
                } else {
                    bi.nb1a06y.setError(null);
                    bi.nb1a06m.setError(null);
                    bi.nb1a06d.setError(null);
                }
            }
        }


        return true;
    }


    private void SaveDraft() throws JSONException {
        Toast.makeText(this, "Saving Draft for  This Section", Toast.LENGTH_SHORT).show();


        MainApp.oc = new OutcomeContract();

        MainApp.oc.setDevicetagID(MainApp.getTagName(this));
        MainApp.oc.setFormDate(new SimpleDateFormat("dd-MM-yyyy HH:mm").format(System.currentTimeMillis()));
        MainApp.oc.setUser(MainApp.userName);
        MainApp.oc.setDeviceId(Settings.Secure.getString(getApplicationContext().getContentResolver(),
                Settings.Secure.ANDROID_ID));
        MainApp.oc.setApp_ver(MainApp.versionName + "." + MainApp.versionCode);
        MainApp.oc.set_UUID(MainApp.mc.get_UID());


        JSONObject sB1a = new JSONObject();

        sB1a.put("nb1a01", bi.nb1a01.getText().toString());

        sB1a.put("nb1a02", bi.nb1a02a.isChecked() ? "1"
                : bi.nb1a02b.isChecked() ? "2"
                : bi.nb1a02c.isChecked() ? "3"
                : bi.nb1a02d.isChecked() ? "4"
                : bi.nb1a02e.isChecked() ? "5"
                : bi.nb1a02f.isChecked() ? "6"
                : "0");

        if (!MainApp.flag) {
            MainApp.outcome = bi.nb1a02.indexOfChild(findViewById(bi.nb1a02.getCheckedRadioButtonId())) + 1;
        }


        sB1a.put("nb1a03", String.valueOf(childSerial));

        sB1a.put("nb1a04", bi.nb1a04a.isChecked() ? "1"
                : bi.nb1a04b.isChecked() ? "2"
                : "0");

        sB1a.put("nb1a05y", bi.nb1a05y.getText().toString());
        sB1a.put("nb1a05m", bi.nb1a05m.getText().toString());
        sB1a.put("nb1a05d", bi.nb1a05d.getText().toString());

        sB1a.put("nb1a06y", bi.nb1a06y.getText().toString());
        sB1a.put("nb1a06m", bi.nb1a06m.getText().toString());
        sB1a.put("nb1a06d", bi.nb1a06d.getText().toString());

        MainApp.oc.setsB1A(String.valueOf(sB1a));


        Toast.makeText(this, "Validation Successful! - Saving Draft...", Toast.LENGTH_SHORT).show();

    }

    private boolean UpdateDB() {

        //Long rowId;
        DatabaseHelper db = new DatabaseHelper(this);

        Long updcount = db.addOutcome(MainApp.oc);
        MainApp.oc.set_ID(String.valueOf(updcount));

        if (updcount != 0) {
            Toast.makeText(this, "Updating Database... Successful!", Toast.LENGTH_SHORT).show();

            MainApp.oc.set_UID(
                    (MainApp.oc.getDeviceId() + MainApp.oc.get_ID()));
            db.updateOutcomeID();

            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }

        //return true;

    }

}

