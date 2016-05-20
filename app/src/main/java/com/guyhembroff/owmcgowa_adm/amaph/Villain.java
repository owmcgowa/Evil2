package com.guyhembroff.owmcgowa_adm.amaph;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by owmcgowa-adm on 10/15/2015.
 */
public class Villain extends AppCompatActivity implements View.OnClickListener{


    private RadioButton power1, power2, power3;
    private Button saveTechville;
    public static final String USER_NAME = "USER_NAME";
    String username;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.villain);


        saveTechville = (Button)findViewById(R.id.bSaveTechville);
        saveTechville.setOnClickListener(this);

        power1 = (RadioButton)findViewById(R.id.rbPower1);
        power2 = (RadioButton)findViewById(R.id.rbPower2);
        power3 = (RadioButton)findViewById(R.id.rbPower3);

        Intent intent = getIntent();
        username = intent.getStringExtra(Techville.USER_NAME);
        //System.out.println(username);

        getData();

    }

    @Override
    public void onClick(View v){

        if(v == saveTechville){
            Intent i = new Intent(Villain.this, Home.class);
            i.putExtra(USER_NAME, username);
            startActivity(i);
        }

    }

    private void getData(){

        String url = ConfigPower.DATA_URL+username.trim();

        StringRequest stringRequest = new StringRequest(url, new Response.Listener<String>(){
            @Override
            public void onResponse(String response){
                showJSON(response);
            }
        },
                new Response.ErrorListener(){
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(Villain.this, error.getMessage().toString(), Toast.LENGTH_LONG).show();
                    }
                });
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    public void showJSON(String response){
        power1.setText("");
        power2.setText("");
        power3.setText("");

        try{
            JSONObject jsonObject = new JSONObject(response);
            JSONArray result = jsonObject.getJSONArray(ConfigBMI.JSON_ARRAY);
            JSONObject bmiData = result.getJSONObject(0);
            power1.setText(bmiData.getString(ConfigPower.KEY_POWER1));
            power2.setText(bmiData.getString(ConfigPower.KEY_POWER2));
            power3.setText(bmiData.getString(ConfigPower.KEY_POWER3));


        }catch (JSONException e){
            e.printStackTrace();
        }
    }

}
