package com.guyhembroff.owmcgowa_adm.amaph;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by owmcgowa-adm on 10/14/2015.
 */
public class Sidekick extends AppCompatActivity implements View.OnClickListener{

    public static final String USER_NAME = "USER_NAME";
    private EditText editTextName;
    private EditText editTextUsername;
    private EditText editTextPassword;
    private EditText editTextConfirm;

    private Button bSaveTechville;

    ArrayList<String> sidekickpower = new ArrayList<String>();

    private static final String REGISTER_URL = "http://141.219.187.99/log_in/register5.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sidekick);

        editTextName = (EditText)findViewById(R.id.etSidekickName);
        editTextUsername = (EditText)findViewById(R.id.etSidekickUsername);
        editTextPassword = (EditText) findViewById(R.id.etSidekickPassword);
        editTextConfirm = (EditText) findViewById(R.id.etSidekickConfirmPassword);

        bSaveTechville = (Button)findViewById(R.id.bSaveTechville);

        bSaveTechville.setOnClickListener(this);


    }
    public void selectItem2 (View view) {
        boolean checked = ((CheckBox) view).isChecked();

        switch (view.getId()) {

            case com.guyhembroff.owmcgowa_adm.amaph.R.id.cbTeleportation:
                if (checked) {
                    sidekickpower.add("Teleportation");
                } else {
                    sidekickpower.remove("Teleportation");
                }
                break;

            case com.guyhembroff.owmcgowa_adm.amaph.R.id.cbControllingWeather:
                if (checked) {
                    sidekickpower.add("Controlling_Weather");
                } else {
                    sidekickpower.remove("Controlling_Weather");
                }
                break;

            case R.id.cbXRay:
                if (checked) {
                    sidekickpower.add("X-Ray_Vision");
                } else {
                    sidekickpower.remove("X-Ray_Vision");
                }
                break;
        }
    }

    public void onClick(View v) {

        if (v.getId() == R.id.bSaveTechville) {
            registerSK();
            //Intent i = new Intent(Sidekick.this, Login.class);
            //startActivity(i);
        }
    }

    private void registerSK (){

        Intent intent = getIntent();
        String user = intent.getStringExtra(SuperheroLogin.USER_NAME);
        String username = user;
        String skname = editTextName.getText().toString().trim();
        String skusername = editTextUsername.getText().toString().trim();
        String skpassword = editTextPassword.getText().toString().trim();
        String skconfirm = editTextConfirm.getText().toString().trim();
        String skpower = "";

        for (int i = 0; i < sidekickpower.size(); i++ ){
            if(i == 0){
                skpower = sidekickpower.get(i).trim();
            }
        }
        register(username, skname, skusername, skpassword, skconfirm, skpower);
    }

    private void register(final String username, String skname, String skusername, String skpassword,String skconfirm, String skpower) {
        String urlSuffix = "?username="+username+"&skname="+skname+"&skusername="+skusername+"&skpassword="+skpassword+"&skconfirm="+skconfirm+"&skpower="+skpower;
        class RegisterSK extends AsyncTask<String, Void, String> {

            ProgressDialog loading;


            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(Sidekick.this, "Please Wait",null, true, true);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                if(s.equalsIgnoreCase("success")){
                    Intent intent = new Intent(Sidekick.this, Home.class);
                    intent.putExtra(USER_NAME,username);
                    startActivity(intent);
                }else{
                    Toast.makeText(Sidekick.this, s, Toast.LENGTH_LONG).show();
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

        RegisterSK ru = new RegisterSK();
        ru.execute(urlSuffix);
    }

}
