package edu.aku.hassannaqvi.kmc_screening.ui.other;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.StrictMode;
import android.text.InputType;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.bumptech.glide.Glide;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Map;
import java.util.Objects;

import edu.aku.hassannaqvi.kmc_screening.R;
import edu.aku.hassannaqvi.kmc_screening.contracts.FormsContract;
import edu.aku.hassannaqvi.kmc_screening.core.AndroidDatabaseManager;
import edu.aku.hassannaqvi.kmc_screening.core.DatabaseHelper;
import edu.aku.hassannaqvi.kmc_screening.core.MainApp;
import edu.aku.hassannaqvi.kmc_screening.databinding.ActivityMainBinding;
import edu.aku.hassannaqvi.kmc_screening.get.DownalodDataTask;
import edu.aku.hassannaqvi.kmc_screening.sync.SyncAllData;
import edu.aku.hassannaqvi.kmc_screening.ui.SectionInfoKmcActivity;
import edu.aku.hassannaqvi.kmc_screening.ui.form0.SectionAForm0Activity;
import edu.aku.hassannaqvi.kmc_screening.ui.mortality.SectionMRAActivity;
import edu.aku.hassannaqvi.kmc_screening.ui.utils.DashboardMenu;

public class MainActivity extends AppCompatActivity {

    private final String TAG = "MainActivity";
    private String dtToday = new SimpleDateFormat("dd-MM-yy HH:mm").format(new Date().getTime());
    private SharedPreferences sharedPref;
    private SharedPreferences.Editor editor;
    private AlertDialog.Builder builder;
    private String m_Text = "", rSumText = "";
    private Boolean exit = false;
    private DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        Binding setting
        ActivityMainBinding bi = DataBindingUtil.setContentView(this, R.layout.activity_main);
        bi.setCallback(this);

        db = new DatabaseHelper(this);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        bi.lblheader.setText(String.format("Welcome! %s", MainApp.userName));

//        TagID Start
        sharedPref = getSharedPreferences("tagName", MODE_PRIVATE);
        editor = sharedPref.edit();

        builder = new AlertDialog.Builder(MainActivity.this);
        final AlertDialog dialog = builder.create();

        ImageView img = new ImageView(this);
        img.setImageResource(R.drawable.tagimg);
        img.setPadding(0, 15, 0, 15);
        builder.setCustomTitle(img);

        final EditText input = new EditText(MainActivity.this);
        input.setInputType(InputType.TYPE_CLASS_TEXT);
        input.requestFocus();
        input.setOnFocusChangeListener((view, b) -> {
            if (b) {
                dialog.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
            }
        });

        //Setting default value in tagName
        editor.putString("tagName", null);
        editor.apply();

        builder.setView(input);
        builder.setPositiveButton("OK", (dialog1, which) -> {
            m_Text = input.getText().toString();
            if (!m_Text.equals("")) {
                editor.putString("tagName", m_Text);
                editor.apply();
            }
        });
        builder.setNegativeButton("Cancel", (dialog12, which) -> dialog12.cancel());

