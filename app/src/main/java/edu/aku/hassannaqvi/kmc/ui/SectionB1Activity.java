package edu.aku.hassannaqvi.kmc.ui;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
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
import edu.aku.hassannaqvi.kmc.databinding.ActivitySectionB1Binding;
import edu.aku.hassannaqvi.kmc.validation.validatorClass;

public class SectionB1Activity extends AppCompatActivity {

    ActivitySectionB1Binding bi;
    String dateToday = new SimpleDateFormat("dd/MM/yyyy").format(new Date().getTime());
    String lmpDate = new SimpleDateFormat("dd/MM/yyyy").format(Calendar.getInstance().getTimeInMillis() -
            ((MainApp.MILLISECONDS_IN_9MONTH) + MainApp.MILLISECONDS_IN_DAY));

    String eddDate = new SimpleDateFormat("dd/MM/yyyy").format(Calendar.getInstance().getTimeInMillis() +
            ((MainApp.MILLISECONDS_IN_9MONTH) + MainApp.MILLISECONDS_IN_DAY));


    @Override
    protected void onCreate(Bundle savedInstanceState) {
       /* super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_b1);
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

        setupView();*/
    }

    /*private void setupView() {

        *//*bi.kb101.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
  *//**//*              if(Integer.valueOf(bi.kb102.getText().toString()) == 0){
                    bi.fldGrpkb101.setVisibility(View.GONE);
//                    clearing edit texts
                    bi.kb202w.setText("0");
                    bi.kb202m.setText("0");
                    bi.kb203.clearCheck();
                    bi.kb204.setText(null);
                    bi.kb205.setText(null);
                }
                else{
                    bi.fldGrpkb101.setVisibility(View.VISIBLE);
                }
*//**//*
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });*//*


        bi.kb201.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (bi.kb201b.isChecked()) {

                    bi.kb202w.setText(null);
                    bi.kb202m.setText(null);
                    bi.kb204.setText(null);
                    bi.kb203.clearCheck();

                    bi.fldGrpkb201.setVisibility(View.GONE);
                    bi.fldGrpkb202.setVisibility(View.GONE);

                } else if (bi.kb20198.isChecked()) {

                    bi.kb202w.setText(null);
                    bi.kb202m.setText(null);

                    bi.fldGrpkb202.setVisibility(View.GONE);
                    bi.fldGrpkb201.setVisibility(View.VISIBLE);

                } else {
                    bi.fldGrpkb201.setVisibility(View.VISIBLE);
                    bi.fldGrpkb202.setVisibility(View.VISIBLE);
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


    }*/


    private void SaveDraft() throws JSONException {

        /*JSONObject sB1 = new JSONObject();

        sB1.put("kb101", bi.kb101.getText().toString());


        sB1.put("kb201", bi.kb201a.isChecked() ? "1"
                : bi.kb201b.isChecked() ? "2"
                : bi.kb20198.isChecked() ? "98"
                : "0");

        sB1.put("kb202w", bi.kb202w.getText().toString());
        sB1.put("kb202m", bi.kb202m.getText().toString());


        sB1.put("kb204", bi.kb204.getText().toString());

        sB1.put("kb203", bi.kb203a.isChecked() ? "1"
                : bi.kb203b.isChecked() ? "2"
                : "0");


        sB1.put("kb205lmp", bi.kb205lmp.getText().toString());
        sB1.put("kb205rec", bi.kb205rec.getText().toString());
        sB1.put("kb205edd", bi.kb205edd.getText().toString());

        MainApp.fc.setsB1(String.valueOf(sB1));*/

    }


    private boolean formValidation() {

        /*if (!validatorClass.EmptyTextBox(this, bi.kb101, getString(R.string.kb101))) {
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
        }*/

        return true;
    }


    public void BtnEnd() {

        /*Toast.makeText(this, "Processing End Section", Toast.LENGTH_SHORT).show();
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
        }*/
        //}
    }

    public void BtnContinue() {

        /*Toast.makeText(this, "Processing This Section", Toast.LENGTH_SHORT).show();
        if (formValidation()) {
            try {
                SaveDraft();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (UpdateDB()) {
                Toast.makeText(this, "Starting Ending Section", Toast.LENGTH_SHORT).show();

                finish();

                startActivity(new Intent(this, SectionB2Activity.class));
                //startActivity(new Intent(this, MainActivity.class));

            } else {
                Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
            }
        }*/
    }


    private boolean UpdateDB() {

       /* //Long rowId;
        DatabaseHelper db = new DatabaseHelper(this);

        int updcount = db.updateSB1();

        if (updcount == 1) {
            //Toast.makeText(this, "Updating Database... Successful!", Toast.LENGTH_SHORT).show();
            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }*/

       return true;
    }

    @Override
    public void onBackPressed() {
        Toast.makeText(getApplicationContext(), "You Can't go back", Toast.LENGTH_LONG).show();
    }
}