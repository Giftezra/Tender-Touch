package com.example.tendertouch;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;
import java.util.Locale;

public class Activity extends AppCompatActivity {

    /**
     * This is the class that will enable users to update their calender activities and hourly rates
     * this class will extend some classes and implement some methods*/

    //Declaring the fields
    private EditText startDate, startTime;
    private EditText endDate, endTime;
    private Calendar calendar;


    /** This is the constructor that will create and display the xml file */
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activities);

        // Initializing the views
        startDate = findViewById(R.id.start_date);
        endDate = findViewById(R.id.end_date);
        startTime = findViewById(R.id.start_time);
        endTime = findViewById(R.id.end_time);
        calendar = Calendar.getInstance();

        //Set the current date on the edit text
        updateDate(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
        updateTime(calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE));

    }

    /** This method will show the date picker as a dialog to the user#
    * @param v
    **/
    public void showDatePicker(View v) {
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                updateDate(year, month, dayOfMonth);
            }
        }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));

        datePickerDialog.show();
    }


    /** This method will show the time picker as a dialog to the user#
     * @param v
     **/
    public void showTimePicker(View v) {
        TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                updateTime(hourOfDay, minute);
            }
        }, calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE), false);

        timePickerDialog.show();
    }


    /**
     * This method will update the user view with the current date or whatever the user choice
     * @param year
     * @param month
     * @param dayOfMonth
     * */
    private void updateDate(int year, int month, int dayOfMonth){
        String selectDate = String.format(Locale.getDefault(), "%02d-%02d-%04d", dayOfMonth, month +1, year );
        startDate.setText(selectDate);
        endDate.setText(selectDate);
    }


    /**
     * This method will update the user view with the current time or whatever the user choice
     * @param hourOfDay
     * @param minute
     * */
    private void updateTime(int hourOfDay, int minute) {
        String selectedTime = String.format(Locale.getDefault(), "%02d:%02d", hourOfDay, minute);
        startTime.setText(selectedTime);
        endTime.setText(selectedTime);
    }

}
