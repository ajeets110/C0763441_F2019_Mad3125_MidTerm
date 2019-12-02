package com.example.c0763441_f2019_mad3125_midterm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayActivity extends AppCompatActivity {

    CRACustomer customer;
    TextView txt_sin;
    TextView txt_full_Name;
    TextView txt_gender;
    TextView txt_gross_income, txt_taxDate, txt_federal_tax, txt_provincialTax, lbl_cpp, lbl_empInsurance, lbl_RrspContributed, lbl_Cf_RRSP, lbl_taxableIncome, lbl_taxPaid;
    double cpp = 0;
    double ei = 0;
    double rrsp = 0;
    double rrspCf = 0;
    double taxableIncome;
    double federalTax;
    double provincialTax;
    double totalTaxPaid;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        txt_sin = findViewById(R.id.txt_Sin);
        txt_full_Name = findViewById(R.id.txt_fullName);
        txt_gender =   findViewById(R.id.txt_gender);
        txt_gross_income = findViewById(R.id.txt_grossIncome);
        lbl_RrspContributed = findViewById(R.id.txt_rrspContribution);
        lbl_cpp = findViewById(R.id.txt_CppYear);
        lbl_empInsurance = findViewById(R.id.txt_empInsurance);
        lbl_Cf_RRSP = findViewById(R.id.txt_cfRrsp);
        lbl_taxableIncome = findViewById(R.id.id_taxableIncome);
        txt_federal_tax = findViewById(R.id.txt_federalTax);
        txt_provincialTax = findViewById(R.id.txt_provincialTax);
        lbl_taxPaid = findViewById(R.id.txt_taxPayed);


        Intent mIntent = getIntent();
        CRACustomer customer = mIntent.getParcelableExtra("CRACustomer");

        txt_sin.setText(" SIN: \t" + customer.getSin_number());
        txt_full_Name.setText(" FULL NAME: \t" + customer.getFull_name());
        txt_gender.setText(" GENDER: \t" + customer.getGender());
        txt_gross_income.setText(" GROSS INCOME: \t" + customer.getGross_income());
        lbl_RrspContributed.setText("RRSP Contributed: \t" + customer.getRrsp_contribution());

        // calculate  cpp
        double grossIncome = customer.getGross_income();
        if(grossIncome > 57400.00){
            cpp = (57400.00 * 0.051); //5.10%
        } else {
            cpp = (grossIncome * 0.051);
        }
        lbl_cpp.setText("CPP COntribution in Year:\t" + cpp);

        // calculate employement insurance
        if(grossIncome > 53100){
            ei = (53100 * 0.0162); //1.62%
        }else{
            ei = (grossIncome * (1.62/100));
        }
        lbl_empInsurance.setText("Employeement Insurance: \t" + ei);

    }
}
