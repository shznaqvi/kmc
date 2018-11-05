package edu.aku.hassannaqvi.kmc_validate_app.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.os.Bundle;
import android.provider.Settings;
import android.text.Editable;
import android.text.InputType;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.format.DateFormat;
import android.text.method.DigitsKeyListener;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.aku.hassannaqvi.kmc_validate_app.R;
import edu.aku.hassannaqvi.kmc_validate_app.contracts.DistrictsContract;
import edu.aku.hassannaqvi.kmc_validate_app.contracts.FormsContract;
import edu.aku.hassannaqvi.kmc_validate_app.contracts.MwraContract;
import edu.aku.hassannaqvi.kmc_validate_app.contracts.UCsContract;
import edu.aku.hassannaqvi.kmc_validate_app.contracts.VillagesContract;
import edu.aku.hassannaqvi.kmc_validate_app.core.DatabaseHelper;
import edu.aku.hassannaqvi.kmc_validate_app.core.MainApp;
import edu.aku.hassannaqvi.kmc_validate_app.databinding.ActivitySectionA1Binding;
import edu.aku.hassannaqvi.kmc_validate_app.validation.validatorClass;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;


public class SectionA1Activity extends Activity {

    public List<String> psuName, districtNames, villageNames, wName;
    public List<String> psuCode, districtCodes, villageCodes, wSno;

    Map<String, MwraContract> mapWRA;

    DatabaseHelper db;

    Collection<MwraContract> mwra;

    private static final String TAG = SectionA1Activity.class.getName();
    String dtToday = new SimpleDateFormat("dd-MM-yy HH:mm").format(new Date().getTime());

    ActivitySectionA1Binding bi;
    int length = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_a1);
        bi.setCallback(this);

        db = new DatabaseHelper(getApplicationContext());


        /*if (MainApp.userName.equals("test1234")) {
            populateSpinner_testuser(this);
        } else {
            populateSpinner(this);
        }*/


        populateSpinner(this);

        bi.cra04.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//                bi.cra04.setInputType(InputType.TYPE_TEXT_FLAG_CAP_CHARACTERS | InputType.TYPE_CLASS_TEXT);
