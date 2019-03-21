package edu.aku.hassannaqvi.kmc_screening.ui;

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

import edu.aku.hassannaqvi.kmc_screening.R;
import edu.aku.hassannaqvi.kmc_screening.contracts.DistrictsContract;
import edu.aku.hassannaqvi.kmc_screening.contracts.FormsContract;
import edu.aku.hassannaqvi.kmc_screening.contracts.MwraContract;
import edu.aku.hassannaqvi.kmc_screening.contracts.UCsContract;
import edu.aku.hassannaqvi.kmc_screening.contracts.VillagesContract;
import edu.aku.hassannaqvi.kmc_screening.core.DatabaseHelper;
import edu.aku.hassannaqvi.kmc_screening.core.MainApp;
import edu.aku.hassannaqvi.kmc_screening.databinding.ActivitySectionInfoKmcBinding;
import edu.aku.hassannaqvi.kmc_screening.validation.ValidatorClass;


public class SectionInfoKmcActivity extends Activity {

    public List<String> psuName, districtNames, villageNames, wName;
    public List<String> psuCode, districtCodes, villageCodes, wSno;

    Map<String, MwraContract> mapWRA;

    DatabaseHelper db;

    private static final String TAG = SectionInfoKmcActivity.class.getName();
    String dtToday = new SimpleDateFormat("dd-MM-yy HH:mm").format(new Date().getTime());

    ActivitySectionInfoKmcBinding bi;
    int length = 0;

