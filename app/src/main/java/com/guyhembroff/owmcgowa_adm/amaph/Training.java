package com.guyhembroff.owmcgowa_adm.amaph;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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
 * Created by owmcgowa-adm on 11/5/2015.
 */
public class Training extends AppCompatActivity implements View.OnClickListener {

    private Button next,backAmaph;
    private EditText sleep, bread, veg, fruit, milk, meat, act;
    String gender, weight, height, birthday, username;
    public static final String NUMBER_DONE = "NUMBER_DONE";
    public static final String USER_NAME = "USER_NAME";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.training);

        Intent intent = getIntent();
        username = intent.getStringExtra(Home.USER_NAME);

        next = (Button) findViewById(R.id.bTrainingResult);
        next.setOnClickListener(this);

        backAmaph = (Button) findViewById(R.id.bHome);
        backAmaph.setOnClickListener(this);

        sleep =  (EditText) findViewById(R.id.etSleep);
        bread = (EditText) findViewById(R.id.etBread);
        veg = (EditText) findViewById(R.id.etVeg);
        fruit = (EditText) findViewById(R.id.etFruit);
        milk = (EditText) findViewById(R.id.etMilk);
        meat = (EditText) findViewById(R.id.etMeat);
        act = (EditText) findViewById(R.id.etAct);
    }


    @Override
    public void onClick(View v) {

        if (v == next) {
            getData();
        }

        if (v == backAmaph){
            Intent i = new Intent(Training.this, Amaph.class);
            i.putExtra(USER_NAME, username);
            startActivity(i);
        }

    }

    private void getData(){

        String url = ConfigBMI.DATA_URL+username.trim();

        StringRequest stringRequest = new StringRequest(url, new Response.Listener<String>(){
            @Override
            public void onResponse(String response){
                showJSON(response);
            }
        },
                new Response.ErrorListener(){
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(Training.this, error.getMessage().toString(), Toast.LENGTH_LONG).show();
                    }
                });
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    public void showJSON(String response){
        gender = "";
        weight = "";
        height = "";
        birthday = "";

        try{
            JSONObject jsonObject = new JSONObject(response);
            JSONArray result = jsonObject.getJSONArray(ConfigBMI.JSON_ARRAY);
            JSONObject bmiData = result.getJSONObject(0);
            gender = bmiData.getString(ConfigBMI.KEY_GENDER);
            weight = bmiData.getString(ConfigBMI.KEY_WEIGHT);
            height = bmiData.getString(ConfigBMI.KEY_HEIGHT);
            birthday = bmiData.getString(ConfigBMI.KEY_BIRTHDAY);
            update();

        }catch (JSONException e){
            e.printStackTrace();
        }
    }

    private void update() {

        //Sleep
        Sleep sleepTime = new Sleep();
        int sleep1 = Integer.parseInt(sleep.getText().toString());
        sleepTime.setSleepFinal(sleep1);

        //Activity
        Activity activityTime = new Activity();
        int act1 = Integer.parseInt(act.getText().toString());
        activityTime.setActivityFinal(act1);

        //BMI
        BMI bmi = new BMI();
        double weight1 = Integer.parseInt(weight);
        double height1 = Integer.parseInt(height);
        double bmitest = ((weight1 / (height1 * height1)) * 703);
        double ageF = Integer.parseInt(birthday);
        String sexF = gender;
        bmi.setBmiFinal(sexF, ageF, bmitest);

        //Food
        Food food = new Food();
        double bread1 = Integer.parseInt(bread.getText().toString());
        double veg1 = Integer.parseInt(veg.getText().toString());
        double fruit1 = Integer.parseInt(fruit.getText().toString());
        double milk1 = Integer.parseInt(milk.getText().toString());
        double meat1 = Integer.parseInt(meat.getText().toString());
        food.setBreadFinal(bread1, sexF);
        food.setVegetableFinal(veg1, sexF);
        food.setFruitFinal(fruit1, sexF);
        food.setMilkFinal(milk1);
        food.setMeatFinal(meat1, sexF);
        double foodAll = food.getBreadFinal() + food.getVegetableFinal() + food.getFruitFinal() + food.getMilkFinal() + food.getMeatFinal();
        food.setFoodFinal(foodAll);

        //add everything
        double all = sleepTime.getSleepFinal() + activityTime.getActivityFinal() + bmi.getBmiFinal() + food.getFoodFinal();
        int numberF = (int) all;
        //System.out.println(weight1 + " " + height1 +" "+ageF + " " + sexF + " " + numberF);

        numberFinal(numberF);
    }

   private void numberFinal(int numberF){
       Intent intent = new Intent(Training.this,TrainingResult.class);
       intent.putExtra(NUMBER_DONE,numberF);
       intent.putExtra(USER_NAME,username);
       startActivity(intent);
   }


}
