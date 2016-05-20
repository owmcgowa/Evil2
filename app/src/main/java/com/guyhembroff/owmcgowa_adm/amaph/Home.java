package com.guyhembroff.owmcgowa_adm.amaph;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by owmcgowa-adm on 9/8/2015.
 */
public class Home extends AppCompatActivity implements View.OnClickListener{

    private TextView textView;
    private TextView tvInfo;
    public static final String USER_NAME = "USER_NAME";

    String username;
    Button bAmaph;
    Button bTechville;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        bAmaph = (Button)findViewById(R.id.bAmaph);
        bTechville = (Button) findViewById(R.id.bTechville);

        bAmaph.setOnClickListener(this);
        bTechville.setOnClickListener(this);

        textView = (TextView)findViewById(R.id.tvUsername);
        Intent intent = getIntent();
        username = intent.getStringExtra(Login.USER_NAME);
        textView.setText("Welcome " + username);

        tvInfo = (TextView) findViewById(R.id.tvInfo);


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        switch(id){

            case R.id.menu_update:
                Intent i = new Intent(Home.this, Update.class);
                i.putExtra(USER_NAME, username);
                startActivity(i);
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onClick(View v){


        if(v == bAmaph){
            Intent i = new Intent(Home.this, Amaph.class);
            i.putExtra(USER_NAME, username);
            startActivity(i);
        }
        if(v == bTechville){
            Intent i = new Intent(Home.this, Techville.class);
            i.putExtra(USER_NAME, username);
            startActivity(i);
        }

    }


}
