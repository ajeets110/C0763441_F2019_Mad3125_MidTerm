package com.example.c0763441_f2019_mad3125_midterm;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // C o m m e n t   a d d e d
    TextView txt_date;
    RadioGroup rg_gender;
    RadioButton rb_male;
    RadioButton rb_female;
    RadioButton rb_others;
    TextView txt_fullName;
    EditText edt_fname;
    EditText edt_lname;
    Button btn_submit;
    TextView txt_age;
    DatePickerDialog datePickerDialog;
    int d_day;
    int d_month;
    int d_year;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


}
