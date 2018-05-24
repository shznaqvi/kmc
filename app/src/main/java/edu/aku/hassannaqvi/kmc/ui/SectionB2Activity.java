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
import java.util.Calendar;
import java.util.Date;

import edu.aku.hassannaqvi.kmc.R;
import edu.aku.hassannaqvi.kmc.core.DatabaseHelper;
import edu.aku.hassannaqvi.kmc.core.MainApp;
import edu.aku.hassannaqvi.kmc.databinding.ActivitySectionB2Binding;
import edu.aku.hassannaqvi.kmc.validation.validatorClass;

public class SectionB2Activity extends AppCompatActivity {
    ActivitySectionB2Binding bi;
    DatabaseHelper db;

    String dateToday = new SimpleDateFormat("dd/MM/yyyy").format(new Date().getTime());
    String lmpDate = new SimpleDateFormat("dd/MM/yyyy").format(Calendar.getInstance().getTimeInMillis() -
            ((MainApp.MILLISECONDS_IN_9MONTH) + MainApp.MILLISECONDS_IN_DAY));

    String eddDate = new SimpleDateFormat("dd/MM/yyyy").format(Calendar.getInstance().getTimeInMillis() +
            ((MainApp.MILLISECONDS_IN_9MONTH) + MainApp.MILLISECONDS_IN_DAY));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_b2);
        db = new DatabaseHelper(this);
        bi.setCallback(this);


        bi.kb204.setManager(getSupportFragmentManager());
        bi.kb204.setMinDate(lmpDate);
        bi.kb204.setMaxDate(dateToday);


        bi.kb205lmp.setManager(getSupportFragmentManager());
        bi.kb205lmp.setMinDate(lmpDate);
        bi.kb205lmp.setMaxDate(dateToday);

        bi.kb205rec.setManager(getSupportFragmentManager());
        bi.kb205rec.setMinDate(dateToday);
        bi.kb205rec.setMaxDate(eddDate);

        bi.kb205edd.setManager(getSupportFragmentManager());
        bi.kb205edd.setMinDate(dateToday);
        bi.kb205edd.setMaxDate(eddDate);

        bi.kb205lmp.setDate(Calendar.getInstance());
        bi.kb205rec.setDate(Calendar.getInstance());
        bi.kb205edd.setDate(Calendar.getInstance());


        setupViews();
    }

    private void setupViews() {


        bi.kb201.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (bi.kb201b.isChecked()) {

                    bi.kb202w.setText(null);
                    bi.kb202m.setText(null);
                    bi.kb204.setText(null);
                    bi.kb203.clearCheck();


                    bi.kb206.clearCheck();
                    bi.kb207a.setChecked(false);
                    bi.kb207b.setChecked(false);
                    bi.kb207c.setChecked(false);
                    bi.kb207d.setChecked(false);
                    bi.kb207e.setChecked(false);
                    bi.kb207f.setChecked(false);
                    bi.kb20796.setChecked(false);
                    bi.kb20796x.setText(null);

                    bi.kb208.setText(null);
                    bi.kb209.clearCheck();
                    bi.kb210.clearCheck();
                    bi.kb21096x.setText(null);


                    bi.kb211.clearCheck();

                    /*bi.kb211a.setChecked(false);
                    bi.kb211b.setChecked(false);
                    bi.kb211c.setChecked(false);
                    bi.kb211d.setChecked(false);
                    bi.kb211e.setChecked(false);
                    bi.kb211f.setChecked(false);
                    bi.kb211g.setChecked(false);
                    bi.kb211h.setChecked(false);
                    bi.kb21196.setChecked(false);*/

                    bi.kb21196x.setText(null);

                    bi.kb212a.setChecked(false);
                    bi.kb212b.setChecked(false);
                    bi.kb212c.setChecked(false);
                    bi.kb212d.setChecked(false);
                    bi.kb212e.setChecked(false);
                    bi.kb212f.setChecked(false);
                    bi.kb212g.setChecked(false);
                    bi.kb212h.setChecked(false);
                    bi.kb212i.setChecked(false);
                    bi.kb21296.setChecked(false);
                    bi.kb21296x.setText(null);

                    bi.kb213.clearCheck();

                    bi.kb214a.setChecked(false);
                    bi.kb214b.setChecked(false);
                    bi.kb214c.setChecked(false);
                    bi.kb21496.setChecked(false);
                    bi.kb21496x.setText(null);

                    bi.kb215.clearCheck();
                    bi.kb216.clearCheck();
                    bi.kb217.clearCheck();
                    bi.kb218.clearCheck();
                    bi.kb219.setText(null);
                    bi.kb21998.setChecked(false);

                    bi.kb220.clearCheck();
                    bi.kb22096x.setText(null);


                    bi.fldGrpkb201.setVisibility(View.GONE);
                    bi.fldGrpkb202.setVisibility(View.GONE);
                    bi.fldGrpSecB2.setVisibility(View.GONE);

                } else if (bi.kb20198.isChecked()) {

                    bi.kb202w.setText(null);
                    bi.kb202m.setText(null);

                    bi.fldGrpkb202.setVisibility(View.GONE);
                    bi.fldGrpkb201.setVisibility(View.VISIBLE);
                    bi.fldGrpSecB2.setVisibility(View.VISIBLE);

                } else {
                    bi.fldGrpkb201.setVisibility(View.VISIBLE);
                    bi.fldGrpkb202.setVisibility(View.VISIBLE);
                    bi.fldGrpSecB2.setVisibility(View.VISIBLE);
                }
            }
        });


        bi.kb203.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (bi.kb203a.isChecked()) {
                    bi.kb205lmp.setVisibility(View.VISIBLE);
                    bi.kb205edd.setVisibility(View.VISIBLE);

                    bi.kb205rec.setText(null);
                    bi.kb205rec.setVisibility(View.GONE);

                } else {
                    bi.kb205lmp.setVisibility(View.VISIBLE);
                    bi.kb205rec.setVisibility(View.VISIBLE);

                    bi.kb205edd.setText(null);
                    bi.kb205edd.setVisibility(View.GONE);
                }
            }
        });

        bi.kb206.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.kb206a) {
                    bi.fldGrpkb207.setVisibility(View.GONE);
                    bi.fldGrkb208.setVisibility(View.VISIBLE);

                    bi.kb207a.setChecked(false);
                    bi.kb207b.setChecked(false);
                    bi.kb207c.setChecked(false);
                    bi.kb207d.setChecked(false);
                    bi.kb207e.setChecked(false);
                    bi.kb207f.setChecked(false);
                    bi.kb20796.setChecked(false);

                    bi.kb20796x.setText(null);

                } else if (checkedId == R.id.kb206b) {
                    bi.fldGrpkb207.setVisibility(View.VISIBLE);
                    bi.fldGrkb208.setVisibility(View.GONE);
                    bi.kb208.setText(null);
                    bi.kb209.clearCheck();
                    bi.kb210.clearCheck();
                    bi.kb21096x.setText(null);

                    bi.kb211.clearCheck();

                    /*bi.kb211a.setChecked(false);
                    bi.kb211b.setChecked(false);
                    bi.kb211c.setChecked(false);
                    bi.kb211d.setChecked(false);
                    bi.kb211e.setChecked(false);
                    bi.kb211f.setChecked(false);
                    bi.kb211g.setChecked(false);
                    bi.kb211h.setChecked(false);
                    bi.kb21196.setChecked(false);*/


                    bi.kb21196x.setText(null);
                    bi.kb212a.setChecked(false);
                    bi.kb212b.setChecked(false);
                    bi.kb212c.setChecked(false);
                    bi.kb212d.setChecked(false);
                    bi.kb212e.setChecked(false);
                    bi.kb212f.setChecked(false);
                    bi.kb212g.setChecked(false);
                    bi.kb212h.setChecked(false);
                    bi.kb212i.setChecked(false);
                    bi.kb21296.setChecked(false);
                    bi.kb21296x.setText(null);
                    bi.kb213.clearCheck();

                    bi.kb214a.setChecked(false);
                    bi.kb214b.setChecked(false);
                    bi.kb214c.setChecked(false);
                    bi.kb21496.setChecked(false);

                    bi.kb21496x.setText(null);
                    bi.kb215.clearCheck();
                    bi.kb216.clearCheck();
                    bi.kb217.clearCheck();
                    bi.kb218.clearCheck();
                    bi.kb219.setText(null);
                    bi.kb21998.setChecked(false);
                    bi.kb220.clearCheck();
                    bi.kb22096x.setText(null);
                }
            }
        });

        bi.kb213.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.kb213a) {
                    bi.fldGrpkb214.setVisibility(View.VISIBLE);

                } else {
                    bi.fldGrpkb214.setVisibility(View.GONE);

                    bi.kb214a.setChecked(false);
                    bi.kb214b.setChecked(false);
                    bi.kb214c.setChecked(false);
                    bi.kb21496.setChecked(false);

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
                if (checkedId == R.id.kb218a) {
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


        sB2.put("kb101", bi.kb101.getText().toString());


        sB2.put("kb201", bi.kb201a.isChecked() ? "1"
                : bi.kb201b.isChecked() ? "2"
                : bi.kb20198.isChecked() ? "98"
                : "0");

        sB2.put("kb202w", bi.kb202w.getText().toString());
        sB2.put("kb202m", bi.kb202m.getText().toString());


        sB2.put("kb204", bi.kb204.getText().toString());

        sB2.put("kb203", bi.kb203a.isChecked() ? "1"
                : bi.kb203b.isChecked() ? "2"
                : "0");


        sB2.put("kb205lmp", bi.kb205lmp.getText().toString());
        sB2.put("kb205rec", bi.kb205rec.getText().toString());
        sB2.put("kb205edd", bi.kb205edd.getText().toString());


        sB2.put("kb206", bi.kb206a.isChecked() ? "1"
                : bi.kb206b.isChecked() ? "2"
                : "0");


        sB2.put("kb212a", bi.kb212a.isChecked() ? "1" : "0");


        sB2.put("kb207a", bi.kb207a.isChecked() ? "1" : "0");
        sB2.put("kb207b", bi.kb207b.isChecked() ? "2" : "0");
        sB2.put("kb207c", bi.kb207c.isChecked() ? "3" : "0");
        sB2.put("kb207d", bi.kb207d.isChecked() ? "4" : "0");
        sB2.put("kb207e", bi.kb207e.isChecked() ? "5" : "0");
        sB2.put("kb207f", bi.kb207f.isChecked() ? "6" : "0");
        sB2.put("kb20796", bi.kb20796.isChecked() ? "96" : "0");


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
                : bi.kb210f.isChecked() ? "6"
                : bi.kb210g.isChecked() ? "7"
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


        /*sB2.put("kb211a", bi.kb211a.isChecked() ? "1" : "0");
        sB2.put("kb211b", bi.kb211b.isChecked() ? "2" : "0");
        sB2.put("kb211c", bi.kb211c.isChecked() ? "3" : "0");
        sB2.put("kb211d", bi.kb211d.isChecked() ? "4" : "0");
        sB2.put("kb211e", bi.kb211e.isChecked() ? "5" : "0");
        sB2.put("kb211f", bi.kb211f.isChecked() ? "6" : "0");
        sB2.put("kb211g", bi.kb211g.isChecked() ? "7" : "0");
        sB2.put("kb211h", bi.kb211h.isChecked() ? "8" : "0");
        sB2.put("kb21196", bi.kb21196.isChecked() ? "96" : "0");
        */

        sB2.put("kb21196x", bi.kb21196x.getText().toString());

        sB2.put("kb212a", bi.kb212a.isChecked() ? "1" : "0");
        sB2.put("kb212b", bi.kb212b.isChecked() ? "2" : "0");
        sB2.put("kb212c", bi.kb212c.isChecked() ? "3" : "0");
        sB2.put("kb212d", bi.kb212d.isChecked() ? "4" : "0");
        sB2.put("kb212e", bi.kb212e.isChecked() ? "5" : "0");
        sB2.put("kb212f", bi.kb212f.isChecked() ? "6" : "0");
        sB2.put("kb212g", bi.kb212g.isChecked() ? "7" : "0");
        sB2.put("kb212h", bi.kb212h.isChecked() ? "8" : "0");
        sB2.put("kb212i", bi.kb212i.isChecked() ? "9" : "0");
        sB2.put("kb21296", bi.kb21296.isChecked() ? "96" : "0");


        sB2.put("kb21296x", bi.kb21296x.getText().toString());


        sB2.put("kb213", bi.kb213a.isChecked() ? "1"
                : bi.kb213b.isChecked() ? "2"
                : bi.kb21398.isChecked() ? "98"
                : "0");


        sB2.put("kb214a", bi.kb214a.isChecked() ? "1" : "0");
        sB2.put("kb214b", bi.kb214b.isChecked() ? "2" : "0");
        sB2.put("kb214c", bi.kb214c.isChecked() ? "3" : "0");
        sB2.put("kb21496", bi.kb21496.isChecked() ? "96" : "0");


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


        if (!validatorClass.EmptyTextBox(this, bi.kb101, getString(R.string.kb101))) {
            return false;
        }


        if (!validatorClass.RangeTextBox(this, bi.kb101, 1, 15, getString(R.string.kb101), "Number")) {
            return false;
        }


        if (!validatorClass.EmptyRadioButton(this, bi.kb201, bi.kb201a, getString(R.string.kb201))) {
            return false;
        }

        if (!bi.kb201b.isChecked()) {

            if (!bi.kb20198.isChecked()) {

                if (!validatorClass.EmptyTextBox(this, bi.kb202w, getString(R.string.weeks))) {
                    return false;
                }


                if (!validatorClass.RangeTextBox(this, bi.kb202w, 0, 3, getString(R.string.weeks), "weeks")) {
                    return false;
                }


                if (!validatorClass.EmptyTextBox(this, bi.kb202m, getString(R.string.months))) {
                    return false;
                }


                if (!validatorClass.RangeTextBox(this, bi.kb202m, 0, 9, getString(R.string.months), "months")) {
                    return false;
                }

            }


            if (!validatorClass.EmptyTextBox(this, bi.kb204, getString(R.string.kb204))) {
                return false;
            }


            if (!validatorClass.EmptyRadioButton(this, bi.kb203, bi.kb203a, getString(R.string.kb203))) {
                return false;
            }


            if (bi.kb203a.isChecked()) {

                if (!validatorClass.EmptyTextBox(this, bi.kb205lmp, getString(R.string.kb205a))) {
                    return false;
                }

                if (!validatorClass.EmptyTextBox(this, bi.kb205edd, getString(R.string.kb205c))) {
                    return false;
                }

            } else if (bi.kb203b.isChecked()) {

                if (!validatorClass.EmptyTextBox(this, bi.kb205lmp, getString(R.string.kb205a))) {
                    return false;
                }


                if (!validatorClass.EmptyTextBox(this, bi.kb205rec, getString(R.string.kb205b))) {
                    return false;
                }
            }
        }


        if (!bi.kb201b.isChecked()) {

            if (!validatorClass.EmptyRadioButton(this, bi.kb206, bi.kb206a, getString(R.string.kb206))) {
                return false;
            }


            if (!bi.kb206a.isChecked()) {

                if (!validatorClass.EmptyCheckBox(this, bi.fldGrpkb207, bi.kb207a, getString(R.string.kb207))) {
                    return false;
                }


                if (bi.kb20796.isChecked()) {

                    if (!validatorClass.EmptyTextBox(this, bi.kb20796x, getString(R.string.other))) {
                        return false;
                    }
                }

            } else {


                if (!validatorClass.EmptyTextBox(this, bi.kb208, getString(R.string.kb208))) {
                    return false;
                }


                if (!validatorClass.RangeTextBox(this, bi.kb208, 1, 15, getString(R.string.kb208), "Number")) {
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

                    if (!validatorClass.EmptyCheckBox(this, bi.fldGrkb213, bi.kb214a, getString(R.string.kb214))) {
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


                        if (!validatorClass.RangeTextBox(this, bi.kb219, 1, 5, getString(R.string.kb219), "Number")) {
                            return false;
                        }

                    }

                }


                if (!validatorClass.EmptyRadioButton(this, bi.kb220, bi.kb220a, getString(R.string.kb220))) {
                    return false;
                }


                if (bi.kb22096.isChecked()) {

                    return validatorClass.EmptyTextBox(this, bi.kb22096x, getString(R.string.other));
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

                startActivity(new Intent(this, SectionC1Activity.class));
                //startActivity(new Intent(this, MainActivity.class));

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

    @Override
    public void onBackPressed() {
        Toast.makeText(getApplicationContext(), "You Can't go back", Toast.LENGTH_LONG).show();
    }

}