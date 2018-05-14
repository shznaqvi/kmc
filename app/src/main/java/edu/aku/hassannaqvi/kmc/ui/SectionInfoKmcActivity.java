package edu.aku.hassannaqvi.kmc.ui;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.os.Bundle;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;

import edu.aku.hassannaqvi.kmc.R;
import edu.aku.hassannaqvi.kmc.databinding.ActivitySectionInfoKmcBinding;

public class SectionInfoKmcActivity extends Activity {

    private static final String TAG = SectionAActivity.class.getName();
    String dtToday = new SimpleDateFormat("dd-MM-yy HH:mm").format(new Date().getTime());

    ActivitySectionInfoKmcBinding bi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_section_info_kmc);

        bi = DataBindingUtil.setContentView(this, R.layout.activity_section_info_kmc);
        bi.setCallback(this);
        //setupViews();
    }

    private void setupViews() {


    }


    private boolean formValidation() {

        return true;
    }


    private void SaveDraft() throws JSONException {

        JSONObject sInfo = new JSONObject();
    }

}