package com.guyhembroff.owmcgowa_adm.amaph;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.RadioButton;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class SignUp extends AppCompatActivity implements View.OnClickListener{

    NumberPicker noPickNumber1 = null;
    NumberPicker noPickNumber2 = null;
    public static final String USER_NAME = "USER_NAME";
    private EditText editTextFirst;
    private EditText editTextLast;
    private EditText editTextUsername;
    private EditText editTextPassword;
    private EditText editTextConfirm;
    private EditText editTextEmail;
    private EditText editTextBirthday;

    private Button bCreate;

    ArrayList<String> userGender = new ArrayList<String>();

    private static final String REGISTER_URL = "http://141.219.187.99/log_in/register3.php";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);

        editTextFirst = (EditText) findViewById(R.id.etFirstName);
        editTextLast = (EditText) findViewById(R.id.etLastName);
        editTextUsername = (EditText) findViewById(R.id.etSuperUsername);
        editTextPassword = (EditText) findViewById(R.id.etSuperPassword);
        editTextConfirm = (EditText)findViewById(R.id.etConfirmPassword);
        editTextEmail = (EditText) findViewById(R.id.etEmail);
        editTextBirthday = (EditText) findViewById(R.id.etBirthday);

        bCreate = (Button) findViewById(R.id.bCreate);


        noPickNumber1 = (NumberPicker) findViewById(R.id.npWeight);
        noPickNumber1.setMaxValue(400);
        noPickNumber1.setMinValue(0);

        noPickNumber2 = (NumberPicker) findViewById(R.id.npHeight);
        noPickNumber2.setMaxValue(96);
        noPickNumber2.setMinValue(0);

        bCreate.setOnClickListener(this);


      //  if(!editTextPassword.equals(editTextConfirm)){
       //     Toast pass = Toast.makeText(SignUp.this, "Passwords don't match!", Toast.LENGTH_LONG);
      //      pass.show();
      //  }


    }

    @Override
    public void onClick(View v) {

        if(v == bCreate){
            registerUser();
        }

    }
    public void selectUserG (View v){
        boolean checked = ((RadioButton)v).isChecked();

        //using a switch statement to add/remove selected Superhero gender
        switch (v.getId()){

            case R.id.rbMale:
                if(checked){
                    userGender.add("Male");
                }
                else{
                    userGender.remove("Male");
                }
                break;

            case R.id.rbFemale:
                if(checked){
                    userGender.add("Female");
                }
                else{
                    userGender.remove("Female");
                }
                break;
        }

    }


    private void registerUser() {
        String first = editTextFirst.getText().toString().trim().toLowerCase();
        String last = editTextLast.getText().toString().trim().toLowerCase();
        String username = editTextUsername.getText().toString().trim().toLowerCase();
        String password = editTextPassword.getText().toString().trim();
        String confirmpass = editTextConfirm.getText().toString().trim();
        String email = editTextEmail.getText().toString().trim().toLowerCase();
        String birthday = editTextBirthday.getText().toString();
        String gender = "";
        int weight1 = noPickNumber1.getValue();
        String weight = String.valueOf(weight1);
        int height1 = noPickNumber2.getValue();
        String height = String.valueOf(height1);

        // using for loop to find selected hero gender
        for (int i = 0; i < userGender.size(); i++){

            if(i == 0){
                gender = userGender.get(i).trim();
            }
        }

        register(first,last,username,password,confirmpass,email,birthday,gender,weight,height);
    }

    private void register(String first, String last, final String username, String password, String confirmpass, String email, String birthday, String gender, String weight, String height) {
        String urlSuffix = "?first="+first+"&last="+last+"&username="+username+"&password="+password+"&confirmpass="+confirmpass+"&email="+email+"&birthday="+birthday+"&gender="+gender+"&weight="+weight+"&height="+height;
        class RegisterUser extends AsyncTask<String, Void, String>{

            ProgressDialog loading;


            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(SignUp.this, "Please Wait",null, true, true);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                if(s.equalsIgnoreCase("successfully registered")){
                    Intent intent = new Intent(SignUp.this, SuperheroLogin.class);
                    intent.putExtra(USER_NAME,username);
                    startActivity(intent);
                }else{
                    Toast.makeText(SignUp.this,s,Toast.LENGTH_LONG).show();
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

        RegisterUser ru = new RegisterUser();
        ru.execute(urlSuffix);
    }
}