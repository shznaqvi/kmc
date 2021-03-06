package edu.aku.hassannaqvi.kmc_screening.ui.other;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.LoaderManager.LoaderCallbacks;
import android.content.Context;
import android.content.CursorLoader;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.Loader;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.text.method.PasswordTransformationMethod;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.github.amlcurran.showcaseview.ShowcaseView;
import com.github.amlcurran.showcaseview.targets.Target;
import com.github.amlcurran.showcaseview.targets.ViewTarget;
import com.nabinbhandari.android.permissions.PermissionHandler;
import com.nabinbhandari.android.permissions.Permissions;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import edu.aku.hassannaqvi.kmc_screening.R;
import edu.aku.hassannaqvi.kmc_screening.core.DatabaseHelper;
import edu.aku.hassannaqvi.kmc_screening.core.MainApp;
import edu.aku.hassannaqvi.kmc_screening.get.DownalodDataTask;

import static edu.aku.hassannaqvi.kmc_screening.core.MainApp.permissions;
import static java.lang.Thread.sleep;


/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends Activity implements LoaderCallbacks<Cursor> {

    /**
     * A dummy authentication store containing known user names and passwords.
     * TODO: remove after connecting to a real authentication system.
     */
    private static final String[] DUMMY_CREDENTIALS = new String[]{
            "test1234:test1234", "testS12345:testS12345", "bar@example.com:world"
    };

    // UI references.
    @BindView(R.id.login_progress)
    ProgressBar mProgressView;
    @BindView(R.id.login_form)
    ScrollView mLoginFormView;
    @BindView(R.id.email)
    EditText mEmailView;
    @BindView(R.id.password)
    EditText mPasswordView;
    @BindView(R.id.txt_password)
    TextView txt_password;
    @BindView(R.id.txtinstalldate)
    TextView txtinstalldate;
    @BindView(R.id.email_sign_in_button)
    Button mEmailSignInButton;
    @BindView(R.id.spUCs)
    Spinner spUCs;
    @BindView(R.id.spTaluka)
    Spinner spTalukas;
    @BindView(R.id.syncData)
    Button syncData;

    SharedPreferences sharedPref;
    SharedPreferences.Editor editor;
    String DirectoryName;
    DatabaseHelper db;
    private UserLoginTask mAuthTask = null;
    private int clicks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        try {

            String packageName = getApplicationContext().getPackageName();

            long installedOn = this
                    .getPackageManager()
                    .getPackageInfo(packageName, 0)
                    .lastUpdateTime;
            MainApp.versionCode = this
                    .getPackageManager()
                    .getPackageInfo(packageName, 0)
                    .versionCode;
            MainApp.versionName = this
                    .getPackageManager()
                    .getPackageInfo(packageName, 0)
                    .versionName;
            txtinstalldate.setText("Ver. " + MainApp.versionName + "." + MainApp.versionCode + " \r\n( Last Updated: " + new SimpleDateFormat("dd MMM. yyyy").format(new Date(installedOn)) + " )");
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }

        Permissions.check(LoginActivity.this, permissions, null/*rationale*/, null/*options*/, new PermissionHandler() {
            @Override
            public void onGranted() {
                // do your task.
                populateAutoComplete();
            }
        });

        Target viewTarget = new ViewTarget(R.id.syncData, this);

        new ShowcaseView.Builder(this)
                .setTarget(viewTarget)
                .setStyle(R.style.CustomShowcaseTheme)
                .setContentText("\n\nPlease Sync Data before login...")
                .singleShot(42)
                .build();

//        mPasswordView = findViewById(R.id.password);
        mPasswordView.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int id, KeyEvent keyEvent) {
                attemptLogin();

                return true;
            }
        });


        mEmailSignInButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Permissions.check(LoginActivity.this, permissions, null/*rationale*/, null/*options*/, new PermissionHandler() {
                    @Override
                    public void onGranted() {
                        // do your task.
                        attemptLogin();
                    }
                });
            }
        });

        db = new DatabaseHelper(this);