    public static FormsContract fc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_section_info_kmc);

        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_info_kmc);
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

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                clearFields();
                bi.fldGrpcra04.setVisibility(View.GONE);
                bi.btnNext.setVisibility(View.GONE);
                bi.btnEnd.setVisibility(View.GONE);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });


        bi.cra07.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (bi.cra07a.isChecked()) {
                    bi.btnNext.setVisibility(View.VISIBLE);
                } else {
                    bi.btnNext.setVisibility(View.GONE);
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

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

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
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

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

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

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
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

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


        bi.crwoman.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
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
        });

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


        if (!ValidatorClass.EmptyTextBox(this, bi.cra04, getString(R.string.cra04))) {
            return false;
        }


        if (bi.crwoman.getSelectedItemPosition() == 0) {
            Toast.makeText(this, "ERROR(Empty)" + getString(R.string.crwoman), Toast.LENGTH_SHORT).show();
            ((TextView) bi.crwoman.getSelectedView()).setText("This Data is Required");
            ((TextView) bi.crwoman.getSelectedView()).setTextColor(Color.RED);
            bi.crwoman.requestFocus();
            Log.i(TAG, "crwoman: This Data is Required!");
            return false;
        } else {
            ((TextView) bi.crwoman.getSelectedView()).setError(null);
        }


        if (!ValidatorClass.EmptyTextBox(this, bi.cravillage, getString(R.string.crvillage))) {
            return false;
        }


        /*if (!ValidatorClass.EmptyTextBox(this, bi.cra03, getString(R.string.cra03))) {
            return false;
        }


        if (!ValidatorClass.EmptyTextBox(this, bi.cra05, getString(R.string.cra05))) {
            return false;
        }
*/

        if (!ValidatorClass.EmptyTextBox(this, bi.cra06, getString(R.string.cra06))) {
            return false;
        }


        if (!ValidatorClass.RangeTextBox(this, bi.cra06, 15, 49, getString(R.string.cra06), "Age")) {
            return false;
        }


        return ValidatorClass.EmptyRadioButton(this, bi.cra07, bi.cra07a, getString(R.string.cra07));
    }


    private void SaveDraft() throws JSONException {

        Toast.makeText(this, "Saving Draft for this Section", Toast.LENGTH_SHORT).show();
        SharedPreferences sharedPref = getSharedPreferences("tagName", MODE_PRIVATE);
        fc = new FormsContract();


        fc.setDevicetagID(sharedPref.getString("tagName", null));
        fc.setFormDate(new SimpleDateFormat("dd-MM-yy HH:mm").format(new Date().getTime()));
        fc.setUser(MainApp.userName);
        fc.setDeviceID(Settings.Secure.getString(getApplicationContext().getContentResolver(),
                Settings.Secure.ANDROID_ID));
        fc.setAppversion(MainApp.versionName + "." + MainApp.versionCode);

        JSONObject sInfo = new JSONObject();


        sInfo.put("kaataluka", MainApp.talukaCode);
        sInfo.put("kaauc", MainApp.ucCode);
        sInfo.put("kavillage", MainApp.villageCode);


        sInfo.put("kaavillage", bi.cravillage.getText().toString());

        //sInfo.put("cra03", bi.cra03.getText().toString());

        sInfo.put("kaa04", bi.cra04.getText().toString());

        //sInfo.put("cra05", bi.cra05.getText().toString());
        sInfo.put("kaa06", bi.cra06.getText().toString());


        sInfo.put("sno", MainApp.wSerialNo);
        sInfo.put("wname", MainApp.wName);
        sInfo.put("muid", mapWRA.get(bi.crwoman.getSelectedItem().toString()).getMuid());
        sInfo.put("duid", mapWRA.get(bi.crwoman.getSelectedItem().toString()).getDuid());
        sInfo.put("delvr_date", mapWRA.get(bi.crwoman.getSelectedItem().toString()).getDlvr_date());
        sInfo.put("hh08", mapWRA.get(bi.crwoman.getSelectedItem().toString()).getHh08());
        sInfo.put("hh09", mapWRA.get(bi.crwoman.getSelectedItem().toString()).getHh09());

        sInfo.put("kaa07", bi.cra07a.isChecked() ? "1"
                : bi.cra07b.isChecked() ? "2"
                : "0");

        fc.setsInfo(String.valueOf(sInfo));

        setGPS();
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

                startActivity(new Intent(this, EndingActivity.class).putExtra("complete", false));

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

                startActivity(new Intent(this, SectionA1Activity.class));
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

        if (ValidSpiner()) {

            if (!TextUtils.isEmpty(bi.cra04.getText().toString())) {

                db = new DatabaseHelper(this);


                // Spinner Drop down elements
                wName = new ArrayList<>();
                wSno = new ArrayList<>();

                wName.add("....");
                wSno.add("....");

                mapWRA = new HashMap<>();

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
                    bi.fldGrpcra04.setVisibility(View.GONE);
                    bi.btnNext.setVisibility(View.GONE);
                    bi.btnEnd.setVisibility(View.GONE);
                    Toast.makeText(this, "Household does not exist ", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(this, "Household number exists", Toast.LENGTH_LONG).show();
                    bi.fldGrpcra04.setVisibility(View.VISIBLE);
                    bi.btnNext.setVisibility(View.VISIBLE);
                    bi.btnEnd.setVisibility(View.VISIBLE);
                }
            } else {
                Toast.makeText(this, "Household number required", Toast.LENGTH_LONG).show();
                clearFields();
                bi.btnNext.setVisibility(View.GONE);
                bi.btnEnd.setVisibility(View.GONE);
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
        bi.fldGrpcra04.setVisibility(View.GONE);

        bi.cravillage.setText(null);
        //bi.cra03.setText(null);
        //bi.cra05.setText(null);
        bi.cra06.setText(null);
        bi.cra07.clearCheck();
    }


    private boolean UpdateDB() {

        DatabaseHelper db = new DatabaseHelper(this);

        long updcount = db.addForm(fc);

        fc.set_ID(String.valueOf(updcount));

        if (updcount > 0) {
            Toast.makeText(this, "Updating Database... Successful!", Toast.LENGTH_SHORT).show();

            fc.setUID(
                    (fc.getDeviceID() + fc.get_ID()));
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

            fc.setGpsLat(lat);
            fc.setGpsLng(lang);
            fc.setGpsAcc(acc);
            fc.setGpsDT(date); // Timestamp is converted to date above

            Toast.makeText(this, "GPS set", Toast.LENGTH_SHORT).show();

        } catch (Exception e) {
            Log.e(TAG, "setGPS: " + e.getMessage());
        }

    }


    @Override
    public void onBackPressed() {
        Toast.makeText(getApplicationContext(), "You Can't go back", Toast.LENGTH_LONG).show();
    }

}