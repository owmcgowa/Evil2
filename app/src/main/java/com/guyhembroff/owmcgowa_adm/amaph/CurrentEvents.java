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
public class CurrentEvents extends AppCompatActivity implements View.OnClickListener {

    public static final String USER_NAME = "USER_NAME";
    String username;
    TextView ed1, ed2, ed3, didyouknow;
    Button bCurrentBackAmaph, bCurrentToTechville;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.current_events);

        Intent intent = getIntent();
        username = intent.getStringExtra(Amaph.USER_NAME);

        bCurrentBackAmaph = (Button)findViewById(R.id.bCurrentBackAmaph);
        bCurrentToTechville = (Button)findViewById(R.id.bCurrentToTechville);

        bCurrentBackAmaph.setOnClickListener(this);
        bCurrentToTechville.setOnClickListener(this);

        ed1 = (TextView)findViewById(R.id.tvEducat1);
        ed2 = (TextView)findViewById(R.id.tvEducat2);
        ed3 = (TextView)findViewById(R.id.tvEducat3);
        didyouknow = (TextView)findViewById(R.id.tvDidYouKnow);

        int random = (int)(Math.random()*4+0);

        Education edu = new Education();
         edu.setEdu(random);

        ed1.setText(edu.getEd1F());
        ed2.setText(edu.getEd2F());
        ed3.setText(edu.getEd3F());
        didyouknow.setText(username + " did you know,");

    }

    public void onClick (View v){

        if(v == bCurrentBackAmaph){
            Intent i = new Intent(CurrentEvents.this, Amaph.class);
            i.putExtra(USER_NAME, username);
            startActivity(i);
        }
        if(v == bCurrentToTechville){
            Intent i = new Intent(CurrentEvents.this, Techville.class);
            i.putExtra(USER_NAME, username);
            startActivity(i);
        }
    }
}
