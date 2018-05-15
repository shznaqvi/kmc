package edu.aku.hassannaqvi.kmc.ui;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import butterknife.BindViews;
import butterknife.ButterKnife;
import edu.aku.hassannaqvi.kmc.R;
import edu.aku.hassannaqvi.kmc.core.DatabaseHelper;
import edu.aku.hassannaqvi.kmc.core.MainApp;
import edu.aku.hassannaqvi.kmc.databinding.ActivitySectionFBinding;
import io.blackbox_vision.datetimepickeredittext.view.DatePickerInputEditText;

public class SectionFActivity extends AppCompatActivity {

    private static final String TAG = SectionFActivity.class.getSimpleName();
    final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    ActivitySectionFBinding bi;
    String dateToday;
    String maxDateyear;
    String maxDate5Years;
    String maxDate49Years;
    String maxDate15Years;
    Calendar now = Calendar.getInstance();


    @BindViews({R.id.bd03dob1, R.id.bd03dob2, R.id.bd03dob3,
            R.id.bd03dob4, R.id.bd03dob5, R.id.bd04dob1, R.id.bd04dob2, R.id.bd04dod1, R.id.bd04dod2, R.id.bd05dob1,
            R.id.bd05dob2, R.id.bd05dod1, R.id.bd05dod2, R.id.bd06dob1, R.id.bd06dob2, R.id.bd06dod1, R.id.bd06dod2
    })
    List<DatePickerInputEditText> bddates;

