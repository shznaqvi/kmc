package edu.aku.hassannaqvi.kmc_screening.get;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import edu.aku.hassannaqvi.kmc_screening.contracts.PWContract;
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


    public GetAllData(Context context, String syncClass) {
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
                        url = new URL(hostItem + PWContract.PWEntry._URI);
                        break;
                    case "Talukas":
                        url = new URL(hostItem + TalukasContract.singleTaluka._URI);
                        break;
                    case "UCs":
                        url = new URL(hostItem + UCsContract.UCsTable._URI);
                        break;
                    case "Villages":
                        url = new URL(hostItem + VillagesContract.singleVillage._URI);
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
            } catch (java.net.SocketTimeoutException e) {
                continue;
            } catch (java.io.IOException e) {
                continue;
            }
        }

        urlConnection.disconnect();

        return result == null ? null : result.toString();

    }

    @Override
    protected void onPostExecute(String result) {

        //Do something with the JSON string
        if (result != null) {
            String json = result;
            if (json.length() > 0) {
                DatabaseHelper db = new DatabaseHelper(mContext);
                try {
                    JSONArray jsonArray = new JSONArray(json);

                    switch (syncClass) {
                        case "PWs":
                            db.syncPWS(jsonArray);
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
                    }

                    pd.setMessage("Received: " + jsonArray.length());
                    pd.show();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            } else {
                pd.setMessage("Received: " + json.length() + "");
                pd.show();
            }
        } else {
            pd.setTitle("Connection Error");
            pd.setMessage("Server not found!");
            pd.show();
        }
    }

}