        if (sharedPref.getString("tagName", null) == "" || sharedPref.getString("tagName", null) == null) {
            builder.show();
        }
//        TagID End

//        Admin checking
        bi.openDB.setVisibility(MainApp.admin ? View.VISIBLE : View.GONE);
        if (MainApp.admin) {
            bi.openDB.setVisibility(View.VISIBLE);

            Collection<FormsContract> todaysForms = db.getTodayForms();

            rSumText += "TODAY'S RECORDS SUMMARY\r\n";

            rSumText += "=======================\r\n";
            rSumText += "\r\n";
            rSumText += "Total Forms Today: " + todaysForms.size() + "\r\n";
            rSumText += "\r\n";
            if (todaysForms.size() > 0) {
                rSumText += "\tFORMS' LIST: \r\n";
                String iStatus;
                rSumText += "--------------------------------------------------\r\n";
                rSumText += "[ DSS_ID ] \t[Form Status] \t[Sync Status]----------\r\n";
                rSumText += "--------------------------------------------------\r\n";

                for (FormsContract fc : todaysForms) {
                    if (fc.getIstatus() != null) {
                        switch (fc.getIstatus()) {
                            case "1":
                                iStatus = "\tComplete";
                                break;
                            case "2":
                                iStatus = "\tIncomplete";
                                break;
                            case "3":
                                iStatus = "\tRefused";
                                break;
                            case "4":
                                iStatus = "\tRefused";
                                break;
                            default:
                                iStatus = "\tN/A";
                        }
                    } else {
                        iStatus = "\tN/A";
                    }

                    //rSumText += fc.getDSSID();

                    rSumText += " " + iStatus + " ";

                    rSumText += (fc.getSynced() == null ? "\t\tNot Synced" : "\t\tSynced");
                    rSumText += "\r\n";
                    rSumText += "--------------------------------------------------\r\n";
                }
            }

            SharedPreferences syncPref = getSharedPreferences("SyncInfo", Context.MODE_PRIVATE);
            rSumText += "Last Data Download: \t" + syncPref.getString("LastDownSyncServer", "Never Updated");
            rSumText += "\r\n";
            rSumText += "Last Data Upload: \t" + syncPref.getString("LastUpSyncServer", "Never Synced");
            rSumText += "\r\n";
            rSumText += "\r\n";

            Log.d(TAG, "onCreate: " + rSumText);
            bi.recordSummary.setText(rSumText);

        } else {
            bi.openDB.setVisibility(View.GONE);
        }

//        Populating Menu Items
        DashboardMenu[] menuItems = {
                new DashboardMenu(R.drawable.pw_reg, getString(R.string.pw_reg)),
                new DashboardMenu(R.drawable.pw_survey, getString(R.string.pw_sur)),
                new DashboardMenu(R.drawable.f1_screening, "Form-1\nParticipant Screening"),
                new DashboardMenu(R.drawable.f2_recruitment, "Form-2\nRecruitment Form"),
                new DashboardMenu(R.drawable.f3_followup, "Form-3\nFollowUP Form"),
                new DashboardMenu(R.drawable.f_mr, "Neonatal Mortality\n(0-28 Days)")
        };

        ImageView[] imageViews = {bi.pwReg.itemImg, bi.pwSurv.itemImg, bi.form01Eligible.itemImg, bi.form02Rec.itemImg, bi.form03FUp.itemImg, bi.formMR.itemImg};
        TextView[] txtViews = {bi.pwReg.itemTitle, bi.pwSurv.itemTitle, bi.form01Eligible.itemTitle, bi.form02Rec.itemTitle, bi.form03FUp.itemTitle, bi.formMR.itemTitle};

