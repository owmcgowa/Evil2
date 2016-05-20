package com.guyhembroff.owmcgowa_adm.amaph;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by owmcgowa-adm on 11/5/2015.
 */
public class Techville extends AppCompatActivity implements View.OnClickListener{

    private Button bNextVillain, bHome2;
    public static final String USER_NAME = "USER_NAME";
    String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.techville);

        bNextVillain = (Button)findViewById(R.id.bNextVillain);
        bHome2 = (Button)findViewById(R.id.bHome2);

        bNextVillain.setOnClickListener(this);
        bHome2.setOnClickListener(this);

        Intent intent = getIntent();
        username = intent.getStringExtra(Home.USER_NAME);

    }

    @Override
    public void onClick(View v){

        if(v == bNextVillain){
            Intent i = new Intent(Techville.this, Villain.class);
            i.putExtra(USER_NAME, username);
            startActivity(i);
        }

        if(v == bHome2){
            Intent i = new Intent(Techville.this, Home.class);
            i.putExtra(USER_NAME, username);
            startActivity(i);
        }

    }

}
