package edu.aku.hassannaqvi.kmc.ui;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import edu.aku.hassannaqvi.kmc.R;
import edu.aku.hassannaqvi.kmc.core.DatabaseHelper;
import edu.aku.hassannaqvi.kmc.core.MainApp;
import edu.aku.hassannaqvi.kmc.databinding.ActivitySectionB2Binding;
import edu.aku.hassannaqvi.kmc.validation.validatorClass;

public class SectionB2Activity extends AppCompatActivity {
    ActivitySectionB2Binding bi;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_b2);
        db = new DatabaseHelper(this);
        bi.setCallback(this);

        setupViews();
    }

    private void setupViews() {
        bi.kb206.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.kb206a) {
                    bi.fldGrpkb207.setVisibility(View.GONE);
                    bi.kb207.clearCheck();
                    bi.kb20796x.setText(null);

                } else {
                    bi.fldGrpkb207.setVisibility(View.VISIBLE);

                }
            }
        });

        bi.kb213.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId != R.id.kb213b) {
                    bi.fldGrpkb214.setVisibility(View.VISIBLE);

                } else {
                    bi.fldGrpkb214.setVisibility(View.GONE);
                    bi.kb214.clearCheck();
                    bi.kb21496x.setText(null);

                    bi.kb215.clearCheck();
                    bi.kb216.clearCheck();
                    bi.kb217.clearCheck();
                }
            }
        });

        bi.kb218.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId != R.id.kb218b) {
                    bi.fldGrpkb219.setVisibility(View.VISIBLE);

                } else {
                    bi.fldGrpkb219.setVisibility(View.GONE);
                    bi.kb21998.setChecked(false);
                    bi.kb219.setText(null);
                }
            }
        });


        bi.kb21998.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (bi.kb21998.isChecked()) {
                    bi.kb219.setText(null);
                    bi.kb219.setVisibility(View.GONE);
                } else {
                    bi.kb219.setVisibility(View.VISIBLE);
                }
            }
        });

    }


    private void SaveDraft() throws JSONException {

        JSONObject sB2 = new JSONObject();

        sB2.put("kb206", bi.kb206a.isChecked() ? "1"
                : bi.kb206b.isChecked() ? "2"
                : "0");

        sB2.put("kb207", bi.kb207a.isChecked() ? "1"
                : bi.kb207b.isChecked() ? "2"
                : bi.kb207c.isChecked() ? "3"
                : bi.kb207d.isChecked() ? "4"
                : bi.kb207e.isChecked() ? "5"
                : bi.kb207f.isChecked() ? "6"
                : bi.kb20796.isChecked() ? "96"
                : "0");

        sB2.put("kb20796x", bi.kb20796x.getText().toString());
        sB2.put("kb208", bi.kb208.getText().toString());

        sB2.put("kb209", bi.kb209a.isChecked() ? "1"
                : bi.kb209b.isChecked() ? "2"
                : bi.kb209c.isChecked() ? "3"
                : "0");


        sB2.put("kb210", bi.kb210a.isChecked() ? "1"
                : bi.kb210b.isChecked() ? "2"
                : bi.kb210c.isChecked() ? "3"
                : bi.kb210d.isChecked() ? "4"
                : bi.kb210e.isChecked() ? "5"
                : bi.kb21096.isChecked() ? "96"
                : "0");

        sB2.put("kb21096x", bi.kb21096x.getText().toString());


        sB2.put("kb211", bi.kb211a.isChecked() ? "1"
                : bi.kb211b.isChecked() ? "2"
                : bi.kb211c.isChecked() ? "3"
                : bi.kb211d.isChecked() ? "4"
                : bi.kb211e.isChecked() ? "5"
                : bi.kb211f.isChecked() ? "6"
                : bi.kb211g.isChecked() ? "7"
                : bi.kb211h.isChecked() ? "8"
                : bi.kb21196.isChecked() ? "96"
                : "0");

        sB2.put("kb21196x", bi.kb21196x.getText().toString());

        sB2.put("kb212a", bi.kb212a.isChecked() ? "1" : "0");
        sB2.put("kb212b", bi.kb212b.isChecked() ? "1" : "0");
        sB2.put("kb212c", bi.kb212c.isChecked() ? "1" : "0");
        sB2.put("kb212d", bi.kb212d.isChecked() ? "1" : "0");
        sB2.put("kb212e", bi.kb212e.isChecked() ? "1" : "0");
        sB2.put("kb212f", bi.kb212f.isChecked() ? "1" : "0");
        sB2.put("kb212g", bi.kb212g.isChecked() ? "1" : "0");
        sB2.put("kb212h", bi.kb212h.isChecked() ? "1" : "0");
        sB2.put("kb212i", bi.kb212i.isChecked() ? "1" : "0");
        sB2.put("kb21296", bi.kb21296.isChecked() ? "1" : "0");


        sB2.put("kb21296x", bi.kb21296x.getText().toString());


        sB2.put("kb213", bi.kb213a.isChecked() ? "1"
                : bi.kb213b.isChecked() ? "2"
                : bi.kb21398.isChecked() ? "98"
                : "0");


        sB2.put("kb214", bi.kb214a.isChecked() ? "1"
                : bi.kb214b.isChecked() ? "2"
                : bi.kb214c.isChecked() ? "3"
                : bi.kb21496.isChecked() ? "96"
                : "0");

        sB2.put("kb21496x", bi.kb21496x.getText().toString());


        sB2.put("kb215", bi.kb215a.isChecked() ? "1"
                : bi.kb215b.isChecked() ? "2"
                : bi.kb215c.isChecked() ? "3"
                : bi.kb215d.isChecked() ? "4"
                : bi.kb215e.isChecked() ? "5"
                : bi.kb215f.isChecked() ? "6"
                : "0");


        sB2.put("kb216", bi.kb216a.isChecked() ? "1"
                : bi.kb216b.isChecked() ? "2"
                : bi.kb216c.isChecked() ? "3"
                : bi.kb216d.isChecked() ? "4"
                : bi.kb216e.isChecked() ? "5"
                : bi.kb216f.isChecked() ? "6"
                : "0");


        sB2.put("kb217", bi.kb217a.isChecked() ? "1"
                : bi.kb217b.isChecked() ? "2"
                : bi.kb217c.isChecked() ? "3"
                : bi.kb217d.isChecked() ? "4"
                : bi.kb217e.isChecked() ? "5"
                : bi.kb217f.isChecked() ? "6"
                : "0");


        sB2.put("kb218", bi.kb218a.isChecked() ? "1"
                : bi.kb218b.isChecked() ? "2"
                : bi.kb21898.isChecked() ? "98"
                : "0");

        sB2.put("kb219", bi.kb219.getText().toString());
        sB2.put("kb21998", bi.kb21998.isChecked() ? "1" : "0");


        sB2.put("kb220", bi.kb220a.isChecked() ? "1"
                : bi.kb220b.isChecked() ? "2"
                : bi.kb220c.isChecked() ? "3"
                : bi.kb220d.isChecked() ? "4"
                : bi.kb220e.isChecked() ? "5"
                : bi.kb220f.isChecked() ? "6"
                : bi.kb220g.isChecked() ? "7"
                : bi.kb22096.isChecked() ? "96"
                : "0");


        sB2.put("kb22096x", bi.kb22096x.getText().toString());

        MainApp.fc.setsB2(String.valueOf(sB2));
    }


    private boolean formValidation() {

        if (!validatorClass.EmptyRadioButton(this, bi.kb206, bi.kb206a, getString(R.string.kb206))) {
            return false;
        }


        if (!bi.kb206a.isChecked()) {

            if (!validatorClass.EmptyRadioButton(this, bi.kb207, bi.kb207a, getString(R.string.kb207))) {
                return false;
            }


            if (bi.kb20796.isChecked()) {

                if (!validatorClass.EmptyTextBox(this, bi.kb20796x, getString(R.string.other))) {
                    return false;
                }
            }

        }


        if (!validatorClass.EmptyTextBox(this, bi.kb208, getString(R.string.kb208))) {
            return false;
        }


        if (!validatorClass.EmptyRadioButton(this, bi.kb209, bi.kb209a, getString(R.string.kb209))) {
            return false;
        }


        if (!validatorClass.EmptyRadioButton(this, bi.kb210, bi.kb210a, getString(R.string.kb210))) {
            return false;
        }


        if (bi.kb21096.isChecked()) {

            if (!validatorClass.EmptyTextBox(this, bi.kb21096x, getString(R.string.other))) {
                return false;
            }
        }


        if (!validatorClass.EmptyRadioButton(this, bi.kb211, bi.kb211a, getString(R.string.kb211))) {
            return false;
        }


        if (bi.kb21196.isChecked()) {

            if (!validatorClass.EmptyTextBox(this, bi.kb21196x, getString(R.string.other))) {
                return false;
            }
        }


        if (!validatorClass.EmptyCheckBox(this, bi.kb212, bi.kb212a, getString(R.string.kb212))) {
            return false;
        }


        if (bi.kb21296.isChecked()) {

            if (!validatorClass.EmptyTextBox(this, bi.kb21296x, getString(R.string.other))) {
                return false;
            }
        }


        if (!validatorClass.EmptyRadioButton(this, bi.kb213, bi.kb213a, getString(R.string.kb213))) {
            return false;
        }


        if (bi.kb213a.isChecked()) {

            if (!validatorClass.EmptyRadioButton(this, bi.kb214, bi.kb214a, getString(R.string.kb214))) {
                return false;
            }


            if (bi.kb21496.isChecked()) {

                if (!validatorClass.EmptyTextBox(this, bi.kb21496x, getString(R.string.other))) {
                    return false;
                }
            }


            if (!validatorClass.EmptyRadioButton(this, bi.kb215, bi.kb215a, getString(R.string.kb215))) {
                return false;
            }


            if (!validatorClass.EmptyRadioButton(this, bi.kb216, bi.kb216a, getString(R.string.kb216))) {
                return false;
            }


            if (!validatorClass.EmptyRadioButton(this, bi.kb217, bi.kb217a, getString(R.string.kb217))) {
                return false;
            }

        }


        if (!validatorClass.EmptyRadioButton(this, bi.kb218, bi.kb218a, getString(R.string.kb218))) {
            return false;
        }


        if (bi.kb218a.isChecked()) {

            if (!bi.kb21998.isChecked()) {
                if (!validatorClass.EmptyTextBox(this, bi.kb219, getString(R.string.kb219))) {
                    return false;
                }
            }

        }


        if (!validatorClass.EmptyRadioButton(this, bi.kb220, bi.kb220a, getString(R.string.kb220))) {
            return false;
        }


        if (bi.kb22096.isChecked()) {

            if (!validatorClass.EmptyTextBox(this, bi.kb22096x, getString(R.string.other))) {
                return false;
            }
        }


        return true;
    }


    public void BtnEnd() {

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
        }
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

                startActivity(new Intent(this, SectionC1Activity.class));

            } else {
                Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
            }
        }
    }


    private boolean UpdateDB() {

        //Long rowId;
        DatabaseHelper db = new DatabaseHelper(this);

        int updcount = db.updateSB2();

        if (updcount == 1) {
            //Toast.makeText(this, "Updating Database... Successful!", Toast.LENGTH_SHORT).show();
            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }
    }

}