        for (int i = 0; i < menuItems.length; i++) {
            Glide.with(this)
                    .asBitmap()
                    .load(menuItems[i].getImageSrc())
                    .into(imageViews[i]);
            txtViews[i].setText(menuItems[i].getLbl());
        }

    }

    public void openForm(int index) {
        if (!MainApp.userName.equals("0000")) {
            Intent oF = new Intent(MainActivity.this, getClass(index));
            if (sharedPref.getString("tagName", null) != null && !Objects.equals(sharedPref.getString("tagName", null), "")) {
                startActivity(oF);
            } else {

                builder = new AlertDialog.Builder(MainActivity.this);
                ImageView img = new ImageView(this);
                img.setImageResource(R.drawable.tagimg);
                img.setPadding(0, 15, 0, 15);
                builder.setCustomTitle(img);

                final EditText input = new EditText(MainActivity.this);
                input.setInputType(InputType.TYPE_CLASS_TEXT);
                builder.setView(input);


                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        m_Text = input.getText().toString();
                        if (!m_Text.equals("")) {
                            editor.putString("tagName", m_Text);
                            editor.commit();

                            if (!MainApp.userName.equals("0000")) {
                                startActivity(oF);
                            }
                        }
                    }
                });
                builder.setNegativeButton("Cancel", (dialog, which) -> dialog.cancel());
                builder.show();
            }
        } else {
            Toast.makeText(this, "Please restart the app", Toast.LENGTH_SHORT).show();
        }

    }

    private Class<?> getClass(int a) {
        Class<?> intentClass = null;
        switch (a) {
            case 0:
                MainApp.surveyType = "kf0a";
                MainApp.formType = "kf0";
                intentClass = SectionAForm0Activity.class;
                break;
            case 1:
                MainApp.surveyType = "kf0b";
                MainApp.formType = "kf0";
                intentClass = SectionAForm0Activity.class;
                break;
            case 2:
                MainApp.formType = "kf1";
                MainApp.surveyType = "kf1";
                intentClass = SectionInfoKmcActivity.class;
                break;
            case 3:
                MainApp.formType = "kf2";
                MainApp.surveyType = "kf2";
                intentClass = SectionInfoKmcActivity.class;
                break;
            case 4:
                MainApp.formType = "kf3";
                MainApp.surveyType = "kf3";
                intentClass = SectionInfoKmcActivity.class;
                break;
            case 5:
                MainApp.formType = "mr";
                intentClass = SectionMRAActivity.class;
                break;
            default:
                break;
        }

        return intentClass;
    }

    public void testGPS(View v) {
        SharedPreferences sharedPref = getSharedPreferences("GPSCoordinates", Context.MODE_PRIVATE);
        Log.d("MAP", "testGPS: " + sharedPref.getAll().toString());
        Map<String, ?> allEntries = sharedPref.getAll();
        for (Map.Entry<String, ?> entry : allEntries.entrySet()) {
            Log.d("Map", entry.getKey() + ": " + entry.getValue().toString());
        }
    }

    public void openDB(View v) {
        Intent dbmanager = new Intent(this, AndroidDatabaseManager.class);
        startActivity(dbmanager);
    }

    public void syncServer() {

        // Require permissions INTERNET & ACCESS_NETWORK_STATE
        ConnectivityManager connMgr = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) {

            Toast.makeText(this, "Syncing Forms - PW Registration", Toast.LENGTH_SHORT).show();
            new SyncAllData(
                    this,
                    "Forms - PW Registration",
                    "updateSyncedForms",
                    FormsContract.class,
                    FormsContract.FormsTable._URL.replace(".php", "_f0a.php"),
                    db.getUnsyncedForms0("kf0", "kf0a")
            ).execute();

            Toast.makeText(this, "Syncing Forms - PW Survillence", Toast.LENGTH_SHORT).show();
            new SyncAllData(
                    this,
                    "Forms - PW Survillence",
                    "updateSyncedForms",
                    FormsContract.class,
                    FormsContract.FormsTable._URL.replace(".php", "_f0b.php"),
                    db.getUnsyncedForms0("kf0", "kf0b")
            ).execute();

            Toast.makeText(this, "Syncing Forms - PW Screening", Toast.LENGTH_SHORT).show();
            new SyncAllData(
                    this,
                    "Forms - PW Screening",
                    "updateSyncedForms",
                    FormsContract.class,
                    FormsContract.FormsTable._URL.replace(".php", "_f1.php"),
                    db.getUnsyncedForms("kf1")
            ).execute();

            Toast.makeText(this, "Syncing Forms - PW Recruitment", Toast.LENGTH_SHORT).show();
            new SyncAllData(
                    this,
                    "Forms - PW Recruitment",
                    "updateSyncedForms",
                    FormsContract.class,
                    FormsContract.FormsTable._URL.replace(".php", "_f2.php"),
                    db.getUnsyncedForms("kf2")
            ).execute();

            Toast.makeText(this, "Syncing Forms - PW FOLLOWUPS", Toast.LENGTH_SHORT).show();
            new SyncAllData(
                    this,
                    "Forms - PW FOLLOWUPS",
                    "updateSyncedForms",
                    FormsContract.class,
                    FormsContract.FormsTable._URL.replace(".php", "_f3.php"),
                    db.getUnsyncedForms("kf3")
            ).execute();

            Toast.makeText(this, "Syncing Forms - MORTALITY", Toast.LENGTH_SHORT).show();
            new SyncAllData(
                    this,
                    "Forms - MORTALITY",
                    "updateSyncedForms",
                    FormsContract.class,
                    FormsContract.FormsTable._URL.replace(".php", "_mr.php"),
                    db.getUnsyncedForms("mr")
            ).execute();

            SharedPreferences syncPref = getSharedPreferences("SyncInfo", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = syncPref.edit();

            editor.putString("LastUpSyncServer", dtToday);

            editor.apply();

        } else {
            Toast.makeText(this, "No network connection available.", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onBackPressed() {
        if (exit) {
            finish(); // finish activity

            startActivity(new Intent(this, LoginActivity.class));

        } else {
            Toast.makeText(this, "Press Back again to Exit.",
                    Toast.LENGTH_SHORT).show();
            exit = true;
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    exit = false;
                }
            }, 3 * 1000);

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //Menu Setting
        getMenuInflater().inflate(R.menu.item_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.onSync:
                new DownalodDataTask(this, this).execute(false);
                break;
            case R.id.onUpload:
                syncServer();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}