package com.example.c0763441_f2019_mad3125_midterm;

import androidx.appcompat.app.AppCompatActivity;

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

    }
}
