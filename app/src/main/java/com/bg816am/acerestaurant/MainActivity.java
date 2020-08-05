package com.bg816am.acerestaurant;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Create the home screen buttons to go to individual apps and link to XML
        Button goToReservation =findViewById(R.id.resButton);
        Button goToDrink = findViewById(R.id.drinkButton);

        // click to go the Reservation screen
        goToReservation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, Reservation.class));
            }
        });
        // click to go to drink mixer
        goToDrink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, DrinkMixer.class));
            }
        });

    }
}