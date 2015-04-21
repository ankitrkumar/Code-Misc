package com.personalcapital.financialplanning.transaction;

/**
 /////////////////////////////////////////////////////////////////////////////
 // SpendingTransaction.java - Class for each spending transaction with     //
 //                            given attributes                             //
 // ver 1.0                                                                 //
 // ----------------------------------------------------------------------- //
 // copyright © Ankit Kumar, 2015                                           //
 // All rights granted provided that this notice is retained                //
 // ----------------------------------------------------------------------- //
 // Language:    Java JDK 1.8, IntelliJ IDEA 14.0.2                         //
 // Platform:    Asus ROG GL551JM-EH71, Core i7, Windows 8.1 64-bit         //
 // Application: Personal Capital code challenge , 2015                     //
 // Author:      Ankit Kumar, Syracuse University						    //
 //              (315) 728-8955, akumar15@syr.edu	                        //
 /////////////////////////////////////////////////////////////////////////////
 *
 * Public Interface:
 * ----------------
 * SpendingTransaction st(2L, 200.0, new GregorianCalendar(2014, 7, 13));
 * st.getExpDate();
 * st.getAccNumber();
 * st.getExpAmount();
 *
 * st.setExpDate(new GregorianCalendar(2014, 1, 4));
 * st.setAccNumber(2095L);
 * st.setExpAmount(1000.0);
 *
 */


import java.util.Calendar;

public class SpendingTransaction {

    //------<Each Spending transaction will have these attributes>---------------
    private Calendar expDate;
    private Long accNumber;
    private Double expAmount;

    //------<Parametrized constructor>---------------
    public SpendingTransaction(Long accNumber, Double expAmount, Calendar expDate)
    {
        if(accNumber >= 0 && expAmount >= 0) {
            this.accNumber = accNumber;
            this.expAmount = expAmount;
            this.expDate = expDate;
        }
        else
        {
            this.accNumber = 0L;
            this.expAmount = 0.00;
            this.expDate = expDate;
        }

    }

    //------<Getter for Expenditure date associated to a transaction>---------------
    public Calendar getExpDate() {
        return expDate;
    }

    //------<Setter for Expenditure date associated to a transaction>---------------
    public void setExpDate(Calendar expDate) {
        if(expAmount>=0)
            this.expDate = expDate;
        else
            this.expAmount=0.0;
    }

    //------<Getter for account number>---------------
    public Long getAccNumber() {
        return accNumber;
    }

    //------<Setter for account number>---------------
    public void setAccNumber(Long accNumber) {
        if(accNumber>=0)
            this.accNumber = accNumber;
        else
            this.accNumber = 0L;
    }

    //------<Getter for Expenditure ammount>---------------
    public Double getExpAmount() {
        return expAmount;
    }

    //------<Setter for Expenditure ammount>---------------
    public void setExpAmount(Double expAmount) {
        this.expAmount = expAmount;
    }

}
