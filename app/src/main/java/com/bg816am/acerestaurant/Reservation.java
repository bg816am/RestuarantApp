package com.bg816am.acerestaurant;

import android.app.AlertDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.app.DatePickerDialog;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

public class Reservation extends MainActivity {

    private TextView mDisplayDate;
    private TextView mDisplayTime;


    private Spinner mGuests;

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
            TimePickerDialog timeDiag = new TimePickerDialog(Reservation.this, R.style.ThemeOverlay_AppCompat_Dialog,mOnTimeSetListener,
                    hour, min, false);
            timeDiag.show();
            }
        });

        //bing up a calendar widget allowing for a date to be selected.
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
            month = month +1;

            String date = month + "/" + day;
            mDisplayDate.setText(date);
            }
        };
        // Replaces the time on the textview after selecting a the time
        mOnTimeSetListener = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int hour, int min) {
                String amPm;
                if(hour > 12) {
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
               if (!(isNameValid(mName)) || !(isPhoneValid(mPhone)) || !(isEmailValid(mEmail))) {
                   Toast toast = Toast.makeText(Reservation.this, "Please complete all fields", Toast.LENGTH_SHORT);
                   toast.show();
                } else {
                   //Sets up an alert pop up confirming reservation
                   AlertDialog.Builder alert = new AlertDialog.Builder(Reservation.this);
                   alert.setTitle("Thank you " + mName + "!");
                   alert.setCancelable(false);
                   alert.setMessage("See you on " + date + " at " + time + ".");
                   alert.setPositiveButton("Main Menu", new DialogInterface.OnClickListener() {
                       @Override
                       public void onClick(DialogInterface dialogInterface, int i) {
                           finish();
                       }
                   });
                   alert.show(); //show alert
               }
   //TODO: Collect phone number and requests field from user = DONE
   //TODO: Correct time to show AM/PM = DONE

            }
        });


            }
    private boolean isEmailValid(String mEmail) {
        // You can add more checking logic here.
        return mEmail.contains("@") && (mEmail.length() > 1);
    }

    private boolean isPhoneValid(String mPhone){

        return mPhone.length() == 10;
    }

    private boolean isNameValid(String mName){

        return mName.equals("");
    }

    }