//        DB backup
        MainApp.dbBackup(this);
    }

    @OnClick(R.id.syncData)
    void onSyncDataClick() {
        //TODO implement

        // Require permissions INTERNET & ACCESS_NETWORK_STATE
        ConnectivityManager connMgr = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) {

            db.deleteRegisteredPW();

            new DownalodDataTask(this, this).execute(true);

        } else {
            Toast.makeText(this, "No network connection available.", Toast.LENGTH_SHORT).show();
        }
    }

    private void populateAutoComplete() {
        getLoaderManager().initLoader(0, null, this);
    }


    /**
     * Attempts to sign in or register the account specified by the login form.
     * If there are form errors (invalid email, missing fields, etc.), the
     * errors are presented and no actual login attempt is made.
     */
    private void attemptLogin() {
        if (mAuthTask != null) {
            return;
        }

        // Reset errors.
        mEmailView.setError(null);
        mPasswordView.setError(null);

        // Store values at the time of the login attempt.
        String email = mEmailView.getText().toString();
        String password = mPasswordView.getText().toString();

        boolean cancel = false;
        View focusView = null;

        // Check for a valid password, if the user entered one.
        if (!TextUtils.isEmpty(password) && !isPasswordValid(password)) {
            mPasswordView.setError(getString(R.string.error_invalid_password));
            focusView = mPasswordView;
            cancel = true;
        }

        // Check for a valid email address.
        if (TextUtils.isEmpty(email)) {
            mEmailView.setError(getString(R.string.error_field_required));
            focusView = mEmailView;
            cancel = true;
        } /*else if (!isEmailValid(email)) {
            mEmailView.setError(getString(R.string.error_invalid_email));
            focusView = mEmailView;
            cancel = true;
        }*/

        if (cancel) {
            // There was an error; don't attempt login and focus the first
            // form field with an error.
            focusView.requestFocus();
        } else {
            // Show a progress spinner, and kick off a background task to
            // perform the user login attempt.
            showProgress(true);
            mAuthTask = new UserLoginTask(email, password);
            mAuthTask.execute((Void) null);


        }
    }

    private boolean isEmailValid(String email) {
        //TODO: Replace this with your own logic
        return email.contains("@");
    }

    private boolean isPasswordValid(String password) {
        //TODO: Replace this with your own logic
        return password.length() >= 7;
    }

    /**
     * Shows the progress UI and hides the login form.
     */
    @TargetApi(Build.VERSION_CODES.HONEYCOMB_MR2)
    private void showProgress(final boolean show) {
        // On Honeycomb MR2 we have the ViewPropertyAnimator APIs, which allow
        // for very easy animations. If available, use these APIs to fade-in
        // the progress spinner.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR2) {
            int shortAnimTime = getResources().getInteger(android.R.integer.config_shortAnimTime);

            mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
            mLoginFormView.animate().setDuration(shortAnimTime).alpha(
                    show ? 0 : 1).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
                }
            });

            mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
            mProgressView.animate().setDuration(shortAnimTime).alpha(
                    show ? 1 : 0).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
                }
            });
        } else {
            // The ViewPropertyAnimator APIs are not available, so simply show
            // and hide the relevant UI components.
            mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
            mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
        }
    }

    @Override
    public Loader<Cursor> onCreateLoader(int i, Bundle bundle) {
        return new CursorLoader(this,
                // Retrieve data rows for the device user's 'profile' contact.
                Uri.withAppendedPath(ContactsContract.Profile.CONTENT_URI,
                        ContactsContract.Contacts.Data.CONTENT_DIRECTORY), ProfileQuery.PROJECTION,

                // Select only email addresses.
                ContactsContract.Contacts.Data.MIMETYPE +
                        " = ?", new String[]{ContactsContract.CommonDataKinds.Email
                .CONTENT_ITEM_TYPE},

                // Show primary email addresses first. Note that there won't be
                // a primary email address if the user hasn't specified one.
                ContactsContract.Contacts.Data.IS_PRIMARY + " DESC");
    }

    @Override
    public void onLoadFinished(Loader<Cursor> cursorLoader, Cursor cursor) {
        List<String> emails = new ArrayList<>();
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            emails.add(cursor.getString(ProfileQuery.ADDRESS));
            cursor.moveToNext();
        }

    }

    @Override
    public void onLoaderReset(Loader<Cursor> cursorLoader) {

    }

    @OnClick(R.id.showPassword)
    void onShowPasswordClick() {
        //TODO implement
        if (mPasswordView.getTransformationMethod() == null) {
            mPasswordView.setTransformationMethod(new PasswordTransformationMethod());
            txt_password.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_lock_black_24dp, 0, 0, 0);
        } else {
            mPasswordView.setTransformationMethod(null);
            txt_password.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_lock_open_black_24dp, 0, 0, 0);
        }
    }

    public void showCredits(View view) {
        if (clicks < 7) {
            clicks++;
            Toast.makeText(this, String.valueOf(clicks), Toast.LENGTH_SHORT).show();
        } else {
            clicks = 0;
            Toast.makeText(this, "TEAM CREDITS: "
                            + "\r\n\tSYED HASSAN ZAMIN NAQVI"
                            + "\r\n\t\tALI AZAZ ALAM"
                            + "\r\n\t\t\tGUL SANOBER"
                            + "\r\n\t\t\t\tRAMSHA SAEED AHMED"
                            + "\r\n\t\t\t\t\tJAVED AHMED KHAN",
                    Toast.LENGTH_LONG)
                    .show();
        }
    }

    private interface ProfileQuery {
        String[] PROJECTION = {
                ContactsContract.CommonDataKinds.Email.ADDRESS,
                ContactsContract.CommonDataKinds.Email.IS_PRIMARY,
        };

        int ADDRESS = 0;
        int IS_PRIMARY = 1;
    }

    /**
     * Represents an asynchronous login/registration task used to authenticate
     * the user.
     */
    public class UserLoginTask extends AsyncTask<Void, Void, Boolean> {

        private final String mEmail;
        private final String mPassword;

        UserLoginTask(String email, String password) {
            mEmail = email;
            mPassword = password;
        }


        @Override
        protected Boolean doInBackground(Void... params) {
            // TODO: attempt authentication against a network service.

            try {
                // Simulate network access.
                sleep(2000);
            } catch (InterruptedException e) {
                return false;
            }

            for (String credential : DUMMY_CREDENTIALS) {
                String[] pieces = credential.split(":");
                if (pieces[0].equals(mEmail)) {
                    // Account exists, return true if the password matches.
                    return pieces[1].equals(mPassword);
                }
            }

            // TODO: register the new account here.
            return true;
        }

        @Override
        protected void onPostExecute(final Boolean success) {
            mAuthTask = null;
            showProgress(false);

            DatabaseHelper db = new DatabaseHelper(LoginActivity.this);
            if ((mEmail.equals("dmu@aku") && mPassword.equals("aku?dmu")) || db.Login(mEmail, mPassword)
                    || (mEmail.equals("test1234") && mPassword.equals("test1234"))) {
                MainApp.userName = mEmail;
                MainApp.admin = mEmail.contains("@");

                finish();
                Intent iLogin = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(iLogin);

            } else {
                mPasswordView.setError(getString(R.string.error_incorrect_password));
                mPasswordView.requestFocus();
                Toast.makeText(LoginActivity.this, mEmail + " " + mPassword, Toast.LENGTH_SHORT).show();
            }


            //HassanBhai@RequestedGPSRemove - 09Feb2021
            /*LocationManager mlocManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
            if (mlocManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {

                DatabaseHelper db = new DatabaseHelper(LoginActivity.this);
                if ((mEmail.equals("dmu@aku") && mPassword.equals("aku?dmu")) || db.Login(mEmail, mPassword)
                        || (mEmail.equals("test1234") && mPassword.equals("test1234"))) {
                    MainApp.userName = mEmail;
                    MainApp.admin = mEmail.contains("@");

                    finish();
                    Intent iLogin = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(iLogin);

                } else {
                    mPasswordView.setError(getString(R.string.error_incorrect_password));
                    mPasswordView.requestFocus();
                    Toast.makeText(LoginActivity.this, mEmail + " " + mPassword, Toast.LENGTH_SHORT).show();
                }
            } else {
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                        LoginActivity.this);
                alertDialogBuilder
                        .setMessage("GPS is disabled in your device. Enable it?")
                        .setCancelable(false)
                        .setPositiveButton("Enable GPS",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog,
                                                        int id) {
                                        Intent callGPSSettingIntent = new Intent(
                                                android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                                        startActivity(callGPSSettingIntent);
                                    }
                                });
                alertDialogBuilder.setNegativeButton("Cancel",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });
                AlertDialog alert = alertDialogBuilder.create();
                alert.show();

            }*/

        }


        @Override
        protected void onCancelled() {
            mAuthTask = null;
            showProgress(false);
        }
    }

