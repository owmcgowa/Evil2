package com.guyhembroff.owmcgowa_adm.amaph;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by owmcgowa-adm on 2/27/2016.
 */
public class Services extends AppCompatActivity implements View.OnClickListener {

    public static final String USER_NAME = "USER_NAME";
    private GoogleApiClient client;
    String username;
    TextView tvUsernameHere, tvDateUpdate, tvTimeUpdate;
    Button bTraining, bServicesBackAMAPH;
    int percentageF;
    String percentage, date, time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.services);

        Intent i = getIntent();
        username = i.getStringExtra(Amaph.USER_NAME);

        tvUsernameHere = (TextView) findViewById(R.id.tvUsernameHere);
        tvUsernameHere.setText(username);
        tvDateUpdate = (TextView) findViewById(R.id.tvDateUpdate);
        tvTimeUpdate = (TextView) findViewById(R.id.tvTimeUpdate);

        bTraining = (Button)findViewById(R.id.bTraining);
        bServicesBackAMAPH = (Button)findViewById(R.id.bServicesBackAMAPH);
        bTraining.setOnClickListener(this);
        bServicesBackAMAPH.setOnClickListener(this);

        CircularProgress circularProgress = (CircularProgress) findViewById(R.id.circular_progress2);
        circularProgress.init(getApplicationContext(), getResources().getColor(R.color.primary_light),
                getResources().getColor(R.color.primary),
                getResources().getColor(R.color.primary_dark));
        circularProgress.setProgress(0);

        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
        getData();
    }
    private void getData(){

        String url = GetResult.DATA_URL+username.trim();

        StringRequest stringRequest = new StringRequest(url, new Response.Listener<String>(){
            @Override
            public void onResponse(String response){
                showJSON(response);
            }
        },
                new Response.ErrorListener(){
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(Services.this, error.getMessage().toString(), Toast.LENGTH_LONG).show();
                    }
                });
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    public void showJSON(String response) {
        percentage = "";
        date = "";
        time = "";

        try {
            JSONObject jsonObject = new JSONObject(response);
            JSONArray result = jsonObject.getJSONArray(GetResult.JSON_ARRAY);
            JSONObject resultData = result.getJSONObject(0);
            percentage = resultData.getString(GetResult.KEY_PERCENTAGE);
            date = resultData.getString(GetResult.KEY_DATE);
            time = resultData.getString(GetResult.KEY_TIME);

            update();

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

        private void update(){

            if( date.equals("null") && time.equals("null") && percentage.equals("null")){
                tvDateUpdate.setText("No information");
                tvTimeUpdate.setText("this time");
                percentageF = 0;
            }
            else {
                tvDateUpdate.setText(date);
                tvTimeUpdate.setText(time);
                percentageF = Integer.parseInt(percentage);
            }

            CircularProgress circularProgress = (CircularProgress) findViewById(R.id.circular_progress2);
            circularProgress.init(getApplicationContext(), getResources().getColor(R.color.primary_light),
                    getResources().getColor(R.color.primary),
                    getResources().getColor(R.color.primary_dark));
            circularProgress.setProgress(percentageF);

            client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();

        }



    @Override
    public void onClick(View v) {

        if (v == bTraining) {
            Intent i = new Intent(Services.this, Training.class);
            i.putExtra(USER_NAME, username);
            startActivity(i);
        }

        if (v == bServicesBackAMAPH) {
            Intent i = new Intent(Services.this, Amaph.class);
            i.putExtra(USER_NAME, username);
            startActivity(i);
        }

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
                Uri.parse("android-app://com.guyhembroff.owmcgowa_adm.amaph/http/host/path")
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
                Uri.parse("android-app://com.guyhembroff.owmcgowa_adm.amaph/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }
}
