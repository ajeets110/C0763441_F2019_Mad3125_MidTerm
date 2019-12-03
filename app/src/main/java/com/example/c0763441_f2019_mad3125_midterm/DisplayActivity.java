package com.example.c0763441_f2019_mad3125_midterm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DisplayActivity extends AppCompatActivity {

    CRACustomer customer;
    TextView txt_sin;
    TextView txt_full_Name;
    TextView txt_gender;
    TextView txt_gross_income, txt_taxDate, txt_federal_tax, txt_provincialTax, lbl_cpp, lbl_empInsurance, lbl_RrspContributed, lbl_Cf_RRSP, lbl_taxableIncome, lbl_taxPaid, lbl_TaxFilingDate;
    double cpp = 0;
    double rrsp = 0;
    double rrspCf = 0;
    double totalTaxableAmount;
    double federalTax;
    double provincialTax;
    double totalTaxPaid;
    double emp_Insurance;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        txt_sin = findViewById(R.id.txt_Sin);
        txt_full_Name = findViewById(R.id.txt_fullName);
        txt_gender = findViewById(R.id.txt_gender);
        txt_gross_income = findViewById(R.id.txt_grossIncome);
        lbl_RrspContributed = findViewById(R.id.txt_rrspContribution);
        lbl_cpp = findViewById(R.id.txt_Cpp);
        lbl_empInsurance = findViewById(R.id.txt_empInsurance);
        lbl_Cf_RRSP = findViewById(R.id.txt_cfRrsp);
        lbl_taxableIncome = findViewById(R.id.id_taxableIncome);
        txt_federal_tax = findViewById(R.id.txt_federalTax);
        txt_provincialTax = findViewById(R.id.txt_provincialTax);
        lbl_taxPaid = findViewById(R.id.txt_taxPayed);
        lbl_TaxFilingDate = findViewById(R.id.txt_taxFilingDate);

        Intent mIntent = getIntent();
        CRACustomer customer = mIntent.getParcelableExtra("User_Data");


        txt_sin.setText(" SIN: \t" + customer.getSin_number());
        txt_full_Name.setText(" FULL NAME: \t" + customer.getFull_name());
        txt_gender.setText(" GENDER: \t" + customer.getGender());
        txt_gross_income.setText(" GROSS INCOME: \t" + customer.getGross_income());
        lbl_RrspContributed.setText("RRSP Contributed: \t" + customer.getRrsp_contribution());
        rrsp = customer.getRrsp_contribution();

        // calculate  cpp

        double grossIncome = customer.getGross_income();
        if (grossIncome > 57400.00) {
            cpp = (57400.00 * 0.051); //5.10%
        } else {
            cpp = (grossIncome * 0.051);
        }
        lbl_cpp.setText("CPP Contribution in Year:\t" + cpp);

        // calculate employement insurance
            if (grossIncome > 53100) {
                emp_Insurance = (53100 * 0.0162); //1.62%
            } else {
                emp_Insurance = (grossIncome * (1.62 / 100));
            }
        lbl_empInsurance.setText("Employeement Insurance: \t" + emp_Insurance);

        // calculate RRSP

        rrsp = customer.getRrsp_contribution();
        double maxRRSP = (grossIncome * 0.18); //18%
        if(rrsp > maxRRSP ){
            Toast.makeText(this,"you mave have to face a penalty, amount exceeding",Toast.LENGTH_SHORT).show();
            rrspCf = rrsp - maxRRSP;
            rrsp = maxRRSP;
        }else{
            rrsp = rrsp;
        }
        lbl_Cf_RRSP.setText("RRSP Carry forward: \t"+ rrspCf);

        //taxable income
            totalTaxableAmount = grossIncome - (cpp + emp_Insurance + rrsp);
            lbl_taxableIncome.setText("Taxable income:\t" + (double) totalTaxableAmount);


        //federal tax
        double calFederal = calcFedralTax();
        txt_federal_tax.setText("Federal Tax: \t" + calFederal);
        // Provincial Tax
        double calProvincial = calcProvincialTax();
        txt_provincialTax.setText("Provincial Tax:\t" + calProvincial);
        // total tax paid
        double taxpaid = calcTaxPaid();
        lbl_taxPaid.setText("Total tax Paid:\t" + taxpaid);

        // tax filing date
        SimpleDateFormat currentDate = new SimpleDateFormat("dd/MM/yyyy");
        Date todayDate = new Date();
        String thisDate = currentDate.format(todayDate);
        lbl_TaxFilingDate.setText("Tax Filing Date: " + thisDate);

    }

    public double calcFedralTax () {
        //calculate federal tax
        double temp = totalTaxableAmount;
        if (temp <= 12069.00) {
            federalTax = 0;//0%
            temp = totalTaxableAmount - 12069.00;
        }
        if (temp >= 12069.01) {
            federalTax = (temp * 0.15);//15%
            temp = temp - 35561;
        }
        if (temp >= 47630.01) {
            federalTax = (temp * 0.205); //20.50%
            temp = temp - 47628.99;
        }
        if (temp >= 95259.01) {
            federalTax = (temp * 0.26); //26%
            temp = temp - 52407.99;
        }
        if (temp >= 147667.01) {
            federalTax = (temp * 0.29);//29%
            temp = temp - 62703.99;
        }
        if (temp >= 210371.01) {
            federalTax = (temp * 0.33);//33%
            //temp = temp - federalTax;
        }
        return federalTax;
    }

    public double calcProvincialTax () {
        //calculate provincial tax
        double temp = totalTaxableAmount;

        if (temp <= 10582.00) {
            provincialTax = 0;
            temp = totalTaxableAmount - 10582.00;
        }
        if (temp >= 10582.01) {
            provincialTax = (temp * 0.0505); //5.05%
            temp = temp - 33323.99;
        }
        if (temp >= 43906.01) {
            provincialTax = (temp * 0.0915); //9.15%
            temp = temp - 43906.99;
        }
        if (temp >= 87813.01) {
            provincialTax = (temp * 0.1116); //11.16%
            temp = temp - 62187.99;
        }
        if (temp >= 150000.01) {
            provincialTax = (temp * 0.1216);//12.16%
            temp = temp - 69999.99;
        }
        if (temp >= 220000.01) {
            provincialTax = (temp * 0.1316);//13.16%

        }
        return provincialTax;
    }

    public double calcTaxPaid () {
        return totalTaxPaid = provincialTax + federalTax;
    }

}
