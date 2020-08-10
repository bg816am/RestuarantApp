package com.bg816am.acerestaurant;

import android.app.AlertDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.DatePicker;
import android.app.DatePickerDialog;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Random;

public class Reservation extends MainActivity {

    private TextView mDisplayDate;
    private TextView mDisplayTime;


    private Spinner mSelectGuests;
    private int mNumberOfGuests;

    private String mName;
    private String mEmail;
    private String mPhone;
    private String mSpecialRequests;

    private EditText mSpecialRequestsBox;
    private EditText mNameBox;
    private EditText mPhoneBox;
    private EditText mEmailBox;

    private DatePickerDialog.OnDateSetListener mOnDateSetListener;
    private TimePickerDialog.OnTimeSetListener mOnTimeSetListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Link XML to java variables
        setContentView(R.layout.reservationscreen);
        mDisplayDate = findViewById(R.id.dateSelect);
        mDisplayTime = findViewById(R.id.visitTime);
        Button confirmReservation = findViewById(R.id.confirmButton);


        //bring up a clock widget allowing to select a time
        mDisplayTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar time = Calendar.getInstance();
                int hour = time.get(Calendar.HOUR);
                int min = time.get(Calendar.MINUTE);

                TimePickerDialog timeDiag = new TimePickerDialog(Reservation.this, R.style.ThemeOverlay_AppCompat_Dialog, mOnTimeSetListener,
                        hour, min, false);
                timeDiag.show();
            }
        });

        //bring up a calendar widget allowing for a date to be selected.
        mDisplayDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_WEEK_IN_MONTH);
                DatePickerDialog dateDiag = new DatePickerDialog(Reservation.this, R.style.ThemeOverlay_AppCompat_Dialog, mOnDateSetListener,
                        year, month, day);
                dateDiag.show();

            }
        });

        // Replaces the date on the text view after selecting the date
        mOnDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;

                String date = month + "/" + day;
                mDisplayDate.setText(date);
            }
        };
        // Replaces the time on the textview after selecting a the time
        mOnTimeSetListener = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int hour, int min) {
                String amPm;
                if (hour > 12) {
                    hour = hour - 12;
                    amPm = " PM";
                } else
                    amPm = " AM";

                String time = (hour + ":" + min + amPm);
                mDisplayTime.setText(time);
            }
        };


        //On button press, confirming the reservation
        confirmReservation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Pulls what was typed in name/email
                //int mNumberOfGuests = mSelectGuests.getSelectedItemPosition();

                mSelectGuests = findViewById(R.id.guestNumber);
                mNumberOfGuests = mSelectGuests.getSelectedItemPosition();

                mNameBox = findViewById(R.id.nameBox);
                mName = mNameBox.getText().toString();

                mEmailBox = findViewById(R.id.emailBox);
                mEmail = mEmailBox.getText().toString();

                mPhoneBox = findViewById(R.id.phoneBox);
                mPhone = mPhoneBox.getText().toString();

                mSpecialRequestsBox = findViewById(R.id.specialRequests);
                mSpecialRequests = mSpecialRequestsBox.getText().toString();


                TextView timePicker = findViewById(R.id.visitTime);
                String time = timePicker.getText().toString();
                TextView datePicker = findViewById(R.id.dateSelect);
                String date = datePicker.getText().toString();

                mDisplayDate.setText(date);
                mDisplayTime.setText(time);

                //using a random number generator to simulate a confirmation number
                double random = Math.random();
                int confirmNumber = (int) (random * 100);

                // To use proper grammar depending on number of people going to restuarant
                String peoplePlural;

                if (mNumberOfGuests == 1) {
                    peoplePlural = "person";
                } else
                    peoplePlural = "people";

                //logic for making sure user enters in information correctly
                if (!isNameValid(mName) || !isPhoneValid(mPhone) || !isEmailValid(mEmail)
                        || time.length() < 4 || date.length() < 2 || mNumberOfGuests < 1) {
                    Toast toast = Toast.makeText(Reservation.this, "Please complete all fields", Toast.LENGTH_SHORT);
                    toast.show();
                } else {
                    //Sets up an alert pop up confirming reservation with a confirm number.
                    Toast.makeText(Reservation.this, "Confirming with restaurant", Toast.LENGTH_SHORT).show();
                    AlertDialog.Builder alert = new AlertDialog.Builder(Reservation.this);
                    alert.setTitle("Thank you " + mName + "!");
                    alert.setCancelable(false);
                    alert.setMessage("See you on " + date + " at " + time + ". Your reservation number is "
                            + confirmNumber + " for " + mNumberOfGuests + " " + peoplePlural + ".");
                    alert.setPositiveButton("Main Menu", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            finish();
                        }
                    });
                    alert.show(); //show alert
                }

            }
        });


    }

    //Logic for checking if the user enters in valid input into the reservation screen
    //Checks for email to have a@ and longer than one character
    private boolean isEmailValid(String mEmail) {

        return mEmail.contains("@") && (mEmail.length() > 1);
    }

    //makes sure the phone number is correct length
    private boolean isPhoneValid(String mPhone) {

        return mPhone.length() == 10;
    }

    //makes sure the user enters something into the name field
    private boolean isNameValid(String mName) {

        return !mName.equals("");
    }

}







