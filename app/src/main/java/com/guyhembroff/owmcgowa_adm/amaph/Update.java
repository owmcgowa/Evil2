package com.guyhembroff.owmcgowa_adm.amaph;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by owmcgowa-adm on 2/14/2016.
 */
public class Update extends AppCompatActivity implements View.OnClickListener {

    private EditText updateEmail, updateWeight, updateHeight;
    String username;
    public static final String USER_NAME = "USER_NAME";

    private Button bUpdate, bBackUpdate;

    private static final String REGISTER_URL = "http://141.219.187.99/log_in/update.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.update);

        Intent intent = getIntent();
        username = intent.getStringExtra(Home.USER_NAME);

        updateEmail = (EditText) findViewById(R.id.etUemail);
        updateWeight = (EditText) findViewById(R.id.etUweight);
        updateHeight = (EditText) findViewById(R.id.etUheight);

        bUpdate = (Button) findViewById(R.id.bUpdate);
        bUpdate.setOnClickListener(this);
        bBackUpdate = (Button) findViewById(R.id.bUback);
        bBackUpdate.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        if (v == bUpdate) {
            updateInfo();
        }
        if (v == bBackUpdate) {
            Intent intent = new Intent(Update.this, Home.class);
            intent.putExtra(USER_NAME, username);
            startActivity(intent);
        }

    }

    private void updateInfo() {
        String uEmail = updateEmail.getText().toString().trim().toLowerCase();
        String uWeight = updateWeight.getText().toString().trim();
        String uHeight = updateHeight.getText().toString().trim();

        update(uEmail, uWeight, uHeight);

    }

    private void update(String uEmail, String uWeight, String uHeight) {
        String urlSuffix = "?username=" + username + "&email=" + uEmail + "&weight=" + uWeight + "&height=" + uHeight;
        class UpdateInfo extends AsyncTask<String, Void, String> {

            ProgressDialog loading;


            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(Update.this, "Please Wait", null, true, true);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                if (s.equalsIgnoreCase("success")) {
                    Intent intent = new Intent(Update.this, Home.class);
                    intent.putExtra(USER_NAME, username);
                    startActivity(intent);
                } else {
                    Toast.makeText(Update.this, s, Toast.LENGTH_LONG).show();
                }
            }

            @Override
            protected String doInBackground(String... params) {
                String s = params[0];
                BufferedReader bufferedReader = null;
                try {
                    URL url = new URL(REGISTER_URL + s);
                    HttpURLConnection con = (HttpURLConnection) url.openConnection();
                    bufferedReader = new BufferedReader(new InputStreamReader(con.getInputStream()));

                    String result;

                    result = bufferedReader.readLine();

                    return result;
                } catch (Exception e) {
                    return null;
                }
            }
        }

        UpdateInfo ru = new UpdateInfo();
        ru.execute(urlSuffix);
    }

}

