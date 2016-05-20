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
import android.widget.RadioButton;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import static com.guyhembroff.owmcgowa_adm.amaph.R.id.cbDuplication;
import static com.guyhembroff.owmcgowa_adm.amaph.R.id.cbFire;
import static com.guyhembroff.owmcgowa_adm.amaph.R.id.cbFlight;
import static com.guyhembroff.owmcgowa_adm.amaph.R.id.cbInvisibility;
import static com.guyhembroff.owmcgowa_adm.amaph.R.id.cbShapeshifting;
import static com.guyhembroff.owmcgowa_adm.amaph.R.id.cbSuperSpeed;
import static com.guyhembroff.owmcgowa_adm.amaph.R.id.cbSuperStrength;
import static com.guyhembroff.owmcgowa_adm.amaph.R.id.cbTelekenesis;
import static com.guyhembroff.owmcgowa_adm.amaph.R.id.cbTelepathy;


/**
 * Created by owmcgowa-adm on 9/2/2015.
 */
public class SuperheroLogin extends AppCompatActivity implements View.OnClickListener {

    //declaring variables, buttons, and ArrayLists
    public static final String USER_NAME = "USER_NAME";
    private EditText editTextSuperhero;
    String user;

    Button bCreateSuperhero;

    ArrayList<String> selection = new ArrayList<String>();
    ArrayList<String> genderSP = new ArrayList<String>();

    //php file locating
    private static final String REGISTER_URL = "http://141.219.187.99/log_in/register4.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.superherologin);

        editTextSuperhero = (EditText) findViewById(R.id.etSuperheroName);
        bCreateSuperhero = (Button) findViewById(R.id.bCreateSuperhero);
        // pulling username from SignUp.class
        Intent intent = getIntent();
        user = intent.getStringExtra(SignUp.USER_NAME);

        bCreateSuperhero.setOnClickListener(this);

    }

    //add or remove selected Superhero gender to genderSP ArrayList
    public void selectGender(View v) {
        boolean checked = ((RadioButton) v).isChecked();

        //using a switch statement to add/remove selected Superhero gender
        switch (v.getId()) {

            case R.id.rbSuperMale:
                if (checked) {
                    genderSP.add("Male");
                } else {
                    genderSP.remove("Male");
                }
                break;

            case R.id.rbSuperFemale:
                if (checked) {
                    genderSP.add("Female");
                } else {
                    genderSP.remove("Female");
                }
                break;
        }

    }


    //add or remove selected Superhero powers to selection ArrayList
    public void selectItem(View view) {
        boolean checked = ((CheckBox) view).isChecked();

        switch (view.getId()) {

            case cbDuplication:
                if (checked) {
                    selection.add("Duplication");
                } else {
                    selection.remove("Duplication");
                }
                break;

            case cbFire:
                if (checked) {
                    selection.add("Fire_Manipulation");
                } else {
                    selection.remove("Fire_Manipulation");
                }
                break;

            case cbFlight:
                if (checked) {
                    selection.add("Flight");
                } else {
                    selection.remove("Flight");
                }
                break;

            case cbInvisibility:
                if (checked) {
                    selection.add("Invisibility");
                } else {
                    selection.remove("Invisibility");
                }
                break;

            case cbShapeshifting:
                if (checked) {
                    selection.add("Shapeshifting");
                } else {
                    selection.remove("Shapeshifting");
                }
                break;

            case cbSuperSpeed:
                if (checked) {
                    selection.add("Super_Speed");
                } else {
                    selection.remove("Super_Speed");
                }
                break;

            case cbSuperStrength:
                if (checked) {
                    selection.add("Super_Strength");
                } else {
                    selection.remove("Super_Strength");
                }
                break;

            case cbTelepathy:
                if (checked) {
                    selection.add("Telepathy");
                } else {
                    selection.remove("Telepathy");
                }
                break;

            case cbTelekenesis:
                if (checked) {
                    selection.add("Telekenesis");
                } else {
                    selection.remove("Telekenesis");
                }
                break;

        }

    }

    @Override
    public void onClick(View v) {

        if (v == bCreateSuperhero) {
            registerSuperhero();
            // Intent i = new Intent(SuperheroLogin.this,Sidekick.class);
            //  startActivity(i);
        }

    }


    private void registerSuperhero() {
        String username = user;
        String superhero = editTextSuperhero.getText().toString();
        String superheroGender = "";

        String power1 = "";
        String power2 = "";
        String power3 = "";

        // using for loop to find selected hero powers
        for (int i = 0; i < selection.size(); i++) {

            if (i == 0) {
                power1 = selection.get(i).trim();
            }
            if (i == 1) {
                power2 = selection.get(i).trim();
            }
            if (i == 2) {
                power3 = selection.get(i).trim();
            }
        }
        // using for loop to find selected hero gender
        for (int j = 0; j < genderSP.size(); j++) {

            if (j == 0) {
                superheroGender = genderSP.get(j).trim();
            }
        }
        Superhero(username, superhero, superheroGender, power1, power2, power3);

    }

    private void Superhero(final String username, String superhero, String superheroGender, String power1, String power2, String power3) {
        String urlSuffix = "?username=" + username + "&superhero=" + superhero + "&superheroGender=" + superheroGender + "&power1=" + power1 + "&power2=" + power2 + "&power3=" + power3;
        class RegisterSuperhero extends AsyncTask<String, Void, String> {

            ProgressDialog loading;


            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(SuperheroLogin.this, "Please Wait", null, true, true);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                if (s.equalsIgnoreCase("success")) {
                    Intent intent = new Intent(SuperheroLogin.this, Sidekick.class);
                    intent.putExtra(USER_NAME, username);
                    startActivity(intent);
                } else {
                    Toast.makeText(SuperheroLogin.this, s, Toast.LENGTH_LONG).show();
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

        RegisterSuperhero ru = new RegisterSuperhero();
        ru.execute(urlSuffix);
    }


}
