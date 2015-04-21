package com.personalcapital.financialplanning;

/**
 /////////////////////////////////////////////////////////////////////////////
 // Main.java - Executive class for testing and displaying the functionality//
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
 * Problem statement:
 * ------------------
 * Background:
 * A good practice in financial planning is to look back your spending pattern in previous year and to adjust accordingly
 * the spending in the coming year. One part of looking back is to calculate the annual spending and the monthly average
 * in the past year. Then the annual spending and monthly average can be used as a base line for the future financial planning.
 *
 * Requirement:
 * Given a list of a user’s financial accounts, and a list of spending transactions for these accounts, please implement
 * a solution to calculate the user’s total annual spending in the past year and monthly average in the past year.
 *
 * Considerations
 * 1.     Each financial account will at least have an “account open date” attribute.                            ##Done
 * 2.     Each spending transaction will have at least these attributes
 * a.     Transaction date                                                                                       ##Done
 * b.     Financial account the transaction belongs to                                                           ##Done
 * c.      Spending amount                                                                                       ##Done
 * 3.     When calculate annual and average spending, please use the rolling year,                               ##Done
 *        that is, from the same date last year to current date.
 * 4.     If a financial account was opened in the past year (not a year ago),                                   ##Done
 *        then this account would only have transactions from date it was opened.
 *        When calculate, please proportionally scale this account’s total spending amount to a full year.
 * 5.     Please design the implementation well and describe or implement test strategy also.                     #Done
 *
 * READ ME:
 *----------
 *
 * The Rolling date has been set to the 1st of January of each year(Not 1st April, for testing purpose).
 * Input:
 *      ArrayList for a users Financial Accounts
 *      ArrayList for a list of spending transactions
 *
 * Output:
 *      returns double--- scaled annual spending
 *      returns double--- scaled average spending
 */


import com.personalcapital.financialplanning.Helper.AccountClassifier;
import com.personalcapital.financialplanning.account.FinancialAccount;
import com.personalcapital.financialplanning.Helper.CalculateSpending;
import com.personalcapital.financialplanning.transaction.SpendingTransaction;
import java.util.ArrayList;

import java.util.HashMap;

public class Main {

    public static ArrayList<FinancialAccount> financialAccountList = Test.getFinancialAccountsList();
    public static ArrayList<SpendingTransaction> spendingTransactionList = Test.getSpendingTransactionList();


    public static void main(String[] args) {

        AccountClassifier ac = new AccountClassifier();
        HashMap<FinancialAccount, ArrayList<SpendingTransaction>> transMap = ac.getAccountsWithSpending(financialAccountList, spendingTransactionList);

        System.out.println("Given a list of a user’s financial accounts, and a list of spending transactions for these accounts ");

        System.out.println("Annual spending for given list of accounts for a user    " + CalculateSpending.annualSpendingforUser(transMap));

        System.out.println("Average spending for given list of accounts for a user   " + CalculateSpending.monthlyAverageforUser(transMap));
    }

}
