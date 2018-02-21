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

import java.io.Serializable;

import edu.aku.hassannaqvi.kmc.R;
import edu.aku.hassannaqvi.kmc.contracts.FamilyMembersContract;
import edu.aku.hassannaqvi.kmc.core.DatabaseHelper;
import edu.aku.hassannaqvi.kmc.core.MainApp;
import edu.aku.hassannaqvi.kmc.databinding.ActivitySectionC4Binding;
import edu.aku.hassannaqvi.kmc.validation.validatorClass;

public class SectionC4Activity extends AppCompatActivity {

    ActivitySectionC4Binding binding;
    DatabaseHelper db;
    FamilyMembersContract selectedChild;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_c4);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_section_c4);
        db = new DatabaseHelper(this);

        //        Assigning data to UI binding
        binding.setCallback(this);

        setupViews();
    }

    private void setupViews() {
        binding.nc403.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (binding.nc403a.isChecked()) {
                    binding.fldGrnc404.setVisibility(View.VISIBLE);
                } else {
                    binding.fldGrnc404.setVisibility(View.GONE);
                    binding.nc404.clearCheck();
                    binding.nc405.clearCheck();

                    binding.nc406a.setChecked(false);
                    binding.nc406b.setChecked(false);
                    binding.nc406c.setChecked(false);
                    binding.nc406d.setChecked(false);
                    binding.nc406e.setChecked(false);
                    binding.nc406f.setChecked(false);
                    binding.nc406g.setChecked(false);
                    binding.nc406h.setChecked(false);
                    binding.nc406i.setChecked(false);
                    binding.nc406j.setChecked(false);
                    binding.nc40696x.setText(null);

                    binding.nc4059601.setText(null);
                    binding.nc4059602.setText(null);
                    binding.nc4059603.setText(null);
                }
            }
        });
        binding.nc404.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (binding.nc404a.isChecked()) {
                    binding.nc405.setVisibility(View.VISIBLE);
                } else {
                    binding.nc405.setVisibility(View.GONE);
                    binding.nc405.clearCheck();

                    binding.nc4059601.setText(null);
                    binding.nc4059602.setText(null);
                    binding.nc4059603.setText(null);
                }
            }
        });

        binding.nc407.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (binding.nc407a.isChecked()) {
                    binding.fldGrnc408.setVisibility(View.VISIBLE);
                } else {
                    binding.fldGrnc408.setVisibility(View.GONE);
                    binding.nc408.clearCheck();
                    binding.nc409.clearCheck();

                    binding.nc4099601.setText(null);
                    binding.nc4099602.setText(null);
                    binding.nc4099603.setText(null);

                    binding.nc410a.setChecked(false);
                    binding.nc410b.setChecked(false);
                    binding.nc410c.setChecked(false);
                    binding.nc410d.setChecked(false);
                    binding.nc410e.setChecked(false);
                    binding.nc410f.setChecked(false);
                    binding.nc410g.setChecked(false);
                    binding.nc410h.setChecked(false);
                    binding.nc410i.setChecked(false);
                    binding.nc4109601x.setText(null);


                }
            }
        });
        binding.nc408.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (binding.nc408a.isChecked()) {
                    binding.nc409.setVisibility(View.VISIBLE);
                } else {
                    binding.nc409.setVisibility(View.GONE);
                    binding.nc409.clearCheck();

                    binding.nc4099601.setText(null);
                    binding.nc4099602.setText(null);
                    binding.nc4099603.setText(null);
                }
            }
        });

        binding.nc411.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (binding.nc411a.isChecked()) {
                    binding.fldGrnc412.setVisibility(View.VISIBLE);
                } else {
                    binding.fldGrnc412.setVisibility(View.GONE);
                    binding.nc412.clearCheck();
                    binding.nc413.clearCheck();

                    binding.nc4139601.setText(null);
                    binding.nc4139602.setText(null);
                    binding.nc4139603.setText(null);

                    binding.nc414a.setChecked(false);
                    binding.nc414b.setChecked(false);
                    binding.nc414c.setChecked(false);
                    binding.nc414d.setChecked(false);
                    binding.nc414e.setChecked(false);
                    binding.nc414f.setChecked(false);
                    binding.nc414g.setChecked(false);
                    binding.nc414h.setChecked(false);
                    binding.nc414i.setChecked(false);
                    binding.nc4149601x.setText(null);


                }
            }
        });
        binding.nc412.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (binding.nc412a.isChecked()) {
                    binding.nc413.setVisibility(View.VISIBLE);
                } else {
                    binding.nc413.setVisibility(View.GONE);
                    binding.nc413.clearCheck();

                    binding.nc4139601.setText(null);
                    binding.nc4139602.setText(null);
                    binding.nc4139603.setText(null);
                }
            }
        });

        //Get Intent
        selectedChild = (FamilyMembersContract) getIntent().getSerializableExtra("selectedChild");

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

                if (Integer.valueOf(selectedChild.getAgeInYear()) > 2) {
                    startActivity(new Intent(this, SectionC5Activity.class)
                            .putExtra("selectedChild", (Serializable) selectedChild));
                } else {

                    MainApp.endActivityMother(this, this, true);

                }

            } else {
                Toast.makeText(this, "Failed to Update Database!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void BtnEnd() {
        MainApp.endActivityMother(this, this, false);
    }

    private boolean formValidation() {
        Toast.makeText(this, "Validating This Section ", Toast.LENGTH_SHORT).show();

//       nc403
        if (!validatorClass.EmptyRadioButton(this, binding.nc403, binding.nc403b, getString(R.string.nc403))) {
            return false;
        }

//        nc404
        if (!validatorClass.EmptyRadioButton(this, binding.nc404, binding.nc404b, getString(R.string.nc404))) {
            return false;
        }

//        nc405
        if (!validatorClass.EmptyRadioButton(this, binding.nc405, binding.nc4059603, getString(R.string.nc405))) {
            return false;
        }
//        nc4059601
        if (!validatorClass.EmptyRadioButton(this, binding.nc405, binding.nc4059603, binding.nc4059601x, getString(R.string.nc405))) {
            return false;
        }
//        nc4059602
        if (!validatorClass.EmptyRadioButton(this, binding.nc405, binding.nc4059603, binding.nc4059602x, getString(R.string.nc405))) {
            return false;
        }
//        nc4059603
        if (!validatorClass.EmptyRadioButton(this, binding.nc405, binding.nc4059603, binding.nc4059603x, getString(R.string.nc405))) {
            return false;
        }

//        fldGrpnc406
        if (!validatorClass.EmptyCheckBox(this, binding.fldGrpnc406, binding.nc40696, binding.nc40696x, getString(R.string.nc406))) {
            return false;
        }


//       nc407
        if (!validatorClass.EmptyRadioButton(this, binding.nc407, binding.nc407b, getString(R.string.nc407))) {
            return false;
        }

//        nc408
        if (!validatorClass.EmptyRadioButton(this, binding.nc408, binding.nc408b, getString(R.string.nc408))) {
            return false;
        }

        // nc409
        if (!validatorClass.EmptyRadioButton(this, binding.nc409, binding.nc4099603, getString(R.string.nc409))) {
            return false;
        }

//        nc4099601x
        if (!validatorClass.EmptyRadioButton(this, binding.nc409, binding.nc4099603, binding.nc4099601x, getString(R.string.nc409))) {
            return false;
        }
//        nc4099602x
        if (!validatorClass.EmptyRadioButton(this, binding.nc409, binding.nc4099603, binding.nc4099602x, getString(R.string.nc409))) {
            return false;
        }
//        nc4099603x
        if (!validatorClass.EmptyRadioButton(this, binding.nc409, binding.nc4099603, binding.nc4099603x, getString(R.string.nc409))) {
            return false;
        }

        //    fldGrnc410check
        if (!validatorClass.EmptyCheckBox(this, binding.fldGrnc410check, binding.nc4109601, binding.nc4109601x, getString(R.string.nc410))) {
            return false;
        }


//       nc411
        if (!validatorClass.EmptyRadioButton(this, binding.nc411, binding.nc411b, getString(R.string.nc411))) {
            return false;
        }

//        nc412
        if (!validatorClass.EmptyRadioButton(this, binding.nc412, binding.nc412b, getString(R.string.nc412))) {
            return false;
        }

        // nc413
        if (!validatorClass.EmptyRadioButton(this, binding.nc413, binding.nc4139603, getString(R.string.nc413))) {
            return false;
        }

//        nc4139601x
        if (!validatorClass.EmptyRadioButton(this, binding.nc413, binding.nc4139603, binding.nc4139601x, getString(R.string.nc413))) {
            return false;
        }
//        nc4139602x
        if (!validatorClass.EmptyRadioButton(this, binding.nc413, binding.nc4139603, binding.nc4139602x, getString(R.string.nc413))) {
            return false;
        }
//        nc4139603x
        if (!validatorClass.EmptyRadioButton(this, binding.nc413, binding.nc4139603, binding.nc4139603x, getString(R.string.nc413))) {
            return false;
        }
        // nc414
        if (!validatorClass.EmptyCheckBox(this, binding.fldGrnc414check, binding.nc4149601, binding.nc4149601x, getString(R.string.nc414))) {
            return false;
        }

//       nc415
        if (!validatorClass.EmptyRadioButton(this, binding.nc415, binding.nc41598, getString(R.string.nc415))) {
            return false;
        }

//        nc416
        return validatorClass.EmptyRadioButton(this, binding.nc416, binding.nc41698, getString(R.string.nc416));
    }

    private void SaveDraft() throws JSONException {
        Toast.makeText(this, "Saving Draft for  This Section", Toast.LENGTH_SHORT).show();

        JSONObject sC4 = new JSONObject();

//        nc301
        sC4.put("nc401", selectedChild.getName());
//        nc302
        sC4.put("nc402Serial", selectedChild.getSerialNo());

//        nc403
        sC4.put("nc403", binding.nc403a.isChecked() ? "1"
                : binding.nc403b.isChecked() ? "2"
                : "0");

//      nc404
        sC4.put("nc404", binding.nc404a.isChecked() ? "1"
                : binding.nc404b.isChecked() ? "2"
                : "0");


//        nc405
        sC4.put("nc405", binding.nc405a.isChecked() ? "1"
                : binding.nc405b.isChecked() ? "2"
                : binding.nc405c.isChecked() ? "3"
                : binding.nc405d.isChecked() ? "4"
                : binding.nc405e.isChecked() ? "5"
                : binding.nc4059601.isChecked() ? "961"
                : binding.nc405f.isChecked() ? "6"
                : binding.nc405g.isChecked() ? "7"
                : binding.nc405h.isChecked() ? "8"
                : binding.nc405i.isChecked() ? "9"
                : binding.nc405j.isChecked() ? "10"
                : binding.nc4059602.isChecked() ? "962"
                : binding.nc405k.isChecked() ? "11"
                : binding.nc405l.isChecked() ? "12"
                : binding.nc405m.isChecked() ? "13"
                : binding.nc4059603.isChecked() ? "963"
                : "0");


        sC4.put("nc4059601x", binding.nc4059601x.getText().toString());
        sC4.put("nc4059602x", binding.nc4059602x.getText().toString());
        sC4.put("nc4059603x", binding.nc4059603x.getText().toString());

//     nc406
        sC4.put("nc406a", binding.nc406a.isChecked() ? "1" : "0");
        sC4.put("nc406b", binding.nc406b.isChecked() ? "2" : "0");
        sC4.put("nc406c", binding.nc406c.isChecked() ? "3" : "0");
        sC4.put("nc406d", binding.nc406d.isChecked() ? "4" : "0");
        sC4.put("nc406e", binding.nc406e.isChecked() ? "5" : "0");
        sC4.put("nc406f", binding.nc406f.isChecked() ? "6" : "0");
        sC4.put("nc406g", binding.nc406g.isChecked() ? "7" : "0");
        sC4.put("nc406h", binding.nc406h.isChecked() ? "8" : "0");
        sC4.put("nc406i", binding.nc406i.isChecked() ? "9" : "0");
        sC4.put("nc406j", binding.nc406j.isChecked() ? "10" : "0");
        sC4.put("nc40696", binding.nc40696.isChecked() ? "96" : "0");

        sC4.put("nc40696x", binding.nc40696x.getText().toString());

//        nc407
        sC4.put("nc407", binding.nc407a.isChecked() ? "1"
                : binding.nc407b.isChecked() ? "2"
                : "0");

//      nc408
        sC4.put("nc408", binding.nc408a.isChecked() ? "1"
                : binding.nc408b.isChecked() ? "2"
                : "0");


//        nc409
        sC4.put("nc409", binding.nc409a.isChecked() ? "1"
                : binding.nc409b.isChecked() ? "2"
                : binding.nc409c.isChecked() ? "3"
                : binding.nc409d.isChecked() ? "4"
                : binding.nc409e.isChecked() ? "5"
                : binding.nc4099601.isChecked() ? "961"
                : binding.nc409f.isChecked() ? "6"
                : binding.nc409g.isChecked() ? "7"
                : binding.nc409h.isChecked() ? "8"
                : binding.nc409i.isChecked() ? "9"
                : binding.nc409j.isChecked() ? "10"
                : binding.nc4099602.isChecked() ? "962"
                : binding.nc409k.isChecked() ? "11"
                : binding.nc409l.isChecked() ? "12"
                : binding.nc409m.isChecked() ? "13"
                : binding.nc4099603.isChecked() ? "963"
                : "0");


        sC4.put("nc4099601x", binding.nc4099601x.getText().toString());
        sC4.put("nc4099602x", binding.nc4099602x.getText().toString());
        sC4.put("nc4099603x", binding.nc4099603x.getText().toString());

//     nc410
        sC4.put("nc410a", binding.nc410a.isChecked() ? "1" : "0");
        sC4.put("nc410b", binding.nc410b.isChecked() ? "2" : "0");
        sC4.put("nc410c", binding.nc410c.isChecked() ? "3" : "0");
        sC4.put("nc410d", binding.nc410d.isChecked() ? "4" : "0");
        sC4.put("nc410e", binding.nc410e.isChecked() ? "5" : "0");
        sC4.put("nc410f", binding.nc410f.isChecked() ? "6" : "0");
        sC4.put("nc410g", binding.nc410g.isChecked() ? "7" : "0");
        sC4.put("nc410h", binding.nc410h.isChecked() ? "8" : "0");
        sC4.put("nc410i", binding.nc410i.isChecked() ? "9" : "0");
        sC4.put("nc4109601", binding.nc4109601.isChecked() ? "96" : "0");

        sC4.put("nc4109601x", binding.nc4109601x.getText().toString());


//        nc411
        sC4.put("nc411", binding.nc411a.isChecked() ? "1"
                : binding.nc411b.isChecked() ? "2"
                : "0");

//      nc412
        sC4.put("nc412", binding.nc412a.isChecked() ? "1"
                : binding.nc412b.isChecked() ? "2"
                : "0");


//        nc413
        sC4.put("nc413", binding.nc414a.isChecked() ? "1"
                : binding.nc413b.isChecked() ? "2"
                : binding.nc413c.isChecked() ? "3"
                : binding.nc413d.isChecked() ? "4"
                : binding.nc413e.isChecked() ? "5"
                : binding.nc4139601.isChecked() ? "961"
                : binding.nc413f.isChecked() ? "6"
                : binding.nc413g.isChecked() ? "7"
                : binding.nc413h.isChecked() ? "8"
                : binding.nc413i.isChecked() ? "9"
                : binding.nc413j.isChecked() ? "10"
                : binding.nc4139602.isChecked() ? "962"
                : binding.nc413k.isChecked() ? "11"
                : binding.nc413l.isChecked() ? "12"
                : binding.nc413m.isChecked() ? "13"
                : binding.nc4139603.isChecked() ? "963"
                : "0");


        sC4.put("nc4139601x", binding.nc4139601x.getText().toString());
        sC4.put("nc4139602x", binding.nc4139602x.getText().toString());
        sC4.put("nc4139603x", binding.nc4139603x.getText().toString());

//     nc414
        sC4.put("nc414a", binding.nc414a.isChecked() ? "1" : "0");
        sC4.put("nc414b", binding.nc414b.isChecked() ? "2" : "0");
        sC4.put("nc414c", binding.nc414c.isChecked() ? "3" : "0");
        sC4.put("nc414d", binding.nc414d.isChecked() ? "4" : "0");
        sC4.put("nc414e", binding.nc414e.isChecked() ? "5" : "0");
        sC4.put("nc414f", binding.nc414f.isChecked() ? "6" : "0");
        sC4.put("nc414g", binding.nc414g.isChecked() ? "7" : "0");
        sC4.put("nc414h", binding.nc414h.isChecked() ? "8" : "0");
        sC4.put("nc414i", binding.nc414i.isChecked() ? "9" : "0");
        sC4.put("nc4149601", binding.nc4149601.isChecked() ? "96" : "0");

        sC4.put("nc4149601x", binding.nc4149601x.getText().toString());


//        nc415
        sC4.put("nc415", binding.nc415a.isChecked() ? "1"
                : binding.nc415b.isChecked() ? "2"
                : binding.nc41698.isChecked() ? "98"
                : "0");

//      nc416
        sC4.put("nc416", binding.nc416a.isChecked() ? "1"
                : binding.nc416b.isChecked() ? "2"
                : binding.nc41698.isChecked() ? "98"
                : "0");

        MainApp.cc.setsC4(String.valueOf(sC4));

        Toast.makeText(this, "Validation Successful! - Saving Draft...", Toast.LENGTH_SHORT).show();
    }

    private boolean UpdateDB() {

        //Long rowId;
        DatabaseHelper db = new DatabaseHelper(this);

        int updcount = db.updateSC4();

        if (updcount == 1) {
            Toast.makeText(this, "Updating Database... Successful!", Toast.LENGTH_SHORT).show();
            return true;
        } else {
            Toast.makeText(this, "Updating Database... ERROR!", Toast.LENGTH_SHORT).show();
            return false;
        }
    }


}