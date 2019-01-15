package com.example.rickb.week2day1;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tvDisplay;
    SharedPreferences prefs;
    public static final int RESULT_CODE = 667;
    public static final String TAG = "tag";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvDisplay = findViewById(R.id.result);
        Intent passedIntent = getIntent();
        if (passedIntent.getExtras() != null) {
            Bundle bundle = passedIntent.getExtras();
            Car car = (Car) bundle.getParcelable("car_data");

            tvDisplay.setText("");
            tvDisplay.append(car.getYear());
            tvDisplay.append(" ");
            tvDisplay.append(car.getMake());
            tvDisplay.append(" ");
            tvDisplay.append(car.getModel());
            tvDisplay.append(" ");
            tvDisplay.append(car.getColor());
            tvDisplay.append(" ");
            tvDisplay.append(car.getEngine());
            tvDisplay.append(" ");
            tvDisplay.append(car.getTransmission());
            tvDisplay.append(" ");
            tvDisplay.append(car.getTitle());
            prefs = getSharedPreferences("sharedPref", Context.MODE_PRIVATE);
            SharedPreferences.Editor myEditor = prefs.edit();
            myEditor.putString("make", car.getMake());
            myEditor.putString("model", car.getModel());
            myEditor.commit();
            Log.d(TAG, "Make is " + car.getMake() + " Model is " + car.getModel());
        }
    }



    public void onClick(View view){

        switch (view.getId()){
            case R.id.firstButton:
                Intent intentOne = new Intent(this, Main2Activity.class);
                startActivityForResult(intentOne, RESULT_CODE);
                break;

            case R.id.secondButton:
                Intent intentTwo = new Intent(this, Main3Activity.class);
                startActivity(intentTwo);
                break;

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(data != null){
            Intent passedIntent = data;
            Car car = passedIntent.getParcelableExtra("car_data");
            tvDisplay.setText("");
            tvDisplay.append(car.getYear());
            tvDisplay.append(" ");
            tvDisplay.append(car.getMake());
            tvDisplay.append(" ");
            tvDisplay.append(car.getModel());
            tvDisplay.append(" ");
            tvDisplay.append(car.getColor());
            tvDisplay.append(" ");
            tvDisplay.append(car.getEngine());
            tvDisplay.append(" ");
            tvDisplay.append(car.getTransmission());
            tvDisplay.append(" ");
            tvDisplay.append(car.getTitle());
            prefs = getSharedPreferences("sharedPref", Context.MODE_PRIVATE);
            SharedPreferences.Editor myEditor = prefs.edit();
            myEditor.putString("make", car.getMake());
            myEditor.putString("model", car.getModel());
            myEditor.commit();
            Log.d(TAG, "Make is " + car.getMake() + " Model is " + car.getModel());
        }
        else{
            tvDisplay.setText("Display was null");
        }
    }
}
