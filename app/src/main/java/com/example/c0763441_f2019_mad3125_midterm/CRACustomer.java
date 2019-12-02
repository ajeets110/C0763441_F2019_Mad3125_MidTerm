package com.example.c0763441_f2019_mad3125_midterm;

import android.os.Parcel;
import android.os.Parcelable;

import java.text.NumberFormat;
import java.util.Locale;

public class CRACustomer implements Parcelable {

    int sin_number;
    String first_name;
    String  last_name;
    String full_name=last_name.toUpperCase()+","+first_name;
    double gross_income;
    double rrsp_contribution;
    double EI;
    double total_taxable_amount=(gross_income - (cppAmount()+rrspAmount()+eiAmount()));


    // G E T T E R   A N D   S E T T E R

    protected CRACustomer(Parcel in) {
        sin_number = in.readInt();
        first_name = in.readString();
        last_name = in.readString();
        full_name = in.readString();
        gross_income = in.readDouble();
        rrsp_contribution = in.readDouble();
        EI = in.readDouble();
        total_taxable_amount = in.readDouble();
    }



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

    public int getSin_number() {
        return sin_number;
    }

    public void setSin_number(int sin_number) {
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

        parcel.writeString(String.valueOf(sin_number));
        parcel.writeString(first_name);
        parcel.writeString(last_name);
        parcel.writeString(full_name);
        parcel.writeDouble(gross_income);
        parcel.writeDouble(rrsp_contribution);
        parcel.writeDouble(EI);
        parcel.writeDouble(total_taxable_amount);

    }

    public CRACustomer(int sin_number, String first_name, String last_name, String full_name, double gross_income, double rrsp_contribution) {
        this.sin_number = sin_number;
        this.first_name = first_name;
        this.last_name = last_name;
        this.full_name = full_name;
        this.gross_income = gross_income;
        this.rrsp_contribution = rrsp_contribution;
        this.EI = eiAmount();
    }


}