//                bi.cra04.setKeyListener(DigitsKeyListener.getInstance("ABCDEFGHIJKLMNOPQRSTUVWXYZ 0123456789-"));
                length = charSequence.toString().length();
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
         /*          clearFields();
             bi.fldGrpcra04.setVisibility(GONE);
                bi.btnNext.setVisibility(GONE);
                bi.btnEnd.setVisibility(GONE);
*/

                if (!bi.cra04.getText().toString().isEmpty() && bi.cra04.getText().toString().length() == 3) {


                        if (bi.cra04.getText().toString().substring(0, 3).matches("[0-9]+")) {
                            if (length < 4) {
                                bi.cra04.setText(bi.cra04.getText().toString() + "-");
                                bi.cra04.setSelection(bi.cra04.getText().length());
                                //binding.nh108.setInputType(InputType.TYPE_TEXT_FLAG_CAP_CHARACTERS);
                            }
                        }

                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
         /*   if (bi.cra04.getText().toString().matches("[^A-Za-z0-9]")) {
                bi.cra04.setError(null);
            }else{
                Toast.makeText(SectionA1Activity.this,"No special characters allowed!!!",Toast.LENGTH_SHORT).show();
                bi.cra04.setError("No special characters allowed!!!");
            }*/
            }
        });


        bi.cra07.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (bi.cra07a.isChecked()) {
                    bi.btnNext.setVisibility(View.VISIBLE);
                } else {
                    bi.btnNext.setVisibility(GONE);
                }
            }
        });


        //setUp();

    }


    public void populateSpinner_testuser(final Context context) {
        // Spinner Drop down elements
        districtNames = new ArrayList<>();
        districtCodes = new ArrayList<>();

        districtNames.add("District1");
        districtCodes.add("1");

        districtNames.add("District2");
        districtCodes.add("2");


        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(context,
                android.R.layout.simple_spinner_item, districtNames);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        bi.crataluka.setAdapter(dataAdapter);

        bi.crataluka.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                MainApp.talukaCode = districtCodes.get(position);

                psuCode = new ArrayList<>();
                psuName = new ArrayList<>();


                psuCode.add("1");
                psuName.add("UC1");

                psuCode.add("2");
                psuName.add("UC2");


                ArrayAdapter<String> psuAdapter = new ArrayAdapter<>(context,
                        android.R.layout.simple_spinner_item, psuName);

                psuAdapter
                        .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                bi.crauc.setAdapter(psuAdapter);
                bi.hidden01.setVisibility(VISIBLE);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                //  bi.hidden01.setVisibility(GONE);

            }
        });

        bi.crauc.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                MainApp.ucCode = psuCode.get(position);

                villageCodes = new ArrayList<>();
                villageNames = new ArrayList<>();
                final List<String> villageNames1 = new ArrayList<>();

                villageCodes.add("1");
                villageNames.add("Village1");

                villageCodes.add("2");
                villageNames.add("Village2");

                bi.crvillage.setAdapter(new ArrayAdapter<>(context, android.R.layout.simple_spinner_dropdown_item, villageNames));
                bi.hidden02.setVisibility(VISIBLE);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                bi.hidden02.setVisibility(GONE);

            }
        });

        bi.crvillage.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                if (bi.crvillage.getSelectedItemPosition() != 0) {
                    MainApp.villageCode = villageCodes.get(i);
                    String[] st = villageNames.get(i).split("\\|");

                    /*districtN.setText(st[0]);
                    ucN.setText(st[1]);
                    psuN.setText(st[2]);*/
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }


    public void populateSpinner(final Context context) {
        // Spinner Drop down elements
        districtNames = new ArrayList<>();
        districtCodes = new ArrayList<>();

        districtNames.add("....");
        districtCodes.add("....");

        Collection<DistrictsContract> dc = db.getAllDistricts();
        Log.d(TAG, "onCreate: " + dc.size());
        for (DistrictsContract d : dc) {
            districtNames.add(d.getDistrictName());
            districtCodes.add(d.getDistrictCode());
        }

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(context,
                android.R.layout.simple_spinner_dropdown_item, districtNames);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);


        // attaching data adapter to spinner
        bi.crataluka.setAdapter(dataAdapter);


        bi.crataluka.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                MainApp.talukaCode = districtCodes.get(position);

                psuCode = new ArrayList<>();
                psuName = new ArrayList<>();


                psuCode.add("....");
                psuName.add("....");

                Collection<UCsContract> pc = db.getAllUCsByTalukas(districtCodes.get(position));
                for (UCsContract p : pc) {
                    psuCode.add(p.getUccode());
                    psuName.add(p.getUcsName());
                }
                ArrayAdapter<String> psuAdapter = new ArrayAdapter<>(context,
                        android.R.layout.simple_spinner_dropdown_item, psuName);

                psuAdapter
                        .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                bi.crauc.setAdapter(psuAdapter);
                if (position == 0) {
                    bi.hidden01.setVisibility(GONE);

                } else {
                    bi.hidden01.setVisibility(VISIBLE);

                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                bi.hidden01.setVisibility(GONE);

            }
        });

        bi.crauc.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                MainApp.ucCode = psuCode.get(position);

                villageCodes = new ArrayList<>();
                villageNames = new ArrayList<>();
                final List<String> villageNames1 = new ArrayList<>();

                villageCodes.add("....");
                villageNames.add("....");
                villageNames1.add("....");

                Collection<VillagesContract> pc = db.getAllPSUsByDistrict(MainApp.talukaCode, MainApp.ucCode);
                for (VillagesContract p : pc) {
                    villageCodes.add(p.getVillageCode());
                    villageNames.add(p.getVillageName());
                    villageNames1.add(p.getVillageName().split("\\|")[2]);
                }

                bi.crvillage.setAdapter(new ArrayAdapter<>(context, android.R.layout.simple_spinner_dropdown_item, villageNames1));
                if (position == 0) {
                    bi.hidden02.setVisibility(GONE);
                } else {
                    bi.hidden02.setVisibility(VISIBLE);
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                bi.hidden02.setVisibility(GONE);

            }
        });

        bi.crvillage.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                if (bi.crvillage.getSelectedItemPosition() != 0) {
                    MainApp.villageCode = villageCodes.get(i);
                   // String[] st = villageNames.get(i).split("\\|");

                    /*districtN.setText(st[0]);
                    ucN.setText(st[1]);
                    psuN.setText(st[2]);*/
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


       /* bi.crwoman.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                if (bi.crwoman.getSelectedItemPosition() != 0) {
                    MainApp.wSerialNo = wSno.get(i);
                    MainApp.wName = wName.get(i);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });*/

    }


    private boolean formValidation() {

        if (bi.crauc.getSelectedItemPosition() == 0) {
            Toast.makeText(this, "ERROR(Empty)" + getString(R.string.cruc), Toast.LENGTH_SHORT).show();
            ((TextView) bi.crauc.getSelectedView()).setText("This Data is Required");
            ((TextView) bi.crauc.getSelectedView()).setTextColor(Color.RED);
            bi.crauc.requestFocus();
            Log.i(TAG, "spTehsil: This Data is Required!");
            return false;
        } else {
            ((TextView) bi.crauc.getSelectedView()).setError(null);
        }


        if (!validatorClass.EmptyTextBox(this, bi.cra04, getString(R.string.cra04))) {
            return false;
        }

        if (!validatorClass.EmptySpinner(this, bi.crvillage, getString(R.string.crvillage))) {
            return false;
        }


      /*  if (bi.crwoman.getSelectedItemPosition() == 0) {
            Toast.makeText(this, "ERROR(Empty)" + getString(R.string.crwoman), Toast.LENGTH_SHORT).show();
            ((TextView) bi.crwoman.getSelectedView()).setText("This Data is Required");
            ((TextView) bi.crwoman.getSelectedView()).setTextColor(Color.RED);
            bi.crwoman.requestFocus();
            Log.i(TAG, "crwoman: This Data is Required!");
            return false;
        } else {
            ((TextView) bi.crwoman.getSelectedView()).setError(null);
        }
*/
/*
        if (!validatorClass.EmptyTextBox(this, bi.cravillage, getString(R.string.crvillage))) {
            return false;
        }*/


        /*if (!validatorClass.EmptyTextBox(this, bi.cra03, getString(R.string.cra03))) {
            return false;
        }


        if (!validatorClass.EmptyTextBox(this, bi.cra05, getString(R.string.cra05))) {
            return false;
        }
*/

      /*  if (!validatorClass.EmptyTextBox(this, bi.cra06, getString(R.string.cra06))) {
            return false;
        }


        if (!validatorClass.RangeTextBox(this, bi.cra06, 14, 49, getString(R.string.cra06), "Age")) {
            return false;
        }*/


        if (!validatorClass.EmptyTextBox(this, bi.kaa05, getString(R.string.kaa05))) {
            return false;
        }
      /*  if (!validatorClass.EmptyTextBox(this, bi.kaa06, getString(R.string.kaa06))) {
            return false;
        }
        if (!validatorClass.RangeTextBox(this, bi.kaa06, 14, 49, getString(R.string.kaa06),  " Age")) {
            return false;
        }*/
       /* if (!validatorClass.EmptyTextBox(this, bi.kaa07, getString(R.string.kaa07))) {
            return false;
        }
        if (!validatorClass.RangeTextBox(this, bi.kaa07, 0, 20, getString(R.string.cra07), " Class")) {
            return false;
        }*/
        if (!validatorClass.EmptyTextBox(this, bi.kaa08, getString(R.string.kaa08))) {
            return false;
        }
        if (!validatorClass.RangeTextBox(this, bi.kaa08, 1, 50, getString(R.string.kaa08), " members")) {
            return false;
        }

        if (!validatorClass.EmptyTextBox(this, bi.kaa09, getString(R.string.kaa09))) {
            return false;
        }
        if (!validatorClass.RangeTextBox(this, bi.kaa09, 1, 9, getString(R.string.kaa09), " members")) {
            return false;
        }
       /* if (!validatorClass.EmptyTextBox(this, bi.kaa10, getString(R.string.kaa10))) {
            return false;
        }
        if (!validatorClass.RangeTextBox(this, bi.kaa10, 0, 20, getString(R.string.kaa10), " members")) {
            return false;
        }*/
//        int totalmwraandchild = Integer.valueOf(bi.kaa09.getText().toString()) + Integer.valueOf(bi.kaa10.getText().toString());
        if (Integer.valueOf(bi.kaa09.getText().toString())<= Integer.valueOf(bi.kaa08.getText().toString())) {
            bi.kaa08.setError(null);
            bi.kaa09.setError(null);
//            bi.kaa10.setError(null);
        } else {
            bi.kaa08.setError("Number of childeren and mwra are greater than total number of household members");
            bi.kaa09.setError("Number of childeren and mwra are greater than total number of household members");
//            bi.kaa10.setError("Number of childeren and mwra are greater than total number of household members");
            Toast.makeText(this, "Number of childeren and mwra are greater than total number of household members", Toast.LENGTH_SHORT).show();
            return false;
        }
       /* if (!validatorClass.EmptyTextBox(this, bi.kaa10a, getString(R.string.kaa10a))) {
            return false;
        }
        if (!validatorClass.RangeTextBox(this, bi.kaa10a, 0, 9, getString(R.string.kaa10a), " members")) {
            return false;
        }
        if (!validatorClass.EmptyTextBox(this, bi.kaa10b, getString(R.string.kaa10b))) {
            return false;
        }
        if (!validatorClass.RangeTextBox(this, bi.kaa10b, 0, 9, getString(R.string.kaa10b), " members")) {
            return false;
        }
        if (!validatorClass.EmptyTextBox(this, bi.kaa10c, getString(R.string.kaa10c))) {
            return false;
        }
        if (!validatorClass.RangeTextBox(this, bi.kaa10c, 0, 9, getString(R.string.kaa10c), " members")) {
            return false;
        }

        int totalchildu5 = Integer.parseInt(bi.kaa10a.getText().toString()) + Integer.parseInt(bi.kaa10b.getText().toString()) + Integer.parseInt(bi.kaa10c.getText().toString());
        if (Integer.parseInt(bi.kaa10.getText().toString()) != totalchildu5) {
            bi.kaa10.setError("Wrong calculation of child under 5");
            bi.kaa10a.setError("Wrong calculation of child under 5");
            bi.kaa10b.setError("Wrong calculation of child under 5");
            bi.kaa10c.setError("Wrong calculation of child under 5");
            Toast.makeText(this, "Wrong calculation of child under 5", Toast.LENGTH_SHORT).show();
            return false;
        } else {
            bi.kaa10.setError(null);
            bi.kaa10a.setError(null);
            bi.kaa10b.setError(null);
            bi.kaa10c.setError(null);
        }*/

        if (!validatorClass.EmptyRadioButton(this, bi.cra07, bi.cra07a, getString(R.string.cra07))) {
            return false;
        }
        return true;
    }


    private void SaveDraft() throws JSONException {

        Toast.makeText(this, "Saving Draft for this Section", Toast.LENGTH_SHORT).show();
        SharedPreferences sharedPref = getSharedPreferences("tagName", MODE_PRIVATE);
        MainApp.fc = new FormsContract();


        MainApp.fc.setDevicetagID(sharedPref.getString("tagName", null));
        MainApp.fc.setFormDate(new SimpleDateFormat("dd-MM-yy HH:mm").format(new Date().getTime()));
        MainApp.fc.setUser(MainApp.userName);
        MainApp.fc.setDeviceID(Settings.Secure.getString(getApplicationContext().getContentResolver(),
                Settings.Secure.ANDROID_ID));
        MainApp.fc.setAppversion(MainApp.versionName + "." + MainApp.versionCode);

        JSONObject sInfo = new JSONObject();


        sInfo.put("kaataluka", MainApp.talukaCode);
        sInfo.put("kaauc", MainApp.ucCode);
        sInfo.put("kavillage", MainApp.villageCode);


        // sInfo.put("kaavillage", bi.cravillage.getText().toString());

        //sInfo.put("cra03", bi.cra03.getText().toString());

        sInfo.put("cra04", bi.cra04.getText().toString().toUpperCase());

        //sInfo.put("cra05", bi.cra05.getText().toString());
        // sInfo.put("cra06", bi.cra06.getText().toString());


       /* sInfo.put("sno", MainApp.wSerialNo);
        sInfo.put("wname", MainApp.wName);
        sInfo.put("muid", mapWRA.get(bi.crwoman.getSelectedItem().toString()).getMuid());
        sInfo.put("duid", mapWRA.get(bi.crwoman.getSelectedItem().toString()).getDuid());
        sInfo.put("delvr_date", mapWRA.get(bi.crwoman.getSelectedItem().toString()).getDlvr_date());
        sInfo.put("hh08", mapWRA.get(bi.crwoman.getSelectedItem().toString()).getHh08());
        sInfo.put("hh09", mapWRA.get(bi.crwoman.getSelectedItem().toString()).getHh09());
*/
        sInfo.put("cra07a", bi.cra07a.isChecked() ? "1"
                : bi.cra07b.isChecked() ? "2"
                : "0");
        sInfo.put("kaa05", bi.kaa05.getText().toString());
        MainApp.resName = bi.kaa05.getText().toString();
//        sInfo.put("kaa06", bi.kaa06.getText().toString());
//        sInfo.put("kaa07", bi.kaa07.getText().toString());
        sInfo.put("kaa08", bi.kaa08.getText().toString());
        sInfo.put("kaa09", bi.kaa09.getText().toString());
      /*  sInfo.put("kaa10", bi.kaa10.getText().toString());
        sInfo.put("kaa10a", bi.kaa10a.getText().toString());
        sInfo.put("kaa10b", bi.kaa10b.getText().toString());
        sInfo.put("kaa10c", bi.kaa10c.getText().toString());*/

        MainApp.fc.setsa1(String.valueOf(sInfo));

        setGPS();
    }


    public void BtnEnd() {
        Toast.makeText(this, "Processing End Section", Toast.LENGTH_SHORT).show();
//        if (formValidation()) {
            try {
                SaveDraft();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (UpdateDB()) {
                MainApp.endActivity(this, this);

            } else {
                Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
            }
//        }
    }

    public void BtnContinue() {

        if (formValidation()) {
            try {
                SaveDraft();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (UpdateDB()) {
                Toast.makeText(this, "Starting Ending Section", Toast.LENGTH_SHORT).show();

                finish();

                startActivity(new Intent(this, SectionA2Activity.class));
                //startActivity(new Intent(this, MainActivity.class));

            } else {
                Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
            }
        }
    }


    private boolean ValidSpiner() {

        if (bi.crataluka.getSelectedItemPosition() == 0) {
            Toast.makeText(this, "ERROR(Empty)" + getString(R.string.crataluka), Toast.LENGTH_SHORT).show();
            ((TextView) bi.crataluka.getSelectedView()).setText("This Data is Required");
            ((TextView) bi.crataluka.getSelectedView()).setTextColor(Color.RED);
            bi.crataluka.requestFocus();
            Log.i(TAG, "crataluka: This Data is Required!");
            return false;
        } else {
            ((TextView) bi.crataluka.getSelectedView()).setError(null);
        }


        if (bi.crauc.getSelectedItemPosition() == 0) {
            Toast.makeText(this, "ERROR(Empty)" + getString(R.string.cruc), Toast.LENGTH_SHORT).show();
            ((TextView) bi.crauc.getSelectedView()).setText("This Data is Required");
            ((TextView) bi.crauc.getSelectedView()).setTextColor(Color.RED);
            bi.crauc.requestFocus();
            Log.i(TAG, "spTehsil: This Data is Required!");
            return false;
        } else {
            ((TextView) bi.crauc.getSelectedView()).setError(null);
        }


        if (bi.crvillage.getSelectedItemPosition() == 0) {
            Toast.makeText(this, "ERROR(Empty)" + getString(R.string.crvillage), Toast.LENGTH_SHORT).show();
            ((TextView) bi.crvillage.getSelectedView()).setText("This Data is Required");
            ((TextView) bi.crvillage.getSelectedView()).setTextColor(Color.RED);
            bi.crvillage.requestFocus();
            Log.i(TAG, "crvillage: This Data is Required!");
            return false;
        } else {
            ((TextView) bi.crvillage.getSelectedView()).setError(null);
        }


        return true;
    }


    public void BtnSearchWoman() {
// Not using in new Form of KMC
        if (ValidSpiner()) {

            if (!TextUtils.isEmpty(bi.cra04.getText().toString())) {

                db = new DatabaseHelper(this);


                // Spinner Drop down elements
                wName = new ArrayList<>();
                wSno = new ArrayList<>();

                wName.add("....");
                wSno.add("....");

                mapWRA = new HashMap<>();
                /*
                Collection<MwraContract> dc = db.getMWRA(bi.cra04.getText().toString(), MainApp.villageCode);
                Log.d(TAG, "onCreate: " + dc.size());
                for (MwraContract d : dc) {
                    wName.add(d.getWname() + "_" + d.getSno());
                    wSno.add(d.getSno());

                    mapWRA.put(d.getWname() + "_" + d.getSno(), d);

                }

                // Creating adapter for spinner
                ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(this,
                        android.R.layout.simple_spinner_dropdown_item, wName);

                // Drop down layout style - list view with radio button
                dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

                // attaching data adapter to spinner
                bi.crwoman.setAdapter(dataAdapter);


                if (dc.size() <= 0) {
                    clearFields();
                    bi.fldGrpcra04.setVisibility(GONE);
                    bi.womeninfo.setVisibility(GONE);
                    bi.btnNext.setVisibility(GONE);
                    bi.btnEnd.setVisibility(GONE);
                    Toast.makeText(this, "Household does not exist ", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(this, "Household number exists", Toast.LENGTH_LONG).show();
                    bi.fldGrpcra04.setVisibility(View.VISIBLE);
                    bi.womeninfo.setVisibility(View.VISIBLE);
                    bi.btnNext.setVisibility(View.VISIBLE);
                    bi.btnEnd.setVisibility(View.VISIBLE);
                }
                */
            } else {
                Toast.makeText(this, "Household number required", Toast.LENGTH_LONG).show();
                clearFields();
                bi.btnNext.setVisibility(GONE);
                bi.btnEnd.setVisibility(GONE);
                bi.womeninfo.setVisibility(GONE);
                bi.cra04.requestFocus();
            }
        }
    }


    private void setUp() {

        bi.cra04.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                bi.cra04.setInputType(InputType.TYPE_CLASS_NUMBER);

                length = charSequence.toString().length();
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                clearFields();


                if (!bi.cra04.getText().toString().isEmpty() && bi.cra04.getText().toString().length() == 4) {
                    if (bi.cra04.getText().toString().substring(0, 3).matches("[0-9]+")) {
                        if (length < 5) {
                            bi.cra04.setText(bi.cra04.getText().toString() + "-");
                            bi.cra04.setSelection(bi.cra04.getText().length());
                            //binding.nh108.setInputType(InputType.TYPE_TEXT_FLAG_CAP_CHARACTERS);
                        }
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });


    }


    public void clearFields() {
        bi.fldGrpcra04.setVisibility(GONE);

        bi.cravillage.setText(null);
        //bi.cra03.setText(null);
        //bi.cra05.setText(null);
        //  bi.cra06.setText(null);
        bi.cra07.clearCheck();
    }


    private boolean UpdateDB() {

        DatabaseHelper db = new DatabaseHelper(this);

        long updcount = db.addForm(MainApp.fc);

        MainApp.fc.set_ID(String.valueOf(updcount));

        if (updcount > 0) {
            Toast.makeText(this, "Updating Database... Successful!", Toast.LENGTH_SHORT).show();

            MainApp.fc.setUID((MainApp.fc.getDeviceID() + MainApp.fc.get_ID()));
            db.updateFormID();
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
        }

        return true;
    }


    public void setGPS() {
        SharedPreferences GPSPref = getSharedPreferences("GPSCoordinates", Context.MODE_PRIVATE);
        try {
            String lat = GPSPref.getString("Latitude", "0");
            String lang = GPSPref.getString("Longitude", "0");
            String acc = GPSPref.getString("Accuracy", "0");
            String elevation = GPSPref.getString("Elevation", "0");

            if (lat == "0" && lang == "0") {
                Toast.makeText(this, "Could not obtained GPS points", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "GPS set", Toast.LENGTH_SHORT).show();
            }

            String date = DateFormat.format("dd-MM-yyyy HH:mm", Long.parseLong(GPSPref.getString("Time", "0"))).toString();

            MainApp.fc.setGpsLat(lat);
            MainApp.fc.setGpsLng(lang);
            MainApp.fc.setGpsAcc(acc);
            MainApp.fc.setGpsDT(date); // Timestamp is converted to date above
            MainApp.fc.setGpsElev(elevation);

            Toast.makeText(this, "GPS set", Toast.LENGTH_SHORT).show();

        } catch (Exception e) {
            Log.e(TAG, "setGPS: " + e.getMessage());
        }

    }


}