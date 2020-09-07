package edu.aku.hassannaqvi.kmc_screening.get;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Handler;
import android.widget.Toast;

import java.lang.ref.WeakReference;

import edu.aku.hassannaqvi.kmc_screening.core.MainApp;

import static android.content.Context.MODE_PRIVATE;

public class DownalodDataTask extends AsyncTask<Boolean, String, String> {

    private WeakReference<Context> mContext;
    private WeakReference<Activity> activity;
    private SharedPreferences.Editor editor;

    public DownalodDataTask(Context mContext, Activity activity) {
        this.mContext = new WeakReference<>(mContext);
        this.activity = new WeakReference<>(activity);
        SharedPreferences sharedPref = this.mContext.get().getSharedPreferences("kmc", MODE_PRIVATE);
        editor = sharedPref.edit();
    }

    @Override
    protected String doInBackground(Boolean... strings) {
        activity.get().runOnUiThread(() -> {
            if (strings[0]) {
                Toast.makeText(mContext.get(), "Sync Users", Toast.LENGTH_LONG).show();
                new GetAllData(mContext.get(), "Users").execute();
                Toast.makeText(mContext.get(), "Sync Talukas", Toast.LENGTH_LONG).show();
                new GetAllData(mContext.get(), "Talukas").execute();
                Toast.makeText(mContext.get(), "Sync UCs", Toast.LENGTH_LONG).show();
                new GetAllData(mContext.get(), "UCs").execute();
                Toast.makeText(mContext.get(), "Sync Villages", Toast.LENGTH_LONG).show();
                new GetAllData(mContext.get(), "Villages").execute();
                Toast.makeText(mContext.get(), "Sync PWs", Toast.LENGTH_LONG).show();
                new GetAllData(mContext.get(), "PWs").execute();
                Toast.makeText(mContext.get(), "Sync PWScreened", Toast.LENGTH_LONG).show();
                new GetAllData(mContext.get(), "PWScreened").execute();
            } else {
                Toast.makeText(mContext.get(), "Sync Eligibiles", Toast.LENGTH_LONG).show();
                new GetAllData(mContext.get(), "Eligibiles").execute();
                Toast.makeText(mContext.get(), "Sync Recruitments", Toast.LENGTH_LONG).show();
                new GetAllData(mContext.get(), "Recruitments").execute();
                Toast.makeText(mContext.get(), "Sync RegisteredPW", Toast.LENGTH_LONG).show();
                new GetAllData(mContext.get(), "RegisteredPW").execute();
                Toast.makeText(mContext.get(), "Sync RegisteredPWF1", Toast.LENGTH_LONG).show();
                new GetAllData(mContext.get(), "RegisteredPWF1").execute();
                Toast.makeText(mContext.get(), "Sync RegisteredPWF2", Toast.LENGTH_LONG).show();
                new GetAllData(mContext.get(), "RegisteredPWF2").execute();
                Toast.makeText(mContext.get(), "Sync RegisteredPWF3", Toast.LENGTH_LONG).show();
                new GetAllData(mContext.get(), "RegisteredPWF3").execute();
            }
        });

        return null;
    }

    @Override
    protected void onPostExecute(String s) {
        new Handler().postDelayed(() -> {
            editor.putBoolean("flag", true);
            editor.commit();
            MainApp.dbBackup(mContext.get());
        }, 1200);
    }
}