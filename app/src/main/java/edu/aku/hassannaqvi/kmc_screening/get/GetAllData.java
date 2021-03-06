package edu.aku.hassannaqvi.kmc_screening.get;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import edu.aku.hassannaqvi.kmc_screening.contracts.EligibleContract;
import edu.aku.hassannaqvi.kmc_screening.contracts.MortalityContract;
import edu.aku.hassannaqvi.kmc_screening.contracts.PWFollowUpContract;
import edu.aku.hassannaqvi.kmc_screening.contracts.PWScreenedContract;
import edu.aku.hassannaqvi.kmc_screening.contracts.RecruitmentContract;
import edu.aku.hassannaqvi.kmc_screening.contracts.RegisteredPWContract;
import edu.aku.hassannaqvi.kmc_screening.contracts.TalukasContract;
import edu.aku.hassannaqvi.kmc_screening.contracts.UCsContract;
import edu.aku.hassannaqvi.kmc_screening.contracts.UsersContract;
import edu.aku.hassannaqvi.kmc_screening.contracts.VillagesContract;
import edu.aku.hassannaqvi.kmc_screening.core.DatabaseHelper;
import edu.aku.hassannaqvi.kmc_screening.core.MainApp;

/**
 * Created by ali.azaz on 7/14/2017.
 * Updated by ali.azaz on 4/29/2019.
 */

public class GetAllData extends AsyncTask<String, String, String> {

    HttpURLConnection urlConnection;
    private String TAG = "";
    private Context mContext;
    private ProgressDialog pd;

    private String syncClass;


    public  GetAllData(Context context, String syncClass) {
        mContext = context;
        this.syncClass = syncClass;
        TAG = "Get" + syncClass;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        pd = new ProgressDialog(mContext);
        pd.setTitle("Syncing " + syncClass);
        pd.setMessage("Getting connected to server...");
        pd.show();
    }

    @Override
    protected String doInBackground(String... args) {
        StringBuilder result = null;

        for (String hostItem : MainApp.HOST) {

            URL url = null;
            try {
                switch (syncClass) {
                    case "Users":
                        url = new URL(hostItem + UsersContract.UsersTable._URI);
                        break;
                    case "PWs":
                        url = new URL(hostItem + PWFollowUpContract.PWFUPEntry._URI);
                        break;
                    case "PWScreened":
                        url = new URL(hostItem + PWScreenedContract.PWFScrennedEntry._URI);
                        break;
                    case "Eligibiles":
                        url = new URL(hostItem + EligibleContract.EligibleEntry._URI);
                        break;
                    case "Recruitments":
                        url = new URL(hostItem + RecruitmentContract.RecruitmentEntry._URI);
                        break;
                    case "Talukas":
                        url = new URL(hostItem + TalukasContract.SingleTaluka._URI);
                        break;
                    case "UCs":
                        url = new URL(hostItem + UCsContract.UCsTable._URI);
                        break;
                    case "Villages":
                        url = new URL(hostItem + VillagesContract.SingleVillage._URI);
                        break;
                    case "RegisteredPW":
                        url = new URL(hostItem + RegisteredPWContract.RegisteredPW._URI);
                        break;
                    case "RegisteredPWF1":
                        url = new URL(hostItem + RegisteredPWContract.RegisteredPW._URI1);
                        break;
                    case "RegisteredPWF0b":
                        url = new URL(hostItem + RegisteredPWContract.RegisteredPW._URI0b);
                        break;
                    case "RegisteredPWF2":
                        url = new URL(hostItem + RegisteredPWContract.RegisteredPW._URI2);
                        break;
                    case "RegisteredPWF3":
                        url = new URL(hostItem + RegisteredPWContract.RegisteredPW._URI3);
                        break;
                    case "Mortality":
                        url = new URL(hostItem + MortalityContract.SingleMortality._URI);
                        break;
                }

                urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.setReadTimeout(100000 /* milliseconds */);
                urlConnection.setConnectTimeout(150000 /* milliseconds */);
                Log.d(TAG, "doInBackground: " + urlConnection.getResponseCode());

                result = new StringBuilder();

                if (urlConnection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                    InputStream in = new BufferedInputStream(urlConnection.getInputStream());

                    BufferedReader reader = new BufferedReader(new InputStreamReader(in));

                    String line;
                    while ((line = reader.readLine()) != null) {
                        Log.i(TAG, syncClass + " In: " + line);
                        result.append(line);
                    }

                    return result.toString();
                }
            } catch (IOException ignored) {
            }
        }

        urlConnection.disconnect();

        return result == null ? null : result.toString();

    }

    @Override
    protected void onPostExecute(String result) {

        //Do something with the JSON string
        if (result != null) {
            if (result.length() > 0) {
                DatabaseHelper db = new DatabaseHelper(mContext);
                try {
                    JSONArray jsonArray = new JSONArray(result);

                    switch (syncClass) {
                        case "PWs":
                            db.syncPWS(jsonArray);
                            break;
                        case "PWScreened":
                            db.syncPWSScreened(jsonArray);
                            break;
                        case "Eligibiles":
                            db.syncEligibiles(jsonArray);
                            break;
                        case "Recruitments":
                            db.syncRecruitments(jsonArray);
                            break;
                        case "Users":
                            db.syncUser(jsonArray);
                            break;
                        case "Talukas":
                            db.syncTalukas(jsonArray);
                            break;
                        case "UCs":
                            db.syncUCs(jsonArray);
                            break;
                        case "Villages":
                            db.syncVillages(jsonArray);
                            break;
                        case "Mortality":
                            db.syncMortality(jsonArray);
                            break;
                        case "RegisteredPW":
                            db.syncRegisteredPW(MainApp.FORMTYPE0, jsonArray);
                            break;
                        case "RegisteredPWF0b":
                            db.syncRegisteredPW(MainApp.FORMTYPE0b, jsonArray);
                            break;
                        case "RegisteredPWF1":
                            db.syncRegisteredPW(MainApp.FORMTYPE1, jsonArray);
                            break;
                        case "RegisteredPWF2":
                            db.syncRegisteredPW(MainApp.FORMTYPE2, jsonArray);
                            break;
                        case "RegisteredPWF3":
                            db.syncRegisteredPW(MainApp.FORMTYPE3, jsonArray);
                            break;
                    }

                    pd.setMessage("Received: " + jsonArray.length());
                    pd.show();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            } else {
                pd.setMessage("Received: " + result.length() + "");
                pd.show();
            }
        } else {
            pd.setTitle("Connection Error");
            pd.setMessage("Server not found!");
            pd.show();
        }
    }

}
