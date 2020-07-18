package com.bg816am.acerestaurant;

import android.icu.util.Calendar;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.app.DatePickerDialog;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import androidx.fragment.app.DialogFragment;

public class Reservation extends MainActivity {
    //Link code to xml screen
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reservationscreen);

        Spinner spinner = findViewById(R.id.guestNumber);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.numberOfGuests, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner.setAdapter(adapter);

      //  DialogFragment resDate = new DialogFragment();
        Button chooseDate = findViewById(R.id.resDate);

        chooseDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });


    }
}
