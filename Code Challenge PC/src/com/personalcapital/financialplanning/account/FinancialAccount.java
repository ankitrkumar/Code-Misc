package com.personalcapital.financialplanning.account;

import com.personalcapital.financialplanning.transaction.SpendingTransaction;

/**
 /////////////////////////////////////////////////////////////////////////////
 // FinancialAccount.java - Financial Account and attributes for the given  //
 //                         account                                         //
 // ver 1.0                                                                 //
 // ----------------------------------------------------------------------- //
 // copyright © Ankit Kumar, 2015                                           //
 // All rights granted provided that this notice is retained                //
 // ----------------------------------------------------------------------- //
 // Language:    Java JDK 1.8, IntelliJ IDEA 14.0.2                         //
 // Platform:    Asus ROG GL551JM-EH71, Core i7, Windows 8.1 64-bit         //
 // Application: Personal Capital code challenge , 2015                    //
 // Author:      Ankit Kumar, Syracuse University						    //
 //              (315) 728-8955, akumar15@syr.edu	                        //
 /////////////////////////////////////////////////////////////////////////////
 *
 * Public Interface:
 * ----------------
 * FinancialAccount fa(1L, new GregorianCalendar(2014, 1, 4));
 * ArrayList<SpendingTransaction> spendingTransactionList = new ArrayList<SpendingTransaction>();
 * fa.getDateOpened();
 * fa.getAccNumber();
 * fa.getSpendingTransactionList();
 *
 * fa.setDateOpened(new GregorianCalendar(2014, 1, 4));
 * fa.setAccNumber(2095L);
 * fa.setSpendingTransactionList(spendingTransactionList);
 *
 * fa.equals(fa);
 * //returns true;
 */

import java.util.ArrayList;
import java.util.Calendar;

public class FinancialAccount {

    //------<Each financial account will have these attributes>---------------
    private Calendar dateOpened;
    private Long accNumber;
    private ArrayList<SpendingTransaction> spendingTransactionList;

    //------<Parametrized constructor>---------------
    public FinancialAccount(Long accNumber, Calendar dateOpened)
    {
        if(accNumber>=0)
            this.accNumber = accNumber;
        else
            this.accNumber = 0L;

        this.dateOpened = dateOpened;
    }

    //------<Overload equals for the given Object FinancialAccount>---------------
    public boolean equals(Object o){
        if(o == null)
            return false;
        if(!(o instanceof FinancialAccount))
            return false;
        FinancialAccount other = (FinancialAccount) o;
        return this.accNumber == other.accNumber;
    }


    //------<Getter for date opened for an account>---------------
    public Calendar getDateOpened() {
        return dateOpened;
    }


    //------<Setter for date opened for an account>---------------
    public void setDateOpened(Calendar dateOpened) {
        this.dateOpened = dateOpened;
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


    //------<Getter for Spending transaction list of given account>---------------
    public ArrayList<SpendingTransaction> getSpendingTransactionList() {
        return spendingTransactionList;
    }


    //------<Getter for Spending transaction list of given account>---------------
    public void setSpendingTransactionList(ArrayList<SpendingTransaction> spendingTransactionList) {
        this.spendingTransactionList = spendingTransactionList;
    }
}
