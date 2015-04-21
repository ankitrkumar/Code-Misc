package com.personalcapital.financialplanning;

/**
 /////////////////////////////////////////////////////////////////////////////
 // Test.java - Creating test lists for a given user                        //
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
 * -----------------
 *
 * ArrayList<FinancialAccount> financialAccountList = Test.getFinancialAccountsList();
 *
 * ArrayList<SpendingTransaction> spendingTransactionList = Test.getSpendingTransactionList();
 *
 *
 */


import com.personalcapital.financialplanning.account.FinancialAccount;
import com.personalcapital.financialplanning.transaction.SpendingTransaction;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Test {

    //------<Getter for creating a test financial Account list per user>---------------
    public static ArrayList<FinancialAccount> getFinancialAccountsList() {
        ArrayList<FinancialAccount> financialAccountList = new ArrayList<FinancialAccount>();
        try {
            addtoFinAccList(financialAccountList,1L, new GregorianCalendar(2014, 0, 4));
            addtoFinAccList(financialAccountList,2L, new GregorianCalendar(2015, 2, 4));
            addtoFinAccList(financialAccountList,3L, new GregorianCalendar(2015, 1, 1));

            //Test criteria--adding transactions before current rolling date;
            addtoFinAccList(financialAccountList,-4L, new GregorianCalendar(2014, 1, 4));

        } catch (Exception e) {
            e.printStackTrace();
        }
        return financialAccountList;
    }
    //------<Helper function to create an account>---------------
    private static void addtoFinAccList(ArrayList<FinancialAccount> al, Long acNo, Calendar date){
        if(!al.contains(new FinancialAccount(acNo , date)) && acNo > 0)
            al.add(new FinancialAccount(acNo , date));
    }

    //------<Getter for creating a test expenditure list>---------------
    public static ArrayList<SpendingTransaction> getSpendingTransactionList() {
        ArrayList<SpendingTransaction> spendingTransactionList = new ArrayList<SpendingTransaction>();
        try {
            addtoSpendList(spendingTransactionList,1L, 200.0, new GregorianCalendar(2015, 3, 12));
            addtoSpendList(spendingTransactionList,1L, 200.0, new GregorianCalendar(2015, 2, 1));
            addtoSpendList(spendingTransactionList,1L, 100.0, new GregorianCalendar(2015, 1, 10));
            addtoSpendList(spendingTransactionList,1L, 100.0, new GregorianCalendar(2015, 0, 3));
            //Test criteria-- adding a transaction before time
            addtoSpendList(spendingTransactionList,1L, 600.0, new GregorianCalendar(2015, 7, 13));


            addtoSpendList(spendingTransactionList,2L, 200.0, new GregorianCalendar(2015, 1, 1));
            addtoSpendList(spendingTransactionList,2L, 100.0, new GregorianCalendar(2015, 3, 15));
            addtoSpendList(spendingTransactionList,2L, 100.0, new GregorianCalendar(2015, 3, 16));
            addtoSpendList(spendingTransactionList,2L, 200.0, new GregorianCalendar(2015, 3, 10));
            addtoSpendList(spendingTransactionList,2L, 200.0, new GregorianCalendar(2015, 3, 6));
            addtoSpendList(spendingTransactionList,2L, 100.0, new GregorianCalendar(2015, 2, 5));

            addtoSpendList(spendingTransactionList,3L, 100.0, new GregorianCalendar(2015, 3, 13));
            addtoSpendList(spendingTransactionList,3L, 100.0, new GregorianCalendar(2015, 3, 5));
            addtoSpendList(spendingTransactionList,3L, 100.0, new GregorianCalendar(2015, 2, 3));
            addtoSpendList(spendingTransactionList,3L, 100.0, new GregorianCalendar(2015, 2, 19));
            addtoSpendList(spendingTransactionList,3L, 100.0, new GregorianCalendar(2015, 2, 14));
            addtoSpendList(spendingTransactionList,3L, 100.0, new GregorianCalendar(2015, 2, 1));
            addtoSpendList(spendingTransactionList,3L, 100.0, new GregorianCalendar(2015, 2, 12));
            addtoSpendList(spendingTransactionList,3L, 100.0, new GregorianCalendar(2015, 2, 10));


            //Test criteria--adding transactions before current rolling date;
            addtoSpendList(spendingTransactionList,3L, 1000.0, new GregorianCalendar(2013, 2, 13));
            addtoSpendList(spendingTransactionList,2L, 1000.0, new GregorianCalendar(2014, 1, 13));

            //Test criteria--adding transactions to non-existent accounts
            addtoSpendList(spendingTransactionList,4L, 1000.0, new GregorianCalendar(2015, 1, 13));

            //Test criteria-- adding negative account number or negative spending transaction
            addtoSpendList(spendingTransactionList,3L, -1000.0, new GregorianCalendar(2015, 1, 13));
            addtoSpendList(spendingTransactionList,-4L, 1000.0, new GregorianCalendar(2015, 1, 13));

            //Test criteria-- transaction with 0 value
            addtoSpendList(spendingTransactionList,2L, 0.0, new GregorianCalendar(2015, 1, 13));

        } catch (Exception e) {
            e.printStackTrace();
        }
        return spendingTransactionList;
    }
    //------<Helper function to create a transaction>---------------
    private static void addtoSpendList(ArrayList<SpendingTransaction> ar1, Long acNo, Double amt, Calendar date){
        if(acNo >= 0 && amt > 0)
            ar1.add(new SpendingTransaction(acNo, amt, date));
    }


}
