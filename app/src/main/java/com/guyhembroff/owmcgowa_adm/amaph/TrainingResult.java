package com.guyhembroff.owmcgowa_adm.amaph;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by owmcgowa-adm on 2/9/2016.
 */
public class TrainingResult extends AppCompatActivity implements View.OnClickListener {

    private static final String REGISTER_URL = "http://141.219.187.99/log_in/percentage.php";
    private GoogleApiClient client;
    TextView message;
    public static final String USER_NAME = "USER_NAME";
    String username;
    int score;

    Button bBackTrining, bNextTechville;


    @Override
    @SuppressWarnings("deprecation")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.trainingresult);

        Intent i = getIntent();
        username = i.getStringExtra(Training.USER_NAME);

        Intent intent = getIntent();
        score = intent.getIntExtra(Training.NUMBER_DONE, 0);

        bBackTrining = (Button) findViewById(R.id.bBackTraining);
        bNextTechville = (Button) findViewById(R.id.bNextTechville);

        bBackTrining.setOnClickListener(this);
        bNextTechville.setOnClickListener(this);


        CircularProgress circularProgress = (CircularProgress) findViewById(R.id.circular_progress);
        circularProgress.init(getApplicationContext(), getResources().getColor(R.color.primary_light),
                getResources().getColor(R.color.primary),
                getResources().getColor(R.color.primary_dark));
        circularProgress.setProgress(score);

        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();

        message = (TextView) findViewById(R.id.tvMessage);

        if (score >= 81 && score <= 100) {
            message.setText("Congratulation, You are Becoming a MASTER, stay focused");
            addPercentage();
        }

        if (score >= 61 && score <= 80) {
            message.setText("Congrats, You have shown much potential, but still need to improve");
            addPercentage();
        }

        if (score >= 41 && score <= 60) {
            message.setText("Nice Work, Keep improving to reach Master Superhero status");
            addPercentage();
        }

        if (score >= 21 && score <= 40) {
            message.setText("Good Effort, however you have much more to learn young Superhero");
            addPercentage();
        }

        if (score >= 0 && score <= 20) {
            message.setText("A key to a young Superhero's success is patience, effort, training, and focus. Keep going and believe in your potential.");
            addPercentage();
        }

    }


    @Override
    public void onClick(View v) {

        if (v == bBackTrining) {
            Intent i = new Intent(TrainingResult.this, Training.class);
            i.putExtra(USER_NAME, username);
            startActivity(i);
        }

        if (v == bNextTechville) {
            Intent i = new Intent(TrainingResult.this, Techville.class);
            i.putExtra(USER_NAME, username);
            startActivity(i);
        }

    }

    private void addPercentage() {
        String fScore = String.valueOf(score);

        percentage(fScore);

    }

    private void percentage(String fScore) {
        String urlSuffix =  "?score=" +fScore+ "&username="+username;
        class AddPercentage extends AsyncTask<String, Void, String> {

            ProgressDialog loading;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(TrainingResult.this, "Please Wait", null, true, true);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                if (s.equalsIgnoreCase("success")) {
                    Toast.makeText(TrainingResult.this, "Success", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(TrainingResult.this, s, Toast.LENGTH_LONG).show();
                }
            }

            @Override
            protected String doInBackground(String... params) {
                String s = params[0];
                BufferedReader bufferedReader = null;
                try {
                    URL url = new URL(REGISTER_URL+s);
                    HttpURLConnection con = (HttpURLConnection) url.openConnection();
                    bufferedReader = new BufferedReader(new InputStreamReader(con.getInputStream()));

                    String result;

                    result = bufferedReader.readLine();

                    return result;
                }catch(Exception e){
                    return null;
                }
            }
        }

        AddPercentage ru = new AddPercentage();
        ru.execute(urlSuffix);
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://com.example.owmcgowa_adm.evil/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://com.example.owmcgowa_adm.evil/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }

}
