package com.bg816am.acerestaurant;

import android.app.AlertDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.app.DatePickerDialog;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import java.sql.Time;
import java.time.Clock;

public class Reservation extends MainActivity {


    private TextView mDisplayDate;
    private DatePickerDialog.OnDateSetListener mOnDateSetListener;

    private TextView mDisplayTime;
    private TimePickerDialog.OnTimeSetListener mOnTimeSetListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reservationscreen);
        mDisplayDate = findViewById(R.id.dateSelect);
        mDisplayTime = findViewById(R.id.visitTime);

        mDisplayTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar time = Calendar.getInstance();
                int hour = time.get(Calendar.HOUR);
                int min = time.get(Calendar.MINUTE);
            TimePickerDialog timeDiag = new TimePickerDialog(Reservation.this, R.style.ThemeOverlay_AppCompat_Dialog,mOnTimeSetListener,
                    hour, min, false);
            timeDiag.show();
            }
        });

        mDisplayDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_WEEK_IN_MONTH);

                DatePickerDialog dateDiag = new DatePickerDialog(Reservation.this, R.style.ThemeOverlay_AppCompat_Dialog, mOnDateSetListener,
                        year, month, day);
                //dateDiag.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dateDiag.show();

            }
        });

        mOnDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
            month = month +1;

            String date = month + "/" + day + "/" + year;
            mDisplayDate.setText(date);
            }
        };

        mOnTimeSetListener = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int hour, int min) {
                if (hour % 12 > 1){
                    hour = hour - 12;
                }
                String time = hour + ":" + min;
                mDisplayTime.setText(time);
            }
        };

        Button confirmReservation;
        confirmReservation = findViewById(R.id.confirmButton);

        confirmReservation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Log.d("acerestaurant", "Confirmed");
               EditText nameBox = findViewById(R.id.nameBox);
               String name = nameBox.getText().toString();
               TextView timePicker = findViewById(R.id.visitTime);
               String time = timePicker.getText().toString();

               AlertDialog.Builder alert = new AlertDialog.Builder(Reservation.this);
                alert.setTitle("Thank you!");
                alert.setCancelable(false);
                alert.setMessage("See you at "+ time + " " + name + ".");
                alert.setPositiveButton("Main Menu", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                });
                alert.show();

            }
        });



            }


    }







