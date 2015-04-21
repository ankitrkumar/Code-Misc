package com.personalcapital.financialplanning.Helper;

/**
 /////////////////////////////////////////////////////////////////////////////
 // AccountClassifier.java - Gets the list of users accounts and a list of  //
 //					         all spending transactions and creates a mapping//
 //					         from each account to each spending transaction  //
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
 *
 * ArrayList<FinancialAccount> financialAccountList = Test.getFinancialAccountsList();
 * ArrayList<SpendingTransaction> spendingTransactionList = Test.getSpendingTransactionList();
 *
 * AccountClassifier ac = new AccountClassifier();
 * HashMap<FinancialAccount, ArrayList<SpendingTransaction>> transMap = ac.getAccountsWithSpending(financialAccountList, spendingTransactionList);
 *
 *
 *
 */

import com.personalcapital.financialplanning.account.FinancialAccount;
import com.personalcapital.financialplanning.transaction.SpendingTransaction;

import java.util.ArrayList;
import java.util.HashMap;

public class AccountClassifier {

    //------<Get the list of accounts and list of transactions and create a map with associativity>---------------
public  HashMap<FinancialAccount, ArrayList<SpendingTransaction>> getAccountsWithSpending(ArrayList<FinancialAccount> FAList, ArrayList<SpendingTransaction> STList) {

    HashMap<FinancialAccount, ArrayList<SpendingTransaction>> transactionsMap = new HashMap<FinancialAccount, ArrayList<SpendingTransaction>>();

    for (FinancialAccount f : FAList) {
        ArrayList<SpendingTransaction> spendingTransactionListLocal = new ArrayList<SpendingTransaction>();
        for (SpendingTransaction s : STList) {
            if (s.getAccNumber().equals(f.getAccNumber())) {
                spendingTransactionListLocal.add(s);
                transactionsMap.put(f, spendingTransactionListLocal);
            }
        }
        f.setSpendingTransactionList(spendingTransactionListLocal);
    }
    return transactionsMap;
}
}
