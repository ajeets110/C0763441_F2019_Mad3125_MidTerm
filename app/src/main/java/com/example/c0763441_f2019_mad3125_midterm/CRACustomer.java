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

    // C a l  c u l a t i n g   P r o v i n c i a l   t a x
    public double provincialTax(){
        double pro_tax=0.0;

        double first_slab_perc=5.05;
        double first_slab=33324;

        double second_slab_perc=9.15;
        double second_slab=43907;

}
