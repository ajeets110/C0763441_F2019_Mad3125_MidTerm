package com.example.c0763441_f2019_mad3125_midterm;

public class CRACustomer {

    int sin_number;
    String first_name;
    String  last_name;
    String full_name=last_name.toUpperCase()+","+first_name;
    double gross_income;
    double rrsp_contribution;

    // G E T T E R   A N D   S E T T E R

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
}
