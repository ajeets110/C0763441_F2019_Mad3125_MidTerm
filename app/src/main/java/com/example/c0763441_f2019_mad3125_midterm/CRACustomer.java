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
    String dob;
    double gross_income;
    double rrsp_contribution;


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
            return last_name.toUpperCase() + ", " + first_name.substring(0,1).toUpperCase() + first_name.substring(1);
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
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
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
        parcel.writeString(gender);

    }

    public CRACustomer(String sin_number, String first_name, String last_name, String gender, double gross_income, double rrsp_contribution, String age) {
        this.sin_number = sin_number;
        this.first_name = first_name;
        this.last_name = last_name;
        this.gross_income = gross_income;
        this.rrsp_contribution = rrsp_contribution;
        this.gender = gender;
        dob = age;
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


}