/*    public class SyncData extends AsyncTask<String, String, String> {

        private Context mContext;

        public SyncData(Context mContext) {
            this.mContext = mContext;
        }

        @Override
        protected String doInBackground(String... strings) {
            runOnUiThread(() -> {
                Toast.makeText(mContext, "Sync Users", Toast.LENGTH_LONG).show();
                new GetAllData(mContext, "Users").execute();
                Toast.makeText(mContext, "Sync Talukas", Toast.LENGTH_LONG).show();
                new GetAllData(mContext, "Talukas").execute();
                Toast.makeText(mContext, "Sync UCs", Toast.LENGTH_LONG).show();
                new GetAllData(mContext, "UCs").execute();
                Toast.makeText(mContext, "Sync Villages", Toast.LENGTH_LONG).show();
                new GetAllData(mContext, "Villages").execute();
                Toast.makeText(mContext, "Sync PWs", Toast.LENGTH_LONG).show();
                new GetAllData(mContext, "PWs").execute();
                Toast.makeText(mContext, "Sync PWScreened", Toast.LENGTH_LONG).show();
                new GetAllData(mContext, "PWScreened").execute();
                Toast.makeText(mContext, "Sync Eligibiles", Toast.LENGTH_LONG).show();
                new GetAllData(mContext, "Eligibiles").execute();
                Toast.makeText(mContext, "Sync Recruitments", Toast.LENGTH_LONG).show();
                new GetAllData(mContext, "Recruitments").execute();
                Toast.makeText(mContext, "Sync RegisteredPW", Toast.LENGTH_LONG).show();
                new GetAllData(mContext, "RegisteredPW").execute();
                Toast.makeText(mContext, "Sync RegisteredPWF1", Toast.LENGTH_LONG).show();
                new GetAllData(mContext, "RegisteredPWF1").execute();
                Toast.makeText(mContext, "Sync RegisteredPWF2", Toast.LENGTH_LONG).show();
                new GetAllData(mContext, "RegisteredPWF2").execute();
                Toast.makeText(mContext, "Sync RegisteredPWF3", Toast.LENGTH_LONG).show();
                new GetAllData(mContext, "RegisteredPWF3").execute();
            });


            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            new Handler().postDelayed(() -> {
                editor.putBoolean("flag", true);
                editor.commit();
                dbBackup();
            }, 1200);
        }
    }*/

}

