package com.projek.p2pl;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.app.LoaderManager.LoaderCallbacks;

import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;

import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okio.BufferedSink;

import static android.Manifest.permission.READ_CONTACTS;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends AppCompatActivity {

    /**
     * Id to identity READ_CONTACTS permission request.
     */
    private static final int REQUEST_READ_CONTACTS = 0;

    /**
     * A dummy authentication store containing known user names and passwords.
     * TODO: remove after connecting to a real authentication system.
     */
    private static final String[] DUMMY_CREDENTIALS = new String[]{
            "foo@example.com:hello", "bar@example.com:world"
    };
    /**
     * Keep track of the login task to ensure we can cancel it if requested.
     */
    private UserLoginTask mAuthTask = null;

    // UI references.
    private EditText mUsernameView;
    private EditText mPasswordView;
    private View mProgressView;
    private View mLoginFormView;

//    final Activity activity = getParent();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Set up the login form.
        mUsernameView = (EditText) findViewById(R.id.username);

        mPasswordView = (EditText) findViewById(R.id.password);
        mPasswordView.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int id, KeyEvent keyEvent) {
                if (id == EditorInfo.IME_ACTION_DONE || id == EditorInfo.IME_NULL) {
                    attemptLogin();
                    return true;
                }
                return false;
            }
        });

        Button mEmailSignInButton = (Button) findViewById(R.id.sign_in_button);
        mEmailSignInButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                attemptLogin();
            }
        });

        mLoginFormView = findViewById(R.id.login_form);
        mProgressView = findViewById(R.id.login_progress);
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
        mUsernameView.setError(null);
        mPasswordView.setError(null);

        // Store values at the time of the login attempt.
        String username = mUsernameView.getText().toString();
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
        if (TextUtils.isEmpty(username)) {
            mUsernameView.setError("Masukkan Username");
            focusView = mUsernameView;
            cancel = true;
        }

        if (cancel) {
            // There was an error; don't attempt login and focus the first
            // form field with an error.
            focusView.requestFocus();
        } else {
            // Show a progress spinner, and kick off a background task to
            // perform the user login attempt.

            String usr = mUsernameView.getText().toString();
            String pwd = mPasswordView.getText().toString();
//            Toast.makeText(this, usr + " - " + pwd, Toast.LENGTH_SHORT).show();

//            login_service(usr, pwd);
            login_service(usr, pwd);

//            mAuthTask = new UserLoginTask(email, password);
//            mAuthTask.execute((Void) null);
        }
    }

    private boolean isPasswordValid(String password) {
        //TODO: Replace this with your own logic
        return password.length() > 4;
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
                Thread.sleep(2000);
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

            if (success) {
                finish();
            } else {
                mPasswordView.setError(getString(R.string.error_incorrect_password));
                mPasswordView.requestFocus();
            }
        }

        @Override
        protected void onCancelled() {
            mAuthTask = null;
            showProgress(false);
        }
    }

    public void login_service(final String username, final String password){
        new Thread(new Runnable() {

            @Override
            public void run() {

//                Log.d("tew", "http://192.168.56.1/p2tl/login_service.php?API=11223344");
                OkHttpClient client = new OkHttpClient();
                // code request code here

                RequestBody formBody = new FormBody.Builder()
                        .add("username", username)
                        .add("password", password)
                        .build();

                Request request = new Request.Builder()
                        .url("http://192.168.56.1/p2tl/login_service.php?API=11223344")
                        .post(formBody)
                        .build();

                try {
                    Response response = client.newCall(request).execute();
                    String result = response.body().string();

                    JSONObject jsonObject = new JSONObject(result);
                    JSONArray login = jsonObject.getJSONArray("login");
                    JSONObject data = login.getJSONObject(0);
//                    JSONObject data = jsonArray.getJSONObject(0);
//
//                    final String namapel = data.isNull("nama") ? "-" : data.getString("nama") ;
//                    final String alamatpel = data.isNull("alamat") ? "-" : data.getString("alamat") ;
//                    final String no_gardupel = data.isNull("kdgardu") ? "-" : data.getString("kdgardu") ;
//                    final String tarifpel = data.isNull("tarif") ? "-" : data.getString("tarif") ;
//
                    if (data.getString("result").equals("USERNAME DAN PASSWORD DITERIMA")){
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                SharedPreferences sharedPreferences = getSharedPreferences("login", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString("nama", data.getString("nama"));
                        editor.putString("kode_rayon", data.getString("kode_rayon"));
                        editor.putString("nama_rayon", data.getString("nama_rayon"));
                        editor.putString("nama_area", data.getString("nama_area"));
                        editor.putString("nama_distribusi", data.getString("nama_distribusi"));
                        editor.putString("alamat_rayon", data.getString("alamat_rayon"));
                        editor.putString("kode_rayon", data.getString("kode_rayon"));

                        LoginActivity.this.runOnUiThread(new Runnable() {
                            public void run() {
                                Toast.makeText(LoginActivity.this, "Login berhasil", Toast.LENGTH_SHORT).show();

                                Intent intent = new Intent(LoginActivity.this, Main2Activity.class);
                                startActivity(intent);
                                finish();
                            }
                        });
                    } else{
                        LoginActivity.this.runOnUiThread(new Runnable() {
                            public void run() {
                                Toast.makeText(LoginActivity.this, "Login gagal. Cek username dan password", Toast.LENGTH_SHORT).show();
                            }
                        });
                    }

//                    Log.d("tesa1", result);
//                    Log.d("tesa2", jsonObject.toString());
//                    Log.d("tesa3", login.toString());
//                    Log.d("tesa4", data.toString());
//
//                    Log.d("hasil1", data.getString("result"));
//                    Log.d("tesa4", data.toString());
//                    Log.d("tesa5", data.getString("result"));
//                    Log.d("tesa6", nama_pel);



                } catch (IOException e) {
                    LoginActivity.this.runOnUiThread(new Runnable() {
                        public void run() {
                            Toast.makeText(LoginActivity.this, "Login gagal. Cek username dan password", Toast.LENGTH_SHORT).show();
                        }
                    });
                    e.printStackTrace();
                } catch (JSONException e) {
                    LoginActivity.this.runOnUiThread(new Runnable() {
                        public void run() {
                            Toast.makeText(LoginActivity.this, "Login gagal. Cek username dan password", Toast.LENGTH_SHORT).show();
                        }
                    });
                    e.printStackTrace();
                }
//        return response.body().string();
            }
        }).start();
    }
}

