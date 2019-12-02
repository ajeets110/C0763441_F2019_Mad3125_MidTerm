package com.example.c0763441_f2019_mad3125_midterm;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    // C o m m e n t   a d d e d
    String Gender_selected;
    TextView txt_date;
    RadioGroup rg_gender;
    RadioButton rb_male;
    RadioButton rb_female;
    RadioButton rb_others;
    TextView edt_fname;
    TextView edt_lname;
    Button btn_submit;
    TextView txt_age;
    DatePickerDialog datePickerDialog;
    final Calendar calendar = Calendar.getInstance();
    TextView edt_sin;
    TextView gross_income;
    TextView rrsp_contribution;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt_date= findViewById(R.id.txtDate);
        rg_gender=findViewById(R.id.rgGender);
        rb_male=findViewById(R.id.rbMale);
        rb_female=findViewById(R.id.rbFemale);
        rb_others=findViewById(R.id.rbOthers);
        txt_date= findViewById(R.id.txtDate);
        edt_fname = findViewById(R.id.edtFname);
        edt_lname = findViewById(R.id.edtLname);
        edt_sin = findViewById(R.id.edtSin);
        gross_income = findViewById(R.id.edtGrossIncome);
        rrsp_contribution = findViewById(R.id.edtRRSP);
        // https://stackoverflow.com/questions/14933330/datepicker-how-to-popup-datepicker-when-click-on-edittext
        final DatePickerDialog.OnDateSetListener t_date = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                calendar.set(Calendar.YEAR, year);
                calendar.set(Calendar.MONTH, monthOfYear);
                calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                dateFormat();
            }
        };
        txt_date.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                new DatePickerDialog(MainActivity.this, t_date, calendar
                        .get(Calendar.YEAR), calendar.get(Calendar.MONTH),
                        calendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        rg_gender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                if(checkedId == R.id.rbMale){
                    Gender_selected = rb_male.getText().toString();
                }else if(checkedId == R.id.rbFemale){
                    Gender_selected  = rb_female.getText().toString();
                }else {
                    Gender_selected = rb_others.getText().toString();
                }
            }

        });
        //submit button

        btn_submit=findViewById(R.id.btnSubmit);
        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // TYPE Casting
                Double g_income = Double.parseDouble(gross_income.getText().toString());
                Double rrs = Double.parseDouble(rrsp_contribution.getText().toString());
                Intent mIntent=new Intent(MainActivity.this, DisplayActivity.class);
                mIntent.putExtra("User_Data", new CRACustomer(edt_sin.getText().toString(), edt_fname.getText().toString(), edt_lname.getText().toString(), Gender_selected, g_income, rrs));
                startActivity(mIntent);
            }
        });

    }


    // D a t e   f o r m a t
    private void dateFormat() {
        String myFormat = "dd-MMM-yyyy";
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        txt_date.setText(sdf.format(calendar.getTime()));
    }

}
