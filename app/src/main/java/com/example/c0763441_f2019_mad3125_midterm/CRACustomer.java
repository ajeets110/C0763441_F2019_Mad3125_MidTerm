package com.example.c0763441_f2019_mad3125_midterm;

import android.os.Parcel;
import android.os.Parcelable;

import java.text.NumberFormat;
import java.util.Date;
import java.util.Locale;

public class CRACustomer implements Parcelable {

    String sin_number;
    String first_name;
    String  last_name;
    String gender;
    String full_name;
    Date dob,filingDate;

    double gross_income;
    double rrsp_contribution;
    double EI;
    double total_taxable_amount=(gross_income - (cppAmount()+rrspAmount()+eiAmount()));
    double total_tax_paid=provincialTax()+federalTax();

    public Date getDob() {
        return dob;
    }
    public Date getFilingDate() {
        return filingDate;
    }

    // G E T T E R   A N D   S E T T E R


    public static final Creator<CRACustomer> CREATOR = new Creator<CRACustomer>() {
        @Override
        public CRACustomer createFromParcel(Parcel in) {
            return new CRACustomer(in);
        }

        @Override
        public CRACustomer[] newArray(int size) {
            return new CRACustomer[size];
        }
    };

    public String getSin_number() {
        return sin_number;
    }

    public void setSin_number(String sin_number) {
        this.sin_number = sin_number;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public double getGross_income() {
        return gross_income;
    }

    public void setGross_income(double gross_income) {
        this.gross_income = gross_income;
    }

    public double getRrsp_contribution() {
        return rrsp_contribution;
    }

    public void setRrsp_contribution(double rrsp_contribution) {
        this.rrsp_contribution = rrsp_contribution;
    }

    // calculating CPP amount
    public double cppAmount(){
        double cpp_slab=57400.00;
        double cpp_rate=5.10;
        double actual_cpp=0.0;
        if(gross_income>=cpp_slab)
        {
            actual_cpp=(cpp_slab*cpp_rate)/100;
        }
        else {
            actual_cpp=(gross_income*cpp_rate)/100;
        }
        return actual_cpp;
    }

    // Calculating RRSP Amount
    public double rrspAmount(){
        double rrsp_perc=18.00;
        double actual_rrsp=(gross_income*rrsp_perc)/100;
        if(actual_rrsp>rrsp_contribution) {
            System.out.println("RRSP amount exceeded ,You may have to face penalty");
        }
        return actual_rrsp;
    }

    // C a l c u l a t i n g   E I   a m o u n t
    public double eiAmount(){

        double ei_slab=53100.00;
        double ei_rate=1.62;
        double actual_ei=0.0;
        if(gross_income>=ei_slab)
        {
            actual_ei=(ei_slab * ei_rate)/100;
        }
        else {
            actual_ei=(gross_income * ei_rate)/100;
        }
        return actual_ei;
    }
    // http://zetcode.com/java/numberformat/

    public String amountFomatter()
    {
        NumberFormat nf = NumberFormat.getInstance(new Locale("en", "US"));
        String val = nf.format("$"+this);

        return val;

    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {

        parcel.writeString(sin_number);
        parcel.writeString(first_name);
        parcel.writeString(last_name);
        parcel.writeString(full_name);
        parcel.writeDouble(gross_income);
        parcel.writeDouble(rrsp_contribution);
//        parcel.writeDouble(EI);
//        parcel.writeDouble(total_taxable_amount);

    }

    public CRACustomer(String sin_number, String first_name, String last_name, String gender, double gross_income, double rrsp_contribution) {
        this.sin_number = sin_number;
        this.first_name = first_name;
        this.last_name = last_name;
        this.gross_income = gross_income;
        this.rrsp_contribution = rrsp_contribution;
        this.EI = eiAmount();
        this.gender = gender;
    }


    public CRACustomer(Parcel parcel){
        sin_number = parcel.readString();
        first_name = parcel.readString();
        last_name = parcel.readString();
        full_name = parcel.readString();
        gender = parcel.readString();
        gross_income = parcel.readDouble();
        rrsp_contribution = parcel.readDouble();

    }
    // Calculating provincial tax
    public double provincialTax(){
        double pro_tax=0.0;

        double first_slab_perc=5.05;
        double first_slab=33324;

        double second_slab_perc=9.15;
        double second_slab=43907;

        double third_slab_perc=11.16;
        double third_slab=62187;

        double fourth_slab_perc=12.16;
        double fourth_slab=70000;

        double final_slab=0.01;
        double final_slab_perc=13.16;
        total_taxable_amount=total_taxable_amount-10582.00;
        if(total_taxable_amount<=first_slab) {
            pro_tax = (first_slab * first_slab_perc) / 100;
            total_taxable_amount = total_taxable_amount - first_slab;
        }

        if(total_taxable_amount<=second_slab) {
            pro_tax = (second_slab * second_slab_perc) / 100;
            total_taxable_amount = total_taxable_amount - second_slab;
        }
        if(total_taxable_amount<=third_slab) {
            pro_tax = (third_slab * third_slab_perc) / 100;
            total_taxable_amount = total_taxable_amount - third_slab;
        }
        if(total_taxable_amount<=fourth_slab) {
            pro_tax = (fourth_slab * fourth_slab_perc) / 100;
            total_taxable_amount = total_taxable_amount - fourth_slab;
        }
        if(total_taxable_amount<=final_slab) {
            pro_tax=(final_slab * final_slab_perc)/100;
        }
        return pro_tax;
    }

    // Calculating Federal tax
    public double federalTax(){
        double fed_tax=0.0;

        double first_slab_perc=15.00;
        double first_slab=35561;

        double second_slab_perc=20.50;
        double second_slab=47628.99;

        double third_slab_perc=26.00;
        double third_slab=52407.99;

        double fourth_slab_perc=29.00;
        double fourth_slab=60703.99;

        double final_slab=0.01;
        double final_slab_perc=33.00;
        total_taxable_amount=total_taxable_amount-12069.00;
        if(total_taxable_amount>=first_slab) {
            fed_tax = (first_slab * first_slab_perc) / 100;
            total_taxable_amount = total_taxable_amount - first_slab;
        }

        if(total_taxable_amount>=second_slab) {
            fed_tax = (second_slab * second_slab_perc) / 100;
            total_taxable_amount = total_taxable_amount - second_slab;
        }
        if(total_taxable_amount>=third_slab) {
            fed_tax = (third_slab * third_slab_perc) / 100;
            total_taxable_amount = total_taxable_amount - third_slab;
        }
        if(total_taxable_amount>=fourth_slab) {
            fed_tax = (fourth_slab * fourth_slab_perc) / 100;
            total_taxable_amount = total_taxable_amount - fourth_slab;
        }
        if(total_taxable_amount>=final_slab) {
            fed_tax=(final_slab * final_slab_perc)/100;
        }
        return fed_tax;
    }



}
