package com.guyhembroff.owmcgowa_adm.amaph;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by owmcgowa-adm on 2/27/2016.
 */
public class HealthStatus extends AppCompatActivity implements View.OnClickListener {

    public static final String USER_NAME = "USER_NAME";
    String username;
    Button bHealthBackAmaph, bHealthToTechville, bHealthToService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.health_status);

        Intent intent = getIntent();
        username = intent.getStringExtra(Amaph.USER_NAME);

        bHealthBackAmaph = (Button)findViewById(R.id.bHealthBackAmaph);
        bHealthToTechville = (Button)findViewById(R.id.bHealthToTechville);
        bHealthToService = (Button)findViewById(R.id.bHealthToService);

        bHealthBackAmaph.setOnClickListener(this);
        bHealthToTechville.setOnClickListener(this);
        bHealthToService.setOnClickListener(this);


    }

    public void onClick (View v){

        if(v == bHealthBackAmaph){
            Intent i = new Intent(HealthStatus.this, Amaph.class);
            i.putExtra(USER_NAME, username);
            startActivity(i);
        }
        if(v == bHealthToTechville){
            Intent i = new Intent(HealthStatus.this, Techville.class);
            i.putExtra(USER_NAME, username);
            startActivity(i);
        }
        if(v == bHealthToService){
            Intent i = new Intent(HealthStatus.this, Services.class);
            i.putExtra(USER_NAME, username);
            startActivity(i);
        }

    }
}

