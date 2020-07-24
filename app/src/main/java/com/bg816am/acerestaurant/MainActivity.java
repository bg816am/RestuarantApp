package com.bg816am.acerestaurant;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.Calendar;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    //Create the home screen buttons to go to individual apps
    Button goToReservation;
    Button goToDrink;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // link buttons to IDs in XML
        goToReservation =findViewById(R.id.resButton);
        goToDrink = findViewById(R.id.drinkButton);


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