    @BindViews({R.id.bd04dod1, R.id.bd04dod2, R.id.bd05dod1,
            R.id.bd05dod2, R.id.bd06dod1, R.id.bd06dod2})
    List<DatePickerInputEditText> bddateofDeath;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_section_f);

        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_f);
        bi.setCallback(this);
        ButterKnife.bind(this);

        Calendar c = Calendar.getInstance();

        dateToday = new SimpleDateFormat("dd/MM/yyyy").format(System.currentTimeMillis());
        maxDateyear = new SimpleDateFormat("dd/MM/yyyy").format(Calendar.getInstance().getTimeInMillis() - ((MainApp.MILLISECONDS_IN_YEAR) + MainApp.MILLISECONDS_IN_DAY));
        maxDate5Years = new SimpleDateFormat("dd/MM/yyyy").format(c.getTimeInMillis() - ((MainApp.MILLISECONDS_IN_5Years) + MainApp.MILLISECONDS_IN_DAY));
        //maxDate49Years = new SimpleDateFormat("dd/MM/yyyy").format(c.getTimeInMillis() - (MainApp.MILLISECONDS_IN_49Years));
        // maxDate15Years = new SimpleDateFormat("dd/MM/yyyy").format(c.getTimeInMillis() - (AppMain.MILLISECONDS_IN_15Years));

        for (DatePickerInputEditText de : bddates) {
            de.setManager(getSupportFragmentManager());
            de.setMaxDate(dateToday);
            de.setMinDate(maxDateyear);

        }

        bi.bd05dob1.setMaxDate(new SimpleDateFormat("dd/MM/yyyy").format(c.getTimeInMillis() - (MainApp.MILLISECONDS_IN_8Days)));
        bi.bd05dob2.setMaxDate(new SimpleDateFormat("dd/MM/yyyy").format(c.getTimeInMillis() - (MainApp.MILLISECONDS_IN_8Days)));
        bi.bd06dob1.setMaxDate(new SimpleDateFormat("dd/MM/yyyy").format(c.getTimeInMillis() - (MainApp.MILLISECONDS_IN_DAY) * 29));
        bi.bd06dob2.setMaxDate(new SimpleDateFormat("dd/MM/yyyy").format(c.getTimeInMillis() - (MainApp.MILLISECONDS_IN_DAY) * 29));


        bi.bd04dob1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                bi.bd04dod1.setText(null);
            }

            @Override
            public void afterTextChanged(Editable s) {

                final Calendar todayCal = Calendar.getInstance();
                todayCal.add(Calendar.DAY_OF_MONTH, -7);
                Calendar selectedDate = getCalendarDate(bi.bd04dob1.getText().toString());
                bi.bd04dod1.setMinDate(convertDateFormat(bi.bd04dob1.getText().toString()));
                if (selectedDate.after(todayCal)) {
                    bi.bd04dod1.setMaxDate(dateToday);
                } else {
                    selectedDate.add(Calendar.DAY_OF_MONTH, 7);
                    bi.bd04dod1.setMaxDate(sdf.format(selectedDate.getTime()));
                    bi.bd04dod1.setEnabled(true);
                }


            }
        });

        bi.bd04dob2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                bi.bd04dod2.setText(null);
            }

            @Override
            public void afterTextChanged(Editable s) {

                final Calendar todayCal = Calendar.getInstance();
                todayCal.add(Calendar.DAY_OF_MONTH, -7);
                Calendar selectedDate = getCalendarDate(bi.bd04dob2.getText().toString());
                bi.bd04dod2.setMinDate(convertDateFormat(bi.bd04dob2.getText().toString()));
                if (selectedDate.after(todayCal)) {
                    bi.bd04dod2.setMaxDate(dateToday);
                } else {
                    selectedDate.add(Calendar.DAY_OF_MONTH, 7);
                    bi.bd04dod2.setMaxDate(sdf.format(selectedDate.getTime()));
                    bi.bd04dod2.setEnabled(true);
                }


            }
        });

        bi.bd05dob1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                bi.bd05dod1.setText(null);
            }

            @Override
            public void afterTextChanged(Editable s) {


                final Calendar todayCal = Calendar.getInstance();
                todayCal.add(Calendar.DAY_OF_MONTH, -8);
                Calendar selectedDate = getCalendarDate(bi.bd05dob1.getText().toString());
                selectedDate.add(Calendar.DAY_OF_MONTH, 8);
                bi.bd05dod1.setMinDate(sdf.format(selectedDate.getTime()));

                if (selectedDate.after(todayCal)) {
                    bi.bd05dod1.setMaxDate(dateToday);
                } else {
                    selectedDate.add(Calendar.DAY_OF_MONTH, 20);
                    bi.bd05dod1.setMaxDate(sdf.format(selectedDate.getTime()));
                    bi.bd05dod1.setEnabled(true);
                }


            }
        });

        bi.bd05dob2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                bi.bd05dod2.setText(null);

            }

            @Override
            public void afterTextChanged(Editable s) {

                final Calendar todayCal = Calendar.getInstance();
                todayCal.add(Calendar.DAY_OF_MONTH, -8);
                Calendar selectedDate = getCalendarDate(bi.bd05dob2.getText().toString());
                selectedDate.add(Calendar.DAY_OF_MONTH, 8);
                bi.bd05dod2.setMinDate(sdf.format(selectedDate.getTime()));
                if (selectedDate.after(todayCal)) {
                    bi.bd05dod2.setMaxDate(dateToday);
                } else {
                    selectedDate.add(Calendar.DAY_OF_MONTH, 20);
                    bi.bd05dod2.setMaxDate(sdf.format(selectedDate.getTime()));
                    bi.bd05dod2.setEnabled(true);
                }


            }
        });

        bi.bd06dob1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                bi.bd06dod1.setText(null);

            }

            @Override
            public void afterTextChanged(Editable s) {

                String birthDateStr = bi.bd06dob1.getText().toString();

                Calendar minDeathCal = getCalendarDate(birthDateStr);
                minDeathCal.add(Calendar.DAY_OF_MONTH, 29);
                bi.bd06dod1.setMinDate(sdf.format(minDeathCal.getTime()));
                Calendar maxDeathCal = getCalendarDate(birthDateStr);
                maxDeathCal.add(Calendar.DAY_OF_YEAR, 334);

                // If today is less than max, set maximum to today
                Calendar todayCal = Calendar.getInstance();
                if (todayCal.before(maxDeathCal)) {
                    bi.bd06dod1.setMaxDate(dateToday);
                } else {
                    // If today is greater than max
                    bi.bd06dod1.setMaxDate(dateToday);
                }


            }
        });


        bi.bd06dob2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                bi.bd06dod2.setText(null);
            }

            @Override
            public void afterTextChanged(Editable s) {


                String birthDateStr = bi.bd06dob2.getText().toString();

                Calendar minDeathCal = getCalendarDate(birthDateStr);
                minDeathCal.add(Calendar.DAY_OF_MONTH, 29);
                bi.bd06dod2.setMinDate(sdf.format(minDeathCal.getTime()));
                Calendar maxDeathCal = getCalendarDate(birthDateStr);
                maxDeathCal.add(Calendar.DAY_OF_YEAR, 334);

                // If today is less than max, set maximum to today
                Calendar todayCal = Calendar.getInstance();
                if (todayCal.before(maxDeathCal)) {
                    bi.bd06dod2.setMaxDate(dateToday);
                } else {
                    // If today is greater than max
                    bi.bd06dod2.setMaxDate(dateToday);
                }

            }
        });

        bi.bd03s.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if (Integer.valueOf(bi.bd03s.getText().toString().isEmpty() ? "0" : bi.bd03s.getText().toString()) == 0) {
                    bi.fldGrpbd03.setVisibility(View.GONE);
                    bi.bd03dob1.setText(null);
                    bi.bd03dob2.setText(null);
                    bi.bd03dob3.setText(null);
                    bi.bd03dob4.setText(null);
                    bi.bd03dob5.setText(null);
                } else {
                    bi.fldGrpbd03.setVisibility(View.VISIBLE);

                }

                if (Integer.valueOf(bi.bd03s.getText().toString().isEmpty() ? "0" : bi.bd03s.getText().toString()) == 1) {
                    bi.fldGrpbd03.setVisibility(View.VISIBLE);
                    bi.bd03dob2.setVisibility(View.GONE);
                    bi.bd03dob3.setVisibility(View.GONE);
                    bi.bd03dob2.setText(null);
                    bi.bd03dob3.setText(null);
                    bi.bd03dob4.setVisibility(View.GONE);
                    bi.bd03dob4.setText(null);
                    bi.bd03dob5.setVisibility(View.GONE);
                    bi.bd03dob5.setText(null);
                } else if (Integer.valueOf(bi.bd03s.getText().toString().isEmpty() ? "0" : bi.bd03s.getText().toString()) == 2) {
                    bi.fldGrpbd03.setVisibility(View.VISIBLE);
                    bi.bd03dob1.setVisibility(View.VISIBLE);
                    bi.bd03dob2.setVisibility(View.VISIBLE);
                    bi.bd03dob3.setVisibility(View.GONE);
                    bi.bd03dob3.setText(null);
                    bi.bd03dob4.setVisibility(View.GONE);
                    bi.bd03dob4.setText(null);
                    bi.bd03dob5.setVisibility(View.GONE);
                    bi.bd03dob5.setText(null);
                } else if (Integer.valueOf(bi.bd03s.getText().toString().isEmpty() ? "0" : bi.bd03s.getText().toString()) == 3) {
                    bi.fldGrpbd03.setVisibility(View.VISIBLE);
                    bi.bd03dob1.setVisibility(View.VISIBLE);
                    bi.bd03dob2.setVisibility(View.VISIBLE);
                    bi.bd03dob3.setVisibility(View.VISIBLE);
                    bi.bd03dob4.setVisibility(View.GONE);
                    bi.bd03dob4.setText(null);
                    bi.bd03dob5.setVisibility(View.GONE);
                    bi.bd03dob5.setText(null);
                } else if (Integer.valueOf(bi.bd03s.getText().toString().isEmpty() ? "0" : bi.bd03s.getText().toString()) == 4) {
                    bi.fldGrpbd03.setVisibility(View.VISIBLE);
                    bi.bd03dob1.setVisibility(View.VISIBLE);
                    bi.bd03dob2.setVisibility(View.VISIBLE);
                    bi.bd03dob3.setVisibility(View.VISIBLE);
                    bi.bd03dob4.setVisibility(View.VISIBLE);
                    bi.bd03dob5.setVisibility(View.GONE);
                    bi.bd03dob5.setText(null);
                } else if (Integer.valueOf(bi.bd03s.getText().toString().isEmpty() ? "0" : bi.bd03s.getText().toString()) == 5) {
                    bi.fldGrpbd03.setVisibility(View.VISIBLE);
                    bi.bd03dob1.setVisibility(View.VISIBLE);
                    bi.bd03dob2.setVisibility(View.VISIBLE);
                    bi.bd03dob3.setVisibility(View.VISIBLE);
                    bi.bd03dob4.setVisibility(View.VISIBLE);
                    bi.bd03dob5.setVisibility(View.VISIBLE);
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        //=================== Q4 Skip Pattern

        bi.bd04s.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if (Integer.valueOf(bi.bd04s.getText().toString().isEmpty() ? "0" : bi.bd04s.getText().toString()) == 0) {
                    bi.fldGrpbd04.setVisibility(View.GONE);
                    bi.bd04dob2.setText(null);
                    bi.bd04dod2.setText(null);
                    bi.bd04dob1.setText(null);
                    bi.bd04dod1.setText(null);
                } else if (Integer.valueOf(bi.bd04s.getText().toString().isEmpty() ? "0" : bi.bd04s.getText().toString()) == 1) {
                    bi.fldGrpbd04.setVisibility(View.VISIBLE);
                    bi.fldGrpbd04dob2.setVisibility(View.GONE);
                    bi.bd04dob2.setText(null);
                    bi.bd04dod2.setText(null);
                } else if (Integer.valueOf(bi.bd04s.getText().toString().isEmpty() ? "0" : bi.bd04s.getText().toString()) == 2) {
                    bi.fldGrpbd04.setVisibility(View.VISIBLE);
                    bi.fldGrpbd04dob2.setVisibility(View.VISIBLE);
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        //=================== Q5 Skip Pattern

        bi.bd05s.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if (Integer.valueOf(bi.bd05s.getText().toString().isEmpty() ? "0" : bi.bd05s.getText().toString()) == 0) {
                    bi.fldGrpbd05.setVisibility(View.GONE);
                    bi.bd05dob2.setText(null);
                    bi.bd05dod2.setText(null);
                    bi.bd05dob1.setText(null);
                    bi.bd05dod1.setText(null);
                } else if (Integer.valueOf(bi.bd05s.getText().toString().isEmpty() ? "0" : bi.bd05s.getText().toString()) == 1) {
                    bi.fldGrpbd05.setVisibility(View.VISIBLE);
                    bi.fldGrpbd05dob2.setVisibility(View.GONE);
                    bi.bd05dob2.setText(null);
                    bi.bd05dod2.setText(null);
                } else if (Integer.valueOf(bi.bd05s.getText().toString().isEmpty() ? "0" : bi.bd05s.getText().toString()) == 2) {
                    bi.fldGrpbd05.setVisibility(View.VISIBLE);
                    bi.fldGrpbd05dob2.setVisibility(View.VISIBLE);
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        //=================== Q6 Skip Pattern

        bi.bd06s.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if (Integer.valueOf(bi.bd06s.getText().toString().isEmpty() ? "0" : bi.bd06s.getText().toString()) == 0) {
                    bi.fldGrpbd06.setVisibility(View.GONE);
                    bi.bd06dob2.setText(null);
                    bi.bd06dod2.setText(null);
                    bi.bd06dob1.setText(null);
                    bi.bd06dod1.setText(null);
                } else if (Integer.valueOf(bi.bd06s.getText().toString().isEmpty() ? "0" : bi.bd06s.getText().toString()) == 1) {
                    bi.fldGrpbd06.setVisibility(View.VISIBLE);
                    bi.fldGrpbd06dob2.setVisibility(View.GONE);
                    bi.bd06dob2.setText(null);
                    bi.bd06dod2.setText(null);
                } else if (Integer.valueOf(bi.bd06s.getText().toString().isEmpty() ? "0" : bi.bd06s.getText().toString()) == 2) {
                    bi.fldGrpbd06.setVisibility(View.VISIBLE);
                    bi.fldGrpbd06dob2.setVisibility(View.VISIBLE);
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        //=================== Q7 Skip Pattern


    }

    public boolean ValidateForm() {


        //================ Q4============

        if (bi.bd04s.getText().toString().isEmpty()) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.bd04), Toast.LENGTH_SHORT).show();
            bi.bd04s.setError("This data is Required!");
            Log.i(TAG, "bd04s: This data is Required!");
            return false;
        } else {
            bi.bd04s.setError(null);
        }

        if (Integer.valueOf(bi.bd04s.getText().toString()) == 1) {
            if (bi.bd04dob1.getText().toString().isEmpty()) {
                Toast.makeText(this, "ERROR(empty): " + getString(R.string.bd04), Toast.LENGTH_SHORT).show();
                bi.bd04dob1.setError("This data is Required!");
                Log.i(TAG, "bd04dob1: This data is Required!");
                return false;
            } else {
                bi.bd04dob1.setError(null);
            }

            if (bi.bd04dod1.getText().toString().isEmpty()) {
                Toast.makeText(this, "ERROR(empty): " + getString(R.string.bd04), Toast.LENGTH_SHORT).show();
                bi.bd04dod1.setError("This data is Required!");
                Log.i(TAG, "bd04dod1: This data is Required!");
                return false;
            } else {
                bi.bd04dod1.setError(null);
            }


        }

        if (Integer.valueOf(bi.bd04s.getText().toString()) == 2) {
            if (bi.bd04dob2.getText().toString().isEmpty() || bi.bd04dob1.getText().toString().isEmpty()) {
                Toast.makeText(this, "ERROR(empty): " + getString(R.string.bd04), Toast.LENGTH_SHORT).show();
                bi.bd04dob2.setError("This data is Required!");
                Log.i(TAG, "bd04dob2: This data is Required!");
                return false;
            } else {
                bi.bd04dob2.setError(null);
            }

            if (bi.bd04dod2.getText().toString().isEmpty() || bi.bd04dod1.getText().toString().isEmpty()) {
                Toast.makeText(this, "ERROR(empty): " + getString(R.string.bd04), Toast.LENGTH_SHORT).show();
                bi.bd04dod2.setError("This data is Required!");
                Log.i(TAG, "bd04dod2: This data is Required!");
                return false;
            } else {
                bi.bd04dod2.setError(null);
            }
        }


        //================ Q5============

        if (bi.bd05s.getText().toString().isEmpty()) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.bd05), Toast.LENGTH_SHORT).show();
            bi.bd05s.setError("This data is Required!");
            Log.i(TAG, "bd05s: This data is Required!");
            return false;
        } else {
            bi.bd05s.setError(null);
        }

        if (Integer.valueOf(bi.bd05s.getText().toString()) == 1) {
            if (bi.bd05dob1.getText().toString().isEmpty()) {
                Toast.makeText(this, "ERROR(empty): " + getString(R.string.bd05), Toast.LENGTH_SHORT).show();
                bi.bd05dob1.setError("This data is Required!");
                Log.i(TAG, "bd05dob1: This data is Required!");
                return false;
            } else {
                bi.bd05dob1.setError(null);
            }

            if (bi.bd05dod1.getText().toString().isEmpty()) {
                Toast.makeText(this, "ERROR(empty): " + getString(R.string.bd05), Toast.LENGTH_SHORT).show();
                bi.bd05dod1.setError("This data is Required!");
                Log.i(TAG, "bd05dod1: This data is Required!");
                return false;
            } else {
                bi.bd05dod1.setError(null);
            }
        }

        if (Integer.valueOf(bi.bd05s.getText().toString()) == 2) {
            if (bi.bd05dob2.getText().toString().isEmpty() || bi.bd05dob1.getText().toString().isEmpty()) {
                Toast.makeText(this, "ERROR(empty): " + getString(R.string.bd05), Toast.LENGTH_SHORT).show();
                bi.bd05dob2.setError("This data is Required!");
                Log.i(TAG, "bd05dob2: This data is Required!");
                return false;
            } else {
                bi.bd05dob2.setError(null);
            }

            if (bi.bd05dod2.getText().toString().isEmpty() || bi.bd05dod1.getText().toString().isEmpty()) {
                Toast.makeText(this, "ERROR(empty): " + getString(R.string.bd05), Toast.LENGTH_SHORT).show();
                bi.bd05dod2.setError("This data is Required!");
                Log.i(TAG, "bd05dod2: This data is Required!");
                return false;
            } else {
                bi.bd05dod2.setError(null);
            }
        }

        //================ Q6============

        if (bi.bd06s.getText().toString().isEmpty()) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.bd06), Toast.LENGTH_SHORT).show();
            bi.bd06s.setError("This data is Required!");
            Log.i(TAG, "bd06s: This data is Required!");
            return false;
        } else {
            bi.bd06s.setError(null);
        }

        if (Integer.valueOf(bi.bd06s.getText().toString()) == 1) {
            if (bi.bd06dob1.getText().toString().isEmpty()) {
                Toast.makeText(this, "ERROR(empty): " + getString(R.string.bd06), Toast.LENGTH_SHORT).show();
                bi.bd06dob1.setError("This data is Required!");
                Log.i(TAG, "bd06dob1: This data is Required!");
                return false;
            } else {
                bi.bd06dob1.setError(null);
            }

            if (bi.bd06dod1.getText().toString().isEmpty()) {
                Toast.makeText(this, "ERROR(empty): " + getString(R.string.bd06), Toast.LENGTH_SHORT).show();
                bi.bd06dod1.setError("This data is Required!");
                Log.i(TAG, "bd06dod1: This data is Required!");
                return false;
            } else {
                bi.bd06dod1.setError(null);
            }
        }

        if (Integer.valueOf(bi.bd06s.getText().toString()) == 2) {
            if (bi.bd06dob2.getText().toString().isEmpty() || bi.bd06dob2.getText().toString().isEmpty()) {
                Toast.makeText(this, "ERROR(empty): " + getString(R.string.bd06), Toast.LENGTH_SHORT).show();
                bi.bd06dob2.setError("This data is Required!");
                Log.i(TAG, "bd06dob2: This data is Required!");
                return false;
            } else {
                bi.bd06dob2.setError(null);
            }

            if (bi.bd06dod2.getText().toString().isEmpty() || bi.bd06dod2.getText().toString().isEmpty()) {
                Toast.makeText(this, "ERROR(empty): " + getString(R.string.bd06), Toast.LENGTH_SHORT).show();
                bi.bd06dod2.setError("This data is Required!");
                Log.i(TAG, "bd06dod2: This data is Required!");
                return false;
            } else {
                bi.bd06dod2.setError(null);
            }
        }


        //======================== Q 3 ==========================

        if (bi.bd03s.getText().toString().isEmpty()) {
            Toast.makeText(this, "ERROR(empty): " + getString(R.string.bd03), Toast.LENGTH_SHORT).show();
            bi.bd03s.setError("This data is Required!");
            Log.i(TAG, "bd03s: This data is Required!");
            return false;
        } else {
            bi.bd03s.setError(null);
        }

        if (Integer.valueOf(bi.bd03s.getText().toString()) == 1) {
            if (bi.bd03dob1.getText().toString().isEmpty()) {
                Toast.makeText(this, "ERROR(empty): " + getString(R.string.bd03), Toast.LENGTH_SHORT).show();
                bi.bd03dob1.setError("This data is Required!");
                Log.i(TAG, "bd03dob1: This data is Required!");
                return false;
            } else {
                bi.bd03dob1.setError(null);
            }
        }

        if (Integer.valueOf(bi.bd03s.getText().toString()) == 2) {
            if (bi.bd03dob2.getText().toString().isEmpty() || bi.bd03dob1.getText().toString().isEmpty()) {
                Toast.makeText(this, "ERROR(empty): " + getString(R.string.bd03), Toast.LENGTH_SHORT).show();
                bi.bd03dob2.setError("This data is Required!");
                Log.i(TAG, "bd03dob2: This data is Required!");
                return false;
            } else {
                bi.bd03dob2.setError(null);
            }
        }

        if (Integer.valueOf(bi.bd03s.getText().toString()) == 3) {
            if (bi.bd03dob3.getText().toString().isEmpty() || bi.bd03dob1.getText().toString().isEmpty()
                    || bi.bd03dob2.getText().toString().isEmpty()) {
                Toast.makeText(this, "ERROR(empty): " + getString(R.string.bd03), Toast.LENGTH_SHORT).show();
                bi.bd03dob3.setError("This data is Required!");
                Log.i(TAG, "bd03dob3: This data is Required!");
                return false;
            } else {
                bi.bd03dob3.setError(null);
            }
        }

        if (Integer.valueOf(bi.bd03s.getText().toString()) == 4) {
            if (bi.bd03dob4.getText().toString().isEmpty() || bi.bd03dob3.getText().toString().isEmpty()
                    || bi.bd03dob1.getText().toString().isEmpty()
                    || bi.bd03dob2.getText().toString().isEmpty()) {
                Toast.makeText(this, "ERROR(empty): " + getString(R.string.bd03), Toast.LENGTH_SHORT).show();
                bi.bd03dob4.setError("This data is Required!");
                Log.i(TAG, "bd03dob4: This data is Required!");
                return false;
            } else {
                bi.bd03dob4.setError(null);
            }
        }

        if (Integer.valueOf(bi.bd03s.getText().toString()) == 5) {
            if (bi.bd03dob5.getText().toString().isEmpty() || bi.bd03dob4.getText().toString().isEmpty()
                    || bi.bd03dob3.getText().toString().isEmpty()
                    || bi.bd03dob1.getText().toString().isEmpty()
                    || bi.bd03dob2.getText().toString().isEmpty()) {
                Toast.makeText(this, "ERROR(empty): " + getString(R.string.bd03), Toast.LENGTH_SHORT).show();
                bi.bd03dob5.setError("This data is Required!");
                Log.i(TAG, "bd03dob5: This data is Required!");
                return false;
            } else {
                bi.bd03dob5.setError(null);
            }

        }


        return true;

    }

    private void SaveDraft() throws JSONException {
        Toast.makeText(this, "Saving Draft for  This Section", Toast.LENGTH_SHORT).show();

        JSONObject sn = new JSONObject();


        sn.put("bd01s", bi.bd04s.getText().toString());
        sn.put("bd01dob1", bi.bd04dob1.getText().toString());
        sn.put("bd01dob2", bi.bd04dob2.getText().toString());
        sn.put("bd01dod1", bi.bd04dod1.getText().toString());
        sn.put("bd01dod2", bi.bd04dod2.getText().toString());

        sn.put("bd02s", bi.bd05s.getText().toString());
        sn.put("bd02dob1", bi.bd05dob1.getText().toString());
        sn.put("bd02dob2", bi.bd05dob2.getText().toString());
        sn.put("bd02dod1", bi.bd05dod1.getText().toString());
        sn.put("bd02dod2", bi.bd05dod2.getText().toString());

        sn.put("bd03s", bi.bd06s.getText().toString());
        sn.put("bd03dob1", bi.bd06dob1.getText().toString());
        sn.put("bd03dob2", bi.bd06dob2.getText().toString());
        sn.put("bd03dod1", bi.bd06dod1.getText().toString());
        sn.put("bd03dod2", bi.bd06dod2.getText().toString());

        sn.put("bd04s", bi.bd03s.getText().toString());
        sn.put("bd04dob1", bi.bd03dob1.getText().toString());
        sn.put("bd04dob2", bi.bd03dob2.getText().toString());
        sn.put("bd04dob3", bi.bd03dob3.getText().toString());
        sn.put("bd04dob4", bi.bd03dob4.getText().toString());
        sn.put("bd04dob5", bi.bd03dob5.getText().toString());


        //MainApp.fc.sets(String.valueOf(sn));

        Toast.makeText(this, "Validation Successful! - Saving Draft...", Toast.LENGTH_SHORT).show();
    }


    private boolean UpdateDB() {
        DatabaseHelper db = new DatabaseHelper(this);

        int updcount = db.updateSF();
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
        if (ValidateForm()) {
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
        if (ValidateForm()) {
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


    public Calendar getCalendarDate(String value) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Calendar calendar = Calendar.getInstance();
        try {
            Date date = sdf.parse(value);
            calendar.setTime(date);
            return calendar;

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return calendar;
    }

    public String convertDateFormat(String dateStr) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        try {
            Date d = sdf.parse(dateStr);
            return new SimpleDateFormat("dd/MM/yyyy").format(d);
        } catch (ParseException ex) {
            ex.printStackTrace();
        }

        return "";
    }

    @Override
    public void onBackPressed() {
        Toast.makeText(getApplicationContext(), "You Can't go back", Toast.LENGTH_LONG).show();
    }
}