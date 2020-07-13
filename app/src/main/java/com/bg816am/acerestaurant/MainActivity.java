package com.bg816am.acerestaurant;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    //Create the home screen buttons to go to individual apps
    private Button goToReservation;
    private Button goToDrink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // link buttons to IDs in XML
        goToReservation =findViewById(R.id.resButton);
        goToDrink = findViewById(R.id.drinkButton);

        goToReservation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });

        goToDrink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }
}