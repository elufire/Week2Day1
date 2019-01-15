package com.example.rickb.week2day1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Main2Activity extends AppCompatActivity {
    EditText edYear;
    EditText edMake;
    EditText edModel;
    EditText edColor;
    EditText edEngine;
    EditText edTransmission;
    EditText edTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        edYear = findViewById(R.id.year);
        edMake = findViewById(R.id.make);
        edModel = findViewById(R.id.model);
        edColor = findViewById(R.id.color);
        edEngine = findViewById(R.id.engine);
        edTransmission = findViewById(R.id.transmission);
        edTitle = findViewById(R.id.title);
    }

    public void onClick(View view){
        Car newCar = new Car();
        newCar.setYear(edYear.getText().toString());
        newCar.setMake(edMake.getText().toString());
        newCar.setModel(edModel.getText().toString());
        newCar.setColor(edColor.getText().toString());
        newCar.setEngine(edEngine.getText().toString());
        newCar.setTransmission(edTransmission.getText().toString());
        newCar.setTitle(edTitle.getText().toString());
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("car_data", newCar);
        setResult(667, intent);
        finish();
    }


}
