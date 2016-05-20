package com.guyhembroff.owmcgowa_adm.amaph;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by owmcgowa-adm on 2/27/2016.
 */
public class Amaph extends AppCompatActivity implements View.OnClickListener{

    private TextView tvGreeting, tvAmaph;
    public static final String USER_NAME = "USER_NAME";

    String username;
    Button bServices, bHealthStatus, bCurrentEvents, bBackHome;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.amaph);

        tvGreeting = (TextView)findViewById(R.id.tvGreeting);
        Intent intent = getIntent();
        username = intent.getStringExtra(Home.USER_NAME);
        tvGreeting.setText("Greetings " + username + ",");

        Typewriter writer = (Typewriter)findViewById(R.id.tvAmaph);
        writer.setCharacterDelay(100);
        writer.animateText("I am AMAPH, An Advanced Monitoring Application of Personal Health, I have the capabilities of Keeping you updated on current events, your health status, and other services you may need.  Where would you like to begin?");

        bServices = (Button)findViewById(R.id.bServices);
        bHealthStatus = (Button)findViewById(R.id.bHealthStatus);
        bCurrentEvents = (Button)findViewById(R.id.bCurrentEvents);
        bBackHome = (Button)findViewById(R.id.bBackHome);

        bServices.setOnClickListener(this);
        bHealthStatus.setOnClickListener(this);
        bCurrentEvents.setOnClickListener(this);
        bBackHome.setOnClickListener(this);
    }



    public void onClick(View v) {

        if (v == bServices) {
            Intent i = new Intent(Amaph.this, Services.class);
            i.putExtra(USER_NAME, username);
            startActivity(i);
        }
        if (v == bHealthStatus) {
            Intent i = new Intent(Amaph.this, HealthStatus.class);
            i.putExtra(USER_NAME, username);
            startActivity(i);
        }
        if (v == bCurrentEvents) {
                Intent i = new Intent(Amaph.this, CurrentEvents.class);
                i.putExtra(USER_NAME, username);
                startActivity(i);
        }
        if (v == bBackHome) {
            Intent i = new Intent(Amaph.this, Home.class);
            i.putExtra(USER_NAME, username);
            startActivity(i);
        }
    }
}
